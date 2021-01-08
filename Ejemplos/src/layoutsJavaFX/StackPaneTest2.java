/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class StackPaneTest2 extends Application {
    private StackPane sp;
    @Override
    public void start(Stage stage)  {
        sp = new StackPane();
        sp.setPadding(new Insets(15));
        //sp.setAlignment(Pos.BOTTOM_RIGHT);//Simplemente asignamos la alineacion al objeto
        sp.getChildren().addAll(new Rectangle(150, 150, Color.DARKBLUE),new Button("Boton 1"));
        
        Scene s = new Scene(sp);
        stage.setScene(s);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
