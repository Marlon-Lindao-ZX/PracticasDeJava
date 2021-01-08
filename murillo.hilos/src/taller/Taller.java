/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class Taller extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PanelMenuPrincipal organizer=new PanelMenuPrincipal();
        Scene escena = new Scene(organizer.getRoot(),400,500);
        primaryStage.setScene(escena);
        primaryStage.setTitle("Registration Form");
        primaryStage.show();
        
    }
    
}
