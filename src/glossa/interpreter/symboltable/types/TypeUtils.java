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
package glossa.interpreter.symboltable.types;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class TypeUtils {

    /**
     * @return an integer indicating the compatibility between the types
     * <ul>
     * <li>0  if the types are equal</li>
     * <li>1  if they are not equal but compatible (real <- integer)</li>
     * <li>-1 if they are incompatible</li>
     * </ul>
     */
    public static int areTypesCompatibleForAssignment(Type type1, Type type2) {
        if(type1==null || type2==null){return -1;}
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
        if(type1==null || type2==null){return null;}
        if(type1.equals(type2)){
            return type1;
        }else{
            if(isNumericType(type1) && isNumericType(type2)){
                if(type1.equals(Type.REAL) || type2.equals(Type.REAL)){
                    return Type.REAL;
                }else{
                    return Type.INTEGER;
                }
            }else{
                return null;
            }
        }
    }

    public static boolean isNumericType(Type type) {
        if(type==null){return false;}
        if (type.equals(Type.REAL) || type.equals(Type.INTEGER)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForArithmeticExpression(Type type1, Type type2) {
        if(type1==null || type2==null){return false;}
        if (isNumericType(type1) && isNumericType(type2)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForBooleanExpression(Type type1, Type type2) {
        if(type1==null || type2==null){return false;}
        if (type1.equals(Type.BOOLEAN) && type2.equals(Type.BOOLEAN)) {
            return true;
        }
        return false;
    }

    public static boolean checkTypesForEqualityExpression(Type type1, Type type2) {
        if(type1==null || type2==null){return false;}
        if (type1.equals(type2)) {
            return true;
        } else if (isNumericType(type1) && isNumericType(type2)) {
            return true;
        }
        return false;
    }
}
