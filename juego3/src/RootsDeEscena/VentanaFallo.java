/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import ObjetosDelJuego.Chronometer;
import Sistema.Juego;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author CORE I7
 */
public class VentanaFallo extends PaneVentana{
/**
 * Metodo para regresar al menu principal
 */
    private EventHandler<ActionEvent> eventBtn1 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            window.close();
            Auxiliar.guardar();
            Auxiliar.setAcumuladorTiempo(0);
            Auxiliar.getLevel1().inicializar();
            Juego.scene1.setRoot(Juego.organizer1.getRootInicio());
            BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
            BackgroundMusic.iniciarThread();
            
        }
    };
    
    /**
     * Metodo continuar nivel 1
     */
        private EventHandler<ActionEvent> eventBtn2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            
            window.close();
            Auxiliar.guardar();
            Auxiliar.setAcumuladorTiempo(0);
            Chronometer.setSeconds(120);
            Auxiliar.getLevel1().inicializar();
            Juego.scene1.setRoot(Auxiliar.getLevel1().getRootNivel());
            Auxiliar.getLevel1().play();
            System.out.println("Nivel 1");
            System.out.println("Continuar");


        }
    };
        

    
    
    /**
     * Constructor de VentanaFallo
     */
    public VentanaFallo(){
        String mensaje = "Perdiste";
        setearElementos1(mensaje, eventBtn2, eventBtn1);
}
    
    /**
     * Metodo para generar el stage
     */
    @Override
    public void generarStage() {
        Auxiliar.updateTime(Chronometer.getSeconds());
        window = new Stage();
        window.initModality(Modality.WINDOW_MODAL);
        
        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.getChildren().addAll(message, contenedorBotones);
        vbox.setSpacing(10);
        
        puntuacion.setText("Puntuacion: " + Nivel.getScore());
        int minutes = Auxiliar.getAcumuladorTiempo() / 60;
        int seconds = Auxiliar.getAcumuladorTiempo() % 60;
        
        String min = "0"+minutes; ;
        String sec;
        
        if(seconds > 9){
            sec = Integer.toString(seconds);
        } else {
            sec = "0"+seconds;
        }
        tiempo.setText("Tiempo: " + min + ":" + sec);
        
        btn1.setText("Reitentar");
        btn2.setText("Salir");
        
        vbox.setAlignment(Pos.CENTER);

        scene = new Scene(vbox, 330, 150);
        scene.getStylesheets().add("CSS/estilo1.css");
        window.setScene(scene);
        window.getIcons().add(new Image("/image/IconCar.png"));
        window.setTitle("Confirmacion");
        window.setOnCloseRequest(e -> {
            e.consume();
            Auxiliar.guardar();
            Auxiliar.setAcumuladorTiempo(0);
            Auxiliar.getLevel1().inicializar();
            Juego.scene1.setRoot(Juego.organizer1.getRootInicio());
            BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
            BackgroundMusic.iniciarThread();
            window.close();
        });
        window.setAlwaysOnTop(true);
        window.initStyle(StageStyle.UTILITY);
        window.showAndWait();
    }
    
}
