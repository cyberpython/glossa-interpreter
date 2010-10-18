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

tree grammar GlossaFirstPassWalker;

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

import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.scopes.*;
import glossa.interpreter.symboltable.symbols.*;
import glossa.interpreter.symboltable.types.*;
import glossa.interpreter.messages.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
}

@members{
        private SymbolTable symbolTable;
	private Scope currentScope;
        private boolean inConstantDeclaration = false;
        private boolean inVariableDeclaration = false;

        public void setSymbolTable(SymbolTable s){
            this.symbolTable = s;
        }

        public SymbolTable getSymbolTable(){
            return this.symbolTable;
        }

        public void setCurrentScope(Scope s){
            this.currentScope = s;
        }

        public Scope getCurrentScope(){
            return this.currentScope;
        }
}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	^(PROGRAM
		id1=ID	{
                                MainProgramScope mainProgramScope = new MainProgramScope();
				mainProgramScope.setProgramName($id1.text);
                                symbolTable.setMainProgramScope(mainProgramScope);
                                currentScope = mainProgramScope;
			}
		declarations
		block 
		(id2=ID {
				if($id1.text.equals($id2.text)==false){
					ReportingAndMessagingUtils.programNameMismatchWarning(new Point($id2.line, $id2.pos), $id2.text);
				}
			}
		)?
		);
		
declarations
	:	constDecl? varDecl?;
		
constDecl
	:	^(CONSTANTS	{
                                        inConstantDeclaration=true;
					if(currentScope.isConstantsDeclared()){
						ReportingAndMessagingUtils.constantsRedeclarationError(new Point($CONSTANTS.line, $CONSTANTS.pos), currentScope.getConstantsDeclarationPoint());
					}else{
						currentScope.setConstantsDeclared(true);
						currentScope.setConstantsDeclarationPoint(new Point($CONSTANTS.line, $CONSTANTS.pos));
					}
				}
		constAssign*)
                                {
                                        inConstantDeclaration=false;
                                }
        ;

constAssign
	:	 ^(EQ ID expr)  {
                                    Constant s = new Constant($ID.text, $expr.expressionType, $ID.line, $ID.pos, $ID.getTokenStartIndex(), null);
                                    currentScope.defineSymbol(s.getName(), s);
                                }
        ;
	
	
	
	
	
varDecl	:	^(VARIABLES	{
                                        inVariableDeclaration=true;
					if(currentScope.isVariablesDeclared()){
						ReportingAndMessagingUtils.variablesRedeclarationError(new Point($VARIABLES.line, $VARIABLES.pos), currentScope.getVariablesDeclarationPoint());
					}else{
						currentScope.setVariablesDeclared(true);
						currentScope.setVariablesDeclarationPoint(new Point($VARIABLES.line, $VARIABLES.pos));
					}
				}
		varsDecl*)      {
                                        inVariableDeclaration=false;
                                }
        ;
		
		

varsDecl
	:	^(
                    varType
                    (varDeclItem     {
                                        Symbol s = $varDeclItem.variable;
                                        s.setType($varType.result);
                                        currentScope.defineSymbol(s.getName(), s);
                                    }
                    )+
                );

varDeclItem returns [Symbol variable]
	:	ID                          {
                                                $variable = new Variable($ID.text, $ID.line, $ID.pos, $ID.getTokenStartIndex(), null);
                                            }
	| 	^(ARRAY ID arrayDimension)  {
                                                $variable = new Array($ID.text, $ID.line, $ID.pos, $ID.getTokenStartIndex(), $arrayDimension.dimensions);
                                            }
        ;



arrayDimension returns [List<Integer> dimensions]
	:	^(
                    ARRAY_DIMENSION {
                                        $dimensions = new ArrayList<Integer>();
                                    }
                    (expr           {
                                        Type type = $expr.expressionType;
                                        if(type!=null){
                                            if(!type.equals(Type.INTEGER)){
                                                ReportingAndMessagingUtils.arrayDimensionDeclarationsNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                            }
                                        }else{
                                            ReportingAndMessagingUtils.arrayDimensionDeclarationsNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                        }
                                        $dimensions.add(new Integer(1));
                                    }
                     )+
                 );



varType	returns [Type result]
        :	BOOLEANS {$result = Type.BOOLEAN;}
	|	STRINGS {$result = Type.STRING;}
	|	INTEGERS {$result = Type.INTEGER;}
	|	REALS {$result = Type.REAL;};
		
block	:	^(BLOCK stm*);




stm	:	^(PRINT expr+)
	|	^(ASSIGN ID expr)           {
                                                Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                    if(s instanceof Variable){
                                                        if($expr.expressionType!=null){
                                                            if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), $expr.expressionType)<0){
                                                                ReportingAndMessagingUtils.incompatibleTypesFoundError(s.getType(), new Point($ID.line, $ID.pos), $expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) ,new Point($ASSIGN.line, $ASSIGN.pos), $ASSIGN.text);
                                                            }
                                                        }
                                                    }else{
                                                        ReportingAndMessagingUtils.leftSideOfAssignmentMustBeVarOrArrayError(new Point($ID.line, $ID.pos));
                                                    }
                                                }
                                            }
        //|       ^(ASSIGN ID arraySubscript expr) //TODO: array item assignment and check (again) number of indices
        ;




