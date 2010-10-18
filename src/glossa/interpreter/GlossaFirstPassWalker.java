// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/GlossaFirstPassWalker.g 2010-10-18 14:24:27

package glossa.interpreter;

import glossa.interpreter.symboltable.*;
import glossa.interpreter.messages.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
        

    public String[] getTokenNames() { return GlossaFirstPassWalker.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/interpreter/grammars/GlossaFirstPassWalker.g"; }


    	SymbolTable symbolTable = new MainProgramSymbolTable();



    // $ANTLR start "unit"
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:54:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:54:6: ( program )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:54:8: program
            {
            pushFollow(FOLLOW_program_in_unit50);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:56:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:56:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:56:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program59); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program65); 

            				((MainProgramSymbolTable)symbolTable).setProgramName((id1!=null?id1.getText():null));
            			
            pushFollow(FOLLOW_declarations_in_program71);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program75);
            block();

            state._fsp--;

            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:62:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:62:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program83); 

                    				if((id1!=null?id1.getText():null).equals((id2!=null?id2.getText():null))==false){
                    					ReportingAndMessagingUtils.programNameMismatchWarning(new Point((id2!=null?id2.getLine():0), (id2!=null?id2.getCharPositionInLine():0)), (id2!=null?id2.getText():null));
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:70:1: declarations : ( constDecl | varDecl )* ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:71:2: ( ( constDecl | varDecl )* )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:71:4: ( constDecl | varDecl )*
            {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:71:4: ( constDecl | varDecl )*
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:71:5: constDecl
            	    {
            	    pushFollow(FOLLOW_constDecl_in_declarations106);
            	    constDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:71:17: varDecl
            	    {
            	    pushFollow(FOLLOW_varDecl_in_declarations110);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:73:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:74:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:74:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl124); 


            					if(symbolTable.isConstantsDeclared()){
            						ReportingAndMessagingUtils.constantsRedeclarationError(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), symbolTable.getConstantsDeclarationPoint());
            					}else{
            						symbolTable.setConstantsDeclared(true);
            						symbolTable.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:82:3: ( constAssign )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==EQ) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:82:3: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl130);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:84:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:85:2: ( ^( EQ ID expr ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:85:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign143); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_constAssign145); 
            pushFollow(FOLLOW_expr_in_constAssign147);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:91:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES2=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:91:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:91:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES2=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl166); 


            					if(symbolTable.isVariablesDeclared()){
            						ReportingAndMessagingUtils.variablesRedeclarationError(new Point((VARIABLES2!=null?VARIABLES2.getLine():0), (VARIABLES2!=null?VARIABLES2.getCharPositionInLine():0)), symbolTable.getVariablesDeclarationPoint());
            					}else{
            						symbolTable.setVariablesDeclared(true);
            						symbolTable.setVariablesDeclarationPoint(new Point((VARIABLES2!=null?VARIABLES2.getLine():0), (VARIABLES2!=null?VARIABLES2.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:99:3: ( varsDecl )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=BOOLEANS && LA4_0<=REALS)) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:99:3: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl172);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:103:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Symbol varDeclItem3 = null;

        Type varType4 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:104:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:104:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl211);
            varType4=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:106:21: ( varDeclItem )+
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:106:22: varDeclItem
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl234);
            	    varDeclItem3=varDeclItem();

            	    state._fsp--;


            	                                            Symbol s = varDeclItem3;
            	                                            s.setType(varType4);
            	                                            symbolTable.defineSymbol(s.getName(), s);
            	                                        

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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:114:1: varDeclItem returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem() throws RecognitionException {
        Symbol variable = null;

        CommonTree ID5=null;
        CommonTree ID6=null;
        List<Integer> arrayDimension7 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:115:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:115:4: ID
                    {
                    ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem294); 

                                                                    variable = new Variable((ID5!=null?ID5.getText():null), (ID5!=null?ID5.getLine():0), (ID5!=null?ID5.getCharPositionInLine():0), ID5.getTokenStartIndex(), null);
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:118:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem328); 

                    match(input, Token.DOWN, null); 
                    ID6=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem330); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem332);
                    arrayDimension7=arrayDimension();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    variable = new Array((ID6!=null?ID6.getText():null), (ID6!=null?ID6.getLine():0), (ID6!=null?ID6.getCharPositionInLine():0), ID6.getTokenStartIndex(), arrayDimension7);
                                                                

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
        return variable;
    }
    // $ANTLR end "varDeclItem"


    // $ANTLR start "arrayDimension"
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:123:1: arrayDimension returns [List<Integer> dimensions] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final List<Integer> arrayDimension() throws RecognitionException {
        List<Integer> dimensions = null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:124:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:124:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension380); 


                                                    dimensions = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:128:21: ( expr )+
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:128:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension405);
            	    expr();

            	    state._fsp--;


            	                                            dimensions.add(new Integer(1)); //TODO get value from expr - expr value msut be integer > 0
            	                                        

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
        return dimensions;
    }
    // $ANTLR end "arrayDimension"


    // $ANTLR start "varType"
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:134:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:135:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            int alt8=4;
            switch ( input.LA(1) ) {
            case BOOLEANS:
                {
                alt8=1;
                }
                break;
            case STRINGS:
                {
                alt8=2;
                }
                break;
            case INTEGERS:
                {
                alt8=3;
                }
                break;
            case REALS:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:135:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType481); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:136:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType488); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:137:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType495); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:138:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType502); 
                    result = Type.REAL;

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
        return result;
    }
    // $ANTLR end "varType"


    // $ANTLR start "block"
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block515); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:17: ( stm )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=PRINT && LA9_0<=ASSIGN)) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block517);
                	    stm();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop9;
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:142:1: stm : ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) );
    public final void stm() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:142:5: ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==PRINT) ) {
                alt11=1;
            }
            else if ( (LA11_0==ASSIGN) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:142:7: ^( PRINT ( expr )+ )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm528); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:142:15: ( expr )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==NEG||LA10_0==ARRAY_ITEM||LA10_0==ID||LA10_0==EQ||(LA10_0>=AND && LA10_0<=CONST_REAL)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:142:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_stm530);
                    	    expr();

                    	    state._fsp--;


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


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:143:4: ^( ASSIGN ID expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm538); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm540); 
                    pushFollow(FOLLOW_expr_in_stm542);
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:145:1: expr : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID ( arraySubscript )+ ) );
    public final void expr() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:145:6: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID ( arraySubscript )+ ) )
            int alt13=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt13=1;
                }
                break;
            case OR:
                {
                alt13=2;
                }
                break;
            case EQ:
                {
                alt13=3;
                }
                break;
            case NEQ:
                {
                alt13=4;
                }
                break;
            case LT:
                {
                alt13=5;
                }
                break;
            case LE:
                {
                alt13=6;
                }
                break;
            case GT:
                {
                alt13=7;
                }
                break;
            case GE:
                {
                alt13=8;
                }
                break;
            case PLUS:
                {
                alt13=9;
                }
                break;
            case MINUS:
                {
                alt13=10;
                }
                break;
            case TIMES:
                {
                alt13=11;
                }
                break;
            case DIA:
                {
                alt13=12;
                }
                break;
            case DIV:
                {
                alt13=13;
                }
                break;
            case MOD:
                {
                alt13=14;
                }
                break;
            case POW:
                {
                alt13=15;
                }
                break;
            case NEG:
                {
                alt13=16;
                }
                break;
            case NOT:
                {
                alt13=17;
                }
                break;
            case CONST_TRUE:
                {
                alt13=18;
                }
                break;
            case CONST_FALSE:
                {
                alt13=19;
                }
                break;
            case CONST_STR:
                {
                alt13=20;
                }
                break;
            case CONST_INT:
                {
                alt13=21;
                }
                break;
            case CONST_REAL:
                {
                alt13=22;
                }
                break;
            case ID:
                {
                alt13=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt13=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:145:8: ^( AND a= expr b= expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr553); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr557);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr563);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:146:4: ^( OR a= expr b= expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr570); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr574);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr580);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:147:4: ^( EQ a= expr b= expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr587); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr591);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr597);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:148:4: ^( NEQ a= expr b= expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr604); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr608);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr614);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:149:4: ^( LT a= expr b= expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr621); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr625);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr631);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:150:4: ^( LE a= expr b= expr )
                    {
                    match(input,LE,FOLLOW_LE_in_expr638); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr642);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr648);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:151:4: ^( GT a= expr b= expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr655); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr659);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr665);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:152:4: ^( GE a= expr b= expr )
                    {
                    match(input,GE,FOLLOW_GE_in_expr672); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr676);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr682);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:153:4: ^( PLUS a= expr b= expr )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expr689); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr693);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr699);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:154:4: ^( MINUS a= expr b= expr )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expr706); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr710);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr716);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:155:4: ^( TIMES a= expr b= expr )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expr723); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr727);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr733);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:156:4: ^( DIA a= expr b= expr )
                    {
                    match(input,DIA,FOLLOW_DIA_in_expr740); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr744);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr750);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:157:4: ^( DIV a= expr b= expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr757); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr761);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr767);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:158:4: ^( MOD a= expr b= expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr774); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr778);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr784);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:159:4: ^( POW a= expr b= expr )
                    {
                    match(input,POW,FOLLOW_POW_in_expr791); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr795);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr801);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:160:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr808); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr812);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:161:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr819); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr823);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:162:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr829); 

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:163:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr834); 

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:164:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr839); 

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:165:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr844); 

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:166:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr849); 

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:167:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_expr854); 

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:168:4: ^( ARRAY_ITEM ID ( arraySubscript )+ )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr860); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_expr862); 
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:168:20: ( arraySubscript )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==ARRAY_INDEX) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:168:20: arraySubscript
                    	    {
                    	    pushFollow(FOLLOW_arraySubscript_in_expr864);
                    	    arraySubscript();

                    	    state._fsp--;


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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:170:1: arraySubscript : ^( ARRAY_INDEX ( expr )+ ) ;
    public final void arraySubscript() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:171:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:171:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript877); 

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:171:18: ( expr )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==NEG||LA14_0==ARRAY_ITEM||LA14_0==ID||LA14_0==EQ||(LA14_0>=AND && LA14_0<=CONST_REAL)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:171:18: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript879);
            	    expr();

            	    state._fsp--;


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


 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations106 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_varDecl_in_declarations110 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl130 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_EQ_in_constAssign143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign145 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_constAssign147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl172 = new BitSet(new long[]{0x0000000007800008L});
    public static final BitSet FOLLOW_varType_in_varsDecl211 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl234 = new BitSet(new long[]{0x0000000000001088L});
    public static final BitSet FOLLOW_ID_in_varDeclItem294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension405 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_BOOLEANS_in_varType481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block517 = new BitSet(new long[]{0x0000000018000008L});
    public static final BitSet FOLLOW_PRINT_in_stm528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm530 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_ASSIGN_in_stm538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm540 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_stm542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr557 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr574 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr580 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr591 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr604 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr608 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr614 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr625 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr631 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr642 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr648 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr659 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr676 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr689 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr693 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr710 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr723 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr727 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr733 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr744 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr761 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr767 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr774 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr778 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr784 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr795 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr862 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arraySubscript_in_expr864 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript879 = new BitSet(new long[]{0x0001FFFFE0021128L});

}