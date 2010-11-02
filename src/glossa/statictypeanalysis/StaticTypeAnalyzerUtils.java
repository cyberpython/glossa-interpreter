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

import glossa.messages.MessageLog;
import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.ScopeTable;
import glossa.statictypeanalysis.scopetable.parameters.ActualParameter;
import glossa.statictypeanalysis.scopetable.scopes.FunctionScope;
import glossa.statictypeanalysis.scopetable.scopes.Scope;
import glossa.statictypeanalysis.scopetable.symbols.Array;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.statictypeanalysis.scopetable.symbols.Variable;
import glossa.types.Type;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class StaticTypeAnalyzerUtils {


    public static void checkResultsForms(MessageLog msgLog, ExpressionResultForm form1, ExpressionResultForm form2,
                                                            int expr1Line, int expr1Pos,
                                                            int expr2Line, int expr2Pos
                                        ) {
        if (ExpressionResultForm.ARRAY.equals(form1)) {
            Messages.arrayUsedInExpressionError(msgLog, new Point(expr1Line, expr1Pos)); //TODO: include the array name in the message
        }

        if (ExpressionResultForm.ARRAY.equals(form2)) {
            Messages.arrayUsedInExpressionError(msgLog, new Point(expr2Line, expr2Pos)); //TODO: include the array name in the message
        }
    }


    public static void checkResultForm(MessageLog msgLog, ExpressionResultForm form1,
                                                            int expr1Line, int expr1Pos
                                        ) {
        if (ExpressionResultForm.ARRAY.equals(form1)) {
            Messages.arrayUsedInExpressionError(msgLog, new Point(expr1Line, expr1Pos)); //TODO: include the array name in the message
        }
    }

    /**
     * @return an integer indicating the compatibility between the types
     * <ul>
     * <li>0  if the types are equal</li>
     * <li>1  if they are not equal but compatible (real <- integer)</li>
     * <li>-1 if they are incompatible</li>
     * </ul>
     */
    public static int areTypesCompatibleForAssignment(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            return 0;
        }
        if (type1.equals(type2)) {
            return 0;
        } else {
            if (type1.equals(Type.REAL) && type2.equals(Type.INTEGER)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static Type getWiderType(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            return null;
        }
        if (type1.equals(type2)) {
            return type1;
        } else {
            if (isNumericType(type1) && isNumericType(type2)) {
                if (type1.equals(Type.REAL) || type2.equals(Type.REAL)) {
                    return Type.REAL;
                } else {
                    return Type.INTEGER;
                }
            } else {
                return null;
            }
        }
    }

    public static boolean isNumericType(Type type) {
        if (type == null) {
            return true;
        }
        if (type.equals(Type.REAL) || type.equals(Type.INTEGER)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForArithmeticExpression(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            if (type1 != null) {
                return isNumericType(type1);
            }
            if (type2 != null) {
                return isNumericType(type1);
            }
        }
        if (isNumericType(type1) && isNumericType(type2)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypeForNotExpression(Type type1) {
        if (type1 == null) {
                return true;
        }else if(type1.equals(Type.BOOLEAN)){
            return true;
        }
        return false;
    }

    public static boolean checkTypeForInfinityIncludingComparisonExpression(Type type1) {
        if (type1 == null) {
                return true;
        }else if(type1.equals(Type.BOOLEAN)){
            return false;
        }
        return true;
    }

    public static boolean checkTypesForIntegerArithmeticExpression(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            if (type1 != null) {
                return type1.equals(Type.INTEGER);
            }
            if (type2 != null) {
                return type2.equals(Type.INTEGER);
            }
        }
        if (type1.equals(Type.INTEGER) && type2.equals(Type.INTEGER)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForBooleanExpression(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            if (type1 != null) {
                return type1.equals(Type.BOOLEAN);
            }
            if (type2 != null) {
                return type2.equals(Type.BOOLEAN);
            }
        }
        if (type1.equals(Type.BOOLEAN) && type2.equals(Type.BOOLEAN)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForEqualityExpression(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            return true;
        }
        if (type1.equals(type2)) {
            return true;
        } else if (isNumericType(type1) && isNumericType(type2)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForComparisonExpression(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            if (type1 != null) {
                return !type1.equals(Type.BOOLEAN);
            }
            if (type2 != null) {
                return !type2.equals(Type.BOOLEAN);
            }
        }
        if (type1.equals(Type.BOOLEAN) || type2.equals(Type.BOOLEAN)) {
            return false;
        }

        return StaticTypeAnalyzerUtils.checkTypesForEqualityExpression(type1, type2);
    }


    public static boolean checkTypesForCaseStatement(Type type1, Type type2) {
        if (type1 == null || type2 == null) {
            return true;
        }
        if (type1.equals(type2)) {
            return true;
        } else if (isNumericType(type1) && isNumericType(type2)) {
            return true;
        }
        return false;
    }

    public static void checkVariableAssignment(MessageLog msgLog, Scope currentScope, String idText, int idLine, int idPosition, Type expressionType, int expressionLine, int expressionPosition, String assignmentOperator, int assignmentLine, int assignmentPosition) {
        Symbol s = currentScope.referenceSymbol(msgLog, idText, new Point(idLine, idPosition));
        if (s != null) {
            if (s instanceof Variable) {
                s.setInitialized(true);
                if (StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(s.getType(), expressionType) < 0) {
                    Messages.incompatibleTypesFoundError(msgLog, s.getType(), new Point(idLine, idPosition), expressionType, new Point(expressionLine, expressionPosition), new Point(assignmentLine, assignmentPosition), assignmentOperator);
                }
            } else {
                Messages.nonVariableSymbolReferencedAsSuchError(msgLog, new Point(idLine, idPosition), s);
            }
        }
    }

    public static void checkArrayAssignment(MessageLog msgLog, Scope currentScope, String idText, int idLine, int idPosition,
            Type expressionType, int expressionLine, int expressionPosition,
            String assignmentOperator, int assignmentLine, int assignmentPosition,
            int indicesCount, int arraySubscriptLine, int arraySubscriptPosition) {
        Symbol s = currentScope.referenceSymbol(msgLog, idText, new Point(idLine, idPosition));
        if (s != null) {
            if (s instanceof Array) {
                s.setInitialized(true);
                if (StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(s.getType(), expressionType) < 0) {
                    Messages.incompatibleTypesFoundError(msgLog, s.getType(), new Point(idLine, idPosition), expressionType, new Point(expressionLine, expressionPosition), new Point(assignmentLine, assignmentPosition), assignmentOperator);
                } else {
                    Array arr = (Array) s;
                    if (arr.getNumberOfDimensions() != indicesCount) {
                        Messages.arrayIndicesAndDimensionsMismatchError(msgLog,new Point(arraySubscriptLine, arraySubscriptPosition), arr, indicesCount);
                    }
                }
            } else {
                Messages.nonArraySymbolReferencedAsSuchError(msgLog, s, new Point(idLine, idPosition));
            }
        }
    }



    public static Type checkFunctionCall(MessageLog msgLog, ScopeTable scopes, String functionId, int idLine, int idPosition, List<ActualParameter> params) {
        FunctionScope fs = scopes.getFunctionScope(functionId);
        if(fs!=null){
            List<Integer> checkResults = fs.checkParameterTypes(params);
            if(checkResults==null){
                msgLog.error(new Point(idLine, idPosition), functionId+Messages.actualParametersToString(params)+" - Εσφαλμένο πλήθος παραμέτρων: "+params.size());//TODO: proper error message
            }else if(checkResults.size() > 0) {
                msgLog.error(new Point(idLine, idPosition), "Εσφαλμένος τύπος παραμέτρων: "+functionId+Messages.actualParametersToString(params));//TODO: get info for wrong params from params list and checkResults
            }
            return fs.getReturnType();
        }else{
            Messages.callToUnknownFunctionError(msgLog, new Point(idLine, idPosition), functionId, params);
            return null;
        }
    }


}
