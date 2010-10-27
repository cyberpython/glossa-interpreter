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

import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.types.Type;
import java.awt.Point;



/**
 *
 * @author cyberpython
 */
public class RuntimeSymbol implements Comparable<RuntimeSymbol>{

    private String name;
    private Type type;

    private int line;
    private int pos;
    private int absolutePosition;

    private boolean initialized;


    public RuntimeSymbol(Symbol s){
        this.name = s.getName();
        this.type = s.getType();
        this.line = s.getLine();
        this.pos = s.getPos();
        this.absolutePosition = s.getAbsolutePosition();
        this.initialized = false;
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
        return Messages.CONSTS_STR_NAME+": "+this.getName()+", "+Messages.CONSTS_STR_TYPE+": "+this.type.toString()+", "+Messages.CONSTS_STR_DECLARED_AT+": ("+this.getPositionAsString()+")";
    }

    public int compareTo(RuntimeSymbol o) {
        return this.name.compareTo(o.getName());
    }

    /**
     * @return if the symbol has been initialized
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * @param initialized boolean value to set if the symbol has been initialized
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }


}
