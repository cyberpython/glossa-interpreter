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
package glossa.interpreter.symboltable;

import glossa.interpreter.symboltable.symbols.RuntimeArray;
import glossa.interpreter.symboltable.symbols.RuntimeConstant;
import glossa.interpreter.symboltable.symbols.RuntimeSymbol;
import glossa.interpreter.symboltable.symbols.RuntimeVariable;
import glossa.statictypeanalysis.scopetable.scopes.Scope;
import glossa.statictypeanalysis.scopetable.symbols.Array;
import glossa.statictypeanalysis.scopetable.symbols.Constant;
import glossa.statictypeanalysis.scopetable.symbols.Symbol;
import glossa.statictypeanalysis.scopetable.symbols.Variable;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author cyberpython
 */
public class SymbolTable {

    private HashMap<String, RuntimeSymbol> symbols;

    public SymbolTable(Scope s) {
        this.symbols = new HashMap<String, RuntimeSymbol>();
        this.copySymbolsFromScope(s);
    }

    private void copySymbolsFromScope(Scope scope) {
        if (scope != null) {
            HashMap<String, Symbol> scopeSymbols = scope.getSymbols();
            Set<String> keys = scopeSymbols.keySet();
            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                String key = it.next();
                Symbol original = scopeSymbols.get(key);
                RuntimeSymbol value = copyFromScope(original);
                if (value != null) {
                    this.symbols.put(key, value);
                }
            }
        }
    }

    private RuntimeSymbol copyFromScope(Symbol original) {
        if (original == null) {
            //TODO: Proper runtime error report
            return null;
        } else {
            if (original instanceof Constant) {
                return new RuntimeConstant((Constant) original);
            } else if (original instanceof Variable) {
                return new RuntimeVariable((Variable) original);
            } else if (original instanceof Array) {
                return new RuntimeArray((Array) original);
            } else {
                return null;
            }
        }
    }

    public RuntimeSymbol referenceSymbol(String symbolName, Point referencePosition) {
        RuntimeSymbol symbol = this.getSymbols().get(symbolName.toLowerCase());
        if (symbol == null) {
            //TODO: Proper runtime error report
            return null;
        } else {
            return symbol;
        }
    }

    /**
     * @return the symbols
     */
    public HashMap<String, RuntimeSymbol> getSymbols() {
        return symbols;
    }

    /**
     * @param symbols the symbols to set
     */
    public void setSymbols(HashMap<String, RuntimeSymbol> symbols) {
        this.symbols = symbols;
    }
}
