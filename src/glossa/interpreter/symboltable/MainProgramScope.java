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

package glossa.interpreter.symboltable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class MainProgramScope extends Scope{

    private String programName;

    public MainProgramScope() {
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
        MainProgramScope mpst = new MainProgramScope();
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
