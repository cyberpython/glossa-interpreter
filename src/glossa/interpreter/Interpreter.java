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
import glossa.recognizers.GlossaParser;
import glossa.recognizers.GlossaLexer;
import glossa.statictypeanalysis.FirstPass;
import glossa.statictypeanalysis.StaticTypeAnalyzer;
import glossa.statictypeanalysis.scopetable.ScopeTable;
import glossa.utils.CharsetDetector;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
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
public class Interpreter implements Runnable, ASTInterpreterListener {

    private static final String COMMAND_EXECUTED = "__cmd_exec__";
    private static final String STACK_PUSHED = "__stack_pushed__";
    private static final String STACK_POPPED = "__stack_popped__";
    private PrintStream out;
    private PrintStream err;
    private InputStream in;
    private File sourceCodeFile;
    private List<InterpreterListener> listeners;

    private ASTInterpreter interpreter;

    public Interpreter(File src) {
        this(src, System.out, System.err, System.in);
    }

    public Interpreter(File src, PrintStream out, PrintStream err, InputStream in) {
        this.sourceCodeFile = src;
        this.out = out;
        this.err = err;
        this.in = in;
        this.listeners = new ArrayList<InterpreterListener>();
        this.interpreter = null;
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
            if (COMMAND_EXECUTED.equals(msg)) {
                listener.commandExecuted(this, (Boolean)params[0]);
            } else if (STACK_PUSHED.equals(msg)) {
                listener.stackPushed((SymbolTable) params[0]);
            } else if (STACK_POPPED.equals(msg)) {
                listener.stackPopped();
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

    public void resume(){
        if(this.interpreter!=null){
                this.interpreter.resume();
        }
    }

    public void pause(){
        if(this.interpreter!=null){
            if(!interpreter.hasFinished()){
                this.interpreter.pause();
            }
        }
    }

    public void stop(){
        if(this.interpreter!=null){
            if(!interpreter.hasFinished()){
                this.interpreter.stop();
                while(!interpreter.hasFinished()){
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException ie){
                    }
                }
            }
        }
    }

    public void run() {

        stop();

        String filename = sourceCodeFile.getAbsolutePath();
        try {
            MessageLog msgLog = new MessageLog(err, out);
            Charset charset = getInputCharset(filename);

            GlossaParser.unit_return r = null;

            try {
                ANTLRFileStream input = new ANTLRFileStream(filename, charset.name());
                GlossaLexer lexer = new GlossaLexer(input);
                lexer.setMessageLog(msgLog);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                GlossaParser parser = new GlossaParser(tokens);
                parser.setMessageLog(msgLog);
                r = parser.unit();
            } catch (RuntimeException re) {
            }

            int errors = msgLog.getNumberOfErrors();
            msgLog.printErrors();



            if (errors == 0) {

                ScopeTable scopeTable = new ScopeTable();

                // WALK RESULTING TREE
                CommonTree t = (CommonTree) r.getTree(); // get tree from parser
                // Create a tree node stream from resulting tree
                BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(t);
                FirstPass fp = new FirstPass(nodes);
                fp.setScopeTable(scopeTable);
                fp.setMessageLog(msgLog);
                fp.unit();                 // launch at start rule prog

                errors = msgLog.getNumberOfErrors();
                msgLog.printErrors();


                if (errors == 0) {
                    nodes.reset();
                    StaticTypeAnalyzer staticTypeAnalyzer = new StaticTypeAnalyzer(nodes); // create a tree parser
                    staticTypeAnalyzer.setScopeTable(scopeTable);
                    staticTypeAnalyzer.setMessageLog(msgLog);
                    staticTypeAnalyzer.unit();                 // launch at start rule prog

                    errors = msgLog.getNumberOfErrors();
                    msgLog.printErrors();
                    msgLog.printWarnings();

                    if (errors == 0) {
                        //scopeTable.printScopes(out);
                        Deque<SymbolTable> stack = new ArrayDeque<SymbolTable>();
                        this.interpreter = new ASTInterpreter(nodes); // create a tree parser
                        interpreter.init(scopeTable, out, err, in);
                        interpreter.addListener(this);
                        Thread thread = new Thread(interpreter);
                        thread.start();
                        while(thread.isAlive()){
                            Thread.sleep(200);
                        }
                    }

                } else {
                    msgLog.printWarnings();
                }
            } else {
                msgLog.printWarnings();
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void stackPushed(SymbolTable newSymbolTable) {
        notifyListeners(STACK_PUSHED, newSymbolTable);
    }

    public void stackPopped() {
        notifyListeners(STACK_POPPED);
    }

    public void commandExecuted(ASTInterpreter sender, boolean wasPrintStatement) {
        notifyListeners(COMMAND_EXECUTED, Boolean.valueOf(wasPrintStatement));
    }
}
