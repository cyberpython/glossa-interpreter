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
import glossa.builtinfunctions.BuiltinFunctions;
import glossa.statictypeanalysis.scopetable.*;
import glossa.statictypeanalysis.scopetable.parameters.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.statictypeanalysis.scopetable.symbols.*;
import glossa.types.*;
import java.util.HashMap;
import java.util.Iterator;
import glossa.utils.Point;

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

unit	:	program (function|procedure)* ;

program	:	^(PROGRAM
		id1=ID      {
                                currentScope = scopeTable.getMainProgramScope();
                            }
		declarations
		block END_PROGRAM
		(id2=ID)?
		)           {
                                    currentScope = null;
                            }
        ;
		
declarations
	:	constDecl? varDecl?;
		
constDecl
	:	^(CONSTANTS	{
                                        inConstantDeclaration=true;
					if(currentScope.isConstantsDeclared()){
						Messages.constantsRedeclarationError(msgLog, new Point($CONSTANTS.line, $CONSTANTS.pos), currentScope.getConstantsDeclarationPoint());
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
                                    currentScope.defineSymbol(msgLog, s.getName(), s);
                                    
                                }
        ;
	
	
	
	
	
varDecl	:	^(VARIABLES	{
                                        inVariableDeclaration=true;
					if(currentScope.isVariablesDeclared()){
						Messages.variablesRedeclarationError(msgLog, new Point($VARIABLES.line, $VARIABLES.pos), currentScope.getVariablesDeclarationPoint());
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
                                                            currentScope.defineSymbol(msgLog, s.getName(), s);
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
                                            Messages.arrayDimensionDeclarationsNotIntegerError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
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
	|	^(ASSIGN ID expr)           {   
                                                boolean varAssignment = true;
                                                if(currentScope instanceof FunctionScope){
                                                    FunctionScope fs = (FunctionScope) currentScope;
                                                    if(fs.getSubprogramName().toLowerCase().equals($ID.text.toLowerCase())){
                                                        varAssignment = false;
                                                        fs.setReturnValueSet(true);
                                                         if (StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(fs.getReturnType(), $expr.expressionType) < 0) {
                                                            Messages.incompatibleTypesFoundError(msgLog, fs.getReturnType(), new Point( $ID.line, $ID.pos), $expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()), new Point($ASSIGN.line, $ASSIGN.pos), $ASSIGN.text);
                                                        }
                                                    }
                                                }
                                                if(varAssignment){
                                                    StaticTypeAnalyzerUtils.checkVariableAssignment(msgLog, this.currentScope, $ID.text, $ID.line, $ID.pos,
                                                                                    $expr.expressionType, $expr.resultForm, $expr.start.getText(), $expr.start.getLine(), $expr.start.getCharPositionInLine(),
                                                                                    $ASSIGN.text, $ASSIGN.line, $ASSIGN.pos);
                                                }
                                            }
        |       ^(ASSIGN ID arraySubscript expr)
                                            {
                                                StaticTypeAnalyzerUtils.checkArrayAssignment(msgLog, this.currentScope, $ID.text, $ID.line, $ID.pos,
                                                                          $expr.expressionType, $expr.resultForm, $expr.start.getText(), $expr.start.getLine(), $expr.start.getCharPositionInLine(),
                                                                          $ASSIGN.text, $ASSIGN.line, $ASSIGN.pos,
                                                                          $arraySubscript.indicesCount, $arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine());
                                            }
        |       ^(IFNODE ifBlock elseIfBlock* elseBlock? END_IF)
        |       ^(SWITCH {int numberOfCases = 0;} expr (caseBlock [$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] {numberOfCases++;}  )*
                  (caseElseBlock{numberOfCases++;})? END_SWITCH)
                                            {
                                                if(numberOfCases==0){
                                                    Messages.caseStmMustHaveAtLeastOneCaseError(msgLog, new Point($SWITCH.line, $SWITCH.pos));
                                                }
                                            }
        |       ^(FOR ID                    {
                                                Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                                                if((s != null)&&(s instanceof Variable)){
                                                    s.setInitialized(true);
                                                }
                                            }
                  expr1=expr
                  expr2=expr
                  (expr3=expr)?
                  block END_LOOP)
                                            {
                                                if(s != null){
                                                     if(s instanceof Variable){
                                                        if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                            if(StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType) && StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType) ){
                                                                if(s.getType().equals(Type.INTEGER)){
                                                                    if(!$expr1.expressionType.equals(Type.INTEGER)){
                                                                        Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                    }
                                                                    if(expr3!=null){
                                                                        if(  ($expr3.expressionType==null) || (!$expr3.expressionType.equals(Type.INTEGER))  ){
                                                                            Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(expr3!=null){
                                                                        if(!StaticTypeAnalyzerUtils.isNumericType($expr3.expressionType)){
                                                                            Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                        }
                                                                    }
                                                                }
                                                            }else{
                                                                if(!StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType)){
                                                                    Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                }
                                                                if(!StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType)){
                                                                    Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr2.start.getLine(), $expr2.start.getCharPositionInLine()), $expr2.expressionType);
                                                                }
                                                            }
                                                        }else{
                                                            Messages.forCounterMustBeOfNumericTypeError(msgLog, new Point($ID.line, $ID.pos), s.getType());
                                                        }
                                                    }else{
                                                        Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point($ID.line, $ID.pos), s);
                                                    }
                                                }
                                            }
        |       ^(FOR ID arraySubscript     {
                                                Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                                                if((s != null)&&(s instanceof Array)){
                                                    s.setInitialized(true);
                                                }
                                            }
                  expr1=expr
                  expr2=expr
                  (expr3=expr)?
                  block END_LOOP)
                                            {
                                                if(s != null){
                                                     if(s instanceof Array){
                                                        s.setInitialized(true);
                                                        Array arr = (Array)s;
                                                        int indicesCount = $arraySubscript.indicesCount;
                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                            Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                        }else{
                                                            if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                                if(StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType) && StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType) ){
                                                                    if(s.getType().equals(Type.INTEGER)){
                                                                        if(!$expr1.expressionType.equals(Type.INTEGER)){
                                                                            Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                        }
                                                                        if(expr3!=null){
                                                                            if(  ($expr3.expressionType==null) || (!$expr3.expressionType.equals(Type.INTEGER))  ){
                                                                                Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                            }
                                                                        }
                                                                    }else{
                                                                        if(expr3!=null){
                                                                            if(!StaticTypeAnalyzerUtils.isNumericType($expr3.expressionType)){
                                                                                Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr3.start.getLine(), $expr3.start.getCharPositionInLine()), $expr3.expressionType);
                                                                            }
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(!StaticTypeAnalyzerUtils.isNumericType($expr1.expressionType)){
                                                                        Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr1.start.getLine(), $expr1.start.getCharPositionInLine()), $expr1.expressionType);
                                                                    }
                                                                    if(!StaticTypeAnalyzerUtils.isNumericType($expr2.expressionType)){
                                                                        Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point($expr2.start.getLine(), $expr2.start.getCharPositionInLine()), $expr2.expressionType);
                                                                    }
                                                                }
                                                            }else{
                                                                Messages.forCounterMustBeOfNumericTypeError(msgLog, new Point($ID.line, $ID.pos), s.getType());
                                                            }
                                                        }
                                                    }else{
                                                        Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point($ID.line, $ID.pos));
                                                    }
                                                }
                                            }
        |       ^(WHILE expr block END_LOOP){
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.whileExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.whileExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
	|	^(REPEAT block UNTIL expr)  {
                                                if($expr.expressionType!=null){
                                                    if(!$expr.expressionType.equals(Type.BOOLEAN)){
                                                        Messages.whileExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.whileExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
        |       ^(CALL ID paramsList)       {
                                                StaticTypeAnalyzerUtils.checkProcedureCall(msgLog, this.scopeTable, $ID.text, $ID.line, $ID.pos, $paramsList.params);
                                            }
        ;

readItem:       arrId=ID arraySubscript   {
                                                Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                    if(s instanceof Array){
                                                        Array arr = (Array)s;
                                                        Type t = arr.getType();
                                                        if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                            Messages.readItemMustBeIntRealOrStringError(msgLog, new Point($ID.line, $ID.pos), t);
                                                        }else{
                                                            int indicesCount = $arraySubscript.indicesCount;
                                                            if(arr.getNumberOfDimensions() != indicesCount){
                                                                Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                            }else{
                                                                s.setInitialized(true);
                                                            }
                                                        }
                                                    }else{
                                                        Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point($ID.line, $ID.pos));
                                                    }
                                                }
                                            }
        |       varId=ID                    {
                                                Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                                                if(s != null){
                                                    if(!(s instanceof Variable)){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point($ID.line, $ID.pos), s);
                                                    }else{
                                                        Type t = s.getType();
                                                        if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                            Messages.readItemMustBeIntRealOrStringError(msgLog, new Point($ID.line, $ID.pos), t);
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
                                                        Messages.ifExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
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
                                                        Messages.ifExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , $expr.expressionType);
                                                    }
                                                }else{
                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()) , null);
                                                }
                                            }
        ;


