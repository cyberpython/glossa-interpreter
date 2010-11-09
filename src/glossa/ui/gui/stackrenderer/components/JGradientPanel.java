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

package glossa.ui.gui.stackrenderer.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class JGradientPanel extends JPanel{

    private Color borderColor;
    private Color bgColor1;
    private Color bgColor2;

    private Color selectedBgColor1;
    private Color selectedBgColor2;

    private BasicStroke borderStroke;

    private boolean selected;

    public JGradientPanel() {

        this.borderColor = new Color(99, 99, 99);
        this.bgColor1 = new Color(245, 245, 245);
        this.bgColor2 = new Color(230, 230, 230);

        this.selectedBgColor1 = new Color(255, 235, 235);
        this.selectedBgColor2 = new Color(255, 205, 205);

        this.borderStroke = new BasicStroke(0.5f);

        this.selected = false;
        
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        this.draw(arg0);
    }

    private void draw(Graphics g){

        int width = this.getWidth();
        int height = this.getHeight();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        fillBgWithGradient(g2d, width, height);
        drawBorder(g2d, width, height);

    }

    private void drawBorder(Graphics2D g2d, int width, int height) {
        g2d.setStroke(borderStroke);
        g2d.setPaint(borderColor);
        g2d.drawRect(0, 0, width - 1, height - 1);
    }

    private void fillBgWithGradient(Graphics2D g2d, int width, int height) {
        GradientPaint bgColor;
        if(selected){
            g2d.setBackground(selectedBgColor1);
            bgColor = new GradientPaint(0, 0, selectedBgColor1, 0, height, selectedBgColor2);
        }else{
            g2d.setBackground(bgColor1);
            bgColor = new GradientPaint(0, 0, bgColor1, 0, height, bgColor2);
        }
        g2d.setPaint(bgColor);
        g2d.fillRect(0, 0, width, height);
    }





}
