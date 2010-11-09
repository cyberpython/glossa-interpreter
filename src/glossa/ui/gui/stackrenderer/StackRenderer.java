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

package glossa.ui.gui.stackrenderer;

import glossa.interpreter.Interpreter;
import glossa.interpreter.InterpreterListener;
import glossa.interpreter.symboltable.FunctionSymbolTable;
import glossa.interpreter.symboltable.MainProgramSymbolTable;
import glossa.interpreter.symboltable.ProcedureSymbolTable;
import glossa.interpreter.symboltable.SymbolTable;
import glossa.ui.gui.stackrenderer.components.JFunctionRenderer;
import glossa.ui.gui.stackrenderer.components.JMainProgramRenderer;
import glossa.ui.gui.stackrenderer.components.JProcedureRenderer;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JPanel;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class StackRenderer extends JPanel implements InterpreterListener{

    private Deque<JPanel> stack;

    public StackRenderer() {
        super();
        stack = new ArrayDeque<JPanel>();
        this.setBackground(Color.white);
        this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }

    public void parsingAndSemanticAnalysisFinished(boolean success) {
        
    }

    public void runtimeError() {
        stack.clear();
        this.removeAll();
        this.repaint();
    }

    public void stackPushed(SymbolTable newSymbolTable) {
        if(newSymbolTable instanceof FunctionSymbolTable){
            JPanel p = new JFunctionRenderer((FunctionSymbolTable)newSymbolTable);
            this.add(p,0);
            stack.push(p);
        }else if(newSymbolTable instanceof ProcedureSymbolTable){
            JPanel p = new JProcedureRenderer((ProcedureSymbolTable)newSymbolTable);
            this.add(p,0);
            stack.push(p);
        }else if(newSymbolTable instanceof MainProgramSymbolTable){
            JPanel p = new JMainProgramRenderer(newSymbolTable);
            this.add(p,0);
            stack.push(p);
        }
        this.revalidate();

    }

    public void stackPopped() {
        this.remove(this.stack.pop());
        this.revalidate();
        this.repaint();
    }


    public void commandExecuted(Interpreter sender, boolean wasPrintStatement) {
        JPanel p = this.stack.peek();
        if(p!=null){
            if(p instanceof JFunctionRenderer){
                ((JFunctionRenderer)p).updateReturnValue();
            }
            p.repaint();
        }
        this.repaint();
    }



}
