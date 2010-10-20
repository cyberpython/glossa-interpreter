// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/StaticTypeAnalyzer.g 2010-10-20 21:11:42


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
    public static final int LPAR=57;
    public static final int UPSILON_TONOS=119;
    public static final int CONT_COMMAND=113;
    public static final int CONST_INT=54;
    public static final int BEGIN=15;
    public static final int LOOP=97;
    public static final int KAPPA=59;
    public static final int EQ=18;
    public static final int COMMENT=112;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=116;
    public static final int END_LOOP=98;
    public static final int GE=42;
    public static final int END_SWITCH=95;
    public static final int NU=86;
    public static final int CONST_TRUE=51;
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
    public static final int PROCEDURE=83;
    public static final int PRINT=28;
    public static final int COLON=20;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=38;
    public static final int NEWLINE=14;
    public static final int END_PROGRAM=16;
    public static final int ZETA=117;
    public static final int CONST_FALSE=52;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=19;
    public static final int ASSIGN=30;
    public static final int END_IF=31;
    public static final int RPAR=58;
    public static final int PROGRAM=12;
    public static final int IOTA=61;
    public static final int DIV=47;
    public static final int GAMMA=68;
    public static final int TIMES=45;
    public static final int LE=40;
    public static final int IOTA_DIALYTIKA=120;
    public static final int IOTA_TONOS=82;
    public static final int STRING=107;

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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:151:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:151:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:151:11: ^( VARIABLES ( varsDecl )* )
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
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:160:3: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:160:3: varsDecl
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:167:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Symbol varDeclItem5 = null;

        Type varType6 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:168:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:168:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType6=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:170:21: ( varDeclItem )+
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
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:170:22: varDeclItem
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:178:1: varDeclItem returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem() throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        List<Integer> arrayDimension9 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:179:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:179:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem362); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex(), null);
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:182:5: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:189:1: arrayDimension returns [List<Integer> dimensions] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final List<Integer> arrayDimension() throws RecognitionException {
        List<Integer> dimensions = null;

        StaticTypeAnalyzer.expr_return expr10 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:190:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:190:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension450); 


                                                    dimensions = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:194:21: ( expr )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==NEG||LA8_0==ARRAY_ITEM||LA8_0==ID||LA8_0==EQ||(LA8_0>=AND && LA8_0<=CONST_REAL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:194:22: expr
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:206:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:207:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:207:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType552); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:208:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType559); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:209:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType566); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:210:4: REALS
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block586); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:17: ( stm )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IFNODE||(LA10_0>=PRINT && LA10_0<=ASSIGN)) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:212:17: stm
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:1: stm : ( ^( PRINT ( expr )+ ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) );
    public final void stm() throws RecognitionException {
        CommonTree ID12=null;
        CommonTree ASSIGN14=null;
        CommonTree ID15=null;
        CommonTree ASSIGN17=null;
        StaticTypeAnalyzer.expr_return expr11 = null;

        StaticTypeAnalyzer.expr_return expr13 = null;

        StaticTypeAnalyzer.expr_return expr16 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript18 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:5: ( ^( PRINT ( expr )+ ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case PRINT:
                {
                alt15=1;
                }
                break;
            case READ:
                {
                alt15=2;
                }
                break;
            case ASSIGN:
                {
                int LA15_3 = input.LA(2);

                if ( (LA15_3==DOWN) ) {
                    int LA15_5 = input.LA(3);

                    if ( (LA15_5==ID) ) {
                        int LA15_6 = input.LA(4);

                        if ( (LA15_6==NEG||LA15_6==ARRAY_ITEM||LA15_6==ID||LA15_6==EQ||(LA15_6>=AND && LA15_6<=CONST_REAL)) ) {
                            alt15=3;
                        }
                        else if ( (LA15_6==ARRAY_INDEX) ) {
                            alt15=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;
                }
                }
                break;
            case IFNODE:
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:7: ^( PRINT ( expr )+ )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm602); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:15: ( expr )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==NEG||LA11_0==ARRAY_ITEM||LA11_0==ID||LA11_0==EQ||(LA11_0>=AND && LA11_0<=CONST_REAL)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_stm604);
                    	    expr11=expr();

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

                                                                   if((expr11!=null?expr11.expressionType:null)==null){
                                                                       //TODO :report error - print cannot print null type
                                                                   }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm640); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:24: ( readItem )+
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
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm642);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:223:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN14=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm650); 

                    match(input, Token.DOWN, null); 
                    ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_stm652); 
                    pushFollow(FOLLOW_expr_in_stm654);
                    expr13=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID12!=null?ID12.getText():null), new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Variable){
                                                                            if((expr13!=null?expr13.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr13!=null?expr13.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)), (expr13!=null?expr13.expressionType:null), new Point((expr13!=null?((CommonTree)expr13.start):null).getLine(), (expr13!=null?((CommonTree)expr13.start):null).getCharPositionInLine()) ,new Point((ASSIGN14!=null?ASSIGN14.getLine():0), (ASSIGN14!=null?ASSIGN14.getCharPositionInLine():0)), (ASSIGN14!=null?ASSIGN14.getText():null));
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr13!=null?((CommonTree)expr13.start):null).getLine(), (expr13!=null?((CommonTree)expr13.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN14!=null?ASSIGN14.getLine():0), (ASSIGN14!=null?ASSIGN14.getCharPositionInLine():0)), (ASSIGN14!=null?ASSIGN14.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:242:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN17=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm686); 

                    match(input, Token.DOWN, null); 
                    ID15=(CommonTree)match(input,ID,FOLLOW_ID_in_stm688); 
                    pushFollow(FOLLOW_arraySubscript_in_stm690);
                    arraySubscript18=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm692);
                    expr16=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID15!=null?ID15.getText():null), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            if((expr16!=null?expr16.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr16!=null?expr16.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)), (expr16!=null?expr16.expressionType:null), new Point((expr16!=null?((CommonTree)expr16.start):null).getLine(), (expr16!=null?((CommonTree)expr16.start):null).getCharPositionInLine()) ,new Point((ASSIGN17!=null?ASSIGN17.getLine():0), (ASSIGN17!=null?ASSIGN17.getCharPositionInLine():0)), (ASSIGN17!=null?ASSIGN17.getText():null));
                                                                                }else{
                                                                                    Array arr = (Array)s;
                                                                                    int indicesCount = (arraySubscript18!=null?arraySubscript18.indices:null).size();
                                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                                        Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript18!=null?((CommonTree)arraySubscript18.start):null).getLine(), (arraySubscript18!=null?((CommonTree)arraySubscript18.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr16!=null?((CommonTree)expr16.start):null).getLine(), (expr16!=null?((CommonTree)expr16.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN17!=null?ASSIGN17.getLine():0), (ASSIGN17!=null?ASSIGN17.getCharPositionInLine():0)), (ASSIGN17!=null?ASSIGN17.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                                Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:268:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm758); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm760);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:268:34: ( elseIfBlock )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ELSE_IF) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:268:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm762);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:268:47: ( elseBlock )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ELSE) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:268:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm765);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


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


    // $ANTLR start "readItem"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:271:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript19 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:271:9: (arrId= ID arraySubscript | varId= ID )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==UP||LA16_1==ID) ) {
                    alt16=2;
                }
                else if ( (LA16_1==ARRAY_INDEX) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:271:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem791); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem793);
                    arraySubscript19=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol((arrId!=null?arrId.getText():null), new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            int indicesCount = (arraySubscript19!=null?arraySubscript19.indices:null).size();
                                                                            if(arr.getNumberOfDimensions() != indicesCount){
                                                                                Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript19!=null?((CommonTree)arraySubscript19.start):null).getLine(), (arraySubscript19!=null?((CommonTree)arraySubscript19.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                            }
                                                                        }else{
                                                                            Messages.nonArraySymbolReferencedAsSuchError(s, new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:285:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem817); 

                                                                    Symbol s = currentScope.referenceSymbol((varId!=null?varId.getText():null), new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(!(s instanceof Variable)){
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)), s);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:295:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr20 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:295:9: ( ^( IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:295:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock862); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock864);
            expr20=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock866);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr20!=null?expr20.expressionType:null)!=null){
                                                                if(!(expr20!=null?expr20.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr20!=null?((CommonTree)expr20.start):null).getLine(), (expr20!=null?((CommonTree)expr20.start):null).getCharPositionInLine()) , (expr20!=null?expr20.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr20!=null?((CommonTree)expr20.start):null).getLine(), (expr20!=null?((CommonTree)expr20.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:306:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:307:2: ( ^( ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:307:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock899); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock901);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:310:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr21 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:311:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:311:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock921); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock923);
            expr21=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock925);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr21!=null?expr21.expressionType:null)!=null){
                                                                if(!(expr21!=null?expr21.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBoolean(new Point((expr21!=null?((CommonTree)expr21.start):null).getLine(), (expr21!=null?((CommonTree)expr21.start):null).getCharPositionInLine()) , (expr21!=null?expr21.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBoolean(new Point((expr21!=null?((CommonTree)expr21.start):null).getLine(), (expr21!=null?((CommonTree)expr21.start):null).getCharPositionInLine()) , null);
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

    public static class expr_return extends TreeRuleReturnScope {
        public Type expressionType;
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:325:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
    public final StaticTypeAnalyzer.expr_return expr() throws RecognitionException {
        StaticTypeAnalyzer.expr_return retval = new StaticTypeAnalyzer.expr_return();
        retval.start = input.LT(1);

        CommonTree AND22=null;
        CommonTree OR23=null;
        CommonTree EQ24=null;
        CommonTree NEQ25=null;
        CommonTree LT26=null;
        CommonTree LE27=null;
        CommonTree GT28=null;
        CommonTree GE29=null;
        CommonTree PLUS30=null;
        CommonTree MINUS31=null;
        CommonTree TIMES32=null;
        CommonTree DIA33=null;
        CommonTree DIV34=null;
        CommonTree MOD35=null;
        CommonTree POW36=null;
        CommonTree ID37=null;
        CommonTree ID38=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript39 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:326:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
            int alt17=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt17=1;
                }
                break;
            case OR:
                {
                alt17=2;
                }
                break;
            case EQ:
                {
                alt17=3;
                }
                break;
            case NEQ:
                {
                alt17=4;
                }
                break;
            case LT:
                {
                alt17=5;
                }
                break;
            case LE:
                {
                alt17=6;
                }
                break;
            case GT:
                {
                alt17=7;
                }
                break;
            case GE:
                {
                alt17=8;
                }
                break;
            case PLUS:
                {
                alt17=9;
                }
                break;
            case MINUS:
                {
                alt17=10;
                }
                break;
            case TIMES:
                {
                alt17=11;
                }
                break;
            case DIA:
                {
                alt17=12;
                }
                break;
            case DIV:
                {
                alt17=13;
                }
                break;
            case MOD:
                {
                alt17=14;
                }
                break;
            case POW:
                {
                alt17=15;
                }
                break;
            case NEG:
                {
                alt17=16;
                }
                break;
            case NOT:
                {
                alt17=17;
                }
                break;
            case CONST_TRUE:
                {
                alt17=18;
                }
                break;
            case CONST_FALSE:
                {
                alt17=19;
                }
                break;
            case CONST_STR:
                {
                alt17=20;
                }
                break;
            case CONST_INT:
                {
                alt17=21;
                }
                break;
            case CONST_REAL:
                {
                alt17=22;
                }
                break;
            case ID:
                {
                alt17=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt17=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:326:4: ^( AND a= expr b= expr )
                    {
                    AND22=(CommonTree)match(input,AND,FOLLOW_AND_in_expr960); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr964);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr970);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((AND22!=null?AND22.getLine():0), (AND22!=null?AND22.getCharPositionInLine():0)), (AND22!=null?AND22.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:336:4: ^( OR a= expr b= expr )
                    {
                    OR23=(CommonTree)match(input,OR,FOLLOW_OR_in_expr981); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr985);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr991);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((OR23!=null?OR23.getLine():0), (OR23!=null?OR23.getCharPositionInLine():0)), (OR23!=null?OR23.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:346:4: ^( EQ a= expr b= expr )
                    {
                    EQ24=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1002); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1006);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1012);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((EQ24!=null?EQ24.getLine():0), (EQ24!=null?EQ24.getCharPositionInLine():0)), (EQ24!=null?EQ24.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:356:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ25=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1023); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1027);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1033);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((NEQ25!=null?NEQ25.getLine():0), (NEQ25!=null?NEQ25.getCharPositionInLine():0)), (NEQ25!=null?NEQ25.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:366:4: ^( LT a= expr b= expr )
                    {
                    LT26=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1044); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1048);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1054);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Type[] requiredTypes = {Type.INTEGER, Type.REAL, Type.STRING};
                                                                            if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                            }
                                                                            if((b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (b!=null?b.expressionType:null), requiredTypes,
                                                                                                                                   new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()));
                                                                            }
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LT26!=null?LT26.getLine():0), (LT26!=null?LT26.getCharPositionInLine():0)), (LT26!=null?LT26.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LT26!=null?LT26.getLine():0), (LT26!=null?LT26.getCharPositionInLine():0)), (LT26!=null?LT26.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:395:4: ^( LE a= expr b= expr )
                    {
                    LE27=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1065); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1069);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1075);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Type[] requiredTypes = {Type.INTEGER, Type.REAL, Type.STRING};
                                                                            if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                            }
                                                                            if((b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (b!=null?b.expressionType:null), requiredTypes,
                                                                                                                                   new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()));
                                                                            }
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LE27!=null?LE27.getLine():0), (LE27!=null?LE27.getCharPositionInLine():0)), (LE27!=null?LE27.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LE27!=null?LE27.getLine():0), (LE27!=null?LE27.getCharPositionInLine():0)), (LE27!=null?LE27.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:424:4: ^( GT a= expr b= expr )
                    {
                    GT28=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1086); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1090);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1096);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Type[] requiredTypes = {Type.INTEGER, Type.REAL, Type.STRING};
                                                                            if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                            }
                                                                            if((b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (b!=null?b.expressionType:null), requiredTypes,
                                                                                                                                   new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()));
                                                                            }
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GT28!=null?GT28.getLine():0), (GT28!=null?GT28.getCharPositionInLine():0)), (GT28!=null?GT28.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GT28!=null?GT28.getLine():0), (GT28!=null?GT28.getCharPositionInLine():0)), (GT28!=null?GT28.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:453:4: ^( GE a= expr b= expr )
                    {
                    GE29=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1107); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1111);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1117);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.BOOLEAN) || (b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Type[] requiredTypes = {Type.INTEGER, Type.REAL, Type.STRING};
                                                                            if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                            }
                                                                            if((b!=null?b.expressionType:null).equals(Type.BOOLEAN)){
                                                                                Messages.incompatibleTypeFoundError( (b!=null?b.expressionType:null), requiredTypes,
                                                                                                                                   new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()));
                                                                            }
                                                                        }else{
                                                                            if(TypeUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                                retval.expressionType = Type.BOOLEAN;
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GE29!=null?GE29.getLine():0), (GE29!=null?GE29.getCharPositionInLine():0)), (GE29!=null?GE29.getText():null)
                                                                                                                                      );
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GE29!=null?GE29.getLine():0), (GE29!=null?GE29.getCharPositionInLine():0)), (GE29!=null?GE29.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:482:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS30=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1128); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1132);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1138);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((PLUS30!=null?PLUS30.getLine():0), (PLUS30!=null?PLUS30.getCharPositionInLine():0)), (PLUS30!=null?PLUS30.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:492:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS31=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1149); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1153);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1159);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MINUS31!=null?MINUS31.getLine():0), (MINUS31!=null?MINUS31.getCharPositionInLine():0)), (MINUS31!=null?MINUS31.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:502:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES32=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1170); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1174);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1180);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((TIMES32!=null?TIMES32.getLine():0), (TIMES32!=null?TIMES32.getCharPositionInLine():0)), (TIMES32!=null?TIMES32.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:512:4: ^( DIA a= expr b= expr )
                    {
                    DIA33=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1191); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1195);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1201);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA33!=null?DIA33.getLine():0), (DIA33!=null?DIA33.getCharPositionInLine():0)), (DIA33!=null?DIA33.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:522:4: ^( DIV a= expr b= expr )
                    {
                    DIV34=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1212); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1216);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1222);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.INTEGER) && (b!=null?b.expressionType:null).equals(Type.INTEGER)){
                                                                            retval.expressionType = Type.INTEGER;
                                                                        }else{
                                                                            Type[] requiredTypes = {Type.INTEGER};
                                                                            if(!(a!=null?a.expressionType:null).equals(Type.INTEGER)){
                                                                                Messages.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                                   new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                            }
                                                                            if(!(b!=null?b.expressionType:null).equals(Type.INTEGER)){
                                                                                Messages.incompatibleTypeFoundError( (b!=null?b.expressionType:null), requiredTypes,
                                                                                                                                   new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()));
                                                                            }
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV34!=null?DIV34.getLine():0), (DIV34!=null?DIV34.getCharPositionInLine():0)), (DIV34!=null?DIV34.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:544:4: ^( MOD a= expr b= expr )
                    {
                    MOD35=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr1233); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1237);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1243);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null)!=null && (b!=null?b.expressionType:null)!=null){
                                                                        if((a!=null?a.expressionType:null).equals(Type.INTEGER) && (b!=null?b.expressionType:null).equals(Type.INTEGER)){
                                                                            retval.expressionType = Type.INTEGER;
                                                                        }else{
                                                                            Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                    (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                    new Point((MOD35!=null?MOD35.getLine():0), (MOD35!=null?MOD35.getCharPositionInLine():0)), (MOD35!=null?MOD35.getText():null)
                                                                                                                                  );
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MOD35!=null?MOD35.getLine():0), (MOD35!=null?MOD35.getCharPositionInLine():0)), (MOD35!=null?MOD35.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:561:4: ^( POW a= expr b= expr )
                    {
                    POW36=(CommonTree)match(input,POW,FOLLOW_POW_in_expr1254); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1258);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1264);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW36!=null?POW36.getLine():0), (POW36!=null?POW36.getCharPositionInLine():0)), (POW36!=null?POW36.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:571:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1275); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1279);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:580:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1300); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1304);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:595:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1324); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:596:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1331); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:597:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1338); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:598:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1345); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:599:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1352); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:600:4: ID
                    {
                    ID37=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1359); 

                                            Symbol s = currentScope.referenceSymbol((ID37!=null?ID37.getText():null), new Point((ID37!=null?ID37.getLine():0), (ID37!=null?ID37.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(s, new Point((ID37!=null?ID37.getLine():0), (ID37!=null?ID37.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID37!=null?ID37.getLine():0), (ID37!=null?ID37.getCharPositionInLine():0)), s);
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:614:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1368); 

                    match(input, Token.DOWN, null); 
                    ID38=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1370); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1372);
                    arraySubscript39=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            Symbol s = currentScope.referenceSymbol((ID38!=null?ID38.getText():null), new Point((ID38!=null?ID38.getLine():0), (ID38!=null?ID38.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        Messages.arrayReferencesInDeclarationsNotAllowedError(s, new Point((ID38!=null?ID38.getLine():0), (ID38!=null?ID38.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript39!=null?arraySubscript39.indices:null).size();
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript39!=null?((CommonTree)arraySubscript39.start):null).getLine(), (arraySubscript39!=null?((CommonTree)arraySubscript39.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID38!=null?ID38.getLine():0), (ID38!=null?ID38.getCharPositionInLine():0)));
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:636:1: arraySubscript returns [List<Integer> indices] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr40 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:637:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:637:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript1403); 


                                                    retval.indices = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:640:19: ( expr )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==NEG||LA18_0==ARRAY_ITEM||LA18_0==ID||LA18_0==EQ||(LA18_0>=AND && LA18_0<=CONST_REAL)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:640:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript1432);
            	    expr40=expr();

            	    state._fsp--;


            	                                            Type type = (expr40!=null?expr40.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    Messages.arrayIndexNotIntegerError(new Point((expr40!=null?((CommonTree)expr40.start):null).getLine(), (expr40!=null?((CommonTree)expr40.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                Messages.arrayIndexNotIntegerError(new Point((expr40!=null?((CommonTree)expr40.start):null).getLine(), (expr40!=null?((CommonTree)expr40.start):null).getCharPositionInLine()));
            	                                            }
            	                                            retval.indices.add(new Integer(1));
            	                                        

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


 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations105 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_varDecl_in_declarations108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000040008L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign185 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_constAssign187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl224 = new BitSet(new long[]{0x000000000F000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl302 = new BitSet(new long[]{0x0000000000002108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem398 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension475 = new BitSet(new long[]{0x00FFFFF000042228L});
    public static final BitSet FOLLOW_BOOLEANS_in_varType552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block588 = new BitSet(new long[]{0x0000000070000088L});
    public static final BitSet FOLLOW_PRINT_in_stm602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm604 = new BitSet(new long[]{0x00FFFFF000042228L});
    public static final BitSet FOLLOW_READ_in_stm640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm642 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm652 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_stm654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm688 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm690 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_stm692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm758 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm760 = new BitSet(new long[]{0x0000000C00000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm762 = new BitSet(new long[]{0x0000000C00000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem791 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock862 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock864 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_block_in_ifBlock866 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock899 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock901 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock921 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock923 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock925 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr960 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr964 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr981 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr985 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1006 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1012 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1027 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1033 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1044 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1048 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1054 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1069 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1086 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1090 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1096 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1107 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1111 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1132 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1153 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1174 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1191 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1195 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1216 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1237 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1243 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1258 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1275 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1304 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1368 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1370 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript1403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1432 = new BitSet(new long[]{0x00FFFFF000042228L});

}