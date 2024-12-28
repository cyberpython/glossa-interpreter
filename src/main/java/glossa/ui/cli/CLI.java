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
package glossa.ui.cli;

import glossa.interpreter.Interpreter;
import glossa.interpreter.InterpreterListener;
import glossa.interpreter.io.OutputPrinter;
import glossa.interpreter.io.SystemInReader;
import glossa.interpreter.symboltable.SymbolTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class CLI implements InterpreterListener {

    private static final String FILE_NOT_FOUND_ERROR = "Το αρχείο \"%1$s\" δε βρέθηκε!";
    private static final String INPUT_IO_ERROR = "Σφάλμα κατά την ανάγνωση της εισόδου από το πληκτρολόγιο!";
    private static final String CONTINUE_EXECUTION_PROMPT = "Συνέχεια; (Enter=ΝΑΙ / S+Enter=Εμφάνιση Στοίβας / Οτιδήποτε άλλο+Enter=ΤΕΡΜΑΤΙΣΜΟΣ): ";
    private static final String COMMAND_EXECUTED_MSG = "Εκτελέστηκε (Γραμμή %1$d): %2$s";
    private boolean stepByStep;
    private PrintStream out;
    private PrintStream err;
    private InputStream in;
    private List<String> sourceCode;

    public CLI(boolean executeStepByStep) {
        this.stepByStep = executeStepByStep;
        this.out = System.out;
        this.err = System.err;
        this.in = System.in;
        this.sourceCode = new ArrayList<String>();
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

    public void parsingAndSemanticAnalysisFinished(Interpreter sender, boolean success) {
        
    }

    public void runtimeError() {
    }

    public void readStatementExecuted(Interpreter sender, Integer line) {
    }

    public void executionPaused(Interpreter sender, Integer line, Boolean wasPrintStatement){
        if (!stepByStep) {
            sender.resume();
        } else {
            if(wasPrintStatement){
                sender.resume();
            }else{
                int lineNumber = line==null?-1:line.intValue();
                String codeLine = lineNumber==-1?"":sourceCode.get(lineNumber-1);
                out.println(String.format(COMMAND_EXECUTED_MSG, lineNumber, codeLine));
                checkUserInputAfterStep(sender);
            }
        }

    }

    public void executionStarted(Interpreter sender) {

    }

    public void executionStopped(Interpreter sender) {

    }

    public void stackPopped() {
    }

    public void stackPushed(SymbolTable newSymbolTable) {
    }

    private void checkUserInputAfterStep(Interpreter sender) {
        out.print(CONTINUE_EXECUTION_PROMPT);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        try {
            String s = r.readLine();
            if (s.equals("")) {
                sender.resume();
            } else if (s.toUpperCase().equals("S")) {
                sender.printRuntimeStack();
                sender.resume();
            } else {
                sender.stop();
            }
        } catch (IOException ioe) {
            err.println(INPUT_IO_ERROR);
        }
    }

    public void execute(File sourceCodeFile, PrintStream out, PrintStream err, InputStream in) {

        this.sourceCode.clear();
        
        String filename = sourceCodeFile.getAbsolutePath();

        Charset charset;
        try {
            charset = getInputCharset(filename);
        } catch (IOException ioe) {
            charset = Charset.defaultCharset();
        }

        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(sourceCodeFile),charset));
            
            String sourceCodeline = "";
            StringBuilder sb = new StringBuilder();
            try {
                while ((sourceCodeline = r.readLine()) != null) {
                    sb.append(sourceCodeline);
                    sb.append("\n");
                    sourceCode.add(sourceCodeline.trim());
                }
                sb.append("\n");

            } catch (IOException ioe) {
                sourceCode.clear();
                sb = new StringBuilder();
                ioe.printStackTrace();
            } finally {
                try {
                    r.close();
                } catch (IOException ioe) {
                }
            }

            this.out = out;
            this.err = err;
            this.in = in;

            Interpreter inter = new Interpreter(sb.toString(), new OutputPrinter(out), new OutputPrinter(err), new OutputPrinter(out), new OutputPrinter(err), new SystemInReader());
            inter.addListener(this);
            if (inter.parseAndAnalyzeSemantics(false)) {
                boolean echo = true;
                if(this.in == System.in){
                    echo = false;
                }
                inter.exec(echo);
            }
            
        } catch (FileNotFoundException fnfe) {
            err.println(String.format(FILE_NOT_FOUND_ERROR, sourceCodeFile.getAbsolutePath()));
        }
    }

    public void execute(File sourceCodeFile, File inputFile) {
        try {
            this.execute(sourceCodeFile, System.out, System.err, new FileInputStream(inputFile));
        } catch (FileNotFoundException fnfe) {
            System.err.println(String.format(FILE_NOT_FOUND_ERROR, inputFile.getAbsolutePath()));
        }
    }

    public void execute(File sourceCodeFile) {
        this.execute(sourceCodeFile, System.out, System.err, System.in);
    }
}
