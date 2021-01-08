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
     * 
     */
    public Chronometer(){
        seconds = 120;

        lb = new Label("Countdown: " + seconds.toString());
        lb.setLayoutX(Juego.scene1.getWidth()-100);
        lb.setLayoutY(40);
    }
/**
 * 
 */
    public void doTime() {
        
        seconds = 120;
        
        lb.setText("Countdown: " + seconds.toString());
        
        time = new Timeline();

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                seconds--;
                lb.setText("Countdown: " + seconds.toString());
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
 * 
 * @return 
 */
    public Label getLb() {
        return lb;
    }
/**
 * 
 * @param lb 
 */
    public void setLb(Label lb) {
        this.lb = lb;
    }
/**
 * 
 * @return 
 */
    public static Integer getSeconds() {
        return seconds;
    }
/**
 * 
 * @param seconds 
 */
    public static void setSeconds(Integer seconds) {
        Chronometer.seconds = seconds;
    }
/**
 * 
 * @return 
 */
    public Timeline getTime() {
        return time;
    }
/**
 * 
 * @param time 
 */
    public void setTime(Timeline time) {
        this.time = time;
    }
    
    
    
    
    
    
}
