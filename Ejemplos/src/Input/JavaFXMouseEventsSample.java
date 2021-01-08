/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 *
 * @author Veronica
 */
public class JavaFXMouseEventsSample extends Application{
     @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Detectar ratón pulsado
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se pulse el ratón
                System.out.println("Mouse pressed X : Y - " + 
                        mouseEvent.getX() + " : " + mouseEvent.getY());
            }
        });
        
        // Detectar ratón soltado
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se suelte el ratón
                System.out.println("Mouse released X : Y - " + 
                        mouseEvent.getX() + " : " + mouseEvent.getY());
            }
        });
        
        // Detectar clic en ratón (pulsado y soltado)
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
                System.out.println("Mouse clicked X : Y - " + 
                        mouseEvent.getX() + " : " + mouseEvent.getY());
                // También se puede comprobar sobre qué botón se ha actuado,
                //  válido para cualquier acción (pressed, released, clicked, etc) 
                if(mouseEvent.getButton() == MouseButton.PRIMARY) {
                    System.out.println("Botón principal");
                } else if(mouseEvent.getButton() == MouseButton.SECONDARY) {
                    System.out.println("Botón secundario");
                }
            }
        });
        
        /* Más información:
            En la API de JavaFX para la clase Scene se puede ver los distintos
            métodos existentes para detectar eventos del ratón. Son aquellos
            cuyo nombre empieza por setOnMouse......
            https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
        */
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
