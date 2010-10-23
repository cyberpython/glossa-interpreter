// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-23 19:15:36

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

package glossa.interpreter;
import glossa.interpreter.messages.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=101;
    public static final int LT=42;
    public static final int END_PROCEDURE=98;
    public static final int WHILE=51;
    public static final int LETTER=112;
    public static final int MOD=63;
    public static final int STRINGS=27;
    public static final int LAMDA=87;
    public static final int UPSILON_DIALYTIKA_TONOS=125;
    public static final int CASE=40;
    public static final int NOT=65;
    public static final int OMICRON=77;
    public static final int EOF=-1;
    public static final int LBRACKET=24;
    public static final int MU=83;
    public static final int TAU=84;
    public static final int POW=64;
    public static final int UPSILON_TONOS=121;
    public static final int LPAR=71;
    public static final int CONT_COMMAND=115;
    public static final int CONST_INT=69;
    public static final int BEGIN=17;
    public static final int LOOP=52;
    public static final int KAPPA=73;
    public static final int EQ=20;
    public static final int COMMENT=114;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=118;
    public static final int END_LOOP=50;
    public static final int GE=45;
    public static final int END_SWITCH=39;
    public static final int NU=100;
    public static final int CONST_TRUE=66;
    public static final int XI=106;
    public static final int SWITCH=38;
    public static final int ELSE=36;
    public static final int DELTA=94;
    public static final int EPSILON=85;
    public static final int CONST_STR=68;
    public static final int INTEGERS=28;
    public static final int ALPHA=74;
    public static final int SIGMA_TELIKO=88;
    public static final int REAL=108;
    public static final int THETA=93;
    public static final int BOOLEANS=26;
    public static final int UPSILON_DIALYTIKA=123;
    public static final int WS=116;
    public static final int OMICRON_TONOS=78;
    public static final int EPSILON_TONOS=86;
    public static final int READ=31;
    public static final int OMEGA=104;
    public static final int UNTIL=54;
    public static final int OR=55;
    public static final int GT=44;
    public static final int ALPHA_TONOS=89;
    public static final int REPEAT=53;
    public static final int CALL=103;
    public static final int PI=80;
    public static final int FROM=47;
    public static final int PHI=120;
    public static final int RHO=81;
    public static final int UPSILON=99;
    public static final int FOR=46;
    public static final int STEP=49;
    public static final int ETA_TONOS=76;
    public static final int CONSTANTS=19;
    public static final int ID=15;
    public static final int AND=56;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=34;
    public static final int OMEGA_TONOS=105;
    public static final int NOT_EOL=113;
    public static final int BOOLEAN=110;
    public static final int THEN=35;
    public static final int END_FUNCTION=102;
    public static final int COMMA=23;
    public static final int ETA=91;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=95;
    public static final int PLUS=58;
    public static final int SIGMA=92;
    public static final int DIGIT=111;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=25;
    public static final int IOTA_DIALYTIKA_TONOS=124;
    public static final int ELSE_IF=37;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=70;
    public static final int INTEGER=107;
    public static final int INF_RANGE=12;
    public static final int TO=48;
    public static final int LATIN_LETTER=117;
    public static final int REALS=29;
    public static final int RANGE=41;
    public static final int CHI=79;
    public static final int MINUS=59;
    public static final int DIA=61;
    public static final int BETA=90;
    public static final int PROCEDURE=97;
    public static final int PRINT=30;
    public static final int COLON=22;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=57;
    public static final int NEWLINE=16;
    public static final int END_PROGRAM=18;
    public static final int ZETA=119;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=67;
    public static final int NEG=5;
    public static final int ASSIGN=32;
    public static final int VARIABLES=21;
    public static final int END_IF=33;
    public static final int PROGRAM=14;
    public static final int RPAR=72;
    public static final int IOTA=75;
    public static final int DIV=62;
    public static final int TIMES=60;
    public static final int GAMMA=82;
    public static final int IOTA_DIALYTIKA=122;
    public static final int LE=43;
    public static final int STRING=109;
    public static final int IOTA_TONOS=96;

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
    public String getGrammarFileName() { return "src/glossa/interpreter/grammars/Glossa.g"; }



            public void displayRecognitionError(String[] tokenNames,
                RecognitionException e) {
                String msg = getErrorMessage(e, tokenNames);
                Messages.parserError(new Point(e.line, e.charPositionInLine), msg);
            }


            public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		String msg = e.getMessage();
    		if ( e instanceof UnwantedTokenException ) {
    			UnwantedTokenException ute = (UnwantedTokenException)e;
    			String tokenName="<unknown>";
    			if ( ute.expecting== Token.EOF ) {
    				tokenName = "EOF";
    			}
    			else {
    				tokenName = tokenNames[ute.expecting];
    			}
    			msg = "extraneous input "+getTokenErrorDisplay(ute.getUnexpectedToken())+
    				" expecting "+tokenName;
    		}
    		else if ( e instanceof MissingTokenException ) {
    			MissingTokenException mte = (MissingTokenException)e;
    			String tokenName="<unknown>";
    			if ( mte.expecting== Token.EOF ) {
    				tokenName = "EOF";
    			}
    			else {
    				tokenName = tokenNames[mte.expecting];
                                    if(tokenName=="EQ"){
                                        tokenName="'='";
                                    }
    			}
    			msg = String.format(ParserMessages.STR_ERROR_PARSER_MISSING_TOKEN_BEFORE_THIS, tokenName, getTokenErrorDisplay(e.token));
    		}
    		else if ( e instanceof MismatchedTokenException ) {
    			MismatchedTokenException mte = (MismatchedTokenException)e;
    			String tokenName="<unknown>";
    			if ( mte.expecting== Token.EOF ) {
    				tokenName = "EOF";
    			}
    			else {
    				tokenName = tokenNames[mte.expecting];
    			}
    			msg = "mismatched input "+getTokenErrorDisplay(e.token)+
    				" expecting "+tokenName;
    		}
    		else if ( e instanceof MismatchedTreeNodeException ) {
    			MismatchedTreeNodeException mtne = (MismatchedTreeNodeException)e;
    			String tokenName="<unknown>";
    			if ( mtne.expecting==Token.EOF ) {
    				tokenName = "EOF";
    			}
    			else {
    				tokenName = tokenNames[mtne.expecting];
    			}
    			msg = "mismatched tree node: "+mtne.node+
    				" expecting "+tokenName;
    		}
    		else if ( e instanceof NoViableAltException ) {
    			//NoViableAltException nvae = (NoViableAltException)e;
    			// for development, can add "decision=<<"+nvae.grammarDecisionDescription+">>"
    			// and "(decision="+nvae.decisionNumber+") and
    			// "state "+nvae.stateNumber
    			msg = String.format(ParserMessages.STR_ERROR_PARSER_PROBLEM_NEAR, getTokenErrorDisplay(e.token));
    		}
    		else if ( e instanceof EarlyExitException ) {
    			//EarlyExitException eee = (EarlyExitException)e;
    			// for development, can add "(decision="+eee.decisionNumber+")"
    			msg = "required (...)+ loop did not match anything at input "+
    				getTokenErrorDisplay(e.token);
    		}
    		else if ( e instanceof MismatchedSetException ) {
    			MismatchedSetException mse = (MismatchedSetException)e;
    			msg = "mismatched input "+getTokenErrorDisplay(e.token)+
    				" expecting set "+mse.expecting;
    		}
    		else if ( e instanceof MismatchedNotSetException ) {
    			MismatchedNotSetException mse = (MismatchedNotSetException)e;
    			msg = "mismatched input "+getTokenErrorDisplay(e.token)+
    				" expecting set "+mse.expecting;
    		}
    		else if ( e instanceof FailedPredicateException ) {
    			FailedPredicateException fpe = (FailedPredicateException)e;
    			msg = "rule "+fpe.ruleName+" failed predicate: {"+
    				fpe.predicateText+"}?";
    		}
    		return msg;
    	}


    public static class unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unit"
    // src/glossa/interpreter/grammars/Glossa.g:283:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:283:6: ( program )
            // src/glossa/interpreter/grammars/Glossa.g:283:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit137);
            program1=program();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, program1.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:285:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
    public final GlossaParser.program_return program() throws RecognitionException {
        GlossaParser.program_return retval = new GlossaParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id1=null;
        Token id2=null;
        Token PROGRAM2=null;
        Token NEWLINE3=null;
        Token BEGIN5=null;
        Token NEWLINE6=null;
        Token END_PROGRAM8=null;
        Token NEWLINE9=null;
        GlossaParser.declarations_return declarations4 = null;

        GlossaParser.block_return block7 = null;


        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree PROGRAM2_tree=null;
        CommonTree NEWLINE3_tree=null;
        CommonTree BEGIN5_tree=null;
        CommonTree NEWLINE6_tree=null;
        CommonTree END_PROGRAM8_tree=null;
        CommonTree NEWLINE9_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:285:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:285:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);
            }
            id1=(Token)match(input,ID,FOLLOW_ID_in_program150); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);
            }
            // src/glossa/interpreter/grammars/Glossa.g:285:27: ( NEWLINE )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NEWLINE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:285:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program153); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            pushFollow(FOLLOW_declarations_in_program160);
            declarations4=declarations();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program164); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:287:11: ( NEWLINE )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==NEWLINE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:287:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program169); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            pushFollow(FOLLOW_block_in_program176);
            block7=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program180); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:289:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:289:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);
                    }

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:289:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:289:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program191); if (state.failed) return retval;

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
    // src/glossa/interpreter/grammars/Glossa.g:291:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:292:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/Glossa.g:292:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/interpreter/grammars/Glossa.g:292:4: ( constDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANTS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:0:0: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations205);
                    constDecl10=constDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constDecl10.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:292:15: ( varDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:0:0: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations208);
                    varDecl11=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl11.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:294:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
    public final GlossaParser.constDecl_return constDecl() throws RecognitionException {
        GlossaParser.constDecl_return retval = new GlossaParser.constDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONSTANTS12=null;
        Token NEWLINE13=null;
        GlossaParser.constAssign_return constAssign14 = null;


        CommonTree CONSTANTS12_tree=null;
        CommonTree NEWLINE13_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:295:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/interpreter/grammars/Glossa.g:295:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);
            }
            // src/glossa/interpreter/grammars/Glossa.g:295:15: ( NEWLINE )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEWLINE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:295:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl224); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:295:27: ( constAssign )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl229);
            	    constAssign14=constAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, constAssign14.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // src/glossa/interpreter/grammars/Glossa.g:297:1: constAssign : ID EQ expr ( NEWLINE )+ ;
    public final GlossaParser.constAssign_return constAssign() throws RecognitionException {
        GlossaParser.constAssign_return retval = new GlossaParser.constAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID15=null;
        Token EQ16=null;
        Token NEWLINE18=null;
        GlossaParser.expr_return expr17 = null;


        CommonTree ID15_tree=null;
        CommonTree EQ16_tree=null;
        CommonTree NEWLINE18_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:298:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:298:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);
            }
            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_constAssign244);
            expr17=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr17.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:298:16: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:298:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign247); if (state.failed) return retval;

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
    // src/glossa/interpreter/grammars/Glossa.g:300:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
    public final GlossaParser.varDecl_return varDecl() throws RecognitionException {
        GlossaParser.varDecl_return retval = new GlossaParser.varDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLES19=null;
        Token NEWLINE20=null;
        GlossaParser.varsDecl_return varsDecl21 = null;


        CommonTree VARIABLES19_tree=null;
        CommonTree NEWLINE20_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:300:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/interpreter/grammars/Glossa.g:300:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);
            }
            // src/glossa/interpreter/grammars/Glossa.g:300:22: ( NEWLINE )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==NEWLINE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:300:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl263); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:300:34: ( varsDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=BOOLEANS && LA11_0<=REALS)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl268);
            	    varsDecl21=varsDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varsDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // src/glossa/interpreter/grammars/Glossa.g:302:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
    public final GlossaParser.varsDecl_return varsDecl() throws RecognitionException {
        GlossaParser.varsDecl_return retval = new GlossaParser.varsDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON23=null;
        Token COMMA25=null;
        Token NEWLINE27=null;
        GlossaParser.varType_return varType22 = null;

        GlossaParser.varDeclItem_return varDeclItem24 = null;

        GlossaParser.varDeclItem_return varDeclItem26 = null;


        CommonTree COLON23_tree=null;
        CommonTree COMMA25_tree=null;
        CommonTree NEWLINE27_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:303:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:303:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType22=varType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl282); if (state.failed) return retval;
            pushFollow(FOLLOW_varDeclItem_in_varsDecl285);
            varDeclItem24=varDeclItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem24.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:303:32: ( COMMA varDeclItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:303:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl288); if (state.failed) return retval;
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl291);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:303:54: ( NEWLINE )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==NEWLINE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:303:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl296); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
    // src/glossa/interpreter/grammars/Glossa.g:305:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
    public final GlossaParser.varDeclItem_return varDeclItem() throws RecognitionException {
        GlossaParser.varDeclItem_return retval = new GlossaParser.varDeclItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID28=null;
        Token ID29=null;
        GlossaParser.arrayDimension_return arrayDimension30 = null;


        CommonTree ID28_tree=null;
        CommonTree ID29_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arrayDimension=new RewriteRuleSubtreeStream(adaptor,"rule arrayDimension");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:306:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==LBRACKET) ) {
                    alt14=2;
                }
                else if ( (LA14_1==EOF||LA14_1==NEWLINE||LA14_1==COMMA) ) {
                    alt14=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:306:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:307:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem315); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem317);
                    arrayDimension30=arrayDimension();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDimension.add(arrayDimension30.getTree());


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
                    // 307:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:307:26: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/Glossa.g:309:1: arrayDimension : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final GlossaParser.arrayDimension_return arrayDimension() throws RecognitionException {
        GlossaParser.arrayDimension_return retval = new GlossaParser.arrayDimension_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET31=null;
        Token COMMA32=null;
        Token RBRACKET33=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET31_tree=null;
        CommonTree COMMA32_tree=null;
        CommonTree RBRACKET33_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:310:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:310:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension336); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET31);

            // src/glossa/interpreter/grammars/Glossa.g:310:13: (dimension+= expr )
            // src/glossa/interpreter/grammars/Glossa.g:310:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arrayDimension341);
            dimension=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/interpreter/grammars/Glossa.g:310:31: ( COMMA dimension+= expr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:310:32: COMMA dimension+= expr
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayDimension345); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_expr_in_arrayDimension349);
            	    dimension=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RBRACKET33=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension353); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET33);



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
            // 310:65: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:310:68: ^( ARRAY_DIMENSION ( expr )+ )
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
    // src/glossa/interpreter/grammars/Glossa.g:312:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set34=null;

        CommonTree set34_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:312:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/interpreter/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set34=(Token)input.LT(1);
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set34));
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
    // src/glossa/interpreter/grammars/Glossa.g:317:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm35 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:317:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/Glossa.g:317:9: ( stm )*
            {
            // src/glossa/interpreter/grammars/Glossa.g:317:9: ( stm )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||(LA16_0>=PRINT && LA16_0<=READ)||LA16_0==IF||LA16_0==SWITCH||LA16_0==FOR||LA16_0==WHILE||LA16_0==REPEAT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block396);
            	    stm35=stm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_stm.add(stm35.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
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
            // 317:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/interpreter/grammars/Glossa.g:317:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/interpreter/grammars/Glossa.g:317:26: ( stm )*
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
    // src/glossa/interpreter/grammars/Glossa.g:319:1: stm : ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm36 = null;

        GlossaParser.readStm_return readStm37 = null;

        GlossaParser.assingmentStm_return assingmentStm38 = null;

        GlossaParser.ifStm_return ifStm39 = null;

        GlossaParser.caseStm_return caseStm40 = null;

        GlossaParser.forStm_return forStm41 = null;

        GlossaParser.whileStm_return whileStm42 = null;

        GlossaParser.repeatStm_return repeatStm43 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:319:5: ( printStm | readStm | assingmentStm | ifStm | caseStm | forStm | whileStm | repeatStm )
            int alt17=8;
            switch ( input.LA(1) ) {
            case PRINT:
                {
                alt17=1;
                }
                break;
            case READ:
                {
                alt17=2;
                }
                break;
            case ID:
                {
                alt17=3;
                }
                break;
            case IF:
                {
                alt17=4;
                }
                break;
            case SWITCH:
                {
                alt17=5;
                }
                break;
            case FOR:
                {
                alt17=6;
                }
                break;
            case WHILE:
                {
                alt17=7;
                }
                break;
            case REPEAT:
                {
                alt17=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:319:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm415);
                    printStm36=printStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, printStm36.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:320:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm433);
                    readStm37=readStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStm37.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:321:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm438);
                    assingmentStm38=assingmentStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assingmentStm38.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:322:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm456);
                    ifStm39=ifStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStm39.getTree());

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:323:17: caseStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_caseStm_in_stm474);
                    caseStm40=caseStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStm40.getTree());

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:324:17: forStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStm_in_stm492);
                    forStm41=forStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStm41.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:325:17: whileStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStm_in_stm510);
                    whileStm42=whileStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStm42.getTree());

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:326:17: repeatStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeatStm_in_stm528);
                    repeatStm43=repeatStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeatStm43.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:329:1: printStm : PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT44=null;
        Token char_literal46=null;
        Token NEWLINE48=null;
        GlossaParser.expr_return expr45 = null;

        GlossaParser.expr_return expr47 = null;


        CommonTree PRINT44_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree NEWLINE48_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:330:9: ( PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:330:11: PRINT ( expr ( ',' expr )* )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT44=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRINT44_tree = (CommonTree)adaptor.create(PRINT44);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT44_tree, root_0);
            }
            // src/glossa/interpreter/grammars/Glossa.g:330:18: ( expr ( ',' expr )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID||(LA19_0>=PLUS && LA19_0<=MINUS)||(LA19_0>=NOT && LA19_0<=LPAR)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:330:19: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_printStm558);
                    expr45=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr45.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:330:24: ( ',' expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==COMMA) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/Glossa.g:330:26: ',' expr
                    	    {
                    	    char_literal46=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm562); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expr_in_printStm565);
                    	    expr47=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr47.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:330:41: ( NEWLINE )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==NEWLINE) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:330:42: NEWLINE
            	    {
            	    NEWLINE48=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm573); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
    // src/glossa/interpreter/grammars/Glossa.g:332:1: readStm : READ readItem ( COMMA readItem )* ( NEWLINE )+ ;
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ49=null;
        Token COMMA51=null;
        Token NEWLINE53=null;
        GlossaParser.readItem_return readItem50 = null;

        GlossaParser.readItem_return readItem52 = null;


        CommonTree READ49_tree=null;
        CommonTree COMMA51_tree=null;
        CommonTree NEWLINE53_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:332:9: ( READ readItem ( COMMA readItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:333:17: READ readItem ( COMMA readItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            READ49=(Token)match(input,READ,FOLLOW_READ_in_readStm600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ49_tree = (CommonTree)adaptor.create(READ49);
            root_0 = (CommonTree)adaptor.becomeRoot(READ49_tree, root_0);
            }
            pushFollow(FOLLOW_readItem_in_readStm603);
            readItem50=readItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem50.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:333:32: ( COMMA readItem )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:333:33: COMMA readItem
            	    {
            	    COMMA51=(Token)match(input,COMMA,FOLLOW_COMMA_in_readStm606); if (state.failed) return retval;
            	    pushFollow(FOLLOW_readItem_in_readStm609);
            	    readItem52=readItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, readItem52.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:333:51: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:333:52: NEWLINE
            	    {
            	    NEWLINE53=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm614); if (state.failed) return retval;

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
    // $ANTLR end "readStm"

    public static class readItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readItem"
    // src/glossa/interpreter/grammars/Glossa.g:336:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final GlossaParser.readItem_return readItem() throws RecognitionException {
        GlossaParser.readItem_return retval = new GlossaParser.readItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token arrId=null;
        Token varId=null;
        GlossaParser.arraySubscript_return arraySubscript54 = null;


        CommonTree arrId_tree=null;
        CommonTree varId_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:336:9: (arrId= ID arraySubscript | varId= ID )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EOF||LA23_1==NEWLINE||LA23_1==COMMA) ) {
                    alt23=2;
                }
                else if ( (LA23_1==LBRACKET) ) {
                    alt23=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:337:17: arrId= ID arraySubscript
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readItem651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_readItem653);
                    arraySubscript54=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript54.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:338:17: varId= ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readItem673); if (state.failed) return retval;
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
    // src/glossa/interpreter/grammars/Glossa.g:341:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN55=null;
        Token NEWLINE56=null;
        Token ASSIGN58=null;
        Token NEWLINE59=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript57 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN55_tree=null;
        CommonTree NEWLINE56_tree=null;
        CommonTree ASSIGN58_tree=null;
        CommonTree NEWLINE59_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:342:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==ASSIGN) ) {
                    alt26=1;
                }
                else if ( (LA26_1==LBRACKET) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:342:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm694); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);
                    }
                    ASSIGN55=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN55_tree = (CommonTree)adaptor.create(ASSIGN55);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN55_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm701);
                    varValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:342:35: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:342:36: NEWLINE
                    	    {
                    	    NEWLINE56=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm704); if (state.failed) return retval;

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
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:343:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);
                    }
                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm729);
                    arraySubscript57=arraySubscript();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arraySubscript57.getTree());
                    ASSIGN58=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN58_tree = (CommonTree)adaptor.create(ASSIGN58);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN58_tree, root_0);
                    }
                    pushFollow(FOLLOW_expr_in_assingmentStm736);
                    arrItemValue=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:343:67: ( NEWLINE )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==NEWLINE) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/Glossa.g:343:68: NEWLINE
                    	    {
                    	    NEWLINE59=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm739); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
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
    // src/glossa/interpreter/grammars/Glossa.g:346:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF63=null;
        Token NEWLINE64=null;
        GlossaParser.ifBlock_return ifBlock60 = null;

        GlossaParser.elseIfBlock_return elseIfBlock61 = null;

        GlossaParser.elseBlock_return elseBlock62 = null;


        CommonTree END_IF63_tree=null;
        CommonTree NEWLINE64_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:346:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/interpreter/grammars/Glossa.g:346:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm759);
            ifBlock60=ifBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifBlock.add(ifBlock60.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:346:17: ( elseIfBlock )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==ELSE_IF) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: elseIfBlock
            	    {
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm761);
            	    elseIfBlock61=elseIfBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elseIfBlock.add(elseIfBlock61.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:346:30: ( elseBlock )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==ELSE) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:0:0: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm764);
                    elseBlock62=elseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock62.getTree());

                    }
                    break;

            }

            END_IF63=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm767); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END_IF.add(END_IF63);

            // src/glossa/interpreter/grammars/Glossa.g:346:48: ( NEWLINE )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==NEWLINE) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:346:49: NEWLINE
            	    {
            	    NEWLINE64=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm770); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE64);


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);



            // AST REWRITE
            // elements: elseIfBlock, ifBlock, elseBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 346:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/interpreter/grammars/Glossa.g:346:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/interpreter/grammars/Glossa.g:346:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/interpreter/grammars/Glossa.g:346:92: ( elseBlock )?
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
    // src/glossa/interpreter/grammars/Glossa.g:348:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF65=null;
        Token THEN67=null;
        Token NEWLINE68=null;
        GlossaParser.expr_return expr66 = null;

        GlossaParser.block_return block69 = null;


        CommonTree IF65_tree=null;
        CommonTree THEN67_tree=null;
        CommonTree NEWLINE68_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:348:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:348:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF65=(Token)match(input,IF,FOLLOW_IF_in_ifBlock794); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF65_tree = (CommonTree)adaptor.create(IF65);
            root_0 = (CommonTree)adaptor.becomeRoot(IF65_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_ifBlock797);
            expr66=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr66.getTree());
            THEN67=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock799); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:348:26: ( NEWLINE )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==NEWLINE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:348:27: NEWLINE
            	    {
            	    NEWLINE68=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock803); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            pushFollow(FOLLOW_block_in_ifBlock808);
            block69=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block69.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:350:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE70=null;
        Token NEWLINE71=null;
        GlossaParser.block_return block72 = null;


        CommonTree ELSE70_tree=null;
        CommonTree NEWLINE71_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:351:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:351:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE70=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE70_tree = (CommonTree)adaptor.create(ELSE70);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE70_tree, root_0);
            }
            // src/glossa/interpreter/grammars/Glossa.g:351:10: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:351:11: NEWLINE
            	    {
            	    NEWLINE71=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock821); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_elseBlock826);
            block72=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block72.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:353:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF73=null;
        Token THEN75=null;
        Token NEWLINE76=null;
        GlossaParser.expr_return expr74 = null;

        GlossaParser.block_return block77 = null;


        CommonTree ELSE_IF73_tree=null;
        CommonTree THEN75_tree=null;
        CommonTree NEWLINE76_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:354:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:354:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF73=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock835); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE_IF73_tree = (CommonTree)adaptor.create(ELSE_IF73);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF73_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_elseIfBlock838);
            expr74=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr74.getTree());
            THEN75=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock840); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:354:24: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:354:25: NEWLINE
            	    {
            	    NEWLINE76=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock844); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_elseIfBlock849);
            block77=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block77.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:356:1: caseStm : SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ ;
    public final GlossaParser.caseStm_return caseStm() throws RecognitionException {
        GlossaParser.caseStm_return retval = new GlossaParser.caseStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SWITCH78=null;
        Token NEWLINE80=null;
        Token END_SWITCH83=null;
        Token NEWLINE84=null;
        GlossaParser.expr_return expr79 = null;

        GlossaParser.caseBlock_return caseBlock81 = null;

        GlossaParser.caseElseBlock_return caseElseBlock82 = null;


        CommonTree SWITCH78_tree=null;
        CommonTree NEWLINE80_tree=null;
        CommonTree END_SWITCH83_tree=null;
        CommonTree NEWLINE84_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:356:9: ( SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:356:11: SWITCH expr ( NEWLINE )+ ( caseBlock )* ( caseElseBlock )? END_SWITCH ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            SWITCH78=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_caseStm857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SWITCH78_tree = (CommonTree)adaptor.create(SWITCH78);
            root_0 = (CommonTree)adaptor.becomeRoot(SWITCH78_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_caseStm860);
            expr79=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr79.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:356:24: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:356:25: NEWLINE
            	    {
            	    NEWLINE80=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm863); if (state.failed) return retval;

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

            // src/glossa/interpreter/grammars/Glossa.g:356:36: ( caseBlock )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==CASE) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==ID||(LA34_1>=LT && LA34_1<=GE)||(LA34_1>=PLUS && LA34_1<=MINUS)||(LA34_1>=NOT && LA34_1<=LPAR)) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: caseBlock
            	    {
            	    pushFollow(FOLLOW_caseBlock_in_caseStm868);
            	    caseBlock81=caseBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseBlock81.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:356:47: ( caseElseBlock )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==CASE) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:0:0: caseElseBlock
                    {
                    pushFollow(FOLLOW_caseElseBlock_in_caseStm871);
                    caseElseBlock82=caseElseBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseElseBlock82.getTree());

                    }
                    break;

            }

            END_SWITCH83=(Token)match(input,END_SWITCH,FOLLOW_END_SWITCH_in_caseStm874); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:356:74: ( NEWLINE )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==NEWLINE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:356:75: NEWLINE
            	    {
            	    NEWLINE84=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm878); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // src/glossa/interpreter/grammars/Glossa.g:358:1: caseBlock : CASE caseExprList ( NEWLINE )+ block ;
    public final GlossaParser.caseBlock_return caseBlock() throws RecognitionException {
        GlossaParser.caseBlock_return retval = new GlossaParser.caseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE85=null;
        Token NEWLINE87=null;
        GlossaParser.caseExprList_return caseExprList86 = null;

        GlossaParser.block_return block88 = null;


        CommonTree CASE85_tree=null;
        CommonTree NEWLINE87_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:359:2: ( CASE caseExprList ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:359:4: CASE caseExprList ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE85=(Token)match(input,CASE,FOLLOW_CASE_in_caseBlock890); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE85_tree = (CommonTree)adaptor.create(CASE85);
            root_0 = (CommonTree)adaptor.becomeRoot(CASE85_tree, root_0);
            }
            pushFollow(FOLLOW_caseExprList_in_caseBlock893);
            caseExprList86=caseExprList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprList86.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:359:23: ( NEWLINE )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==NEWLINE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:359:24: NEWLINE
            	    {
            	    NEWLINE87=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseBlock896); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            pushFollow(FOLLOW_block_in_caseBlock901);
            block88=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block88.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:361:1: caseExprList : caseExprListItem ( COMMA caseExprListItem )* ;
    public final GlossaParser.caseExprList_return caseExprList() throws RecognitionException {
        GlossaParser.caseExprList_return retval = new GlossaParser.caseExprList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA90=null;
        GlossaParser.caseExprListItem_return caseExprListItem89 = null;

        GlossaParser.caseExprListItem_return caseExprListItem91 = null;


        CommonTree COMMA90_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:362:2: ( caseExprListItem ( COMMA caseExprListItem )* )
            // src/glossa/interpreter/grammars/Glossa.g:362:4: caseExprListItem ( COMMA caseExprListItem )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_caseExprListItem_in_caseExprList910);
            caseExprListItem89=caseExprListItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem89.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:362:21: ( COMMA caseExprListItem )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==COMMA) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:362:22: COMMA caseExprListItem
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_caseExprList913); if (state.failed) return retval;
            	    pushFollow(FOLLOW_caseExprListItem_in_caseExprList916);
            	    caseExprListItem91=caseExprListItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseExprListItem91.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // src/glossa/interpreter/grammars/Glossa.g:364:1: caseExprListItem : ( rangeItem | expr | infRangeItem );
    public final GlossaParser.caseExprListItem_return caseExprListItem() throws RecognitionException {
        GlossaParser.caseExprListItem_return retval = new GlossaParser.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.rangeItem_return rangeItem92 = null;

        GlossaParser.expr_return expr93 = null;

        GlossaParser.infRangeItem_return infRangeItem94 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:365:2: ( rangeItem | expr | infRangeItem )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:365:5: rangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rangeItem_in_caseExprListItem928);
                    rangeItem92=rangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rangeItem92.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:365:17: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_caseExprListItem932);
                    expr93=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr93.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:365:24: infRangeItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infRangeItem_in_caseExprListItem936);
                    infRangeItem94=infRangeItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infRangeItem94.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:367:1: rangeItem : expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) ;
    public final GlossaParser.rangeItem_return rangeItem() throws RecognitionException {
        GlossaParser.rangeItem_return retval = new GlossaParser.rangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RANGE95=null;
        GlossaParser.expr_return expr1 = null;

        GlossaParser.expr_return expr2 = null;


        CommonTree RANGE95_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:368:9: (expr1= expr RANGE expr2= expr -> ^( RANGE $expr1 $expr2) )
            // src/glossa/interpreter/grammars/Glossa.g:368:17: expr1= expr RANGE expr2= expr
            {
            pushFollow(FOLLOW_expr_in_rangeItem960);
            expr1=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr1.getTree());
            RANGE95=(Token)match(input,RANGE,FOLLOW_RANGE_in_rangeItem962); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE95);

            pushFollow(FOLLOW_expr_in_rangeItem966);
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
            // 368:45: -> ^( RANGE $expr1 $expr2)
            {
                // src/glossa/interpreter/grammars/Glossa.g:368:48: ^( RANGE $expr1 $expr2)
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
    // src/glossa/interpreter/grammars/Glossa.g:370:1: infRangeItem : ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) );
    public final GlossaParser.infRangeItem_return infRangeItem() throws RecognitionException {
        GlossaParser.infRangeItem_return retval = new GlossaParser.infRangeItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT96=null;
        Token LE98=null;
        Token GT100=null;
        Token GE102=null;
        GlossaParser.expr_return expr97 = null;

        GlossaParser.expr_return expr99 = null;

        GlossaParser.expr_return expr101 = null;

        GlossaParser.expr_return expr103 = null;


        CommonTree LT96_tree=null;
        CommonTree LE98_tree=null;
        CommonTree GT100_tree=null;
        CommonTree GE102_tree=null;
        RewriteRuleTokenStream stream_GE=new RewriteRuleTokenStream(adaptor,"token GE");
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
        RewriteRuleTokenStream stream_LE=new RewriteRuleTokenStream(adaptor,"token LE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:371:9: ( LT expr -> ^( INF_RANGE LT expr ) | LE expr -> ^( INF_RANGE LE expr ) | GT expr -> ^( INF_RANGE GT expr ) | GE expr -> ^( INF_RANGE GE expr ) )
            int alt40=4;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt40=1;
                }
                break;
            case LE:
                {
                alt40=2;
                }
                break;
            case GT:
                {
                alt40=3;
                }
                break;
            case GE:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:371:17: LT expr
                    {
                    LT96=(Token)match(input,LT,FOLLOW_LT_in_infRangeItem1000); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LT.add(LT96);

                    pushFollow(FOLLOW_expr_in_infRangeItem1002);
                    expr97=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr97.getTree());


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
                    // 371:25: -> ^( INF_RANGE LT expr )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:371:28: ^( INF_RANGE LT expr )
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
                    // src/glossa/interpreter/grammars/Glossa.g:372:17: LE expr
                    {
                    LE98=(Token)match(input,LE,FOLLOW_LE_in_infRangeItem1030); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LE.add(LE98);

                    pushFollow(FOLLOW_expr_in_infRangeItem1032);
                    expr99=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr99.getTree());


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
                    // 372:25: -> ^( INF_RANGE LE expr )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:372:28: ^( INF_RANGE LE expr )
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
                    // src/glossa/interpreter/grammars/Glossa.g:373:17: GT expr
                    {
                    GT100=(Token)match(input,GT,FOLLOW_GT_in_infRangeItem1060); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GT.add(GT100);

                    pushFollow(FOLLOW_expr_in_infRangeItem1062);
                    expr101=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr101.getTree());


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
                    // 373:25: -> ^( INF_RANGE GT expr )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:373:28: ^( INF_RANGE GT expr )
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
                    // src/glossa/interpreter/grammars/Glossa.g:374:17: GE expr
                    {
                    GE102=(Token)match(input,GE,FOLLOW_GE_in_infRangeItem1090); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GE.add(GE102);

                    pushFollow(FOLLOW_expr_in_infRangeItem1092);
                    expr103=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr103.getTree());


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
                    // 374:25: -> ^( INF_RANGE GE expr )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:374:28: ^( INF_RANGE GE expr )
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
    // src/glossa/interpreter/grammars/Glossa.g:377:1: caseElseBlock : CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) ;
    public final GlossaParser.caseElseBlock_return caseElseBlock() throws RecognitionException {
        GlossaParser.caseElseBlock_return retval = new GlossaParser.caseElseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CASE104=null;
        Token ELSE105=null;
        Token NEWLINE106=null;
        GlossaParser.block_return block107 = null;


        CommonTree CASE104_tree=null;
        CommonTree ELSE105_tree=null;
        CommonTree NEWLINE106_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:378:2: ( CASE ELSE ( NEWLINE )+ block -> ^( CASE_ELSE block ) )
            // src/glossa/interpreter/grammars/Glossa.g:378:4: CASE ELSE ( NEWLINE )+ block
            {
            CASE104=(Token)match(input,CASE,FOLLOW_CASE_in_caseElseBlock1120); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CASE.add(CASE104);

            ELSE105=(Token)match(input,ELSE,FOLLOW_ELSE_in_caseElseBlock1122); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE.add(ELSE105);

            // src/glossa/interpreter/grammars/Glossa.g:378:14: ( NEWLINE )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==NEWLINE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:0:0: NEWLINE
            	    {
            	    NEWLINE106=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseElseBlock1124); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE106);


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);

            pushFollow(FOLLOW_block_in_caseElseBlock1127);
            block107=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block107.getTree());


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
            // 378:29: -> ^( CASE_ELSE block )
            {
                // src/glossa/interpreter/grammars/Glossa.g:378:32: ^( CASE_ELSE block )
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
    // src/glossa/interpreter/grammars/Glossa.g:380:1: forStm : FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.forStm_return forStm() throws RecognitionException {
        GlossaParser.forStm_return retval = new GlossaParser.forStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR108=null;
        Token ID109=null;
        Token FROM110=null;
        Token TO111=null;
        Token STEP112=null;
        Token NEWLINE113=null;
        Token END_LOOP115=null;
        Token NEWLINE116=null;
        GlossaParser.expr_return from = null;

        GlossaParser.expr_return to = null;

        GlossaParser.expr_return step = null;

        GlossaParser.block_return block114 = null;


        CommonTree FOR108_tree=null;
        CommonTree ID109_tree=null;
        CommonTree FROM110_tree=null;
        CommonTree TO111_tree=null;
        CommonTree STEP112_tree=null;
        CommonTree NEWLINE113_tree=null;
        CommonTree END_LOOP115_tree=null;
        CommonTree NEWLINE116_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:380:8: ( FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:380:10: FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            FOR108=(Token)match(input,FOR,FOLLOW_FOR_in_forStm1143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR108_tree = (CommonTree)adaptor.create(FOR108);
            root_0 = (CommonTree)adaptor.becomeRoot(FOR108_tree, root_0);
            }
            ID109=(Token)match(input,ID,FOLLOW_ID_in_forStm1146); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID109_tree = (CommonTree)adaptor.create(ID109);
            adaptor.addChild(root_0, ID109_tree);
            }
            FROM110=(Token)match(input,FROM,FOLLOW_FROM_in_forStm1148); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1153);
            from=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, from.getTree());
            TO111=(Token)match(input,TO,FOLLOW_TO_in_forStm1155); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_forStm1160);
            to=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, to.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:380:46: ( STEP step= expr )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==STEP) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:380:47: STEP step= expr
                    {
                    STEP112=(Token)match(input,STEP,FOLLOW_STEP_in_forStm1163); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_forStm1168);
                    step=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, step.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:380:65: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:380:66: NEWLINE
            	    {
            	    NEWLINE113=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1173); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_forStm1178);
            block114=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block114.getTree());
            END_LOOP115=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_forStm1180); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:380:93: ( NEWLINE )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==NEWLINE) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:380:94: NEWLINE
            	    {
            	    NEWLINE116=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm1184); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
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
    // src/glossa/interpreter/grammars/Glossa.g:382:1: whileStm : WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.whileStm_return whileStm() throws RecognitionException {
        GlossaParser.whileStm_return retval = new GlossaParser.whileStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE117=null;
        Token LOOP119=null;
        Token NEWLINE120=null;
        Token END_LOOP122=null;
        Token NEWLINE123=null;
        GlossaParser.expr_return expr118 = null;

        GlossaParser.block_return block121 = null;


        CommonTree WHILE117_tree=null;
        CommonTree LOOP119_tree=null;
        CommonTree NEWLINE120_tree=null;
        CommonTree END_LOOP122_tree=null;
        CommonTree NEWLINE123_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:383:9: ( WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:383:11: WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            WHILE117=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStm1203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE117_tree = (CommonTree)adaptor.create(WHILE117);
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE117_tree, root_0);
            }
            pushFollow(FOLLOW_expr_in_whileStm1206);
            expr118=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr118.getTree());
            LOOP119=(Token)match(input,LOOP,FOLLOW_LOOP_in_whileStm1208); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:383:29: ( NEWLINE )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==NEWLINE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:383:30: NEWLINE
            	    {
            	    NEWLINE120=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1212); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            pushFollow(FOLLOW_block_in_whileStm1217);
            block121=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block121.getTree());
            END_LOOP122=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_whileStm1219); if (state.failed) return retval;
            // src/glossa/interpreter/grammars/Glossa.g:383:57: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:383:58: NEWLINE
            	    {
            	    NEWLINE123=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm1223); if (state.failed) return retval;

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
    // src/glossa/interpreter/grammars/Glossa.g:385:1: repeatStm : REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ ;
    public final GlossaParser.repeatStm_return repeatStm() throws RecognitionException {
        GlossaParser.repeatStm_return retval = new GlossaParser.repeatStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REPEAT124=null;
        Token NEWLINE125=null;
        Token UNTIL127=null;
        Token NEWLINE129=null;
        GlossaParser.block_return block126 = null;

        GlossaParser.expr_return expr128 = null;


        CommonTree REPEAT124_tree=null;
        CommonTree NEWLINE125_tree=null;
        CommonTree UNTIL127_tree=null;
        CommonTree NEWLINE129_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:386:2: ( REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:386:4: REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            REPEAT124=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeatStm1235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REPEAT124_tree = (CommonTree)adaptor.create(REPEAT124);
            root_0 = (CommonTree)adaptor.becomeRoot(REPEAT124_tree, root_0);
            }
            // src/glossa/interpreter/grammars/Glossa.g:386:12: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:386:13: NEWLINE
            	    {
            	    NEWLINE125=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1239); if (state.failed) return retval;

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

            pushFollow(FOLLOW_block_in_repeatStm1244);
            block126=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block126.getTree());
            UNTIL127=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_repeatStm1246); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_repeatStm1249);
            expr128=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr128.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:386:42: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:386:43: NEWLINE
            	    {
            	    NEWLINE129=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm1252); if (state.failed) return retval;

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

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/Glossa.g:388:1: expr : andExpr ( OR andExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR131=null;
        GlossaParser.andExpr_return andExpr130 = null;

        GlossaParser.andExpr_return andExpr132 = null;


        CommonTree OR131_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:388:6: ( andExpr ( OR andExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:388:8: andExpr ( OR andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_expr1264);
            andExpr130=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr130.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:388:16: ( OR andExpr )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==OR) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:388:18: OR andExpr
            	    {
            	    OR131=(Token)match(input,OR,FOLLOW_OR_in_expr1268); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR131_tree = (CommonTree)adaptor.create(OR131);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR131_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_expr1271);
            	    andExpr132=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr132.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
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
    // src/glossa/interpreter/grammars/Glossa.g:390:1: andExpr : eqExpr ( AND eqExpr )* ;
    public final GlossaParser.andExpr_return andExpr() throws RecognitionException {
        GlossaParser.andExpr_return retval = new GlossaParser.andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND134=null;
        GlossaParser.eqExpr_return eqExpr133 = null;

        GlossaParser.eqExpr_return eqExpr135 = null;


        CommonTree AND134_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:390:9: ( eqExpr ( AND eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:390:17: eqExpr ( AND eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_andExpr1287);
            eqExpr133=eqExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr133.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:390:24: ( AND eqExpr )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==AND) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:390:25: AND eqExpr
            	    {
            	    AND134=(Token)match(input,AND,FOLLOW_AND_in_andExpr1290); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND134_tree = (CommonTree)adaptor.create(AND134);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND134_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_eqExpr_in_andExpr1293);
            	    eqExpr135=eqExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr135.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // src/glossa/interpreter/grammars/Glossa.g:392:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ137=null;
        Token NEQ139=null;
        GlossaParser.compExpr_return compExpr136 = null;

        GlossaParser.compExpr_return compExpr138 = null;

        GlossaParser.compExpr_return compExpr140 = null;


        CommonTree EQ137_tree=null;
        CommonTree NEQ139_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:392:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:392:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr1303);
            compExpr136=compExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr136.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:392:19: ( EQ compExpr | NEQ compExpr )*
            loop51:
            do {
                int alt51=3;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==EQ) ) {
                    alt51=1;
                }
                else if ( (LA51_0==NEQ) ) {
                    alt51=2;
                }


                switch (alt51) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:392:20: EQ compExpr
            	    {
            	    EQ137=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr1306); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    EQ137_tree = (CommonTree)adaptor.create(EQ137);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ137_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1309);
            	    compExpr138=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr138.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:392:35: NEQ compExpr
            	    {
            	    NEQ139=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr1313); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEQ139_tree = (CommonTree)adaptor.create(NEQ139);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ139_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_compExpr_in_eqExpr1316);
            	    compExpr140=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr140.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
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
    // src/glossa/interpreter/grammars/Glossa.g:394:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT142=null;
        Token LE144=null;
        Token GT146=null;
        Token GE148=null;
        GlossaParser.addExpr_return addExpr141 = null;

        GlossaParser.addExpr_return addExpr143 = null;

        GlossaParser.addExpr_return addExpr145 = null;

        GlossaParser.addExpr_return addExpr147 = null;

        GlossaParser.addExpr_return addExpr149 = null;


        CommonTree LT142_tree=null;
        CommonTree LE144_tree=null;
        CommonTree GT146_tree=null;
        CommonTree GE148_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:394:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:394:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr1327);
            addExpr141=addExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr141.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:394:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop52:
            do {
                int alt52=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt52=1;
                    }
                    break;
                case LE:
                    {
                    alt52=2;
                    }
                    break;
                case GT:
                    {
                    alt52=3;
                    }
                    break;
                case GE:
                    {
                    alt52=4;
                    }
                    break;

                }

                switch (alt52) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:394:20: LT addExpr
            	    {
            	    LT142=(Token)match(input,LT,FOLLOW_LT_in_compExpr1330); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LT142_tree = (CommonTree)adaptor.create(LT142);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT142_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1333);
            	    addExpr143=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr143.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:394:34: LE addExpr
            	    {
            	    LE144=(Token)match(input,LE,FOLLOW_LE_in_compExpr1337); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LE144_tree = (CommonTree)adaptor.create(LE144);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE144_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1340);
            	    addExpr145=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr145.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:394:48: GT addExpr
            	    {
            	    GT146=(Token)match(input,GT,FOLLOW_GT_in_compExpr1344); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GT146_tree = (CommonTree)adaptor.create(GT146);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT146_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1347);
            	    addExpr147=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr147.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:394:62: GE addExpr
            	    {
            	    GE148=(Token)match(input,GE,FOLLOW_GE_in_compExpr1351); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    GE148_tree = (CommonTree)adaptor.create(GE148);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE148_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_addExpr_in_compExpr1354);
            	    addExpr149=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, addExpr149.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
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
    // src/glossa/interpreter/grammars/Glossa.g:396:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS151=null;
        Token MINUS153=null;
        GlossaParser.multExpr_return multExpr150 = null;

        GlossaParser.multExpr_return multExpr152 = null;

        GlossaParser.multExpr_return multExpr154 = null;


        CommonTree PLUS151_tree=null;
        CommonTree MINUS153_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:396:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:396:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr1367);
            multExpr150=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr150.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:396:20: ( PLUS multExpr | MINUS multExpr )*
            loop53:
            do {
                int alt53=3;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==PLUS) ) {
                    alt53=1;
                }
                else if ( (LA53_0==MINUS) ) {
                    alt53=2;
                }


                switch (alt53) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:396:21: PLUS multExpr
            	    {
            	    PLUS151=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr1370); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    PLUS151_tree = (CommonTree)adaptor.create(PLUS151);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS151_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1373);
            	    multExpr152=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr152.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:396:38: MINUS multExpr
            	    {
            	    MINUS153=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr1377); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MINUS153_tree = (CommonTree)adaptor.create(MINUS153);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS153_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multExpr_in_addExpr1380);
            	    multExpr154=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr154.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
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
    // src/glossa/interpreter/grammars/Glossa.g:398:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES156=null;
        Token DIA158=null;
        Token DIV160=null;
        Token MOD162=null;
        GlossaParser.powExpr_return powExpr155 = null;

        GlossaParser.powExpr_return powExpr157 = null;

        GlossaParser.powExpr_return powExpr159 = null;

        GlossaParser.powExpr_return powExpr161 = null;

        GlossaParser.powExpr_return powExpr163 = null;


        CommonTree TIMES156_tree=null;
        CommonTree DIA158_tree=null;
        CommonTree DIV160_tree=null;
        CommonTree MOD162_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:398:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:398:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr1392);
            powExpr155=powExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr155.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:398:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop54:
            do {
                int alt54=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt54=1;
                    }
                    break;
                case DIA:
                    {
                    alt54=2;
                    }
                    break;
                case DIV:
                    {
                    alt54=3;
                    }
                    break;
                case MOD:
                    {
                    alt54=4;
                    }
                    break;

                }

                switch (alt54) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:398:21: TIMES powExpr
            	    {
            	    TIMES156=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr1395); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TIMES156_tree = (CommonTree)adaptor.create(TIMES156);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES156_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1398);
            	    powExpr157=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr157.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:398:38: DIA powExpr
            	    {
            	    DIA158=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr1402); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIA158_tree = (CommonTree)adaptor.create(DIA158);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA158_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1405);
            	    powExpr159=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr159.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:398:53: DIV powExpr
            	    {
            	    DIV160=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr1409); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV160_tree = (CommonTree)adaptor.create(DIV160);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV160_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1412);
            	    powExpr161=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr161.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:398:68: MOD powExpr
            	    {
            	    MOD162=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr1416); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MOD162_tree = (CommonTree)adaptor.create(MOD162);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD162_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_powExpr_in_multExpr1419);
            	    powExpr163=powExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr163.getTree());

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
    // $ANTLR end "multExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpr"
    // src/glossa/interpreter/grammars/Glossa.g:400:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW165=null;
        GlossaParser.unaryExpr_return unaryExpr164 = null;

        GlossaParser.unaryExpr_return unaryExpr166 = null;


        CommonTree POW165_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:400:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:400:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr1431);
            unaryExpr164=unaryExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr164.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:400:21: ( POW unaryExpr )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==POW) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:400:22: POW unaryExpr
            	    {
            	    POW165=(Token)match(input,POW,FOLLOW_POW_in_powExpr1434); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POW165_tree = (CommonTree)adaptor.create(POW165);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW165_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_unaryExpr_in_powExpr1437);
            	    unaryExpr166=unaryExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr166.getTree());

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
    // $ANTLR end "powExpr"

    public static class unaryExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpr"
    // src/glossa/interpreter/grammars/Glossa.g:402:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS167=null;
        Token MINUS169=null;
        Token NOT171=null;
        GlossaParser.atom_return atom168 = null;

        GlossaParser.atom_return atom170 = null;

        GlossaParser.atom_return atom172 = null;

        GlossaParser.atom_return atom173 = null;


        CommonTree PLUS167_tree=null;
        CommonTree MINUS169_tree=null;
        CommonTree NOT171_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:403:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt56=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt56=1;
                }
                break;
            case MINUS:
                {
                alt56=2;
                }
                break;
            case NOT:
                {
                alt56=3;
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
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:403:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS167=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr1448); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_unaryExpr1451);
                    atom168=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom168.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:404:4: MINUS atom
                    {
                    MINUS169=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr1456); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS169);

                    pushFollow(FOLLOW_atom_in_unaryExpr1458);
                    atom170=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom170.getTree());


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
                    // 404:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:404:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:405:4: NOT atom
                    {
                    NOT171=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr1471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT171);

                    pushFollow(FOLLOW_atom_in_unaryExpr1473);
                    atom172=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom172.getTree());


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
                    // 405:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:405:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:406:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr1486);
                    atom173=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom173.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:409:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE174=null;
        Token CONST_FALSE175=null;
        Token CONST_STR176=null;
        Token CONST_INT177=null;
        Token CONST_REAL178=null;
        Token ID180=null;
        Token char_literal181=null;
        Token char_literal183=null;
        GlossaParser.arrayItem_return arrayItem179 = null;

        GlossaParser.expr_return expr182 = null;


        CommonTree CONST_TRUE174_tree=null;
        CommonTree CONST_FALSE175_tree=null;
        CommonTree CONST_STR176_tree=null;
        CommonTree CONST_INT177_tree=null;
        CommonTree CONST_REAL178_tree=null;
        CommonTree ID180_tree=null;
        CommonTree char_literal181_tree=null;
        CommonTree char_literal183_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:409:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt57=8;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:409:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE174=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom1495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_TRUE174_tree = (CommonTree)adaptor.create(CONST_TRUE174);
                    adaptor.addChild(root_0, CONST_TRUE174_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:410:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE175=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom1500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_FALSE175_tree = (CommonTree)adaptor.create(CONST_FALSE175);
                    adaptor.addChild(root_0, CONST_FALSE175_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:411:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR176=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom1505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_STR176_tree = (CommonTree)adaptor.create(CONST_STR176);
                    adaptor.addChild(root_0, CONST_STR176_tree);
                    }

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:412:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT177=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom1510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_INT177_tree = (CommonTree)adaptor.create(CONST_INT177);
                    adaptor.addChild(root_0, CONST_INT177_tree);
                    }

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:413:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL178=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom1515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST_REAL178_tree = (CommonTree)adaptor.create(CONST_REAL178);
                    adaptor.addChild(root_0, CONST_REAL178_tree);
                    }

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:414:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom1520);
                    arrayItem179=arrayItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayItem179.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:415:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID180=(Token)match(input,ID,FOLLOW_ID_in_atom1525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID180_tree = (CommonTree)adaptor.create(ID180);
                    adaptor.addChild(root_0, ID180_tree);
                    }

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:416:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal181=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1530); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1533);
                    expr182=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr182.getTree());
                    char_literal183=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1535); if (state.failed) return retval;

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

    public static class arrayItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayItem"
    // src/glossa/interpreter/grammars/Glossa.g:419:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID184=null;
        GlossaParser.arraySubscript_return arraySubscript185 = null;


        CommonTree ID184_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:420:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:420:4: ID arraySubscript
            {
            ID184=(Token)match(input,ID,FOLLOW_ID_in_arrayItem1548); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID184);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem1550);
            arraySubscript185=arraySubscript();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arraySubscript.add(arraySubscript185.getTree());


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
            // 420:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:420:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:422:1: arraySubscript : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET186=null;
        Token COMMA187=null;
        Token RBRACKET188=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET186_tree=null;
        CommonTree COMMA187_tree=null;
        CommonTree RBRACKET188_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:423:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:423:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET186=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1570); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET186);

            // src/glossa/interpreter/grammars/Glossa.g:423:13: (dimension+= expr )
            // src/glossa/interpreter/grammars/Glossa.g:423:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arraySubscript1575);
            dimension=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/interpreter/grammars/Glossa.g:423:31: ( COMMA dimension+= expr )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:423:32: COMMA dimension+= expr
            	    {
            	    COMMA187=(Token)match(input,COMMA,FOLLOW_COMMA_in_arraySubscript1579); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA187);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1583);
            	    dimension=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            RBRACKET188=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1587); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET188);



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
            // 423:65: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:423:68: ^( ARRAY_INDEX ( expr )+ )
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

    // $ANTLR start synpred48_Glossa
    public final void synpred48_Glossa_fragment() throws RecognitionException {   
        // src/glossa/interpreter/grammars/Glossa.g:365:5: ( rangeItem )
        // src/glossa/interpreter/grammars/Glossa.g:365:5: rangeItem
        {
        pushFollow(FOLLOW_rangeItem_in_synpred48_Glossa928);
        rangeItem();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Glossa

    // $ANTLR start synpred49_Glossa
    public final void synpred49_Glossa_fragment() throws RecognitionException {   
        // src/glossa/interpreter/grammars/Glossa.g:365:17: ( expr )
        // src/glossa/interpreter/grammars/Glossa.g:365:17: expr
        {
        pushFollow(FOLLOW_expr_in_synpred49_Glossa932);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Glossa

    // Delegated rules

    public final boolean synpred48_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Glossa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Glossa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Glossa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA39 dfa39 = new DFA39(this);
    protected DFA57 dfa57 = new DFA57(this);
    static final String DFA39_eotS =
        "\21\uffff";
    static final String DFA39_eofS =
        "\21\uffff";
    static final String DFA39_minS =
        "\1\17\12\0\6\uffff";
    static final String DFA39_maxS =
        "\1\107\12\0\6\uffff";
    static final String DFA39_acceptS =
        "\13\uffff\1\3\3\uffff\1\1\1\2";
    static final String DFA39_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\6\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\11\32\uffff\4\13\14\uffff\1\1\1\2\5\uffff\1\3\1\4\1\5\1\6"+
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "364:1: caseExprListItem : ( rangeItem | expr | infRangeItem );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_6 = input.LA(1);

                         
                        int index39_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_7 = input.LA(1);

                         
                        int index39_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_8 = input.LA(1);

                         
                        int index39_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_9 = input.LA(1);

                         
                        int index39_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_10 = input.LA(1);

                         
                        int index39_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Glossa()) ) {s = 15;}

                        else if ( (synpred49_Glossa()) ) {s = 16;}

                         
                        input.seek(index39_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\12\uffff";
    static final String DFA57_eofS =
        "\6\uffff\1\10\3\uffff";
    static final String DFA57_minS =
        "\1\17\5\uffff\1\20\3\uffff";
    static final String DFA57_maxS =
        "\1\107\5\uffff\1\110\3\uffff";
    static final String DFA57_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\7\1\6";
    static final String DFA57_specialS =
        "\12\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\6\62\uffff\1\1\1\2\1\3\1\4\1\5\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10\3\uffff\1\10\2\uffff\1\10\1\11\1\10\11\uffff\1\10\5\uffff"+
            "\5\10\2\uffff\2\10\2\uffff\1\10\2\uffff\12\10\7\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "409:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program145 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_program150 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_program153 = new BitSet(new long[]{0x00000000002B0000L});
    public static final BitSet FOLLOW_declarations_in_program160 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_BEGIN_in_program164 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_program169 = new BitSet(new long[]{0x00284044C0058000L});
    public static final BitSet FOLLOW_block_in_program176 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program180 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ID_in_program186 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_program191 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_constDecl_in_declarations205 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_varDecl_in_declarations208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl220 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl224 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl229 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ID_in_constAssign239 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EQ_in_constAssign241 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_constAssign244 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign247 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl259 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl263 = new BitSet(new long[]{0x000000003C010002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl268 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl282 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl285 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl288 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl291 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl296 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem315 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension336 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_arrayDimension341 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_COMMA_in_arrayDimension345 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_arrayDimension349 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block396 = new BitSet(new long[]{0x00284044C0008002L});
    public static final BitSet FOLLOW_printStm_in_stm415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseStm_in_stm474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStm_in_stm492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStm_in_stm510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatStm_in_stm528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm554 = new BitSet(new long[]{0x0C00000000018000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_printStm558 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_COMMA_in_printStm562 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_printStm565 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm573 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_READ_in_readStm600 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_readItem_in_readStm603 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_COMMA_in_readStm606 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_readItem_in_readStm609 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm614 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ID_in_readItem651 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm694 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm696 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_assingmentStm701 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm704 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm727 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm729 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm731 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_assingmentStm736 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm739 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm759 = new BitSet(new long[]{0x0000003200000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm761 = new BitSet(new long[]{0x0000003200000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm764 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm767 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm770 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_IF_in_ifBlock794 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_ifBlock797 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock799 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock803 = new BitSet(new long[]{0x00284044C0018000L});
    public static final BitSet FOLLOW_block_in_ifBlock808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock817 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock821 = new BitSet(new long[]{0x00284044C0018000L});
    public static final BitSet FOLLOW_block_in_elseBlock826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock835 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_elseIfBlock838 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock840 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock844 = new BitSet(new long[]{0x00284044C0018000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_caseStm857 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_caseStm860 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm863 = new BitSet(new long[]{0x0000018000010000L});
    public static final BitSet FOLLOW_caseBlock_in_caseStm868 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_caseElseBlock_in_caseStm871 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_END_SWITCH_in_caseStm874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm878 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_CASE_in_caseBlock890 = new BitSet(new long[]{0x0C003C0000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_caseExprList_in_caseBlock893 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseBlock896 = new BitSet(new long[]{0x00284044C0018000L});
    public static final BitSet FOLLOW_block_in_caseBlock901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList910 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_caseExprList913 = new BitSet(new long[]{0x0C003C0000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_caseExprListItem_in_caseExprList916 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rangeItem_in_caseExprListItem928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infRangeItem_in_caseExprListItem936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_rangeItem960 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RANGE_in_rangeItem962 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_rangeItem966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_infRangeItem1000 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_infRangeItem1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_infRangeItem1030 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_infRangeItem1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_infRangeItem1060 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_infRangeItem1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_infRangeItem1090 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_infRangeItem1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseElseBlock1120 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ELSE_in_caseElseBlock1122 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_caseElseBlock1124 = new BitSet(new long[]{0x00284044C0018000L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStm1143 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_forStm1146 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_FROM_in_forStm1148 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_forStm1153 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TO_in_forStm1155 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_forStm1160 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_STEP_in_forStm1163 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_forStm1168 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1173 = new BitSet(new long[]{0x002C4044C0018000L});
    public static final BitSet FOLLOW_block_in_forStm1178 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_forStm1180 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm1184 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_WHILE_in_whileStm1203 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_whileStm1206 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LOOP_in_whileStm1208 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1212 = new BitSet(new long[]{0x002C4044C0018000L});
    public static final BitSet FOLLOW_block_in_whileStm1217 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_whileStm1219 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm1223 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_REPEAT_in_repeatStm1235 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1239 = new BitSet(new long[]{0x00684044C0018000L});
    public static final BitSet FOLLOW_block_in_repeatStm1244 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_repeatStm1246 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_repeatStm1249 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm1252 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_andExpr_in_expr1264 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_OR_in_expr1268 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_andExpr_in_expr1271 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1287 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_AND_in_andExpr1290 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1293 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1303 = new BitSet(new long[]{0x0200000000100002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr1306 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1309 = new BitSet(new long[]{0x0200000000100002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr1313 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1316 = new BitSet(new long[]{0x0200000000100002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1327 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr1330 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_addExpr_in_compExpr1333 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr1337 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_addExpr_in_compExpr1340 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr1344 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_addExpr_in_compExpr1347 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr1351 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_addExpr_in_compExpr1354 = new BitSet(new long[]{0x00003C0000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1367 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr1370 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_multExpr_in_addExpr1373 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr1377 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_multExpr_in_addExpr1380 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1392 = new BitSet(new long[]{0xF000000000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr1395 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_powExpr_in_multExpr1398 = new BitSet(new long[]{0xF000000000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr1402 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_powExpr_in_multExpr1405 = new BitSet(new long[]{0xF000000000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr1409 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_powExpr_in_multExpr1412 = new BitSet(new long[]{0xF000000000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr1416 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_powExpr_in_multExpr1419 = new BitSet(new long[]{0xF000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_POW_in_powExpr1434 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1437 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr1448 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_atom_in_unaryExpr1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr1456 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_atom_in_unaryExpr1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr1471 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_atom_in_unaryExpr1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1530 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_atom1533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAR_in_atom1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem1548 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1570 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_arraySubscript1575 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_COMMA_in_arraySubscript1579 = new BitSet(new long[]{0x0C00000000008000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_expr_in_arraySubscript1583 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rangeItem_in_synpred48_Glossa928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred49_Glossa932 = new BitSet(new long[]{0x0000000000000002L});

}