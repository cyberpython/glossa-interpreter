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

import javax.swing.JEditorPane;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class JRuntimeWindow extends JEditorPane {

    private final String initialContent = "<html>   <head>    </head>   <body style=\"font-family: monospace; background-color: rgb(255,255,255);\"><p style=\"margin-top: 0px; margin-left: 10px;\"></p></body> </html>";
    HTMLDocument document;
    Element mainParagraph;

    private JRuntimeWindowPrintStream out;
    private JRuntimeWindowPrintStream err;

    public JRuntimeWindow() {
        super();
        init();
    }

    private void init(){
        setEditable(false);
        setContentType("text/html");
        setText(initialContent);
        document = (HTMLDocument) getDocument();
        mainParagraph = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.P);

        this.out = new JRuntimeWindowPrintStream(false, this);
        this.err = new JRuntimeWindowPrintStream(true, this);
    }

    public JRuntimeWindowPrintStream getOut() {
        return out;
    }

    public JRuntimeWindowPrintStream getErr() {
        return err;
    }

    public void clear(){
        setText(initialContent);
        document = (HTMLDocument) getDocument();
        mainParagraph = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.P);
    }

    public void append(String text, boolean isError){
        String txt;
        if(isError){
            txt = "<span style=\"color: rgb(155,0,0);\">" + text.replaceAll("\\s", "&nbsp;") + "</span>";
        }else{
            txt = "<span style=\"margin:0px;padding:0px;\">" + text.replaceAll("\\s", "&nbsp;") + "</span>";
        }
        try{
            document.insertBeforeEnd(mainParagraph, txt);
        }catch(Exception e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void newline(){
        String txt = "<br>";
        try{
            document.insertBeforeEnd(mainParagraph, txt);
        }catch(Exception e){
            System.err.println(e.getLocalizedMessage());
        }
    }



}
