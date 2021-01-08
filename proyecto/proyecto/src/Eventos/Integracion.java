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
 *
 * @author CORE I7
 */

/***
 * Clase Integracion de una clase hija con la Clase padre de Evento
 * @author Marinchi
 */

public class Integracion extends Evento {
    private boolean transporte;
    private int cantidadPersonasTransportar;
    
    /***
     * Constructor vacio de esta clase Integracion
     */
    public Integracion(){
        
    }
    
    /***
     * Metodo Contructor de la clase Integracion y que llama al constructor correspondiente de la clase padre
     * @param tipo Tipo de la Integracion
     * @param cliente Cliente asociado a la Integracion
     * @param lugar Lugar de la Integracion
     * @param fecha Fecha de la Integracion
     * @param horaInicio Hora Inicio de la Integracion
     * @param horaFin Hora Fin de la Integracion
     * @param capacidad Capacidad de la Integracion
     * @param planificador Planificador asociado a la Integracion
     * @param elementos Elementos de la Integracion
     * @param transporte Transporte de la Integracion
     * @param cantidadPersonasTransportar  Cantidad de Personas a Transportar
     */
    
    
    public Integracion(TipoEvento tipo, Cliente cliente, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                  int capacidad, Planificador planificador, ArrayList<Elemento> elementos,
                  boolean transporte, int cantidadPersonasTransportar){
        super(tipo,cliente,lugar,fecha,horaInicio,horaFin,capacidad,planificador,elementos);
        this.transporte = transporte;
        this.cantidadPersonasTransportar = cantidadPersonasTransportar;
    }
    
    /***
     * constructor que recibe dos parametros, un string y otro de tipo evento, y que ademas llama al constructor copia de la clase padre
     * @param evento Evento del cual se va a copiar los datos
     * @param transporte Transporte de la Integracion
     * @param cantidadPersonasTransportar  Cantidad de Personas a Transportar
     */
    
    public Integracion(Evento evento, boolean transporte, int cantidadPersonasTransportar){
        super(evento);
        this.transporte = transporte;
        this.cantidadPersonasTransportar = cantidadPersonasTransportar;
    }
    
    /***
     * constructor que solo recibe un objeto tipo evento y que llama al constructor copia de la clase padre
     * @param evento Evento del cual se va a copiar los datos
     */
    public Integracion(Evento evento){
        super(evento);
    }
    
    /***
     * metodo que anade elementos de otra lista a la lista del objeto que llama al metodo
     * @param lista Lista de elementos previamente cargada en el inicio del programa
     */
    public void setAtributos(ArrayList<Elemento> lista) {
        for (Elemento elemento : lista) {
            if (elemento.getEvento().getCodigoEvento().equals(this.codigoEvento)){
                if (elemento.getElemento() == null) {
                    transporte = elemento.isTransporte();
                    cantidadPersonasTransportar = elemento.getCantidadPersonasTransportar();
                }
            }
        }

    }
    
    /***
     * Sobreescritura del metodo confirmar() de la clase Padre
     */
    @Override      
    public void confirmar(){
        System.out.println("El transporte al lugar del evento es gratuito en un próximo evento, si lo organizan con el mismo planificador(a)");
        super.confirmar();
    }
    
    /***
     * regresa en un string los atributos del objeto que lo invoca
     * @return Un String con los atributos propios de esta clase Integracion
     */
    @Override
    public String toString() {
        String s = super.toString();
        s += "Elementos propios del evento" + tipo + ": " + "\n"+"SERVICIO DE TRANSPORTE: ";
        if(transporte){
            s += "SI"+"\n";
        } else {
            s += "NO"+"\n";
        }
        s += "CANTIDAD DE PERSONAS A TRANSPORTAR: "+cantidadPersonasTransportar+"\n"; 
        s += presentarElementos();
        return s;
    }

    /***
     * get del atributo transporte
     * @return true si el Evento requiere transporte, false caso contrario
     */
    public boolean isTransporte() {
        return transporte;
    }
    
    /***
     * set del atributo transporte
     * @param transporte Dato booleano que reemplazara el valor actual de este atributo Transporte
     */
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }
    
    /***
     * get del atributo cantidadPersonasTransportar
     * @return La cantidad de Personas a transportar 
     */
    public int getCantidadPersonasTransportar() {
        return cantidadPersonasTransportar;
    }
    
    /***
     * set del atributo cantidadPersonasTransportar
     * @param cantidadPersonasTransportar Dato numerico que va a reemplazar este atributo
     */
    public void setCantidadPersonasTransportar(int cantidadPersonasTransportar) {
        this.cantidadPersonasTransportar = cantidadPersonasTransportar;
    }

    
    
}
