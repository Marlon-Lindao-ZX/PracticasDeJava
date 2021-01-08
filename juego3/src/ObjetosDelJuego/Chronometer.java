/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.Auxiliar;
import Sistema.Juego;
import java.time.LocalTime;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public class Chronometer {

    private static Integer seconds;
    private Label lb;
    private Timeline time;
    /**
     * Constructor de Chronometer
     */
    public Chronometer(){
        seconds = 120;

        lb = new Label("TIEMPO: " + seconds.toString());
        
        lb.setLayoutX(Juego.scene1.getWidth()-100);
        lb.setLayoutX(50);
        lb.setLayoutY(100);
    }
/**
 * Metodo para setear el contador
 */
    public void doTime() {
        
        seconds = 120;
        
        lb.setText("TIEMPO: " + seconds.toString());
                
        time = new Timeline();

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                seconds--;
                lb.setText("TIEMPO: " + seconds.toString());
                if(seconds >= 80){
            lb.setStyle("-fx-text-fill: GREEN;-fx-font-weight: bold;-fx-font-size: 20px");
        }else if(seconds < 80 && seconds >=40){
            lb.setStyle("-fx-text-fill: YELLOW;-fx-font-weight: bold;-fx-font-size: 20px");
        }else{
            lb.setStyle("-fx-text-fill: RED;-fx-font-weight: bold;-fx-font-size: 20px");
        }
                if (seconds <= 0) {
                    Platform.runLater(() ->{
                        time.stop();
                        Auxiliar.getPaneF().generarStage();
                    });
                }

            }

        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if (time != null) {
            time.stop();
        }
        time.play();
       
    }
/**
 * Obtiene el label
 * @return label
 */
    public Label getLb() {
        return lb;
    }
/**
 * setea el label
 * @param lb label
 */
    public void setLb(Label lb) {
        this.lb = lb;
    }
/**
 * obtiene los segundos
 * @return segundos
 */
    public static Integer getSeconds() {
        return seconds;
    }
/**
 * setea los segundos
 * @param seconds segundos
 */
    public static void setSeconds(Integer seconds) {
        Chronometer.seconds = seconds;
    }
/**
 * obtiene el tiempo
 * @return tiempo
 */
    public Timeline getTime() {
        return time;
    }
/**
 * setea el tiempo
 * @param time tiempo
 */
    public void setTime(Timeline time) {
        this.time = time;
    }
    
    
    
    
    
    
}
