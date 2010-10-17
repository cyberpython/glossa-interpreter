/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa;

import glossa.interpreter.Interpreter;


/**
 *
 * @author cyberpython
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interpreter inter = new Interpreter();
        try{
            inter.run(args);
        }catch(Exception e){
            System.err.println(e.getLocalizedMessage());
        }
    }

}
