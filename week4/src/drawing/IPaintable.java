/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;
import javafx.scene.paint.Color;
import java.awt.Point;

/**
 *
 * @author Anneke
 */
public interface IPaintable {
    
    public void setColor(Color color);
    public void paintOval(Oval oval);
    //public void paintLine(Point from, Point to, int weight);
    public void paintSpline(Spline spline);
    public void paintText(PaintedText text);
    public void paintImage(Image image);
    public void clear();
    
    
}
