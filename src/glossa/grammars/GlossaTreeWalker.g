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

tree grammar GlossaTreeWalker;

options{
	tokenVocab = Glossa;
	ASTLabelType=CommonTree;
}


@header{

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


package glossa.grammars;

}

@members{

}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program (function|procedure)*;

program	:	^(PROGRAM ID declarations block ID?)
        ;

declarations
	:	constDecl? varDecl?
	;

constDecl
	:	^(CONSTANTS constAssign*)
        ;

constAssign
	:	 ^(EQ ID expr)
        ;





varDecl	:	^(VARIABLES varsDecl*)
        ;



varsDecl
	:	^(varType varDeclItem+)
	;

varDeclItem
	:	ID
	| 	^(ARRAY ID arrayDimension)
        ;



arrayDimension
	:	^(ARRAY_DIMENSION expr+)
	;



varType
        :	BOOLEANS
	|	STRINGS
	|	INTEGERS
	|	REALS
	;

block	:	^(BLOCK stm*)
        ;




stm	:	^(PRINT expr*)
        |       ^(READ readItem+)
	|	^(ASSIGN ID expr)
        |       ^(ASSIGN ID arraySubscript expr)
        |       ^(IFNODE ifBlock elseIfBlock* elseBlock?)
        |       ^(SWITCH expr caseBlock* caseElseBlock?)
        |       ^(FOR ID expr1=expr expr2=expr (expr3=expr)? block)
        |       ^(FOR ID arraySubscript expr1=expr expr2=expr (expr3=expr)? block)
        |       ^(WHILE expr block)
	|	^(REPEAT block expr)
        |       ^(CALL ID paramsList)
        ;

readItem:       ID arraySubscript
        |       ID
        ;

ifBlock	:       ^(IF expr block)
        ;

elseBlock
	:	^(ELSE block)
        ;

elseIfBlock
	:	^(ELSE_IF expr block)
        ;


caseBlock
	:	^(CASE caseExprListItem+ block)
	;

caseExprListItem
	:	expr
	|       ^(RANGE a=expr b=expr)
	|       ^(INF_RANGE LT a=expr)
        |       ^(INF_RANGE LE a=expr)
        |       ^(INF_RANGE GT a=expr)
        |       ^(INF_RANGE GE a=expr)
        ;

caseElseBlock
	:	^(CASE_ELSE CASE block);



expr
	:	^(AND	a=expr	  b=expr)
	|	^(OR	a=expr	  b=expr)
	|	^(EQ	a=expr	  b=expr)
	|	^(NEQ	a=expr	  b=expr)
	|	^(LT	a=expr	  b=expr)
	|	^(LE	a=expr	  b=expr)
	|	^(GT	a=expr	  b=expr)
	|	^(GE	a=expr	  b=expr)
	|	^(PLUS	a=expr	  b=expr)
	|	^(MINUS	a=expr	  b=expr)
	|	^(TIMES	a=expr	  b=expr)
	|	^(DIA	a=expr	  b=expr)
	|	^(DIV	a=expr	  b=expr)
	|	^(MOD	a=expr	  b=expr)
	|	^(POW	a=expr	  b=expr)
	|	^(NEG	a=expr)
	|	^(NOT	a=expr)
	|	CONST_TRUE
	|	CONST_FALSE
	|	CONST_STR
	|	CONST_INT
	|	CONST_REAL
	|	ID
	|	^(ARRAY_ITEM ID arraySubscript)
        |       ^(FUNC_CALL ID paramsList)
        ;

paramsList
	:	^(PARAMS expr*)
        ;

arraySubscript
	:	^(ARRAY_INDEX (expr)+ );

procedure
	:	^(PROCEDURE ID formalParamsList constDecl? varDecl? block )
        ;

function
	:	^(FUNCTION ID returnType formalParamsList constDecl? varDecl? block )
        ;

returnType
	:	INTEGER
	|	REAL
	|	STRING
	|	BOOLEAN
        ;


formalParamsList
	:	^(FORMAL_PARAMS ID*)
        ;

