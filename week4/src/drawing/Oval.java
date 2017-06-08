/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import javafx.scene.paint.*;
import java.awt.Point;

/**
 *
 * @author Bart
 */
public class Oval extends DrawingItem {

    private double width;
    private double height;
    

    

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.height = height;
    }
//constructor

    public Oval(Point anchor, Color color, double width, double height  ) {
        super(anchor, color);
        this.width = width;
        this.height = height;
    }
//iedere item heeft eigen tostring methode

    @Override
    public String toString() {
        return "Oval{" + "width=" + width + ", height=" + height + '}';
    }

    @Override
    public void paint(IPaintable paintable) {
        paintable.paintOval(this);
    }

 
    

}
