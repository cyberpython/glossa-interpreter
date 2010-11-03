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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class MathUtils {

    private static final MathContext mc15;
    private static final BigDecimal d90;
    private static final BigDecimal d180;
    private static final BigDecimal d270;
    private static final BigDecimal d360;

    static {
        mc15 = new MathContext(15, RoundingMode.DOWN);
        d90 = new BigDecimal("90", mc15);
        d180 = new BigDecimal("180", mc15);
        d270 = new BigDecimal("270", mc15);
        d360 = new BigDecimal("360", mc15);
    }

    public static BigDecimal sin(BigInteger degrees) {
        return sin(new BigDecimal(degrees));
    }

    public static BigDecimal sin(BigDecimal degrees) {
        BigDecimal d = degrees.remainder(d360);
        if ((d.compareTo(BigDecimal.ZERO) == 0) || (d.compareTo(d180) == 0) || (d.compareTo(d360) == 0)) {
            return BigDecimal.ZERO;
        } else if (d.compareTo(d90) == 0) {
            return BigDecimal.ONE;
        } else if (d.compareTo(d270) == 0) {
            return BigDecimal.ONE.negate(mc15);
        } else {
            return cos(d90.subtract(d, mc15));
        }
    }

    public static BigDecimal cos(BigInteger d) {
        return cos(new BigDecimal(d, mc15));
    }

    public static BigDecimal cos(BigDecimal degrees) {
        int signFactor = 1;
        BigDecimal d = degrees.remainder(d360).abs(mc15);

        if ((d.compareTo(d90) > 0) && (d.compareTo(d180) < 0)) {
            d = d180.subtract(d, mc15);
            signFactor = -1;
        } else if ((d.compareTo(d180) > 0) && (d.compareTo(d270) < 0)) {
            d = d.subtract(d180, mc15);
            signFactor = -1;
        } else if ((d.compareTo(d270) > 0) && (d.compareTo(d360) < 0)) {
            d = d360.subtract(d, mc15);
            signFactor = 1;
        }

        if ((d.compareTo(BigDecimal.ZERO) == 0) || (d.compareTo(d360) == 0)) {
            return BigDecimal.ONE;
        } else if ((d.compareTo(d180) == 0)) {
            return BigDecimal.ONE.negate(mc15);
        } else if ((d.compareTo(d90) == 0) || (d.compareTo(d270) == 0)) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(   Double.toString(signFactor * Math.cos(Math.toRadians(d.doubleValue())))  , mc15);
        }
    }

    public static BigDecimal tan(BigInteger degrees) {
        return tan(new BigDecimal(degrees));
    }

    public static BigDecimal tan(BigDecimal degrees) {
        BigDecimal d = degrees.remainder(d360);
        if ((d.compareTo(d90) == 0) || (d.compareTo(d90.negate()) == 0) || (d.compareTo(d270) == 0) || (d.compareTo(d270.negate()) == 0)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_TANGENT_NOT_DEFINED_FOR_THIS_ANGLE, InterpreterUtils.toPrintableString(d)));
        }
        return sin(d).divide(cos(d), mc15);
    }

    public static BigInteger intPart(BigDecimal n){
        return n.toBigInteger();
    }

    public static BigInteger intPart(BigInteger n){
        return n;
    }

    public static BigDecimal abs(BigDecimal n){
        return n.abs();
    }

    public static BigInteger abs(BigInteger n){
        return n.abs();
    }

    public static BigDecimal sqrt(BigDecimal n){
        if(n.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }else if (n.compareTo(BigDecimal.ZERO) > 0) {
            double d = n.doubleValue();
            if(d==Double.POSITIVE_INFINITY){
                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_SQRT_FOR_A_NUMBER_THIS_BIG, InterpreterUtils.toPrintableString(n)));
            }else{
                return new BigDecimal(Double.toString(Math.sqrt(d)));
            }
        }else{
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_SQRT_FOR_NEGATIVE_NUMBER, InterpreterUtils.toPrintableString(n)));
        }
    }

    public static BigDecimal sqrt(BigInteger n){
        return sqrt(new BigDecimal(n));
    }


    public static BigDecimal log(BigDecimal n){
        if (n.compareTo(BigDecimal.ZERO) > 0) {
            double d = n.doubleValue();
            if(d==Double.POSITIVE_INFINITY){
                throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_LN_FOR_A_NUMBER_THIS_BIG, InterpreterUtils.toPrintableString(n)));
            }else{
                return new BigDecimal(Double.toString(Math.log(d)));
            }
        }else{
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_LN_FOR_NEGATIVE_NUMBER, InterpreterUtils.toPrintableString(n)));
        }
    }

    public static BigDecimal log(BigInteger n){
        return log(new BigDecimal(n));
    }

    public static BigDecimal exp(BigDecimal n){
        
        double d = n.doubleValue();
        if(d==Double.POSITIVE_INFINITY){
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_COMPUTE_EXP_FOR_A_NUMBER_THIS_BIG, InterpreterUtils.toPrintableString(n)));
        }if(d==Double.NEGATIVE_INFINITY){
            return BigDecimal.ZERO;
        }else{
            return new BigDecimal(Double.toString(Math.exp(d)));
        }
        
    }

    public static BigDecimal exp(BigInteger n){
        return exp(new BigDecimal(n));
    }


    /*public static void main(String[] args) {

        for (int i = 0; i <= 360; i++) {
            BigInteger bi = new BigInteger(String.valueOf(i));
            System.out.print("ΣΥΝ(" + i + ") : " + cos(bi) + "\t\t" + "ΗΜ(" + i + ")  : " + sin(bi));
            try {
                System.out.println("\t\t" + "ΕΦ(" + i + ")  : " + tan(bi));
            } catch (Exception e) {
                System.out.println("\t\t" + "ΕΦ(" + i + ")  : " + e.getMessage());
            }
        }

    }*/
}
