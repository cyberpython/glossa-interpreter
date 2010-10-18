/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package glossa.interpreter.symboltable;

/**
 *
 * @author cyberpython
 */
public enum Type {
    INTEGER, REAL, BOOLEAN, STRING;

    @Override
    public String toString() {
        if(this.equals(Type.INTEGER)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_INTEGER;
        }else if(this.equals(Type.REAL)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_REAL;
        }else if(this.equals(Type.BOOLEAN)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_BOOLEAN;
        }else{
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_STRING;
        }
    }

}
