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
    private static final MathContext mc;
    private static final int maxDecimalDigits;

    static {
        maxDecimalDigits = 34;
        maxInt = new BigInteger(new Integer(Integer.MAX_VALUE).toString());
        mc = new MathContext(maxDecimalDigits, RoundingMode.UP);
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

    // <editor-fold defaultstate="collapsed" desc="Boolean operations">
    public static Boolean and(Object a, Object b) {
        if ((a instanceof Boolean) && (b instanceof Boolean)) {
            return and((Boolean) a, (Boolean) b);
        }
        throw new RuntimeException("Cannot apply boolean-AND to non-boolean types"); //TODO: proper runtime error message
    }

    public static Boolean and(Boolean a, Boolean b) {
        return Boolean.valueOf(a.booleanValue() && b.booleanValue());
    }

    public static Boolean or(Object a, Object b) {
        if ((a instanceof Boolean) && (b instanceof Boolean)) {
            return or((Boolean) a, (Boolean) b);
        }
        throw new RuntimeException("Cannot apply boolean-OR to non-boolean types"); //TODO: proper runtime error message
    }

    public static Boolean or(Boolean a, Boolean b) {
        return Boolean.valueOf(a.booleanValue() || b.booleanValue());
    }

    public static Boolean not(Object a) {
        if (a instanceof Boolean) {
            return not((Boolean) a);
        }
        throw new RuntimeException("Cannot apply boolean-NOT to non-boolean type"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot compare non-compatible types for equality"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot compare non-numeric/non-string types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot compare non-numeric/non-string types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot compare non-numeric/non-string types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot compare non-numeric/non-string types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot add non-numeric types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot subtract non-numeric types"); //TODO: proper runtime error message
    }

    public static BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public static BigDecimal subtract(BigDecimal a, BigInteger b) {
        return a.subtract(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal subtract(BigInteger a, BigDecimal b) {
        return b.subtract(new BigDecimal(a, mc), mc);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return b.subtract(a, mc);
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
        throw new RuntimeException("Cannot multiply non-numeric types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot divide non-numeric types"); //TODO: proper runtime error message
    }

    public static BigDecimal divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return (new BigDecimal(a)).divide(new BigDecimal(b));
    }

    public static BigDecimal divide(BigDecimal a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return a.divide(new BigDecimal(b, mc), mc);
    }

    public static BigDecimal divide(BigInteger a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return (new BigDecimal(a, mc)).divide(b, mc);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return a.divide(b, mc);
    }

    public static Object intDivide(Object a, Object b) {
        if ((a instanceof BigInteger) && (b instanceof BigInteger)) {
            return intDivide((BigInteger) a, (BigInteger) b);
        }
        throw new RuntimeException("Cannot intDivide non-integer types"); //TODO: proper runtime error message
    }

    public static BigInteger intDivide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return a.divide(b);
    }

    public static Object intMod(Object a, Object b) {
        if ((a instanceof BigInteger) && (b instanceof BigInteger)) {
            return intMod((BigInteger) a, (BigInteger) b);
        }
        throw new RuntimeException("Cannot intMod non-integer types"); //TODO: proper runtime error message
    }

    public static BigInteger intMod(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Division by 0"); //TODO: proper runtime error message
        }
        return a.mod(b);
    }

    public static Object pow(Object a, Object b) {
        if (b instanceof BigInteger) {
            if (a instanceof BigInteger) {
                return pow((BigInteger) a, (BigInteger) b);
            } else if (a instanceof BigDecimal) {
                return pow((BigDecimal) a, (BigInteger) b);
            }
        }
        throw new RuntimeException("Cannot exponentiate non-numeric types"); //TODO: proper runtime error message
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
        throw new RuntimeException("Cannot negate non-numeric types"); //TODO: proper runtime error message
    }
    //</editor-fold>

    public static void print(Object o, PrintStream out) {
        
        out.print(toPrintableString(o));
    }

    public static String toPrintableString(Object o){
        if(o==null){
            return RuntimeMessages.UNDEFINED_VALUE;
        }else if (o instanceof String) {
            return ((String) o).substring(1, ((String) o).length() - 1);
        }else if(o instanceof Boolean){
            if(((Boolean) o).booleanValue()==true){
                return RuntimeMessages.CONST_STR_TRUE;
            }else{
                return RuntimeMessages.CONST_STR_FALSE;
            }
        }
        return o.toString();
    }

    public static Object toValue(String s, Type t){

        if((s==null)||(t==null)){
            throw new RuntimeException("Invalid value"); //TODO: proper runtime error message
        }else if(t.equals(Type.INTEGER)){
            try{
                return new BigInteger(s);
            }catch(NumberFormatException nfe){
                throw new RuntimeException("Invalid integer value: "+nfe); //TODO: proper runtime error message
            }
        }else if(t.equals(Type.REAL)){
            try{
                return new BigDecimal(s, mc);
            }catch(NumberFormatException nfe){
                throw new RuntimeException("Invalid integer value: "+nfe); //TODO: proper runtime error message
            }
        }else if(t.equals(Type.STRING)){
            return "'"+s+"'";
        }
        throw new RuntimeException("Incompatible value for assignment: "+s+" - needed: "+t.toString()); //TODO: proper runtime error message
    }
}
