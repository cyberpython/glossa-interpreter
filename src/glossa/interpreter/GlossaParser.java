// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-20 19:11:19

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


import org.antlr.runtime.tree.*;

public class GlossaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "AND", "OR", "NEQ", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "DOUBLE_DOT", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "SWITCH", "CASE", "END_SWITCH", "WHILE", "LOOP", "END_LOOP", "REPEAT", "UNTIL", "FOR", "FROM", "TO", "STEP", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=87;
    public static final int LT=39;
    public static final int END_PROCEDURE=84;
    public static final int WHILE=96;
    public static final int LETTER=110;
    public static final int MOD=48;
    public static final int STRINGS=25;
    public static final int LAMDA=73;
    public static final int UPSILON_DIALYTIKA_TONOS=123;
    public static final int CASE=94;
    public static final int NOT=50;
    public static final int OMICRON=63;
    public static final int EOF=-1;
    public static final int DOUBLE_DOT=56;
    public static final int LBRACKET=22;
    public static final int MU=69;
    public static final int TAU=70;
    public static final int POW=49;
    public static final int UPSILON_TONOS=119;
    public static final int LPAR=57;
    public static final int CONT_COMMAND=113;
    public static final int CONST_INT=54;
    public static final int LOOP=97;
    public static final int BEGIN=15;
    public static final int KAPPA=59;
    public static final int EQ=18;
    public static final int COMMENT=112;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=116;
    public static final int END_LOOP=98;
    public static final int GE=42;
    public static final int END_SWITCH=95;
    public static final int CONST_TRUE=51;
    public static final int NU=86;
    public static final int XI=92;
    public static final int SWITCH=93;
    public static final int ELSE=34;
    public static final int DELTA=80;
    public static final int EPSILON=71;
    public static final int CONST_STR=53;
    public static final int INTEGERS=26;
    public static final int ALPHA=60;
    public static final int SIGMA_TELIKO=74;
    public static final int REAL=106;
    public static final int BOOLEANS=24;
    public static final int THETA=79;
    public static final int UPSILON_DIALYTIKA=121;
    public static final int WS=114;
    public static final int OMICRON_TONOS=64;
    public static final int EPSILON_TONOS=72;
    public static final int READ=29;
    public static final int UNTIL=100;
    public static final int OMEGA=90;
    public static final int OR=37;
    public static final int GT=41;
    public static final int ALPHA_TONOS=75;
    public static final int REPEAT=99;
    public static final int PI=66;
    public static final int CALL=89;
    public static final int FROM=102;
    public static final int PHI=118;
    public static final int RHO=67;
    public static final int UPSILON=85;
    public static final int STEP=104;
    public static final int FOR=101;
    public static final int ETA_TONOS=62;
    public static final int CONSTANTS=17;
    public static final int AND=36;
    public static final int ID=13;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=32;
    public static final int OMEGA_TONOS=91;
    public static final int NOT_EOL=111;
    public static final int BOOLEAN=108;
    public static final int THEN=33;
    public static final int END_FUNCTION=88;
    public static final int COMMA=21;
    public static final int ETA=77;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PLUS=43;
    public static final int PSI=81;
    public static final int SIGMA=78;
    public static final int DIGIT=109;
    public static final int RBRACKET=23;
    public static final int IOTA_DIALYTIKA_TONOS=122;
    public static final int ELSE_IF=35;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=55;
    public static final int INTEGER=105;
    public static final int TO=103;
    public static final int LATIN_LETTER=115;
    public static final int REALS=27;
    public static final int CHI=65;
    public static final int MINUS=44;
    public static final int DIA=46;
    public static final int BETA=76;
    public static final int PRINT=28;
    public static final int PROCEDURE=83;
    public static final int COLON=20;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=38;
    public static final int NEWLINE=14;
    public static final int END_PROGRAM=16;
    public static final int ZETA=117;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=52;
    public static final int NEG=5;
    public static final int ASSIGN=30;
    public static final int VARIABLES=19;
    public static final int END_IF=31;
    public static final int PROGRAM=12;
    public static final int RPAR=58;
    public static final int IOTA=61;
    public static final int DIV=47;
    public static final int TIMES=45;
    public static final int GAMMA=68;
    public static final int IOTA_DIALYTIKA=120;
    public static final int LE=40;
    public static final int STRING=107;
    public static final int IOTA_TONOS=82;

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
    // src/glossa/interpreter/grammars/Glossa.g:280:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:280:6: ( program )
            // src/glossa/interpreter/grammars/Glossa.g:280:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit112);
            program1=program();

            state._fsp--;

            adaptor.addChild(root_0, program1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:282:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:282:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:282:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program120); 
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);

            id1=(Token)match(input,ID,FOLLOW_ID_in_program125); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            // src/glossa/interpreter/grammars/Glossa.g:282:27: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:282:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program128); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            pushFollow(FOLLOW_declarations_in_program135);
            declarations4=declarations();

            state._fsp--;

            adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program139); 
            // src/glossa/interpreter/grammars/Glossa.g:284:11: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:284:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program144); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            pushFollow(FOLLOW_block_in_program151);
            block7=block();

            state._fsp--;

            adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program155); 
            // src/glossa/interpreter/grammars/Glossa.g:286:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:286:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program161); 
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:286:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:286:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program166); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:288:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:289:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/Glossa.g:289:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/interpreter/grammars/Glossa.g:289:4: ( constDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANTS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:289:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations180);
                    constDecl10=constDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, constDecl10.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:289:15: ( varDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:289:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations183);
                    varDecl11=varDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, varDecl11.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:291:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:292:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/interpreter/grammars/Glossa.g:292:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl195); 
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:292:15: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:292:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl199); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:292:27: ( constAssign )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:292:27: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl204);
            	    constAssign14=constAssign();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constAssign14.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:294:1: constAssign : ID EQ expr ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:295:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:295:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign214); 
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign216); 
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);

            pushFollow(FOLLOW_expr_in_constAssign219);
            expr17=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr17.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:295:16: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:295:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign222); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:297:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:297:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/interpreter/grammars/Glossa.g:297:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl234); 
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:297:22: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:297:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl238); 

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

            // src/glossa/interpreter/grammars/Glossa.g:297:34: ( varsDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=BOOLEANS && LA11_0<=REALS)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:297:34: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl243);
            	    varsDecl21=varsDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varsDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:299:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:300:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:300:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl254);
            varType22=varType();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl257); 
            pushFollow(FOLLOW_varDeclItem_in_varsDecl260);
            varDeclItem24=varDeclItem();

            state._fsp--;

            adaptor.addChild(root_0, varDeclItem24.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:300:32: ( COMMA varDeclItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:300:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl263); 
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl266);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:300:54: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:300:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl271); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:302:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
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
            // src/glossa/interpreter/grammars/Glossa.g:303:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==LBRACKET) ) {
                    alt14=2;
                }
                else if ( (LA14_1==NEWLINE||LA14_1==COMMA) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:303:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem283); 
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:304:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem290);  
                    stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem292);
                    arrayDimension30=arrayDimension();

                    state._fsp--;

                    stream_arrayDimension.add(arrayDimension30.getTree());


                    // AST REWRITE
                    // elements: arrayDimension, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 304:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:304:26: ^( ARRAY ID arrayDimension )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_arrayDimension.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:306:1: arrayDimension : ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final GlossaParser.arrayDimension_return arrayDimension() throws RecognitionException {
        GlossaParser.arrayDimension_return retval = new GlossaParser.arrayDimension_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET31=null;
        Token RBRACKET32=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET31_tree=null;
        CommonTree RBRACKET32_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:307:2: ( ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:307:4: ( LBRACKET dimension+= expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:307:4: ( LBRACKET dimension+= expr RBRACKET )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==LBRACKET) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:307:5: LBRACKET dimension+= expr RBRACKET
            	    {
            	    LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension312);  
            	    stream_LBRACKET.add(LBRACKET31);

            	    pushFollow(FOLLOW_expr_in_arrayDimension316);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());

            	    RBRACKET32=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension318);  
            	    stream_RBRACKET.add(RBRACKET32);


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 307:41: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:307:44: ^( ARRAY_DIMENSION ( expr )+ )
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

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:309:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:309:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/interpreter/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set33=(Token)input.LT(1);
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set33));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:314:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm34 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:314:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/Glossa.g:314:9: ( stm )*
            {
            // src/glossa/interpreter/grammars/Glossa.g:314:9: ( stm )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||(LA16_0>=PRINT && LA16_0<=READ)||LA16_0==IF) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:314:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block363);
            	    stm34=stm();

            	    state._fsp--;

            	    stream_stm.add(stm34.getTree());

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
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 314:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/interpreter/grammars/Glossa.g:314:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/interpreter/grammars/Glossa.g:314:26: ( stm )*
                while ( stream_stm.hasNext() ) {
                    adaptor.addChild(root_1, stream_stm.nextTree());

                }
                stream_stm.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:316:1: stm : ( printStm | readStm | assingmentStm | ifStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.readStm_return readStm36 = null;

        GlossaParser.assingmentStm_return assingmentStm37 = null;

        GlossaParser.ifStm_return ifStm38 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:316:5: ( printStm | readStm | assingmentStm | ifStm )
            int alt17=4;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:316:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm382);
                    printStm35=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm35.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:317:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm400);
                    readStm36=readStm();

                    state._fsp--;

                    adaptor.addChild(root_0, readStm36.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:318:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm405);
                    assingmentStm37=assingmentStm();

                    state._fsp--;

                    adaptor.addChild(root_0, assingmentStm37.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:319:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm423);
                    ifStm38=ifStm();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStm38.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:322:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT39=null;
        Token char_literal41=null;
        Token NEWLINE43=null;
        GlossaParser.expr_return expr40 = null;

        GlossaParser.expr_return expr42 = null;


        CommonTree PRINT39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree NEWLINE43_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:323:9: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:323:11: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT39=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm449); 
            PRINT39_tree = (CommonTree)adaptor.create(PRINT39);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT39_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm452);
            expr40=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr40.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:323:23: ( ',' expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:323:25: ',' expr
            	    {
            	    char_literal41=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm456); 
            	    pushFollow(FOLLOW_expr_in_printStm459);
            	    expr42=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr42.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:323:38: ( NEWLINE )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==NEWLINE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:323:39: NEWLINE
            	    {
            	    NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm465); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:325:1: readStm : ( READ varId= ID ( NEWLINE )+ | READ arrId= ID arraySubscript ( NEWLINE )+ );
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token READ44=null;
        Token NEWLINE45=null;
        Token READ46=null;
        Token NEWLINE48=null;
        GlossaParser.arraySubscript_return arraySubscript47 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree READ44_tree=null;
        CommonTree NEWLINE45_tree=null;
        CommonTree READ46_tree=null;
        CommonTree NEWLINE48_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:325:9: ( READ varId= ID ( NEWLINE )+ | READ arrId= ID arraySubscript ( NEWLINE )+ )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==READ) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==ID) ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2==NEWLINE) ) {
                        alt22=1;
                    }
                    else if ( (LA22_2==LBRACKET) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:326:17: READ varId= ID ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    READ44=(Token)match(input,READ,FOLLOW_READ_in_readStm493); 
                    READ44_tree = (CommonTree)adaptor.create(READ44);
                    root_0 = (CommonTree)adaptor.becomeRoot(READ44_tree, root_0);

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readStm498); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    // src/glossa/interpreter/grammars/Glossa.g:326:32: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:326:33: NEWLINE
                    	    {
                    	    NEWLINE45=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm501); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:327:17: READ arrId= ID arraySubscript ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    READ46=(Token)match(input,READ,FOLLOW_READ_in_readStm522); 
                    READ46_tree = (CommonTree)adaptor.create(READ46);
                    root_0 = (CommonTree)adaptor.becomeRoot(READ46_tree, root_0);

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readStm527); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_readStm529);
                    arraySubscript47=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript47.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:327:47: ( NEWLINE )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==NEWLINE) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/Glossa.g:327:48: NEWLINE
                    	    {
                    	    NEWLINE48=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm532); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class assingmentStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assingmentStm"
    // src/glossa/interpreter/grammars/Glossa.g:330:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN49=null;
        Token NEWLINE50=null;
        Token ASSIGN52=null;
        Token NEWLINE53=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript51 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN49_tree=null;
        CommonTree NEWLINE50_tree=null;
        CommonTree ASSIGN52_tree=null;
        CommonTree NEWLINE53_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:331:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==ASSIGN) ) {
                    alt25=1;
                }
                else if ( (LA25_1==LBRACKET) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:331:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm556); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    ASSIGN49=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm558); 
                    ASSIGN49_tree = (CommonTree)adaptor.create(ASSIGN49);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN49_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm563);
                    varValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:331:35: ( NEWLINE )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==NEWLINE) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/Glossa.g:331:36: NEWLINE
                    	    {
                    	    NEWLINE50=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm566); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:332:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm589); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm591);
                    arraySubscript51=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript51.getTree());
                    ASSIGN52=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm593); 
                    ASSIGN52_tree = (CommonTree)adaptor.create(ASSIGN52);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN52_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm598);
                    arrItemValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:332:67: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:332:68: NEWLINE
                    	    {
                    	    NEWLINE53=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm601); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:335:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF57=null;
        Token NEWLINE58=null;
        GlossaParser.ifBlock_return ifBlock54 = null;

        GlossaParser.elseIfBlock_return elseIfBlock55 = null;

        GlossaParser.elseBlock_return elseBlock56 = null;


        CommonTree END_IF57_tree=null;
        CommonTree NEWLINE58_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:335:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/interpreter/grammars/Glossa.g:335:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm621);
            ifBlock54=ifBlock();

            state._fsp--;

            stream_ifBlock.add(ifBlock54.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:335:17: ( elseIfBlock )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==ELSE_IF) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:335:17: elseIfBlock
            	    {
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm623);
            	    elseIfBlock55=elseIfBlock();

            	    state._fsp--;

            	    stream_elseIfBlock.add(elseIfBlock55.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:335:30: ( elseBlock )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ELSE) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:335:30: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm626);
                    elseBlock56=elseBlock();

                    state._fsp--;

                    stream_elseBlock.add(elseBlock56.getTree());

                    }
                    break;

            }

            END_IF57=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm629);  
            stream_END_IF.add(END_IF57);

            // src/glossa/interpreter/grammars/Glossa.g:335:48: ( NEWLINE )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==NEWLINE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:335:49: NEWLINE
            	    {
            	    NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm632);  
            	    stream_NEWLINE.add(NEWLINE58);


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);



            // AST REWRITE
            // elements: elseBlock, ifBlock, elseIfBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 335:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/interpreter/grammars/Glossa.g:335:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/interpreter/grammars/Glossa.g:335:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/interpreter/grammars/Glossa.g:335:92: ( elseBlock )?
                if ( stream_elseBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseBlock.nextTree());

                }
                stream_elseBlock.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:337:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF59=null;
        Token THEN61=null;
        Token NEWLINE62=null;
        GlossaParser.expr_return expr60 = null;

        GlossaParser.block_return block63 = null;


        CommonTree IF59_tree=null;
        CommonTree THEN61_tree=null;
        CommonTree NEWLINE62_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:337:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:337:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF59=(Token)match(input,IF,FOLLOW_IF_in_ifBlock656); 
            IF59_tree = (CommonTree)adaptor.create(IF59);
            root_0 = (CommonTree)adaptor.becomeRoot(IF59_tree, root_0);

            pushFollow(FOLLOW_expr_in_ifBlock659);
            expr60=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr60.getTree());
            THEN61=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock661); 
            // src/glossa/interpreter/grammars/Glossa.g:337:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:337:27: NEWLINE
            	    {
            	    NEWLINE62=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock665); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            pushFollow(FOLLOW_block_in_ifBlock670);
            block63=block();

            state._fsp--;

            adaptor.addChild(root_0, block63.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:339:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE64=null;
        Token NEWLINE65=null;
        GlossaParser.block_return block66 = null;


        CommonTree ELSE64_tree=null;
        CommonTree NEWLINE65_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:340:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:340:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE64=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock679); 
            ELSE64_tree = (CommonTree)adaptor.create(ELSE64);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE64_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:340:10: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:340:11: NEWLINE
            	    {
            	    NEWLINE65=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock683); 

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            pushFollow(FOLLOW_block_in_elseBlock688);
            block66=block();

            state._fsp--;

            adaptor.addChild(root_0, block66.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:342:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF67=null;
        Token THEN69=null;
        Token NEWLINE70=null;
        GlossaParser.expr_return expr68 = null;

        GlossaParser.block_return block71 = null;


        CommonTree ELSE_IF67_tree=null;
        CommonTree THEN69_tree=null;
        CommonTree NEWLINE70_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:343:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:343:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF67=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock697); 
            ELSE_IF67_tree = (CommonTree)adaptor.create(ELSE_IF67);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF67_tree, root_0);

            pushFollow(FOLLOW_expr_in_elseIfBlock700);
            expr68=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr68.getTree());
            THEN69=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock702); 
            // src/glossa/interpreter/grammars/Glossa.g:343:24: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:343:25: NEWLINE
            	    {
            	    NEWLINE70=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock706); 

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            pushFollow(FOLLOW_block_in_elseIfBlock711);
            block71=block();

            state._fsp--;

            adaptor.addChild(root_0, block71.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/Glossa.g:345:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND73=null;
        Token OR75=null;
        GlossaParser.eqExpr_return eqExpr72 = null;

        GlossaParser.eqExpr_return eqExpr74 = null;

        GlossaParser.eqExpr_return eqExpr76 = null;


        CommonTree AND73_tree=null;
        CommonTree OR75_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:345:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:345:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr720);
            eqExpr72=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr72.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:345:15: ( AND eqExpr | OR eqExpr )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==AND) ) {
                    alt32=1;
                }
                else if ( (LA32_0==OR) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:345:16: AND eqExpr
            	    {
            	    AND73=(Token)match(input,AND,FOLLOW_AND_in_expr723); 
            	    AND73_tree = (CommonTree)adaptor.create(AND73);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND73_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr726);
            	    eqExpr74=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr74.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:345:30: OR eqExpr
            	    {
            	    OR75=(Token)match(input,OR,FOLLOW_OR_in_expr730); 
            	    OR75_tree = (CommonTree)adaptor.create(OR75);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR75_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr733);
            	    eqExpr76=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr76.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // src/glossa/interpreter/grammars/Glossa.g:347:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ78=null;
        Token NEQ80=null;
        GlossaParser.compExpr_return compExpr77 = null;

        GlossaParser.compExpr_return compExpr79 = null;

        GlossaParser.compExpr_return compExpr81 = null;


        CommonTree EQ78_tree=null;
        CommonTree NEQ80_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:347:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:347:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr743);
            compExpr77=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr77.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:347:19: ( EQ compExpr | NEQ compExpr )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==EQ) ) {
                    alt33=1;
                }
                else if ( (LA33_0==NEQ) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:347:20: EQ compExpr
            	    {
            	    EQ78=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr746); 
            	    EQ78_tree = (CommonTree)adaptor.create(EQ78);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ78_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr749);
            	    compExpr79=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr79.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:347:35: NEQ compExpr
            	    {
            	    NEQ80=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr753); 
            	    NEQ80_tree = (CommonTree)adaptor.create(NEQ80);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ80_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr756);
            	    compExpr81=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr81.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:349:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT83=null;
        Token LE85=null;
        Token GT87=null;
        Token GE89=null;
        GlossaParser.addExpr_return addExpr82 = null;

        GlossaParser.addExpr_return addExpr84 = null;

        GlossaParser.addExpr_return addExpr86 = null;

        GlossaParser.addExpr_return addExpr88 = null;

        GlossaParser.addExpr_return addExpr90 = null;


        CommonTree LT83_tree=null;
        CommonTree LE85_tree=null;
        CommonTree GT87_tree=null;
        CommonTree GE89_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:349:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:349:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr767);
            addExpr82=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr82.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:349:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop34:
            do {
                int alt34=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt34=1;
                    }
                    break;
                case LE:
                    {
                    alt34=2;
                    }
                    break;
                case GT:
                    {
                    alt34=3;
                    }
                    break;
                case GE:
                    {
                    alt34=4;
                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:349:20: LT addExpr
            	    {
            	    LT83=(Token)match(input,LT,FOLLOW_LT_in_compExpr770); 
            	    LT83_tree = (CommonTree)adaptor.create(LT83);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT83_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr773);
            	    addExpr84=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr84.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:349:34: LE addExpr
            	    {
            	    LE85=(Token)match(input,LE,FOLLOW_LE_in_compExpr777); 
            	    LE85_tree = (CommonTree)adaptor.create(LE85);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE85_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr780);
            	    addExpr86=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr86.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:349:48: GT addExpr
            	    {
            	    GT87=(Token)match(input,GT,FOLLOW_GT_in_compExpr784); 
            	    GT87_tree = (CommonTree)adaptor.create(GT87);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT87_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr787);
            	    addExpr88=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr88.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:349:62: GE addExpr
            	    {
            	    GE89=(Token)match(input,GE,FOLLOW_GE_in_compExpr791); 
            	    GE89_tree = (CommonTree)adaptor.create(GE89);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE89_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr794);
            	    addExpr90=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr90.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:351:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS92=null;
        Token MINUS94=null;
        GlossaParser.multExpr_return multExpr91 = null;

        GlossaParser.multExpr_return multExpr93 = null;

        GlossaParser.multExpr_return multExpr95 = null;


        CommonTree PLUS92_tree=null;
        CommonTree MINUS94_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:351:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:351:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr807);
            multExpr91=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr91.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:351:20: ( PLUS multExpr | MINUS multExpr )*
            loop35:
            do {
                int alt35=3;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==PLUS) ) {
                    alt35=1;
                }
                else if ( (LA35_0==MINUS) ) {
                    alt35=2;
                }


                switch (alt35) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:351:21: PLUS multExpr
            	    {
            	    PLUS92=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr810); 
            	    PLUS92_tree = (CommonTree)adaptor.create(PLUS92);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS92_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr813);
            	    multExpr93=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr93.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:351:38: MINUS multExpr
            	    {
            	    MINUS94=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr817); 
            	    MINUS94_tree = (CommonTree)adaptor.create(MINUS94);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS94_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr820);
            	    multExpr95=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr95.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:353:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES97=null;
        Token DIA99=null;
        Token DIV101=null;
        Token MOD103=null;
        GlossaParser.powExpr_return powExpr96 = null;

        GlossaParser.powExpr_return powExpr98 = null;

        GlossaParser.powExpr_return powExpr100 = null;

        GlossaParser.powExpr_return powExpr102 = null;

        GlossaParser.powExpr_return powExpr104 = null;


        CommonTree TIMES97_tree=null;
        CommonTree DIA99_tree=null;
        CommonTree DIV101_tree=null;
        CommonTree MOD103_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:353:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:353:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr832);
            powExpr96=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr96.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:353:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop36:
            do {
                int alt36=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt36=1;
                    }
                    break;
                case DIA:
                    {
                    alt36=2;
                    }
                    break;
                case DIV:
                    {
                    alt36=3;
                    }
                    break;
                case MOD:
                    {
                    alt36=4;
                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:353:21: TIMES powExpr
            	    {
            	    TIMES97=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr835); 
            	    TIMES97_tree = (CommonTree)adaptor.create(TIMES97);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES97_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr838);
            	    powExpr98=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr98.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:353:38: DIA powExpr
            	    {
            	    DIA99=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr842); 
            	    DIA99_tree = (CommonTree)adaptor.create(DIA99);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA99_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr845);
            	    powExpr100=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr100.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:353:53: DIV powExpr
            	    {
            	    DIV101=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr849); 
            	    DIV101_tree = (CommonTree)adaptor.create(DIV101);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV101_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr852);
            	    powExpr102=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr102.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:353:68: MOD powExpr
            	    {
            	    MOD103=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr856); 
            	    MOD103_tree = (CommonTree)adaptor.create(MOD103);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD103_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr859);
            	    powExpr104=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr104.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:355:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW106=null;
        GlossaParser.unaryExpr_return unaryExpr105 = null;

        GlossaParser.unaryExpr_return unaryExpr107 = null;


        CommonTree POW106_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:355:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:355:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr871);
            unaryExpr105=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr105.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:355:21: ( POW unaryExpr )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==POW) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:355:22: POW unaryExpr
            	    {
            	    POW106=(Token)match(input,POW,FOLLOW_POW_in_powExpr874); 
            	    POW106_tree = (CommonTree)adaptor.create(POW106);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW106_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr877);
            	    unaryExpr107=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr107.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:357:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS108=null;
        Token MINUS110=null;
        Token NOT112=null;
        GlossaParser.atom_return atom109 = null;

        GlossaParser.atom_return atom111 = null;

        GlossaParser.atom_return atom113 = null;

        GlossaParser.atom_return atom114 = null;


        CommonTree PLUS108_tree=null;
        CommonTree MINUS110_tree=null;
        CommonTree NOT112_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:358:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt38=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt38=1;
                }
                break;
            case MINUS:
                {
                alt38=2;
                }
                break;
            case NOT:
                {
                alt38=3;
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
                alt38=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:358:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS108=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr888); 
                    pushFollow(FOLLOW_atom_in_unaryExpr891);
                    atom109=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom109.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:359:4: MINUS atom
                    {
                    MINUS110=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr896);  
                    stream_MINUS.add(MINUS110);

                    pushFollow(FOLLOW_atom_in_unaryExpr898);
                    atom111=atom();

                    state._fsp--;

                    stream_atom.add(atom111.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 359:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:359:18: ^( NEG atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEG, "NEG"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:360:4: NOT atom
                    {
                    NOT112=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr911);  
                    stream_NOT.add(NOT112);

                    pushFollow(FOLLOW_atom_in_unaryExpr913);
                    atom113=atom();

                    state._fsp--;

                    stream_atom.add(atom113.getTree());


                    // AST REWRITE
                    // elements: NOT, atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 360:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:360:16: ^( NOT atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:361:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr926);
                    atom114=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom114.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:364:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE115=null;
        Token CONST_FALSE116=null;
        Token CONST_STR117=null;
        Token CONST_INT118=null;
        Token CONST_REAL119=null;
        Token ID121=null;
        Token char_literal122=null;
        Token char_literal124=null;
        GlossaParser.arrayItem_return arrayItem120 = null;

        GlossaParser.expr_return expr123 = null;


        CommonTree CONST_TRUE115_tree=null;
        CommonTree CONST_FALSE116_tree=null;
        CommonTree CONST_STR117_tree=null;
        CommonTree CONST_INT118_tree=null;
        CommonTree CONST_REAL119_tree=null;
        CommonTree ID121_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:364:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt39=8;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:364:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE115=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom935); 
                    CONST_TRUE115_tree = (CommonTree)adaptor.create(CONST_TRUE115);
                    adaptor.addChild(root_0, CONST_TRUE115_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:365:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE116=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom940); 
                    CONST_FALSE116_tree = (CommonTree)adaptor.create(CONST_FALSE116);
                    adaptor.addChild(root_0, CONST_FALSE116_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:366:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR117=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom945); 
                    CONST_STR117_tree = (CommonTree)adaptor.create(CONST_STR117);
                    adaptor.addChild(root_0, CONST_STR117_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:367:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT118=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom950); 
                    CONST_INT118_tree = (CommonTree)adaptor.create(CONST_INT118);
                    adaptor.addChild(root_0, CONST_INT118_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:368:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL119=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom955); 
                    CONST_REAL119_tree = (CommonTree)adaptor.create(CONST_REAL119);
                    adaptor.addChild(root_0, CONST_REAL119_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:369:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom960);
                    arrayItem120=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem120.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:370:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID121=(Token)match(input,ID,FOLLOW_ID_in_atom965); 
                    ID121_tree = (CommonTree)adaptor.create(ID121);
                    adaptor.addChild(root_0, ID121_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:371:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal122=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom970); 
                    pushFollow(FOLLOW_expr_in_atom973);
                    expr123=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr123.getTree());
                    char_literal124=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom975); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:374:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID125=null;
        GlossaParser.arraySubscript_return arraySubscript126 = null;


        CommonTree ID125_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:375:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:375:4: ID arraySubscript
            {
            ID125=(Token)match(input,ID,FOLLOW_ID_in_arrayItem988);  
            stream_ID.add(ID125);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem990);
            arraySubscript126=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript126.getTree());


            // AST REWRITE
            // elements: arraySubscript, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 375:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:375:25: ^( ARRAY_ITEM ID arraySubscript )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_ITEM, "ARRAY_ITEM"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_arraySubscript.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // src/glossa/interpreter/grammars/Glossa.g:377:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET127=null;
        Token RBRACKET129=null;
        GlossaParser.expr_return expr128 = null;


        CommonTree LBRACKET127_tree=null;
        CommonTree RBRACKET129_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:378:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:378:4: ( LBRACKET expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:378:4: ( LBRACKET expr RBRACKET )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==LBRACKET) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:378:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET127=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1011);  
            	    stream_LBRACKET.add(LBRACKET127);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1013);
            	    expr128=expr();

            	    state._fsp--;

            	    stream_expr.add(expr128.getTree());
            	    RBRACKET129=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1015);  
            	    stream_RBRACKET.add(RBRACKET129);


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 378:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:378:33: ^( ARRAY_INDEX ( expr )+ )
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

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    // Delegated rules


    protected DFA39 dfa39 = new DFA39(this);
    static final String DFA39_eotS =
        "\12\uffff";
    static final String DFA39_eofS =
        "\12\uffff";
    static final String DFA39_minS =
        "\1\15\5\uffff\1\16\3\uffff";
    static final String DFA39_maxS =
        "\1\71\5\uffff\1\72\3\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\7\1\6";
    static final String DFA39_specialS =
        "\12\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\6\45\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10\3\uffff\1\10\2\uffff\1\10\1\11\1\10\11\uffff\1\10\2\uffff"+
            "\16\10\10\uffff\1\10",
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
            return "364:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program120 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_program125 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program128 = new BitSet(new long[]{0x00000000000AC000L});
    public static final BitSet FOLLOW_declarations_in_program135 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BEGIN_in_program139 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program144 = new BitSet(new long[]{0x0000000130016000L});
    public static final BitSet FOLLOW_block_in_program151 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program155 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ID_in_program161 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program166 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_constDecl_in_declarations180 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_varDecl_in_declarations183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl195 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl199 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl204 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_constAssign214 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_constAssign216 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_constAssign219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign222 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl234 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl238 = new BitSet(new long[]{0x000000000F004002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl243 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_varType_in_varsDecl254 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl257 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl260 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl263 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl266 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl271 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem290 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension312 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension316 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension318 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block363 = new BitSet(new long[]{0x0000000130002002L});
    public static final BitSet FOLLOW_printStm_in_stm382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm449 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_printStm452 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_printStm456 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_printStm459 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm465 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_READ_in_readStm493 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_readStm498 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm501 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_READ_in_readStm522 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_readStm527 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_readStm529 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm532 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm556 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm558 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm563 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm566 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm589 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm591 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm593 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm598 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm601 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm621 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm623 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm626 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm629 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm632 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_IF_in_ifBlock656 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_ifBlock659 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock661 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock665 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_ifBlock670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock679 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock683 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_elseBlock688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock697 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock700 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock702 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock706 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_expr720 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_AND_in_expr723 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_eqExpr_in_expr726 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_OR_in_expr730 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_eqExpr_in_expr733 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr743 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr746 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr749 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr753 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr756 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr767 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr770 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr773 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr777 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr780 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr784 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr787 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr791 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr794 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr807 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr810 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr813 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr817 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr820 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr832 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr835 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr838 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr842 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr845 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr849 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr852 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr856 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr859 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr871 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr874 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr877 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr888 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr896 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr911 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom970 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_atom973 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem988 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1011 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1013 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1015 = new BitSet(new long[]{0x0000000000400002L});

}