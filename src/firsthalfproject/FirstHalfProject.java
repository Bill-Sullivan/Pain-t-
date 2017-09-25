/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;
// Testing Git
// This is the currrent version

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Bill
 */
public class FirstHalfProject extends Application {
    
    // variable that containes the active image
    public static Image image;
    public static GridPane root;
    
    public static Stage stage;
    
    
    static ComboBoxWrapper comboBoxWrapper = new ComboBoxWrapper();
    static CanvasWrapper canvasWrapper = new CanvasWrapper();
    static ColorPickerWrapper colorPickerWrapper = new ColorPickerWrapper();
    static ToolBarWrapper toolBarWrapper = new ToolBarWrapper();
    static MenuBarWrapper menuBarWrapper = new MenuBarWrapper();
    
    @Override
    public void start(Stage primaryStage) {        
        
        
        stage = primaryStage;
        // Container that arranges the items contained in it in a grid for display on screen
        // grid is arranged as (column, row)        
        root = new GridPane();
        
        
        
        Scene scene = new Scene(root);
        
        // adds the menu bar to the top of the view 
        root.add(menuBarWrapper.getMenuBar(), 0, 0);
        
        root.add(comboBoxWrapper.getComboBox(), 2, 0);
        
        root.add(toolBarWrapper.getToolBar(), 3, 0);
        
        // Aligns the grid so that (0, 0) is in the top right
        root.setAlignment(Pos.TOP_RIGHT);
        
        root.add(colorPickerWrapper.getColorPicker(), 1, 0);
        
        
        primaryStage.setTitle("Image Viewer");
        primaryStage.setScene(scene);        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


/*
        // remove from Rososcos Version
        MenuItem resizeCanvas = new MenuItem("Resize Canvas");
        resizeCanvas.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Dialog<Pair<String, String>> dialog = new Dialog<>();
                
                ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
                
                TextField from = new TextField();
                from.setPromptText("From");
                TextField to = new TextField();
                to.setPromptText("To");
                
                GridPane gridPane = new GridPane();
                
                gridPane.add(from, 0, 0);
                gridPane.add(new Label("To:"), 1, 0);
                gridPane.add(to, 2, 0);

                dialog.getDialogPane().setContent(gridPane);
                
                Optional<Pair<String, String>> data = dialog.showAndWait();
                
                data.ifPresent(pair -> {  
                    System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());                    
                    canvasWrapper.resizeCanvas(Double.parseDouble(pair.getKey()), Double.parseDouble(pair.getValue()));
                });
                
                primaryStage.sizeToScene();
                
            }
        });
        // remove from Rososcos Version
        */