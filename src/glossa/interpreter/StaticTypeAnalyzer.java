// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/StaticTypeAnalyzer.g 2010-10-25 21:59:33


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
import glossa.interpreter.statictypeanalysis.*;
import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.scopes.*;
import glossa.interpreter.symboltable.symbols.*;
import glossa.interpreter.symboltable.types.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.awt.Point;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StaticTypeAnalyzer extends TreeParser {
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
    public static final int LPAR=71;
    public static final int UPSILON_TONOS=121;
    public static final int CONT_COMMAND=115;
    public static final int CONST_INT=69;
    public static final int LOOP=52;
    public static final int BEGIN=17;
    public static final int KAPPA=73;
    public static final int EQ=20;
    public static final int COMMENT=114;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=118;
    public static final int END_LOOP=50;
    public static final int GE=45;
    public static final int END_SWITCH=39;
    public static final int CONST_TRUE=66;
    public static final int NU=100;
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
    public static final int PRINT=30;
    public static final int PROCEDURE=97;
    public static final int COLON=22;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=57;
    public static final int NEWLINE=16;
    public static final int END_PROGRAM=18;
    public static final int ZETA=119;
    public static final int CONST_FALSE=67;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=21;
    public static final int ASSIGN=32;
    public static final int END_IF=33;
    public static final int RPAR=72;
    public static final int PROGRAM=14;
    public static final int IOTA=75;
    public static final int DIV=62;
    public static final int GAMMA=82;
    public static final int TIMES=60;
    public static final int LE=43;
    public static final int IOTA_DIALYTIKA=122;
    public static final int IOTA_TONOS=96;
    public static final int STRING=109;

    // delegates
    // delegators


        public StaticTypeAnalyzer(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public StaticTypeAnalyzer(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StaticTypeAnalyzer.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/interpreter/grammars/StaticTypeAnalyzer.g"; }


            private SymbolTable symbolTable;
    	private Scope currentScope;
            private boolean inConstantDeclaration = false;
            private boolean inVariableDeclaration = false;

            public void setSymbolTable(SymbolTable s){
                this.symbolTable = s;
            }

            public SymbolTable getSymbolTable(){
                return this.symbolTable;
            }

            public void setCurrentScope(Scope s){
                this.currentScope = s;
            }

            public Scope getCurrentScope(){
                return this.currentScope;
            }



    // $ANTLR start "unit"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:105:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:105:6: ( program )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:105:8: program
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:107:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:107:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:107:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program59); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program65); 

                                            MainProgramScope mainProgramScope = new MainProgramScope();
            				mainProgramScope.setProgramName((id1!=null?id1.getText():null));
                                            symbolTable.setMainProgramScope(mainProgramScope);
                                            currentScope = mainProgramScope;
            			
            pushFollow(FOLLOW_declarations_in_program71);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program75);
            block();

            state._fsp--;

            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:116:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:116:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program83); 

                    				if((id1!=null?id1.getText():null).equals((id2!=null?id2.getText():null))==false){
                    					Messages.programNameMismatchWarning(new Point((id2!=null?id2.getLine():0), (id2!=null?id2.getCharPositionInLine():0)), (id2!=null?id2.getText():null));
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:124:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:4: ( constDecl )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CONSTANTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations105);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:15: ( varDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLES) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations108);
                    varDecl();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "declarations"


    // $ANTLR start "constDecl"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:127:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:128:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:128:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl121); 


                                                    inConstantDeclaration=true;
            					if(currentScope.isConstantsDeclared()){
            						Messages.constantsRedeclarationError(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), currentScope.getConstantsDeclarationPoint());
            					}else{
            						currentScope.setConstantsDeclared(true);
            						currentScope.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:137:3: ( constAssign )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==EQ) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:137:3: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl127);
                	    constAssign();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                                                    inConstantDeclaration=false;
                                            

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:143:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID2=null;
        StaticTypeAnalyzer.expr_return expr3 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:144:2: ( ^( EQ ID expr ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:144:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign183); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign185); 
            pushFollow(FOLLOW_expr_in_constAssign187);
            expr3=expr();

            state._fsp--;


            match(input, Token.UP, null); 

                                                Constant s = new Constant((ID2!=null?ID2.getText():null), (expr3!=null?expr3.expressionType:null), (ID2!=null?ID2.getLine():0), (ID2!=null?ID2.getCharPositionInLine():0), ID2.getTokenStartIndex(), null);
                                                s.setInitialized(true);
                                                currentScope.defineSymbol(s.getName(), s);
                                            

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:155:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:155:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:155:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES4=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl218); 


                                                    inVariableDeclaration=true;
            					if(currentScope.isVariablesDeclared()){
            						Messages.variablesRedeclarationError(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)), currentScope.getVariablesDeclarationPoint());
            					}else{
            						currentScope.setVariablesDeclared(true);
            						currentScope.setVariablesDeclarationPoint(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:164:3: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:164:3: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl224);
                	    varsDecl();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

                                                    inVariableDeclaration=false;
                                            

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:171:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Symbol varDeclItem5 = null;

        Type varType6 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:172:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:172:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType6=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:174:21: ( varDeclItem )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ARRAY||LA6_0==ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:174:22: varDeclItem
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl302);
            	    varDeclItem5=varDeclItem();

            	    state._fsp--;


            	                                            Symbol s = varDeclItem5;
            	                                            s.setType(varType6);
            	                                            currentScope.defineSymbol(s.getName(), s);
            	                                        

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:182:1: varDeclItem returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem() throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        int arrayDimension9 = 0;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:183:2: ( ID | ^( ARRAY ID arrayDimension ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==ARRAY) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:183:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem362); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex(), null);
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:186:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem396); 

                    match(input, Token.DOWN, null); 
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem398); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem400);
                    arrayDimension9=arrayDimension();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    variable = new Array((ID8!=null?ID8.getText():null), (ID8!=null?ID8.getLine():0), (ID8!=null?ID8.getCharPositionInLine():0), ID8.getTokenStartIndex(), arrayDimension9);
                                                                

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:193:1: arrayDimension returns [int indicesCount] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final int arrayDimension() throws RecognitionException {
        int indicesCount = 0;

        StaticTypeAnalyzer.expr_return expr10 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:194:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:194:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension450); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:198:21: ( expr )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==NEG||LA8_0==ARRAY_ITEM||LA8_0==ID||LA8_0==EQ||(LA8_0>=LT && LA8_0<=GE)||(LA8_0>=OR && LA8_0<=CONST_REAL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:198:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension475);
            	    expr10=expr();

            	    state._fsp--;


            	                                            Type type = (expr10!=null?expr10.expressionType:null);
            	                                            count++;
            	                                            if(   (type==null)     ||   ( !type.equals(Type.INTEGER) )   ){
            	                                                Messages.arrayDimensionDeclarationsNotIntegerError(new Point((expr10!=null?((CommonTree)expr10.start):null).getLine(), (expr10!=null?((CommonTree)expr10.start):null).getCharPositionInLine()));
            	                                            }
            	                                        

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

               indicesCount = count;  

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return indicesCount;
    }
    // $ANTLR end "arrayDimension"


    // $ANTLR start "varType"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:211:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            int alt9=4;
            switch ( input.LA(1) ) {
            case BOOLEANS:
                {
                alt9=1;
                }
                break;
            case STRINGS:
                {
                alt9=2;
                }
                break;
            case INTEGERS:
                {
                alt9=3;
                }
                break;
            case REALS:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType590); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType597); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:214:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType604); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:215:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType611); 
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block624); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:17: ( stm )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IFNODE||(LA10_0>=PRINT && LA10_0<=ASSIGN)||LA10_0==SWITCH||LA10_0==FOR||LA10_0==WHILE||LA10_0==REPEAT) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block626);
                	    stm();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop10;
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );
    public final void stm() throws RecognitionException {
        CommonTree ID11=null;
        CommonTree ASSIGN13=null;
        CommonTree ID14=null;
        CommonTree ASSIGN16=null;
        CommonTree ID20=null;
        StaticTypeAnalyzer.expr_return expr1 = null;

        StaticTypeAnalyzer.expr_return expr2 = null;

        StaticTypeAnalyzer.expr_return expr3 = null;

        StaticTypeAnalyzer.expr_return expr12 = null;

        StaticTypeAnalyzer.expr_return expr15 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript17 = null;

        StaticTypeAnalyzer.caseBlock_return caseBlock18 = null;

        StaticTypeAnalyzer.expr_return expr19 = null;

        StaticTypeAnalyzer.expr_return expr21 = null;

        StaticTypeAnalyzer.expr_return expr22 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) )
            int alt18=9;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm640); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:15: (expr1= expr )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==NEG||LA11_0==ARRAY_ITEM||LA11_0==ID||LA11_0==EQ||(LA11_0>=LT && LA11_0<=GE)||(LA11_0>=OR && LA11_0<=CONST_REAL)) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:16: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm645);
                        	    expr1=expr();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop11;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:223:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm668); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:223:24: ( readItem )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:223:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm670);
                    	    readItem();

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
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:224:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm678); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm680); 
                    pushFollow(FOLLOW_expr_in_stm682);
                    expr12=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       StaticTypeAnalyzerUtils.checkVariableAssignment(this.currentScope, (ID11!=null?ID11.getText():null), (ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0),
                                                                                                        (expr12!=null?expr12.expressionType:null), (expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine(),
                                                                                                        (ASSIGN13!=null?ASSIGN13.getText():null), (ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0));
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:228:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN16=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm714); 

                    match(input, Token.DOWN, null); 
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_stm716); 
                    pushFollow(FOLLOW_arraySubscript_in_stm718);
                    arraySubscript17=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm720);
                    expr15=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkArrayAssignment(this.currentScope, (ID14!=null?ID14.getText():null), (ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0),
                                                                                              (expr15!=null?expr15.expressionType:null), (expr15!=null?((CommonTree)expr15.start):null).getLine(), (expr15!=null?((CommonTree)expr15.start):null).getCharPositionInLine(),
                                                                                              (ASSIGN16!=null?ASSIGN16.getText():null), (ASSIGN16!=null?ASSIGN16.getLine():0), (ASSIGN16!=null?ASSIGN16.getCharPositionInLine():0),
                                                                                              (arraySubscript17!=null?arraySubscript17.indicesCount:0), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getLine(), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getCharPositionInLine());
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:235:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm786); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm788);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:235:34: ( elseIfBlock )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ELSE_IF) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:235:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm790);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:235:47: ( elseBlock )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ELSE) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:235:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm793);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:236:17: ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? )
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_stm814); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm816);
                    expr19=expr();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:237:26: ( caseBlock )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==CASE) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:237:27: caseBlock
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm845);
                    	    caseBlock18=caseBlock();

                    	    state._fsp--;


                    	                                                    for (Iterator<Type> it = (caseBlock18!=null?caseBlock18.expressionTypes:null).iterator(); it.hasNext();) {
                    	                                                        Type expressionType = it.next();
                    	                                                        if( !StaticTypeAnalyzerUtils.checkTypesForEqualityExpression((expr19!=null?expr19.expressionType:null), expressionType) ){
                    	                                                            //TODO: proper error message
                    	                                                            Messages.error(new Point((caseBlock18!=null?((CommonTree)caseBlock18.start):null).getLine(), (caseBlock18!=null?((CommonTree)caseBlock18.start):null).getCharPositionInLine()), "Incompatible types for SWITCH statment");
                    	                                                        }
                    	                                                    }
                    	                                                

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:247:26: ( caseElseBlock )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==CASE_ELSE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:247:26: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm910);
                            caseElseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:249:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm949); 

                    match(input, Token.DOWN, null); 
                    ID20=(CommonTree)match(input,ID,FOLLOW_ID_in_stm951); 
                    pushFollow(FOLLOW_expr_in_stm955);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm959);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:249:48: (expr3= expr )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==NEG||LA17_0==ARRAY_ITEM||LA17_0==ID||LA17_0==EQ||(LA17_0>=LT && LA17_0<=GE)||(LA17_0>=OR && LA17_0<=CONST_REAL)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:249:49: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm964);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm968);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID20!=null?ID20.getText():null), new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                         if(s instanceof Variable){
                                                                            if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                                                if(StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null)) && StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null)) ){
                                                                                    if(s.getType().equals(Type.INTEGER)){
                                                                                        if(!(expr1!=null?expr1.expressionType:null).equals(Type.INTEGER)){
                                                                                            Messages.forFromStepExpressionsMustBeInteger(new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                        }
                                                                                        if(expr3!=null){
                                                                                            if(  ((expr3!=null?expr3.expressionType:null)==null) || (!(expr3!=null?expr3.expressionType:null).equals(Type.INTEGER))  ){
                                                                                                Messages.forFromStepExpressionsMustBeInteger(new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        if(expr3!=null){
                                                                                            if(!StaticTypeAnalyzerUtils.isNumericType((expr3!=null?expr3.expressionType:null))){
                                                                                                Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    if(!StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                    }
                                                                                    if(!StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr2!=null?((CommonTree)expr2.start):null).getLine(), (expr2!=null?((CommonTree)expr2.start):null).getCharPositionInLine()), (expr2!=null?expr2.expressionType:null));
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.forCounterMustBeOfNumericType(new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)), s.getType());
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:288:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm1034); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm1036);
                    expr21=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm1038);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr21!=null?expr21.expressionType:null)!=null){
                                                                        if(!(expr21!=null?expr21.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBoolean(new Point((expr21!=null?((CommonTree)expr21.start):null).getLine(), (expr21!=null?((CommonTree)expr21.start):null).getCharPositionInLine()) , (expr21!=null?expr21.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBoolean(new Point((expr21!=null?((CommonTree)expr21.start):null).getLine(), (expr21!=null?((CommonTree)expr21.start):null).getCharPositionInLine()) , null);
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:297:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm1055); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm1057);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1059);
                    expr22=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr22!=null?expr22.expressionType:null)!=null){
                                                                        if(!(expr22!=null?expr22.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBoolean(new Point((expr22!=null?((CommonTree)expr22.start):null).getLine(), (expr22!=null?((CommonTree)expr22.start):null).getCharPositionInLine()) , (expr22!=null?expr22.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBoolean(new Point((expr22!=null?((CommonTree)expr22.start):null).getLine(), (expr22!=null?((CommonTree)expr22.start):null).getCharPositionInLine()) , null);
                                                                    }
                                                                

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


    // $ANTLR start "readItem"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:308:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript23 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:308:9: (arrId= ID arraySubscript | varId= ID )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==ARRAY_INDEX) ) {
                    alt19=1;
                }
                else if ( (LA19_1==UP||LA19_1==ID) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:308:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1093); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1095);
                    arraySubscript23=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol((arrId!=null?arrId.getText():null), new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            Type t = arr.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)), t);
                                                                            }else{
                                                                                int indicesCount = (arraySubscript23!=null?arraySubscript23.indicesCount:0);
                                                                                if(arr.getNumberOfDimensions() != indicesCount){
                                                                                    Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript23!=null?((CommonTree)arraySubscript23.start):null).getLine(), (arraySubscript23!=null?((CommonTree)arraySubscript23.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                }else{
                                                                                    s.setInitialized(true);
                                                                                }
                                                                            }
                                                                        }else{
                                                                            Messages.nonArraySymbolReferencedAsSuchError(s, new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:329:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1119); 

                                                                    Symbol s = currentScope.referenceSymbol((varId!=null?varId.getText():null), new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(!(s instanceof Variable)){
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)), s);
                                                                        }else{
                                                                            Type t = s.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)), t);
                                                                            }else{
                                                                                s.setInitialized(true);
                                                                            }
                                                                        }
                                                                    }
                                                                

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
    // $ANTLR end "readItem"


    // $ANTLR start "ifBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:346:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr24 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:346:9: ( ^( IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:346:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1164); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1166);
            expr24=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1168);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr24!=null?expr24.expressionType:null)!=null){
                                                                if(!(expr24!=null?expr24.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr24!=null?((CommonTree)expr24.start):null).getLine(), (expr24!=null?((CommonTree)expr24.start):null).getCharPositionInLine()) , (expr24!=null?expr24.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr24!=null?((CommonTree)expr24.start):null).getLine(), (expr24!=null?((CommonTree)expr24.start):null).getCharPositionInLine()) , null);
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
    // $ANTLR end "ifBlock"


    // $ANTLR start "elseBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:357:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:358:2: ( ^( ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:358:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1201); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1203);
            block();

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
    // $ANTLR end "elseBlock"


    // $ANTLR start "elseIfBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:361:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr25 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:362:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:362:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1223); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1225);
            expr25=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1227);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr25!=null?expr25.expressionType:null)!=null){
                                                                if(!(expr25!=null?expr25.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr25!=null?((CommonTree)expr25.start):null).getLine(), (expr25!=null?((CommonTree)expr25.start):null).getCharPositionInLine()) , (expr25!=null?expr25.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr25!=null?((CommonTree)expr25.start):null).getLine(), (expr25!=null?((CommonTree)expr25.start):null).getCharPositionInLine()) , null);
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
    // $ANTLR end "elseIfBlock"

    public static class caseBlock_return extends TreeRuleReturnScope {
        public List<Type> expressionTypes;
    };

    // $ANTLR start "caseBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:374:1: caseBlock returns [List<Type> expressionTypes] : ^( CASE ( caseExprListItem )+ block ) ;
    public final StaticTypeAnalyzer.caseBlock_return caseBlock() throws RecognitionException {
        StaticTypeAnalyzer.caseBlock_return retval = new StaticTypeAnalyzer.caseBlock_return();
        retval.start = input.LT(1);

        Type caseExprListItem26 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:375:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:375:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1262); 

               List<Type> result = new ArrayList<Type>();   

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:376:19: ( caseExprListItem )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==NEG||LA20_0==ARRAY_ITEM||LA20_0==INF_RANGE||LA20_0==ID||LA20_0==EQ||(LA20_0>=RANGE && LA20_0<=GE)||(LA20_0>=OR && LA20_0<=CONST_REAL)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:376:19: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1301);
            	    caseExprListItem26=caseExprListItem();

            	    state._fsp--;


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


                                                        result.add(caseExprListItem26);
                                                    
            pushFollow(FOLLOW_block_in_caseBlock1328);
            block();

            state._fsp--;

               retval.expressionTypes = result;  

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseBlock"


    // $ANTLR start "caseExprListItem"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:382:1: caseExprListItem returns [Type expressionType] : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final Type caseExprListItem() throws RecognitionException {
        Type expressionType = null;

        CommonTree RANGE27=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:383:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
            int alt21=6;
            switch ( input.LA(1) ) {
            case NEG:
            case ARRAY_ITEM:
            case ID:
            case EQ:
            case LT:
            case LE:
            case GT:
            case GE:
            case OR:
            case AND:
            case NEQ:
            case PLUS:
            case MINUS:
            case TIMES:
            case DIA:
            case DIV:
            case MOD:
            case POW:
            case NOT:
            case CONST_TRUE:
            case CONST_FALSE:
            case CONST_STR:
            case CONST_INT:
            case CONST_REAL:
                {
                alt21=1;
                }
                break;
            case RANGE:
                {
                alt21=2;
                }
                break;
            case INF_RANGE:
                {
                int LA21_3 = input.LA(2);

                if ( (LA21_3==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case LT:
                        {
                        alt21=3;
                        }
                        break;
                    case LE:
                        {
                        alt21=4;
                        }
                        break;
                    case GT:
                        {
                        alt21=5;
                        }
                        break;
                    case GE:
                        {
                        alt21=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:383:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1380);
                    a=expr();

                    state._fsp--;


                                                                expressionType = (a!=null?a.expressionType:null);
                                                            

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:386:10: ^( RANGE a= expr b= expr )
                    {
                    RANGE27=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1411); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1415);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1419);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                    expressionType = Type.REAL;
                                                                }else{
                                                                    Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((RANGE27!=null?RANGE27.getLine():0), (RANGE27!=null?RANGE27.getCharPositionInLine():0)), (RANGE27!=null?RANGE27.getText():null)
                                                                                                                              );
                                                                }
                                                            

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:396:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1435); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1437); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1441);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        expressionType = Type.REAL;
                                                                    }else{
                                                                        expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    //TODO: Proper error message
                                                                    Messages.error(new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), "You can not use booleans in ranges");
                                                                }
                                                            

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:408:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1464); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1466); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1470);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        expressionType = Type.REAL;
                                                                    }else{
                                                                        expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    //TODO: Proper error message
                                                                    Messages.error(new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), "You can not use booleans in ranges");
                                                                }
                                                            

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:420:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1493); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1495); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1499);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        expressionType = Type.REAL;
                                                                    }else{
                                                                        expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    //TODO: Proper error message
                                                                    Messages.error(new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), "You can not use booleans in ranges");
                                                                }
                                                            

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:432:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1522); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1524); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1528);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        expressionType = Type.REAL;
                                                                    }else{
                                                                        expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    //TODO: Proper error message
                                                                    Messages.error(new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), "You can not use booleans in ranges");
                                                                }
                                                            

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
        return expressionType;
    }
    // $ANTLR end "caseExprListItem"


    // $ANTLR start "caseElseBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:446:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:447:2: ( ^( CASE_ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:447:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1551); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1553);
            block();

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
    // $ANTLR end "caseElseBlock"

    public static class expr_return extends TreeRuleReturnScope {
        public Type expressionType;
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:451:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
    public final StaticTypeAnalyzer.expr_return expr() throws RecognitionException {
        StaticTypeAnalyzer.expr_return retval = new StaticTypeAnalyzer.expr_return();
        retval.start = input.LT(1);

        CommonTree AND28=null;
        CommonTree OR29=null;
        CommonTree EQ30=null;
        CommonTree NEQ31=null;
        CommonTree LT32=null;
        CommonTree LE33=null;
        CommonTree GT34=null;
        CommonTree GE35=null;
        CommonTree PLUS36=null;
        CommonTree MINUS37=null;
        CommonTree TIMES38=null;
        CommonTree DIA39=null;
        CommonTree DIV40=null;
        CommonTree MOD41=null;
        CommonTree POW42=null;
        CommonTree ID43=null;
        CommonTree ID44=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript45 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:452:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
            int alt22=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt22=1;
                }
                break;
            case OR:
                {
                alt22=2;
                }
                break;
            case EQ:
                {
                alt22=3;
                }
                break;
            case NEQ:
                {
                alt22=4;
                }
                break;
            case LT:
                {
                alt22=5;
                }
                break;
            case LE:
                {
                alt22=6;
                }
                break;
            case GT:
                {
                alt22=7;
                }
                break;
            case GE:
                {
                alt22=8;
                }
                break;
            case PLUS:
                {
                alt22=9;
                }
                break;
            case MINUS:
                {
                alt22=10;
                }
                break;
            case TIMES:
                {
                alt22=11;
                }
                break;
            case DIA:
                {
                alt22=12;
                }
                break;
            case DIV:
                {
                alt22=13;
                }
                break;
            case MOD:
                {
                alt22=14;
                }
                break;
            case POW:
                {
                alt22=15;
                }
                break;
            case NEG:
                {
                alt22=16;
                }
                break;
            case NOT:
                {
                alt22=17;
                }
                break;
            case CONST_TRUE:
                {
                alt22=18;
                }
                break;
            case CONST_FALSE:
                {
                alt22=19;
                }
                break;
            case CONST_STR:
                {
                alt22=20;
                }
                break;
            case CONST_INT:
                {
                alt22=21;
                }
                break;
            case CONST_REAL:
                {
                alt22=22;
                }
                break;
            case ID:
                {
                alt22=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt22=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:452:4: ^( AND a= expr b= expr )
                    {
                    AND28=(CommonTree)match(input,AND,FOLLOW_AND_in_expr1570); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1574);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1580);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((AND28!=null?AND28.getLine():0), (AND28!=null?AND28.getCharPositionInLine():0)), (AND28!=null?AND28.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:462:4: ^( OR a= expr b= expr )
                    {
                    OR29=(CommonTree)match(input,OR,FOLLOW_OR_in_expr1591); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1595);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1601);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((OR29!=null?OR29.getLine():0), (OR29!=null?OR29.getCharPositionInLine():0)), (OR29!=null?OR29.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:472:4: ^( EQ a= expr b= expr )
                    {
                    EQ30=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1612); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1616);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1622);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((EQ30!=null?EQ30.getLine():0), (EQ30!=null?EQ30.getCharPositionInLine():0)), (EQ30!=null?EQ30.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:482:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ31=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1633); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1637);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1643);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((NEQ31!=null?NEQ31.getLine():0), (NEQ31!=null?NEQ31.getCharPositionInLine():0)), (NEQ31!=null?NEQ31.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:492:4: ^( LT a= expr b= expr )
                    {
                    LT32=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1654); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1658);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1664);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LT32!=null?LT32.getLine():0), (LT32!=null?LT32.getCharPositionInLine():0)), (LT32!=null?LT32.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:502:4: ^( LE a= expr b= expr )
                    {
                    LE33=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1675); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1679);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1685);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LE33!=null?LE33.getLine():0), (LE33!=null?LE33.getCharPositionInLine():0)), (LE33!=null?LE33.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:512:4: ^( GT a= expr b= expr )
                    {
                    GT34=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1696); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1700);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1706);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GT34!=null?GT34.getLine():0), (GT34!=null?GT34.getCharPositionInLine():0)), (GT34!=null?GT34.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:522:4: ^( GE a= expr b= expr )
                    {
                    GE35=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1717); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1721);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1727);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GE35!=null?GE35.getLine():0), (GE35!=null?GE35.getCharPositionInLine():0)), (GE35!=null?GE35.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:532:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS36=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1738); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1742);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1748);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((PLUS36!=null?PLUS36.getLine():0), (PLUS36!=null?PLUS36.getCharPositionInLine():0)), (PLUS36!=null?PLUS36.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:542:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS37=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1759); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1763);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1769);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MINUS37!=null?MINUS37.getLine():0), (MINUS37!=null?MINUS37.getCharPositionInLine():0)), (MINUS37!=null?MINUS37.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:552:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES38=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1780); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1784);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1790);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((TIMES38!=null?TIMES38.getLine():0), (TIMES38!=null?TIMES38.getCharPositionInLine():0)), (TIMES38!=null?TIMES38.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:562:4: ^( DIA a= expr b= expr )
                    {
                    DIA39=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1801); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1805);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1811);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA39!=null?DIA39.getLine():0), (DIA39!=null?DIA39.getCharPositionInLine():0)), (DIA39!=null?DIA39.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:572:4: ^( DIV a= expr b= expr )
                    {
                    DIV40=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1822); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1826);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1832);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.INTEGER;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV40!=null?DIV40.getLine():0), (DIV40!=null?DIV40.getCharPositionInLine():0)), (DIV40!=null?DIV40.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:582:4: ^( MOD a= expr b= expr )
                    {
                    MOD41=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr1843); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1847);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1853);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.INTEGER;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                    (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                    new Point((MOD41!=null?MOD41.getLine():0), (MOD41!=null?MOD41.getCharPositionInLine():0)), (MOD41!=null?MOD41.getText():null)
                                                                                                                                  );
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:592:4: ^( POW a= expr b= expr )
                    {
                    POW42=(CommonTree)match(input,POW,FOLLOW_POW_in_expr1864); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1868);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1874);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;//TODO: (Maybe not needed) If a == int && b == int && b>0 =>  expressionType = Type.INTEGER
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW42!=null?POW42.getLine():0), (POW42!=null?POW42.getCharPositionInLine():0)), (POW42!=null?POW42.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:602:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1885); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1889);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = (a!=null?a.expressionType:null);
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                                        Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 17 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:611:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1910); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1914);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypeForNotExpression((a!=null?a.expressionType:null))){
                                                                            retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.BOOLEAN};
                                                                        Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 18 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:620:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1934); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:621:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1941); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:622:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1948); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:623:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1955); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:624:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1962); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:625:4: ID
                    {
                    ID43=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1969); 

                                            Symbol s = currentScope.referenceSymbol((ID43!=null?ID43.getText():null), new Point((ID43!=null?ID43.getLine():0), (ID43!=null?ID43.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(s, new Point((ID43!=null?ID43.getLine():0), (ID43!=null?ID43.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID43!=null?ID43.getLine():0), (ID43!=null?ID43.getCharPositionInLine():0)), s);
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                        if(!s.isInitialized()){
                                                            Messages.varOrConstNotInitializedButReferencedError(new Point((ID43!=null?ID43.getLine():0), (ID43!=null?ID43.getCharPositionInLine():0)), s);
                                                        }
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:642:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1978); 

                    match(input, Token.DOWN, null); 
                    ID44=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1980); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1982);
                    arraySubscript45=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            Symbol s = currentScope.referenceSymbol((ID44!=null?ID44.getText():null), new Point((ID44!=null?ID44.getLine():0), (ID44!=null?ID44.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        Messages.arrayReferencesInDeclarationsNotAllowedError(s, new Point((ID44!=null?ID44.getLine():0), (ID44!=null?ID44.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript45!=null?arraySubscript45.indicesCount:0);
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript45!=null?((CommonTree)arraySubscript45.start):null).getLine(), (arraySubscript45!=null?((CommonTree)arraySubscript45.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID44!=null?ID44.getLine():0), (ID44!=null?ID44.getCharPositionInLine():0)));
                                                                                }
                                                                            }
                                                                        

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
        return retval;
    }
    // $ANTLR end "expr"

    public static class arraySubscript_return extends TreeRuleReturnScope {
        public int indicesCount;
    };

    // $ANTLR start "arraySubscript"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:664:1: arraySubscript returns [int indicesCount] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr46 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:665:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:665:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript2013); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:668:19: ( expr )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==NEG||LA23_0==ARRAY_ITEM||LA23_0==ID||LA23_0==EQ||(LA23_0>=LT && LA23_0<=GE)||(LA23_0>=OR && LA23_0<=CONST_REAL)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:668:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript2042);
            	    expr46=expr();

            	    state._fsp--;


            	                                            Type type = (expr46!=null?expr46.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    Messages.arrayIndexNotIntegerError(new Point((expr46!=null?((CommonTree)expr46.start):null).getLine(), (expr46!=null?((CommonTree)expr46.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                Messages.arrayIndexNotIntegerError(new Point((expr46!=null?((CommonTree)expr46.start):null).getLine(), (expr46!=null?((CommonTree)expr46.start):null).getCharPositionInLine()));
            	                                            }
            	                                            count++;
            	                                        

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

               retval.indicesCount = count;    

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arraySubscript"

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\15\uffff";
    static final String DFA18_eofS =
        "\15\uffff";
    static final String DFA18_minS =
        "\1\7\2\uffff\1\2\5\uffff\1\17\1\5\2\uffff";
    static final String DFA18_maxS =
        "\1\65\2\uffff\1\2\5\uffff\1\17\1\106\2\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\4\1\3";
    static final String DFA18_specialS =
        "\15\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\4\26\uffff\1\1\1\2\1\3\5\uffff\1\5\7\uffff\1\6\4\uffff\1"+
            "\7\1\uffff\1\10",
            "",
            "",
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\14\3\uffff\1\14\1\13\4\uffff\1\14\4\uffff\1\14\25\uffff"+
            "\4\14\11\uffff\20\14",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "222:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations105 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_varDecl_in_declarations108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign185 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_constAssign187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl224 = new BitSet(new long[]{0x000000003C000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl302 = new BitSet(new long[]{0x0000000000008108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem398 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension475 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block626 = new BitSet(new long[]{0x00284041C0000088L});
    public static final BitSet FOLLOW_PRINT_in_stm640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm645 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});
    public static final BitSet FOLLOW_READ_in_stm668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm670 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm680 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm716 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm718 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm788 = new BitSet(new long[]{0x0000003000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm790 = new BitSet(new long[]{0x0000003000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm793 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm816 = new BitSet(new long[]{0x0000010000002008L});
    public static final BitSet FOLLOW_caseBlock_in_stm845 = new BitSet(new long[]{0x0000010000002008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm910 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm951 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm955 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm959 = new BitSet(new long[]{0xFF803C0000388230L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm964 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_stm968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm1034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm1036 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_stm1038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm1055 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm1057 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm1059 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1093 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1166 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_ifBlock1168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1225 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1301 = new BitSet(new long[]{0xFF803E0000389230L,0x000000000000007FL});
    public static final BitSet FOLLOW_block_in_caseBlock1328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1415 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1437 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1441 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1466 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1495 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1524 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1551 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1574 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1580 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1595 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1601 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1616 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1637 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1658 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1664 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1675 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1679 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1696 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1700 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1721 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1742 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1748 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1763 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1780 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1784 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1805 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1826 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1847 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1853 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1868 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1874 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1885 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1889 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1914 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1978 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1980 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1982 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript2013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript2042 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});

}