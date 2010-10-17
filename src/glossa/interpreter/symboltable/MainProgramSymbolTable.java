/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class MainProgramSymbolTable extends SymbolTable{

    private String programName;

    public MainProgramSymbolTable() {
        super();
        this.programName = "";
    }


    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName the programName to set
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }


    public static void main(String[] args) {
        MainProgramSymbolTable mpst = new MainProgramSymbolTable();
        mpst.setProgramName("TestProgram");

        Variable x = new Variable("x", Type.INTEGER, 3, 12, 40, new Integer(0));
        mpst.defineSymbol("x", x);
        System.out.println(x);


        List<Integer> dimensions = new ArrayList<Integer>();
        dimensions.add(2);
        dimensions.add(5);
        mpst.defineSymbol("arr", new Array("arr", Type.REAL, 4, 32, 129, dimensions) );

        mpst.defineSymbol("arr", new Variable("arr", Type.INTEGER, 5, 212, 40, new Integer(0)));
        Symbol s = mpst.referenceSymbol("x", new Point(12,2));
        System.out.println(s);
        s = mpst.referenceSymbol("adsa", new Point(14,27));
    }



}
