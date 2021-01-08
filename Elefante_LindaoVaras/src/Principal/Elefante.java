/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public class Elefante {
    
    private ImageView elefante;
    private double velocityX;
    private double velocityY;
   
    private double tempX;
    private double tempY;
    private double tx;
    private double ty;
  
    
    private AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long now) {
           
            tempX = elefante.getTranslateX() + velocityX;
            tempY = elefante.getTranslateY() + velocityY;

            if (!((tempX <= -(MainPane.getScene().getWidth() / 2) + 30 || tempX >= (MainPane.getScene().getWidth() / 2) - 33)
                    || (tempY <= -(MainPane.getScene().getHeight() / 2) + 73 || tempY >= (MainPane.getScene().getHeight() / 2) - 7))) {

                elefante.relocate(tempX, tempY);
                elefante.setTranslateX(tempX);
                elefante.setTranslateY(tempY);
            }
            
            
           

        }
    };
    
    public Elefante(){
       
        elefante = new ImageView(new Image("Fuentes/elefante-1.png",80,80,true,true));
        elefante.setFocusTraversable(true);
        elefante.setOnKeyPressed(e -> {
           
            e.consume();
            switch(e.getCode()){
                case UP:
                    velocityY = -3;
                    System.out.println(e.getCode());
                    break;
                case DOWN:
                    velocityY = 3;
                    System.out.println(e.getCode());
                    break;
                case LEFT:
                    velocityX = -3;
                    System.out.println(e.getCode());
                    break;
                case RIGHT:
                    velocityX = 3;
                    System.out.println(e.getCode());
                    break;
            }
            
        });
        
        elefante.setOnKeyReleased(e -> {
            
            switch(e.getCode()){
                case UP:
                    velocityY = 0;
                    break;
                case DOWN:
                    velocityY = 0;
                    break;
                case LEFT:
                    velocityX = 0;
                    break;
                case RIGHT:
                    velocityX = 0;
                    break;
            }
            
        });
        
       MainPane.getScene().setOnMouseClicked(e -> {
           
           tx = e.getSceneX() - MainPane.getScene().getWidth() / 2;
           ty = e.getSceneY() - MainPane.getScene().getHeight() / 2;
           
           elefante.setTranslateX(tx);
           elefante.setTranslateY(ty);
          
       });
        
        timer.start();
        
    }
    
    public void aumentar() {
        ScaleTransition trans = new ScaleTransition(Duration.seconds(2), elefante);
        trans.setFromX(1.0);
        trans.setToX(2.0);
        trans.setFromY(1.0);
        trans.setToY(2.0);
        trans.setAutoReverse(false);
        trans.play();
    }

    public void reducir() {
        ScaleTransition trans = new ScaleTransition(Duration.seconds(2), elefante);
        trans.setFromX(2.0);
        trans.setToX(1.0);
        trans.setFromY(2.0);
        trans.setToY(1.0);
        trans.setAutoReverse(false);
        trans.play();
    }
    
    public void moveForward(){
        TranslateTransition trans = new TranslateTransition(Duration.seconds(4), elefante);
		trans.setFromX(elefante.getTranslateX());
		trans.setToX((MainPane.getScene().getWidth()/2)-33);
		trans.setAutoReverse(false);
		trans.play();	
    }
    
    public void moveBackward(){
        TranslateTransition trans = new TranslateTransition(Duration.seconds(4), elefante);
		trans.setFromX(elefante.getTranslateX());
		trans.setToX(-(MainPane.getScene().getWidth()/2)+30);
		trans.setAutoReverse(false);
		trans.play();	
    }

    public ImageView getElefante() {
        return elefante;
    }

    public AnimationTimer getTimer() {
        return timer;
    }
    
    
}
