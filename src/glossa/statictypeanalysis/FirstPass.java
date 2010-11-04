// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/glossa/grammars/FirstPass.g 2010-11-04 21:42:12


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
import java.util.Iterator;
import java.awt.Point;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FirstPass extends TreeParser {
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


        public FirstPass(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public FirstPass(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return FirstPass.tokenNames; }
    public String getGrammarFileName() { return "src/glossa/grammars/FirstPass.g"; }


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



    // $ANTLR start "unit"
    // src/glossa/grammars/FirstPass.g:103:1: unit : program ( function | procedure )* ;
    public final void unit() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:103:6: ( program ( function | procedure )* )
            // src/glossa/grammars/FirstPass.g:103:8: program ( function | procedure )*
            {
            pushFollow(FOLLOW_program_in_unit50);
            program();

            state._fsp--;

            // src/glossa/grammars/FirstPass.g:103:16: ( function | procedure )*
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
            	    // src/glossa/grammars/FirstPass.g:103:17: function
            	    {
            	    pushFollow(FOLLOW_function_in_unit53);
            	    function();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // src/glossa/grammars/FirstPass.g:103:26: procedure
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
    // src/glossa/grammars/FirstPass.g:105:1: program : ^( PROGRAM id1= ID declarations block (id2= ID )? ) ;
    public final void program() throws RecognitionException {
        CommonTree id1=null;
        CommonTree id2=null;

        try {
            // src/glossa/grammars/FirstPass.g:105:9: ( ^( PROGRAM id1= ID declarations block (id2= ID )? ) )
            // src/glossa/grammars/FirstPass.g:105:11: ^( PROGRAM id1= ID declarations block (id2= ID )? )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program66); 

            match(input, Token.DOWN, null); 
            id1=(CommonTree)match(input,ID,FOLLOW_ID_in_program72); 

                                            MainProgramScope mainProgramScope = new MainProgramScope();
            				mainProgramScope.setProgramName((id1!=null?id1.getText():null));
                                            scopeTable.setMainProgramScope(mainProgramScope);
                                            currentScope = scopeTable.getMainProgramScope();
            			
            pushFollow(FOLLOW_declarations_in_program78);
            declarations();

            state._fsp--;

            pushFollow(FOLLOW_block_in_program82);
            block();

            state._fsp--;

            // src/glossa/grammars/FirstPass.g:114:3: (id2= ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:114:4: id2= ID
                    {
                    id2=(CommonTree)match(input,ID,FOLLOW_ID_in_program89); 

                    				if((id1!=null?id1.getText():null).toLowerCase().equals((id2!=null?id2.getText():null).toLowerCase())==false){
                    					Messages.programNameMismatchWarning(msgLog, new Point((id2!=null?id2.getLine():0), (id2!=null?id2.getCharPositionInLine():0)), (id2!=null?id2.getText():null));
                    				}
                    			

                    }
                    break;

            }

            currentScope = null;

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
    // src/glossa/grammars/FirstPass.g:123:1: declarations : ( constDecl )? ( varDecl )? ;
    public final void declarations() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:124:2: ( ( constDecl )? ( varDecl )? )
            // src/glossa/grammars/FirstPass.g:124:4: ( constDecl )? ( varDecl )?
            {
            // src/glossa/grammars/FirstPass.g:124:4: ( constDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==CONSTANTS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:124:4: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_declarations135);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/FirstPass.g:124:15: ( varDecl )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==VARIABLES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:124:15: varDecl
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
    // src/glossa/grammars/FirstPass.g:126:1: constDecl : ^( CONSTANTS ( constAssign )* ) ;
    public final void constDecl() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:127:2: ( ^( CONSTANTS ( constAssign )* ) )
            // src/glossa/grammars/FirstPass.g:127:4: ^( CONSTANTS ( constAssign )* )
            {
            match(input,CONSTANTS,FOLLOW_CONSTANTS_in_constDecl149); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/FirstPass.g:128:3: ( constAssign )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==EQ) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/glossa/grammars/FirstPass.g:128:3: constAssign
                	    {
                	    pushFollow(FOLLOW_constAssign_in_constDecl153);
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
    // src/glossa/grammars/FirstPass.g:131:1: constAssign : ^( EQ ID expr ) ;
    public final void constAssign() throws RecognitionException {
        CommonTree ID1=null;

        try {
            // src/glossa/grammars/FirstPass.g:132:2: ( ^( EQ ID expr ) )
            // src/glossa/grammars/FirstPass.g:132:5: ^( EQ ID expr )
            {
            match(input,EQ,FOLLOW_EQ_in_constAssign175); 

            match(input, Token.DOWN, null); 
            ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_constAssign177); 
            pushFollow(FOLLOW_expr_in_constAssign179);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 

                                                if(inSubprogram && currentScope!=null){
                                                    SubProgramScope sc = (SubProgramScope) currentScope;
                                                     if((sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals((ID1!=null?ID1.getText():null).toLowerCase())){
                                                        Messages.constantDeclaredWithSameNameAsFunctionError(msgLog, new Point((ID1!=null?ID1.getLine():0), (ID1!=null?ID1.getCharPositionInLine():0)), (ID1!=null?ID1.getText():null));
                                                    }
                                                    if(sc.getFormalParameters().contains(new FormalParameter((ID1!=null?ID1.getLine():0), (ID1!=null?ID1.getCharPositionInLine():0), (ID1!=null?ID1.getText():null)))){
                                                        Messages.parameterWithTheSameNameExistsError(msgLog, new Point((ID1!=null?ID1.getLine():0), (ID1!=null?ID1.getCharPositionInLine():0)), (ID1!=null?ID1.getText():null));
                                                    }
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
    // $ANTLR end "constAssign"


    // $ANTLR start "varDecl"
    // src/glossa/grammars/FirstPass.g:149:1: varDecl : ^( VARIABLES ( varsDecl )* ) ;
    public final void varDecl() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:149:9: ( ^( VARIABLES ( varsDecl )* ) )
            // src/glossa/grammars/FirstPass.g:149:11: ^( VARIABLES ( varsDecl )* )
            {
            match(input,VARIABLES,FOLLOW_VARIABLES_in_varDecl205); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/FirstPass.g:150:3: ( varsDecl )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=BOOLEANS && LA6_0<=REALS)) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // src/glossa/grammars/FirstPass.g:150:3: varsDecl
                	    {
                	    pushFollow(FOLLOW_varsDecl_in_varDecl209);
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
    // src/glossa/grammars/FirstPass.g:155:1: varsDecl : ^( varType ( varDeclItem[$varType.result] )+ ) ;
    public final void varsDecl() throws RecognitionException {
        Type varType2 = null;


        try {
            // src/glossa/grammars/FirstPass.g:156:2: ( ^( varType ( varDeclItem[$varType.result] )+ ) )
            // src/glossa/grammars/FirstPass.g:156:4: ^( varType ( varDeclItem[$varType.result] )+ )
            {
            pushFollow(FOLLOW_varType_in_varsDecl253);
            varType2=varType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            // src/glossa/grammars/FirstPass.g:158:21: ( varDeclItem[$varType.result] )+
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
            	    // src/glossa/grammars/FirstPass.g:158:23: varDeclItem[$varType.result]
            	    {
            	    pushFollow(FOLLOW_varDeclItem_in_varsDecl277);
            	    varDeclItem(varType2);

            	    state._fsp--;


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
    // src/glossa/grammars/FirstPass.g:161:1: varDeclItem[Type t] : ( ID | ^( ARRAY ID arrayDimension ) );
    public final void varDeclItem(Type t) throws RecognitionException {
        CommonTree ID3=null;
        CommonTree ID4=null;

        try {
            // src/glossa/grammars/FirstPass.g:162:2: ( ID | ^( ARRAY ID arrayDimension ) )
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
                    // src/glossa/grammars/FirstPass.g:162:4: ID
                    {
                    ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem311); 

                                                                    if(inSubprogram && currentScope!=null){
                                                                        SubProgramScope sc = (SubProgramScope) currentScope;
                                                                        if( (sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals((ID3!=null?ID3.getText():null).toLowerCase())){
                                                                            Messages.variableDeclaredWithSameNameAsFunctionError(msgLog, new Point((ID3!=null?ID3.getLine():0), (ID3!=null?ID3.getCharPositionInLine():0)), (ID3!=null?ID3.getText():null));
                                                                        }else{
                                                                            FormalParameter fp = new FormalParameter((ID3!=null?ID3.getLine():0), (ID3!=null?ID3.getCharPositionInLine():0), (ID3!=null?ID3.getText():null));
                                                                            List<FormalParameter> paramsList = sc.getFormalParameters();
                                                                            if(paramsList.contains(fp)){
                                                                                paramsList.get(paramsList.indexOf(fp)).setType(t);
                                                                            }
                                                                        }
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:176:5: ^( ARRAY ID arrayDimension )
                    {
                    match(input,ARRAY,FOLLOW_ARRAY_in_varDeclItem345); 

                    match(input, Token.DOWN, null); 
                    ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_varDeclItem347); 
                    pushFollow(FOLLOW_arrayDimension_in_varDeclItem349);
                    arrayDimension();

                    state._fsp--;


                    match(input, Token.UP, null); 

                                                                    if(inSubprogram && currentScope!=null){
                                                                        SubProgramScope sc = (SubProgramScope) currentScope;
                                                                        if( (sc instanceof FunctionScope) &&  sc.getSubprogramName().toLowerCase().equals((ID4!=null?ID4.getText():null).toLowerCase())){
                                                                            Messages.variableDeclaredWithSameNameAsFunctionError(msgLog, new Point((ID4!=null?ID4.getLine():0), (ID4!=null?ID4.getCharPositionInLine():0)), (ID4!=null?ID4.getText():null));
                                                                        }else{
                                                                            FormalParameter fp = new FormalParameter((ID4!=null?ID4.getLine():0), (ID4!=null?ID4.getCharPositionInLine():0), (ID4!=null?ID4.getText():null));
                                                                            List<FormalParameter> paramsList = sc.getFormalParameters();
                                                                            if(paramsList.contains(fp)){
                                                                                FormalParameter tmp = paramsList.get(paramsList.indexOf(fp));
                                                                                tmp.setType(t);
                                                                                tmp.setArrayParamFlagSet(true);
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
    // $ANTLR end "varDeclItem"


    // $ANTLR start "arrayDimension"
    // src/glossa/grammars/FirstPass.g:196:1: arrayDimension : ^( ARRAY_DIMENSION ( expr )+ ) ;
    public final void arrayDimension() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:197:2: ( ^( ARRAY_DIMENSION ( expr )+ ) )
            // src/glossa/grammars/FirstPass.g:197:4: ^( ARRAY_DIMENSION ( expr )+ )
            {
            match(input,ARRAY_DIMENSION,FOLLOW_ARRAY_DIMENSION_in_arrayDimension395); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/FirstPass.g:199:21: ( expr )+
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
            	    // src/glossa/grammars/FirstPass.g:199:22: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arrayDimension418);
            	    expr();

            	    state._fsp--;


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
    // $ANTLR end "arrayDimension"


    // $ANTLR start "varType"
    // src/glossa/grammars/FirstPass.g:204:1: varType returns [Type result] : ( BOOLEANS | STRINGS | INTEGERS | REALS );
    public final Type varType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/grammars/FirstPass.g:205:9: ( BOOLEANS | STRINGS | INTEGERS | REALS )
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
                    // src/glossa/grammars/FirstPass.g:205:11: BOOLEANS
                    {
                    match(input,BOOLEANS,FOLLOW_BOOLEANS_in_varType461); 
                    result = Type.BOOLEAN;

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:206:4: STRINGS
                    {
                    match(input,STRINGS,FOLLOW_STRINGS_in_varType468); 
                    result = Type.STRING;

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/FirstPass.g:207:4: INTEGERS
                    {
                    match(input,INTEGERS,FOLLOW_INTEGERS_in_varType475); 
                    result = Type.INTEGER;

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/FirstPass.g:208:4: REALS
                    {
                    match(input,REALS,FOLLOW_REALS_in_varType482); 
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
    // src/glossa/grammars/FirstPass.g:210:1: block : ^( BLOCK ( stm )* ) ;
    public final void block() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:210:7: ( ^( BLOCK ( stm )* ) )
            // src/glossa/grammars/FirstPass.g:210:9: ^( BLOCK ( stm )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block493); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/FirstPass.g:210:17: ( stm )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IFNODE||(LA11_0>=PRINT && LA11_0<=ASSIGN)||LA11_0==SWITCH||LA11_0==FOR||LA11_0==WHILE||LA11_0==REPEAT||LA11_0==CALL) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // src/glossa/grammars/FirstPass.g:210:17: stm
                	    {
                	    pushFollow(FOLLOW_stm_in_block495);
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
    // src/glossa/grammars/FirstPass.g:215:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) | ^( CALL ID paramsList ) );
    public final void stm() throws RecognitionException {
        CommonTree PRINT5=null;
        CommonTree READ6=null;

        try {
            // src/glossa/grammars/FirstPass.g:215:5: ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) | ^( CALL ID paramsList ) )
            int alt20=11;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:215:7: ^( PRINT (expr1= expr )* )
                    {
                    PRINT5=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_stm509); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // src/glossa/grammars/FirstPass.g:215:15: (expr1= expr )*
                        loop12:
                        do {
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0==NEG||LA12_0==ARRAY_ITEM||LA12_0==FUNC_CALL||LA12_0==ID||LA12_0==EQ||(LA12_0>=LT && LA12_0<=GE)||(LA12_0>=OR && LA12_0<=CONST_REAL)) ) {
                                alt12=1;
                            }


                            switch (alt12) {
                        	case 1 :
                        	    // src/glossa/grammars/FirstPass.g:215:16: expr1= expr
                        	    {
                        	    pushFollow(FOLLOW_expr_in_stm514);
                        	    expr();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop12;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                                                                    if((currentScope instanceof FunctionScope) && currentScope!=null){
                                                                        msgLog.error(new Point((PRINT5!=null?PRINT5.getLine():0), (PRINT5!=null?PRINT5.getCharPositionInLine():0)), Messages.STR_ERROR_CANNOT_USE_PRINT_STM_IN_FUNCTIONS);
                                                                    }
                                                                

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:220:17: ^( READ ( readItem )+ )
                    {
                    READ6=(CommonTree)match(input,READ,FOLLOW_READ_in_stm543); 

                    match(input, Token.DOWN, null); 
                    // src/glossa/grammars/FirstPass.g:220:24: ( readItem )+
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
                    	    // src/glossa/grammars/FirstPass.g:220:24: readItem
                    	    {
                    	    pushFollow(FOLLOW_readItem_in_stm545);
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

                                                                    if((currentScope instanceof FunctionScope) && currentScope!=null){
                                                                        msgLog.error(new Point((READ6!=null?READ6.getLine():0), (READ6!=null?READ6.getCharPositionInLine():0)), Messages.STR_ERROR_CANNOT_USE_READ_STM_IN_FUNCTIONS);
                                                                    }
                                                                

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/FirstPass.g:225:4: ^( ASSIGN ID expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm565); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm567); 
                    pushFollow(FOLLOW_expr_in_stm569);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/FirstPass.g:226:17: ^( ASSIGN ID arraySubscript expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_stm589); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm591); 
                    pushFollow(FOLLOW_arraySubscript_in_stm593);
                    arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm595);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/FirstPass.g:227:17: ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? )
                    {
                    match(input,IFNODE,FOLLOW_IFNODE_in_stm615); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ifBlock_in_stm617);
                    ifBlock();

                    state._fsp--;

                    // src/glossa/grammars/FirstPass.g:227:34: ( elseIfBlock )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ELSE_IF) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/glossa/grammars/FirstPass.g:227:34: elseIfBlock
                    	    {
                    	    pushFollow(FOLLOW_elseIfBlock_in_stm619);
                    	    elseIfBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // src/glossa/grammars/FirstPass.g:227:47: ( elseBlock )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ELSE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // src/glossa/grammars/FirstPass.g:227:47: elseBlock
                            {
                            pushFollow(FOLLOW_elseBlock_in_stm622);
                            elseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/FirstPass.g:228:17: ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? )
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_stm643); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm645);
                    expr();

                    state._fsp--;

                    // src/glossa/grammars/FirstPass.g:228:31: ( caseBlock )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==CASE) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/glossa/grammars/FirstPass.g:228:32: caseBlock
                    	    {
                    	    pushFollow(FOLLOW_caseBlock_in_stm648);
                    	    caseBlock();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // src/glossa/grammars/FirstPass.g:228:43: ( caseElseBlock )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==CASE_ELSE) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/glossa/grammars/FirstPass.g:228:44: caseElseBlock
                            {
                            pushFollow(FOLLOW_caseElseBlock_in_stm652);
                            caseElseBlock();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/FirstPass.g:229:17: ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm674); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm676); 
                    pushFollow(FOLLOW_expr_in_stm698);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm720);
                    expr();

                    state._fsp--;

                    // src/glossa/grammars/FirstPass.g:232:19: (expr3= expr )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==NEG||LA18_0==ARRAY_ITEM||LA18_0==FUNC_CALL||LA18_0==ID||LA18_0==EQ||(LA18_0>=LT && LA18_0<=GE)||(LA18_0>=OR && LA18_0<=CONST_REAL)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/glossa/grammars/FirstPass.g:232:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm743);
                            expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm765);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/FirstPass.g:234:17: ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block )
                    {
                    match(input,FOR,FOLLOW_FOR_in_stm785); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm787); 
                    pushFollow(FOLLOW_arraySubscript_in_stm789);
                    arraySubscript();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm811);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm833);
                    expr();

                    state._fsp--;

                    // src/glossa/grammars/FirstPass.g:237:19: (expr3= expr )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==NEG||LA19_0==ARRAY_ITEM||LA19_0==FUNC_CALL||LA19_0==ID||LA19_0==EQ||(LA19_0>=LT && LA19_0<=GE)||(LA19_0>=OR && LA19_0<=CONST_REAL)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // src/glossa/grammars/FirstPass.g:237:20: expr3= expr
                            {
                            pushFollow(FOLLOW_expr_in_stm856);
                            expr();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_stm878);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/FirstPass.g:239:17: ^( WHILE expr block )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_stm898); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_stm900);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_block_in_stm902);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/FirstPass.g:240:4: ^( REPEAT block expr )
                    {
                    match(input,REPEAT,FOLLOW_REPEAT_in_stm909); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_stm911);
                    block();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_stm913);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/glossa/grammars/FirstPass.g:241:17: ^( CALL ID paramsList )
                    {
                    match(input,CALL,FOLLOW_CALL_in_stm933); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_stm935); 
                    pushFollow(FOLLOW_paramsList_in_stm937);
                    paramsList();

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
    // src/glossa/grammars/FirstPass.g:244:1: readItem : (arrId= ID arraySubscript | varId= ID );
    public final void readItem() throws RecognitionException {
        CommonTree arrId=null;
        CommonTree varId=null;

        try {
            // src/glossa/grammars/FirstPass.g:244:9: (arrId= ID arraySubscript | varId= ID )
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
                    // src/glossa/grammars/FirstPass.g:244:17: arrId= ID arraySubscript
                    {
                    arrId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem962); 
                    pushFollow(FOLLOW_arraySubscript_in_readItem964);
                    arraySubscript();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:245:17: varId= ID
                    {
                    varId=(CommonTree)match(input,ID,FOLLOW_ID_in_readItem984); 

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
    // src/glossa/grammars/FirstPass.g:248:1: ifBlock : ^( IF expr block ) ;
    public final void ifBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:248:9: ( ^( IF expr block ) )
            // src/glossa/grammars/FirstPass.g:248:17: ^( IF expr block )
            {
            match(input,IF,FOLLOW_IF_in_ifBlock1008); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifBlock1010);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_ifBlock1012);
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
    // src/glossa/grammars/FirstPass.g:251:1: elseBlock : ^( ELSE block ) ;
    public final void elseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:252:2: ( ^( ELSE block ) )
            // src/glossa/grammars/FirstPass.g:252:4: ^( ELSE block )
            {
            match(input,ELSE,FOLLOW_ELSE_in_elseBlock1032); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_elseBlock1034);
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
    // src/glossa/grammars/FirstPass.g:255:1: elseIfBlock : ^( ELSE_IF expr block ) ;
    public final void elseIfBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:256:2: ( ^( ELSE_IF expr block ) )
            // src/glossa/grammars/FirstPass.g:256:4: ^( ELSE_IF expr block )
            {
            match(input,ELSE_IF,FOLLOW_ELSE_IF_in_elseIfBlock1054); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_elseIfBlock1056);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_block_in_elseIfBlock1058);
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
    // src/glossa/grammars/FirstPass.g:260:1: caseBlock : ^( CASE ( caseExprListItem )+ block ) ;
    public final void caseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:261:2: ( ^( CASE ( caseExprListItem )+ block ) )
            // src/glossa/grammars/FirstPass.g:261:4: ^( CASE ( caseExprListItem )+ block )
            {
            match(input,CASE,FOLLOW_CASE_in_caseBlock1079); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/FirstPass.g:261:11: ( caseExprListItem )+
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
            	    // src/glossa/grammars/FirstPass.g:261:12: caseExprListItem
            	    {
            	    pushFollow(FOLLOW_caseExprListItem_in_caseBlock1082);
            	    caseExprListItem();

            	    state._fsp--;


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

            pushFollow(FOLLOW_block_in_caseBlock1104);
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
    // src/glossa/grammars/FirstPass.g:264:1: caseExprListItem : (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) );
    public final void caseExprListItem() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:265:2: (a= expr | ^( RANGE a= expr b= expr ) | ^( INF_RANGE LT a= expr ) | ^( INF_RANGE LE a= expr ) | ^( INF_RANGE GT a= expr ) | ^( INF_RANGE GE a= expr ) )
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
                    // src/glossa/grammars/FirstPass.g:265:4: a= expr
                    {
                    pushFollow(FOLLOW_expr_in_caseExprListItem1116);
                    expr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:266:10: ^( RANGE a= expr b= expr )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_caseExprListItem1128); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1132);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_caseExprListItem1136);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/FirstPass.g:267:10: ^( INF_RANGE LT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1149); 

                    match(input, Token.DOWN, null); 
                    match(input,LT,FOLLOW_LT_in_caseExprListItem1151); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1155);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/FirstPass.g:268:17: ^( INF_RANGE LE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1175); 

                    match(input, Token.DOWN, null); 
                    match(input,LE,FOLLOW_LE_in_caseExprListItem1177); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1181);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/FirstPass.g:269:17: ^( INF_RANGE GT a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1201); 

                    match(input, Token.DOWN, null); 
                    match(input,GT,FOLLOW_GT_in_caseExprListItem1203); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1207);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/FirstPass.g:270:17: ^( INF_RANGE GE a= expr )
                    {
                    match(input,INF_RANGE,FOLLOW_INF_RANGE_in_caseExprListItem1227); 

                    match(input, Token.DOWN, null); 
                    match(input,GE,FOLLOW_GE_in_caseExprListItem1229); 
                    pushFollow(FOLLOW_expr_in_caseExprListItem1233);
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
    // src/glossa/grammars/FirstPass.g:273:1: caseElseBlock : ^( CASE_ELSE block ) ;
    public final void caseElseBlock() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:274:2: ( ^( CASE_ELSE block ) )
            // src/glossa/grammars/FirstPass.g:274:4: ^( CASE_ELSE block )
            {
            match(input,CASE_ELSE,FOLLOW_CASE_ELSE_in_caseElseBlock1253); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_caseElseBlock1255);
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
    // src/glossa/grammars/FirstPass.g:278:1: expr : ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) );
    public final void expr() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:279:2: ( ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( EQ a= expr b= expr ) | ^( NEQ a= expr b= expr ) | ^( LT a= expr b= expr ) | ^( LE a= expr b= expr ) | ^( GT a= expr b= expr ) | ^( GE a= expr b= expr ) | ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( TIMES a= expr b= expr ) | ^( DIA a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | ^( POW a= expr b= expr ) | ^( NEG a= expr ) | ^( NOT a= expr ) | CONST_TRUE | CONST_FALSE | CONST_STR | CONST_INT | CONST_REAL | ID | ^( ARRAY_ITEM ID arraySubscript ) | ^( FUNC_CALL ID paramsList ) )
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
                    // src/glossa/grammars/FirstPass.g:279:4: ^( AND a= expr b= expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr1268); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1272);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1278);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:280:4: ^( OR a= expr b= expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr1285); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1289);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1295);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/FirstPass.g:281:4: ^( EQ a= expr b= expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr1302); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1306);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1312);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/FirstPass.g:282:4: ^( NEQ a= expr b= expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr1319); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1323);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1329);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/glossa/grammars/FirstPass.g:283:4: ^( LT a= expr b= expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr1336); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1340);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1346);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/glossa/grammars/FirstPass.g:284:4: ^( LE a= expr b= expr )
                    {
                    match(input,LE,FOLLOW_LE_in_expr1353); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1357);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1363);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/glossa/grammars/FirstPass.g:285:4: ^( GT a= expr b= expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr1370); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1374);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1380);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // src/glossa/grammars/FirstPass.g:286:4: ^( GE a= expr b= expr )
                    {
                    match(input,GE,FOLLOW_GE_in_expr1387); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1391);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1397);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // src/glossa/grammars/FirstPass.g:287:4: ^( PLUS a= expr b= expr )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expr1404); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1408);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1414);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // src/glossa/grammars/FirstPass.g:288:4: ^( MINUS a= expr b= expr )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expr1421); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1425);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1431);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/glossa/grammars/FirstPass.g:289:4: ^( TIMES a= expr b= expr )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_expr1438); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1442);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1448);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/glossa/grammars/FirstPass.g:290:4: ^( DIA a= expr b= expr )
                    {
                    match(input,DIA,FOLLOW_DIA_in_expr1455); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1459);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1465);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // src/glossa/grammars/FirstPass.g:291:4: ^( DIV a= expr b= expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr1472); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1476);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1482);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/glossa/grammars/FirstPass.g:292:4: ^( MOD a= expr b= expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr1489); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1493);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1499);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/glossa/grammars/FirstPass.g:293:4: ^( POW a= expr b= expr )
                    {
                    match(input,POW,FOLLOW_POW_in_expr1506); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1510);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr1516);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // src/glossa/grammars/FirstPass.g:294:4: ^( NEG a= expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1523); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1527);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/glossa/grammars/FirstPass.g:295:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1534); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1538);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // src/glossa/grammars/FirstPass.g:296:4: CONST_TRUE
                    {
                    match(input,CONST_TRUE,FOLLOW_CONST_TRUE_in_expr1544); 

                    }
                    break;
                case 19 :
                    // src/glossa/grammars/FirstPass.g:297:4: CONST_FALSE
                    {
                    match(input,CONST_FALSE,FOLLOW_CONST_FALSE_in_expr1549); 

                    }
                    break;
                case 20 :
                    // src/glossa/grammars/FirstPass.g:298:4: CONST_STR
                    {
                    match(input,CONST_STR,FOLLOW_CONST_STR_in_expr1554); 

                    }
                    break;
                case 21 :
                    // src/glossa/grammars/FirstPass.g:299:4: CONST_INT
                    {
                    match(input,CONST_INT,FOLLOW_CONST_INT_in_expr1559); 

                    }
                    break;
                case 22 :
                    // src/glossa/grammars/FirstPass.g:300:4: CONST_REAL
                    {
                    match(input,CONST_REAL,FOLLOW_CONST_REAL_in_expr1564); 

                    }
                    break;
                case 23 :
                    // src/glossa/grammars/FirstPass.g:301:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_expr1569); 

                    }
                    break;
                case 24 :
                    // src/glossa/grammars/FirstPass.g:302:4: ^( ARRAY_ITEM ID arraySubscript )
                    {
                    match(input,ARRAY_ITEM,FOLLOW_ARRAY_ITEM_in_expr1575); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_expr1577); 
                    pushFollow(FOLLOW_arraySubscript_in_expr1579);
                    arraySubscript();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 25 :
                    // src/glossa/grammars/FirstPass.g:303:17: ^( FUNC_CALL ID paramsList )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_expr1599); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_expr1601); 
                    pushFollow(FOLLOW_paramsList_in_expr1603);
                    paramsList();

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
    // $ANTLR end "expr"


    // $ANTLR start "paramsList"
    // src/glossa/grammars/FirstPass.g:306:1: paramsList : ^( PARAMS ( expr )* ) ;
    public final void paramsList() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:307:2: ( ^( PARAMS ( expr )* ) )
            // src/glossa/grammars/FirstPass.g:307:4: ^( PARAMS ( expr )* )
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_paramsList1623); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/FirstPass.g:308:19: ( expr )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NEG||LA25_0==ARRAY_ITEM||LA25_0==FUNC_CALL||LA25_0==ID||LA25_0==EQ||(LA25_0>=LT && LA25_0<=GE)||(LA25_0>=OR && LA25_0<=CONST_REAL)) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // src/glossa/grammars/FirstPass.g:308:20: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_paramsList1644);
                	    expr();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop25;
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
    // $ANTLR end "paramsList"


    // $ANTLR start "arraySubscript"
    // src/glossa/grammars/FirstPass.g:312:1: arraySubscript : ^( ARRAY_INDEX ( expr )+ ) ;
    public final void arraySubscript() throws RecognitionException {
        try {
            // src/glossa/grammars/FirstPass.g:313:2: ( ^( ARRAY_INDEX ( expr )+ ) )
            // src/glossa/grammars/FirstPass.g:313:4: ^( ARRAY_INDEX ( expr )+ )
            {
            match(input,ARRAY_INDEX,FOLLOW_ARRAY_INDEX_in_arraySubscript1683); 

            match(input, Token.DOWN, null); 
            // src/glossa/grammars/FirstPass.g:313:18: ( expr )+
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
            	    // src/glossa/grammars/FirstPass.g:313:19: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_arraySubscript1686);
            	    expr();

            	    state._fsp--;


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


    // $ANTLR start "procedure"
    // src/glossa/grammars/FirstPass.g:315:1: procedure : ^( PROCEDURE ID formalParamsList[$ID.text, false] ( constDecl )? ( varDecl )? block ) ;
    public final void procedure() throws RecognitionException {
        CommonTree ID7=null;
        List<FormalParameter> formalParamsList8 = null;


        try {
            // src/glossa/grammars/FirstPass.g:316:2: ( ^( PROCEDURE ID formalParamsList[$ID.text, false] ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/FirstPass.g:316:4: ^( PROCEDURE ID formalParamsList[$ID.text, false] ( constDecl )? ( varDecl )? block )
            {
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure1700); 

               int index = input.index()-1;
                                            inSubprogram = true;
                                        

            match(input, Token.DOWN, null); 
            ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_procedure1722); 
            pushFollow(FOLLOW_formalParamsList_in_procedure1724);
            formalParamsList8=formalParamsList((ID7!=null?ID7.getText():null), false);

            state._fsp--;



                                            if(scopeTable.getFunctionScope((ID7!=null?ID7.getText():null))==null){
                                                if(scopeTable.getProcedureScope((ID7!=null?ID7.getText():null))==null){
                                                    ProcedureScope ps = new ProcedureScope(index, (ID7!=null?ID7.getText():null), formalParamsList8);
                                                    scopeTable.putProcedureScope((ID7!=null?ID7.getText():null), ps);
                                                    currentScope = ps;
                                                }else{
                                                    Messages.redeclarationOfProcedureError(msgLog, new Point((ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0)), (ID7!=null?ID7.getText():null));
                                                }
                                            }else{
                                                Messages.redeclarationOfFunctionError(msgLog, new Point((ID7!=null?ID7.getLine():0), (ID7!=null?ID7.getCharPositionInLine():0)), (ID7!=null?ID7.getText():null));
                                            }
                                    
            // src/glossa/grammars/FirstPass.g:334:19: ( constDecl )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==CONSTANTS) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:334:19: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_procedure1776);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/FirstPass.g:334:30: ( varDecl )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==VARIABLES) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:334:30: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_procedure1779);
                    varDecl();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_procedure1782);
            block();

            state._fsp--;


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
    // src/glossa/grammars/FirstPass.g:341:1: function : ^( FUNCTION ID returnType formalParamsList[$ID.text, true] ( constDecl )? ( varDecl )? block ) ;
    public final void function() throws RecognitionException {
        CommonTree ID9=null;
        List<FormalParameter> formalParamsList10 = null;

        Type returnType11 = null;


        try {
            // src/glossa/grammars/FirstPass.g:342:2: ( ^( FUNCTION ID returnType formalParamsList[$ID.text, true] ( constDecl )? ( varDecl )? block ) )
            // src/glossa/grammars/FirstPass.g:342:4: ^( FUNCTION ID returnType formalParamsList[$ID.text, true] ( constDecl )? ( varDecl )? block )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function1829); 

               int index = input.index()-1;
                                            inSubprogram = true;
                                        

            match(input, Token.DOWN, null); 
            ID9=(CommonTree)match(input,ID,FOLLOW_ID_in_function1852); 
            pushFollow(FOLLOW_returnType_in_function1854);
            returnType11=returnType();

            state._fsp--;

            pushFollow(FOLLOW_formalParamsList_in_function1856);
            formalParamsList10=formalParamsList((ID9!=null?ID9.getText():null), true);

            state._fsp--;


                                        if(BuiltinFunctions.isBuiltinFunctionName((ID9!=null?ID9.getText():null))){
                                            Messages.redeclarationOfBuiltinFunctionError(msgLog, new Point((ID9!=null?ID9.getLine():0), (ID9!=null?ID9.getCharPositionInLine():0)), (ID9!=null?ID9.getText():null));
                                        }else{
                                            if(scopeTable.getFunctionScope((ID9!=null?ID9.getText():null))==null){
                                                if(scopeTable.getProcedureScope((ID9!=null?ID9.getText():null))==null){
                                                    FunctionScope fs = new FunctionScope(index, (ID9!=null?ID9.getText():null), formalParamsList10, returnType11);
                                                    scopeTable.putFunctionScope((ID9!=null?ID9.getText():null), fs);
                                                    currentScope = fs;
                                                }else{
                                                    Messages.redeclarationOfProcedureError(msgLog, new Point((ID9!=null?ID9.getLine():0), (ID9!=null?ID9.getCharPositionInLine():0)), (ID9!=null?ID9.getText():null));
                                                }
                                            }else{
                                                Messages.redeclarationOfFunctionError(msgLog, new Point((ID9!=null?ID9.getLine():0), (ID9!=null?ID9.getCharPositionInLine():0)), (ID9!=null?ID9.getText():null));
                                            }
                                        }
                                    
            // src/glossa/grammars/FirstPass.g:363:19: ( constDecl )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==CONSTANTS) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:363:19: constDecl
                    {
                    pushFollow(FOLLOW_constDecl_in_function1904);
                    constDecl();

                    state._fsp--;


                    }
                    break;

            }

            // src/glossa/grammars/FirstPass.g:363:30: ( varDecl )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==VARIABLES) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:363:30: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_function1907);
                    varDecl();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_function1910);
            block();

            state._fsp--;


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
    // $ANTLR end "function"


    // $ANTLR start "returnType"
    // src/glossa/grammars/FirstPass.g:370:1: returnType returns [Type result] : ( INTEGER | REAL | STRING | BOOLEAN );
    public final Type returnType() throws RecognitionException {
        Type result = null;

        try {
            // src/glossa/grammars/FirstPass.g:371:2: ( INTEGER | REAL | STRING | BOOLEAN )
            int alt31=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt31=1;
                }
                break;
            case REAL:
                {
                alt31=2;
                }
                break;
            case STRING:
                {
                alt31=3;
                }
                break;
            case BOOLEAN:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // src/glossa/grammars/FirstPass.g:371:4: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_returnType1955); 
                    result =Type.INTEGER;

                    }
                    break;
                case 2 :
                    // src/glossa/grammars/FirstPass.g:372:4: REAL
                    {
                    match(input,REAL,FOLLOW_REAL_in_returnType1966); 
                    result =Type.REAL;

                    }
                    break;
                case 3 :
                    // src/glossa/grammars/FirstPass.g:373:4: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_returnType1980); 
                    result =Type.STRING;

                    }
                    break;
                case 4 :
                    // src/glossa/grammars/FirstPass.g:374:4: BOOLEAN
                    {
                    match(input,BOOLEAN,FOLLOW_BOOLEAN_in_returnType1992); 
                    result =Type.BOOLEAN;

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
    // $ANTLR end "returnType"


    // $ANTLR start "formalParamsList"
    // src/glossa/grammars/FirstPass.g:380:1: formalParamsList[String subprogramName, boolean inFunctionDecl] returns [List<FormalParameter> formalParams] : ^( FORMAL_PARAMS ( ID )* ) ;
    public final List<FormalParameter> formalParamsList(String subprogramName, boolean inFunctionDecl) throws RecognitionException {
        List<FormalParameter> formalParams = null;

        CommonTree ID12=null;

        try {
            // src/glossa/grammars/FirstPass.g:381:2: ( ^( FORMAL_PARAMS ( ID )* ) )
            // src/glossa/grammars/FirstPass.g:381:4: ^( FORMAL_PARAMS ( ID )* )
            {
            match(input,FORMAL_PARAMS,FOLLOW_FORMAL_PARAMS_in_formalParamsList2025); 


                                        List<FormalParameter> result = new ArrayList<FormalParameter>();
                                    

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/glossa/grammars/FirstPass.g:385:19: ( ID )*
                loop32:
                do {
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==ID) ) {
                        alt32=1;
                    }


                    switch (alt32) {
                	case 1 :
                	    // src/glossa/grammars/FirstPass.g:385:21: ID
                	    {
                	    ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_formalParamsList2073); 

                	                                FormalParameter param = new FormalParameter((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0), (ID12!=null?ID12.getText():null));
                	                                if( inFunctionDecl &&  subprogramName.toLowerCase().equals((ID12!=null?ID12.getText():null).toLowerCase())){
                	                                    Messages.paramDefinedWithSameNameAsFunctionError(msgLog, new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)), (ID12!=null?ID12.getText():null));
                	                                }
                	                                if(result.contains(param)){
                	                                    Messages.parameterWithTheSameNameExistsError(msgLog, new Point((ID12!=null?ID12.getLine():0), (ID12!=null?ID12.getCharPositionInLine():0)), (ID12!=null?ID12.getText():null));
                	                                }else{
                	                                    result.add(param);
                	                                }
                	                            

                	    }
                	    break;

                	default :
                	    break loop32;
                    }
                } while (true);


                                            formalParams = result;
                                        

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
        return formalParams;
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
        "\1\3\1\4\1\7\1\10";
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
            "\1\16\3\uffff\1\16\1\17\4\uffff\1\16\3\uffff\1\16\3\uffff\1"+
            "\16\25\uffff\4\16\14\uffff\20\16",
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
            return "215:1: stm : ( ^( PRINT (expr1= expr )* ) | ^( READ ( readItem )+ ) | ^( ASSIGN ID expr ) | ^( ASSIGN ID arraySubscript expr ) | ^( IFNODE ifBlock ( elseIfBlock )* ( elseBlock )? ) | ^( SWITCH expr ( caseBlock )* ( caseElseBlock )? ) | ^( FOR ID expr1= expr expr2= expr (expr3= expr )? block ) | ^( FOR ID arraySubscript expr1= expr expr2= expr (expr3= expr )? block ) | ^( WHILE expr block ) | ^( REPEAT block expr ) | ^( CALL ID paramsList ) );";
        }
    }
 

    public static final BitSet FOLLOW_program_in_unit50 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_function_in_unit53 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_procedure_in_unit55 = new BitSet(new long[]{0x0000000000000002L,0x000000000000A000L});
    public static final BitSet FOLLOW_PROGRAM_in_program66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_program72 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_declarations_in_program78 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_program82 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ID_in_program89 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constDecl_in_declarations135 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_varDecl_in_declarations138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANTS_in_constDecl149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constAssign_in_constDecl153 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_EQ_in_constAssign175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constAssign177 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_constAssign179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLES_in_varDecl205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varsDecl_in_varDecl209 = new BitSet(new long[]{0x00000001E0000008L});
    public static final BitSet FOLLOW_varType_in_varsDecl253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_varDeclItem_in_varsDecl277 = new BitSet(new long[]{0x0000000000080108L});
    public static final BitSet FOLLOW_ID_in_varDeclItem311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_varDeclItem345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_varDeclItem347 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_arrayDimension_in_varDeclItem349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_DIMENSION_in_arrayDimension395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayDimension418 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_BOOLEANS_in_varType461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGS_in_varType468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERS_in_varType475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REALS_in_varType482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stm_in_block495 = new BitSet(new long[]{0x0542020E00000088L});
    public static final BitSet FOLLOW_PRINT_in_stm509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm514 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_READ_in_stm543 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_readItem_in_stm545 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm565 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm567 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm569 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_stm589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm591 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm593 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm595 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IFNODE_in_stm615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifBlock_in_stm617 = new BitSet(new long[]{0x0000018000000008L});
    public static final BitSet FOLLOW_elseIfBlock_in_stm619 = new BitSet(new long[]{0x0000018000000008L});
    public static final BitSet FOLLOW_elseBlock_in_stm622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_stm643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm645 = new BitSet(new long[]{0x0000080000002008L});
    public static final BitSet FOLLOW_caseBlock_in_stm648 = new BitSet(new long[]{0x0000080000002008L});
    public static final BitSet FOLLOW_caseElseBlock_in_stm652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm676 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm698 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm720 = new BitSet(new long[]{0xE001E00001C88230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm743 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_stm785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm787 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_stm789 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm811 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm833 = new BitSet(new long[]{0xE001E00001C88230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm856 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_stm898 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_stm900 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_stm902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_stm909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_stm911 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_stm913 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_stm933 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_stm935 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_stm937 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_readItem962 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_readItem964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_readItem984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifBlock1008 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifBlock1010 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_ifBlock1012 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock1032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_elseBlock1034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_IF_in_elseIfBlock1054 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_elseIfBlock1056 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_elseIfBlock1058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_caseBlock1079 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_caseExprListItem_in_caseBlock1082 = new BitSet(new long[]{0xE001F00001C89230L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_block_in_caseBlock1104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_caseExprListItem1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1132 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LT_in_caseExprListItem1151 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1155 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LE_in_caseExprListItem1177 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1181 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GT_in_caseExprListItem1203 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INF_RANGE_in_caseExprListItem1227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GE_in_caseExprListItem1229 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_caseExprListItem1233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_ELSE_in_caseElseBlock1253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_caseElseBlock1255 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr1268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1272 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr1285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1289 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr1302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1306 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr1319 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1323 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr1336 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1340 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LE_in_expr1353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1357 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1363 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr1370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1374 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1380 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GE_in_expr1387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1391 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1397 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expr1404 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1408 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1414 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1421 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1425 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_expr1438 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1442 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIA_in_expr1455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1459 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1465 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1476 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1482 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1493 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POW_in_expr1506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1510 = new BitSet(new long[]{0xE001E00000888220L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expr_in_expr1516 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONST_TRUE_in_expr1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_FALSE_in_expr1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_STR_in_expr1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_INT_in_expr1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_REAL_in_expr1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_ITEM_in_expr1575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1577 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_arraySubscript_in_expr1579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_expr1599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expr1601 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_paramsList_in_expr1603 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAMS_in_paramsList1623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_paramsList1644 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_ARRAY_INDEX_in_arraySubscript1683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arraySubscript1686 = new BitSet(new long[]{0xE001E00000888228L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure1700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_procedure1722 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParamsList_in_procedure1724 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_constDecl_in_procedure1776 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_varDecl_in_procedure1779 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_procedure1782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_function1829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function1852 = new BitSet(new long[]{0x0000000000000000L,0x00000000001E0000L});
    public static final BitSet FOLLOW_returnType_in_function1854 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_formalParamsList_in_function1856 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_constDecl_in_function1904 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_varDecl_in_function1907 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_block_in_function1910 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_returnType1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_returnType1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_returnType1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_returnType1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAL_PARAMS_in_formalParamsList2025 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_formalParamsList2073 = new BitSet(new long[]{0x0000000000080008L});

}