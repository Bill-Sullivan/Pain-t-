/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

/**
 *
 * @author Bill
 */
public class ToolBarWrapper {
    ToolBar toolBar;
    ToolBarWrapper () {
        Button line =   new Button("Line");
        
        line.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.canvasWrapper.setCurserMode("Line");
            }
        });
        
        Button rectangle = new Button("Rectangle");
        rectangle.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.canvasWrapper.setCurserMode("Rectangle");
            }
        });
        
        Button square = new Button("Square");
        square.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.canvasWrapper.setCurserMode("Square");
            }
        });
        
        Button freeDraw = new Button("Free Draw");
        freeDraw.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.canvasWrapper.setCurserMode("FreeDraw");
            }
        });
        
        Button undo = new Button("Undo");

        undo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.undoWrapper.undo();
            }
        });
        
        Button redo = new Button("Redo");

        redo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FirstHalfProject.undoWrapper.redo();
            }
        });
                
        toolBar = new ToolBar(
                undo,
                redo,
                line,
                rectangle,
                square,
                freeDraw
        );
    }
    
    ToolBar getToolBar() {
        return toolBar;
    }
}