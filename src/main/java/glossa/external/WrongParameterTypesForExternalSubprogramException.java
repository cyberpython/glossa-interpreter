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

import java.util.List;

/**
 *
 * @author cyberpython
 */
public class WrongParameterTypesForExternalSubprogramException extends Exception {

    private final static String MESSAGE = "Λάθος τύπος παραμέτρων για τη συνάρτηση %1$s, ";
    
    private String functionName;
    private  List<ParameterTypeMismatchInstance> mismatchedParams;

    public WrongParameterTypesForExternalSubprogramException(String functionName, List<ParameterTypeMismatchInstance> mismatchedParams) {
        super(buildMessage(functionName, mismatchedParams));
        this.functionName = functionName;
        this.mismatchedParams = mismatchedParams;
    }
    
    private static String buildMessage(String functionName, List<ParameterTypeMismatchInstance> mismatchedParams) {
        StringBuilder sb = new StringBuilder(String.format(MESSAGE, functionName));
        for (ParameterTypeMismatchInstance parameterTypeMismatchInstance : mismatchedParams) {
            sb.append("παράμετρος ").append(parameterTypeMismatchInstance.getParameterName());
            sb.append(". Αναμενόταν: ");
            if (parameterTypeMismatchInstance.getArrayExpected()) {
                sb.append("πίνακας ").append(parameterTypeMismatchInstance.getExpectedType().toPluralPossesiveString());
            } else {
                sb.append(parameterTypeMismatchInstance.getExpectedType().toString());
            }
            sb.append(" - βρέθηκε: ");
            if (parameterTypeMismatchInstance.getArrayFound()) {
                sb.append("πίνακας ").append(parameterTypeMismatchInstance.getFoundType().toPluralPossesiveString());
            } else {
                sb.append(parameterTypeMismatchInstance.getFoundType().toString());
            }
        }
        return sb.toString();
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<ParameterTypeMismatchInstance> getMismatchedParams() {
        return mismatchedParams;
    }
}
