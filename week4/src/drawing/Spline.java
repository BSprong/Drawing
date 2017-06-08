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
public class Spline extends DrawingItem{
    private Point points;
    private int weight;
    private int degree;

    public Point getPoints() {
        return points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.weight = weight;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.degree = degree;
    }

    public Spline(Point points, Point anchor, Color color, int weight, int degree  ) {
        super(anchor, color);
        this.points = points;
        this.weight = weight;
        this.degree = degree;
    }
//iedere item heeft eigen tostring methode

    @Override
    public String toString() {
        return "Spline{" + "points=" + points + ", weight=" + weight + ", degree=" + degree + '}';
    }

   

    @Override
    public void paint(IPaintable paintable) {
        paintable.paintSpline(this);
    }
   

    
    
    
    
    
    
}
