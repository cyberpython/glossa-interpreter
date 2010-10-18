/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

import java.awt.Point;

/**
 *
 * @author cyberpython
 */
public class Symbol implements Comparable<Symbol>{

    private String name;
    private Type type;

    private int line;
    private int pos;
    private int absolutePosition;

    public Symbol(String name, Type type, int line, int pos, int absolutePosition){
        this.name = name;
        this.type = type;
        this.line = line;
        this.pos = pos;
        this.absolutePosition = absolutePosition;
    }



    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the position as a Point(line, char)
     */
    public Point getPosition() {
        return new Point(getLine(), getPos());
    }

    /**
     * @return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * @return the pos
     */
    public int getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * @return the absolutePosition
     */
    public int getAbsolutePosition() {
        return absolutePosition;
    }

    /**
     * @param absolutePosition the absolutePosition to set
     */
    public void setAbsolutePosition(int absolutePosition) {
        this.absolutePosition = absolutePosition;
    }

    public String getPositionAsString(){
        return this.line+","+(this.pos+1);
    }

    @Override
    public String toString() {
        return ReportingAndMessagingUtils.CONSTS_STR_NAME+": "+this.getName()+", "+ReportingAndMessagingUtils.CONSTS_STR_TYPE+": "+this.type.toString()+"\t - "+ReportingAndMessagingUtils.CONSTS_STR_DECLARED_AT+": "+this.getPositionAsString();
    }

    public int compareTo(Symbol o) {
        return this.name.compareTo(o.getName());
    }


}
