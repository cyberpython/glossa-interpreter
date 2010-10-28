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

grammar Glossa;

options{
	output = AST;
	ASTLabelType = CommonTree;
        backtrack = true;
}


tokens
{
  BLOCK;
  NEG;
  VARSDECL;
  IFNODE;
  ARRAY;
  ARRAY_ITEM;
  ARRAY_INDEX;
  ARRAY_DIMENSION;
  INF_RANGE;
  CASE_ELSE;
}

@lexer::header{
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

package glossa.recognizers;
import glossa.messages.*;
import java.awt.Point;
}


@lexer::members {

    private MessageLog msgLog;

    public void setMessageLog(MessageLog msgLog){
        this.msgLog = msgLog;
    }


    public Token nextToken() {
		while (true) {
			state.token = null;
			state.channel = Token.DEFAULT_CHANNEL;
			state.tokenStartCharIndex = input.index();
			state.tokenStartCharPositionInLine = input.getCharPositionInLine();
			state.tokenStartLine = input.getLine();
			state.text = null;
			if ( input.LA(1)==CharStream.EOF ) {
				return Token.EOF_TOKEN;
			}
			try {
				mTokens();
				if ( state.token==null ) {
					emit();
				}
				else if ( state.token==Token.SKIP_TOKEN ) {
					continue;
				}
				return state.token;
			}
			catch (RecognitionException re) {
				reportError(re);
				throw new RuntimeException("");
			}
		}
	}

        public void displayRecognitionError(String[] tokenNames,
                RecognitionException e) {
                String msg = getErrorMessage(e, tokenNames);
                msgLog.lexerError(new Point(e.line, e.charPositionInLine), msg);
        }


        public String getCharErrorDisplay(int c) {
		String s = String.valueOf((char)c);
		switch ( c ) {
			case Token.EOF :
				s = LexerMessages.STR_CONST_EOF;
				return s;
			case '\n' :
				s = LexerMessages.STR_CONST_NEW_LINE;
				return s;
			case '\t' :
				s = LexerMessages.STR_CONST_TAB;
				return s;
			case '\r' :
				s = LexerMessages.STR_CONST_NEW_LINE;
				return s;
                        case '\'' :
                                return "\"'\"";
		}
		return "'"+s+"'";
	}



	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
                String msg = null;
		if ( e instanceof MismatchedTokenException ) {
			MismatchedTokenException mte = (MismatchedTokenException)e;
                        msg = String.format(LexerMessages.STR_ERROR_MISMATCHED_SYMBOL, getCharErrorDisplay(mte.expecting), getCharErrorDisplay(e.c));
		}
		else if ( e instanceof NoViableAltException ) {
			msg = LexerMessages.STR_ERROR_UNKNOWN_SYMBOL+": "+getCharErrorDisplay(e.c);
		}
		else if ( e instanceof EarlyExitException ) {
			EarlyExitException eee = (EarlyExitException)e;
			msg = String.format(LexerMessages.STR_ERROR_UNEXPECTED_SYMBOL, getCharErrorDisplay(e.c));
		}
		else if ( e instanceof MismatchedNotSetException ) {
			MismatchedNotSetException mse = (MismatchedNotSetException)e;
                        msg = String.format(LexerMessages.STR_ERROR_MISMATCHED_SYMBOL, mse.expecting, getCharErrorDisplay(e.c));
		}
		else if ( e instanceof MismatchedSetException ) {
			MismatchedSetException mse = (MismatchedSetException)e;
                        msg = String.format(LexerMessages.STR_ERROR_MISMATCHED_SYMBOL, mse.expecting, getCharErrorDisplay(e.c));
		}
		else if ( e instanceof MismatchedRangeException ) {
			MismatchedRangeException mre = (MismatchedRangeException)e;
                        msg = String.format(LexerMessages.STR_ERROR_MISMATCHED_SYMBOL, getCharErrorDisplay(mre.a)+".."+getCharErrorDisplay(mre.b), getCharErrorDisplay(e.c));
		}
		else {
			msg = super.getErrorMessage(e, tokenNames);
		}
		return msg;
	}

}

@header{
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

package glossa.recognizers;
import glossa.messages.*;
import java.awt.Point;
}


