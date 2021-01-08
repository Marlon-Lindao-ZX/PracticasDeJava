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
 * Enumerador de los tipos de Eventos que hay en Proeventos
 * @author Marinchi
 */
public enum TipoEvento {
    Boda(1000),Integracion(300),Fiesta_Infantil(700),Otros(0);
    
    private double PRECIO_BASE;
    
    /***
     * Constructor Vacio de TipoEvento
     */
    private TipoEvento(){}
    
    /***
     * Metodo Constructor de TipoEvento
     * @param PRECIO_BASE El precio base correspondiente al tipo de evento
     */  
    private TipoEvento(double PRECIO_BASE){
        this.PRECIO_BASE = PRECIO_BASE;
    }
    /***
     * Metodo getter muestra el valor de PRECIO_BASE
     * @return El precio base del Evento
     */

    public double getPRECIO_BASE() {
        return PRECIO_BASE;
    }
    
    
}
