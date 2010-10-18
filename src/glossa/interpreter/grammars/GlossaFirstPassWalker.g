tree grammar GlossaFirstPassWalker;

options{
	tokenVocab = Glossa; //read token types from Expr.tokens file
	ASTLabelType=CommonTree;
}


@header{
package glossa.interpreter;

import glossa.interpreter.symboltable.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
}

@members{
	SymbolTable symbolTable = new MainProgramSymbolTable();
}


/*
**************************
*	Grammar rules:
**************************
*/

unit	:	program;

program	:	^(PROGRAM
		id1=ID	{
				((MainProgramSymbolTable)symbolTable).setProgramName($id1.text);
			}
		declarations
		block 
		(id2=ID {
				if($id1.text.equals($id2.text)==false){
					ReportingAndMessagingUtils.programNameMismatchWarning(new Point($id2.line, $id2.pos), $id2.text);
				}
			}
		)?
		);
		
declarations
	:	(constDecl | varDecl)*;
		
constDecl
	:	^(CONSTANTS	{
					if(symbolTable.isConstantsDeclared()){
						ReportingAndMessagingUtils.constantsRedeclarationError(new Point($CONSTANTS.line, $CONSTANTS.pos), symbolTable.getConstantsDeclarationPoint());
					}else{
						symbolTable.setConstantsDeclared(true);
						symbolTable.setConstantsDeclarationPoint(new Point($CONSTANTS.line, $CONSTANTS.pos));
					}
				}
		constAssign*);

constAssign
	:	 ^(EQ ID expr);
	
	
	
	
	
varDecl	:	^(VARIABLES	{
					if(symbolTable.isVariablesDeclared()){
						ReportingAndMessagingUtils.variablesRedeclarationError(new Point($VARIABLES.line, $VARIABLES.pos), symbolTable.getVariablesDeclarationPoint());
					}else{
						symbolTable.setVariablesDeclared(true);
						symbolTable.setVariablesDeclarationPoint(new Point($VARIABLES.line, $VARIABLES.pos));
					}
				}
		varsDecl*);
		
		

varsDecl
	:	^(
                    varType
                    (varDeclItem     {
                                        Symbol s = $varDeclItem.variable;
                                        s.setType($varType.result);
                                        symbolTable.defineSymbol(s.getName(), s);
                                    }
                    )+
                );

varDeclItem returns [Symbol variable]
	:	ID                          {
                                                $variable = new Variable($ID.text, $ID.line, $ID.pos, $ID.getTokenStartIndex(), null);
                                            }
	| 	^(ARRAY ID arrayDimension)  {
                                                $variable = new Array($ID.text, $ID.line, $ID.pos, $ID.getTokenStartIndex(), $arrayDimension.dimensions);
                                            }
        ;

arrayDimension returns [List<Integer> dimensions]
	:	^(
                    ARRAY_DIMENSION {
                                        $dimensions = new ArrayList<Integer>();
                                    }
                    (expr           {
                                        $dimensions.add(new Integer(1)); //TODO get value from expr - expr value msut be integer > 0
                                    }
                     )+
                 );
	
varType	returns [Type result]
        :	BOOLEANS {$result = Type.BOOLEAN;}
	|	STRINGS {$result = Type.STRING;}
	|	INTEGERS {$result = Type.INTEGER;}
	|	REALS {$result = Type.REAL;};
		
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
