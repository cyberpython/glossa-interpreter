// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-20 17:55:19

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "AND", "OR", "NEQ", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "DOUBLE_DOT", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "IF", "THEN", "OMEGA", "OMEGA_TONOS", "ELSE", "ELSE_IF", "END_IF", "XI", "SWITCH", "CASE", "END_SWITCH", "WHILE", "LOOP", "END_LOOP", "REPEAT", "UNTIL", "FOR", "FROM", "TO", "STEP", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=81;
    public static final int LT=33;
    public static final int END_PROCEDURE=78;
    public static final int WHILE=95;
    public static final int LETTER=109;
    public static final int MOD=42;
    public static final int STRINGS=24;
    public static final int LAMDA=67;
    public static final int UPSILON_DIALYTIKA_TONOS=122;
    public static final int CASE=93;
    public static final int NOT=44;
    public static final int OMICRON=57;
    public static final int EOF=-1;
    public static final int DOUBLE_DOT=50;
    public static final int LBRACKET=21;
    public static final int MU=63;
    public static final int TAU=64;
    public static final int POW=43;
    public static final int UPSILON_TONOS=118;
    public static final int LPAR=51;
    public static final int CONT_COMMAND=112;
    public static final int CONST_INT=48;
    public static final int LOOP=96;
    public static final int BEGIN=14;
    public static final int KAPPA=53;
    public static final int EQ=17;
    public static final int COMMENT=111;
    public static final int ARRAY=7;
    public static final int GREEK_LETTER=115;
    public static final int END_LOOP=97;
    public static final int GE=36;
    public static final int END_SWITCH=94;
    public static final int CONST_TRUE=45;
    public static final int NU=80;
    public static final int XI=91;
    public static final int SWITCH=92;
    public static final int ELSE=88;
    public static final int DELTA=74;
    public static final int EPSILON=65;
    public static final int CONST_STR=47;
    public static final int INTEGERS=25;
    public static final int ALPHA=54;
    public static final int SIGMA_TELIKO=68;
    public static final int REAL=105;
    public static final int BOOLEANS=23;
    public static final int THETA=73;
    public static final int UPSILON_DIALYTIKA=120;
    public static final int WS=113;
    public static final int OMICRON_TONOS=58;
    public static final int EPSILON_TONOS=66;
    public static final int READ=28;
    public static final int UNTIL=99;
    public static final int OMEGA=86;
    public static final int OR=31;
    public static final int GT=35;
    public static final int ALPHA_TONOS=69;
    public static final int REPEAT=98;
    public static final int PI=60;
    public static final int CALL=83;
    public static final int FROM=101;
    public static final int PHI=117;
    public static final int RHO=61;
    public static final int UPSILON=79;
    public static final int STEP=103;
    public static final int FOR=100;
    public static final int ETA_TONOS=56;
    public static final int CONSTANTS=16;
    public static final int AND=30;
    public static final int ID=12;
    public static final int ARRAY_DIMENSION=10;
    public static final int IF=84;
    public static final int OMEGA_TONOS=87;
    public static final int NOT_EOL=110;
    public static final int BOOLEAN=107;
    public static final int THEN=85;
    public static final int END_FUNCTION=82;
    public static final int COMMA=20;
    public static final int ETA=71;
    public static final int ARRAY_INDEX=9;
    public static final int PLUS=37;
    public static final int PSI=75;
    public static final int SIGMA=72;
    public static final int DIGIT=108;
    public static final int RBRACKET=22;
    public static final int IOTA_DIALYTIKA_TONOS=121;
    public static final int ELSE_IF=89;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=49;
    public static final int INTEGER=104;
    public static final int TO=102;
    public static final int LATIN_LETTER=114;
    public static final int REALS=26;
    public static final int CHI=59;
    public static final int MINUS=38;
    public static final int DIA=40;
    public static final int BETA=70;
    public static final int PRINT=27;
    public static final int PROCEDURE=77;
    public static final int COLON=19;
    public static final int ARRAY_ITEM=8;
    public static final int NEQ=32;
    public static final int NEWLINE=13;
    public static final int END_PROGRAM=15;
    public static final int ZETA=116;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=46;
    public static final int NEG=5;
    public static final int ASSIGN=29;
    public static final int VARIABLES=18;
    public static final int END_IF=90;
    public static final int PROGRAM=11;
    public static final int RPAR=52;
    public static final int IOTA=55;
    public static final int DIV=41;
    public static final int TIMES=39;
    public static final int GAMMA=62;
    public static final int IOTA_DIALYTIKA=119;
    public static final int LE=34;
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
                    // elements: ID, arrayDimension
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

                if ( (LA16_0==ID||(LA16_0>=PRINT && LA16_0<=READ)) ) {
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
    // src/glossa/interpreter/grammars/Glossa.g:315:1: stm : ( printStm | readStm | assingmentStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.readStm_return readStm36 = null;

        GlossaParser.assingmentStm_return assingmentStm37 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:315:5: ( printStm | readStm | assingmentStm )
            int alt17=3;
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
            default:
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
                    // src/glossa/interpreter/grammars/Glossa.g:316:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm395);
                    readStm36=readStm();

                    state._fsp--;

                    adaptor.addChild(root_0, readStm36.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:317:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm400);
                    assingmentStm37=assingmentStm();

                    state._fsp--;

                    adaptor.addChild(root_0, assingmentStm37.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:319:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT38=null;
        Token char_literal40=null;
        Token NEWLINE42=null;
        GlossaParser.expr_return expr39 = null;

        GlossaParser.expr_return expr41 = null;


        CommonTree PRINT38_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree NEWLINE42_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:320:9: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:320:11: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT38=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm417); 
            PRINT38_tree = (CommonTree)adaptor.create(PRINT38);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT38_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm420);
            expr39=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr39.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:320:23: ( ',' expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:320:25: ',' expr
            	    {
            	    char_literal40=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm424); 
            	    pushFollow(FOLLOW_expr_in_printStm427);
            	    expr41=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr41.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:320:38: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:320:39: NEWLINE
            	    {
            	    NEWLINE42=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm433); 

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
    // src/glossa/interpreter/grammars/Glossa.g:322:1: readStm : ( READ varId= ID ( NEWLINE )+ | READ arrId= ID arraySubscript ( NEWLINE )+ );
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token READ43=null;
        Token NEWLINE44=null;
        Token READ45=null;
        Token NEWLINE47=null;
        GlossaParser.arraySubscript_return arraySubscript46 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree READ43_tree=null;
        CommonTree NEWLINE44_tree=null;
        CommonTree READ45_tree=null;
        CommonTree NEWLINE47_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:322:9: ( READ varId= ID ( NEWLINE )+ | READ arrId= ID arraySubscript ( NEWLINE )+ )
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
                    // src/glossa/interpreter/grammars/Glossa.g:323:17: READ varId= ID ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    READ43=(Token)match(input,READ,FOLLOW_READ_in_readStm461); 
                    READ43_tree = (CommonTree)adaptor.create(READ43);
                    root_0 = (CommonTree)adaptor.becomeRoot(READ43_tree, root_0);

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readStm466); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    // src/glossa/interpreter/grammars/Glossa.g:323:32: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:323:33: NEWLINE
                    	    {
                    	    NEWLINE44=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm469); 

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
                    // src/glossa/interpreter/grammars/Glossa.g:324:17: READ arrId= ID arraySubscript ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    READ45=(Token)match(input,READ,FOLLOW_READ_in_readStm490); 
                    READ45_tree = (CommonTree)adaptor.create(READ45);
                    root_0 = (CommonTree)adaptor.becomeRoot(READ45_tree, root_0);

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readStm495); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_readStm497);
                    arraySubscript46=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript46.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:324:47: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:324:48: NEWLINE
                    	    {
                    	    NEWLINE47=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm500); 

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
    // src/glossa/interpreter/grammars/Glossa.g:327:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN48=null;
        Token NEWLINE49=null;
        Token ASSIGN51=null;
        Token NEWLINE52=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript50 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN48_tree=null;
        CommonTree NEWLINE49_tree=null;
        CommonTree ASSIGN51_tree=null;
        CommonTree NEWLINE52_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:328:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
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
                    // src/glossa/interpreter/grammars/Glossa.g:328:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm524); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    ASSIGN48=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm526); 
                    ASSIGN48_tree = (CommonTree)adaptor.create(ASSIGN48);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN48_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm531);
                    varValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:328:35: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:328:36: NEWLINE
                    	    {
                    	    NEWLINE49=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm534); 

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
                    // src/glossa/interpreter/grammars/Glossa.g:329:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm557); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm559);
                    arraySubscript50=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript50.getTree());
                    ASSIGN51=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm561); 
                    ASSIGN51_tree = (CommonTree)adaptor.create(ASSIGN51);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN51_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm566);
                    arrItemValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:329:67: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:329:68: NEWLINE
                    	    {
                    	    NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm569); 

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

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/Glossa.g:332:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND54=null;
        Token OR56=null;
        GlossaParser.eqExpr_return eqExpr53 = null;

        GlossaParser.eqExpr_return eqExpr55 = null;

        GlossaParser.eqExpr_return eqExpr57 = null;


        CommonTree AND54_tree=null;
        CommonTree OR56_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:332:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:332:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr590);
            eqExpr53=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr53.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:332:15: ( AND eqExpr | OR eqExpr )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==AND) ) {
                    alt26=1;
                }
                else if ( (LA26_0==OR) ) {
                    alt26=2;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:332:16: AND eqExpr
            	    {
            	    AND54=(Token)match(input,AND,FOLLOW_AND_in_expr593); 
            	    AND54_tree = (CommonTree)adaptor.create(AND54);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND54_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr596);
            	    eqExpr55=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr55.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:332:30: OR eqExpr
            	    {
            	    OR56=(Token)match(input,OR,FOLLOW_OR_in_expr600); 
            	    OR56_tree = (CommonTree)adaptor.create(OR56);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR56_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr603);
            	    eqExpr57=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr57.getTree());

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
    // $ANTLR end "expr"

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // src/glossa/interpreter/grammars/Glossa.g:334:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ59=null;
        Token NEQ61=null;
        GlossaParser.compExpr_return compExpr58 = null;

        GlossaParser.compExpr_return compExpr60 = null;

        GlossaParser.compExpr_return compExpr62 = null;


        CommonTree EQ59_tree=null;
        CommonTree NEQ61_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:334:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:334:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr613);
            compExpr58=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr58.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:334:19: ( EQ compExpr | NEQ compExpr )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==EQ) ) {
                    alt27=1;
                }
                else if ( (LA27_0==NEQ) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:334:20: EQ compExpr
            	    {
            	    EQ59=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr616); 
            	    EQ59_tree = (CommonTree)adaptor.create(EQ59);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ59_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr619);
            	    compExpr60=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:334:35: NEQ compExpr
            	    {
            	    NEQ61=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr623); 
            	    NEQ61_tree = (CommonTree)adaptor.create(NEQ61);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ61_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr626);
            	    compExpr62=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr62.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // src/glossa/interpreter/grammars/Glossa.g:336:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT64=null;
        Token LE66=null;
        Token GT68=null;
        Token GE70=null;
        GlossaParser.addExpr_return addExpr63 = null;

        GlossaParser.addExpr_return addExpr65 = null;

        GlossaParser.addExpr_return addExpr67 = null;

        GlossaParser.addExpr_return addExpr69 = null;

        GlossaParser.addExpr_return addExpr71 = null;


        CommonTree LT64_tree=null;
        CommonTree LE66_tree=null;
        CommonTree GT68_tree=null;
        CommonTree GE70_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:336:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:336:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr637);
            addExpr63=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr63.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:336:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop28:
            do {
                int alt28=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt28=1;
                    }
                    break;
                case LE:
                    {
                    alt28=2;
                    }
                    break;
                case GT:
                    {
                    alt28=3;
                    }
                    break;
                case GE:
                    {
                    alt28=4;
                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:336:20: LT addExpr
            	    {
            	    LT64=(Token)match(input,LT,FOLLOW_LT_in_compExpr640); 
            	    LT64_tree = (CommonTree)adaptor.create(LT64);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT64_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr643);
            	    addExpr65=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr65.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:336:34: LE addExpr
            	    {
            	    LE66=(Token)match(input,LE,FOLLOW_LE_in_compExpr647); 
            	    LE66_tree = (CommonTree)adaptor.create(LE66);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE66_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr650);
            	    addExpr67=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr67.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:336:48: GT addExpr
            	    {
            	    GT68=(Token)match(input,GT,FOLLOW_GT_in_compExpr654); 
            	    GT68_tree = (CommonTree)adaptor.create(GT68);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT68_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr657);
            	    addExpr69=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr69.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:336:62: GE addExpr
            	    {
            	    GE70=(Token)match(input,GE,FOLLOW_GE_in_compExpr661); 
            	    GE70_tree = (CommonTree)adaptor.create(GE70);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE70_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr664);
            	    addExpr71=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr71.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // src/glossa/interpreter/grammars/Glossa.g:338:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS73=null;
        Token MINUS75=null;
        GlossaParser.multExpr_return multExpr72 = null;

        GlossaParser.multExpr_return multExpr74 = null;

        GlossaParser.multExpr_return multExpr76 = null;


        CommonTree PLUS73_tree=null;
        CommonTree MINUS75_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:338:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:338:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr677);
            multExpr72=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr72.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:338:20: ( PLUS multExpr | MINUS multExpr )*
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==PLUS) ) {
                    alt29=1;
                }
                else if ( (LA29_0==MINUS) ) {
                    alt29=2;
                }


                switch (alt29) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:338:21: PLUS multExpr
            	    {
            	    PLUS73=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr680); 
            	    PLUS73_tree = (CommonTree)adaptor.create(PLUS73);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS73_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr683);
            	    multExpr74=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr74.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:338:38: MINUS multExpr
            	    {
            	    MINUS75=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr687); 
            	    MINUS75_tree = (CommonTree)adaptor.create(MINUS75);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS75_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr690);
            	    multExpr76=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr76.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // src/glossa/interpreter/grammars/Glossa.g:340:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES78=null;
        Token DIA80=null;
        Token DIV82=null;
        Token MOD84=null;
        GlossaParser.powExpr_return powExpr77 = null;

        GlossaParser.powExpr_return powExpr79 = null;

        GlossaParser.powExpr_return powExpr81 = null;

        GlossaParser.powExpr_return powExpr83 = null;

        GlossaParser.powExpr_return powExpr85 = null;


        CommonTree TIMES78_tree=null;
        CommonTree DIA80_tree=null;
        CommonTree DIV82_tree=null;
        CommonTree MOD84_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:340:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:340:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr702);
            powExpr77=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr77.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:340:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop30:
            do {
                int alt30=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt30=1;
                    }
                    break;
                case DIA:
                    {
                    alt30=2;
                    }
                    break;
                case DIV:
                    {
                    alt30=3;
                    }
                    break;
                case MOD:
                    {
                    alt30=4;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:340:21: TIMES powExpr
            	    {
            	    TIMES78=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr705); 
            	    TIMES78_tree = (CommonTree)adaptor.create(TIMES78);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES78_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr708);
            	    powExpr79=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr79.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:340:38: DIA powExpr
            	    {
            	    DIA80=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr712); 
            	    DIA80_tree = (CommonTree)adaptor.create(DIA80);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA80_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr715);
            	    powExpr81=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr81.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:340:53: DIV powExpr
            	    {
            	    DIV82=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr719); 
            	    DIV82_tree = (CommonTree)adaptor.create(DIV82);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV82_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr722);
            	    powExpr83=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr83.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:340:68: MOD powExpr
            	    {
            	    MOD84=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr726); 
            	    MOD84_tree = (CommonTree)adaptor.create(MOD84);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD84_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr729);
            	    powExpr85=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr85.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // src/glossa/interpreter/grammars/Glossa.g:342:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW87=null;
        GlossaParser.unaryExpr_return unaryExpr86 = null;

        GlossaParser.unaryExpr_return unaryExpr88 = null;


        CommonTree POW87_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:342:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:342:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr741);
            unaryExpr86=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr86.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:342:21: ( POW unaryExpr )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==POW) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:342:22: POW unaryExpr
            	    {
            	    POW87=(Token)match(input,POW,FOLLOW_POW_in_powExpr744); 
            	    POW87_tree = (CommonTree)adaptor.create(POW87);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW87_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr747);
            	    unaryExpr88=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr88.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // src/glossa/interpreter/grammars/Glossa.g:344:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS89=null;
        Token MINUS91=null;
        Token NOT93=null;
        GlossaParser.atom_return atom90 = null;

        GlossaParser.atom_return atom92 = null;

        GlossaParser.atom_return atom94 = null;

        GlossaParser.atom_return atom95 = null;


        CommonTree PLUS89_tree=null;
        CommonTree MINUS91_tree=null;
        CommonTree NOT93_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:345:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt32=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt32=1;
                }
                break;
            case MINUS:
                {
                alt32=2;
                }
                break;
            case NOT:
                {
                alt32=3;
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
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:345:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS89=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr758); 
                    pushFollow(FOLLOW_atom_in_unaryExpr761);
                    atom90=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom90.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:346:4: MINUS atom
                    {
                    MINUS91=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr766);  
                    stream_MINUS.add(MINUS91);

                    pushFollow(FOLLOW_atom_in_unaryExpr768);
                    atom92=atom();

                    state._fsp--;

                    stream_atom.add(atom92.getTree());


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
                    // 346:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:346:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:347:4: NOT atom
                    {
                    NOT93=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr781);  
                    stream_NOT.add(NOT93);

                    pushFollow(FOLLOW_atom_in_unaryExpr783);
                    atom94=atom();

                    state._fsp--;

                    stream_atom.add(atom94.getTree());


                    // AST REWRITE
                    // elements: atom, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 347:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:347:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:348:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr796);
                    atom95=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom95.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:351:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE96=null;
        Token CONST_FALSE97=null;
        Token CONST_STR98=null;
        Token CONST_INT99=null;
        Token CONST_REAL100=null;
        Token ID102=null;
        Token char_literal103=null;
        Token char_literal105=null;
        GlossaParser.arrayItem_return arrayItem101 = null;

        GlossaParser.expr_return expr104 = null;


        CommonTree CONST_TRUE96_tree=null;
        CommonTree CONST_FALSE97_tree=null;
        CommonTree CONST_STR98_tree=null;
        CommonTree CONST_INT99_tree=null;
        CommonTree CONST_REAL100_tree=null;
        CommonTree ID102_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal105_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:351:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt33=8;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:351:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE96=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom805); 
                    CONST_TRUE96_tree = (CommonTree)adaptor.create(CONST_TRUE96);
                    adaptor.addChild(root_0, CONST_TRUE96_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:352:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE97=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom810); 
                    CONST_FALSE97_tree = (CommonTree)adaptor.create(CONST_FALSE97);
                    adaptor.addChild(root_0, CONST_FALSE97_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:353:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR98=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom815); 
                    CONST_STR98_tree = (CommonTree)adaptor.create(CONST_STR98);
                    adaptor.addChild(root_0, CONST_STR98_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:354:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT99=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom820); 
                    CONST_INT99_tree = (CommonTree)adaptor.create(CONST_INT99);
                    adaptor.addChild(root_0, CONST_INT99_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:355:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL100=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom825); 
                    CONST_REAL100_tree = (CommonTree)adaptor.create(CONST_REAL100);
                    adaptor.addChild(root_0, CONST_REAL100_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:356:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom830);
                    arrayItem101=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem101.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:357:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID102=(Token)match(input,ID,FOLLOW_ID_in_atom835); 
                    ID102_tree = (CommonTree)adaptor.create(ID102);
                    adaptor.addChild(root_0, ID102_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:358:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal103=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom840); 
                    pushFollow(FOLLOW_expr_in_atom843);
                    expr104=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr104.getTree());
                    char_literal105=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom845); 

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
    // src/glossa/interpreter/grammars/Glossa.g:361:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID106=null;
        GlossaParser.arraySubscript_return arraySubscript107 = null;


        CommonTree ID106_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:362:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:362:4: ID arraySubscript
            {
            ID106=(Token)match(input,ID,FOLLOW_ID_in_arrayItem858);  
            stream_ID.add(ID106);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem860);
            arraySubscript107=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript107.getTree());


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
            // 362:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:362:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:364:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET108=null;
        Token RBRACKET110=null;
        GlossaParser.expr_return expr109 = null;


        CommonTree LBRACKET108_tree=null;
        CommonTree RBRACKET110_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:365:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:365:4: ( LBRACKET expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:365:4: ( LBRACKET expr RBRACKET )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==LBRACKET) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:365:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET108=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript881);  
            	    stream_LBRACKET.add(LBRACKET108);

            	    pushFollow(FOLLOW_expr_in_arraySubscript883);
            	    expr109=expr();

            	    state._fsp--;

            	    stream_expr.add(expr109.getTree());
            	    RBRACKET110=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript885);  
            	    stream_RBRACKET.add(RBRACKET110);


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
            // 365:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:365:33: ^( ARRAY_INDEX ( expr )+ )
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


    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\12\uffff";
    static final String DFA33_minS =
        "\1\14\5\uffff\1\15\3\uffff";
    static final String DFA33_maxS =
        "\1\63\5\uffff\1\64\3\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\7\1\6";
    static final String DFA33_specialS =
        "\12\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\6\40\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10\3\uffff\1\10\2\uffff\1\10\1\11\1\10\7\uffff\16\10\10"+
            "\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "351:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_program120 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program123 = new BitSet(new long[]{0x0000000000056000L});
    public static final BitSet FOLLOW_declarations_in_program130 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_BEGIN_in_program134 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program139 = new BitSet(new long[]{0x000000001800B000L});
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
    public static final BitSet FOLLOW_EQ_in_constAssign211 = new BitSet(new long[]{0x000BF06000001000L});
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
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension307 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension311 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension313 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block358 = new BitSet(new long[]{0x0000000018001002L});
    public static final BitSet FOLLOW_printStm_in_stm377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm417 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_printStm420 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_printStm424 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_printStm427 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm433 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_READ_in_readStm461 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_readStm466 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm469 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_READ_in_readStm490 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_readStm495 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_readStm497 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm500 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm524 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm526 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm531 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm534 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm557 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm559 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm561 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm566 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm569 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_eqExpr_in_expr590 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_AND_in_expr593 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr596 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_OR_in_expr600 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr603 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr613 = new BitSet(new long[]{0x0000000100020002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr616 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr619 = new BitSet(new long[]{0x0000000100020002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr623 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr626 = new BitSet(new long[]{0x0000000100020002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr637 = new BitSet(new long[]{0x0000001E00000002L});
    public static final BitSet FOLLOW_LT_in_compExpr640 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr643 = new BitSet(new long[]{0x0000001E00000002L});
    public static final BitSet FOLLOW_LE_in_compExpr647 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr650 = new BitSet(new long[]{0x0000001E00000002L});
    public static final BitSet FOLLOW_GT_in_compExpr654 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr657 = new BitSet(new long[]{0x0000001E00000002L});
    public static final BitSet FOLLOW_GE_in_compExpr661 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr664 = new BitSet(new long[]{0x0000001E00000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr677 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr680 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr683 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr687 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr690 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr702 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr705 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr708 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr712 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr715 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr719 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr722 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr726 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr729 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr741 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr744 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr747 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr758 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr766 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr781 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom840 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_atom843 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem858 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript881 = new BitSet(new long[]{0x000BF06000001000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript883 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript885 = new BitSet(new long[]{0x0000000000200002L});

}