// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-22 15:05:48

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "DOUBLE_DOT", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "SWITCH", "CASE", "END_SWITCH", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=96;
    public static final int LT=48;
    public static final int END_PROCEDURE=93;
    public static final int WHILE=41;
    public static final int LETTER=110;
    public static final int MOD=57;
    public static final int STRINGS=25;
    public static final int LAMDA=82;
    public static final int UPSILON_DIALYTIKA_TONOS=123;
    public static final int CASE=103;
    public static final int NOT=59;
    public static final int OMICRON=72;
    public static final int EOF=-1;
    public static final int DOUBLE_DOT=65;
    public static final int LBRACKET=22;
    public static final int MU=78;
    public static final int TAU=79;
    public static final int POW=58;
    public static final int UPSILON_TONOS=119;
    public static final int LPAR=66;
    public static final int CONT_COMMAND=113;
    public static final int CONST_INT=63;
    public static final int LOOP=42;
    public static final int BEGIN=15;
    public static final int KAPPA=68;
    public static final int EQ=18;
    public static final int COMMENT=112;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=116;
    public static final int END_LOOP=40;
    public static final int GE=51;
    public static final int END_SWITCH=104;
    public static final int NU=95;
    public static final int CONST_TRUE=60;
    public static final int XI=101;
    public static final int SWITCH=102;
    public static final int ELSE=34;
    public static final int DELTA=89;
    public static final int EPSILON=80;
    public static final int CONST_STR=62;
    public static final int INTEGERS=26;
    public static final int ALPHA=69;
    public static final int SIGMA_TELIKO=83;
    public static final int REAL=106;
    public static final int BOOLEANS=24;
    public static final int THETA=88;
    public static final int UPSILON_DIALYTIKA=121;
    public static final int WS=114;
    public static final int OMICRON_TONOS=73;
    public static final int EPSILON_TONOS=81;
    public static final int READ=29;
    public static final int OMEGA=99;
    public static final int UNTIL=44;
    public static final int OR=45;
    public static final int GT=50;
    public static final int ALPHA_TONOS=84;
    public static final int REPEAT=43;
    public static final int CALL=98;
    public static final int PI=75;
    public static final int FROM=37;
    public static final int PHI=118;
    public static final int RHO=76;
    public static final int UPSILON=94;
    public static final int STEP=39;
    public static final int FOR=36;
    public static final int ETA_TONOS=71;
    public static final int CONSTANTS=17;
    public static final int ID=13;
    public static final int AND=46;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=32;
    public static final int OMEGA_TONOS=100;
    public static final int NOT_EOL=111;
    public static final int BOOLEAN=108;
    public static final int THEN=33;
    public static final int END_FUNCTION=97;
    public static final int COMMA=21;
    public static final int ETA=86;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PLUS=52;
    public static final int PSI=90;
    public static final int SIGMA=87;
    public static final int DIGIT=109;
    public static final int RBRACKET=23;
    public static final int IOTA_DIALYTIKA_TONOS=122;
    public static final int ELSE_IF=35;
    public static final int VARSDECL=6;
    public static final int CONST_REAL=64;
    public static final int INTEGER=105;
    public static final int TO=38;
    public static final int LATIN_LETTER=115;
    public static final int REALS=27;
    public static final int CHI=74;
    public static final int MINUS=53;
    public static final int DIA=55;
    public static final int BETA=85;
    public static final int PROCEDURE=92;
    public static final int PRINT=28;
    public static final int COLON=20;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=47;
    public static final int NEWLINE=14;
    public static final int END_PROGRAM=16;
    public static final int ZETA=117;
    public static final int BLOCK=4;
    public static final int CONST_FALSE=61;
    public static final int NEG=5;
    public static final int ASSIGN=30;
    public static final int VARIABLES=19;
    public static final int END_IF=31;
    public static final int PROGRAM=12;
    public static final int RPAR=67;
    public static final int IOTA=70;
    public static final int DIV=56;
    public static final int TIMES=54;
    public static final int GAMMA=77;
    public static final int IOTA_DIALYTIKA=120;
    public static final int LE=49;
    public static final int STRING=107;
    public static final int IOTA_TONOS=91;

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
    // src/glossa/interpreter/grammars/Glossa.g:281:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:281:6: ( program )
            // src/glossa/interpreter/grammars/Glossa.g:281:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit121);
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
    // src/glossa/interpreter/grammars/Glossa.g:283:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:283:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:283:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program129); 
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);

            id1=(Token)match(input,ID,FOLLOW_ID_in_program134); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            // src/glossa/interpreter/grammars/Glossa.g:283:27: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:283:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program137); 

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

            pushFollow(FOLLOW_declarations_in_program144);
            declarations4=declarations();

            state._fsp--;

            adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program148); 
            // src/glossa/interpreter/grammars/Glossa.g:285:11: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:285:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program153); 

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

            pushFollow(FOLLOW_block_in_program160);
            block7=block();

            state._fsp--;

            adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program164); 
            // src/glossa/interpreter/grammars/Glossa.g:287:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:287:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program170); 
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:287:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:287:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program175); 

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
    // src/glossa/interpreter/grammars/Glossa.g:289:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:290:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/Glossa.g:290:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/interpreter/grammars/Glossa.g:290:4: ( constDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANTS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:290:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations189);
                    constDecl10=constDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, constDecl10.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:290:15: ( varDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:290:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations192);
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
    // src/glossa/interpreter/grammars/Glossa.g:292:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:293:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/interpreter/grammars/Glossa.g:293:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl204); 
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:293:15: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:293:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl208); 

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

            // src/glossa/interpreter/grammars/Glossa.g:293:27: ( constAssign )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:293:27: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl213);
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
    // src/glossa/interpreter/grammars/Glossa.g:295:1: constAssign : ID EQ expr ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:296:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:296:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign223); 
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign225); 
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);

            pushFollow(FOLLOW_expr_in_constAssign228);
            expr17=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr17.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:296:16: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:296:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign231); 

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
    // src/glossa/interpreter/grammars/Glossa.g:298:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:298:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/interpreter/grammars/Glossa.g:298:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl243); 
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:298:22: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:298:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl247); 

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

            // src/glossa/interpreter/grammars/Glossa.g:298:34: ( varsDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=BOOLEANS && LA11_0<=REALS)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:298:34: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl252);
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
    // src/glossa/interpreter/grammars/Glossa.g:300:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:301:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:301:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl263);
            varType22=varType();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl266); 
            pushFollow(FOLLOW_varDeclItem_in_varsDecl269);
            varDeclItem24=varDeclItem();

            state._fsp--;

            adaptor.addChild(root_0, varDeclItem24.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:301:32: ( COMMA varDeclItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:301:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl272); 
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl275);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:301:54: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:301:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl280); 

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
    // src/glossa/interpreter/grammars/Glossa.g:303:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
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
            // src/glossa/interpreter/grammars/Glossa.g:304:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/Glossa.g:304:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem292); 
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:305:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem299);  
                    stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem301);
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
                    // 305:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:305:26: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/Glossa.g:307:1: arrayDimension : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:308:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:308:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension320);  
            stream_LBRACKET.add(LBRACKET31);

            // src/glossa/interpreter/grammars/Glossa.g:308:13: (dimension+= expr )
            // src/glossa/interpreter/grammars/Glossa.g:308:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arrayDimension325);
            dimension=expr();

            state._fsp--;

            stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/interpreter/grammars/Glossa.g:308:31: ( COMMA dimension+= expr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:308:32: COMMA dimension+= expr
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayDimension329);  
            	    stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_expr_in_arrayDimension333);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RBRACKET33=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension337);  
            stream_RBRACKET.add(RBRACKET33);



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
            // 308:65: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:308:68: ^( ARRAY_DIMENSION ( expr )+ )
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
    // src/glossa/interpreter/grammars/Glossa.g:310:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set34=null;

        CommonTree set34_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:310:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/interpreter/grammars/Glossa.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set34=(Token)input.LT(1);
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set34));
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
    // src/glossa/interpreter/grammars/Glossa.g:315:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm35 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:315:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/Glossa.g:315:9: ( stm )*
            {
            // src/glossa/interpreter/grammars/Glossa.g:315:9: ( stm )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||(LA16_0>=PRINT && LA16_0<=READ)||LA16_0==IF||LA16_0==FOR||LA16_0==WHILE||LA16_0==REPEAT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:315:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block380);
            	    stm35=stm();

            	    state._fsp--;

            	    stream_stm.add(stm35.getTree());

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
            // 315:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/interpreter/grammars/Glossa.g:315:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/interpreter/grammars/Glossa.g:315:26: ( stm )*
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
    // src/glossa/interpreter/grammars/Glossa.g:317:1: stm : ( printStm | readStm | assingmentStm | ifStm | forStm | whileStm | repeatStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm36 = null;

        GlossaParser.readStm_return readStm37 = null;

        GlossaParser.assingmentStm_return assingmentStm38 = null;

        GlossaParser.ifStm_return ifStm39 = null;

        GlossaParser.forStm_return forStm40 = null;

        GlossaParser.whileStm_return whileStm41 = null;

        GlossaParser.repeatStm_return repeatStm42 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:317:5: ( printStm | readStm | assingmentStm | ifStm | forStm | whileStm | repeatStm )
            int alt17=7;
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
            case FOR:
                {
                alt17=5;
                }
                break;
            case WHILE:
                {
                alt17=6;
                }
                break;
            case REPEAT:
                {
                alt17=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:317:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm399);
                    printStm36=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm36.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:318:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm417);
                    readStm37=readStm();

                    state._fsp--;

                    adaptor.addChild(root_0, readStm37.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:319:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm422);
                    assingmentStm38=assingmentStm();

                    state._fsp--;

                    adaptor.addChild(root_0, assingmentStm38.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:320:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm440);
                    ifStm39=ifStm();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStm39.getTree());

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:321:17: forStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forStm_in_stm458);
                    forStm40=forStm();

                    state._fsp--;

                    adaptor.addChild(root_0, forStm40.getTree());

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:322:17: whileStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileStm_in_stm476);
                    whileStm41=whileStm();

                    state._fsp--;

                    adaptor.addChild(root_0, whileStm41.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:323:17: repeatStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeatStm_in_stm494);
                    repeatStm42=repeatStm();

                    state._fsp--;

                    adaptor.addChild(root_0, repeatStm42.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:326:1: printStm : PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ ;
    public final GlossaParser.printStm_return printStm() throws RecognitionException {
        GlossaParser.printStm_return retval = new GlossaParser.printStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRINT43=null;
        Token char_literal45=null;
        Token NEWLINE47=null;
        GlossaParser.expr_return expr44 = null;

        GlossaParser.expr_return expr46 = null;


        CommonTree PRINT43_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree NEWLINE47_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:327:9: ( PRINT ( expr ( ',' expr )* )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:327:11: PRINT ( expr ( ',' expr )* )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT43=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm520); 
            PRINT43_tree = (CommonTree)adaptor.create(PRINT43);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT43_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:327:18: ( expr ( ',' expr )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID||(LA19_0>=PLUS && LA19_0<=MINUS)||(LA19_0>=NOT && LA19_0<=CONST_REAL)||LA19_0==LPAR) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:327:19: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_printStm524);
                    expr44=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr44.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:327:24: ( ',' expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==COMMA) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/Glossa.g:327:26: ',' expr
                    	    {
                    	    char_literal45=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm528); 
                    	    pushFollow(FOLLOW_expr_in_printStm531);
                    	    expr46=expr();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expr46.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:327:41: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:327:42: NEWLINE
            	    {
            	    NEWLINE47=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm539); 

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
    // $ANTLR end "printStm"

    public static class readStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readStm"
    // src/glossa/interpreter/grammars/Glossa.g:329:1: readStm : READ readItem ( COMMA readItem )* ( NEWLINE )+ ;
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ48=null;
        Token COMMA50=null;
        Token NEWLINE52=null;
        GlossaParser.readItem_return readItem49 = null;

        GlossaParser.readItem_return readItem51 = null;


        CommonTree READ48_tree=null;
        CommonTree COMMA50_tree=null;
        CommonTree NEWLINE52_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:329:9: ( READ readItem ( COMMA readItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:330:17: READ readItem ( COMMA readItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            READ48=(Token)match(input,READ,FOLLOW_READ_in_readStm567); 
            READ48_tree = (CommonTree)adaptor.create(READ48);
            root_0 = (CommonTree)adaptor.becomeRoot(READ48_tree, root_0);

            pushFollow(FOLLOW_readItem_in_readStm570);
            readItem49=readItem();

            state._fsp--;

            adaptor.addChild(root_0, readItem49.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:330:32: ( COMMA readItem )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:330:33: COMMA readItem
            	    {
            	    COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_readStm573); 
            	    pushFollow(FOLLOW_readItem_in_readStm576);
            	    readItem51=readItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, readItem51.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:330:51: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:330:52: NEWLINE
            	    {
            	    NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm581); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // $ANTLR end "readStm"

    public static class readItem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "readItem"
    // src/glossa/interpreter/grammars/Glossa.g:333:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final GlossaParser.readItem_return readItem() throws RecognitionException {
        GlossaParser.readItem_return retval = new GlossaParser.readItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token arrId=null;
        Token varId=null;
        GlossaParser.arraySubscript_return arraySubscript53 = null;


        CommonTree arrId_tree=null;
        CommonTree varId_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:333:9: (arrId= ID arraySubscript | varId= ID )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==LBRACKET) ) {
                    alt23=1;
                }
                else if ( (LA23_1==NEWLINE||LA23_1==COMMA) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:334:17: arrId= ID arraySubscript
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readItem618); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_readItem620);
                    arraySubscript53=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript53.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:335:17: varId= ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readItem640); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);


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
    // $ANTLR end "readItem"

    public static class assingmentStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assingmentStm"
    // src/glossa/interpreter/grammars/Glossa.g:338:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN54=null;
        Token NEWLINE55=null;
        Token ASSIGN57=null;
        Token NEWLINE58=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript56 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN54_tree=null;
        CommonTree NEWLINE55_tree=null;
        CommonTree ASSIGN57_tree=null;
        CommonTree NEWLINE58_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:339:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
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
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:339:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm661); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    ASSIGN54=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm663); 
                    ASSIGN54_tree = (CommonTree)adaptor.create(ASSIGN54);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN54_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm668);
                    varValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:339:35: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:339:36: NEWLINE
                    	    {
                    	    NEWLINE55=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm671); 

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
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:340:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm694); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm696);
                    arraySubscript56=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript56.getTree());
                    ASSIGN57=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm698); 
                    ASSIGN57_tree = (CommonTree)adaptor.create(ASSIGN57);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN57_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm703);
                    arrItemValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:340:67: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:340:68: NEWLINE
                    	    {
                    	    NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm706); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
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
    // src/glossa/interpreter/grammars/Glossa.g:343:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF62=null;
        Token NEWLINE63=null;
        GlossaParser.ifBlock_return ifBlock59 = null;

        GlossaParser.elseIfBlock_return elseIfBlock60 = null;

        GlossaParser.elseBlock_return elseBlock61 = null;


        CommonTree END_IF62_tree=null;
        CommonTree NEWLINE63_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:343:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/interpreter/grammars/Glossa.g:343:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm726);
            ifBlock59=ifBlock();

            state._fsp--;

            stream_ifBlock.add(ifBlock59.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:343:17: ( elseIfBlock )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==ELSE_IF) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:343:17: elseIfBlock
            	    {
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm728);
            	    elseIfBlock60=elseIfBlock();

            	    state._fsp--;

            	    stream_elseIfBlock.add(elseIfBlock60.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:343:30: ( elseBlock )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==ELSE) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:343:30: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm731);
                    elseBlock61=elseBlock();

                    state._fsp--;

                    stream_elseBlock.add(elseBlock61.getTree());

                    }
                    break;

            }

            END_IF62=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm734);  
            stream_END_IF.add(END_IF62);

            // src/glossa/interpreter/grammars/Glossa.g:343:48: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:343:49: NEWLINE
            	    {
            	    NEWLINE63=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm737);  
            	    stream_NEWLINE.add(NEWLINE63);


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
            // elements: elseIfBlock, elseBlock, ifBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 343:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/interpreter/grammars/Glossa.g:343:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/interpreter/grammars/Glossa.g:343:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/interpreter/grammars/Glossa.g:343:92: ( elseBlock )?
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
    // src/glossa/interpreter/grammars/Glossa.g:345:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF64=null;
        Token THEN66=null;
        Token NEWLINE67=null;
        GlossaParser.expr_return expr65 = null;

        GlossaParser.block_return block68 = null;


        CommonTree IF64_tree=null;
        CommonTree THEN66_tree=null;
        CommonTree NEWLINE67_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:345:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:345:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF64=(Token)match(input,IF,FOLLOW_IF_in_ifBlock761); 
            IF64_tree = (CommonTree)adaptor.create(IF64);
            root_0 = (CommonTree)adaptor.becomeRoot(IF64_tree, root_0);

            pushFollow(FOLLOW_expr_in_ifBlock764);
            expr65=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr65.getTree());
            THEN66=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock766); 
            // src/glossa/interpreter/grammars/Glossa.g:345:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:345:27: NEWLINE
            	    {
            	    NEWLINE67=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock770); 

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

            pushFollow(FOLLOW_block_in_ifBlock775);
            block68=block();

            state._fsp--;

            adaptor.addChild(root_0, block68.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:347:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE69=null;
        Token NEWLINE70=null;
        GlossaParser.block_return block71 = null;


        CommonTree ELSE69_tree=null;
        CommonTree NEWLINE70_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:348:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:348:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE69=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock784); 
            ELSE69_tree = (CommonTree)adaptor.create(ELSE69);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE69_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:348:10: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:348:11: NEWLINE
            	    {
            	    NEWLINE70=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock788); 

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

            pushFollow(FOLLOW_block_in_elseBlock793);
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
    // $ANTLR end "elseBlock"

    public static class elseIfBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseIfBlock"
    // src/glossa/interpreter/grammars/Glossa.g:350:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF72=null;
        Token THEN74=null;
        Token NEWLINE75=null;
        GlossaParser.expr_return expr73 = null;

        GlossaParser.block_return block76 = null;


        CommonTree ELSE_IF72_tree=null;
        CommonTree THEN74_tree=null;
        CommonTree NEWLINE75_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:351:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:351:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF72=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock802); 
            ELSE_IF72_tree = (CommonTree)adaptor.create(ELSE_IF72);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF72_tree, root_0);

            pushFollow(FOLLOW_expr_in_elseIfBlock805);
            expr73=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr73.getTree());
            THEN74=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock807); 
            // src/glossa/interpreter/grammars/Glossa.g:351:24: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:351:25: NEWLINE
            	    {
            	    NEWLINE75=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock811); 

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            pushFollow(FOLLOW_block_in_elseIfBlock816);
            block76=block();

            state._fsp--;

            adaptor.addChild(root_0, block76.getTree());

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

    public static class forStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStm"
    // src/glossa/interpreter/grammars/Glossa.g:353:1: forStm : FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.forStm_return forStm() throws RecognitionException {
        GlossaParser.forStm_return retval = new GlossaParser.forStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR77=null;
        Token ID78=null;
        Token FROM79=null;
        Token TO80=null;
        Token STEP81=null;
        Token NEWLINE82=null;
        Token END_LOOP84=null;
        Token NEWLINE85=null;
        GlossaParser.expr_return from = null;

        GlossaParser.expr_return to = null;

        GlossaParser.expr_return step = null;

        GlossaParser.block_return block83 = null;


        CommonTree FOR77_tree=null;
        CommonTree ID78_tree=null;
        CommonTree FROM79_tree=null;
        CommonTree TO80_tree=null;
        CommonTree STEP81_tree=null;
        CommonTree NEWLINE82_tree=null;
        CommonTree END_LOOP84_tree=null;
        CommonTree NEWLINE85_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:353:8: ( FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:353:10: FOR ID FROM from= expr TO to= expr ( STEP step= expr )? ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            FOR77=(Token)match(input,FOR,FOLLOW_FOR_in_forStm824); 
            FOR77_tree = (CommonTree)adaptor.create(FOR77);
            root_0 = (CommonTree)adaptor.becomeRoot(FOR77_tree, root_0);

            ID78=(Token)match(input,ID,FOLLOW_ID_in_forStm827); 
            ID78_tree = (CommonTree)adaptor.create(ID78);
            adaptor.addChild(root_0, ID78_tree);

            FROM79=(Token)match(input,FROM,FOLLOW_FROM_in_forStm829); 
            pushFollow(FOLLOW_expr_in_forStm834);
            from=expr();

            state._fsp--;

            adaptor.addChild(root_0, from.getTree());
            TO80=(Token)match(input,TO,FOLLOW_TO_in_forStm836); 
            pushFollow(FOLLOW_expr_in_forStm841);
            to=expr();

            state._fsp--;

            adaptor.addChild(root_0, to.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:353:46: ( STEP step= expr )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==STEP) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:353:47: STEP step= expr
                    {
                    STEP81=(Token)match(input,STEP,FOLLOW_STEP_in_forStm844); 
                    pushFollow(FOLLOW_expr_in_forStm849);
                    step=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, step.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:353:65: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:353:66: NEWLINE
            	    {
            	    NEWLINE82=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm854); 

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

            pushFollow(FOLLOW_block_in_forStm859);
            block83=block();

            state._fsp--;

            adaptor.addChild(root_0, block83.getTree());
            END_LOOP84=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_forStm861); 
            // src/glossa/interpreter/grammars/Glossa.g:353:93: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:353:94: NEWLINE
            	    {
            	    NEWLINE85=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_forStm865); 

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
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
    // $ANTLR end "forStm"

    public static class whileStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStm"
    // src/glossa/interpreter/grammars/Glossa.g:355:1: whileStm : WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ ;
    public final GlossaParser.whileStm_return whileStm() throws RecognitionException {
        GlossaParser.whileStm_return retval = new GlossaParser.whileStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE86=null;
        Token LOOP88=null;
        Token NEWLINE89=null;
        Token END_LOOP91=null;
        Token NEWLINE92=null;
        GlossaParser.expr_return expr87 = null;

        GlossaParser.block_return block90 = null;


        CommonTree WHILE86_tree=null;
        CommonTree LOOP88_tree=null;
        CommonTree NEWLINE89_tree=null;
        CommonTree END_LOOP91_tree=null;
        CommonTree NEWLINE92_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:356:9: ( WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:356:11: WHILE expr LOOP ( NEWLINE )+ block END_LOOP ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            WHILE86=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStm884); 
            WHILE86_tree = (CommonTree)adaptor.create(WHILE86);
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE86_tree, root_0);

            pushFollow(FOLLOW_expr_in_whileStm887);
            expr87=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr87.getTree());
            LOOP88=(Token)match(input,LOOP,FOLLOW_LOOP_in_whileStm889); 
            // src/glossa/interpreter/grammars/Glossa.g:356:29: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:356:30: NEWLINE
            	    {
            	    NEWLINE89=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm893); 

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            pushFollow(FOLLOW_block_in_whileStm898);
            block90=block();

            state._fsp--;

            adaptor.addChild(root_0, block90.getTree());
            END_LOOP91=(Token)match(input,END_LOOP,FOLLOW_END_LOOP_in_whileStm900); 
            // src/glossa/interpreter/grammars/Glossa.g:356:57: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:356:58: NEWLINE
            	    {
            	    NEWLINE92=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_whileStm904); 

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
    // $ANTLR end "whileStm"

    public static class repeatStm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeatStm"
    // src/glossa/interpreter/grammars/Glossa.g:358:1: repeatStm : REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ ;
    public final GlossaParser.repeatStm_return repeatStm() throws RecognitionException {
        GlossaParser.repeatStm_return retval = new GlossaParser.repeatStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REPEAT93=null;
        Token NEWLINE94=null;
        Token UNTIL96=null;
        Token NEWLINE98=null;
        GlossaParser.block_return block95 = null;

        GlossaParser.expr_return expr97 = null;


        CommonTree REPEAT93_tree=null;
        CommonTree NEWLINE94_tree=null;
        CommonTree UNTIL96_tree=null;
        CommonTree NEWLINE98_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:359:2: ( REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:359:4: REPEAT ( NEWLINE )+ block UNTIL expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            REPEAT93=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeatStm916); 
            REPEAT93_tree = (CommonTree)adaptor.create(REPEAT93);
            root_0 = (CommonTree)adaptor.becomeRoot(REPEAT93_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:359:12: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:359:13: NEWLINE
            	    {
            	    NEWLINE94=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm920); 

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            pushFollow(FOLLOW_block_in_repeatStm925);
            block95=block();

            state._fsp--;

            adaptor.addChild(root_0, block95.getTree());
            UNTIL96=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_repeatStm927); 
            pushFollow(FOLLOW_expr_in_repeatStm930);
            expr97=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr97.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:359:42: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:359:43: NEWLINE
            	    {
            	    NEWLINE98=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeatStm933); 

            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
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
    // $ANTLR end "repeatStm"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/Glossa.g:361:1: expr : andExpr ( OR andExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR100=null;
        GlossaParser.andExpr_return andExpr99 = null;

        GlossaParser.andExpr_return andExpr101 = null;


        CommonTree OR100_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:361:6: ( andExpr ( OR andExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:361:8: andExpr ( OR andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_expr945);
            andExpr99=andExpr();

            state._fsp--;

            adaptor.addChild(root_0, andExpr99.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:361:16: ( OR andExpr )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==OR) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:361:18: OR andExpr
            	    {
            	    OR100=(Token)match(input,OR,FOLLOW_OR_in_expr949); 
            	    OR100_tree = (CommonTree)adaptor.create(OR100);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR100_tree, root_0);

            	    pushFollow(FOLLOW_andExpr_in_expr952);
            	    andExpr101=andExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, andExpr101.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
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

    public static class andExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // src/glossa/interpreter/grammars/Glossa.g:363:1: andExpr : eqExpr ( AND eqExpr )* ;
    public final GlossaParser.andExpr_return andExpr() throws RecognitionException {
        GlossaParser.andExpr_return retval = new GlossaParser.andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND103=null;
        GlossaParser.eqExpr_return eqExpr102 = null;

        GlossaParser.eqExpr_return eqExpr104 = null;


        CommonTree AND103_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:363:9: ( eqExpr ( AND eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:363:17: eqExpr ( AND eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_andExpr968);
            eqExpr102=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr102.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:363:24: ( AND eqExpr )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==AND) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:363:25: AND eqExpr
            	    {
            	    AND103=(Token)match(input,AND,FOLLOW_AND_in_andExpr971); 
            	    AND103_tree = (CommonTree)adaptor.create(AND103);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND103_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_andExpr974);
            	    eqExpr104=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr104.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end "andExpr"

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // src/glossa/interpreter/grammars/Glossa.g:365:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ106=null;
        Token NEQ108=null;
        GlossaParser.compExpr_return compExpr105 = null;

        GlossaParser.compExpr_return compExpr107 = null;

        GlossaParser.compExpr_return compExpr109 = null;


        CommonTree EQ106_tree=null;
        CommonTree NEQ108_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:365:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:365:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr984);
            compExpr105=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr105.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:365:19: ( EQ compExpr | NEQ compExpr )*
            loop42:
            do {
                int alt42=3;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==EQ) ) {
                    alt42=1;
                }
                else if ( (LA42_0==NEQ) ) {
                    alt42=2;
                }


                switch (alt42) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:365:20: EQ compExpr
            	    {
            	    EQ106=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr987); 
            	    EQ106_tree = (CommonTree)adaptor.create(EQ106);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ106_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr990);
            	    compExpr107=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr107.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:365:35: NEQ compExpr
            	    {
            	    NEQ108=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr994); 
            	    NEQ108_tree = (CommonTree)adaptor.create(NEQ108);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ108_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr997);
            	    compExpr109=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr109.getTree());

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // src/glossa/interpreter/grammars/Glossa.g:367:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT111=null;
        Token LE113=null;
        Token GT115=null;
        Token GE117=null;
        GlossaParser.addExpr_return addExpr110 = null;

        GlossaParser.addExpr_return addExpr112 = null;

        GlossaParser.addExpr_return addExpr114 = null;

        GlossaParser.addExpr_return addExpr116 = null;

        GlossaParser.addExpr_return addExpr118 = null;


        CommonTree LT111_tree=null;
        CommonTree LE113_tree=null;
        CommonTree GT115_tree=null;
        CommonTree GE117_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:367:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:367:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr1008);
            addExpr110=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr110.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:367:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop43:
            do {
                int alt43=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt43=1;
                    }
                    break;
                case LE:
                    {
                    alt43=2;
                    }
                    break;
                case GT:
                    {
                    alt43=3;
                    }
                    break;
                case GE:
                    {
                    alt43=4;
                    }
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:367:20: LT addExpr
            	    {
            	    LT111=(Token)match(input,LT,FOLLOW_LT_in_compExpr1011); 
            	    LT111_tree = (CommonTree)adaptor.create(LT111);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT111_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr1014);
            	    addExpr112=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr112.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:367:34: LE addExpr
            	    {
            	    LE113=(Token)match(input,LE,FOLLOW_LE_in_compExpr1018); 
            	    LE113_tree = (CommonTree)adaptor.create(LE113);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE113_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr1021);
            	    addExpr114=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr114.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:367:48: GT addExpr
            	    {
            	    GT115=(Token)match(input,GT,FOLLOW_GT_in_compExpr1025); 
            	    GT115_tree = (CommonTree)adaptor.create(GT115);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT115_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr1028);
            	    addExpr116=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr116.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:367:62: GE addExpr
            	    {
            	    GE117=(Token)match(input,GE,FOLLOW_GE_in_compExpr1032); 
            	    GE117_tree = (CommonTree)adaptor.create(GE117);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE117_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr1035);
            	    addExpr118=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr118.getTree());

            	    }
            	    break;

            	default :
            	    break loop43;
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
    // src/glossa/interpreter/grammars/Glossa.g:369:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS120=null;
        Token MINUS122=null;
        GlossaParser.multExpr_return multExpr119 = null;

        GlossaParser.multExpr_return multExpr121 = null;

        GlossaParser.multExpr_return multExpr123 = null;


        CommonTree PLUS120_tree=null;
        CommonTree MINUS122_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:369:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:369:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr1048);
            multExpr119=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr119.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:369:20: ( PLUS multExpr | MINUS multExpr )*
            loop44:
            do {
                int alt44=3;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==PLUS) ) {
                    alt44=1;
                }
                else if ( (LA44_0==MINUS) ) {
                    alt44=2;
                }


                switch (alt44) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:369:21: PLUS multExpr
            	    {
            	    PLUS120=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr1051); 
            	    PLUS120_tree = (CommonTree)adaptor.create(PLUS120);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS120_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr1054);
            	    multExpr121=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr121.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:369:38: MINUS multExpr
            	    {
            	    MINUS122=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr1058); 
            	    MINUS122_tree = (CommonTree)adaptor.create(MINUS122);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS122_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr1061);
            	    multExpr123=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr123.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // src/glossa/interpreter/grammars/Glossa.g:371:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES125=null;
        Token DIA127=null;
        Token DIV129=null;
        Token MOD131=null;
        GlossaParser.powExpr_return powExpr124 = null;

        GlossaParser.powExpr_return powExpr126 = null;

        GlossaParser.powExpr_return powExpr128 = null;

        GlossaParser.powExpr_return powExpr130 = null;

        GlossaParser.powExpr_return powExpr132 = null;


        CommonTree TIMES125_tree=null;
        CommonTree DIA127_tree=null;
        CommonTree DIV129_tree=null;
        CommonTree MOD131_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:371:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:371:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr1073);
            powExpr124=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr124.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:371:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop45:
            do {
                int alt45=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt45=1;
                    }
                    break;
                case DIA:
                    {
                    alt45=2;
                    }
                    break;
                case DIV:
                    {
                    alt45=3;
                    }
                    break;
                case MOD:
                    {
                    alt45=4;
                    }
                    break;

                }

                switch (alt45) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:371:21: TIMES powExpr
            	    {
            	    TIMES125=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr1076); 
            	    TIMES125_tree = (CommonTree)adaptor.create(TIMES125);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES125_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr1079);
            	    powExpr126=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr126.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:371:38: DIA powExpr
            	    {
            	    DIA127=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr1083); 
            	    DIA127_tree = (CommonTree)adaptor.create(DIA127);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA127_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr1086);
            	    powExpr128=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr128.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:371:53: DIV powExpr
            	    {
            	    DIV129=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr1090); 
            	    DIV129_tree = (CommonTree)adaptor.create(DIV129);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV129_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr1093);
            	    powExpr130=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr130.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:371:68: MOD powExpr
            	    {
            	    MOD131=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr1097); 
            	    MOD131_tree = (CommonTree)adaptor.create(MOD131);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD131_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr1100);
            	    powExpr132=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr132.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
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
    // src/glossa/interpreter/grammars/Glossa.g:373:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW134=null;
        GlossaParser.unaryExpr_return unaryExpr133 = null;

        GlossaParser.unaryExpr_return unaryExpr135 = null;


        CommonTree POW134_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:373:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:373:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr1112);
            unaryExpr133=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr133.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:373:21: ( POW unaryExpr )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==POW) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:373:22: POW unaryExpr
            	    {
            	    POW134=(Token)match(input,POW,FOLLOW_POW_in_powExpr1115); 
            	    POW134_tree = (CommonTree)adaptor.create(POW134);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW134_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr1118);
            	    unaryExpr135=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr135.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // src/glossa/interpreter/grammars/Glossa.g:375:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS136=null;
        Token MINUS138=null;
        Token NOT140=null;
        GlossaParser.atom_return atom137 = null;

        GlossaParser.atom_return atom139 = null;

        GlossaParser.atom_return atom141 = null;

        GlossaParser.atom_return atom142 = null;


        CommonTree PLUS136_tree=null;
        CommonTree MINUS138_tree=null;
        CommonTree NOT140_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:376:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt47=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt47=1;
                }
                break;
            case MINUS:
                {
                alt47=2;
                }
                break;
            case NOT:
                {
                alt47=3;
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
                alt47=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:376:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS136=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr1129); 
                    pushFollow(FOLLOW_atom_in_unaryExpr1132);
                    atom137=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom137.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:377:4: MINUS atom
                    {
                    MINUS138=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr1137);  
                    stream_MINUS.add(MINUS138);

                    pushFollow(FOLLOW_atom_in_unaryExpr1139);
                    atom139=atom();

                    state._fsp--;

                    stream_atom.add(atom139.getTree());


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
                    // 377:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:377:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:378:4: NOT atom
                    {
                    NOT140=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr1152);  
                    stream_NOT.add(NOT140);

                    pushFollow(FOLLOW_atom_in_unaryExpr1154);
                    atom141=atom();

                    state._fsp--;

                    stream_atom.add(atom141.getTree());


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
                    // 378:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:378:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:379:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr1167);
                    atom142=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom142.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:382:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE143=null;
        Token CONST_FALSE144=null;
        Token CONST_STR145=null;
        Token CONST_INT146=null;
        Token CONST_REAL147=null;
        Token ID149=null;
        Token char_literal150=null;
        Token char_literal152=null;
        GlossaParser.arrayItem_return arrayItem148 = null;

        GlossaParser.expr_return expr151 = null;


        CommonTree CONST_TRUE143_tree=null;
        CommonTree CONST_FALSE144_tree=null;
        CommonTree CONST_STR145_tree=null;
        CommonTree CONST_INT146_tree=null;
        CommonTree CONST_REAL147_tree=null;
        CommonTree ID149_tree=null;
        CommonTree char_literal150_tree=null;
        CommonTree char_literal152_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:382:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt48=8;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:382:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE143=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom1176); 
                    CONST_TRUE143_tree = (CommonTree)adaptor.create(CONST_TRUE143);
                    adaptor.addChild(root_0, CONST_TRUE143_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:383:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE144=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom1181); 
                    CONST_FALSE144_tree = (CommonTree)adaptor.create(CONST_FALSE144);
                    adaptor.addChild(root_0, CONST_FALSE144_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:384:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR145=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom1186); 
                    CONST_STR145_tree = (CommonTree)adaptor.create(CONST_STR145);
                    adaptor.addChild(root_0, CONST_STR145_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:385:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT146=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom1191); 
                    CONST_INT146_tree = (CommonTree)adaptor.create(CONST_INT146);
                    adaptor.addChild(root_0, CONST_INT146_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:386:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL147=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom1196); 
                    CONST_REAL147_tree = (CommonTree)adaptor.create(CONST_REAL147);
                    adaptor.addChild(root_0, CONST_REAL147_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:387:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom1201);
                    arrayItem148=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem148.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:388:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID149=(Token)match(input,ID,FOLLOW_ID_in_atom1206); 
                    ID149_tree = (CommonTree)adaptor.create(ID149);
                    adaptor.addChild(root_0, ID149_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:389:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal150=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1211); 
                    pushFollow(FOLLOW_expr_in_atom1214);
                    expr151=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr151.getTree());
                    char_literal152=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1216); 

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
    // src/glossa/interpreter/grammars/Glossa.g:392:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID153=null;
        GlossaParser.arraySubscript_return arraySubscript154 = null;


        CommonTree ID153_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:393:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:393:4: ID arraySubscript
            {
            ID153=(Token)match(input,ID,FOLLOW_ID_in_arrayItem1229);  
            stream_ID.add(ID153);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem1231);
            arraySubscript154=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript154.getTree());


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
            // 393:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:393:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:395:1: arraySubscript : LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET155=null;
        Token COMMA156=null;
        Token RBRACKET157=null;
        List list_dimension=null;
        RuleReturnScope dimension = null;
        CommonTree LBRACKET155_tree=null;
        CommonTree COMMA156_tree=null;
        CommonTree RBRACKET157_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:396:2: ( LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:396:4: LBRACKET (dimension+= expr ) ( COMMA dimension+= expr )* RBRACKET
            {
            LBRACKET155=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1251);  
            stream_LBRACKET.add(LBRACKET155);

            // src/glossa/interpreter/grammars/Glossa.g:396:13: (dimension+= expr )
            // src/glossa/interpreter/grammars/Glossa.g:396:14: dimension+= expr
            {
            pushFollow(FOLLOW_expr_in_arraySubscript1256);
            dimension=expr();

            state._fsp--;

            stream_expr.add(dimension.getTree());
            if (list_dimension==null) list_dimension=new ArrayList();
            list_dimension.add(dimension.getTree());


            }

            // src/glossa/interpreter/grammars/Glossa.g:396:31: ( COMMA dimension+= expr )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:396:32: COMMA dimension+= expr
            	    {
            	    COMMA156=(Token)match(input,COMMA,FOLLOW_COMMA_in_arraySubscript1260);  
            	    stream_COMMA.add(COMMA156);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1264);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            RBRACKET157=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1268);  
            stream_RBRACKET.add(RBRACKET157);



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
            // 396:65: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:396:68: ^( ARRAY_INDEX ( expr )+ )
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


    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA48_eotS =
        "\12\uffff";
    static final String DFA48_eofS =
        "\12\uffff";
    static final String DFA48_minS =
        "\1\15\5\uffff\1\16\3\uffff";
    static final String DFA48_maxS =
        "\1\102\5\uffff\1\103\3\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\7\1\6";
    static final String DFA48_specialS =
        "\12\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\6\56\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10\3\uffff\1\10\2\uffff\1\10\1\11\1\10\11\uffff\1\10\4\uffff"+
            "\2\10\2\uffff\1\10\2\uffff\16\10\10\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "382:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program129 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_program134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program137 = new BitSet(new long[]{0x00000000000AC000L});
    public static final BitSet FOLLOW_declarations_in_program144 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BEGIN_in_program148 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program153 = new BitSet(new long[]{0x00000A1130016000L});
    public static final BitSet FOLLOW_block_in_program160 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program164 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ID_in_program170 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program175 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_constDecl_in_declarations189 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_varDecl_in_declarations192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl204 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl208 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl213 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_constAssign223 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_constAssign225 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_constAssign228 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign231 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl243 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl247 = new BitSet(new long[]{0x000000000F004002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl252 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_varType_in_varsDecl263 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl266 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl269 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl272 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl275 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl280 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem299 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension320 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_arrayDimension325 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_COMMA_in_arrayDimension329 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_arrayDimension333 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block380 = new BitSet(new long[]{0x00000A1130002002L});
    public static final BitSet FOLLOW_printStm_in_stm399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStm_in_stm458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStm_in_stm476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatStm_in_stm494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm520 = new BitSet(new long[]{0xF830000000006000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_printStm524 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_printStm528 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_printStm531 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm539 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_READ_in_readStm567 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_readItem_in_readStm570 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_readStm573 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_readItem_in_readStm576 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm581 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_readItem618 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm661 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm663 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_assingmentStm668 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm671 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm694 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm696 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm698 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_assingmentStm703 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm706 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm726 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm728 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm731 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm734 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm737 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_IF_in_ifBlock761 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_ifBlock764 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock766 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock770 = new BitSet(new long[]{0x00000A1130006000L});
    public static final BitSet FOLLOW_block_in_ifBlock775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock784 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock788 = new BitSet(new long[]{0x00000A1130006000L});
    public static final BitSet FOLLOW_block_in_elseBlock793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock802 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock805 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock807 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock811 = new BitSet(new long[]{0x00000A1130006000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStm824 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_forStm827 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_FROM_in_forStm829 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_forStm834 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_TO_in_forStm836 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_forStm841 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_STEP_in_forStm844 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_forStm849 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm854 = new BitSet(new long[]{0x00000B1130006000L});
    public static final BitSet FOLLOW_block_in_forStm859 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_forStm861 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_forStm865 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_WHILE_in_whileStm884 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_whileStm887 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LOOP_in_whileStm889 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm893 = new BitSet(new long[]{0x00000B1130006000L});
    public static final BitSet FOLLOW_block_in_whileStm898 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_whileStm900 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_whileStm904 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_REPEAT_in_repeatStm916 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm920 = new BitSet(new long[]{0x00001A1130006000L});
    public static final BitSet FOLLOW_block_in_repeatStm925 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_UNTIL_in_repeatStm927 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_repeatStm930 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeatStm933 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_expr945 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_OR_in_expr949 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_andExpr_in_expr952 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr968 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_AND_in_andExpr971 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr974 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr984 = new BitSet(new long[]{0x0000800000040002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr987 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr990 = new BitSet(new long[]{0x0000800000040002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr994 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr997 = new BitSet(new long[]{0x0000800000040002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1008 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr1011 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1014 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr1018 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1021 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr1025 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1028 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr1032 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_addExpr_in_compExpr1035 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1048 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr1051 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1054 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr1058 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_multExpr_in_addExpr1061 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1073 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr1076 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1079 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr1083 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1086 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr1090 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1093 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr1097 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_powExpr_in_multExpr1100 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1112 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr1115 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1118 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr1129 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr1137 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr1152 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1211 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_atom1214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RPAR_in_atom1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem1229 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1251 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1256 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_COMMA_in_arraySubscript1260 = new BitSet(new long[]{0xF830000000002000L,0x0000000000000005L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1264 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1268 = new BitSet(new long[]{0x0000000000000002L});

}