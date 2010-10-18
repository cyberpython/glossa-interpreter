/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package glossa.interpreter;

import glossa.interpreter.symboltable.MainProgramSymbolTable;
import glossa.interpreter.symboltable.ReportingAndMessagingUtils;
import glossa.interpreter.symboltable.Symbol;
import glossa.interpreter.symboltable.messages.ErrorMessage;
import glossa.interpreter.symboltable.messages.InterpreterMessage;
import glossa.interpreter.symboltable.messages.WarningMessage;

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

        ReportingAndMessagingUtils.clearMessages();

        // Create an input character stream from standard in
        /*InputStream is = Interpreter.class.getResourceAsStream("/glossa/interpreter/tests/HelloWorld.gls");
        ANTLRInputStream input = new ANTLRInputStream(is);*/
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        // Create an ExprLexer that feeds from that stream
        GlossaLexer lexer = new GlossaLexer(input);
        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the token stream
        GlossaParser parser = new GlossaParser(tokens);
        // Begin parsing at rule prog
        GlossaParser.unit_return r = parser.unit();

        // WALK RESULTING TREE
        CommonTree t = (CommonTree) r.getTree(); // get tree from parser
        // Create a tree node stream from resulting tree
        BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(t);
        GlossaFirstPassWalker walker = new GlossaFirstPassWalker(nodes); // create a tree parser
        walker.unit();                 // launch at start rule prog


        MainProgramSymbolTable mpst = (MainProgramSymbolTable) walker.symbolTable;


        List<InterpreterMessage> msgs = ReportingAndMessagingUtils.getMessages();
        
        int errors = 0;

        for (Iterator<InterpreterMessage> it = msgs.iterator(); it.hasNext();) {
            InterpreterMessage interpreterMessage = it.next();
            if (interpreterMessage instanceof ErrorMessage) {
                ReportingAndMessagingUtils.printError((ErrorMessage) interpreterMessage);
                errors++;

            } else if (interpreterMessage instanceof WarningMessage) {
                ReportingAndMessagingUtils.printWarning((WarningMessage) interpreterMessage);
            }
        }

        if (errors == 0) {

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
