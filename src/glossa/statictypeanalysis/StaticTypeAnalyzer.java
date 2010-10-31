// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/StaticTypeAnalyzer.g 2010-10-31 22:23:57


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


package glossa.statictypeanalysis;

import glossa.messages.*;
import glossa.builtinfunctions.BuiltinFunctions;
import glossa.statictypeanalysis.scopetable.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.statictypeanalysis.scopetable.symbols.*;
import glossa.types.*;
import java.util.Iterator;
import java.awt.Point;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StaticTypeAnalyzer extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PARAMS", "FUNC_CALL", "PROGRAM", "ID", "NEWLINE", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "LPAR", "RPAR", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "FUNCTION", "END_FUNCTION", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "INTEGER", "REAL", "STRING", "BOOLEAN", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=103;
    public static final int LT=44;
    public static final int END_PROCEDURE=100;
    public static final int WHILE=53;
    public static final int LETTER=114;
    public static final int MOD=65;
    public static final int STRINGS=29;
    public static final int LAMDA=89;
    public static final int UPSILON_DIALYTIKA_TONOS=127;
    public static final int CASE=42;
    public static final int NOT=67;
    public static final int OMICRON=79;
    public static final int EOF=-1;
    public static final int FUNC_CALL=15;
    public static final int LBRACKET=26;
    public static final int MU=85;
    public static final int TAU=86;
    public static final int POW=66;
    public static final int LPAR=73;
    public static final int UPSILON_TONOS=123;
    public static final int CONT_COMMAND=117;
    public static final int CONST_INT=71;
    public static final int LOOP=54;
    public static final int BEGIN=19;
    public static final int KAPPA=75;
    public static final int EQ=22;
    public static final int COMMENT=116;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=120;
    public static final int END_LOOP=52;
    public static final int GE=47;
    public static final int END_SWITCH=41;
    public static final int CONST_TRUE=68;
    public static final int NU=102;
    public static final int XI=108;
    public static final int SWITCH=40;
    public static final int ELSE=38;
    public static final int DELTA=96;
    public static final int EPSILON=87;
    public static final int CONST_STR=70;
    public static final int INTEGERS=30;
    public static final int ALPHA=76;
    public static final int SIGMA_TELIKO=90;
    public static final int REAL=110;
    public static final int THETA=95;
    public static final int BOOLEANS=28;
    public static final int UPSILON_DIALYTIKA=125;
    public static final int WS=118;
    public static final int OMICRON_TONOS=80;
    public static final int EPSILON_TONOS=88;
    public static final int READ=33;
    public static final int OMEGA=106;
    public static final int UNTIL=56;
    public static final int OR=57;
    public static final int GT=46;
    public static final int ALPHA_TONOS=91;
    public static final int REPEAT=55;
    public static final int CALL=105;
    public static final int PI=82;
    public static final int FROM=49;
    public static final int PHI=122;
    public static final int RHO=83;
    public static final int UPSILON=101;
    public static final int FOR=48;
    public static final int STEP=51;
    public static final int ETA_TONOS=78;
    public static final int CONSTANTS=21;
    public static final int ID=17;
    public static final int AND=58;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=36;
    public static final int OMEGA_TONOS=107;
    public static final int NOT_EOL=115;
    public static final int BOOLEAN=112;
    public static final int THEN=37;
    public static final int END_FUNCTION=104;
    public static final int COMMA=25;
    public static final int ETA=93;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=97;
    public static final int PLUS=60;
    public static final int SIGMA=94;
    public static final int DIGIT=113;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=27;
    public static final int IOTA_DIALYTIKA_TONOS=126;
    public static final int ELSE_IF=39;
    public static final int CONST_REAL=72;
    public static final int VARSDECL=6;
    public static final int PARAMS=14;
    public static final int INTEGER=109;
    public static final int INF_RANGE=12;
    public static final int TO=50;
    public static final int LATIN_LETTER=119;
    public static final int REALS=31;
    public static final int RANGE=43;
    public static final int CHI=81;
    public static final int MINUS=61;
    public static final int DIA=63;
    public static final int BETA=92;
    public static final int PRINT=32;
    public static final int PROCEDURE=99;
    public static final int COLON=24;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=59;
    public static final int NEWLINE=18;
    public static final int END_PROGRAM=20;
    public static final int ZETA=121;
    public static final int CONST_FALSE=69;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=23;
    public static final int ASSIGN=34;
    public static final int END_IF=35;
    public static final int RPAR=74;
    public static final int PROGRAM=16;
    public static final int IOTA=77;
    public static final int DIV=64;
    public static final int GAMMA=84;
    public static final int TIMES=62;
    public static final int LE=45;
    public static final int IOTA_DIALYTIKA=124;
    public static final int IOTA_TONOS=98;
    public static final int STRING=111;

    // delegates
    // delegators


        public StaticTypeAnalyzer(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public StaticTypeAnalyzer(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StaticTypeAnalyzer.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/grammars/StaticTypeAnalyzer.g"; }


            private MessageLog msgLog;

            private ScopeTable scopeTable;
    	private Scope currentScope;
            private boolean inConstantDeclaration = false;
            private boolean inVariableDeclaration = false;

            public void setMessageLog(MessageLog msgLog){
                this.msgLog = msgLog;
            }

            public void setScopeTable(ScopeTable s){
                this.scopeTable = s;
            }

            public ScopeTable getScopeTable(){
                return this.scopeTable;
            }

            public void setCurrentScope(Scope s){
                this.currentScope = s;
            }

            public Scope getCurrentScope(){
                return this.currentScope;
            }



    // $ANTLR start "unit"
    // src/glossa/grammars/StaticTypeAnalyzer.g:109:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:109:6: ( program )
            // src/glossa/grammars/StaticTypeAnalyzer.g:109:8: program
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:111:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:111:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:111:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program59); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program65); 

                                            MainProgramScope mainProgramScope = new MainProgramScope();
            				mainProgramScope.setProgramName((id1!=null?id1.getText():null));
                                            scopeTable.setMainProgramScope(mainProgramScope);
                                            currentScope = mainProgramScope;
            			
            pushFollow(FOLLOW_declarations_in_program71);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program75);
            block();

            state._fsp--;

            // src/glossa/grammars/StaticTypeAnalyzer.g:120:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:120:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program83); 

                    				if((id1!=null?id1.getText():null).toLowerCase().equals((id2!=null?id2.getText():null).toLowerCase())==false){
                    					Messages.programNameMismatchWarning(msgLog, new Point((id2!=null?id2.getLine():0), (id2!=null?id2.getCharPositionInLine():0)), (id2!=null?id2.getText():null));
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:128:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:129:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/grammars/StaticTypeAnalyzer.g:129:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/grammars/StaticTypeAnalyzer.g:129:4: ( constDecl )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CONSTANTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:129:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations105);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/StaticTypeAnalyzer.g:129:15: ( varDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLES) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:129:15: varDecl
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:131:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:132:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:132:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl121); 


                                                    inConstantDeclaration=true;
            					if(currentScope.isConstantsDeclared()){
            						Messages.constantsRedeclarationError(msgLog, new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), currentScope.getConstantsDeclarationPoint());
            					}else{
            						currentScope.setConstantsDeclared(true);
            						currentScope.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:141:3: ( constAssign )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==EQ) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:141:3: constAssign
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:147:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID2=null;
        StaticTypeAnalyzer.expr_return expr3 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:148:2: ( ^( EQ ID expr ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:148:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign183); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign185); 
            pushFollow(FOLLOW_expr_in_constAssign187);
            expr3=expr();

            state._fsp--;


            match(input, Token.UP, null); 

                                                Constant s = new Constant((ID2!=null?ID2.getText():null), (expr3!=null?expr3.expressionType:null), (ID2!=null?ID2.getLine():0), (ID2!=null?ID2.getCharPositionInLine():0), ID2.getTokenStartIndex());
                                                s.setInitialized(true);
                                                currentScope.defineSymbol(msgLog, s.getName(), s);
                                            

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:159:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:159:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:159:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES4=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl218); 


                                                    inVariableDeclaration=true;
            					if(currentScope.isVariablesDeclared()){
            						Messages.variablesRedeclarationError(msgLog, new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)), currentScope.getVariablesDeclarationPoint());
            					}else{
            						currentScope.setVariablesDeclared(true);
            						currentScope.setVariablesDeclarationPoint(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:168:3: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:168:3: varsDecl
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:175:1: varsDecl : ^( varType ( varDeclItem[$varType.result] )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Type varType5 = null;

        Symbol varDeclItem6 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:176:2: ( ^( varType ( varDeclItem[$varType.result] )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:176:4: ^( varType ( varDeclItem[$varType.result] )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType5=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:178:21: ( varDeclItem[$varType.result] )+
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
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:178:22: varDeclItem[$varType.result]
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl302);
            	    varDeclItem6=varDeclItem(varType5);

            	    state._fsp--;


            	                                                                Symbol s = varDeclItem6;
            	                                                                currentScope.defineSymbol(msgLog, s.getName(), s);
            	                                                            

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:185:1: varDeclItem[Type t] returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem(Type t) throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        int arrayDimension9 = 0;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:186:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:186:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem365); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), t, (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex());
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:189:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem399); 

                    match(input, Token.DOWN, null); 
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem401); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem403);
                    arrayDimension9=arrayDimension();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    variable = new Array((ID8!=null?ID8.getText():null), t, (ID8!=null?ID8.getLine():0), (ID8!=null?ID8.getCharPositionInLine():0), ID8.getTokenStartIndex(), arrayDimension9);
                                                                

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:196:1: arrayDimension returns [int indicesCount] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final int arrayDimension() throws RecognitionException {
        int indicesCount = 0;

        StaticTypeAnalyzer.expr_return expr10 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:197:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:197:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension453); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:201:21: ( expr )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==NEG||LA8_0==ARRAY_ITEM||LA8_0==FUNC_CALL||LA8_0==ID||LA8_0==EQ||(LA8_0>=LT && LA8_0<=GE)||(LA8_0>=OR && LA8_0<=CONST_REAL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:201:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension478);
            	    expr10=expr();

            	    state._fsp--;


            	                                            Type type = (expr10!=null?expr10.expressionType:null);
            	                                            count++;
            	                                            if(   (type==null)     ||   ( !type.equals(Type.INTEGER) )   ){
            	                                                Messages.arrayDimensionDeclarationsNotIntegerError(msgLog, new Point((expr10!=null?((CommonTree)expr10.start):null).getLine(), (expr10!=null?((CommonTree)expr10.start):null).getCharPositionInLine()));
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:214:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:215:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:215:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType593); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:216:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType600); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:217:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType607); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:218:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType614); 
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:220:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:220:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:220:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block627); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:220:17: ( stm )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IFNODE||(LA10_0>=PRINT && LA10_0<=ASSIGN)||LA10_0==SWITCH||LA10_0==FOR||LA10_0==WHILE||LA10_0==REPEAT) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:220:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block629);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:225:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );
    public final void stm() throws RecognitionException {
        CommonTree ID11=null;
        CommonTree ASSIGN13=null;
        CommonTree ID14=null;
        CommonTree ASSIGN16=null;
        CommonTree SWITCH19=null;
        CommonTree ID20=null;
        CommonTree ID21=null;
        StaticTypeAnalyzer.expr_return expr1 = null;

        StaticTypeAnalyzer.expr_return expr2 = null;

        StaticTypeAnalyzer.expr_return expr3 = null;

        StaticTypeAnalyzer.expr_return expr12 = null;

        StaticTypeAnalyzer.expr_return expr15 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript17 = null;

        StaticTypeAnalyzer.expr_return expr18 = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript22 = null;

        StaticTypeAnalyzer.expr_return expr23 = null;

        StaticTypeAnalyzer.expr_return expr24 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:225:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) )
            int alt19=10;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:225:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm643); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/grammars/StaticTypeAnalyzer.g:225:15: (expr1= expr )*
                        loop11:
                        do {
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==NEG||LA11_0==ARRAY_ITEM||LA11_0==FUNC_CALL||LA11_0==ID||LA11_0==EQ||(LA11_0>=LT && LA11_0<=GE)||(LA11_0>=OR && LA11_0<=CONST_REAL)) ) {
                                alt11=1;
                            }


                            switch (alt11) {
                        	case 1 :
                        	    // src/glossa/grammars/StaticTypeAnalyzer.g:225:16: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm648);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:226:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm671); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/grammars/StaticTypeAnalyzer.g:226:24: ( readItem )+
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
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:226:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm673);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:227:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm681); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm683); 
                    pushFollow(FOLLOW_expr_in_stm685);
                    expr12=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       StaticTypeAnalyzerUtils.checkVariableAssignment(msgLog, this.currentScope, (ID11!=null?ID11.getText():null), (ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0),
                                                                                                        (expr12!=null?expr12.expressionType:null), (expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine(),
                                                                                                        (ASSIGN13!=null?ASSIGN13.getText():null), (ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0));
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:231:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN16=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm717); 

                    match(input, Token.DOWN, null); 
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_stm719); 
                    pushFollow(FOLLOW_arraySubscript_in_stm721);
                    arraySubscript17=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm723);
                    expr15=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkArrayAssignment(msgLog, this.currentScope, (ID14!=null?ID14.getText():null), (ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0),
                                                                                              (expr15!=null?expr15.expressionType:null), (expr15!=null?((CommonTree)expr15.start):null).getLine(), (expr15!=null?((CommonTree)expr15.start):null).getCharPositionInLine(),
                                                                                              (ASSIGN16!=null?ASSIGN16.getText():null), (ASSIGN16!=null?ASSIGN16.getLine():0), (ASSIGN16!=null?ASSIGN16.getCharPositionInLine():0),
                                                                                              (arraySubscript17!=null?arraySubscript17.indicesCount:0), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getLine(), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getCharPositionInLine());
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:238:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm789); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm791);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:238:34: ( elseIfBlock )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ELSE_IF) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:238:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm793);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // src/glossa/grammars/StaticTypeAnalyzer.g:238:47: ( elseBlock )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ELSE) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:238:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm796);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:239:17: ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? )
                    {
                    SWITCH19=(CommonTree)match(input,SWITCH,FOLLOW_SWITCH_in_stm817); 

                    int numberOfCases = 0;

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm821);
                    expr18=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:239:56: ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==CASE) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:239:57: caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())]
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm824);
                    	    caseBlock((expr18!=null?expr18.expressionType:null), new Point((expr18!=null?((CommonTree)expr18.start):null).getLine(), (expr18!=null?((CommonTree)expr18.start):null).getCharPositionInLine()));

                    	    state._fsp--;

                    	    numberOfCases++;

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // src/glossa/grammars/StaticTypeAnalyzer.g:240:19: ( caseElseBlock )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==CASE_ELSE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:240:20: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm853);
                            caseElseBlock();

                            state._fsp--;

                            numberOfCases++;

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                                                                    if(numberOfCases==0){
                                                                        Messages.caseStmMustHaveAtLeastOneCaseError(msgLog, new Point((SWITCH19!=null?SWITCH19.getLine():0), (SWITCH19!=null?SWITCH19.getCharPositionInLine():0)));
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:246:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm922); 

                    match(input, Token.DOWN, null); 
                    ID20=(CommonTree)match(input,ID,FOLLOW_ID_in_stm924); 

                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID20!=null?ID20.getText():null), new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Variable)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm967);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm989);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:254:19: (expr3= expr )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==NEG||LA17_0==ARRAY_ITEM||LA17_0==FUNC_CALL||LA17_0==ID||LA17_0==EQ||(LA17_0>=LT && LA17_0<=GE)||(LA17_0>=OR && LA17_0<=CONST_REAL)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:254:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm1012);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1034);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(s != null){
                                                                         if(s instanceof Variable){
                                                                            if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                                                if(StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null)) && StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null)) ){
                                                                                    if(s.getType().equals(Type.INTEGER)){
                                                                                        if(!(expr1!=null?expr1.expressionType:null).equals(Type.INTEGER)){
                                                                                            Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                        }
                                                                                        if(expr3!=null){
                                                                                            if(  ((expr3!=null?expr3.expressionType:null)==null) || (!(expr3!=null?expr3.expressionType:null).equals(Type.INTEGER))  ){
                                                                                                Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        if(expr3!=null){
                                                                                            if(!StaticTypeAnalyzerUtils.isNumericType((expr3!=null?expr3.expressionType:null))){
                                                                                                Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    if(!StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                    }
                                                                                    if(!StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null))){
                                                                                        Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr2!=null?((CommonTree)expr2.start):null).getLine(), (expr2!=null?((CommonTree)expr2.start):null).getCharPositionInLine()), (expr2!=null?expr2.expressionType:null));
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                Messages.forCounterMustBeOfNumericTypeError(msgLog, new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)), s.getType());
                                                                            }
                                                                        }else{
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)), s);
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:293:17: ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm1100); 

                    match(input, Token.DOWN, null); 
                    ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_stm1102); 
                    pushFollow(FOLLOW_arraySubscript_in_stm1104);
                    arraySubscript22=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID21!=null?ID21.getText():null), new Point((ID21!=null?ID21.getLine():0), (ID21!=null?ID21.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Array)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm1132);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1154);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:301:19: (expr3= expr )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==NEG||LA18_0==ARRAY_ITEM||LA18_0==FUNC_CALL||LA18_0==ID||LA18_0==EQ||(LA18_0>=LT && LA18_0<=GE)||(LA18_0>=OR && LA18_0<=CONST_REAL)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:301:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm1177);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1199);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(s != null){
                                                                         if(s instanceof Array){
                                                                            s.setInitialized(true);
                                                                            Array arr = (Array)s;
                                                                            int indicesCount = (arraySubscript22!=null?arraySubscript22.indicesCount:0);
                                                                            if(arr.getNumberOfDimensions() != indicesCount){
                                                                                Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point((arraySubscript22!=null?((CommonTree)arraySubscript22.start):null).getLine(), (arraySubscript22!=null?((CommonTree)arraySubscript22.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                            }else{
                                                                                if(StaticTypeAnalyzerUtils.isNumericType(s.getType())){
                                                                                    if(StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null)) && StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null)) ){
                                                                                        if(s.getType().equals(Type.INTEGER)){
                                                                                            if(!(expr1!=null?expr1.expressionType:null).equals(Type.INTEGER)){
                                                                                                Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                            }
                                                                                            if(expr3!=null){
                                                                                                if(  ((expr3!=null?expr3.expressionType:null)==null) || (!(expr3!=null?expr3.expressionType:null).equals(Type.INTEGER))  ){
                                                                                                    Messages.forFromStepExpressionsMustBeIntegerError(msgLog, new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                                }
                                                                                            }
                                                                                        }else{
                                                                                            if(expr3!=null){
                                                                                                if(!StaticTypeAnalyzerUtils.isNumericType((expr3!=null?expr3.expressionType:null))){
                                                                                                    Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr3!=null?((CommonTree)expr3.start):null).getLine(), (expr3!=null?((CommonTree)expr3.start):null).getCharPositionInLine()), (expr3!=null?expr3.expressionType:null));
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        if(!StaticTypeAnalyzerUtils.isNumericType((expr1!=null?expr1.expressionType:null))){
                                                                                            Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr1!=null?((CommonTree)expr1.start):null).getLine(), (expr1!=null?((CommonTree)expr1.start):null).getCharPositionInLine()), (expr1!=null?expr1.expressionType:null));
                                                                                        }
                                                                                        if(!StaticTypeAnalyzerUtils.isNumericType((expr2!=null?expr2.expressionType:null))){
                                                                                            Messages.forFromToStepExpressionsMustBeOfNumericTypeError(msgLog, new Point((expr2!=null?((CommonTree)expr2.start):null).getLine(), (expr2!=null?((CommonTree)expr2.start):null).getCharPositionInLine()), (expr2!=null?expr2.expressionType:null));
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.forCounterMustBeOfNumericTypeError(msgLog, new Point((ID21!=null?ID21.getLine():0), (ID21!=null?ID21.getCharPositionInLine():0)), s.getType());
                                                                                }
                                                                            }
                                                                        }else{
                                                                            Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point((ID21!=null?ID21.getLine():0), (ID21!=null?ID21.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:347:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm1265); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm1267);
                    expr23=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm1269);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr23!=null?expr23.expressionType:null)!=null){
                                                                        if(!(expr23!=null?expr23.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBooleanError(msgLog, new Point((expr23!=null?((CommonTree)expr23.start):null).getLine(), (expr23!=null?((CommonTree)expr23.start):null).getCharPositionInLine()) , (expr23!=null?expr23.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBooleanError(msgLog, new Point((expr23!=null?((CommonTree)expr23.start):null).getLine(), (expr23!=null?((CommonTree)expr23.start):null).getCharPositionInLine()) , null);
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:356:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm1286); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm1288);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1290);
                    expr24=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((expr24!=null?expr24.expressionType:null)!=null){
                                                                        if(!(expr24!=null?expr24.expressionType:null).equals(Type.BOOLEAN)){
                                                                            Messages.whileExpressionMustBeBooleanError(msgLog, new Point((expr24!=null?((CommonTree)expr24.start):null).getLine(), (expr24!=null?((CommonTree)expr24.start):null).getCharPositionInLine()) , (expr24!=null?expr24.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.whileExpressionMustBeBooleanError(msgLog, new Point((expr24!=null?((CommonTree)expr24.start):null).getLine(), (expr24!=null?((CommonTree)expr24.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:367:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript25 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:367:9: (arrId= ID arraySubscript | varId= ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==ARRAY_INDEX) ) {
                    alt20=1;
                }
                else if ( (LA20_1==UP||LA20_1==ID) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:367:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1324); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1326);
                    arraySubscript25=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (arrId!=null?arrId.getText():null), new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            Type t = arr.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(msgLog, new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)), t);
                                                                            }else{
                                                                                int indicesCount = (arraySubscript25!=null?arraySubscript25.indicesCount:0);
                                                                                if(arr.getNumberOfDimensions() != indicesCount){
                                                                                    Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point((arraySubscript25!=null?((CommonTree)arraySubscript25.start):null).getLine(), (arraySubscript25!=null?((CommonTree)arraySubscript25.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                }else{
                                                                                    s.setInitialized(true);
                                                                                }
                                                                            }
                                                                        }else{
                                                                            Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:388:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1350); 

                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (varId!=null?varId.getText():null), new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(!(s instanceof Variable)){
                                                                            Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)), s);
                                                                        }else{
                                                                            Type t = s.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(msgLog, new Point((varId!=null?varId.getLine():0), (varId!=null?varId.getCharPositionInLine():0)), t);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:405:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr26 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:405:9: ( ^( IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:405:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1395); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1397);
            expr26=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1399);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr26!=null?expr26.expressionType:null)!=null){
                                                                if(!(expr26!=null?expr26.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr26!=null?((CommonTree)expr26.start):null).getLine(), (expr26!=null?((CommonTree)expr26.start):null).getCharPositionInLine()) , (expr26!=null?expr26.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr26!=null?((CommonTree)expr26.start):null).getLine(), (expr26!=null?((CommonTree)expr26.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:416:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:417:2: ( ^( ELSE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:417:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1432); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1434);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:420:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr27 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:421:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:421:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1454); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1456);
            expr27=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1458);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr27!=null?expr27.expressionType:null)!=null){
                                                                if(!(expr27!=null?expr27.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr27!=null?((CommonTree)expr27.start):null).getLine(), (expr27!=null?((CommonTree)expr27.start):null).getCharPositionInLine()) , (expr27!=null?expr27.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr27!=null?((CommonTree)expr27.start):null).getLine(), (expr27!=null?((CommonTree)expr27.start):null).getCharPositionInLine()) , null);
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
    };

    // $ANTLR start "caseBlock"
    // src/glossa/grammars/StaticTypeAnalyzer.g:433:1: caseBlock[Type exprType, Point exprPoint] : ^( CASE ( caseExprListItem )+ block ) ;
    public final StaticTypeAnalyzer.caseBlock_return caseBlock(Type exprType, Point exprPoint) throws RecognitionException {
        StaticTypeAnalyzer.caseBlock_return retval = new StaticTypeAnalyzer.caseBlock_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.caseExprListItem_return caseExprListItem28 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:434:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:434:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1489); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:434:11: ( caseExprListItem )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==NEG||LA21_0==ARRAY_ITEM||LA21_0==INF_RANGE||LA21_0==FUNC_CALL||LA21_0==ID||LA21_0==EQ||(LA21_0>=RANGE && LA21_0<=GE)||(LA21_0>=OR && LA21_0<=CONST_REAL)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:434:12: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1492);
            	    caseExprListItem28=caseExprListItem();

            	    state._fsp--;

            	       if( !StaticTypeAnalyzerUtils.checkTypesForCaseStatement(exprType, (caseExprListItem28!=null?caseExprListItem28.expressionType:null)) ){
            	                                                            Messages.incompatibleTypesForCaseStmFoundError(msgLog, exprType, exprPoint, (caseExprListItem28!=null?caseExprListItem28.expressionType:null), new Point((caseExprListItem28!=null?((CommonTree)caseExprListItem28.start):null).getLine(), (caseExprListItem28!=null?((CommonTree)caseExprListItem28.start):null).getCharPositionInLine()), new Point(((CommonTree)retval.start).getLine(), ((CommonTree)retval.start).getCharPositionInLine()));
            	                                                }
            	                                            

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

            pushFollow(FOLLOW_block_in_caseBlock1515);
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
        return retval;
    }
    // $ANTLR end "caseBlock"

    public static class caseExprListItem_return extends TreeRuleReturnScope {
        public Type expressionType;
    };

    // $ANTLR start "caseExprListItem"
    // src/glossa/grammars/StaticTypeAnalyzer.g:440:1: caseExprListItem returns [Type expressionType] : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final StaticTypeAnalyzer.caseExprListItem_return caseExprListItem() throws RecognitionException {
        StaticTypeAnalyzer.caseExprListItem_return retval = new StaticTypeAnalyzer.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree RANGE29=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:441:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
            int alt22=6;
            switch ( input.LA(1) ) {
            case NEG:
            case ARRAY_ITEM:
            case FUNC_CALL:
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
                alt22=1;
                }
                break;
            case RANGE:
                {
                alt22=2;
                }
                break;
            case INF_RANGE:
                {
                int LA22_3 = input.LA(2);

                if ( (LA22_3==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case LT:
                        {
                        alt22=3;
                        }
                        break;
                    case LE:
                        {
                        alt22=4;
                        }
                        break;
                    case GT:
                        {
                        alt22=5;
                        }
                        break;
                    case GE:
                        {
                        alt22=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:441:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1531);
                    a=expr();

                    state._fsp--;


                                                                retval.expressionType = (a!=null?a.expressionType:null);
                                                            

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:444:10: ^( RANGE a= expr b= expr )
                    {
                    RANGE29=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1562); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1566);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1570);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                    retval.expressionType = Type.REAL;
                                                                }else{
                                                                    Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((RANGE29!=null?RANGE29.getLine():0), (RANGE29!=null?RANGE29.getCharPositionInLine():0)), (RANGE29!=null?RANGE29.getText():null)
                                                                                                                              );
                                                                }
                                                            

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:454:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1586); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1588); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1592);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        retval.expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), (a!=null?a.expressionType:null));
                                                                }
                                                            

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:465:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1615); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1617); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1621);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        retval.expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), (a!=null?a.expressionType:null));
                                                                }
                                                            

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:476:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1644); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1646); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1650);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        retval.expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                   Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), (a!=null?a.expressionType:null));
                                                                }
                                                            

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:487:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1673); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1675); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1679);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypeForInfinityIncludingComparisonExpression((a!=null?a.expressionType:null))){
                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        retval.expressionType = Type.STRING;
                                                                    }
                                                                }else{
                                                                    Messages.caseItemExprMustBeIntRealOrStringError(msgLog, new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()), (a!=null?a.expressionType:null));
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
    // $ANTLR end "caseExprListItem"


    // $ANTLR start "caseElseBlock"
    // src/glossa/grammars/StaticTypeAnalyzer.g:500:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:501:2: ( ^( CASE_ELSE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:501:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1702); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1704);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:505:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) );
    public final StaticTypeAnalyzer.expr_return expr() throws RecognitionException {
        StaticTypeAnalyzer.expr_return retval = new StaticTypeAnalyzer.expr_return();
        retval.start = input.LT(1);

        CommonTree AND30=null;
        CommonTree OR31=null;
        CommonTree EQ32=null;
        CommonTree NEQ33=null;
        CommonTree LT34=null;
        CommonTree LE35=null;
        CommonTree GT36=null;
        CommonTree GE37=null;
        CommonTree PLUS38=null;
        CommonTree MINUS39=null;
        CommonTree TIMES40=null;
        CommonTree DIA41=null;
        CommonTree DIV42=null;
        CommonTree MOD43=null;
        CommonTree POW44=null;
        CommonTree ID45=null;
        CommonTree ID46=null;
        CommonTree ID48=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript47 = null;

        List<Type> paramsList49 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:506:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) )
            int alt23=25;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt23=1;
                }
                break;
            case OR:
                {
                alt23=2;
                }
                break;
            case EQ:
                {
                alt23=3;
                }
                break;
            case NEQ:
                {
                alt23=4;
                }
                break;
            case LT:
                {
                alt23=5;
                }
                break;
            case LE:
                {
                alt23=6;
                }
                break;
            case GT:
                {
                alt23=7;
                }
                break;
            case GE:
                {
                alt23=8;
                }
                break;
            case PLUS:
                {
                alt23=9;
                }
                break;
            case MINUS:
                {
                alt23=10;
                }
                break;
            case TIMES:
                {
                alt23=11;
                }
                break;
            case DIA:
                {
                alt23=12;
                }
                break;
            case DIV:
                {
                alt23=13;
                }
                break;
            case MOD:
                {
                alt23=14;
                }
                break;
            case POW:
                {
                alt23=15;
                }
                break;
            case NEG:
                {
                alt23=16;
                }
                break;
            case NOT:
                {
                alt23=17;
                }
                break;
            case CONST_TRUE:
                {
                alt23=18;
                }
                break;
            case CONST_FALSE:
                {
                alt23=19;
                }
                break;
            case CONST_STR:
                {
                alt23=20;
                }
                break;
            case CONST_INT:
                {
                alt23=21;
                }
                break;
            case CONST_REAL:
                {
                alt23=22;
                }
                break;
            case ID:
                {
                alt23=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt23=24;
                }
                break;
            case FUNC_CALL:
                {
                alt23=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:506:4: ^( AND a= expr b= expr )
                    {
                    AND30=(CommonTree)match(input,AND,FOLLOW_AND_in_expr1721); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1725);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1731);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((AND30!=null?AND30.getLine():0), (AND30!=null?AND30.getCharPositionInLine():0)), (AND30!=null?AND30.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:516:4: ^( OR a= expr b= expr )
                    {
                    OR31=(CommonTree)match(input,OR,FOLLOW_OR_in_expr1742); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1746);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1752);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((OR31!=null?OR31.getLine():0), (OR31!=null?OR31.getCharPositionInLine():0)), (OR31!=null?OR31.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:526:4: ^( EQ a= expr b= expr )
                    {
                    EQ32=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1763); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1767);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1773);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((EQ32!=null?EQ32.getLine():0), (EQ32!=null?EQ32.getCharPositionInLine():0)), (EQ32!=null?EQ32.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:536:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ33=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1784); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1788);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1794);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForEqualityExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((NEQ33!=null?NEQ33.getLine():0), (NEQ33!=null?NEQ33.getCharPositionInLine():0)), (NEQ33!=null?NEQ33.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:546:4: ^( LT a= expr b= expr )
                    {
                    LT34=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1805); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1809);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1815);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LT34!=null?LT34.getLine():0), (LT34!=null?LT34.getCharPositionInLine():0)), (LT34!=null?LT34.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:556:4: ^( LE a= expr b= expr )
                    {
                    LE35=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1826); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1830);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1836);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((LE35!=null?LE35.getLine():0), (LE35!=null?LE35.getCharPositionInLine():0)), (LE35!=null?LE35.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:566:4: ^( GT a= expr b= expr )
                    {
                    GT36=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1847); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1851);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1857);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GT36!=null?GT36.getLine():0), (GT36!=null?GT36.getCharPositionInLine():0)), (GT36!=null?GT36.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:576:4: ^( GE a= expr b= expr )
                    {
                    GE37=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1868); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1872);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1878);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                       Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                        (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                        new Point((GE37!=null?GE37.getLine():0), (GE37!=null?GE37.getCharPositionInLine():0)), (GE37!=null?GE37.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:586:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS38=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1889); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1893);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1899);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((PLUS38!=null?PLUS38.getLine():0), (PLUS38!=null?PLUS38.getCharPositionInLine():0)), (PLUS38!=null?PLUS38.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:596:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS39=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1910); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1914);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1920);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MINUS39!=null?MINUS39.getLine():0), (MINUS39!=null?MINUS39.getCharPositionInLine():0)), (MINUS39!=null?MINUS39.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:606:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES40=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1931); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1935);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1941);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = StaticTypeAnalyzerUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((TIMES40!=null?TIMES40.getLine():0), (TIMES40!=null?TIMES40.getCharPositionInLine():0)), (TIMES40!=null?TIMES40.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:616:4: ^( DIA a= expr b= expr )
                    {
                    DIA41=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1952); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1956);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1962);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.REAL;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA41!=null?DIA41.getLine():0), (DIA41!=null?DIA41.getCharPositionInLine():0)), (DIA41!=null?DIA41.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:626:4: ^( DIV a= expr b= expr )
                    {
                    DIV42=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1973); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1977);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1983);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.INTEGER;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV42!=null?DIV42.getLine():0), (DIV42!=null?DIV42.getCharPositionInLine():0)), (DIV42!=null?DIV42.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:636:4: ^( MOD a= expr b= expr )
                    {
                    MOD43=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr1994); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1998);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2004);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForIntegerArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.INTEGER;
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                    (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                    new Point((MOD43!=null?MOD43.getLine():0), (MOD43!=null?MOD43.getCharPositionInLine():0)), (MOD43!=null?MOD43.getText():null)
                                                                                                                                  );
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:646:4: ^( POW a= expr b= expr )
                    {
                    POW44=(CommonTree)match(input,POW,FOLLOW_POW_in_expr2015); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2019);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2025);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        if(((b!=null?b.expressionType:null)!=null)&&((b!=null?b.expressionType:null).equals(Type.INTEGER))){
                                                                            retval.expressionType = Type.REAL;
                                                                        }else{
                                                                            Messages.exponentNotIntegerError(msgLog, new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()), (b!=null?b.expressionType:null));
                                                                        }
                                                                    }else{
                                                                        Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW44!=null?POW44.getLine():0), (POW44!=null?POW44.getCharPositionInLine():0)), (POW44!=null?POW44.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:660:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr2036); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2040);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = (a!=null?a.expressionType:null);
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                                        Messages.incompatibleTypeFoundError(msgLog, (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 17 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:669:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr2061); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2065);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(StaticTypeAnalyzerUtils.checkTypeForNotExpression((a!=null?a.expressionType:null))){
                                                                            retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.BOOLEAN};
                                                                        Messages.incompatibleTypeFoundError(msgLog, (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 18 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:678:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr2085); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:679:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr2092); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:680:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr2099); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:681:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr2106); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:682:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr2113); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:683:4: ID
                    {
                    ID45=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2120); 

                                            Symbol s = currentScope.referenceSymbol(msgLog, (ID45!=null?ID45.getText():null), new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(msgLog, s, new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)), s);
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                        if(!s.isInitialized()){
                                                            Messages.varOrConstNotInitializedButReferencedError(msgLog, new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)), s);
                                                        }
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:700:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr2129); 

                    match(input, Token.DOWN, null); 
                    ID46=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2131); 
                    pushFollow(FOLLOW_arraySubscript_in_expr2133);
                    arraySubscript47=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            Symbol s = currentScope.referenceSymbol(msgLog, (ID46!=null?ID46.getText():null), new Point((ID46!=null?ID46.getLine():0), (ID46!=null?ID46.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        Messages.arrayReferencesInDeclarationsNotAllowedError(msgLog, s, new Point((ID46!=null?ID46.getLine():0), (ID46!=null?ID46.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript47!=null?arraySubscript47.indicesCount:0);
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point((arraySubscript47!=null?((CommonTree)arraySubscript47.start):null).getLine(), (arraySubscript47!=null?((CommonTree)arraySubscript47.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point((ID46!=null?ID46.getLine():0), (ID46!=null?ID46.getCharPositionInLine():0)));
                                                                                }
                                                                            }
                                                                        

                    }
                    break;
                case 25 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:720:17: ^( FUNC_CALL ID paramsList )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_expr2158); 

                    match(input, Token.DOWN, null); 
                    ID48=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2160); 
                    pushFollow(FOLLOW_paramsList_in_expr2162);
                    paramsList49=paramsList();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                                if(BuiltinFunctions.isBuiltinFunctionName((ID48!=null?ID48.getText():null))){
                                                                                    if(paramsList49.size()==1){
                                                                                        Type paramType = paramsList49.get(0);
                                                                                        if(StaticTypeAnalyzerUtils.isNumericType(paramType)){
                                                                                            retval.expressionType = BuiltinFunctions.getReturnTypeForBuiltinFuntion((ID48!=null?ID48.getText():null), paramsList49.get(0));
                                                                                        }else{
                                                                                            Messages.callToBuiltinFunctionWithWrongParamTypeError(msgLog, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)), (ID48!=null?ID48.getText():null), paramType);
                                                                                        }
                                                                                    }else{
                                                                                        Messages.callToBuiltinFunctionWithWrongNumOfParamsError(msgLog, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)), (ID48!=null?ID48.getText():null), paramsList49.size());
                                                                                    }
                                                                                }else{
                                                                                    Messages.callToUnknownFunctionError(msgLog, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)), (ID48!=null?ID48.getText():null), paramsList49);
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


    // $ANTLR start "paramsList"
    // src/glossa/grammars/StaticTypeAnalyzer.g:738:1: paramsList returns [List<Type> paramTypes] : ^( PARAMS ( expr )* ) ;
    public final List<Type> paramsList() throws RecognitionException {
        List<Type> paramTypes = null;

        StaticTypeAnalyzer.expr_return expr50 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:739:2: ( ^( PARAMS ( expr )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:739:4: ^( PARAMS ( expr )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_paramsList2197); 

            List<Type> result = new ArrayList<Type>();

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:740:19: ( expr )*
                loop24:
                do {
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==NEG||LA24_0==ARRAY_ITEM||LA24_0==FUNC_CALL||LA24_0==ID||LA24_0==EQ||(LA24_0>=LT && LA24_0<=GE)||(LA24_0>=OR && LA24_0<=CONST_REAL)) ) {
                        alt24=1;
                    }


                    switch (alt24) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:740:20: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_paramsList2223);
                	    expr50=expr();

                	    state._fsp--;

                	    result.add((expr50!=null?expr50.expressionType:null));

                	    }
                	    break;

                	default :
                	    break loop24;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            paramTypes = result;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return paramTypes;
    }
    // $ANTLR end "paramsList"

    public static class arraySubscript_return extends TreeRuleReturnScope {
        public int indicesCount;
    };

    // $ANTLR start "arraySubscript"
    // src/glossa/grammars/StaticTypeAnalyzer.g:745:1: arraySubscript returns [int indicesCount] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr51 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:746:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:746:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript2304); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:749:19: ( expr )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==NEG||LA25_0==ARRAY_ITEM||LA25_0==FUNC_CALL||LA25_0==ID||LA25_0==EQ||(LA25_0>=LT && LA25_0<=GE)||(LA25_0>=OR && LA25_0<=CONST_REAL)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:749:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript2333);
            	    expr51=expr();

            	    state._fsp--;


            	                                            Type type = (expr51!=null?expr51.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    Messages.arrayIndexNotIntegerError(msgLog, new Point((expr51!=null?((CommonTree)expr51.start):null).getLine(), (expr51!=null?((CommonTree)expr51.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                Messages.arrayIndexNotIntegerError(msgLog, new Point((expr51!=null?((CommonTree)expr51.start):null).getLine(), (expr51!=null?((CommonTree)expr51.start):null).getCharPositionInLine()));
            	                                            }
            	                                            count++;
            	                                        

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


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\21\uffff";
    static final String DFA19_eofS =
        "\21\uffff";
    static final String DFA19_minS =
        "\1\7\2\uffff\1\2\2\uffff\1\2\2\uffff\2\21\2\5\4\uffff";
    static final String DFA19_maxS =
        "\1\67\2\uffff\1\2\2\uffff\1\2\2\uffff\2\21\2\110\4\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\uffff\1\11\1\12\4\uffff\1\4\1"+
        "\3\1\7\1\10";
    static final String DFA19_specialS =
        "\21\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\4\30\uffff\1\1\1\2\1\3\5\uffff\1\5\7\uffff\1\6\4\uffff\1"+
            "\7\1\uffff\1\10",
            "",
            "",
            "\1\11",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\16\3\uffff\1\16\1\15\4\uffff\1\16\1\uffff\1\16\4\uffff\1"+
            "\16\25\uffff\4\16\11\uffff\20\16",
            "\1\17\3\uffff\1\17\1\20\4\uffff\1\17\1\uffff\1\17\4\uffff\1"+
            "\17\25\uffff\4\17\11\uffff\20\17",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "225:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations105 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_varDecl_in_declarations108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000400008L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign185 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_constAssign187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl224 = new BitSet(new long[]{0x00000000F0000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl302 = new BitSet(new long[]{0x0000000000020108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem399 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem401 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension453 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension478 = new BitSet(new long[]{0xFE00F00000428228L,0x00000000000001FFL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block629 = new BitSet(new long[]{0x00A1010700000088L});
    public static final BitSet FOLLOW_PRINT_in_stm643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm648 = new BitSet(new long[]{0xFE00F00000428228L,0x00000000000001FFL});
    public static final BitSet FOLLOW_READ_in_stm671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm673 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm683 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm719 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm721 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm723 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm791 = new BitSet(new long[]{0x000000C000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm793 = new BitSet(new long[]{0x000000C000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm821 = new BitSet(new long[]{0x0000040000002008L});
    public static final BitSet FOLLOW_caseBlock_in_stm824 = new BitSet(new long[]{0x0000040000002008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm853 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm922 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm924 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm967 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm989 = new BitSet(new long[]{0xFE00F00000E28230L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm1012 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_stm1034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm1100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm1102 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm1104 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm1132 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm1154 = new BitSet(new long[]{0xFE00F00000E28230L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm1177 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_stm1199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm1265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm1267 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_stm1269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm1286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm1288 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_stm1290 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1324 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1397 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_ifBlock1399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1434 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1456 = new BitSet(new long[]{0x0000000000A00010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1492 = new BitSet(new long[]{0xFE00F80000E29230L,0x00000000000001FFL});
    public static final BitSet FOLLOW_block_in_caseBlock1515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1566 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1570 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1588 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1617 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1646 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1675 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1702 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1704 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1725 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1746 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1767 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1773 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1788 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1794 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1805 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1809 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1826 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1830 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1836 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1851 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1872 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1889 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1893 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1899 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1914 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1920 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1931 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1935 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1952 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1956 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1962 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1977 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr1983 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1994 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1998 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr2004 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr2015 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2019 = new BitSet(new long[]{0xFE00F00000428220L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expr_in_expr2025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr2036 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2040 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr2061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2065 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr2129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2131 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_expr2158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2160 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_expr2162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_paramsList2197 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_paramsList2223 = new BitSet(new long[]{0xFE00F00000428228L,0x00000000000001FFL});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript2304 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript2333 = new BitSet(new long[]{0xFE00F00000428228L,0x00000000000001FFL});

}