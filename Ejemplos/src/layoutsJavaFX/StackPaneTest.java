/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class StackPaneTest extends Application {
    private StackPane sp;
    @Override
    public void start(Stage stage)  {
        sp = new StackPane();
        sp.getChildren().addAll(new Button("Boton 1"), new Button("Botont 2"), new Button("Boton 3"));
        
        Scene s = new Scene(sp);
        stage.setScene(s);
        stage.show();
    }
     public static void main(String[] args) {
        launch(args);
    }
}
