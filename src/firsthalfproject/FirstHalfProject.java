/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;
// Testing Git

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;


/**
 *
 * @author Bill
 */
public class FirstHalfProject extends Application {
    
    // variable that containes the active image
    Image image;
    
    @Override
    public void start(Stage primaryStage) {
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //System.out.println("Somthing Highly Visable And Easy to See");
        
        // Container that allows the immage to be displayed
        // Container also has helpful methods
        ImageView iv1 = new ImageView();        
        
        // Container that arranges the items contained in it in a grid for display on screen
        // grid is arranged as (column, row)        
        GridPane root = new GridPane();
        
        //
        Scene scene = new Scene(root);              
        
        // menuBar serves two purposes
        // 1 create the menu bar displaied on the screen
        // 2 act as a container for the Menu objects
        MenuBar menuBar = new MenuBar();        
 
        // --- Menu File
        Menu menuFile = new Menu("File"); // creates the File menu
        MenuItem open = new MenuItem("Open"); // creates the open menu item to be placed in the file menu
        
        // provides access to the File Manager's File Chooser in a file manager and os agnostic way
        // The File Chooser opens a window that allows the user to select a file 
        // this file is then retured to the program to use as it will
        final FileChooser fileChooser = new FileChooser();
        
        // sets the file formates that the File Chooser will show in its window
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BMP(*.bmp)", "*.bmp"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("GIF(*.gif)", "*.gif"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG(*.jpeg)", "*.jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG(*.png)", "*.png"));
        
        // this function is called when the open MenuItem is clicked on
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {                
                try {
                    // launches the File Chooser to open a file then stores that file in the file object
                    File file = fileChooser.showOpenDialog(primaryStage);
                    
                    // converts the file to an image object for further use
                    image = new Image(new FileInputStream(file));                    
                    
                    // sets the Image that will be shown in the Viewer 
                    iv1.setImage(image);
                    
                    /*
                    These Lines appear to do nothing remove from Rososco's version
                    //HBox box = new HBox();
                    //box.getChildren().add(iv1);                    
                    */
                    
                    // adds the image viewer to the grid directly bellow the menu bar
                    root.add(iv1, 0, 1); // 
                    // resizes the window to match the size of the image
                    primaryStage.sizeToScene();                    
                    
                } catch (FileNotFoundException e) {
                    //e.printStackTrace(); 
                }                     
            }
        });
        // adds the open menu item to the File Menu
        menuFile.getItems().addAll(open);
        
        /*
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG(*.png)", "*.png"));
        */
        
        // creates a new menu item Save to be placed in the file menu
        // when pressed this item saves the image currently in use 
        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                 try {
                 File file = fileChooser.showSaveDialog(primaryStage);
                 System.out.println(fileChooser.getSelectedExtensionFilter().getExtensions().get(0).substring(2));
                 
                 String fileType = new String(fileChooser.getSelectedExtensionFilter().getExtensions().get(0).substring(2));
                 // 
                 ImageIO.write(SwingFXUtils.fromFXImage(image, null), fileType, file);
                 
                 /*
                 Iterator<ImageReader> imageReaders = ImageIO.getImageReadersByFormatName(fileType);
                 ImageWriter writer = ImageIO.getImageWriter(imageReaders.next());
                 writer.write(image);
                 */
                 
                } catch (IOException e) {
                    //System.out.println("IO Exception");
                } 
            }
        });
        
        menuFile.getItems().addAll(save);
        
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
 
        // --- Menu View
        Menu menuView = new Menu("View"); 
        
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        
        //root.getChildren().addAll(menuBar);
        root.add(menuBar, 0, 0);
        //root.setVgrow(menuBar, ALWAYS);
        root.setVgap(0);
        root.setAlignment(Pos.TOP_RIGHT);
        //root.setGridLinesVisible(true);
        
        
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
