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

tree grammar ASTInterpreter;

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


package glossa.interpreter;

import glossa.statictypeanalysis.scopetable.*;
import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.symbols.*;
import java.awt.Point;
import java.math.BigInteger;
import java.util.Deque;
import java.util.ArrayList;

}


@members{
        private ScopeTable scopeTable;
        private Deque<SymbolTable> stack;

        private SymbolTable currentSymbolTable;

        public void setScopeTable(ScopeTable s){
            this.scopeTable = s;
        }

        public ScopeTable getScopeTable(){
            return this.scopeTable;
        }

        public void setStack(Deque<SymbolTable> stack){
            this.stack = stack;
        }

        public Deque<SymbolTable> getStack(){
            return this.stack;
        }

}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	^(  PROGRAM         {
                                        SymbolTable mainProgramSymbolTable = new SymbolTable(this.scopeTable.getMainProgramScope());
                                        this.stack.push(mainProgramSymbolTable);
                                        this.currentSymbolTable = mainProgramSymbolTable;
                                    }
                    id1=ID
                    declarations
                    block
                    (id2=ID)?
                )
                    
        ;

declarations
	:	constDecl? varDecl?
        ;

constDecl
	:	^(CONSTANTS constAssign* )
        ;

constAssign
	:	 ^(EQ ID expr )
        ;





varDecl	:	^(VARIABLES varsDecl* )
        ;



varsDecl
	:	^(varType varDeclItem+ )
        ;

varDeclItem
	:	ID
	| 	^(ARRAY ID arrayDimension 
                                {
                                    RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                    arr.setDimensions($arrayDimension.value);
                                }
                 )
        ;



arrayDimension  returns [List<Integer> value]
	:	^(ARRAY_DIMENSION
                                {List<Integer> result = new ArrayList<Integer>();}
                    (expr
                                {
                                    if(InterpreterUtils.isValidArrayDimension($expr.result)){
                                        result.add(new Integer(  ((BigInteger)$expr.result).intValue()   ));
                                    }else{
                                        throw new RuntimeException("Array dimensions must be of integer type and in the range (0,"+Integer.MAX_VALUE+")"); //TODO: proper runtime error message
                                    }
                                }
                    )+
                                {$value = result;}
                )
        ;



varType
        :	BOOLEANS
	|	STRINGS
	|	INTEGERS
	|	REALS
        ;

block	:	^(BLOCK stm*)
        ;




stm	:	^(  PRINT
                    (expr1=expr     {
                                        Object o = $expr1.result;
                                        if(o instanceof String){
                                            o = ((String)o).substring(1, ((String)o).length()-1);
                                        }
                                        System.out.print(o.toString());
                                    }
                    )*)             {
                                        System.out.println();
                                    }
        |       ^(READ readItem+)
	|	^(ASSIGN ID expr)   {
                                        RuntimeVariable var = (RuntimeVariable)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        var.setValue($expr.result);
                                    }
        |       ^(ASSIGN ID arraySubscript expr)
                                    {
                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        arr.set($arraySubscript.value, $expr.result);
                                    }
        |       ^(IFNODE ifBlock elseIfBlock* elseBlock?)
        |       ^(SWITCH expr caseBlock* caseElseBlock?)
        |       ^(FOR ID expr1=expr expr2=expr (expr3=expr)? block)
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
	:	^(CASE caseExprListItem+ block)
        ;

caseExprListItem
	:	a=expr
	|       ^(RANGE a=expr b=expr)
	|       ^(INF_RANGE LT a=expr)
        |       ^(INF_RANGE LE a=expr)
        |       ^(INF_RANGE GT a=expr)
        |       ^(INF_RANGE GE a=expr)
        ;

caseElseBlock
	:	^(CASE_ELSE block)
        ;



