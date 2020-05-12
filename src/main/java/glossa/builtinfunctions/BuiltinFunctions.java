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
package glossa.builtinfunctions;

import glossa.types.Type;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class BuiltinFunctions {

    public static boolean isBuiltinFunctionName(String functionName) {
        if (functionName == null) {
            return false;
        }
        String funcId = functionName.toUpperCase();
        if (funcId.equals("ΗΜ") || funcId.equals("ΣΥΝ") || funcId.equals("ΕΦ")
                || funcId.equals("Τ_Ρ") || funcId.equals("ΛΟΓ") || funcId.equals("Ε")
                || funcId.equals("Α_Μ") || funcId.equals("Α_Τ")) {
            return true;
        }
        return false;
    }
    
    public static Type getReturnTypeForBuiltinFuntion(String functionName, Type parameterType) {
        if ((functionName == null)||(parameterType==null)) {
            return null;
        }
        String funcId = functionName.toUpperCase();
        if (funcId.equals("ΗΜ") || funcId.equals("ΣΥΝ") || funcId.equals("ΕΦ")
                || funcId.equals("Τ_Ρ") || funcId.equals("ΛΟΓ") || funcId.equals("Ε") ){
            if(parameterType.equals(Type.INTEGER) || parameterType.equals(Type.REAL) ){
                return Type.REAL;
            }else{
                return null;
            }
        }else if (funcId.equals("Α_Τ")){
            if(parameterType.equals(Type.INTEGER)){
                return Type.INTEGER;
            }else if(parameterType.equals(Type.REAL)){
                return Type.REAL;
            }else{
                return null;
            }
        }else if (funcId.equals("Α_Μ")){
            if(parameterType.equals(Type.INTEGER) || parameterType.equals(Type.REAL)){
                return Type.INTEGER;
            }else{
                return null;
            }
        }
        return null;
    }


}
