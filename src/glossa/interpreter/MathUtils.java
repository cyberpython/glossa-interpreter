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

    public static BigDecimal tan(double degrees) {
        return tan(new BigDecimal(degrees, mc15));
    }

    public static BigDecimal tan(BigInteger degrees) {
        return tan(new BigDecimal(degrees, mc15));
    }

    public static BigDecimal tan(BigDecimal degrees) {
        BigDecimal d = degrees.remainder(d360);
        if((d.compareTo(d90)==0) || (d.compareTo(d90.negate())==0) || (d.compareTo(d270)==0) || (d.compareTo(d270.negate())==0) ){
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_TANGENT_NOT_DEFINED_FOR_THIS_ANGLE, d.toPlainString()));
        }
        return sin(d).divide(cos(d), mc15);
    }


    public static BigDecimal sin(double degrees) {
        return sin(new BigDecimal(degrees, mc15));
    }

    public static BigDecimal sin(BigInteger degrees) {
        return sin(new BigDecimal(degrees, mc15));
    }

    public static BigDecimal sin(BigDecimal degrees) {
        BigDecimal d = degrees.remainder(d360, mc15);
        if((d.compareTo(BigDecimal.ZERO)==0)||(d.compareTo(d180)==0)||(d.compareTo(d360)==0)){
            return BigDecimal.ZERO;
        }else if(d.compareTo(d90)==0){
            return BigDecimal.ONE;
        }else if(d.compareTo(d270)==0){
            return BigDecimal.ONE.negate(mc15);
        }else{
            return cos(d90.subtract(d, mc15));
        }
    }


    public static BigDecimal cos(double d) {
        return cos(new BigDecimal(d, mc15));
    }

    public static BigDecimal cos(BigInteger d) {
        return cos(new BigDecimal(d, mc15));
    }

    public static BigDecimal cos(BigDecimal degrees) {
        int signFactor = 1;
        BigDecimal d = degrees.remainder(d360, mc15).abs(mc15);

        if (  (d.compareTo(d90)>0) && (d.compareTo(d180)<0)   ) {
            d = d180.subtract(d, mc15);
            signFactor = -1;
        } else if (   (d.compareTo(d180)>0) && (d.compareTo(d270)<0)  ) {
            d = d.subtract(d180, mc15);
            signFactor = -1;
        } else if (   (d.compareTo(d270)>0) && (d.compareTo(d360)<0)  ) {
            d = d360.subtract(d, mc15);
            signFactor = 1;
        }

        if((d.compareTo(BigDecimal.ZERO)==0)||(d.compareTo(d360)==0)){
            return BigDecimal.ONE;
        }else if((d.compareTo(d180)==0)){
            return BigDecimal.ONE.negate(mc15);
        }else if((d.compareTo(d90)==0)||(d.compareTo(d270)==0)){
            return BigDecimal.ZERO;
        }else{
            return new BigDecimal(    signFactor *  Math.cos(Math.toRadians(d.doubleValue()))  , mc15);
        }
    }


    public static void main(String[] args){

                for(double i=0; i<=360; i++){
                    System.out.print("ΣΥΝ("+i+") : "+cos(i)+"\t\t"+"ΗΜ("+i+")  : "+sin(i));
                    try{
                        System.out.println("\t\t"+"ΕΦ("+i+")  : "+tan(i));
                    }catch(Exception e){
                        System.out.println("\t\t"+"ΕΦ("+i+")  : "+e.getMessage());
                    }
                }

        }


}
