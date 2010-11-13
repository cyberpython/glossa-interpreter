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
package glossa.interpreter.core;

import glossa.builtinfunctions.BuiltinFunctions;
import glossa.interpreter.symboltable.symbols.RuntimeArray;
import glossa.interpreter.symboltable.symbols.RuntimeSimpleSymbol;
import glossa.interpreter.symboltable.symbols.RuntimeSymbol;
import glossa.messages.RuntimeMessages;
import glossa.types.Type;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class InterpreterUtils {

    private static final BigInteger maxInt;
    private static final BigDecimal d360;
    private static final MathContext mc;
    private static final int maxDecimalDigits;

    static {
        maxDecimalDigits = 128;
        maxInt = new BigInteger(new Integer(Integer.MAX_VALUE).toString());
        mc = new MathContext(maxDecimalDigits, RoundingMode.UP);
        d360 = new BigDecimal("360", mc);
    }

    public static MathContext getMathContext(){
        return InterpreterUtils.mc;
    }

    public static boolean isValidArrayDimension(Object o) {
        if (o instanceof BigInteger) {
            BigInteger bi = (BigInteger) o;
            if ((bi.compareTo(BigInteger.ZERO) > 0) && (bi.compareTo(maxInt) < 0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidArrayIndex(Object o, RuntimeArray arr, int index) {
        if (o instanceof BigInteger) {
            BigInteger bi = (BigInteger) o;
            if ((bi.compareTo(BigInteger.ZERO) > 0) && (bi.compareTo(new BigInteger(String.valueOf(arr.getDimensions().get(index).intValue()))) < 0)) {
                return true;
            }
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="Boolean operations">
    public static Boolean and(Object a, Object b) {
        if ((a instanceof Boolean) && (b instanceof Boolean)) {
            return and((Boolean) a, (Boolean) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_AND_FOR_NON_BOOLEAN_VALUES));
    }

    public static Boolean and(Boolean a, Boolean b) {
        return Boolean.valueOf(a.booleanValue() && b.booleanValue());
    }

    public static Boolean or(Object a, Object b) {
        if ((a instanceof Boolean) && (b instanceof Boolean)) {
            return or((Boolean) a, (Boolean) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_OR_FOR_NON_BOOLEAN_VALUES));
    }

    public static Boolean or(Boolean a, Boolean b) {
        return Boolean.valueOf(a.booleanValue() || b.booleanValue());
    }

    public static Boolean not(Object a) {
        if (a instanceof Boolean) {
            return not((Boolean) a);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_LOGIC_NOT_FOR_NON_BOOLEAN_VALUE));
    }

    public static Boolean not(Boolean a) {
        return Boolean.valueOf(!(a.booleanValue()));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Equality operations">
    public static Boolean equals(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return equals((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return equals((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return equals((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return equals((BigDecimal) a, (BigDecimal) b);
            }
        } else if ((a instanceof String) && (b instanceof String)) {
            return equals((String) a, (String) b);
        } else if ((a instanceof Boolean) && (b instanceof Boolean)) {
            return equals((Boolean) a, (Boolean) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_CHECK_NON_COMPATIBLE_TYPES_FOR_EQUALITY));
    }

    public static Boolean equals(BigInteger a, BigInteger b) {
        return a.equals(b);
    }

    public static Boolean equals(BigInteger a, BigDecimal b) {
        return (new BigDecimal(a)).equals(b);
    }

    public static Boolean equals(BigDecimal a, BigInteger b) {
        return a.equals(new BigDecimal(b));
    }

    public static Boolean equals(BigDecimal a, BigDecimal b) {
        return a.equals(b);
    }

    public static Boolean equals(String a, String b) {
        return a.equals(b);
    }

    public static Boolean equals(Boolean a, Boolean b) {
        return a.equals(b);
    }

    public static Boolean notEquals(Object a, Object b) {
        return Boolean.valueOf(!(equals(a, b).booleanValue()));
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Arithmetic and String comparison operations">
    public static Boolean lowerThan(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return lowerThan((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return lowerThan((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return lowerThan((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return lowerThan((BigDecimal) a, (BigDecimal) b);
            }
        } else if ((a instanceof String) && (b instanceof String)) {
            return lowerThan((String) a, (String) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CAN_ONLY_COMPARE_NUMERIC_TYPES_OR_STRINGS));
    }

    public static Boolean lowerThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) < 0;
    }

    public static Boolean lowerThan(BigDecimal a, BigInteger b) {
        return a.compareTo(new BigDecimal(b)) < 0;
    }

    public static Boolean lowerThan(BigInteger a, BigDecimal b) {
        return (new BigDecimal(a)).compareTo(b) < 0;
    }

    public static Boolean lowerThan(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 0;
    }

    public static Boolean lowerThan(String a, String b) {
        return a.compareTo(b) < 0;
    }

    public static Boolean lowerThanOrEqual(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return lowerThanOrEqual((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return lowerThanOrEqual((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return lowerThanOrEqual((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return lowerThanOrEqual((BigDecimal) a, (BigDecimal) b);
            }
        } else if ((a instanceof String) && (b instanceof String)) {
            return lowerThanOrEqual((String) a, (String) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CAN_ONLY_COMPARE_NUMERIC_TYPES_OR_STRINGS));
    }

    public static Boolean lowerThanOrEqual(BigInteger a, BigInteger b) {
        return a.compareTo(b) <= 0;
    }

    public static Boolean lowerThanOrEqual(BigDecimal a, BigInteger b) {
        return a.compareTo(new BigDecimal(b)) <= 0;
    }

    public static Boolean lowerThanOrEqual(BigInteger a, BigDecimal b) {
        return (new BigDecimal(a)).compareTo(b) <= 0;
    }

    public static Boolean lowerThanOrEqual(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) <= 0;
    }

    public static Boolean lowerThanOrEqual(String a, String b) {
        return a.compareTo(b) <= 0;
    }

    public static Boolean greaterThan(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return greaterThan((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return greaterThan((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return greaterThan((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return greaterThan((BigDecimal) a, (BigDecimal) b);
            }
        } else if ((a instanceof String) && (b instanceof String)) {
            return greaterThan((String) a, (String) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CAN_ONLY_COMPARE_NUMERIC_TYPES_OR_STRINGS));
    }

    public static Boolean greaterThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) > 0;
    }

    public static Boolean greaterThan(BigDecimal a, BigInteger b) {
        return a.compareTo(new BigDecimal(b)) > 0;
    }

    public static Boolean greaterThan(BigInteger a, BigDecimal b) {
        return (new BigDecimal(a)).compareTo(b) > 0;
    }

    public static Boolean greaterThan(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0;
    }

    public static Boolean greaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    public static Boolean greaterThanOrEqual(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return greaterThanOrEqual((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return greaterThanOrEqual((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return greaterThanOrEqual((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return greaterThanOrEqual((BigDecimal) a, (BigDecimal) b);
            }
        } else if ((a instanceof String) && (b instanceof String)) {
            return greaterThanOrEqual((String) a, (String) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CAN_ONLY_COMPARE_NUMERIC_TYPES_OR_STRINGS));
    }

    public static Boolean greaterThanOrEqual(BigInteger a, BigInteger b) {
        return a.compareTo(b) >= 0;
    }

    public static Boolean greaterThanOrEqual(BigDecimal a, BigInteger b) {
        return a.compareTo(new BigDecimal(b)) >= 0;
    }

    public static Boolean greaterThanOrEqual(BigInteger a, BigDecimal b) {
        return (new BigDecimal(a)).compareTo(b) >= 0;
    }

    public static Boolean greaterThanOrEqual(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) >= 0;
    }

    public static Boolean greaterThanOrEqual(String a, String b) {
        return a.compareTo(b) >= 0;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Arithmetic operations">
    public static Object add(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return add((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return add((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return add((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return add((BigDecimal) a, (BigDecimal) b);
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ADD_NON_NUMERIC_VALUES));
    }

    public static BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    public static BigDecimal add(BigDecimal a, BigInteger b) {
        return a.add(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal add(BigInteger a, BigDecimal b) {
        return b.add(new BigDecimal(a, mc), mc);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return b.add(a, mc);
    }

    public static Object subtract(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return subtract((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return subtract((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return subtract((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return subtract((BigDecimal) a, (BigDecimal) b);
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_SUBTRACT_NON_NUMERIC_VALUES));
    }

    public static BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public static BigDecimal subtract(BigDecimal a, BigInteger b) {
        return a.subtract(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal subtract(BigInteger a, BigDecimal b) {
        return new BigDecimal(a, mc).subtract(b, mc);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b, mc);
    }

    public static Object multiply(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return multiply((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return multiply((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return multiply((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return multiply((BigDecimal) a, (BigDecimal) b);
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_MULTIPLY_NON_NUMERIC_VALUES));
    }

    public static BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    public static BigDecimal multiply(BigDecimal a, BigInteger b) {
        return a.multiply(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal multiply(BigInteger a, BigDecimal b) {
        return b.multiply(new BigDecimal(a, mc), mc);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b, mc);
    }

    public static Object divide(Object a, Object b) {
        if (a instanceof BigInteger) {
            if (b instanceof BigInteger) {
                return divide((BigInteger) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return divide((BigInteger) a, (BigDecimal) b);
            }
        } else if (a instanceof BigDecimal) {
            if (b instanceof BigInteger) {
                return divide((BigDecimal) a, (BigInteger) b);
            } else if (b instanceof BigDecimal) {
                return divide((BigDecimal) a, (BigDecimal) b);
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_DIVIDE_NON_NUMERIC_VALUES));
    }

    public static BigDecimal divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return (new BigDecimal(a)).divide(new BigDecimal(b));
    }

    public static BigDecimal divide(BigDecimal a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return a.divide(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal divide(BigInteger a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return (new BigDecimal(a, mc)).divide(b, mc);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return a.divide(b, mc);
    }

    public static Object intDivide(Object a, Object b) {
        if ((a instanceof BigInteger) && (b instanceof BigInteger)) {
            return intDivide((BigInteger) a, (BigInteger) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_INTDIVIDE_NON_INTEGER_VALUES));
    }

    public static BigInteger intDivide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return a.divide(b);
    }

    public static Object intMod(Object a, Object b) {
        if ((a instanceof BigInteger) && (b instanceof BigInteger)) {
            return intMod((BigInteger) a, (BigInteger) b);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_INTMOD_NON_INTEGER_VALUES));
    }

    public static BigInteger intMod(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_DIVISION_BY_ZERO));
        }
        return a.remainder(b);
    }

    public static Object pow(Object a, Object b) {
        if (b instanceof BigInteger) {
            if (a instanceof BigInteger) {
                return pow((BigInteger) a, (BigInteger) b);
            } else if (a instanceof BigDecimal) {
                return pow((BigDecimal) a, (BigInteger) b);
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_EXPONENTIATE_NON_NUMERIC_VALUE));
    }

    public static BigDecimal pow(BigInteger a, BigInteger b) {
        return (new BigDecimal(a, mc)).pow(b.intValue(), mc);
    }

    public static BigDecimal pow(BigDecimal a, BigInteger b) {
        return a.pow(b.intValue(), mc);
    }

    public static Object negate(Object a) {
        if (a instanceof BigInteger) {
            return ((BigInteger) a).negate();
        } else if (a instanceof BigDecimal) {
            return ((BigDecimal) a).negate(mc);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_NEGATE_NON_NUMERIC_VALUE));
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Built-in functions">

    public static Object execBuiltinFunction(String functionName, Object param){
        if(BuiltinFunctions.isBuiltinFunctionName(functionName)){
            Object parameter;
            if(param instanceof RuntimeSymbol){
                if(param instanceof RuntimeSimpleSymbol){
                    parameter = ((RuntimeSimpleSymbol)param).getValue();
                }else{
                    throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_USED_AS_VALUE, ((RuntimeArray)param).getName(), functionName));
                }
            }else{
                parameter = param;
            }
            String funcId = functionName.toUpperCase();
            if (funcId.equals("ΗΜ")){
                return sin(parameter);
            }else if (funcId.equals("ΣΥΝ")){
                return cos(parameter);
            }else if (funcId.equals("ΕΦ")){
                return tan(parameter);
            }else if (funcId.equals("Τ_Ρ")){
                return sqrt(parameter);
            }else if (funcId.equals("ΛΟΓ")){
                return log(parameter);
            }else if (funcId.equals("Ε")){
                return exp(parameter);
            }else if (funcId.equals("Α_Μ")){
                return intPart(parameter);
            }else if (funcId.equals("Α_Τ")){
                return abs(parameter);
            }else{
                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_BUILT_IN_FUNCTION, toPrintableString(functionName)));
            }
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_BUILT_IN_FUNCTION, toPrintableString(functionName)));
    }

    public static BigDecimal sin(Object degrees){
        if(degrees instanceof BigDecimal){
            return MathUtils.sin((BigDecimal)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(degrees instanceof BigInteger){
            return MathUtils.sin((BigInteger)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(degrees)));
    }

    public static BigDecimal cos(Object degrees){
        if(degrees instanceof BigDecimal){
            return MathUtils.cos((BigDecimal)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(degrees instanceof BigInteger){
            return MathUtils.cos((BigInteger)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(degrees)));
    }

    public static BigDecimal tan(Object degrees){
        if(degrees instanceof BigDecimal){
            return MathUtils.tan((BigDecimal)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(degrees instanceof BigInteger){
            return MathUtils.tan((BigInteger)degrees).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(degrees)));
    }

    public static BigDecimal sqrt(Object n){
        if(n instanceof BigDecimal){
            return MathUtils.sqrt((BigDecimal)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(n instanceof BigInteger){
            return MathUtils.sqrt((BigInteger)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(n)));
    }


    public static BigDecimal log(Object n){
        if(n instanceof BigDecimal){
            return MathUtils.log((BigDecimal)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(n instanceof BigInteger){
            return MathUtils.log((BigInteger)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(n)));
    }

    public static BigDecimal exp(Object n){
        if(n instanceof BigDecimal){
            return MathUtils.exp((BigDecimal)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(n instanceof BigInteger){
            return MathUtils.exp((BigInteger)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(n)));
    }

    public static BigInteger intPart(Object n){
        if(n instanceof BigDecimal){
            return MathUtils.intPart((BigDecimal)n);
        }else if(n instanceof BigInteger){
            return MathUtils.intPart((BigInteger)n);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(n)));
    }

    public static Object abs(Object n){
        if(n instanceof BigDecimal){
            return MathUtils.abs((BigDecimal)n).setScale(maxDecimalDigits, mc.getRoundingMode());
        }else if(n instanceof BigInteger){
            return MathUtils.abs((BigInteger)n);
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_NUMERIC_VALUE, toPrintableString(n)));
    }

    
    // </editor-fold>

    public static void print(Object o, PrintStream out) {
        out.print(toPrintableString(o));
    }

    public static String toPrintableString(Object o){
        if(o==null){
            return RuntimeMessages.UNDEFINED_VALUE;
        }else if (o instanceof String) {
            String s = (String)o;
            if(s.length()>2){
                return ((String) o).substring(1, ((String) o).length() - 1);
            }else{
                return s;
            }
        }else if(o instanceof Boolean){
            if(((Boolean) o).booleanValue()==true){
                return RuntimeMessages.CONST_STR_TRUE;
            }else{
                return RuntimeMessages.CONST_STR_FALSE;
            }
        }else if(o instanceof BigDecimal){
            return ((BigDecimal)o).stripTrailingZeros().toPlainString();
        }
        return o.toString();
    }

    public static Object toValue(String s, Type t){

        if((s==null)||(t==null)){
            throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_VALUE);
        }else if(t.equals(Type.INTEGER)){
            try{
                return new BigInteger(s);
            }catch(NumberFormatException nfe){
                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_INTEGER_VALUE, s));
            }
        }else if(t.equals(Type.REAL)){
            try{
                return new BigDecimal(s, mc);
            }catch(NumberFormatException nfe){
                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_REAL_VALUE, s));
            }
        }else if(t.equals(Type.STRING)){
            return "'"+s+"'";
        }
        throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_VALUE_FOR_ASSIGNMENT, s, t.toString()));
    }
}
