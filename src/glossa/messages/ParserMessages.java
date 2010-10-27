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

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class ParserMessages {

    public final static String STR_CONST_NEW_LINE = "'αλλαγή γραμμής'";
    public final static String STR_CONST_EOF = "τέλος αρχείου";
    public final static String STR_ERROR_PARSER_ERROR = "Συντακτικό σφάλμα.";
    public final static String STR_ERROR_PARSER_EXTRANEOUS_TOKEN_BEFORE_THIS = "Αναμενόταν: %1$s. Βρέθηκε ενώ δε χρειάζεται: %2$s.";
    public final static String STR_ERROR_PARSER_MISSING_TOKEN_BEFORE_THIS = "Λείπει το: %1$s.";
    public final static String STR_ERROR_PARSER_PROBLEM_NEAR = "Λάθος πριν/μετά το: %1$s.";
    public final static String STR_ERROR_PARSER_EARLY_EXIT = "Βρέθηκε πρόωρα: %1$s.";
    public final static String STR_ERROR_PARSER_EXPECTING = "Αναμενόταν: %1$s. Βρέθηκε: %2$s.";


    public static String tokenNameToString(String tokenName) {
        if (tokenName.equals("EOF")) {
            return "'ΤΕΛΟΣ ΑΡΧΕΙΟΥ'";
        }else if (tokenName.equals("NEG")) {
            return "'-'";
        } else if (tokenName.equals("INF_RANGE")) {
            return "ΤΕΛΕΣΤΗΣ ΣΥΓΚΡΙΣΗΣ ('<'/'<='/'>'/'>=') ΠΕΡΙΠΤΩΣΗΣ";
        } else if (tokenName.equals("CASE_ELSE")) {
            return "'ΠΕΡΙΠΤΩΣΗ ΑΛΛΙΩΣ'";
        } else if (tokenName.equals("PROGRAM")) {
	     return "'ΠΡΟΓΡΑΜΜΑ'";
        } else if (tokenName.equals("ID")) {
	     return "'ΑΝΑΓΝΩΡΙΣΤΙΚΟ'";
        } else if (tokenName.equals("NEWLINE")) {
	     return "'ΑΛΛΑΓΗ ΓΡΑΜΜΗΣ'";
        } else if (tokenName.equals("BEGIN")) {
	     return "'ΑΡΧΗ'";
        } else if (tokenName.equals("END_PROGRAM")) {
	     return "'ΤΕΛΟΣ_ΠΡΟΓΡΑΜΜΑΤΟΣ'";
        } else if (tokenName.equals("CONSTANTS")) {
	     return "'ΣΤΑΘΕΡΕΣ'";
        } else if (tokenName.equals("EQ")) {
	     return "'='";
        } else if (tokenName.equals("VARIABLES")) {
	     return "'ΜΕΤΑΒΛΗΤΕΣ'";
        } else if (tokenName.equals("COLON")) {
	     return "':'";
        } else if (tokenName.equals("COMMA")) {
	     return "','";
        } else if (tokenName.equals("LBRACKET")) {
	     return "'['";
        } else if (tokenName.equals("RBRACKET")) {
	     return "']'";
        } else if (tokenName.equals("BOOLEANS")) {
	     return "'ΛΟΓΙΚΕΣ'";
        } else if (tokenName.equals("STRINGS")) {
	     return "'ΧΑΡΑΚΤΗΡΕΣ'";
        } else if (tokenName.equals("INTEGERS")) {
	     return "'ΑΚΕΡΑΙΕΣ'";
        } else if (tokenName.equals("REALS")) {
	     return "'ΠΡΑΓΜΑΤΙΚΕΣ'";
        } else if (tokenName.equals("PRINT")) {
	     return "'ΓΡΑΨΕ'";
        } else if (tokenName.equals("READ")) {
	     return "'ΔΙΑΒΑΣΕ'";
        } else if (tokenName.equals("ASSIGN")) {
	     return "'<-'";
        } else if (tokenName.equals("END_IF")) {
	     return "'ΤΕΛΟΣ_ΑΝ'";
        } else if (tokenName.equals("IF")) {
	     return "'ΑΝ'";
        } else if (tokenName.equals("THEN")) {
	     return "'ΤΟΤΕ'";
        } else if (tokenName.equals("ELSE")) {
	     return "'ΑΛΛΙΩΣ'";
        } else if (tokenName.equals("ELSE_IF")) {
	     return "'ΑΛΛΙΩΣ_ΑΝ'";
        } else if (tokenName.equals("SWITCH")) {
	     return "'ΕΠΙΛΕΞΕ'";
        } else if (tokenName.equals("END_SWITCH")) {
	     return "'ΤΕΛΟΣ_ΕΠΙΛΟΓΩΝ'";
        } else if (tokenName.equals("CASE")) {
	     return "'ΠΕΡΙΠΤΩΣΗ'";
        } else if (tokenName.equals("RANGE")) {
	     return "'..'";
        } else if (tokenName.equals("LT")) {
	     return "'<'";
        } else if (tokenName.equals("LE")) {
	     return "'<='";
        } else if (tokenName.equals("GT")) {
	     return "'>'";
        } else if (tokenName.equals("GE")) {
	     return "'>='";
        } else if (tokenName.equals("FOR")) {
	     return "'ΓΙΑ'";
        } else if (tokenName.equals("FROM")) {
	     return "'ΑΠΟ'";
        } else if (tokenName.equals("TO")) {
	     return "'ΜΕΧΡΙ'";
        } else if (tokenName.equals("STEP")) {
	     return "'ΜΕ_ΒΗΜΑ'";
        } else if (tokenName.equals("END_LOOP")) {
	     return "'ΤΕΛΟΣ_ΕΠΑΝΑΛΗΨΗΣ'";
        } else if (tokenName.equals("WHILE")) {
	     return "'ΌΣΟ'";
        } else if (tokenName.equals("LOOP")) {
	     return "'ΕΠΑΝΑΛΑΒΕ'";
        } else if (tokenName.equals("REPEAT")) {
	     return "'ΑΡΧΗ_ΕΠΑΝΑΛΗΨΗΣ'";
        } else if (tokenName.equals("UNTIL")) {
	     return "'ΜΕΧΡΙΣ_ΌΤΟΥ'";
        } else if (tokenName.equals("OR")) {
	     return "'Ή'";
        } else if (tokenName.equals("AND")) {
	     return "'ΚΑΙ'";
        } else if (tokenName.equals("NEQ")) {
	     return "'<>'";
        } else if (tokenName.equals("PLUS")) {
	     return "'+'";
        } else if (tokenName.equals("MINUS")) {
	     return "'-'";
        } else if (tokenName.equals("TIMES")) {
	     return "'*'";
        } else if (tokenName.equals("DIA")) {
	     return "'/'";
        } else if (tokenName.equals("DIV")) {
	     return "'DIV'";
        } else if (tokenName.equals("MOD")) {
	     return "'MOD'";
        } else if (tokenName.equals("POW")) {
	     return "'^'";
        } else if (tokenName.equals("NOT")) {
	     return "'ΌΧΙ'";
        } else if (tokenName.equals("CONST_TRUE")) {
	     return "'ΑΛΗΘΗΣ'";
        } else if (tokenName.equals("CONST_FALSE")) {
	     return "'ΨΕΥΔΗΣ'";
        } else if (tokenName.equals("CONST_STR")) {
	     return "ΣΤΑΘΕΡΑ ΤΥΠΟΥ 'ΧΑΡΑΚΤΗΡΕΣ'";
        } else if (tokenName.equals("CONST_INT")) {
	     return "ΣΤΑΘΕΡΑ ΤΥΠΟΥ 'ΑΚΕΡΑΙΑ'";
        } else if (tokenName.equals("CONST_REAL")) {
	     return "ΣΤΑΘΕΡΑ ΤΥΠΟΥ 'ΠΡΑΓΜΑΤΙΚΗ'";
        } else if (tokenName.equals("LPAR")) {
	     return "'('";
        } else if (tokenName.equals("RPAR")) {
	     return "')'";
        } else if (tokenName.equals("PROCEDURE")) {
	     return "'ΔΙΑΔΙΚΑΣΙΑ'";
        } else if (tokenName.equals("END_PROCEDURE")) {
	     return "'ΤΕΛΟΣ_ΔΙΑΔΙΚΑΣΙΑΣ'";
        } else if (tokenName.equals("FUNCTION")) {
	     return "'ΣΥΝΑΡΤΗΣΗ'";
        } else if (tokenName.equals("END_FUNCTION")) {
	     return "'ΤΕΛΟΣ_ΣΥΝΑΡΤΗΣΗΣ'";
        } else if (tokenName.equals("CALL")) {
	     return "'ΚΑΛΕΣΕ'";
        } else if (tokenName.equals("INTEGER")) {
	     return "'ΑΚΕΡΑΙΑ'";
        } else if (tokenName.equals("REAL")) {
	     return "'ΠΡΑΓΜΑΤΙΚΗ'";
        } else if (tokenName.equals("STRING")) {
	     return "'ΧΑΡΑΚΤΗΡΑΣ'";
        } else if (tokenName.equals("BOOLEAN")) {
	     return "'ΛΟΓΙΚΗ'";
        } else if (tokenName.equals("DIGIT")) {
	     return "'ΨΗΦΙΟ'";
        } else if (tokenName.equals("LETTER")) {
	     return "'ΓΡΑΜΜΑ'";
        } else if (tokenName.equals("COMMENT")) {
	     return "ΣΧΟΛΙΟ";
        } else if (tokenName.equals("CONT_COMMAND")) {
	     return "'&'";
        }
        return tokenName;
    }

}
