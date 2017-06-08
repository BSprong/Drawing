/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.Point;
import javafx.scene.paint.*;
import java.io.File;

/**
 *
 * @author Bart
 */
public class Image extends DrawingItem{
    private File file;
    private double size;
    private Color color;

    public File getFile() {
        return file;
    }

    public void setFile(File file) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.file = file;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) throws CloneNotSupportedException {
        previousState=(Oval)this.clone();
        this.size = size;
    }

    public Image(Point anchor, Color color, File file, double size  ) {
        super(anchor, color);
        this.file = file;
        this.size = size;
    }
//iedere item heeft eigen tostring methode
    @Override
    public String toString() {
        return "Image{" + "file=" + file + ", size=" + size + ", color=" + color + '}';
    }

    @Override
    public int compareTo(DrawingItem t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(IPaintable paintable) {
        paintable.paintImage(this);
    }
    
    
    
    
}
