
package Sistema;

import Fuentes.ManejoDeArchivos;
import RootsDeEscena.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class Juego extends Application {
    
    private Stage ventana;
    public static PaneInicio organizer1;
    public static Scene scene1,scene2;
    
  /**
   * Metodo para generar roots
   */
    @Override
    public void init(){
        Group gp = new Group();
        scene1 = new Scene(gp,800,600);
        scene1.getStylesheets().add("CSS/estilo1.css");
        
        ManejoDeArchivos.verificarArchivo();
        Auxiliar.generarRoots();
    }
    /**
     * Metodo star que setea el root y muestra la ventana
     * @param Stage stage  
     */
    @Override
    public void start(Stage Stage) {
        
        ventana = Stage;
        organizer1 = new PaneInicio();
        scene1.setRoot(organizer1.getRootInicio());
        
        ventana.setScene(scene1);
        ventana.setTitle("TOY CAR PARKING");
        ventana.getIcons().add(new Image("/image/IconCar.png"));
        ventana.setResizable(false);
        ventana.setOnCloseRequest(e -> {
            e.consume();
            Auxiliar.getPaneS().generarStage();
        });
        ventana.show();
    }

    /**Metodo main
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
