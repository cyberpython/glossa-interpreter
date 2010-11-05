// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/Glossa.g 2010-11-05 12:13:57

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PARAMS", "FUNC_CALL", "FORMAL_PARAMS", "NEWLINE", "PROGRAM", "ID", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "CALL", "LPAR", "RPAR", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "PROCEDURE", "END_PROCEDURE", "FUNCTION", "END_FUNCTION", "INTEGER", "REAL", "STRING", "BOOLEAN", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "UPSILON", "NU", "OMEGA", "OMEGA_TONOS", "XI", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=79;
    public static final int LT=45;
    public static final int END_PROCEDURE=78;
    public static final int WHILE=54;
    public static final int LETTER=115;
    public static final int MOD=69;
    public static final int LAMDA=99;
    public static final int STRINGS=30;
    public static final int UPSILON_DIALYTIKA_TONOS=128;
    public static final int CASE=43;
    public static final int NOT=71;
    public static final int OMICRON=89;
    public static final int EOF=-1;
    public static final int FUNC_CALL=15;
    public static final int LBRACKET=27;
    public static final int MU=95;
    public static final int TAU=96;
    public static final int POW=70;
    public static final int UPSILON_TONOS=124;
    public static final int LPAR=59;
    public static final int CONT_COMMAND=118;
    public static final int CONST_INT=75;
    public static final int BEGIN=20;
    public static final int LOOP=55;
    public static final int KAPPA=85;
    public static final int EQ=23;
    public static final int COMMENT=117;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=121;
    public static final int END_LOOP=53;
    public static final int GE=48;
    public static final int END_SWITCH=42;
    public static final int NU=110;
    public static final int CONST_TRUE=72;
    public static final int XI=113;
    public static final int SWITCH=41;
    public static final int ELSE=39;
    public static final int DELTA=106;
    public static final int EPSILON=97;
    public static final int CONST_STR=74;
    public static final int INTEGERS=31;
    public static final int ALPHA=86;
    public static final int SIGMA_TELIKO=100;
    public static final int REAL=82;
    public static final int FORMAL_PARAMS=16;
    public static final int THETA=105;
    public static final int BOOLEANS=29;
    public static final int UPSILON_DIALYTIKA=126;
    public static final int WS=119;
    public static final int EPSILON_TONOS=98;
    public static final int OMICRON_TONOS=90;
    public static final int READ=34;
    public static final int OMEGA=111;
    public static final int UNTIL=57;
    public static final int OR=61;
    public static final int GT=47;
    public static final int ALPHA_TONOS=101;
    public static final int REPEAT=56;
    public static final int PI=92;
    public static final int CALL=58;
    public static final int FROM=50;
    public static final int PHI=123;
    public static final int RHO=93;
    public static final int UPSILON=109;
    public static final int FOR=49;
    public static final int STEP=52;
    public static final int ETA_TONOS=88;
    public static final int CONSTANTS=22;
    public static final int ID=19;
    public static final int AND=62;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=37;
    public static final int OMEGA_TONOS=112;
    public static final int NOT_EOL=116;
    public static final int BOOLEAN=84;
    public static final int THEN=38;
    public static final int END_FUNCTION=80;
    public static final int COMMA=26;
    public static final int ETA=103;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=107;
    public static final int PLUS=64;
    public static final int SIGMA=104;
    public static final int DIGIT=114;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=28;
    public static final int IOTA_DIALYTIKA_TONOS=127;
    public static final int ELSE_IF=40;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=76;
    public static final int PARAMS=14;
    public static final int INTEGER=81;
    public static final int INF_RANGE=12;
    public static final int TO=51;
    public static final int LATIN_LETTER=120;
    public static final int REALS=32;
    public static final int RANGE=44;
    public static final int CHI=91;
    public static final int MINUS=65;
    public static final int DIA=67;
    public static final int BETA=102;
    public static final int PRINT=33;
    public static final int PROCEDURE=77;
    public static final int COLON=25;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=63;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=21;
    public static final int ZETA=122;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=73;
    public static final int NEG=5;
    public static final int ASSIGN=35;
    public static final int VARIABLES=24;
    public static final int END_IF=36;
    public static final int PROGRAM=18;
    public static final int RPAR=60;
    public static final int IOTA=87;
    public static final int DIV=68;
    public static final int GAMMA=94;
    public static final int TIMES=66;
    public static final int IOTA_DIALYTIKA=125;
    public static final int LE=46;
    public static final int IOTA_TONOS=108;
    public static final int STRING=83;

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
    // src/glossa/grammars/Glossa.g:286:1: unit : ( NEWLINE )* program ( function | procedure )* ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE1=null;
        GlossaParser.program_return program2 = null;

        GlossaParser.function_return function3 = null;

        GlossaParser.procedure_return procedure4 = null;


        CommonTree NEWLINE1_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:286:6: ( ( NEWLINE )* program ( function | procedure )* )
            // src/glossa/grammars/Glossa.g:286:8: ( NEWLINE )* program ( function | procedure )*
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
            // src/glossa/grammars/Glossa.g:286:28: ( function | procedure )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==FUNCTION) ) {
                    alt2=1;
                }
                else if ( (LA2_0==PROCEDURE) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:286:29: function
            	    {
            	    pushFollow(FOLLOW_function_in_unit161);
            	    function3=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, function3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:286:38: procedure
            	    {
            	    pushFollow(FOLLOW_procedure_in_unit163);
            	    procedure4=procedure();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, procedure4.getTree());

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
        Token PROGRAM5=null;
        Token NEWLINE6=null;
        Token BEGIN8=null;
        Token NEWLINE9=null;
        Token END_PROGRAM11=null;
        Token NEWLINE12=null;
        GlossaParser.declarations_return declarations7 = null;

        GlossaParser.block_return block10 = null;


        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree PROGRAM5_tree=null;
        CommonTree NEWLINE6_tree=null;
        CommonTree BEGIN8_tree=null;
        CommonTree NEWLINE9_tree=null;
        CommonTree END_PROGRAM11_tree=null;
        CommonTree NEWLINE12_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:288:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:288:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM5=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PROGRAM5_tree = (CommonTree)adaptor.create(PROGRAM5);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM5_tree, root_0);
            }
            id1=(Token)match(input,ID,FOLLOW_ID_in_program178); if (state.failed) return retval;
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
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program181); if (state.failed) return retval;

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

            pushFollow(FOLLOW_declarations_in_program188);
            declarations7=declarations();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarations7.getTree());
            BEGIN8=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program192); if (state.failed) return retval;
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
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program197); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_program204);
            block10=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block10.getTree());
            END_PROGRAM11=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program208); if (state.failed) return retval;
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
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program214); if (state.failed) return retval;
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
            	    NEWLINE12=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program219); if (state.failed) return retval;

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

        GlossaParser.constDecl_return constDecl13 = null;

        GlossaParser.varDecl_return varDecl14 = null;



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
                    pushFollow(FOLLOW_constDecl_in_declarations233);
                    constDecl13=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constDecl13.getTree());

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
                    pushFollow(FOLLOW_varDecl_in_declarations236);
                    varDecl14=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl14.getTree());

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

        Token CONSTANTS15=null;
        Token NEWLINE16=null;
        GlossaParser.constAssign_return constAssign17 = null;


        CommonTree CONSTANTS15_tree=null;
        CommonTree NEWLINE16_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:298:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/grammars/Glossa.g:298:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS15=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CONSTANTS15_tree = (CommonTree)adaptor.create(CONSTANTS15);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS15_tree, root_0);
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
            	    NEWLINE16=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl252); if (state.failed) return retval;

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
            	    pushFollow(FOLLOW_constAssign_in_constDecl257);
            	    constAssign17=constAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, constAssign17.getTree());

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

        Token ID18=null;
        Token EQ19=null;
        Token NEWLINE21=null;
        GlossaParser.expr_return expr20 = null;


        CommonTree ID18_tree=null;
        CommonTree EQ19_tree=null;
        CommonTree NEWLINE21_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:301:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:301:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID18=(Token)match(input,ID,FOLLOW_ID_in_constAssign267); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID18_tree = (CommonTree)adaptor.create(ID18);
            adaptor.addChild(root_0, ID18_tree);
            }
            EQ19=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQ19_tree = (CommonTree)adaptor.create(EQ19);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ19_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_constAssign272);
            expr20=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr20.getTree());
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
            	    NEWLINE21=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign275); if (state.failed) return retval;

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

        Token VARIABLES22=null;
        Token NEWLINE23=null;
        GlossaParser.varsDecl_return varsDecl24 = null;


        CommonTree VARIABLES22_tree=null;
        CommonTree NEWLINE23_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:303:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/grammars/Glossa.g:303:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES22=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            VARIABLES22_tree = (CommonTree)adaptor.create(VARIABLES22);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES22_tree, root_0);
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
            	    NEWLINE23=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl291); if (state.failed) return retval;

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
            	    pushFollow(FOLLOW_varsDecl_in_varDecl296);
            	    varsDecl24=varsDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varsDecl24.getTree());

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

        Token COLON26=null;
        Token COMMA28=null;
        Token NEWLINE30=null;
        GlossaParser.varType_return varType25 = null;

        GlossaParser.varDeclItem_return varDeclItem27 = null;

        GlossaParser.varDeclItem_return varDeclItem29 = null;


        CommonTree COLON26_tree=null;
        CommonTree COMMA28_tree=null;
        CommonTree NEWLINE30_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:306:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:306:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl307);
            varType25=varType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(varType25.getTree(), root_0);
            COLON26=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl310); if (state.failed) return retval;
            pushFollow(FOLLOW_varDeclItem_in_varsDecl313);
            varDeclItem27=varDeclItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem27.getTree());
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
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl316); if (state.failed) return retval;
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl319);
            	    varDeclItem29=varDeclItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem29.getTree());

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
            	    NEWLINE30=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl324); if (state.failed) return retval;

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

        Token ID31=null;
        Token ID32=null;
        GlossaParser.arrayDimension_return arrayDimension33 = null;


        CommonTree ID31_tree=null;
        CommonTree ID32_tree=null;
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

                    ID31=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID31_tree = (CommonTree)adaptor.create(ID31);
                    adaptor.addChild(root_0, ID31_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:310:5: ID arrayDimension
                    {
                    ID32=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem343); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID32);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem345);
                    arrayDimension33=arrayDimension();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDimension.add(arrayDimension33.getTree());


                    // AST REWRITE
                    // elements: arrayDimension, ID
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

        Token LBRACKET34=null;
        Token COMMA35=null;
        Token RBRACKET36=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET34_tree=null;
        CommonTree COMMA35_tree=null;
        CommonTree RBRACKET36_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:313:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/Glossa.g:313:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET34=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension364); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET34);

            // src/glossa/grammars/Glossa.g:313:13: (dimension+= expr )
            // src/glossa/grammars/Glossa.g:313:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arrayDimension369);
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
            	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayDimension373); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA35);

            	    pushFollow(FOLLOW_expr_in_arrayDimension377);
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

            RBRACKET36=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension381); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET36);



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

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:315:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set37=(Token)input.LT(1);
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set37));
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

        GlossaParser.stm_return stm38 = null;


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

                if ( (LA18_0==ID||(LA18_0>=PRINT && LA18_0<=READ)||LA18_0==IF||LA18_0==SWITCH||LA18_0==FOR||LA18_0==WHILE||LA18_0==REPEAT||LA18_0==CALL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block424);
            	    stm38=stm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stm.add(stm38.getTree());

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
    // src/glossa/grammars/Glossa.g:322:1: stm : ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm | procedureCallStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm39 = null;

        GlossaParser.readStm_return readStm40 = null;

        GlossaParser.assingmentStm_return assingmentStm41 = null;

        GlossaParser.ifStm_return ifStm42 = null;

        GlossaParser.caseStm_return caseStm43 = null;

        GlossaParser.forStm_return forStm44 = null;

        GlossaParser.whileStm_return whileStm45 = null;

        GlossaParser.repeatStm_return repeatStm46 = null;

        GlossaParser.procedureCallStm_return procedureCallStm47 = null;



        try {
            // src/glossa/grammars/Glossa.g:322:5: ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm | procedureCallStm )
            int alt19=9;
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
            case CALL:
                {
                alt19=9;
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

                    pushFollow(FOLLOW_printStm_in_stm443);
                    printStm39=printStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, printStm39.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:323:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm461);
                    readStm40=readStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStm40.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:324:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm466);
                    assingmentStm41=assingmentStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assingmentStm41.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:325:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm484);
                    ifStm42=ifStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStm42.getTree());

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/Glossa.g:326:17: caseStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_caseStm_in_stm502);
                    caseStm43=caseStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStm43.getTree());

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/Glossa.g:327:17: forStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStm_in_stm520);
                    forStm44=forStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStm44.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/Glossa.g:328:17: whileStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStm_in_stm538);
                    whileStm45=whileStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStm45.getTree());

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/Glossa.g:329:17: repeatStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeatStm_in_stm556);
                    repeatStm46=repeatStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeatStm46.getTree());

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/Glossa.g:330:11: procedureCallStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_procedureCallStm_in_stm568);
                    procedureCallStm47=procedureCallStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procedureCallStm47.getTree());

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
    // src/glossa/grammars/Glossa.g:333:1: printStm : PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT48=null;
        Token char_literal50=null;
        Token NEWLINE52=null;
        GlossaParser.expr_return expr49 = null;

        GlossaParser.expr_return expr51 = null;


        CommonTree PRINT48_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree NEWLINE52_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:334:9: ( PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:334:11: PRINT ( expr ( ',' expr )* )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT48=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm594); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRINT48_tree = (CommonTree)adaptor.create(PRINT48);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT48_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:334:18: ( expr ( ',' expr )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID||LA21_0==LPAR||(LA21_0>=PLUS && LA21_0<=MINUS)||(LA21_0>=NOT && LA21_0<=CONST_REAL)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:334:19: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_printStm598);
                    expr49=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr49.getTree());
                    // src/glossa/grammars/Glossa.g:334:24: ( ',' expr )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:334:26: ',' expr
                    	    {
                    	    char_literal50=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm602); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expr_in_printStm605);
                    	    expr51=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr51.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:334:41: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:334:42: NEWLINE
            	    {
            	    NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm613); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:336:1: readStm : READ readItem ( COMMA readItem )* ( NEWLINE )+ ;
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ53=null;
        Token COMMA55=null;
        Token NEWLINE57=null;
        GlossaParser.readItem_return readItem54 = null;

        GlossaParser.readItem_return readItem56 = null;


        CommonTree READ53_tree=null;
        CommonTree COMMA55_tree=null;
        CommonTree NEWLINE57_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:336:9: ( READ readItem ( COMMA readItem )* ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:337:17: READ readItem ( COMMA readItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            READ53=(Token)match(input,READ,FOLLOW_READ_in_readStm640); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ53_tree = (CommonTree)adaptor.create(READ53);
            root_0 = (CommonTree)adaptor.becomeRoot(READ53_tree, root_0);
            }
            pushFollow(FOLLOW_readItem_in_readStm643);
            readItem54=readItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem54.getTree());
            // src/glossa/grammars/Glossa.g:337:32: ( COMMA readItem )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:337:33: COMMA readItem
            	    {
            	    COMMA55=(Token)match(input,COMMA,FOLLOW_COMMA_in_readStm646); if (state.failed) return retval;
            	    pushFollow(FOLLOW_readItem_in_readStm649);
            	    readItem56=readItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem56.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:337:51: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:337:52: NEWLINE
            	    {
            	    NEWLINE57=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm654); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:340:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final GlossaParser.readItem_return readItem() throws RecognitionException {
        GlossaParser.readItem_return retval = new GlossaParser.readItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token arrId=null;
        Token varId=null;
        GlossaParser.arraySubscript_return arraySubscript58 = null;


        CommonTree arrId_tree=null;
        CommonTree varId_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:340:9: (arrId= ID arraySubscript | varId= ID )
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
                    // src/glossa/grammars/Glossa.g:341:17: arrId= ID arraySubscript
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readItem691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_readItem693);
                    arraySubscript58=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript58.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:342:17: varId= ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readItem713); if (state.failed) return retval;
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
    // src/glossa/grammars/Glossa.g:345:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN59=null;
        Token NEWLINE60=null;
        Token ASSIGN62=null;
        Token NEWLINE63=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript61 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN59_tree=null;
        CommonTree NEWLINE60_tree=null;
        CommonTree ASSIGN62_tree=null;
        CommonTree NEWLINE63_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:346:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
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
                    // src/glossa/grammars/Glossa.g:346:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm734); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);
                    }
                    ASSIGN59=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN59_tree = (CommonTree)adaptor.create(ASSIGN59);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN59_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm741);
                    varValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/grammars/Glossa.g:346:35: ( NEWLINE )+
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
                    	    // src/glossa/grammars/Glossa.g:346:36: NEWLINE
                    	    {
                    	    NEWLINE60=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm744); if (state.failed) return retval;

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
                    // src/glossa/grammars/Glossa.g:347:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm769);
                    arraySubscript61=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript61.getTree());
                    ASSIGN62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN62_tree = (CommonTree)adaptor.create(ASSIGN62);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN62_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm776);
                    arrItemValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/grammars/Glossa.g:347:67: ( NEWLINE )+
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
                    	    // src/glossa/grammars/Glossa.g:347:68: NEWLINE
                    	    {
                    	    NEWLINE63=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm779); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:350:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF67=null;
        Token NEWLINE68=null;
        GlossaParser.ifBlock_return ifBlock64 = null;

        GlossaParser.elseIfBlock_return elseIfBlock65 = null;

        GlossaParser.elseBlock_return elseBlock66 = null;


        CommonTree END_IF67_tree=null;
        CommonTree NEWLINE68_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/grammars/Glossa.g:350:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/grammars/Glossa.g:350:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm799);
            ifBlock64=ifBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifBlock.add(ifBlock64.getTree());
            // src/glossa/grammars/Glossa.g:350:17: ( elseIfBlock )*
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
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm801);
            	    elseIfBlock65=elseIfBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elseIfBlock.add(elseIfBlock65.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:350:30: ( elseBlock )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ELSE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm804);
                    elseBlock66=elseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock66.getTree());

                    }
                    break;

            }

            END_IF67=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm807); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_IF.add(END_IF67);

            // src/glossa/grammars/Glossa.g:350:48: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:350:49: NEWLINE
            	    {
            	    NEWLINE68=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm810); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE68);


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
            // elements: elseBlock, ifBlock, elseIfBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 350:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/grammars/Glossa.g:350:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/grammars/Glossa.g:350:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/grammars/Glossa.g:350:92: ( elseBlock )?
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
    // src/glossa/grammars/Glossa.g:352:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF69=null;
        Token THEN71=null;
        Token NEWLINE72=null;
        GlossaParser.expr_return expr70 = null;

        GlossaParser.block_return block73 = null;


        CommonTree IF69_tree=null;
        CommonTree THEN71_tree=null;
        CommonTree NEWLINE72_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:352:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:352:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF69=(Token)match(input,IF,FOLLOW_IF_in_ifBlock834); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF69_tree = (CommonTree)adaptor.create(IF69);
            root_0 = (CommonTree)adaptor.becomeRoot(IF69_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_ifBlock837);
            expr70=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr70.getTree());
            THEN71=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock839); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:352:26: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:352:27: NEWLINE
            	    {
            	    NEWLINE72=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock843); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_ifBlock848);
            block73=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block73.getTree());

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
    // src/glossa/grammars/Glossa.g:354:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE74=null;
        Token NEWLINE75=null;
        GlossaParser.block_return block76 = null;


        CommonTree ELSE74_tree=null;
        CommonTree NEWLINE75_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:355:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:355:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE74=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE74_tree = (CommonTree)adaptor.create(ELSE74);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE74_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:355:10: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:355:11: NEWLINE
            	    {
            	    NEWLINE75=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock861); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_elseBlock866);
            block76=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block76.getTree());

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
    // src/glossa/grammars/Glossa.g:357:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF77=null;
        Token THEN79=null;
        Token NEWLINE80=null;
        GlossaParser.expr_return expr78 = null;

        GlossaParser.block_return block81 = null;


        CommonTree ELSE_IF77_tree=null;
        CommonTree THEN79_tree=null;
        CommonTree NEWLINE80_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:358:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:358:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF77=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock875); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE_IF77_tree = (CommonTree)adaptor.create(ELSE_IF77);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF77_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_elseIfBlock878);
            expr78=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr78.getTree());
            THEN79=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock880); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:358:24: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:358:25: NEWLINE
            	    {
            	    NEWLINE80=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock884); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_elseIfBlock889);
            block81=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block81.getTree());

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
    // src/glossa/grammars/Glossa.g:360:1: caseStm : SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ ;
    public final GlossaParser.caseStm_return caseStm() throws RecognitionException {
        GlossaParser.caseStm_return retval = new GlossaParser.caseStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SWITCH82=null;
        Token NEWLINE84=null;
        Token END_SWITCH87=null;
        Token NEWLINE88=null;
        GlossaParser.expr_return expr83 = null;

        GlossaParser.caseBlock_return caseBlock85 = null;

        GlossaParser.caseElseBlock_return caseElseBlock86 = null;


        CommonTree SWITCH82_tree=null;
        CommonTree NEWLINE84_tree=null;
        CommonTree END_SWITCH87_tree=null;
        CommonTree NEWLINE88_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:360:9: ( SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:360:11: SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            SWITCH82=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_caseStm897); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SWITCH82_tree = (CommonTree)adaptor.create(SWITCH82);
            root_0 = (CommonTree)adaptor.becomeRoot(SWITCH82_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_caseStm900);
            expr83=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr83.getTree());
            // src/glossa/grammars/Glossa.g:360:24: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:360:25: NEWLINE
            	    {
            	    NEWLINE84=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm903); if (state.failed) return retval;

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

            // src/glossa/grammars/Glossa.g:360:36: ( caseBlock )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==CASE) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==ID||(LA36_1>=LT && LA36_1<=GE)||LA36_1==LPAR||(LA36_1>=PLUS && LA36_1<=MINUS)||(LA36_1>=NOT && LA36_1<=CONST_REAL)) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: caseBlock
            	    {
            	    pushFollow(FOLLOW_caseBlock_in_caseStm908);
            	    caseBlock85=caseBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseBlock85.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // src/glossa/grammars/Glossa.g:360:47: ( caseElseBlock )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==CASE) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: caseElseBlock
                    {
                    pushFollow(FOLLOW_caseElseBlock_in_caseStm911);
                    caseElseBlock86=caseElseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseElseBlock86.getTree());

                    }
                    break;

            }

            END_SWITCH87=(Token)match(input,END_SWITCH,FOLLOW_END_SWITCH_in_caseStm914); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:360:74: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:360:75: NEWLINE
            	    {
            	    NEWLINE88=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm918); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:362:1: caseBlock : CASE caseExprList ( NEWLINE )+ block ;
    public final GlossaParser.caseBlock_return caseBlock() throws RecognitionException {
        GlossaParser.caseBlock_return retval = new GlossaParser.caseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE89=null;
        Token NEWLINE91=null;
        GlossaParser.caseExprList_return caseExprList90 = null;

        GlossaParser.block_return block92 = null;


        CommonTree CASE89_tree=null;
        CommonTree NEWLINE91_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:363:2: ( CASE caseExprList ( NEWLINE )+ block )
            // src/glossa/grammars/Glossa.g:363:4: CASE caseExprList ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE89=(Token)match(input,CASE,FOLLOW_CASE_in_caseBlock930); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE89_tree = (CommonTree)adaptor.create(CASE89);
            root_0 = (CommonTree)adaptor.becomeRoot(CASE89_tree, root_0);
            }
            pushFollow(FOLLOW_caseExprList_in_caseBlock933);
            caseExprList90=caseExprList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprList90.getTree());
            // src/glossa/grammars/Glossa.g:363:23: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:363:24: NEWLINE
            	    {
            	    NEWLINE91=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseBlock936); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_caseBlock941);
            block92=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block92.getTree());

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
    // src/glossa/grammars/Glossa.g:365:1: caseExprList : caseExprListItem ( COMMA caseExprListItem )* ;
    public final GlossaParser.caseExprList_return caseExprList() throws RecognitionException {
        GlossaParser.caseExprList_return retval = new GlossaParser.caseExprList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA94=null;
        GlossaParser.caseExprListItem_return caseExprListItem93 = null;

        GlossaParser.caseExprListItem_return caseExprListItem95 = null;


        CommonTree COMMA94_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:366:2: ( caseExprListItem ( COMMA caseExprListItem )* )
            // src/glossa/grammars/Glossa.g:366:4: caseExprListItem ( COMMA caseExprListItem )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_caseExprListItem_in_caseExprList950);
            caseExprListItem93=caseExprListItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem93.getTree());
            // src/glossa/grammars/Glossa.g:366:21: ( COMMA caseExprListItem )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==COMMA) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:366:22: COMMA caseExprListItem
            	    {
            	    COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_caseExprList953); if (state.failed) return retval;
            	    pushFollow(FOLLOW_caseExprListItem_in_caseExprList956);
            	    caseExprListItem95=caseExprListItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem95.getTree());

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
    // src/glossa/grammars/Glossa.g:368:1: caseExprListItem : ( rangeItem | expr | infRangeItem );
    public final GlossaParser.caseExprListItem_return caseExprListItem() throws RecognitionException {
        GlossaParser.caseExprListItem_return retval = new GlossaParser.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.rangeItem_return rangeItem96 = null;

        GlossaParser.expr_return expr97 = null;

        GlossaParser.infRangeItem_return infRangeItem98 = null;



        try {
            // src/glossa/grammars/Glossa.g:369:2: ( rangeItem | expr | infRangeItem )
            int alt41=3;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:369:5: rangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rangeItem_in_caseExprListItem968);
                    rangeItem96=rangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rangeItem96.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:369:17: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_caseExprListItem972);
                    expr97=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr97.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:369:24: infRangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infRangeItem_in_caseExprListItem976);
                    infRangeItem98=infRangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infRangeItem98.getTree());

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
    // src/glossa/grammars/Glossa.g:371:1: rangeItem : expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) ;
    public final GlossaParser.rangeItem_return rangeItem() throws RecognitionException {
        GlossaParser.rangeItem_return retval = new GlossaParser.rangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RANGE99=null;
        GlossaParser.expr_return expr1 = null;

        GlossaParser.expr_return expr2 = null;


        CommonTree RANGE99_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:372:9: (expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) )
            // src/glossa/grammars/Glossa.g:372:17: expr1= expr RANGE expr2= expr
            {
            pushFollow(FOLLOW_expr_in_rangeItem1000);
            expr1=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr1.getTree());
            RANGE99=(Token)match(input,RANGE,FOLLOW_RANGE_in_rangeItem1002); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE99);

            pushFollow(FOLLOW_expr_in_rangeItem1006);
            expr2=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr2.getTree());


            // AST REWRITE
            // elements: RANGE, expr1, expr2
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
            // 372:45: -> ^( RANGE $expr1 $expr2)
            {
                // src/glossa/grammars/Glossa.g:372:48: ^( RANGE $expr1 $expr2)
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
    // src/glossa/grammars/Glossa.g:374:1: infRangeItem : ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) );
    public final GlossaParser.infRangeItem_return infRangeItem() throws RecognitionException {
        GlossaParser.infRangeItem_return retval = new GlossaParser.infRangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT100=null;
        Token LE102=null;
        Token GT104=null;
        Token GE106=null;
        GlossaParser.expr_return expr101 = null;

        GlossaParser.expr_return expr103 = null;

        GlossaParser.expr_return expr105 = null;

        GlossaParser.expr_return expr107 = null;


        CommonTree LT100_tree=null;
        CommonTree LE102_tree=null;
        CommonTree GT104_tree=null;
        CommonTree GE106_tree=null;
        RewriteRuleTokenStream stream_GE=new RewriteRuleTokenStream(adaptor,"token GE");
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
        RewriteRuleTokenStream stream_LE=new RewriteRuleTokenStream(adaptor,"token LE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:375:9: ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) )
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
                    // src/glossa/grammars/Glossa.g:375:17: LT expr
                    {
                    LT100=(Token)match(input,LT,FOLLOW_LT_in_infRangeItem1040); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LT.add(LT100);

                    pushFollow(FOLLOW_expr_in_infRangeItem1042);
                    expr101=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr101.getTree());


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
                    // 375:25: -> ^( INF_RANGE LT expr )
                    {
                        // src/glossa/grammars/Glossa.g:375:28: ^( INF_RANGE LT expr )
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
                    // src/glossa/grammars/Glossa.g:376:17: LE expr
                    {
                    LE102=(Token)match(input,LE,FOLLOW_LE_in_infRangeItem1070); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LE.add(LE102);

                    pushFollow(FOLLOW_expr_in_infRangeItem1072);
                    expr103=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr103.getTree());


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
                    // 376:25: -> ^( INF_RANGE LE expr )
                    {
                        // src/glossa/grammars/Glossa.g:376:28: ^( INF_RANGE LE expr )
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
                    // src/glossa/grammars/Glossa.g:377:17: GT expr
                    {
                    GT104=(Token)match(input,GT,FOLLOW_GT_in_infRangeItem1100); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GT.add(GT104);

                    pushFollow(FOLLOW_expr_in_infRangeItem1102);
                    expr105=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr105.getTree());


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
                    // 377:25: -> ^( INF_RANGE GT expr )
                    {
                        // src/glossa/grammars/Glossa.g:377:28: ^( INF_RANGE GT expr )
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
                    // src/glossa/grammars/Glossa.g:378:17: GE expr
                    {
                    GE106=(Token)match(input,GE,FOLLOW_GE_in_infRangeItem1130); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GE.add(GE106);

                    pushFollow(FOLLOW_expr_in_infRangeItem1132);
                    expr107=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr107.getTree());


                    // AST REWRITE
                    // elements: expr, GE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 378:25: -> ^( INF_RANGE GE expr )
                    {
                        // src/glossa/grammars/Glossa.g:378:28: ^( INF_RANGE GE expr )
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
    // src/glossa/grammars/Glossa.g:381:1: caseElseBlock : CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) ;
    public final GlossaParser.caseElseBlock_return caseElseBlock() throws RecognitionException {
        GlossaParser.caseElseBlock_return retval = new GlossaParser.caseElseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE108=null;
        Token ELSE109=null;
        Token NEWLINE110=null;
        GlossaParser.block_return block111 = null;


        CommonTree CASE108_tree=null;
        CommonTree ELSE109_tree=null;
        CommonTree NEWLINE110_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/glossa/grammars/Glossa.g:382:2: ( CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) )
            // src/glossa/grammars/Glossa.g:382:4: CASE ELSE ( NEWLINE )+ block
            {
            CASE108=(Token)match(input,CASE,FOLLOW_CASE_in_caseElseBlock1160); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CASE.add(CASE108);

            ELSE109=(Token)match(input,ELSE,FOLLOW_ELSE_in_caseElseBlock1162); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE.add(ELSE109);

            // src/glossa/grammars/Glossa.g:382:14: ( NEWLINE )+
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
            	    NEWLINE110=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseElseBlock1164); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE110);


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

            pushFollow(FOLLOW_block_in_caseElseBlock1167);
            block111=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block111.getTree());


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
            // 382:29: -> ^( CASE_ELSE block )
            {
                // src/glossa/grammars/Glossa.g:382:32: ^( CASE_ELSE block )
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
    // src/glossa/grammars/Glossa.g:383:1: forStm : FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.forStm_return forStm() throws RecognitionException {
        GlossaParser.forStm_return retval = new GlossaParser.forStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR112=null;
        Token ID113=null;
        Token FROM115=null;
        Token TO116=null;
        Token STEP117=null;
        Token NEWLINE118=null;
        Token END_LOOP120=null;
        Token NEWLINE121=null;
        GlossaParser.expr_return from = null;

        GlossaParser.expr_return to = null;

        GlossaParser.expr_return step = null;

        GlossaParser.arraySubscript_return arraySubscript114 = null;

        GlossaParser.block_return block119 = null;


        CommonTree FOR112_tree=null;
        CommonTree ID113_tree=null;
        CommonTree FROM115_tree=null;
        CommonTree TO116_tree=null;
        CommonTree STEP117_tree=null;
        CommonTree NEWLINE118_tree=null;
        CommonTree END_LOOP120_tree=null;
        CommonTree NEWLINE121_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:383:8: ( FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:383:10: FOR ID ( arraySubscript )? FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            FOR112=(Token)match(input,FOR,FOLLOW_FOR_in_forStm1182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR112_tree = (CommonTree)adaptor.create(FOR112);
            root_0 = (CommonTree)adaptor.becomeRoot(FOR112_tree, root_0);
            }
            ID113=(Token)match(input,ID,FOLLOW_ID_in_forStm1185); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID113_tree = (CommonTree)adaptor.create(ID113);
            adaptor.addChild(root_0, ID113_tree);
            }
            // src/glossa/grammars/Glossa.g:383:18: ( arraySubscript )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LBRACKET) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: arraySubscript
                    {
                    pushFollow(FOLLOW_arraySubscript_in_forStm1187);
                    arraySubscript114=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript114.getTree());

                    }
                    break;

            }

            FROM115=(Token)match(input,FROM,FOLLOW_FROM_in_forStm1190); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1195);
            from=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, from.getTree());
            TO116=(Token)match(input,TO,FOLLOW_TO_in_forStm1197); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1202);
            to=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, to.getTree());
            // src/glossa/grammars/Glossa.g:383:62: ( STEP step= expr )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==STEP) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:383:63: STEP step= expr
                    {
                    STEP117=(Token)match(input,STEP,FOLLOW_STEP_in_forStm1205); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_forStm1210);
                    step=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, step.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:383:81: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:383:82: NEWLINE
            	    {
            	    NEWLINE118=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1215); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_forStm1220);
            block119=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block119.getTree());
            END_LOOP120=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_forStm1222); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:383:109: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:383:110: NEWLINE
            	    {
            	    NEWLINE121=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1226); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:386:1: whileStm : WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.whileStm_return whileStm() throws RecognitionException {
        GlossaParser.whileStm_return retval = new GlossaParser.whileStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE122=null;
        Token LOOP124=null;
        Token NEWLINE125=null;
        Token END_LOOP127=null;
        Token NEWLINE128=null;
        GlossaParser.expr_return expr123 = null;

        GlossaParser.block_return block126 = null;


        CommonTree WHILE122_tree=null;
        CommonTree LOOP124_tree=null;
        CommonTree NEWLINE125_tree=null;
        CommonTree END_LOOP127_tree=null;
        CommonTree NEWLINE128_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:387:9: ( WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:387:11: WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            WHILE122=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStm1254); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE122_tree = (CommonTree)adaptor.create(WHILE122);
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE122_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_whileStm1257);
            expr123=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr123.getTree());
            LOOP124=(Token)match(input,LOOP,FOLLOW_LOOP_in_whileStm1259); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:387:29: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:387:30: NEWLINE
            	    {
            	    NEWLINE125=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1263); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_whileStm1268);
            block126=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block126.getTree());
            END_LOOP127=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_whileStm1270); if (state.failed) return retval;
            // src/glossa/grammars/Glossa.g:387:57: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:387:58: NEWLINE
            	    {
            	    NEWLINE128=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1274); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:389:1: repeatStm : REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ ;
    public final GlossaParser.repeatStm_return repeatStm() throws RecognitionException {
        GlossaParser.repeatStm_return retval = new GlossaParser.repeatStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REPEAT129=null;
        Token NEWLINE130=null;
        Token UNTIL132=null;
        Token NEWLINE134=null;
        GlossaParser.block_return block131 = null;

        GlossaParser.expr_return expr133 = null;


        CommonTree REPEAT129_tree=null;
        CommonTree NEWLINE130_tree=null;
        CommonTree UNTIL132_tree=null;
        CommonTree NEWLINE134_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:390:2: ( REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ )
            // src/glossa/grammars/Glossa.g:390:4: REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            REPEAT129=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeatStm1286); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REPEAT129_tree = (CommonTree)adaptor.create(REPEAT129);
            root_0 = (CommonTree)adaptor.becomeRoot(REPEAT129_tree, root_0);
            }
            // src/glossa/grammars/Glossa.g:390:12: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:390:13: NEWLINE
            	    {
            	    NEWLINE130=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1290); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_repeatStm1295);
            block131=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block131.getTree());
            UNTIL132=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_repeatStm1297); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_repeatStm1300);
            expr133=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr133.getTree());
            // src/glossa/grammars/Glossa.g:390:42: ( NEWLINE )+
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
            	    // src/glossa/grammars/Glossa.g:390:43: NEWLINE
            	    {
            	    NEWLINE134=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1303); if (state.failed) return retval;

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

    public static class procedureCallStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procedureCallStm"
    // src/glossa/grammars/Glossa.g:392:1: procedureCallStm : CALL ID LPAR paramsList RPAR ( NEWLINE )+ -> ^( CALL ID paramsList ) ;
    public final GlossaParser.procedureCallStm_return procedureCallStm() throws RecognitionException {
        GlossaParser.procedureCallStm_return retval = new GlossaParser.procedureCallStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CALL135=null;
        Token ID136=null;
        Token LPAR137=null;
        Token RPAR139=null;
        Token NEWLINE140=null;
        GlossaParser.paramsList_return paramsList138 = null;


        CommonTree CALL135_tree=null;
        CommonTree ID136_tree=null;
        CommonTree LPAR137_tree=null;
        CommonTree RPAR139_tree=null;
        CommonTree NEWLINE140_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_CALL=new RewriteRuleTokenStream(adaptor,"token CALL");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_paramsList=new RewriteRuleSubtreeStream(adaptor,"rule paramsList");
        try {
            // src/glossa/grammars/Glossa.g:393:2: ( CALL ID LPAR paramsList RPAR ( NEWLINE )+ -> ^( CALL ID paramsList ) )
            // src/glossa/grammars/Glossa.g:393:4: CALL ID LPAR paramsList RPAR ( NEWLINE )+
            {
            CALL135=(Token)match(input,CALL,FOLLOW_CALL_in_procedureCallStm1315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CALL.add(CALL135);

            ID136=(Token)match(input,ID,FOLLOW_ID_in_procedureCallStm1317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID136);

            LPAR137=(Token)match(input,LPAR,FOLLOW_LPAR_in_procedureCallStm1319); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR137);

            pushFollow(FOLLOW_paramsList_in_procedureCallStm1321);
            paramsList138=paramsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_paramsList.add(paramsList138.getTree());
            RPAR139=(Token)match(input,RPAR,FOLLOW_RPAR_in_procedureCallStm1323); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR139);

            // src/glossa/grammars/Glossa.g:393:33: ( NEWLINE )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==NEWLINE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE140=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_procedureCallStm1325); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE140);


            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);



            // AST REWRITE
            // elements: CALL, ID, paramsList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 393:42: -> ^( CALL ID paramsList )
            {
                // src/glossa/grammars/Glossa.g:393:45: ^( CALL ID paramsList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CALL.nextNode(), root_1);

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
    // $ANTLR end "procedureCallStm"

    public static class paramsList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "paramsList"
    // src/glossa/grammars/Glossa.g:395:1: paramsList : (params+= expr ( COMMA params+= expr )* )? -> ^( PARAMS ( $params)* ) ;
    public final GlossaParser.paramsList_return paramsList() throws RecognitionException {
        GlossaParser.paramsList_return retval = new GlossaParser.paramsList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA141=null;
        List list_params=null;
        RuleReturnScope params = null;
        CommonTree COMMA141_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:396:2: ( (params+= expr ( COMMA params+= expr )* )? -> ^( PARAMS ( $params)* ) )
            // src/glossa/grammars/Glossa.g:396:4: (params+= expr ( COMMA params+= expr )* )?
            {
            // src/glossa/grammars/Glossa.g:396:4: (params+= expr ( COMMA params+= expr )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ID||LA54_0==LPAR||(LA54_0>=PLUS && LA54_0<=MINUS)||(LA54_0>=NOT && LA54_0<=CONST_REAL)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:396:5: params+= expr ( COMMA params+= expr )*
                    {
                    pushFollow(FOLLOW_expr_in_paramsList1348);
                    params=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(params.getTree());
                    if (list_params==null) list_params=new ArrayList();
                    list_params.add(params.getTree());

                    // src/glossa/grammars/Glossa.g:396:18: ( COMMA params+= expr )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==COMMA) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:396:19: COMMA params+= expr
                    	    {
                    	    COMMA141=(Token)match(input,COMMA,FOLLOW_COMMA_in_paramsList1351); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA141);

                    	    pushFollow(FOLLOW_expr_in_paramsList1355);
                    	    params=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(params.getTree());
                    	    if (list_params==null) list_params=new ArrayList();
                    	    list_params.add(params.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
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
            // 396:42: -> ^( PARAMS ( $params)* )
            {
                // src/glossa/grammars/Glossa.g:396:45: ^( PARAMS ( $params)* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMS, "PARAMS"), root_1);

                // src/glossa/grammars/Glossa.g:396:54: ( $params)*
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
    // src/glossa/grammars/Glossa.g:398:1: expr : andExpr ( OR andExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR143=null;
        GlossaParser.andExpr_return andExpr142 = null;

        GlossaParser.andExpr_return andExpr144 = null;


        CommonTree OR143_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:398:6: ( andExpr ( OR andExpr )* )
            // src/glossa/grammars/Glossa.g:398:8: andExpr ( OR andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_expr1377);
            andExpr142=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr142.getTree());
            // src/glossa/grammars/Glossa.g:398:16: ( OR andExpr )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==OR) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:398:18: OR andExpr
            	    {
            	    OR143=(Token)match(input,OR,FOLLOW_OR_in_expr1381); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR143_tree = (CommonTree)adaptor.create(OR143);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR143_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_expr1384);
            	    andExpr144=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr144.getTree());

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
    // $ANTLR end "expr"

    public static class andExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // src/glossa/grammars/Glossa.g:400:1: andExpr : eqExpr ( AND eqExpr )* ;
    public final GlossaParser.andExpr_return andExpr() throws RecognitionException {
        GlossaParser.andExpr_return retval = new GlossaParser.andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND146=null;
        GlossaParser.eqExpr_return eqExpr145 = null;

        GlossaParser.eqExpr_return eqExpr147 = null;


        CommonTree AND146_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:400:9: ( eqExpr ( AND eqExpr )* )
            // src/glossa/grammars/Glossa.g:400:17: eqExpr ( AND eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_andExpr1400);
            eqExpr145=eqExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr145.getTree());
            // src/glossa/grammars/Glossa.g:400:24: ( AND eqExpr )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==AND) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:400:25: AND eqExpr
            	    {
            	    AND146=(Token)match(input,AND,FOLLOW_AND_in_andExpr1403); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND146_tree = (CommonTree)adaptor.create(AND146);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND146_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_eqExpr_in_andExpr1406);
            	    eqExpr147=eqExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr147.getTree());

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
    // $ANTLR end "andExpr"

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // src/glossa/grammars/Glossa.g:402:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ149=null;
        Token NEQ151=null;
        GlossaParser.compExpr_return compExpr148 = null;

        GlossaParser.compExpr_return compExpr150 = null;

        GlossaParser.compExpr_return compExpr152 = null;


        CommonTree EQ149_tree=null;
        CommonTree NEQ151_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:402:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/grammars/Glossa.g:402:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr1416);
            compExpr148=compExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr148.getTree());
            // src/glossa/grammars/Glossa.g:402:19: ( EQ compExpr | NEQ compExpr )*
            loop57:
            do {
                int alt57=3;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==EQ) ) {
                    alt57=1;
                }
                else if ( (LA57_0==NEQ) ) {
                    alt57=2;
                }


                switch (alt57) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:402:20: EQ compExpr
            	    {
            	    EQ149=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr1419); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    EQ149_tree = (CommonTree)adaptor.create(EQ149);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ149_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1422);
            	    compExpr150=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr150.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:402:35: NEQ compExpr
            	    {
            	    NEQ151=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr1426); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEQ151_tree = (CommonTree)adaptor.create(NEQ151);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ151_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1429);
            	    compExpr152=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr152.getTree());

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
    // $ANTLR end "eqExpr"

    public static class compExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compExpr"
    // src/glossa/grammars/Glossa.g:404:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT154=null;
        Token LE156=null;
        Token GT158=null;
        Token GE160=null;
        GlossaParser.addExpr_return addExpr153 = null;

        GlossaParser.addExpr_return addExpr155 = null;

        GlossaParser.addExpr_return addExpr157 = null;

        GlossaParser.addExpr_return addExpr159 = null;

        GlossaParser.addExpr_return addExpr161 = null;


        CommonTree LT154_tree=null;
        CommonTree LE156_tree=null;
        CommonTree GT158_tree=null;
        CommonTree GE160_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:404:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/grammars/Glossa.g:404:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr1440);
            addExpr153=addExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr153.getTree());
            // src/glossa/grammars/Glossa.g:404:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop58:
            do {
                int alt58=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt58=1;
                    }
                    break;
                case LE:
                    {
                    alt58=2;
                    }
                    break;
                case GT:
                    {
                    alt58=3;
                    }
                    break;
                case GE:
                    {
                    alt58=4;
                    }
                    break;

                }

                switch (alt58) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:404:20: LT addExpr
            	    {
            	    LT154=(Token)match(input,LT,FOLLOW_LT_in_compExpr1443); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LT154_tree = (CommonTree)adaptor.create(LT154);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT154_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1446);
            	    addExpr155=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr155.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:404:34: LE addExpr
            	    {
            	    LE156=(Token)match(input,LE,FOLLOW_LE_in_compExpr1450); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LE156_tree = (CommonTree)adaptor.create(LE156);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE156_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1453);
            	    addExpr157=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr157.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/grammars/Glossa.g:404:48: GT addExpr
            	    {
            	    GT158=(Token)match(input,GT,FOLLOW_GT_in_compExpr1457); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GT158_tree = (CommonTree)adaptor.create(GT158);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT158_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1460);
            	    addExpr159=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr159.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/grammars/Glossa.g:404:62: GE addExpr
            	    {
            	    GE160=(Token)match(input,GE,FOLLOW_GE_in_compExpr1464); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GE160_tree = (CommonTree)adaptor.create(GE160);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE160_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1467);
            	    addExpr161=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr161.getTree());

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
    // $ANTLR end "compExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // src/glossa/grammars/Glossa.g:406:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS163=null;
        Token MINUS165=null;
        GlossaParser.multExpr_return multExpr162 = null;

        GlossaParser.multExpr_return multExpr164 = null;

        GlossaParser.multExpr_return multExpr166 = null;


        CommonTree PLUS163_tree=null;
        CommonTree MINUS165_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:406:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/grammars/Glossa.g:406:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr1480);
            multExpr162=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr162.getTree());
            // src/glossa/grammars/Glossa.g:406:20: ( PLUS multExpr | MINUS multExpr )*
            loop59:
            do {
                int alt59=3;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==PLUS) ) {
                    alt59=1;
                }
                else if ( (LA59_0==MINUS) ) {
                    alt59=2;
                }


                switch (alt59) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:406:21: PLUS multExpr
            	    {
            	    PLUS163=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr1483); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    PLUS163_tree = (CommonTree)adaptor.create(PLUS163);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS163_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1486);
            	    multExpr164=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr164.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:406:38: MINUS multExpr
            	    {
            	    MINUS165=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr1490); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MINUS165_tree = (CommonTree)adaptor.create(MINUS165);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS165_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1493);
            	    multExpr166=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr166.getTree());

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
    // $ANTLR end "addExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // src/glossa/grammars/Glossa.g:408:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES168=null;
        Token DIA170=null;
        Token DIV172=null;
        Token MOD174=null;
        GlossaParser.powExpr_return powExpr167 = null;

        GlossaParser.powExpr_return powExpr169 = null;

        GlossaParser.powExpr_return powExpr171 = null;

        GlossaParser.powExpr_return powExpr173 = null;

        GlossaParser.powExpr_return powExpr175 = null;


        CommonTree TIMES168_tree=null;
        CommonTree DIA170_tree=null;
        CommonTree DIV172_tree=null;
        CommonTree MOD174_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:408:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/grammars/Glossa.g:408:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr1505);
            powExpr167=powExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr167.getTree());
            // src/glossa/grammars/Glossa.g:408:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop60:
            do {
                int alt60=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt60=1;
                    }
                    break;
                case DIA:
                    {
                    alt60=2;
                    }
                    break;
                case DIV:
                    {
                    alt60=3;
                    }
                    break;
                case MOD:
                    {
                    alt60=4;
                    }
                    break;

                }

                switch (alt60) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:408:21: TIMES powExpr
            	    {
            	    TIMES168=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr1508); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TIMES168_tree = (CommonTree)adaptor.create(TIMES168);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES168_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1511);
            	    powExpr169=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr169.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/Glossa.g:408:38: DIA powExpr
            	    {
            	    DIA170=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr1515); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIA170_tree = (CommonTree)adaptor.create(DIA170);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA170_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1518);
            	    powExpr171=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr171.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/grammars/Glossa.g:408:53: DIV powExpr
            	    {
            	    DIV172=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr1522); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV172_tree = (CommonTree)adaptor.create(DIV172);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV172_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1525);
            	    powExpr173=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr173.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/grammars/Glossa.g:408:68: MOD powExpr
            	    {
            	    MOD174=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr1529); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MOD174_tree = (CommonTree)adaptor.create(MOD174);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD174_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1532);
            	    powExpr175=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr175.getTree());

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
    // $ANTLR end "multExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpr"
    // src/glossa/grammars/Glossa.g:410:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW177=null;
        GlossaParser.unaryExpr_return unaryExpr176 = null;

        GlossaParser.unaryExpr_return unaryExpr178 = null;


        CommonTree POW177_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:410:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/grammars/Glossa.g:410:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr1544);
            unaryExpr176=unaryExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr176.getTree());
            // src/glossa/grammars/Glossa.g:410:21: ( POW unaryExpr )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==POW) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:410:22: POW unaryExpr
            	    {
            	    POW177=(Token)match(input,POW,FOLLOW_POW_in_powExpr1547); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW177_tree = (CommonTree)adaptor.create(POW177);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW177_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_unaryExpr_in_powExpr1550);
            	    unaryExpr178=unaryExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr178.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
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
    // src/glossa/grammars/Glossa.g:412:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS179=null;
        Token MINUS181=null;
        Token NOT183=null;
        GlossaParser.atom_return atom180 = null;

        GlossaParser.atom_return atom182 = null;

        GlossaParser.atom_return atom184 = null;

        GlossaParser.atom_return atom185 = null;


        CommonTree PLUS179_tree=null;
        CommonTree MINUS181_tree=null;
        CommonTree NOT183_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/grammars/Glossa.g:413:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt62=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt62=1;
                }
                break;
            case MINUS:
                {
                alt62=2;
                }
                break;
            case NOT:
                {
                alt62=3;
                }
                break;
            case ID:
            case LPAR:
            case CONST_TRUE:
            case CONST_FALSE:
            case CONST_STR:
            case CONST_INT:
            case CONST_REAL:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:413:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS179=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr1561); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_unaryExpr1564);
                    atom180=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom180.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:414:4: MINUS atom
                    {
                    MINUS181=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr1569); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS181);

                    pushFollow(FOLLOW_atom_in_unaryExpr1571);
                    atom182=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom182.getTree());


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
                    // 414:15: -> ^( NEG atom )
                    {
                        // src/glossa/grammars/Glossa.g:414:18: ^( NEG atom )
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
                    // src/glossa/grammars/Glossa.g:415:4: NOT atom
                    {
                    NOT183=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr1584); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT183);

                    pushFollow(FOLLOW_atom_in_unaryExpr1586);
                    atom184=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom184.getTree());


                    // AST REWRITE
                    // elements: atom, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 415:13: -> ^( NOT atom )
                    {
                        // src/glossa/grammars/Glossa.g:415:16: ^( NOT atom )
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
                    // src/glossa/grammars/Glossa.g:416:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr1599);
                    atom185=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom185.getTree());

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
    // src/glossa/grammars/Glossa.g:419:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE186=null;
        Token CONST_FALSE187=null;
        Token CONST_STR188=null;
        Token CONST_INT189=null;
        Token CONST_REAL190=null;
        Token ID192=null;
        Token char_literal194=null;
        Token char_literal196=null;
        GlossaParser.arrayItem_return arrayItem191 = null;

        GlossaParser.functionCall_return functionCall193 = null;

        GlossaParser.expr_return expr195 = null;


        CommonTree CONST_TRUE186_tree=null;
        CommonTree CONST_FALSE187_tree=null;
        CommonTree CONST_STR188_tree=null;
        CommonTree CONST_INT189_tree=null;
        CommonTree CONST_REAL190_tree=null;
        CommonTree ID192_tree=null;
        CommonTree char_literal194_tree=null;
        CommonTree char_literal196_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:419:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' )
            int alt63=9;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:419:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE186=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom1608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_TRUE186_tree = (CommonTree)adaptor.create(CONST_TRUE186);
                    adaptor.addChild(root_0, CONST_TRUE186_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/Glossa.g:420:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE187=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom1613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_FALSE187_tree = (CommonTree)adaptor.create(CONST_FALSE187);
                    adaptor.addChild(root_0, CONST_FALSE187_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/Glossa.g:421:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR188=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom1618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_STR188_tree = (CommonTree)adaptor.create(CONST_STR188);
                    adaptor.addChild(root_0, CONST_STR188_tree);
                    }

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/Glossa.g:422:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT189=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom1623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_INT189_tree = (CommonTree)adaptor.create(CONST_INT189);
                    adaptor.addChild(root_0, CONST_INT189_tree);
                    }

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/Glossa.g:423:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL190=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom1628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_REAL190_tree = (CommonTree)adaptor.create(CONST_REAL190);
                    adaptor.addChild(root_0, CONST_REAL190_tree);
                    }

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/Glossa.g:424:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom1633);
                    arrayItem191=arrayItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayItem191.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/Glossa.g:425:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID192=(Token)match(input,ID,FOLLOW_ID_in_atom1638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID192_tree = (CommonTree)adaptor.create(ID192);
                    adaptor.addChild(root_0, ID192_tree);
                    }

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/Glossa.g:426:11: functionCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_atom1650);
                    functionCall193=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall193.getTree());

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/Glossa.g:427:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal194=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1655); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1658);
                    expr195=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr195.getTree());
                    char_literal196=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1660); if (state.failed) return retval;

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
    // src/glossa/grammars/Glossa.g:429:1: functionCall : ID LPAR paramsList RPAR -> ^( FUNC_CALL ID paramsList ) ;
    public final GlossaParser.functionCall_return functionCall() throws RecognitionException {
        GlossaParser.functionCall_return retval = new GlossaParser.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID197=null;
        Token LPAR198=null;
        Token RPAR200=null;
        GlossaParser.paramsList_return paramsList199 = null;


        CommonTree ID197_tree=null;
        CommonTree LPAR198_tree=null;
        CommonTree RPAR200_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_paramsList=new RewriteRuleSubtreeStream(adaptor,"rule paramsList");
        try {
            // src/glossa/grammars/Glossa.g:430:2: ( ID LPAR paramsList RPAR -> ^( FUNC_CALL ID paramsList ) )
            // src/glossa/grammars/Glossa.g:430:4: ID LPAR paramsList RPAR
            {
            ID197=(Token)match(input,ID,FOLLOW_ID_in_functionCall1670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID197);

            LPAR198=(Token)match(input,LPAR,FOLLOW_LPAR_in_functionCall1672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR198);

            pushFollow(FOLLOW_paramsList_in_functionCall1674);
            paramsList199=paramsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_paramsList.add(paramsList199.getTree());
            RPAR200=(Token)match(input,RPAR,FOLLOW_RPAR_in_functionCall1676); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR200);



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
            // 430:28: -> ^( FUNC_CALL ID paramsList )
            {
                // src/glossa/grammars/Glossa.g:430:31: ^( FUNC_CALL ID paramsList )
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
    // src/glossa/grammars/Glossa.g:432:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID201=null;
        GlossaParser.arraySubscript_return arraySubscript202 = null;


        CommonTree ID201_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/grammars/Glossa.g:433:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/grammars/Glossa.g:433:4: ID arraySubscript
            {
            ID201=(Token)match(input,ID,FOLLOW_ID_in_arrayItem1696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID201);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem1698);
            arraySubscript202=arraySubscript();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arraySubscript.add(arraySubscript202.getTree());


            // AST REWRITE
            // elements: arraySubscript, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 433:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/grammars/Glossa.g:433:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/grammars/Glossa.g:435:1: arraySubscript : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET203=null;
        Token COMMA204=null;
        Token RBRACKET205=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET203_tree=null;
        CommonTree COMMA204_tree=null;
        CommonTree RBRACKET205_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/grammars/Glossa.g:436:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/Glossa.g:436:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET203=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1718); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET203);

            // src/glossa/grammars/Glossa.g:436:13: (dimension+= expr )
            // src/glossa/grammars/Glossa.g:436:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arraySubscript1723);
            dimension=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/grammars/Glossa.g:436:31: ( COMMA dimension+= expr )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==COMMA) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:436:32: COMMA dimension+= expr
            	    {
            	    COMMA204=(Token)match(input,COMMA,FOLLOW_COMMA_in_arraySubscript1727); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA204);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1731);
            	    dimension=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            RBRACKET205=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1735); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET205);



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
            // 436:65: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/grammars/Glossa.g:436:68: ^( ARRAY_INDEX ( expr )+ )
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

    public static class procedure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procedure"
    // src/glossa/grammars/Glossa.g:438:1: procedure : PROCEDURE ID LPAR formalParamsList RPAR ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_PROCEDURE ( NEWLINE )+ -> ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block ) ;
    public final GlossaParser.procedure_return procedure() throws RecognitionException {
        GlossaParser.procedure_return retval = new GlossaParser.procedure_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROCEDURE206=null;
        Token ID207=null;
        Token LPAR208=null;
        Token RPAR210=null;
        Token NEWLINE211=null;
        Token BEGIN214=null;
        Token NEWLINE215=null;
        Token END_PROCEDURE217=null;
        Token NEWLINE218=null;
        GlossaParser.formalParamsList_return formalParamsList209 = null;

        GlossaParser.constDecl_return constDecl212 = null;

        GlossaParser.varDecl_return varDecl213 = null;

        GlossaParser.block_return block216 = null;


        CommonTree PROCEDURE206_tree=null;
        CommonTree ID207_tree=null;
        CommonTree LPAR208_tree=null;
        CommonTree RPAR210_tree=null;
        CommonTree NEWLINE211_tree=null;
        CommonTree BEGIN214_tree=null;
        CommonTree NEWLINE215_tree=null;
        CommonTree END_PROCEDURE217_tree=null;
        CommonTree NEWLINE218_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_END_PROCEDURE=new RewriteRuleTokenStream(adaptor,"token END_PROCEDURE");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PROCEDURE=new RewriteRuleTokenStream(adaptor,"token PROCEDURE");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_constDecl=new RewriteRuleSubtreeStream(adaptor,"rule constDecl");
        RewriteRuleSubtreeStream stream_formalParamsList=new RewriteRuleSubtreeStream(adaptor,"rule formalParamsList");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/glossa/grammars/Glossa.g:439:2: ( PROCEDURE ID LPAR formalParamsList RPAR ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_PROCEDURE ( NEWLINE )+ -> ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/Glossa.g:439:4: PROCEDURE ID LPAR formalParamsList RPAR ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_PROCEDURE ( NEWLINE )+
            {
            PROCEDURE206=(Token)match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure1753); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PROCEDURE.add(PROCEDURE206);

            ID207=(Token)match(input,ID,FOLLOW_ID_in_procedure1755); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID207);

            LPAR208=(Token)match(input,LPAR,FOLLOW_LPAR_in_procedure1757); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR208);

            pushFollow(FOLLOW_formalParamsList_in_procedure1759);
            formalParamsList209=formalParamsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParamsList.add(formalParamsList209.getTree());
            RPAR210=(Token)match(input,RPAR,FOLLOW_RPAR_in_procedure1761); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR210);

            // src/glossa/grammars/Glossa.g:439:44: ( NEWLINE )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==NEWLINE) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE211=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_procedure1763); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE211);


            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);

            // src/glossa/grammars/Glossa.g:440:3: ( constDecl )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==CONSTANTS) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_procedure1768);
                    constDecl212=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constDecl.add(constDecl212.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:440:14: ( varDecl )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==VARIABLES) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_procedure1771);
                    varDecl213=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl213.getTree());

                    }
                    break;

            }

            BEGIN214=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_procedure1776); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN214);

            // src/glossa/grammars/Glossa.g:441:10: ( NEWLINE )+
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
            	    NEWLINE215=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_procedure1779); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE215);


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

            pushFollow(FOLLOW_block_in_procedure1784);
            block216=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block216.getTree());
            END_PROCEDURE217=(Token)match(input,END_PROCEDURE,FOLLOW_END_PROCEDURE_in_procedure1788); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_PROCEDURE.add(END_PROCEDURE217);

            // src/glossa/grammars/Glossa.g:443:17: ( NEWLINE )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==NEWLINE) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE218=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_procedure1790); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE218);


            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
            } while (true);



            // AST REWRITE
            // elements: ID, PROCEDURE, constDecl, formalParamsList, block, varDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 443:26: -> ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block )
            {
                // src/glossa/grammars/Glossa.g:443:29: ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_PROCEDURE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_formalParamsList.nextTree());
                // src/glossa/grammars/Glossa.g:443:61: ( constDecl )?
                if ( stream_constDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_constDecl.nextTree());

                }
                stream_constDecl.reset();
                // src/glossa/grammars/Glossa.g:443:72: ( varDecl )?
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
    // $ANTLR end "procedure"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // src/glossa/grammars/Glossa.g:445:1: function : FUNCTION ID LPAR formalParamsList RPAR COLON returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+ -> ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block ) ;
    public final GlossaParser.function_return function() throws RecognitionException {
        GlossaParser.function_return retval = new GlossaParser.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCTION219=null;
        Token ID220=null;
        Token LPAR221=null;
        Token RPAR223=null;
        Token COLON224=null;
        Token NEWLINE226=null;
        Token BEGIN229=null;
        Token NEWLINE230=null;
        Token END_FUNCTION232=null;
        Token NEWLINE233=null;
        GlossaParser.formalParamsList_return formalParamsList222 = null;

        GlossaParser.returnType_return returnType225 = null;

        GlossaParser.constDecl_return constDecl227 = null;

        GlossaParser.varDecl_return varDecl228 = null;

        GlossaParser.block_return block231 = null;


        CommonTree FUNCTION219_tree=null;
        CommonTree ID220_tree=null;
        CommonTree LPAR221_tree=null;
        CommonTree RPAR223_tree=null;
        CommonTree COLON224_tree=null;
        CommonTree NEWLINE226_tree=null;
        CommonTree BEGIN229_tree=null;
        CommonTree NEWLINE230_tree=null;
        CommonTree END_FUNCTION232_tree=null;
        CommonTree NEWLINE233_tree=null;
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
            // src/glossa/grammars/Glossa.g:446:2: ( FUNCTION ID LPAR formalParamsList RPAR COLON returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+ -> ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/Glossa.g:446:4: FUNCTION ID LPAR formalParamsList RPAR COLON returnType ( NEWLINE )+ ( constDecl )? ( varDecl )? BEGIN ( NEWLINE )+ block END_FUNCTION ( NEWLINE )+
            {
            FUNCTION219=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function1818); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(FUNCTION219);

            ID220=(Token)match(input,ID,FOLLOW_ID_in_function1820); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID220);

            LPAR221=(Token)match(input,LPAR,FOLLOW_LPAR_in_function1822); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR221);

            pushFollow(FOLLOW_formalParamsList_in_function1824);
            formalParamsList222=formalParamsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_formalParamsList.add(formalParamsList222.getTree());
            RPAR223=(Token)match(input,RPAR,FOLLOW_RPAR_in_function1826); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR223);

            COLON224=(Token)match(input,COLON,FOLLOW_COLON_in_function1828); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON224);

            pushFollow(FOLLOW_returnType_in_function1830);
            returnType225=returnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_returnType.add(returnType225.getTree());
            // src/glossa/grammars/Glossa.g:446:60: ( NEWLINE )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==NEWLINE) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE226=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1832); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE226);


            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
            } while (true);

            // src/glossa/grammars/Glossa.g:447:3: ( constDecl )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CONSTANTS) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_function1837);
                    constDecl227=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constDecl.add(constDecl227.getTree());

                    }
                    break;

            }

            // src/glossa/grammars/Glossa.g:447:14: ( varDecl )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==VARIABLES) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:0:0: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_function1840);
                    varDecl228=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl228.getTree());

                    }
                    break;

            }

            BEGIN229=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_function1845); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BEGIN.add(BEGIN229);

            // src/glossa/grammars/Glossa.g:448:10: ( NEWLINE )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==NEWLINE) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE230=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1848); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE230);


            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);

            pushFollow(FOLLOW_block_in_function1853);
            block231=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block231.getTree());
            END_FUNCTION232=(Token)match(input,END_FUNCTION,FOLLOW_END_FUNCTION_in_function1857); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_FUNCTION.add(END_FUNCTION232);

            // src/glossa/grammars/Glossa.g:450:16: ( NEWLINE )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==NEWLINE) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // src/glossa/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE233=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function1859); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE233);


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);



            // AST REWRITE
            // elements: formalParamsList, ID, constDecl, block, varDecl, returnType, FUNCTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 450:25: -> ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block )
            {
                // src/glossa/grammars/Glossa.g:450:28: ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_returnType.nextTree());
                adaptor.addChild(root_1, stream_formalParamsList.nextTree());
                // src/glossa/grammars/Glossa.g:450:70: ( constDecl )?
                if ( stream_constDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_constDecl.nextTree());

                }
                stream_constDecl.reset();
                // src/glossa/grammars/Glossa.g:450:81: ( varDecl )?
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
    // src/glossa/grammars/Glossa.g:452:1: returnType : ( INTEGER | REAL | STRING | BOOLEAN );
    public final GlossaParser.returnType_return returnType() throws RecognitionException {
        GlossaParser.returnType_return retval = new GlossaParser.returnType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set234=null;

        CommonTree set234_tree=null;

        try {
            // src/glossa/grammars/Glossa.g:453:2: ( INTEGER | REAL | STRING | BOOLEAN )
            // src/glossa/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set234=(Token)input.LT(1);
            if ( (input.LA(1)>=INTEGER && input.LA(1)<=BOOLEAN) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set234));
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
    // src/glossa/grammars/Glossa.g:458:1: formalParamsList : (params+= ID ( COMMA params+= ID )* )? -> ^( FORMAL_PARAMS ( $params)* ) ;
    public final GlossaParser.formalParamsList_return formalParamsList() throws RecognitionException {
        GlossaParser.formalParamsList_return retval = new GlossaParser.formalParamsList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA235=null;
        Token params=null;
        List list_params=null;

        CommonTree COMMA235_tree=null;
        CommonTree params_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // src/glossa/grammars/Glossa.g:459:2: ( (params+= ID ( COMMA params+= ID )* )? -> ^( FORMAL_PARAMS ( $params)* ) )
            // src/glossa/grammars/Glossa.g:459:4: (params+= ID ( COMMA params+= ID )* )?
            {
            // src/glossa/grammars/Glossa.g:459:4: (params+= ID ( COMMA params+= ID )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==ID) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // src/glossa/grammars/Glossa.g:459:5: params+= ID ( COMMA params+= ID )*
                    {
                    params=(Token)match(input,ID,FOLLOW_ID_in_formalParamsList1916); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(params);

                    if (list_params==null) list_params=new ArrayList();
                    list_params.add(params);

                    // src/glossa/grammars/Glossa.g:459:16: ( COMMA params+= ID )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==COMMA) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // src/glossa/grammars/Glossa.g:459:17: COMMA params+= ID
                    	    {
                    	    COMMA235=(Token)match(input,COMMA,FOLLOW_COMMA_in_formalParamsList1919); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA235);

                    	    params=(Token)match(input,ID,FOLLOW_ID_in_formalParamsList1923); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(params);

                    	    if (list_params==null) list_params=new ArrayList();
                    	    list_params.add(params);


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
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
            // 459:38: -> ^( FORMAL_PARAMS ( $params)* )
            {
                // src/glossa/grammars/Glossa.g:459:41: ^( FORMAL_PARAMS ( $params)* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL_PARAMS, "FORMAL_PARAMS"), root_1);

                // src/glossa/grammars/Glossa.g:459:57: ( $params)*
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

    // $ANTLR start synpred52_Glossa
    public final void synpred52_Glossa_fragment() throws RecognitionException {   
        // src/glossa/grammars/Glossa.g:369:5: ( rangeItem )
        // src/glossa/grammars/Glossa.g:369:5: rangeItem
        {
        pushFollow(FOLLOW_rangeItem_in_synpred52_Glossa968);
        rangeItem();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Glossa

    // $ANTLR start synpred53_Glossa
    public final void synpred53_Glossa_fragment() throws RecognitionException {   
        // src/glossa/grammars/Glossa.g:369:17: ( expr )
        // src/glossa/grammars/Glossa.g:369:17: expr
        {
        pushFollow(FOLLOW_expr_in_synpred53_Glossa972);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_Glossa

    // Delegated rules

    public final boolean synpred53_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Glossa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Glossa_fragment(); // can never throw exception
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
    protected DFA63 dfa63 = new DFA63(this);
    static final String DFA41_eotS =
        "\21\uffff";
    static final String DFA41_eofS =
        "\21\uffff";
    static final String DFA41_minS =
        "\1\23\12\0\6\uffff";
    static final String DFA41_maxS =
        "\1\114\12\0\6\uffff";
    static final String DFA41_acceptS =
        "\13\uffff\1\3\3\uffff\1\1\1\2";
    static final String DFA41_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\6\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\11\31\uffff\4\13\12\uffff\1\12\4\uffff\1\1\1\2\5\uffff\1"+
            "\3\1\4\1\5\1\6\1\7\1\10",
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
            return "368:1: caseExprListItem : ( rangeItem | expr | infRangeItem );";
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
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_3 = input.LA(1);

                         
                        int index41_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA41_6 = input.LA(1);

                         
                        int index41_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA41_8 = input.LA(1);

                         
                        int index41_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA41_9 = input.LA(1);

                         
                        int index41_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
                        input.seek(index41_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA41_10 = input.LA(1);

                         
                        int index41_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Glossa()) ) {s = 15;}

                        else if ( (synpred53_Glossa()) ) {s = 16;}

                         
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
    static final String DFA63_eotS =
        "\13\uffff";
    static final String DFA63_eofS =
        "\6\uffff\1\11\4\uffff";
    static final String DFA63_minS =
        "\1\23\5\uffff\1\21\4\uffff";
    static final String DFA63_maxS =
        "\1\114\5\uffff\1\106\4\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\11\1\10\1\7\1\6";
    static final String DFA63_specialS =
        "\13\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\6\47\uffff\1\7\14\uffff\1\1\1\2\1\3\1\4\1\5",
            "",
            "",
            "",
            "",
            "",
            "\1\11\5\uffff\1\11\2\uffff\1\11\1\12\1\11\11\uffff\1\11\5\uffff"+
            "\5\11\2\uffff\2\11\2\uffff\1\11\3\uffff\1\10\13\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "419:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | functionCall | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_NEWLINE_in_unit153 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_program_in_unit158 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_function_in_unit161 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_procedure_in_unit163 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_PROGRAM_in_program173 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_program178 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program181 = new BitSet(new long[]{0x0000000001520000L});
    public static final BitSet FOLLOW_declarations_in_program188 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BEGIN_in_program192 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program197 = new BitSet(new long[]{0x05420226002A0000L});
    public static final BitSet FOLLOW_block_in_program204 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program208 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_ID_in_program214 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_program219 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_constDecl_in_declarations233 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_varDecl_in_declarations236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl248 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl252 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl257 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ID_in_constAssign267 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EQ_in_constAssign269 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_constAssign272 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign275 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl287 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl291 = new BitSet(new long[]{0x00000001E0020002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl296 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_varType_in_varsDecl307 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl310 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl313 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl316 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl319 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl324 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem343 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension364 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_arrayDimension369 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayDimension373 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_arrayDimension377 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block424 = new BitSet(new long[]{0x0542022600080002L});
    public static final BitSet FOLLOW_printStm_in_stm443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseStm_in_stm502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStm_in_stm520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStm_in_stm538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatStm_in_stm556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedureCallStm_in_stm568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm594 = new BitSet(new long[]{0x08000000000A0000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_printStm598 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_printStm602 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_printStm605 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm613 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_READ_in_readStm640 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_readItem_in_readStm643 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_COMMA_in_readStm646 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_readItem_in_readStm649 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm654 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_readItem691 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm734 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm736 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_assingmentStm741 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm744 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm767 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm769 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm771 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_assingmentStm776 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm779 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm799 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm801 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm804 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm807 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm810 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IF_in_ifBlock834 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_ifBlock837 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock839 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock843 = new BitSet(new long[]{0x05420226000A0000L});
    public static final BitSet FOLLOW_block_in_ifBlock848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock857 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock861 = new BitSet(new long[]{0x05420226000A0000L});
    public static final BitSet FOLLOW_block_in_elseBlock866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock875 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock878 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock880 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock884 = new BitSet(new long[]{0x05420226000A0000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_caseStm897 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_caseStm900 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm903 = new BitSet(new long[]{0x00000C0000020000L});
    public static final BitSet FOLLOW_caseBlock_in_caseStm908 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_caseElseBlock_in_caseStm911 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_END_SWITCH_in_caseStm914 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm918 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CASE_in_caseBlock930 = new BitSet(new long[]{0x0801E00000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_caseExprList_in_caseBlock933 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseBlock936 = new BitSet(new long[]{0x05420226000A0000L});
    public static final BitSet FOLLOW_block_in_caseBlock941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList950 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_caseExprList953 = new BitSet(new long[]{0x0801E00000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList956 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rangeItem_in_caseExprListItem968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infRangeItem_in_caseExprListItem976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_rangeItem1000 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RANGE_in_rangeItem1002 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_rangeItem1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_infRangeItem1040 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_infRangeItem1070 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_infRangeItem1100 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_infRangeItem1130 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_infRangeItem1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseElseBlock1160 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ELSE_in_caseElseBlock1162 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseElseBlock1164 = new BitSet(new long[]{0x05420226000A0000L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStm1182 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_forStm1185 = new BitSet(new long[]{0x0004000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_forStm1187 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_FROM_in_forStm1190 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_forStm1195 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_TO_in_forStm1197 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_forStm1202 = new BitSet(new long[]{0x0010000000020000L});
    public static final BitSet FOLLOW_STEP_in_forStm1205 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_forStm1210 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1215 = new BitSet(new long[]{0x05620226000A0000L});
    public static final BitSet FOLLOW_block_in_forStm1220 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_forStm1222 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1226 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_WHILE_in_whileStm1254 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_whileStm1257 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_LOOP_in_whileStm1259 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1263 = new BitSet(new long[]{0x05620226000A0000L});
    public static final BitSet FOLLOW_block_in_whileStm1268 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_whileStm1270 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1274 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_REPEAT_in_repeatStm1286 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1290 = new BitSet(new long[]{0x07420226000A0000L});
    public static final BitSet FOLLOW_block_in_repeatStm1295 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_repeatStm1297 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_repeatStm1300 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1303 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CALL_in_procedureCallStm1315 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_procedureCallStm1317 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_LPAR_in_procedureCallStm1319 = new BitSet(new long[]{0x1800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_paramsList_in_procedureCallStm1321 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RPAR_in_procedureCallStm1323 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_procedureCallStm1325 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_expr_in_paramsList1348 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_paramsList1351 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_paramsList1355 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_andExpr_in_expr1377 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_OR_in_expr1381 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_andExpr_in_expr1384 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1400 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_AND_in_andExpr1403 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1406 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1416 = new BitSet(new long[]{0x8000000000800002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr1419 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1422 = new BitSet(new long[]{0x8000000000800002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr1426 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1429 = new BitSet(new long[]{0x8000000000800002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1440 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr1443 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1446 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr1450 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1453 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr1457 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1460 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr1464 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1467 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1480 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_PLUS_in_addExpr1483 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1486 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_MINUS_in_addExpr1490 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1493 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1505 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_TIMES_in_multExpr1508 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1511 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_DIA_in_multExpr1515 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1518 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_DIV_in_multExpr1522 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1525 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_MOD_in_multExpr1529 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1532 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1544 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_POW_in_powExpr1547 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1550 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr1561 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr1569 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr1584 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_atom1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1655 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_atom1658 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall1670 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_LPAR_in_functionCall1672 = new BitSet(new long[]{0x1800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_paramsList_in_functionCall1674 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RPAR_in_functionCall1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem1696 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1718 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1723 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_COMMA_in_arraySubscript1727 = new BitSet(new long[]{0x0800000000080000L,0x0000000000001F83L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1731 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure1753 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_procedure1755 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_LPAR_in_procedure1757 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_formalParamsList_in_procedure1759 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RPAR_in_procedure1761 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_procedure1763 = new BitSet(new long[]{0x0000000001520000L});
    public static final BitSet FOLLOW_constDecl_in_procedure1768 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_varDecl_in_procedure1771 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BEGIN_in_procedure1776 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_procedure1779 = new BitSet(new long[]{0x05420226000A0000L,0x0000000000004000L});
    public static final BitSet FOLLOW_block_in_procedure1784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_END_PROCEDURE_in_procedure1788 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_procedure1790 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_FUNCTION_in_function1818 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function1820 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_LPAR_in_function1822 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_formalParamsList_in_function1824 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RPAR_in_function1826 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COLON_in_function1828 = new BitSet(new long[]{0x0000000000000000L,0x00000000001E0000L});
    public static final BitSet FOLLOW_returnType_in_function1830 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1832 = new BitSet(new long[]{0x0000000001520000L});
    public static final BitSet FOLLOW_constDecl_in_function1837 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_varDecl_in_function1840 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BEGIN_in_function1845 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1848 = new BitSet(new long[]{0x05420226000A0000L,0x0000000000010000L});
    public static final BitSet FOLLOW_block_in_function1853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_END_FUNCTION_in_function1857 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NEWLINE_in_function1859 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_set_in_returnType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_formalParamsList1916 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_formalParamsList1919 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_formalParamsList1923 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rangeItem_in_synpred52_Glossa968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred53_Glossa972 = new BitSet(new long[]{0x0000000000000002L});

}