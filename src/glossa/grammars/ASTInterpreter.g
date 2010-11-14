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
        superClass=RunnableTreeParser;
	tokenVocab = Glossa; //read token types from tokens file
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


package glossa.interpreter.core;

import glossa.types.*;
import glossa.messages.RuntimeMessages;
import glossa.messages.Messages;
import glossa.builtinfunctions.BuiltinFunctions;
import glossa.statictypeanalysis.scopetable.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.symbols.*;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Iterator;

}


@members{

        private static final String EXECUTION_STARTED = "__exec_started__";
        private static final String EXECUTION_PAUSED = "__exec_paused__";
        private static final String EXECUTION_STOPPED = "__exec_stopped__";
        private static final String READ_STM = "__read_stm__";
        private static final String STACK_PUSHED = "__stack_pushed__";
        private static final String STACK_POPPED = "__stack_popped__";
        private static final String RUNTIME_ERROR = "__runtime_error__";

        private ScopeTable scopeTable;
        private Deque<SymbolTable> stack;

        private SymbolTable currentSymbolTable;

        private PrintStream out;
        private PrintStream err;
        private InputStream in;
        private BufferedReader reader;

        List<ASTInterpreterListener> listeners;

        private boolean halt;
        private boolean stop;
        private boolean finished;

        public void init(ScopeTable s, PrintStream out, PrintStream err, InputStream in){
            input.reset();

            this.stack = new ArrayDeque<SymbolTable>();
            this.scopeTable = s;
            this.listeners = new ArrayList<ASTInterpreterListener>();
            this.halt=false;
            this.stop=false;
            this.finished = false;

            this.out = out;
            this.err = err;
            this.in = in;
            this.reader = new BufferedReader(new InputStreamReader(in));
        }

        public void addListener(ASTInterpreterListener listener){
            this.listeners.add(listener);
        }

        public boolean removeListener(ASTInterpreterListener listener){
            return this.listeners.remove(listener);
        }

        public void notifyListeners(String msg, Object... params){
            for (Iterator<ASTInterpreterListener> it = listeners.iterator(); it.hasNext();) {
                ASTInterpreterListener listener = it.next();
                if(EXECUTION_PAUSED.equals(msg)){
                    listener.executionPaused(this, (Integer)params[0], (Boolean)params[1]);
                }else if(STACK_PUSHED.equals(msg)){
                    listener.stackPushed((SymbolTable)params[0]);
                }else if(STACK_POPPED.equals(msg)){
                    listener.stackPopped();
                }else if(READ_STM.equals(msg)){
                    listener.readStatementExecuted(this, (Integer)params[0]);
                }else if(EXECUTION_STARTED.equals(msg)){
                    listener.executionStarted(this);
                }else if(EXECUTION_STOPPED.equals(msg)){
                    listener.executionStopped(this);
                }else if (RUNTIME_ERROR.equals(msg)) {
                    listener.runtimeError();
                }
            }
        }

        public void run(){
            this.finished = false;
            notifyListeners(EXECUTION_STARTED);
            try{
                unit();
                out.println(RuntimeMessages.STR_RUNTIME_MSG_EXECUTION_FINISHED);
            }catch(RecognitionException re){
                err.println(re.getMessage());
                notifyListeners(RUNTIME_ERROR);
            }catch (RuntimeException re) {
                err.println(re.getMessage());
                notifyListeners(RUNTIME_ERROR);
            }catch(Error e){
                if(e instanceof StackOverflowError){
                    err.println(RuntimeMessages.STR_RUNTIME_ERROR_STACk_OVERFLOW);
                }else{
                    err.println(String.format(RuntimeMessages.STR_RUNTIME_ERROR_JVM_ERROR, e.getMessage()));
                }
                notifyListeners(RUNTIME_ERROR);
            }
            this.finished = true;
            notifyListeners(EXECUTION_STOPPED);
        }


        public void stop(){
            stop = true;
        }

        public void killThread(){
            notifyListeners(RUNTIME_ERROR);
            throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_EXECUTION_TERMINATED_BY_USER);
        }

        public void resume(){
            this.halt = false;
        }

        public boolean hasFinished(){
            return this.finished;
        }

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


        public void pauseExecution(int line, boolean wasPrintStatement){
            this.halt=true;
            if(stop){
                killThread();
            }
            this.notifyListeners(EXECUTION_PAUSED, new Integer(line), Boolean.valueOf(wasPrintStatement));
            while(halt){
                if(stop){
                    killThread();
                }
                try{
                    Thread.sleep(500);
                }catch(InterruptedException ie){
                }
            }
        }

}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	^(  PROGRAM         {
                                        SymbolTable mainProgramSymbolTable = new MainProgramSymbolTable(this.scopeTable.getMainProgramScope());
                                        this.stack.push(mainProgramSymbolTable);
                                        this.currentSymbolTable = mainProgramSymbolTable;
                                        notifyListeners(STACK_PUSHED, mainProgramSymbolTable);
                                    }
                    id1=ID
                    declarations
                    block
                    (id2=ID)?
                )                   {
                                        this.stack.pop();
                                        notifyListeners(STACK_POPPED);
                                    }

        ;

