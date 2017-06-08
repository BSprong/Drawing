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
public class Polygon extends DrawingItem{
    private Point vertices;
    private int weight;

    public Point getVertices() {
        return vertices;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.weight = weight;
    }

    public Polygon(Point vertices, int weight, Point anchor, Color color) {
        super(anchor, color);
        this.vertices = vertices;
        this.weight = weight;
    }
//iedere item heeft eigen tostring methode

    @Override
    public String toString() {
        return "Polygon{" + "vertices=" + vertices + ", weight=" + weight + '}';
    }
   

    
    
    
    
}
