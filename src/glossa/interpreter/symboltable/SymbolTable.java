/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

import glossa.interpreter.utils.ErrorUtils;
import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author cyberpython
 */
public class SymbolTable {
    private HashMap<String, Symbol> symbols;
    private boolean constantsDeclared;
    private boolean variablesDeclared;
    private Point constantsDeclarationPoint;
    private Point variablesDeclarationPoint;

    public SymbolTable(){
        this.symbols = new HashMap<String, Symbol>();
        this.constantsDeclared = false;
        this.variablesDeclared = false;
    }

    public void defineSymbol(String key, Symbol s){
        Symbol existingSymbol = symbols.get(key);
        if(existingSymbol!=null){
           ErrorUtils.symbolRedefinitionError(s, existingSymbol);
        }else{
            this.symbols.put(key, s);
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

    


}
