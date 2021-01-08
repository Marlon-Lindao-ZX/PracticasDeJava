/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.Nivel;
import javafx.animation.Timeline;
import javafx.application.Platform;

/**
 *
 * @author Alex
 */
public class PoderEspecial extends Premio{
    
    private int power;
    
    /**
     * 
     * @param ruta
     * @param posX
     * @param posY 
     */
    public PoderEspecial(String ruta,double posX,double posY){
        super(ruta,posX,posY);
    }
    /**
     * 
     * @param path
     * @param posX
     * @param posY
     * @param angulo
     * @param height
     * @param value
     * @param power 
     */
    public PoderEspecial(String path,double posX,double posY, double angulo,double height,boolean value,int power){
        super(path,posX,posY,angulo,height,value);
        this.power = (power + 1);
    }
    /**
     * 
     * @param level 
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
     * 
     * @param timer
     * @param level 
     */
    private void runTaskPower(Timeline timer,Nivel level) {
        try {
            Thread.sleep(10000);
            Platform.runLater(() -> {
                level.getContainer().getChildren().remove(this.getElemento());
                timer.play();
            });
            
        } catch (InterruptedException ie) {
            System.out.println("problemillas que se estan manejando");
        }
    }
    /**
     * 
     * @param level 
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
