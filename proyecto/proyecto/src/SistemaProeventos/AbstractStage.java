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
public abstract class AbstractStage {
    
    protected Stage stage;
    
    public AbstractStage(String titulo){
        
        stage = new Stage();
        stage.setTitle(titulo);
        stage.setOnCloseRequest(e -> {
                                     e.consume();
                                     Auxiliar.btnCloseClick(stage);
        });
        
    }

    public Stage getStage() {
        return stage;
    }
    
    public abstract Scene obtenerEscena();
}
