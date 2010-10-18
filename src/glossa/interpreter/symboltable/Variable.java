/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

/**
 *
 * @author cyberpython
 */
public class Variable extends SimpleSymbol{

    public Variable(String name, Type type, int line, int pos, int absolutePosition, Object value) {
        super(name, type, line, pos, absolutePosition, value);
    }

    public Variable(String name, int line, int pos, int absolutePosition, Object value) {
        super(name, Type.INTEGER, line, pos, absolutePosition, value);
    }

    @Override
    public String toString() {
        return ReportingAndMessagingUtils.CONSTS_STR_VARIABLE+" "+super.toString();
    }



}
