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
         * Metodo handle
         * @param now numero
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
     * Constructor de vehiculo
     */
    public Vehiculo() {

    }
    /**
     *Constructor de Vehiculo 
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param height height
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
     * Metodo runTask
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
     * Obtiene si esta vivo
     * @return boolean
     */
    public boolean isVivo() {
        return vivo;
    }
/**
 * Setea si esta vivo
 * @param vivo boolean
 */
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
/**
 * Obtiene el angulo
 * @return angulo
 */
    public double getAngulo() {
        return angulo;
    }
/**
 * Setea el angulo
 * @param angulo angulo
 */
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
/**
 * Obtiene la referencia x
 * @return referencia
 */
    public double getRefX() {
        return refX;
    }
/**
 * Setea la referencia x
 * @param refX referencia
 */
    public void setRefX(double refX) {
        this.refX = refX;
    }
/**
 * Obtiene la referencia y
 * @return referencia
 */
    public double getRefY() {
        return refY;
    }
/**
 * Setea la referencia y
 * @param refY referencia
 */
    public void setRefY(double refY) {
        this.refY = refY;
    }
/**
 * Obtiene la velocidad
 * @return velocidad
 */
    public double getVelocity() {
        return velocity;
    }
/**
 * Setea la velocidad
 * @param velocity velocidad
 */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
/**
 * Obtiene el giro
 * @return giro
 */
    public double getGiro() {
        return giro;
    }
/**
 * Setea el girp
 * @param giro giro
 */
    public void setGiro(double giro) {
        this.giro = giro;
    }
/**
 * Obtiene el timer
 * @return timer
 */
    public AnimationTimer getTimer() {
        return timer;
    }
/**
 * Setea el timer
 * @param timer 
 */
    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }
    
    
    
    

}