@members{

        private MessageLog msgLog;

        public void setMessageLog(MessageLog msgLog){
            this.msgLog = msgLog;
        }

        public void displayRecognitionError(String[] tokenNames,
            RecognitionException e) {
            String msg = getErrorMessage(e, tokenNames);
            msgLog.parserError(new Point(e.line, e.charPositionInLine), msg);
        }

        public String getTokenErrorDisplay(Token t) {
                if((t!=null)&&(t.getType()==EOF)){
                    return ParserMessages.STR_CONST_EOF;
                }
		String s = t.getText();
                if(s!=null){
                    if(s.equals("\n")){
                        return ParserMessages.STR_CONST_NEW_LINE;
                    }
                }
		return super.getTokenErrorDisplay(t);
	}


        public String getErrorMessage(RecognitionException e, String[] tokenNames) {
		String msg = e.getMessage();
		if ( e instanceof UnwantedTokenException ) {
			UnwantedTokenException ute = (UnwantedTokenException)e;
			String tokenName = ParserMessages.tokenNameToString(tokenNames[ute.expecting]);
                        msg = String.format(ParserMessages.STR_ERROR_PARSER_MISSING_TOKEN_BEFORE_THIS, tokenName, getTokenErrorDisplay(ute.getUnexpectedToken()));
		}
		else if ( e instanceof MissingTokenException ) {
			MissingTokenException mte = (MissingTokenException)e;
			String tokenName = ParserMessages.tokenNameToString(tokenNames[mte.expecting]);
			msg = String.format(ParserMessages.STR_ERROR_PARSER_MISSING_TOKEN_BEFORE_THIS, tokenName);
		}
		else if ( e instanceof MismatchedTokenException ) {
			MismatchedTokenException mte = (MismatchedTokenException)e;
			String tokenName = ParserMessages.tokenNameToString(tokenNames[mte.expecting]);
			msg = String.format(ParserMessages.STR_ERROR_PARSER_EXPECTING, tokenName, getTokenErrorDisplay(e.token));
		}
		else if ( e instanceof MismatchedTreeNodeException ) {
			msg = ParserMessages.STR_ERROR_PARSER_ERROR;
		}
		else if ( e instanceof NoViableAltException ) {
			msg = String.format(ParserMessages.STR_ERROR_PARSER_PROBLEM_NEAR, getTokenErrorDisplay(e.token));
		}
		else if ( e instanceof EarlyExitException ) {
			msg = String.format(ParserMessages.STR_ERROR_PARSER_EARLY_EXIT, getTokenErrorDisplay(e.token));
		}
		else if ( e instanceof MismatchedSetException ) {
			msg = ParserMessages.STR_ERROR_PARSER_ERROR;
		}
		else if ( e instanceof MismatchedNotSetException ) {
			msg = ParserMessages.STR_ERROR_PARSER_ERROR;
		}
		else if ( e instanceof FailedPredicateException ) {
			msg = ParserMessages.STR_ERROR_PARSER_ERROR;
		}
		return msg;
	}
}

/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	PROGRAM^ id1=ID (NEWLINE!)+
		declarations
		BEGIN!  (NEWLINE!)+
		block
		END_PROGRAM! (id2=ID)? (NEWLINE!)+;
		
declarations
	:	constDecl? varDecl?;
		
constDecl
	:	CONSTANTS^ (NEWLINE!)+ constAssign*;

constAssign
	:	ID EQ^ expr (NEWLINE!)+;
	
varDecl	:	VARIABLES^ (NEWLINE!)+ varsDecl*;
	
varsDecl
	:	varType^ COLON! varDeclItem (COMMA! varDeclItem)* (NEWLINE!)+;

varDeclItem
	:	ID 
	| 	ID arrayDimension -> ^(ARRAY ID arrayDimension);

arrayDimension
	:	LBRACKET (dimension+=expr) (COMMA dimension+=expr)* RBRACKET -> ^(ARRAY_DIMENSION expr+);
	
varType	:	BOOLEANS
	|	STRINGS
	|	INTEGERS
	|	REALS;
		
block	:	stm*  -> ^(BLOCK stm*);

stm	:	printStm
        |       readStm
	|	assingmentStm
        |       ifStm
        |       caseStm
        |       forStm
        |       whileStm
        |       repeatStm
        ;
	
printStm
        :	PRINT^ (expr ( ','! expr )*)? (NEWLINE!)+;

readStm :
                READ^ readItem (COMMA! readItem)* (NEWLINE!)+
        ;

readItem:
                arrId=ID arraySubscript
        |       varId=ID
        ;
	
assingmentStm
	:	varId=ID ASSIGN^ varValue=expr (NEWLINE!)+
        |       arrId=ID arraySubscript ASSIGN^ arrItemValue=expr (NEWLINE!)+
        ;