caseBlock [Type exprType, Point exprPoint]
	:	^(CASE (caseExprListItem{   if( !StaticTypeAnalyzerUtils.checkTypesForCaseStatement(exprType, $caseExprListItem.expressionType) ){
                                                        Messages.incompatibleTypesForCaseStmFoundError(msgLog, exprType, exprPoint, $caseExprListItem.expressionType, new Point($caseExprListItem.start.getLine(), $caseExprListItem.start.getCharPositionInLine()), new Point($caseBlock.start.getLine(), $caseBlock.start.getCharPositionInLine()));
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
                                                Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
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
                                                Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
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
                                                Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
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
                                               Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
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
                                                Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point($a.start.getLine(), $a.start.getCharPositionInLine()), $a.expressionType);
                                            }
                                        }
        ;

caseElseBlock
	:	^(CASE_ELSE CASE block);



expr	returns [Type expressionType, ExpressionResultForm resultForm]
	:	^(AND	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($AND.line, $AND.pos), $AND.text
                                                                                                          );
                                                }
                                            }
	|	^(OR	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($OR.line, $OR.pos), $OR.text
                                                                                                          );
                                                }
                                            }
	|	^(EQ	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($EQ.line, $EQ.pos), $EQ.text
                                                                                                          );
                                                }
                                            }
	|	^(NEQ	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($NEQ.line, $NEQ.pos), $NEQ.text
                                                                                                          );
                                                }
                                            }
	|	^(LT	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($LT.line, $LT.pos), $LT.text
                                                                                                                  );
                                                }
                                            }
	|	^(LE	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($LE.line, $LE.pos), $LE.text
                                                                                                                  );
                                                }
                                            }
	|	^(GT	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($GT.line, $GT.pos), $GT.text
                                                                                                                  );
                                                }
                                            }
	|	^(GE	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.BOOLEAN;
                                                }else{
                                                   Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                    $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                    new Point($GE.line, $GE.pos), $GE.text
                                                                                                                  );
                                                }
                                            }
	|	^(PLUS	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($PLUS.line, $PLUS.pos), $PLUS.text
                                                                                                          );
                                                }
                                            }
	|	^(MINUS	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($MINUS.line, $MINUS.pos), $MINUS.text
                                                                                                          );
                                                }
                                            }
	|	^(TIMES	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = StaticTypeAnalyzerUtils.getWiderType($a.expressionType, $b.expressionType);
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($TIMES.line, $TIMES.pos), $TIMES.text
                                                                                                          );
                                                }
                                            }
	|	^(DIA	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.REAL;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIA.line, $DIA.pos), $DIA.text
                                                                                                          );
                                                }
                                            }
	|	^(DIV	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.INTEGER;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($DIV.line, $DIV.pos), $DIV.text
                                                                                                          );
                                                }
                                            }
	|	^(MOD	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    $expressionType = Type.INTEGER;
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                                $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                                new Point($MOD.line, $MOD.pos), $MOD.text
                                                                                                              );
                                                }
                                            }
	|	^(POW	a=expr	  b=expr)   {
                                                StaticTypeAnalyzerUtils.checkResultsForms(msgLog, $a.resultForm, $b.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(),
                                                            $b.start.getLine(), $b.start.getCharPositionInLine(),
                                                            $a.start.getText(), $b.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression($a.expressionType, $b.expressionType)){
                                                    if(($b.expressionType!=null)&&($b.expressionType.equals(Type.INTEGER))){
                                                        $expressionType = Type.REAL;
                                                    }else{
                                                        Messages.exponentNotIntegerError(msgLog, new Point($b.start.getLine(), $b.start.getCharPositionInLine()), $b.expressionType);
                                                    }
                                                }else{
                                                    Messages.incompatibleTypesFoundError(msgLog, $a.expressionType, new Point($a.start.getLine(), $a.start.getCharPositionInLine()),
                                                                                                            $b.expressionType, new Point($b.start.getLine(), $b.start.getCharPositionInLine()),
                                                                                                            new Point($POW.line, $POW.pos), $POW.text
                                                                                                          );
                                                }
                                            }
	|	^(NEG	a=expr)             {
                                                StaticTypeAnalyzerUtils.checkResultForm(msgLog, $a.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(), $a.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.isNumericType($a.expressionType)){
                                                    $expressionType = $a.expressionType;
                                                }else{
                                                    Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                    Messages.incompatibleTypeFoundError(msgLog, $a.expressionType, requiredTypes,
                                                                                                           new Point($a.start.getLine(), $a.start.getCharPositionInLine()));
                                                }
                                            }
	|	^(NOT	a=expr)             {
                                                StaticTypeAnalyzerUtils.checkResultForm(msgLog, $a.resultForm,
                                                            $a.start.getLine(), $a.start.getCharPositionInLine(), $a.start.getText());
                                                $resultForm=ExpressionResultForm.VALUE;
                                                if(StaticTypeAnalyzerUtils.checkTypeForNotExpression($a.expressionType)){
                                                        $expressionType = Type.BOOLEAN;
                                                }else{
                                                    Type[] requiredTypes = {Type.BOOLEAN};
                                                    Messages.incompatibleTypeFoundError(msgLog, $a.expressionType, requiredTypes,
                                                                                                           new Point($a.start.getLine(), $a.start.getCharPositionInLine()));
                                                }
                                            }
	|	CONST_TRUE {$expressionType = Type.BOOLEAN; $resultForm=ExpressionResultForm.VALUE;}
	|	CONST_FALSE {$expressionType = Type.BOOLEAN; $resultForm=ExpressionResultForm.VALUE;}
	|	CONST_STR {$expressionType = Type.STRING; $resultForm=ExpressionResultForm.VALUE;}
	|	CONST_INT {$expressionType = Type.INTEGER; $resultForm=ExpressionResultForm.VALUE;}
	|	CONST_REAL {$expressionType = Type.REAL; $resultForm=ExpressionResultForm.VALUE;}
	|	ID  {
                        $resultForm=ExpressionResultForm.VARIABLE;
                        Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                        if(s != null){
                            if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                Messages.variableReferencesInDeclarationsNotAllowedError(msgLog, s, new Point($ID.line, $ID.pos));
                            }else{
                                if(s instanceof Array){
                                    //Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point($ID.line, $ID.pos), s);
                                    $resultForm=ExpressionResultForm.ARRAY;
                                    $expressionType = s.getType();
                                }else{
                                    $expressionType = s.getType();
                                    if(!s.isInitialized()){
                                        Messages.varOrConstNotInitializedButReferencedError(msgLog, new Point($ID.line, $ID.pos), s);
                                    }
                                }
                            }
                        }
                    }
	|	^(ARRAY_ITEM ID arraySubscript)    {
                                                        $resultForm=ExpressionResultForm.ARRAY_ITEM;
                                                        Symbol s = currentScope.referenceSymbol(msgLog, $ID.text, new Point($ID.line, $ID.pos));
                                                        if(s != null){
                                                            if(s instanceof Array){
                                                                if(inConstantDeclaration || inVariableDeclaration){
                                                                    Messages.arrayReferencesInDeclarationsNotAllowedError(msgLog, s, new Point($ID.line, $ID.pos));
                                                                }
                                                                else{
                                                                    $expressionType = s.getType();
                                                                    Array arr = (Array)s;
                                                                    int indicesCount = $arraySubscript.indicesCount;
                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                        Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point($arraySubscript.start.getLine(), $arraySubscript.start.getCharPositionInLine()), arr, indicesCount);
                                                                    }
                                                                }
                                                            }else{
                                                                Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point($ID.line, $ID.pos));
                                                            }
                                                        }
                                                    }
        |       ^(FUNC_CALL ID paramsList)          {
                                                            $resultForm=ExpressionResultForm.FUNCTION_CALL;
                                                            if(BuiltinFunctions.isBuiltinFunctionName($ID.text)){
                                                                if($paramsList.params.size()==1){
                                                                    Type paramType = $paramsList.params.get(0).getType();
                                                                    if(StaticTypeAnalyzerUtils.isNumericType(paramType)){
                                                                        $expressionType = BuiltinFunctions.getReturnTypeForBuiltinFuntion($ID.text, paramType);
                                                                    }else{
                                                                        Messages.callToBuiltinFunctionWithWrongParamTypeError(msgLog, new Point($ID.line, $ID.pos), $ID.text, paramType);
                                                                    }
                                                                }else{
                                                                    Messages.callToBuiltinFunctionWithWrongNumOfParamsError(msgLog, new Point($ID.line, $ID.pos), $ID.text, $paramsList.params.size());
                                                                }
                                                            }else{
                                                                $expressionType = StaticTypeAnalyzerUtils.checkFunctionCall(msgLog, this.scopeTable, $ID.text, $ID.line, $ID.pos, $paramsList.params);
                                                            }
                                                    }
        ;

