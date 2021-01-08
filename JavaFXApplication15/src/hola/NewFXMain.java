/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image ik = new Image("/hola/explotion.png");
        ImageView a = new ImageView(ik);
        a.relocate(300, 300);
        a.setRotate(0);
        a.setFitHeight(100);
        a.setPreserveRatio(true);
        a.setPickOnBounds(false);
        
        

       
        Rectangle border = new Rectangle();
        border.setX(300);
        border.setY(300);
        border.setRotate(0);
        border.setHeight(100);
//        double n = (a.getFitHeight()/a.getImage().getHeight());
//        System.out.println(a);
        border.setWidth((100*a.getImage().getWidth())/a.getImage().getHeight());
        
 
//        border.widthProperty().bind(a.getImage());
        

        border.setFill(Color.AQUA);
        border.setPickOnBounds(true);
        border.setOpacity(0.5);
        
        Pane root = new Pane();
        
        Main test = new Main();
        root.getChildren().addAll(test.getTop(),test.getBottom(),a,border);
        
        Scene scene = new Scene(root, 800, 600);
        
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