ifStm	:	ifBlock elseIfBlock* elseBlock? END_IF (NEWLINE)+ -> ^(IFNODE ifBlock elseIfBlock* elseBlock?);

ifBlock	:	IF^ expr THEN! (NEWLINE!)+ block;

elseBlock
	:	ELSE^ (NEWLINE!)+ block;

elseIfBlock
	:	ELSE_IF^ expr THEN! (NEWLINE!)+ block;

caseStm	:	SWITCH^ expr (NEWLINE!)+ caseBlock* caseElseBlock? END_SWITCH! (NEWLINE!)+;

caseBlock
	:	CASE^ caseExprList (NEWLINE!)+ block;

caseExprList
	:	caseExprListItem (COMMA! caseExprListItem)*;

caseExprListItem
	:	 rangeItem | expr | infRangeItem;

rangeItem
        :       expr1=expr RANGE expr2=expr -> ^(RANGE $expr1 $expr2);

infRangeItem
        :       LT expr -> ^(INF_RANGE LT expr)
        |       LE expr -> ^(INF_RANGE LE expr)
        |       GT expr -> ^(INF_RANGE GT expr)
        |       GE expr -> ^(INF_RANGE GE expr)
        ;

caseElseBlock
	:	CASE ELSE NEWLINE+ block -> ^(CASE_ELSE block);

forStm	:	FOR^ ID FROM! from=expr TO! to=expr (STEP! step=expr)? (NEWLINE!)+ block END_LOOP! (NEWLINE!)+;

whileStm
        :	WHILE^ expr LOOP! (NEWLINE!)+ block END_LOOP! (NEWLINE!)+;

repeatStm
	:	REPEAT^ (NEWLINE!)+ block UNTIL! expr (NEWLINE!)+;
	
expr	:	andExpr ( OR^ andExpr)*;

andExpr :       eqExpr (AND^ eqExpr)*;

eqExpr	:	compExpr (EQ^ compExpr | NEQ^ compExpr )*	;

compExpr:	addExpr (LT^ addExpr | LE^ addExpr | GT^ addExpr | GE^ addExpr  )*	;

addExpr	:	multExpr (PLUS^ multExpr | MINUS^ multExpr )*	;

multExpr	:	powExpr (TIMES^ powExpr | DIA^ powExpr | DIV^ powExpr | MOD^ powExpr )*	;

powExpr	:	unaryExpr (POW^ unaryExpr)*;

unaryExpr
	:	PLUS! atom
	|	MINUS atom -> ^(NEG atom)
	|	NOT atom -> ^(NOT atom)
	|	atom;


atom	:	CONST_TRUE
	|	CONST_FALSE
	|	CONST_STR
	|	CONST_INT
	|	CONST_REAL
	|	arrayItem
	|	ID
	|	'('! expr ')'!;
	
	
arrayItem
	:	ID arraySubscript -> ^(ARRAY_ITEM ID arraySubscript);
	
arraySubscript
	:	LBRACKET (dimension+=expr) (COMMA dimension+=expr)* RBRACKET -> ^(ARRAY_INDEX expr+);


/*
**************************
*	Tokens:
**************************
*/

ASSIGN
	:	'<-' | '\u2190';
	
COMMA	:	',';

COLON	:	':';

LPAR	:	'(';

RPAR	:	')';

LBRACKET:	'[';

RBRACKET:	']';

PLUS	:	'+';

MINUS	:	'-';

TIMES	:	'*';

DIA	:	'/';

POW	:	'^';

DIV	:	('D'|'d')('I'|'i')('V'|'v');

MOD	:	('M'|'m')('O'|'o')('D'|'d');

LE	:	'<=' | '\u2264';

LT	:	'<';

GE	:	'>=' | '\u2265';

GT	:	'>';

EQ	:	'=';

NEQ	:	'<>' | '\u2260';


AND	:	KAPPA ALPHA IOTA;

OR	:	ETA_TONOS;

NOT	:	(OMICRON|OMICRON_TONOS) CHI IOTA;

RANGE   :       '..';


PROGRAM :	 PI RHO (OMICRON | OMICRON_TONOS) GAMMA RHO ALPHA MU MU ALPHA;
	
END_PROGRAM
	:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' PI RHO OMICRON GAMMA RHO (ALPHA | ALPHA_TONOS) MU MU ALPHA TAU OMICRON SIGMA_TELIKO;
	
VARIABLES
	:	MU EPSILON TAU ALPHA BETA LAMDA ETA TAU (EPSILON | EPSILON_TONOS) SIGMA_TELIKO;

