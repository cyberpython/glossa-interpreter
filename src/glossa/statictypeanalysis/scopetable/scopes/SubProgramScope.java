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
import glossa.statictypeanalysis.StaticTypeAnalyzerUtils;
import glossa.statictypeanalysis.scopetable.symbols.FormalParameter;
import glossa.types.Type;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class SubProgramScope extends Scope {

    private String subprogramName;
    private List<FormalParameter> formalParameters;
    private int index;

    public SubProgramScope(int index, String subprogramName, List<FormalParameter> formalParameters) {
        this.subprogramName = subprogramName;
        this.formalParameters = formalParameters;
        this.index = index;
    }

    public String getSubprogramName() {
        return subprogramName;
    }

    public void setSubprogramName(String subprogramName) {
        this.subprogramName = subprogramName;
    }

    public List<FormalParameter> getFormalParameters() {
        return formalParameters;
    }

    public void setFormalParameters(List<FormalParameter> formalParameters) {
        this.formalParameters = formalParameters;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int checkParameterTypes(List<Type> parameterTypes) {
        if (parameterTypes == null) {
            if ((this.formalParameters == null) || this.formalParameters.isEmpty()) {
                return 0;
            } else {
                return -1;
            }
        }

        if (parameterTypes.size() != this.formalParameters.size()) {
            return -1;
        }else{
            int i=0;
            while(i<this.formalParameters.size()){
                if( StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(this.formalParameters.get(i).getType(), parameterTypes.get(i)) < 0 ){
                    return -2;
                }
                i++;
            }
            return 0;
        }

    }

    public String paramNamesToString() {
        StringBuilder sb = new StringBuilder();
        for (Iterator<FormalParameter> it = formalParameters.iterator(); it.hasNext();) {
            FormalParameter param = it.next();
            sb.append(param.getName());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public void print(PrintStream out) {
        out.println("---------------------------------------------------------------------");
        out.println(" " + Messages.CONSTS_STR_PARAMETERS + ": ");
        for (Iterator<FormalParameter> it = formalParameters.iterator(); it.hasNext();) {
            FormalParameter formalParameter = it.next();
            out.println("\t" + formalParameter);
        }
        super.print(out);
    }
}
