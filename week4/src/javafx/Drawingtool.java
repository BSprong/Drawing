/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;


import java.awt.color.CMMException;
import drawing.Drawing;
import drawing.Image;
import drawing.Oval;
import drawing.PaintedText;
import drawing.Spline;
import javafx.scene.paint.*;
import java.awt.Font;
import java.awt.Point;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;


/**
 *
 * @author Anneke
 */
public class Drawingtool extends Application {
    
         Canvas canvas = new Canvas(400, 400);
         GraphicsContext gc = canvas.getGraphicsContext2D();
         JavaFXPaintable paintable = new JavaFXPaintable(gc);
         Drawing drawing = new Drawing("teken", 400, 400);
    
    @Override
    public void start(Stage primaryStage) {
        
        //toevoegen items dus oval, line font, image
        
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        
        
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
        /**
         * met onderstaande geef je aan wat je op de canvas wilt. 
         * je geeft de coordinaten aan x en y as, lengte en de breedte en kleur
         */
        Oval oval = new Oval(new Point(60, 10), Color.RED, 30, 20);
       drawing.addItem(oval);
       
       Spline spline = new Spline(new Point (30, 70), new Point(), Color.BLUE, 10, 80);
       drawing.addItem(spline);
       
       Font letter = new Font("Arial", Font.PLAIN, 11);
       PaintedText paintedtext = new PaintedText(new Point(100, 100), Color.GREEN, "Dit is tekst in javafx", letter);
       drawing.addItem(paintedtext);
       
       File files = new File(System.getProperty("user.dir"));
       File bestand = new File (files, "/src/javafx/java.png");
       Image image = new Image(new Point(5, 100), Color.YELLOW, bestand, 40);
       drawing.addItem(image);
       
       tekenen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     *
     */
    public void tekenen(){
        paintable.clear();
        drawing.paint(paintable);
    }
    
}
