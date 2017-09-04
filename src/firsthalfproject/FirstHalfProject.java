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
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author Bill
 */
public class FirstHalfProject extends Application {
    
    Image image;
    
    @Override
    public void start(Stage primaryStage) {
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //System.out.println("Somthing Highly Visable And Easy to See");
        
        ImageView iv1 = new ImageView();        
        
        VBox root = new VBox();
        
        Scene scene = new Scene(root);
        //Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);       
        
        MenuBar menuBar = new MenuBar();        
 
        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem add = new MenuItem("Open");
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG(*.png)", "*.png"));
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {                
                try {
                    File file = fileChooser.showOpenDialog(primaryStage);
                    image = new Image(new FileInputStream(file));                    
                    
                    iv1.setImage(image);
                    HBox box = new HBox();
                    box.getChildren().add(iv1);
                    root.getChildren().add(box);
                    primaryStage.sizeToScene();                    
                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace(); 
                }                     
            }
        });
        menuFile.getItems().addAll(add);
        MenuItem add2 = new MenuItem("Save");
        add2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                 try {
                 File file = fileChooser.showSaveDialog(primaryStage);
                 file.setWritable(true);
                 FileOutputStream Fout = new FileOutputStream(file);
                 ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", Fout);
                } catch (IOException e) {
                    System.out.println("IO Exception");
                } 
            }
        });
        
        menuFile.getItems().addAll(add2);
        
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
 
        // --- Menu View
        Menu menuView = new Menu("View");
        
        root.getChildren().addAll(menuBar);
 
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        
        primaryStage.setTitle("Hello World!");
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
