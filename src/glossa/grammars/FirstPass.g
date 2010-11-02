/*
 *  The MIT License
 *
 *  Copyright 2010 Georgios Migdos <cyberpython@gmail.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

tree grammar FirstPass;

options{
	tokenVocab = Glossa; //read token types from Expr.tokens file
	ASTLabelType=CommonTree;
}


@header{

/*
 *  The MIT License
 *
 *  Copyright 2010 Georgios Migdos <cyberpython@gmail.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */


package glossa.statictypeanalysis;

import glossa.messages.*;
import glossa.builtinfunctions.BuiltinFunctions;
import glossa.statictypeanalysis.scopetable.*;
import glossa.statictypeanalysis.scopetable.parameters.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.statictypeanalysis.scopetable.symbols.*;
import glossa.types.*;
import java.util.Iterator;
import java.awt.Point;

}

@members{
        private MessageLog msgLog;

        private ScopeTable scopeTable;
        private Scope currentScope;
        private boolean inConstantDeclaration = false;
        private boolean inVariableDeclaration = false;
        private boolean inSubprogram = false;

        public void setMessageLog(MessageLog msgLog){
            this.msgLog = msgLog;
        }

        public void setScopeTable(ScopeTable s){
            this.scopeTable = s;
        }

        public ScopeTable getScopeTable(){
            return this.scopeTable;
        }
}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program function*;

program	:	^(PROGRAM
		id1=ID	{
                                MainProgramScope mainProgramScope = new MainProgramScope();
				mainProgramScope.setProgramName($id1.text);
                                scopeTable.setMainProgramScope(mainProgramScope);
                                currentScope = scopeTable.getMainProgramScope();
			}
		declarations
		block
		(id2=ID {
				if($id1.text.toLowerCase().equals($id2.text.toLowerCase())==false){
					Messages.programNameMismatchWarning(msgLog, new Point($id2.line, $id2.pos), $id2.text);
				}
			}
		)?
                        {currentScope = null;}
		);

declarations
	:	constDecl? varDecl?;

constDecl
	:	^(CONSTANTS
		constAssign*)
        ;

