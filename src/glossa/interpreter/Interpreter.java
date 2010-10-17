/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter;

import glossa.interpreter.symboltable.MainProgramSymbolTable;

import java.io.File;
import java.io.FileInputStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author cyberpython
 */
public class Interpreter {
    public void run(String[] args) throws Exception {
        // Create an input character stream from standard in
        FileInputStream is = new FileInputStream(new File(Interpreter.class.getResource("/glossa/interpreter/tests/HelloWorld.gls").toURI()));
        ANTLRInputStream input = new ANTLRInputStream(is);
        // Create an ExprLexer that feeds from that stream
        GlossaLexer lexer = new GlossaLexer(input);
        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the token stream
        GlossaParser parser = new GlossaParser(tokens);
        // Begin parsing at rule prog
        GlossaParser.unit_return r = parser.unit();

        // WALK RESULTING TREE
        CommonTree t = (CommonTree)r.getTree(); // get tree from parser
        // Create a tree node stream from resulting tree
        BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(t);
        GlossaFirstPassWalker walker = new GlossaFirstPassWalker(nodes); // create a tree parser
        walker.unit();                 // launch at start rule prog


        is.close();

        MainProgramSymbolTable mpst = walker.mainSymbolTable;
        System.out.println(mpst.getProgramName());
    }
}