CONSTANTS
	:	SIGMA TAU ALPHA THETA EPSILON RHO (EPSILON|EPSILON_TONOS) SIGMA_TELIKO;

READ	:	DELTA IOTA (ALPHA | ALPHA_TONOS) BETA ALPHA SIGMA EPSILON;

PRINT	:	GAMMA RHO (ALPHA | ALPHA_TONOS) PSI EPSILON;

BEGIN	:	ALPHA RHO CHI (ETA | ETA_TONOS);

PROCEDURE
	:	DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA (IOTA|IOTA_TONOS) ALPHA;
	
END_PROCEDURE
	:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA (IOTA|IOTA_TONOS) ALPHA SIGMA_TELIKO;

FUNCTION:	SIGMA UPSILON NU (ALPHA|ALPHA_TONOS) RHO TAU ETA SIGMA ETA;

END_FUNCTION
	:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' SIGMA UPSILON NU (ALPHA|ALPHA_TONOS) RHO TAU ETA SIGMA ETA SIGMA_TELIKO;
	
CALL	:	KAPPA (ALPHA|ALPHA_TONOS) LAMDA EPSILON SIGMA EPSILON;


IF	:	ALPHA NU;

THEN	:	TAU (OMICRON | OMICRON_TONOS) TAU EPSILON;

ELSE	:	ALPHA LAMDA LAMDA IOTA (OMEGA | OMEGA_TONOS) SIGMA_TELIKO;

ELSE_IF	:	ALPHA LAMDA LAMDA IOTA (OMEGA | OMEGA_TONOS) SIGMA_TELIKO '_' ALPHA NU;

END_IF	:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' ALPHA NU;




SWITCH	:	EPSILON PI (IOTA|IOTA_TONOS) LAMDA EPSILON XI EPSILON;

CASE	:	PI EPSILON RHO (IOTA|IOTA_TONOS) PI TAU OMEGA SIGMA ETA;

END_SWITCH
	:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI IOTA LAMDA OMICRON GAMMA (OMEGA|OMEGA_TONOS) NU;



WHILE	:	(OMICRON|OMICRON_TONOS) SIGMA OMICRON;

LOOP	:	EPSILON PI ALPHA NU (ALPHA|ALPHA_TONOS) LAMDA ALPHA BETA EPSILON;

END_LOOP:	TAU (EPSILON|EPSILON_TONOS) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI ALPHA NU (ALPHA|ALPHA_TONOS) LAMDA ETA PSI ETA SIGMA_TELIKO;



REPEAT	:	ALPHA RHO CHI (ETA|ETA_TONOS) '_' EPSILON PI ALPHA NU (ALPHA|ALPHA_TONOS) LAMDA ETA PSI ETA SIGMA_TELIKO;

UNTIL	:	MU (EPSILON|EPSILON_TONOS) CHI RHO IOTA SIGMA_TELIKO '_' (OMICRON|OMICRON_TONOS) TAU OMICRON UPSILON;


FOR	:	GAMMA IOTA ALPHA;

FROM	:	ALPHA PI (OMICRON|OMICRON_TONOS);

TO	:	MU (EPSILON|EPSILON_TONOS) CHI RHO IOTA;

STEP	:	MU EPSILON ( '_' | (' '|'\t')+  ) BETA (ETA|ETA_TONOS) MU ALPHA;



INTEGER	:	ALPHA KAPPA (EPSILON|EPSILON_TONOS) RHO ALPHA IOTA ALPHA;

INTEGERS:	ALPHA KAPPA (EPSILON|EPSILON_TONOS) RHO ALPHA IOTA EPSILON SIGMA_TELIKO;

REAL	:	PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA (ETA|ETA_TONOS);

REALS	:	PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA (EPSILON|EPSILON_TONOS) SIGMA_TELIKO;

STRING	:	CHI ALPHA RHO ALPHA KAPPA TAU (ETA|ETA_TONOS) RHO ALPHA SIGMA_TELIKO;

STRINGS	:	CHI ALPHA RHO ALPHA KAPPA TAU (ETA|ETA_TONOS) RHO EPSILON SIGMA_TELIKO;

BOOLEAN	:	LAMDA OMICRON GAMMA IOTA KAPPA (ETA|ETA_TONOS);

BOOLEANS	:	LAMDA OMICRON GAMMA IOTA KAPPA (EPSILON|EPSILON_TONOS) SIGMA_TELIKO;






