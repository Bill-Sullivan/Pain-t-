/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author Bill
 */
public class ColorPickerWrapper {
    ColorPicker colorPicker;
    ColorPickerWrapper () {
        colorPicker = new ColorPicker();
    }
    ColorPicker getColorPicker() {
        return colorPicker;
    }
    Color getValue() {
        return colorPicker.getValue();
    }
}
