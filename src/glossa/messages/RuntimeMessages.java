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

    public static final String UNDEFINED_VALUE = "<απροσδιόριστη_τιμή>";
    public static final String CONST_STR_TRUE = "ΑΛΗΘΗΣ";
    public static final String CONST_STR_FALSE = "ΨΕΥΔΗΣ";

    public final static String STR_RUNTIME_ERROR_SIMPLE_SYMBOL_NOT_INITIALIZED = "%1$s \"%2$s\" δεν έχει πάρει αρχική τιμή.";
    public final static String STR_RUNTIME_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS = "Ο δείκτης %1$s προς στοιχείο του πίνακα \"%2$s\" είναι εκτός ορίων.";
    public final static String STR_RUNTIME_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH = "Το πλήθος των δεικτών (%1$d) δε συμφωνεί με τις διαστάσεις του πίνακα \"%2$s\" (%3$d).";
    public final static String STR_RUNTIME_ERROR_INVALID_TYPE_FOR_ASSIGNMENT = "Ασύμβατη τιμή για χρήση με τον τελεστή εκχώρησης: %1$s. Αναμενόταν %2$s.";

    public final static String STR_RUNTIME_ERROR_TANGENT_NOT_DEFINED_FOR_THIS_ANGLE = "Η εφαπτομένη δεν ορίζεται για γωνία %1$s μοιρών.";


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
