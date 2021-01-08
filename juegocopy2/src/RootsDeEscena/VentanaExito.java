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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class VentanaExito extends PaneVentana{
    
    private int time;
    private int score;
    private int control;
    
    
    /**
     * 
     */
    private EventHandler<ActionEvent> eventBtn1 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            
            window.close();
            Auxiliar.updateTime(Chronometer.getSeconds());
            Chronometer.setSeconds(120);
            Auxiliar.getLevel2().inicializar();
            Juego.scene1.setRoot(Auxiliar.getLevel2().getRootNivel());
            Auxiliar.getLevel2().play();
            System.out.println("Nivel 2");
            System.out.println("Continuar");
        }
    };
    /**
     * 
     */
    private EventHandler<ActionEvent> eventBtn2 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            
            window.close();
            Auxiliar.guardar();
            Auxiliar.setAcumuladorTiempo(0);
            Auxiliar.getLevel1().inicializar();
            Juego.scene1.setRoot(Juego.organizer1.getRootInicio());
            BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
            BackgroundMusic.iniciarThread();
            System.out.println("Menu Principal");
        }
    };
    /**
     * 
     */
    private EventHandler<ActionEvent> eventBtn3 = new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
            
            window.close();
            Auxiliar.updateTime(Chronometer.getSeconds());
            Chronometer.setSeconds(120);
            Auxiliar.getLevel3().inicializar();
            Juego.scene1.setRoot(Auxiliar.getLevel3().getRootNivel());
            Auxiliar.getLevel3().play();
            System.out.println("Nivel 3");
        }
    };
    
    
    /**
     * 
     */
    public VentanaExito() {
        String mensaje = "Has ganado";
        control = 1;
        setearElementos1(mensaje, eventBtn1, eventBtn2);

    }
    /**
     * 
     * @param controller 
     */
    public void setearVentana(int controller){
        String mensaje = "Has ganado";
        control = controller;
        switch(controller){
            case 1:
                setearElementos1(mensaje,eventBtn1,eventBtn2);
                break;
            case 2:
                setearElementos1(mensaje,eventBtn3,eventBtn2);
                break;
            case 3:
                setearElementos("Felicitaciones"+"\n"+"Has superado todos los niveles XD","Guardar y Salir",eventBtn2);
                break;
        }
        
    }
    
    
    /**
     * 
     */
    @Override
    public void generarStage() {
        if (control == 3) {
            window = new Stage();

            puntuacion.setText("Puntuacion: " + Nivel.getScore());
            int minutes = (120 - Chronometer.getSeconds()) / 60;
            int seconds = (120 - Chronometer.getSeconds()) % 60;

            String min = "0" + minutes;
            String sec;

            if (seconds > 9) {
                sec = Integer.toString(seconds);
            } else {
                sec = "0" + seconds;
            }
            tiempo.setText("Tiempo: " + min + ":" + sec);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(message, puntuacion, tiempo, btn1);
            vbox.setSpacing(10);
            vbox.setId("vbox");

            

            vbox.setAlignment(Pos.CENTER);

            scene = new Scene(vbox, 330, 150);
            scene.getStylesheets().add("CSS/estilo1.css");
            window.setScene(scene);
            window.setTitle("Car Toy Parking");
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
            window.showAndWait();

        } else {
            window = new Stage();

            puntuacion.setText("Puntuacion: " + Nivel.getScore());
            int minutes = (120 - Chronometer.getSeconds()) / 60;
            int seconds = (120 - Chronometer.getSeconds()) % 60;

            String min = "0" + minutes;;
            String sec;

            if (seconds > 9) {
                sec = Integer.toString(seconds);
            } else {
                sec = "0" + seconds;
            }
            tiempo.setText("Tiempo: " + min + ":" + sec);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(message, puntuacion, tiempo, contenedorBotones);
            vbox.setSpacing(10);
            vbox.setId("vbox");

            btn1.setText("Continuar");
            btn2.setText("Salir");

            vbox.setAlignment(Pos.CENTER);

            scene = new Scene(vbox, 330, 150);
            scene.getStylesheets().add("CSS/estilo1.css");
            window.setScene(scene);
            window.setTitle("Car Toy Parking");
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
            window.showAndWait();
        }
    }
/**
 * 
 * @return 
 */
    public int getTime() {
        return time;
    }
/**
 * 
 * @param time 
 */
    public void setTime(int time) {
        this.time = time;
    }
/**
 * 
 * @return 
 */
    public int getScore() {
        return score;
    }
/**
 * 
 * @param score 
 */
    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
