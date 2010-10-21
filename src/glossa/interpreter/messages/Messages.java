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
public class Messages {

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

    public final static String STR_WARNING_PROG_NAME_MISMATCH = "Το αναγνωριστικό \"%1$s\" είναι διαφορετικό από το όνομα του προγράμματος.";

    public final static String STR_ERROR_CONSTANTS_ALREADY_DEFINED = "Οι σταθερές έχουν ήδη δηλωθεί στο %1$s.";
    public final static String STR_ERROR_VARIABLES_ALREADY_DEFINED = "Οι μεταβλητές έχουν ήδη δηλωθεί στο %1$s.";
    public final static String STR_ERROR_SYMBOL_ALREADY_DEFINED = "%1$s \"%2$s\" έχει ήδη δηλωθεί στο %3$s.";
    public final static String STR_ERROR_SYMBOL_UNDEFINED = "Το αναγνωριστικό \"%1$s\" δεν έχει δηλωθεί ως σταθερά, μεταβλητή, συνάρτηση ή διαδικασία.";

    public final static String STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY = "Το σύμβολο \"%1$s\" χρησιμοποιείται ως πίνακας ενώ είναι %2$s.";
    public final static String STR_ERROR_NONVARIABLE_REFERENCED_AS_VARIABLE = "Το σύμβολο \"%1$s\" χρησιμοποιείται ως μεταβλητή ενώ είναι %2$s.";
    public final static String STR_ERROR_VAR_AND_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED = "Δεν επιτρέπεται η χρήση μεταβλητών και πινάκων στη δήλωση σταθερών και μεταβλητών.";
    public final static String STR_ERROR_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED = "Δεν επιτρέπεται η χρήση πινάκων στη δήλωση σταθερών και μεταβλητών.";


    public final static String STR_ERROR_INCOMPATIBLE_TYPE = "Ασύμβατος τύπος δεδομένων: Βρέθηκε %1$s ενώ αναμενόταν %2$s.";
    public final static String STR_ERROR_INCOMPATIBLE_TYPES = "Ασύμβατοι τύποι δεδομένων για χρήση με τον τελεστή \"%5$s\": %1$s στο (%2$s) και %3$s στο (%4$s).";
    public final static String STR_ERROR_ARRAY_DIMENSION_DECLARATION_NOT_INTEGER = "Το μέγεθος της διάστασης του πίνακα πρέπει να είναι τιμή ή έκφραση ακέραιου τύπου.";
    public final static String STR_ERROR_ARRAY_INDEX_NOT_INTEGER = "Ο δείκτης πρέπει να είναι μεταβλητή, σταθερά ή έκφραση ακέραιου τύπου.";
    public final static String STR_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH = "Το πλήθος των δεικτών (%1$d) δε συμφωνεί με τις διαστάσεις του πίνακα \"%2$s\" (%3$d).";

    public final static String STR_ERROR_VAR_OR_CONST_REFERENCED_BUT_NOT_INITIALIZED = "%1$s \"%2$s\" χρησιμοποιείται χωρίς να έχει πάρει αρχική τιμή.";
    public final static String STR_ERROR_ARRAY_ΙΤΕΜ_REFERENCED_BUT_NOT_INITIALIZED = "Το στοιχείο %2$s του πίνακα \"%1$s\" χρησιμοποιείται χωρίς να έχει πάρει αρχική τιμή.";

