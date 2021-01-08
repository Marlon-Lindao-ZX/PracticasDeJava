/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.Nivel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class Premio extends Elemento{
    
    protected static Vehiculo auto;
    protected Timeline lifeLine;
    /**
     * 
     * @param ruta
     * @param posX
     * @param posY 
     */
    public Premio(String ruta,double posX,double posY){
        super(ruta,25,25,posX,posY);
    }
    /**
     * 
     * @param path
     * @param posX
     * @param posY
     * @param angulo
     * @param height
     * @param value 
     */
    public Premio(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
        lifeLine = new Timeline(new KeyFrame(Duration.seconds(15)));
        lifeLine.setCycleCount(1);
        
    }
    /**
     * 
     * @param level 
     */
    public void play(Nivel level){
        lifeLine.setOnFinished(e -> {
            level.getContainer().getChildren().remove(this.getElemento());
            level.getParkPrizes().remove(this);
            
        });
        
        lifeLine.play();
    }
    /**
     * 
     * @return 
     */
    public static Vehiculo getAuto() {
        return auto;
    }
    /**
     * 
     * @param auto 
     */
    public static void setAuto(Vehiculo auto) {
        Premio.auto = auto;
    }
    
    
}
