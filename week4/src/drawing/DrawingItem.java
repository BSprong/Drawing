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
public abstract class DrawingItem implements Comparable<DrawingItem> 
{
    
    private Point anchor;
    private Color color;
    protected DrawingItem previousState;
    
    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) throws CloneNotSupportedException {
        previousState=(DrawingItem)this.clone();
        this.anchor = anchor;        
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        //color is now Blue.
        //create new DrawingItem with that color and the current anchor
        //save this in previousState
        //setColor to new color (e.g. Red)
        this.color = color;
    }
    
    
//constructor
    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
        //DummyData();
    }

    @Override
    public abstract String toString();
    
//hiermee sorteer je de lijst
    @Override
    public int compareTo(DrawingItem other)
    {
        double thisDistance = (Math.sqrt(anchor.x) + Math.sqrt(anchor.y));
        double otherDistance = (Math.sqrt(other.getAnchor().x) + Math.sqrt(other.getAnchor().y));
        return Double.compare(thisDistance, otherDistance);//        
    }
    
    public DrawingItem returnToPreviousState(){
        return this.previousState;
    }
    
    public void paint (IPaintable paintable)
    {
        
    }
    
    /*public void SetPreviousState(){
        previousState = dwItem;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
    
    

}
