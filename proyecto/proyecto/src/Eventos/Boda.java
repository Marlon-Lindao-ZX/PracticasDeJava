/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Constantes.TipoEvento;
import Elementos.Elemento;
import Usuarios.Cliente;
import Usuarios.Planificador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *Clase que hereda de Evento
 * @author CORE I7
 */
public class Boda extends Evento{
    private String tipoVehiculo;
    
    /***
     * constructor vacio de boda
     */
    public Boda(){
        
    }
    
    /***
     * constructor con parametros y que llama al constructor correspondiente de la clase padre
     * @param tipo tipo evento
     * @param cliente cliente
     * @param lugar lugar
     * @param fecha fecha
     * @param horaInicio hora de inicio
     * @param horaFin  hora fin
     * @param capacidad capacidad
     * @param planificador planificador
     * @param elementos elementos
     * @param tipoVehiculo tipo de vehiculo
     */
    public Boda(TipoEvento tipo,  Cliente cliente, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                  int capacidad, Planificador planificador,
                  ArrayList<Elemento> elementos, String tipoVehiculo ){
        super(tipo,cliente,lugar,fecha,horaInicio,horaFin,capacidad,planificador,elementos);
        this.tipoVehiculo = tipoVehiculo;
        
    }
    
    /***
     *constructor que recibe dos parametros, un string y otro de tipo evento, y que ademas llama al constructor copia de la clase padre 
     * @param evento tipo de evento
     * @param tipoVehiculo tipo de vehiculo
     */
    public Boda(Evento evento, String tipoVehiculo){
        super(evento);
        this.tipoVehiculo = tipoVehiculo;
        
    }
    
    /***
     * constructor que solo recibe un objeto tipo evento y que llama al constructor copia de la clase padre
     * @param evento evento
     */
    public Boda(Evento evento){
        super(evento);
    }
    
    /***
     * modifica el estado del evento a Confirmado
     */
    @Override 
    public void confirmar(){
        System.out.println("Los novios tendrán un 25% de descuento si compran sus tickets de luna de miel en la aerolínea LATAM.");
        super.confirmar();
    }
    
    
    /***
     * retorna un string con los atributos de esta clase
     * @return atributos de boda
     */
    @Override
    public String toString(){
        String s = super.toString();
        s += "Elementos propios del evento"+tipo+": "+"\n"+"TIPO DE VEHICULO: "+tipoVehiculo.toUpperCase()+"\n";
        s += presentarElementos();
        return s;
    }
    
    /***
     * agrega los elementos adicionales de otra lista a la lista de este objeto tipo Boda
     * @param lista lista de este objeto tipo Boda
     */
    public void setAtributos(ArrayList<Elemento> lista) {
        for (Elemento elemento : lista) {
            if (elemento.getEvento().getCodigoEvento().equals(this.codigoEvento)) {
                if (elemento.getElemento() == null) {
                    tipoVehiculo = elemento.getTipoVehiculo();
                }
            }
        }
        
    }

    /***
     * Obtiene del atributo TipoVehiculo
     * @return tipo de vehiculo
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /***
     * Setea del atributo TipoVehiculo
     * @param tipoVehiculo tipo de vehiculo
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