constAssign
	:	 ^(EQ ID expr)  {
                                    if(inSubprogram && currentScope!=null){
                                        SubProgramScope sc = (SubProgramScope) currentScope;
                                         if((sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals($ID.text.toLowerCase())){
                                            //TODO: Error message
                                            msgLog.error(new Point($ID.line, $ID.pos), "\""+$ID.text+"\" - you cannot define a constant with the same name as the function!");
                                        }
                                        if(sc.getFormalParameters().contains(new FormalParameter($ID.line, $ID.pos, $ID.text))){
                                            //TODO: Error message
                                            msgLog.error(new Point($ID.line, $ID.pos), "Cannot declare constant \""+$ID.text+"\" - there is a parameter with the same name");
                                        }
                                    }
                                }
        ;





varDecl	:	^(VARIABLES
		varsDecl*)
        ;



varsDecl
	:	^(
                    varType
                    ( varDeclItem [$varType.result] )+
                );

varDeclItem [Type t]
	:	ID                          {
                                                if(inSubprogram && currentScope!=null){
                                                    SubProgramScope sc = (SubProgramScope) currentScope;
                                                    if( (sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals($ID.text.toLowerCase())){
                                                        //TODO: Error message
                                                        msgLog.error(new Point($ID.line, $ID.pos), "\""+$ID.text+"\" - you cannot define a variable with the same name as the function!");
                                                    }else{
                                                        FormalParameter fp = new FormalParameter($ID.line, $ID.pos, $ID.text);
                                                        List<FormalParameter> paramsList = sc.getFormalParameters();
                                                        if(paramsList.contains(fp)){
                                                            paramsList.get(paramsList.indexOf(fp)).setType(t);
                                                        }
                                                    }
                                                }
                                            }
	| 	^(ARRAY ID arrayDimension)  {
                                                if(inSubprogram && currentScope!=null){
                                                    SubProgramScope sc = (SubProgramScope) currentScope;
                                                    if( (sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals($ID.text.toLowerCase())){
                                                        //TODO: Error message
                                                        msgLog.error(new Point($ID.line, $ID.pos), "\""+$ID.text+"\" - you cannot define a variable with the same name as the function!");
                                                    }else{
                                                        FormalParameter fp = new FormalParameter($ID.line, $ID.pos, $ID.text);
                                                        List<FormalParameter> paramsList = sc.getFormalParameters();
                                                        if(paramsList.contains(fp)){
                                                            FormalParameter tmp = paramsList.get(paramsList.indexOf(fp));
                                                            tmp.setType(t);
                                                            tmp.setArrayParamFlagSet(true);
                                                        }
                                                    }
                                                }
                                            }
        ;



arrayDimension
	:	^(
                    ARRAY_DIMENSION
                    (expr)+
                 );



varType	returns [Type result]
        :	BOOLEANS {$result = Type.BOOLEAN;}
	|	STRINGS {$result = Type.STRING;}
	|	INTEGERS {$result = Type.INTEGER;}
	|	REALS {$result = Type.REAL;};

block	:	^(BLOCK stm*);




stm	:	^(PRINT (expr1=expr)* )     {
                                                if((currentScope instanceof FunctionScope) && currentScope!=null){
                                                    //TODO: proper error
                                                    msgLog.error(new Point($PRINT.line, $PRINT.pos), "You cannot use PRINT statements in functions");
                                                }
                                            }
        |       ^(READ readItem+)           {
                                                if((currentScope instanceof FunctionScope) && currentScope!=null){
                                                    //TODO: proper error
                                                    msgLog.error(new Point($READ.line, $READ.pos), "You cannot use READ statements in functions");
                                                }
                                            }
	|	^(ASSIGN ID expr)
        |       ^(ASSIGN ID arraySubscript expr)
        |       ^(IFNODE ifBlock elseIfBlock* elseBlock?)
        |       ^(SWITCH expr (caseBlock)*(caseElseBlock)?)
        |       ^(FOR ID
                  expr1=expr
                  expr2=expr
                  (expr3=expr)?
                  block)
        |       ^(FOR ID arraySubscript
                  expr1=expr
                  expr2=expr
                  (expr3=expr)?
                  block)
        |       ^(WHILE expr block)
	|	^(REPEAT block expr)
        ;

readItem:       arrId=ID arraySubscript
        |       varId=ID
        ;

ifBlock	:       ^(IF expr block)
        ;

elseBlock
	:	^(ELSE block)
        ;

elseIfBlock
	:	^(ELSE_IF expr block)
        ;


caseBlock
	:	^(CASE (caseExprListItem)+
                  block);

caseExprListItem
	:	a=expr
	|       ^(RANGE a=expr b=expr)
	|       ^(INF_RANGE LT a=expr)
        |       ^(INF_RANGE LE a=expr)
        |       ^(INF_RANGE GT a=expr)
        |       ^(INF_RANGE GE a=expr)
        ;

caseElseBlock
	:	^(CASE_ELSE block);



expr
	:	^(AND	a=expr	  b=expr)
	|	^(OR	a=expr	  b=expr)
	|	^(EQ	a=expr	  b=expr)
	|	^(NEQ	a=expr	  b=expr)
	|	^(LT	a=expr	  b=expr)
	|	^(LE	a=expr	  b=expr)
	|	^(GT	a=expr	  b=expr)
	|	^(GE	a=expr	  b=expr)
	|	^(PLUS	a=expr	  b=expr)
	|	^(MINUS	a=expr	  b=expr)
	|	^(TIMES	a=expr	  b=expr)
	|	^(DIA	a=expr	  b=expr)
	|	^(DIV	a=expr	  b=expr)
	|	^(MOD	a=expr	  b=expr)
	|	^(POW	a=expr	  b=expr)
	|	^(NEG	a=expr)
	|	^(NOT	a=expr)
	|	CONST_TRUE
	|	CONST_FALSE
	|	CONST_STR
	|	CONST_INT
	|	CONST_REAL
	|	ID
	|	^(ARRAY_ITEM ID arraySubscript)
        |       ^(FUNC_CALL ID paramsList)
        ;

paramsList
	:	^(PARAMS
                  (expr)*
                )
        ;

arraySubscript
	:	^(ARRAY_INDEX (expr)+ );



function
	:	{int index=input.index();}
                ^(FUNCTION  {
                                inSubprogram = true;
                            }
                  ID returnType formalParamsList [$ID.text, true]
                        {
                            if(BuiltinFunctions.isBuiltinFunctionName($ID.text)){
                                //TODO: Error message
                                msgLog.error(new Point($ID.line, $ID.pos), "There is already a built-in function named "+$ID.text);
                            }else{
                                if(scopeTable.getFunctionScope($ID.text)==null){
                                    if(scopeTable.getProcedureScope($ID.text)==null){
                                        FunctionScope fs = new FunctionScope(index, $ID.text, $formalParamsList.formalParams, $returnType.result);
                                        scopeTable.putFunctionScope($ID.text, fs);
                                        currentScope = fs;
                                    }else{
                                        //TODO: Error message
                                        msgLog.error(new Point($ID.line, $ID.pos), "There is already a procedure named "+$ID.text);
                                    }
                                }else{
                                    //TODO: Error message
                                    msgLog.error(new Point($ID.line, $ID.pos), "There is already a function named "+$ID.text);
                                }
                            }
                        }
                  constDecl? varDecl? block )
                    {
                        inSubprogram = false;
                        currentScope = null;
                    }
        ;

returnType returns[Type result]
	:	INTEGER     {$result=Type.INTEGER;}
	|	REAL        {$result=Type.REAL;}
	|	STRING      {$result=Type.STRING;}
	|	BOOLEAN    {$result=Type.BOOLEAN;}
        ;




formalParamsList [String subprogramName, boolean inFunctionDecl] returns [List<FormalParameter> formalParams]
	:	^(FORMAL_PARAMS
                        {
                            List<FormalParameter> result = new ArrayList<FormalParameter>();
                        }
                  ( ID  {
                            FormalParameter param = new FormalParameter($ID.line, $ID.pos, $ID.text);
                            if( inFunctionDecl &&  subprogramName.toLowerCase().equals($ID.text.toLowerCase())){
                                //TODO: Error message
                                msgLog.error(new Point($ID.line, $ID.pos), "\""+$ID.text+"\" - you cannot define a parameter with the same name as the function!");
                            }
                            if(result.contains(param)){
                                //TODO: Error message
                                msgLog.error(new Point($ID.line, $ID.pos), "There is already a parameter named "+$ID.text);
                            }else{
                                result.add(param);
                            }
                        }
                  )*
                        {
                            $formalParams = result;
                        }
                  )
        ;