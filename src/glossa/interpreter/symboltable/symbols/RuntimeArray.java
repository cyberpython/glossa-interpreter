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

import glossa.interpreter.InterpreterUtils;
import glossa.messages.Messages;
import glossa.messages.RuntimeMessages;
import glossa.statictypeanalysis.scopetable.symbols.Array;
import glossa.types.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author cyberpython
 */
public class RuntimeArray extends RuntimeSymbol {
    private List<Integer> dimensions;
    private int dimensionsCount;
    private int[] colSizes;
    private Object[] values;

    public RuntimeArray(Array a) {
        super(a);
        this.dimensionsCount = a.getNumberOfDimensions();
        this.dimensions = null;
    }

    public RuntimeArray(Array a, List<Integer> dimensions) {
        super(a);
        this.dimensions = dimensions;
        this.dimensionsCount = this.dimensions.size();
        this.initialize();
    }

    private void initialize() {
        this.initColSizes();
        Object defaultVaule = null;
        Type t = this.getType();
        if (t != null) {
            defaultVaule = t.getInitializationValue();
        }
        this.initValues(defaultVaule);
        this.setInitialized(true);
    }

    private void initColSizes() {
        this.colSizes = new int[dimensions.size()];
        colSizes[colSizes.length - 1] = 1;
        int product = 1;
        for (int i = colSizes.length - 1; i > 0; i--) {
            colSizes[i - 1] = dimensions.get(i) * product;
            product = product * dimensions.get(i);
        }
    }

    public void initValues(Object initialValue) {
        int totalSize = 1;
        for (Iterator<Integer> it = dimensions.iterator(); it.hasNext();) {
            Integer integer = it.next();
            totalSize *= integer;
        }
        this.values = new Object[totalSize];
        for (int i = 0; i < values.length; i++) {
            values[i] = initialValue;
        }
    }

    private int resolveIndex(List<Integer> indices) {
        int result = -1;
        int numberOfDimensions = dimensions.size();
        if (indices.size() == numberOfDimensions) {
            result = 0;
            int index = -1;
            int d = 1;
            int j = 0;
            for (int i = 0; i < numberOfDimensions; i++) {
                index = indices.get(i).intValue();
                if (index < 1 || index > dimensions.get(i).intValue()) {
                    throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_INDEX_OUT_OF_BOUNDS,  Messages.arrayIndexToString(indices), this.getName()));
                } else {
                    d = colSizes[i];
                    j = index;
                    result = result + (j - 1) * d;
                }
            }
        } else {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_INDICES_AND_DIMENSIONS_MISMATCH,  indices.size(), this.getName(), this.getDimensions().size()));
        }
        return result;
    }

    public Object get(List<Integer> indices) {
        return this.values[resolveIndex(indices)];
    }

    public void set(List<Integer> indices, Object value) {
        if ((value instanceof BigInteger) && this.getType().equals(Type.INTEGER)) {
            this.values[resolveIndex(indices)] = value;
        } else if ((value instanceof BigDecimal) && this.getType().equals(Type.REAL)) {
            this.values[resolveIndex(indices)] = value;
        } else if ((value instanceof Boolean) && this.getType().equals(Type.BOOLEAN)) {
            this.values[resolveIndex(indices)] = value;
        } else if ((value instanceof String) && this.getType().equals(Type.STRING)) {
            this.values[resolveIndex(indices)] = value;
        } else {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_TYPE_FOR_ASSIGNMENT,  InterpreterUtils.toPrintableString(value), this.getType().toString()));
        }
    }


    private void set(int index, Object value) {
        if ((value instanceof BigInteger) && this.getType().equals(Type.INTEGER)) {
            this.values[index] = new BigInteger(((BigInteger)value).toString());
        } else if ((value instanceof BigDecimal) && this.getType().equals(Type.REAL)) {
            this.values[index] = new BigDecimal(((BigDecimal)value).toString());
        } else if ((value instanceof Boolean) && this.getType().equals(Type.BOOLEAN)) {
            this.values[index] = new Boolean(((Boolean)value).toString());
        } else if ((value instanceof String) && this.getType().equals(Type.STRING)) {
            this.values[index] = new String(((String)value).toString());
        } else {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_INVALID_TYPE_FOR_ASSIGNMENT,  InterpreterUtils.toPrintableString(value), this.getType().toString()));
        }
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) { //FIXME: check array size
        for (int i = 0; i < values.length; i++) {
            Object value = values[i];
            this.set(i, value);
        }
    }

    @Override
    public void setType(Type type) {
        super.setType(type);
        this.initialize();
    }

    /**
     * @return the dimensions
     */
    public List<Integer> getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(List<Integer> dimensions) {
        this.dimensions = dimensions;
        this.dimensionsCount = this.dimensions.size();
        this.initialize();
    }

    /**
     * @return the number of dimensions
     */
    public int getNumberOfDimensions() {
        return this.dimensionsCount;
    }

    @Override
    public String toString() {
        return Messages.CONSTS_STR_ARRAY + " " + super.toString() + " - " + Messages.CONSTS_STR_DIMENSIONS + ": " + this.dimensionsCount;
    }
}