CONST_TRUE
	:	ALPHA LAMDA ETA THETA (ETA|ETA_TONOS) SIGMA_TELIKO;
	
CONST_FALSE
	:	PSI EPSILON UPSILON DELTA (ETA|ETA_TONOS) SIGMA_TELIKO;
	
CONST_STR
	:	'\'' .* '\'' | '"' .* '"' ;

CONST_INT
	:	DIGIT+;
	
CONST_REAL
	:	DIGIT+ '.' DIGIT+;

ID	:	LETTER (LETTER|DIGIT|'_')*;

COMMENT	:	'!' NOT_EOL* {skip();};

CONT_COMMAND
	:	NEWLINE '&'{skip();};

NEWLINE	:	'\r'? '\n';

WS	:	(' '|'\t')+ {skip();};




/*
**************************
*	Fragments:
**************************
*/

fragment DIGIT
	:	'0'..'9';

fragment LETTER
	:	LATIN_LETTER|GREEK_LETTER;


fragment LATIN_LETTER
	:	'a'..'z' | 'A'..'Z';


fragment GREEK_LETTER
	:	ALPHA | BETA | GAMMA | DELTA | EPSILON | ZETA | ETA | THETA
	|	IOTA | KAPPA | LAMDA | MU | NU | XI | OMICRON | PI | RHO | SIGMA
	|	TAU | UPSILON | PHI | CHI | PSI | OMEGA | SIGMA_TELIKO
	| 	ALPHA_TONOS | EPSILON_TONOS | ETA_TONOS | IOTA_TONOS | UPSILON_TONOS
	|	OMICRON_TONOS | OMEGA_TONOS | IOTA_DIALYTIKA | UPSILON_DIALYTIKA
	|	IOTA_DIALYTIKA_TONOS | UPSILON_DIALYTIKA_TONOS ;

fragment ALPHA
	:	'\u03B1'|'\u0391';
fragment BETA
	:	'\u03B2'|'\u0392';
fragment GAMMA
	:	'\u03B3'|'\u0393';
fragment DELTA
	:	'\u03B4'|'\u0394';
fragment EPSILON
	:	'\u03B5'|'\u0395';
fragment ZETA
	:	'\u03B6'|'\u0396';
fragment ETA
	:	'\u03B7'|'\u0397';
fragment THETA
	:	'\u03B8'|'\u0398';
fragment IOTA
	:	'\u03B9'|'\u0399';
fragment KAPPA
	:	'\u03BA'|'\u039A';
fragment LAMDA
	:	'\u03BB'|'\u039B';
fragment MU
	:	'\u03BC'|'\u039C';
fragment NU
	:	'\u03BD'|'\u039D';
fragment XI
	:	'\u03BE'|'\u039E';
fragment OMICRON
	:	'\u03BF'|'\u039F';
fragment PI
	:	'\u03C0'|'\u03A0';
fragment RHO
	:	'\u03C1'|'\u03A1';
fragment SIGMA
	:	'\u03C3'|'\u03A3';
fragment TAU
	:	'\u03C4'|'\u03A4';
fragment UPSILON
	:	'\u03C5'|'\u03A5';
fragment PHI
	:	'\u03C6'|'\u03A6';
fragment CHI
	:	'\u03C7'|'\u03A7';
fragment PSI
	:	'\u03C8'|'\u03A8';
fragment OMEGA
	:	'\u03C9'|'\u03A9';
fragment SIGMA_TELIKO
	:	'\u03C2'|'\u03A3';	
fragment ALPHA_TONOS
	:	'\u03AC'|'\u0386';
fragment EPSILON_TONOS
	:	'\u03AD'|'\u0388';
fragment ETA_TONOS
	:	'\u03AE'|'\u0389';
fragment IOTA_TONOS
	:	'\u03AF'|'\u038A';
fragment UPSILON_TONOS
	:	'\u03CD'|'\u038E';
fragment OMICRON_TONOS
	:	'\u03CC'|'\u038C';
fragment OMEGA_TONOS
	:	'\u03CE'|'\u038F';
fragment IOTA_DIALYTIKA
	:	'\u03CA'|'\u03AA';
fragment UPSILON_DIALYTIKA
	:	'\u03CB'|'\u03AB';
fragment IOTA_DIALYTIKA_TONOS
	:	'\u0390';
fragment UPSILON_DIALYTIKA_TONOS
	:	'\u03B0';
	
	
fragment NOT_EOL
	:	('\u0000'..'\u0009') | '\u000B' | '\u000C'| ('\u000E'..'\uFFFF') ;
	
	
	
