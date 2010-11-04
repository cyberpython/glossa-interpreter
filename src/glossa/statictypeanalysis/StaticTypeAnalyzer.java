// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/StaticTypeAnalyzer.g 2010-11-04 16:57:16


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
import glossa.statictypeanalysis.scopetable.parameters.*;
import glossa.statictypeanalysis.scopetable.scopes.*;
import glossa.statictypeanalysis.scopetable.symbols.*;
import glossa.types.*;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.Point;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StaticTypeAnalyzer extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PARAMS", "FUNC_CALL", "FORMAL_PARAMS", "NEWLINE", "PROGRAM", "ID", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "LPAR", "RPAR", "FUNCTION", "END_FUNCTION", "INTEGER", "REAL", "STRING", "BOOLEAN", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "PROCEDURE", "END_PROCEDURE", "UPSILON", "NU", "CALL", "OMEGA", "OMEGA_TONOS", "XI", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=76;
    public static final int LT=45;
    public static final int END_PROCEDURE=107;
    public static final int WHILE=54;
    public static final int LETTER=115;
    public static final int MOD=66;
    public static final int LAMDA=96;
    public static final int STRINGS=30;
    public static final int UPSILON_DIALYTIKA_TONOS=128;
    public static final int CASE=43;
    public static final int NOT=68;
    public static final int OMICRON=86;
    public static final int EOF=-1;
    public static final int FUNC_CALL=15;
    public static final int LBRACKET=27;
    public static final int MU=92;
    public static final int TAU=93;
    public static final int POW=67;
    public static final int LPAR=74;
    public static final int UPSILON_TONOS=124;
    public static final int CONT_COMMAND=118;
    public static final int CONST_INT=72;
    public static final int LOOP=55;
    public static final int BEGIN=20;
    public static final int KAPPA=82;
    public static final int EQ=23;
    public static final int COMMENT=117;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=121;
    public static final int END_LOOP=53;
    public static final int GE=48;
    public static final int END_SWITCH=42;
    public static final int CONST_TRUE=69;
    public static final int NU=109;
    public static final int XI=113;
    public static final int SWITCH=41;
    public static final int ELSE=39;
    public static final int DELTA=103;
    public static final int EPSILON=94;
    public static final int CONST_STR=71;
    public static final int INTEGERS=31;
    public static final int ALPHA=83;
    public static final int SIGMA_TELIKO=97;
    public static final int REAL=79;
    public static final int FORMAL_PARAMS=16;
    public static final int THETA=102;
    public static final int BOOLEANS=29;
    public static final int UPSILON_DIALYTIKA=126;
    public static final int WS=119;
    public static final int EPSILON_TONOS=95;
    public static final int OMICRON_TONOS=87;
    public static final int READ=34;
    public static final int OMEGA=111;
    public static final int UNTIL=57;
    public static final int OR=58;
    public static final int GT=47;
    public static final int ALPHA_TONOS=98;
    public static final int REPEAT=56;
    public static final int CALL=110;
    public static final int PI=89;
    public static final int FROM=50;
    public static final int PHI=123;
    public static final int RHO=90;
    public static final int UPSILON=108;
    public static final int FOR=49;
    public static final int STEP=52;
    public static final int ETA_TONOS=85;
    public static final int CONSTANTS=22;
    public static final int ID=19;
    public static final int AND=59;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=37;
    public static final int OMEGA_TONOS=112;
    public static final int NOT_EOL=116;
    public static final int BOOLEAN=81;
    public static final int THEN=38;
    public static final int END_FUNCTION=77;
    public static final int COMMA=26;
    public static final int ETA=100;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=104;
    public static final int PLUS=61;
    public static final int SIGMA=101;
    public static final int DIGIT=114;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=28;
    public static final int IOTA_DIALYTIKA_TONOS=127;
    public static final int ELSE_IF=40;
    public static final int CONST_REAL=73;
    public static final int VARSDECL=6;
    public static final int PARAMS=14;
    public static final int INTEGER=78;
    public static final int INF_RANGE=12;
    public static final int TO=51;
    public static final int LATIN_LETTER=120;
    public static final int REALS=32;
    public static final int RANGE=44;
    public static final int CHI=88;
    public static final int MINUS=62;
    public static final int DIA=64;
    public static final int BETA=99;
    public static final int PRINT=33;
    public static final int PROCEDURE=106;
    public static final int COLON=25;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=60;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=21;
    public static final int ZETA=122;
    public static final int CONST_FALSE=70;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=24;
    public static final int ASSIGN=35;
    public static final int END_IF=36;
    public static final int RPAR=75;
    public static final int PROGRAM=18;
    public static final int IOTA=84;
    public static final int DIV=65;
    public static final int GAMMA=91;
    public static final int TIMES=63;
    public static final int LE=46;
    public static final int IOTA_DIALYTIKA=125;
    public static final int STRING=80;
    public static final int IOTA_TONOS=105;

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
            private boolean inSubprogram = false;

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:112:1: unit : program ( ( function )* ) ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:6: ( program ( ( function )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:8: program ( ( function )* )
            {
            pushFollow(FOLLOW_program_in_unit50);
            program();

            state._fsp--;

            // src/glossa/grammars/StaticTypeAnalyzer.g:112:16: ( ( function )* )
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:17: ( function )*
            {
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:17: ( function )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCTION) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:112:17: function
            	    {
            	    pushFollow(FOLLOW_function_in_unit53);
            	    function();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "unit"


    // $ANTLR start "program"
    // src/glossa/grammars/StaticTypeAnalyzer.g:114:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:114:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:114:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program65); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program71); 

                                            currentScope = scopeTable.getMainProgramScope();
                                        
            pushFollow(FOLLOW_declarations_in_program82);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program86);
            block();

            state._fsp--;

            // src/glossa/grammars/StaticTypeAnalyzer.g:120:3: (id2= ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:120:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program94); 

                    }
                    break;

            }


            match(input, Token.UP, null); 

                                                currentScope = null;
                                        

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:126:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:127:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/grammars/StaticTypeAnalyzer.g:127:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/grammars/StaticTypeAnalyzer.g:127:4: ( constDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==CONSTANTS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:127:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations132);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/StaticTypeAnalyzer.g:127:15: ( varDecl )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==VARIABLES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:127:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations135);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:129:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:130:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:130:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl148); 


                                                    inConstantDeclaration=true;
            					if(currentScope.isConstantsDeclared()){
            						Messages.constantsRedeclarationError(msgLog, new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), currentScope.getConstantsDeclarationPoint());
            					}else{
            						currentScope.setConstantsDeclared(true);
            						currentScope.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:139:3: ( constAssign )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==EQ) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:139:3: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl154);
                	    constAssign();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop5;
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:145:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID2=null;
        StaticTypeAnalyzer.expr_return expr3 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:146:2: ( ^( EQ ID expr ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:146:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign210); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign212); 
            pushFollow(FOLLOW_expr_in_constAssign214);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:158:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:158:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:158:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES4=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl245); 


                                                    inVariableDeclaration=true;
            					if(currentScope.isVariablesDeclared()){
            						Messages.variablesRedeclarationError(msgLog, new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)), currentScope.getVariablesDeclarationPoint());
            					}else{
            						currentScope.setVariablesDeclared(true);
            						currentScope.setVariablesDeclarationPoint(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:167:3: ( varsDecl )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=BOOLEANS && LA6_0<=REALS)) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:167:3: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl251);
                	    varsDecl();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop6;
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:174:1: varsDecl : ^( varType ( varDeclItem[$varType.result] )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Type varType5 = null;

        Symbol varDeclItem6 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:175:2: ( ^( varType ( varDeclItem[$varType.result] )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:175:4: ^( varType ( varDeclItem[$varType.result] )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl306);
            varType5=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:177:21: ( varDeclItem[$varType.result] )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ARRAY||LA7_0==ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:177:22: varDeclItem[$varType.result]
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl329);
            	    varDeclItem6=varDeclItem(varType5);

            	    state._fsp--;


            	                                                                Symbol s = varDeclItem6;
            	                                                                currentScope.defineSymbol(msgLog, s.getName(), s);
            	                                                            

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
    // $ANTLR end "varsDecl"


    // $ANTLR start "varDeclItem"
    // src/glossa/grammars/StaticTypeAnalyzer.g:184:1: varDeclItem[Type t] returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem(Type t) throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        int arrayDimension9 = 0;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:185:2: ( ID | ^( ARRAY ID arrayDimension ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==ARRAY) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:185:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem392); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), t, (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex());
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:188:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem426); 

                    match(input, Token.DOWN, null); 
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem428); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem430);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:195:1: arrayDimension returns [int indicesCount] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final int arrayDimension() throws RecognitionException {
        int indicesCount = 0;

        StaticTypeAnalyzer.expr_return expr10 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:196:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:196:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension480); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:200:21: ( expr )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==NEG||LA9_0==ARRAY_ITEM||LA9_0==FUNC_CALL||LA9_0==ID||LA9_0==EQ||(LA9_0>=LT && LA9_0<=GE)||(LA9_0>=OR && LA9_0<=CONST_REAL)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:200:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension505);
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:213:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:214:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            int alt10=4;
            switch ( input.LA(1) ) {
            case BOOLEANS:
                {
                alt10=1;
                }
                break;
            case STRINGS:
                {
                alt10=2;
                }
                break;
            case INTEGERS:
                {
                alt10=3;
                }
                break;
            case REALS:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:214:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType620); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:215:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType627); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:216:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType634); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:217:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType641); 
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:219:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:219:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:219:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block654); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:219:17: ( stm )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IFNODE||(LA11_0>=PRINT && LA11_0<=ASSIGN)||LA11_0==SWITCH||LA11_0==FOR||LA11_0==WHILE||LA11_0==REPEAT) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:219:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block656);
                	    stm();

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:224:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );
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
            // src/glossa/grammars/StaticTypeAnalyzer.g:224:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) )
            int alt20=10;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:224:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm670); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/grammars/StaticTypeAnalyzer.g:224:15: (expr1= expr )*
                        loop12:
                        do {
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0==NEG||LA12_0==ARRAY_ITEM||LA12_0==FUNC_CALL||LA12_0==ID||LA12_0==EQ||(LA12_0>=LT && LA12_0<=GE)||(LA12_0>=OR && LA12_0<=CONST_REAL)) ) {
                                alt12=1;
                            }


                            switch (alt12) {
                        	case 1 :
                        	    // src/glossa/grammars/StaticTypeAnalyzer.g:224:16: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm675);
                        	    expr1=expr();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop12;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:225:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm698); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/grammars/StaticTypeAnalyzer.g:225:24: ( readItem )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:225:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm700);
                    	    readItem();

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
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:226:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm708); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm710); 
                    pushFollow(FOLLOW_expr_in_stm712);
                    expr12=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       
                                                                    boolean varAssignment = true;
                                                                    if(currentScope instanceof FunctionScope){
                                                                        FunctionScope fs = (FunctionScope) currentScope;
                                                                        if(fs.getSubprogramName().toLowerCase().equals((ID11!=null?ID11.getText():null).toLowerCase())){
                                                                            varAssignment = false;
                                                                            fs.setReturnValueSet(true);
                                                                             if (StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(fs.getReturnType(), (expr12!=null?expr12.expressionType:null)) < 0) {
                                                                                Messages.incompatibleTypesFoundError(msgLog, fs.getReturnType(), new Point( (ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)), (expr12!=null?expr12.expressionType:null), new Point((expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine()), new Point((ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0)), (ASSIGN13!=null?ASSIGN13.getText():null));
                                                                            }
                                                                        }
                                                                    }
                                                                    if(varAssignment){
                                                                        StaticTypeAnalyzerUtils.checkVariableAssignment(msgLog, this.currentScope, (ID11!=null?ID11.getText():null), (ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0),
                                                                                                        (expr12!=null?expr12.expressionType:null), (expr12!=null?expr12.resultForm:null), (expr12!=null?((CommonTree)expr12.start):null).getText(), (expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine(),
                                                                                                        (ASSIGN13!=null?ASSIGN13.getText():null), (ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0));
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:244:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    ASSIGN16=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm744); 

                    match(input, Token.DOWN, null); 
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_stm746); 
                    pushFollow(FOLLOW_arraySubscript_in_stm748);
                    arraySubscript17=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm750);
                    expr15=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkArrayAssignment(msgLog, this.currentScope, (ID14!=null?ID14.getText():null), (ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0),
                                                                                              (expr15!=null?expr15.expressionType:null), (expr15!=null?expr15.resultForm:null), (expr15!=null?((CommonTree)expr15.start):null).getText(), (expr15!=null?((CommonTree)expr15.start):null).getLine(), (expr15!=null?((CommonTree)expr15.start):null).getCharPositionInLine(),
                                                                                              (ASSIGN16!=null?ASSIGN16.getText():null), (ASSIGN16!=null?ASSIGN16.getLine():0), (ASSIGN16!=null?ASSIGN16.getCharPositionInLine():0),
                                                                                              (arraySubscript17!=null?arraySubscript17.indicesCount:0), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getLine(), (arraySubscript17!=null?((CommonTree)arraySubscript17.start):null).getCharPositionInLine());
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:251:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm816); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm818);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:251:34: ( elseIfBlock )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ELSE_IF) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:251:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm820);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // src/glossa/grammars/StaticTypeAnalyzer.g:251:47: ( elseBlock )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ELSE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:251:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm823);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:252:17: ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? )
                    {
                    SWITCH19=(CommonTree)match(input,SWITCH,FOLLOW_SWITCH_in_stm844); 

                    int numberOfCases = 0;

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm848);
                    expr18=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:252:56: ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==CASE) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/glossa/grammars/StaticTypeAnalyzer.g:252:57: caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())]
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm851);
                    	    caseBlock((expr18!=null?expr18.expressionType:null), new Point((expr18!=null?((CommonTree)expr18.start):null).getLine(), (expr18!=null?((CommonTree)expr18.start):null).getCharPositionInLine()));

                    	    state._fsp--;

                    	    numberOfCases++;

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // src/glossa/grammars/StaticTypeAnalyzer.g:253:19: ( caseElseBlock )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==CASE_ELSE) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:253:20: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm880);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:259:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm949); 

                    match(input, Token.DOWN, null); 
                    ID20=(CommonTree)match(input,ID,FOLLOW_ID_in_stm951); 

                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID20!=null?ID20.getText():null), new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Variable)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm994);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1016);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:267:19: (expr3= expr )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==NEG||LA18_0==ARRAY_ITEM||LA18_0==FUNC_CALL||LA18_0==ID||LA18_0==EQ||(LA18_0>=LT && LA18_0<=GE)||(LA18_0>=OR && LA18_0<=CONST_REAL)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:267:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm1039);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1061);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:306:17: ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm1127); 

                    match(input, Token.DOWN, null); 
                    ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_stm1129); 
                    pushFollow(FOLLOW_arraySubscript_in_stm1131);
                    arraySubscript22=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID21!=null?ID21.getText():null), new Point((ID21!=null?ID21.getLine():0), (ID21!=null?ID21.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Array)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm1159);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1181);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/grammars/StaticTypeAnalyzer.g:314:19: (expr3= expr )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==NEG||LA19_0==ARRAY_ITEM||LA19_0==FUNC_CALL||LA19_0==ID||LA19_0==EQ||(LA19_0>=LT && LA19_0<=GE)||(LA19_0>=OR && LA19_0<=CONST_REAL)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // src/glossa/grammars/StaticTypeAnalyzer.g:314:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm1204);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1226);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:360:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm1292); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm1294);
                    expr23=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm1296);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:369:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm1313); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm1315);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1317);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:380:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript25 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:380:9: (arrId= ID arraySubscript | varId= ID )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==UP||LA21_1==ID) ) {
                    alt21=2;
                }
                else if ( (LA21_1==ARRAY_INDEX) ) {
                    alt21=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:380:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1351); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1353);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:401:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1377); 

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:418:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr26 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:418:9: ( ^( IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:418:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1422); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1424);
            expr26=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1426);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:429:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:430:2: ( ^( ELSE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:430:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1459); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1461);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:433:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr27 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:434:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:434:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1481); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1483);
            expr27=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1485);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:446:1: caseBlock[Type exprType, Point exprPoint] : ^( CASE ( caseExprListItem )+ block ) ;
    public final StaticTypeAnalyzer.caseBlock_return caseBlock(Type exprType, Point exprPoint) throws RecognitionException {
        StaticTypeAnalyzer.caseBlock_return retval = new StaticTypeAnalyzer.caseBlock_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.caseExprListItem_return caseExprListItem28 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:447:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:447:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1516); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:447:11: ( caseExprListItem )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==NEG||LA22_0==ARRAY_ITEM||LA22_0==INF_RANGE||LA22_0==FUNC_CALL||LA22_0==ID||LA22_0==EQ||(LA22_0>=RANGE && LA22_0<=GE)||(LA22_0>=OR && LA22_0<=CONST_REAL)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:447:12: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1519);
            	    caseExprListItem28=caseExprListItem();

            	    state._fsp--;

            	       if( !StaticTypeAnalyzerUtils.checkTypesForCaseStatement(exprType, (caseExprListItem28!=null?caseExprListItem28.expressionType:null)) ){
            	                                                            Messages.incompatibleTypesForCaseStmFoundError(msgLog, exprType, exprPoint, (caseExprListItem28!=null?caseExprListItem28.expressionType:null), new Point((caseExprListItem28!=null?((CommonTree)caseExprListItem28.start):null).getLine(), (caseExprListItem28!=null?((CommonTree)caseExprListItem28.start):null).getCharPositionInLine()), new Point(((CommonTree)retval.start).getLine(), ((CommonTree)retval.start).getCharPositionInLine()));
            	                                                }
            	                                            

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            pushFollow(FOLLOW_block_in_caseBlock1542);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:453:1: caseExprListItem returns [Type expressionType] : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final StaticTypeAnalyzer.caseExprListItem_return caseExprListItem() throws RecognitionException {
        StaticTypeAnalyzer.caseExprListItem_return retval = new StaticTypeAnalyzer.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree RANGE29=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:454:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
            int alt23=6;
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
                alt23=1;
                }
                break;
            case RANGE:
                {
                alt23=2;
                }
                break;
            case INF_RANGE:
                {
                int LA23_3 = input.LA(2);

                if ( (LA23_3==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case LT:
                        {
                        alt23=3;
                        }
                        break;
                    case LE:
                        {
                        alt23=4;
                        }
                        break;
                    case GT:
                        {
                        alt23=5;
                        }
                        break;
                    case GE:
                        {
                        alt23=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:454:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1558);
                    a=expr();

                    state._fsp--;


                                                                retval.expressionType = (a!=null?a.expressionType:null);
                                                            

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:457:10: ^( RANGE a= expr b= expr )
                    {
                    RANGE29=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1589); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1593);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1597);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:467:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1613); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1615); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1619);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:478:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1642); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1644); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1648);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:489:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1671); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1673); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1677);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:500:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1700); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1702); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1706);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:513:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:514:2: ( ^( CASE_ELSE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:514:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1729); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1731);
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
        public ExpressionResultForm resultForm;
    };

    // $ANTLR start "expr"
    // src/glossa/grammars/StaticTypeAnalyzer.g:518:1: expr returns [Type expressionType, ExpressionResultForm resultForm] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) );
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

        List<ActualParameter> paramsList49 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:519:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) )
            int alt24=25;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt24=1;
                }
                break;
            case OR:
                {
                alt24=2;
                }
                break;
            case EQ:
                {
                alt24=3;
                }
                break;
            case NEQ:
                {
                alt24=4;
                }
                break;
            case LT:
                {
                alt24=5;
                }
                break;
            case LE:
                {
                alt24=6;
                }
                break;
            case GT:
                {
                alt24=7;
                }
                break;
            case GE:
                {
                alt24=8;
                }
                break;
            case PLUS:
                {
                alt24=9;
                }
                break;
            case MINUS:
                {
                alt24=10;
                }
                break;
            case TIMES:
                {
                alt24=11;
                }
                break;
            case DIA:
                {
                alt24=12;
                }
                break;
            case DIV:
                {
                alt24=13;
                }
                break;
            case MOD:
                {
                alt24=14;
                }
                break;
            case POW:
                {
                alt24=15;
                }
                break;
            case NEG:
                {
                alt24=16;
                }
                break;
            case NOT:
                {
                alt24=17;
                }
                break;
            case CONST_TRUE:
                {
                alt24=18;
                }
                break;
            case CONST_FALSE:
                {
                alt24=19;
                }
                break;
            case CONST_STR:
                {
                alt24=20;
                }
                break;
            case CONST_INT:
                {
                alt24=21;
                }
                break;
            case CONST_REAL:
                {
                alt24=22;
                }
                break;
            case ID:
                {
                alt24=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt24=24;
                }
                break;
            case FUNC_CALL:
                {
                alt24=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:519:4: ^( AND a= expr b= expr )
                    {
                    AND30=(CommonTree)match(input,AND,FOLLOW_AND_in_expr1748); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1752);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1758);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:534:4: ^( OR a= expr b= expr )
                    {
                    OR31=(CommonTree)match(input,OR,FOLLOW_OR_in_expr1769); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1773);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1779);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:549:4: ^( EQ a= expr b= expr )
                    {
                    EQ32=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1790); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1794);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1800);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:564:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ33=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1811); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1815);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1821);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:579:4: ^( LT a= expr b= expr )
                    {
                    LT34=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1832); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1836);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1842);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:594:4: ^( LE a= expr b= expr )
                    {
                    LE35=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1853); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1857);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1863);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:609:4: ^( GT a= expr b= expr )
                    {
                    GT36=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1874); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1878);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1884);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:624:4: ^( GE a= expr b= expr )
                    {
                    GE37=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1895); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1899);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1905);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:639:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS38=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1916); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1920);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1926);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:654:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS39=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1937); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1941);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1947);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:669:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES40=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1958); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1962);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1968);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:684:4: ^( DIA a= expr b= expr )
                    {
                    DIA41=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr1979); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1983);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1989);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:699:4: ^( DIV a= expr b= expr )
                    {
                    DIV42=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2000); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2004);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2010);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:714:4: ^( MOD a= expr b= expr )
                    {
                    MOD43=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr2021); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2025);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2031);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:729:4: ^( POW a= expr b= expr )
                    {
                    POW44=(CommonTree)match(input,POW,FOLLOW_POW_in_expr2042); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2046);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2052);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultsForms(msgLog, (a!=null?a.resultForm:null), (b!=null?b.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(),
                                                                                (b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine(),
                                                                                (a!=null?((CommonTree)a.start):null).getText(), (b!=null?((CommonTree)b.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:748:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr2063); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2067);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultForm(msgLog, (a!=null?a.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(), (a!=null?((CommonTree)a.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:760:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr2088); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2092);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkResultForm(msgLog, (a!=null?a.resultForm:null),
                                                                                (a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine(), (a!=null?((CommonTree)a.start):null).getText());
                                                                    retval.resultForm =ExpressionResultForm.VALUE;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:772:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr2112); 
                    retval.expressionType = Type.BOOLEAN; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 19 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:773:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr2119); 
                    retval.expressionType = Type.BOOLEAN; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 20 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:774:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr2126); 
                    retval.expressionType = Type.STRING; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 21 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:775:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr2133); 
                    retval.expressionType = Type.INTEGER; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 22 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:776:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr2140); 
                    retval.expressionType = Type.REAL; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 23 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:777:4: ID
                    {
                    ID45=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2147); 

                                            retval.resultForm =ExpressionResultForm.VARIABLE;
                                            Symbol s = currentScope.referenceSymbol(msgLog, (ID45!=null?ID45.getText():null), new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(msgLog, s, new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        //Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point((ID45!=null?ID45.getLine():0), (ID45!=null?ID45.getCharPositionInLine():0)), s);
                                                        retval.resultForm =ExpressionResultForm.ARRAY;
                                                        retval.expressionType = s.getType();
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:797:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr2156); 

                    match(input, Token.DOWN, null); 
                    ID46=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2158); 
                    pushFollow(FOLLOW_arraySubscript_in_expr2160);
                    arraySubscript47=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            retval.resultForm =ExpressionResultForm.ARRAY_ITEM;
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:818:17: ^( FUNC_CALL ID paramsList )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_expr2185); 

                    match(input, Token.DOWN, null); 
                    ID48=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2187); 
                    pushFollow(FOLLOW_paramsList_in_expr2189);
                    paramsList49=paramsList();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                                retval.resultForm =ExpressionResultForm.FUNCTION_CALL;
                                                                                if(BuiltinFunctions.isBuiltinFunctionName((ID48!=null?ID48.getText():null))){
                                                                                    if(paramsList49.size()==1){
                                                                                        Type paramType = paramsList49.get(0).getType();
                                                                                        if(StaticTypeAnalyzerUtils.isNumericType(paramType)){
                                                                                            retval.expressionType = BuiltinFunctions.getReturnTypeForBuiltinFuntion((ID48!=null?ID48.getText():null), paramType);
                                                                                        }else{
                                                                                            Messages.callToBuiltinFunctionWithWrongParamTypeError(msgLog, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)), (ID48!=null?ID48.getText():null), paramType);
                                                                                        }
                                                                                    }else{
                                                                                        Messages.callToBuiltinFunctionWithWrongNumOfParamsError(msgLog, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)), (ID48!=null?ID48.getText():null), paramsList49.size());
                                                                                    }
                                                                                }else{
                                                                                    retval.expressionType = StaticTypeAnalyzerUtils.checkFunctionCall(msgLog, this.scopeTable, (ID48!=null?ID48.getText():null), (ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0), paramsList49);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:837:1: paramsList returns [List<ActualParameter> params] : ^( PARAMS ( expr )* ) ;
    public final List<ActualParameter> paramsList() throws RecognitionException {
        List<ActualParameter> params = null;

        StaticTypeAnalyzer.expr_return expr50 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:838:2: ( ^( PARAMS ( expr )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:838:4: ^( PARAMS ( expr )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_paramsList2224); 

            List<ActualParameter> result = new ArrayList<ActualParameter>();

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:839:19: ( expr )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NEG||LA25_0==ARRAY_ITEM||LA25_0==FUNC_CALL||LA25_0==ID||LA25_0==EQ||(LA25_0>=LT && LA25_0<=GE)||(LA25_0>=OR && LA25_0<=CONST_REAL)) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:839:20: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_paramsList2250);
                	    expr50=expr();

                	    state._fsp--;

                	    result.add(new ActualParameter((expr50!=null?((CommonTree)expr50.start):null).getLine(), (expr50!=null?((CommonTree)expr50.start):null).getCharPositionInLine(), (expr50!=null?expr50.expressionType:null), (expr50!=null?expr50.resultForm:null)));

                	    }
                	    break;

                	default :
                	    break loop25;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            params = result;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return params;
    }
    // $ANTLR end "paramsList"

    public static class arraySubscript_return extends TreeRuleReturnScope {
        public int indicesCount;
    };

    // $ANTLR start "arraySubscript"
    // src/glossa/grammars/StaticTypeAnalyzer.g:844:1: arraySubscript returns [int indicesCount] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr51 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:845:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:845:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript2331); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:848:19: ( expr )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==NEG||LA26_0==ARRAY_ITEM||LA26_0==FUNC_CALL||LA26_0==ID||LA26_0==EQ||(LA26_0>=LT && LA26_0<=GE)||(LA26_0>=OR && LA26_0<=CONST_REAL)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:848:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript2360);
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
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
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


    // $ANTLR start "function"
    // src/glossa/grammars/StaticTypeAnalyzer.g:864:1: function : ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block ) ;
    public final void function() throws RecognitionException {
        CommonTree ID52=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:865:2: ( ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:865:4: ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function2463); 


                                                    inSubprogram = true;
                                                

            match(input, Token.DOWN, null); 
            ID52=(CommonTree)match(input,ID,FOLLOW_ID_in_function2494); 
            pushFollow(FOLLOW_returnType_in_function2496);
            returnType();

            state._fsp--;

            pushFollow(FOLLOW_formalParamsList_in_function2498);
            formalParamsList();

            state._fsp--;


                                                    FunctionScope fs = scopeTable.getFunctionScope((ID52!=null?ID52.getText():null));
                                                    currentScope = fs;
                                                
            // src/glossa/grammars/StaticTypeAnalyzer.g:873:19: ( constDecl )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==CONSTANTS) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:873:19: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_function2556);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/StaticTypeAnalyzer.g:874:19: ( varDecl )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==VARIABLES) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:874:19: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_function2577);
                    varDecl();

                    state._fsp--;


                    }
                    break;

            }


                                                    List<FormalParameter> formalParams = fs.getFormalParameters();
                                                    HashMap<String, Symbol> symbols = fs.getSymbols();
                                                    for(Iterator<FormalParameter> it = formalParams.iterator(); it.hasNext();){
                                                        FormalParameter param = it.next();
                                                        Symbol symbol = symbols.get(param.getName().toLowerCase());
                                                        if (symbol == null) {
                                                            Messages.parameterNotDeclaredError(msgLog, new Point(param.getLine(), param.getPos()), param.getName());
                                                        }else{
                                                            if((symbol instanceof Variable)||(symbol instanceof Array)){
                                                                symbol.setInitialized(true);
                                                                param.setSymbol(symbol);
                                                            }else{
                                                                msgLog.error(new Point(param.getLine(), param.getPos()), Messages.STR_ERROR_PARAMETER_MUST_BE_DECLARED_AS_VAR_OR_ARRAY);
                                                            }
                                                        }
                                                    }
                                                
            pushFollow(FOLLOW_block_in_function2609);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                    if(!fs.isReturnValueSet()){
                                                        Messages.functionReturnValueNotSetError(msgLog, new Point((ID52!=null?ID52.getLine():0), (ID52!=null?ID52.getCharPositionInLine():0)), fs.getSubprogramName(), fs.getFormalParameters());
                                                    }
                                                    inSubprogram = false;
                                                    currentScope = null;
                                                

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
    // $ANTLR end "function"


    // $ANTLR start "returnType"
    // src/glossa/grammars/StaticTypeAnalyzer.g:902:1: returnType : ( INTEGER | REAL | STRING | BOOLEAN );
    public final void returnType() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:903:2: ( INTEGER | REAL | STRING | BOOLEAN )
            // src/glossa/grammars/StaticTypeAnalyzer.g:
            {
            if ( (input.LA(1)>=INTEGER && input.LA(1)<=BOOLEAN) ) {
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
    // $ANTLR end "returnType"


    // $ANTLR start "formalParamsList"
    // src/glossa/grammars/StaticTypeAnalyzer.g:912:1: formalParamsList : ^( FORMAL_PARAMS ( ID )* ) ;
    public final void formalParamsList() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:913:2: ( ^( FORMAL_PARAMS ( ID )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:913:4: ^( FORMAL_PARAMS ( ID )* )
            {
            match(input,FORMAL_PARAMS,FOLLOW_FORMAL_PARAMS_in_formalParamsList2702); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:913:20: ( ID )*
                loop29:
                do {
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==ID) ) {
                        alt29=1;
                    }


                    switch (alt29) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:913:21: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_formalParamsList2705); 

                	    }
                	    break;

                	default :
                	    break loop29;
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
    // $ANTLR end "formalParamsList"

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\21\uffff";
    static final String DFA20_eofS =
        "\21\uffff";
    static final String DFA20_minS =
        "\1\7\2\uffff\1\2\2\uffff\1\2\2\uffff\2\23\2\5\4\uffff";
    static final String DFA20_maxS =
        "\1\70\2\uffff\1\2\2\uffff\1\2\2\uffff\2\23\2\111\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\uffff\1\11\1\12\4\uffff\1\3\1"+
        "\4\1\7\1\10";
    static final String DFA20_specialS =
        "\21\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\4\31\uffff\1\1\1\2\1\3\5\uffff\1\5\7\uffff\1\6\4\uffff\1"+
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
            "\1\15\3\uffff\1\15\1\16\4\uffff\1\15\3\uffff\1\15\3\uffff\1"+
            "\15\25\uffff\4\15\11\uffff\20\15",
            "\1\17\3\uffff\1\17\1\20\4\uffff\1\17\3\uffff\1\17\3\uffff\1"+
            "\17\25\uffff\4\17\11\uffff\20\17",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "224:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_function_in_unit53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_PROGRAM_in_program65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program71 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_declarations_in_program82 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_program86 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ID_in_program94 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations132 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_varDecl_in_declarations135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl154 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_EQ_in_constAssign210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign212 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_constAssign214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl251 = new BitSet(new long[]{0x00000001E0000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl306 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl329 = new BitSet(new long[]{0x0000000000080108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem428 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension505 = new BitSet(new long[]{0xFC01E00000888228L,0x00000000000003FFL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block656 = new BitSet(new long[]{0x0142020E00000088L});
    public static final BitSet FOLLOW_PRINT_in_stm670 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm675 = new BitSet(new long[]{0xFC01E00000888228L,0x00000000000003FFL});
    public static final BitSet FOLLOW_READ_in_stm698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm700 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm708 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm710 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm712 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm744 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm746 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm748 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm818 = new BitSet(new long[]{0x0000018000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm820 = new BitSet(new long[]{0x0000018000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm848 = new BitSet(new long[]{0x0000080000002008L});
    public static final BitSet FOLLOW_caseBlock_in_stm851 = new BitSet(new long[]{0x0000080000002008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm880 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm951 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm994 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1016 = new BitSet(new long[]{0xFC01E00001C88230L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1039 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm1127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm1129 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm1131 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1159 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1181 = new BitSet(new long[]{0xFC01E00001C88230L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1204 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1226 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm1292 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm1294 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm1313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm1315 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_stm1317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1351 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1424 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_ifBlock1426 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1459 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1483 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1485 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1516 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1519 = new BitSet(new long[]{0xFC01F00001C89230L,0x00000000000003FFL});
    public static final BitSet FOLLOW_block_in_caseBlock1542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1593 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1615 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1619 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1644 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1648 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1673 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1702 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1752 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1773 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1794 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1815 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1821 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1832 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1836 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1842 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1857 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1878 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1899 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1905 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1916 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1920 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1926 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1941 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1962 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1983 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr1989 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2000 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2004 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr2010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr2021 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2025 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr2031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr2042 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2046 = new BitSet(new long[]{0xFC01E00000888220L,0x00000000000003FFL});
    public static final BitSet FOLLOW_expr_in_expr2052 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr2063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2067 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr2088 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2092 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr2156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2158 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr2160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_expr2185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2187 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_expr2189 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_paramsList2224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_paramsList2250 = new BitSet(new long[]{0xFC01E00000888228L,0x00000000000003FFL});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript2331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript2360 = new BitSet(new long[]{0xFC01E00000888228L,0x00000000000003FFL});
    public static final BitSet FOLLOW_FUNCTION_in_function2463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function2494 = new BitSet(new long[]{0x0000000000000000L,0x000000000003C000L});
    public static final BitSet FOLLOW_returnType_in_function2496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParamsList_in_function2498 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_constDecl_in_function2556 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_varDecl_in_function2577 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_function2609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_returnType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAL_PARAMS_in_formalParamsList2702 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_formalParamsList2705 = new BitSet(new long[]{0x0000000000080008L});

}