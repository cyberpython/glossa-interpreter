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
import glossa.statictypeanalysis.ExpressionResultForm;
import glossa.statictypeanalysis.StaticTypeAnalyzerUtils;
import glossa.statictypeanalysis.scopetable.parameters.ActualParameter;
import glossa.statictypeanalysis.scopetable.parameters.FormalParameter;
import java.io.PrintStream;
import java.util.ArrayList;
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

    /*
     * @return a List<Integer> indicating the indices of parameters
     *         with the wrong type or null if 
     *                - the parameters list is null
     *                  and the formal parameters list is non-empty and not null
     *                 -OR the number of parameters does not
     *                  match the number of formal parameters
     */
    public List<Integer> checkParameterTypes(List<ActualParameter> parameters) {
        List<Integer> result = new ArrayList<Integer>();
        if (parameters == null) {
            if ((this.formalParameters == null) || this.formalParameters.isEmpty()) {
                return result;
            } else {
                return null;
            }
        }

        if (parameters.size() == this.formalParameters.size()) {
            int i=0;
            FormalParameter fp;
            ActualParameter ap;
            while(i<this.formalParameters.size()){
                fp = this.formalParameters.get(i);
                ap = parameters.get(i);
                if( StaticTypeAnalyzerUtils.areTypesCompatibleForAssignment(fp.getType(), ap.getType()) < 0 ){
                    result.add(new Integer(i));
                }else{
                    if( (fp.isArrayParamFlagSet())  &&  (!ap.getForm().equals(ExpressionResultForm.ARRAY))  ){
                        result.add(new Integer(i));
                    }
                }
                i++;
            }
            return result;
        }else{
            return null;
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