expr	returns [Object result]
	:	^(AND	a=expr	  b=expr)   {   $result = InterpreterUtils.and($a.result, $b.result);   }
	|	^(OR	a=expr	  b=expr)   {   $result = InterpreterUtils.or($a.result, $b.result);    }
	|	^(EQ	a=expr	  b=expr)   {   $result = InterpreterUtils.equals($a.result, $b.result);    }
	|	^(NEQ	a=expr	  b=expr)   {   $result = InterpreterUtils.notEquals($a.result, $b.result); }
	|	^(LT	a=expr	  b=expr)   {   $result = InterpreterUtils.lowerThan($a.result, $b.result); }
	|	^(LE	a=expr	  b=expr)   {   $result = InterpreterUtils.lowerThanOrEqual($a.result, $b.result);  }
	|	^(GT	a=expr	  b=expr)   {   $result = InterpreterUtils.greaterThan($a.result, $b.result);   }
	|	^(GE	a=expr	  b=expr)   {   $result = InterpreterUtils.greaterThanOrEqual($a.result, $b.result);    }
	|	^(PLUS	a=expr	  b=expr)   {   $result = InterpreterUtils.add($a.result, $b.result);   }
	|	^(MINUS	a=expr	  b=expr)   {   $result = InterpreterUtils.subtract($a.result, $b.result);  }
	|	^(TIMES	a=expr	  b=expr)   {   $result = InterpreterUtils.multiply($a.result, $b.result);  }
        |	^(DIA	a=expr	  b=expr)   {   $result = InterpreterUtils.divide($a.result, $b.result);    }
        |	^(DIV	a=expr	  b=expr)   {   $result = InterpreterUtils.intDivide($a.result, $b.result); }
	|	^(MOD	a=expr	  b=expr)   {   $result = InterpreterUtils.intMod($a.result, $b.result);    }
	|	^(POW	a=expr	  b=expr)   {   $result = InterpreterUtils.pow($a.result, $b.result);   }
	|	^(NEG	a=expr)             {   $result = InterpreterUtils.negate($a.result);   }
	|	^(NOT	a=expr)             {   $result = InterpreterUtils.not($a.result);  }
	|	CONST_TRUE                  {   $result = Boolean.valueOf(true);    }
	|	CONST_FALSE                 {   $result = Boolean.valueOf(false);   }
	|	CONST_STR                   {   $result = new String($CONST_STR.text);  }
	|	CONST_INT                   {   $result = new BigInteger($CONST_INT.text);  }
	|	CONST_REAL                  {   $result = new BigInteger($CONST_REAL.text); }
	|	ID                          {
                                                RuntimeSimpleSymbol s = (RuntimeSimpleSymbol)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                $result = s.getValue();
                                            }
	|	^(
                    ARRAY_ITEM
                    ID                      {
                                                RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                List<Integer> dimensions = arr.getDimensions();
                                            }
                    arraySubscript
                                            {
                                                List<Integer> indices = $arraySubscript.value;
                                                if(indices.size()!=dimensions.size()){
                                                    throw new RuntimeException("Array dimensions and item index mismatch"); //TODO: proper runtime error message
                                                }else{
                                                    for(int i=0; i<dimensions.size(); i++){
                                                        if(indices.get(i).compareTo(dimensions.get(i))>=0){
                                                            throw new RuntimeException("Array index out of bounds"); //TODO: proper runtime error message
                                                        }
                                                    }
                                                }

                                                $result = arr.get(indices);
                                            }
                )
        ;

arraySubscript returns [List<Integer> value]
	:	^(ARRAY_INDEX
                                {List<Integer> result = new ArrayList<Integer>();}
                    (expr
                                {
                                    if(InterpreterUtils.isValidArrayDimension($expr.result)){
                                        result.add(new Integer(  ((BigInteger)$expr.result).intValue()   ));
                                    }else{
                                        throw new RuntimeException("Array index out of bounds"); //TODO: proper runtime error message
                                    }
                                }
                    )+
                                {
                                    $value = result;
                                }
                )
        ;

