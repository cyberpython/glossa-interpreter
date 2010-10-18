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
public class InterpreterMessage {

    private Point point;
    private String msg;

    public InterpreterMessage() {
        this(new Point(0, 0), "");
    }

    public InterpreterMessage(Point point, String msg) {
        this.point = point;
        this.msg = msg;
    }





    /**
     * @return the point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
