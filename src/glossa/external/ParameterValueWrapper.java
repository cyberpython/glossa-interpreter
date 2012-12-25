/*
 * The MIT License
 *
 * Copyright 2012 cyberpython.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package glossa.external;

import glossa.interpreter.symboltable.symbols.ValueContainer;
import glossa.types.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author cyberpython
 */
public class ParameterValueWrapper implements ValueContainer{
    
    private Object value;

    public ParameterValueWrapper(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        if(value == null){
            return null;
        }else if(value instanceof BigInteger){
            return Type.INTEGER;
        }else if(value instanceof BigDecimal){
            return Type.REAL;
        }else if(value instanceof String){
            return Type.STRING;
        }else if(value instanceof Boolean){
            return Type.BOOLEAN;
        }
        return null;
    }
    
    
    
}
