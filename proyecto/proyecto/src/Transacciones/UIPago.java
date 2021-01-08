/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import Eventos.Evento;
import java.util.ArrayList;

/**
 * Clase que tiene un atributo transacciones que es una lista de tipo Pago y que almacena los pagos que se
 * vayan a crear
 * @author CORE I7
 */
public class UIPago {
    
    private static ArrayList<Pago> transacciones = new ArrayList<>();
    
    /***
     * constructor vacio
     */
    public UIPago(){}
    
    /***
     * metodo que carga los pagos que han sido guardados previamente en el archivo pagos.txt, y que lo hace recibiendo
     * una lista de strings extraidos de ese archivo
     * @param lista Una lista de Strings que contienen los atributos de los objetos tipo pago que habian sido guardados
     * antes en el sistema
     */
    public static void cargarTransacciones(ArrayList<String> lista){
        for(String linea: lista){
            Pago pago = new Pago(linea);
            transacciones.add(pago);
        }
    }

    /***
     * verifica que el evento enviado como parametro se encuentre referenciado en el atributo evento de algun pago
     * almacenado en la lista transacciones de esta clase UIPago
     * @param evento El objeto tipo Evento del cual se verificara que coincida con la variable de
     * referencia que guarde un objeto tipo Pago en la lista de la clase UIPago
     * @return true Si el evento coincide con la variable de referencia del atributo evento de algun objeto tipo Pago
     * que sea parte de lista de la clase UIPago
     */
    public static boolean verificarPago(Evento evento){
        for(Pago pago: transacciones){
            if(pago.getEvento() == evento){
                return true;
            }
            
        }
        return false;
        
    }
    
    /***
     * agrega un objeto tipo pago a la lista transacciones de esta clase UIPago
     * @param pago Objeto tipo Pago que fue creado anteriormente y que se agregara a la lista
     * definida en UIPago
     */
    public static void anadirPago(Pago pago){
        transacciones.add(pago);
    }

    /***
     * get del atributo transacciones
     * @return La lista tipo Pago que contiene todos los pagos registrados hasta ese instante
     */
    public static ArrayList<Pago> getTransacciones() {
        return transacciones;
    }

    /***
     * set del atributo transacciones
     * @param transacciones Una lista tipo Pago que va a reemplazar el valor actual del atributo transacciones
     */
    public static void setTransacciones(ArrayList<Pago> transacciones) {
        UIPago.transacciones = transacciones;
    }
    
    
}
