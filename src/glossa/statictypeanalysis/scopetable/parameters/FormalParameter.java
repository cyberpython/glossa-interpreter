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

package glossa.statictypeanalysis.scopetable.parameters;

import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.types.Type;
import glossa.utils.Point;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class FormalParameter implements Comparable<FormalParameter>{

    private int line;
    private int pos;
    private String name;

    private Type type;
    private Symbol symbol;
    private boolean arrayParamFlagSet;

    public FormalParameter(int line, int pos, String name) {
        this.line = line;
        this.pos = pos;
        this.name = name;
        this.type = null;
        this.symbol = null;
        this.arrayParamFlagSet = false;
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


    public Point getPosition(){
        return new Point(this.line, this.pos);
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isArrayParamFlagSet() {
        return arrayParamFlagSet;
    }

    public void setArrayParamFlagSet(boolean arrayParamFlagSet) {
        this.arrayParamFlagSet = arrayParamFlagSet;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    

    public int compareTo(FormalParameter o) {
        return this.name.toLowerCase().compareTo(o.getName().toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if((obj!=null)&&(obj instanceof FormalParameter)){
            return this.name.toLowerCase().equals(((FormalParameter)obj).getName().toLowerCase());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return Messages.CONSTS_STR_PARAMETER +" "+ Messages.CONSTS_STR_NAME+": "+this.name +" : " + Messages.typeToString(type);
    }

    

}
