/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package glossa.interpreter.symboltable;

/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;*/
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class Array extends Symbol {

    ///private HashMap<String, Object> values;
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
        StringBuilder dim = new StringBuilder();
        for (Iterator<Integer> it = dimensions.iterator(); it.hasNext();) {
            Integer integer = it.next();
            dim.append(String.valueOf(integer));
            if(it.hasNext()){
                    dim.append("x");
            }
        }
        return ReportingAndMessagingUtils.CONSTS_STR_ARRAY+" ["+dim.toString()+"] "+super.toString();
    }

    /*public void initValues(List<Integer> dimensions, Object initialValue) {

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
    }*/
}
