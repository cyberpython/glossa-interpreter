// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/interpreter/grammars/GlossaFirstPassWalker.g 2010-10-18 22:29:19


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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:102:1: unit : program ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:102:6: ( program )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:102:8: program
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:104:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:104:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:104:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
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

            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:113:3: (id2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:113:4: id2= ID
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:121:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:4: ( constDecl )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CONSTANTS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations105);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:15: ( varDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLES) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:122:15: varDecl
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:124:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        CommonTree CONSTANTS1=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:125:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:125:4: ^( CONSTANTS ( constAssign )* )
            {
            CONSTANTS1=(CommonTree)match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl121); 


                                                    inConstantDeclaration=true;
            					if(currentScope.isConstantsDeclared()){
            						ReportingAndMessagingUtils.constantsRedeclarationError(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)), currentScope.getConstantsDeclarationPoint());
            					}else{
            						currentScope.setConstantsDeclared(true);
            						currentScope.setConstantsDeclarationPoint(new Point((CONSTANTS1!=null?CONSTANTS1.getLine():0), (CONSTANTS1!=null?CONSTANTS1.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:134:3: ( constAssign )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==EQ) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:134:3: constAssign
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:140:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID2=null;
        GlossaFirstPassWalker.expr_return expr3 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:141:2: ( ^( EQ ID expr ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:141:5: ^( EQ ID expr )
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:151:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        CommonTree VARIABLES4=null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:151:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:151:11: ^( VARIABLES ( varsDecl )* )
            {
            VARIABLES4=(CommonTree)match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl218); 


                                                    inVariableDeclaration=true;
            					if(currentScope.isVariablesDeclared()){
            						ReportingAndMessagingUtils.variablesRedeclarationError(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)), currentScope.getVariablesDeclarationPoint());
            					}else{
            						currentScope.setVariablesDeclared(true);
            						currentScope.setVariablesDeclarationPoint(new Point((VARIABLES4!=null?VARIABLES4.getLine():0), (VARIABLES4!=null?VARIABLES4.getCharPositionInLine():0)));
            					}
            				

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:160:3: ( varsDecl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=BOOLEANS && LA5_0<=REALS)) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:160:3: varsDecl
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:167:1: varsDecl : ^( varType ( varDeclItem )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Symbol varDeclItem5 = null;

        Type varType6 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:168:2: ( ^( varType ( varDeclItem )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:168:4: ^( varType ( varDeclItem )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl279);
            varType6=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:170:21: ( varDeclItem )+
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:170:22: varDeclItem
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:178:1: varDeclItem returns [Symbol variable] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final Symbol varDeclItem() throws RecognitionException {
        Symbol variable = null;

        CommonTree ID7=null;
        CommonTree ID8=null;
        List<Integer> arrayDimension9 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:179:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:179:4: ID
                    {
                    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem362); 

                                                                    variable = new Variable((ID7!=null?ID7.getText():null), (ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0), ID7.getTokenStartIndex(), null);
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:182:5: ^( ARRAY ID arrayDimension )
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:189:1: arrayDimension returns [List<Integer> dimensions] : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final List<Integer> arrayDimension() throws RecognitionException {
        List<Integer> dimensions = null;

        GlossaFirstPassWalker.expr_return expr10 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:190:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:190:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension450); 


                                                    dimensions = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:194:21: ( expr )+
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:194:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension475);
            	    expr10=expr();

            	    state._fsp--;


            	                                            Type type = (expr10!=null?expr10.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    ReportingAndMessagingUtils.arrayDimensionDeclarationsNotIntegerError(new Point((expr10!=null?((CommonTree)expr10.start):null).getLine(), (expr10!=null?((CommonTree)expr10.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                ReportingAndMessagingUtils.arrayDimensionDeclarationsNotIntegerError(new Point((expr10!=null?((CommonTree)expr10.start):null).getLine(), (expr10!=null?((CommonTree)expr10.start):null).getCharPositionInLine()));
            	                                            }
            	                                            dimensions.add(new Integer(1));
            	                                        

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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:210:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:211:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:211:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType552); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:212:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType559); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:213:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType566); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:214:4: REALS
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:216:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:216:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:216:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block586); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:216:17: ( stm )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=PRINT && LA10_0<=ASSIGN)) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:216:17: stm
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:221:1: stm : ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) );
    public final void stm() throws RecognitionException {
        CommonTree ID11=null;
        CommonTree ASSIGN13=null;
        GlossaFirstPassWalker.expr_return expr12 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:221:5: ( ^( PRINT ( expr )+ ) | ^( ASSIGN ID expr ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==PRINT) ) {
                alt12=1;
            }
            else if ( (LA12_0==ASSIGN) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:221:7: ^( PRINT ( expr )+ )
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_stm602); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:221:15: ( expr )+
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
                    	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:221:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_stm604);
                    	    expr();

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
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:222:4: ^( ASSIGN ID expr )
                    {
                    ASSIGN13=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_stm612); 

                    match(input, Token.DOWN, null); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stm614); 
                    pushFollow(FOLLOW_expr_in_stm616);
                    expr12=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    Symbol s = currentScope.referenceSymbol((ID11!=null?ID11.getText():null), new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)));
                                                                    if(s != null){
                                                                        if(s instanceof Variable){
                                                                            if((expr12!=null?expr12.expressionType:null)!=null){
                                                                                if(TypeUtils.areTypesCompatibleForAssignment(s.getType(), (expr12!=null?expr12.expressionType:null))<0){
                                                                                    ReportingAndMessagingUtils.incompatibleTypesFoundError(s.getType(), new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)), (expr12!=null?expr12.expressionType:null), new Point((expr12!=null?((CommonTree)expr12.start):null).getLine(), (expr12!=null?((CommonTree)expr12.start):null).getCharPositionInLine()) ,new Point((ASSIGN13!=null?ASSIGN13.getLine():0), (ASSIGN13!=null?ASSIGN13.getCharPositionInLine():0)), (ASSIGN13!=null?ASSIGN13.getText():null));
                                                                                }
                                                                            }
                                                                        }else{
                                                                            ReportingAndMessagingUtils.leftSideOfAssignmentMustBeVarOrArrayError(new Point((ID11!=null?ID11.getLine():0), (ID11!=null?ID11.getCharPositionInLine():0)));
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
    // $ANTLR end "stm"

    public static class expr_return extends TreeRuleReturnScope {
        public Type expressionType;
    };

    // $ANTLR start "expr"
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:242:1: expr returns [Type expressionType] : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) );
    public final GlossaFirstPassWalker.expr_return expr() throws RecognitionException {
        GlossaFirstPassWalker.expr_return retval = new GlossaFirstPassWalker.expr_return();
        retval.start = input.LT(1);

        CommonTree AND14=null;
        CommonTree OR15=null;
        CommonTree EQ16=null;
        CommonTree NEQ17=null;
        CommonTree LT18=null;
        CommonTree LE19=null;
        CommonTree GT20=null;
        CommonTree GE21=null;
        CommonTree PLUS22=null;
        CommonTree MINUS23=null;
        CommonTree TIMES24=null;
        CommonTree DIA25=null;
        CommonTree DIV26=null;
        CommonTree MOD27=null;
        CommonTree POW28=null;
        CommonTree ID29=null;
        CommonTree ID30=null;
        GlossaFirstPassWalker.expr_return a = null;

        GlossaFirstPassWalker.expr_return b = null;

        GlossaFirstPassWalker.arraySubscript_return arraySubscript31 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:243:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) )
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
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:243:4: ^( AND a= expr b= expr )
                    {
                    AND14=(CommonTree)match(input,AND,FOLLOW_AND_in_expr664); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr668);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr674);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((AND14!=null?AND14.getLine():0), (AND14!=null?AND14.getCharPositionInLine():0)), (AND14!=null?AND14.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:253:4: ^( OR a= expr b= expr )
                    {
                    OR15=(CommonTree)match(input,OR,FOLLOW_OR_in_expr685); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr689);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr695);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForBooleanExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((OR15!=null?OR15.getLine():0), (OR15!=null?OR15.getCharPositionInLine():0)), (OR15!=null?OR15.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:263:4: ^( EQ a= expr b= expr )
                    {
                    EQ16=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr706); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr710);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr716);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((EQ16!=null?EQ16.getLine():0), (EQ16!=null?EQ16.getCharPositionInLine():0)), (EQ16!=null?EQ16.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 4 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:273:4: ^( NEQ a= expr b= expr )
                    {
                    NEQ17=(CommonTree)match(input,NEQ,FOLLOW_NEQ_in_expr727); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr731);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr737);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((NEQ17!=null?NEQ17.getLine():0), (NEQ17!=null?NEQ17.getCharPositionInLine():0)), (NEQ17!=null?NEQ17.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 5 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:283:4: ^( LT a= expr b= expr )
                    {
                    LT18=(CommonTree)match(input,LT,FOLLOW_LT_in_expr748); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr752);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr758);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LT18!=null?LT18.getLine():0), (LT18!=null?LT18.getCharPositionInLine():0)), (LT18!=null?LT18.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 6 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:293:4: ^( LE a= expr b= expr )
                    {
                    LE19=(CommonTree)match(input,LE,FOLLOW_LE_in_expr769); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr773);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr779);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((LE19!=null?LE19.getLine():0), (LE19!=null?LE19.getCharPositionInLine():0)), (LE19!=null?LE19.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 7 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:303:4: ^( GT a= expr b= expr )
                    {
                    GT20=(CommonTree)match(input,GT,FOLLOW_GT_in_expr790); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr794);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr800);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GT20!=null?GT20.getLine():0), (GT20!=null?GT20.getCharPositionInLine():0)), (GT20!=null?GT20.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 8 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:313:4: ^( GE a= expr b= expr )
                    {
                    GE21=(CommonTree)match(input,GE,FOLLOW_GE_in_expr811); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr815);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr821);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForComparisonExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((GE21!=null?GE21.getLine():0), (GE21!=null?GE21.getCharPositionInLine():0)), (GE21!=null?GE21.getText():null)
                                                                                                                              );
                                                                    }
                                                                

                    }
                    break;
                case 9 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:323:4: ^( PLUS a= expr b= expr )
                    {
                    PLUS22=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr832); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr836);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr842);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((PLUS22!=null?PLUS22.getLine():0), (PLUS22!=null?PLUS22.getCharPositionInLine():0)), (PLUS22!=null?PLUS22.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                    }
                                                                

                    }
                    break;
                case 10 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:333:4: ^( MINUS a= expr b= expr )
                    {
                    MINUS23=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr853); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr857);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr863);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MINUS23!=null?MINUS23.getLine():0), (MINUS23!=null?MINUS23.getCharPositionInLine():0)), (MINUS23!=null?MINUS23.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                    }
                                                                

                    }
                    break;
                case 11 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:343:4: ^( TIMES a= expr b= expr )
                    {
                    TIMES24=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr874); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr878);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr884);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((TIMES24!=null?TIMES24.getLine():0), (TIMES24!=null?TIMES24.getCharPositionInLine():0)), (TIMES24!=null?TIMES24.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                    }
                                                                

                    }
                    break;
                case 12 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:353:4: ^( DIA a= expr b= expr )
                    {
                    DIA25=(CommonTree)match(input,DIA,FOLLOW_DIA_in_expr895); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr899);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr905);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIA25!=null?DIA25.getLine():0), (DIA25!=null?DIA25.getCharPositionInLine():0)), (DIA25!=null?DIA25.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                                                                                //TODO which types are valid?
                                                                    }
                                                                

                    }
                    break;
                case 13 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:364:4: ^( DIV a= expr b= expr )
                    {
                    DIV26=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr916); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr920);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr926);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((DIV26!=null?DIV26.getLine():0), (DIV26!=null?DIV26.getCharPositionInLine():0)), (DIV26!=null?DIV26.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                                                                                //TODO which types are valid?
                                                                    }
                                                                

                    }
                    break;
                case 14 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:375:4: ^( MOD a= expr b= expr )
                    {
                    MOD27=(CommonTree)match(input,MOD,FOLLOW_MOD_in_expr937); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr941);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr947);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((MOD27!=null?MOD27.getLine():0), (MOD27!=null?MOD27.getCharPositionInLine():0)), (MOD27!=null?MOD27.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                                                                                //TODO which types are valid?
                                                                    }
                                                                

                    }
                    break;
                case 15 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:386:4: ^( POW a= expr b= expr )
                    {
                    POW28=(CommonTree)match(input,POW,FOLLOW_POW_in_expr958); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr962);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr968);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.checkTypesForArithmeticExpression((a!=null?a.expressionType:null), (b!=null?b.expressionType:null))){
                                                                        retval.expressionType = TypeUtils.getWiderType((a!=null?a.expressionType:null), (b!=null?b.expressionType:null));
                                                                    }else{
                                                                        ReportingAndMessagingUtils.incompatibleTypesFoundError( (a!=null?a.expressionType:null), new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()),
                                                                                                                                (b!=null?b.expressionType:null), new Point((b!=null?((CommonTree)b.start):null).getLine(), (b!=null?((CommonTree)b.start):null).getCharPositionInLine()),
                                                                                                                                new Point((POW28!=null?POW28.getLine():0), (POW28!=null?POW28.getCharPositionInLine():0)), (POW28!=null?POW28.getText():null)
                                                                                                                              );//TODO change this to print incompatible types for operation x
                                                                    }
                                                                

                    }
                    break;
                case 16 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:396:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr979); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr983);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(TypeUtils.isNumericType((a!=null?a.expressionType:null))){
                                                                        retval.expressionType = (a!=null?a.expressionType:null);
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.INTEGER, Type.REAL};
                                                                        ReportingAndMessagingUtils.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 17 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:405:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1004); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1008);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if((a!=null?a.expressionType:null).equals(Type.BOOLEAN)){
                                                                        retval.expressionType = Type.BOOLEAN;
                                                                    }else{
                                                                        Type[] requiredTypes = {Type.BOOLEAN};
                                                                        ReportingAndMessagingUtils.incompatibleTypeFoundError( (a!=null?a.expressionType:null), requiredTypes,
                                                                                                                               new Point((a!=null?((CommonTree)a.start):null).getLine(), (a!=null?((CommonTree)a.start):null).getCharPositionInLine()));
                                                                    }
                                                                

                    }
                    break;
                case 18 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:414:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1028); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 19 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:415:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1035); 
                    retval.expressionType = Type.BOOLEAN;

                    }
                    break;
                case 20 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:416:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1042); 
                    retval.expressionType = Type.STRING;

                    }
                    break;
                case 21 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:417:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1049); 
                    retval.expressionType = Type.INTEGER;

                    }
                    break;
                case 22 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:418:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1056); 
                    retval.expressionType = Type.REAL;

                    }
                    break;
                case 23 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:419:4: ID
                    {
                    ID29=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1063); 

                                            Symbol s = currentScope.referenceSymbol((ID29!=null?ID29.getText():null), new Point((ID29!=null?ID29.getLine():0), (ID29!=null?ID29.getCharPositionInLine():0)));
                                            if(s != null){
                                                if(s instanceof Variable && (inConstantDeclaration || inVariableDeclaration) ){
                                                    ReportingAndMessagingUtils.variableReferencesInDeclarationsNotAllowedError(s, new Point((ID29!=null?ID29.getLine():0), (ID29!=null?ID29.getCharPositionInLine():0)));
                                                }else{
                                                    retval.expressionType = s.getType();
                                                }
                                            }
                                        

                    }
                    break;
                case 24 :
                    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:429:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1072); 

                    match(input, Token.DOWN, null); 
                    ID30=(CommonTree)match(input,ID,FOLLOW_ID_in_expr1074); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1076);
                    arraySubscript31=arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                            Symbol s = currentScope.referenceSymbol((ID30!=null?ID30.getText():null), new Point((ID30!=null?ID30.getLine():0), (ID30!=null?ID30.getCharPositionInLine():0)));
                                                                            if(s != null){
                                                                                if(s instanceof Array){
                                                                                    if(inConstantDeclaration || inVariableDeclaration){
                                                                                        ReportingAndMessagingUtils.arrayReferencesInDeclarationsNotAllowedError(s, new Point((ID30!=null?ID30.getLine():0), (ID30!=null?ID30.getCharPositionInLine():0)));
                                                                                    }
                                                                                    else{
                                                                                        retval.expressionType = s.getType();
                                                                                        Array arr = (Array)s;
                                                                                        int indicesCount = (arraySubscript31!=null?arraySubscript31.indices:null).size();
                                                                                        if(arr.getNumberOfDimensions() != indicesCount){
                                                                                            ReportingAndMessagingUtils.arrayIndicesAndDimensionsMismatchError(new Point((arraySubscript31!=null?((CommonTree)arraySubscript31.start):null).getLine(), (arraySubscript31!=null?((CommonTree)arraySubscript31.start):null).getCharPositionInLine()), arr, indicesCount);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    ReportingAndMessagingUtils.nonArraySymbolReferencedAsSuch(s, new Point((ID30!=null?ID30.getLine():0), (ID30!=null?ID30.getCharPositionInLine():0)));
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
    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:451:1: arraySubscript returns [List<Integer> indices] : ^( ARRAY_INDEX ( expr )+ ) ;
    public final GlossaFirstPassWalker.arraySubscript_return arraySubscript() throws RecognitionException {
        GlossaFirstPassWalker.arraySubscript_return retval = new GlossaFirstPassWalker.arraySubscript_return();
        retval.start = input.LT(1);

        GlossaFirstPassWalker.expr_return expr32 = null;


        try {
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:452:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:452:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript1107); 


                                                    retval.indices = new ArrayList<Integer>();
                                                

            match(input, Token.DOWN, null); 
            // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:455:19: ( expr )+
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
            	    // src/glossa/interpreter/grammars/GlossaFirstPassWalker.g:455:20: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript1136);
            	    expr32=expr();

            	    state._fsp--;


            	                                            Type type = (expr32!=null?expr32.expressionType:null);
            	                                            if(type!=null){
            	                                                if(!type.equals(Type.INTEGER)){
            	                                                    ReportingAndMessagingUtils.arrayIndexNotIntegerError(new Point((expr32!=null?((CommonTree)expr32.start):null).getLine(), (expr32!=null?((CommonTree)expr32.start):null).getCharPositionInLine()));
            	                                                }
            	                                            }else{
            	                                                ReportingAndMessagingUtils.arrayIndexNotIntegerError(new Point((expr32!=null?((CommonTree)expr32.start):null).getLine(), (expr32!=null?((CommonTree)expr32.start):null).getCharPositionInLine()));
            	                                            }
            	                                            retval.indices.add(new Integer(1));
            	                                        

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
        return retval;
    }
    // $ANTLR end "arraySubscript"

    // Delegated rules


 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program65 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_declarations_in_program71 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_block_in_program75 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_ID_in_program83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations105 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_varDecl_in_declarations108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl127 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_EQ_in_constAssign183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign185 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_constAssign187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl224 = new BitSet(new long[]{0x0000000007800008L});
    public static final BitSet FOLLOW_varType_in_varsDecl279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl302 = new BitSet(new long[]{0x0000000000001088L});
    public static final BitSet FOLLOW_ID_in_varDeclItem362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem398 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension475 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_BOOLEANS_in_varType552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block588 = new BitSet(new long[]{0x0000000018000008L});
    public static final BitSet FOLLOW_PRINT_in_stm602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm604 = new BitSet(new long[]{0x0001FFFFE0021128L});
    public static final BitSet FOLLOW_ASSIGN_in_stm612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm614 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_stm616 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr668 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr689 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr710 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr727 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr731 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr752 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr773 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr794 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr815 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr821 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr832 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr836 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr842 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr857 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr878 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr899 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr905 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr916 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr920 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr926 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr941 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr962 = new BitSet(new long[]{0x0001FFFFE0021120L});
    public static final BitSet FOLLOW_expr_in_expr968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr983 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1008 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1072 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1074 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1076 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript1107 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1136 = new BitSet(new long[]{0x0001FFFFE0021128L});

}