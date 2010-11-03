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

import glossa.statictypeanalysis.ExpressionResultForm;
import glossa.statictypeanalysis.scopetable.parameters.ActualParameter;
import glossa.statictypeanalysis.scopetable.parameters.FormalParameter;
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
    public final static String CONSTS_STR_DIMENSIONS = "διαστάσεις";
    public final static String CONSTS_STR_OR = "ή";
    public final static String CONSTS_STR_THE_VARIABLE = "Η μεταβλητή";
    public final static String CONSTS_STR_THE_CONSTANT = "Η σταθερά";
    public final static String CONSTS_STR_THE_ARRAY = "Ο πίνακας";
    public final static String CONSTS_STR_THE_SYMBOL = "Το σύμβολο";
    public final static String CONSTS_STR_VARIABLE = "μεταβλητή";
    public final static String CONSTS_STR_CONSTANT = "σταθερά";
    public final static String CONSTS_STR_VARIABLES = "μεταβλητές";
    public final static String CONSTS_STR_CONSTANTS = "σταθερές";
    public final static String CONSTS_STR_ARRAY = "πίνακας";
    public final static String CONSTS_STR_SYMBOL = "σύμβολο";
    public final static String CONSTS_STR_NAME = "όνομα";
    public final static String CONSTS_STR_TYPE = "τύπος";
    public final static String CONSTS_STR_FUNCTION = "συνάρτηση";
    public final static String CONSTS_STR_PARAMETERS = "παράμετροι";
    public final static String CONSTS_STR_PARAMETER = "παράμετρος";
    public final static String CONSTS_STR_RETURNS = "επιστρέφει";
    public final static String CONSTS_STR_DECLARED_AT = "δηλωμένο στο";
    public final static String CONSTS_STR_TYPE_INTEGER = "ακέραια";
    public final static String CONSTS_STR_TYPE_REAL = "πραγματική";
    public final static String CONSTS_STR_TYPE_BOOLEAN = "λογική";
    public final static String CONSTS_STR_TYPE_STRING = "χαρακτήρας";
    public final static String CONSTS_STR_TYPE_UNKNOWN = "αγνωστος_τύπος";
    public final static String CONSTS_STR_TYPE_INTEGER_Μ = "ακέραιος";
    public final static String CONSTS_STR_TYPE_REAL_Μ = "πραγματικός";
    public final static String CONSTS_STR_TYPE_BOOLEAN_Μ = "λογικός";
    public final static String CONSTS_STR_TYPE_STRING_Μ = "χαρακτήρας";
    public final static String CONSTS_STR_TYPE_UNKNOWN_Μ = "άγνωστος_τύπος";
    public final static String CONSTS_STR_TYPE_OF_INTEGER = "ακεραίων";
    public final static String CONSTS_STR_TYPE_OF_REAL = "πραγματικών";
    public final static String CONSTS_STR_TYPE_OF_BOOLEAN = "λογικών";
    public final static String CONSTS_STR_TYPE_OF_STRING = "χαρακτήρων";
    public final static String CONSTS_STR_TYPE_OF_UNKNOWN = "αγνώστου_τύπου";
    public final static String STR_WARNING_PROG_NAME_MISMATCH = "Το αναγνωριστικό \"%1$s\" είναι διαφορετικό από το όνομα του προγράμματος.";
    public final static String STR_ERROR_CONSTANTS_ALREADY_DEFINED = "Οι σταθερές έχουν ήδη δηλωθεί στο %1$s.";
    public final static String STR_ERROR_VARIABLES_ALREADY_DEFINED = "Οι μεταβλητές έχουν ήδη δηλωθεί στο %1$s.";
    public final static String STR_ERROR_SYMBOL_ALREADY_DEFINED = "%1$s \"%2$s\" έχει ήδη δηλωθεί στο %3$s.";
    public final static String STR_ERROR_SYMBOL_UNDEFINED = "Το αναγνωριστικό \"%1$s\" δεν έχει δηλωθεί ως σταθερά ή μεταβλητή.";
    public final static String STR_ERROR_NONARRAY_REFERENCED_AS_ARRAY = "Το σύμβολο \"%1$s\" χρησιμοποιείται ως πίνακας ενώ είναι %2$s.";
    public final static String STR_ERROR_NONVARIABLE_REFERENCED_AS_VARIABLE = "Το σύμβολο \"%1$s\" χρησιμοποιείται ως μεταβλητή ενώ είναι %2$s.";
    public final static String STR_ERROR_ARRAY_USED_IN_EXPR = "Πίνακας \"%1$s\" - στις εκφράσεις δε μπορούν να χρησιμοποιηθούν ολόκληροι πίνακες.";
    public final static String STR_ERROR_ARRAY_USED_IN_ASSIGNMENT = "Πίνακας \"%1$s\" - δε μπορεί να γίνει ανάθεση ολόκληρου πίνακα σε μεταβλητή.";
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
    public final static String STR_ERROR_REDECLARATION_OF_BUILTIN_FUNCTION = "Υπάρχει ήδη ενσωματωμένη συνάρτηση με το όνομα \"%1$s\".";
    public final static String STR_ERROR_REDECLARATION_OF_FUNCTION = "Υπάρχει ήδη δηλωμένη συνάρτηση με το όνομα \"%1$s\".";
    public final static String STR_ERROR_REDECLARATION_OF_PROCEDURE = "Υπάρχει ήδη δηλωμένη διαδικασία με το όνομα \"%1$s\".";
    public final static String STR_ERROR_CANNOT_USE_PRINT_STM_IN_FUNCTIONS = "Δεν επιτρέπεται η χρήση της \"ΓΡΑΨΕ\" σε συναρτήσεις.";
    public final static String STR_ERROR_CANNOT_USE_READ_STM_IN_FUNCTIONS = "Δεν επιτρέπεται η χρήση της \"ΔΙΑΒΑΣΕ\" σε συναρτήσεις.";
    public final static String STR_ERROR_CANNOT_DEFINE_PARAM_WITH_SAME_NAME_AS_FUNCTION = "Παράμετρος \"%1$s\": δεν επιτρέπεται η δήλωση παραμέτρου με το ίδιο όνομα με τη συνάρτηση.";
    public final static String STR_ERROR_CANNOT_DECLARE_CONST_WITH_SAME_NAME_AS_FUNCTION = "Σταθερά \"%1$s\": δεν επιτρέπεται η δήλωση σταθεράς με το ίδιο όνομα με τη συνάρτηση.";
    public final static String STR_ERROR_CANNOT_DECLARE_VAR_WITH_SAME_NAME_AS_FUNCTION = "Μεταβλητή \"%1$s\": δεν επιτρέπεται η δήλωση μεταβλητής με το ίδιο όνομα με τη συνάρτηση.";
    public final static String STR_ERROR_PARAMETER_WITH_SAME_NAME_EXISTS = "Υπάρχει ήδη παράμετρος με το όνομα \"%1$s\".";
    public final static String STR_ERROR_PARAMETER_NOT_DECLARED = "Η παράμετρος \"%1$s\" δεν έχει δηλωθεί.";
    public final static String STR_ERROR_PARAMETER_MUST_BE_DECLARED_AS_VAR_OR_ARRAY = "Οι παράμετροι πρέπει να δηλώνονται ως μεταβλητές ή πίνακες.";
    public final static String STR_ERROR_FUNCTION_RETURN_VALUE_NOT_SET = "Δεν έχει δωθεί τιμή επιστροφής στη συνάρτηση %1$s%2$s.";
    public final static String STR_ERROR_CALL_TO_UNKNOWN_FUNCTION = "Κλήση σε άγνωστη συνάρτηση: %1$s %2$s.";
    public final static String STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_NUMBER_OF_PARAMS = "Λάθος πλήθος παραμέτρων για κλήση στην ενσωματωμένη συνάρτηση %1$s(Χ): %2$d.";
    public final static String STR_ERROR_CALL_TO_BUILTIN_FUNCTION_WITH_WRONG_TYPE_OF_PARAMETER = "Ασύμβατος τύπος παραμέτρου για κλήση στην ενσωματωμένη συνάρτηση %1$s(Χ): %2$s.";
    public final static String STR_ERROR_CALL_TO_FUNCTION_WITH_WRONG_NUMBER_OF_PARAMS = "Λάθος πλήθος παραμέτρων για κλήση στην συνάρτηση %1$s%2$s: %3$d.";
    public final static String STR_ERROR_CALL_TO_FUNCTION_WITH_WRONG_TYPE_OF_PARAMETER = "Εσφαλμένος τύπος της %1$dης παραμέτρου στην κλήση της συνάρτησης %2$s%3$s: βρέθηκε %4$s ενώ αναμενόταν %5$s.";

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
        } else {
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
        } else {
            type1Str = typeToStringM(type1);
        }
        if (type2 == null) {
            type2Str = CONSTS_STR_TYPE_UNKNOWN;
        } else {
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

    public static void arrayUsedInExpressionError(MessageLog msgLog, Point errorPoint, String arrayName) {
        String msg = String.format(STR_ERROR_ARRAY_USED_IN_EXPR, arrayName);
        msgLog.error(errorPoint, msg);
    }

    public static void arrayUsedInAssignmentError(MessageLog msgLog, Point errorPoint, String arrayName) {
        String msg = String.format(STR_ERROR_ARRAY_USED_IN_ASSIGNMENT, arrayName);
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
        } else {
            type1Str = typeToStringM(type1);
        }
        if (type2 == null) {
            type2Str = CONSTS_STR_TYPE_UNKNOWN;
        } else {
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

    public static void callToUnknownFunctionError(MessageLog msgLog, Point errorPoint, String functionName, List<ActualParameter> params) {
        String msg = String.format(STR_ERROR_CALL_TO_UNKNOWN_FUNCTION, functionName, actualParametersTypesToString(params));
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

    public static void callToFunctionWithWrongNumOfParamsError(MessageLog msgLog, Point errorPoint, String functionName, List<FormalParameter> fparams, int numOfParams) {
        String msg = String.format(STR_ERROR_CALL_TO_FUNCTION_WITH_WRONG_NUMBER_OF_PARAMS, functionName, formalParametersNamesToString(fparams), numOfParams);
        msgLog.error(errorPoint, msg);
    }

    public static void callToFunctionWithWrongParamTypeError(MessageLog msgLog, Point errorPoint, int paramIndex, String functionName, List<FormalParameter> fparams, ActualParameter param, FormalParameter formalParam) {
        String msg = String.format(STR_ERROR_CALL_TO_FUNCTION_WITH_WRONG_TYPE_OF_PARAMETER, paramIndex + 1, functionName, formalParametersNamesToString(fparams), actualParameterToString(param), formalParameterToString(formalParam));
        msgLog.error(errorPoint, msg);
    }

    public static void redeclarationOfBuiltinFunctionError(MessageLog msgLog, Point errorPoint, String subprogramName) {
        String msg = String.format(STR_ERROR_REDECLARATION_OF_BUILTIN_FUNCTION, subprogramName);
        msgLog.error(errorPoint, msg);
    }

    public static void redeclarationOfFunctionError(MessageLog msgLog, Point errorPoint, String subprogramName) {
        String msg = String.format(STR_ERROR_REDECLARATION_OF_FUNCTION, subprogramName);
        msgLog.error(errorPoint, msg);
    }

    public static void redeclarationOfProcedureError(MessageLog msgLog, Point errorPoint, String subprogramName) {
        String msg = String.format(STR_ERROR_REDECLARATION_OF_PROCEDURE, subprogramName);
        msgLog.error(errorPoint, msg);
    }

    public static void paramDefinedWithSameNameAsFunctionError(MessageLog msgLog, Point errorPoint, String paramName) {
        String msg = String.format(STR_ERROR_CANNOT_DEFINE_PARAM_WITH_SAME_NAME_AS_FUNCTION, paramName);
        msgLog.error(errorPoint, msg);
    }

    public static void constantDeclaredWithSameNameAsFunctionError(MessageLog msgLog, Point errorPoint, String constantName) {
        String msg = String.format(STR_ERROR_CANNOT_DECLARE_CONST_WITH_SAME_NAME_AS_FUNCTION, constantName);
        msgLog.error(errorPoint, msg);
    }

    public static void variableDeclaredWithSameNameAsFunctionError(MessageLog msgLog, Point errorPoint, String variableName) {
        String msg = String.format(STR_ERROR_CANNOT_DECLARE_VAR_WITH_SAME_NAME_AS_FUNCTION, variableName);
        msgLog.error(errorPoint, msg);
    }

    public static void parameterWithTheSameNameExistsError(MessageLog msgLog, Point errorPoint, String paramName) {
        String msg = String.format(STR_ERROR_PARAMETER_WITH_SAME_NAME_EXISTS, paramName);
        msgLog.error(errorPoint, msg);
    }

    public static void parameterNotDeclaredError(MessageLog msgLog, Point errorPoint, String paramName) {
        String msg = String.format(STR_ERROR_PARAMETER_NOT_DECLARED, paramName);
        msgLog.error(errorPoint, msg);
    }

    public static void functionReturnValueNotSetError(MessageLog msgLog, Point errorPoint, String functionName, List<FormalParameter> fparams) {
        String msg = String.format(STR_ERROR_FUNCTION_RETURN_VALUE_NOT_SET, functionName, formalParametersNamesToString(fparams));
        msgLog.error(errorPoint, msg);
    }

    public static String pointToString(Point p) {
        return ((int) p.getX()) + "," + ((int) p.getY() + 1);
    }

    public static String typeToString(Type t) {
        if (t == null) {
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
        if (t == null) {
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

    public static String typeOfToString(Type t) {
        if (t == null) {
            return Messages.CONSTS_STR_TYPE_OF_UNKNOWN;
        }
        if (t.equals(Type.INTEGER)) {
            return Messages.CONSTS_STR_TYPE_OF_INTEGER;
        } else if (t.equals(Type.REAL)) {
            return Messages.CONSTS_STR_TYPE_OF_REAL;
        } else if (t.equals(Type.BOOLEAN)) {
            return Messages.CONSTS_STR_TYPE_OF_BOOLEAN;
        } else if (t.equals(Type.STRING)) {
            return Messages.CONSTS_STR_TYPE_OF_STRING;
        } else {
            return Messages.CONSTS_STR_TYPE_OF_UNKNOWN;
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

    public static String formToString(ExpressionResultForm f) {
        if (ExpressionResultForm.ARRAY.equals(f)) {
            return CONSTS_STR_ARRAY + ":";
        }
        return "";
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

    public static String actualParametersTypesToString(List<ActualParameter> params) {
        StringBuilder dim = new StringBuilder();
        dim.append("(");
        for (Iterator<ActualParameter> it = params.iterator(); it.hasNext();) {
            ActualParameter param = it.next();
            Type type = param.getType();
            if (ExpressionResultForm.ARRAY.equals(param.getForm())) {
                dim.append(CONSTS_STR_ARRAY);
                dim.append(" ");
                dim.append(typeOfToString(type));
            } else {
                dim.append(typeToString(type));
            }
            if (it.hasNext()) {
                dim.append(", ");
            }
        }
        dim.append(")");
        return dim.toString();
    }

    public static String formalParametersNamesToString(List<FormalParameter> params) {
        StringBuilder dim = new StringBuilder();
        dim.append("(");
        for (Iterator<FormalParameter> it = params.iterator(); it.hasNext();) {
            FormalParameter param = it.next();
            dim.append(param.getName());
            if (it.hasNext()) {
                dim.append(", ");
            }
        }
        dim.append(")");
        return dim.toString();
    }

    public static String formalParametersTypesToString(List<FormalParameter> params) {
        StringBuilder dim = new StringBuilder();
        dim.append("(");
        for (Iterator<FormalParameter> it = params.iterator(); it.hasNext();) {
            FormalParameter param = it.next();
            Type type = param.getType();
            if (param.isArrayParamFlagSet()) {
                dim.append(CONSTS_STR_ARRAY);
                dim.append(" ");
                dim.append(typeOfToString(type));
            } else {
                dim.append(typeToString(type));
            }
            if (it.hasNext()) {
                dim.append(", ");
            }
        }
        dim.append(")");
        return dim.toString();
    }

    public static String formalParameterToString(FormalParameter param) {
        StringBuilder dim = new StringBuilder();
        Type type = param.getType();
        if (param.isArrayParamFlagSet()) {
            dim.append(CONSTS_STR_ARRAY);
            dim.append(" ");
            dim.append(typeOfToString(type));
        }else{
            dim.append(typeToString(type));
        }
        return dim.toString();
    }

    public static String actualParameterToString(ActualParameter param) {
        StringBuilder dim = new StringBuilder();
        Type type = param.getType();
        if (ExpressionResultForm.ARRAY.equals(param.getForm())) {
            dim.append(CONSTS_STR_ARRAY);
            dim.append(" ");
            dim.append(typeOfToString(type));
        }else{
            dim.append(typeToString(type));
        }
        return dim.toString();
    }
}
