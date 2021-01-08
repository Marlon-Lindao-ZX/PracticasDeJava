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
public class ObjetoFijo extends Elemento {
    
    protected static Vehiculo auto;
    /**
     * Constructor de ObjetoFijo
     * @param ruta ruta
     * @param posX posicion x
     * @param posY posicion y
     */
    public ObjetoFijo(String ruta,double posX,double posY){
        super(ruta,50,50,posX,posY);
    }
    /**
     * Constructor de ObjetoFijo
     * @param path path 
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     */
    public ObjetoFijo(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
    }
/**
 * Obtiene el auto
 * @return auto
 */
    public static Vehiculo getAuto() {
        return auto;
    }
/**
 * Setea el auto
 * @param auto auto
 */
    public static void setAuto(Vehiculo auto) {
        ObjetoFijo.auto = auto;
    }
    
    
}
