/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

/**
 *
 * @author cyberpython
 */
public class Constant extends SimpleSymbol{

    public Constant(String name, Type type, int line, int pos, int absolutePosition, Object value) {
        super(name, type, line, pos, absolutePosition, value);
    }

    @Override
    public String toString() {
        return "Constant "+super.toString();
    }

}
