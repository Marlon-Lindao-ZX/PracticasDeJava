
package RootsDeEscena;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class PaneSalir extends PaneVentana{
    
    private EventHandler<ActionEvent> eventBtn1 = new EventHandler<ActionEvent>(){
        /**
         * Metodo para salir del juego
         * @param event 
         */
        @Override
        public void handle(ActionEvent event){
            Platform.exit();
        }
    };
    /**
     * Metodo para cerrar el stage
     */
    private EventHandler<ActionEvent> eventBtn2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            window.close();
        }
    };
    /**
     * Constructor de PaneSalir
     */
    public PaneSalir(){
        String mensaje = "¿Desea salir del juego?";
        setearElementos(mensaje,"Si","No",eventBtn1,eventBtn2);
        
    }
    
    /**
     * Metodo para generar stage
     */
    @Override
    public void generarStage(){
        window = new Stage();
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(message, contenedorBotones);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: lightblue;");
        vbox.setAlignment(Pos.CENTER);

        scene = new Scene(vbox, 330, 150);
        scene.getStylesheets().add("CSS/estilo1.css");
        window.setScene(scene);
        window.getIcons().add(new Image("/image/IconCar.png"));
        window.setTitle("Confirmacion");
        window.show();
        
    }
    
    

    
    
    
    
    

    
    
}