expr	returns [Type expressionType]
	:	^(AND	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($AND.line, $AND.pos), $AND.text
                                                                                                          );
                                                }
                                            }
	|	^(OR	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($OR.line, $OR.pos), $OR.text
                                                                                                          );
                                                }
                                            }
	|	^(EQ	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($EQ.line, $EQ.pos), $EQ.text
                                                                                                          );
                                                }
                                            }
	|	^(NEQ	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($NEQ.line, $NEQ.pos), $NEQ.text
                                                                                                          );
                                                }
                                            }
	|	^(LT	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($LT.line, $LT.pos), $LT.text
                                                                                                          );
                                                }
                                            }
	|	^(LE	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($LE.line, $LE.pos), $LE.text
                                                                                                          );
                                                }
                                            }
	|	^(GT	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($GT.line, $GT.pos), $GT.text
                                                                                                          );
                                                }
                                            }
	|	^(GE	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($GE.line, $GE.pos), $GE.text
                                                                                                          );
                                                }
                                            }
	|	^(PLUS	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($PLUS.line, $PLUS.pos), $PLUS.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                }
                                            }
	|	^(MINUS	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($MINUS.line, $MINUS.pos), $MINUS.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                }
                                            }
	|	^(TIMES	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($TIMES.line, $TIMES.pos), $TIMES.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                }
                                            }
	|	^(DIA	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIA.line, $DIA.pos), $DIA.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                                                                            //TODO which types are valid?
                                                }
                                            }
	|	^(DIV	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIV.line, $DIV.pos), $DIV.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                                                                            //TODO which types are valid?
                                                }
                                            }
	|	^(MOD	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($MOD.line, $MOD.pos), $MOD.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                                                                            //TODO which types are valid?
                                                }
                                            }
	|	^(POW	a=expr	  b=expr)   {
                                                if(TypeUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = TypeUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($POW.line, $POW.pos), $POW.text
                                                                                                          );//TODO change this to print incompatible types for operation x
                                                }
                                            }
	|	^(NEG	a=expr)             {
                                                if(TypeUtils.isNumericType($a.expressionType)){
                                                    $expressionType = $a.expressionType;
                                                }else{
                                                    Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                    ReportingAndMessagingUtils.incompatibleTypeFoundError( $a.expressionType, requiredTypes,
                                                                                                           new Point($a.start.getLine(), $a.start.getCharPositionInLine()));
                                                }
                                            }
	|	^(NOT	a=expr)             {
                                                if($a.expressionType.equals(Type.BOOLEAN)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Type[] requiredTypes = {Type.BOOLEAN};
                                                    ReportingAndMessagingUtils.incompatibleTypeFoundError( $a.expressionType, requiredTypes,
                                                                                                           new Point($a.start.getLine(), $a.start.getCharPositionInLine()));
                                                }
                                            }
	|	CONST_TRUE {$expressionType = Type.BOOLEAN;}
	|	CONST_FALSE {$expressionType = Type.BOOLEAN;}
	|	CONST_STR {$expressionType = Type.STRING;}
	|	CONST_INT {$expressionType = Type.INTEGER;}
	|	CONST_REAL {$expressionType = Type.REAL;}
	|	ID  {
                        Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                        if(s != null){
                            if(s instanceof Variable && (inConstantDeclaration || inVariableDeclaration) ){
                                ReportingAndMessagingUtils.variableReferencesInDeclarationsNotAllowedError(s, new Point($ID.line, $ID.pos));
                            }else{
                                $expressionType = s.getType();
                            }
                        }
                    }
	|	^(ARRAY_ITEM ID arraySubscript)    {
                                                        Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                        if(s != null){
                                                            if(s instanceof Array){
                                                                if(inConstantDeclaration || inVariableDeclaration){
                                                                    ReportingAndMessagingUtils.arrayReferencesInDeclarationsNotAllowedError(s, new Point($ID.line, $ID.pos));
                                                                }
                                                                else{
                                                                    $expressionType = s.getType();
                                                                    Array arr = (Array)s;
                                                                    int indicesCount = $arraySubscript.indices.size();
                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                        ReportingAndMessagingUtils.arrayIndicesAndDimensionsMismatchError(new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                                    }
                                                                }
                                                            }else{
                                                                ReportingAndMessagingUtils.nonArraySymbolReferencedAsSuch(s, new Point($ID.line, $ID.pos));
                                                            }
                                                        }
                                                    }
        ;
	
arraySubscript  returns [List<Integer> indices]
	:	^(ARRAY_INDEX       {
                                        $indices = new ArrayList<Integer>();
                                    }
                  (expr             {
                                        Type type = $expr.expressionType;
                                        if(type!=null){
                                            if(!type.equals(Type.INTEGER)){
                                                ReportingAndMessagingUtils.arrayIndexNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                            }
                                        }else{
                                            ReportingAndMessagingUtils.arrayIndexNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                        }
                                        $indices.add(new Integer(1));
                                    }
                  )+
                 );
