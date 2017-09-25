/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import firsthalfproject.PairOfValues;

/**
 *
 * @author Bill
 */
public class CanvasWrapper {
    ColorPicker colorPicker = new ColorPicker();
        
    final Canvas canvas = new Canvas();
    GraphicsContext gc = canvas.getGraphicsContext2D();
    
    private String curserMode = new String ("Default");
    
    
    private double startDragClickX;
    private double startDragClickY;
    
    void setCurserMode(String mode) {
        curserMode = mode;
    }
    
    CanvasWrapper() {
        
       canvas.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (curserMode == "Line" || curserMode == "Rectangle" || curserMode == "Circle" || curserMode == "Square") {
                    startDragClickX = event.getX();
                    startDragClickY = event.getY();
                } 
                if (curserMode == ("FreeDraw")) {
                        gc.beginPath();
                        gc.moveTo(event.getX(), event.getY());   
                }
                
            }
        });
    canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (curserMode == "FreeDraw") {
                    gc.lineTo(event.getX(), event.getY());
                    gc.moveTo(event.getX(), event.getY());
                }
            }
    });
        
    canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {    
        public void handle(MouseEvent event) {
            if (curserMode == "Line") {
                gc.setStroke(colorPicker.getValue());
                gc.strokeLine(startDragClickX, startDragClickY, event.getX(), event.getY());
            } else if (curserMode == "Rectangle") {
                drawRectangle(startDragClickX, startDragClickY, event.getX(), event.getY());
            } else if (curserMode == "Square") {
                drawSquare(startDragClickX, startDragClickY, event.getX(), event.getY());
                
                
                
                
            } else if (curserMode == "Circle") {
                double radius = getDistance(startDragClickX, startDragClickY, event.getX(), event.getY());
                
                /*
                double startPointX = startDragClickX - radius;
                double startPointY = startDragClickY - radius;
                
               
                System.out.println(startDragClickX);
                System.out.println(startDragClickY);
                System.out.println(event.getX());
                System.out.println(event.getY());
                System.out.println(radius);
                System.out.println("");
                
                
                gc.beginPath();
                gc.moveTo(startPointX, startPointY); 
                gc.setStroke(colorPicker.getValue());
                gc.arcTo( event.getY(), event.getX(),  startDragClickY, startDragClickX, radius);
                */
                System.out.println(startDragClickX);
                System.out.println(startDragClickY);
                System.out.println(event.getX());
                System.out.println(event.getY());
                System.out.println(radius);
                System.out.println("");
                
                System.out.println(getDistance(4, 0, 10, 0));
                
                gc.beginPath();
                //gc.moveTo(startDragClickX+radius, startDragClickY);
                gc.arc(startDragClickX, startDragClickX, event.getX(), event.getY(), 180, 2*radius);
                

                gc.stroke();
                
            } else if (curserMode == "FreeDraw") {              
                gc.lineTo(event.getX(), event.getY());   
                gc.closePath();
                gc.setStroke(colorPicker.getValue());
                gc.stroke();
            }
        }
    });   
    
    
    }
    
    void drawTestPath () {
        gc.beginPath();
        gc.moveTo(0, 0);
        gc.lineTo(100, 100);
        gc.stroke();
    }
    
    Image drawBlankCanvas(Image toWrite) {
        File blankImage = new File("Empty.png");
        try {
            Image blank = new Image(new FileInputStream(blankImage));
            drawImageOnCanvas(blank);
            return blank;            
        } catch (FileNotFoundException e) {
            return toWrite;
        }
       
    }
    
    void drawImageOnCanvas(Image image) {
        // sets the Image that will be shown in the Viewer 
                    //imageView.setImage(image);
                    canvas.setHeight(image.getHeight());
                    canvas.setWidth(image.getWidth());
                    
                    gc.drawImage(image, 0, 0);
    }
    
    void resizeCanvas (double width, double height) {
        canvas.resize(width, height);
    }
    
    ColorPicker getColorPicker () {
        return colorPicker;
    }
    
    Canvas getCanvas() {
        return canvas;
    }
    
    void drawRectangle(double CornerOneX, double CornerOneY, double CornerTwoX, double CornerTwoY) {
        double[] topCorner = findTopCorner(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        double x = topCorner[0];
        double y = topCorner[1];
        
        double width = findWidth(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        double height = findHeight(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        
        width = min (width, height);
        height = min (width, height);    
        
        gc.setStroke(colorPicker.getValue());
        gc.strokeRect(x, y, width, height);
    }
    
    void drawSquare (double CornerOneX, double CornerOneY, double CornerTwoX, double CornerTwoY) {
        double[] topCorner = findTopCorner(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        
        double x = topCorner[0];
        double y = topCorner[1];
        
        double width = findWidth(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        double height = findHeight(CornerOneX,  CornerOneY,  CornerTwoX,  CornerTwoY);
        
        width = min (width, height);
        height = min (width, height);
        
        
        gc.setStroke(colorPicker.getValue());
        gc.strokeRect(x, y, width, height);
    }
    
    double[] findTopCorner (double CornerOneX, double CornerOneY, double CornerTwoX, double CornerTwoY) {
        double width;
        double height;
        
        double x;
        double y;
        
        x = min(CornerOneX, CornerTwoX);
        y = min(CornerOneY, CornerTwoY);
        
        double[] toReturn = {x, y};
        
        return toReturn;
    }
    
    double findWidth (double CornerOneX, double CornerOneY, double CornerTwoX, double CornerTwoY) {
        abs(CornerOneX - CornerTwoX);
    }
    
    double findHeight (double CornerOneX, double CornerOneY, double CornerTwoX, double CornerTwoY) {
        abs(CornerOneY - CornerTwoY);
    }
    
    double getMinRetaineNegitive (double X, double Y) {
        if (abs(X) < abs(Y)) {
            return X;
        } else {
            return Y;
        }
        
    }
    
    double getDistance (double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    }
}
