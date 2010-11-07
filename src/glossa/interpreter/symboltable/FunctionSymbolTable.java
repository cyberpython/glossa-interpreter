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

import glossa.interpreter.core.InterpreterUtils;
import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.scopes.FunctionScope;
import glossa.statictypeanalysis.scopetable.scopes.SubProgramScope;
import glossa.types.Type;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class FunctionSymbolTable extends SubProgramSymbolTable{
    
    private Object returnValue;

    public FunctionSymbolTable(SubProgramScope s, List<Object> actualParameters) {
        super(s, actualParameters);
        this.returnValue = null;
        this.setName(s.getSubprogramName());
    }

    /**
     * @return the returnValue
     */
    public Object getReturnValue() {
        return returnValue;
    }

    /**
     * @param returnValue the returnValue to set
     */
    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public boolean checkName(String name){
        if(this.getName().toLowerCase().equals(name.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public void print(PrintStream out){
        out.println("ΣΥΝΑΡΤΗΣΗ: "+this.getName()+" : "+Messages.typeToString(((FunctionScope)this.getSubprogramScope()).getReturnType()));//TODO:message
        out.println("ΠΑΡΑΜΕΤΡΟΙ: "+Messages.formalParametersNamesToString(this.getSubprogramScope().getFormalParameters()));//TODO:message
        out.println("ΤΙΜΗ ΕΠΙΣΤΡΟΦΗΣ: "+InterpreterUtils.toPrintableString(this.returnValue));//TODO:message
        super.print(out);
    }

}