paramsList returns [List<ActualParameter> params]
	:	^(PARAMS    {List<ActualParameter> result = new ArrayList<ActualParameter>();}
                  (expr     {result.add(new ActualParameter($expr.start.getLine(), $expr.start.getCharPositionInLine(), $expr.expressionType, $expr.resultForm));}
                  )*
                )           {$params = result;}
        ;

arraySubscript  returns [int indicesCount]
	:	^(ARRAY_INDEX       {
                                        int count = 0;
                                    }
                  (expr             {
                                        Type type = $expr.expressionType;
                                        if(type!=null){
                                            if(!type.equals(Type.INTEGER)){
                                                Messages.arrayIndexNotIntegerError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                            }
                                        }else{
                                            Messages.arrayIndexNotIntegerError(msgLog, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine()));
                                        }
                                        count++;
                                    }
                  )+
                                    {   $indicesCount = count;    }
                 );

procedure
	:	^(PROCEDURE         {
                                        inSubprogram = true;
                                    }
                  ID formalParamsList
                                    {
                                        ProcedureScope ps = scopeTable.getProcedureScope($ID.text);
                                        currentScope = ps;
                                    }
                  constDecl?
                  varDecl?          {
                                        List<FormalParameter> formalParams = ps.getFormalParameters();
                                        HashMap<String, Symbol> symbols = ps.getSymbols();
                                        for(Iterator<FormalParameter> it = formalParams.iterator(); it.hasNext();){
                                            FormalParameter param = it.next();
                                            Symbol symbol = symbols.get(param.getName().toLowerCase());
                                            if (symbol == null) {
                                                Messages.parameterNotDeclaredError(msgLog, new Point(param.getLine(), param.getPos()), param.getName());
                                            }else{
                                                if((symbol instanceof Variable)||(symbol instanceof Array)){
                                                    symbol.setInitialized(true);
                                                    param.setSymbol(symbol);
                                                }else{
                                                    msgLog.error(new Point(param.getLine(), param.getPos()), Messages.STR_ERROR_PARAMETER_MUST_BE_DECLARED_AS_VAR_OR_ARRAY);
                                                }
                                            }
                                        }
                                    }
                  block END_PROCEDURE)
                                    {
                                        inSubprogram = false;
                                        currentScope = null;
                                    }
        ;

