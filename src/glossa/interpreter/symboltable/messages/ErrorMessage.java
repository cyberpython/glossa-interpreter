/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable.messages;

import java.awt.Point;

/**
 *
 * @author cyberpython
 */
public class ErrorMessage extends InterpreterMessage{

    public ErrorMessage(Point point, String msg) {
        super(point, msg);
    }

}
