/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

/**
 *
 * @author cyberpython
 */
public class SimpleSymbol extends Symbol{

    private Object value;

    public SimpleSymbol(String name, Type type, int line, int pos, int absolutePosition, Object value) {
        super(name, type, line, pos, absolutePosition);
        this.value = value;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

}
