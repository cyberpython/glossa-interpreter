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
import glossa.recognizers.GlossaParser;
import glossa.recognizers.GlossaLexer;
import glossa.messages.ErrorMessage;
import glossa.messages.InterpreterMessage;
import glossa.messages.Messages;
import glossa.messages.WarningMessage;
import glossa.statictypeanalysis.StaticTypeAnalyzer;
import glossa.statictypeanalysis.scopetable.ScopeTable;
import glossa.statictypeanalysis.scopetable.scopes.MainProgramScope;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
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
public class Interpreter {

    public void run(String[] args) throws Exception {

        Messages.clearMessages();

        List<InterpreterMessage> msgs = Messages.getMessages();

        GlossaParser.unit_return r = null;

        try {
            ANTLRFileStream input = new ANTLRFileStream(args[0]);
            GlossaLexer lexer = new GlossaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GlossaParser parser = new GlossaParser(tokens);
            r = parser.unit();
        } catch (RuntimeException re) {
            
        }

        int errors = 0;

        for (Iterator<InterpreterMessage> it = msgs.iterator(); it.hasNext();) {
            InterpreterMessage interpreterMessage = it.next();
            if (interpreterMessage instanceof ErrorMessage) {
                Messages.printError((ErrorMessage) interpreterMessage);
                errors++;

            } else if (interpreterMessage instanceof WarningMessage) {
                Messages.printWarning((WarningMessage) interpreterMessage);
            }
        }


        if (errors == 0) {

            ScopeTable scopeTable = new ScopeTable();

            // WALK RESULTING TREE
            CommonTree t = (CommonTree) r.getTree(); // get tree from parser
            // Create a tree node stream from resulting tree
            BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(t);
            StaticTypeAnalyzer staticTypeAnalyzer = new StaticTypeAnalyzer(nodes); // create a tree parser
            staticTypeAnalyzer.setScopeTable(scopeTable);
            staticTypeAnalyzer.unit();                 // launch at start rule prog
            

            MainProgramScope mpst = scopeTable.getMainProgramScope();

            errors = 0;

            for (Iterator<InterpreterMessage> it = msgs.iterator(); it.hasNext();) {
                InterpreterMessage interpreterMessage = it.next();
                if (interpreterMessage instanceof ErrorMessage) {
                    Messages.printError((ErrorMessage) interpreterMessage);
                    errors++;

                } else if (interpreterMessage instanceof WarningMessage) {
                    Messages.printWarning((WarningMessage) interpreterMessage);
                }
            }

            if (errors == 0) {
                try{
                Deque<SymbolTable> stack = new ArrayDeque<SymbolTable>();
                nodes.reset();
                ASTInterpreter interpreter = new ASTInterpreter(nodes); // create a tree parser
                interpreter.setScopeTable(scopeTable);
                interpreter.setStack(stack);
                interpreter.unit();                 // launch at start rule prog
                
                }catch(RuntimeException re){
                    System.out.println(re.getMessage());
                }
            }
        }
    }
}
