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

import glossa.interpreter.symboltable.symbols.Array;
import glossa.interpreter.symboltable.symbols.Constant;
import glossa.interpreter.symboltable.symbols.Symbol;
import glossa.interpreter.symboltable.symbols.Variable;
import glossa.interpreter.symboltable.types.Type;
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

    public final static String CONSTS_STR_DIMENSIONS = "Διαστάσεις";
    
    public final static String CONSTS_STR_OR = "ή";

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
    public final static String CONSTS_STR_TYPE_UNKNOWN = "Άγνωστος_Τύπος";

    public final static String CONSTS_STR_TYPE_INTEGER_Μ = "Ακέραιος";
    public final static String CONSTS_STR_TYPE_REAL_Μ = "Πραγματικός";
    public final static String CONSTS_STR_TYPE_BOOLEAN_Μ = "Λογικός";
    public final static String CONSTS_STR_TYPE_STRING_Μ = "Χαρακτήρες";
    public final static String CONSTS_STR_TYPE_UNKNOWN_Μ = "Άγνωστος_Τύπος";

    public final static String STR_WARNING_PROG_NAME_MISMATCH = "Το αναγνωριστικό \"%1$s\" είναι διαφορετικό από το όνομα του προγράμματος";
    public final static String STR_ERROR_CONSTANTS_ALREADY_DEFINED = "Οι σταθερές έχουν ήδη δηλωθεί στο %1$s";
    public final static String STR_ERROR_VARIABLES_ALREADY_DEFINED = "Οι μεταβλητές έχουν ήδη δηλωθεί στο %1$s";
    
    public final static String STR_ERROR_SYMBOL_ALREADY_DEFINED = "%1$s \"%2$s\" έχει ήδη δηλωθεί στο %3$s";
    public final static String STR_ERROR_SYMBOL_UNDEFINED = "Το αναγνωριστικό \"%1$s\" δεν έχει δηλωθεί ως σταθερά, μεταβλητή, συνάρτηση ή διαδικασία";

    public final static String STR_ERROR_ARR_DIMENSION_DECLARATION_NOT_INTEGER = "Το μέγεθος της διάστασης του πίνακα πρέπει να είναι τιμή ή έκφραση ακέραιου τύπου";
    public final static String STR_ERROR_INCOMPATIBLE_TYPE = "Ασύμβατος τύπος δεδομένων: Βρέθηκε %1$s ενώ αναμενόταν %2$s";
    public final static String STR_ERROR_INCOMPATIBLE_TYPES = "Ασύμβατοι τύποι δεδομένων για χρήση με τον τελεστή \"%5$s\": %1$s στο (%2$s) και %3$s στο (%4$s)";

    public final static String STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY = "Το σύμβολο %1$s χρησιμοποιείται ως πίνακας ενώ είναι %2$s !";
    public final static String STR_ERROR_VAR_REF_IN_DECLARATIONS_NOT_ALLOWED = "Δεν επιτρέπεται η χρήση μεταβλητών στη δήλωση σταθερών και μεταβλητών";
    public final static String STR_ERROR_ARR_REF_IN_DECLARATIONS_NOT_ALLOWED = "Δεν επιτρέπεται η χρήση πινάκων στη δήλωση σταθερών και μεταβλητών";

    public final static String STR_ERROR_ARR_INDEX_NOT_INTEGER = "Ο δείκτης πρέπει να είναι μεταβλητή, σταθερά ή έκφραση ακέραιου τύπου";
    public final static String STR_ERROR_ARR_INDICES_AND_DIMENSIONS_MISMATCH = "Το πλήθος των δεικτών (%1$d) δε συμφωνεί με τις διαστάσεις του πίνακα \"%2$s\" (%3$d)";

    public final static String STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM = "Στο αριστερό μέρος της ανάθεσης τιμής πρέπει να βρίσκεται μεταβλητή ή στοιχείο πίνακα";
    

    private final static PrintStream err;
    private final static PrintStream warn;

    private static List<InterpreterMessage> messages;

    static {
        err = System.err;
        warn = System.out;
        messages = new ArrayList<InterpreterMessage>();
    }

    public static List<InterpreterMessage> getMessages(){
        return messages;
    }

    public static void clearMessages(){
        messages.clear();
    }

    public static void error(Point errorPoint, String msg) {
        messages.add(new ErrorMessage(errorPoint, msg));
    }
    
    public static void warning(Point warningPoint, String msg) {
        messages.add(new WarningMessage(warningPoint, msg));
    }
    
    public static void printError(ErrorMessage msg) {
        err.println(CONSTS_STR_ERROR+" ("+pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public static void printWarning(WarningMessage msg) {
        warn.println(CONSTS_STR_WARNING+" ("+pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public static void programNameMismatchWarning(Point warningPoint, String falseName) {
        String msg = String.format(STR_WARNING_PROG_NAME_MISMATCH, falseName);
        warning(warningPoint, msg);
    }

    public static void constantsRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(STR_ERROR_CONSTANTS_ALREADY_DEFINED, pointToString(firstDeclarationPoint));
        error(redeclarationPoint, msg);
    }

    public static void variablesRedeclarationError(Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(STR_ERROR_VARIABLES_ALREADY_DEFINED, pointToString(firstDeclarationPoint));
        error(redeclarationPoint, msg);
    }

    public static void symbolRedefinitionError(Symbol s, Symbol existingSymbol) {
        String msg = String.format(STR_ERROR_SYMBOL_ALREADY_DEFINED, symbolTypeToTheString(s), s.getName(), existingSymbol.getPositionAsString());
        error(s.getPosition(), msg);
    }

    public static void symbolUndefinedError(String symbolName, Point errorPoint) {
        String msg = String.format(STR_ERROR_SYMBOL_UNDEFINED, symbolName);
        error(errorPoint, msg);
    }

    public static void incompatibleTypeFoundError(Type type, Type[] requiredTypes, Point errorPoint) {
        StringBuilder builder = new StringBuilder();

        int max = requiredTypes.length - 1;
        for (int i = 0; i < requiredTypes.length; i++) {
            Type t = requiredTypes[i];
            builder.append(typeToStringM(t));
            if(i!=max){
                builder.append(" "+CONSTS_STR_OR+" ");
            }

        }

        String msg = String.format(STR_ERROR_INCOMPATIBLE_TYPE, typeToStringM(type), builder.toString());
        error(errorPoint, msg);
    }

    public static void incompatibleTypesFoundError(Type type1, Point type1ReferencePoint, Type type2, Point type2ReferencePoint, Point errorPoint, String operator) {
        String msg = String.format(STR_ERROR_INCOMPATIBLE_TYPES,
                                    typeToStringM(type1), pointToString(type1ReferencePoint),
                                    typeToStringM(type2), pointToString(type2ReferencePoint), operator
                                  );
        error(errorPoint, msg);
    }

    public static void nonArraySymbolReferencedAsSuch(Symbol s, Point errorPoint){
        String msg = String.format(STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY, s.getName(), symbolTypeToString(s).toLowerCase());
        error(errorPoint, msg);
    }

    public static void variableReferencesInDeclarationsNotAllowedError(Symbol s, Point errorPoint){
        String msg = String.format(STR_ERROR_VAR_REF_IN_DECLARATIONS_NOT_ALLOWED);
        error(errorPoint, msg);
    }

    public static void arrayReferencesInDeclarationsNotAllowedError(Symbol s, Point errorPoint){
        String msg = String.format(STR_ERROR_ARR_REF_IN_DECLARATIONS_NOT_ALLOWED);
        error(errorPoint, msg);
    }

    public static void arrayDimensionDeclarationsNotIntegerError(Point errorPoint){
        String msg = String.format(STR_ERROR_ARR_DIMENSION_DECLARATION_NOT_INTEGER);
        error(errorPoint, msg);
    }

    public static void arrayIndexNotIntegerError(Point errorPoint){
        String msg = String.format(STR_ERROR_ARR_INDEX_NOT_INTEGER);
        error(errorPoint, msg);
    }

    public static void arrayIndicesAndDimensionsMismatchError(Point errorPoint, Array arr, int indicesNumber){
        String msg = String.format(STR_ERROR_ARR_INDICES_AND_DIMENSIONS_MISMATCH, indicesNumber, arr.getName(), arr.getDimensions().size());
        error(errorPoint, msg);
    }

    public static void leftSideOfAssignmentMustBeVarOrArrayError(Point errorPoint){
        String msg = String.format(STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM);
        error(errorPoint, msg);
    }

    public static String pointToString(Point p) {
        return ((int) p.getX()) + "," + ((int) p.getY() + 1);
    }

    public static String typeToStringM(Type t) {
        if(t.equals(Type.INTEGER)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_INTEGER_Μ;
        }else if(t.equals(Type.REAL)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_REAL_Μ;
        }else if(t.equals(Type.BOOLEAN)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_BOOLEAN_Μ;
        }else if(t.equals(Type.STRING)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_STRING_Μ;
        }else{
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_UNKNOWN_Μ;
        }
    }

    public static String symbolTypeToTheString(Symbol s) {
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

    public static String symbolTypeToString(Symbol s) {
        if (s instanceof Variable) {
            return ReportingAndMessagingUtils.CONSTS_STR_VARIABLE;
        } else if (s instanceof Constant) {
            return ReportingAndMessagingUtils.CONSTS_STR_CONSTANT;
        } else if (s instanceof Array) {
            return ReportingAndMessagingUtils.CONSTS_STR_ARRAY;
        } else {
            return ReportingAndMessagingUtils.CONSTS_STR_SYMBOL;
        }
    }
}
