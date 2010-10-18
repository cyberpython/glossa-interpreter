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

package glossa.interpreter.messages;

import glossa.interpreter.symboltable.Array;
import glossa.interpreter.symboltable.Constant;
import glossa.interpreter.symboltable.Symbol;
import glossa.interpreter.symboltable.Variable;
import java.awt.Point;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class ReportingAndMessagingUtils {

    public final static String CONSTS_STR_ERROR = "Σφάλμα";
    public final static String CONSTS_STR_WARNING = "Προειδοποίηση";

    public final static String CONSTS_STR_THE_VARIABLE = "Η μεταβλητή";
    public final static String CONSTS_STR_THE_CONSTANT = "Η σταθερά";
    public final static String CONSTS_STR_THE_ARRAY = "Ο πίνακας";
    public final static String CONSTS_STR_THE_SYMBOL = "Το σύμβολο";

    public final static String CONSTS_STR_VARIABLE = "Μεταβλητή";
    public final static String CONSTS_STR_CONSTANT = "Σταθερά";
    public final static String CONSTS_STR_ARRAY = "Πίνακας";
    public final static String CONSTS_STR_SYMBOL = "Σύμβολο";

    public final static String CONSTS_STR_NAME = "Όνομα";
    public final static String CONSTS_STR_TYPE = "Τύπος";
    public final static String CONSTS_STR_DECLARED_AT = "Δηλωμένο στο";

    public final static String CONSTS_STR_TYPE_INTEGER = "Ακέραια";
    public final static String CONSTS_STR_TYPE_REAL = "Πραγματική";
    public final static String CONSTS_STR_TYPE_BOOLEAN = "Λογική";
    public final static String CONSTS_STR_TYPE_STRING = "Χαρακτήρες";

    public final static String CONSTS_STR_PROG_NAME_MISMATCH = "Το αναγνωριστικό \"%1$s\" είναι διαφορετικό από το όνομα του προγράμματος";
    public final static String CONSTS_STR_CONSTANTS_ALREADY_DEFINED = "Οι σταθερές έχουν ήδη δηλωθεί στο %1$s";
    public final static String CONSTS_STR_VARIABLES_ALREADY_DEFINED = "Οι μεταβλητές έχουν ήδη δηλωθεί στο %1$s";
    
    public final static String CONSTS_STR_ALREADY_DEFINED = "%1$s \"%2$s\" έχει ήδη δηλωθεί στο %3$s";
    public final static String CONSTS_STR_SYMBOL_UNDEFINED = "Το αναγνωριστικό \"%1$s\" δεν έχει δηλωθεί ως σταθερά, μεταβλητή, συνάρτηση ή διαδικασία";

    private final static PrintStream err;
    //private final static PrintStream out;

    private static List<InterpreterMessage> messages;

    static {
        err = System.err;
        messages = new ArrayList<InterpreterMessage>();
    }

    public static List<InterpreterMessage> getMessages(){
        return messages;
    }

    public static void clearMessages(){
        messages.clear();
    }

    public static void error(Point errorPoint, String msg) {
        //err.println(ReportingAndMessagingUtils.CONSTS_STR_ERROR+":\t"+ReportingAndMessagingUtils.pointToString(errorPoint) + ": " + msg);
        messages.add(new ErrorMessage(errorPoint, msg));
    }
    
    public static void warning(Point warningPoint, String msg) {
        //err.println(ReportingAndMessagingUtils.CONSTS_STR_WARNING+":\t"+ReportingAndMessagingUtils.pointToString(warningPoint) + ": " + msg);
        messages.add(new WarningMessage(warningPoint, msg));
    }
    
    public static void printError(ErrorMessage msg) {
        err.println(ReportingAndMessagingUtils.CONSTS_STR_ERROR+":\t"+ReportingAndMessagingUtils.pointToString(msg.getPoint()) + ": " + msg.getMsg());
    }

    public static void printWarning(WarningMessage msg) {
        err.println(ReportingAndMessagingUtils.CONSTS_STR_WARNING+":\t"+ReportingAndMessagingUtils.pointToString(msg.getPoint()) + ": " + msg.getMsg());
    }

    public static void programNameMismatchWarning(Point warningPoint, String falseName) {
        String msg = String.format(CONSTS_STR_PROG_NAME_MISMATCH, falseName);
        ReportingAndMessagingUtils.warning(warningPoint, msg);
    }

    public static void constantsRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(CONSTS_STR_CONSTANTS_ALREADY_DEFINED, ReportingAndMessagingUtils.pointToString(firstDeclarationPoint));
        ReportingAndMessagingUtils.error(redeclarationPoint, msg);
    }

    public static void variablesRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(CONSTS_STR_VARIABLES_ALREADY_DEFINED, ReportingAndMessagingUtils.pointToString(firstDeclarationPoint));
        ReportingAndMessagingUtils.error(redeclarationPoint, msg);
    }

    public static void symbolRedefinitionError(Symbol s, Symbol existingSymbol) {
        String msg = String.format(CONSTS_STR_ALREADY_DEFINED, ReportingAndMessagingUtils.symbolTypeToString(s), s.getName(), existingSymbol.getPositionAsString());
        ReportingAndMessagingUtils.error(s.getPosition(), msg);
    }

    public static void symbolUndefinedError(String symbolName, Point errorPoint) {
        String msg = String.format(CONSTS_STR_SYMBOL_UNDEFINED, symbolName);
        ReportingAndMessagingUtils.error(errorPoint, msg);
    }

    public static String pointToString(Point p) {
        return ((int) p.getX()) + "," + ((int) p.getY() + 1);
    }

    public static String symbolTypeToString(Symbol s) {
        if (s instanceof Variable) {
            return ReportingAndMessagingUtils.CONSTS_STR_THE_VARIABLE;
        } else if (s instanceof Constant) {
            return ReportingAndMessagingUtils.CONSTS_STR_THE_CONSTANT;
        } else if (s instanceof Array) {
            return ReportingAndMessagingUtils.CONSTS_STR_THE_ARRAY;
        } else {
            return ReportingAndMessagingUtils.CONSTS_STR_THE_SYMBOL;
        }
    }
}