declarations
	:	(constDecl)? (varDecl)?
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





varDecl
        :	^(VARIABLES varsDecl* )
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
                                        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_DIMENSIONS_MUST_BE_OF_INTEGER_TYPE_AND_IN_RANGE, Integer.MAX_VALUE));
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

block	:	^(BLOCK stm *)
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
                                        pauseExecution($PRINT.line, true);
                                    }
        |       ^(READ {   this.notifyListeners(READ_STM, new Integer($READ.line));    } readItem+)
	|	^(ASSIGN ID expr)   {
                                        boolean varAssignment = true;
                                        if(currentSymbolTable instanceof FunctionSymbolTable){
                                            FunctionSymbolTable fst = (FunctionSymbolTable)currentSymbolTable;
                                            if(fst.checkName($ID.text)){
                                                varAssignment = false;
                                                fst.setReturnValue($expr.result);
                                            }
                                        }
                                        if(varAssignment){
                                            RuntimeVariable var = (RuntimeVariable)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                            var.setValue($expr.result);
                                        }

                                        pauseExecution($ASSIGN.line, false);
                                    }
        |       ^(ASSIGN ID         {
                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                    }
                  arraySubscript [arr]
                  expr
                 )                  {
                                        arr.set($arraySubscript.value, $expr.result);
                                        pauseExecution($ASSIGN.line, false);
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
                                    {
                                        
                                    }
                )
        |       ^(SWITCH
                  expr              {
                                        boolean proceed = true;
                                        pauseExecution($SWITCH.line, false);
                                    }
                  (caseBlock [$expr.result, proceed]
                                    {
                                        proceed = $caseBlock.checkNextCaseBlock;
                                    }
                  )*
                  (caseElseBlock [proceed])?
                 )                  {
                                        
                                    }
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

                                        pauseExecution($FOR.line, false);

                                        if(InterpreterUtils.greaterThanOrEqual(step, BigInteger.ZERO)){ //step is positive
                                            while(InterpreterUtils.lowerThanOrEqual(counter.getValue(), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                counter.setValue(InterpreterUtils.add(counter.getValue(), step));
                                                pauseExecution($FOR.line, false);
                                            }
                                        }else{                                                //step is negative
                                            while(InterpreterUtils.greaterThanOrEqual(counter.getValue(), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                counter.setValue(InterpreterUtils.add(counter.getValue(), step));
                                                pauseExecution($FOR.line, false);
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

                                        pauseExecution($FOR.line, false);

                                        if(InterpreterUtils.greaterThanOrEqual(step, BigInteger.ZERO)){ //step is positive
                                            while(InterpreterUtils.lowerThanOrEqual(arr.get($arraySubscript.value), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                arr.set($arraySubscript.value, InterpreterUtils.add(arr.get($arraySubscript.value), step));
                                                pauseExecution($FOR.line, false);
                                            }
                                        }else{                                                //step is negative
                                            while(InterpreterUtils.greaterThanOrEqual(arr.get($arraySubscript.value), $toValue.result)){
                                                input.seek(blkIndex);
                                                block();
                                                arr.set($arraySubscript.value, InterpreterUtils.add(arr.get($arraySubscript.value), step));
                                                pauseExecution($FOR.line, false);
                                            }
                                        }

                                        input.seek(resumeAt);
                                        
                                    }
        |       ^(WHILE {int conditionIndex = input.index()+1;} condition=. {int blkIndex = input.index();}  blk=.)
                                    {
                                            int resumeAt = input.index();
                                            input.seek(conditionIndex);
                                            Boolean exprResult = (Boolean)expr().result;

                                            pauseExecution($WHILE.line, false);
                                            while(  exprResult.equals(Boolean.TRUE)  ){
                                                input.seek(blkIndex);
                                                block();
                                                input.seek(conditionIndex);
                                                exprResult = (Boolean)expr().result;
                                                pauseExecution($WHILE.line, false);
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
                                                exprResult = (Boolean)expr().result;
                                                pauseExecution($condition.getLine(), false);
                                            }

                                            input.seek(resumeAt);
                                            
                                    }
        |       ^(CALL ID paramsList)
                                    {
                                        pauseExecution($CALL.line, false);
                                        ProcedureScope ps = scopeTable.getProcedureScope($ID.text);
                                        if(ps!=null){
                                            ProcedureSymbolTable pst = new ProcedureSymbolTable(ps, $paramsList.parameters);
                                            this.stack.push(pst);
                                            this.currentSymbolTable = pst;
                                            notifyListeners(STACK_PUSHED, pst);

                                            int resumeAt = input.index();
                                            input.seek(pst.getIndex());
                                            procedure(true);
                                            this.stack.pop();
                                            this.currentSymbolTable = this.stack.peek();
                                            notifyListeners(STACK_POPPED);
                                            input.seek(resumeAt);
                                        }else{
                                            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CALL_TO_UNNKOWN_PROCEDURE, $ID.text));
                                        }
                                        
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
                                        pauseExecution($IF.line, false);
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
                                            pauseExecution($ELSE.line, false);
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
                                            pauseExecution($ELSE_IF.line, false);
                                            int resumeAt = input.index();
                                            input.seek(conditionIndex);
                                            Boolean exprResult = (Boolean)expr().result;

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
                                            pauseExecution($CASE.line, false);
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
	:	^(CASE_ELSE CASE {int blkIndex = input.index();} blk=.)
                                    {
                                        if($proceed){
                                            pauseExecution($CASE.line, false);
                                            int resumeAt = input.index();
                                            input.seek(blkIndex);
                                            block();
                                            input.seek(resumeAt);
                                        }
                                    }
        ;



expr	returns [Object result, Object resultForParam]
	:	^(AND	a=expr	  b=expr)   {   $result = InterpreterUtils.and($a.result, $b.result);   $resultForParam = $result;}
	|	^(OR	a=expr	  b=expr)   {   $result = InterpreterUtils.or($a.result, $b.result);    $resultForParam = $result;}
	|	^(EQ	a=expr	  b=expr)   {   $result = InterpreterUtils.equals($a.result, $b.result);    $resultForParam = $result;}
	|	^(NEQ	a=expr	  b=expr)   {   $result = InterpreterUtils.notEquals($a.result, $b.result); $resultForParam = $result;}
	|	^(LT	a=expr	  b=expr)   {   $result = InterpreterUtils.lowerThan($a.result, $b.result); $resultForParam = $result;}
	|	^(LE	a=expr	  b=expr)   {   $result = InterpreterUtils.lowerThanOrEqual($a.result, $b.result);  $resultForParam = $result;}
	|	^(GT	a=expr	  b=expr)   {   $result = InterpreterUtils.greaterThan($a.result, $b.result);   $resultForParam = $result;}
	|	^(GE	a=expr	  b=expr)   {   $result = InterpreterUtils.greaterThanOrEqual($a.result, $b.result);    $resultForParam = $result;}
	|	^(PLUS	a=expr	  b=expr)   {   $result = InterpreterUtils.add($a.result, $b.result);   $resultForParam = $result;}
	|	^(MINUS	a=expr	  b=expr)   {   $result = InterpreterUtils.subtract($a.result, $b.result);  $resultForParam = $result;}
	|	^(TIMES	a=expr	  b=expr)   {   $result = InterpreterUtils.multiply($a.result, $b.result);  $resultForParam = $result;}
        |	^(DIA	a=expr	  b=expr)   {   $result = InterpreterUtils.divide($a.result, $b.result);    $resultForParam = $result;}
        |	^(DIV	a=expr	  b=expr)   {   $result = InterpreterUtils.intDivide($a.result, $b.result); $resultForParam = $result;}
	|	^(MOD	a=expr	  b=expr)   {   $result = InterpreterUtils.intMod($a.result, $b.result);    $resultForParam = $result;}
	|	^(POW	a=expr	  b=expr)   {   $result = InterpreterUtils.pow($a.result, $b.result);   $resultForParam = $result;}
	|	^(NEG	a=expr)             {   $result = InterpreterUtils.negate($a.result);   $resultForParam = $result;}
	|	^(NOT	a=expr)             {   $result = InterpreterUtils.not($a.result);  $resultForParam = $result;}
	|	CONST_TRUE                  {   $result = Boolean.valueOf(true);    $resultForParam = $result;}
	|	CONST_FALSE                 {   $result = Boolean.valueOf(false);   $resultForParam = $result;}
	|	CONST_STR                   {   $result = new String($CONST_STR.text);  $resultForParam = $result;}
	|	CONST_INT                   {   $result = new BigInteger($CONST_INT.text);  $resultForParam = $result;}
	|	CONST_REAL                  {   $result = new BigDecimal($CONST_REAL.text, InterpreterUtils.getMathContext()); $resultForParam = $result;}
	|	ID                          {
                                                RuntimeSymbol s = (RuntimeSymbol)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                                if(s instanceof RuntimeSimpleSymbol){
                                                    $result = ((RuntimeSimpleSymbol)s).getValue();
                                                }
                                                $resultForParam = s;
                                            }
	|	^(
                    ARRAY_ITEM
                    ID                      {
                                                RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol($ID.text, new Point($ID.line, $ID.pos));
                                            }
                    arraySubscript [arr]
                                            {
                                                $result = arr.get($arraySubscript.value);
                                                $resultForParam = new RuntimeArrayItemWrapper(arr, $arraySubscript.value);
                                            }
                )
        |       ^(FUNC_CALL ID paramsList)          {
                                                            if(BuiltinFunctions.isBuiltinFunctionName($ID.text)){
                                                                $result = InterpreterUtils.execBuiltinFunction($ID.text, $paramsList.parameters.get(0));
                                                            }else{
                                                                pauseExecution($ID.line, false);
                                                                FunctionScope fs = scopeTable.getFunctionScope($ID.text);
                                                                if(fs!=null){
                                                                    FunctionSymbolTable fst = new FunctionSymbolTable(fs, $paramsList.parameters);
                                                                    this.stack.push(fst);
                                                                    this.currentSymbolTable = fst;
                                                                    notifyListeners(STACK_PUSHED, fst);

                                                                    int resumeAt = input.index();
                                                                    input.seek(fst.getIndex());
                                                                    function(true);

                                                                    this.stack.pop();
                                                                    this.currentSymbolTable = this.stack.peek();
                                                                    notifyListeners(STACK_POPPED);
                                                                    $result = fst.getReturnValue();
                                                                    input.seek(resumeAt);
                                                                }else{
                                                                    throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CALL_TO_UNNKOWN_FUNCTION, $ID.text));
                                                                }
                                                            }
                                                            $resultForParam = $result;
                                                    }
        ;

paramsList returns [List<Object> parameters]
	:	^(PARAMS    {List<Object> result = new ArrayList<Object>();}
                  (expr     {result.add($expr.resultForParam);}
                  )*
                )           {$parameters = result;}
        ;

arraySubscript [RuntimeArray arr] returns [List<Integer> value]
	:	^(ARRAY_INDEX
                                {List<Integer> result = new ArrayList<Integer>(); int index=0;}
                    (expr
                                {
                                    if(InterpreterUtils.isValidArrayIndex($expr.result, $arr, index)){
                                        result.add(new Integer(  ((BigInteger)$expr.result).intValue()   ));
                                    }else{
                                        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_INDICES_MUST_BE_OF_INTEGER_TYPE_AND_IN_RANGE, (index+1), $arr.getName(), $arr.getDimensions().get(index).intValue()));
                                    }
                                    index++;
                                }
                    )+
                                {
                                    List<Integer> dimensions = arr.getDimensions();
                                    if(result.size()!=dimensions.size()){
                                        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH,  result.size(), arr.getName(), dimensions.size()));
                                    }else{
                                        for(int i=0; i<dimensions.size(); i++){
                                            if(result.get(i).compareTo(dimensions.get(i))>0){
                                                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS,  Messages.arrayIndexToString(result), arr.getName()));
                                            }
                                        }
                                    }

                                    $value = result;
                                }
                )
        ;

procedure [boolean exec]
	:	^(PROCEDURE ID formalParamsList constDecl? varDecl? {int blkIndex = input.index();}blk=. )
                                {
                                    if(exec){
                                        ProcedureSymbolTable pst = (ProcedureSymbolTable)this.currentSymbolTable;
                                        pst.passParameters();
                                        pauseExecution($PROCEDURE.line, false);
                                        int resumeAt = input.index();
                                        input.seek(blkIndex);
                                        block();
                                        pst.restore();
                                        input.seek(resumeAt);
                                    }
                                }
        ;

function [boolean exec]
	:	^(FUNCTION ID returnType formalParamsList constDecl? varDecl? {int blkIndex = input.index();}blk=. )
                                {
                                    if(exec){
                                        FunctionSymbolTable fst = (FunctionSymbolTable)this.currentSymbolTable;
                                        fst.passParameters();
                                        pauseExecution($FUNCTION.line, false);
                                        int resumeAt = input.index();
                                        input.seek(blkIndex);
                                        block();
                                        input.seek(resumeAt);
                                    }
                                }
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
