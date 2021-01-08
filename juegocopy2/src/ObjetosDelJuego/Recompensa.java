/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

/**
 *
 * @author CORE I7
 */
public class Recompensa extends Premio{
    /**
     * 
     * @param ruta
     * @param posX
     * @param posY 
     */
    public Recompensa(String ruta,double posX,double posY){
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
     */
    public Recompensa(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
    }
}
