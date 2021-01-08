/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constantes;

/**
 *
 * @author CORE I7
 */

/*** 
 * Enumerador de los elementos adicionales de un evento
 * @author Marinchi
 */
public enum TipoElementos {
    
    MENU(15),BOCADITOS(20),WHISKY(50),VODKA(25),CERVEZA(3),REFRESCOS(1),DJ(300)
    ,BANDA(2000),FOTOGRAFIA(500),DECORACION(900),ANIMADOR(300);
    
    private double precio;
    
    /***
     * Metodo constructor de TipoElementos
     * @param precio El precio unitario de este tipo de elemento
     */
    
    private TipoElementos(double precio){
        this.precio = precio;
    }
    
    /***
     * Metodo getter muestra el valor de precio
     * @return Devuelve el precio unitario de este elemento
     */

    public double getPrecio() {
        return precio;
    }
    
    
    
}
