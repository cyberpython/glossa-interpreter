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

package glossa.interpreter.symboltable.symbols;

import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.types.Type;


/**
 *
 * @author cyberpython
 */
public abstract class RuntimeSimpleSymbol extends RuntimeSymbol{

    private Object value;

    public RuntimeSimpleSymbol(Symbol s) {
        super(s);
        Type type = super.getType();
        if(type!=null){
            this.value = type.getInitializationValue();
        }
    }

    @Override
    public void setType(Type type) {
        super.setType(type);
        if(type!=null){
            this.setValue(type.getInitializationValue());
        }
        this.setInitialized(false);
    }



    /**
     * @return the value
     */
    public Object getValue() {
        if( ! this.isInitialized() ){
            throw new RuntimeException(this.getName()+" has not been initialized.");//TODO: proper runtime error report
        }else{
            return value;
        }
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
        this.setInitialized(true);
    }

}
