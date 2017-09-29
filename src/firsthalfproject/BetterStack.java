/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author wsulliva
 */
public class BetterStack {
    LinkedList<Image> list = new LinkedList<Image>();
    
    void push (Image toPush) {
        BufferedImage dontPushThis = SwingFXUtils.fromFXImage(toPush, null);
        Image pushThis = SwingFXUtils.toFXImage(dontPushThis, null);
        list.push(pushThis);
    }
    
    Image pop () {
        return list.pop();
    }
    
    Image peek () {
        return list.peek();
    }
}
