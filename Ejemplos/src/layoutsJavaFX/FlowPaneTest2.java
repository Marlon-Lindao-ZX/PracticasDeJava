/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class FlowPaneTest2 extends Application {
    private FlowPane flow;
    @Override
    public void start(Stage stage)  {
        flow = new FlowPane(Orientation.VERTICAL);//Establecemos la orientación
        flow.getChildren().addAll(new Button("Boton 1"), new Button("Boton 2"), new Button("Boton 3"));
        
        Scene s = new Scene(flow);
        stage.setScene(s);
        stage.show();
    }
     public static void main(String[] args) {
        launch(args);
    }
}
