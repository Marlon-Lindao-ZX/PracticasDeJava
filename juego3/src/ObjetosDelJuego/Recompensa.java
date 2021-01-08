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
     * Constructor de Recompensa
     * @param ruta ruta
     * @param posX posicion x
     * @param posY posicion y
     */
    public Recompensa(String ruta,double posX,double posY){
        super(ruta,posX,posY);
    }
    /**
     * Constructor de Recompensa
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     */
    public Recompensa(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
    }
}
