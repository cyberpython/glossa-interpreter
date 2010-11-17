// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/StaticTypeAnalyzer.g 2010-11-16 20:42:17


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "NEG", "VARSDECL", "IFNODE", "ARRAY", "ARRAY_ITEM", "ARRAY_INDEX", "ARRAY_DIMENSION", "INF_RANGE", "CASE_ELSE", "PARAMS", "FUNC_CALL", "FORMAL_PARAMS", "NEWLINE", "PROGRAM", "ID", "BEGIN", "END_PROGRAM", "CONSTANTS", "EQ", "VARIABLES", "COLON", "COMMA", "LBRACKET", "RBRACKET", "BOOLEANS", "STRINGS", "INTEGERS", "REALS", "PRINT", "READ", "ASSIGN", "END_IF", "IF", "THEN", "ELSE", "ELSE_IF", "SWITCH", "END_SWITCH", "CASE", "RANGE", "LT", "LE", "GT", "GE", "FOR", "FROM", "TO", "STEP", "END_LOOP", "WHILE", "LOOP", "REPEAT", "UNTIL", "CALL", "LPAR", "RPAR", "OR", "AND", "NEQ", "PLUS", "MINUS", "TIMES", "DIA", "DIV", "MOD", "POW", "NOT", "CONST_TRUE", "CONST_FALSE", "CONST_STR", "CONST_INT", "CONST_REAL", "PROCEDURE", "END_PROCEDURE", "FUNCTION", "END_FUNCTION", "INTEGER", "REAL", "STRING", "BOOLEAN", "KAPPA", "ALPHA", "IOTA", "ETA_TONOS", "OMICRON", "OMICRON_TONOS", "CHI", "PI", "RHO", "GAMMA", "MU", "TAU", "EPSILON", "EPSILON_TONOS", "LAMDA", "SIGMA_TELIKO", "ALPHA_TONOS", "BETA", "ETA", "SIGMA", "THETA", "DELTA", "PSI", "IOTA_TONOS", "UPSILON", "NU", "OMEGA", "OMEGA_TONOS", "XI", "DIGIT", "LETTER", "NOT_EOL", "COMMENT", "CONT_COMMAND", "WS", "LATIN_LETTER", "GREEK_LETTER", "ZETA", "PHI", "UPSILON_TONOS", "IOTA_DIALYTIKA", "UPSILON_DIALYTIKA", "IOTA_DIALYTIKA_TONOS", "UPSILON_DIALYTIKA_TONOS"
    };
    public static final int FUNCTION=79;
    public static final int LT=45;
    public static final int END_PROCEDURE=78;
    public static final int WHILE=54;
    public static final int LETTER=115;
    public static final int MOD=69;
    public static final int LAMDA=99;
    public static final int STRINGS=30;
    public static final int UPSILON_DIALYTIKA_TONOS=128;
    public static final int CASE=43;
    public static final int NOT=71;
    public static final int OMICRON=89;
    public static final int EOF=-1;
    public static final int FUNC_CALL=15;
    public static final int LBRACKET=27;
    public static final int MU=95;
    public static final int TAU=96;
    public static final int POW=70;
    public static final int LPAR=59;
    public static final int UPSILON_TONOS=124;
    public static final int CONT_COMMAND=118;
    public static final int CONST_INT=75;
    public static final int LOOP=55;
    public static final int BEGIN=20;
    public static final int KAPPA=85;
    public static final int EQ=23;
    public static final int COMMENT=117;
    public static final int ARRAY=8;
    public static final int GREEK_LETTER=121;
    public static final int END_LOOP=53;
    public static final int GE=48;
    public static final int END_SWITCH=42;
    public static final int CONST_TRUE=72;
    public static final int NU=110;
    public static final int XI=113;
    public static final int SWITCH=41;
    public static final int ELSE=39;
    public static final int DELTA=106;
    public static final int EPSILON=97;
    public static final int CONST_STR=74;
    public static final int INTEGERS=31;
    public static final int ALPHA=86;
    public static final int SIGMA_TELIKO=100;
    public static final int REAL=82;
    public static final int FORMAL_PARAMS=16;
    public static final int THETA=105;
    public static final int BOOLEANS=29;
    public static final int UPSILON_DIALYTIKA=126;
    public static final int WS=119;
    public static final int EPSILON_TONOS=98;
    public static final int OMICRON_TONOS=90;
    public static final int READ=34;
    public static final int OMEGA=111;
    public static final int UNTIL=57;
    public static final int OR=61;
    public static final int GT=47;
    public static final int ALPHA_TONOS=101;
    public static final int REPEAT=56;
    public static final int PI=92;
    public static final int CALL=58;
    public static final int FROM=50;
    public static final int PHI=123;
    public static final int RHO=93;
    public static final int UPSILON=109;
    public static final int FOR=49;
    public static final int STEP=52;
    public static final int ETA_TONOS=88;
    public static final int CONSTANTS=22;
    public static final int ID=19;
    public static final int AND=62;
    public static final int ARRAY_DIMENSION=11;
    public static final int IF=37;
    public static final int OMEGA_TONOS=112;
    public static final int NOT_EOL=116;
    public static final int BOOLEAN=84;
    public static final int THEN=38;
    public static final int END_FUNCTION=80;
    public static final int COMMA=26;
    public static final int ETA=103;
    public static final int ARRAY_INDEX=10;
    public static final int IFNODE=7;
    public static final int PSI=107;
    public static final int PLUS=64;
    public static final int SIGMA=104;
    public static final int DIGIT=114;
    public static final int CASE_ELSE=13;
    public static final int RBRACKET=28;
    public static final int IOTA_DIALYTIKA_TONOS=127;
    public static final int ELSE_IF=40;
    public static final int CONST_REAL=76;
    public static final int VARSDECL=6;
    public static final int PARAMS=14;
    public static final int INTEGER=81;
    public static final int INF_RANGE=12;
    public static final int TO=51;
    public static final int LATIN_LETTER=120;
    public static final int REALS=32;
    public static final int RANGE=44;
    public static final int CHI=91;
    public static final int MINUS=65;
    public static final int DIA=67;
    public static final int BETA=102;
    public static final int PROCEDURE=77;
    public static final int PRINT=33;
    public static final int COLON=25;
    public static final int ARRAY_ITEM=9;
    public static final int NEQ=63;
    public static final int NEWLINE=17;
    public static final int END_PROGRAM=21;
    public static final int ZETA=122;
    public static final int CONST_FALSE=73;
    public static final int BLOCK=4;
    public static final int NEG=5;
    public static final int VARIABLES=24;
    public static final int ASSIGN=35;
    public static final int END_IF=36;
    public static final int RPAR=60;
    public static final int PROGRAM=18;
    public static final int IOTA=87;
    public static final int DIV=68;
    public static final int TIMES=66;
    public static final int GAMMA=94;
    public static final int LE=46;
    public static final int IOTA_DIALYTIKA=125;
    public static final int STRING=83;
    public static final int IOTA_TONOS=108;

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:112:1: unit : program ( function | procedure )* ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:6: ( program ( function | procedure )* )
            // src/glossa/grammars/StaticTypeAnalyzer.g:112:8: program ( function | procedure )*
            {
            pushFollow(FOLLOW_program_in_unit50);
            program();

            state._fsp--;

            // src/glossa/grammars/StaticTypeAnalyzer.g:112:16: ( function | procedure )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCTION) ) {
                    alt1=1;
                }
                else if ( (LA1_0==PROCEDURE) ) {
                    alt1=2;
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
            	case 2 :
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:112:26: procedure
            	    {
            	    pushFollow(FOLLOW_procedure_in_unit55);
            	    procedure();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "unit"


    // $ANTLR start "program"
    // src/glossa/grammars/StaticTypeAnalyzer.g:114:1: program : ^( PROGRAM id1= ID declarations block END_PROGRAM (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:114:9: ( ^( PROGRAM id1= ID declarations block END_PROGRAM (id2= ID )? ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:114:11: ^( PROGRAM id1= ID declarations block END_PROGRAM (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program67); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program73); 

                                            currentScope = scopeTable.getMainProgramScope();
                                        
            pushFollow(FOLLOW_declarations_in_program84);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program88);
            block();

            state._fsp--;

            match(input,END_PROGRAM,FOLLOW_END_PROGRAM_in_program90); 
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
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program97); 

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
                    pushFollow(FOLLOW_constDecl_in_declarations135);
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
                    pushFollow(FOLLOW_varDecl_in_declarations138);
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
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl151); 


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
                	    pushFollow(FOLLOW_constAssign_in_constDecl157);
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
            match(input,EQ,FOLLOW_EQ_in_constAssign213); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign215); 
            pushFollow(FOLLOW_expr_in_constAssign217);
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
            VARIABLES4=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl248); 


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
                	    pushFollow(FOLLOW_varsDecl_in_varDecl254);
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
            pushFollow(FOLLOW_varType_in_varsDecl309);
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
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl332);
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
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem395); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), t, (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex());
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:188:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem429); 

                    match(input, Token.DOWN, null); 
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem431); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem433);
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
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension483); 


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
            	    pushFollow(FOLLOW_expr_in_arrayDimension508);
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
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType623); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:215:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType630); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:216:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType637); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:217:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType644); 
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
            match(input,BLOCK,FOLLOW_BLOCK_in_block657); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:219:17: ( stm )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IFNODE||(LA11_0>=PRINT && LA11_0<=ASSIGN)||LA11_0==SWITCH||LA11_0==FOR||LA11_0==WHILE||LA11_0==REPEAT||LA11_0==CALL) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:219:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block659);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:224:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? END_SWITCH ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( WHILE expr block END_LOOP ) | ^( REPEAT block UNTIL expr ) | ^( CALL ID paramsList ) );
    public final void stm() throws RecognitionException {
        CommonTree ID11=null;
        CommonTree ASSIGN13=null;
        CommonTree ID14=null;
        CommonTree ASSIGN16=null;
        CommonTree SWITCH19=null;
        CommonTree ID20=null;
        CommonTree ID21=null;
        CommonTree ID25=null;
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

        List<ActualParameter> paramsList26 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:224:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? END_SWITCH ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( WHILE expr block END_LOOP ) | ^( REPEAT block UNTIL expr ) | ^( CALL ID paramsList ) )
            int alt20=11;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:224:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm673); 

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
                        	    pushFollow(FOLLOW_expr_in_stm678);
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
                    match(input,READ,FOLLOW_READ_in_stm701); 

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
                    	    pushFollow(FOLLOW_readItem_in_stm703);
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
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm711); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm713); 
                    pushFollow(FOLLOW_expr_in_stm715);
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
                    ASSIGN16=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm747); 

                    match(input, Token.DOWN, null); 
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_stm749); 
                    pushFollow(FOLLOW_arraySubscript_in_stm751);
                    arraySubscript17=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm753);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:251:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? END_IF )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm819); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm821);
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
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm823);
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
                            pushFollow(FOLLOW_elseBlock_in_stm826);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,END_IF,FOLLOW_END_IF_in_stm829); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:252:17: ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? END_SWITCH )
                    {
                    SWITCH19=(CommonTree)match(input,SWITCH,FOLLOW_SWITCH_in_stm849); 

                    int numberOfCases = 0;

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm853);
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
                    	    pushFollow(FOLLOW_caseBlock_in_stm856);
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
                            pushFollow(FOLLOW_caseElseBlock_in_stm885);
                            caseElseBlock();

                            state._fsp--;

                            numberOfCases++;

                            }
                            break;

                    }

                    match(input,END_SWITCH,FOLLOW_END_SWITCH_in_stm890); 

                    match(input, Token.UP, null); 

                                                                    if(numberOfCases==0){
                                                                        Messages.caseStmMustHaveAtLeastOneCaseError(msgLog, new Point((SWITCH19!=null?SWITCH19.getLine():0), (SWITCH19!=null?SWITCH19.getCharPositionInLine():0)));
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:259:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block END_LOOP )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm956); 

                    match(input, Token.DOWN, null); 
                    ID20=(CommonTree)match(input,ID,FOLLOW_ID_in_stm958); 

                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID20!=null?ID20.getText():null), new Point((ID20!=null?ID20.getLine():0), (ID20!=null?ID20.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Variable)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm1001);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1023);
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
                            pushFollow(FOLLOW_expr_in_stm1046);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1068);
                    block();

                    state._fsp--;

                    match(input,END_LOOP,FOLLOW_END_LOOP_in_stm1070); 

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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:306:17: ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block END_LOOP )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm1136); 

                    match(input, Token.DOWN, null); 
                    ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_stm1138); 
                    pushFollow(FOLLOW_arraySubscript_in_stm1140);
                    arraySubscript22=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (ID21!=null?ID21.getText():null), new Point((ID21!=null?ID21.getLine():0), (ID21!=null?ID21.getCharPositionInLine():0)));
                                                                    if((s != null)&&(s instanceof Array)){
                                                                        s.setInitialized(true);
                                                                    }
                                                                
                    pushFollow(FOLLOW_expr_in_stm1168);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm1190);
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
                            pushFollow(FOLLOW_expr_in_stm1213);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm1235);
                    block();

                    state._fsp--;

                    match(input,END_LOOP,FOLLOW_END_LOOP_in_stm1237); 

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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:360:17: ^( WHILE expr block END_LOOP )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm1303); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm1305);
                    expr23=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm1307);
                    block();

                    state._fsp--;

                    match(input,END_LOOP,FOLLOW_END_LOOP_in_stm1309); 

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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:369:4: ^( REPEAT block UNTIL expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm1317); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm1319);
                    block();

                    state._fsp--;

                    match(input,UNTIL,FOLLOW_UNTIL_in_stm1321); 
                    pushFollow(FOLLOW_expr_in_stm1323);
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
                case 11 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:378:17: ^( CALL ID paramsList )
                    {
                    match(input,CALL,FOLLOW_CALL_in_stm1346); 

                    match(input, Token.DOWN, null); 
                    ID25=(CommonTree)match(input,ID,FOLLOW_ID_in_stm1348); 
                    pushFollow(FOLLOW_paramsList_in_stm1350);
                    paramsList26=paramsList();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    StaticTypeAnalyzerUtils.checkProcedureCall(msgLog, this.scopeTable, (ID25!=null?ID25.getText():null), (ID25!=null?ID25.getLine():0), (ID25!=null?ID25.getCharPositionInLine():0), paramsList26);
                                                                

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:383:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;
        StaticTypeAnalyzer.arraySubscript_return arraySubscript27 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:383:9: (arrId= ID arraySubscript | varId= ID )
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:383:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1383); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1385);
                    arraySubscript27=arraySubscript();

                    state._fsp--;


                                                                    Symbol s = currentScope.referenceSymbol(msgLog, (arrId!=null?arrId.getText():null), new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Array){
                                                                            Array arr = (Array)s;
                                                                            Type t = arr.getType();
                                                                            if( (t==null) || (t.equals(Type.BOOLEAN)) ){
                                                                                Messages.readItemMustBeIntRealOrStringError(msgLog, new Point((arrId!=null?arrId.getLine():0), (arrId!=null?arrId.getCharPositionInLine():0)), t);
                                                                            }else{
                                                                                int indicesCount = (arraySubscript27!=null?arraySubscript27.indicesCount:0);
                                                                                if(arr.getNumberOfDimensions() != indicesCount){
                                                                                    Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point((arraySubscript27!=null?((CommonTree)arraySubscript27.start):null).getLine(), (arraySubscript27!=null?((CommonTree)arraySubscript27.start):null).getCharPositionInLine()), arr, indicesCount);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:404:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1409); 

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:421:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr28 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:421:9: ( ^( IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:421:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1454); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1456);
            expr28=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1458);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr28!=null?expr28.expressionType:null)!=null){
                                                                if(!(expr28!=null?expr28.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr28!=null?((CommonTree)expr28.start):null).getLine(), (expr28!=null?((CommonTree)expr28.start):null).getCharPositionInLine()) , (expr28!=null?expr28.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr28!=null?((CommonTree)expr28.start):null).getLine(), (expr28!=null?((CommonTree)expr28.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:432:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:433:2: ( ^( ELSE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:433:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1491); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1493);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:436:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        StaticTypeAnalyzer.expr_return expr29 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:437:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:437:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1513); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1515);
            expr29=expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1517);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

                                                            if((expr29!=null?expr29.expressionType:null)!=null){
                                                                if(!(expr29!=null?expr29.expressionType:null).equals(Type.BOOLEAN)){
                                                                    Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr29!=null?((CommonTree)expr29.start):null).getLine(), (expr29!=null?((CommonTree)expr29.start):null).getCharPositionInLine()) , (expr29!=null?expr29.expressionType:null));
                                                                }
                                                            }else{
                                                                Messages.ifExpressionMustBeBooleanError(msgLog, new Point((expr29!=null?((CommonTree)expr29.start):null).getLine(), (expr29!=null?((CommonTree)expr29.start):null).getCharPositionInLine()) , null);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:449:1: caseBlock[Type exprType, Point exprPoint] : ^( CASE ( caseExprListItem )+ block ) ;
    public final StaticTypeAnalyzer.caseBlock_return caseBlock(Type exprType, Point exprPoint) throws RecognitionException {
        StaticTypeAnalyzer.caseBlock_return retval = new StaticTypeAnalyzer.caseBlock_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.caseExprListItem_return caseExprListItem30 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:450:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:450:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1548); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:450:11: ( caseExprListItem )+
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
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:450:12: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1551);
            	    caseExprListItem30=caseExprListItem();

            	    state._fsp--;

            	       if( !StaticTypeAnalyzerUtils.checkTypesForCaseStatement(exprType, (caseExprListItem30!=null?caseExprListItem30.expressionType:null)) ){
            	                                                            Messages.incompatibleTypesForCaseStmFoundError(msgLog, exprType, exprPoint, (caseExprListItem30!=null?caseExprListItem30.expressionType:null), new Point((caseExprListItem30!=null?((CommonTree)caseExprListItem30.start):null).getLine(), (caseExprListItem30!=null?((CommonTree)caseExprListItem30.start):null).getCharPositionInLine()), new Point(((CommonTree)retval.start).getLine(), ((CommonTree)retval.start).getCharPositionInLine()));
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

            pushFollow(FOLLOW_block_in_caseBlock1574);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:456:1: caseExprListItem returns [Type expressionType] : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final StaticTypeAnalyzer.caseExprListItem_return caseExprListItem() throws RecognitionException {
        StaticTypeAnalyzer.caseExprListItem_return retval = new StaticTypeAnalyzer.caseExprListItem_return();
        retval.start = input.LT(1);

        CommonTree RANGE31=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:457:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:457:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1590);
                    a=expr();

                    state._fsp--;


                                                                retval.expressionType = (a!=null?a.expressionType:null);
                                                            

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:460:10: ^( RANGE a= expr b= expr )
                    {
                    RANGE31=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1621); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1625);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1629);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                if(StaticTypeAnalyzerUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                    retval.expressionType = Type.REAL;
                                                                }else{
                                                                    Messages.incompatibleTypesFoundError(msgLog, (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((RANGE31!=null?RANGE31.getLine():0), (RANGE31!=null?RANGE31.getCharPositionInLine():0)), (RANGE31!=null?RANGE31.getText():null)
                                                                                                                              );
                                                                }
                                                            

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:470:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1645); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1647); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1651);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:481:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1674); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1676); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1680);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:492:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1703); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1705); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1709);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:503:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1732); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1734); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1738);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:516:1: caseElseBlock : ^( CASE_ELSE CASE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:517:2: ( ^( CASE_ELSE CASE block ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:517:4: ^( CASE_ELSE CASE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1761); 

            match(input, Token.DOWN, null); 
            match(input,CASE,FOLLOW_CASE_in_caseElseBlock1763); 
            pushFollow(FOLLOW_block_in_caseElseBlock1765);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:521:1: expr returns [Type expressionType, ExpressionResultForm resultForm] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) );
    public final StaticTypeAnalyzer.expr_return expr() throws RecognitionException {
        StaticTypeAnalyzer.expr_return retval = new StaticTypeAnalyzer.expr_return();
        retval.start = input.LT(1);

        CommonTree AND32=null;
        CommonTree OR33=null;
        CommonTree EQ34=null;
        CommonTree NEQ35=null;
        CommonTree LT36=null;
        CommonTree LE37=null;
        CommonTree GT38=null;
        CommonTree GE39=null;
        CommonTree PLUS40=null;
        CommonTree MINUS41=null;
        CommonTree TIMES42=null;
        CommonTree DIA43=null;
        CommonTree DIV44=null;
        CommonTree MOD45=null;
        CommonTree POW46=null;
        CommonTree ID47=null;
        CommonTree ID48=null;
        CommonTree ID50=null;
        StaticTypeAnalyzer.expr_return a = null;

        StaticTypeAnalyzer.expr_return b = null;

        StaticTypeAnalyzer.arraySubscript_return arraySubscript49 = null;

        List<ActualParameter> paramsList51 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:522:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) )
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:522:4: ^( AND a= expr b= expr )
                    {
                    AND32=(CommonTree)match(input,AND,FOLLOW_AND_in_expr1782); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1786);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1792);
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
                                                                                                                                new Point((AND32!=null?AND32.getLine():0), (AND32!=null?AND32.getCharPositionInLine():0)), (AND32!=null?AND32.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:537:4: ^( OR a= expr b= expr )
                    {
                    OR33=(CommonTree)match(input,OR,FOLLOW_OR_in_expr1803); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1807);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1813);
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
                                                                                                                                new Point((OR33!=null?OR33.getLine():0), (OR33!=null?OR33.getCharPositionInLine():0)), (OR33!=null?OR33.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:552:4: ^( EQ a= expr b= expr )
                    {
                    EQ34=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr1824); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1828);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1834);
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
                                                                                                                                new Point((EQ34!=null?EQ34.getLine():0), (EQ34!=null?EQ34.getCharPositionInLine():0)), (EQ34!=null?EQ34.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:567:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ35=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr1845); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1849);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1855);
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
                                                                                                                                new Point((NEQ35!=null?NEQ35.getLine():0), (NEQ35!=null?NEQ35.getCharPositionInLine():0)), (NEQ35!=null?NEQ35.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:582:4: ^( LT a= expr b= expr )
                    {
                    LT36=(CommonTree)match(input,LT,FOLLOW_LT_in_expr1866); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1870);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1876);
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
                                                                                                                                        new Point((LT36!=null?LT36.getLine():0), (LT36!=null?LT36.getCharPositionInLine():0)), (LT36!=null?LT36.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:597:4: ^( LE a= expr b= expr )
                    {
                    LE37=(CommonTree)match(input,LE,FOLLOW_LE_in_expr1887); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1891);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1897);
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
                                                                                                                                        new Point((LE37!=null?LE37.getLine():0), (LE37!=null?LE37.getCharPositionInLine():0)), (LE37!=null?LE37.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:612:4: ^( GT a= expr b= expr )
                    {
                    GT38=(CommonTree)match(input,GT,FOLLOW_GT_in_expr1908); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1912);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1918);
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
                                                                                                                                        new Point((GT38!=null?GT38.getLine():0), (GT38!=null?GT38.getCharPositionInLine():0)), (GT38!=null?GT38.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:627:4: ^( GE a= expr b= expr )
                    {
                    GE39=(CommonTree)match(input,GE,FOLLOW_GE_in_expr1929); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1933);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1939);
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
                                                                                                                                        new Point((GE39!=null?GE39.getLine():0), (GE39!=null?GE39.getCharPositionInLine():0)), (GE39!=null?GE39.getText():null)
                                                                                                                                      );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:642:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS40=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1950); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1954);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1960);
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
                                                                                                                                new Point((PLUS40!=null?PLUS40.getLine():0), (PLUS40!=null?PLUS40.getCharPositionInLine():0)), (PLUS40!=null?PLUS40.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:657:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS41=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1971); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1975);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1981);
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
                                                                                                                                new Point((MINUS41!=null?MINUS41.getLine():0), (MINUS41!=null?MINUS41.getCharPositionInLine():0)), (MINUS41!=null?MINUS41.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:672:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES42=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr1992); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1996);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2002);
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
                                                                                                                                new Point((TIMES42!=null?TIMES42.getLine():0), (TIMES42!=null?TIMES42.getCharPositionInLine():0)), (TIMES42!=null?TIMES42.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:687:4: ^( DIA a= expr b= expr )
                    {
                    DIA43=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr2013); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2017);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2023);
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
                                                                                                                                new Point((DIA43!=null?DIA43.getLine():0), (DIA43!=null?DIA43.getCharPositionInLine():0)), (DIA43!=null?DIA43.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:702:4: ^( DIV a= expr b= expr )
                    {
                    DIV44=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2034); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2038);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2044);
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
                                                                                                                                new Point((DIV44!=null?DIV44.getLine():0), (DIV44!=null?DIV44.getCharPositionInLine():0)), (DIV44!=null?DIV44.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:717:4: ^( MOD a= expr b= expr )
                    {
                    MOD45=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr2055); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2059);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2065);
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
                                                                                                                                    new Point((MOD45!=null?MOD45.getLine():0), (MOD45!=null?MOD45.getCharPositionInLine():0)), (MOD45!=null?MOD45.getText():null)
                                                                                                                                  );
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:732:4: ^( POW a= expr b= expr )
                    {
                    POW46=(CommonTree)match(input,POW,FOLLOW_POW_in_expr2076); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2080);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr2086);
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
                                                                                                                                new Point((POW46!=null?POW46.getLine():0), (POW46!=null?POW46.getCharPositionInLine():0)), (POW46!=null?POW46.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:751:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr2097); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2101);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:763:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr2122); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr2126);
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
                    // src/glossa/grammars/StaticTypeAnalyzer.g:775:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr2146); 
                    retval.expressionType = Type.BOOLEAN; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 19 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:776:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr2153); 
                    retval.expressionType = Type.BOOLEAN; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 20 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:777:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr2160); 
                    retval.expressionType = Type.STRING; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 21 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:778:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr2167); 
                    retval.expressionType = Type.INTEGER; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 22 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:779:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr2174); 
                    retval.expressionType = Type.REAL; retval.resultForm =ExpressionResultForm.VALUE;

                    }
                    break;
                case 23 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:780:4: ID
                    {
                    ID47=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2181); 

                                            retval.resultForm =ExpressionResultForm.VARIABLE;
                                            Symbol s = currentScope.referenceSymbol(msgLog, (ID47!=null?ID47.getText():null), new Point((ID47!=null?ID47.getLine():0), (ID47!=null?ID47.getCharPositionInLine():0)));
                                            if(s != null){
                                                if( (s instanceof Constant == false)  &&  (inConstantDeclaration || inVariableDeclaration) ){
                                                    Messages.variableReferencesInDeclarationsNotAllowedError(msgLog, s, new Point((ID47!=null?ID47.getLine():0), (ID47!=null?ID47.getCharPositionInLine():0)));
                                                }else{
                                                    if(s instanceof Array){
                                                        //Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point((ID47!=null?ID47.getLine():0), (ID47!=null?ID47.getCharPositionInLine():0)), s);
                                                        retval.resultForm =ExpressionResultForm.ARRAY;
                                                        retval.expressionType = s.getType();
                                                    }else{
                                                        retval.expressionType = s.getType();
                                                        if(!s.isInitialized()){
                                                            Messages.varOrConstNotInitializedButReferencedError(msgLog, new Point((ID47!=null?ID47.getLine():0), (ID47!=null?ID47.getCharPositionInLine():0)), s);
                                                        }
                                                    }
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:800:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr2190); 

                    match(input, Token.DOWN, null); 
                    ID48=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2192); 
                    pushFollow(FOLLOW_arraySubscript_in_expr2194);
                    arraySubscript49=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            retval.resultForm =ExpressionResultForm.ARRAY_ITEM;
                                                                            Symbol s = currentScope.referenceSymbol(msgLog, (ID48!=null?ID48.getText():null), new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        Messages.arrayReferencesInDeclarationsNotAllowedError(msgLog, s, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript49!=null?arraySubscript49.indicesCount:0);
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            Messages.arrayIndicesAndDimensionsMismatchError(msgLog, new Point((arraySubscript49!=null?((CommonTree)arraySubscript49.start):null).getLine(), (arraySubscript49!=null?((CommonTree)arraySubscript49.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point((ID48!=null?ID48.getLine():0), (ID48!=null?ID48.getCharPositionInLine():0)));
                                                                                }
                                                                            }
                                                                        

                    }
                    break;
                case 25 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:821:17: ^( FUNC_CALL ID paramsList )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_expr2219); 

                    match(input, Token.DOWN, null); 
                    ID50=(CommonTree)match(input,ID,FOLLOW_ID_in_expr2221); 
                    pushFollow(FOLLOW_paramsList_in_expr2223);
                    paramsList51=paramsList();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                                retval.resultForm =ExpressionResultForm.FUNCTION_CALL;
                                                                                if(BuiltinFunctions.isBuiltinFunctionName((ID50!=null?ID50.getText():null))){
                                                                                    if(paramsList51.size()==1){
                                                                                        Type paramType = paramsList51.get(0).getType();
                                                                                        if(StaticTypeAnalyzerUtils.isNumericType(paramType)){
                                                                                            retval.expressionType = BuiltinFunctions.getReturnTypeForBuiltinFuntion((ID50!=null?ID50.getText():null), paramType);
                                                                                        }else{
                                                                                            Messages.callToBuiltinFunctionWithWrongParamTypeError(msgLog, new Point((ID50!=null?ID50.getLine():0), (ID50!=null?ID50.getCharPositionInLine():0)), (ID50!=null?ID50.getText():null), paramType);
                                                                                        }
                                                                                    }else{
                                                                                        Messages.callToBuiltinFunctionWithWrongNumOfParamsError(msgLog, new Point((ID50!=null?ID50.getLine():0), (ID50!=null?ID50.getCharPositionInLine():0)), (ID50!=null?ID50.getText():null), paramsList51.size());
                                                                                    }
                                                                                }else{
                                                                                    retval.expressionType = StaticTypeAnalyzerUtils.checkFunctionCall(msgLog, this.scopeTable, (ID50!=null?ID50.getText():null), (ID50!=null?ID50.getLine():0), (ID50!=null?ID50.getCharPositionInLine():0), paramsList51);
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:840:1: paramsList returns [List<ActualParameter> params] : ^( PARAMS ( expr )* ) ;
    public final List<ActualParameter> paramsList() throws RecognitionException {
        List<ActualParameter> params = null;

        StaticTypeAnalyzer.expr_return expr52 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:841:2: ( ^( PARAMS ( expr )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:841:4: ^( PARAMS ( expr )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_paramsList2258); 

            List<ActualParameter> result = new ArrayList<ActualParameter>();

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:842:19: ( expr )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NEG||LA25_0==ARRAY_ITEM||LA25_0==FUNC_CALL||LA25_0==ID||LA25_0==EQ||(LA25_0>=LT && LA25_0<=GE)||(LA25_0>=OR && LA25_0<=CONST_REAL)) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:842:20: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_paramsList2284);
                	    expr52=expr();

                	    state._fsp--;

                	    result.add(new ActualParameter((expr52!=null?((CommonTree)expr52.start):null).getLine(), (expr52!=null?((CommonTree)expr52.start):null).getCharPositionInLine(), (expr52!=null?expr52.expressionType:null), (expr52!=null?expr52.resultForm:null)));

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
    // src/glossa/grammars/StaticTypeAnalyzer.g:847:1: arraySubscript returns [int indicesCount] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final StaticTypeAnalyzer.arraySubscript_return arraySubscript() throws RecognitionException {
        StaticTypeAnalyzer.arraySubscript_return retval = new StaticTypeAnalyzer.arraySubscript_return();
        retval.start = input.LT(1);

        StaticTypeAnalyzer.expr_return expr53 = null;


        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:848:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:848:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript2365); 


                                                    int count = 0;
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/StaticTypeAnalyzer.g:851:19: ( expr )+
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
            	    // src/glossa/grammars/StaticTypeAnalyzer.g:851:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript2394);
            	    expr53=expr();

            	    state._fsp--;


            	                                            Type type = (expr53!=null?expr53.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    Messages.arrayIndexNotIntegerError(msgLog, new Point((expr53!=null?((CommonTree)expr53.start):null).getLine(), (expr53!=null?((CommonTree)expr53.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                Messages.arrayIndexNotIntegerError(msgLog, new Point((expr53!=null?((CommonTree)expr53.start):null).getLine(), (expr53!=null?((CommonTree)expr53.start):null).getCharPositionInLine()));
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


    // $ANTLR start "procedure"
    // src/glossa/grammars/StaticTypeAnalyzer.g:866:1: procedure : ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block END_PROCEDURE ) ;
    public final void procedure() throws RecognitionException {
        CommonTree ID54=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:867:2: ( ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block END_PROCEDURE ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:867:4: ^( PROCEDURE ID formalParamsList ( constDecl )? ( varDecl )? block END_PROCEDURE )
            {
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure2496); 


                                                    inSubprogram = true;
                                                

            match(input, Token.DOWN, null); 
            ID54=(CommonTree)match(input,ID,FOLLOW_ID_in_procedure2526); 
            pushFollow(FOLLOW_formalParamsList_in_procedure2528);
            formalParamsList();

            state._fsp--;


                                                    ProcedureScope ps = scopeTable.getProcedureScope((ID54!=null?ID54.getText():null));
                                                    currentScope = ps;
                                                
            // src/glossa/grammars/StaticTypeAnalyzer.g:875:19: ( constDecl )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==CONSTANTS) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:875:19: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_procedure2586);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/StaticTypeAnalyzer.g:876:19: ( varDecl )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==VARIABLES) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:876:19: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_procedure2607);
                    varDecl();

                    state._fsp--;


                    }
                    break;

            }


                                                    List<FormalParameter> formalParams = ps.getFormalParameters();
                                                    HashMap<String, Symbol> symbols = ps.getSymbols();
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
                                                
            pushFollow(FOLLOW_block_in_procedure2639);
            block();

            state._fsp--;

            match(input,END_PROCEDURE,FOLLOW_END_PROCEDURE_in_procedure2641); 

            match(input, Token.UP, null); 

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
    // $ANTLR end "procedure"


    // $ANTLR start "function"
    // src/glossa/grammars/StaticTypeAnalyzer.g:901:1: function : ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block END_FUNCTION ) ;
    public final void function() throws RecognitionException {
        CommonTree ID55=null;

        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:902:2: ( ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block END_FUNCTION ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:902:4: ^( FUNCTION ID returnType formalParamsList ( constDecl )? ( varDecl )? block END_FUNCTION )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function2699); 


                                                    inSubprogram = true;
                                                

            match(input, Token.DOWN, null); 
            ID55=(CommonTree)match(input,ID,FOLLOW_ID_in_function2730); 
            pushFollow(FOLLOW_returnType_in_function2732);
            returnType();

            state._fsp--;

            pushFollow(FOLLOW_formalParamsList_in_function2734);
            formalParamsList();

            state._fsp--;


                                                    FunctionScope fs = scopeTable.getFunctionScope((ID55!=null?ID55.getText():null));
                                                    currentScope = fs;
                                                
            // src/glossa/grammars/StaticTypeAnalyzer.g:910:19: ( constDecl )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==CONSTANTS) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:910:19: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_function2792);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/StaticTypeAnalyzer.g:911:19: ( varDecl )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==VARIABLES) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // src/glossa/grammars/StaticTypeAnalyzer.g:911:19: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_function2813);
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
                                                
            pushFollow(FOLLOW_block_in_function2845);
            block();

            state._fsp--;

            match(input,END_FUNCTION,FOLLOW_END_FUNCTION_in_function2847); 

            match(input, Token.UP, null); 

                                                    if(!fs.isReturnValueSet()){
                                                        Messages.functionReturnValueNotSetError(msgLog, new Point((ID55!=null?ID55.getLine():0), (ID55!=null?ID55.getCharPositionInLine():0)), fs.getSubprogramName(), fs.getFormalParameters());
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:939:1: returnType : ( INTEGER | REAL | STRING | BOOLEAN );
    public final void returnType() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:940:2: ( INTEGER | REAL | STRING | BOOLEAN )
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
    // src/glossa/grammars/StaticTypeAnalyzer.g:949:1: formalParamsList : ^( FORMAL_PARAMS ( ID )* ) ;
    public final void formalParamsList() throws RecognitionException {
        try {
            // src/glossa/grammars/StaticTypeAnalyzer.g:950:2: ( ^( FORMAL_PARAMS ( ID )* ) )
            // src/glossa/grammars/StaticTypeAnalyzer.g:950:4: ^( FORMAL_PARAMS ( ID )* )
            {
            match(input,FORMAL_PARAMS,FOLLOW_FORMAL_PARAMS_in_formalParamsList2940); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/StaticTypeAnalyzer.g:950:20: ( ID )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==ID) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // src/glossa/grammars/StaticTypeAnalyzer.g:950:21: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_formalParamsList2943); 

                	    }
                	    break;

                	default :
                	    break loop31;
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
        "\22\uffff";
    static final String DFA20_eofS =
        "\22\uffff";
    static final String DFA20_minS =
        "\1\7\2\uffff\1\2\2\uffff\1\2\3\uffff\2\23\2\5\4\uffff";
    static final String DFA20_maxS =
        "\1\72\2\uffff\1\2\2\uffff\1\2\3\uffff\2\23\2\114\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\uffff\1\11\1\12\1\13\4\uffff"+
        "\1\4\1\3\1\7\1\10";
    static final String DFA20_specialS =
        "\22\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\4\31\uffff\1\1\1\2\1\3\5\uffff\1\5\7\uffff\1\6\4\uffff\1"+
            "\7\1\uffff\1\10\1\uffff\1\11",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\13",
            "",
            "",
            "",
            "\1\14",
            "\1\15",
            "\1\17\3\uffff\1\17\1\16\4\uffff\1\17\3\uffff\1\17\3\uffff\1"+
            "\17\25\uffff\4\17\14\uffff\20\17",
            "\1\20\3\uffff\1\20\1\21\4\uffff\1\20\3\uffff\1\20\3\uffff\1"+
            "\20\25\uffff\4\20\14\uffff\20\20",
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
            return "224:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? END_IF ) | ^( SWITCH expr ( caseBlock[$expr.expressionType, new Point($expr.start.getLine(), $expr.start.getCharPositionInLine())] )* ( caseElseBlock )? END_SWITCH ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block END_LOOP ) | ^( WHILE expr block END_LOOP ) | ^( REPEAT block UNTIL expr ) | ^( CALL ID paramsList ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_function_in_unit53 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_procedure_in_unit55 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_PROGRAM_in_program67 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program73 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_declarations_in_program84 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_program88 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_END_PROGRAM_in_program90 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ID_in_program97 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations135 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_varDecl_in_declarations138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl157 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_EQ_in_constAssign213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign215 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_constAssign217 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl254 = new BitSet(new long[]{0x00000001E0000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl332 = new BitSet(new long[]{0x0000000000080108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem431 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension508 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block657 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block659 = new BitSet(new long[]{0x0542020E00000088L});
    public static final BitSet FOLLOW_PRINT_in_stm673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm678 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_READ_in_stm701 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm703 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm713 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm715 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm749 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm751 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm753 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm821 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm823 = new BitSet(new long[]{0x0000019000000000L});
    public static final BitSet FOLLOW_elseBlock_in_stm826 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_END_IF_in_stm829 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm853 = new BitSet(new long[]{0x00000C0000002000L});
    public static final BitSet FOLLOW_caseBlock_in_stm856 = new BitSet(new long[]{0x00000C0000002000L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm885 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_END_SWITCH_in_stm890 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm956 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm958 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1001 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1023 = new BitSet(new long[]{0xE001E00001C88230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1046 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1068 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_stm1070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm1136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm1138 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm1140 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1168 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1190 = new BitSet(new long[]{0xE001E00001C88230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1213 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1235 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_stm1237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm1303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm1305 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm1307 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_END_LOOP_in_stm1309 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm1317 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm1319 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_stm1321 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm1323 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_stm1346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm1348 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_stm1350 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1383 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1456 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_ifBlock1458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1491 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1493 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1515 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1517 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1551 = new BitSet(new long[]{0xE001F00001C89230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_block_in_caseBlock1574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1625 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1647 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1676 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1705 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1734 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1738 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1761 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_in_caseElseBlock1763 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1786 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1803 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1807 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1813 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1828 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1834 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1849 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1866 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1870 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1876 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1891 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1897 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1912 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1918 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1933 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1954 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1960 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1975 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1996 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr2002 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr2013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2017 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr2023 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2038 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr2044 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr2055 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2059 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr2065 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr2076 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2080 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr2086 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr2097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr2122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr2190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2192 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr2194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_expr2219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr2221 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_expr2223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_paramsList2258 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_paramsList2284 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript2365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript2394 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure2496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_procedure2526 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParamsList_in_procedure2528 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_constDecl_in_procedure2586 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_varDecl_in_procedure2607 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_procedure2639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_END_PROCEDURE_in_procedure2641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_function2699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function2730 = new BitSet(new long[]{0x0000000000000000L,0x00000000001E0000L});
    public static final BitSet FOLLOW_returnType_in_function2732 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParamsList_in_function2734 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_constDecl_in_function2792 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_varDecl_in_function2813 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_function2845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_END_FUNCTION_in_function2847 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_returnType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAL_PARAMS_in_formalParamsList2940 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_formalParamsList2943 = new BitSet(new long[]{0x0000000000080008L});

}