/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.Nivel;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;

/**
 *
 * @author Alex
 */
public class PoderEspecial extends Premio{
    
    private int power;
    
    /**
     * Constructor de PoderEspecial
     * @param ruta ruta
     * @param posX posicion x
     * @param posY posicion y
     */
    public PoderEspecial(String ruta,double posX,double posY){
        super(ruta,posX,posY);
    }
    /**
     * Constructor de PoderEspecial
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     * @param power poder
     */
    public PoderEspecial(String path,double posX,double posY, double angulo,double height,boolean value,int power){
        super(path,posX,posY,angulo,height,value);
        this.power = (power + 1);
    }
    /**
     * Remueve los elementos
     * @param level nivel
     */
    @Override
    public void play(Nivel level){
        switch(power){
            case 1:
                elemento.setOnMouseClicked(e ->{
                   level.getContainer().getChildren().remove(this.getElemento());
                   if((level.getLife()+1)<3){
                    Runnable taskPower = () -> runTaskPower2(level);
                    Thread threadPower = new Thread(taskPower);
                    threadPower.setDaemon(true);
                    threadPower.start();
                   } 
                   
                });
                break;
            case 2:
                elemento.setOnMouseClicked(e ->{
                    Nivel.setCrash(this.elemento);
                    level.getContainer().getChildren().remove(this.getElemento());
                    level.gettLine().stop();
                    Runnable taskPower = () -> runTaskPower(level.gettLine(),level);
                    Thread threadPower = new Thread(taskPower);
                    threadPower.setDaemon(true);
                    threadPower.start();
                });
                break;
            case 3:
                elemento.setOnMouseClicked(e ->{
                    Nivel.setCrash(this.elemento);
                    level.getContainer().getChildren().remove(this.getElemento());
                    level.getTime().getTime().stop();
                    Runnable taskPower = () -> runTaskPower(level.getTime().getTime(),level);
                    Thread threadPower = new Thread(taskPower);
                    threadPower.setDaemon(true);
                    threadPower.start();
                });
                break;
        }
        
        lifeLine.setOnFinished(e -> {
            level.getContainer().getChildren().remove(this.getElemento());
            level.getParkPrizes().remove(this);
            
        });
        
        lifeLine.play();
    }
    /**
     * Remueve los elementos
     * @param timer timer
     * @param level nivel
     */
    private void runTaskPower(Timeline timer,Nivel level) {
        try {
            Nivel.setCrash(this.elemento);
            Thread.sleep(10000);
            Nivel.getCrash().setImage(new Image("/image/explotion.png",30,30,true,true));
            Platform.runLater(() -> {
                Nivel.setCrash(this.elemento);
                level.getContainer().getChildren().remove(this.getElemento());
                timer.play();
            });
            
        } catch (InterruptedException ie) {
            System.out.println("problemillas que se estan manejando");
        }
    }
    /**
     * Remueve los elementos
     * @param level nivel
     */
    private void runTaskPower2(Nivel level) {
        try {
            Thread.sleep(10);
            Platform.runLater(() -> {
                level.setLife((level.getLife()) + 1);
                level.getVida().setText("Vidas: " + level.getLife());
                level.getContainer().getChildren().remove(this.getElemento());
            });
        } catch (InterruptedException ie) {
            System.out.println("ooo");
        }
    }
}
