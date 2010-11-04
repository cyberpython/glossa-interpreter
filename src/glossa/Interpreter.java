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
package glossa;

import glossa.interpreter.ASTInterpreter;
import glossa.interpreter.symboltable.SymbolTable;
import glossa.messages.MessageLog;
import glossa.recognizers.GlossaParser;
import glossa.recognizers.GlossaLexer;
import glossa.statictypeanalysis.FirstPass;
import glossa.statictypeanalysis.StaticTypeAnalyzer;
import glossa.statictypeanalysis.scopetable.ScopeTable;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author cyberpython
 */
public class Interpreter {

    private PrintStream out;
    private PrintStream err;
    private InputStream in;

    public Interpreter() {
        this.out = System.out;
        this.err = System.err;
        this.in = System.in;
    }

    public Interpreter(PrintStream out, PrintStream err, InputStream in) {
        this.out = out;
        this.err = err;
        this.in = in;
    }

    public void run(String[] args) throws Exception {

        MessageLog msgLog = new MessageLog(err, out);

        GlossaParser.unit_return r = null;

        try {
            ANTLRFileStream input = new ANTLRFileStream(args[0]);
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
                    try {
                        Deque<SymbolTable> stack = new ArrayDeque<SymbolTable>();
                        nodes.reset();
                        ASTInterpreter interpreter = new ASTInterpreter(nodes); // create a tree parser
                        interpreter.setScopeTable(scopeTable);
                        interpreter.setStack(stack);
                        interpreter.setOutputStream(out);
                        interpreter.setErrorStream(err);
                        interpreter.setInputStream(in);
                        interpreter.unit();                 // launch at start rule prog

                    } catch (RuntimeException re) {
                        err.println(re.getMessage());
                    }
                }

            }else{
                msgLog.printWarnings();
            }
        }else{
            msgLog.printWarnings();
        }
    }
}
