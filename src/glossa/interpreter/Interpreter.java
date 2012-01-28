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

import glossa.interpreter.core.ASTInterpreter;
import glossa.interpreter.core.ASTInterpreterListener;
import glossa.interpreter.symboltable.SymbolTable;
import glossa.messages.MessageLog;
import glossa.messages.RuntimeMessages;
import glossa.recognizers.GlossaParser;
import glossa.recognizers.GlossaLexer;
import glossa.statictypeanalysis.FirstPass;
import glossa.statictypeanalysis.StaticTypeAnalyzer;
import glossa.statictypeanalysis.scopetable.ScopeTable;
import glossa.utils.CharsetDetector;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author cyberpython
 */
public class Interpreter implements ASTInterpreterListener {

    private static final String PARSER_AND_ANALYZER_FINISHED = "__parser_and_analyzer_done__";
    private static final String EXECUTION_STARTED = "__exec_started__";
    private static final String EXECUTION_PAUSED = "__exec_paused__";
    private static final String EXECUTION_STOPPED = "__exec_stopped__";
    private static final String READ_STM = "__read_stm__";
    private static final String STACK_PUSHED = "__stack_pushed__";
    private static final String STACK_POPPED = "__stack_popped__";
    private static final String RUNTIME_ERROR = "__runtime_error__";
    private PrintStream out;
    private PrintStream err;
    private PrintStream runtimeOut;
    private PrintStream runtimeErr;
    private InputStream runtimeIn;
    private File sourceCodeFile;
    private List<InterpreterListener> listeners;
    private BufferedTreeNodeStream nodes;
    private ASTInterpreter interpreter;
    private Thread interpreterThread;
    private MessageLog msgLog;
    private ScopeTable scopeTable;

    public Interpreter(File src) {
        this(src, System.out, System.err, System.out, System.err, System.in);
    }

    public Interpreter(File src, PrintStream out, PrintStream err, PrintStream runtimeOut, PrintStream runtimeErr, InputStream runtimeIn) {
        this.sourceCodeFile = src;
        this.out = out;
        this.err = err;
        this.runtimeOut = runtimeOut;
        this.runtimeErr = runtimeErr;
        this.runtimeIn = runtimeIn;
        this.listeners = new ArrayList<InterpreterListener>();
        this.interpreter = null;
        this.interpreterThread = null;
        this.msgLog = new MessageLog(err, out);
        this.scopeTable = null;
    }

