/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        PaneOrganizer po = new PaneOrganizer();
        
        Scene scene = new Scene(po.getRoot(), 300, 250);
        
        primaryStage.setTitle("Aplicacion Thread XD!!!");
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
