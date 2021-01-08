/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Group gp = new Group();
        
        Scene scene = new Scene(gp,800,600);
        
        MainPane mp = new MainPane(scene);
        
        
        scene.setRoot(mp.getRoot());
       
        
        primaryStage.setTitle("Elephant Animation!!! XD");
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
