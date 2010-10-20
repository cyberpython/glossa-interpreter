// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-20 19:35:40

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
    // src/glossa/interpreter/grammars/Glossa.g:307:1: arrayDimension : ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:308:2: ( ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:308:4: ( LBRACKET dimension+= expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:308:4: ( LBRACKET dimension+= expr RBRACKET )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:308:5: LBRACKET dimension+= expr RBRACKET
            	    {
            	    LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension321);  
            	    stream_LBRACKET.add(LBRACKET31);

            	    pushFollow(FOLLOW_expr_in_arrayDimension325);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());

            	    RBRACKET32=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension327);  
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
            // 308:41: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:308:44: ^( ARRAY_DIMENSION ( expr )+ )
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

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:310:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
    // src/glossa/interpreter/grammars/Glossa.g:315:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm34 = null;


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

                if ( (LA16_0==ID||(LA16_0>=PRINT && LA16_0<=READ)||LA16_0==IF) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:315:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block372);
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
    // src/glossa/interpreter/grammars/Glossa.g:317:1: stm : ( printStm | readStm | assingmentStm | ifStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.readStm_return readStm36 = null;

        GlossaParser.assingmentStm_return assingmentStm37 = null;

        GlossaParser.ifStm_return ifStm38 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:317:5: ( printStm | readStm | assingmentStm | ifStm )
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
                    // src/glossa/interpreter/grammars/Glossa.g:317:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm391);
                    printStm35=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm35.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:318:17: readStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_readStm_in_stm409);
                    readStm36=readStm();

                    state._fsp--;

                    adaptor.addChild(root_0, readStm36.getTree());

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:319:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm414);
                    assingmentStm37=assingmentStm();

                    state._fsp--;

                    adaptor.addChild(root_0, assingmentStm37.getTree());

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:320:17: ifStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_stm432);
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
    // src/glossa/interpreter/grammars/Glossa.g:323:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:324:9: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:324:11: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT39=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm458); 
            PRINT39_tree = (CommonTree)adaptor.create(PRINT39);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT39_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm461);
            expr40=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr40.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:324:23: ( ',' expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:324:25: ',' expr
            	    {
            	    char_literal41=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm465); 
            	    pushFollow(FOLLOW_expr_in_printStm468);
            	    expr42=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr42.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:324:38: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:324:39: NEWLINE
            	    {
            	    NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm474); 

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
    // src/glossa/interpreter/grammars/Glossa.g:326:1: readStm : READ readItem ( COMMA readItem )* ( NEWLINE )+ ;
    public final GlossaParser.readStm_return readStm() throws RecognitionException {
        GlossaParser.readStm_return retval = new GlossaParser.readStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ44=null;
        Token COMMA46=null;
        Token NEWLINE48=null;
        GlossaParser.readItem_return readItem45 = null;

        GlossaParser.readItem_return readItem47 = null;


        CommonTree READ44_tree=null;
        CommonTree COMMA46_tree=null;
        CommonTree NEWLINE48_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:326:9: ( READ readItem ( COMMA readItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:327:17: READ readItem ( COMMA readItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            READ44=(Token)match(input,READ,FOLLOW_READ_in_readStm502); 
            READ44_tree = (CommonTree)adaptor.create(READ44);
            root_0 = (CommonTree)adaptor.becomeRoot(READ44_tree, root_0);

            pushFollow(FOLLOW_readItem_in_readStm505);
            readItem45=readItem();

            state._fsp--;

            adaptor.addChild(root_0, readItem45.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:327:32: ( COMMA readItem )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:327:33: COMMA readItem
            	    {
            	    COMMA46=(Token)match(input,COMMA,FOLLOW_COMMA_in_readStm508); 
            	    pushFollow(FOLLOW_readItem_in_readStm511);
            	    readItem47=readItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, readItem47.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:327:51: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:327:52: NEWLINE
            	    {
            	    NEWLINE48=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_readStm516); 

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
    // src/glossa/interpreter/grammars/Glossa.g:330:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final GlossaParser.readItem_return readItem() throws RecognitionException {
        GlossaParser.readItem_return retval = new GlossaParser.readItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token arrId=null;
        Token varId=null;
        GlossaParser.arraySubscript_return arraySubscript49 = null;


        CommonTree arrId_tree=null;
        CommonTree varId_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:330:9: (arrId= ID arraySubscript | varId= ID )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==LBRACKET) ) {
                    alt22=1;
                }
                else if ( (LA22_1==NEWLINE||LA22_1==COMMA) ) {
                    alt22=2;
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
                    // src/glossa/interpreter/grammars/Glossa.g:331:17: arrId= ID arraySubscript
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_readItem553); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_readItem555);
                    arraySubscript49=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript49.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:332:17: varId= ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_readItem575); 
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
    // src/glossa/interpreter/grammars/Glossa.g:335:1: assingmentStm : (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ );
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token varId=null;
        Token arrId=null;
        Token ASSIGN50=null;
        Token NEWLINE51=null;
        Token ASSIGN53=null;
        Token NEWLINE54=null;
        GlossaParser.expr_return varValue = null;

        GlossaParser.expr_return arrItemValue = null;

        GlossaParser.arraySubscript_return arraySubscript52 = null;


        CommonTree varId_tree=null;
        CommonTree arrId_tree=null;
        CommonTree ASSIGN50_tree=null;
        CommonTree NEWLINE51_tree=null;
        CommonTree ASSIGN53_tree=null;
        CommonTree NEWLINE54_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:336:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ | arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+ )
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
                    // src/glossa/interpreter/grammars/Glossa.g:336:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm596); 
                    varId_tree = (CommonTree)adaptor.create(varId);
                    adaptor.addChild(root_0, varId_tree);

                    ASSIGN50=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm598); 
                    ASSIGN50_tree = (CommonTree)adaptor.create(ASSIGN50);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN50_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm603);
                    varValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, varValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:336:35: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:336:36: NEWLINE
                    	    {
                    	    NEWLINE51=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm606); 

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
                    // src/glossa/interpreter/grammars/Glossa.g:337:17: arrId= ID arraySubscript ASSIGN arrItemValue= expr ( NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    arrId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm629); 
                    arrId_tree = (CommonTree)adaptor.create(arrId);
                    adaptor.addChild(root_0, arrId_tree);

                    pushFollow(FOLLOW_arraySubscript_in_assingmentStm631);
                    arraySubscript52=arraySubscript();

                    state._fsp--;

                    adaptor.addChild(root_0, arraySubscript52.getTree());
                    ASSIGN53=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm633); 
                    ASSIGN53_tree = (CommonTree)adaptor.create(ASSIGN53);
                    root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN53_tree, root_0);

                    pushFollow(FOLLOW_expr_in_assingmentStm638);
                    arrItemValue=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, arrItemValue.getTree());
                    // src/glossa/interpreter/grammars/Glossa.g:337:67: ( NEWLINE )+
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
                    	    // src/glossa/interpreter/grammars/Glossa.g:337:68: NEWLINE
                    	    {
                    	    NEWLINE54=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm641); 

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
    // src/glossa/interpreter/grammars/Glossa.g:340:1: ifStm : ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) ;
    public final GlossaParser.ifStm_return ifStm() throws RecognitionException {
        GlossaParser.ifStm_return retval = new GlossaParser.ifStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END_IF58=null;
        Token NEWLINE59=null;
        GlossaParser.ifBlock_return ifBlock55 = null;

        GlossaParser.elseIfBlock_return elseIfBlock56 = null;

        GlossaParser.elseBlock_return elseBlock57 = null;


        CommonTree END_IF58_tree=null;
        CommonTree NEWLINE59_tree=null;
        RewriteRuleTokenStream stream_END_IF=new RewriteRuleTokenStream(adaptor,"token END_IF");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_elseIfBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseIfBlock");
        RewriteRuleSubtreeStream stream_ifBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifBlock");
        RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:340:7: ( ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+ -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            // src/glossa/interpreter/grammars/Glossa.g:340:9: ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ( NEWLINE )+
            {
            pushFollow(FOLLOW_ifBlock_in_ifStm661);
            ifBlock55=ifBlock();

            state._fsp--;

            stream_ifBlock.add(ifBlock55.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:340:17: ( elseIfBlock )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==ELSE_IF) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:340:17: elseIfBlock
            	    {
            	    pushFollow(FOLLOW_elseIfBlock_in_ifStm663);
            	    elseIfBlock56=elseIfBlock();

            	    state._fsp--;

            	    stream_elseIfBlock.add(elseIfBlock56.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:340:30: ( elseBlock )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ELSE) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:340:30: elseBlock
                    {
                    pushFollow(FOLLOW_elseBlock_in_ifStm666);
                    elseBlock57=elseBlock();

                    state._fsp--;

                    stream_elseBlock.add(elseBlock57.getTree());

                    }
                    break;

            }

            END_IF58=(Token)match(input,END_IF,FOLLOW_END_IF_in_ifStm669);  
            stream_END_IF.add(END_IF58);

            // src/glossa/interpreter/grammars/Glossa.g:340:48: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:340:49: NEWLINE
            	    {
            	    NEWLINE59=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifStm672);  
            	    stream_NEWLINE.add(NEWLINE59);


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
            // elements: elseIfBlock, elseBlock, ifBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 340:59: -> ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
            {
                // src/glossa/interpreter/grammars/Glossa.g:340:62: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFNODE, "IFNODE"), root_1);

                adaptor.addChild(root_1, stream_ifBlock.nextTree());
                // src/glossa/interpreter/grammars/Glossa.g:340:79: ( elseIfBlock )*
                while ( stream_elseIfBlock.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfBlock.nextTree());

                }
                stream_elseIfBlock.reset();
                // src/glossa/interpreter/grammars/Glossa.g:340:92: ( elseBlock )?
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
    // src/glossa/interpreter/grammars/Glossa.g:342:1: ifBlock : IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.ifBlock_return ifBlock() throws RecognitionException {
        GlossaParser.ifBlock_return retval = new GlossaParser.ifBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF60=null;
        Token THEN62=null;
        Token NEWLINE63=null;
        GlossaParser.expr_return expr61 = null;

        GlossaParser.block_return block64 = null;


        CommonTree IF60_tree=null;
        CommonTree THEN62_tree=null;
        CommonTree NEWLINE63_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:342:9: ( IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:342:11: IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            IF60=(Token)match(input,IF,FOLLOW_IF_in_ifBlock696); 
            IF60_tree = (CommonTree)adaptor.create(IF60);
            root_0 = (CommonTree)adaptor.becomeRoot(IF60_tree, root_0);

            pushFollow(FOLLOW_expr_in_ifBlock699);
            expr61=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr61.getTree());
            THEN62=(Token)match(input,THEN,FOLLOW_THEN_in_ifBlock701); 
            // src/glossa/interpreter/grammars/Glossa.g:342:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:342:27: NEWLINE
            	    {
            	    NEWLINE63=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifBlock705); 

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

            pushFollow(FOLLOW_block_in_ifBlock710);
            block64=block();

            state._fsp--;

            adaptor.addChild(root_0, block64.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:344:1: elseBlock : ELSE ( NEWLINE )+ block ;
    public final GlossaParser.elseBlock_return elseBlock() throws RecognitionException {
        GlossaParser.elseBlock_return retval = new GlossaParser.elseBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE65=null;
        Token NEWLINE66=null;
        GlossaParser.block_return block67 = null;


        CommonTree ELSE65_tree=null;
        CommonTree NEWLINE66_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:345:2: ( ELSE ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:345:4: ELSE ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE65=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseBlock719); 
            ELSE65_tree = (CommonTree)adaptor.create(ELSE65);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE65_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:345:10: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:345:11: NEWLINE
            	    {
            	    NEWLINE66=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseBlock723); 

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

            pushFollow(FOLLOW_block_in_elseBlock728);
            block67=block();

            state._fsp--;

            adaptor.addChild(root_0, block67.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:347:1: elseIfBlock : ELSE_IF expr THEN ( NEWLINE )+ block ;
    public final GlossaParser.elseIfBlock_return elseIfBlock() throws RecognitionException {
        GlossaParser.elseIfBlock_return retval = new GlossaParser.elseIfBlock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE_IF68=null;
        Token THEN70=null;
        Token NEWLINE71=null;
        GlossaParser.expr_return expr69 = null;

        GlossaParser.block_return block72 = null;


        CommonTree ELSE_IF68_tree=null;
        CommonTree THEN70_tree=null;
        CommonTree NEWLINE71_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:348:2: ( ELSE_IF expr THEN ( NEWLINE )+ block )
            // src/glossa/interpreter/grammars/Glossa.g:348:4: ELSE_IF expr THEN ( NEWLINE )+ block
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSE_IF68=(Token)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock737); 
            ELSE_IF68_tree = (CommonTree)adaptor.create(ELSE_IF68);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSE_IF68_tree, root_0);

            pushFollow(FOLLOW_expr_in_elseIfBlock740);
            expr69=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr69.getTree());
            THEN70=(Token)match(input,THEN,FOLLOW_THEN_in_elseIfBlock742); 
            // src/glossa/interpreter/grammars/Glossa.g:348:24: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:348:25: NEWLINE
            	    {
            	    NEWLINE71=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_elseIfBlock746); 

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

            pushFollow(FOLLOW_block_in_elseIfBlock751);
            block72=block();

            state._fsp--;

            adaptor.addChild(root_0, block72.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:350:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND74=null;
        Token OR76=null;
        GlossaParser.eqExpr_return eqExpr73 = null;

        GlossaParser.eqExpr_return eqExpr75 = null;

        GlossaParser.eqExpr_return eqExpr77 = null;


        CommonTree AND74_tree=null;
        CommonTree OR76_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:350:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:350:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr760);
            eqExpr73=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr73.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:350:15: ( AND eqExpr | OR eqExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:350:16: AND eqExpr
            	    {
            	    AND74=(Token)match(input,AND,FOLLOW_AND_in_expr763); 
            	    AND74_tree = (CommonTree)adaptor.create(AND74);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND74_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr766);
            	    eqExpr75=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr75.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:350:30: OR eqExpr
            	    {
            	    OR76=(Token)match(input,OR,FOLLOW_OR_in_expr770); 
            	    OR76_tree = (CommonTree)adaptor.create(OR76);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR76_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr773);
            	    eqExpr77=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr77.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:352:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ79=null;
        Token NEQ81=null;
        GlossaParser.compExpr_return compExpr78 = null;

        GlossaParser.compExpr_return compExpr80 = null;

        GlossaParser.compExpr_return compExpr82 = null;


        CommonTree EQ79_tree=null;
        CommonTree NEQ81_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:352:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:352:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr783);
            compExpr78=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr78.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:352:19: ( EQ compExpr | NEQ compExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:352:20: EQ compExpr
            	    {
            	    EQ79=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr786); 
            	    EQ79_tree = (CommonTree)adaptor.create(EQ79);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ79_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr789);
            	    compExpr80=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr80.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:352:35: NEQ compExpr
            	    {
            	    NEQ81=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr793); 
            	    NEQ81_tree = (CommonTree)adaptor.create(NEQ81);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ81_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr796);
            	    compExpr82=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr82.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:354:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT84=null;
        Token LE86=null;
        Token GT88=null;
        Token GE90=null;
        GlossaParser.addExpr_return addExpr83 = null;

        GlossaParser.addExpr_return addExpr85 = null;

        GlossaParser.addExpr_return addExpr87 = null;

        GlossaParser.addExpr_return addExpr89 = null;

        GlossaParser.addExpr_return addExpr91 = null;


        CommonTree LT84_tree=null;
        CommonTree LE86_tree=null;
        CommonTree GT88_tree=null;
        CommonTree GE90_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:354:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:354:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr807);
            addExpr83=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr83.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:354:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:354:20: LT addExpr
            	    {
            	    LT84=(Token)match(input,LT,FOLLOW_LT_in_compExpr810); 
            	    LT84_tree = (CommonTree)adaptor.create(LT84);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT84_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr813);
            	    addExpr85=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr85.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:354:34: LE addExpr
            	    {
            	    LE86=(Token)match(input,LE,FOLLOW_LE_in_compExpr817); 
            	    LE86_tree = (CommonTree)adaptor.create(LE86);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE86_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr820);
            	    addExpr87=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr87.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:354:48: GT addExpr
            	    {
            	    GT88=(Token)match(input,GT,FOLLOW_GT_in_compExpr824); 
            	    GT88_tree = (CommonTree)adaptor.create(GT88);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT88_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr827);
            	    addExpr89=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr89.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:354:62: GE addExpr
            	    {
            	    GE90=(Token)match(input,GE,FOLLOW_GE_in_compExpr831); 
            	    GE90_tree = (CommonTree)adaptor.create(GE90);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE90_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr834);
            	    addExpr91=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr91.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:356:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS93=null;
        Token MINUS95=null;
        GlossaParser.multExpr_return multExpr92 = null;

        GlossaParser.multExpr_return multExpr94 = null;

        GlossaParser.multExpr_return multExpr96 = null;


        CommonTree PLUS93_tree=null;
        CommonTree MINUS95_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:356:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:356:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr847);
            multExpr92=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr92.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:356:20: ( PLUS multExpr | MINUS multExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:356:21: PLUS multExpr
            	    {
            	    PLUS93=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr850); 
            	    PLUS93_tree = (CommonTree)adaptor.create(PLUS93);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS93_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr853);
            	    multExpr94=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr94.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:356:38: MINUS multExpr
            	    {
            	    MINUS95=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr857); 
            	    MINUS95_tree = (CommonTree)adaptor.create(MINUS95);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS95_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr860);
            	    multExpr96=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr96.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:358:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES98=null;
        Token DIA100=null;
        Token DIV102=null;
        Token MOD104=null;
        GlossaParser.powExpr_return powExpr97 = null;

        GlossaParser.powExpr_return powExpr99 = null;

        GlossaParser.powExpr_return powExpr101 = null;

        GlossaParser.powExpr_return powExpr103 = null;

        GlossaParser.powExpr_return powExpr105 = null;


        CommonTree TIMES98_tree=null;
        CommonTree DIA100_tree=null;
        CommonTree DIV102_tree=null;
        CommonTree MOD104_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:358:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:358:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr872);
            powExpr97=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr97.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:358:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:358:21: TIMES powExpr
            	    {
            	    TIMES98=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr875); 
            	    TIMES98_tree = (CommonTree)adaptor.create(TIMES98);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES98_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr878);
            	    powExpr99=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr99.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:358:38: DIA powExpr
            	    {
            	    DIA100=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr882); 
            	    DIA100_tree = (CommonTree)adaptor.create(DIA100);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA100_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr885);
            	    powExpr101=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr101.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:358:53: DIV powExpr
            	    {
            	    DIV102=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr889); 
            	    DIV102_tree = (CommonTree)adaptor.create(DIV102);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV102_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr892);
            	    powExpr103=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr103.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:358:68: MOD powExpr
            	    {
            	    MOD104=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr896); 
            	    MOD104_tree = (CommonTree)adaptor.create(MOD104);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD104_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr899);
            	    powExpr105=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr105.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:360:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW107=null;
        GlossaParser.unaryExpr_return unaryExpr106 = null;

        GlossaParser.unaryExpr_return unaryExpr108 = null;


        CommonTree POW107_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:360:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:360:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr911);
            unaryExpr106=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr106.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:360:21: ( POW unaryExpr )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==POW) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:360:22: POW unaryExpr
            	    {
            	    POW107=(Token)match(input,POW,FOLLOW_POW_in_powExpr914); 
            	    POW107_tree = (CommonTree)adaptor.create(POW107);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW107_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr917);
            	    unaryExpr108=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr108.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:362:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS109=null;
        Token MINUS111=null;
        Token NOT113=null;
        GlossaParser.atom_return atom110 = null;

        GlossaParser.atom_return atom112 = null;

        GlossaParser.atom_return atom114 = null;

        GlossaParser.atom_return atom115 = null;


        CommonTree PLUS109_tree=null;
        CommonTree MINUS111_tree=null;
        CommonTree NOT113_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:363:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:363:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS109=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr928); 
                    pushFollow(FOLLOW_atom_in_unaryExpr931);
                    atom110=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom110.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:364:4: MINUS atom
                    {
                    MINUS111=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr936);  
                    stream_MINUS.add(MINUS111);

                    pushFollow(FOLLOW_atom_in_unaryExpr938);
                    atom112=atom();

                    state._fsp--;

                    stream_atom.add(atom112.getTree());


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
                    // 364:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:364:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:365:4: NOT atom
                    {
                    NOT113=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr951);  
                    stream_NOT.add(NOT113);

                    pushFollow(FOLLOW_atom_in_unaryExpr953);
                    atom114=atom();

                    state._fsp--;

                    stream_atom.add(atom114.getTree());


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
                    // 365:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:365:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:366:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr966);
                    atom115=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom115.getTree());

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
    // src/glossa/interpreter/grammars/Glossa.g:369:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE116=null;
        Token CONST_FALSE117=null;
        Token CONST_STR118=null;
        Token CONST_INT119=null;
        Token CONST_REAL120=null;
        Token ID122=null;
        Token char_literal123=null;
        Token char_literal125=null;
        GlossaParser.arrayItem_return arrayItem121 = null;

        GlossaParser.expr_return expr124 = null;


        CommonTree CONST_TRUE116_tree=null;
        CommonTree CONST_FALSE117_tree=null;
        CommonTree CONST_STR118_tree=null;
        CommonTree CONST_INT119_tree=null;
        CommonTree CONST_REAL120_tree=null;
        CommonTree ID122_tree=null;
        CommonTree char_literal123_tree=null;
        CommonTree char_literal125_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:369:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt39=8;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:369:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE116=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom975); 
                    CONST_TRUE116_tree = (CommonTree)adaptor.create(CONST_TRUE116);
                    adaptor.addChild(root_0, CONST_TRUE116_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:370:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE117=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom980); 
                    CONST_FALSE117_tree = (CommonTree)adaptor.create(CONST_FALSE117);
                    adaptor.addChild(root_0, CONST_FALSE117_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:371:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR118=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom985); 
                    CONST_STR118_tree = (CommonTree)adaptor.create(CONST_STR118);
                    adaptor.addChild(root_0, CONST_STR118_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:372:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT119=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom990); 
                    CONST_INT119_tree = (CommonTree)adaptor.create(CONST_INT119);
                    adaptor.addChild(root_0, CONST_INT119_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:373:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL120=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom995); 
                    CONST_REAL120_tree = (CommonTree)adaptor.create(CONST_REAL120);
                    adaptor.addChild(root_0, CONST_REAL120_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:374:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom1000);
                    arrayItem121=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem121.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:375:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID122=(Token)match(input,ID,FOLLOW_ID_in_atom1005); 
                    ID122_tree = (CommonTree)adaptor.create(ID122);
                    adaptor.addChild(root_0, ID122_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:376:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal123=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1010); 
                    pushFollow(FOLLOW_expr_in_atom1013);
                    expr124=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr124.getTree());
                    char_literal125=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1015); 

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
    // src/glossa/interpreter/grammars/Glossa.g:379:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID126=null;
        GlossaParser.arraySubscript_return arraySubscript127 = null;


        CommonTree ID126_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:380:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:380:4: ID arraySubscript
            {
            ID126=(Token)match(input,ID,FOLLOW_ID_in_arrayItem1028);  
            stream_ID.add(ID126);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem1030);
            arraySubscript127=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript127.getTree());


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
            // 380:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:380:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:382:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET128=null;
        Token RBRACKET130=null;
        GlossaParser.expr_return expr129 = null;


        CommonTree LBRACKET128_tree=null;
        CommonTree RBRACKET130_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:383:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:383:4: ( LBRACKET expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:383:4: ( LBRACKET expr RBRACKET )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:383:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET128=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript1051);  
            	    stream_LBRACKET.add(LBRACKET128);

            	    pushFollow(FOLLOW_expr_in_arraySubscript1053);
            	    expr129=expr();

            	    state._fsp--;

            	    stream_expr.add(expr129.getTree());
            	    RBRACKET130=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript1055);  
            	    stream_RBRACKET.add(RBRACKET130);


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
            // 383:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:383:33: ^( ARRAY_INDEX ( expr )+ )
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
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\6\1\7";
    static final String DFA39_specialS =
        "\12\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\6\45\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\11\3\uffff\1\11\2\uffff\1\11\1\10\1\11\11\uffff\1\11\2\uffff"+
            "\16\11\10\uffff\1\11",
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
            return "369:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program129 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_program134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program137 = new BitSet(new long[]{0x00000000000AC000L});
    public static final BitSet FOLLOW_declarations_in_program144 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BEGIN_in_program148 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_program153 = new BitSet(new long[]{0x0000000130016000L});
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
    public static final BitSet FOLLOW_EQ_in_constAssign225 = new BitSet(new long[]{0x02FC180000002000L});
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
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension321 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension325 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension327 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block372 = new BitSet(new long[]{0x0000000130002002L});
    public static final BitSet FOLLOW_printStm_in_stm391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStm_in_stm409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_stm432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm458 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_printStm461 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_printStm465 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_printStm468 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm474 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_READ_in_readStm502 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_readItem_in_readStm505 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_COMMA_in_readStm508 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_readItem_in_readStm511 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_NEWLINE_in_readStm516 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_readItem553 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm596 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm598 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm603 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm606 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm629 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_assingmentStm631 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm633 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm638 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm641 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ifBlock_in_ifStm661 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_ifStm663 = new BitSet(new long[]{0x0000000C80000000L});
    public static final BitSet FOLLOW_elseBlock_in_ifStm666 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_END_IF_in_ifStm669 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifStm672 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_IF_in_ifBlock696 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_ifBlock699 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_ifBlock701 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_ifBlock705 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_ifBlock710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock719 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseBlock723 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_elseBlock728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock737 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock740 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_THEN_in_elseIfBlock742 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NEWLINE_in_elseIfBlock746 = new BitSet(new long[]{0x0000000130006000L});
    public static final BitSet FOLLOW_block_in_elseIfBlock751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_expr760 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_AND_in_expr763 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_eqExpr_in_expr766 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_OR_in_expr770 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_eqExpr_in_expr773 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr783 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr786 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr789 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr793 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr796 = new BitSet(new long[]{0x0000004000040002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr807 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_LT_in_compExpr810 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr813 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_LE_in_compExpr817 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr820 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_GT_in_compExpr824 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr827 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_GE_in_compExpr831 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr834 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr847 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr850 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr853 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr857 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr860 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr872 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr875 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr878 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr882 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr885 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr889 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr892 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr896 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr899 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr911 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr914 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr917 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr928 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr936 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr951 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1010 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_atom1013 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem1028 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript1051 = new BitSet(new long[]{0x02FC180000002000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1053 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript1055 = new BitSet(new long[]{0x0000000000400002L});

}