    public final static String STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM = "Στο αριστερό μέρος της ανάθεσης τιμής πρέπει να βρίσκεται μεταβλητή ή στοιχείο πίνακα.";
    public final static String STR_ERROR_READ_STM_ITEM_MUST_BE_INT_REAL_OR_STR = "Οι μεταβλητές και οι πίνακες που χρησιμοποιούνται στην εντολή \"ΔΙΑΒΑΣΕ\" πρέπει να είναι δηλωμένες ως ακέραιες, πραγματικές ή χαρακτήρες - βρέθηκε %1$s.";
    public final static String STR_ERROR_IF_EXPRESSION_MUST_BE_BOOLEAN = "Η έκφραση στις δομές ΑΝ/ΑΛΛΙΩΣ_ΑΝ πρέπει να είναι λογικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_WHILE_EXPRESSION_MUST_BE_BOOLEAN = "Η έκφραση στις δομές ΌΣΟ..ΕΠΑΝΑΛΑΒΕ/ΑΡΧΗ_ΕΠΑΝΑΛΗΨΗΣ..ΜΕΧΡΙΣ_ΌΤΟΥ πρέπει να είναι λογικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_COUNTER_MUST_BE_NUMERIC = "Η μεταβλητή-μετρητής στη δομή ΓΙΑ..ΑΠΟ..ΜΕΧΡΙ..(ΜΕ_ΒΗΜΑ..) πρέπει να είναι ακέραιου ή πραγματικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_FROM_TO_STEP_EXPR_MUST_BE_NUMERIC = "Οι εκφράσεις μετά το ΑΠΟ../ΜΕΧΡΙ../ΜΕ_ΒΗΜΑ.. πρέπει να είναι ακέραιου ή πραγματικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_FROM_STEP_EXPR_MUST_BE_INTEGER = "Οι εκφράσεις μετά το ΑΠΟ../ΜΕ_ΒΗΜΑ.. πρέπει να είναι ακέραιου τύπου όταν ο μετρητής είναι ακέραιου τύπου - βρέθηκε %1$s.";

    public final static String STR_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS = "Ο δείκτης %1$s προς στοιχείο του πίνακα \"%2$s\" είναι εκτός ορίων.";

    private final static PrintStream err;
    private final static PrintStream warn;

    private static List<InterpreterMessage> messages;

    static {
        err = System.err;
        warn = System.out;
        messages = new ArrayList<InterpreterMessage>();
    }

    public static List<InterpreterMessage> getMessages() {
        return messages;
    }

    public static void clearMessages() {
        messages.clear();
    }

    public static void error(Point errorPoint, String msg) {
        messages.add(new ErrorMessage(errorPoint, msg));
    }

    public static void warning(Point warningPoint, String msg) {
        messages.add(new WarningMessage(warningPoint, msg));
    }

    public static void printError(ErrorMessage msg) {
        err.println(CONSTS_STR_ERROR + " (" + pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public static void printWarning(WarningMessage msg) {
        warn.println(CONSTS_STR_WARNING + " (" + pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public static void lexerError(Point errorPoint, String msg) {
        error(errorPoint, msg);
    }

    public static void parserError(Point errorPoint, String msg) {
        error(errorPoint, msg);
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
            if (i != max) {
                builder.append(" " + CONSTS_STR_OR + " ");
            }

        }

        String typeStr;
        if (type == null) {
            typeStr = CONSTS_STR_TYPE_UNKNOWN;
        }else{
            typeStr = typeToStringM(type);
        }

        String msg = String.format(STR_ERROR_INCOMPATIBLE_TYPE, typeStr, builder.toString());
        error(errorPoint, msg);
    }

    public static void incompatibleTypesFoundError(Type type1, Point type1ReferencePoint, Type type2, Point type2ReferencePoint, Point errorPoint, String operator) {
        String type1Str;
        String type2Str;
        if (type1 == null) {
            type1Str = CONSTS_STR_TYPE_UNKNOWN;
        }else{
            type1Str = typeToStringM(type1);
        }
        if (type2 == null) {
            type2Str = CONSTS_STR_TYPE_UNKNOWN;
        }else{
            type2Str = typeToStringM(type2);
        }
        String msg = String.format(STR_ERROR_INCOMPATIBLE_TYPES,
                type1Str, pointToString(type1ReferencePoint),
                type2Str, pointToString(type2ReferencePoint), operator);
        error(errorPoint, msg);
    }

    public static void nonArraySymbolReferencedAsSuchError(Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY, s.getName(), symbolTypeToString(s).toLowerCase());
        error(errorPoint, msg);
    }

    public static void nonVariableSymbolReferencedAsSuchError(Point errorPoint, Symbol s) {
        String msg = String.format(STR_ERROR_NONVARIABLE_REFERENCED_AS_VARIABLE, s.getName(), symbolTypeToString(s).toLowerCase());
        error(errorPoint, msg);
    }

    public static void variableReferencesInDeclarationsNotAllowedError(Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_VAR_AND_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED);
        error(errorPoint, msg);
    }

    public static void arrayReferencesInDeclarationsNotAllowedError(Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED);
        error(errorPoint, msg);
    }

