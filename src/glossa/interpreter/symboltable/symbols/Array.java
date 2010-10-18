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

import glossa.interpreter.messages.ReportingAndMessagingUtils;
import glossa.interpreter.symboltable.types.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class Array extends Symbol {

    private HashMap<String, Object> values;
    private List<Integer> dimensions;

    public Array(String name, Type type, int line, int pos, int absolutePosition, List<Integer> dimensions) {
        super(name, type, line, pos, absolutePosition);
        this.dimensions = dimensions;
    }

    public Array(String name,int line, int pos, int absolutePosition, List<Integer> dimensions) {
        super(name, Type.INTEGER, line, pos, absolutePosition);
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        /*StringBuilder dim = new StringBuilder();
        for (Iterator<Integer> it = dimensions.iterator(); it.hasNext();) {
            Integer integer = it.next();
            dim.append(String.valueOf(integer));
            if(it.hasNext()){
                    dim.append("x");
            }
        }*/
        return ReportingAndMessagingUtils.CONSTS_STR_ARRAY+" - "+ReportingAndMessagingUtils.CONSTS_STR_DIMENSIONS+": "+getDimensions().size()+"\t"+super.toString();
    }

    public void initValues(List<Integer> dimensions, Object initialValue) {

        int numberOfDimensions = dimensions.size();
        List<List<String>> tmp = new ArrayList<List<String>>();

        for (int i = 0; i < numberOfDimensions; i++) {
            ArrayList<String> dim = new ArrayList<String>();
            for (int j = 0; j < dimensions.get(i); j++) {
                dim.add(String.valueOf(j));
            }
            tmp.add(dim);
        }

        List<String> result = new ArrayList<String>();
        Iterator<List<String>> it = tmp.iterator();

        List<String> firstDimension = it.next();
        for (Iterator<String> it1 = firstDimension.iterator(); it1.hasNext();) {
            String str = it1.next();
            result.add(str);
        }


        while (it.hasNext()) {
            List<String> dimension = it.next();
            List<String> newResult = new ArrayList<String>();
            for (Iterator<String> it1 = result.iterator(); it1.hasNext();) {
                String value = it1.next();
                for (Iterator<String> it2 = dimension.iterator(); it2.hasNext();) {
                    String str = it2.next();
                    newResult.add(value + "," + str);
                }
            }
            result = newResult;

        }
        
        for (Iterator<String> it1 = result.iterator(); it1.hasNext();) {
            String key = it1.next();
            this.values.put(key, initialValue);
        }
    }


    public Object getValue(String index){
        return this.values.get(index);
    }

    public void setValue(String index, Object value){
        this.values.put(index, value);
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
    }

    /**
     * @return the number of dimensions
     */
    public int getNumberOfDimensions() {
        return dimensions.size();
    }
}
