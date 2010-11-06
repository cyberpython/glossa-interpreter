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
package glossa.ui;

import glossa.interpreter.Interpreter;
import glossa.interpreter.InterpreterListener;
import glossa.interpreter.symboltable.SymbolTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class CLI implements InterpreterListener {

    private boolean stepByStep;

    public CLI() {
        this.stepByStep = false;
    }

    public void commandExecuted(Interpreter sender, boolean wasPrintStatement) {
        if (!stepByStep) {
            sender.resume();
        } else {
            if (!wasPrintStatement) {
                System.out.print("Continue? ");
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String s = r.readLine();
                    if (s.equals("")) {
                        sender.resume();
                    } else {
                        sender.stop();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else {
                sender.resume();
            }
        }

    }

    public void stackPopped() {
    }

    public void stackPushed(SymbolTable newSymbolTable) {
    }

    public void execute(File f) {
        Interpreter inter = new Interpreter(f);
        inter.addListener(this);
        Thread t = new Thread(inter);
        t.start();
    }
}
