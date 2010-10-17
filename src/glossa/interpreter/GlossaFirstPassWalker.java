// $ANTLR 3.2 Sep 23, 2009 12:02:23 GlossaFirstPassWalker.g 2010-10-17 10:57:20

package glossa.interpreter;

import glossa.interpreter.symboltable.MainProgramSymbolTable;
import glossa.interpreter.utils.ErrorUtils;
import java.awt.Point;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class GlossaFirstPassWalker extends TreeParser {
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
    public static final int LPAR=50;
    public static final int UPSILON_TONOS=118;
    public static final int CONT_COMMAND=112;
    public static final int CONST_INT=47;
    public static final int BEGIN=14;
    public static final int LOOP=96;
    public static final int KAPPA=52;
    public static final int EQ=17;
    public static final int COMMENT=111;
    public static final int ARRAY=7;
    public static final int GREEK_LETTER=115;
    public static final int END_LOOP=97;
    public static final int GE=35;
    public static final int END_SWITCH=94;
    public static final int NU=80;
    public static final int CONST_TRUE=44;
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
    public static final int PROCEDURE=77;
    public static final int PRINT=27;
    public static final int COLON=19;
    public static final int ARRAY_ITEM=8;
    public static final int NEQ=31;
    public static final int NEWLINE=13;
    public static final int END_PROGRAM=15;
    public static final int ZETA=116;
    public static final int CONST_FALSE=45;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=18;
    public static final int ASSIGN=28;
    public static final int END_IF=90;
    public static final int RPAR=51;
    public static final int PROGRAM=11;
    public static final int IOTA=54;
    public static final int DIV=40;
    public static final int GAMMA=61;
    public static final int TIMES=38;
    public static final int LE=33;
    public static final int IOTA_DIALYTIKA=119;
    public static final int IOTA_TONOS=76;
    public static final int STRING=106;

    // delegates
    // delegators


        public GlossaFirstPassWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public GlossaFirstPassWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    @Override
    public String[] getTokenNames() { return GlossaFirstPassWalker.tokenNames; }
    @Override
    public String getGrammarFileName() { return "GlossaFirstPassWalker.g"; }


    	MainProgramSymbolTable mainSymbolTable = new MainProgramSymbolTable();



    // $ANTLR start "unit"
    // GlossaFirstPassWalker.g:28:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:28:6: ( program )
            // GlossaFirstPassWalker.g:28:8: program
            {
            pushFollow(FOLLOW_program_in_unit47);
            program();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unit"


    // $ANTLR start "program"
    // GlossaFirstPassWalker.g:30:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // GlossaFirstPassWalker.g:30:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // GlossaFirstPassWalker.g:30:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program56); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program62); 

            				mainSymbolTable.setProgramName((id1!=null?id1.getText():null));
            			
            pushFollow(FOLLOW_declarations_in_program68);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program72);
            block();

            state._fsp--;

            // GlossaFirstPassWalker.g:36:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // GlossaFirstPassWalker.g:36:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program80); 

                    				if((id1!=null?id1.getText():null).equals((id2!=null?id2.getText():null))==false){
                    					ErrorUtils.programNameMismatchError(new Point((id2!=null?id2.getLine():0), (id2!=null?id2.getCharPositionInLine():0)), (id2!=null?id2.getText():null));
                    				}
                    			

                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "declarations"
    // GlossaFirstPassWalker.g:44:1: declarations : ( constDecl | varDecl )* ;
    public final void declarations() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:45:2: ( ( constDecl | varDecl )* )
            // GlossaFirstPassWalker.g:45:4: ( constDecl | varDecl )*
            {
            // GlossaFirstPassWalker.g:45:4: ( constDecl | varDecl )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==CONSTANTS) ) {
                    alt2=1;
                }
                else if ( (LA2_0==VARIABLES) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // GlossaFirstPassWalker.g:45:5: constDecl
            	    {
            	    pushFollow(FOLLOW_constDecl_in_declarations103);
            	    constDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // GlossaFirstPassWalker.g:45:17: varDecl
            	    {
            	    pushFollow(FOLLOW_varDecl_in_declarations107);
            	    varDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declarations"


    // $ANTLR start "constDecl"
    // GlossaFirstPassWalker.g:47:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // GlossaFirstPassWalker.g:48:2: ( ^( CONSTANTS ( constAssign )* ) )
            // GlossaFirstPassWalker.g:48:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl121); 


            					if(mainSymbolTable.isConstantsDeclared()){
            						ErrorUtils.constantsRedeclarationError(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), mainSymbolTable.getConstantsDeclarationPoint());
            					}else{
            						mainSymbolTable.setConstantsDeclared(true);
            						mainSymbolTable.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GlossaFirstPassWalker.g:56:3: ( constAssign )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==EQ) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // GlossaFirstPassWalker.g:56:3: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl127);
                	    constAssign();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constDecl"


    // $ANTLR start "constAssign"
    // GlossaFirstPassWalker.g:58:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:59:2: ( ^( EQ ID expr ) )
            // GlossaFirstPassWalker.g:59:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign140); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_constAssign142); 
            pushFollow(FOLLOW_expr_in_constAssign144);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constAssign"


    // $ANTLR start "varDecl"
    // GlossaFirstPassWalker.g:65:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES2=null;

        try {
            // GlossaFirstPassWalker.g:65:9: ( ^( VARIABLES ( varsDecl )* ) )
            // GlossaFirstPassWalker.g:65:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES2=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl163); 


            					if(mainSymbolTable.isVariablesDeclared()){
            						ErrorUtils.variablesRedeclarationError(new Point((VARIABLES2!=null?VARIABLES2.getLine():0), (VARIABLES2!=null?VARIABLES2.getCharPositionInLine():0)), mainSymbolTable.getVariablesDeclarationPoint());
            					}else{
            						mainSymbolTable.setVariablesDeclared(true);
            						mainSymbolTable.setVariablesDeclarationPoint(new Point((VARIABLES2!=null?VARIABLES2.getLine():0), (VARIABLES2!=null?VARIABLES2.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GlossaFirstPassWalker.g:73:3: ( varsDecl )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=BOOLEANS && LA4_0<=REALS)) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // GlossaFirstPassWalker.g:73:3: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl169);
                	    varsDecl();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varDecl"


    // $ANTLR start "varsDecl"
    // GlossaFirstPassWalker.g:77:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:78:2: ( ^( varType ( varDeclItem )+ ) )
            // GlossaFirstPassWalker.g:78:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl188);
            varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // GlossaFirstPassWalker.g:78:14: ( varDeclItem )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ARRAY||LA5_0==ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // GlossaFirstPassWalker.g:78:14: varDeclItem
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl190);
            	    varDeclItem();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varsDecl"


    // $ANTLR start "varDeclItem"
    // GlossaFirstPassWalker.g:80:1: varDeclItem : ( ID | ^( ARRAY ID arrayDimension ) );
    public final void varDeclItem() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:81:2: ( ID | ^( ARRAY ID arrayDimension ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==ARRAY) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // GlossaFirstPassWalker.g:81:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_varDeclItem201); 

                    }
                    break;
                case 2 :
                    // GlossaFirstPassWalker.g:82:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem209); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_varDeclItem211); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem213);
                    arrayDimension();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varDeclItem"


    // $ANTLR start "arrayDimension"
    // GlossaFirstPassWalker.g:84:1: arrayDimension : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final void arrayDimension() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:85:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // GlossaFirstPassWalker.g:85:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension224); 

            match(input, Token.DOWN, null); 
            // GlossaFirstPassWalker.g:85:22: ( expr )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEG||LA7_0==ARRAY_ITEM||LA7_0==ID||LA7_0==EQ||(LA7_0>=AND && LA7_0<=CONST_REAL)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // GlossaFirstPassWalker.g:85:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension226);
            	    expr();

            	    state._fsp--;


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


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arrayDimension"


    // $ANTLR start "varType"
    // GlossaFirstPassWalker.g:87:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final void varType() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:87:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // GlossaFirstPassWalker.g:
            {
            if ( (input.LA(1)>=BOOLEANS && input.LA(1)<=REALS) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varType"


    // $ANTLR start "block"
    // GlossaFirstPassWalker.g:92:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:92:7: ( ^( BLOCK ( stm )* ) )
            // GlossaFirstPassWalker.g:92:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block263); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GlossaFirstPassWalker.g:92:17: ( stm )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=PRINT && LA8_0<=ASSIGN)) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // GlossaFirstPassWalker.g:92:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block265);
                	    stm();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "block"


    // $ANTLR start "stm"
    // GlossaFirstPassWalker.g:94:1: stm : ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) );
    public final void stm() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:94:5: ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==PRINT) ) {
                alt10=1;
            }
            else if ( (LA10_0==ASSIGN) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // GlossaFirstPassWalker.g:94:7: ^( PRINT ( expr )+ )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm276); 

                    match(input, Token.DOWN, null); 
                    // GlossaFirstPassWalker.g:94:15: ( expr )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==NEG||LA9_0==ARRAY_ITEM||LA9_0==ID||LA9_0==EQ||(LA9_0>=AND && LA9_0<=CONST_REAL)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // GlossaFirstPassWalker.g:94:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_stm278);
                    	    expr();

                    	    state._fsp--;


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


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // GlossaFirstPassWalker.g:95:4: ^( ASSIGN ID expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm286); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm288); 
                    pushFollow(FOLLOW_expr_in_stm290);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stm"


    // $ANTLR start "expr"
    // GlossaFirstPassWalker.g:97:1: expr : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID ( arraySubscript )+ ) );
    public final void expr() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:97:6: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID ( arraySubscript )+ ) )
            int alt12=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt12=1;
                }
                break;
            case OR:
                {
                alt12=2;
                }
                break;
            case EQ:
                {
                alt12=3;
                }
                break;
            case NEQ:
                {
                alt12=4;
                }
                break;
            case LT:
                {
                alt12=5;
                }
                break;
            case LE:
                {
                alt12=6;
                }
                break;
            case GT:
                {
                alt12=7;
                }
                break;
            case GE:
                {
                alt12=8;
                }
                break;
            case PLUS:
                {
                alt12=9;
                }
                break;
            case MINUS:
                {
                alt12=10;
                }
                break;
            case TIMES:
                {
                alt12=11;
                }
                break;
            case DIA:
                {
                alt12=12;
                }
                break;
            case DIV:
                {
                alt12=13;
                }
                break;
            case MOD:
                {
                alt12=14;
                }
                break;
            case POW:
                {
                alt12=15;
                }
                break;
            case NEG:
                {
                alt12=16;
                }
                break;
            case NOT:
                {
                alt12=17;
                }
                break;
            case CONST_TRUE:
                {
                alt12=18;
                }
                break;
            case CONST_FALSE:
                {
                alt12=19;
                }
                break;
            case CONST_STR:
                {
                alt12=20;
                }
                break;
            case CONST_INT:
                {
                alt12=21;
                }
                break;
            case CONST_REAL:
                {
                alt12=22;
                }
                break;
            case ID:
                {
                alt12=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt12=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // GlossaFirstPassWalker.g:97:8: ^( AND a= expr b= expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr301); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr305);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr311);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // GlossaFirstPassWalker.g:98:4: ^( OR a= expr b= expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr318); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr322);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr328);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // GlossaFirstPassWalker.g:99:4: ^( EQ a= expr b= expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr335); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr339);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr345);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // GlossaFirstPassWalker.g:100:4: ^( NEQ a= expr b= expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr352); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr356);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr362);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // GlossaFirstPassWalker.g:101:4: ^( LT a= expr b= expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr369); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr373);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr379);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // GlossaFirstPassWalker.g:102:4: ^( LE a= expr b= expr )
                    {
                    match(input,LE,FOLLOW_LE_in_expr386); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr390);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr396);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // GlossaFirstPassWalker.g:103:4: ^( GT a= expr b= expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr403); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr407);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr413);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // GlossaFirstPassWalker.g:104:4: ^( GE a= expr b= expr )
                    {
                    match(input,GE,FOLLOW_GE_in_expr420); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr424);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr430);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // GlossaFirstPassWalker.g:105:4: ^( PLUS a= expr b= expr )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expr437); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr441);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr447);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // GlossaFirstPassWalker.g:106:4: ^( MINUS a= expr b= expr )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expr454); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr458);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr464);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // GlossaFirstPassWalker.g:107:4: ^( TIMES a= expr b= expr )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expr471); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr475);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr481);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // GlossaFirstPassWalker.g:108:4: ^( DIA a= expr b= expr )
                    {
                    match(input,DIA,FOLLOW_DIA_in_expr488); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr492);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr498);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // GlossaFirstPassWalker.g:109:4: ^( DIV a= expr b= expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr505); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr509);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr515);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // GlossaFirstPassWalker.g:110:4: ^( MOD a= expr b= expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr522); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr526);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr532);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // GlossaFirstPassWalker.g:111:4: ^( POW a= expr b= expr )
                    {
                    match(input,POW,FOLLOW_POW_in_expr539); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr543);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr549);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // GlossaFirstPassWalker.g:112:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr556); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr560);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // GlossaFirstPassWalker.g:113:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr567); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr571);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // GlossaFirstPassWalker.g:114:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr577); 

                    }
                    break;
                case 19 :
                    // GlossaFirstPassWalker.g:115:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr582); 

                    }
                    break;
                case 20 :
                    // GlossaFirstPassWalker.g:116:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr587); 

                    }
                    break;
                case 21 :
                    // GlossaFirstPassWalker.g:117:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr592); 

                    }
                    break;
                case 22 :
                    // GlossaFirstPassWalker.g:118:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr597); 

                    }
                    break;
                case 23 :
                    // GlossaFirstPassWalker.g:119:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_expr602); 

                    }
                    break;
                case 24 :
                    // GlossaFirstPassWalker.g:120:4: ^( ARRAY_ITEM ID ( arraySubscript )+ )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr608); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_expr610); 
                    // GlossaFirstPassWalker.g:120:20: ( arraySubscript )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==ARRAY_INDEX) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // GlossaFirstPassWalker.g:120:20: arraySubscript
                    	    {
                    	    pushFollow(FOLLOW_arraySubscript_in_expr612);
                    	    arraySubscript();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"


    // $ANTLR start "arraySubscript"
    // GlossaFirstPassWalker.g:122:1: arraySubscript : ^( ARRAY_INDEX ( expr )+ ) ;
    public final void arraySubscript() throws RecognitionException {
        try {
            // GlossaFirstPassWalker.g:123:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // GlossaFirstPassWalker.g:123:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript625); 

            match(input, Token.DOWN, null); 
            // GlossaFirstPassWalker.g:123:18: ( expr )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==NEG||LA13_0==ARRAY_ITEM||LA13_0==ID||LA13_0==EQ||(LA13_0>=AND && LA13_0<=CONST_REAL)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // GlossaFirstPassWalker.g:123:18: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript627);
            	    expr();

            	    state._fsp--;


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


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arraySubscript"

    // Delegated rules


 

    public static final BitSet FOLLOW_program_in_unit47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program56 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program62 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_declarations_in_program68 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_block_in_program72 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_ID_in_program80 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations103 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_varDecl_in_declarations107 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_EQ_in_constAssign140 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign142 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_constAssign144 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl169 = new BitSet(new long[]{0x0000000007800008L});
    public static final BitSet FOLLOW_varType_in_varsDecl188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl190 = new BitSet(new long[]{0x0000000000001088L});
    public static final BitSet FOLLOW_ID_in_varDeclItem201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem211 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension226 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block265 = new BitSet(new long[]{0x0000000018000008L});
    public static final BitSet FOLLOW_PRINT_in_stm276 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm278 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_ASSIGN_in_stm286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm288 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_stm290 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr305 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr322 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr339 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr345 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr356 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr373 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr379 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr386 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr390 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr396 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr407 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr413 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr424 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr437 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr441 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr458 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr464 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr475 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr492 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr505 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr509 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr526 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr543 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr610 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arraySubscript_in_expr612 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript625 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript627 = new BitSet(new long[]{0x0001FFFFE0021128L});

}