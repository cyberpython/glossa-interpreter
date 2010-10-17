package glossasimple.intrepreter;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 Glossa.g 2010-10-17 10:08:13

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
    public String getGrammarFileName() { return "Glossa.g"; }


    public static class unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unit"
    // Glossa.g:27:1: unit : program ;
    public final GlossaParser.unit_return unit() throws RecognitionException {
        GlossaParser.unit_return retval = new GlossaParser.unit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.program_return program1 = null;



        try {
            // Glossa.g:27:6: ( program )
            // Glossa.g:27:8: program
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_program_in_unit76);
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
    // Glossa.g:29:1: program : PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ ;
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
            // Glossa.g:29:9: ( PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+ )
            // Glossa.g:29:11: PROGRAM id1= ID ( NEWLINE )+ declarations BEGIN ( NEWLINE )+ block END_PROGRAM (id2= ID )? ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM2=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program84); 
            PROGRAM2_tree = (CommonTree)adaptor.create(PROGRAM2);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM2_tree, root_0);

            id1=(Token)match(input,ID,FOLLOW_ID_in_program89); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            // Glossa.g:29:27: ( NEWLINE )+
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
            	    // Glossa.g:29:28: NEWLINE
            	    {
            	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program92); 

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

            pushFollow(FOLLOW_declarations_in_program99);
            declarations4=declarations();

            state._fsp--;

            adaptor.addChild(root_0, declarations4.getTree());
            BEGIN5=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program103); 
            // Glossa.g:31:11: ( NEWLINE )+
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
            	    // Glossa.g:31:12: NEWLINE
            	    {
            	    NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program108); 

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

            pushFollow(FOLLOW_block_in_program115);
            block7=block();

            state._fsp--;

            adaptor.addChild(root_0, block7.getTree());
            END_PROGRAM8=(Token)match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program119); 
            // Glossa.g:33:16: (id2= ID )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Glossa.g:33:17: id2= ID
                    {
                    id2=(Token)match(input,ID,FOLLOW_ID_in_program125); 
                    id2_tree = (CommonTree)adaptor.create(id2);
                    adaptor.addChild(root_0, id2_tree);


                    }
                    break;

            }

            // Glossa.g:33:26: ( NEWLINE )+
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
            	    // Glossa.g:33:27: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program130); 

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
    // Glossa.g:35:1: declarations : ( constDecl | varDecl )* ;
    public final GlossaParser.declarations_return declarations() throws RecognitionException {
        GlossaParser.declarations_return retval = new GlossaParser.declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.constDecl_return constDecl10 = null;

        GlossaParser.varDecl_return varDecl11 = null;



        try {
            // Glossa.g:36:2: ( ( constDecl | varDecl )* )
            // Glossa.g:36:4: ( constDecl | varDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // Glossa.g:36:4: ( constDecl | varDecl )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==CONSTANTS) ) {
                    alt5=1;
                }
                else if ( (LA5_0==VARIABLES) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // Glossa.g:36:5: constDecl
            	    {
            	    pushFollow(FOLLOW_constDecl_in_declarations145);
            	    constDecl10=constDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constDecl10.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:36:17: varDecl
            	    {
            	    pushFollow(FOLLOW_varDecl_in_declarations149);
            	    varDecl11=varDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDecl11.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "declarations"

    public static class constDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constDecl"
    // Glossa.g:38:1: constDecl : CONSTANTS ( NEWLINE )+ ( constAssign )* ;
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
            // Glossa.g:39:2: ( CONSTANTS ( NEWLINE )+ ( constAssign )* )
            // Glossa.g:39:4: CONSTANTS ( NEWLINE )+ ( constAssign )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CONSTANTS12=(Token)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl162); 
            CONSTANTS12_tree = (CommonTree)adaptor.create(CONSTANTS12);
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANTS12_tree, root_0);

            // Glossa.g:39:15: ( NEWLINE )+
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
            	    // Glossa.g:39:16: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constDecl166); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // Glossa.g:39:27: ( constAssign )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Glossa.g:39:27: constAssign
            	    {
            	    pushFollow(FOLLOW_constAssign_in_constDecl171);
            	    constAssign14=constAssign();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constAssign14.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // Glossa.g:41:1: constAssign : ID EQ expr ( NEWLINE )+ ;
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
            // Glossa.g:42:2: ( ID EQ expr ( NEWLINE )+ )
            // Glossa.g:42:4: ID EQ expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID15=(Token)match(input,ID,FOLLOW_ID_in_constAssign181); 
            ID15_tree = (CommonTree)adaptor.create(ID15);
            adaptor.addChild(root_0, ID15_tree);

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_constAssign183); 
            EQ16_tree = (CommonTree)adaptor.create(EQ16);
            root_0 = (CommonTree)adaptor.becomeRoot(EQ16_tree, root_0);

            pushFollow(FOLLOW_expr_in_constAssign186);
            expr17=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr17.getTree());
            // Glossa.g:42:16: ( NEWLINE )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==NEWLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Glossa.g:42:17: NEWLINE
            	    {
            	    NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_constAssign189); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    // Glossa.g:44:1: varDecl : VARIABLES ( NEWLINE )+ ( varsDecl )* ;
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
            // Glossa.g:44:9: ( VARIABLES ( NEWLINE )+ ( varsDecl )* )
            // Glossa.g:44:11: VARIABLES ( NEWLINE )+ ( varsDecl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLES19=(Token)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl201); 
            VARIABLES19_tree = (CommonTree)adaptor.create(VARIABLES19);
            root_0 = (CommonTree)adaptor.becomeRoot(VARIABLES19_tree, root_0);

            // Glossa.g:44:22: ( NEWLINE )+
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
            	    // Glossa.g:44:23: NEWLINE
            	    {
            	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varDecl205); 

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

            // Glossa.g:44:34: ( varsDecl )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=BOOLEANS && LA10_0<=REALS)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Glossa.g:44:34: varsDecl
            	    {
            	    pushFollow(FOLLOW_varsDecl_in_varDecl210);
            	    varsDecl21=varsDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varsDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // Glossa.g:46:1: varsDecl : varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ ;
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
            // Glossa.g:47:2: ( varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+ )
            // Glossa.g:47:4: varType COLON varDeclItem ( COMMA varDeclItem )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_varType_in_varsDecl221);
            varType22=varType();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(varType22.getTree(), root_0);
            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_varsDecl224); 
            pushFollow(FOLLOW_varDeclItem_in_varsDecl227);
            varDeclItem24=varDeclItem();

            state._fsp--;

            adaptor.addChild(root_0, varDeclItem24.getTree());
            // Glossa.g:47:32: ( COMMA varDeclItem )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Glossa.g:47:33: COMMA varDeclItem
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_varsDecl230); 
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl233);
            	    varDeclItem26=varDeclItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, varDeclItem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // Glossa.g:47:54: ( NEWLINE )+
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
            	    // Glossa.g:47:55: NEWLINE
            	    {
            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_varsDecl238); 

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
    // Glossa.g:49:1: varDeclItem : ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) );
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
            // Glossa.g:50:2: ( ID | ID arrayDimension -> ^( ARRAY ID arrayDimension ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==NEWLINE||LA13_1==COMMA) ) {
                    alt13=1;
                }
                else if ( (LA13_1==LBRACKET) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // Glossa.g:50:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID28=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem250); 
                    ID28_tree = (CommonTree)adaptor.create(ID28);
                    adaptor.addChild(root_0, ID28_tree);


                    }
                    break;
                case 2 :
                    // Glossa.g:51:5: ID arrayDimension
                    {
                    ID29=(Token)match(input,ID,FOLLOW_ID_in_varDeclItem257);  
                    stream_ID.add(ID29);

                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem259);
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
                    // 51:23: -> ^( ARRAY ID arrayDimension )
                    {
                        // Glossa.g:51:26: ^( ARRAY ID arrayDimension )
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
    // Glossa.g:53:1: arrayDimension : ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) ;
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
            // Glossa.g:54:2: ( ( LBRACKET dimension+= expr RBRACKET )+ -> ^( ARRAY_DIMENSION ( expr )+ ) )
            // Glossa.g:54:4: ( LBRACKET dimension+= expr RBRACKET )+
            {
            // Glossa.g:54:4: ( LBRACKET dimension+= expr RBRACKET )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==LBRACKET) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Glossa.g:54:5: LBRACKET dimension+= expr RBRACKET
            	    {
            	    LBRACKET31=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayDimension279);  
            	    stream_LBRACKET.add(LBRACKET31);

            	    pushFollow(FOLLOW_expr_in_arrayDimension283);
            	    dimension=expr();

            	    state._fsp--;

            	    stream_expr.add(dimension.getTree());
            	    if (list_dimension==null) list_dimension=new ArrayList();
            	    list_dimension.add(dimension.getTree());

            	    RBRACKET32=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayDimension285);  
            	    stream_RBRACKET.add(RBRACKET32);


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
            // 54:41: -> ^( ARRAY_DIMENSION ( expr )+ )
            {
                // Glossa.g:54:44: ^( ARRAY_DIMENSION ( expr )+ )
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
    // Glossa.g:56:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final GlossaParser.varType_return varType() throws RecognitionException {
        GlossaParser.varType_return retval = new GlossaParser.varType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // Glossa.g:56:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // Glossa.g:
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
    // Glossa.g:61:1: block : ( stm )* -> ^( BLOCK ( stm )* ) ;
    public final GlossaParser.block_return block() throws RecognitionException {
        GlossaParser.block_return retval = new GlossaParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.stm_return stm34 = null;


        RewriteRuleSubtreeStream stream_stm=new RewriteRuleSubtreeStream(adaptor,"rule stm");
        try {
            // Glossa.g:61:7: ( ( stm )* -> ^( BLOCK ( stm )* ) )
            // Glossa.g:61:9: ( stm )*
            {
            // Glossa.g:61:9: ( stm )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==ID||LA15_0==PRINT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Glossa.g:61:9: stm
            	    {
            	    pushFollow(FOLLOW_stm_in_block330);
            	    stm34=stm();

            	    state._fsp--;

            	    stream_stm.add(stm34.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
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
            // 61:15: -> ^( BLOCK ( stm )* )
            {
                // Glossa.g:61:18: ^( BLOCK ( stm )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // Glossa.g:61:26: ( stm )*
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
    // Glossa.g:63:1: stm : ( printStm | assingmentStm );
    public final GlossaParser.stm_return stm() throws RecognitionException {
        GlossaParser.stm_return retval = new GlossaParser.stm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GlossaParser.printStm_return printStm35 = null;

        GlossaParser.assingmentStm_return assingmentStm36 = null;



        try {
            // Glossa.g:63:5: ( printStm | assingmentStm )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PRINT) ) {
                alt16=1;
            }
            else if ( (LA16_0==ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // Glossa.g:63:7: printStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printStm_in_stm349);
                    printStm35=printStm();

                    state._fsp--;

                    adaptor.addChild(root_0, printStm35.getTree());

                    }
                    break;
                case 2 :
                    // Glossa.g:64:4: assingmentStm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assingmentStm_in_stm354);
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
    // Glossa.g:66:1: printStm : PRINT expr ( ',' expr )* ( NEWLINE )+ ;
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
            // Glossa.g:66:10: ( PRINT expr ( ',' expr )* ( NEWLINE )+ )
            // Glossa.g:66:12: PRINT expr ( ',' expr )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            PRINT37=(Token)match(input,PRINT,FOLLOW_PRINT_in_printStm363); 
            PRINT37_tree = (CommonTree)adaptor.create(PRINT37);
            root_0 = (CommonTree)adaptor.becomeRoot(PRINT37_tree, root_0);

            pushFollow(FOLLOW_expr_in_printStm366);
            expr38=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr38.getTree());
            // Glossa.g:66:24: ( ',' expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Glossa.g:66:26: ',' expr
            	    {
            	    char_literal39=(Token)match(input,COMMA,FOLLOW_COMMA_in_printStm370); 
            	    pushFollow(FOLLOW_expr_in_printStm373);
            	    expr40=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr40.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // Glossa.g:66:39: ( NEWLINE )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==NEWLINE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Glossa.g:66:40: NEWLINE
            	    {
            	    NEWLINE41=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_printStm379); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // Glossa.g:68:1: assingmentStm : ID ASSIGN expr ( NEWLINE )+ ;
    public final GlossaParser.assingmentStm_return assingmentStm() throws RecognitionException {
        GlossaParser.assingmentStm_return retval = new GlossaParser.assingmentStm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID42=null;
        Token ASSIGN43=null;
        Token NEWLINE45=null;
        GlossaParser.expr_return expr44 = null;


        CommonTree ID42_tree=null;
        CommonTree ASSIGN43_tree=null;
        CommonTree NEWLINE45_tree=null;

        try {
            // Glossa.g:69:2: ( ID ASSIGN expr ( NEWLINE )+ )
            // Glossa.g:69:4: ID ASSIGN expr ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            ID42=(Token)match(input,ID,FOLLOW_ID_in_assingmentStm393); 
            ID42_tree = (CommonTree)adaptor.create(ID42);
            adaptor.addChild(root_0, ID42_tree);

            ASSIGN43=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assingmentStm395); 
            ASSIGN43_tree = (CommonTree)adaptor.create(ASSIGN43);
            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN43_tree, root_0);

            pushFollow(FOLLOW_expr_in_assingmentStm398);
            expr44=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr44.getTree());
            // Glossa.g:69:20: ( NEWLINE )+
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
            	    // Glossa.g:69:21: NEWLINE
            	    {
            	    NEWLINE45=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_assingmentStm401); 

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
    // $ANTLR end "assingmentStm"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // Glossa.g:71:1: expr : eqExpr ( AND eqExpr | OR eqExpr )* ;
    public final GlossaParser.expr_return expr() throws RecognitionException {
        GlossaParser.expr_return retval = new GlossaParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND47=null;
        Token OR49=null;
        GlossaParser.eqExpr_return eqExpr46 = null;

        GlossaParser.eqExpr_return eqExpr48 = null;

        GlossaParser.eqExpr_return eqExpr50 = null;


        CommonTree AND47_tree=null;
        CommonTree OR49_tree=null;

        try {
            // Glossa.g:71:6: ( eqExpr ( AND eqExpr | OR eqExpr )* )
            // Glossa.g:71:8: eqExpr ( AND eqExpr | OR eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_expr413);
            eqExpr46=eqExpr();

            state._fsp--;

            adaptor.addChild(root_0, eqExpr46.getTree());
            // Glossa.g:71:15: ( AND eqExpr | OR eqExpr )*
            loop20:
            do {
                int alt20=3;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==AND) ) {
                    alt20=1;
                }
                else if ( (LA20_0==OR) ) {
                    alt20=2;
                }


                switch (alt20) {
            	case 1 :
            	    // Glossa.g:71:16: AND eqExpr
            	    {
            	    AND47=(Token)match(input,AND,FOLLOW_AND_in_expr416); 
            	    AND47_tree = (CommonTree)adaptor.create(AND47);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND47_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr419);
            	    eqExpr48=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr48.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:71:30: OR eqExpr
            	    {
            	    OR49=(Token)match(input,OR,FOLLOW_OR_in_expr423); 
            	    OR49_tree = (CommonTree)adaptor.create(OR49);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR49_tree, root_0);

            	    pushFollow(FOLLOW_eqExpr_in_expr426);
            	    eqExpr50=eqExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eqExpr50.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // Glossa.g:73:1: eqExpr : compExpr ( EQ compExpr | NEQ compExpr )* ;
    public final GlossaParser.eqExpr_return eqExpr() throws RecognitionException {
        GlossaParser.eqExpr_return retval = new GlossaParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ52=null;
        Token NEQ54=null;
        GlossaParser.compExpr_return compExpr51 = null;

        GlossaParser.compExpr_return compExpr53 = null;

        GlossaParser.compExpr_return compExpr55 = null;


        CommonTree EQ52_tree=null;
        CommonTree NEQ54_tree=null;

        try {
            // Glossa.g:73:8: ( compExpr ( EQ compExpr | NEQ compExpr )* )
            // Glossa.g:73:10: compExpr ( EQ compExpr | NEQ compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr436);
            compExpr51=compExpr();

            state._fsp--;

            adaptor.addChild(root_0, compExpr51.getTree());
            // Glossa.g:73:19: ( EQ compExpr | NEQ compExpr )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==EQ) ) {
                    alt21=1;
                }
                else if ( (LA21_0==NEQ) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // Glossa.g:73:20: EQ compExpr
            	    {
            	    EQ52=(Token)match(input,EQ,FOLLOW_EQ_in_eqExpr439); 
            	    EQ52_tree = (CommonTree)adaptor.create(EQ52);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ52_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr442);
            	    compExpr53=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr53.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:73:35: NEQ compExpr
            	    {
            	    NEQ54=(Token)match(input,NEQ,FOLLOW_NEQ_in_eqExpr446); 
            	    NEQ54_tree = (CommonTree)adaptor.create(NEQ54);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ54_tree, root_0);

            	    pushFollow(FOLLOW_compExpr_in_eqExpr449);
            	    compExpr55=compExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, compExpr55.getTree());

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
    // $ANTLR end "eqExpr"

    public static class compExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compExpr"
    // Glossa.g:75:1: compExpr : addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* ;
    public final GlossaParser.compExpr_return compExpr() throws RecognitionException {
        GlossaParser.compExpr_return retval = new GlossaParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT57=null;
        Token LE59=null;
        Token GT61=null;
        Token GE63=null;
        GlossaParser.addExpr_return addExpr56 = null;

        GlossaParser.addExpr_return addExpr58 = null;

        GlossaParser.addExpr_return addExpr60 = null;

        GlossaParser.addExpr_return addExpr62 = null;

        GlossaParser.addExpr_return addExpr64 = null;


        CommonTree LT57_tree=null;
        CommonTree LE59_tree=null;
        CommonTree GT61_tree=null;
        CommonTree GE63_tree=null;

        try {
            // Glossa.g:75:9: ( addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )* )
            // Glossa.g:75:11: addExpr ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_compExpr460);
            addExpr56=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr56.getTree());
            // Glossa.g:75:19: ( LT addExpr | LE addExpr | GT addExpr | GE addExpr )*
            loop22:
            do {
                int alt22=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt22=1;
                    }
                    break;
                case LE:
                    {
                    alt22=2;
                    }
                    break;
                case GT:
                    {
                    alt22=3;
                    }
                    break;
                case GE:
                    {
                    alt22=4;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // Glossa.g:75:20: LT addExpr
            	    {
            	    LT57=(Token)match(input,LT,FOLLOW_LT_in_compExpr463); 
            	    LT57_tree = (CommonTree)adaptor.create(LT57);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT57_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr466);
            	    addExpr58=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr58.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:75:34: LE addExpr
            	    {
            	    LE59=(Token)match(input,LE,FOLLOW_LE_in_compExpr470); 
            	    LE59_tree = (CommonTree)adaptor.create(LE59);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE59_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr473);
            	    addExpr60=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr60.getTree());

            	    }
            	    break;
            	case 3 :
            	    // Glossa.g:75:48: GT addExpr
            	    {
            	    GT61=(Token)match(input,GT,FOLLOW_GT_in_compExpr477); 
            	    GT61_tree = (CommonTree)adaptor.create(GT61);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT61_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr480);
            	    addExpr62=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr62.getTree());

            	    }
            	    break;
            	case 4 :
            	    // Glossa.g:75:62: GE addExpr
            	    {
            	    GE63=(Token)match(input,GE,FOLLOW_GE_in_compExpr484); 
            	    GE63_tree = (CommonTree)adaptor.create(GE63);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE63_tree, root_0);

            	    pushFollow(FOLLOW_addExpr_in_compExpr487);
            	    addExpr64=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr64.getTree());

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
    // $ANTLR end "compExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // Glossa.g:77:1: addExpr : multExpr ( PLUS multExpr | MINUS multExpr )* ;
    public final GlossaParser.addExpr_return addExpr() throws RecognitionException {
        GlossaParser.addExpr_return retval = new GlossaParser.addExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS66=null;
        Token MINUS68=null;
        GlossaParser.multExpr_return multExpr65 = null;

        GlossaParser.multExpr_return multExpr67 = null;

        GlossaParser.multExpr_return multExpr69 = null;


        CommonTree PLUS66_tree=null;
        CommonTree MINUS68_tree=null;

        try {
            // Glossa.g:77:9: ( multExpr ( PLUS multExpr | MINUS multExpr )* )
            // Glossa.g:77:11: multExpr ( PLUS multExpr | MINUS multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr500);
            multExpr65=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr65.getTree());
            // Glossa.g:77:20: ( PLUS multExpr | MINUS multExpr )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==PLUS) ) {
                    alt23=1;
                }
                else if ( (LA23_0==MINUS) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // Glossa.g:77:21: PLUS multExpr
            	    {
            	    PLUS66=(Token)match(input,PLUS,FOLLOW_PLUS_in_addExpr503); 
            	    PLUS66_tree = (CommonTree)adaptor.create(PLUS66);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS66_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr506);
            	    multExpr67=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr67.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:77:38: MINUS multExpr
            	    {
            	    MINUS68=(Token)match(input,MINUS,FOLLOW_MINUS_in_addExpr510); 
            	    MINUS68_tree = (CommonTree)adaptor.create(MINUS68);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS68_tree, root_0);

            	    pushFollow(FOLLOW_multExpr_in_addExpr513);
            	    multExpr69=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr69.getTree());

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
    // $ANTLR end "addExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // Glossa.g:79:1: multExpr : powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* ;
    public final GlossaParser.multExpr_return multExpr() throws RecognitionException {
        GlossaParser.multExpr_return retval = new GlossaParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES71=null;
        Token DIA73=null;
        Token DIV75=null;
        Token MOD77=null;
        GlossaParser.powExpr_return powExpr70 = null;

        GlossaParser.powExpr_return powExpr72 = null;

        GlossaParser.powExpr_return powExpr74 = null;

        GlossaParser.powExpr_return powExpr76 = null;

        GlossaParser.powExpr_return powExpr78 = null;


        CommonTree TIMES71_tree=null;
        CommonTree DIA73_tree=null;
        CommonTree DIV75_tree=null;
        CommonTree MOD77_tree=null;

        try {
            // Glossa.g:79:10: ( powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )* )
            // Glossa.g:79:12: powExpr ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_multExpr525);
            powExpr70=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr70.getTree());
            // Glossa.g:79:20: ( TIMES powExpr | DIA powExpr | DIV powExpr | MOD powExpr )*
            loop24:
            do {
                int alt24=5;
                switch ( input.LA(1) ) {
                case TIMES:
                    {
                    alt24=1;
                    }
                    break;
                case DIA:
                    {
                    alt24=2;
                    }
                    break;
                case DIV:
                    {
                    alt24=3;
                    }
                    break;
                case MOD:
                    {
                    alt24=4;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // Glossa.g:79:21: TIMES powExpr
            	    {
            	    TIMES71=(Token)match(input,TIMES,FOLLOW_TIMES_in_multExpr528); 
            	    TIMES71_tree = (CommonTree)adaptor.create(TIMES71);
            	    root_0 = (CommonTree)adaptor.becomeRoot(TIMES71_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr531);
            	    powExpr72=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr72.getTree());

            	    }
            	    break;
            	case 2 :
            	    // Glossa.g:79:38: DIA powExpr
            	    {
            	    DIA73=(Token)match(input,DIA,FOLLOW_DIA_in_multExpr535); 
            	    DIA73_tree = (CommonTree)adaptor.create(DIA73);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIA73_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr538);
            	    powExpr74=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr74.getTree());

            	    }
            	    break;
            	case 3 :
            	    // Glossa.g:79:53: DIV powExpr
            	    {
            	    DIV75=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr542); 
            	    DIV75_tree = (CommonTree)adaptor.create(DIV75);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV75_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr545);
            	    powExpr76=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr76.getTree());

            	    }
            	    break;
            	case 4 :
            	    // Glossa.g:79:68: MOD powExpr
            	    {
            	    MOD77=(Token)match(input,MOD,FOLLOW_MOD_in_multExpr549); 
            	    MOD77_tree = (CommonTree)adaptor.create(MOD77);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD77_tree, root_0);

            	    pushFollow(FOLLOW_powExpr_in_multExpr552);
            	    powExpr78=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr78.getTree());

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
    // $ANTLR end "multExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpr"
    // Glossa.g:81:1: powExpr : unaryExpr ( POW unaryExpr )* ;
    public final GlossaParser.powExpr_return powExpr() throws RecognitionException {
        GlossaParser.powExpr_return retval = new GlossaParser.powExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token POW80=null;
        GlossaParser.unaryExpr_return unaryExpr79 = null;

        GlossaParser.unaryExpr_return unaryExpr81 = null;


        CommonTree POW80_tree=null;

        try {
            // Glossa.g:81:9: ( unaryExpr ( POW unaryExpr )* )
            // Glossa.g:81:11: unaryExpr ( POW unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr564);
            unaryExpr79=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr79.getTree());
            // Glossa.g:81:21: ( POW unaryExpr )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==POW) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // Glossa.g:81:22: POW unaryExpr
            	    {
            	    POW80=(Token)match(input,POW,FOLLOW_POW_in_powExpr567); 
            	    POW80_tree = (CommonTree)adaptor.create(POW80);
            	    root_0 = (CommonTree)adaptor.becomeRoot(POW80_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr570);
            	    unaryExpr81=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr81.getTree());

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
    // $ANTLR end "powExpr"

    public static class unaryExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpr"
    // Glossa.g:83:1: unaryExpr : ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom );
    public final GlossaParser.unaryExpr_return unaryExpr() throws RecognitionException {
        GlossaParser.unaryExpr_return retval = new GlossaParser.unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS82=null;
        Token MINUS84=null;
        Token NOT86=null;
        GlossaParser.atom_return atom83 = null;

        GlossaParser.atom_return atom85 = null;

        GlossaParser.atom_return atom87 = null;

        GlossaParser.atom_return atom88 = null;


        CommonTree PLUS82_tree=null;
        CommonTree MINUS84_tree=null;
        CommonTree NOT86_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // Glossa.g:84:2: ( PLUS atom | MINUS atom -> ^( NEG atom ) | NOT atom -> ^( NOT atom ) | atom )
            int alt26=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt26=1;
                }
                break;
            case MINUS:
                {
                alt26=2;
                }
                break;
            case NOT:
                {
                alt26=3;
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
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // Glossa.g:84:4: PLUS atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PLUS82=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr581); 
                    pushFollow(FOLLOW_atom_in_unaryExpr584);
                    atom83=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom83.getTree());

                    }
                    break;
                case 2 :
                    // Glossa.g:85:4: MINUS atom
                    {
                    MINUS84=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr589);  
                    stream_MINUS.add(MINUS84);

                    pushFollow(FOLLOW_atom_in_unaryExpr591);
                    atom85=atom();

                    state._fsp--;

                    stream_atom.add(atom85.getTree());


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
                    // 85:15: -> ^( NEG atom )
                    {
                        // Glossa.g:85:18: ^( NEG atom )
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
                    // Glossa.g:86:4: NOT atom
                    {
                    NOT86=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpr604);  
                    stream_NOT.add(NOT86);

                    pushFollow(FOLLOW_atom_in_unaryExpr606);
                    atom87=atom();

                    state._fsp--;

                    stream_atom.add(atom87.getTree());


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
                    // 86:13: -> ^( NOT atom )
                    {
                        // Glossa.g:86:16: ^( NOT atom )
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
                    // Glossa.g:87:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr619);
                    atom88=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom88.getTree());

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
    // Glossa.g:90:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );
    public final GlossaParser.atom_return atom() throws RecognitionException {
        GlossaParser.atom_return retval = new GlossaParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONST_TRUE89=null;
        Token CONST_FALSE90=null;
        Token CONST_STR91=null;
        Token CONST_INT92=null;
        Token CONST_REAL93=null;
        Token ID95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        GlossaParser.arrayItem_return arrayItem94 = null;

        GlossaParser.expr_return expr97 = null;


        CommonTree CONST_TRUE89_tree=null;
        CommonTree CONST_FALSE90_tree=null;
        CommonTree CONST_STR91_tree=null;
        CommonTree CONST_INT92_tree=null;
        CommonTree CONST_REAL93_tree=null;
        CommonTree ID95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree char_literal98_tree=null;

        try {
            // Glossa.g:90:6: ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' )
            int alt27=8;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // Glossa.g:90:8: CONST_TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_TRUE89=(Token)match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_atom628); 
                    CONST_TRUE89_tree = (CommonTree)adaptor.create(CONST_TRUE89);
                    adaptor.addChild(root_0, CONST_TRUE89_tree);


                    }
                    break;
                case 2 :
                    // Glossa.g:91:4: CONST_FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_FALSE90=(Token)match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_atom633); 
                    CONST_FALSE90_tree = (CommonTree)adaptor.create(CONST_FALSE90);
                    adaptor.addChild(root_0, CONST_FALSE90_tree);


                    }
                    break;
                case 3 :
                    // Glossa.g:92:4: CONST_STR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_STR91=(Token)match(input,CONST_STR,FOLLOW_CONST_STR_in_atom638); 
                    CONST_STR91_tree = (CommonTree)adaptor.create(CONST_STR91);
                    adaptor.addChild(root_0, CONST_STR91_tree);


                    }
                    break;
                case 4 :
                    // Glossa.g:93:4: CONST_INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_INT92=(Token)match(input,CONST_INT,FOLLOW_CONST_INT_in_atom643); 
                    CONST_INT92_tree = (CommonTree)adaptor.create(CONST_INT92);
                    adaptor.addChild(root_0, CONST_INT92_tree);


                    }
                    break;
                case 5 :
                    // Glossa.g:94:4: CONST_REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CONST_REAL93=(Token)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_atom648); 
                    CONST_REAL93_tree = (CommonTree)adaptor.create(CONST_REAL93);
                    adaptor.addChild(root_0, CONST_REAL93_tree);


                    }
                    break;
                case 6 :
                    // Glossa.g:95:4: arrayItem
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayItem_in_atom653);
                    arrayItem94=arrayItem();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayItem94.getTree());

                    }
                    break;
                case 7 :
                    // Glossa.g:96:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID95=(Token)match(input,ID,FOLLOW_ID_in_atom658); 
                    ID95_tree = (CommonTree)adaptor.create(ID95);
                    adaptor.addChild(root_0, ID95_tree);


                    }
                    break;
                case 8 :
                    // Glossa.g:97:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal96=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom663); 
                    pushFollow(FOLLOW_expr_in_atom666);
                    expr97=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr97.getTree());
                    char_literal98=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom668); 

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
    // Glossa.g:100:1: arrayItem : ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) ;
    public final GlossaParser.arrayItem_return arrayItem() throws RecognitionException {
        GlossaParser.arrayItem_return retval = new GlossaParser.arrayItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID99=null;
        GlossaParser.arraySubscript_return arraySubscript100 = null;


        CommonTree ID99_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arraySubscript=new RewriteRuleSubtreeStream(adaptor,"rule arraySubscript");
        try {
            // Glossa.g:101:2: ( ID arraySubscript -> ^( ARRAY_ITEM ID arraySubscript ) )
            // Glossa.g:101:4: ID arraySubscript
            {
            ID99=(Token)match(input,ID,FOLLOW_ID_in_arrayItem681);  
            stream_ID.add(ID99);

            pushFollow(FOLLOW_arraySubscript_in_arrayItem683);
            arraySubscript100=arraySubscript();

            state._fsp--;

            stream_arraySubscript.add(arraySubscript100.getTree());


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
            // 101:22: -> ^( ARRAY_ITEM ID arraySubscript )
            {
                // Glossa.g:101:25: ^( ARRAY_ITEM ID arraySubscript )
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
    // Glossa.g:103:1: arraySubscript : ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaParser.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaParser.arraySubscript_return retval = new GlossaParser.arraySubscript_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET101=null;
        Token RBRACKET103=null;
        GlossaParser.expr_return expr102 = null;


        CommonTree LBRACKET101_tree=null;
        CommonTree RBRACKET103_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // Glossa.g:104:2: ( ( LBRACKET expr RBRACKET )+ -> ^( ARRAY_INDEX ( expr )+ ) )
            // Glossa.g:104:4: ( LBRACKET expr RBRACKET )+
            {
            // Glossa.g:104:4: ( LBRACKET expr RBRACKET )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==LBRACKET) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Glossa.g:104:5: LBRACKET expr RBRACKET
            	    {
            	    LBRACKET101=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySubscript704);  
            	    stream_LBRACKET.add(LBRACKET101);

            	    pushFollow(FOLLOW_expr_in_arraySubscript706);
            	    expr102=expr();

            	    state._fsp--;

            	    stream_expr.add(expr102.getTree());
            	    RBRACKET103=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySubscript708);  
            	    stream_RBRACKET.add(RBRACKET103);


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
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:30: -> ^( ARRAY_INDEX ( expr )+ )
            {
                // Glossa.g:104:33: ^( ARRAY_INDEX ( expr )+ )
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


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\12\uffff";
    static final String DFA27_eofS =
        "\12\uffff";
    static final String DFA27_minS =
        "\1\14\5\uffff\1\15\3\uffff";
    static final String DFA27_maxS =
        "\1\62\5\uffff\1\63\3\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\6\1\7";
    static final String DFA27_specialS =
        "\12\uffff}>";
    static final String[] DFA27_transitionS = {
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "90:1: atom : ( CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | arrayItem | ID | '(' expr ')' );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program84 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_program89 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program92 = new BitSet(new long[]{0x0000000000056000L});
    public static final BitSet FOLLOW_declarations_in_program99 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_BEGIN_in_program103 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program108 = new BitSet(new long[]{0x000000000800B000L});
    public static final BitSet FOLLOW_block_in_program115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program119 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_ID_in_program125 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_program130 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_constDecl_in_declarations145 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_varDecl_in_declarations149 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl162 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constDecl166 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_constAssign_in_constDecl171 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ID_in_constAssign181 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_constAssign186 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_constAssign189 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl201 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_varDecl205 = new BitSet(new long[]{0x0000000007802002L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl210 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_varType_in_varsDecl221 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_varsDecl224 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl227 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_varsDecl230 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl233 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_varsDecl238 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varDeclItem257 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayDimension279 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arrayDimension283 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayDimension285 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stm_in_block330 = new BitSet(new long[]{0x0000000008001002L});
    public static final BitSet FOLLOW_printStm_in_stm349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assingmentStm_in_stm354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printStm363 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm366 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMMA_in_printStm370 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_printStm373 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_NEWLINE_in_printStm379 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_assingmentStm393 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assingmentStm395 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_assingmentStm398 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_assingmentStm401 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_eqExpr_in_expr413 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_AND_in_expr416 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr419 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_OR_in_expr423 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_eqExpr_in_expr426 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr436 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_EQ_in_eqExpr439 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr442 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_NEQ_in_eqExpr446 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr449 = new BitSet(new long[]{0x0000000080020002L});
    public static final BitSet FOLLOW_addExpr_in_compExpr460 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LT_in_compExpr463 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr466 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_LE_in_compExpr470 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr473 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GT_in_compExpr477 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr480 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_GE_in_compExpr484 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_addExpr_in_compExpr487 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_multExpr_in_addExpr500 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_PLUS_in_addExpr503 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr506 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_MINUS_in_addExpr510 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr513 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_powExpr_in_multExpr525 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_TIMES_in_multExpr528 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr531 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIA_in_multExpr535 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr538 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpr542 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr545 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpr549 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_powExpr_in_multExpr552 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr564 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_POW_in_powExpr567 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr570 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr581 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr589 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr604 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_TRUE_in_atom628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_atom633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_atom638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_atom643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_atom648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayItem_in_atom653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom663 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_atom666 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayItem681 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arraySubscript_in_arrayItem683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySubscript704 = new BitSet(new long[]{0x0005F83000001000L});
    public static final BitSet FOLLOW_expr_in_arraySubscript706 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySubscript708 = new BitSet(new long[]{0x0000000000200002L});

}