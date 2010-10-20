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

import glossa.interpreter.symboltable.scopes.MainProgramScope;
import glossa.interpreter.messages.Messages;
import glossa.interpreter.symboltable.symbols.Symbol;
import glossa.interpreter.messages.ErrorMessage;
import glossa.interpreter.messages.InterpreterMessage;
import glossa.interpreter.messages.WarningMessage;
import glossa.interpreter.symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
            // Create an input character stream
            ANTLRFileStream input = new ANTLRFileStream(args[0]);

            // Create an ExprLexer that feeds from that stream
            GlossaLexer lexer = new GlossaLexer(input);

            // Create a stream of tokens fed by the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Create a parser that feeds off the token stream
            GlossaParser parser = new GlossaParser(tokens);

            // Begin parsing at rule prog
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

            SymbolTable symbolTable = new SymbolTable();

            // WALK RESULTING TREE
            CommonTree t = (CommonTree) r.getTree(); // get tree from parser
            // Create a tree node stream from resulting tree
            BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(t);
            StaticTypeAnalyzer staticTypeAnalyzer = new StaticTypeAnalyzer(nodes); // create a tree parser

            try{
                staticTypeAnalyzer.setSymbolTable(symbolTable);
                staticTypeAnalyzer.unit();                 // launch at start rule prog
            }catch(NullPointerException npe){
                npe.printStackTrace();
            }

            MainProgramScope mpst = symbolTable.getMainProgramScope();

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
                System.out.println();
                System.out.println();

                System.out.println("Πρόγραμμα: " + mpst.getProgramName());

                System.out.println();
                System.out.println("////////// Σύμβολα Κύριου Προγράμματος: /////////////");

                HashMap<String, Symbol> symbols = mpst.getSymbols();
                Collection<Symbol> values = symbols.values();
                List<Symbol> list = new ArrayList<Symbol>(values);
                Collections.sort(list);
                for (Iterator<Symbol> it = list.iterator(); it.hasNext();) {
                    Symbol s = it.next();
                    System.out.println((Symbol) s);
                }
            }
        }
    }
}
