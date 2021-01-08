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
     * 
     * @param ruta
     * @param posX
     * @param posY 
     */
    public ObjetoFijo(String ruta,double posX,double posY){
        super(ruta,50,50,posX,posY);
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
    public ObjetoFijo(String path,double posX,double posY, double angulo,double height,boolean value){
        super(path,posX,posY,angulo,height,value);
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
        ObjetoFijo.auto = auto;
    }
    
    
}