    public static void arrayDimensionDeclarationsNotIntegerError(Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_DIMENSION_DECLARATION_NOT_INTEGER);
        error(errorPoint, msg);
    }

    public static void arrayIndexNotIntegerError(Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_INDEX_NOT_INTEGER);
        error(errorPoint, msg);
    }

    public static void arrayIndicesAndDimensionsMismatchError(Point errorPoint, Array arr, int indicesNumber) {
        String msg = String.format(STR_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH, indicesNumber, arr.getName(), arr.getDimensions().size());
        error(errorPoint, msg);
    }

    public static void arrayIndexOutOfBoundsError(Point errorPoint, Array arr, List<Integer> indices) {
        String msg = String.format(STR_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS, arr.arrayIndexToString(indices), arr.getName()+arr.arrayIndexToString(arr.getDimensions()));
        error(errorPoint, msg);
    }

    public static void leftSideOfAssignmentMustBeVarOrArrayError(Point errorPoint) {
        String msg = String.format(STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM);
        error(errorPoint, msg);
    }

    public static void readItemMustBeIntRealOrStringError(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_READ_STM_ITEM_MUST_BE_INT_REAL_OR_STR, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static void varOrConstNotInitializedButReferencedError(Point errorPoint, Symbol s) {
        String msg = String.format(STR_ERROR_VAR_OR_CONST_REFERENCED_BUT_NOT_INITIALIZED, symbolTypeToTheString(s), s.getName());
        error(errorPoint, msg);
    }

    public static void arrayItemNotInitializedButReferencedError(Point errorPoint, Array arr, List<Integer> indices) {
        String msg = String.format(STR_ERROR_ARRAY_ΙΤΕΜ_REFERENCED_BUT_NOT_INITIALIZED, symbolTypeToTheString(arr), arr.getName(), arr.arrayIndexToString(indices));
        error(errorPoint, msg);
    }

    public static void ifExpressionMustBeBoolean(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_IF_EXPRESSION_MUST_BE_BOOLEAN, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static void whileExpressionMustBeBoolean(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_WHILE_EXPRESSION_MUST_BE_BOOLEAN, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static void forCounterMustBeOfNumericType(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_COUNTER_MUST_BE_NUMERIC, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static void forFromToStepExpressionsMustBeOfNumericType(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_FROM_TO_STEP_EXPR_MUST_BE_NUMERIC, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static void forFromStepExpressionsMustBeInteger(Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_FROM_STEP_EXPR_MUST_BE_INTEGER, typeToStringM(invalidType));
        error(errorPoint, msg);
    }

    public static String pointToString(Point p) {
        return ((int) p.getX()) + "," + ((int) p.getY() + 1);
    }

    public static String typeToStringM(Type t) {
        if(t==null){
            return Messages.CONSTS_STR_TYPE_UNKNOWN_Μ;
        }
        if (t.equals(Type.INTEGER)) {
            return Messages.CONSTS_STR_TYPE_INTEGER_Μ;
        } else if (t.equals(Type.REAL)) {
            return Messages.CONSTS_STR_TYPE_REAL_Μ;
        } else if (t.equals(Type.BOOLEAN)) {
            return Messages.CONSTS_STR_TYPE_BOOLEAN_Μ;
        } else if (t.equals(Type.STRING)) {
            return Messages.CONSTS_STR_TYPE_STRING_Μ;
        } else {
            return Messages.CONSTS_STR_TYPE_UNKNOWN_Μ;
        }
    }

    public static String symbolTypeToTheString(Symbol s) {
        if (s instanceof Variable) {
            return Messages.CONSTS_STR_THE_VARIABLE;
        } else if (s instanceof Constant) {
            return Messages.CONSTS_STR_THE_CONSTANT;
        } else if (s instanceof Array) {
            return Messages.CONSTS_STR_THE_ARRAY;
        } else {
            return Messages.CONSTS_STR_THE_SYMBOL;
        }
    }

    public static String symbolTypeToString(Symbol s) {
        if (s instanceof Variable) {
            return Messages.CONSTS_STR_VARIABLE;
        } else if (s instanceof Constant) {
            return Messages.CONSTS_STR_CONSTANT;
        } else if (s instanceof Array) {
            return Messages.CONSTS_STR_ARRAY;
        } else {
            return Messages.CONSTS_STR_SYMBOL;
        }
    }
}
