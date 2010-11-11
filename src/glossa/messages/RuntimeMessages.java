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

import glossa.interpreter.symboltable.symbols.RuntimeArray;
import glossa.interpreter.symboltable.symbols.RuntimeConstant;
import glossa.interpreter.symboltable.symbols.RuntimeSymbol;
import glossa.interpreter.symboltable.symbols.RuntimeVariable;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class RuntimeMessages {

    public final static String STR_RUNTIME_MSG_EXECUTION_FINISHED = "Η εκτέλεση ολοκληρώθηκε.";

    public final static String STR_RUNTIME_ERROR_FILE_NOT_FOUND = "Το αρχείο \"%1$s\" δε βρέθηκε!";
    public final static String STR_RUNTIME_ERROR_EXECUTION_TERMINATED_BY_USER = "Η εκτέλεση τερματίστηκε από το χρήστη.";
    public final static String STR_RUNTIME_ERROR_STACk_OVERFLOW = "Ο χώρος στη στοίβα της εικονικής μηχανής Java δεν επαρκεί.\n Μπορείτε να καθορίσετε το μέγεθος της στοίβας σε MB με την παράμετρο:\n\t -Xss<πλήθος_MB>Μ\n π.χ.\n\t java -Xss16M -jar ...";
    public final static String STR_RUNTIME_ERROR_JVM_ERROR = "Σοβαρό σφάλμα κατά τη λειτουργία της εικονικής μηχανής Java : %1$s";

    public static final String UNDEFINED_VALUE = "<απροσδιόριστη_τιμή>";
    public static final String CONST_STR_TRUE = "ΑΛΗΘΗΣ";
    public static final String CONST_STR_FALSE = "ΨΕΥΔΗΣ";
    public static final String CONST_STR_PROCEDURE = "ΔΙΑΔΙΚΑΣΙΑ";
    public static final String CONST_STR_FUNCTION = "ΣΥΝΑΡΤΗΣΗ";
    public static final String CONST_STR_PROGRAM = "ΠΡΟΓΡΑΜΜΑ";
    public static final String CONST_STR_PARAMETERS = "ΠΑΡΑΜΕΤΡΟΙ";
    public static final String CONST_STR_RETURN_VALUE = "ΤΙΜΗ ΕΠΙΣΤΡΟΦΗΣ";

    public final static String STR_RUNTIME_ERROR_CALL_TO_UNNKOWN_FUNCTION = "Κλήση σε άγνωστη συνάρτηση: %1$s";
    public final static String STR_RUNTIME_ERROR_CALL_TO_UNNKOWN_PROCEDURE = "Κλήση σε άγνωστη διαδικασία: %1$s";

    public final static String STR_RUNTIME_ERROR_SIMPLE_SYMBOL_NOT_INITIALIZED = "%1$s \"%2$s\" δεν έχει πάρει αρχική τιμή.";
    public final static String STR_RUNTIME_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS = "Ο δείκτης %1$s προς στοιχείο του πίνακα \"%2$s\" είναι εκτός ορίων.";
    public final static String STR_RUNTIME_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH = "Το πλήθος των δεικτών (%1$d) δε συμφωνεί με τις διαστάσεις του πίνακα \"%2$s\" (%3$d).";
    public final static String STR_RUNTIME_ERROR_ARRAY_LENGTHS_MISMATCH = "Ασυμφωνία των μεγεθών των πινάκων κατά την αντιγραφή των τιμών τους.";
    public final static String STR_RUNTIME_ERROR_INVALID_TYPE_FOR_ASSIGNMENT = "Ασύμβατη τιμή για χρήση με τον τελεστή εκχώρησης: %1$s. Αναμενόταν %2$s.";

    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_AND_FOR_NON_BOOLEAN_VALUES = "Δε μπορεί να υπολογιστεί το λογικό \"ΚΑΙ\" μη λογικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_OR_FOR_NON_BOOLEAN_VALUES = "Δε μπορεί να υπολογιστεί το λογικό \"Ή\" μη λογικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_NOT_FOR_NON_BOOLEAN_VALUE = "Δε μπορεί να υπολογιστεί το λογικό \"ΌΧΙ\" μη λογικής τιμής.";
    public final static String STR_RUNTIME_ERROR_CANNOT_CHECK_NON_COMPATIBLE_TYPES_FOR_EQUALITY = "Δε μπορεί να γίνει έλεγχος ισότητας σε τιμές ασύμβατου τύπου.";
    public final static String STR_RUNTIME_ERROR_CAN_ONLY_COMPARE_NUMERIC_TYPES_OR_STRINGS = "Η σύγκριση επιτρέπεται μόνο μεταξύ αριθμητικών τιμών ή χαρακτήρων.";
    
    public final static String STR_RUNTIME_ERROR_DIVISION_BY_ZERO = "Διαίρεση με το μηδέν.";

    public final static String STR_RUNTIME_ERROR_CANNOT_ADD_NON_NUMERIC_VALUES = "Δε μπορεί να γίνει η πρόσθεση μη αριθμητικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_SUBTRACT_NON_NUMERIC_VALUES = "Δε μπορεί να γίνει η αφαίρεση μη αριθμητικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_MULTIPLY_NON_NUMERIC_VALUES = "Δε μπορεί να γίνει ο πολλαπλασιασμός μη αριθμητικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_DIVIDE_NON_NUMERIC_VALUES = "Δε μπορεί να γίνει η διαίρεση μη αριθμητικών τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_INTDIVIDE_NON_INTEGER_VALUES = "Δε μπορεί να γίνει η ακέραια διαίρεση μη ακέραιων τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_INTMOD_NON_INTEGER_VALUES = "Δε μπορεί να υπολογιστεί το υπόλοιπο της ακέραιας διαίρεσης μη ακέραιων τιμών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_NEGATE_NON_NUMERIC_VALUE = "Δε μπορεί να υπολογιστεί ο αντίθετος μη αριθμητικής τιμής.";
    public final static String STR_RUNTIME_ERROR_CANNOT_EXPONENTIATE_NON_NUMERIC_VALUE = "Δε μπορεί να υπολογιστεί η δύναμη μη αριθμητικής τιμής.";

    public final static String STR_RUNTIME_ERROR_TANGENT_NOT_DEFINED_FOR_THIS_ANGLE = "Η εφαπτομένη δεν ορίζεται για γωνία %1$s μοιρών.";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_SQRT_FOR_A_NUMBER_THIS_BIG = "Δε μπορεί να υπολογιστεί η τιμή της Τ_Ρ(Χ) για τόσο μεγάλο Χ: %1$s.";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_SQRT_FOR_NEGATIVE_NUMBER = "Δε μπορεί να υπολογιστεί η ρίζα αρνητικού αριθμού: Τ_Ρ(%1$s).";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_LN_FOR_A_NUMBER_THIS_BIG = "Δε μπορεί να υπολογιστεί η τιμή της ΛΟΓ(Χ) για τόσο μεγάλο Χ: %1$s.";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_LN_FOR_NEGATIVE_NUMBER = "Δε μπορεί να υπολογιστεί ο φυσικός λογάριθμος αριθμού <=0: ΛΟΓ(%1$s).";
    public final static String STR_RUNTIME_ERROR_CANNOT_COMPUTE_EXP_FOR_A_NUMBER_THIS_BIG = "Δε μπορεί να υπολογιστεί η τιμή της Ε(Χ) για τόσο μεγάλο Χ: %1$s.";

    public final static String STR_RUNTIME_ERROR_INVALID_VALUE = "Μη έγκυρη τιμή.";
    public final static String STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE = "Μη έγκυρη αριθμητική τιμή: %1$s.";
    public final static String STR_RUNTIME_ERROR_INVALID_INTEGER_VALUE = "Μη έγκυρη ακέραια τιμή: %1$s.";
    public final static String STR_RUNTIME_ERROR_INVALID_REAL_VALUE = "Μη έγκυρη πραγματική τιμή: %1$s.";
    public final static String STR_RUNTIME_ERROR_INVALID_VALUE_FOR_ASSIGNMENT = "Μη έγκυρη τιμή για εκχώρηση: %1$s - χρειάζεται %2$s.";
    public final static String STR_RUNTIME_ERROR_INVALID_BUILT_IN_FUNCTION = "Ανύπαρκτη ενσωματωμένη συνάρτηση \"%1$s\".";
    public final static String STR_RUNTIME_ERROR_ARRAY_USED_AS_VALUE = "Ο πίνακας %1$s  δε μπορεί να χρησιμοποιηθεί ως τιμή παραμέτρου για τη συνάρτηση %2$s.";

    public final static String STR_RUNTIME_ERROR_ARRAY_INDICES_MUST_BE_OF_INTEGER_TYPE_AND_IN_RANGE = "Οι δείκτες σε στοιχεία πίνακα πρέπει να είναι εκφράσεις ακέραιου τύπου με τιμή στο πεδίο (0, %1$d).";

    public final static String STR_RUNTIME_ERROR_ARRAY_PARAM_AND_FORMAL_PARAM_DIMENSIONS_MISMATCH = "Οι διαστάσεις του πίνακα παραμέτρου( %1$s ) δε συμφωνούν με αυτές της δήλωσης της τυπικής παραμέτρου ( %2$s ).";
    public final static String STR_RUNTIME_ERROR_CANNOT_ASSIGN_VALUE_TO_ARRAY = "Δε μπορεί να γίνει ανάθεση τιμής σε ολόκληρο πίνακα!";
    public final static String STR_RUNTIME_ERROR_CANNOT_ASSIGN_ARRAY_TO_VAR = "Δε μπορεί να γίνει ανάθεση πίνακα σε μεταβλητή!";
    public final static String STR_RUNTIME_ERROR_FOMRAL_PARAMS_MUST_BE_VARS_OR_ARRAYS = "Ως παράμετροι μπορούν να δηλωθούν μόνο μεταβλητές και πίνακες.";
    public final static String STR_RUNTIME_ERROR_PARAMS_AND_FOMRAL_PARAMS_COUNT_MISMATCH = "Ασυμφωνία πλήθους τυπικών παραμέτρων και παραμέτρων κλήσης.";

    public static String symbolTypeToTheString(RuntimeSymbol s) {
        if (s instanceof RuntimeVariable) {
            return Messages.CONSTS_STR_THE_VARIABLE;
        } else if (s instanceof RuntimeConstant) {
            return Messages.CONSTS_STR_THE_CONSTANT;
        } else if (s instanceof RuntimeArray) {
            return Messages.CONSTS_STR_THE_ARRAY;
        } else {
            return Messages.CONSTS_STR_THE_SYMBOL;
        }
    }

}
