
package auto;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class PaneSalir extends PaneVentana{
    
    private EventHandler<ActionEvent> eventBtn1 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            Platform.exit();
        }
    };
    
    private EventHandler<ActionEvent> eventBtn2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            window.close();
        }
    };
    
    public PaneSalir(){
        String mensaje = "¿Desea salir del programa?";
        setearElementos(mensaje,"Si","No",eventBtn1,eventBtn2);
        
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
