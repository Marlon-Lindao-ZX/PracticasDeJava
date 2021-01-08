/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Event;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author CORE I7
 */
public class MainPane {
    
    private BorderPane root;
    private Elefante elephant;
    private static Scene scene;
    private Button neutro;
    private Button aumento;
    private Button reduce;
    
    private EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent ae){
            elephant.aumentar();
            neutro.setText("Reducir");
            neutro.setOnAction(event2);
        }
    };
    
    private EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent ae){
            elephant.reducir();
            neutro.setText("Aumentar");
            neutro.setOnAction(event1);
        }
    };
    
    
    private double posX;
    private double posY;
    
    
    public MainPane(Scene scene){
        root = new BorderPane();
        this.scene = scene;
        generarRoot();
        
        
        
        
        
    }
    
    private void generarRoot(){
        
        elephant = new Elefante();
        
        String style = "-fx-text-fill: white; -fx-background-color: blue; "
                + "-fx-border-color: white; -fx-boder-width: 5px;"
                + "-fx-border-radius: 5px; "           
                + "-fx-effect: dropshadow(one-pass-box, gray, 2, 0.6, 2, 2);";
        
        root.setCenter(elephant.getElefante());
        
        HBox contBotones = new HBox();
        contBotones.setPadding(new Insets(20,40,20,40));
        contBotones.setSpacing(30);
        
        Button adelante = new Button("Desplazar Derecha");
        adelante.setOnAction(e -> {
            elephant.moveBackward();
        });
        adelante.setStyle(style);
        
        
        Button atras = new Button("Desplazar Izquierda");
        atras.setOnAction(e -> {
            elephant.moveForward();
        });
        atras.setStyle(style);
        
        neutro = new Button("Aumento");
        neutro.setOnAction(event1);
        neutro.setStyle(style);
        
        
        
        contBotones.getChildren().addAll(adelante,atras,neutro);
        contBotones.setAlignment(Pos.CENTER);
        root.setBottom(contBotones);
        
        
       
    }

    public BorderPane getRoot() {
        return root;
    }

    public Elefante getElephant() {
        return elephant;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public void setElephant(Elefante elephant) {
        this.elephant = elephant;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        MainPane.scene = scene;
    }
    
    
    
    
}
