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

import glossa.interpreter.Interpreter;
import glossa.interpreter.InterpreterListener;
import glossa.interpreter.symboltable.SymbolTable;
import glossa.messages.ErrorMessage;
import glossa.messages.MessageLog;
import glossa.messages.WarningMessage;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class JInterpreterMessagesList extends JList implements InterpreterListener {

    private Interpreter interpreter;
    private DefaultListModel model;

    public JInterpreterMessagesList() {
        this.interpreter = null;
        this.model = new DefaultListModel();
        this.setBackground(Color.WHITE);
        this.setModel(model);
        this.setCellRenderer(new InterpreterMessagesListCellRenderer());
    }

    public void clear() {
        model.clear();
    }

    public void setInterpreter(Interpreter interpreter) {
        if (this.interpreter != null) {
            this.interpreter.removeListener(this);
        }
        this.interpreter = interpreter;
        this.interpreter.addListener(this);
    }

    public void parsingAndSemanticAnalysisFinished(boolean success) {
        model.clear();
        MessageLog msgLog = interpreter.getMsgLog();
        List<ErrorMessage> errors = msgLog.getErrorMessages();
        for (Iterator<ErrorMessage> it = errors.iterator(); it.hasNext();) {
            ErrorMessage errorMessage = it.next();
            model.addElement(errorMessage);
        }
        List<WarningMessage> warnings = msgLog.getWarningMessages();
        for (Iterator<WarningMessage> it = warnings.iterator(); it.hasNext();) {
            WarningMessage warningMessage = it.next();
            model.addElement(warningMessage);
        }
        this.repaint();
    }

    public void runtimeError() {
    }

    public void commandExecuted(Interpreter sender, boolean wasPrintStatement) {
    }

    public void stackPopped() {
    }

    public void stackPushed(SymbolTable newSymbolTable) {
    }
}
