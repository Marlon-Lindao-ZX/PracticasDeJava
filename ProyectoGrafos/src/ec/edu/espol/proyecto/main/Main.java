/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.main;


import ec.edu.espol.proyecto.virtual.MainStage;
import javafx.application.Application;

import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Main extends Application {
    

    
    @Override
    public void start(Stage primaryStage) {
        
        
        MainStage mainStage = new MainStage(primaryStage);
        
        System.out.println(mainStage.getGraph().prim());
        
        System.out.println(System.getProperty("user.dir"));
        
        primaryStage.setTitle("Distancias Mas Cortas Entre Ciudades");
        primaryStage.setScene(mainStage.getScene());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
