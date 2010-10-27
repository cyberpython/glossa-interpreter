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

tree grammar StaticTypeAnalyzer;

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
import glossa.statictypeanalysis.scopetable.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.statictypeanalysis.scopetable.symbols.*;
import glossa.types.*;
import java.util.Iterator;
import java.awt.Point;

}

@members{
        private ScopeTable scopeTable;
	private Scope currentScope;
        private boolean inConstantDeclaration = false;
        private boolean inVariableDeclaration = false;

        public void setScopeTable(ScopeTable s){
            this.scopeTable = s;
        }

        public ScopeTable getScopeTable(){
            return this.scopeTable;
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
                                scopeTable.setMainProgramScope(mainProgramScope);
                                currentScope = mainProgramScope;
			}
		declarations
		block 
		(id2=ID {
				if($id1.text.equals($id2.text)==false){
					Messages.programNameMismatchWarning(new Point($id2.line, $id2.pos), $id2.text);
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
						Messages.constantsRedeclarationError(new Point($CONSTANTS.line, $CONSTANTS.pos), currentScope.getConstantsDeclarationPoint());
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
                                    Constant s = new Constant($ID.text, $expr.expressionType, $ID.line, $ID.pos, $ID.getTokenStartIndex());
                                    s.setInitialized(true);
                                    currentScope.defineSymbol(s.getName(), s);
                                }
        ;
	
	
	
	
	
varDecl	:	^(VARIABLES	{
                                        inVariableDeclaration=true;
					if(currentScope.isVariablesDeclared()){
						Messages.variablesRedeclarationError(new Point($VARIABLES.line, $VARIABLES.pos), currentScope.getVariablesDeclarationPoint());
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
                    (varDeclItem [$varType.result]    {
                                                            Symbol s = $varDeclItem.variable;
                                                            currentScope.defineSymbol(s.getName(), s);
                                                        }
                    )+
                );

varDeclItem [Type t] returns [Symbol variable]
	:	ID                          {
                                                $variable = new Variable($ID.text, t, $ID.line, $ID.pos, $ID.getTokenStartIndex());
                                            }
	| 	^(ARRAY ID arrayDimension)  {
                                                $variable = new Array($ID.text, t, $ID.line, $ID.pos, $ID.getTokenStartIndex(), $arrayDimension.indicesCount);
                                            }
        ;



arrayDimension returns [int indicesCount]
	:	^(
                    ARRAY_DIMENSION {
                                        int count = 0;
                                    }
                    (expr           {
                                        Type type = $expr.expressionType;
                                        count++;
                                        if(   (type==null)     ||   ( !type.equals(Type.INTEGER) )   ){
                                            Messages.arrayDimensionDeclarationsNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                        }
                                    }
                     )+
                                    {   $indicesCount = count;  }
                 );



varType	returns [Type result]
        :	BOOLEANS {$result = Type.BOOLEAN;}
	|	STRINGS {$result = Type.STRING;}
	|	INTEGERS {$result = Type.INTEGER;}
	|	REALS {$result = Type.REAL;};
		
block	:	^(BLOCK stm*);




stm	:	^(PRINT (expr1=expr)* )
        |       ^(READ readItem+)
	|	^(ASSIGN ID expr)           {   StaticTypeAnalyzerUtils.checkVariableAssignment(this.currentScope, $ID.text, $ID.line, $ID.pos,
                                                                                    $expr.expressionType, $expr.start.getLine(), $expr.start.getCharPositionInLine(),
                                                                                    $ASSIGN.text, $ASSIGN.line, $ASSIGN.pos);
                                            }
        |       ^(ASSIGN ID arraySubscript expr)
                                            {
                                                StaticTypeAnalyzerUtils.checkArrayAssignment(this.currentScope, $ID.text, $ID.line, $ID.pos,
                                                                          $expr.expressionType, $expr.start.getLine(), $expr.start.getCharPositionInLine(),
                                                                          $ASSIGN.text, $ASSIGN.line, $ASSIGN.pos,
                                                                          $arraySubscript.indicesCount, $arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine());
                                            }
        |       ^(IFNODE ifBlock elseIfBlock* elseBlock?)
        |       ^(SWITCH {int numberOfCases = 0;} expr (caseBlock [$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] {numberOfCases++;}  )*
                  (caseElseBlock{numberOfCases++;})?)
                                            {
                                                if(numberOfCases==0){
                                                    Messages.caseStmMustHaveAtLeastOneCase(new Point($SWITCH.line, $SWITCH.pos));
                                                }
                                            }
        |       ^(FOR ID expr1=expr expr2=expr (expr3=expr)? block)
                                            {
                                                Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                     if(s instanceof Variable){
                                                        if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                            if(StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType) && StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType) ){
                                                                if(s.getType().equals(Type.INTEGER)){
                                                                    if(!$expr1.expressionType.equals(Type.INTEGER)){
                                                                        Messages.forFromStepExpressionsMustBeInteger(new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                    }
                                                                    if(expr3!=null){
                                                                        if(  ($expr3.expressionType==null) || (!$expr3.expressionType.equals(Type.INTEGER))  ){
                                                                            Messages.forFromStepExpressionsMustBeInteger(new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(expr3!=null){
                                                                        if(!StaticTypeAnalyzerUtils.isNumericType($expr3.expressionType)){
                                                                            Messages.forFromToStepExpressionsMustBeOfNumericType(new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                        }
                                                                    }
                                                                }
                                                            }else{
                                                                if(!StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType)){
                                                                    Messages.forFromToStepExpressionsMustBeOfNumericType(new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                }
                                                                if(!StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType)){
                                                                    Messages.forFromToStepExpressionsMustBeOfNumericType(new Point($expr2.start.getLine(), $expr2.start.getCharPositionInLine()), $expr2.expressionType);
                                                                }
                                                            }
                                                        }else{
                                                            Messages.forCounterMustBeOfNumericType(new Point($ID.line, $ID.pos), s.getType());
                                                        }
                                                    }else{
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point($ID.line, $ID.pos), s);
                                                    }
                                                }
                                            }
        |       ^(WHILE expr block)         {
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.whileExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.whileExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
	|	^(REPEAT block expr)        {
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.whileExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.whileExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
        ;

readItem:       arrId=ID arraySubscript   {
                                                Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                    if(s instanceof Array){
                                                        Array arr = (Array)s;
                                                        Type t = arr.getType();
                                                        if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                            Messages.readItemMustBeIntRealOrStringError(new Point($ID.line, $ID.pos), t);
                                                        }else{
                                                            int indicesCount = $arraySubscript.indicesCount;
                                                            if(arr.getNumberOfDimensions() != indicesCount){
                                                                Messages.arrayIndicesAndDimensionsMismatchError(new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                            }else{
                                                                s.setInitialized(true);
                                                            }
                                                        }
                                                    }else{
                                                        Messages.nonArraySymbolReferencedAsSuchError(s, new Point($ID.line, $ID.pos));
                                                    }
                                                }
                                            }
        |       varId=ID                    {
                                                Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                    if(!(s instanceof Variable)){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point($ID.line, $ID.pos), s);
                                                    }else{
                                                        Type t = s.getType();
                                                        if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                            Messages.readItemMustBeIntRealOrStringError(new Point($ID.line, $ID.pos), t);
                                                        }else{
                                                            s.setInitialized(true);
                                                        }
                                                    }
                                                }
                                            }
        ;

ifBlock	:       ^(IF expr block)            {
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.ifExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.ifExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
        ;

elseBlock
	:	^(ELSE block)
        ;

elseIfBlock
	:	^(ELSE_IF expr block)       {
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.ifExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.ifExpressionMustBeBoolean(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
        ;


caseBlock [Type exprType, Point exprPoint]
	:	^(CASE (caseExprListItem{   if( !StaticTypeAnalyzerUtils.checkTypesForCaseStatement(exprType, $caseExprListItem.expressionType) ){
                                                        Messages.incompatibleTypesForCaseStmFoundError(exprType, exprPoint, $caseExprListItem.expressionType, new Point($caseExprListItem.start.getLine(), $caseExprListItem.start.getCharPositionInLine()), new Point($caseBlock.start.getLine(), $caseBlock.start.getCharPositionInLine()));
                                            }
                                        })+
                  block);

caseExprListItem returns [Type expressionType]
	:	a=expr                  {
                                            $expressionType = $a.expressionType;
                                        }
	|       ^(RANGE a=expr b=expr)  {
                                            if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                $expressionType = Type.REAL;
                                            }else{
                                                Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($RANGE.line, $RANGE.pos), $RANGE.text
                                                                                                          );
                                            }
                                        }
	|       ^(INF_RANGE LT a=expr)  {
                                            if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression($a.expressionType)){
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    $expressionType = Type.STRING;
                                                }
                                            }else{
                                                Messages.caseItemExprMustBeIntRealOrStringError(new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
                                            }
                                        }
        |       ^(INF_RANGE LE a=expr)  {
                                            if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression($a.expressionType)){
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    $expressionType = Type.STRING;
                                                }
                                            }else{
                                                Messages.caseItemExprMustBeIntRealOrStringError(new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
                                            }
                                        }
        |       ^(INF_RANGE GT a=expr)  {
                                            if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression($a.expressionType)){
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    $expressionType = Type.STRING;
                                                }
                                            }else{
                                               Messages.caseItemExprMustBeIntRealOrStringError(new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
                                            }
                                        }
        |       ^(INF_RANGE GE a=expr)  {
                                            if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression($a.expressionType)){
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    $expressionType = Type.STRING;
                                                }
                                            }else{
                                                Messages.caseItemExprMustBeIntRealOrStringError(new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
                                            }
                                        }
        ;

