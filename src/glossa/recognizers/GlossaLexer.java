// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/Glossa.g 2010-11-04 16:57:13

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GlossaLexer extends Lexer {
    public static final int FUNCTION=76;
    public static final int LT=45;
    public static final int END_PROCEDURE=107;
    public static final int WHILE=54;
    public static final int LETTER=115;
    public static final int MOD=66;
    public static final int LAMDA=96;
    public static final int STRINGS=30;
    public static final int UPSILON_DIALYTIKA_TONOS=128;
    public static final int CASE=43;
    public static final int NOT=68;
    public static final int OMICRON=86;
    public static final int EOF=-1;
    public static final int FUNC_CALL=15;
    public static final int LBRACKET=27;
    public static final int MU=92;
    public static final int TAU=93;
    public static final int POW=67;
    public static final int LPAR=74;
    public static final int UPSILON_TONOS=124;
    public static final int CONT_COMMAND=118;
    public static final int CONST_INT=72;
    public static final int LOOP=55;
    public static final int BEGIN=20;
    public static final int KAPPA=82;
    public static final int EQ=23;
    public static final int COMMENT=117;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=121;
    public static final int END_LOOP=53;
    public static final int GE=48;
    public static final int END_SWITCH=42;
    public static final int CONST_TRUE=69;
    public static final int NU=109;
    public static final int XI=113;
    public static final int SWITCH=41;
    public static final int ELSE=39;
    public static final int DELTA=103;
    public static final int EPSILON=94;
    public static final int CONST_STR=71;
    public static final int INTEGERS=31;
    public static final int ALPHA=83;
    public static final int SIGMA_TELIKO=97;
    public static final int REAL=79;
    public static final int FORMAL_PARAMS=16;
    public static final int THETA=102;
    public static final int BOOLEANS=29;
    public static final int UPSILON_DIALYTIKA=126;
    public static final int WS=119;
    public static final int EPSILON_TONOS=95;
    public static final int OMICRON_TONOS=87;
    public static final int READ=34;
    public static final int OMEGA=111;
    public static final int UNTIL=57;
    public static final int OR=58;
    public static final int GT=47;
    public static final int ALPHA_TONOS=98;
    public static final int REPEAT=56;
    public static final int CALL=110;
    public static final int PI=89;
    public static final int FROM=50;
    public static final int PHI=123;
    public static final int RHO=90;
    public static final int UPSILON=108;
    public static final int FOR=49;
    public static final int STEP=52;
    public static final int ETA_TONOS=85;
    public static final int CONSTANTS=22;
    public static final int ID=19;
    public static final int AND=59;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=37;
    public static final int OMEGA_TONOS=112;
    public static final int NOT_EOL=116;
    public static final int BOOLEAN=81;
    public static final int THEN=38;
    public static final int END_FUNCTION=77;
    public static final int COMMA=26;
    public static final int ETA=100;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=104;
    public static final int PLUS=61;
    public static final int SIGMA=101;
    public static final int DIGIT=114;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=28;
    public static final int IOTA_DIALYTIKA_TONOS=127;
    public static final int ELSE_IF=40;
    public static final int CONST_REAL=73;
    public static final int VARSDECL=6;
    public static final int PARAMS=14;
    public static final int INTEGER=78;
    public static final int INF_RANGE=12;
    public static final int TO=51;
    public static final int LATIN_LETTER=120;
    public static final int REALS=32;
    public static final int RANGE=44;
    public static final int CHI=88;
    public static final int MINUS=62;
    public static final int DIA=64;
    public static final int BETA=99;
    public static final int PRINT=33;
    public static final int PROCEDURE=106;
    public static final int COLON=25;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=60;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=21;
    public static final int ZETA=122;
    public static final int CONST_FALSE=70;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=24;
    public static final int ASSIGN=35;
    public static final int END_IF=36;
    public static final int RPAR=75;
    public static final int PROGRAM=18;
    public static final int IOTA=84;
    public static final int DIV=65;
    public static final int GAMMA=91;
    public static final int TIMES=63;
    public static final int LE=46;
    public static final int IOTA_DIALYTIKA=125;
    public static final int STRING=80;
    public static final int IOTA_TONOS=105;


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



    // delegates
    // delegators

    public GlossaLexer() {;} 
    public GlossaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GlossaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/glossa/grammars/Glossa.g"; }

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:458:2: ( '<-' | '\\u2190' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='<') ) {
                alt1=1;
            }
            else if ( (LA1_0=='\u2190') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:458:4: '<-'
                    {
                    match("<-"); 


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:458:11: '\\u2190'
                    {
                    match('\u2190'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:460:7: ( ',' )
            // src/glossa/grammars/Glossa.g:460:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:462:7: ( ':' )
            // src/glossa/grammars/Glossa.g:462:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:464:6: ( '(' )
            // src/glossa/grammars/Glossa.g:464:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:466:6: ( ')' )
            // src/glossa/grammars/Glossa.g:466:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:468:9: ( '[' )
            // src/glossa/grammars/Glossa.g:468:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:470:9: ( ']' )
            // src/glossa/grammars/Glossa.g:470:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:472:6: ( '+' )
            // src/glossa/grammars/Glossa.g:472:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:474:7: ( '-' )
            // src/glossa/grammars/Glossa.g:474:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "TIMES"
    public final void mTIMES() throws RecognitionException {
        try {
            int _type = TIMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:476:7: ( '*' )
            // src/glossa/grammars/Glossa.g:476:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TIMES"

    // $ANTLR start "DIA"
    public final void mDIA() throws RecognitionException {
        try {
            int _type = DIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:478:5: ( '/' )
            // src/glossa/grammars/Glossa.g:478:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIA"

    // $ANTLR start "POW"
    public final void mPOW() throws RecognitionException {
        try {
            int _type = POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:480:5: ( '^' )
            // src/glossa/grammars/Glossa.g:480:7: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POW"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:482:5: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' ) )
            // src/glossa/grammars/Glossa.g:482:7: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:484:5: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // src/glossa/grammars/Glossa.g:484:7: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:486:4: ( '<=' | '\\u2264' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='<') ) {
                alt2=1;
            }
            else if ( (LA2_0=='\u2264') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:486:6: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:486:13: '\\u2264'
                    {
                    match('\u2264'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:488:4: ( '<' )
            // src/glossa/grammars/Glossa.g:488:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:490:4: ( '>=' | '\\u2265' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='>') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\u2265') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:490:6: '>='
                    {
                    match(">="); 


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:490:13: '\\u2265'
                    {
                    match('\u2265'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:492:4: ( '>' )
            // src/glossa/grammars/Glossa.g:492:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:494:4: ( '=' )
            // src/glossa/grammars/Glossa.g:494:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:496:5: ( '<>' | '\\u2260' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='<') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\u2260') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:496:7: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:496:14: '\\u2260'
                    {
                    match('\u2260'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:499:5: ( KAPPA ALPHA IOTA )
            // src/glossa/grammars/Glossa.g:499:7: KAPPA ALPHA IOTA
            {
            mKAPPA(); 
            mALPHA(); 
            mIOTA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:501:4: ( ETA_TONOS )
            // src/glossa/grammars/Glossa.g:501:6: ETA_TONOS
            {
            mETA_TONOS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:503:5: ( ( OMICRON | OMICRON_TONOS ) CHI IOTA )
            // src/glossa/grammars/Glossa.g:503:7: ( OMICRON | OMICRON_TONOS ) CHI IOTA
            {
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mCHI(); 
            mIOTA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:505:9: ( '..' )
            // src/glossa/grammars/Glossa.g:505:17: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:508:9: ( PI RHO ( OMICRON | OMICRON_TONOS ) GAMMA RHO ALPHA MU MU ALPHA )
            // src/glossa/grammars/Glossa.g:508:12: PI RHO ( OMICRON | OMICRON_TONOS ) GAMMA RHO ALPHA MU MU ALPHA
            {
            mPI(); 
            mRHO(); 
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mGAMMA(); 
            mRHO(); 
            mALPHA(); 
            mMU(); 
            mMU(); 
            mALPHA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "END_PROGRAM"
    public final void mEND_PROGRAM() throws RecognitionException {
        try {
            int _type = END_PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:511:2: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' PI RHO OMICRON GAMMA RHO ( ALPHA | ALPHA_TONOS ) MU MU ALPHA TAU OMICRON SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:511:4: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' PI RHO OMICRON GAMMA RHO ( ALPHA | ALPHA_TONOS ) MU MU ALPHA TAU OMICRON SIGMA_TELIKO
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mPI(); 
            mRHO(); 
            mOMICRON(); 
            mGAMMA(); 
            mRHO(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mMU(); 
            mMU(); 
            mALPHA(); 
            mTAU(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_PROGRAM"

    // $ANTLR start "VARIABLES"
    public final void mVARIABLES() throws RecognitionException {
        try {
            int _type = VARIABLES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:514:2: ( MU EPSILON TAU ALPHA BETA LAMDA ETA TAU ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:514:4: MU EPSILON TAU ALPHA BETA LAMDA ETA TAU ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO
            {
            mMU(); 
            mEPSILON(); 
            mTAU(); 
            mALPHA(); 
            mBETA(); 
            mLAMDA(); 
            mETA(); 
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLES"

    // $ANTLR start "CONSTANTS"
    public final void mCONSTANTS() throws RecognitionException {
        try {
            int _type = CONSTANTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:517:2: ( SIGMA TAU ALPHA THETA EPSILON RHO ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:517:4: SIGMA TAU ALPHA THETA EPSILON RHO ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO
            {
            mSIGMA(); 
            mTAU(); 
            mALPHA(); 
            mTHETA(); 
            mEPSILON(); 
            mRHO(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTANTS"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:519:6: ( DELTA IOTA ( ALPHA | ALPHA_TONOS ) BETA ALPHA SIGMA EPSILON )
            // src/glossa/grammars/Glossa.g:519:8: DELTA IOTA ( ALPHA | ALPHA_TONOS ) BETA ALPHA SIGMA EPSILON
            {
            mDELTA(); 
            mIOTA(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mBETA(); 
            mALPHA(); 
            mSIGMA(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "PRINT"
    public final void mPRINT() throws RecognitionException {
        try {
            int _type = PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:521:7: ( GAMMA RHO ( ALPHA | ALPHA_TONOS ) PSI EPSILON )
            // src/glossa/grammars/Glossa.g:521:9: GAMMA RHO ( ALPHA | ALPHA_TONOS ) PSI EPSILON
            {
            mGAMMA(); 
            mRHO(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mPSI(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:523:7: ( ALPHA RHO CHI ( ETA | ETA_TONOS ) )
            // src/glossa/grammars/Glossa.g:523:9: ALPHA RHO CHI ( ETA | ETA_TONOS )
            {
            mALPHA(); 
            mRHO(); 
            mCHI(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "PROCEDURE"
    public final void mPROCEDURE() throws RecognitionException {
        try {
            int _type = PROCEDURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:526:2: ( DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA ( IOTA | IOTA_TONOS ) ALPHA )
            // src/glossa/grammars/Glossa.g:526:4: DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA ( IOTA | IOTA_TONOS ) ALPHA
            {
            mDELTA(); 
            mIOTA(); 
            mALPHA(); 
            mDELTA(); 
            mIOTA(); 
            mKAPPA(); 
            mALPHA(); 
            mSIGMA(); 
            if ( input.LA(1)=='\u038A'||input.LA(1)=='\u0399'||input.LA(1)=='\u03AF'||input.LA(1)=='\u03B9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mALPHA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROCEDURE"

    // $ANTLR start "END_PROCEDURE"
    public final void mEND_PROCEDURE() throws RecognitionException {
        try {
            int _type = END_PROCEDURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:529:2: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA ( IOTA | IOTA_TONOS ) ALPHA SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:529:4: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' DELTA IOTA ALPHA DELTA IOTA KAPPA ALPHA SIGMA ( IOTA | IOTA_TONOS ) ALPHA SIGMA_TELIKO
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mDELTA(); 
            mIOTA(); 
            mALPHA(); 
            mDELTA(); 
            mIOTA(); 
            mKAPPA(); 
            mALPHA(); 
            mSIGMA(); 
            if ( input.LA(1)=='\u038A'||input.LA(1)=='\u0399'||input.LA(1)=='\u03AF'||input.LA(1)=='\u03B9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mALPHA(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_PROCEDURE"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:531:9: ( SIGMA UPSILON NU ( ALPHA | ALPHA_TONOS ) RHO TAU ETA SIGMA ETA )
            // src/glossa/grammars/Glossa.g:531:11: SIGMA UPSILON NU ( ALPHA | ALPHA_TONOS ) RHO TAU ETA SIGMA ETA
            {
            mSIGMA(); 
            mUPSILON(); 
            mNU(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mTAU(); 
            mETA(); 
            mSIGMA(); 
            mETA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "END_FUNCTION"
    public final void mEND_FUNCTION() throws RecognitionException {
        try {
            int _type = END_FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:534:2: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' SIGMA UPSILON NU ( ALPHA | ALPHA_TONOS ) RHO TAU ETA SIGMA ETA SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:534:4: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' SIGMA UPSILON NU ( ALPHA | ALPHA_TONOS ) RHO TAU ETA SIGMA ETA SIGMA_TELIKO
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mSIGMA(); 
            mUPSILON(); 
            mNU(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mTAU(); 
            mETA(); 
            mSIGMA(); 
            mETA(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_FUNCTION"

    // $ANTLR start "CALL"
    public final void mCALL() throws RecognitionException {
        try {
            int _type = CALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:536:6: ( KAPPA ( ALPHA | ALPHA_TONOS ) LAMDA EPSILON SIGMA EPSILON )
            // src/glossa/grammars/Glossa.g:536:8: KAPPA ( ALPHA | ALPHA_TONOS ) LAMDA EPSILON SIGMA EPSILON
            {
            mKAPPA(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mEPSILON(); 
            mSIGMA(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CALL"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:539:4: ( ALPHA NU )
            // src/glossa/grammars/Glossa.g:539:6: ALPHA NU
            {
            mALPHA(); 
            mNU(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:541:6: ( TAU ( OMICRON | OMICRON_TONOS ) TAU EPSILON )
            // src/glossa/grammars/Glossa.g:541:8: TAU ( OMICRON | OMICRON_TONOS ) TAU EPSILON
            {
            mTAU(); 
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mTAU(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:543:6: ( ALPHA LAMDA LAMDA IOTA ( OMEGA | OMEGA_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:543:8: ALPHA LAMDA LAMDA IOTA ( OMEGA | OMEGA_TONOS ) SIGMA_TELIKO
            {
            mALPHA(); 
            mLAMDA(); 
            mLAMDA(); 
            mIOTA(); 
            if ( input.LA(1)=='\u038F'||input.LA(1)=='\u03A9'||input.LA(1)=='\u03C9'||input.LA(1)=='\u03CE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "ELSE_IF"
    public final void mELSE_IF() throws RecognitionException {
        try {
            int _type = ELSE_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:545:9: ( ALPHA LAMDA LAMDA IOTA ( OMEGA | OMEGA_TONOS ) SIGMA_TELIKO '_' ALPHA NU )
            // src/glossa/grammars/Glossa.g:545:11: ALPHA LAMDA LAMDA IOTA ( OMEGA | OMEGA_TONOS ) SIGMA_TELIKO '_' ALPHA NU
            {
            mALPHA(); 
            mLAMDA(); 
            mLAMDA(); 
            mIOTA(); 
            if ( input.LA(1)=='\u038F'||input.LA(1)=='\u03A9'||input.LA(1)=='\u03C9'||input.LA(1)=='\u03CE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 
            match('_'); 
            mALPHA(); 
            mNU(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE_IF"

    // $ANTLR start "END_IF"
    public final void mEND_IF() throws RecognitionException {
        try {
            int _type = END_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:547:8: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' ALPHA NU )
            // src/glossa/grammars/Glossa.g:547:10: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' ALPHA NU
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mALPHA(); 
            mNU(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_IF"

    // $ANTLR start "SWITCH"
    public final void mSWITCH() throws RecognitionException {
        try {
            int _type = SWITCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:552:8: ( EPSILON PI ( IOTA | IOTA_TONOS ) LAMDA EPSILON XI EPSILON )
            // src/glossa/grammars/Glossa.g:552:10: EPSILON PI ( IOTA | IOTA_TONOS ) LAMDA EPSILON XI EPSILON
            {
            mEPSILON(); 
            mPI(); 
            if ( input.LA(1)=='\u038A'||input.LA(1)=='\u0399'||input.LA(1)=='\u03AF'||input.LA(1)=='\u03B9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mEPSILON(); 
            mXI(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SWITCH"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:554:6: ( PI EPSILON RHO ( IOTA | IOTA_TONOS ) PI TAU OMEGA SIGMA ETA )
            // src/glossa/grammars/Glossa.g:554:8: PI EPSILON RHO ( IOTA | IOTA_TONOS ) PI TAU OMEGA SIGMA ETA
            {
            mPI(); 
            mEPSILON(); 
            mRHO(); 
            if ( input.LA(1)=='\u038A'||input.LA(1)=='\u0399'||input.LA(1)=='\u03AF'||input.LA(1)=='\u03B9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mPI(); 
            mTAU(); 
            mOMEGA(); 
            mSIGMA(); 
            mETA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "END_SWITCH"
    public final void mEND_SWITCH() throws RecognitionException {
        try {
            int _type = END_SWITCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:557:2: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI IOTA LAMDA OMICRON GAMMA ( OMEGA | OMEGA_TONOS ) NU )
            // src/glossa/grammars/Glossa.g:557:4: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI IOTA LAMDA OMICRON GAMMA ( OMEGA | OMEGA_TONOS ) NU
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mEPSILON(); 
            mPI(); 
            mIOTA(); 
            mLAMDA(); 
            mOMICRON(); 
            mGAMMA(); 
            if ( input.LA(1)=='\u038F'||input.LA(1)=='\u03A9'||input.LA(1)=='\u03C9'||input.LA(1)=='\u03CE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mNU(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_SWITCH"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:561:7: ( ( OMICRON | OMICRON_TONOS ) SIGMA OMICRON )
            // src/glossa/grammars/Glossa.g:561:9: ( OMICRON | OMICRON_TONOS ) SIGMA OMICRON
            {
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA(); 
            mOMICRON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "LOOP"
    public final void mLOOP() throws RecognitionException {
        try {
            int _type = LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:563:6: ( EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ALPHA BETA EPSILON )
            // src/glossa/grammars/Glossa.g:563:8: EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ALPHA BETA EPSILON
            {
            mEPSILON(); 
            mPI(); 
            mALPHA(); 
            mNU(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mALPHA(); 
            mBETA(); 
            mEPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOOP"

    // $ANTLR start "END_LOOP"
    public final void mEND_LOOP() throws RecognitionException {
        try {
            int _type = END_LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:565:9: ( TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ETA PSI ETA SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:565:11: TAU ( EPSILON | EPSILON_TONOS ) LAMDA OMICRON SIGMA_TELIKO '_' EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ETA PSI ETA SIGMA_TELIKO
            {
            mTAU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mOMICRON(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            mEPSILON(); 
            mPI(); 
            mALPHA(); 
            mNU(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mETA(); 
            mPSI(); 
            mETA(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_LOOP"

    // $ANTLR start "REPEAT"
    public final void mREPEAT() throws RecognitionException {
        try {
            int _type = REPEAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:569:8: ( ALPHA RHO CHI ( ETA | ETA_TONOS ) '_' EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ETA PSI ETA SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:569:10: ALPHA RHO CHI ( ETA | ETA_TONOS ) '_' EPSILON PI ALPHA NU ( ALPHA | ALPHA_TONOS ) LAMDA ETA PSI ETA SIGMA_TELIKO
            {
            mALPHA(); 
            mRHO(); 
            mCHI(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            mEPSILON(); 
            mPI(); 
            mALPHA(); 
            mNU(); 
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u0391'||input.LA(1)=='\u03AC'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mLAMDA(); 
            mETA(); 
            mPSI(); 
            mETA(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REPEAT"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:571:7: ( MU ( EPSILON | EPSILON_TONOS ) CHI RHO IOTA SIGMA_TELIKO '_' ( OMICRON | OMICRON_TONOS ) TAU OMICRON UPSILON )
            // src/glossa/grammars/Glossa.g:571:9: MU ( EPSILON | EPSILON_TONOS ) CHI RHO IOTA SIGMA_TELIKO '_' ( OMICRON | OMICRON_TONOS ) TAU OMICRON UPSILON
            {
            mMU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mCHI(); 
            mRHO(); 
            mIOTA(); 
            mSIGMA_TELIKO(); 
            match('_'); 
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mTAU(); 
            mOMICRON(); 
            mUPSILON(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:574:5: ( GAMMA IOTA ALPHA )
            // src/glossa/grammars/Glossa.g:574:7: GAMMA IOTA ALPHA
            {
            mGAMMA(); 
            mIOTA(); 
            mALPHA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:576:6: ( ALPHA PI ( OMICRON | OMICRON_TONOS ) )
            // src/glossa/grammars/Glossa.g:576:8: ALPHA PI ( OMICRON | OMICRON_TONOS )
            {
            mALPHA(); 
            mPI(); 
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u039F'||input.LA(1)=='\u03BF'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:578:4: ( MU ( EPSILON | EPSILON_TONOS ) CHI RHO IOTA )
            // src/glossa/grammars/Glossa.g:578:6: MU ( EPSILON | EPSILON_TONOS ) CHI RHO IOTA
            {
            mMU(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mCHI(); 
            mRHO(); 
            mIOTA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "STEP"
    public final void mSTEP() throws RecognitionException {
        try {
            int _type = STEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:580:6: ( MU EPSILON ( '_' | ( ' ' | '\\t' )+ ) BETA ( ETA | ETA_TONOS ) MU ALPHA )
            // src/glossa/grammars/Glossa.g:580:8: MU EPSILON ( '_' | ( ' ' | '\\t' )+ ) BETA ( ETA | ETA_TONOS ) MU ALPHA
            {
            mMU(); 
            mEPSILON(); 
            // src/glossa/grammars/Glossa.g:580:19: ( '_' | ( ' ' | '\\t' )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='_') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\t'||LA6_0==' ') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:580:21: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:580:27: ( ' ' | '\\t' )+
                    {
                    // src/glossa/grammars/Glossa.g:580:27: ( ' ' | '\\t' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\t'||LA5_0==' ') ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:
                    	    {
                    	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }

            mBETA(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mMU(); 
            mALPHA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STEP"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:584:9: ( ALPHA KAPPA ( EPSILON | EPSILON_TONOS ) RHO ALPHA IOTA ALPHA )
            // src/glossa/grammars/Glossa.g:584:11: ALPHA KAPPA ( EPSILON | EPSILON_TONOS ) RHO ALPHA IOTA ALPHA
            {
            mALPHA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mALPHA(); 
            mIOTA(); 
            mALPHA(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "INTEGERS"
    public final void mINTEGERS() throws RecognitionException {
        try {
            int _type = INTEGERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:586:9: ( ALPHA KAPPA ( EPSILON | EPSILON_TONOS ) RHO ALPHA IOTA EPSILON SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:586:11: ALPHA KAPPA ( EPSILON | EPSILON_TONOS ) RHO ALPHA IOTA EPSILON SIGMA_TELIKO
            {
            mALPHA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mALPHA(); 
            mIOTA(); 
            mEPSILON(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGERS"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:588:6: ( PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA ( ETA | ETA_TONOS ) )
            // src/glossa/grammars/Glossa.g:588:8: PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA ( ETA | ETA_TONOS )
            {
            mPI(); 
            mRHO(); 
            mALPHA(); 
            mGAMMA(); 
            mMU(); 
            mALPHA(); 
            mTAU(); 
            mIOTA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "REALS"
    public final void mREALS() throws RecognitionException {
        try {
            int _type = REALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:590:7: ( PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:590:9: PI RHO ALPHA GAMMA MU ALPHA TAU IOTA KAPPA ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO
            {
            mPI(); 
            mRHO(); 
            mALPHA(); 
            mGAMMA(); 
            mMU(); 
            mALPHA(); 
            mTAU(); 
            mIOTA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REALS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:592:8: ( CHI ALPHA RHO ALPHA KAPPA TAU ( ETA | ETA_TONOS ) RHO ALPHA SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:592:10: CHI ALPHA RHO ALPHA KAPPA TAU ( ETA | ETA_TONOS ) RHO ALPHA SIGMA_TELIKO
            {
            mCHI(); 
            mALPHA(); 
            mRHO(); 
            mALPHA(); 
            mKAPPA(); 
            mTAU(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mALPHA(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "STRINGS"
    public final void mSTRINGS() throws RecognitionException {
        try {
            int _type = STRINGS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:594:9: ( CHI ALPHA RHO ALPHA KAPPA TAU ( ETA | ETA_TONOS ) RHO EPSILON SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:594:11: CHI ALPHA RHO ALPHA KAPPA TAU ( ETA | ETA_TONOS ) RHO EPSILON SIGMA_TELIKO
            {
            mCHI(); 
            mALPHA(); 
            mRHO(); 
            mALPHA(); 
            mKAPPA(); 
            mTAU(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mRHO(); 
            mEPSILON(); 
            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGS"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:596:9: ( LAMDA OMICRON GAMMA IOTA KAPPA ( ETA | ETA_TONOS ) )
            // src/glossa/grammars/Glossa.g:596:11: LAMDA OMICRON GAMMA IOTA KAPPA ( ETA | ETA_TONOS )
            {
            mLAMDA(); 
            mOMICRON(); 
            mGAMMA(); 
            mIOTA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "BOOLEANS"
    public final void mBOOLEANS() throws RecognitionException {
        try {
            int _type = BOOLEANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:598:10: ( LAMDA OMICRON GAMMA IOTA KAPPA ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:598:12: LAMDA OMICRON GAMMA IOTA KAPPA ( EPSILON | EPSILON_TONOS ) SIGMA_TELIKO
            {
            mLAMDA(); 
            mOMICRON(); 
            mGAMMA(); 
            mIOTA(); 
            mKAPPA(); 
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u0395'||input.LA(1)=='\u03AD'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEANS"

    // $ANTLR start "CONST_TRUE"
    public final void mCONST_TRUE() throws RecognitionException {
        try {
            int _type = CONST_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:606:2: ( ALPHA LAMDA ETA THETA ( ETA | ETA_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:606:4: ALPHA LAMDA ETA THETA ( ETA | ETA_TONOS ) SIGMA_TELIKO
            {
            mALPHA(); 
            mLAMDA(); 
            mETA(); 
            mTHETA(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST_TRUE"

    // $ANTLR start "CONST_FALSE"
    public final void mCONST_FALSE() throws RecognitionException {
        try {
            int _type = CONST_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:609:2: ( PSI EPSILON UPSILON DELTA ( ETA | ETA_TONOS ) SIGMA_TELIKO )
            // src/glossa/grammars/Glossa.g:609:4: PSI EPSILON UPSILON DELTA ( ETA | ETA_TONOS ) SIGMA_TELIKO
            {
            mPSI(); 
            mEPSILON(); 
            mUPSILON(); 
            mDELTA(); 
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u0397'||input.LA(1)=='\u03AE'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mSIGMA_TELIKO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST_FALSE"

    // $ANTLR start "CONST_STR"
    public final void mCONST_STR() throws RecognitionException {
        try {
            int _type = CONST_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:612:2: ( '\\'' ( . )* '\\'' | '\"' ( . )* '\"' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\'') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\"') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:612:4: '\\'' ( . )* '\\''
                    {
                    match('\''); 
                    // src/glossa/grammars/Glossa.g:612:9: ( . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\'') ) {
                            alt7=2;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:612:9: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:612:19: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // src/glossa/grammars/Glossa.g:612:23: ( . )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\"') ) {
                            alt8=2;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:612:23: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST_STR"

    // $ANTLR start "CONST_INT"
    public final void mCONST_INT() throws RecognitionException {
        try {
            int _type = CONST_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:615:2: ( ( DIGIT )+ )
            // src/glossa/grammars/Glossa.g:615:4: ( DIGIT )+
            {
            // src/glossa/grammars/Glossa.g:615:4: ( DIGIT )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:615:4: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST_INT"

    // $ANTLR start "CONST_REAL"
    public final void mCONST_REAL() throws RecognitionException {
        try {
            int _type = CONST_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:618:2: ( ( DIGIT )+ '.' ( DIGIT )+ )
            // src/glossa/grammars/Glossa.g:618:4: ( DIGIT )+ '.' ( DIGIT )+
            {
            // src/glossa/grammars/Glossa.g:618:4: ( DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:618:4: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            match('.'); 
            // src/glossa/grammars/Glossa.g:618:15: ( DIGIT )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:618:15: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST_REAL"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:620:4: ( LETTER ( LETTER | DIGIT | '_' )* )
            // src/glossa/grammars/Glossa.g:620:6: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // src/glossa/grammars/Glossa.g:620:13: ( LETTER | DIGIT | '_' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')||LA13_0=='\u0386'||(LA13_0>='\u0388' && LA13_0<='\u038A')||LA13_0=='\u038C'||(LA13_0>='\u038E' && LA13_0<='\u03A1')||(LA13_0>='\u03A3' && LA13_0<='\u03CE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:622:9: ( '!' ( NOT_EOL )* )
            // src/glossa/grammars/Glossa.g:622:11: '!' ( NOT_EOL )*
            {
            match('!'); 
            // src/glossa/grammars/Glossa.g:622:15: ( NOT_EOL )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:622:15: NOT_EOL
            	    {
            	    mNOT_EOL(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "CONT_COMMAND"
    public final void mCONT_COMMAND() throws RecognitionException {
        try {
            int _type = CONT_COMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:625:2: ( NEWLINE '&' )
            // src/glossa/grammars/Glossa.g:625:4: NEWLINE '&'
            {
            mNEWLINE(); 
            match('&'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONT_COMMAND"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:627:9: ( ( '\\r' )? '\\n' )
            // src/glossa/grammars/Glossa.g:627:11: ( '\\r' )? '\\n'
            {
            // src/glossa/grammars/Glossa.g:627:11: ( '\\r' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:627:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/glossa/grammars/Glossa.g:629:4: ( ( ' ' | '\\t' )+ )
            // src/glossa/grammars/Glossa.g:629:6: ( ' ' | '\\t' )+
            {
            // src/glossa/grammars/Glossa.g:629:6: ( ' ' | '\\t' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\t'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:641:2: ( '0' .. '9' )
            // src/glossa/grammars/Glossa.g:641:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:644:2: ( LATIN_LETTER | GREEK_LETTER )
            // src/glossa/grammars/Glossa.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "LATIN_LETTER"
    public final void mLATIN_LETTER() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:648:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LATIN_LETTER"

    // $ANTLR start "GREEK_LETTER"
    public final void mGREEK_LETTER() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:652:2: ( ALPHA | BETA | GAMMA | DELTA | EPSILON | ZETA | ETA | THETA | IOTA | KAPPA | LAMDA | MU | NU | XI | OMICRON | PI | RHO | SIGMA | TAU | UPSILON | PHI | CHI | PSI | OMEGA | SIGMA_TELIKO | ALPHA_TONOS | EPSILON_TONOS | ETA_TONOS | IOTA_TONOS | UPSILON_TONOS | OMICRON_TONOS | OMEGA_TONOS | IOTA_DIALYTIKA | UPSILON_DIALYTIKA | IOTA_DIALYTIKA_TONOS | UPSILON_DIALYTIKA_TONOS )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "GREEK_LETTER"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:660:2: ( '\\u03B1' | '\\u0391' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0391'||input.LA(1)=='\u03B1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "BETA"
    public final void mBETA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:662:2: ( '\\u03B2' | '\\u0392' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0392'||input.LA(1)=='\u03B2' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "BETA"

    // $ANTLR start "GAMMA"
    public final void mGAMMA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:664:2: ( '\\u03B3' | '\\u0393' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0393'||input.LA(1)=='\u03B3' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "GAMMA"

    // $ANTLR start "DELTA"
    public final void mDELTA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:666:2: ( '\\u03B4' | '\\u0394' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0394'||input.LA(1)=='\u03B4' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DELTA"

    // $ANTLR start "EPSILON"
    public final void mEPSILON() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:668:2: ( '\\u03B5' | '\\u0395' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0395'||input.LA(1)=='\u03B5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "EPSILON"

    // $ANTLR start "ZETA"
    public final void mZETA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:670:2: ( '\\u03B6' | '\\u0396' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0396'||input.LA(1)=='\u03B6' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ZETA"

    // $ANTLR start "ETA"
    public final void mETA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:672:2: ( '\\u03B7' | '\\u0397' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0397'||input.LA(1)=='\u03B7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ETA"

    // $ANTLR start "THETA"
    public final void mTHETA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:674:2: ( '\\u03B8' | '\\u0398' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0398'||input.LA(1)=='\u03B8' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "THETA"

    // $ANTLR start "IOTA"
    public final void mIOTA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:676:2: ( '\\u03B9' | '\\u0399' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0399'||input.LA(1)=='\u03B9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IOTA"

    // $ANTLR start "KAPPA"
    public final void mKAPPA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:678:2: ( '\\u03BA' | '\\u039A' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039A'||input.LA(1)=='\u03BA' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "KAPPA"

    // $ANTLR start "LAMDA"
    public final void mLAMDA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:680:2: ( '\\u03BB' | '\\u039B' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039B'||input.LA(1)=='\u03BB' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LAMDA"

    // $ANTLR start "MU"
    public final void mMU() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:682:2: ( '\\u03BC' | '\\u039C' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039C'||input.LA(1)=='\u03BC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "MU"

    // $ANTLR start "NU"
    public final void mNU() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:684:2: ( '\\u03BD' | '\\u039D' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039D'||input.LA(1)=='\u03BD' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NU"

    // $ANTLR start "XI"
    public final void mXI() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:686:2: ( '\\u03BE' | '\\u039E' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039E'||input.LA(1)=='\u03BE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "XI"

    // $ANTLR start "OMICRON"
    public final void mOMICRON() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:688:2: ( '\\u03BF' | '\\u039F' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u039F'||input.LA(1)=='\u03BF' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OMICRON"

    // $ANTLR start "PI"
    public final void mPI() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:690:2: ( '\\u03C0' | '\\u03A0' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A0'||input.LA(1)=='\u03C0' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "PI"

    // $ANTLR start "RHO"
    public final void mRHO() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:692:2: ( '\\u03C1' | '\\u03A1' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A1'||input.LA(1)=='\u03C1' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RHO"

    // $ANTLR start "SIGMA"
    public final void mSIGMA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:694:2: ( '\\u03C3' | '\\u03A3' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A3'||input.LA(1)=='\u03C3' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SIGMA"

    // $ANTLR start "TAU"
    public final void mTAU() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:696:2: ( '\\u03C4' | '\\u03A4' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A4'||input.LA(1)=='\u03C4' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "TAU"

    // $ANTLR start "UPSILON"
    public final void mUPSILON() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:698:2: ( '\\u03C5' | '\\u03A5' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A5'||input.LA(1)=='\u03C5' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UPSILON"

    // $ANTLR start "PHI"
    public final void mPHI() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:700:2: ( '\\u03C6' | '\\u03A6' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A6'||input.LA(1)=='\u03C6' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "PHI"

    // $ANTLR start "CHI"
    public final void mCHI() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:702:2: ( '\\u03C7' | '\\u03A7' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A7'||input.LA(1)=='\u03C7' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "CHI"

    // $ANTLR start "PSI"
    public final void mPSI() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:704:2: ( '\\u03C8' | '\\u03A8' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A8'||input.LA(1)=='\u03C8' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "PSI"

    // $ANTLR start "OMEGA"
    public final void mOMEGA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:706:2: ( '\\u03C9' | '\\u03A9' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A9'||input.LA(1)=='\u03C9' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OMEGA"

    // $ANTLR start "SIGMA_TELIKO"
    public final void mSIGMA_TELIKO() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:708:2: ( '\\u03C2' | '\\u03A3' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03A3'||input.LA(1)=='\u03C2' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SIGMA_TELIKO"

    // $ANTLR start "ALPHA_TONOS"
    public final void mALPHA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:710:2: ( '\\u03AC' | '\\u0386' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0386'||input.LA(1)=='\u03AC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA_TONOS"

    // $ANTLR start "EPSILON_TONOS"
    public final void mEPSILON_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:712:2: ( '\\u03AD' | '\\u0388' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0388'||input.LA(1)=='\u03AD' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "EPSILON_TONOS"

    // $ANTLR start "ETA_TONOS"
    public final void mETA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:714:2: ( '\\u03AE' | '\\u0389' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u0389'||input.LA(1)=='\u03AE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ETA_TONOS"

    // $ANTLR start "IOTA_TONOS"
    public final void mIOTA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:716:2: ( '\\u03AF' | '\\u038A' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u038A'||input.LA(1)=='\u03AF' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IOTA_TONOS"

    // $ANTLR start "UPSILON_TONOS"
    public final void mUPSILON_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:718:2: ( '\\u03CD' | '\\u038E' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u038E'||input.LA(1)=='\u03CD' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UPSILON_TONOS"

    // $ANTLR start "OMICRON_TONOS"
    public final void mOMICRON_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:720:2: ( '\\u03CC' | '\\u038C' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u038C'||input.LA(1)=='\u03CC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OMICRON_TONOS"

    // $ANTLR start "OMEGA_TONOS"
    public final void mOMEGA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:722:2: ( '\\u03CE' | '\\u038F' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u038F'||input.LA(1)=='\u03CE' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OMEGA_TONOS"

    // $ANTLR start "IOTA_DIALYTIKA"
    public final void mIOTA_DIALYTIKA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:724:2: ( '\\u03CA' | '\\u03AA' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03AA'||input.LA(1)=='\u03CA' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IOTA_DIALYTIKA"

    // $ANTLR start "UPSILON_DIALYTIKA"
    public final void mUPSILON_DIALYTIKA() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:726:2: ( '\\u03CB' | '\\u03AB' )
            // src/glossa/grammars/Glossa.g:
            {
            if ( input.LA(1)=='\u03AB'||input.LA(1)=='\u03CB' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UPSILON_DIALYTIKA"

    // $ANTLR start "IOTA_DIALYTIKA_TONOS"
    public final void mIOTA_DIALYTIKA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:728:2: ( '\\u0390' )
            // src/glossa/grammars/Glossa.g:728:4: '\\u0390'
            {
            match('\u0390'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "IOTA_DIALYTIKA_TONOS"

    // $ANTLR start "UPSILON_DIALYTIKA_TONOS"
    public final void mUPSILON_DIALYTIKA_TONOS() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:730:2: ( '\\u03B0' )
            // src/glossa/grammars/Glossa.g:730:4: '\\u03B0'
            {
            match('\u03B0'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UPSILON_DIALYTIKA_TONOS"

    // $ANTLR start "NOT_EOL"
    public final void mNOT_EOL() throws RecognitionException {
        try {
            // src/glossa/grammars/Glossa.g:734:2: ( ( '\\u0000' .. '\\u0009' ) | '\\u000B' | '\\u000C' | ( '\\u000E' .. '\\uFFFF' ) )
            int alt17=4;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='\u0000' && LA17_0<='\t')) ) {
                alt17=1;
            }
            else if ( (LA17_0=='\u000B') ) {
                alt17=2;
            }
            else if ( (LA17_0=='\f') ) {
                alt17=3;
            }
            else if ( ((LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                alt17=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:734:4: ( '\\u0000' .. '\\u0009' )
                    {
                    // src/glossa/grammars/Glossa.g:734:4: ( '\\u0000' .. '\\u0009' )
                    // src/glossa/grammars/Glossa.g:734:5: '\\u0000' .. '\\u0009'
                    {
                    matchRange('\u0000','\t'); 

                    }


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:734:27: '\\u000B'
                    {
                    match('\u000B'); 

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:734:38: '\\u000C'
                    {
                    match('\f'); 

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:734:48: ( '\\u000E' .. '\\uFFFF' )
                    {
                    // src/glossa/grammars/Glossa.g:734:48: ( '\\u000E' .. '\\uFFFF' )
                    // src/glossa/grammars/Glossa.g:734:49: '\\u000E' .. '\\uFFFF'
                    {
                    matchRange('\u000E','\uFFFF'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EOL"

    public void mTokens() throws RecognitionException {
        // src/glossa/grammars/Glossa.g:1:8: ( ASSIGN | COMMA | COLON | LPAR | RPAR | LBRACKET | RBRACKET | PLUS | MINUS | TIMES | DIA | POW | DIV | MOD | LE | LT | GE | GT | EQ | NEQ | AND | OR | NOT | RANGE | PROGRAM | END_PROGRAM | VARIABLES | CONSTANTS | READ | PRINT | BEGIN | PROCEDURE | END_PROCEDURE | FUNCTION | END_FUNCTION | CALL | IF | THEN | ELSE | ELSE_IF | END_IF | SWITCH | CASE | END_SWITCH | WHILE | LOOP | END_LOOP | REPEAT | UNTIL | FOR | FROM | TO | STEP | INTEGER | INTEGERS | REAL | REALS | STRING | STRINGS | BOOLEAN | BOOLEANS | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | COMMENT | CONT_COMMAND | NEWLINE | WS )
        int alt18=71;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // src/glossa/grammars/Glossa.g:1:10: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 2 :
                // src/glossa/grammars/Glossa.g:1:17: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 3 :
                // src/glossa/grammars/Glossa.g:1:23: COLON
                {
                mCOLON(); 

                }
                break;
            case 4 :
                // src/glossa/grammars/Glossa.g:1:29: LPAR
                {
                mLPAR(); 

                }
                break;
            case 5 :
                // src/glossa/grammars/Glossa.g:1:34: RPAR
                {
                mRPAR(); 

                }
                break;
            case 6 :
                // src/glossa/grammars/Glossa.g:1:39: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 7 :
                // src/glossa/grammars/Glossa.g:1:48: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 8 :
                // src/glossa/grammars/Glossa.g:1:57: PLUS
                {
                mPLUS(); 

                }
                break;
            case 9 :
                // src/glossa/grammars/Glossa.g:1:62: MINUS
                {
                mMINUS(); 

                }
                break;
            case 10 :
                // src/glossa/grammars/Glossa.g:1:68: TIMES
                {
                mTIMES(); 

                }
                break;
            case 11 :
                // src/glossa/grammars/Glossa.g:1:74: DIA
                {
                mDIA(); 

                }
                break;
            case 12 :
                // src/glossa/grammars/Glossa.g:1:78: POW
                {
                mPOW(); 

                }
                break;
            case 13 :
                // src/glossa/grammars/Glossa.g:1:82: DIV
                {
                mDIV(); 

                }
                break;
            case 14 :
                // src/glossa/grammars/Glossa.g:1:86: MOD
                {
                mMOD(); 

                }
                break;
            case 15 :
                // src/glossa/grammars/Glossa.g:1:90: LE
                {
                mLE(); 

                }
                break;
            case 16 :
                // src/glossa/grammars/Glossa.g:1:93: LT
                {
                mLT(); 

                }
                break;
            case 17 :
                // src/glossa/grammars/Glossa.g:1:96: GE
                {
                mGE(); 

                }
                break;
            case 18 :
                // src/glossa/grammars/Glossa.g:1:99: GT
                {
                mGT(); 

                }
                break;
            case 19 :
                // src/glossa/grammars/Glossa.g:1:102: EQ
                {
                mEQ(); 

                }
                break;
            case 20 :
                // src/glossa/grammars/Glossa.g:1:105: NEQ
                {
                mNEQ(); 

                }
                break;
            case 21 :
                // src/glossa/grammars/Glossa.g:1:109: AND
                {
                mAND(); 

                }
                break;
            case 22 :
                // src/glossa/grammars/Glossa.g:1:113: OR
                {
                mOR(); 

                }
                break;
            case 23 :
                // src/glossa/grammars/Glossa.g:1:116: NOT
                {
                mNOT(); 

                }
                break;
            case 24 :
                // src/glossa/grammars/Glossa.g:1:120: RANGE
                {
                mRANGE(); 

                }
                break;
            case 25 :
                // src/glossa/grammars/Glossa.g:1:126: PROGRAM
                {
                mPROGRAM(); 

                }
                break;
            case 26 :
                // src/glossa/grammars/Glossa.g:1:134: END_PROGRAM
                {
                mEND_PROGRAM(); 

                }
                break;
            case 27 :
                // src/glossa/grammars/Glossa.g:1:146: VARIABLES
                {
                mVARIABLES(); 

                }
                break;
            case 28 :
                // src/glossa/grammars/Glossa.g:1:156: CONSTANTS
                {
                mCONSTANTS(); 

                }
                break;
            case 29 :
                // src/glossa/grammars/Glossa.g:1:166: READ
                {
                mREAD(); 

                }
                break;
            case 30 :
                // src/glossa/grammars/Glossa.g:1:171: PRINT
                {
                mPRINT(); 

                }
                break;
            case 31 :
                // src/glossa/grammars/Glossa.g:1:177: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 32 :
                // src/glossa/grammars/Glossa.g:1:183: PROCEDURE
                {
                mPROCEDURE(); 

                }
                break;
            case 33 :
                // src/glossa/grammars/Glossa.g:1:193: END_PROCEDURE
                {
                mEND_PROCEDURE(); 

                }
                break;
            case 34 :
                // src/glossa/grammars/Glossa.g:1:207: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 35 :
                // src/glossa/grammars/Glossa.g:1:216: END_FUNCTION
                {
                mEND_FUNCTION(); 

                }
                break;
            case 36 :
                // src/glossa/grammars/Glossa.g:1:229: CALL
                {
                mCALL(); 

                }
                break;
            case 37 :
                // src/glossa/grammars/Glossa.g:1:234: IF
                {
                mIF(); 

                }
                break;
            case 38 :
                // src/glossa/grammars/Glossa.g:1:237: THEN
                {
                mTHEN(); 

                }
                break;
            case 39 :
                // src/glossa/grammars/Glossa.g:1:242: ELSE
                {
                mELSE(); 

                }
                break;
            case 40 :
                // src/glossa/grammars/Glossa.g:1:247: ELSE_IF
                {
                mELSE_IF(); 

                }
                break;
            case 41 :
                // src/glossa/grammars/Glossa.g:1:255: END_IF
                {
                mEND_IF(); 

                }
                break;
            case 42 :
                // src/glossa/grammars/Glossa.g:1:262: SWITCH
                {
                mSWITCH(); 

                }
                break;
            case 43 :
                // src/glossa/grammars/Glossa.g:1:269: CASE
                {
                mCASE(); 

                }
                break;
            case 44 :
                // src/glossa/grammars/Glossa.g:1:274: END_SWITCH
                {
                mEND_SWITCH(); 

                }
                break;
            case 45 :
                // src/glossa/grammars/Glossa.g:1:285: WHILE
                {
                mWHILE(); 

                }
                break;
            case 46 :
                // src/glossa/grammars/Glossa.g:1:291: LOOP
                {
                mLOOP(); 

                }
                break;
            case 47 :
                // src/glossa/grammars/Glossa.g:1:296: END_LOOP
                {
                mEND_LOOP(); 

                }
                break;
            case 48 :
                // src/glossa/grammars/Glossa.g:1:305: REPEAT
                {
                mREPEAT(); 

                }
                break;
            case 49 :
                // src/glossa/grammars/Glossa.g:1:312: UNTIL
                {
                mUNTIL(); 

                }
                break;
            case 50 :
                // src/glossa/grammars/Glossa.g:1:318: FOR
                {
                mFOR(); 

                }
                break;
            case 51 :
                // src/glossa/grammars/Glossa.g:1:322: FROM
                {
                mFROM(); 

                }
                break;
            case 52 :
                // src/glossa/grammars/Glossa.g:1:327: TO
                {
                mTO(); 

                }
                break;
            case 53 :
                // src/glossa/grammars/Glossa.g:1:330: STEP
                {
                mSTEP(); 

                }
                break;
            case 54 :
                // src/glossa/grammars/Glossa.g:1:335: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 55 :
                // src/glossa/grammars/Glossa.g:1:343: INTEGERS
                {
                mINTEGERS(); 

                }
                break;
            case 56 :
                // src/glossa/grammars/Glossa.g:1:352: REAL
                {
                mREAL(); 

                }
                break;
            case 57 :
                // src/glossa/grammars/Glossa.g:1:357: REALS
                {
                mREALS(); 

                }
                break;
            case 58 :
                // src/glossa/grammars/Glossa.g:1:363: STRING
                {
                mSTRING(); 

                }
                break;
            case 59 :
                // src/glossa/grammars/Glossa.g:1:370: STRINGS
                {
                mSTRINGS(); 

                }
                break;
            case 60 :
                // src/glossa/grammars/Glossa.g:1:378: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 61 :
                // src/glossa/grammars/Glossa.g:1:386: BOOLEANS
                {
                mBOOLEANS(); 

                }
                break;
            case 62 :
                // src/glossa/grammars/Glossa.g:1:395: CONST_TRUE
                {
                mCONST_TRUE(); 

                }
                break;
            case 63 :
                // src/glossa/grammars/Glossa.g:1:406: CONST_FALSE
                {
                mCONST_FALSE(); 

                }
                break;
            case 64 :
                // src/glossa/grammars/Glossa.g:1:418: CONST_STR
                {
                mCONST_STR(); 

                }
                break;
            case 65 :
                // src/glossa/grammars/Glossa.g:1:428: CONST_INT
                {
                mCONST_INT(); 

                }
                break;
            case 66 :
                // src/glossa/grammars/Glossa.g:1:438: CONST_REAL
                {
                mCONST_REAL(); 

                }
                break;
            case 67 :
                // src/glossa/grammars/Glossa.g:1:449: ID
                {
                mID(); 

                }
                break;
            case 68 :
                // src/glossa/grammars/Glossa.g:1:452: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 69 :
                // src/glossa/grammars/Glossa.g:1:460: CONT_COMMAND
                {
                mCONT_COMMAND(); 

                }
                break;
            case 70 :
                // src/glossa/grammars/Glossa.g:1:473: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 71 :
                // src/glossa/grammars/Glossa.g:1:481: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\1\53\14\uffff\2\46\1\uffff\1\56\3\uffff\1\46\1\61\1\46"+
        "\1\uffff\13\46\1\uffff\1\110\3\uffff\1\112\2\uffff\2\46\1\uffff"+
        "\2\46\1\uffff\21\46\1\146\4\46\4\uffff\1\154\1\155\1\156\1\46\1"+
        "\160\1\161\10\46\1\uffff\4\46\1\176\5\46\1\u0084\1\uffff\5\46\3"+
        "\uffff\1\46\2\uffff\4\46\1\u008f\7\46\1\uffff\1\46\1\u0099\3\46"+
        "\1\uffff\12\46\1\uffff\2\46\1\u00a9\4\46\1\u00af\1\46\1\uffff\10"+
        "\46\1\u00ba\6\46\1\uffff\5\46\1\uffff\2\46\1\u00cd\1\u00cf\3\46"+
        "\1\u00d3\1\46\1\u00d5\1\uffff\11\46\1\132\3\46\1\u00e2\3\46\1\u00e6"+
        "\1\uffff\1\46\1\uffff\1\u00e8\2\46\1\uffff\1\u00eb\1\uffff\5\46"+
        "\1\u00f2\4\46\1\u00f7\1\46\1\uffff\2\46\1\u00fb\1\uffff\1\46\1\uffff"+
        "\2\46\1\uffff\1\46\1\u0102\1\u0103\3\46\1\uffff\4\46\1\uffff\1\u010b"+
        "\2\46\1\uffff\1\u010e\1\u010f\3\46\1\u0113\2\uffff\5\46\1\u0119"+
        "\1\46\1\uffff\1\u011b\1\46\2\uffff\1\u011d\1\u011e\1\u011f\1\uffff"+
        "\5\46\1\uffff\1\u0125\1\uffff\1\46\3\uffff\5\46\1\uffff\10\46\1"+
        "\u0134\5\46\1\uffff\3\46\1\u013d\1\u013e\1\u013f\2\46\3\uffff\1"+
        "\u0142\1\46\1\uffff\1\u0144\1\uffff";
    static final String DFA18_eofS =
        "\u0145\uffff";
    static final String DFA18_minS =
        "\1\11\1\55\14\uffff\1\111\1\117\1\uffff\1\75\3\uffff\1\u0386\1\60"+
        "\1\u03a3\1\uffff\1\u0395\2\u0388\1\u03a4\2\u0399\1\u039a\1\u03a0"+
        "\1\u0391\1\u039f\1\u0395\1\uffff\1\56\2\uffff\1\12\1\46\2\uffff"+
        "\1\126\1\104\1\uffff\1\u0399\1\u039b\1\uffff\1\u0399\1\u039f\1\u038c"+
        "\1\u03a1\1\u039b\1\u03a4\1\11\1\u03a7\1\u0391\1\u039d\1\u0386\1"+
        "\u0391\1\u0386\1\u03a7\1\u0388\1\u0397\1\u038c\1\60\1\u038a\1\u03a1"+
        "\1\u0393\1\u03a5\4\uffff\3\60\1\u0395\2\60\2\u0393\1\u038a\1\u039f"+
        "\1\u0395\1\u0391\1\u0392\1\u03a1\1\uffff\1\u0398\1\u0386\2\u0392"+
        "\1\60\1\u03a8\1\u0389\1\u03a1\1\u0399\1\u0398\1\60\1\uffff\1\u039b"+
        "\1\u039d\1\u0391\1\u0399\1\u0394\3\uffff\1\u03a3\2\uffff\1\u039c"+
        "\1\u03a1\1\u03a0\1\u03a3\1\60\1\u0392\1\u0389\1\u0399\1\u0395\1"+
        "\u03a1\1\u0391\1\u0399\1\uffff\1\u0395\1\60\1\u0391\1\u038f\1\u0389"+
        "\1\uffff\1\u0395\1\u0386\2\u039a\1\u0389\1\u0395\2\u0391\1\u03a4"+
        "\1\137\1\uffff\1\u039b\1\u039c\1\60\1\u03a1\1\u03a4\1\u03a3\1\u039a"+
        "\1\60\1\u0395\1\uffff\1\u0399\2\u03a3\1\u039e\1\u039b\1\u03a4\1"+
        "\u0388\1\u03a3\1\60\1\u03a4\1\u039c\1\u03a9\1\u0391\1\u0397\1\u0391"+
        "\1\uffff\1\137\1\u0388\1\u0397\1\u0395\1\u0391\1\uffff\1\u03a0\1"+
        "\u0391\2\60\1\u0395\1\u0391\1\u0389\1\60\1\u03a3\1\60\1\uffff\1"+
        "\u0399\1\u039c\1\u03a3\1\u03a0\1\u03a5\1\u039d\1\u0399\1\u03a1\1"+
        "\u03a4\1\60\1\u038c\2\u03a3\1\60\1\u03a3\1\u0391\1\u03a3\1\60\1"+
        "\uffff\1\u0391\1\uffff\1\60\1\u0392\1\u03a1\1\uffff\1\60\1\uffff"+
        "\1\u039a\1\u0391\1\u0397\1\u0391\1\u039d\1\60\1\u0391\1\u039f\1"+
        "\u0388\1\u03a4\1\60\1\u0397\1\uffff\1\u038a\1\u039d\1\60\1\uffff"+
        "\1\u039d\1\uffff\1\u0395\1\u0391\1\uffff\1\u0388\2\60\1\u039d\1"+
        "\u039b\1\u0386\1\uffff\1\u0394\1\u0393\1\u03a3\1\u039f\1\uffff\1"+
        "\60\1\u0391\1\u0386\1\uffff\2\60\3\u03a3\1\60\2\uffff\1\u0386\1"+
        "\u039f\1\u03a1\1\u0399\1\u03a1\1\60\1\u03a5\1\uffff\1\60\1\u039b"+
        "\2\uffff\3\60\1\uffff\1\u039b\1\u0393\1\u03a4\1\u039a\1\u0386\1"+
        "\uffff\1\60\1\uffff\1\u0397\3\uffff\1\u0397\1\u038f\1\u0397\1\u0391"+
        "\1\u039c\1\uffff\2\u03a8\1\u039d\2\u03a3\1\u039c\2\u0397\1\60\1"+
        "\u0397\1\u038a\1\u0391\2\u03a3\1\uffff\1\u03a3\1\u0391\1\u03a4\3"+
        "\60\1\u03a3\1\u039f\3\uffff\1\60\1\u03a3\1\uffff\1\60\1\uffff";
    static final String DFA18_maxS =
        "\1\u2265\1\76\14\uffff\1\151\1\157\1\uffff\1\75\3\uffff\1\u03b1"+
        "\1\u03ce\1\u03c7\1\uffff\1\u03c1\1\u03cc\1\u03b5\1\u03c5\1\u03b9"+
        "\2\u03c1\1\u03c0\1\u03b1\1\u03bf\1\u03b5\1\uffff\1\71\2\uffff\1"+
        "\12\1\46\2\uffff\1\166\1\144\1\uffff\2\u03bb\1\uffff\1\u03b9\1\u03bf"+
        "\1\u03cc\1\u03c1\1\u03bb\1\u03c4\2\u03c7\1\u03b1\1\u03bd\3\u03b1"+
        "\1\u03c7\1\u03b5\1\u03bb\1\u03cc\1\u03ce\1\u03b9\1\u03c1\1\u03b3"+
        "\1\u03c5\4\uffff\3\u03ce\1\u03b5\2\u03ce\2\u03b3\1\u03b9\1\u03bf"+
        "\1\u03b5\1\u03b1\1\u03b2\1\u03c1\1\uffff\1\u03b8\1\u03b1\1\u03b4"+
        "\1\u03b2\1\u03ce\1\u03c8\1\u03b7\1\u03c1\1\u03b9\1\u03b8\1\u03ce"+
        "\1\uffff\1\u03bb\1\u03bd\1\u03b1\1\u03b9\1\u03b4\3\uffff\1\u03c3"+
        "\2\uffff\1\u03bc\1\u03c1\1\u03c0\1\u03c2\1\u03ce\1\u03b2\1\u03b7"+
        "\1\u03b9\1\u03b5\1\u03c1\1\u03b1\1\u03b9\1\uffff\1\u03b5\1\u03ce"+
        "\1\u03b1\1\u03ce\1\u03b7\1\uffff\1\u03b5\1\u03b1\2\u03ba\1\u03b7"+
        "\1\u03b5\2\u03b1\1\u03c4\1\137\1\uffff\1\u03bb\1\u03bc\1\u03ce\1"+
        "\u03c1\1\u03c4\1\u03c3\1\u03ba\1\u03ce\1\u03b5\1\uffff\1\u03b9\2"+
        "\u03c2\1\u03be\1\u03bb\1\u03c4\1\u03b7\1\u03c2\1\u03ce\1\u03c4\1"+
        "\u03bc\1\u03c9\1\u03c3\1\u03b7\1\u03b1\1\uffff\1\137\1\u03b5\1\u03b7"+
        "\1\u03b5\1\u03b1\1\uffff\1\u03c0\1\u03b5\2\u03ce\1\u03b5\1\u03b1"+
        "\1\u03b7\1\u03ce\1\u03c2\1\u03ce\1\uffff\1\u03b9\1\u03bc\1\u03c3"+
        "\1\u03c0\1\u03c5\1\u03bd\1\u03b9\1\u03c1\1\u03c4\1\u03ce\1\u03cc"+
        "\1\u03c2\1\u03c3\1\u03ce\1\u03c3\1\u03b1\1\u03c2\1\u03ce\1\uffff"+
        "\1\u03b1\1\uffff\1\u03ce\1\u03b2\1\u03c1\1\uffff\1\u03ce\1\uffff"+
        "\1\u03ba\1\u03b1\1\u03b7\1\u03b9\1\u03bd\1\u03ce\1\u03b1\1\u03bf"+
        "\1\u03b5\1\u03c4\1\u03ce\1\u03b7\1\uffff\1\u03b9\1\u03bd\1\u03ce"+
        "\1\uffff\1\u03bd\1\uffff\2\u03b5\1\uffff\1\u03b7\2\u03ce\1\u03bd"+
        "\1\u03bb\1\u03b1\1\uffff\1\u03b4\1\u03b3\1\u03c2\1\u03bf\1\uffff"+
        "\1\u03ce\2\u03b1\1\uffff\2\u03ce\3\u03c2\1\u03ce\2\uffff\1\u03b1"+
        "\1\u03bf\1\u03c1\1\u03b9\1\u03c1\1\u03ce\1\u03c5\1\uffff\1\u03ce"+
        "\1\u03bb\2\uffff\3\u03ce\1\uffff\1\u03bb\1\u03b3\1\u03c4\1\u03ba"+
        "\1\u03b1\1\uffff\1\u03ce\1\uffff\1\u03b7\3\uffff\1\u03b7\1\u03ce"+
        "\1\u03b7\1\u03b1\1\u03bc\1\uffff\2\u03c8\1\u03bd\2\u03c3\1\u03bc"+
        "\2\u03b7\1\u03ce\1\u03b7\1\u03b9\1\u03b1\2\u03c2\1\uffff\1\u03c2"+
        "\1\u03b1\1\u03c4\3\u03ce\1\u03c2\1\u03bf\3\uffff\1\u03ce\1\u03c2"+
        "\1\uffff\1\u03ce\1\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\2"+
        "\uffff\1\17\1\uffff\1\21\1\23\1\24\3\uffff\1\30\13\uffff\1\100\1"+
        "\uffff\1\103\1\104\2\uffff\1\107\1\20\2\uffff\1\22\2\uffff\1\26"+
        "\26\uffff\1\101\1\102\1\106\1\105\16\uffff\1\65\13\uffff\1\45\5"+
        "\uffff\1\15\1\16\1\25\1\uffff\1\27\1\55\14\uffff\1\62\5\uffff\1"+
        "\63\12\uffff\1\46\11\uffff\1\37\17\uffff\1\64\5\uffff\1\36\12\uffff"+
        "\1\44\22\uffff\1\47\1\uffff\1\76\3\uffff\1\74\1\uffff\1\77\14\uffff"+
        "\1\35\3\uffff\1\66\1\uffff\1\52\2\uffff\1\75\6\uffff\1\51\4\uffff"+
        "\1\34\3\uffff\1\67\6\uffff\1\31\1\53\7\uffff\1\42\2\uffff\1\50\1"+
        "\56\3\uffff\1\70\5\uffff\1\33\1\uffff\1\40\1\uffff\1\73\1\72\1\71"+
        "\5\uffff\1\61\16\uffff\1\54\10\uffff\1\60\1\57\1\43\2\uffff\1\41"+
        "\1\uffff\1\32";
    static final String DFA18_specialS =
        "\u0145\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\52\1\51\2\uffff\1\50\22\uffff\1\52\1\47\1\44\4\uffff\1\44"+
            "\1\5\1\6\1\13\1\11\1\3\1\12\1\30\1\14\12\45\1\4\1\uffff\1\1"+
            "\1\23\1\21\2\uffff\3\46\1\16\10\46\1\17\15\46\1\7\1\uffff\1"+
            "\10\1\15\2\uffff\3\46\1\16\10\46\1\17\15\46\u030b\uffff\1\46"+
            "\1\uffff\1\46\1\26\1\46\1\uffff\1\27\1\uffff\3\46\1\37\1\46"+
            "\1\36\1\35\1\40\4\46\1\25\1\42\1\33\2\46\1\27\1\31\1\46\1\uffff"+
            "\1\34\1\32\2\46\1\41\1\43\5\46\1\26\2\46\1\37\1\46\1\36\1\35"+
            "\1\40\4\46\1\25\1\42\1\33\2\46\1\27\1\31\2\46\1\34\1\32\2\46"+
            "\1\41\1\43\3\46\1\27\2\46\u1dc1\uffff\1\2\u00cf\uffff\1\24\3"+
            "\uffff\1\20\1\22",
            "\1\2\17\uffff\1\20\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\54\37\uffff\1\54",
            "\1\55\37\uffff\1\55",
            "",
            "\1\22",
            "",
            "",
            "",
            "\1\60\12\uffff\1\57\32\uffff\1\60\4\uffff\1\57",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\63\3\uffff\1\62\33\uffff\1\63\3\uffff\1\62",
            "",
            "\1\65\13\uffff\1\64\23\uffff\1\65\13\uffff\1\64",
            "\1\66\3\uffff\1\67\10\uffff\1\66\11\uffff\1\67\15\uffff\1\66"+
            "\7\uffff\1\66\11\uffff\1\67\14\uffff\1\67",
            "\1\71\14\uffff\1\70\27\uffff\1\71\7\uffff\1\70",
            "\1\72\1\73\36\uffff\1\72\1\73",
            "\1\74\37\uffff\1\74",
            "\1\75\7\uffff\1\76\27\uffff\1\75\7\uffff\1\76",
            "\1\100\1\101\1\uffff\1\103\2\uffff\1\102\1\77\30\uffff\1\100"+
            "\1\101\1\uffff\1\103\2\uffff\1\102\1\77",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\106\37\uffff\1\106",
            "\1\107\37\uffff\1\107",
            "",
            "\1\111\1\uffff\12\45",
            "",
            "",
            "\1\51",
            "\1\113",
            "",
            "",
            "\1\114\37\uffff\1\114",
            "\1\115\37\uffff\1\115",
            "",
            "\1\116\1\uffff\1\117\35\uffff\1\116\1\uffff\1\117",
            "\1\117\37\uffff\1\117",
            "",
            "\1\120\37\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "\1\123\4\uffff\1\122\15\uffff\1\123\21\uffff\1\122\15\uffff"+
            "\1\123\14\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\1\125\37\uffff\1\125",
            "\1\126\37\uffff\1\126",
            "\1\132\26\uffff\1\132\76\uffff\1\130\u0344\uffff\1\127\2\uffff"+
            "\1\131\34\uffff\1\127\2\uffff\1\131",
            "\1\131\37\uffff\1\131",
            "\1\133\37\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "\1\136\12\uffff\1\135\32\uffff\1\136\4\uffff\1\135",
            "\1\137\37\uffff\1\137",
            "\1\140\12\uffff\1\140\32\uffff\1\140\4\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\14\uffff\1\142\27\uffff\1\142\7\uffff\1\142",
            "\1\144\3\uffff\1\143\33\uffff\1\144\3\uffff\1\143",
            "\1\145\22\uffff\1\145\37\uffff\1\145\14\uffff\1\145",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\147\6\uffff\1\150\7\uffff\1\147\25\uffff\1\147\1\uffff\1"+
            "\150\7\uffff\1\147",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\157\37\uffff\1\157",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "\1\164\16\uffff\1\164\25\uffff\1\164\11\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "",
            "\1\172\37\uffff\1\172",
            "\1\173\12\uffff\1\173\32\uffff\1\173\4\uffff\1\173",
            "\1\174\1\uffff\1\175\35\uffff\1\174\1\uffff\1\175",
            "\1\174\37\uffff\1\174",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\177\37\uffff\1\177",
            "\1\u0080\15\uffff\1\u0080\26\uffff\1\u0080\10\uffff\1\u0080",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "",
            "",
            "",
            "\1\u008a\37\uffff\1\u008a",
            "",
            "",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\36\uffff\1\u008e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\15\uffff\1\u0091\26\uffff\1\u0091\10\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "",
            "\1\u0097\37\uffff\1\u0097",
            "\12\46\7\uffff\32\46\4\uffff\1\u0098\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\31\uffff\1\u009b\37\uffff\1\u009b\4\uffff\1\u009b",
            "\1\u009c\15\uffff\1\u009c\26\uffff\1\u009c\10\uffff\1\u009c",
            "",
            "\1\u009d\37\uffff\1\u009d",
            "\1\u009e\12\uffff\1\u009e\32\uffff\1\u009e\4\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\15\uffff\1\u00a1\26\uffff\1\u00a1\10\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\1\u00aa"+
            "\36\46\1\u00aa\14\46",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00b0\37\uffff\1\u00b0",
            "",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\36\uffff\1\u00b2",
            "\1\u00b3\36\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\u00b8\1\u00b7\13\uffff\1\u00b8\1\uffff\1\u00b7\25\uffff"+
            "\1\u00b8\1\u00b7\6\uffff\1\u00b8\1\uffff\1\u00b7",
            "\1\u00b9\36\uffff\1\u00b9",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00c0\2\uffff\1\u00c1\1\u00be\12\uffff\1\u00c2\2\uffff\1"+
            "\u00bf\15\uffff\1\u00c0\2\uffff\1\u00c1\1\u00be\12\uffff\1\u00c2"+
            "\2\uffff\1\u00bf",
            "\1\u00c3\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c4",
            "",
            "\1\u00c5",
            "\1\u00c6\14\uffff\1\u00c6\27\uffff\1\u00c6\7\uffff\1\u00c6",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cc\3\uffff\1\u00cb\33\uffff\1\u00cc\3\uffff\1\u00cb",
            "\12\46\7\uffff\32\46\4\uffff\1\u00ce\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\u00d2\15\uffff\1\u00d2\26\uffff\1\u00d2\10\uffff\1\u00d2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00d4\36\uffff\1\u00d4",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00da",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00df\22\uffff\1\u00df\37\uffff\1\u00df\14\uffff\1\u00df",
            "\1\u00e0\36\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\36\uffff\1\u00e5",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u00e7\37\uffff\1\u00e7",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\7\uffff\1\u00f0\27\uffff\1\u00ef\7\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f1",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\14\uffff\1\u00f5\27\uffff\1\u00f5\7\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u00f8\37\uffff\1\u00f8",
            "",
            "\1\u00f9\16\uffff\1\u00f9\25\uffff\1\u00f9\11\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00fa",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u00fc\37\uffff\1\u00fc",
            "",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\u00ff\3\uffff\1\u00fe\33\uffff\1\u00ff\3\uffff\1\u00fe",
            "",
            "\1\u0100\1\u0101\13\uffff\1\u0100\1\uffff\1\u0101\25\uffff"+
            "\1\u0100\1\u0101\6\uffff\1\u0100\1\uffff\1\u0101",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\37\uffff\1\u0105",
            "\1\u0106\12\uffff\1\u0106\32\uffff\1\u0106\4\uffff\1\u0106",
            "",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\36\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\12\uffff\1\u010d\32\uffff\1\u010d\4\uffff\1\u010d",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0110\36\uffff\1\u0110",
            "\1\u0111\36\uffff\1\u0111",
            "\1\u0112\36\uffff\1\u0112",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "",
            "\1\u0114\12\uffff\1\u0114\32\uffff\1\u0114\4\uffff\1\u0114",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u011a\37\uffff\1\u011a",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u011c\37\uffff\1\u011c",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u0120\37\uffff\1\u0120",
            "\1\u0121\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0122",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\12\uffff\1\u0124\32\uffff\1\u0124\4\uffff\1\u0124",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "",
            "\1\u0126\37\uffff\1\u0126",
            "",
            "",
            "",
            "\1\u0127\37\uffff\1\u0127",
            "\1\u0128\31\uffff\1\u0128\37\uffff\1\u0128\4\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "\1\u0130\37\uffff\1\u0130",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0133",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\16\uffff\1\u0136\25\uffff\1\u0136\11\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\36\uffff\1\u0138",
            "\1\u0139\36\uffff\1\u0139",
            "",
            "\1\u013a\36\uffff\1\u013a",
            "\1\u013b\37\uffff\1\u013b",
            "\1\u013c\37\uffff\1\u013c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0140\36\uffff\1\u0140",
            "\1\u0141\37\uffff\1\u0141",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            "\1\u0143\36\uffff\1\u0143",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\u030b\uffff"+
            "\1\46\1\uffff\3\46\1\uffff\1\46\1\uffff\24\46\1\uffff\54\46",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ASSIGN | COMMA | COLON | LPAR | RPAR | LBRACKET | RBRACKET | PLUS | MINUS | TIMES | DIA | POW | DIV | MOD | LE | LT | GE | GT | EQ | NEQ | AND | OR | NOT | RANGE | PROGRAM | END_PROGRAM | VARIABLES | CONSTANTS | READ | PRINT | BEGIN | PROCEDURE | END_PROCEDURE | FUNCTION | END_FUNCTION | CALL | IF | THEN | ELSE | ELSE_IF | END_IF | SWITCH | CASE | END_SWITCH | WHILE | LOOP | END_LOOP | REPEAT | UNTIL | FOR | FROM | TO | STEP | INTEGER | INTEGERS | REAL | REALS | STRING | STRINGS | BOOLEAN | BOOLEANS | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | COMMENT | CONT_COMMAND | NEWLINE | WS );";
        }
    }
 

}