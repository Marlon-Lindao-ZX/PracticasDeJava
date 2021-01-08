/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class Formulario extends Application {
    
    static ArrayList<Persona> personas = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(30);
        root.setStyle("-fx-background: ORANGE");
        
        Label titulo = new Label("Formulario Registro");
        titulo.setAlignment(Pos.CENTER);
        titulo.setStyle("-fx-font-size:1.5em; -fx-font-weight:bolder");
        
        GridPane gp = new GridPane();
        
        Label nombre = new Label("Nombre: ");
        Label cedula = new Label("Cedula: ");
        Label direccion = new Label("Direccion: ");
        
        TextField tf1 = new TextField();
        tf1.setMaxWidth(250);
        tf1.setPromptText("(Ingrese aqui su nombre)");
        TextField tf2 = new TextField();
        tf2.setMaxWidth(250);
        tf2.setPromptText("(Ingrese aqui su cedula)");
        TextArea ta = new TextArea();
        ta.setMaxWidth(250);
        ta.setPromptText("(Ingrese aqui su direccion)");
        
        gp.add(nombre,0,0);
        gp.add(tf1,1,0);
        gp.add(cedula,0,1);
        gp.add(tf2,1,1);
        gp.add(direccion,0,2);
        gp.add(ta,1,2);
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        
        
        HBox hbox = new HBox(20);
        
        
        Button btn1 = new Button("Limpiar");
        btn1.setStyle("-fx-text-fill: white; -fx-background-color: darkslateblue; ");
        btn1.setOnAction(new EventHandler<ActionEvent> () {
            
            @Override
            public void handle(ActionEvent event){
                tf1.clear();
                tf2.clear();
                ta.clear();
            }
        });
        Button btn2 = new Button("Guardar");
        btn2.setStyle("-fx-text-fill: white; -fx-background-color: darkslateblue; ");
        btn2.setOnAction(new EventHandler<ActionEvent> () {
            
            @Override
            public void handle(ActionEvent event){
                Persona persona = new Persona(tf1.getText(),tf2.getText(),ta.getText());
                personas.add(persona);
            }
        });
        Button btn3 = new Button("Salir");
        btn3.setStyle("-fx-text-fill: white; -fx-background-color: darkslateblue; ");
        btn3.setOnAction(new EventHandler<ActionEvent> () {
            
            @Override
            public void handle(ActionEvent event){
                System.out.println("Hello Word!!!");
                primaryStage.close();
            }
        });
        
        hbox.getChildren().addAll(btn1,btn2,btn3);
        hbox.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(titulo,gp,hbox);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root,400,400);
        
        
        primaryStage.setTitle("Formulario Practica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
        for(Persona persona: personas) System.out.println(persona);

            
        
    }
    
}
