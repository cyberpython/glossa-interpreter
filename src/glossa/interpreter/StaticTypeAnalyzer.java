// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/StaticTypeAnalyzer.g 2010-10-23 18:20:13


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

import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.scopes.*;
import glossa.interpreter.symboltable.symbols.*;
import glossa.interpreter.symboltable.types.*;
import glossa.interpreter.messages.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StaticTypeAnalyzer extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "RANGE", "INF_RANGE", "CASE_ELSE", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "DOUBLE_DOT", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=102;
    public static final int LT=42;
    public static final int END_PROCEDURE=99;
    public static final int WHILE=51;
    public static final int LETTER=113;
    public static final int MOD=63;
    public static final int STRINGS=28;
    public static final int LAMDA=88;
    public static final int UPSILON_DIALYTIKA_TONOS=126;
    public static final int CASE=41;
    public static final int NOT=65;
    public static final int OMICRON=78;
    public static final int EOF=-1;
    public static final int DOUBLE_DOT=71;
    public static final int LBRACKET=25;
    public static final int MU=84;
    public static final int TAU=85;
    public static final int POW=64;
    public static final int LPAR=72;
    public static final int UPSILON_TONOS=122;
    public static final int CONT_COMMAND=116;
    public static final int CONST_INT=69;
    public static final int LOOP=52;
    public static final int BEGIN=18;
    public static final int KAPPA=74;
    public static final int EQ=21;
    public static final int COMMENT=115;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=119;
    public static final int END_LOOP=50;
    public static final int GE=45;
    public static final int END_SWITCH=40;
    public static final int CONST_TRUE=66;
    public static final int NU=101;
    public static final int XI=107;
    public static final int SWITCH=39;
    public static final int ELSE=37;
    public static final int DELTA=95;
    public static final int EPSILON=86;
    public static final int CONST_STR=68;
    public static final int INTEGERS=29;
    public static final int ALPHA=75;
    public static final int SIGMA_TELIKO=89;
    public static final int REAL=109;
    public static final int THETA=94;
    public static final int BOOLEANS=27;
    public static final int UPSILON_DIALYTIKA=124;
    public static final int WS=117;
    public static final int OMICRON_TONOS=79;
    public static final int EPSILON_TONOS=87;
    public static final int READ=32;
    public static final int OMEGA=105;
    public static final int UNTIL=54;
    public static final int OR=55;
    public static final int GT=44;
    public static final int ALPHA_TONOS=90;
    public static final int REPEAT=53;
    public static final int CALL=104;
    public static final int PI=81;
    public static final int FROM=47;
    public static final int PHI=121;
    public static final int RHO=82;
    public static final int UPSILON=100;
    public static final int FOR=46;
    public static final int STEP=49;
    public static final int ETA_TONOS=77;
    public static final int CONSTANTS=20;
    public static final int ID=16;
    public static final int AND=56;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=35;
    public static final int OMEGA_TONOS=106;
    public static final int NOT_EOL=114;
    public static final int BOOLEAN=111;
    public static final int THEN=36;
    public static final int END_FUNCTION=103;
    public static final int COMMA=24;
    public static final int ETA=92;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=96;
    public static final int PLUS=58;
    public static final int SIGMA=93;
    public static final int DIGIT=112;
    public static final int CASE_ELSE=14;
    public static final int RBRACKET=26;
    public static final int IOTA_DIALYTIKA_TONOS=125;
    public static final int ELSE_IF=38;
    public static final int CONST_REAL=70;
    public static final int VARSDECL=6;
    public static final int INTEGER=108;
    public static final int INF_RANGE=13;
    public static final int TO=48;
    public static final int LATIN_LETTER=118;
    public static final int REALS=30;
    public static final int RANGE=12;
    public static final int CHI=80;
    public static final int MINUS=59;
    public static final int DIA=61;
    public static final int BETA=91;
    public static final int PRINT=31;
    public static final int PROCEDURE=98;
    public static final int COLON=23;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=57;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=19;
    public static final int ZETA=120;
    public static final int CONST_FALSE=67;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=22;
    public static final int ASSIGN=33;
    public static final int END_IF=34;
    public static final int RPAR=73;
    public static final int PROGRAM=15;
    public static final int IOTA=76;
    public static final int DIV=62;
    public static final int GAMMA=83;
    public static final int TIMES=60;
    public static final int LE=43;
    public static final int IOTA_DIALYTIKA=123;
    public static final int IOTA_TONOS=97;
    public static final int STRING=110;

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:102:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:102:6: ( program )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:102:8: program
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:104:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:104:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:104:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
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

            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:113:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:113:4: id2= ID
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:121:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:4: ( constDecl )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CONSTANTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations105);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:15: ( varDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLES) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:122:15: varDecl
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:124:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:125:4: ^( CONSTANTS ( constAssign )* )
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
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:134:3: ( constAssign )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==EQ) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:134:3: constAssign
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:140:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID2=null;
        StaticTypeAnalyzer.expr_return expr3 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:141:2: ( ^( EQ ID expr ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:141:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign183); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign185); 
            pushFollow(FOLLOW_expr_in_constAssign187);
            expr3=expr();

            state._fsp--;


            match(input, Token.UP, null); 

                                                Constant s = new Constant((ID2!=null?ID2.getText():null), (expr3!=null?expr3.expressionType:null), (ID2!=null?ID2.getLine():0), (ID2!=null?ID2.getCharPositionInLine():0), ID2.getTokenStartIndex(), null);
                                                s.setInitialized((expr3!=null?expr3.expressionType:null)!=null);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:152:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:152:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:152:11: ^( VARIABLES ( varsDecl )* )
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
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:161:3: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:161:3: varsDecl
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:168:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Symbol varDeclItem5 = null;

        Type varType6 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:169:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:169:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType6=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:171:21: ( varDeclItem )+
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
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:171:22: varDeclItem
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:179:1: varDeclItem returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem() throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        List<Integer> arrayDimension9 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:180:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:180:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem362); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex(), null);
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:183:5: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:190:1: arrayDimension returns [List<Integer> dimensions] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final List<Integer> arrayDimension() throws RecognitionException {
        List<Integer> dimensions = null;

        StaticTypeAnalyzer.expr_return expr10 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:191:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:191:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension450); 


                                                    dimensions = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:195:21: ( expr )+
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
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:195:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension475);
            	    expr10=expr();

            	    state._fsp--;


            	                                            Type type = (expr10!=null?expr10.expressionType:null);
            	                                            dimensions.add(new Integer(1));
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:207:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:208:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:208:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType552); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:209:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType559); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:210:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType566); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:211:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType573); 
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block586); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:17: ( stm )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IFNODE||(LA10_0>=PRINT && LA10_0<=ASSIGN)||LA10_0==SWITCH||LA10_0==FOR||LA10_0==WHILE||LA10_0==REPEAT) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:213:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block588);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:218:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );
    public final void stm() throws RecognitionException {
        CommonTree ID11=null;
        CommonTree ASSIGN13=null;
        CommonTree ID14=null;
        CommonTree ASSIGN16=null;
        CommonTree ID18=null;
        StaticTypeAnalyzer.expr_return expr1 = null;

        StaticTypeAnalyzer.expr_return expr2 = null;

        StaticTypeAnalyzer.expr_return expr3 = null;

        StaticTypeAnalyzer.expr_return expr12 = null;

        StaticTypeAnalyzer.expr_return expr15 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript17 = null;

        StaticTypeAnalyzer.expr_return expr19 = null;

        StaticTypeAnalyzer.expr_return expr20 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:218:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) )
            int alt18=9;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:218:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm602); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:218:15: (expr1= expr )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==NEG||LA11_0==ARRAY_ITEM||LA11_0==ID||LA11_0==EQ||(LA11_0>=LT && LA11_0<=GE)||(LA11_0>=OR && LA11_0<=CONST_REAL)) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:218:16: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm607);
                        	    expr1=expr();

                        	    state._fsp--;


                        	                                                   if((expr1!=null?expr1.expressionType:null)==null){
                        	                                                       //TODO :report error - print cannot print null type
                        	                                                   }
                        	                                                

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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:225:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm682); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:225:24: ( readItem )+
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
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:225:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm684);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:226:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm692); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm694); 
                    pushFollow(FOLLOW_expr_in_stm696);
                    expr12=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID11!=null?ID11.getText():null), new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Variable){
                                                                            if((expr12!=null?expr12.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr12!=null?expr12.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)), (expr12!=null?expr12.expressionType:null), new Point((expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine()) ,new Point((ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0)), (ASSIGN13!=null?ASSIGN13.getText():null));
                                                                                }else{
                                                                                    s.setInitialized(true);
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0)), (ASSIGN13!=null?ASSIGN13.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:247:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN16=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm728); 

                    match(input, Token.DOWN, null); 
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_stm730); 
                    pushFollow(FOLLOW_arraySubscript_in_stm732);
                    arraySubscript17=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm734);
                    expr15=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID14!=null?ID14.getText():null), new Point((ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            if((expr15!=null?expr15.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr15!=null?expr15.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0)), (expr15!=null?expr15.expressionType:null), new Point((expr15!=null?((CommonTree)expr15.start):null).getLine(), (expr15!=null?((CommonTree)expr15.start):null).getCharPositionInLine()) ,new Point((ASSIGN16!=null?ASSIGN16.getLine():0), (ASSIGN16!=null?ASSIGN16.getCharPositionInLine():0)), (ASSIGN16!=null?ASSIGN16.getText():null));
                                                                                }else{
                                                                                    Array arr = (Array)s;
                                                                                    int indicesCount = (arraySubscript17!=null?arraySubscript17.indices:null).size();
                                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                                        Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getLine(), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                    }else{
                                                                                        s.setInitialized(true);
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr15!=null?((CommonTree)expr15.start):null).getLine(), (expr15!=null?((CommonTree)expr15.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN16!=null?ASSIGN16.getLine():0), (ASSIGN16!=null?ASSIGN16.getCharPositionInLine():0)), (ASSIGN16!=null?ASSIGN16.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                                Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:275:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm800); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm802);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:275:34: ( elseIfBlock )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ELSE_IF) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:275:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm804);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:275:47: ( elseBlock )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ELSE) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:275:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm807);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:276:17: ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? )
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_stm828); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm830);
                    expr();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:276:31: ( caseBlock )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==CASE) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:276:31: caseBlock
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm832);
                    	    caseBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:276:42: ( caseElseBlock )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==CASE_ELSE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:276:42: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm835);
                            caseElseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:277:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm856); 

                    match(input, Token.DOWN, null); 
                    ID18=(CommonTree)match(input,ID,FOLLOW_ID_in_stm858); 
                    pushFollow(FOLLOW_expr_in_stm862);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm866);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:277:48: (expr3= expr )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==NEG||LA17_0==ARRAY_ITEM||LA17_0==ID||LA17_0==EQ||(LA17_0>=LT && LA17_0<=GE)||(LA17_0>=OR && LA17_0<=CONST_REAL)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:277:49: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm871);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm875);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID18!=null?ID18.getText():null), new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                         if(s instanceof Variable){
                                                                            if(TypeUtils.isNumericType(s.getType())){
                                                                                if(TypeUtils.isNumericType((expr1!=null?expr1.expressionType:null)) && TypeUtils.isNumericType((expr2!=null?expr2.expressionType:null)) ){
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
                                                                                            if(!TypeUtils.isNumericType((expr3!=null?expr3.expressionType:null))){
                                                                                                Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    if(!TypeUtils.isNumericType((expr1!=null?expr1.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                    }
                                                                                    if(!TypeUtils.isNumericType((expr2!=null?expr2.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericType(new Point((expr2!=null?((CommonTree)expr2.start):null).getLine(), (expr2!=null?((CommonTree)expr2.start):null).getCharPositionInLine()), (expr2!=null?expr2.expressionType:null));
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.forCounterMustBeOfNumericType(new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)), s.getType());
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:316:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm941); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm943);
                    expr19=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm945);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr19!=null?expr19.expressionType:null)!=null){
                                                                        if(!(expr19!=null?expr19.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBoolean(new Point((expr19!=null?((CommonTree)expr19.start):null).getLine(), (expr19!=null?((CommonTree)expr19.start):null).getCharPositionInLine()) , (expr19!=null?expr19.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBoolean(new Point((expr19!=null?((CommonTree)expr19.start):null).getLine(), (expr19!=null?((CommonTree)expr19.start):null).getCharPositionInLine()) , null);
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:325:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm962); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm964);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm966);
                    expr20=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr20!=null?expr20.expressionType:null)!=null){
                                                                        if(!(expr20!=null?expr20.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBoolean(new Point((expr20!=null?((CommonTree)expr20.start):null).getLine(), (expr20!=null?((CommonTree)expr20.start):null).getCharPositionInLine()) , (expr20!=null?expr20.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBoolean(new Point((expr20!=null?((CommonTree)expr20.start):null).getLine(), (expr20!=null?((CommonTree)expr20.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:336:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript21 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:336:9: (arrId= ID arraySubscript | varId= ID )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==UP||LA19_1==ID) ) {
                    alt19=2;
                }
                else if ( (LA19_1==ARRAY_INDEX) ) {
                    alt19=1;
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:336:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1000); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1002);
                    arraySubscript21=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol((arrId!=null?arrId.getText():null), new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            Type t = arr.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)), t);
                                                                            }else{
                                                                                int indicesCount = (arraySubscript21!=null?arraySubscript21.indices:null).size();
                                                                                if(arr.getNumberOfDimensions() != indicesCount){
                                                                                    Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript21!=null?((CommonTree)arraySubscript21.start):null).getLine(), (arraySubscript21!=null?((CommonTree)arraySubscript21.start):null).getCharPositionInLine()), arr, indicesCount);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:357:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1026); 

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:374:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr22 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:374:9: ( ^( IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:374:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1071); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1073);
            expr22=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1075);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr22!=null?expr22.expressionType:null)!=null){
                                                                if(!(expr22!=null?expr22.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr22!=null?((CommonTree)expr22.start):null).getLine(), (expr22!=null?((CommonTree)expr22.start):null).getCharPositionInLine()) , (expr22!=null?expr22.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr22!=null?((CommonTree)expr22.start):null).getLine(), (expr22!=null?((CommonTree)expr22.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:385:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:386:2: ( ^( ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:386:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1108); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1110);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:389:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr23 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:390:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:390:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1130); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1132);
            expr23=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1134);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr23!=null?expr23.expressionType:null)!=null){
                                                                if(!(expr23!=null?expr23.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr23!=null?((CommonTree)expr23.start):null).getLine(), (expr23!=null?((CommonTree)expr23.start):null).getCharPositionInLine()) , (expr23!=null?expr23.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr23!=null?((CommonTree)expr23.start):null).getLine(), (expr23!=null?((CommonTree)expr23.start):null).getCharPositionInLine()) , null);
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


    // $ANTLR start "caseBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:402:1: caseBlock : ^( CASE ( caseExprListItem )+ block ) ;
    public final void caseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:403:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:403:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1163); 

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:403:11: ( caseExprListItem )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==NEG||LA20_0==ARRAY_ITEM||(LA20_0>=RANGE && LA20_0<=INF_RANGE)||LA20_0==ID||LA20_0==EQ||(LA20_0>=LT && LA20_0<=GE)||(LA20_0>=OR && LA20_0<=CONST_REAL)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:403:11: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1165);
            	    caseExprListItem();

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

            pushFollow(FOLLOW_block_in_caseBlock1168);
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
    // $ANTLR end "caseBlock"


    // $ANTLR start "caseExprListItem"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:405:1: caseExprListItem : ( expr | ^( RANGE expr expr ) | ^( INF_RANGE LT expr ) | ^( INF_RANGE LE expr ) | ^( INF_RANGE GT expr ) | ^( INF_RANGE GE expr ) );
    public final void caseExprListItem() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:406:2: ( expr | ^( RANGE expr expr ) | ^( INF_RANGE LT expr ) | ^( INF_RANGE LE expr ) | ^( INF_RANGE GT expr ) | ^( INF_RANGE GE expr ) )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:406:4: expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1178);
                    expr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:407:10: ^( RANGE expr expr )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1190); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1192);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1194);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:408:10: ^( INF_RANGE LT expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1207); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1209); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1211);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:409:17: ^( INF_RANGE LE expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1231); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1233); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1235);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:410:17: ^( INF_RANGE GT expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1255); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1257); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1259);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:411:17: ^( INF_RANGE GE expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1279); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1281); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1283);
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
    // $ANTLR end "caseExprListItem"


    // $ANTLR start "caseElseBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:414:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:415:2: ( ^( CASE_ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:415:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1303); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1305);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:419:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
    public final StaticTypeAnalyzer.expr_return expr() throws RecognitionException {
        StaticTypeAnalyzer.expr_return retval = new StaticTypeAnalyzer.expr_return();
        retval.start = input.LT(1);

        CommonTree AND24=null;
        CommonTree OR25=null;
        CommonTree EQ26=null;
        CommonTree NEQ27=null;
        CommonTree LT28=null;
        CommonTree LE29=null;
        CommonTree GT30=null;
        CommonTree GE31=null;
        CommonTree PLUS32=null;
        CommonTree MINUS33=null;
        CommonTree TIMES34=null;
        CommonTree DIA35=null;
        CommonTree DIV36=null;
        CommonTree MOD37=null;
        CommonTree POW38=null;
        CommonTree ID39=null;
        CommonTree ID40=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript41 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:420:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:420:4: ^( AND a= expr b= expr )
                    {
                    AND24=(CommonTree)match(input,AND,FOLLOW_AND_in_expr1322); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1326);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1332);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((AND24!=null?AND24.getLine():0), (AND24!=null?AND24.getCharPositionInLine():0)), (AND24!=null?AND24.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:430:4: ^( OR a= expr b= expr )
                    {
                    OR25=(CommonTree)match(input,OR,FOLLOW_OR_in_expr1343); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1347);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1353);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((OR25!=null?OR25.getLine():0), (OR25!=null?OR25.getCharPositionInLine():0)), (OR25!=null?OR25.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:440:4: ^( EQ a= expr b= expr )
                    {
                    EQ26=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1364); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1368);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1374);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((EQ26!=null?EQ26.getLine():0), (EQ26!=null?EQ26.getCharPositionInLine():0)), (EQ26!=null?EQ26.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:450:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ27=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1385); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1389);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1395);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((NEQ27!=null?NEQ27.getLine():0), (NEQ27!=null?NEQ27.getCharPositionInLine():0)), (NEQ27!=null?NEQ27.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:460:4: ^( LT a= expr b= expr )
                    {
                    LT28=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1406); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1410);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1416);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LT28!=null?LT28.getLine():0), (LT28!=null?LT28.getCharPositionInLine():0)), (LT28!=null?LT28.getText():null)
                                                                                                                                      );
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LT28!=null?LT28.getLine():0), (LT28!=null?LT28.getCharPositionInLine():0)), (LT28!=null?LT28.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LT28!=null?LT28.getLine():0), (LT28!=null?LT28.getCharPositionInLine():0)), (LT28!=null?LT28.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:484:4: ^( LE a= expr b= expr )
                    {
                    LE29=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1427); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1431);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1437);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LE29!=null?LE29.getLine():0), (LE29!=null?LE29.getCharPositionInLine():0)), (LE29!=null?LE29.getText():null)
                                                                                                                                      );
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LE29!=null?LE29.getLine():0), (LE29!=null?LE29.getCharPositionInLine():0)), (LE29!=null?LE29.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LE29!=null?LE29.getLine():0), (LE29!=null?LE29.getCharPositionInLine():0)), (LE29!=null?LE29.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:508:4: ^( GT a= expr b= expr )
                    {
                    GT30=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1448); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1452);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1458);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GT30!=null?GT30.getLine():0), (GT30!=null?GT30.getCharPositionInLine():0)), (GT30!=null?GT30.getText():null)
                                                                                                                                      );
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GT30!=null?GT30.getLine():0), (GT30!=null?GT30.getCharPositionInLine():0)), (GT30!=null?GT30.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GT30!=null?GT30.getLine():0), (GT30!=null?GT30.getCharPositionInLine():0)), (GT30!=null?GT30.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:532:4: ^( GE a= expr b= expr )
                    {
                    GE31=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1469); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1473);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1479);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GE31!=null?GE31.getLine():0), (GE31!=null?GE31.getCharPositionInLine():0)), (GE31!=null?GE31.getText():null)
                                                                                                                                      );
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GE31!=null?GE31.getLine():0), (GE31!=null?GE31.getCharPositionInLine():0)), (GE31!=null?GE31.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GE31!=null?GE31.getLine():0), (GE31!=null?GE31.getCharPositionInLine():0)), (GE31!=null?GE31.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:556:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS32=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1490); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1494);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1500);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((PLUS32!=null?PLUS32.getLine():0), (PLUS32!=null?PLUS32.getCharPositionInLine():0)), (PLUS32!=null?PLUS32.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:566:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS33=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1511); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1515);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1521);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MINUS33!=null?MINUS33.getLine():0), (MINUS33!=null?MINUS33.getCharPositionInLine():0)), (MINUS33!=null?MINUS33.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:576:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES34=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1532); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1536);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1542);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((TIMES34!=null?TIMES34.getLine():0), (TIMES34!=null?TIMES34.getCharPositionInLine():0)), (TIMES34!=null?TIMES34.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:586:4: ^( DIA a= expr b= expr )
                    {
                    DIA35=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1553); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1557);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1563);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA35!=null?DIA35.getLine():0), (DIA35!=null?DIA35.getCharPositionInLine():0)), (DIA35!=null?DIA35.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:596:4: ^( DIV a= expr b= expr )
                    {
                    DIV36=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1574); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1578);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1584);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.INTEGER) && (b!=null?b.expressionType:null).equals(Type.INTEGER)){
                                                                            retval.expressionType = Type.INTEGER;
                                                                        }else{
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV36!=null?DIV36.getLine():0), (DIV36!=null?DIV36.getCharPositionInLine():0)), (DIV36!=null?DIV36.getText():null)
                                                                                                                              );
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV36!=null?DIV36.getLine():0), (DIV36!=null?DIV36.getCharPositionInLine():0)), (DIV36!=null?DIV36.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:613:4: ^( MOD a= expr b= expr )
                    {
                    MOD37=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr1595); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1599);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1605);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.INTEGER) && (b!=null?b.expressionType:null).equals(Type.INTEGER)){
                                                                            retval.expressionType = Type.INTEGER;
                                                                        }else{
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                    (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                    new Point((MOD37!=null?MOD37.getLine():0), (MOD37!=null?MOD37.getCharPositionInLine():0)), (MOD37!=null?MOD37.getText():null)
                                                                                                                                  );
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MOD37!=null?MOD37.getLine():0), (MOD37!=null?MOD37.getCharPositionInLine():0)), (MOD37!=null?MOD37.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:630:4: ^( POW a= expr b= expr )
                    {
                    POW38=(CommonTree)match(input,POW,FOLLOW_POW_in_expr1616); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1620);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1626);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;//TODO: If a == int && b == int && b>0 =>  expressionType = Type.INTEGER
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW38!=null?POW38.getLine():0), (POW38!=null?POW38.getCharPositionInLine():0)), (POW38!=null?POW38.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:640:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1637); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1641);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = (a!=null?a.expressionType:null);
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                                        Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 17 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:649:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1662); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1666);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                            retval.expressionType = Type.BOOLEAN;
                                                                        }else{
                                                                            Type[] requiredTypes = {Type.BOOLEAN};
                                                                            Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                        }
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.BOOLEAN};
                                                                        Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 18 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:664:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1686); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:665:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1693); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:666:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1700); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:667:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1707); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:668:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1714); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:669:4: ID
                    {
                    ID39=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1721); 

                                            Symbol s = currentScope.referenceSymbol((ID39!=null?ID39.getText():null), new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(s, new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)), s);
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                        if(!s.isInitialized()){
                                                            Messages.varOrConstNotInitializedButReferencedError(new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)), s);
                                                        }
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:686:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1730); 

                    match(input, Token.DOWN, null); 
                    ID40=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1732); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1734);
                    arraySubscript41=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            Symbol s = currentScope.referenceSymbol((ID40!=null?ID40.getText():null), new Point((ID40!=null?ID40.getLine():0), (ID40!=null?ID40.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        Messages.arrayReferencesInDeclarationsNotAllowedError(s, new Point((ID40!=null?ID40.getLine():0), (ID40!=null?ID40.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript41!=null?arraySubscript41.indices:null).size();
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript41!=null?((CommonTree)arraySubscript41.start):null).getLine(), (arraySubscript41!=null?((CommonTree)arraySubscript41.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }else{
                                                                                            if(!arr.isInitialized()){
                                                                                                Messages.arrayItemNotInitializedButReferencedError(new Point((ID40!=null?ID40.getLine():0), (ID40!=null?ID40.getCharPositionInLine():0)), arr, (arraySubscript41!=null?arraySubscript41.indices:null));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID40!=null?ID40.getLine():0), (ID40!=null?ID40.getCharPositionInLine():0)));
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
        public List<Integer> indices;
    };

    // $ANTLR start "arraySubscript"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:712:1: arraySubscript returns [List<Integer> indices] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr42 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:713:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:713:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript1765); 


                                                    retval.indices = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:716:19: ( expr )+
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
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:716:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript1794);
            	    expr42=expr();

            	    state._fsp--;


            	                                            Type type = (expr42!=null?expr42.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    Messages.arrayIndexNotIntegerError(new Point((expr42!=null?((CommonTree)expr42.start):null).getLine(), (expr42!=null?((CommonTree)expr42.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                Messages.arrayIndexNotIntegerError(new Point((expr42!=null?((CommonTree)expr42.start):null).getLine(), (expr42!=null?((CommonTree)expr42.start):null).getCharPositionInLine()));
            	                                            }
            	                                            retval.indices.add(new Integer(1));
            	                                        

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
        "\1\7\2\uffff\1\2\5\uffff\1\20\1\5\2\uffff";
    static final String DFA18_maxS =
        "\1\65\2\uffff\1\2\5\uffff\1\20\1\106\2\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\4\1\3";
    static final String DFA18_specialS =
        "\15\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\4\27\uffff\1\1\1\2\1\3\5\uffff\1\5\6\uffff\1\6\4\uffff\1"+
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
            "\1\14\3\uffff\1\14\1\13\5\uffff\1\14\4\uffff\1\14\24\uffff"+
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
            return "218:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations105 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_varDecl_in_declarations108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign185 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_constAssign187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl224 = new BitSet(new long[]{0x0000000078000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl302 = new BitSet(new long[]{0x0000000000010108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem398 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension475 = new BitSet(new long[]{0xFF803C0000210228L,0x000000000000007FL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block588 = new BitSet(new long[]{0x0028408380000088L});
    public static final BitSet FOLLOW_PRINT_in_stm602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm607 = new BitSet(new long[]{0xFF803C0000210228L,0x000000000000007FL});
    public static final BitSet FOLLOW_READ_in_stm682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm684 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm692 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm694 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm696 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm728 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm730 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm732 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm734 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm802 = new BitSet(new long[]{0x0000006000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm804 = new BitSet(new long[]{0x0000006000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm830 = new BitSet(new long[]{0x0000020000004008L});
    public static final BitSet FOLLOW_caseBlock_in_stm832 = new BitSet(new long[]{0x0000020000004008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm835 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm856 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm858 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm862 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm866 = new BitSet(new long[]{0xFF803C0000710230L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm871 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_block_in_stm875 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm941 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm943 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_block_in_stm945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm962 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm964 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm966 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1000 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1071 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1073 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_block_in_ifBlock1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1132 = new BitSet(new long[]{0x0000000000500010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1165 = new BitSet(new long[]{0xFF803C0000713230L,0x000000000000007FL});
    public static final BitSet FOLLOW_block_in_caseBlock1168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1192 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1207 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1209 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1211 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1233 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1257 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1281 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1305 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1326 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1347 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1364 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1368 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1374 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1389 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1395 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1410 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1416 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1431 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1448 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1452 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1473 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1479 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1494 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1500 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1511 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1515 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1536 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1557 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1578 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1584 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1599 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1620 = new BitSet(new long[]{0xFF803C0000210220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1637 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1666 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1730 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1732 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1734 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript1765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1794 = new BitSet(new long[]{0xFF803C0000210228L,0x000000000000007FL});

}