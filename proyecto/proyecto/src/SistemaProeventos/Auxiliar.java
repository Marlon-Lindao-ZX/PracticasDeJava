/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Auxiliar {
    
    public static void btnCloseClick(Stage stage){
        
        boolean quit;
        
        quit = ConfirmationBox.show("¿Realmente desea salir?","Confirmacion","Si","No");
        
        if(quit){
            stage.close();
        }
        
    }
    
    public static void btnCerrarSesionClick(Stage stage, Scene scene){
        
        boolean cierre;
        
        cierre = ConfirmationBox.show("¿Realmente desea cerrar sesion?","Confirmacion","Si","No");
        
        if(cierre){
            
            stage.setScene(scene);
            
        }
        
    }
    
    public static void btnOpenStage(Stage stage){
        
        stage.show();
        
    }
}
