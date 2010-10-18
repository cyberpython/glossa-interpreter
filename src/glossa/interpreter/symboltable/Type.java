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

import glossa.interpreter.messages.ReportingAndMessagingUtils;

/**
 *
 * @author cyberpython
 */
public enum Type {
    INTEGER, REAL, BOOLEAN, STRING;

    @Override
    public String toString() {
        if(this.equals(Type.INTEGER)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_INTEGER;
        }else if(this.equals(Type.REAL)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_REAL;
        }else if(this.equals(Type.BOOLEAN)){
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_BOOLEAN;
        }else{
            return ReportingAndMessagingUtils.CONSTS_STR_TYPE_STRING;
        }
    }

}
