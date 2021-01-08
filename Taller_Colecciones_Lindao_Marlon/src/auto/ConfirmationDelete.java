/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class ConfirmationDelete extends PaneVentana {
    
    private EventHandler<ActionEvent> event1 = e -> {
        
        Auxiliar.deleteAuto(Auxiliar.getSecStage().getAutoSelection());
        window.close();
        
    };
    
    private EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            window.close();
        }
    };
    
    public ConfirmationDelete(){
        String mensaje = "¿Desea eliminar este auto?";
        setearElementos(mensaje,"Si","No",event1,event2);
    }
    
    @Override
    public void generarStage(){
        window = new Stage();
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(message, contenedorBotones);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: lightblue;");
        vbox.setAlignment(Pos.CENTER);

        scene = new Scene(vbox, 330, 150);
        window.setScene(scene);
        window.setTitle("Confirmacion");
        window.show();
        
    }
}
