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
import glossa.interpreter.symboltable.symbols.RuntimeArrayItemWrapper;
import glossa.interpreter.symboltable.symbols.RuntimeSymbol;
import glossa.interpreter.symboltable.symbols.RuntimeVariable;
import glossa.messages.Messages;
import glossa.messages.RuntimeMessages;
import glossa.statictypeanalysis.scopetable.scopes.SubProgramScope;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class ProcedureSymbolTable extends SubProgramSymbolTable{
    public ProcedureSymbolTable(SubProgramScope s, List<Object> actualParameters) {
        super(s, actualParameters);
    }

    public void restore(){
        List<Object> actualParams = this.getActualParameters();
        List<RuntimeSymbol> params = this.getParameters();
        for (int i = 0; i < actualParams.size(); i++) {
            Object object = actualParams.get(i);
            if(object !=null){
                if(object instanceof RuntimeVariable){
                    RuntimeVariable var = (RuntimeVariable) object;
                    var.setValue(  ( (RuntimeVariable) this.referenceSymbol(params.get(i).getName(), params.get(i).getPosition()) ).getValue()  );
                }else if(object instanceof RuntimeArray){
                    RuntimeArray arr = (RuntimeArray) object;
                    arr.setValues( ( (RuntimeArray) this.referenceSymbol(params.get(i).getName(), params.get(i).getPosition()) ).getValues() );
                }else if(object instanceof RuntimeArrayItemWrapper){
                    RuntimeArrayItemWrapper raiw = (RuntimeArrayItemWrapper) object;
                    RuntimeArray arr = raiw.getArray();
                    arr.set(raiw.getIndex(), ( (RuntimeVariable) this.referenceSymbol(params.get(i).getName(), params.get(i).getPosition()) ).getValue() );
                }
            }
        }
    }

    @Override
    public void print(PrintStream out){
        out.println(RuntimeMessages.CONST_STR_PROCEDURE+": "+this.getName());
        out.println(RuntimeMessages.CONST_STR_PARAMETERS+": "+Messages.formalParametersNamesToString(this.getSubprogramScope().getFormalParameters()));
        super.print(out);
    }
}