function
	:	^(FUNCTION          {
                                        inSubprogram = true;
                                    }
                  ID returnType formalParamsList
                                    {
                                        FunctionScope fs = scopeTable.getFunctionScope($ID.text);
                                        currentScope = fs;
                                    }
                  constDecl?
                  varDecl?          {
                                        List<FormalParameter> formalParams = fs.getFormalParameters();
                                        HashMap<String, Symbol> symbols = fs.getSymbols();
                                        for(Iterator<FormalParameter> it = formalParams.iterator(); it.hasNext();){
                                            FormalParameter param = it.next();
                                            Symbol symbol = symbols.get(param.getName().toLowerCase());
                                            if (symbol == null) {
                                                Messages.parameterNotDeclaredError(msgLog, new Point(param.getLine(), param.getPos()), param.getName());
                                            }else{
                                                if((symbol instanceof Variable)||(symbol instanceof Array)){
                                                    symbol.setInitialized(true);
                                                    param.setSymbol(symbol);
                                                }else{
                                                    msgLog.error(new Point(param.getLine(), param.getPos()), Messages.STR_ERROR_PARAMETER_MUST_BE_DECLARED_AS_VAR_OR_ARRAY);
                                                }
                                            }
                                        }
                                    }
                  block END_FUNCTION
                )                   {
                                        if(!fs.isReturnValueSet()){
                                            Messages.functionReturnValueNotSetError(msgLog, new Point($ID.line, $ID.pos), fs.getSubprogramName(), fs.getFormalParameters());
                                        }
                                        inSubprogram = false;
                                        currentScope = null;
                                    }
        ;

returnType
	:	INTEGER
	|	REAL
	|	STRING
	|	BOOLEAN
        ;




formalParamsList
	:	^(FORMAL_PARAMS (ID)* )
        ;