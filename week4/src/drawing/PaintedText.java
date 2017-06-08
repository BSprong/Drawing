/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import javafx.scene.paint.*;
import java.awt.Font;
import java.awt.Point;

/**
 *
 * @author Bart
 */
public class PaintedText extends DrawingItem{
    private String content;
    private Font font;

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws CloneNotSupportedException {
        previousState=(Oval)this.clone(); 
        this.content = content;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.font = font;
    }

    public PaintedText(Point anchor, Color color, String content, Font font  ) {
        super(anchor, color);
        this.content = content;
        this.font = font;
    }
//iedere item heeft eigen tostring methode

    @Override
    public String toString() {
        return "PaintedText{" + "content=" + content + ", font=" + font + '}';
    }

    @Override
    public void paint(IPaintable paintable) {
        paintable.paintText(this);
    }
   

    
    
    
    
    
}
