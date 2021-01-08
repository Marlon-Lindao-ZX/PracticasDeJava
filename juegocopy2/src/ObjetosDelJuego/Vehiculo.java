/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.Auxiliar;
import RootsDeEscena.Nivel;
import RootsDeEscena.Nivel1;
import RootsDeEscena.PaneVentana;

import Sistema.Juego;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alex
 */
public class Vehiculo extends Elemento {

    private double angulo;
    private double refX;
    private double refY;
    private boolean vivo;
    private double velocity;
    private double giro;
    
    private AnimationTimer timer = new AnimationTimer() {
        /**
         * 
         * @param now 
         */
        @Override
        public void handle(long now) {

            if (vivo) {
                angulo += giro;

                posX += velocity * Math.cos(angulo);
                refX = Math.cos(angulo);

                posY += velocity * Math.sin(angulo);
                refY = Math.sin(angulo);

                elemento.setTranslateX(posX);
                elemento.setTranslateY(posY);
                elemento.setRotate(Math.toDegrees(Math.atan2(refY, refX)));
                
                border.setTranslateX(posX);
                border.setTranslateY(posY);
                border.setRotate(Math.toDegrees(Math.atan2(refY, refX)));
            } else {
                Runnable task = () -> runTask();
                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();
                this.stop();
            }

        }

    };
    /**
     * 
     */
    public Vehiculo() {

    }
    /**
     * 
     * @param path
     * @param posX
     * @param posY
     * @param height 
     */
    public Vehiculo(String path,double posX,double posY,double height) {
        super(path,posX,posY,0.0,height,true);
        angulo = 0;
        vivo = true;
        elemento.setFocusTraversable(true);
        elemento.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case W:
                    velocity = 0;
                    break;
                case S:
                    velocity = 0;
                    break;
                case D:
                    giro = 0;
                    break;
                case A:
                    giro = 0;
                    break;
            }
        });

        elemento.setOnKeyPressed(e -> {
            if (vivo) {
                switch (e.getCode()) {
                    case W:
                        velocity = 3;
                        break;
                    case S:
                        velocity = -3;
                        break;
                    case A:
                        if (velocity != 0) {
                            giro = -0.02;
                        } else {
                            giro = 0;
                        }
                        break;
                    case D:
                        if (velocity != 0) {
                            giro = 0.02;
                        } else {
                            giro = 0;
                        }
                        break;

                } 
            } else {
                timer.stop();
            }

        });
        timer.start();
    }

    
    /**
     * 
     */
    private void runTask(){
        try{
            Thread.sleep(10);
            Platform.runLater( () -> {
                velocity = 0;
                angulo = 0;
                elemento.setRotate(Math.toDegrees(Math.atan2((280-posY), -posX)));
                border.setRotate(Math.toDegrees(Math.atan2((280-posY), -posX)));
                elemento.relocate(-posX, (280-posY));
                border.relocate(-posX, (280-posY));
                vivo = true;
            });
        }catch(InterruptedException ie){
            
        }
    }
    /**
     * 
     * @return 
     */
    public boolean isVivo() {
        return vivo;
    }
/**
 * 
 * @param vivo 
 */
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
/**
 * 
 * @return 
 */
    public double getAngulo() {
        return angulo;
    }
/**
 * 
 * @param angulo 
 */
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
/**
 * 
 * @return 
 */
    public double getRefX() {
        return refX;
    }
/**
 * 
 * @param refX 
 */
    public void setRefX(double refX) {
        this.refX = refX;
    }
/**
 * 
 * @return 
 */
    public double getRefY() {
        return refY;
    }
/**
 * 
 * @param refY 
 */
    public void setRefY(double refY) {
        this.refY = refY;
    }
/**
 * 
 * @return 
 */
    public double getVelocity() {
        return velocity;
    }
/**
 * 
 * @param velocity 
 */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
/**
 * 
 * @return 
 */
    public double getGiro() {
        return giro;
    }
/**
 * 
 * @param giro 
 */
    public void setGiro(double giro) {
        this.giro = giro;
    }
/**
 * 
 * @return 
 */
    public AnimationTimer getTimer() {
        return timer;
    }
/**
 * 
 * @param timer 
 */
    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }
    
    
    
    

}
