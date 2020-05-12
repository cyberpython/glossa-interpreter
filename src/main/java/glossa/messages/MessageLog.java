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

package glossa.messages;

import glossa.utils.Point;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class MessageLog {

    private PrintStream err;
    private PrintStream warn;

    private List<ErrorMessage> errorMessages;
    private List<WarningMessage> warningMessages;

    public MessageLog() {
        this.err = System.err;
        this.warn = System.out;
        this.errorMessages = new ArrayList<ErrorMessage>();
        this.warningMessages = new ArrayList<WarningMessage>();
    }

    public MessageLog(PrintStream err, PrintStream warn) {
        this.err = err;
        this.warn = warn;
        this.errorMessages = new ArrayList<ErrorMessage>();
        this.warningMessages = new ArrayList<WarningMessage>();
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public List<WarningMessage> getWarningMessages() {
        return warningMessages;
    }

    public void clearMessages() {
        errorMessages.clear();
        warningMessages.clear();
    }

    public void error(Point errorPoint, String msg) {
        errorMessages.add(new ErrorMessage(errorPoint, msg));
    }

    public void warning(Point warningPoint, String msg) {
        warningMessages.add(new WarningMessage(warningPoint, msg));
    }

    public void printError(ErrorMessage msg) {
        err.println(Messages.CONSTS_STR_ERROR + " (" + Messages.pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public void printWarning(WarningMessage msg) {
        warn.println(Messages.CONSTS_STR_WARNING + " (" + Messages.pointToString(msg.getPoint()) + "): " + msg.getMsg());
    }

    public void printErrors() {
        for (Iterator<ErrorMessage> it = errorMessages.iterator(); it.hasNext();) {
            ErrorMessage msg = it.next();
            printError(msg);
        }
    }

    public void printWarnings() {
        for (Iterator<WarningMessage> it = warningMessages.iterator(); it.hasNext();) {
            WarningMessage msg = it.next();
            printWarning(msg);
        }
    }

    public void lexerError(Point errorPoint, String msg) {
        error(errorPoint, msg);
    }

    public void parserError(Point errorPoint, String msg) {
        error(errorPoint, msg);
    }

    public int getNumberOfErrors(){
        return this.errorMessages.size();
    }

    public int getNumberOfWarnings(){
        return this.warningMessages.size();
    }

}