    public void addListener(InterpreterListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(InterpreterListener listener) {
        return this.listeners.remove(listener);
    }

    public void notifyListeners(String msg, Object... params) {
        for (Iterator<InterpreterListener> it = listeners.iterator(); it.hasNext();) {
            InterpreterListener listener = it.next();
            if (EXECUTION_PAUSED.equals(msg)) {
                listener.executionPaused(this, (Integer) params[0], (Boolean)params[1]);
            } else if (STACK_PUSHED.equals(msg)) {
                listener.stackPushed((SymbolTable) params[0]);
            } else if (STACK_POPPED.equals(msg)) {
                listener.stackPopped();
            } else if(READ_STM.equals(msg)) {
                listener.readStatementExecuted(this, (Integer) params[0]);
            } else if (EXECUTION_STARTED.equals(msg)) {
                listener.executionStarted(this);
            } else if (EXECUTION_STOPPED.equals(msg)) {
                listener.executionStopped(this);
            } else if (RUNTIME_ERROR.equals(msg)) {
                listener.runtimeError();
            } else if (PARSER_AND_ANALYZER_FINISHED.equals(msg)) {
                listener.parsingAndSemanticAnalysisFinished(this, (Boolean)params[0]);
            }
        }
    }

    private static Charset getInputCharset(String filename) throws IOException {
        String[] charsetsToTest = {"UTF-8", "windows-1253", "ISO-8859-7"};
        File file = new File(filename);
        Charset charset = new CharsetDetector().detectCharset(file, charsetsToTest);
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        return charset;
    }

    public void resume() {
        if (this.interpreter != null) {
            this.interpreter.resume();
        }
    }

    public void stop() {
        if (this.interpreter != null) {
            if (!interpreter.hasFinished()) {
                this.interpreter.stop();
                interpreterThread.interrupt();
                /*while (interpreterThread.isAlive()) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ie) {
                    }
                }*/
            }
        }
    }

    public boolean parseAndAnalyzeSemantics(boolean silent) {

        int errors = 0;

        stop();

        String filename = sourceCodeFile.getAbsolutePath();
        msgLog = new MessageLog(err, out);

        Charset charset;
        try {
            charset = getInputCharset(filename);
        } catch (IOException ioe) {
            charset = Charset.defaultCharset();
        }

        try {
            ANTLRFileStream input = new ANTLRFileStream(filename, charset.name());

            try {
                GlossaParser.unit_return r = null;

                try {
                    GlossaLexer lexer = new GlossaLexer(input);
                    lexer.setMessageLog(msgLog);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    GlossaParser parser = new GlossaParser(tokens);
                    parser.setMessageLog(msgLog);
                    r = parser.unit();
                } catch (RuntimeException re) {
                }

                errors = msgLog.getNumberOfErrors();
                if (!silent) {
                    msgLog.printErrors();
                }

                if (errors == 0) {

                    scopeTable = new ScopeTable();

                    // WALK RESULTING TREE
                    CommonTree t = (CommonTree) r.getTree(); // get tree from parser
                    // Create a tree node stream from resulting tree
                    nodes = new BufferedTreeNodeStream(t);
                    FirstPass fp = new FirstPass(nodes);
                    fp.setScopeTable(scopeTable);
                    fp.setMessageLog(msgLog);
                    fp.unit();                 // launch at start rule prog

                    errors = msgLog.getNumberOfErrors();
                    if (!silent) {
                        msgLog.printErrors();
                    }


                    if (errors == 0) {
                        nodes.reset();
                        StaticTypeAnalyzer staticTypeAnalyzer = new StaticTypeAnalyzer(nodes); // create a tree parser
                        staticTypeAnalyzer.setScopeTable(scopeTable);
                        staticTypeAnalyzer.setMessageLog(msgLog);
                        staticTypeAnalyzer.unit();                 // launch at start rule prog

                        errors = msgLog.getNumberOfErrors();
                        if (!silent) {
                            msgLog.printErrors();
                            msgLog.printWarnings();
                        }

                        //------------------------------------

                    } else {
                        if (!silent) {
                            msgLog.printWarnings();
                        }
                    }
                } else {
                    if (!silent) {
                        msgLog.printWarnings();
                    }
                }
            } catch (Exception e) {
                msgLog.error(new Point(0, 0), e.getLocalizedMessage());
                err.println(e.getLocalizedMessage());
            }
        } catch (IOException ioe) {
            err.println(String.format(RuntimeMessages.STR_RUNTIME_ERROR_FILE_NOT_FOUND, filename));
            msgLog.error(new Point(0, 0), String.format(RuntimeMessages.STR_RUNTIME_ERROR_FILE_NOT_FOUND, filename));
        }

        errors = msgLog.getNumberOfErrors();
        boolean result = errors == 0;
        notifyListeners(PARSER_AND_ANALYZER_FINISHED, Boolean.valueOf(result));

        return result;
    }

    public MessageLog getMsgLog() {
        return msgLog;
    }

    public void exec() {
        stop();
        if (this.scopeTable != null) {
            //scopeTable.printScopes(out);
            this.interpreter = new ASTInterpreter(nodes); // create a tree parser
            interpreter.init(scopeTable, runtimeOut, runtimeErr, runtimeIn);
            interpreter.addListener(this);
            Thread thread = new Thread(interpreter);
            this.interpreterThread = thread;
            thread.start();
            /*while (thread.isAlive()) {
                try{
                    Thread.sleep(200);
                }catch(InterruptedException ie){
                }
            }*/
        }
    }

    public void printRuntimeStack() {
        if (this.interpreter != null) {
            out.println();
            Deque<SymbolTable> stack = this.interpreter.getStack();
            for (Iterator<SymbolTable> it = stack.iterator(); it.hasNext();) {
                SymbolTable symbolTable = it.next();
                symbolTable.print(out);
            }
        }
    }

    public void runtimeError() {
        notifyListeners(RUNTIME_ERROR);
    }

    public void stackPushed(SymbolTable newSymbolTable) {
        notifyListeners(STACK_PUSHED, newSymbolTable);
    }

    public void stackPopped() {
        notifyListeners(STACK_POPPED);
    }

    public void executionPaused(ASTInterpreter sender, Integer line, Boolean wasPrintStatement) {
        notifyListeners(EXECUTION_PAUSED, line, wasPrintStatement);
    }

    public void readStatementExecuted(ASTInterpreter sender, Integer line){
        notifyListeners(READ_STM, line);
    }

    public void executionStarted(ASTInterpreter sender) {
        notifyListeners(EXECUTION_STARTED);
    }

    public void executionStopped(ASTInterpreter sender) {
        notifyListeners(EXECUTION_STOPPED);
    }


}
