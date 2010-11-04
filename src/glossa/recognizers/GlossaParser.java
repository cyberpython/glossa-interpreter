// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/Glossa.g 2010-11-04 16:57:12

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
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class GlossaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PARAMS", "FUNC_CALL", "FORMAL_PARAMS", "NEWLINE", "PROGRAM", "ID", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "LPAR", "RPAR", "FUNCTION", "END_FUNCTION", "INTEGER", "REAL", "STRING", "BOOLEAN", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
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
    public static final int UPSILON_TONOS=124;
    public static final int LPAR=74;
    public static final int CONT_COMMAND=118;
    public static final int CONST_INT=72;
    public static final int BEGIN=20;
    public static final int LOOP=55;
    public static final int KAPPA=82;
    public static final int EQ=23;
    public static final int COMMENT=117;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=121;
    public static final int END_LOOP=53;
    public static final int GE=48;
    public static final int END_SWITCH=42;
    public static final int NU=109;
    public static final int CONST_TRUE=69;
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
    public static final int VARSDECL=6;
    public static final int CONST_REAL=73;
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
    public static final int PROCEDURE=106;
    public static final int PRINT=33;
    public static final int COLON=25;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=60;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=21;
    public static final int ZETA=122;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=70;
    public static final int NEG=5;
    public static final int ASSIGN=35;
    public static final int VARIABLES=24;
    public static final int END_IF=36;
    public static final int PROGRAM=18;
    public static final int RPAR=75;
    public static final int IOTA=84;
    public static final int DIV=65;
    public static final int TIMES=63;
    public static final int GAMMA=91;
    public static final int IOTA_DIALYTIKA=125;
    public static final int LE=46;
    public static final int IOTA_TONOS=105;
    public static final int STRING=80;

    // delegates
    // delegators


        public GlossaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GlossaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return GlossaParser.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/grammars/Glossa.g"; }



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


    public static class unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unit"
    // src/glossa/grammars/Glossa.g:286:1: unit : ( NEWLINE )* program ( function )* ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE1=null;
        GlossaParser.program_return program2 = null;

        GlossaParser.function_return function3 = null;


        CommonTree NEWLINE1_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:286:6: ( ( NEWLINE )* program ( function )* )
            // src/glossa/grammars/Glossa.g:286:8: ( NEWLINE )* program ( function )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/grammars/Glossa.g:286:8: ( NEWLINE )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NEWLINE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:286:9: NEWLINE
            	    {
            	    NEWLINE1=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_unit153); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_program_in_unit158);
            program2=program();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, program2.getTree());
            // src/glossa/grammars/Glossa.g:286:28: ( function )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==FUNCTION) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: function
            	    {
            	    pushFollow(FOLLOW_function_in_unit160);
            	    function3=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, function3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unit"

    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/glossa/grammars/Glossa.g:288:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
    public final GlossaParser.program_return program() throws RecognitionException {
        GlossaParser.program_return retval = new GlossaParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id1=null;
        Token id2=null;
        Token PROGRAM4=null;
        Token NEWLINE5=null;
        Token BEGIN7=null;
        Token NEWLINE8=null;
        Token END_PROGRAM10=null;
        Token NEWLINE11=null;
        GlossaParser.declarations_return declarations6 = null;

        GlossaParser.block_return block9 = null;


        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree PROGRAM4_tree=null;
        CommonTree NEWLINE5_tree=null;
        CommonTree BEGIN7_tree=null;
        CommonTree NEWLINE8_tree=null;
        CommonTree END_PROGRAM10_tree=null;
        CommonTree NEWLINE11_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:288:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:288:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM4=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PROGRAM4_tree = (CommonTree)adaptor.create(PROGRAM4);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM4_tree, root_0);
            }
            id1=(Token)match(input,ID,FOLLOW_ID_in_program174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);
            }
            // src/glossa/grammars/Glossa.g:288:27: ( NEWLINE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:288:28: NEWLINE
            	    {
            	    NEWLINE5=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program177); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            pushFollow(FOLLOW_declarations_in_program184);
            declarations6=declarations();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarations6.getTree());
            BEGIN7=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program188); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:290:11: ( NEWLINE )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==NEWLINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:290:12: NEWLINE
            	    {
            	    NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program193); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            pushFollow(FOLLOW_block_in_program200);
            block9=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block9.getTree());
            END_PROGRAM10=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program204); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:292:16: (id2= ID )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:292:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program210); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);
                    }

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:292:26: ( NEWLINE )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==NEWLINE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:292:27: NEWLINE
            	    {
            	    NEWLINE11=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program215); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class declarations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarations"
    // src/glossa/grammars/Glossa.g:294:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl12 = null;

        GlossaParser.varDecl_return varDecl13 = null;



        try {
            // src/glossa/grammars/Glossa.g:295:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/grammars/Glossa.g:295:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/grammars/Glossa.g:295:4: ( constDecl )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==CONSTANTS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations229);
                    constDecl12=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constDecl12.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:295:15: ( varDecl )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==VARIABLES) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations232);
                    varDecl13=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl13.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declarations"

    public static class constDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constDecl"
    // src/glossa/grammars/Glossa.g:297:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
    public final GlossaParser.constDecl_return constDecl() throws RecognitionException {
        GlossaParser.constDecl_return retval = new GlossaParser.constDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONSTANTS14=null;
        Token NEWLINE15=null;
        GlossaParser.constAssign_return constAssign16 = null;


        CommonTree CONSTANTS14_tree=null;
        CommonTree NEWLINE15_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:298:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/grammars/Glossa.g:298:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS14=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CONSTANTS14_tree = (CommonTree)adaptor.create(CONSTANTS14);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS14_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:298:15: ( NEWLINE )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==NEWLINE) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:298:16: NEWLINE
            	    {
            	    NEWLINE15=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl248); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // src/glossa/grammars/Glossa.g:298:27: ( constAssign )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl253);
            	    constAssign16=constAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, constAssign16.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constDecl"

    public static class constAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constAssign"
    // src/glossa/grammars/Glossa.g:300:1: constAssign : ID EQ expr ( NEWLINE )+ ;
    public final GlossaParser.constAssign_return constAssign() throws RecognitionException {
        GlossaParser.constAssign_return retval = new GlossaParser.constAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID17=null;
        Token EQ18=null;
        Token NEWLINE20=null;
        GlossaParser.expr_return expr19 = null;


        CommonTree ID17_tree=null;
        CommonTree EQ18_tree=null;
        CommonTree NEWLINE20_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:301:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:301:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID17=(Token)match(input,ID,FOLLOW_ID_in_constAssign263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID17_tree = (CommonTree)adaptor.create(ID17);
            adaptor.addChild(root_0, ID17_tree);
            }
            EQ18=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQ18_tree = (CommonTree)adaptor.create(EQ18);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ18_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_constAssign268);
            expr19=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr19.getTree());
            // src/glossa/grammars/Glossa.g:301:16: ( NEWLINE )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==NEWLINE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:301:17: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign271); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constAssign"

    public static class varDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDecl"
    // src/glossa/grammars/Glossa.g:303:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
    public final GlossaParser.varDecl_return varDecl() throws RecognitionException {
        GlossaParser.varDecl_return retval = new GlossaParser.varDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLES21=null;
        Token NEWLINE22=null;
        GlossaParser.varsDecl_return varsDecl23 = null;


        CommonTree VARIABLES21_tree=null;
        CommonTree NEWLINE22_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:303:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/grammars/Glossa.g:303:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES21=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl283); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            VARIABLES21_tree = (CommonTree)adaptor.create(VARIABLES21);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES21_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:303:22: ( NEWLINE )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==NEWLINE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:303:23: NEWLINE
            	    {
            	    NEWLINE22=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl287); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // src/glossa/grammars/Glossa.g:303:34: ( varsDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=BOOLEANS && LA13_0<=REALS)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl292);
            	    varsDecl23=varsDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varsDecl23.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varDecl"

    public static class varsDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varsDecl"
    // src/glossa/grammars/Glossa.g:305:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
    public final GlossaParser.varsDecl_return varsDecl() throws RecognitionException {
        GlossaParser.varsDecl_return retval = new GlossaParser.varsDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON25=null;
        Token COMMA27=null;
        Token NEWLINE29=null;
        GlossaParser.varType_return varType24 = null;

        GlossaParser.varDeclItem_return varDeclItem26 = null;

        GlossaParser.varDeclItem_return varDeclItem28 = null;


        CommonTree COLON25_tree=null;
        CommonTree COMMA27_tree=null;
        CommonTree NEWLINE29_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:306:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:306:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl303);
            varType24=varType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(varType24.getTree(), root_0);
            COLON25=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl306); if (state.failed) return retval;
            pushFollow(FOLLOW_varDeclItem_in_varsDecl309);
            varDeclItem26=varDeclItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem26.getTree());
            // src/glossa/grammars/Glossa.g:306:32: ( COMMA varDeclItem )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:306:33: COMMA varDeclItem
            	    {
            	    COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl312); if (state.failed) return retval;
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl315);
            	    varDeclItem28=varDeclItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem28.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:306:54: ( NEWLINE )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==NEWLINE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:306:55: NEWLINE
            	    {
            	    NEWLINE29=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl320); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varsDecl"

    public static class varDeclItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDeclItem"
    // src/glossa/grammars/Glossa.g:308:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
    public final GlossaParser.varDeclItem_return varDeclItem() throws RecognitionException {
        GlossaParser.varDeclItem_return retval = new GlossaParser.varDeclItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID30=null;
        Token ID31=null;
        GlossaParser.arrayDimension_return arrayDimension32 = null;


        CommonTree ID30_tree=null;
        CommonTree ID31_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arrayDimension=new RewriteRuleSubtreeStream(adaptor,"rule arrayDimension");
        try {
            // src/glossa/grammars/Glossa.g:309:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==LBRACKET) ) {
                    alt16=2;
                }
                else if ( (LA16_1==EOF||LA16_1==NEWLINE||LA16_1==COMMA) ) {
                    alt16=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:309:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID30=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID30_tree = (CommonTree)adaptor.create(ID30);
                    adaptor.addChild(root_0, ID30_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:310:5: ID arrayDimension
                    {
                    ID31=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem339); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID31);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem341);
                    arrayDimension32=arrayDimension();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDimension.add(arrayDimension32.getTree());


                    // AST REWRITE
                    // elements: ID, arrayDimension
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 310:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/grammars/Glossa.g:310:26: ^( ARRAY ID arrayDimension )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_arrayDimension.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varDeclItem"

    public static class arrayDimension_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayDimension"
    // src/glossa/grammars/Glossa.g:312:1: arrayDimension : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final GlossaParser.arrayDimension_return arrayDimension() throws RecognitionException {
        GlossaParser.arrayDimension_return retval = new GlossaParser.arrayDimension_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET33=null;
        Token COMMA34=null;
        Token RBRACKET35=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET33_tree=null;
        CommonTree COMMA34_tree=null;
        CommonTree RBRACKET35_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:313:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/Glossa.g:313:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET33=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension360); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET33);

            // src/glossa/grammars/Glossa.g:313:13: (dimension+= expr )
            // src/glossa/grammars/Glossa.g:313:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arrayDimension365);
            dimension=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/grammars/Glossa.g:313:31: ( COMMA dimension+= expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:313:32: COMMA dimension+= expr
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayDimension369); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_expr_in_arrayDimension373);
            	    dimension=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            RBRACKET35=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension377); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET35);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 313:65: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/grammars/Glossa.g:313:68: ^( ARRAY_DIMENSION ( expr )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_DIMENSION, "ARRAY_DIMENSION"), root_1);

                if ( !(stream_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayDimension"

    public static class varType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varType"
    // src/glossa/grammars/Glossa.g:315:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:315:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set36=(Token)input.LT(1);
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set36));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varType"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // src/glossa/grammars/Glossa.g:320:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm37 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/grammars/Glossa.g:320:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/grammars/Glossa.g:320:9: ( stm )*
            {
            // src/glossa/grammars/Glossa.g:320:9: ( stm )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==ID||(LA18_0>=PRINT && LA18_0<=READ)||LA18_0==IF||LA18_0==SWITCH||LA18_0==FOR||LA18_0==WHILE||LA18_0==REPEAT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block420);
            	    stm37=stm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stm.add(stm37.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: stm
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 320:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/grammars/Glossa.g:320:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/grammars/Glossa.g:320:26: ( stm )*
                while ( stream_stm.hasNext() ) {
                    adaptor.addChild(root_1, stream_stm.nextTree());

                }
                stream_stm.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class stm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stm"
    // src/glossa/grammars/Glossa.g:322:1: stm : ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm38 = null;

        GlossaParser.readStm_return readStm39 = null;

        GlossaParser.assingmentStm_return assingmentStm40 = null;

        GlossaParser.ifStm_return ifStm41 = null;

        GlossaParser.caseStm_return caseStm42 = null;

        GlossaParser.forStm_return forStm43 = null;

        GlossaParser.whileStm_return whileStm44 = null;

        GlossaParser.repeatStm_return repeatStm45 = null;



        try {
            // src/glossa/grammars/Glossa.g:322:5: ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm )
            int alt19=8;
            switch ( input.LA(1) ) {
            case PRINT:
                {
                alt19=1;
                }
                break;
            case READ:
                {
                alt19=2;
                }
                break;
            case ID:
                {
                alt19=3;
                }
                break;
            case IF:
                {
                alt19=4;
                }
                break;
            case SWITCH:
                {
                alt19=5;
                }
                break;
            case FOR:
                {
                alt19=6;
                }
                break;
            case WHILE:
                {
                alt19=7;
                }
                break;
            case REPEAT:
                {
                alt19=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:322:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm439);
                    printStm38=printStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, printStm38.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:323:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm457);
                    readStm39=readStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStm39.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:324:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm462);
                    assingmentStm40=assingmentStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assingmentStm40.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:325:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm480);
                    ifStm41=ifStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStm41.getTree());

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/Glossa.g:326:17: caseStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_caseStm_in_stm498);
                    caseStm42=caseStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStm42.getTree());

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/Glossa.g:327:17: forStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStm_in_stm516);
                    forStm43=forStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStm43.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/Glossa.g:328:17: whileStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStm_in_stm534);
                    whileStm44=whileStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStm44.getTree());

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/Glossa.g:329:17: repeatStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeatStm_in_stm552);
                    repeatStm45=repeatStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeatStm45.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stm"

    public static class printStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "printStm"
    // src/glossa/grammars/Glossa.g:332:1: printStm : PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT46=null;
        Token char_literal48=null;
        Token NEWLINE50=null;
        GlossaParser.expr_return expr47 = null;

        GlossaParser.expr_return expr49 = null;


        CommonTree PRINT46_tree=null;
        CommonTree char_literal48_tree=null;
        CommonTree NEWLINE50_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:333:9: ( PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:333:11: PRINT ( expr ( ',' expr )* )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT46=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm578); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRINT46_tree = (CommonTree)adaptor.create(PRINT46);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT46_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:333:18: ( expr ( ',' expr )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID||(LA21_0>=PLUS && LA21_0<=MINUS)||(LA21_0>=NOT && LA21_0<=LPAR)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:333:19: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_printStm582);
                    expr47=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr47.getTree());
                    // src/glossa/grammars/Glossa.g:333:24: ( ',' expr )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:333:26: ',' expr
                    	    {
                    	    char_literal48=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm586); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expr_in_printStm589);
                    	    expr49=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr49.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:333:41: ( NEWLINE )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==NEWLINE) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:333:42: NEWLINE
            	    {
            	    NEWLINE50=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm597); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "printStm"

    public static class readStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readStm"
    // src/glossa/grammars/Glossa.g:335:1: readStm : READ readItem ( COMMA readItem )* ( NEWLINE )+ ;
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ51=null;
        Token COMMA53=null;
        Token NEWLINE55=null;
        GlossaParser.readItem_return readItem52 = null;

        GlossaParser.readItem_return readItem54 = null;


        CommonTree READ51_tree=null;
        CommonTree COMMA53_tree=null;
        CommonTree NEWLINE55_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:335:9: ( READ readItem ( COMMA readItem )* ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:336:17: READ readItem ( COMMA readItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            READ51=(Token)match(input,READ,FOLLOW_READ_in_readStm624); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ51_tree = (CommonTree)adaptor.create(READ51);
            root_0 = (CommonTree)adaptor.becomeRoot(READ51_tree, root_0);
            }
            pushFollow(FOLLOW_readItem_in_readStm627);
            readItem52=readItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem52.getTree());
            // src/glossa/grammars/Glossa.g:336:32: ( COMMA readItem )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:336:33: COMMA readItem
            	    {
            	    COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_readStm630); if (state.failed) return retval;
            	    pushFollow(FOLLOW_readItem_in_readStm633);
            	    readItem54=readItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem54.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:336:51: ( NEWLINE )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:336:52: NEWLINE
            	    {
            	    NEWLINE55=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm638); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "readStm"

    public static class readItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readItem"
    // src/glossa/grammars/Glossa.g:339:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final GlossaParser.readItem_return readItem() throws RecognitionException {
        GlossaParser.readItem_return retval = new GlossaParser.readItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token arrId=null;
        Token varId=null;
        GlossaParser.arraySubscript_return arraySubscript56 = null;


        CommonTree arrId_tree=null;
        CommonTree varId_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:339:9: (arrId= ID arraySubscript | varId= ID )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==LBRACKET) ) {
                    alt25=1;
                }
                else if ( (LA25_1==EOF||LA25_1==NEWLINE||LA25_1==COMMA) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:340:17: arrId= ID arraySubscript
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readItem675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_readItem677);
                    arraySubscript56=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript56.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:341:17: varId= ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readItem697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "readItem"

    public static class assingmentStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assingmentStm"
    // src/glossa/grammars/Glossa.g:344:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN57=null;
        Token NEWLINE58=null;
        Token ASSIGN60=null;
        Token NEWLINE61=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript59 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN57_tree=null;
        CommonTree NEWLINE58_tree=null;
        CommonTree ASSIGN60_tree=null;
        CommonTree NEWLINE61_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:345:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==ASSIGN) ) {
                    alt28=1;
                }
                else if ( (LA28_1==LBRACKET) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:345:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);
                    }
                    ASSIGN57=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN57_tree = (CommonTree)adaptor.create(ASSIGN57);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN57_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm725);
                    varValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/grammars/Glossa.g:345:35: ( NEWLINE )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==NEWLINE) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:345:36: NEWLINE
                    	    {
                    	    NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm728); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:346:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm751); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm753);
                    arraySubscript59=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript59.getTree());
                    ASSIGN60=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN60_tree = (CommonTree)adaptor.create(ASSIGN60);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN60_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm760);
                    arrItemValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/grammars/Glossa.g:346:67: ( NEWLINE )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==NEWLINE) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:346:68: NEWLINE
                    	    {
                    	    NEWLINE61=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm763); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assingmentStm"

    public static class ifStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStm"
    // src/glossa/grammars/Glossa.g:349:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF65=null;
        Token NEWLINE66=null;
        GlossaParser.ifBlock_return ifBlock62 = null;

        GlossaParser.elseIfBlock_return elseIfBlock63 = null;

        GlossaParser.elseBlock_return elseBlock64 = null;


        CommonTree END_IF65_tree=null;
        CommonTree NEWLINE66_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/grammars/Glossa.g:349:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/grammars/Glossa.g:349:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm783);
            ifBlock62=ifBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifBlock.add(ifBlock62.getTree());
            // src/glossa/grammars/Glossa.g:349:17: ( elseIfBlock )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==ELSE_IF) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: elseIfBlock
            	    {
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm785);
            	    elseIfBlock63=elseIfBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elseIfBlock.add(elseIfBlock63.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:349:30: ( elseBlock )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ELSE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm788);
                    elseBlock64=elseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock64.getTree());

                    }
                    break;

            }

            END_IF65=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm791); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_IF.add(END_IF65);

            // src/glossa/grammars/Glossa.g:349:48: ( NEWLINE )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==NEWLINE) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:349:49: NEWLINE
            	    {
            	    NEWLINE66=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm794); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE66);


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);



            // AST REWRITE
            // elements: elseIfBlock, elseBlock, ifBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 349:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/grammars/Glossa.g:349:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/grammars/Glossa.g:349:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/grammars/Glossa.g:349:92: ( elseBlock )?
                if ( stream_elseBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseBlock.nextTree());

                }
                stream_elseBlock.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStm"

    public static class ifBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifBlock"
    // src/glossa/grammars/Glossa.g:351:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF67=null;
        Token THEN69=null;
        Token NEWLINE70=null;
        GlossaParser.expr_return expr68 = null;

        GlossaParser.block_return block71 = null;


        CommonTree IF67_tree=null;
        CommonTree THEN69_tree=null;
        CommonTree NEWLINE70_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:351:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:351:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF67=(Token)match(input,IF,FOLLOW_IF_in_ifBlock818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF67_tree = (CommonTree)adaptor.create(IF67);
            root_0 = (CommonTree)adaptor.becomeRoot(IF67_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_ifBlock821);
            expr68=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr68.getTree());
            THEN69=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock823); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:351:26: ( NEWLINE )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==NEWLINE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:351:27: NEWLINE
            	    {
            	    NEWLINE70=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock827); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            pushFollow(FOLLOW_block_in_ifBlock832);
            block71=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block71.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifBlock"

    public static class elseBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseBlock"
    // src/glossa/grammars/Glossa.g:353:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE72=null;
        Token NEWLINE73=null;
        GlossaParser.block_return block74 = null;


        CommonTree ELSE72_tree=null;
        CommonTree NEWLINE73_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:354:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:354:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE72=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock841); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE72_tree = (CommonTree)adaptor.create(ELSE72);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE72_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:354:10: ( NEWLINE )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==NEWLINE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:354:11: NEWLINE
            	    {
            	    NEWLINE73=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock845); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            pushFollow(FOLLOW_block_in_elseBlock850);
            block74=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block74.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elseBlock"

    public static class elseIfBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseIfBlock"
    // src/glossa/grammars/Glossa.g:356:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF75=null;
        Token THEN77=null;
        Token NEWLINE78=null;
        GlossaParser.expr_return expr76 = null;

        GlossaParser.block_return block79 = null;


        CommonTree ELSE_IF75_tree=null;
        CommonTree THEN77_tree=null;
        CommonTree NEWLINE78_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:357:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:357:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF75=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock859); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE_IF75_tree = (CommonTree)adaptor.create(ELSE_IF75);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF75_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_elseIfBlock862);
            expr76=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr76.getTree());
            THEN77=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock864); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:357:24: ( NEWLINE )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==NEWLINE) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:357:25: NEWLINE
            	    {
            	    NEWLINE78=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock868); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            pushFollow(FOLLOW_block_in_elseIfBlock873);
            block79=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block79.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elseIfBlock"

    public static class caseStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseStm"
    // src/glossa/grammars/Glossa.g:359:1: caseStm : SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ ;
    public final GlossaParser.caseStm_return caseStm() throws RecognitionException {
        GlossaParser.caseStm_return retval = new GlossaParser.caseStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SWITCH80=null;
        Token NEWLINE82=null;
        Token END_SWITCH85=null;
        Token NEWLINE86=null;
        GlossaParser.expr_return expr81 = null;

        GlossaParser.caseBlock_return caseBlock83 = null;

        GlossaParser.caseElseBlock_return caseElseBlock84 = null;


        CommonTree SWITCH80_tree=null;
        CommonTree NEWLINE82_tree=null;
        CommonTree END_SWITCH85_tree=null;
        CommonTree NEWLINE86_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:359:9: ( SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:359:11: SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            SWITCH80=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_caseStm881); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SWITCH80_tree = (CommonTree)adaptor.create(SWITCH80);
            root_0 = (CommonTree)adaptor.becomeRoot(SWITCH80_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_caseStm884);
            expr81=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr81.getTree());
            // src/glossa/grammars/Glossa.g:359:24: ( NEWLINE )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==NEWLINE) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:359:25: NEWLINE
            	    {
            	    NEWLINE82=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm887); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            // src/glossa/grammars/Glossa.g:359:36: ( caseBlock )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==CASE) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==ID||(LA36_1>=LT && LA36_1<=GE)||(LA36_1>=PLUS && LA36_1<=MINUS)||(LA36_1>=NOT && LA36_1<=LPAR)) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: caseBlock
            	    {
            	    pushFollow(FOLLOW_caseBlock_in_caseStm892);
            	    caseBlock83=caseBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseBlock83.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:359:47: ( caseElseBlock )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==CASE) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: caseElseBlock
                    {
                    pushFollow(FOLLOW_caseElseBlock_in_caseStm895);
                    caseElseBlock84=caseElseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseElseBlock84.getTree());

                    }
                    break;

            }

            END_SWITCH85=(Token)match(input,END_SWITCH,FOLLOW_END_SWITCH_in_caseStm898); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:359:74: ( NEWLINE )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==NEWLINE) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:359:75: NEWLINE
            	    {
            	    NEWLINE86=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm902); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseStm"

    public static class caseBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseBlock"
    // src/glossa/grammars/Glossa.g:361:1: caseBlock : CASE caseExprList ( NEWLINE )+ block ;
    public final GlossaParser.caseBlock_return caseBlock() throws RecognitionException {
        GlossaParser.caseBlock_return retval = new GlossaParser.caseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE87=null;
        Token NEWLINE89=null;
        GlossaParser.caseExprList_return caseExprList88 = null;

        GlossaParser.block_return block90 = null;


        CommonTree CASE87_tree=null;
        CommonTree NEWLINE89_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:362:2: ( CASE caseExprList ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:362:4: CASE caseExprList ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE87=(Token)match(input,CASE,FOLLOW_CASE_in_caseBlock914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE87_tree = (CommonTree)adaptor.create(CASE87);
            root_0 = (CommonTree)adaptor.becomeRoot(CASE87_tree, root_0);
            }
            pushFollow(FOLLOW_caseExprList_in_caseBlock917);
            caseExprList88=caseExprList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprList88.getTree());
            // src/glossa/grammars/Glossa.g:362:23: ( NEWLINE )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==NEWLINE) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:362:24: NEWLINE
            	    {
            	    NEWLINE89=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseBlock920); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            pushFollow(FOLLOW_block_in_caseBlock925);
            block90=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block90.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseBlock"

    public static class caseExprList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseExprList"
    // src/glossa/grammars/Glossa.g:364:1: caseExprList : caseExprListItem ( COMMA caseExprListItem )* ;
    public final GlossaParser.caseExprList_return caseExprList() throws RecognitionException {
        GlossaParser.caseExprList_return retval = new GlossaParser.caseExprList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA92=null;
        GlossaParser.caseExprListItem_return caseExprListItem91 = null;

        GlossaParser.caseExprListItem_return caseExprListItem93 = null;


        CommonTree COMMA92_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:365:2: ( caseExprListItem ( COMMA caseExprListItem )* )
            // src/glossa/grammars/Glossa.g:365:4: caseExprListItem ( COMMA caseExprListItem )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_caseExprListItem_in_caseExprList934);
            caseExprListItem91=caseExprListItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem91.getTree());
            // src/glossa/grammars/Glossa.g:365:21: ( COMMA caseExprListItem )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==COMMA) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:365:22: COMMA caseExprListItem
            	    {
            	    COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_caseExprList937); if (state.failed) return retval;
            	    pushFollow(FOLLOW_caseExprListItem_in_caseExprList940);
            	    caseExprListItem93=caseExprListItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem93.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseExprList"

    public static class caseExprListItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseExprListItem"
    // src/glossa/grammars/Glossa.g:367:1: caseExprListItem : ( rangeItem | expr | infRangeItem );
    public final GlossaParser.caseExprListItem_return caseExprListItem() throws RecognitionException {
        GlossaParser.caseExprListItem_return retval = new GlossaParser.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.rangeItem_return rangeItem94 = null;

        GlossaParser.expr_return expr95 = null;

        GlossaParser.infRangeItem_return infRangeItem96 = null;



        try {
            // src/glossa/grammars/Glossa.g:368:2: ( rangeItem | expr | infRangeItem )
            int alt41=3;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:368:5: rangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rangeItem_in_caseExprListItem952);
                    rangeItem94=rangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rangeItem94.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:368:17: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_caseExprListItem956);
                    expr95=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr95.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:368:24: infRangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infRangeItem_in_caseExprListItem960);
                    infRangeItem96=infRangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infRangeItem96.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseExprListItem"

    public static class rangeItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rangeItem"
    // src/glossa/grammars/Glossa.g:370:1: rangeItem : expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) ;
    public final GlossaParser.rangeItem_return rangeItem() throws RecognitionException {
        GlossaParser.rangeItem_return retval = new GlossaParser.rangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RANGE97=null;
        GlossaParser.expr_return expr1 = null;

        GlossaParser.expr_return expr2 = null;


        CommonTree RANGE97_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:371:9: (expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) )
            // src/glossa/grammars/Glossa.g:371:17: expr1= expr RANGE expr2= expr
            {
            pushFollow(FOLLOW_expr_in_rangeItem984);
            expr1=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr1.getTree());
            RANGE97=(Token)match(input,RANGE,FOLLOW_RANGE_in_rangeItem986); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE97);

            pushFollow(FOLLOW_expr_in_rangeItem990);
            expr2=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr2.getTree());


            // AST REWRITE
            // elements: RANGE, expr2, expr1
            // token labels: 
            // rule labels: retval, expr1, expr2
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_expr1=new RewriteRuleSubtreeStream(adaptor,"rule expr1",expr1!=null?expr1.tree:null);
            RewriteRuleSubtreeStream stream_expr2=new RewriteRuleSubtreeStream(adaptor,"rule expr2",expr2!=null?expr2.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 371:45: -> ^( RANGE $expr1 $expr2)
            {
                // src/glossa/grammars/Glossa.g:371:48: ^( RANGE $expr1 $expr2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr1.nextTree());
                adaptor.addChild(root_1, stream_expr2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rangeItem"

    public static class infRangeItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infRangeItem"
    // src/glossa/grammars/Glossa.g:373:1: infRangeItem : ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) );
    public final GlossaParser.infRangeItem_return infRangeItem() throws RecognitionException {
        GlossaParser.infRangeItem_return retval = new GlossaParser.infRangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT98=null;
        Token LE100=null;
        Token GT102=null;
        Token GE104=null;
        GlossaParser.expr_return expr99 = null;

        GlossaParser.expr_return expr101 = null;

        GlossaParser.expr_return expr103 = null;

        GlossaParser.expr_return expr105 = null;


        CommonTree LT98_tree=null;
        CommonTree LE100_tree=null;
        CommonTree GT102_tree=null;
        CommonTree GE104_tree=null;
        RewriteRuleTokenStream stream_GE=new RewriteRuleTokenStream(adaptor,"token GE");
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
        RewriteRuleTokenStream stream_LE=new RewriteRuleTokenStream(adaptor,"token LE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:374:9: ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt42=1;
                }
                break;
            case LE:
                {
                alt42=2;
                }
                break;
            case GT:
                {
                alt42=3;
                }
                break;
            case GE:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:374:17: LT expr
                    {
                    LT98=(Token)match(input,LT,FOLLOW_LT_in_infRangeItem1024); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LT.add(LT98);

                    pushFollow(FOLLOW_expr_in_infRangeItem1026);
                    expr99=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr99.getTree());


                    // AST REWRITE
                    // elements: LT, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 374:25: -> ^( INF_RANGE LT expr )
                    {
                        // src/glossa/grammars/Glossa.g:374:28: ^( INF_RANGE LT expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INF_RANGE, "INF_RANGE"), root_1);

                        adaptor.addChild(root_1, stream_LT.nextNode());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:375:17: LE expr
                    {
                    LE100=(Token)match(input,LE,FOLLOW_LE_in_infRangeItem1054); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LE.add(LE100);

                    pushFollow(FOLLOW_expr_in_infRangeItem1056);
                    expr101=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr101.getTree());


                    // AST REWRITE
                    // elements: LE, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 375:25: -> ^( INF_RANGE LE expr )
                    {
                        // src/glossa/grammars/Glossa.g:375:28: ^( INF_RANGE LE expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INF_RANGE, "INF_RANGE"), root_1);

                        adaptor.addChild(root_1, stream_LE.nextNode());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:376:17: GT expr
                    {
                    GT102=(Token)match(input,GT,FOLLOW_GT_in_infRangeItem1084); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GT.add(GT102);

                    pushFollow(FOLLOW_expr_in_infRangeItem1086);
                    expr103=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr103.getTree());


                    // AST REWRITE
                    // elements: GT, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 376:25: -> ^( INF_RANGE GT expr )
                    {
                        // src/glossa/grammars/Glossa.g:376:28: ^( INF_RANGE GT expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INF_RANGE, "INF_RANGE"), root_1);

                        adaptor.addChild(root_1, stream_GT.nextNode());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:377:17: GE expr
                    {
                    GE104=(Token)match(input,GE,FOLLOW_GE_in_infRangeItem1114); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GE.add(GE104);

                    pushFollow(FOLLOW_expr_in_infRangeItem1116);
                    expr105=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr105.getTree());


                    // AST REWRITE
                    // elements: GE, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 377:25: -> ^( INF_RANGE GE expr )
                    {
                        // src/glossa/grammars/Glossa.g:377:28: ^( INF_RANGE GE expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INF_RANGE, "INF_RANGE"), root_1);

                        adaptor.addChild(root_1, stream_GE.nextNode());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "infRangeItem"

    public static class caseElseBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseElseBlock"
    // src/glossa/grammars/Glossa.g:380:1: caseElseBlock : CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) ;
    public final GlossaParser.caseElseBlock_return caseElseBlock() throws RecognitionException {
        GlossaParser.caseElseBlock_return retval = new GlossaParser.caseElseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE106=null;
        Token ELSE107=null;
        Token NEWLINE108=null;
        GlossaParser.block_return block109 = null;


        CommonTree CASE106_tree=null;
        CommonTree ELSE107_tree=null;
        CommonTree NEWLINE108_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/glossa/grammars/Glossa.g:381:2: ( CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) )
            // src/glossa/grammars/Glossa.g:381:4: CASE ELSE ( NEWLINE )+ block
            {
            CASE106=(Token)match(input,CASE,FOLLOW_CASE_in_caseElseBlock1144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CASE.add(CASE106);

            ELSE107=(Token)match(input,ELSE,FOLLOW_ELSE_in_caseElseBlock1146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE.add(ELSE107);

            // src/glossa/grammars/Glossa.g:381:14: ( NEWLINE )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==NEWLINE) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE108=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseElseBlock1148); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE108);


            	    }
            	    break;

            	default :
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            pushFollow(FOLLOW_block_in_caseElseBlock1151);
            block109=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block109.getTree());


            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 381:29: -> ^( CASE_ELSE block )
            {
                // src/glossa/grammars/Glossa.g:381:32: ^( CASE_ELSE block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CASE_ELSE, "CASE_ELSE"), root_1);

                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseElseBlock"

    public static class forStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStm"
    // src/glossa/grammars/Glossa.g:382:1: forStm : FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.forStm_return forStm() throws RecognitionException {
        GlossaParser.forStm_return retval = new GlossaParser.forStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR110=null;
        Token ID111=null;
        Token FROM113=null;
        Token TO114=null;
        Token STEP115=null;
        Token NEWLINE116=null;
        Token END_LOOP118=null;
        Token NEWLINE119=null;
        GlossaParser.expr_return from = null;

        GlossaParser.expr_return to = null;

        GlossaParser.expr_return step = null;

        GlossaParser.arraySubscript_return arraySubscript112 = null;

        GlossaParser.block_return block117 = null;


        CommonTree FOR110_tree=null;
        CommonTree ID111_tree=null;
        CommonTree FROM113_tree=null;
        CommonTree TO114_tree=null;
        CommonTree STEP115_tree=null;
        CommonTree NEWLINE116_tree=null;
        CommonTree END_LOOP118_tree=null;
        CommonTree NEWLINE119_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:382:8: ( FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:382:10: FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            FOR110=(Token)match(input,FOR,FOLLOW_FOR_in_forStm1166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR110_tree = (CommonTree)adaptor.create(FOR110);
            root_0 = (CommonTree)adaptor.becomeRoot(FOR110_tree, root_0);
            }
            ID111=(Token)match(input,ID,FOLLOW_ID_in_forStm1169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID111_tree = (CommonTree)adaptor.create(ID111);
            adaptor.addChild(root_0, ID111_tree);
            }
            // src/glossa/grammars/Glossa.g:382:18: ( arraySubscript )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LBRACKET) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: arraySubscript
                    {
                    pushFollow(FOLLOW_arraySubscript_in_forStm1171);
                    arraySubscript112=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript112.getTree());

                    }
                    break;

            }

            FROM113=(Token)match(input,FROM,FOLLOW_FROM_in_forStm1174); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1179);
            from=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, from.getTree());
            TO114=(Token)match(input,TO,FOLLOW_TO_in_forStm1181); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1186);
            to=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, to.getTree());
            // src/glossa/grammars/Glossa.g:382:62: ( STEP step= expr )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==STEP) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:382:63: STEP step= expr
                    {
                    STEP115=(Token)match(input,STEP,FOLLOW_STEP_in_forStm1189); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_forStm1194);
                    step=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, step.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:382:81: ( NEWLINE )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==NEWLINE) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:382:82: NEWLINE
            	    {
            	    NEWLINE116=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1199); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);

            pushFollow(FOLLOW_block_in_forStm1204);
            block117=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block117.getTree());
            END_LOOP118=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_forStm1206); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:382:109: ( NEWLINE )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==NEWLINE) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:382:110: NEWLINE
            	    {
            	    NEWLINE119=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1210); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forStm"

    public static class whileStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStm"
    // src/glossa/grammars/Glossa.g:385:1: whileStm : WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.whileStm_return whileStm() throws RecognitionException {
        GlossaParser.whileStm_return retval = new GlossaParser.whileStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE120=null;
        Token LOOP122=null;
        Token NEWLINE123=null;
        Token END_LOOP125=null;
        Token NEWLINE126=null;
        GlossaParser.expr_return expr121 = null;

        GlossaParser.block_return block124 = null;


        CommonTree WHILE120_tree=null;
        CommonTree LOOP122_tree=null;
        CommonTree NEWLINE123_tree=null;
        CommonTree END_LOOP125_tree=null;
        CommonTree NEWLINE126_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:386:9: ( WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:386:11: WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            WHILE120=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStm1238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE120_tree = (CommonTree)adaptor.create(WHILE120);
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE120_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_whileStm1241);
            expr121=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr121.getTree());
            LOOP122=(Token)match(input,LOOP,FOLLOW_LOOP_in_whileStm1243); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:386:29: ( NEWLINE )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==NEWLINE) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:386:30: NEWLINE
            	    {
            	    NEWLINE123=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1247); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            pushFollow(FOLLOW_block_in_whileStm1252);
            block124=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block124.getTree());
            END_LOOP125=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_whileStm1254); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:386:57: ( NEWLINE )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==NEWLINE) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:386:58: NEWLINE
            	    {
            	    NEWLINE126=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1258); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whileStm"

    public static class repeatStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeatStm"
    // src/glossa/grammars/Glossa.g:388:1: repeatStm : REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ ;
    public final GlossaParser.repeatStm_return repeatStm() throws RecognitionException {
        GlossaParser.repeatStm_return retval = new GlossaParser.repeatStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REPEAT127=null;
        Token NEWLINE128=null;
        Token UNTIL130=null;
        Token NEWLINE132=null;
        GlossaParser.block_return block129 = null;

        GlossaParser.expr_return expr131 = null;


        CommonTree REPEAT127_tree=null;
        CommonTree NEWLINE128_tree=null;
        CommonTree UNTIL130_tree=null;
        CommonTree NEWLINE132_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:389:2: ( REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:389:4: REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            REPEAT127=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeatStm1270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REPEAT127_tree = (CommonTree)adaptor.create(REPEAT127);
            root_0 = (CommonTree)adaptor.becomeRoot(REPEAT127_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:389:12: ( NEWLINE )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==NEWLINE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:389:13: NEWLINE
            	    {
            	    NEWLINE128=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1274); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            pushFollow(FOLLOW_block_in_repeatStm1279);
            block129=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block129.getTree());
            UNTIL130=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_repeatStm1281); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_repeatStm1284);
            expr131=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr131.getTree());
            // src/glossa/grammars/Glossa.g:389:42: ( NEWLINE )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==NEWLINE) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:389:43: NEWLINE
            	    {
            	    NEWLINE132=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1287); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeatStm"

    public static class paramsList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "paramsList"
    // src/glossa/grammars/Glossa.g:391:1: paramsList : (params+= expr ( COMMA params+= expr )* )? -> ^( PARAMS ( $params)* ) ;
    public final GlossaParser.paramsList_return paramsList() throws RecognitionException {
        GlossaParser.paramsList_return retval = new GlossaParser.paramsList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA133=null;
        List list_params=null;
        RuleReturnScope params = null;
        CommonTree COMMA133_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:392:2: ( (params+= expr ( COMMA params+= expr )* )? -> ^( PARAMS ( $params)* ) )
            // src/glossa/grammars/Glossa.g:392:4: (params+= expr ( COMMA params+= expr )* )?
            {
            // src/glossa/grammars/Glossa.g:392:4: (params+= expr ( COMMA params+= expr )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==ID||(LA53_0>=PLUS && LA53_0<=MINUS)||(LA53_0>=NOT && LA53_0<=LPAR)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:392:5: params+= expr ( COMMA params+= expr )*
                    {
                    pushFollow(FOLLOW_expr_in_paramsList1302);
                    params=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(params.getTree());
                    if (list_params==null) list_params=new ArrayList();
                    list_params.add(params.getTree());

                    // src/glossa/grammars/Glossa.g:392:18: ( COMMA params+= expr )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==COMMA) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:392:19: COMMA params+= expr
                    	    {
                    	    COMMA133=(Token)match(input,COMMA,FOLLOW_COMMA_in_paramsList1305); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA133);

                    	    pushFollow(FOLLOW_expr_in_paramsList1309);
                    	    params=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(params.getTree());
                    	    if (list_params==null) list_params=new ArrayList();
                    	    list_params.add(params.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }



            // AST REWRITE
            // elements: params
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: params
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"token params",list_params);
            root_0 = (CommonTree)adaptor.nil();
            // 392:42: -> ^( PARAMS ( $params)* )
            {
                // src/glossa/grammars/Glossa.g:392:45: ^( PARAMS ( $params)* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMS, "PARAMS"), root_1);

                // src/glossa/grammars/Glossa.g:392:54: ( $params)*
                while ( stream_params.hasNext() ) {
                    adaptor.addChild(root_1, stream_params.nextTree());

                }
                stream_params.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "paramsList"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/grammars/Glossa.g:394:1: expr : andExpr ( OR andExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR135=null;
        GlossaParser.andExpr_return andExpr134 = null;

        GlossaParser.andExpr_return andExpr136 = null;


        CommonTree OR135_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:394:6: ( andExpr ( OR andExpr )* )
            // src/glossa/grammars/Glossa.g:394:8: andExpr ( OR andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_expr1331);
            andExpr134=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr134.getTree());
            // src/glossa/grammars/Glossa.g:394:16: ( OR andExpr )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==OR) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:394:18: OR andExpr
            	    {
            	    OR135=(Token)match(input,OR,FOLLOW_OR_in_expr1335); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR135_tree = (CommonTree)adaptor.create(OR135);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR135_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_expr1338);
            	    andExpr136=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr136.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class andExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // src/glossa/grammars/Glossa.g:396:1: andExpr : eqExpr ( AND eqExpr )* ;
    public final GlossaParser.andExpr_return andExpr() throws RecognitionException {
        GlossaParser.andExpr_return retval = new GlossaParser.andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND138=null;
        GlossaParser.eqExpr_return eqExpr137 = null;

        GlossaParser.eqExpr_return eqExpr139 = null;


        CommonTree AND138_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:396:9: ( eqExpr ( AND eqExpr )* )
            // src/glossa/grammars/Glossa.g:396:17: eqExpr ( AND eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_andExpr1354);
            eqExpr137=eqExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr137.getTree());
            // src/glossa/grammars/Glossa.g:396:24: ( AND eqExpr )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==AND) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:396:25: AND eqExpr
            	    {
            	    AND138=(Token)match(input,AND,FOLLOW_AND_in_andExpr1357); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND138_tree = (CommonTree)adaptor.create(AND138);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND138_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_eqExpr_in_andExpr1360);
            	    eqExpr139=eqExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr139.getTree());

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // src/glossa/grammars/Glossa.g:398:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ141=null;
        Token NEQ143=null;
        GlossaParser.compExpr_return compExpr140 = null;

        GlossaParser.compExpr_return compExpr142 = null;

        GlossaParser.compExpr_return compExpr144 = null;


        CommonTree EQ141_tree=null;
        CommonTree NEQ143_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:398:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/grammars/Glossa.g:398:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr1370);
            compExpr140=compExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr140.getTree());
            // src/glossa/grammars/Glossa.g:398:19: ( EQ compExpr | NEQ compExpr )*
            loop56:
            do {
                int alt56=3;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==EQ) ) {
                    alt56=1;
                }
                else if ( (LA56_0==NEQ) ) {
                    alt56=2;
                }


                switch (alt56) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:398:20: EQ compExpr
            	    {
            	    EQ141=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr1373); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    EQ141_tree = (CommonTree)adaptor.create(EQ141);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ141_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1376);
            	    compExpr142=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr142.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:398:35: NEQ compExpr
            	    {
            	    NEQ143=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr1380); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEQ143_tree = (CommonTree)adaptor.create(NEQ143);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ143_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1383);
            	    compExpr144=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr144.getTree());

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "eqExpr"

    public static class compExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compExpr"
    // src/glossa/grammars/Glossa.g:400:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT146=null;
        Token LE148=null;
        Token GT150=null;
        Token GE152=null;
        GlossaParser.addExpr_return addExpr145 = null;

        GlossaParser.addExpr_return addExpr147 = null;

        GlossaParser.addExpr_return addExpr149 = null;

        GlossaParser.addExpr_return addExpr151 = null;

        GlossaParser.addExpr_return addExpr153 = null;


        CommonTree LT146_tree=null;
        CommonTree LE148_tree=null;
        CommonTree GT150_tree=null;
        CommonTree GE152_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:400:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/grammars/Glossa.g:400:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr1394);
            addExpr145=addExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr145.getTree());
            // src/glossa/grammars/Glossa.g:400:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop57:
            do {
                int alt57=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt57=1;
                    }
                    break;
                case LE:
                    {
                    alt57=2;
                    }
                    break;
                case GT:
                    {
                    alt57=3;
                    }
                    break;
                case GE:
                    {
                    alt57=4;
                    }
                    break;

                }

                switch (alt57) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:400:20: LT addExpr
            	    {
            	    LT146=(Token)match(input,LT,FOLLOW_LT_in_compExpr1397); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LT146_tree = (CommonTree)adaptor.create(LT146);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT146_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1400);
            	    addExpr147=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr147.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:400:34: LE addExpr
            	    {
            	    LE148=(Token)match(input,LE,FOLLOW_LE_in_compExpr1404); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LE148_tree = (CommonTree)adaptor.create(LE148);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE148_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1407);
            	    addExpr149=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr149.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/grammars/Glossa.g:400:48: GT addExpr
            	    {
            	    GT150=(Token)match(input,GT,FOLLOW_GT_in_compExpr1411); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GT150_tree = (CommonTree)adaptor.create(GT150);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT150_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1414);
            	    addExpr151=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr151.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/grammars/Glossa.g:400:62: GE addExpr
            	    {
            	    GE152=(Token)match(input,GE,FOLLOW_GE_in_compExpr1418); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GE152_tree = (CommonTree)adaptor.create(GE152);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE152_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1421);
            	    addExpr153=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr153.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // src/glossa/grammars/Glossa.g:402:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS155=null;
        Token MINUS157=null;
        GlossaParser.multExpr_return multExpr154 = null;

        GlossaParser.multExpr_return multExpr156 = null;

        GlossaParser.multExpr_return multExpr158 = null;


        CommonTree PLUS155_tree=null;
        CommonTree MINUS157_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:402:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/grammars/Glossa.g:402:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr1434);
            multExpr154=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr154.getTree());
            // src/glossa/grammars/Glossa.g:402:20: ( PLUS multExpr | MINUS multExpr )*
            loop58:
            do {
                int alt58=3;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==PLUS) ) {
                    alt58=1;
                }
                else if ( (LA58_0==MINUS) ) {
                    alt58=2;
                }


                switch (alt58) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:402:21: PLUS multExpr
            	    {
            	    PLUS155=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr1437); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    PLUS155_tree = (CommonTree)adaptor.create(PLUS155);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS155_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1440);
            	    multExpr156=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr156.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:402:38: MINUS multExpr
            	    {
            	    MINUS157=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr1444); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MINUS157_tree = (CommonTree)adaptor.create(MINUS157);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS157_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1447);
            	    multExpr158=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr158.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // src/glossa/grammars/Glossa.g:404:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES160=null;
        Token DIA162=null;
        Token DIV164=null;
        Token MOD166=null;
        GlossaParser.powExpr_return powExpr159 = null;

        GlossaParser.powExpr_return powExpr161 = null;

        GlossaParser.powExpr_return powExpr163 = null;

        GlossaParser.powExpr_return powExpr165 = null;

        GlossaParser.powExpr_return powExpr167 = null;


        CommonTree TIMES160_tree=null;
        CommonTree DIA162_tree=null;
        CommonTree DIV164_tree=null;
        CommonTree MOD166_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:404:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/grammars/Glossa.g:404:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr1459);
            powExpr159=powExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr159.getTree());
            // src/glossa/grammars/Glossa.g:404:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop59:
            do {
                int alt59=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt59=1;
                    }
                    break;
                case DIA:
                    {
                    alt59=2;
                    }
                    break;
                case DIV:
                    {
                    alt59=3;
                    }
                    break;
                case MOD:
                    {
                    alt59=4;
                    }
                    break;

                }

                switch (alt59) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:404:21: TIMES powExpr
            	    {
            	    TIMES160=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr1462); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TIMES160_tree = (CommonTree)adaptor.create(TIMES160);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES160_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1465);
            	    powExpr161=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr161.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:404:38: DIA powExpr
            	    {
            	    DIA162=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr1469); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIA162_tree = (CommonTree)adaptor.create(DIA162);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA162_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1472);
            	    powExpr163=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr163.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/grammars/Glossa.g:404:53: DIV powExpr
            	    {
            	    DIV164=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr1476); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV164_tree = (CommonTree)adaptor.create(DIV164);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV164_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1479);
            	    powExpr165=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr165.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/grammars/Glossa.g:404:68: MOD powExpr
            	    {
            	    MOD166=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr1483); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MOD166_tree = (CommonTree)adaptor.create(MOD166);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD166_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1486);
            	    powExpr167=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr167.getTree());

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpr"
    // src/glossa/grammars/Glossa.g:406:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW169=null;
        GlossaParser.unaryExpr_return unaryExpr168 = null;

        GlossaParser.unaryExpr_return unaryExpr170 = null;


        CommonTree POW169_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:406:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/grammars/Glossa.g:406:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr1498);
            unaryExpr168=unaryExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr168.getTree());
            // src/glossa/grammars/Glossa.g:406:21: ( POW unaryExpr )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==POW) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:406:22: POW unaryExpr
            	    {
            	    POW169=(Token)match(input,POW,FOLLOW_POW_in_powExpr1501); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW169_tree = (CommonTree)adaptor.create(POW169);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW169_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_unaryExpr_in_powExpr1504);
            	    unaryExpr170=unaryExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr170.getTree());

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "powExpr"

    public static class unaryExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpr"
    // src/glossa/grammars/Glossa.g:408:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS171=null;
        Token MINUS173=null;
        Token NOT175=null;
        GlossaParser.atom_return atom172 = null;

        GlossaParser.atom_return atom174 = null;

        GlossaParser.atom_return atom176 = null;

        GlossaParser.atom_return atom177 = null;


        CommonTree PLUS171_tree=null;
        CommonTree MINUS173_tree=null;
        CommonTree NOT175_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/grammars/Glossa.g:409:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt61=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt61=1;
                }
                break;
            case MINUS:
                {
                alt61=2;
                }
                break;
            case NOT:
                {
                alt61=3;
                }
                break;
            case ID:
            case CONST_TRUE:
            case CONST_FALSE:
            case CONST_STR:
            case CONST_INT:
            case CONST_REAL:
            case LPAR:
                {
                alt61=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:409:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS171=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr1515); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_unaryExpr1518);
                    atom172=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom172.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:410:4: MINUS atom
                    {
                    MINUS173=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr1523); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS173);

                    pushFollow(FOLLOW_atom_in_unaryExpr1525);
                    atom174=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom174.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 410:15: -> ^( NEG atom )
                    {
                        // src/glossa/grammars/Glossa.g:410:18: ^( NEG atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEG, "NEG"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:411:4: NOT atom
                    {
                    NOT175=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr1538); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT175);

                    pushFollow(FOLLOW_atom_in_unaryExpr1540);
                    atom176=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom176.getTree());


                    // AST REWRITE
                    // elements: NOT, atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 411:13: -> ^( NOT atom )
                    {
                        // src/glossa/grammars/Glossa.g:411:16: ^( NOT atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:412:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr1553);
                    atom177=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom177.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpr"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/glossa/grammars/Glossa.g:415:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE178=null;
        Token CONST_FALSE179=null;
        Token CONST_STR180=null;
        Token CONST_INT181=null;
        Token CONST_REAL182=null;
        Token ID184=null;
        Token char_literal186=null;
        Token char_literal188=null;
        GlossaParser.arrayItem_return arrayItem183 = null;

        GlossaParser.functionCall_return functionCall185 = null;

        GlossaParser.expr_return expr187 = null;


        CommonTree CONST_TRUE178_tree=null;
        CommonTree CONST_FALSE179_tree=null;
        CommonTree CONST_STR180_tree=null;
        CommonTree CONST_INT181_tree=null;
        CommonTree CONST_REAL182_tree=null;
        CommonTree ID184_tree=null;
        CommonTree char_literal186_tree=null;
        CommonTree char_literal188_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:415:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' )
            int alt62=9;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:415:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE178=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom1562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_TRUE178_tree = (CommonTree)adaptor.create(CONST_TRUE178);
                    adaptor.addChild(root_0, CONST_TRUE178_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:416:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE179=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom1567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_FALSE179_tree = (CommonTree)adaptor.create(CONST_FALSE179);
                    adaptor.addChild(root_0, CONST_FALSE179_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:417:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR180=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom1572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_STR180_tree = (CommonTree)adaptor.create(CONST_STR180);
                    adaptor.addChild(root_0, CONST_STR180_tree);
                    }

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:418:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT181=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom1577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_INT181_tree = (CommonTree)adaptor.create(CONST_INT181);
                    adaptor.addChild(root_0, CONST_INT181_tree);
                    }

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/Glossa.g:419:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL182=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom1582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_REAL182_tree = (CommonTree)adaptor.create(CONST_REAL182);
                    adaptor.addChild(root_0, CONST_REAL182_tree);
                    }

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/Glossa.g:420:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom1587);
                    arrayItem183=arrayItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayItem183.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/Glossa.g:421:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID184=(Token)match(input,ID,FOLLOW_ID_in_atom1592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID184_tree = (CommonTree)adaptor.create(ID184);
                    adaptor.addChild(root_0, ID184_tree);
                    }

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/Glossa.g:422:11: functionCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_atom1604);
                    functionCall185=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall185.getTree());

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/Glossa.g:423:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal186=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1609); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1612);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr187.getTree());
                    char_literal188=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1614); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class functionCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // src/glossa/grammars/Glossa.g:425:1: functionCall : ID LPAR paramsList RPAR -> ^( FUNC_CALL ID paramsList ) ;
    public final GlossaParser.functionCall_return functionCall() throws RecognitionException {
        GlossaParser.functionCall_return retval = new GlossaParser.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID189=null;
        Token LPAR190=null;
        Token RPAR192=null;
        GlossaParser.paramsList_return paramsList191 = null;


        CommonTree ID189_tree=null;
        CommonTree LPAR190_tree=null;
        CommonTree RPAR192_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_paramsList=new RewriteRuleSubtreeStream(adaptor,"rule paramsList");
        try {
            // src/glossa/grammars/Glossa.g:426:2: ( ID LPAR paramsList RPAR -> ^( FUNC_CALL ID paramsList ) )
            // src/glossa/grammars/Glossa.g:426:4: ID LPAR paramsList RPAR
            {
            ID189=(Token)match(input,ID,FOLLOW_ID_in_functionCall1624); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID189);

            LPAR190=(Token)match(input,LPAR,FOLLOW_LPAR_in_functionCall1626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR190);

            pushFollow(FOLLOW_paramsList_in_functionCall1628);
            paramsList191=paramsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_paramsList.add(paramsList191.getTree());
            RPAR192=(Token)match(input,RPAR,FOLLOW_RPAR_in_functionCall1630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR192);



            // AST REWRITE
            // elements: ID, paramsList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 426:28: -> ^( FUNC_CALL ID paramsList )
            {
                // src/glossa/grammars/Glossa.g:426:31: ^( FUNC_CALL ID paramsList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_paramsList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class arrayItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayItem"
    // src/glossa/grammars/Glossa.g:428:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID193=null;
        GlossaParser.arraySubscript_return arraySubscript194 = null;


        CommonTree ID193_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/grammars/Glossa.g:429:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/grammars/Glossa.g:429:4: ID arraySubscript
            {
            ID193=(Token)match(input,ID,FOLLOW_ID_in_arrayItem1650); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID193);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem1652);
            arraySubscript194=arraySubscript();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arraySubscript.add(arraySubscript194.getTree());


            // AST REWRITE
            // elements: ID, arraySubscript
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 429:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/grammars/Glossa.g:429:25: ^( ARRAY_ITEM ID arraySubscript )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_ITEM, "ARRAY_ITEM"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_arraySubscript.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayItem"

    public static class arraySubscript_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arraySubscript"
    // src/glossa/grammars/Glossa.g:431:1: arraySubscript : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET195=null;
        Token COMMA196=null;
        Token RBRACKET197=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET195_tree=null;
        CommonTree COMMA196_tree=null;
        CommonTree RBRACKET197_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:432:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/Glossa.g:432:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET195=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET195);

            // src/glossa/grammars/Glossa.g:432:13: (dimension+= expr )
            // src/glossa/grammars/Glossa.g:432:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arraySubscript1677);
            dimension=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/grammars/Glossa.g:432:31: ( COMMA dimension+= expr )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==COMMA) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:432:32: COMMA dimension+= expr
            	    {
            	    COMMA196=(Token)match(input,COMMA,FOLLOW_COMMA_in_arraySubscript1681); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA196);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1685);
            	    dimension=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            RBRACKET197=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1689); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET197);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 432:65: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/grammars/Glossa.g:432:68: ^( ARRAY_INDEX ( expr )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_INDEX, "ARRAY_INDEX"), root_1);

                if ( !(stream_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arraySubscript"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // src/glossa/grammars/Glossa.g:435:1: function : FUNCTION id= ID LPAR formalParamsList RPAR COLON ret= returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+ -> ^( FUNCTION $id $ret formalParamsList ( constDecl )? ( varDecl )? block ) ;
    public final GlossaParser.function_return function() throws RecognitionException {
        GlossaParser.function_return retval = new GlossaParser.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id=null;
        Token FUNCTION198=null;
        Token LPAR199=null;
        Token RPAR201=null;
        Token COLON202=null;
        Token NEWLINE203=null;
        Token BEGIN206=null;
        Token NEWLINE207=null;
        Token END_FUNCTION209=null;
        Token NEWLINE210=null;
        GlossaParser.returnType_return ret = null;

        GlossaParser.formalParamsList_return formalParamsList200 = null;

        GlossaParser.constDecl_return constDecl204 = null;

        GlossaParser.varDecl_return varDecl205 = null;

        GlossaParser.block_return block208 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION198_tree=null;
        CommonTree LPAR199_tree=null;
        CommonTree RPAR201_tree=null;
        CommonTree COLON202_tree=null;
        CommonTree NEWLINE203_tree=null;
        CommonTree BEGIN206_tree=null;
        CommonTree NEWLINE207_tree=null;
        CommonTree END_FUNCTION209_tree=null;
        CommonTree NEWLINE210_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_END_FUNCTION=new RewriteRuleTokenStream(adaptor,"token END_FUNCTION");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_constDecl=new RewriteRuleSubtreeStream(adaptor,"rule constDecl");
        RewriteRuleSubtreeStream stream_formalParamsList=new RewriteRuleSubtreeStream(adaptor,"rule formalParamsList");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_returnType=new RewriteRuleSubtreeStream(adaptor,"rule returnType");
        try {
            // src/glossa/grammars/Glossa.g:436:2: ( FUNCTION id= ID LPAR formalParamsList RPAR COLON ret= returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+ -> ^( FUNCTION $id $ret formalParamsList ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/Glossa.g:436:4: FUNCTION id= ID LPAR formalParamsList RPAR COLON ret= returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+
            {
            FUNCTION198=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function1708); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(FUNCTION198);

            id=(Token)match(input,ID,FOLLOW_ID_in_function1712); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(id);

            LPAR199=(Token)match(input,LPAR,FOLLOW_LPAR_in_function1714); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR199);

            pushFollow(FOLLOW_formalParamsList_in_function1716);
            formalParamsList200=formalParamsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParamsList.add(formalParamsList200.getTree());
            RPAR201=(Token)match(input,RPAR,FOLLOW_RPAR_in_function1718); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR201);

            COLON202=(Token)match(input,COLON,FOLLOW_COLON_in_function1720); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON202);

            pushFollow(FOLLOW_returnType_in_function1724);
            ret=returnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_returnType.add(ret.getTree());
            // src/glossa/grammars/Glossa.g:436:67: ( NEWLINE )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==NEWLINE) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE203=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1726); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE203);


            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            // src/glossa/grammars/Glossa.g:437:3: ( constDecl )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CONSTANTS) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_function1731);
                    constDecl204=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constDecl.add(constDecl204.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:437:14: ( varDecl )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==VARIABLES) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_function1734);
                    varDecl205=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl205.getTree());

                    }
                    break;

            }

            BEGIN206=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_function1739); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN206);

            // src/glossa/grammars/Glossa.g:438:10: ( NEWLINE )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==NEWLINE) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE207=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1742); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE207);


            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);

            pushFollow(FOLLOW_block_in_function1747);
            block208=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block208.getTree());
            END_FUNCTION209=(Token)match(input,END_FUNCTION,FOLLOW_END_FUNCTION_in_function1751); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_FUNCTION.add(END_FUNCTION209);

            // src/glossa/grammars/Glossa.g:440:16: ( NEWLINE )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==NEWLINE) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE210=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1753); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE210);


            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);



            // AST REWRITE
            // elements: ret, formalParamsList, block, varDecl, constDecl, id, FUNCTION
            // token labels: id
            // rule labels: ret, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleSubtreeStream stream_ret=new RewriteRuleSubtreeStream(adaptor,"rule ret",ret!=null?ret.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 440:25: -> ^( FUNCTION $id $ret formalParamsList ( constDecl )? ( varDecl )? block )
            {
                // src/glossa/grammars/Glossa.g:440:28: ^( FUNCTION $id $ret formalParamsList ( constDecl )? ( varDecl )? block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_id.nextNode());
                adaptor.addChild(root_1, stream_ret.nextTree());
                adaptor.addChild(root_1, stream_formalParamsList.nextTree());
                // src/glossa/grammars/Glossa.g:440:65: ( constDecl )?
                if ( stream_constDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_constDecl.nextTree());

                }
                stream_constDecl.reset();
                // src/glossa/grammars/Glossa.g:440:76: ( varDecl )?
                if ( stream_varDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_varDecl.nextTree());

                }
                stream_varDecl.reset();
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class returnType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "returnType"
    // src/glossa/grammars/Glossa.g:442:1: returnType : ( INTEGER | REAL | STRING | BOOLEAN );
    public final GlossaParser.returnType_return returnType() throws RecognitionException {
        GlossaParser.returnType_return retval = new GlossaParser.returnType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set211=null;

        CommonTree set211_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:443:2: ( INTEGER | REAL | STRING | BOOLEAN )
            // src/glossa/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set211=(Token)input.LT(1);
            if ( (input.LA(1)>=INTEGER && input.LA(1)<=BOOLEAN) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set211));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "returnType"

    public static class formalParamsList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParamsList"
    // src/glossa/grammars/Glossa.g:448:1: formalParamsList : (params+= ID ( COMMA params+= ID )* )? -> ^( FORMAL_PARAMS ( $params)* ) ;
    public final GlossaParser.formalParamsList_return formalParamsList() throws RecognitionException {
        GlossaParser.formalParamsList_return retval = new GlossaParser.formalParamsList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA212=null;
        Token params=null;
        List list_params=null;

        CommonTree COMMA212_tree=null;
        CommonTree params_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // src/glossa/grammars/Glossa.g:449:2: ( (params+= ID ( COMMA params+= ID )* )? -> ^( FORMAL_PARAMS ( $params)* ) )
            // src/glossa/grammars/Glossa.g:449:4: (params+= ID ( COMMA params+= ID )* )?
            {
            // src/glossa/grammars/Glossa.g:449:4: (params+= ID ( COMMA params+= ID )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==ID) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:449:5: params+= ID ( COMMA params+= ID )*
                    {
                    params=(Token)match(input,ID,FOLLOW_ID_in_formalParamsList1812); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(params);

                    if (list_params==null) list_params=new ArrayList();
                    list_params.add(params);

                    // src/glossa/grammars/Glossa.g:449:16: ( COMMA params+= ID )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==COMMA) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:449:17: COMMA params+= ID
                    	    {
                    	    COMMA212=(Token)match(input,COMMA,FOLLOW_COMMA_in_formalParamsList1815); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA212);

                    	    params=(Token)match(input,ID,FOLLOW_ID_in_formalParamsList1819); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(params);

                    	    if (list_params==null) list_params=new ArrayList();
                    	    list_params.add(params);


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }



            // AST REWRITE
            // elements: params
            // token labels: 
            // rule labels: retval
            // token list labels: params
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_params=new RewriteRuleTokenStream(adaptor,"token params", list_params);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 449:38: -> ^( FORMAL_PARAMS ( $params)* )
            {
                // src/glossa/grammars/Glossa.g:449:41: ^( FORMAL_PARAMS ( $params)* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL_PARAMS, "FORMAL_PARAMS"), root_1);

                // src/glossa/grammars/Glossa.g:449:57: ( $params)*
                while ( stream_params.hasNext() ) {
                    adaptor.addChild(root_1, stream_params.nextNode());

                }
                stream_params.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formalParamsList"

    // $ANTLR start synpred50_Glossa
    public final void synpred50_Glossa_fragment() throws RecognitionException {   
        // src/glossa/grammars/Glossa.g:368:5: ( rangeItem )
        // src/glossa/grammars/Glossa.g:368:5: rangeItem
        {
        pushFollow(FOLLOW_rangeItem_in_synpred50_Glossa952);
        rangeItem();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Glossa

    // $ANTLR start synpred51_Glossa
    public final void synpred51_Glossa_fragment() throws RecognitionException {   
        // src/glossa/grammars/Glossa.g:368:17: ( expr )
        // src/glossa/grammars/Glossa.g:368:17: expr
        {
        pushFollow(FOLLOW_expr_in_synpred51_Glossa956);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_Glossa

    // Delegated rules

    public final boolean synpred50_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Glossa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Glossa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA41 dfa41 = new DFA41(this);
    protected DFA62 dfa62 = new DFA62(this);
    static final String DFA41_eotS =
        "\21\uffff";
    static final String DFA41_eofS =
        "\21\uffff";
    static final String DFA41_minS =
        "\1\23\12\0\6\uffff";
    static final String DFA41_maxS =
        "\1\112\12\0\6\uffff";
    static final String DFA41_acceptS =
        "\13\uffff\1\3\3\uffff\1\1\1\2";
    static final String DFA41_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\6\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\11\31\uffff\4\13\14\uffff\1\1\1\2\5\uffff\1\3\1\4\1\5\1\6"+
            "\1\7\1\10\1\12",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "367:1: caseExprListItem : ( rangeItem | expr | infRangeItem );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA41_9 = input.LA(1);

                         
                        int index41_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA41_10 = input.LA(1);

                         
                        int index41_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Glossa()) ) {s = 15;}

                        else if ( (synpred51_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\13\uffff";
    static final String DFA62_eofS =
        "\6\uffff\1\11\4\uffff";
    static final String DFA62_minS =
        "\1\23\5\uffff\1\21\4\uffff";
    static final String DFA62_maxS =
        "\1\112\5\uffff\1\113\4\uffff";
    static final String DFA62_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\11\1\10\1\7\1\6";
    static final String DFA62_specialS =
        "\13\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\6\61\uffff\1\1\1\2\1\3\1\4\1\5\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\11\5\uffff\1\11\2\uffff\1\11\1\12\1\11\11\uffff\1\11\5\uffff"+
            "\5\11\2\uffff\2\11\2\uffff\1\11\2\uffff\12\11\6\uffff\1\10\1"+
            "\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "415:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_NEWLINE_in_unit153 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_program_in_unit158 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_function_in_unit160 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_PROGRAM_in_program169 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_program174 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program177 = new BitSet(new long[]{0x0000000001520000L});
    public static final BitSet FOLLOW_declarations_in_program184 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BEGIN_in_program188 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program193 = new BitSet(new long[]{0x01420226002A0000L});
    public static final BitSet FOLLOW_block_in_program200 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program204 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_ID_in_program210 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program215 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_constDecl_in_declarations229 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_varDecl_in_declarations232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl244 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl248 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl253 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ID_in_constAssign263 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EQ_in_constAssign265 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_constAssign268 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign271 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl283 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl287 = new BitSet(new long[]{0x00000001E0020002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl292 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_varType_in_varsDecl303 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl306 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl309 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl312 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl315 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl320 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem339 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension360 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_arrayDimension365 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayDimension369 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_arrayDimension373 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block420 = new BitSet(new long[]{0x0142022600080002L});
    public static final BitSet FOLLOW_printStm_in_stm439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseStm_in_stm498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStm_in_stm516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStm_in_stm534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatStm_in_stm552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm578 = new BitSet(new long[]{0x60000000000A0000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_printStm582 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_printStm586 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_printStm589 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm597 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_READ_in_readStm624 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_readItem_in_readStm627 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_readStm630 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_readItem_in_readStm633 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm638 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_readItem675 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm718 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm720 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_assingmentStm725 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm728 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm751 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm753 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm755 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_assingmentStm760 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm763 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm783 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm785 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm788 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm791 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm794 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IF_in_ifBlock818 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_ifBlock821 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock823 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock827 = new BitSet(new long[]{0x01420226000A0000L});
    public static final BitSet FOLLOW_block_in_ifBlock832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock841 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock845 = new BitSet(new long[]{0x01420226000A0000L});
    public static final BitSet FOLLOW_block_in_elseBlock850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock859 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock862 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock864 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock868 = new BitSet(new long[]{0x01420226000A0000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_caseStm881 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_caseStm884 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm887 = new BitSet(new long[]{0x00000C0000020000L});
    public static final BitSet FOLLOW_caseBlock_in_caseStm892 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_caseElseBlock_in_caseStm895 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_END_SWITCH_in_caseStm898 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm902 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CASE_in_caseBlock914 = new BitSet(new long[]{0x6001E00000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_caseExprList_in_caseBlock917 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseBlock920 = new BitSet(new long[]{0x01420226000A0000L});
    public static final BitSet FOLLOW_block_in_caseBlock925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList934 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_caseExprList937 = new BitSet(new long[]{0x6001E00000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList940 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rangeItem_in_caseExprListItem952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infRangeItem_in_caseExprListItem960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_rangeItem984 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RANGE_in_rangeItem986 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_rangeItem990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_infRangeItem1024 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_infRangeItem1054 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_infRangeItem1084 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_infRangeItem1114 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseElseBlock1144 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ELSE_in_caseElseBlock1146 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseElseBlock1148 = new BitSet(new long[]{0x01420226000A0000L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStm1166 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_forStm1169 = new BitSet(new long[]{0x0004000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_forStm1171 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_FROM_in_forStm1174 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_forStm1179 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_TO_in_forStm1181 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_forStm1186 = new BitSet(new long[]{0x0010000000020000L});
    public static final BitSet FOLLOW_STEP_in_forStm1189 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_forStm1194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1199 = new BitSet(new long[]{0x01620226000A0000L});
    public static final BitSet FOLLOW_block_in_forStm1204 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_forStm1206 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1210 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_WHILE_in_whileStm1238 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_whileStm1241 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_LOOP_in_whileStm1243 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1247 = new BitSet(new long[]{0x01620226000A0000L});
    public static final BitSet FOLLOW_block_in_whileStm1252 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_whileStm1254 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1258 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_REPEAT_in_repeatStm1270 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1274 = new BitSet(new long[]{0x03420226000A0000L});
    public static final BitSet FOLLOW_block_in_repeatStm1279 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_repeatStm1281 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_repeatStm1284 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1287 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_expr_in_paramsList1302 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_paramsList1305 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_paramsList1309 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_andExpr_in_expr1331 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_OR_in_expr1335 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_andExpr_in_expr1338 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1354 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_AND_in_andExpr1357 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1360 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1370 = new BitSet(new long[]{0x1000000000800002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr1373 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1376 = new BitSet(new long[]{0x1000000000800002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr1380 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1383 = new BitSet(new long[]{0x1000000000800002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1394 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr1397 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1400 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr1404 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1407 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr1411 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1414 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr1418 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1421 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1434 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr1437 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1440 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr1444 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1447 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1459 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_TIMES_in_multExpr1462 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1465 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_DIA_in_multExpr1469 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1472 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_DIV_in_multExpr1476 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1479 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_MOD_in_multExpr1483 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1486 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1498 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_powExpr1501 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1504 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr1515 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr1523 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr1538 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_atom1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1609 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_atom1612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_RPAR_in_atom1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall1624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_LPAR_in_functionCall1626 = new BitSet(new long[]{0x6000000000080000L,0x0000000000000FF0L});
    public static final BitSet FOLLOW_paramsList_in_functionCall1628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_RPAR_in_functionCall1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem1650 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1672 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1677 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_COMMA_in_arraySubscript1681 = new BitSet(new long[]{0x6000000000080000L,0x00000000000007F0L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1685 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function1708 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function1712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_LPAR_in_function1714 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000800L});
    public static final BitSet FOLLOW_formalParamsList_in_function1716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_RPAR_in_function1718 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COLON_in_function1720 = new BitSet(new long[]{0x0000000000000000L,0x000000000003C000L});
    public static final BitSet FOLLOW_returnType_in_function1724 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1726 = new BitSet(new long[]{0x0000000001520000L});
    public static final BitSet FOLLOW_constDecl_in_function1731 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_varDecl_in_function1734 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BEGIN_in_function1739 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1742 = new BitSet(new long[]{0x01420226000A0000L,0x0000000000002000L});
    public static final BitSet FOLLOW_block_in_function1747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_END_FUNCTION_in_function1751 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1753 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_set_in_returnType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_formalParamsList1812 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_formalParamsList1815 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_formalParamsList1819 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rangeItem_in_synpred50_Glossa952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred51_Glossa956 = new BitSet(new long[]{0x0000000000000002L});

}