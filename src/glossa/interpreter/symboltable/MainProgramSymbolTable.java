/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

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

        mpst.defineSymbol("x", new Variable("x", Type.INTEGER, 3, 12, 40, new Integer(0)));

        List<Integer> dimensions = new ArrayList<Integer>();
        dimensions.add(2);
        dimensions.add(5);
        mpst.defineSymbol("arr", new Array("arr", Type.REAL, 4, 32, 129, dimensions) );

        mpst.defineSymbol("arr", new Variable("arr", Type.INTEGER, 5, 212, 40, new Integer(0)));
    }



}
