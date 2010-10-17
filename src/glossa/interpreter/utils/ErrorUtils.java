/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.utils;


import glossa.interpreter.symboltable.Array;
import glossa.interpreter.symboltable.Constant;
import glossa.interpreter.symboltable.Symbol;
import glossa.interpreter.symboltable.Variable;
import java.awt.Point;
import java.io.PrintStream;

/**
 *
 * @author cyberpython
 */
public class ErrorUtils {

    private final static String CONSTS_STR_VARIABLE = "η μεταβλητή";
    private final static String CONSTS_STR_CONSTANT = "η σταθερά";
    private final static String CONSTS_STR_ARRAY    = "ο πίνακας";
    private final static String CONSTS_STR_UNKNOWN_SYMBOL    = "το σύμβολο";
    private final static String CONSTS_STR_ALREADY_DEFINED    = "%1$s \"%2$s\" έχει ήδη δηλωθεί στο %3$s";
    private final static String CONSTS_STR_PROG_NAME_MISMATCH = "το αναγνωριστικό \"%1$s\" είναι διαφορετικό από το όνομα του προγράμματος";
    private final static String CONSTS_STR_CONSTANTS_ALREADY_DEFINED    = "οι σταθερές έχουν ήδη δηλωθεί στο %1$s";
    private final static String CONSTS_STR_VARIABLES_ALREADY_DEFINED    = "οι μεταβλητές έχουν ήδη δηλωθεί στο %1$s";
    
    private final static PrintStream err;
    
    static{
        err = System.err;
    }

    public static void error(Point errorPoint, String msg){
        err.println(ErrorUtils.pointToString(errorPoint)+": "+msg);
    }

    public static void programNameMismatchError(Point errorPoint, String falseName){
        String msg = String.format(CONSTS_STR_PROG_NAME_MISMATCH, falseName);
        ErrorUtils.error(errorPoint, msg);
    }

    public static void constantsRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint){
        String msg = String.format(CONSTS_STR_CONSTANTS_ALREADY_DEFINED, ErrorUtils.pointToString(firstDeclarationPoint));
        ErrorUtils.error(redeclarationPoint, msg);
    }

    public static void variablesRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint){
        String msg = String.format(CONSTS_STR_VARIABLES_ALREADY_DEFINED, ErrorUtils.pointToString(firstDeclarationPoint));
        ErrorUtils.error(redeclarationPoint, msg);
    }

    public static void symbolRedefinitionError(Symbol s, Symbol existingSymbol){
        String msg = String.format(CONSTS_STR_ALREADY_DEFINED, ErrorUtils.symbolTypeToString(s), s.getName(), existingSymbol.getPositionAsString());
        ErrorUtils.error(s.getPosition(), msg);
    }

    
    public static String pointToString(Point p){
        return ((int)p.getX())+","+((int)p.getY()+1);
    }

    public static String symbolTypeToString(Symbol s){
        if(s instanceof Variable){
            return ErrorUtils.CONSTS_STR_VARIABLE;
        }else if(s instanceof Constant){
            return ErrorUtils.CONSTS_STR_CONSTANT;
        }else if(s instanceof Array){
            return ErrorUtils.CONSTS_STR_ARRAY;
        }else{
            return ErrorUtils.CONSTS_STR_UNKNOWN_SYMBOL;
        }
    }

}
