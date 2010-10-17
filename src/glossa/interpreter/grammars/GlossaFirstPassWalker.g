tree grammar GlossaFirstPassWalker;

options{
	tokenVocab = Glossa; //read token types from Expr.tokens file
	ASTLabelType=CommonTree;
}


@header{
package glossa.interpreter;

import glossa.interpreter.symboltable.MainProgramSymbolTable;
import glossa.interpreter.utils.ErrorUtils;
import java.awt.Point;
}

@members{
	MainProgramSymbolTable mainSymbolTable = new MainProgramSymbolTable();
}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	^(PROGRAM
		id1=ID	{
				mainSymbolTable.setProgramName($id1.text);
			}
		declarations
		block 
		(id2=ID {
				if($id1.text.equals($id2.text)==false){
					ErrorUtils.programNameMismatchError(new Point($id2.line, $id2.pos), $id2.text);
				}
			}
		)?
		);
		
declarations
	:	(constDecl | varDecl)*;
		
constDecl
	:	^(CONSTANTS	{
					if(mainSymbolTable.isConstantsDeclared()){
						ErrorUtils.constantsRedeclarationError(new Point($CONSTANTS.line, $CONSTANTS.pos), mainSymbolTable.getConstantsDeclarationPoint());
					}else{
						mainSymbolTable.setConstantsDeclared(true);
						mainSymbolTable.setConstantsDeclarationPoint(new Point($CONSTANTS.line, $CONSTANTS.pos));
					}
				}
		constAssign*);

constAssign
	:	 ^(EQ ID expr);
	
	
	
	
	
varDecl	:	^(VARIABLES	{
					if(mainSymbolTable.isVariablesDeclared()){
						ErrorUtils.variablesRedeclarationError(new Point($VARIABLES.line, $VARIABLES.pos), mainSymbolTable.getVariablesDeclarationPoint());
					}else{
						mainSymbolTable.setVariablesDeclared(true);
						mainSymbolTable.setVariablesDeclarationPoint(new Point($VARIABLES.line, $VARIABLES.pos));
					}
				}
		varsDecl*);
		
		
	
varsDecl
	:	^(varType varDeclItem+);

varDeclItem
	:	ID 
	| 	^(ARRAY ID arrayDimension);

arrayDimension
	:	^(ARRAY_DIMENSION expr+);
	
varType	:	BOOLEANS
	|	STRINGS
	|	INTEGERS
	|	REALS;
		
block	:	^(BLOCK stm*);

stm	:	^(PRINT expr+)
	|	^(ASSIGN ID expr);
	
expr	:	^(AND	a=expr	  b=expr)
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
	|	^(ARRAY_ITEM ID arraySubscript+);
	
arraySubscript
	:	^(ARRAY_INDEX expr+);
