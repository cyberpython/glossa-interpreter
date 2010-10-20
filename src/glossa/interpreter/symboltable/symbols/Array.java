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

import glossa.interpreter.messages.Messages;
import glossa.interpreter.symboltable.types.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class Array extends Symbol {

    //private HashMap<String, Object> values;
    private List<Integer> dimensions;
    private int[] colSizes;
    private Object[] values;

    public Array(String name, Type type, int line, int pos, int absolutePosition, List<Integer> dimensions) {
        super(name, type, line, pos, absolutePosition);
        this.dimensions = dimensions;
        this.initialize();
    }

    public Array(String name, int line, int pos, int absolutePosition, List<Integer> dimensions) {
        super(name, null, line, pos, absolutePosition);
        this.dimensions = dimensions;
        this.initColSizes();
    }

    private void initialize(){
        this.initColSizes();
        Object defaultVaule;
        if(this.getType().equals(Type.INTEGER)){
            defaultVaule = new BigInteger("0");
        }else if(this.getType().equals(Type.REAL)){
            defaultVaule = new BigDecimal("0.0");
        }else if(this.getType().equals(Type.BOOLEAN)){
            defaultVaule = Boolean.valueOf(false);
        }else if(this.getType().equals(Type.STRING)){
            defaultVaule = "";
        }else{
            defaultVaule = null;
        }
        this.initValues(defaultVaule);
    }

    private void initColSizes() {
        this.colSizes = new int[dimensions.size()];
        colSizes[colSizes.length-1] = 1;
        int product = 1;
        for (int i = colSizes.length - 1; i > 0; i--) {
            colSizes[i-1] = dimensions.get(i) * product;
            product = product * dimensions.get(i);
        }
        //TODO: Remove:
        /*for (int i = 0; i < colSizes.length; i++) {
            System.out.println("colSize[" + i + "]: " + colSizes[i]);
        }*/
    }

    public String arrayIndexToString(List<Integer> indices) {
        StringBuilder dim = new StringBuilder();
        for (Iterator<Integer> it = indices.iterator(); it.hasNext();) {
            Integer integer = it.next();
            dim.append("[");
            dim.append(String.valueOf(integer));
            dim.append("]");
            /*if (it.hasNext()) {
                dim.append("x");
            }*/
        }
        return dim.toString();
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

    private int resolveIndex(List<Integer> indices){
        int result = -1;
        int dimensionsCount = dimensions.size();
        if(indices.size() == dimensionsCount){
            result = 0;
            int index = -1;
            int d = 1;
            int j = 0;
            for (int i = 0; i < dimensionsCount; i++) {
                index = indices.get(i);
                if(index<1 || index > dimensions.get(i)){
                    throw new RuntimeException(String.valueOf(index)+" at "+arrayIndexToString(indices));//TODO: Proper runtime error report
                }else{
                    d = colSizes[i];
                    j = index;
                    result = result + (j-1)*d;
                }
            }
        }else{
            throw new RuntimeException(arrayIndexToString(indices));//TODO: Proper runtime error report
        }
        return result;
    }

    public Object get(List<Integer> indices){
        return this.values[resolveIndex(indices)];
    }

    public void set(List<Integer> indices, Object value){
        if( (value instanceof BigInteger) && this.getType().equals(Type.INTEGER)){
            this.values[resolveIndex(indices)] = value;
        }else if( (value instanceof BigDecimal) && this.getType().equals(Type.REAL)){
            this.values[resolveIndex(indices)] = value;
        }else if( (value instanceof Boolean) && this.getType().equals(Type.BOOLEAN)){
            this.values[resolveIndex(indices)] = value;
        }else if( (value instanceof String) && this.getType().equals(Type.STRING)){
            this.values[resolveIndex(indices)] = value;
        }else{
            throw new RuntimeException("Invalid type in array assignment");//TODO: Proper runtime error report
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
        this.initialize();
    }

    /**
     * @return the number of dimensions
     */
    public int getNumberOfDimensions() {
        return dimensions.size();
    }

    @Override
    public String toString() {
        return Messages.CONSTS_STR_ARRAY + " - " + Messages.CONSTS_STR_DIMENSIONS + ": " + getDimensions().size() + "\t" + super.toString();
    }

    public static void main(String[] args) {
        List<Integer> dim = new ArrayList<Integer>();
        dim.add(3);
        dim.add(2);
        dim.add(4);
        Array arr = new Array("arr", Type.INTEGER, 1, 1, 1, dim);
        
        List<Integer> index = new ArrayList<Integer>();
        index.add(2);
        index.add(1);
        index.add(3);
        //System.out.println("\tarr[2,1,3]: "+arr.resolveIndex(index));

        System.out.println("\tarr[2,1,3]: "+arr.get(index));

    }
}
