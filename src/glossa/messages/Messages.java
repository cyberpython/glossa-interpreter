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
package glossa.messages;


import glossa.statictypeanalysis.scopetable.symbols.Array;
import glossa.statictypeanalysis.scopetable.symbols.Constant;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.statictypeanalysis.scopetable.symbols.Variable;
import glossa.types.Type;
import java.awt.Point;
import java.util.Iterator;
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
    public final static String STR_ERROR_EXPONENT_NOT_INTEGER = "Ο εκθέτης πρέπει να είναι ακέραιου τύπου. Βρέθηκε: %2$s";
    public final static String STR_ERROR_ARRAY_DIMENSION_DECLARATION_NOT_INTEGER = "Το μέγεθος της διάστασης του πίνακα πρέπει να είναι τιμή ή έκφραση ακέραιου τύπου.";
    public final static String STR_ERROR_ARRAY_INDEX_NOT_INTEGER = "Ο δείκτης πρέπει να είναι μεταβλητή, σταθερά ή έκφραση ακέραιου τύπου.";
    public final static String STR_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH = "Το πλήθος των δεικτών (%1$d) δε συμφωνεί με τις διαστάσεις του πίνακα \"%2$s\" (%3$d).";

    public final static String STR_ERROR_VAR_OR_CONST_REFERENCED_BUT_NOT_INITIALIZED = "%1$s \"%2$s\" χρησιμοποιείται χωρίς να έχει πάρει αρχική τιμή.";
    public final static String STR_ERROR_ARRAY_ΙΤΕΜ_REFERENCED_BUT_NOT_INITIALIZED = "Το στοιχείο %2$s του πίνακα \"%1$s\" χρησιμοποιείται χωρίς να έχει πάρει αρχική τιμή.";

    public final static String STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM = "Στο αριστερό μέρος της ανάθεσης τιμής πρέπει να βρίσκεται μεταβλητή ή στοιχείο πίνακα.";
    public final static String STR_ERROR_READ_STM_ITEM_MUST_BE_INT_REAL_OR_STR = "Οι μεταβλητές και οι πίνακες που χρησιμοποιούνται στην εντολή \"ΔΙΑΒΑΣΕ\" πρέπει να είναι δηλωμένες ως ακέραιες, πραγματικές ή χαρακτήρες - βρέθηκε %1$s.";
    public final static String STR_ERROR_IF_EXPRESSION_MUST_BE_BOOLEAN = "Η συνθήκη στις δομές ΑΝ/ΑΛΛΙΩΣ_ΑΝ πρέπει να είναι λογικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_WHILE_EXPRESSION_MUST_BE_BOOLEAN = "Η συνθήκη στις δομές ΌΣΟ..ΕΠΑΝΑΛΑΒΕ/ΑΡΧΗ_ΕΠΑΝΑΛΗΨΗΣ..ΜΕΧΡΙΣ_ΌΤΟΥ πρέπει να είναι λογικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_COUNTER_MUST_BE_NUMERIC = "Η μεταβλητή-μετρητής στη δομή ΓΙΑ..ΑΠΟ..ΜΕΧΡΙ..(ΜΕ_ΒΗΜΑ..) πρέπει να είναι ακέραιου ή πραγματικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_FROM_TO_STEP_EXPR_MUST_BE_NUMERIC = "Οι εκφράσεις μετά το ΑΠΟ../ΜΕΧΡΙ../ΜΕ_ΒΗΜΑ.. πρέπει να είναι ακέραιου ή πραγματικού τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_FOR_FROM_STEP_EXPR_MUST_BE_INTEGER = "Οι εκφράσεις μετά το ΑΠΟ../ΜΕ_ΒΗΜΑ.. πρέπει να είναι ακέραιου τύπου όταν ο μετρητής είναι ακέραιου τύπου - βρέθηκε %1$s.";
    public final static String STR_ERROR_CASE_STM_MUST_HAVE_AT_LEAST_ONE_CASE = "Η δομή \"ΕΠΙΛΕΞΕ\" πρέπει να περιλαμβάνει τουλάχιστον μία \"ΠΕΡΙΠΤΩΣΗ\" ή \"ΠΕΡΙΠΤΩΣΗ ΑΛΛΙΩΣ\".";
    public final static String STR_ERROR_INCOMPATIBLE_TYPES_FOR_CASE_STM = "Ασύμβατοι τύποι δεδομένων για χρήση με τη δομή \"ΕΠΙΛΕΞΕ\": %1$s στο (%2$s) και %3$s στο (%4$s).";
    public final static String STR_ERROR_CASE_ITEM_EXPR_MUST_BE_INT_REAL_OR_STR = "Οι εκφράσεις που χρησιμοποιούνται στη λίστα τιμών της \"ΠΕΡΙΠΤΩΣΗ...\" πρέπει να είναι ακέραιες, πραγματικές ή χαρακτήρες - βρέθηκε %1$s.";

    public final static String STR_ERROR_CALL_TO_UNKNOWN_FUNCTION = "Κλήση σε άγνωστη συνάρτηση: %1$s %2$s";
    public final static String STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_NUMBER_OF_PARAMS = "Λάθος πλήθος παραμέτρων για κλήση στην ενσωματωμένη συνάρτηση %1$s(Χ): %2$d";
    public final static String STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_TYPE_OF_PARAMETER = "Ασύμβατος τύπος παραμέτρου για κλήση στην ενσωματωμένη συνάρτηση %1$s(Χ): %2$s";



    public static void programNameMismatchWarning(MessageLog msgLog, Point warningPoint, String falseName) {
        String msg = String.format(STR_WARNING_PROG_NAME_MISMATCH, falseName);
        msgLog.warning(warningPoint, msg);
    }

    public static void constantsRedeclarationError(MessageLog msgLog, Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(STR_ERROR_CONSTANTS_ALREADY_DEFINED, pointToString(firstDeclarationPoint));
        msgLog.error(redeclarationPoint, msg);
    }

    public static void variablesRedeclarationError(MessageLog msgLog, Point redeclarationPoint, Point firstDeclarationPoint) {
        String msg = String.format(STR_ERROR_VARIABLES_ALREADY_DEFINED, pointToString(firstDeclarationPoint));
        msgLog.error(redeclarationPoint, msg);
    }

    public static void symbolRedefinitionError(MessageLog msgLog, Symbol s, Symbol existingSymbol) {
        String msg = String.format(STR_ERROR_SYMBOL_ALREADY_DEFINED, symbolTypeToTheString(s), s.getName(), existingSymbol.getPositionAsString());
        msgLog.error(s.getPosition(), msg);
    }

    public static void symbolUndefinedError(MessageLog msgLog, String symbolName, Point errorPoint) {
        String msg = String.format(STR_ERROR_SYMBOL_UNDEFINED, symbolName);
        msgLog.error(errorPoint, msg);
    }

    public static void incompatibleTypeFoundError(MessageLog msgLog, Type type, Type[] requiredTypes, Point errorPoint) {
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
        msgLog.error(errorPoint, msg);
    }

    public static void incompatibleTypesFoundError(MessageLog msgLog, Type type1, Point type1ReferencePoint, Type type2, Point type2ReferencePoint, Point errorPoint, String operator) {
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
        msgLog.error(errorPoint, msg);
    }


    public static void exponentNotIntegerError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_EXPONENT_NOT_INTEGER, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void nonArraySymbolReferencedAsSuchError(MessageLog msgLog, Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY, s.getName(), symbolTypeToString(s).toLowerCase());
        msgLog.error(errorPoint, msg);
    }

    public static void nonVariableSymbolReferencedAsSuchError(MessageLog msgLog, Point errorPoint, Symbol s) {
        String msg = String.format(STR_ERROR_NONVARIABLE_REFERENCED_AS_VARIABLE, s.getName(), symbolTypeToString(s).toLowerCase());
        msgLog.error(errorPoint, msg);
    }

    public static void variableReferencesInDeclarationsNotAllowedError(MessageLog msgLog, Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_VAR_AND_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED);
        msgLog.error(errorPoint, msg);
    }

    public static void arrayReferencesInDeclarationsNotAllowedError(MessageLog msgLog, Symbol s, Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_REF_IN_DECLARATIONS_NOT_ALLOWED);
        msgLog.error(errorPoint, msg);
    }

    public static void arrayDimensionDeclarationsNotIntegerError(MessageLog msgLog, Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_DIMENSION_DECLARATION_NOT_INTEGER);
        msgLog.error(errorPoint, msg);
    }

    public static void arrayIndexNotIntegerError(MessageLog msgLog, Point errorPoint) {
        String msg = String.format(STR_ERROR_ARRAY_INDEX_NOT_INTEGER);
        msgLog.error(errorPoint, msg);
    }

    public static void arrayIndicesAndDimensionsMismatchError(MessageLog msgLog, Point errorPoint, Array arr, int indicesNumber) {
        String msg = String.format(STR_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH, indicesNumber, arr.getName(), arr.getNumberOfDimensions());
        msgLog.error(errorPoint, msg);
    }

    public static void leftSideOfAssignmentMustBeVarOrArrayError(MessageLog msgLog, Point errorPoint) {
        String msg = String.format(STR_ERROR_LEFT_SIDE_OF_ASSIGNMENT_MUST_BE_VAR_OR_ARRAY_ITEM);
        msgLog.error(errorPoint, msg);
    }

    public static void readItemMustBeIntRealOrStringError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_READ_STM_ITEM_MUST_BE_INT_REAL_OR_STR, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void varOrConstNotInitializedButReferencedError(MessageLog msgLog, Point errorPoint, Symbol s) {
        String msg = String.format(STR_ERROR_VAR_OR_CONST_REFERENCED_BUT_NOT_INITIALIZED, symbolTypeToTheString(s), s.getName());
        msgLog.error(errorPoint, msg);
    }

    public static void arrayItemNotInitializedButReferencedError(MessageLog msgLog, Point errorPoint, Array arr, List<Integer> indices) {
        String msg = String.format(STR_ERROR_ARRAY_ΙΤΕΜ_REFERENCED_BUT_NOT_INITIALIZED, symbolTypeToTheString(arr), arr.getName(), arrayIndexToString(indices));
        msgLog.error(errorPoint, msg);
    }

    public static void ifExpressionMustBeBooleanError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_IF_EXPRESSION_MUST_BE_BOOLEAN, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void whileExpressionMustBeBooleanError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_WHILE_EXPRESSION_MUST_BE_BOOLEAN, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void forCounterMustBeOfNumericTypeError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_COUNTER_MUST_BE_NUMERIC, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void forFromToStepExpressionsMustBeOfNumericTypeError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_FROM_TO_STEP_EXPR_MUST_BE_NUMERIC, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void forFromStepExpressionsMustBeIntegerError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_FOR_FROM_STEP_EXPR_MUST_BE_INTEGER, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }


    public static void caseStmMustHaveAtLeastOneCaseError(MessageLog msgLog, Point errorPoint) {
        String msg = String.format(STR_ERROR_CASE_STM_MUST_HAVE_AT_LEAST_ONE_CASE);
        msgLog.error(errorPoint, msg);
    }

    public static void incompatibleTypesForCaseStmFoundError(MessageLog msgLog, Type type1, Point type1ReferencePoint, Type type2, Point type2ReferencePoint, Point errorPoint) {
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
        String msg = String.format(STR_ERROR_INCOMPATIBLE_TYPES_FOR_CASE_STM,
                type1Str, pointToString(type1ReferencePoint),
                type2Str, pointToString(type2ReferencePoint));
        msgLog.error(errorPoint, msg);
    }

    public static void caseItemExprMustBeIntRealOrStringError(MessageLog msgLog, Point errorPoint, Type invalidType) {
        String msg = String.format(STR_ERROR_CASE_ITEM_EXPR_MUST_BE_INT_REAL_OR_STR, typeToStringM(invalidType));
        msgLog.error(errorPoint, msg);
    }

    public static void callToUnknownFunctionError(MessageLog msgLog, Point errorPoint, String functionName, List<Type> paramTypes) {
        String msg = String.format(STR_ERROR_CALL_TO_UNKNOWN_FUNCTION, functionName, paramTypesToString(paramTypes));
        msgLog.error(errorPoint, msg);
    }

    public static void callToBuiltinFunctionWithWrongNumOfParamsError(MessageLog msgLog, Point errorPoint, String functionName, int numOfParams) {
        String msg = String.format(STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_NUMBER_OF_PARAMS, functionName, numOfParams);
        msgLog.error(errorPoint, msg);
    }

    public static void callToBuiltinFunctionWithWrongParamTypeError(MessageLog msgLog, Point errorPoint, String functionName, Type paramType) {
        String msg = String.format(STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_TYPE_OF_PARAMETER, functionName, typeToString(paramType));
        msgLog.error(errorPoint, msg);
    }

    public static String pointToString(Point p) {
        return ((int) p.getX()) + "," + ((int) p.getY() + 1);
    }

    public static String typeToString(Type t) {
        if(t==null){
            return Messages.CONSTS_STR_TYPE_UNKNOWN;
        }
        if (t.equals(Type.INTEGER)) {
            return Messages.CONSTS_STR_TYPE_INTEGER;
        } else if (t.equals(Type.REAL)) {
            return Messages.CONSTS_STR_TYPE_REAL;
        } else if (t.equals(Type.BOOLEAN)) {
            return Messages.CONSTS_STR_TYPE_BOOLEAN;
        } else if (t.equals(Type.STRING)) {
            return Messages.CONSTS_STR_TYPE_STRING;
        } else {
            return Messages.CONSTS_STR_TYPE_UNKNOWN;
        }
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

    public static String arrayIndexToString(List<Integer> indices) {
        StringBuilder dim = new StringBuilder();
        dim.append("[");
        for (Iterator<Integer> it = indices.iterator(); it.hasNext();) {
            Integer integer = it.next();
            dim.append(String.valueOf(integer));
            if (it.hasNext()) {
                dim.append(",");
            }
        }
        dim.append("]");
        return dim.toString();
    }

    public static String paramTypesToString(List<Type> paramTypes) {
        StringBuilder dim = new StringBuilder();
        dim.append("(");
        for (Iterator<Type> it = paramTypes.iterator(); it.hasNext();) {
            Type type = it.next();
            dim.append(typeToString(type));
            if (it.hasNext()) {
                dim.append(", ");
            }
        }
        dim.append(")");
        return dim.toString();
    }
}
