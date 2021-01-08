/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class VBoxTest1  extends Application{
     private VBox cajaVertical;

    @Override
    public void start(Stage stage) {
        cajaVertical = new VBox(10);//Asignamos 10 pixeles de separacion entre los nodos
        cajaVertical.setPadding(new Insets(15)); //Agregamos un relleno de 15 pixeles para separarlo del borde de la ventana
        cajaVertical.getChildren().addAll(new Button("Boton 1"), new Button("Boton 2"), new Button("Boton 3"));//llamando al metodo addAll podemos agregar nodos en una sola linea
        
        Scene s = new Scene(cajaVertical);
        stage.setScene(s);
        stage.show();
    }
     public static void main(String[] args) {
        launch(args);
    }
}