caseElseBlock
	:	^(CASE_ELSE block);



expr	returns [Type expressionType]
	:	^(AND	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($AND.line, $AND.pos), $AND.text
                                                                                                          );
                                                }
                                            }
	|	^(OR	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($OR.line, $OR.pos), $OR.text
                                                                                                          );
                                                }
                                            }
	|	^(EQ	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($EQ.line, $EQ.pos), $EQ.text
                                                                                                          );
                                                }
                                            }
	|	^(NEQ	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($NEQ.line, $NEQ.pos), $NEQ.text
                                                                                                          );
                                                }
                                            }
	|	^(LT	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($LT.line, $LT.pos), $LT.text
                                                                                                                  );
                                                }
                                            }
	|	^(LE	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($LE.line, $LE.pos), $LE.text
                                                                                                                  );
                                                }
                                            }
	|	^(GT	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($GT.line, $GT.pos), $GT.text
                                                                                                                  );
                                                }
                                            }
	|	^(GE	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($GE.line, $GE.pos), $GE.text
                                                                                                                  );
                                                }
                                            }
	|	^(PLUS	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($PLUS.line, $PLUS.pos), $PLUS.text
                                                                                                          );
                                                }
                                            }
	|	^(MINUS	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($MINUS.line, $MINUS.pos), $MINUS.text
                                                                                                          );
                                                }
                                            }
	|	^(TIMES	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($TIMES.line, $TIMES.pos), $TIMES.text
                                                                                                          );
                                                }
                                            }
	|	^(DIA	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIA.line, $DIA.pos), $DIA.text
                                                                                                          );
                                                }
                                            }
	|	^(DIV	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.INTEGER;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIV.line, $DIV.pos), $DIV.text
                                                                                                          );
                                                }
                                            }
	|	^(MOD	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.INTEGER;
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                new Point($MOD.line, $MOD.pos), $MOD.text
                                                                                                              );
                                                }
                                            }
	|	^(POW	a=expr	  b=expr)   {
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    if(($b.expressionType!=null)&&($b.expressionType.equals(Type.INTEGER))){
                                                        $expressionType = Type.REAL;
                                                    }else{
                                                        Messages.exponentNotIntegerError(new Point($b.start.getLine(), $b.start.getCharPositionInLine()), $b.expressionType);
                                                    }
                                                }else{
                                                    Messages.incompatibleTypesFoundError( $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($POW.line, $POW.pos), $POW.text
                                                                                                          );
                                                }
                                            }
	|	^(NEG	a=expr)             {
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = $a.expressionType;
                                                }else{
                                                    Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                    Messages.incompatibleTypeFoundError( $a.expressionType, requiredTypes,
                                                                                                           new Point($a.start.getLine(), $a.start.getCharPositionInLine()));
                                                }
                                            }
	|	^(NOT	a=expr)             {
                                                if(StaticTypeAnalyzerUtils.checkTypeForNotExpression($a.expressionType)){
                                                        $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Type[] requiredTypes = {Type.BOOLEAN};
                                                    Messages.incompatibleTypeFoundError( $a.expressionType, requiredTypes,
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
                            if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                Messages.variableReferencesInDeclarationsNotAllowedError(s, new Point($ID.line, $ID.pos));
                            }else{
                                if(s instanceof Array){
                                    Messages.nonVariableSymbolReferencedAsSuchError(new Point($ID.line, $ID.pos), s);
                                }else{
                                    $expressionType = s.getType();
                                    if(!s.isInitialized()){
                                        Messages.varOrConstNotInitializedButReferencedError(new Point($ID.line, $ID.pos), s);
                                    }
                                }
                            }
                        }
                    }
	|	^(ARRAY_ITEM ID arraySubscript)    {
                                                        Symbol s = currentScope.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                        if(s != null){
                                                            if(s instanceof Array){
                                                                if(inConstantDeclaration || inVariableDeclaration){
                                                                    Messages.arrayReferencesInDeclarationsNotAllowedError(s, new Point($ID.line, $ID.pos));
                                                                }
                                                                else{
                                                                    $expressionType = s.getType();
                                                                    Array arr = (Array)s;
                                                                    int indicesCount = $arraySubscript.indicesCount;
                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                        Messages.arrayIndicesAndDimensionsMismatchError(new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                                    }
                                                                }
                                                            }else{
                                                                Messages.nonArraySymbolReferencedAsSuchError(s, new Point($ID.line, $ID.pos));
                                                            }
                                                        }
                                                    }
        ;
	
arraySubscript  returns [int indicesCount]
	:	^(ARRAY_INDEX       {
                                        int count = 0;
                                    }
                  (expr             {
                                        Type type = $expr.expressionType;
                                        if(type!=null){
                                            if(!type.equals(Type.INTEGER)){
                                                Messages.arrayIndexNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                            }
                                        }else{
                                            Messages.arrayIndexNotIntegerError(new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                        }
                                        count++;
                                    }
                  )+
                                    {   $indicesCount = count;    }
                 );
