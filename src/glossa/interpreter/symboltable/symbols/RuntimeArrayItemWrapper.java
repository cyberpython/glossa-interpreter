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

import glossa.types.Type;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class RuntimeArrayItemWrapper implements ValueContainer {

    private RuntimeArray arr;
    private List<Integer> index;

    public RuntimeArrayItemWrapper(RuntimeArray arr, List<Integer> index) {
        this.arr = arr;
        this.index = index;
    }

    public RuntimeArray getArray() {
        return arr;
    }

    public List<Integer> getIndex() {
        return index;
    }

    public void setArray(RuntimeArray arr) {
        this.arr = arr;
    }

    public void setIndex(List<Integer> index) {
        this.index = index;
    }

    public Object getValue() {
        return arr.get(index);
    }

    public void setValue(Object value) {
        arr.set(index, value);
    }

    public Type getType() {
        return arr.getType();
    }
}
