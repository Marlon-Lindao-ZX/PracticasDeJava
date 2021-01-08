/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import RootsDeEscena.PaneVentana;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author Alex
 */
public class Obstaculo extends ObjetoFijo{
    
    
    /**
     * Constructor de Obstaculo
     * @param ruta ruta
     * @param posX posicion x
     * @param posY posicion y
     */
    public Obstaculo(String ruta,double posX,double posY){
        super(ruta,posX,posY);
    }
    /**
     * Constructor de Obstaculo
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     */
    public Obstaculo(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
//        elemento.boundsInLocalProperty().addListener(e -> {
//            
//            if(auto.getElemento().getLayoutBounds().intersects(elemento.getLayoutBounds())){
//                System.out.println("collision");
//                Runnable task = () -> runTask();
//                Thread thread = new Thread(task);
//                thread.setDaemon(true);
//                thread.start();
//                
//            }
//            
//        });
    }
    /**
     * Genera el stage de crash
     */
    private void runTask() {
        try {
            auto.setVelocity(0);
            Thread.sleep(10);
            Platform.runLater(() -> {

                PaneVentana.generarStageCrash();
            });
        } catch (InterruptedException ie) {

        }
    }
    
   
    
    
}
