/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import java.util.LinkedList;
import javafx.scene.image.Image;

/**
 *
 * @author Bill
 */
public class UndoWrapper {
    LinkedList<Image> pastStates = new LinkedList();
    LinkedList<Image> furtureStates = new LinkedList();
    
    Image baseImage;
    
    void updateUndoStack() {
        pastStates.push(FirstHalfProject.canvasWrapper.getCanvas().snapshot(null, null));
        //System.out.println("");
        //System.out.println("UndoStack Updated");        
        //System.out.println(pastStates.peek());
    }
    
    void updateUndoStack(Image toPush) {
        pastStates.push(toPush);
        //System.out.println("UndoStack Updated");
    }
    
    void updateRedoStack(Image toPush) {
        furtureStates.push(toPush);
    }
    
    void undo() {
        //System.out.println("");
        //System.out.println(pastStates.peek());
        //System.out.println(pastStates.size());
        
        if (!(pastStates.isEmpty())) {
            updateRedoStack(pastStates.pop());
        }
        if (!(pastStates.isEmpty())) {
            
            //System.out.println("Undo is Not Empty");
            //System.out.println(pastStates.size());
            //System.out.println(pastStates.peek());
            FirstHalfProject.canvasWrapper.drawImageOnCanvas(pastStates.peek());
        } else {
            FirstHalfProject.canvasWrapper.drawImageOnCanvas(baseImage);
            //System.out.println("Undo is Empty");
        }
              
    }
    
    void clearRedoStack() {
        furtureStates = new LinkedList();
    }
    
    void redo() {        
        if (!(furtureStates.isEmpty())) {            
            updateUndoStack(furtureStates.peek());
            FirstHalfProject.canvasWrapper.drawImageOnCanvas(furtureStates.pop());
        } else {
            System.out.println("Redo is Empty");
        }
       
    }    
}
