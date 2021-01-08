/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import Sistema.Juego;
import static Sistema.Juego.scene1;
import java.time.LocalTime;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author CORE I7
 */
public abstract class PaneVentana {
    
    protected Scene scene;
    protected Text message;
    protected Text puntuacion;
    protected Text tiempo;
    protected Button btn1;
    protected Button btn2;
    
    protected HBox contenedorBotones;
    protected Stage window;
    private static Runnable task;
    private static Thread test;
   
    /**
     * Metodo para generar stage
     */
    public abstract void generarStage();
    /**
     * Metodo para generar el stage crash
     */
    public static void generarStageCrash(){
        Stage crashStage = new Stage();
        crashStage.initModality(Modality.APPLICATION_MODAL);
        crashStage.initStyle(StageStyle.UNIFIED);
        
        StackPane root = new StackPane();
        
        Label texto = new Label("Crash!!!");
        texto.setOnMouseClicked(e ->{
            
        });
        
        root.getChildren().add(texto);
        
        Scene scene = new Scene(root,400,250);
        scene.getStylesheets().add("CSS/estilo1.css");
        
        scene.setOnMouseClicked(e -> {
            e.consume();
            task = () -> runTask();
            test = new Thread(task); 
            test.setDaemon(true);
            test.start();
            crashStage.close();
        });
        
        crashStage.setScene(scene);
        
        crashStage.show();
    }
    /**
     * Metodo runTask
     */
    private static void runTask() {
        try{
            Thread.sleep(20);
            Platform.runLater(() -> {
                
                
                Auxiliar.getLevel1().getVehicle().getElemento().setX(0);
                Auxiliar.getLevel1().getVehicle().getElemento().setY(0);
                Auxiliar.getLevel1().getVehicle().setVivo(true);
            });
        } catch (InterruptedException ie) {

        }
    }
    /**
     * Metodo para setear elementos
     * @param mensaje mensaje
     * @param nameBtn1 nombre boton1
     * @param nameBtn2 nombre boton2
     * @param eventBtn1 evento1
     * @param eventBtn2 evento2
     */
    public void setearElementos(String mensaje,String nameBtn1,String nameBtn2,
                                EventHandler<ActionEvent> eventBtn1,EventHandler<ActionEvent> eventBtn2){
        message = new Text(mensaje);
        message.setId("mensaje");

        btn1 = new Button(nameBtn1);
        btn1.setId("btn1");
        
        btn2 = new Button(nameBtn2);
        btn2.setId("btn2");
        
        btn1.setOnAction(eventBtn1);
        btn2.setOnAction(eventBtn2);

        contenedorBotones = new HBox();
        
        
        contenedorBotones.getChildren().addAll(btn1, btn2);
        contenedorBotones.setSpacing(30);
        contenedorBotones.setAlignment(Pos.CENTER);

    }
    /**
     * Setea los elementos
     * @param mensaje mensaje
     * @param nameBtn1 nombre boton
     * @param eventBtn1 evento1
     */
    public void setearElementos(String mensaje,String nameBtn1,
                                EventHandler<ActionEvent> eventBtn1){
        message = new Text(mensaje);
        message.setId("mensaje");

        btn1 = new Button(nameBtn1);
        btn1.setId("btn1");
        
        
        btn1.setOnAction(eventBtn1);

        contenedorBotones = new HBox();
        
        
        contenedorBotones.getChildren().add(btn1);
        contenedorBotones.setSpacing(30);
        contenedorBotones.setAlignment(Pos.CENTER);

    }
    /**
     * Setea los elementos1
     * @param mensaje mensaje
     * @param eventBtn1 evento1
     * @param eventBtn2 evento2
     */
    public void setearElementos1(String mensaje,
                                EventHandler<ActionEvent> eventBtn1,EventHandler<ActionEvent> eventBtn2){
        message = new Text(mensaje);
        message.setId("mensaje");
        tiempo=new Text("Tiempo: ");
        tiempo.setId("texto");
        puntuacion=new Text("Puntuacion: ");
        puntuacion.setId("texto");
        
        btn1=new Button("Continuar");
        btn1.setId("btn1");
        btn1.setOnAction(eventBtn1);
        
        btn2=new Button("Menu Principal");
        btn2.setId("btn1");
        btn2.setOnAction(eventBtn2);
        
        contenedorBotones = new HBox();
        
        
        contenedorBotones.getChildren().addAll(btn1,btn2);
        contenedorBotones.setSpacing(30);
        contenedorBotones.setAlignment(Pos.CENTER);
        
        
    }
    
}
