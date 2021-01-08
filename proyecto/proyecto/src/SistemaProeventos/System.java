/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class System extends Application{
    
    private static UISistema uis = new UISistema();

    
    
    @Override
    public void init(){
        uis.cargaArchivos();
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Sistema ProEventos");
        LoginStage ls = new LoginStage(primaryStage);
        primaryStage.setScene(ls.getScene());
        primaryStage.setOnCloseRequest(e -> {
                                             e.consume();
                                             Auxiliar.btnCloseClick(primaryStage);
                                      } );
        primaryStage.show();
    }
    
    public static void main (String [] args){
        launch(args);
    }

    
    
}
