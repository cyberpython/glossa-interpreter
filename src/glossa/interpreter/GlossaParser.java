// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-19 17:18:27

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "ASSIGN", "AND", "OR", "NEQ", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "DOUBLE_DOT", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "READ", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "IF", "THEN", "OMEGA", "OMEGA_TONOS", "ELSE", "ELSE_IF", "END_IF", "XI", "SWITCH", "CASE", "END_SWITCH", "WHILE", "LOOP", "END_LOOP", "REPEAT", "UNTIL", "FOR", "FROM", "TO", "STEP", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=81;
    public static final int LT=32;
    public static final int END_PROCEDURE=78;
    public static final int WHILE=95;
    public static final int LETTER=109;
    public static final int MOD=41;
    public static final int STRINGS=24;
    public static final int LAMDA=66;
    public static final int UPSILON_DIALYTIKA_TONOS=122;
    public static final int CASE=93;
    public static final int NOT=43;
    public static final int OMICRON=56;
    public static final int EOF=-1;
    public static final int DOUBLE_DOT=49;
    public static final int LBRACKET=21;
    public static final int MU=62;
    public static final int TAU=63;
    public static final int POW=42;
    public static final int UPSILON_TONOS=118;
    public static final int LPAR=50;
    public static final int CONT_COMMAND=112;
    public static final int CONST_INT=47;
    public static final int LOOP=96;
    public static final int BEGIN=14;
    public static final int KAPPA=52;
    public static final int EQ=17;
    public static final int COMMENT=111;
    public static final int ARRAY=7;
    public static final int GREEK_LETTER=115;
    public static final int END_LOOP=97;
    public static final int GE=35;
    public static final int END_SWITCH=94;
    public static final int CONST_TRUE=44;
    public static final int NU=80;
    public static final int XI=91;
    public static final int SWITCH=92;
    public static final int ELSE=88;
    public static final int DELTA=73;
    public static final int EPSILON=64;
    public static final int CONST_STR=46;
    public static final int INTEGERS=25;
    public static final int ALPHA=53;
    public static final int SIGMA_TELIKO=67;
    public static final int REAL=105;
    public static final int BOOLEANS=23;
    public static final int THETA=72;
    public static final int UPSILON_DIALYTIKA=120;
    public static final int WS=113;
    public static final int OMICRON_TONOS=57;
    public static final int EPSILON_TONOS=65;
    public static final int READ=74;
    public static final int UNTIL=99;
    public static final int OMEGA=86;
    public static final int OR=30;
    public static final int GT=34;
    public static final int ALPHA_TONOS=68;
    public static final int REPEAT=98;
    public static final int PI=59;
    public static final int CALL=83;
    public static final int FROM=101;
    public static final int PHI=117;
    public static final int RHO=60;
    public static final int UPSILON=79;
    public static final int STEP=103;
    public static final int FOR=100;
    public static final int ETA_TONOS=55;
    public static final int CONSTANTS=16;
    public static final int AND=29;
    public static final int ID=12;
    public static final int ARRAY_DIMENSION=10;
    public static final int IF=84;
    public static final int OMEGA_TONOS=87;
    public static final int NOT_EOL=110;
    public static final int BOOLEAN=107;
    public static final int THEN=85;
    public static final int END_FUNCTION=82;
    public static final int COMMA=20;
    public static final int ETA=70;
    public static final int ARRAY_INDEX=9;
    public static final int PLUS=36;
    public static final int PSI=75;
    public static final int SIGMA=71;
    public static final int DIGIT=108;
    public static final int RBRACKET=22;
    public static final int IOTA_DIALYTIKA_TONOS=121;
    public static final int ELSE_IF=89;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=48;
    public static final int INTEGER=104;
    public static final int TO=102;
    public static final int LATIN_LETTER=114;
    public static final int REALS=26;
    public static final int CHI=58;
    public static final int MINUS=37;
    public static final int DIA=39;
    public static final int BETA=69;
    public static final int PRINT=27;
    public static final int PROCEDURE=77;
    public static final int COLON=19;
    public static final int ARRAY_ITEM=8;
    public static final int NEQ=31;
    public static final int NEWLINE=13;
    public static final int END_PROGRAM=15;
    public static final int ZETA=116;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=45;
    public static final int NEG=5;
    public static final int ASSIGN=28;
    public static final int VARIABLES=18;
    public static final int END_IF=90;
    public static final int PROGRAM=11;
    public static final int RPAR=51;
    public static final int IOTA=54;
    public static final int DIV=40;
    public static final int TIMES=38;
    public static final int GAMMA=61;
    public static final int IOTA_DIALYTIKA=119;
    public static final int LE=33;
    public static final int STRING=106;
    public static final int IOTA_TONOS=76;

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
                ReportingAndMessagingUtils.parserError(new Point(e.line, e.charPositionInLine), msg);
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
    // src/glossa/interpreter/grammars/Glossa.g:279:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:279:6: ( program )
            // src/glossa/interpreter/grammars/Glossa.g:279:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit107);
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
    // src/glossa/interpreter/grammars/Glossa.g:281:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:281:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:281:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program115); 
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);

            id1=(Token)match(input,ID,FOLLOW_ID_in_program120); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            // src/glossa/interpreter/grammars/Glossa.g:281:27: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:281:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program123); 

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

            pushFollow(FOLLOW_declarations_in_program130);
            declarations4=declarations();

            state._fsp--;

            adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program134); 
            // src/glossa/interpreter/grammars/Glossa.g:283:11: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:283:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program139); 

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

            pushFollow(FOLLOW_block_in_program146);
            block7=block();

            state._fsp--;

            adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program150); 
            // src/glossa/interpreter/grammars/Glossa.g:285:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:285:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program156); 
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:285:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:285:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program161); 

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
    // src/glossa/interpreter/grammars/Glossa.g:287:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:288:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/Glossa.g:288:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/interpreter/grammars/Glossa.g:288:4: ( constDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANTS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:288:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations175);
                    constDecl10=constDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, constDecl10.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:288:15: ( varDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:288:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations178);
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
    // src/glossa/interpreter/grammars/Glossa.g:290:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:291:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/interpreter/grammars/Glossa.g:291:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl190); 
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:291:15: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:291:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl194); 

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

            // src/glossa/interpreter/grammars/Glossa.g:291:27: ( constAssign )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:291:27: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl199);
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
    // src/glossa/interpreter/grammars/Glossa.g:293:1: constAssign : ID EQ expr ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:294:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:294:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign209); 
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign211); 
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);

            pushFollow(FOLLOW_expr_in_constAssign214);
            expr17=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr17.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:294:16: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:294:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign217); 

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
    // src/glossa/interpreter/grammars/Glossa.g:296:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:296:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/interpreter/grammars/Glossa.g:296:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl229); 
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:296:22: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:296:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl233); 

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

            // src/glossa/interpreter/grammars/Glossa.g:296:34: ( varsDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=BOOLEANS && LA11_0<=REALS)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:296:34: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl238);
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
    // src/glossa/interpreter/grammars/Glossa.g:298:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:299:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:299:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl249);
            varType22=varType();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl252); 
            pushFollow(FOLLOW_varDeclItem_in_varsDecl255);
            varDeclItem24=varDeclItem();

            state._fsp--;

            adaptor.addChild(root_0, varDeclItem24.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:299:32: ( COMMA varDeclItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:299:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl258); 
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl261);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:299:54: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:299:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl266); 

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
    // src/glossa/interpreter/grammars/Glossa.g:301:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
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
            // src/glossa/interpreter/grammars/Glossa.g:302:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==NEWLINE||LA14_1==COMMA) ) {
                    alt14=1;
                }
                else if ( (LA14_1==LBRACKET) ) {
                    alt14=2;
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
                    // src/glossa/interpreter/grammars/Glossa.g:302:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem278); 
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:303:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem285);  
                    stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem287);
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
                    // 303:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:303:26: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/Glossa.g:305:1: arrayDimension : ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:306:2: ( ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:306:4: ( LBRACKET dimension+= expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:306:4: ( LBRACKET dimension+= expr RBRACKET )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:306:5: LBRACKET dimension+= expr RBRACKET
            	    {
            	    LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension307);  
            	    stream_LBRACKET.add(LBRACKET31);

            	    pushFollow(FOLLOW_expr_in_arrayDimension311);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());

            	    RBRACKET32=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension313);  
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
            // 306:41: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:306:44: ^( ARRAY_DIMENSION ( expr )+ )
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
    // src/glossa/interpreter/grammars/Glossa.g:308:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:308:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
    // src/glossa/interpreter/grammars/Glossa.g:313:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm34 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:313:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/Glossa.g:313:9: ( stm )*
            {
            // src/glossa/interpreter/grammars/Glossa.g:313:9: ( stm )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||LA16_0==PRINT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:313:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block358);
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
            // 313:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/interpreter/grammars/Glossa.g:313:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/interpreter/grammars/Glossa.g:313:26: ( stm )*
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
    // src/glossa/interpreter/grammars/Glossa.g:315:1: stm : ( printStm | assingmentStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.assingmentStm_return assingmentStm36 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:315:5: ( printStm | assingmentStm )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==PRINT) ) {
                alt17=1;
            }
            else if ( (LA17_0==ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:315:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm377);
                    printStm35=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm35.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:316:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm382);
                    assingmentStm36=assingmentStm();

                    state._fsp--;

                    adaptor.addChild(root_0, assingmentStm36.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:318:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT37=null;
        Token char_literal39=null;
        Token NEWLINE41=null;
        GlossaParser.expr_return expr38 = null;

        GlossaParser.expr_return expr40 = null;


        CommonTree PRINT37_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree NEWLINE41_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:318:10: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:318:12: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT37=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm391); 
            PRINT37_tree = (CommonTree)adaptor.create(PRINT37);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT37_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm394);
            expr38=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr38.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:318:24: ( ',' expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:318:26: ',' expr
            	    {
            	    char_literal39=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm398); 
            	    pushFollow(FOLLOW_expr_in_printStm401);
            	    expr40=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr40.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:318:39: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:318:40: NEWLINE
            	    {
            	    NEWLINE41=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm407); 

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

    public static class assingmentStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assingmentStm"
    // src/glossa/interpreter/grammars/Glossa.g:320:1: assingmentStm : varId= ID ASSIGN varValue= expr ( NEWLINE )+ ;
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token ASSIGN42=null;
        Token NEWLINE43=null;
        GlossaParser.expr_return varValue = null;


        CommonTree varId_tree=null;
        CommonTree ASSIGN42_tree=null;
        CommonTree NEWLINE43_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:321:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:321:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm423); 
            varId_tree = (CommonTree)adaptor.create(varId);
            adaptor.addChild(root_0, varId_tree);

            ASSIGN42=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm425); 
            ASSIGN42_tree = (CommonTree)adaptor.create(ASSIGN42);
            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN42_tree, root_0);

            pushFollow(FOLLOW_expr_in_assingmentStm430);
            varValue=expr();

            state._fsp--;

            adaptor.addChild(root_0, varValue.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:321:35: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:321:36: NEWLINE
            	    {
            	    NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm433); 

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

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/Glossa.g:325:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND45=null;
        Token OR47=null;
        GlossaParser.eqExpr_return eqExpr44 = null;

        GlossaParser.eqExpr_return eqExpr46 = null;

        GlossaParser.eqExpr_return eqExpr48 = null;


        CommonTree AND45_tree=null;
        CommonTree OR47_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:325:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:325:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr463);
            eqExpr44=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr44.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:325:15: ( AND eqExpr | OR eqExpr )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==AND) ) {
                    alt21=1;
                }
                else if ( (LA21_0==OR) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:325:16: AND eqExpr
            	    {
            	    AND45=(Token)match(input,AND,FOLLOW_AND_in_expr466); 
            	    AND45_tree = (CommonTree)adaptor.create(AND45);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND45_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr469);
            	    eqExpr46=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr46.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:325:30: OR eqExpr
            	    {
            	    OR47=(Token)match(input,OR,FOLLOW_OR_in_expr473); 
            	    OR47_tree = (CommonTree)adaptor.create(OR47);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR47_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr476);
            	    eqExpr48=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr48.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // src/glossa/interpreter/grammars/Glossa.g:327:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ50=null;
        Token NEQ52=null;
        GlossaParser.compExpr_return compExpr49 = null;

        GlossaParser.compExpr_return compExpr51 = null;

        GlossaParser.compExpr_return compExpr53 = null;


        CommonTree EQ50_tree=null;
        CommonTree NEQ52_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:327:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:327:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr486);
            compExpr49=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr49.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:327:19: ( EQ compExpr | NEQ compExpr )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==EQ) ) {
                    alt22=1;
                }
                else if ( (LA22_0==NEQ) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:327:20: EQ compExpr
            	    {
            	    EQ50=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr489); 
            	    EQ50_tree = (CommonTree)adaptor.create(EQ50);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ50_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr492);
            	    compExpr51=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr51.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:327:35: NEQ compExpr
            	    {
            	    NEQ52=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr496); 
            	    NEQ52_tree = (CommonTree)adaptor.create(NEQ52);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ52_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr499);
            	    compExpr53=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr53.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // src/glossa/interpreter/grammars/Glossa.g:329:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT55=null;
        Token LE57=null;
        Token GT59=null;
        Token GE61=null;
        GlossaParser.addExpr_return addExpr54 = null;

        GlossaParser.addExpr_return addExpr56 = null;

        GlossaParser.addExpr_return addExpr58 = null;

        GlossaParser.addExpr_return addExpr60 = null;

        GlossaParser.addExpr_return addExpr62 = null;


        CommonTree LT55_tree=null;
        CommonTree LE57_tree=null;
        CommonTree GT59_tree=null;
        CommonTree GE61_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:329:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:329:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr510);
            addExpr54=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr54.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:329:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop23:
            do {
                int alt23=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt23=1;
                    }
                    break;
                case LE:
                    {
                    alt23=2;
                    }
                    break;
                case GT:
                    {
                    alt23=3;
                    }
                    break;
                case GE:
                    {
                    alt23=4;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:329:20: LT addExpr
            	    {
            	    LT55=(Token)match(input,LT,FOLLOW_LT_in_compExpr513); 
            	    LT55_tree = (CommonTree)adaptor.create(LT55);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT55_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr516);
            	    addExpr56=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr56.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:329:34: LE addExpr
            	    {
            	    LE57=(Token)match(input,LE,FOLLOW_LE_in_compExpr520); 
            	    LE57_tree = (CommonTree)adaptor.create(LE57);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE57_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr523);
            	    addExpr58=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr58.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:329:48: GT addExpr
            	    {
            	    GT59=(Token)match(input,GT,FOLLOW_GT_in_compExpr527); 
            	    GT59_tree = (CommonTree)adaptor.create(GT59);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT59_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr530);
            	    addExpr60=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr60.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:329:62: GE addExpr
            	    {
            	    GE61=(Token)match(input,GE,FOLLOW_GE_in_compExpr534); 
            	    GE61_tree = (CommonTree)adaptor.create(GE61);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE61_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr537);
            	    addExpr62=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr62.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // src/glossa/interpreter/grammars/Glossa.g:331:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS64=null;
        Token MINUS66=null;
        GlossaParser.multExpr_return multExpr63 = null;

        GlossaParser.multExpr_return multExpr65 = null;

        GlossaParser.multExpr_return multExpr67 = null;


        CommonTree PLUS64_tree=null;
        CommonTree MINUS66_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:331:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:331:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr550);
            multExpr63=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr63.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:331:20: ( PLUS multExpr | MINUS multExpr )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==PLUS) ) {
                    alt24=1;
                }
                else if ( (LA24_0==MINUS) ) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:331:21: PLUS multExpr
            	    {
            	    PLUS64=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr553); 
            	    PLUS64_tree = (CommonTree)adaptor.create(PLUS64);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS64_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr556);
            	    multExpr65=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr65.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:331:38: MINUS multExpr
            	    {
            	    MINUS66=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr560); 
            	    MINUS66_tree = (CommonTree)adaptor.create(MINUS66);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS66_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr563);
            	    multExpr67=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr67.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // src/glossa/interpreter/grammars/Glossa.g:333:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES69=null;
        Token DIA71=null;
        Token DIV73=null;
        Token MOD75=null;
        GlossaParser.powExpr_return powExpr68 = null;

        GlossaParser.powExpr_return powExpr70 = null;

        GlossaParser.powExpr_return powExpr72 = null;

        GlossaParser.powExpr_return powExpr74 = null;

        GlossaParser.powExpr_return powExpr76 = null;


        CommonTree TIMES69_tree=null;
        CommonTree DIA71_tree=null;
        CommonTree DIV73_tree=null;
        CommonTree MOD75_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:333:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:333:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr575);
            powExpr68=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr68.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:333:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop25:
            do {
                int alt25=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt25=1;
                    }
                    break;
                case DIA:
                    {
                    alt25=2;
                    }
                    break;
                case DIV:
                    {
                    alt25=3;
                    }
                    break;
                case MOD:
                    {
                    alt25=4;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:333:21: TIMES powExpr
            	    {
            	    TIMES69=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr578); 
            	    TIMES69_tree = (CommonTree)adaptor.create(TIMES69);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES69_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr581);
            	    powExpr70=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr70.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:333:38: DIA powExpr
            	    {
            	    DIA71=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr585); 
            	    DIA71_tree = (CommonTree)adaptor.create(DIA71);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA71_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr588);
            	    powExpr72=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr72.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:333:53: DIV powExpr
            	    {
            	    DIV73=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr592); 
            	    DIV73_tree = (CommonTree)adaptor.create(DIV73);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV73_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr595);
            	    powExpr74=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr74.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:333:68: MOD powExpr
            	    {
            	    MOD75=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr599); 
            	    MOD75_tree = (CommonTree)adaptor.create(MOD75);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD75_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr602);
            	    powExpr76=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr76.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // src/glossa/interpreter/grammars/Glossa.g:335:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW78=null;
        GlossaParser.unaryExpr_return unaryExpr77 = null;

        GlossaParser.unaryExpr_return unaryExpr79 = null;


        CommonTree POW78_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:335:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:335:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr614);
            unaryExpr77=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr77.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:335:21: ( POW unaryExpr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==POW) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:335:22: POW unaryExpr
            	    {
            	    POW78=(Token)match(input,POW,FOLLOW_POW_in_powExpr617); 
            	    POW78_tree = (CommonTree)adaptor.create(POW78);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW78_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr620);
            	    unaryExpr79=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr79.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // src/glossa/interpreter/grammars/Glossa.g:337:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS80=null;
        Token MINUS82=null;
        Token NOT84=null;
        GlossaParser.atom_return atom81 = null;

        GlossaParser.atom_return atom83 = null;

        GlossaParser.atom_return atom85 = null;

        GlossaParser.atom_return atom86 = null;


        CommonTree PLUS80_tree=null;
        CommonTree MINUS82_tree=null;
        CommonTree NOT84_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:338:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt27=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt27=1;
                }
                break;
            case MINUS:
                {
                alt27=2;
                }
                break;
            case NOT:
                {
                alt27=3;
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
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:338:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS80=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr631); 
                    pushFollow(FOLLOW_atom_in_unaryExpr634);
                    atom81=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom81.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:339:4: MINUS atom
                    {
                    MINUS82=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr639);  
                    stream_MINUS.add(MINUS82);

                    pushFollow(FOLLOW_atom_in_unaryExpr641);
                    atom83=atom();

                    state._fsp--;

                    stream_atom.add(atom83.getTree());


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
                    // 339:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:339:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:340:4: NOT atom
                    {
                    NOT84=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr654);  
                    stream_NOT.add(NOT84);

                    pushFollow(FOLLOW_atom_in_unaryExpr656);
                    atom85=atom();

                    state._fsp--;

                    stream_atom.add(atom85.getTree());


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
                    // 340:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:340:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:341:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr669);
                    atom86=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom86.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:344:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE87=null;
        Token CONST_FALSE88=null;
        Token CONST_STR89=null;
        Token CONST_INT90=null;
        Token CONST_REAL91=null;
        Token ID93=null;
        Token char_literal94=null;
        Token char_literal96=null;
        GlossaParser.arrayItem_return arrayItem92 = null;

        GlossaParser.expr_return expr95 = null;


        CommonTree CONST_TRUE87_tree=null;
        CommonTree CONST_FALSE88_tree=null;
        CommonTree CONST_STR89_tree=null;
        CommonTree CONST_INT90_tree=null;
        CommonTree CONST_REAL91_tree=null;
        CommonTree ID93_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree char_literal96_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:344:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt28=8;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:344:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE87=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom678); 
                    CONST_TRUE87_tree = (CommonTree)adaptor.create(CONST_TRUE87);
                    adaptor.addChild(root_0, CONST_TRUE87_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:345:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE88=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom683); 
                    CONST_FALSE88_tree = (CommonTree)adaptor.create(CONST_FALSE88);
                    adaptor.addChild(root_0, CONST_FALSE88_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:346:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR89=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom688); 
                    CONST_STR89_tree = (CommonTree)adaptor.create(CONST_STR89);
                    adaptor.addChild(root_0, CONST_STR89_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:347:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT90=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom693); 
                    CONST_INT90_tree = (CommonTree)adaptor.create(CONST_INT90);
                    adaptor.addChild(root_0, CONST_INT90_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:348:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL91=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom698); 
                    CONST_REAL91_tree = (CommonTree)adaptor.create(CONST_REAL91);
                    adaptor.addChild(root_0, CONST_REAL91_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:349:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom703);
                    arrayItem92=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem92.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:350:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID93=(Token)match(input,ID,FOLLOW_ID_in_atom708); 
                    ID93_tree = (CommonTree)adaptor.create(ID93);
                    adaptor.addChild(root_0, ID93_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:351:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal94=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom713); 
                    pushFollow(FOLLOW_expr_in_atom716);
                    expr95=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr95.getTree());
                    char_literal96=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom718); 

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
    // src/glossa/interpreter/grammars/Glossa.g:354:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID97=null;
        GlossaParser.arraySubscript_return arraySubscript98 = null;


        CommonTree ID97_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:355:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:355:4: ID arraySubscript
            {
            ID97=(Token)match(input,ID,FOLLOW_ID_in_arrayItem731);  
            stream_ID.add(ID97);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem733);
            arraySubscript98=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript98.getTree());


            // AST REWRITE
            // elements: ID, arraySubscript
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 355:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:355:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:357:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET99=null;
        Token RBRACKET101=null;
        GlossaParser.expr_return expr100 = null;


        CommonTree LBRACKET99_tree=null;
        CommonTree RBRACKET101_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:358:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:358:4: ( LBRACKET expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:358:4: ( LBRACKET expr RBRACKET )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==LBRACKET) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:358:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET99=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript754);  
            	    stream_LBRACKET.add(LBRACKET99);

            	    pushFollow(FOLLOW_expr_in_arraySubscript756);
            	    expr100=expr();

            	    state._fsp--;

            	    stream_expr.add(expr100.getTree());
            	    RBRACKET101=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript758);  
            	    stream_RBRACKET.add(RBRACKET101);


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
            // 358:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:358:33: ^( ARRAY_INDEX ( expr )+ )
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


    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\12\uffff";
    static final String DFA28_minS =
        "\1\14\5\uffff\1\15\3\uffff";
    static final String DFA28_maxS =
        "\1\62\5\uffff\1\63\3\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\6\1\7";
    static final String DFA28_specialS =
        "\12\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\6\37\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\11\3\uffff\1\11\2\uffff\1\11\1\10\1\11\6\uffff\16\11\10"+
            "\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "344:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_program120 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program123 = new BitSet(new long[]{0x0000000000056000L});
    public static final BitSet FOLLOW_declarations_in_program130 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_BEGIN_in_program134 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program139 = new BitSet(new long[]{0x000000000800B000L});
    public static final BitSet FOLLOW_block_in_program146 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program150 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_ID_in_program156 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program161 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_constDecl_in_declarations175 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_varDecl_in_declarations178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl190 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl194 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl199 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ID_in_constAssign209 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EQ_in_constAssign211 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_constAssign214 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign217 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl229 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl233 = new BitSet(new long[]{0x0000000007802002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl238 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_varType_in_varsDecl249 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl252 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl255 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl258 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl261 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl266 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem285 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension307 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension311 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension313 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block358 = new BitSet(new long[]{0x0000000008001002L});
    public static final BitSet FOLLOW_printStm_in_stm377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm391 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm394 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_printStm398 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm401 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm407 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm423 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm425 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm430 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm433 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_eqExpr_in_expr463 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_AND_in_expr466 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr469 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_OR_in_expr473 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr476 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr486 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr489 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr492 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr496 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr499 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr510 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LT_in_compExpr513 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr516 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LE_in_compExpr520 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr523 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GT_in_compExpr527 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr530 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GE_in_compExpr534 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr537 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr550 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr553 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr556 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr560 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr563 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr575 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr578 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr581 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr585 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr588 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr592 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr595 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr599 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr602 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr614 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr617 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr620 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr631 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr639 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr654 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom713 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_atom716 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem731 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript754 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript756 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript758 = new BitSet(new long[]{0x0000000000200002L});

}