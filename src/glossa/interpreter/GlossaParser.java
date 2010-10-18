// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/Glossa.g 2010-10-18 22:29:17

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


    public static class unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unit"
    // src/glossa/interpreter/grammars/Glossa.g:107:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:107:6: ( program )
            // src/glossa/interpreter/grammars/Glossa.g:107:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit92);
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
    // src/glossa/interpreter/grammars/Glossa.g:109:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:109:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:109:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program100); 
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);

            id1=(Token)match(input,ID,FOLLOW_ID_in_program105); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            // src/glossa/interpreter/grammars/Glossa.g:109:27: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:109:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program108); 

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

            pushFollow(FOLLOW_declarations_in_program115);
            declarations4=declarations();

            state._fsp--;

            adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program119); 
            // src/glossa/interpreter/grammars/Glossa.g:111:11: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:111:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program124); 

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

            pushFollow(FOLLOW_block_in_program131);
            block7=block();

            state._fsp--;

            adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program135); 
            // src/glossa/interpreter/grammars/Glossa.g:113:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:113:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program141); 
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:113:26: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:113:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program146); 

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
    // src/glossa/interpreter/grammars/Glossa.g:115:1: declarations : ( constDecl )? ( varDecl )? ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:116:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/Glossa.g:116:4: ( constDecl )? ( varDecl )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/glossa/interpreter/grammars/Glossa.g:116:4: ( constDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANTS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:116:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations160);
                    constDecl10=constDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, constDecl10.getTree());

                    }
                    break;

            }

            // src/glossa/interpreter/grammars/Glossa.g:116:15: ( varDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLES) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:116:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations163);
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
    // src/glossa/interpreter/grammars/Glossa.g:118:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:119:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // src/glossa/interpreter/grammars/Glossa.g:119:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl175); 
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:119:15: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:119:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl179); 

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

            // src/glossa/interpreter/grammars/Glossa.g:119:27: ( constAssign )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:119:27: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl184);
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
    // src/glossa/interpreter/grammars/Glossa.g:121:1: constAssign : ID EQ expr ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:122:2: ( ID EQ expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:122:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign194); 
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign196); 
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);

            pushFollow(FOLLOW_expr_in_constAssign199);
            expr17=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr17.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:122:16: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:122:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign202); 

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
    // src/glossa/interpreter/grammars/Glossa.g:124:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:124:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // src/glossa/interpreter/grammars/Glossa.g:124:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl214); 
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);

            // src/glossa/interpreter/grammars/Glossa.g:124:22: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:124:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl218); 

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

            // src/glossa/interpreter/grammars/Glossa.g:124:34: ( varsDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=BOOLEANS && LA11_0<=REALS)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:124:34: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl223);
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
    // src/glossa/interpreter/grammars/Glossa.g:126:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:127:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:127:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl234);
            varType22=varType();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl237); 
            pushFollow(FOLLOW_varDeclItem_in_varsDecl240);
            varDeclItem24=varDeclItem();

            state._fsp--;

            adaptor.addChild(root_0, varDeclItem24.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:127:32: ( COMMA varDeclItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:127:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl243); 
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl246);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:127:54: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:127:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl251); 

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
    // src/glossa/interpreter/grammars/Glossa.g:129:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
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
            // src/glossa/interpreter/grammars/Glossa.g:130:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/Glossa.g:130:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem263); 
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:131:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem270);  
                    stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem272);
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
                    // 131:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:131:26: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/Glossa.g:133:1: arrayDimension : ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:134:2: ( ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:134:4: ( LBRACKET dimension+= expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:134:4: ( LBRACKET dimension+= expr RBRACKET )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:134:5: LBRACKET dimension+= expr RBRACKET
            	    {
            	    LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension292);  
            	    stream_LBRACKET.add(LBRACKET31);

            	    pushFollow(FOLLOW_expr_in_arrayDimension296);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());

            	    RBRACKET32=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension298);  
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
            // 134:41: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:134:44: ^( ARRAY_DIMENSION ( expr )+ )
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
    // src/glossa/interpreter/grammars/Glossa.g:136:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:136:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
    // src/glossa/interpreter/grammars/Glossa.g:141:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm34 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // src/glossa/interpreter/grammars/Glossa.g:141:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/Glossa.g:141:9: ( stm )*
            {
            // src/glossa/interpreter/grammars/Glossa.g:141:9: ( stm )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||LA16_0==PRINT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:141:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block343);
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
            // 141:15: -> ^( BLOCK ( stm )* )
            {
                // src/glossa/interpreter/grammars/Glossa.g:141:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/glossa/interpreter/grammars/Glossa.g:141:26: ( stm )*
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
    // src/glossa/interpreter/grammars/Glossa.g:143:1: stm : ( printStm | assingmentStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.assingmentStm_return assingmentStm36 = null;



        try {
            // src/glossa/interpreter/grammars/Glossa.g:143:5: ( printStm | assingmentStm )
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
                    // src/glossa/interpreter/grammars/Glossa.g:143:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm362);
                    printStm35=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm35.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:144:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm367);
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
    // src/glossa/interpreter/grammars/Glossa.g:146:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:146:10: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:146:12: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT37=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm376); 
            PRINT37_tree = (CommonTree)adaptor.create(PRINT37);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT37_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm379);
            expr38=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr38.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:146:24: ( ',' expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:146:26: ',' expr
            	    {
            	    char_literal39=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm383); 
            	    pushFollow(FOLLOW_expr_in_printStm386);
            	    expr40=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr40.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/glossa/interpreter/grammars/Glossa.g:146:39: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:146:40: NEWLINE
            	    {
            	    NEWLINE41=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm392); 

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
    // src/glossa/interpreter/grammars/Glossa.g:148:1: assingmentStm : varId= ID ASSIGN varValue= expr ( NEWLINE )+ ;
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
            // src/glossa/interpreter/grammars/Glossa.g:149:2: (varId= ID ASSIGN varValue= expr ( NEWLINE )+ )
            // src/glossa/interpreter/grammars/Glossa.g:149:4: varId= ID ASSIGN varValue= expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            varId=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm408); 
            varId_tree = (CommonTree)adaptor.create(varId);
            adaptor.addChild(root_0, varId_tree);

            ASSIGN42=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm410); 
            ASSIGN42_tree = (CommonTree)adaptor.create(ASSIGN42);
            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN42_tree, root_0);

            pushFollow(FOLLOW_expr_in_assingmentStm415);
            varValue=expr();

            state._fsp--;

            adaptor.addChild(root_0, varValue.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:149:35: ( NEWLINE )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:149:36: NEWLINE
            	    {
            	    NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm418); 

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
    // src/glossa/interpreter/grammars/Glossa.g:153:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:153:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:153:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr448);
            eqExpr44=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr44.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:153:15: ( AND eqExpr | OR eqExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:153:16: AND eqExpr
            	    {
            	    AND45=(Token)match(input,AND,FOLLOW_AND_in_expr451); 
            	    AND45_tree = (CommonTree)adaptor.create(AND45);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND45_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr454);
            	    eqExpr46=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr46.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:153:30: OR eqExpr
            	    {
            	    OR47=(Token)match(input,OR,FOLLOW_OR_in_expr458); 
            	    OR47_tree = (CommonTree)adaptor.create(OR47);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR47_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr461);
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
    // src/glossa/interpreter/grammars/Glossa.g:155:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:155:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:155:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr471);
            compExpr49=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr49.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:155:19: ( EQ compExpr | NEQ compExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:155:20: EQ compExpr
            	    {
            	    EQ50=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr474); 
            	    EQ50_tree = (CommonTree)adaptor.create(EQ50);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ50_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr477);
            	    compExpr51=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr51.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:155:35: NEQ compExpr
            	    {
            	    NEQ52=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr481); 
            	    NEQ52_tree = (CommonTree)adaptor.create(NEQ52);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ52_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr484);
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
    // src/glossa/interpreter/grammars/Glossa.g:157:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:157:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:157:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr495);
            addExpr54=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr54.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:157:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:157:20: LT addExpr
            	    {
            	    LT55=(Token)match(input,LT,FOLLOW_LT_in_compExpr498); 
            	    LT55_tree = (CommonTree)adaptor.create(LT55);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT55_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr501);
            	    addExpr56=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr56.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:157:34: LE addExpr
            	    {
            	    LE57=(Token)match(input,LE,FOLLOW_LE_in_compExpr505); 
            	    LE57_tree = (CommonTree)adaptor.create(LE57);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE57_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr508);
            	    addExpr58=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr58.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:157:48: GT addExpr
            	    {
            	    GT59=(Token)match(input,GT,FOLLOW_GT_in_compExpr512); 
            	    GT59_tree = (CommonTree)adaptor.create(GT59);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT59_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr515);
            	    addExpr60=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr60.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:157:62: GE addExpr
            	    {
            	    GE61=(Token)match(input,GE,FOLLOW_GE_in_compExpr519); 
            	    GE61_tree = (CommonTree)adaptor.create(GE61);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE61_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr522);
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
    // src/glossa/interpreter/grammars/Glossa.g:159:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:159:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:159:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr535);
            multExpr63=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr63.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:159:20: ( PLUS multExpr | MINUS multExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:159:21: PLUS multExpr
            	    {
            	    PLUS64=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr538); 
            	    PLUS64_tree = (CommonTree)adaptor.create(PLUS64);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS64_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr541);
            	    multExpr65=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr65.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:159:38: MINUS multExpr
            	    {
            	    MINUS66=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr545); 
            	    MINUS66_tree = (CommonTree)adaptor.create(MINUS66);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS66_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr548);
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
    // src/glossa/interpreter/grammars/Glossa.g:161:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
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
            // src/glossa/interpreter/grammars/Glossa.g:161:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:161:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr560);
            powExpr68=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr68.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:161:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
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
            	    // src/glossa/interpreter/grammars/Glossa.g:161:21: TIMES powExpr
            	    {
            	    TIMES69=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr563); 
            	    TIMES69_tree = (CommonTree)adaptor.create(TIMES69);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES69_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr566);
            	    powExpr70=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr70.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/Glossa.g:161:38: DIA powExpr
            	    {
            	    DIA71=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr570); 
            	    DIA71_tree = (CommonTree)adaptor.create(DIA71);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA71_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr573);
            	    powExpr72=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr72.getTree());

            	    }
            	    break;
            	case 3 :
            	    // src/glossa/interpreter/grammars/Glossa.g:161:53: DIV powExpr
            	    {
            	    DIV73=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr577); 
            	    DIV73_tree = (CommonTree)adaptor.create(DIV73);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV73_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr580);
            	    powExpr74=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr74.getTree());

            	    }
            	    break;
            	case 4 :
            	    // src/glossa/interpreter/grammars/Glossa.g:161:68: MOD powExpr
            	    {
            	    MOD75=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr584); 
            	    MOD75_tree = (CommonTree)adaptor.create(MOD75);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD75_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr587);
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
    // src/glossa/interpreter/grammars/Glossa.g:163:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW78=null;
        GlossaParser.unaryExpr_return unaryExpr77 = null;

        GlossaParser.unaryExpr_return unaryExpr79 = null;


        CommonTree POW78_tree=null;

        try {
            // src/glossa/interpreter/grammars/Glossa.g:163:9: ( unaryExpr ( POW unaryExpr )* )
            // src/glossa/interpreter/grammars/Glossa.g:163:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr599);
            unaryExpr77=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr77.getTree());
            // src/glossa/interpreter/grammars/Glossa.g:163:21: ( POW unaryExpr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==POW) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/Glossa.g:163:22: POW unaryExpr
            	    {
            	    POW78=(Token)match(input,POW,FOLLOW_POW_in_powExpr602); 
            	    POW78_tree = (CommonTree)adaptor.create(POW78);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW78_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr605);
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
    // src/glossa/interpreter/grammars/Glossa.g:165:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
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
            // src/glossa/interpreter/grammars/Glossa.g:166:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:166:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS80=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr616); 
                    pushFollow(FOLLOW_atom_in_unaryExpr619);
                    atom81=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom81.getTree());

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:167:4: MINUS atom
                    {
                    MINUS82=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr624);  
                    stream_MINUS.add(MINUS82);

                    pushFollow(FOLLOW_atom_in_unaryExpr626);
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
                    // 167:15: -> ^( NEG atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:167:18: ^( NEG atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:168:4: NOT atom
                    {
                    NOT84=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr639);  
                    stream_NOT.add(NOT84);

                    pushFollow(FOLLOW_atom_in_unaryExpr641);
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
                    // 168:13: -> ^( NOT atom )
                    {
                        // src/glossa/interpreter/grammars/Glossa.g:168:16: ^( NOT atom )
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
                    // src/glossa/interpreter/grammars/Glossa.g:169:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr654);
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
    // src/glossa/interpreter/grammars/Glossa.g:172:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
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
            // src/glossa/interpreter/grammars/Glossa.g:172:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt28=8;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // src/glossa/interpreter/grammars/Glossa.g:172:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE87=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom663); 
                    CONST_TRUE87_tree = (CommonTree)adaptor.create(CONST_TRUE87);
                    adaptor.addChild(root_0, CONST_TRUE87_tree);


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/Glossa.g:173:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE88=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom668); 
                    CONST_FALSE88_tree = (CommonTree)adaptor.create(CONST_FALSE88);
                    adaptor.addChild(root_0, CONST_FALSE88_tree);


                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/Glossa.g:174:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR89=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom673); 
                    CONST_STR89_tree = (CommonTree)adaptor.create(CONST_STR89);
                    adaptor.addChild(root_0, CONST_STR89_tree);


                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/Glossa.g:175:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT90=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom678); 
                    CONST_INT90_tree = (CommonTree)adaptor.create(CONST_INT90);
                    adaptor.addChild(root_0, CONST_INT90_tree);


                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/Glossa.g:176:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL91=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom683); 
                    CONST_REAL91_tree = (CommonTree)adaptor.create(CONST_REAL91);
                    adaptor.addChild(root_0, CONST_REAL91_tree);


                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/Glossa.g:177:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom688);
                    arrayItem92=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem92.getTree());

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/Glossa.g:178:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID93=(Token)match(input,ID,FOLLOW_ID_in_atom693); 
                    ID93_tree = (CommonTree)adaptor.create(ID93);
                    adaptor.addChild(root_0, ID93_tree);


                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/Glossa.g:179:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal94=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom698); 
                    pushFollow(FOLLOW_expr_in_atom701);
                    expr95=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr95.getTree());
                    char_literal96=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom703); 

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
    // src/glossa/interpreter/grammars/Glossa.g:182:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:183:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // src/glossa/interpreter/grammars/Glossa.g:183:4: ID arraySubscript
            {
            ID97=(Token)match(input,ID,FOLLOW_ID_in_arrayItem716);  
            stream_ID.add(ID97);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem718);
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
            // 183:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // src/glossa/interpreter/grammars/Glossa.g:183:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // src/glossa/interpreter/grammars/Glossa.g:185:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
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
            // src/glossa/interpreter/grammars/Glossa.g:186:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/Glossa.g:186:4: ( LBRACKET expr RBRACKET )+
            {
            // src/glossa/interpreter/grammars/Glossa.g:186:4: ( LBRACKET expr RBRACKET )+
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
            	    // src/glossa/interpreter/grammars/Glossa.g:186:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET99=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript739);  
            	    stream_LBRACKET.add(LBRACKET99);

            	    pushFollow(FOLLOW_expr_in_arraySubscript741);
            	    expr100=expr();

            	    state._fsp--;

            	    stream_expr.add(expr100.getTree());
            	    RBRACKET101=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript743);  
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
            // 186:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // src/glossa/interpreter/grammars/Glossa.g:186:33: ^( ARRAY_INDEX ( expr )+ )
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
            return "172:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program100 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_program105 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program108 = new BitSet(new long[]{0x0000000000056000L});
    public static final BitSet FOLLOW_declarations_in_program115 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_BEGIN_in_program119 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program124 = new BitSet(new long[]{0x000000000800B000L});
    public static final BitSet FOLLOW_block_in_program131 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program135 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_ID_in_program141 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program146 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_constDecl_in_declarations160 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_varDecl_in_declarations163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl175 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl179 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl184 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ID_in_constAssign194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EQ_in_constAssign196 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_constAssign199 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign202 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl214 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl218 = new BitSet(new long[]{0x0000000007802002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl223 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_varType_in_varsDecl234 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl237 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl240 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl243 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl246 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl251 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem270 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension292 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension296 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension298 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block343 = new BitSet(new long[]{0x0000000008001002L});
    public static final BitSet FOLLOW_printStm_in_stm362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm376 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm379 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_printStm383 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm386 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm392 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm408 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm410 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm415 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm418 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_eqExpr_in_expr448 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_AND_in_expr451 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr454 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_OR_in_expr458 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr461 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr471 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr474 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr477 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr481 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr484 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr495 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LT_in_compExpr498 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr501 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LE_in_compExpr505 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr508 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GT_in_compExpr512 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr515 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GE_in_compExpr519 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr522 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr535 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr538 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr541 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr545 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr548 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr560 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr563 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr566 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr570 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr573 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr577 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr580 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr584 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr587 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr599 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr602 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr605 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr616 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr624 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr639 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom698 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_atom701 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem716 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript739 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript741 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript743 = new BitSet(new long[]{0x0000000000200002L});

}