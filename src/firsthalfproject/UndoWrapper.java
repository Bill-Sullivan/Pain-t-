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
    
    void updateUndoStack() {
        pastStates.push(FirstHalfProject.canvasWrapper.getCanvas().snapshot(null, null));
    }
    
    void updateUndoStack(Image toPush) {
        pastStates.push(toPush);
    }
    
    void updateRedoStack(Image toPush) {
        furtureStates.push(toPush);
    }
    
    void undo() {
        updateRedoStack(pastStates.pop());
        FirstHalfProject.canvasWrapper.drawImageOnCanvas(pastStates.peek());
              
    }
    
    void redo() {
        updateUndoStack(furtureStates.peek());
        FirstHalfProject.canvasWrapper.drawImageOnCanvas(furtureStates.pop());
    }    
}
