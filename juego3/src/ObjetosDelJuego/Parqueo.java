/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

/**
 *
 * @author Alex
 */
public class Parqueo extends ObjetoFijo{
    /**
     * Constructor de Parqueo
     * @param ruta ruta
     * @param posX posicion x
     * @param posY posicion y
     */
    public Parqueo(String ruta,double posX,double posY){
        super(ruta,posX,posY);
    }
    /**
     * Constructor de Parqueo
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     */
    public Parqueo(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
    }
}
