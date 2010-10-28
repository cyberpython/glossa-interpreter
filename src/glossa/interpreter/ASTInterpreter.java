// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/ASTInterpreter.g 2010-10-28 13:50:24


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

import glossa.statictypeanalysis.scopetable.*;
import glossa.interpreter.symboltable.*;
import glossa.interpreter.symboltable.symbols.*;
import java.awt.Point;
import java.io.PrintStream;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.ArrayList;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ASTInterpreter extends TreeParser {
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


        public ASTInterpreter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ASTInterpreter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ASTInterpreter.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/grammars/ASTInterpreter.g"; }


            private ScopeTable scopeTable;
            private Deque<SymbolTable> stack;

            private SymbolTable currentSymbolTable;

            private PrintStream out;
            private PrintStream err;

            public void setScopeTable(ScopeTable s){
                this.scopeTable = s;
            }

            public ScopeTable getScopeTable(){
                return this.scopeTable;
            }

            public void setStack(Deque<SymbolTable> stack){
                this.stack = stack;
            }

            public Deque<SymbolTable> getStack(){
                return this.stack;
            }

            public void setOutputStream(PrintStream out){
                this.out = out;
            }

            public PrintStream getOutputStream(){
                return this.out;
            }

            public void setErrorStream(PrintStream err){
                this.err = err;
            }

            public PrintStream getErrorStream(){
                return this.err;
            }




    // $ANTLR start "unit"
    // src/glossa/grammars/ASTInterpreter.g:125:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:125:6: ( program )
            // src/glossa/grammars/ASTInterpreter.g:125:8: program
            {
            pushFollow(FOLLOW_program_in_unit51);
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
    // src/glossa/grammars/ASTInterpreter.g:127:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/grammars/ASTInterpreter.g:127:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/grammars/ASTInterpreter.g:127:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program62); 


                                                    SymbolTable mainProgramSymbolTable = new SymbolTable(this.scopeTable.getMainProgramScope());
                                                    this.stack.push(mainProgramSymbolTable);
                                                    this.currentSymbolTable = mainProgramSymbolTable;
                                                

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program96); 
            pushFollow(FOLLOW_declarations_in_program118);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program140);
            block();

            state._fsp--;

            // src/glossa/grammars/ASTInterpreter.g:135:21: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:135:22: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program165); 

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
    // src/glossa/grammars/ASTInterpreter.g:140:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:141:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/grammars/ASTInterpreter.g:141:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/grammars/ASTInterpreter.g:141:4: ( constDecl )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CONSTANTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:141:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations224);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/ASTInterpreter.g:141:15: ( varDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLES) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:141:15: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declarations227);
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
    // src/glossa/grammars/ASTInterpreter.g:144:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:145:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/grammars/ASTInterpreter.g:145:4: ^( CONSTANTS ( constAssign )* )
            {
            match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl247); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/ASTInterpreter.g:145:16: ( constAssign )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==EQ) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/grammars/ASTInterpreter.g:145:16: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl249);
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
    // src/glossa/grammars/ASTInterpreter.g:148:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID1=null;
        Object expr2 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:149:2: ( ^( EQ ID expr ) )
            // src/glossa/grammars/ASTInterpreter.g:149:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign272); 

            match(input, Token.DOWN, null); 
            ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign274); 
            pushFollow(FOLLOW_expr_in_constAssign276);
            expr2=expr();

            state._fsp--;


            match(input, Token.UP, null); 

                                                    RuntimeConstant constant = (RuntimeConstant)this.currentSymbolTable.referenceSymbol((ID1!=null?ID1.getText():null), new Point((ID1!=null?ID1.getLine():0), (ID1!=null?ID1.getCharPositionInLine():0)));
                                                    constant.setValue(expr2);
                                             

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
    // src/glossa/grammars/ASTInterpreter.g:159:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:159:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/grammars/ASTInterpreter.g:159:11: ^( VARIABLES ( varsDecl )* )
            {
            match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl302); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/ASTInterpreter.g:159:23: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/grammars/ASTInterpreter.g:159:23: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl304);
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
    // src/glossa/grammars/ASTInterpreter.g:164:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:165:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/grammars/ASTInterpreter.g:165:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl328);
            varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/grammars/ASTInterpreter.g:165:14: ( varDeclItem )+
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
            	    // src/glossa/grammars/ASTInterpreter.g:165:14: varDeclItem
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl330);
            	    varDeclItem();

            	    state._fsp--;


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
    // src/glossa/grammars/ASTInterpreter.g:168:1: varDeclItem : ( ID | ^( ARRAY ID arrayDimension ) );
    public final void varDeclItem() throws RecognitionException {
        CommonTree ID3=null;
        List<Integer> arrayDimension4 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:169:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/grammars/ASTInterpreter.g:169:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_varDeclItem351); 

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/ASTInterpreter.g:170:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem358); 

                    match(input, Token.DOWN, null); 
                    ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem360); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem362);
                    arrayDimension4=arrayDimension();

                    state._fsp--;


                                                        RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol((ID3!=null?ID3.getText():null), new Point((ID3!=null?ID3.getLine():0), (ID3!=null?ID3.getCharPositionInLine():0)));
                                                        arr.setDimensions(arrayDimension4);
                                                    

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
    // src/glossa/grammars/ASTInterpreter.g:180:1: arrayDimension returns [List<Integer> value] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final List<Integer> arrayDimension() throws RecognitionException {
        List<Integer> value = null;

        Object expr5 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:181:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/ASTInterpreter.g:181:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension442); 

            List<Integer> result = new ArrayList<Integer>();

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/ASTInterpreter.g:183:21: ( expr )+
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
            	    // src/glossa/grammars/ASTInterpreter.g:183:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension499);
            	    expr5=expr();

            	    state._fsp--;


            	                                        if(InterpreterUtils.isValidArrayDimension(expr5)){
            	                                            result.add(new Integer(  ((BigInteger)expr5).intValue()   ));
            	                                        }else{
            	                                            throw new RuntimeException("Array dimensions must be of integer type and in the range (0,"+Integer.MAX_VALUE+")"); //TODO: proper runtime error message
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

            value = result;

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "arrayDimension"


    // $ANTLR start "varType"
    // src/glossa/grammars/ASTInterpreter.g:198:1: varType : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final void varType() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:199:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
            // src/glossa/grammars/ASTInterpreter.g:
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
    // src/glossa/grammars/ASTInterpreter.g:205:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:205:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/grammars/ASTInterpreter.g:205:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block668); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/ASTInterpreter.g:205:17: ( stm )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IFNODE||(LA9_0>=PRINT && LA9_0<=ASSIGN)||LA9_0==SWITCH||LA9_0==FOR||LA9_0==WHILE||LA9_0==REPEAT) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // src/glossa/grammars/ASTInterpreter.g:205:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block670);
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
    // src/glossa/grammars/ASTInterpreter.g:211:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );
    public final void stm() throws RecognitionException {
        CommonTree ID6=null;
        CommonTree ID8=null;
        Object expr1 = null;

        Object expr2 = null;

        Object expr3 = null;

        Object expr7 = null;

        List<Integer> arraySubscript9 = null;

        Object expr10 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:211:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) )
            int alt17=9;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:211:7: ^( PRINT (expr1= expr )* )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm695); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/grammars/ASTInterpreter.g:212:21: (expr1= expr )*
                        loop10:
                        do {
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0==NEG||LA10_0==ARRAY_ITEM||LA10_0==ID||LA10_0==EQ||(LA10_0>=LT && LA10_0<=GE)||(LA10_0>=OR && LA10_0<=CONST_REAL)) ) {
                                alt10=1;
                            }


                            switch (alt10) {
                        	case 1 :
                        	    // src/glossa/grammars/ASTInterpreter.g:212:22: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm720);
                        	    expr1=expr();

                        	    state._fsp--;


                        	                                            Object o = expr1;
                        	                                            InterpreterUtils.print(o, this.out);
                        	                                        

                        	    }
                        	    break;

                        	default :
                        	    break loop10;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                                                            this.out.println();
                                                        

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/ASTInterpreter.g:219:17: ^( READ ( readItem )+ )
                    {
                    match(input,READ,FOLLOW_READ_in_stm783); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/grammars/ASTInterpreter.g:219:24: ( readItem )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/glossa/grammars/ASTInterpreter.g:219:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm785);
                    	    readItem();

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
                case 3 :
                    // src/glossa/grammars/ASTInterpreter.g:220:4: ^( ASSIGN ID expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm793); 

                    match(input, Token.DOWN, null); 
                    ID6=(CommonTree)match(input,ID,FOLLOW_ID_in_stm795); 
                    pushFollow(FOLLOW_expr_in_stm797);
                    expr7=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                            RuntimeVariable var = (RuntimeVariable)this.currentSymbolTable.referenceSymbol((ID6!=null?ID6.getText():null), new Point((ID6!=null?ID6.getLine():0), (ID6!=null?ID6.getCharPositionInLine():0)));
                                                            var.setValue(expr7);
                                                        

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/ASTInterpreter.g:224:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm821); 

                    match(input, Token.DOWN, null); 
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_stm823); 
                    pushFollow(FOLLOW_arraySubscript_in_stm825);
                    arraySubscript9=arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm827);
                    expr10=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                            RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol((ID8!=null?ID8.getText():null), new Point((ID8!=null?ID8.getLine():0), (ID8!=null?ID8.getCharPositionInLine():0)));
                                                            arr.set(arraySubscript9, expr10);
                                                        

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/ASTInterpreter.g:229:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm885); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm887);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/grammars/ASTInterpreter.g:229:34: ( elseIfBlock )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==ELSE_IF) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/glossa/grammars/ASTInterpreter.g:229:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm889);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // src/glossa/grammars/ASTInterpreter.g:229:47: ( elseBlock )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ELSE) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // src/glossa/grammars/ASTInterpreter.g:229:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm892);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/ASTInterpreter.g:230:17: ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? )
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_stm913); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm915);
                    expr();

                    state._fsp--;

                    // src/glossa/grammars/ASTInterpreter.g:230:31: ( caseBlock )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==CASE) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/glossa/grammars/ASTInterpreter.g:230:31: caseBlock
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm917);
                    	    caseBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // src/glossa/grammars/ASTInterpreter.g:230:42: ( caseElseBlock )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==CASE_ELSE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // src/glossa/grammars/ASTInterpreter.g:230:42: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm920);
                            caseElseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/ASTInterpreter.g:231:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm941); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm943); 
                    pushFollow(FOLLOW_expr_in_stm947);
                    expr1=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm951);
                    expr2=expr();

                    state._fsp--;

                    // src/glossa/grammars/ASTInterpreter.g:231:48: (expr3= expr )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==NEG||LA16_0==ARRAY_ITEM||LA16_0==ID||LA16_0==EQ||(LA16_0>=LT && LA16_0<=GE)||(LA16_0>=OR && LA16_0<=CONST_REAL)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/glossa/grammars/ASTInterpreter.g:231:49: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm956);
                            expr3=expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm960);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/ASTInterpreter.g:232:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm980); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm982);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm984);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/ASTInterpreter.g:233:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm991); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm993);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm995);
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


    // $ANTLR start "readItem"
    // src/glossa/grammars/ASTInterpreter.g:236:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;

        try {
            // src/glossa/grammars/ASTInterpreter.g:236:9: (arrId= ID arraySubscript | varId= ID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==UP||LA18_1==ID) ) {
                    alt18=2;
                }
                else if ( (LA18_1==ARRAY_INDEX) ) {
                    alt18=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:236:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1020); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem1022);
                    arraySubscript();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/ASTInterpreter.g:237:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem1042); 

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
    // src/glossa/grammars/ASTInterpreter.g:240:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:240:9: ( ^( IF expr block ) )
            // src/glossa/grammars/ASTInterpreter.g:240:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1066); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1068);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1070);
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
    // $ANTLR end "ifBlock"


    // $ANTLR start "elseBlock"
    // src/glossa/grammars/ASTInterpreter.g:243:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:244:2: ( ^( ELSE block ) )
            // src/glossa/grammars/ASTInterpreter.g:244:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1090); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1092);
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
    // src/glossa/grammars/ASTInterpreter.g:247:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:248:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/grammars/ASTInterpreter.g:248:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1112); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1114);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1116);
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
    // $ANTLR end "elseIfBlock"


    // $ANTLR start "caseBlock"
    // src/glossa/grammars/ASTInterpreter.g:252:1: caseBlock : ^( CASE ( caseExprListItem )+ block ) ;
    public final void caseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:253:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/grammars/ASTInterpreter.g:253:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1137); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/ASTInterpreter.g:253:11: ( caseExprListItem )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==NEG||LA19_0==ARRAY_ITEM||LA19_0==INF_RANGE||LA19_0==ID||LA19_0==EQ||(LA19_0>=RANGE && LA19_0<=GE)||(LA19_0>=OR && LA19_0<=CONST_REAL)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/glossa/grammars/ASTInterpreter.g:253:11: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1139);
            	    caseExprListItem();

            	    state._fsp--;


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

            pushFollow(FOLLOW_block_in_caseBlock1142);
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
    // src/glossa/grammars/ASTInterpreter.g:256:1: caseExprListItem : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final void caseExprListItem() throws RecognitionException {
        Object a = null;

        Object b = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:257:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
            int alt20=6;
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
                alt20=1;
                }
                break;
            case RANGE:
                {
                alt20=2;
                }
                break;
            case INF_RANGE:
                {
                int LA20_3 = input.LA(2);

                if ( (LA20_3==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case LT:
                        {
                        alt20=3;
                        }
                        break;
                    case LE:
                        {
                        alt20=4;
                        }
                        break;
                    case GT:
                        {
                        alt20=5;
                        }
                        break;
                    case GE:
                        {
                        alt20=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:257:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1163);
                    a=expr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/ASTInterpreter.g:258:10: ^( RANGE a= expr b= expr )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1175); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1179);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1183);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/ASTInterpreter.g:259:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1196); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1198); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1202);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/ASTInterpreter.g:260:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1222); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1224); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1228);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/ASTInterpreter.g:261:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1248); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1250); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1254);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/ASTInterpreter.g:262:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1274); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1276); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1280);
                    a=expr();

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
    // src/glossa/grammars/ASTInterpreter.g:265:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/ASTInterpreter.g:266:2: ( ^( CASE_ELSE block ) )
            // src/glossa/grammars/ASTInterpreter.g:266:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1300); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1302);
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


    // $ANTLR start "expr"
    // src/glossa/grammars/ASTInterpreter.g:271:1: expr returns [Object result] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
    public final Object expr() throws RecognitionException {
        Object result = null;

        CommonTree CONST_STR11=null;
        CommonTree CONST_INT12=null;
        CommonTree CONST_REAL13=null;
        CommonTree ID14=null;
        CommonTree ID15=null;
        Object a = null;

        Object b = null;

        List<Integer> arraySubscript16 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:272:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
            int alt21=24;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt21=1;
                }
                break;
            case OR:
                {
                alt21=2;
                }
                break;
            case EQ:
                {
                alt21=3;
                }
                break;
            case NEQ:
                {
                alt21=4;
                }
                break;
            case LT:
                {
                alt21=5;
                }
                break;
            case LE:
                {
                alt21=6;
                }
                break;
            case GT:
                {
                alt21=7;
                }
                break;
            case GE:
                {
                alt21=8;
                }
                break;
            case PLUS:
                {
                alt21=9;
                }
                break;
            case MINUS:
                {
                alt21=10;
                }
                break;
            case TIMES:
                {
                alt21=11;
                }
                break;
            case DIA:
                {
                alt21=12;
                }
                break;
            case DIV:
                {
                alt21=13;
                }
                break;
            case MOD:
                {
                alt21=14;
                }
                break;
            case POW:
                {
                alt21=15;
                }
                break;
            case NEG:
                {
                alt21=16;
                }
                break;
            case NOT:
                {
                alt21=17;
                }
                break;
            case CONST_TRUE:
                {
                alt21=18;
                }
                break;
            case CONST_FALSE:
                {
                alt21=19;
                }
                break;
            case CONST_STR:
                {
                alt21=20;
                }
                break;
            case CONST_INT:
                {
                alt21=21;
                }
                break;
            case CONST_REAL:
                {
                alt21=22;
                }
                break;
            case ID:
                {
                alt21=23;
                }
                break;
            case ARRAY_ITEM:
                {
                alt21=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // src/glossa/grammars/ASTInterpreter.g:272:4: ^( AND a= expr b= expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr1328); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1332);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1338);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.and(a, b);   

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/ASTInterpreter.g:273:4: ^( OR a= expr b= expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr1349); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1353);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1359);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.or(a, b);    

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/ASTInterpreter.g:274:4: ^( EQ a= expr b= expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr1370); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1374);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1380);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.equals(a, b);    

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/ASTInterpreter.g:275:4: ^( NEQ a= expr b= expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr1391); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1395);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1401);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.notEquals(a, b); 

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/ASTInterpreter.g:276:4: ^( LT a= expr b= expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr1412); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1416);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1422);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.lowerThan(a, b); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/ASTInterpreter.g:277:4: ^( LE a= expr b= expr )
                    {
                    match(input,LE,FOLLOW_LE_in_expr1433); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1437);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1443);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.lowerThanOrEqual(a, b);  

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/ASTInterpreter.g:278:4: ^( GT a= expr b= expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr1454); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1458);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1464);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.greaterThan(a, b);   

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/ASTInterpreter.g:279:4: ^( GE a= expr b= expr )
                    {
                    match(input,GE,FOLLOW_GE_in_expr1475); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1479);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1485);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.greaterThanOrEqual(a, b);    

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/ASTInterpreter.g:280:4: ^( PLUS a= expr b= expr )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expr1496); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1500);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1506);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.add(a, b);   

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/ASTInterpreter.g:281:4: ^( MINUS a= expr b= expr )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expr1517); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1521);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1527);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.subtract(a, b);  

                    }
                    break;
                case 11 :
                    // src/glossa/grammars/ASTInterpreter.g:282:4: ^( TIMES a= expr b= expr )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expr1538); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1542);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1548);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.multiply(a, b);  

                    }
                    break;
                case 12 :
                    // src/glossa/grammars/ASTInterpreter.g:283:11: ^( DIA a= expr b= expr )
                    {
                    match(input,DIA,FOLLOW_DIA_in_expr1566); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1570);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1576);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.divide(a, b);    

                    }
                    break;
                case 13 :
                    // src/glossa/grammars/ASTInterpreter.g:284:11: ^( DIV a= expr b= expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr1594); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1598);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1604);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.intDivide(a, b); 

                    }
                    break;
                case 14 :
                    // src/glossa/grammars/ASTInterpreter.g:285:4: ^( MOD a= expr b= expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr1615); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1619);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1625);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.intMod(a, b);    

                    }
                    break;
                case 15 :
                    // src/glossa/grammars/ASTInterpreter.g:286:4: ^( POW a= expr b= expr )
                    {
                    match(input,POW,FOLLOW_POW_in_expr1636); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1640);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1646);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.pow(a, b);   

                    }
                    break;
                case 16 :
                    // src/glossa/grammars/ASTInterpreter.g:287:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1657); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1661);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.negate(a);   

                    }
                    break;
                case 17 :
                    // src/glossa/grammars/ASTInterpreter.g:288:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1682); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1686);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       result = InterpreterUtils.not(a);  

                    }
                    break;
                case 18 :
                    // src/glossa/grammars/ASTInterpreter.g:289:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1706); 
                       result = Boolean.valueOf(true);    

                    }
                    break;
                case 19 :
                    // src/glossa/grammars/ASTInterpreter.g:290:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1730); 
                       result = Boolean.valueOf(false);   

                    }
                    break;
                case 20 :
                    // src/glossa/grammars/ASTInterpreter.g:291:4: CONST_STR
                    {
                    CONST_STR11=(CommonTree)match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1753); 
                       result = new String((CONST_STR11!=null?CONST_STR11.getText():null));  

                    }
                    break;
                case 21 :
                    // src/glossa/grammars/ASTInterpreter.g:292:4: CONST_INT
                    {
                    CONST_INT12=(CommonTree)match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1778); 
                       result = new BigInteger((CONST_INT12!=null?CONST_INT12.getText():null));  

                    }
                    break;
                case 22 :
                    // src/glossa/grammars/ASTInterpreter.g:293:4: CONST_REAL
                    {
                    CONST_REAL13=(CommonTree)match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1803); 
                       result = new BigDecimal((CONST_REAL13!=null?CONST_REAL13.getText():null), InterpreterUtils.getMathContext()); 

                    }
                    break;
                case 23 :
                    // src/glossa/grammars/ASTInterpreter.g:294:4: ID
                    {
                    ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1827); 

                                                                    RuntimeSimpleSymbol s = (RuntimeSimpleSymbol)this.currentSymbolTable.referenceSymbol((ID14!=null?ID14.getText():null), new Point((ID14!=null?ID14.getLine():0), (ID14!=null?ID14.getCharPositionInLine():0)));
                                                                    result = s.getValue();
                                                                

                    }
                    break;
                case 24 :
                    // src/glossa/grammars/ASTInterpreter.g:298:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1881); 

                    match(input, Token.DOWN, null); 
                    ID15=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1903); 

                                                                    RuntimeArray arr = (RuntimeArray)this.currentSymbolTable.referenceSymbol((ID15!=null?ID15.getText():null), new Point((ID15!=null?ID15.getLine():0), (ID15!=null?ID15.getCharPositionInLine():0)));
                                                                    List<Integer> dimensions = arr.getDimensions();
                                                                
                    pushFollow(FOLLOW_arraySubscript_in_expr1948);
                    arraySubscript16=arraySubscript();

                    state._fsp--;


                                                                    List<Integer> indices = arraySubscript16;
                                                                    if(indices.size()!=dimensions.size()){
                                                                        throw new RuntimeException("Array dimensions and item index mismatch"); //TODO: proper runtime error message
                                                                    }else{
                                                                        for(int i=0; i<dimensions.size(); i++){
                                                                            if(indices.get(i).compareTo(dimensions.get(i))>0){
                                                                                throw new RuntimeException("Array index out of bounds"); //TODO: proper runtime error message
                                                                            }
                                                                        }
                                                                    }

                                                                    result = arr.get(indices);
                                                                

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
        return result;
    }
    // $ANTLR end "expr"


    // $ANTLR start "arraySubscript"
    // src/glossa/grammars/ASTInterpreter.g:322:1: arraySubscript returns [List<Integer> value] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final List<Integer> arraySubscript() throws RecognitionException {
        List<Integer> value = null;

        Object expr17 = null;


        try {
            // src/glossa/grammars/ASTInterpreter.g:323:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/ASTInterpreter.g:323:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript2035); 

            List<Integer> result = new ArrayList<Integer>();

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/ASTInterpreter.g:325:21: ( expr )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==NEG||LA22_0==ARRAY_ITEM||LA22_0==ID||LA22_0==EQ||(LA22_0>=LT && LA22_0<=GE)||(LA22_0>=OR && LA22_0<=CONST_REAL)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/glossa/grammars/ASTInterpreter.g:325:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript2092);
            	    expr17=expr();

            	    state._fsp--;


            	                                        if(InterpreterUtils.isValidArrayDimension(expr17)){
            	                                            result.add(new Integer(  ((BigInteger)expr17).intValue()   ));
            	                                        }else{
            	                                            throw new RuntimeException("Array index out of bounds"); //TODO: proper runtime error message
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


                                                value = result;
                                            

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "arraySubscript"

    // Delegated rules


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\15\uffff";
    static final String DFA17_eofS =
        "\15\uffff";
    static final String DFA17_minS =
        "\1\7\2\uffff\1\2\5\uffff\1\17\1\5\2\uffff";
    static final String DFA17_maxS =
        "\1\65\2\uffff\1\2\5\uffff\1\17\1\106\2\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\4\1\3";
    static final String DFA17_specialS =
        "\15\uffff}>";
    static final String[] DFA17_transitionS = {
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

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "211:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program62 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program96 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_declarations_in_program118 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_program140 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_ID_in_program165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations224 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_varDecl_in_declarations227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl249 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_EQ_in_constAssign272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign274 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_constAssign276 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl304 = new BitSet(new long[]{0x000000003C000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl330 = new BitSet(new long[]{0x0000000000008108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem360 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension499 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});
    public static final BitSet FOLLOW_set_in_varType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block670 = new BitSet(new long[]{0x00284041C0000088L});
    public static final BitSet FOLLOW_PRINT_in_stm695 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm720 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});
    public static final BitSet FOLLOW_READ_in_stm783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm785 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm793 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm795 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm823 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm825 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm827 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm885 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm887 = new BitSet(new long[]{0x0000003000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm889 = new BitSet(new long[]{0x0000003000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm915 = new BitSet(new long[]{0x0000010000002008L});
    public static final BitSet FOLLOW_caseBlock_in_stm917 = new BitSet(new long[]{0x0000010000002008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm920 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm941 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm943 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm947 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm951 = new BitSet(new long[]{0xFF803C0000388230L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm956 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_stm960 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm980 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm982 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_stm984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm991 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm993 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_stm995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem1020 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1068 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_ifBlock1070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1090 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1092 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1112 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1114 = new BitSet(new long[]{0x0000000000280010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1116 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1139 = new BitSet(new long[]{0xFF803E0000389230L,0x000000000000007FL});
    public static final BitSet FOLLOW_block_in_caseBlock1142 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1179 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1183 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1198 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1224 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1250 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1276 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1280 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1332 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1353 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1359 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1374 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1380 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1395 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1401 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1416 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1433 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1437 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1458 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1464 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1475 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1479 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1485 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1500 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1521 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1542 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1570 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1598 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1619 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1640 = new BitSet(new long[]{0xFF803C0000108220L,0x000000000000007FL});
    public static final BitSet FOLLOW_expr_in_expr1646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1657 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1661 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1903 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1948 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript2035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript2092 = new BitSet(new long[]{0xFF803C0000108228L,0x000000000000007FL});

}