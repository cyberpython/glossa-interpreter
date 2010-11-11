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
import glossa.interpreter.symboltable.symbols.RuntimeConstant;
import glossa.interpreter.symboltable.symbols.RuntimeSymbol;
import glossa.interpreter.symboltable.symbols.RuntimeVariable;
import glossa.messages.Messages;
import glossa.messages.RuntimeMessages;
import glossa.statictypeanalysis.scopetable.parameters.FormalParameter;
import glossa.statictypeanalysis.scopetable.scopes.SubProgramScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class SubProgramSymbolTable extends SymbolTable {

    private List<RuntimeSymbol> parameters;
    private List<Object> actualParameters;
    private SubProgramScope subprogramScope;

    public SubProgramSymbolTable(SubProgramScope s, List<Object> actualParameters) {
        super(s);
        this.setName(s.getSubprogramName());
        this.subprogramScope = s;
        this.actualParameters = actualParameters;
        associateFormalParametersWithRuntimeSymbols();
    }

    public int getIndex() {
        return subprogramScope.getIndex();
    }

    public List<Object> getActualParameters() {
        return actualParameters;
    }

    public List<RuntimeSymbol> getParameters() {
        return parameters;
    }

    public SubProgramScope getSubprogramScope() {
        return subprogramScope;
    }

    private void associateFormalParametersWithRuntimeSymbols() {
        if (this.subprogramScope != null) {
            this.parameters = new ArrayList<RuntimeSymbol>();
            List<FormalParameter> fparams = this.subprogramScope.getFormalParameters();
            for (Iterator<FormalParameter> it = fparams.iterator(); it.hasNext();) {
                FormalParameter formalParameter = it.next();
                RuntimeSymbol parameter = this.referenceSymbol(formalParameter.getName().toLowerCase(), formalParameter.getPosition());
                if ((parameter instanceof RuntimeVariable) || (parameter instanceof RuntimeArray)) {
                    this.parameters.add(parameter);
                } else {
                    throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_FOMRAL_PARAMS_MUST_BE_VARS_OR_ARRAYS);
                }
            }
        }else{}
    }

    public void passParameters(){
        if(this.actualParameters.size()==this.parameters.size()){
            for (int i = 0; i < this.actualParameters.size(); i++) {
                passParameterByValue(this.parameters.get(i), this.actualParameters.get(i));
            }
        }else{
            throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_PARAMS_AND_FOMRAL_PARAMS_COUNT_MISMATCH);
        }
    }

    private void passParameterByValue(RuntimeSymbol parameter, Object actualParam) {
        if (actualParam instanceof RuntimeConstant) { //parameter is a constant
            if (parameter instanceof RuntimeVariable) {
                ((RuntimeVariable) parameter).setValue(((RuntimeConstant) actualParam).getValue());
            } else {
                throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ASSIGN_VALUE_TO_ARRAY);
            }
        } else if (actualParam instanceof RuntimeVariable) { //parameter is a variable
            if (parameter instanceof RuntimeVariable) {
                ((RuntimeVariable) parameter).setValue(((RuntimeVariable) actualParam).getValue());
            } else {
                throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ASSIGN_VALUE_TO_ARRAY);
            }
        } else if (actualParam instanceof RuntimeArray) { //parameter is an array
            if (parameter instanceof RuntimeArray) {
                this.copyArrayItems((RuntimeArray) actualParam, (RuntimeArray) parameter);
            } else {
                throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ASSIGN_ARRAY_TO_VAR);
            }
        } else if (actualParam instanceof RuntimeArrayItemWrapper) { //parameter is an array
            if (parameter instanceof RuntimeVariable) {
                RuntimeArrayItemWrapper raiw = (RuntimeArrayItemWrapper) actualParam;
                ((RuntimeVariable) parameter).setValue(raiw.getArray().get(raiw.getIndex()));
            } else {
                throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ASSIGN_VALUE_TO_ARRAY);
            }
        } else { //parameter is an expression result
            if (parameter instanceof RuntimeVariable) {
                ((RuntimeVariable) parameter).setValue(actualParam);
            } else {
                throw new RuntimeException(RuntimeMessages.STR_RUNTIME_ERROR_CANNOT_ASSIGN_VALUE_TO_ARRAY);
            }
        }
    }

    protected void copyArrayItems(RuntimeArray original, RuntimeArray copy) {
        List<Integer> origDims = original.getDimensions();
        List<Integer> copyDims = copy.getDimensions();
        if (!origDims.equals(copyDims)) {
            throw new RuntimeException(String.format(RuntimeMessages.STR_RUNTIME_ERROR_ARRAY_PARAM_AND_FORMAL_PARAM_DIMENSIONS_MISMATCH, Messages.arrayIndexToString(origDims), Messages.arrayIndexToString(copyDims)));
        } else {
            Object[] originals = original.getValues();
            copy.setValues(originals);
        }
    }
}
