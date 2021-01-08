/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class StackPaneTest3 extends Application{
    private StackPane sp;
    @Override
    public void start(Stage stage)  {
        sp = new StackPane();
        Button b1, b2, b3;
        b1 = new Button("Boton 1");
        b2 = new Button("Boton 2");
        b3 = new Button("Boton 3");
        
        StackPane.setAlignment(b1, Pos.CENTER);
        StackPane.setAlignment(b2, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(b3, Pos.TOP_RIGHT);
        sp.getChildren().addAll(b1, b2, b3);
        
        Scene s = new Scene(sp);
        stage.setScene(s);
        stage.show();
    }
        public static void main(String[] args) {
        launch(args);
    }
    
}
