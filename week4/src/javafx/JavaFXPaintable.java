/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import drawing.IPaintable;
import drawing.Image;
import drawing.Oval;
import drawing.PaintedText;
import drawing.Spline;
import javafx.scene.paint.*;
//import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import sun.awt.resources.awt;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Anneke
 */
public class JavaFXPaintable implements IPaintable {

    GraphicsContext graphicsContext;
    
    JavaFXPaintable(GraphicsContext gc) {
        graphicsContext = gc;
    }

    /**
     *
     * @param color
     */
    @Override
    public void setColor(Color color) {
        graphicsContext.setFill(color);
    }

    /**
     *
     * @param oval
     */
    @Override
    public void paintOval(Oval oval) {
        setColor(oval.getColor());
        graphicsContext.fillOval(oval.getAnchor().x, oval.getAnchor().y, oval.getWidth(), oval.getHeight());
    }

    /**
     *
     * @param spline
     */
    @Override
    public void paintSpline(Spline spline) {
        setColor(spline.getColor());
        graphicsContext.setLineWidth(spline.getWeight());
        graphicsContext.strokeLine(spline.getAnchor().x, spline.getAnchor().y, spline.getPoints().x, spline.getPoints().y);
    }

    /**
     *
     * @param text
     */
    @Override 
    public void paintText(PaintedText text) {
        setColor(text.getColor());
       graphicsContext.fillText(text.getContent(), text.getAnchor().x, text.getAnchor().y);
       
    }

    /**
     *
     * @param image
     */
    @Override
    public void paintImage(Image image) {
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(image.getFile());
        } catch (IOException ex) {
            System.out.println("Afbeelding kan niet geladen worden.");
        }

        WritableImage wr = null;
        if (bf != null) {
            wr = new WritableImage(bf.getWidth(), bf.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < bf.getWidth(); x++) {
                for (int y = 0; y < bf.getHeight(); y++) {
                    pw.setArgb(x, y, bf.getRGB(x, y));
               }
            }
        }

        ImageView inView = new ImageView(wr);
        javafx.scene.image.Image inImage = inView.getImage();

        graphicsContext.drawImage(inImage, image.getAnchor().x, image.getAnchor().y);
    }

    /**
     *
     */
    @Override
    public void clear() {
        graphicsContext.clearRect(0, 0, 400, 400);
    }
    
}
