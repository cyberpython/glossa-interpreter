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

import glossa.types.*;
import glossa.statictypeanalysis.scopetable.*;
import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.symbols.*;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.StringBuilder;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.ArrayList;

}


@members{
        private ScopeTable scopeTable;
        private Deque<SymbolTable> stack;

        private SymbolTable currentSymbolTable;

        private PrintStream out;
        private PrintStream err;
        private InputStream in;
        private BufferedReader reader;

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

        public void setOutputStream(PrintStream out){
            this.out = out;
        }

        public PrintStream getOutputStream(){
            return this.out;
        }

        public void setErrorStream(PrintStream err){
            this.err = err;
        }

        public PrintStream getErrorStream(){
            return this.err;
        }

        public void setInputStream(InputStream in){
            this.in = in;
            this.reader = new BufferedReader(new InputStreamReader(in));
        }

        public InputStream getInputStream(){
            return this.in;
        }

}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program function*;

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
	:	 ^(EQ ID expr ) {
                                        RuntimeConstant constant = (RuntimeConstant)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        constant.setValue($expr.result);
                                 }
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




stm	:	^(  PRINT           {
                                        StringBuilder sb = new StringBuilder();
                                    }
                    (expr1=expr     {
                                        Object o = $expr1.result;
                                        //InterpreterUtils.print(o, this.out);
                                        sb.append(InterpreterUtils.toPrintableString(o));
                                    }
                    )*)             {
                                        String outputString = sb.toString();
                                        if(outputString.endsWith(" ")){
                                            this.out.print(outputString);
                                        }else{
                                            this.out.println(outputString);
                                        }
                                    }
        |       ^(READ readItem+)
	|	^(ASSIGN ID expr)   {
                                        RuntimeVariable var = (RuntimeVariable)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        var.setValue($expr.result);
                                    }
        |       ^(ASSIGN ID         {
                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                    }
                  arraySubscript [arr]
                  expr
                 )                  {
                                        arr.set($arraySubscript.value, $expr.result);
                                    }
        |       ^(IFNODE 
                  ifBlock           {
                                        boolean proceed = $ifBlock.proceedToNextCondition;
                                    }
                  (elseIfBlock [proceed]
                                    {
                                        proceed = $elseIfBlock.proceedToNextCondition;
                                    }
                  )*
                  (elseBlock [proceed])?
                )
        |       ^(SWITCH 
                  expr              {
                                        boolean proceed = true;
                                    }
                  (caseBlock [$expr.result, proceed]
                                    {
                                        proceed = $caseBlock.checkNextCaseBlock;
                                    }
                  )*
                  (caseElseBlock [proceed])?
                 )
        |       ^(FOR ID fromValue=expr toValue=expr (stepValue=expr)? {int blkIndex = input.index();} blk=.)
                                    {
                                        int resumeAt = input.index();

                                        RuntimeVariable counter = (RuntimeVariable)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        Object step = null;
                                        Type counterType = counter.getType();
                                        if(counterType.equals(Type.INTEGER)){
                                            counter.setValue($fromValue.result);
                                            if(stepValue!=null){
                                                step = (BigInteger)$stepValue.result;
                                            }else{
                                                step = new BigInteger("1");
                                            }

                                        }else if(counterType.equals(Type.REAL)){
                                            if($fromValue.result instanceof BigInteger){
                                                counter.setValue(new BigDecimal((BigInteger)$fromValue.result, InterpreterUtils.getMathContext()));
                                            }else{
                                                counter.setValue($fromValue.result);
                                            }
                                            if(stepValue!=null){
                                                if($stepValue.result instanceof BigInteger){
                                                    step = new BigDecimal((BigInteger)$stepValue.result, InterpreterUtils.getMathContext());
                                                }else{
                                                    step = (BigDecimal)$stepValue.result;
                                                }
                                            }else{
                                                step = new BigDecimal("1", InterpreterUtils.getMathContext());
                                            }
                                        }

                                        if(InterpreterUtils.greaterThanOrEqual(step, BigInteger.ZERO)){ //step is positive
                                            while(InterpreterUtils.lowerThanOrEqual(counter.getValue(), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                counter.setValue(InterpreterUtils.add(counter.getValue(), step));
                                            }
                                        }else{                                                //step is negative
                                            while(InterpreterUtils.greaterThanOrEqual(counter.getValue(), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                counter.setValue(InterpreterUtils.add(counter.getValue(), step));
                                            }
                                        }

                                        input.seek(resumeAt);
                                    }
        |       ^(FOR ID            {
                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                    }
                  arraySubscript [arr]
                  fromValue=expr
                  toValue=expr
                  (stepValue=expr)?
                  {int blkIndex = input.index();} blk=.
                 )                  {
                                        int resumeAt = input.index();
                                        Object step = null;
                                        Type counterType = arr.getType();
                                        if(counterType.equals(Type.INTEGER)){
                                            arr.set($arraySubscript.value, $fromValue.result);
                                            if(stepValue!=null){
                                                step = (BigInteger)$stepValue.result;
                                            }else{
                                                step = new BigInteger("1");
                                            }

                                        }else if(counterType.equals(Type.REAL)){
                                            if($fromValue.result instanceof BigInteger){
                                                arr.set($arraySubscript.value, new BigDecimal((BigInteger)$fromValue.result, InterpreterUtils.getMathContext()));
                                            }else{
                                                arr.set($arraySubscript.value, $fromValue.result);
                                            }
                                            if(stepValue!=null){
                                                if($stepValue.result instanceof BigInteger){
                                                    step = new BigDecimal((BigInteger)$stepValue.result, InterpreterUtils.getMathContext());
                                                }else{
                                                    step = (BigDecimal)$stepValue.result;
                                                }
                                            }else{
                                                step = new BigDecimal("1", InterpreterUtils.getMathContext());
                                            }
                                        }

                                        if(InterpreterUtils.greaterThanOrEqual(step, BigInteger.ZERO)){ //step is positive
                                            while(InterpreterUtils.lowerThanOrEqual(arr.get($arraySubscript.value), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                arr.set($arraySubscript.value, InterpreterUtils.add(arr.get($arraySubscript.value), step));
                                            }
                                        }else{                                                //step is negative
                                            while(InterpreterUtils.greaterThanOrEqual(arr.get($arraySubscript.value), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                arr.set($arraySubscript.value, InterpreterUtils.add(arr.get($arraySubscript.value), step));
                                            }
                                        }

                                        input.seek(resumeAt);
                                    }
        |       ^(WHILE {int conditionIndex = input.index()+1;} condition=. {int blkIndex = input.index();}  blk=.)
                                    {
                                            int resumeAt = input.index();
                                            input.seek(conditionIndex);
                                            Boolean exprResult = (Boolean)expr();

                                            while(  exprResult.equals(Boolean.TRUE)  ){
                                                input.seek(blkIndex);
                                                block();
                                                input.seek(conditionIndex);
                                                exprResult = (Boolean)expr();
                                            }

                                            input.seek(resumeAt);
                                    }
	|	^(REPEAT {int blkIndex = input.index()+1;} blk=. {int conditionIndex = input.index();} condition=.)
                                    {
                                            int resumeAt = input.index();
                                            Boolean exprResult = Boolean.FALSE;

                                            while(  exprResult.equals(Boolean.FALSE)  ){
                                                input.seek(blkIndex);
                                                block();
                                                input.seek(conditionIndex);
                                                exprResult = (Boolean)expr();
                                            }

                                            input.seek(resumeAt);
                                    }
        ;

readItem
        :       arrId=ID            {
                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                    }
                arraySubscript [arr]
                                    {
                                        String line = "";
                                        try{
                                            line = reader.readLine();
                                        }catch(Exception e){
                                        }
                                        arr.set($arraySubscript.value, InterpreterUtils.toValue(line, arr.getType()));
                                    }
        |       varId=ID            {
                                        String line = "";
                                        try{
                                            line = reader.readLine();
                                        }catch(Exception e){
                                        }
                                        RuntimeVariable var = (RuntimeVariable)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                        var.setValue(InterpreterUtils.toValue(line, var.getType()));
                                    }
        ;

ifBlock returns [boolean proceedToNextCondition]
        :       ^(IF expr {int index = input.index();} cmd=.)
                                    {
                                        if(  ((Boolean) $expr.result).equals(Boolean.TRUE)  ){
                                            int resumeAt = input.index();
                                            $proceedToNextCondition = false;
                                            input.seek(index);
                                            block();
                                            input.seek(resumeAt);
                                        }else{
                                            $proceedToNextCondition = true;
                                        }
                                    }
        ;

elseBlock [boolean exec]
	:	^(ELSE  {int elseIndex = input.index()+1;} cmd=.)
                                    {
                                        if($exec){
                                            int resumeAt = input.index();
                                            input.seek(elseIndex);
                                            block();
                                            input.seek(resumeAt);
                                        }
                                    }
        ;

elseIfBlock [boolean exec] returns [boolean proceedToNextCondition]
	:	^(ELSE_IF {int conditionIndex = input.index()+1;} e=. {int blkIndex = input.index();}  cmd=.)
                                    {
                                        $proceedToNextCondition = $exec;
                                        if($exec){
                                            int resumeAt = input.index();
                                            input.seek(conditionIndex);
                                            Boolean exprResult = (Boolean)expr();

                                            if(  (exprResult).equals(Boolean.TRUE)  ){
                                                $proceedToNextCondition = false;
                                                input.seek(blkIndex);
                                                block();
                                            }

                                            input.seek(resumeAt);
                                        }
                                    }
        ;


caseBlock [Object target, boolean proceed] returns [boolean checkNextCaseBlock]
	:	^(CASE {boolean foundMatch = false;} (caseExprListItem [$target] {foundMatch = foundMatch || $caseExprListItem.success;} )+  {int blkIndex = input.index();} blk=.)
                                    {
                                        $checkNextCaseBlock = $proceed;
                                        if($proceed){
                                            int resumeAt = input.index();

                                            if(  foundMatch  ){
                                                $checkNextCaseBlock = false;
                                                input.seek(blkIndex);
                                                block();
                                            }

                                            input.seek(resumeAt);
                                        }
                                    }
        ;

caseExprListItem [Object target] returns [boolean success]
	:	a=expr              {
                                        if(InterpreterUtils.equals($target, $a.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
	|       ^(RANGE a=expr b=expr)
                                    {
                                        if(InterpreterUtils.greaterThanOrEqual($target, $a.result)  &&  InterpreterUtils.lowerThanOrEqual($target, $b.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
	|       ^(INF_RANGE LT a=expr)
                                    {
                                        if(InterpreterUtils.lowerThan($target, $a.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
        |       ^(INF_RANGE LE a=expr) 
                                    {
                                        if(InterpreterUtils.lowerThanOrEqual($target, $a.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
        |       ^(INF_RANGE GT a=expr)  
                                    {
                                        if(InterpreterUtils.greaterThan($target, $a.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
        |       ^(INF_RANGE GE a=expr)  
                                    {
                                        if(InterpreterUtils.greaterThanOrEqual($target, $a.result)){
                                            $success = true;
                                        }else{
                                            $success = false;
                                        }
                                    }
        ;

caseElseBlock [boolean proceed]
	:	^(CASE_ELSE {int blkIndex = input.index()+1;} blk=.)
                                    {
                                        if($proceed){
                                            int resumeAt = input.index();
                                            input.seek(blkIndex);
                                            block();
                                            input.seek(resumeAt);
                                        }
                                    }
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
	|	CONST_REAL                  {   $result = new BigDecimal($CONST_REAL.text, InterpreterUtils.getMathContext()); }
	|	ID                          {
                                                RuntimeSimpleSymbol s = (RuntimeSimpleSymbol)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                $result = s.getValue();
                                            }
	|	^(
                    ARRAY_ITEM
                    ID                      {
                                                RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                            }
                    arraySubscript [arr]
                                            {
                                                $result = arr.get($arraySubscript.value);
                                            }
                )
        |       ^(FUNC_CALL ID paramsList)          {
                                                            $result = InterpreterUtils.execBuiltinFunction($ID.text, $paramsList.parameters.get(0));
                                                    }
        ;

paramsList returns [List<Object> parameters]
	:	^(PARAMS    {List<Object> result = new ArrayList<Object>();}
                  (expr     {result.add($expr.result);}
                  )*
                )           {$parameters = result;}
        ;

arraySubscript [RuntimeArray arr] returns [List<Integer> value]
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
                                    List<Integer> dimensions = arr.getDimensions();
                                    if(result.size()!=dimensions.size()){
                                        throw new RuntimeException("Array dimensions and item index mismatch"); //TODO: proper runtime error message
                                    }else{
                                        for(int i=0; i<dimensions.size(); i++){
                                            if(result.get(i).compareTo(dimensions.get(i))>0){
                                                throw new RuntimeException("Array index out of bounds"); //TODO: proper runtime error message
                                            }
                                        }
                                    }
                                    
                                    $value = result;
                                }
                )
        ;

function
	:	^(FUNCTION ID returnType formalParamsList constDecl? varDecl? block )
        ;

returnType
	:	INTEGER
	|	REAL
	|	STRING
	|	BOOLEAN
        ;




formalParamsList returns [List<String> formalParamsNames]
	:	^(FORMAL_PARAMS  (ID)*  )
        ;