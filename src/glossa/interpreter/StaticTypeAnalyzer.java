// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/StaticTypeAnalyzer.g 2010-10-20 19:11:22


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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:1: stm : ( ^( PRINT ( expr )+ ) | ^( READ ID ) | ^( READ ID arraySubscript ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) );
    public final void stm() throws RecognitionException {
        CommonTree ID12=null;
        CommonTree ID13=null;
        CommonTree ID15=null;
        CommonTree ASSIGN17=null;
        CommonTree ID18=null;
        CommonTree ASSIGN20=null;
        StaticTypeAnalyzer.expr_return expr11 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript14 = null;

        StaticTypeAnalyzer.expr_return expr16 = null;

        StaticTypeAnalyzer.expr_return expr19 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript21 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:217:5: ( ^( PRINT ( expr )+ ) | ^( READ ID ) | ^( READ ID arraySubscript ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:222:17: ^( READ ID )
                    {
                    match(input,READ,FOLLOW_READ_in_stm640); 

                    match(input, Token.DOWN, null); 
                    ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_stm642); 

                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID12!=null?ID12.getText():null), new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(!(s instanceof Variable)){
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:230:17: ^( READ ID arraySubscript )
                    {
                    match(input,READ,FOLLOW_READ_in_stm681); 

                    match(input, Token.DOWN, null); 
                    ID13=(CommonTree)match(input,ID,FOLLOW_ID_in_stm683); 
                    pushFollow(FOLLOW_arraySubscript_in_stm685);
                    arraySubscript14=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID13!=null?ID13.getText():null), new Point((ID13!=null?ID13.getLine():0), (ID13!=null?ID13.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            int indicesCount = (arraySubscript14!=null?arraySubscript14.indices:null).size();
                                                                            if(arr.getNumberOfDimensions() != indicesCount){
                                                                                Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript14!=null?((CommonTree)arraySubscript14.start):null).getLine(), (arraySubscript14!=null?((CommonTree)arraySubscript14.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                            }
                                                                        }else{
                                                                            Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID13!=null?ID13.getLine():0), (ID13!=null?ID13.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:244:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN17=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm696); 

                    match(input, Token.DOWN, null); 
                    ID15=(CommonTree)match(input,ID,FOLLOW_ID_in_stm698); 
                    pushFollow(FOLLOW_expr_in_stm700);
                    expr16=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID15!=null?ID15.getText():null), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Variable){
                                                                            if((expr16!=null?expr16.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr16!=null?expr16.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)), (expr16!=null?expr16.expressionType:null), new Point((expr16!=null?((CommonTree)expr16.start):null).getLine(), (expr16!=null?((CommonTree)expr16.start):null).getCharPositionInLine()) ,new Point((ASSIGN17!=null?ASSIGN17.getLine():0), (ASSIGN17!=null?ASSIGN17.getCharPositionInLine():0)), (ASSIGN17!=null?ASSIGN17.getText():null));
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr16!=null?((CommonTree)expr16.start):null).getLine(), (expr16!=null?((CommonTree)expr16.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN17!=null?ASSIGN17.getLine():0), (ASSIGN17!=null?ASSIGN17.getCharPositionInLine():0)), (ASSIGN17!=null?ASSIGN17.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:263:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN20=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm732); 

                    match(input, Token.DOWN, null); 
                    ID18=(CommonTree)match(input,ID,FOLLOW_ID_in_stm734); 
                    pushFollow(FOLLOW_arraySubscript_in_stm736);
                    arraySubscript21=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm738);
                    expr19=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID18!=null?ID18.getText():null), new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            if((expr19!=null?expr19.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr19!=null?expr19.expressionType:null))<0){
                                                                                    Messages.incompatibleTypesFoundError(s.getType(), new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)), (expr19!=null?expr19.expressionType:null), new Point((expr19!=null?((CommonTree)expr19.start):null).getLine(), (expr19!=null?((CommonTree)expr19.start):null).getCharPositionInLine()) ,new Point((ASSIGN20!=null?ASSIGN20.getLine():0), (ASSIGN20!=null?ASSIGN20.getCharPositionInLine():0)), (ASSIGN20!=null?ASSIGN20.getText():null));
                                                                                }else{
                                                                                    Array arr = (Array)s;
                                                                                    int indicesCount = (arraySubscript21!=null?arraySubscript21.indices:null).size();
                                                                                    if(arr.getNumberOfDimensions() != indicesCount){
                                                                                        Messages.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript21!=null?((CommonTree)arraySubscript21.start):null).getLine(), (arraySubscript21!=null?((CommonTree)arraySubscript21.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.incompatibleTypesFoundError( s.getType(), new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)),
                                                                                                                                null, new Point((expr19!=null?((CommonTree)expr19.start):null).getLine(), (expr19!=null?((CommonTree)expr19.start):null).getCharPositionInLine()),
                                                                                                                                new Point((ASSIGN20!=null?ASSIGN20.getLine():0), (ASSIGN20!=null?ASSIGN20.getCharPositionInLine():0)), (ASSIGN20!=null?ASSIGN20.getText():null)
                                                                                                                              );
                                                                            }
                                                                        }else{
                                                                                Messages.nonArraySymbolReferencedAsSuchError(s, new Point((ID18!=null?ID18.getLine():0), (ID18!=null?ID18.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:289:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm804); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm806);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:289:34: ( elseIfBlock )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==ELSE_IF) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:289:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm808);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:289:47: ( elseBlock )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ELSE) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:289:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm811);
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


    // $ANTLR start "ifBlock"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:294:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr22 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:294:9: ( ^( IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:294:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock839); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock841);
            expr22=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock843);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:305:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:306:2: ( ^( ELSE block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:306:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock876); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock878);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:309:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr23 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:310:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:310:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock898); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock900);
            expr23=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock902);
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

    public static class expr_return extends TreeRuleReturnScope {
        public Type expressionType;
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:324:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
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
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:325:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
            int alt15=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt15=1;
                }
                break;
            case OR:
                {
                alt15=2;
                }
                break;
            case EQ:
                {
                alt15=3;
                }
                break;
            case NEQ:
                {
                alt15=4;
                }
                break;
            case LT:
                {
                alt15=5;
                }
                break;
            case LE:
                {
                alt15=6;
                }
                break;
            case GT:
                {
                alt15=7;
                }
                break;
            case GE:
                {
                alt15=8;
                }
                break;
            case PLUS:
                {
                alt15=9;
                }
                break;
            case MINUS:
                {
                alt15=10;
                }
                break;
            case TIMES:
                {
                alt15=11;
                }
                break;
            case DIA:
                {
                alt15=12;
                }
                break;
            case DIV:
                {
                alt15=13;
                }
                break;
            case MOD:
                {
                alt15=14;
                }
                break;
            case POW:
                {
                alt15=15;
                }
                break;
            case NEG:
                {
                alt15=16;
                }
                break;
            case NOT:
                {
                alt15=17;
                }
                break;
            case CONST_TRUE:
                {
                alt15=18;
                }
                break;
            case CONST_FALSE:
                {
                alt15=19;
                }
                break;
            case CONST_STR:
                {
                alt15=20;
                }
                break;
            case CONST_INT:
                {
                alt15=21;
                }
                break;
            case CONST_REAL:
                {
                alt15=22;
                }
                break;
            case ID:
                {
                alt15=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt15=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:325:4: ^( AND a= expr b= expr )
                    {
                    AND24=(CommonTree)match(input,AND,FOLLOW_AND_in_expr937); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr941);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr947);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:335:4: ^( OR a= expr b= expr )
                    {
                    OR25=(CommonTree)match(input,OR,FOLLOW_OR_in_expr958); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr962);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr968);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:345:4: ^( EQ a= expr b= expr )
                    {
                    EQ26=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr979); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr983);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr989);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:355:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ27=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1000); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1004);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1010);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:365:4: ^( LT a= expr b= expr )
                    {
                    LT28=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1021); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1025);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1031);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:394:4: ^( LE a= expr b= expr )
                    {
                    LE29=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1042); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1046);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1052);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:423:4: ^( GT a= expr b= expr )
                    {
                    GT30=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1063); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1067);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1073);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:452:4: ^( GE a= expr b= expr )
                    {
                    GE31=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1084); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1088);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1094);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:481:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS32=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1105); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1109);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1115);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:491:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS33=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1126); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1130);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1136);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:501:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES34=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1147); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1151);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1157);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:511:4: ^( DIA a= expr b= expr )
                    {
                    DIA35=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1168); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1172);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1178);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA35!=null?DIA35.getLine():0), (DIA35!=null?DIA35.getCharPositionInLine():0)), (DIA35!=null?DIA35.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:521:4: ^( DIV a= expr b= expr )
                    {
                    DIV36=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1189); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1193);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1199);
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
                                                                                                                                new Point((DIV36!=null?DIV36.getLine():0), (DIV36!=null?DIV36.getCharPositionInLine():0)), (DIV36!=null?DIV36.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:543:4: ^( MOD a= expr b= expr )
                    {
                    MOD37=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr1210); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1214);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1220);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:560:4: ^( POW a= expr b= expr )
                    {
                    POW38=(CommonTree)match(input,POW,FOLLOW_POW_in_expr1231); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1235);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1241);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW38!=null?POW38.getLine():0), (POW38!=null?POW38.getCharPositionInLine():0)), (POW38!=null?POW38.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:570:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1252); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1256);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:579:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1277); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1281);
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
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:594:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1301); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:595:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1308); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:596:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1315); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:597:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1322); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:598:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1329); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:599:4: ID
                    {
                    ID39=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1336); 

                                            Symbol s = currentScope.referenceSymbol((ID39!=null?ID39.getText():null), new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(s, new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(new Point((ID39!=null?ID39.getLine():0), (ID39!=null?ID39.getCharPositionInLine():0)), s);
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:613:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1345); 

                    match(input, Token.DOWN, null); 
                    ID40=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1347); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1349);
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
    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:635:1: arraySubscript returns [List<Integer> indices] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr42 = null;


        try {
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:636:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:636:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript1380); 


                                                    retval.indices = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:639:19: ( expr )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==NEG||LA16_0==ARRAY_ITEM||LA16_0==ID||LA16_0==EQ||(LA16_0>=AND && LA16_0<=CONST_REAL)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/glossa/interpreter/grammars/StaticTypeAnalyzer.g:639:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript1409);
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\15\uffff";
    static final String DFA14_eofS =
        "\15\uffff";
    static final String DFA14_minS =
        "\1\7\1\uffff\2\2\1\uffff\2\15\1\3\1\5\4\uffff";
    static final String DFA14_maxS =
        "\1\36\1\uffff\2\2\1\uffff\2\15\1\12\1\67\4\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\2\uffff\1\6\4\uffff\1\2\1\3\1\5\1\4";
    static final String DFA14_specialS =
        "\15\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\4\24\uffff\1\1\1\2\1\3",
            "",
            "\1\5",
            "\1\6",
            "",
            "\1\7",
            "\1\10",
            "\1\11\6\uffff\1\12",
            "\1\14\3\uffff\1\14\1\13\2\uffff\1\14\4\uffff\1\14\21\uffff"+
            "\24\14",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "217:1: stm : ( ^( PRINT ( expr )+ ) | ^( READ ID ) | ^( READ ID arraySubscript ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) );";
        }
    }
 

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
    public static final BitSet FOLLOW_ID_in_stm642 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_stm681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm683 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm696 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm698 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_stm700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm734 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm736 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_stm738 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm804 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm806 = new BitSet(new long[]{0x0000000C00000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm808 = new BitSet(new long[]{0x0000000C00000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifBlock839 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock841 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_block_in_ifBlock843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock898 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock900 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr941 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr962 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr983 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr989 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1000 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1004 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1021 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1025 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1042 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1046 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1052 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1067 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1073 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1088 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1094 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1109 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1115 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1130 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1151 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1172 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1193 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1214 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1235 = new BitSet(new long[]{0x00FFFFF000042220L});
    public static final BitSet FOLLOW_expr_in_expr1241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1256 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1281 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1347 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript1380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1409 = new BitSet(new long[]{0x00FFFFF000042228L});

}