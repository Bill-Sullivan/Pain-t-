/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Bill
 */
public class ComboBoxWrapper {
    ComboBox<Double> cmb;
    ComboBoxWrapper () {
        cmb = new ComboBox<Double>();
        cmb.getItems().addAll(
        1.0,
        1.5,
        2.0,
        2.5,
        3.0);
        cmb.setValue(1.0);
    }
    
    double getValue () {
        return cmb.getValue();
    }
    
    ComboBox <Double> getComboBox() {
        return cmb;
    }
        
        
}