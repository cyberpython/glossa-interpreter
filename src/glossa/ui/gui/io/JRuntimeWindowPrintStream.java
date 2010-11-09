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

package glossa.ui.gui.io;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class JRuntimeWindowPrintStream extends PrintStream{

    private JRuntimeWindow runtimeWindow;
    private boolean isErrorStream;
    private ByteArrayOutputStream outputStream;

    public JRuntimeWindowPrintStream(boolean isErrorStream, JRuntimeWindow jRuntimeWindow) {
        this(true, isErrorStream, jRuntimeWindow);
    }

    public JRuntimeWindowPrintStream(boolean autoFlash, boolean isErrorStream, JRuntimeWindow jRuntimeWindow) {
        super(new ByteArrayOutputStream(), autoFlash);
        this.outputStream = (ByteArrayOutputStream)super.out;
        this.runtimeWindow = jRuntimeWindow;
        this.isErrorStream = isErrorStream;
    }
    
    @Override
    public void print(Object x) {
        runtimeWindow.append(x==null?"null":x.toString(), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(String x) {
        runtimeWindow.append(x==null?"null":x, isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(boolean x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(char x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(double x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(int x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(float x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(long x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void print(char[] x) {
        runtimeWindow.append(String.valueOf(x), isErrorStream);
        outputStream.reset();
    }

    @Override
    public void println() {
        runtimeWindow.newline();
        outputStream.reset();
    }

    @Override
    public void println(Object x) {
        print(x);
        println();
    }

    @Override
    public void println(String x) {
        print(x);
        println();
    }

    @Override
    public void println(boolean x) {
        print(x);
        println();
    }

    @Override
    public void println(char x) {
        print(x);
        println();
    }

    @Override
    public void println(double x) {
        print(x);
        println();
    }

    @Override
    public void println(int x) {
        print(x);
        println();
    }

    @Override
    public void println(float x) {
        print(x);
        println();
    }

    @Override
    public void println(long x) {
        print(x);
        println();
    }

    @Override
    public void println(char[] x) {
        print(x);
        println();
    }

    public JRuntimeWindow getRuntimeWindow() {
        return runtimeWindow;
    }

    public void setRuntimeWindow(JRuntimeWindow runtimeWindow) {
        this.runtimeWindow = runtimeWindow;
    }

}
