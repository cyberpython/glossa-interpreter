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

package glossa.statictypeanalysis.scopetable.scopes;

import glossa.messages.MessageLog;
import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import java.awt.Point;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author cyberpython
 */
public class Scope {

    private HashMap<String, Symbol> symbols;
    private boolean constantsDeclared;
    private boolean variablesDeclared;
    private Point constantsDeclarationPoint;
    private Point variablesDeclarationPoint;

    public Scope() {
        this.symbols = new HashMap<String, Symbol>();
        this.constantsDeclared = false;
        this.variablesDeclared = false;
    }

    public void defineSymbol(MessageLog msgLog, String searchKey, Symbol s) {
        String key = searchKey.toLowerCase();
        Symbol existingSymbol = getSymbols().get(key);
        if (existingSymbol != null) {
            Messages.symbolRedefinitionError(msgLog, s, existingSymbol);
        } else {
            this.getSymbols().put(key, s);
        }
    }

    public Symbol referenceSymbol(MessageLog msgLog, String symbolName, Point referencePosition) {
        String key = symbolName.toLowerCase();
        Symbol symbol = this.getSymbols().get(key);
        if (symbol == null) {
            Messages.symbolUndefinedError(msgLog, symbolName, referencePosition);
            return null;
        } else {
            return symbol;
        }
    }

    /**
     * @return the constantsDeclared
     */
    public boolean isConstantsDeclared() {
        return constantsDeclared;
    }

    /**
     * @param constantsDeclared the constantsDeclared to set
     */
    public void setConstantsDeclared(boolean constantsDeclared) {
        this.constantsDeclared = constantsDeclared;
    }

    /**
     * @return the variablesDeclared
     */
    public boolean isVariablesDeclared() {
        return variablesDeclared;
    }

    /**
     * @param variablesDeclared the variablesDeclared to set
     */
    public void setVariablesDeclared(boolean variablesDeclared) {
        this.variablesDeclared = variablesDeclared;
    }

    /**
     * @return the constantsDeclarationPoint
     */
    public Point getConstantsDeclarationPoint() {
        return constantsDeclarationPoint;
    }

    /**
     * @param constantsDeclarationPoint the constantsDeclarationPoint to set
     */
    public void setConstantsDeclarationPoint(Point constantsDeclarationPoint) {
        this.constantsDeclarationPoint = constantsDeclarationPoint;
    }

    /**
     * @return the variablesDeclarationPoint
     */
    public Point getVariablesDeclarationPoint() {
        return variablesDeclarationPoint;
    }

    /**
     * @param variablesDeclarationPoint the variablesDeclarationPoint to set
     */
    public void setVariablesDeclarationPoint(Point variablesDeclarationPoint) {
        this.variablesDeclarationPoint = variablesDeclarationPoint;
    }

    /**
     * @return the symbols
     */
    public HashMap<String, Symbol> getSymbols() {
        return symbols;
    }

    /**
     * @param symbols the symbols to set
     */
    public void setSymbols(HashMap<String, Symbol> symbols) {
        this.symbols = symbols;
    }


    public void print(PrintStream out){
        out.println(" "+Messages.CONSTS_STR_CONSTANTS+" & "+Messages.CONSTS_STR_VARIABLES+": ");
        Set<String> keys = symbols.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            String key = it.next();
            Symbol s = symbols.get(key);
            out.println("\t"+s.toString());
        }
        out.println("---------------------------------------------------------------------");
        out.println();
        out.println();
    }
}
