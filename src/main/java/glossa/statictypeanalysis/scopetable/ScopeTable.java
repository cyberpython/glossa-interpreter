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

package glossa.statictypeanalysis.scopetable;

import glossa.statictypeanalysis.scopetable.scopes.FunctionScope;
import glossa.statictypeanalysis.scopetable.scopes.MainProgramScope;
import glossa.statictypeanalysis.scopetable.scopes.ProcedureScope;
import glossa.statictypeanalysis.scopetable.scopes.Scope;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class ScopeTable {

    private final String MAIN_PROGRAM_SCOPE_NAME = "_main";
    private final String FUNCTION_SCOPE_PREFIX = "func_";
    private final String PROCEDURE_SCOPE_PREFIX = "proc_";
    private HashMap<String, Scope> scopes;

    public ScopeTable() {
        this.scopes = new HashMap<String, Scope>();
    }

    public void putScope(String scopename, Scope s) {
        this.scopes.put(scopename.toLowerCase(), s);
    }

    public Scope getScope(String scopename) {
        return this.scopes.get(scopename.toLowerCase());
    }

    public void putFunctionScope(String scopename, FunctionScope s) {
        this.scopes.put(FUNCTION_SCOPE_PREFIX+scopename.toLowerCase(), s);
    }

    public FunctionScope getFunctionScope(String scopename) {
        return (FunctionScope)this.scopes.get(FUNCTION_SCOPE_PREFIX+scopename.toLowerCase());
    }

    public void putProcedureScope(String scopename, ProcedureScope s) {
        this.scopes.put(PROCEDURE_SCOPE_PREFIX+scopename.toLowerCase(), s);
    }

    public ProcedureScope getProcedureScope(String scopename) {
        return (ProcedureScope)this.scopes.get(PROCEDURE_SCOPE_PREFIX+scopename.toLowerCase());
    }

    public void setMainProgramScope(MainProgramScope mps){
        this.scopes.put(MAIN_PROGRAM_SCOPE_NAME, mps);
    }

    public MainProgramScope getMainProgramScope() {
        return (MainProgramScope)this.scopes.get(MAIN_PROGRAM_SCOPE_NAME);
    }


    public void printScopes(PrintStream out){
        String[] keys = scopes.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for (int i=0; i<keys.length; i++) {
            String key = keys[i];
            Scope s = scopes.get(key);
            s.print(out);
        }
    }

}
