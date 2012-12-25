/*
 *  The MIT License
 *
 *  Copyright 2012 Georgios Migdos <cyberpython@gmail.com>.
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
package glossa.external;

import glossa.statictypeanalysis.scopetable.parameters.ActualParameter;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public class WrongParametersNumberForExternalSubprogramException extends Exception {
    
    private final static String MESSAGE1 = "Η συνάρτηση %1$s δέχεται %2$d παραμέτρο - δόθηκαν: %3$d.";
    private final static String MESSAGE2 = "Η συνάρτηση %1$s δέχεται %2$d παραμέτρους - δόθηκαν: %3$d.";
    private List<Parameter> expected;
    private List<ActualParameter> passed;
    private String functionName;
    
    public WrongParametersNumberForExternalSubprogramException(String functionName, List<Parameter> expected, List<ActualParameter> passed) {
        super(expected.size() == 1 ? String.format(MESSAGE1, functionName, expected.size(), passed.size()) : String.format(MESSAGE2, functionName, expected.size(), passed.size()));
        this.functionName = functionName;
        this.expected = expected;
        this.passed = passed;
    }
    
    public String getFunctionName() {
        return functionName;
    }
    
    public List<Parameter> getExpected() {
        return expected;
    }
    
    public List<ActualParameter> getPassed() {
        return passed;
    }
}
