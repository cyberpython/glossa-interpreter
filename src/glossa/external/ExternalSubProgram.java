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
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public interface ExternalSubProgram {
    
    /**
     * Returns the subprogram's name.
     * @return The subprogram's name (case insensitive) - must be unique
     *         for each subprogram.
     */
    public String getName();
    
    /**
     * Returns the subprogram's package name.
     * @return The subprogram's package name (case insensitive) - currently not 
     * used. In the future it could be used to differentiate between 
     * subprograms with the same name.
     */
    public String getPackageName();
    
    /**
     * Returns the subprogram's description.
     * @return The subprogram's description. This shall be used for documentation purposes;
     */
    public String getDescription();
    
    /**
     * Returns the subprogram's parameter list.
     * @return The subprogram's parameter list.
     */
    public List<Parameter> getParametersList();
    
    
}
