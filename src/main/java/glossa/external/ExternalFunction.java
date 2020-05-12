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

import glossa.types.Type;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author cyberpython
 */
public interface ExternalFunction extends ExternalSubProgram{   
    

    /**
     * Returns the function's return type.
     * @return The function's return type (real/integer/boolean/string).
     */
    public Type getReturnType();  
    
    /**
     * Executes the function.
     * @param parameters The list of values to be passed to the function as
     *                   input.
     * @param err The default error stream (usually System.err)
     * @return An object which is the function's return value.
     *         This object must be:
     *         BigInteger for integer
     *         BigDecimal for real
     *         Boolean    for boolean
     *         String     for string
     */
    public Object execute(List<Object> parameters, PrintStream err);
}
