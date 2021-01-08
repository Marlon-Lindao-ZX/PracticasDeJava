/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Verónica
 */
public class handlers extends Application {

    @Override
    public void start(Stage primaryStage) {
        EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("handler1...");
            }
        };

        EventHandler<MouseEvent> handler2 = (MouseEvent event) -> {
            System.out.println("handler2...");
        };

        Button btn = new Button();
        btn.setText("Button");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Manejo de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
