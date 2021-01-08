/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import SistemaProeventos.AbstractStage;
import SistemaProeventos.Auxiliar;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class StageRegistroEvento extends AbstractStage{
    
     
    public StageRegistroEvento(){
        
        super("Registro de Evento");
        stage.setScene(obtenerEscena());
    }
    
    @Override
    public Scene obtenerEscena(){
        Scene scene;
        
        Label test = new Label("Coming soon!!! XD");
        
        VBox vbox = new VBox(test);
        
        
        scene = new Scene(vbox,400,400);
        
        return scene;
        
        
    }
}
