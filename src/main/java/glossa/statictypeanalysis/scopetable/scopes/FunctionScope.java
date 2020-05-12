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

import glossa.messages.Messages;
import glossa.statictypeanalysis.scopetable.parameters.FormalParameter;
import glossa.types.Type;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class FunctionScope extends SubProgramScope{
    private Type returnType;
    private boolean returnValueSet;

    public FunctionScope(int index, String subprogramName, List<FormalParameter> formalParameters, Type returnType) {
        super(index, subprogramName, formalParameters);
        this.returnType = returnType;
        this.returnValueSet = false;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }


    @Override
    public void print(PrintStream out) {
        out.println("\t\t"+Messages.CONSTS_STR_FUNCTION+": "+this.getSubprogramName()+" "+Messages.CONSTS_STR_RETURNS+" "+Messages.typeToString(this.returnType));
        out.println(" Index: "+getIndex());
        super.print(out);
    }

    /**
     * @return the returnValueSet
     */
    public boolean isReturnValueSet() {
        return returnValueSet;
    }

    /**
     * @param returnValueSet the returnValueSet to set
     */
    public void setReturnValueSet(boolean returnValueSet) {
        this.returnValueSet = returnValueSet;
    }

}
