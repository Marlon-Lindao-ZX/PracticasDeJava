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
 * Clase FiestaInfantil hija hereda clase padre de Evento, con atributos y metodos
 * de acceso respectivos
 * @author Marinchi
 */
public class FiestaInfantil extends Evento {
    private int cantidadPersonasDisfrazadas;
    private int cantidadSorpresasRepartir;
    private boolean adicionJuegosInfantiles;
    
    
    public FiestaInfantil(){}
    
    /***
     * Metodo Constructor de la Clase FiestaInfantil y que llama al constructor correspondiente de la clase padre
    * @param tipo Tipo de la FiestaInfantil
     * @param cliente Cliente asociado a la FiestaInfantil
     * @param lugar Lugar de la FiestaInfantil
     * @param fecha Fecha de la FiestaInfantil
     * @param horaInicio Hora Inicio de la FiestaInfantil
     * @param horaFin Hora Fin de la FiestaInfantil
     * @param capacidad Capacidad de la FiestaInfantil
     * @param planificador Planificador asociado a la FiestaInfantil
     * @param elementos Elementos de la FiestaInfantil
     * @param cantidadPersonasDisfrazadas Cantidad de personas que se disfrazaran en la FiestaInfantil
     * @param cantidadSorpresasRepartir Cantidad de sorpresas a repartir en la FiestaInfantil
     * @param adicionJuegosInfantiles  Valor de verdad que indica si la FiestaInfanil contara con juegos Infantiles
     */
    
    public FiestaInfantil(TipoEvento tipo, Cliente cliente, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                  int capacidad, Planificador planificador, ArrayList<Elemento> elementos,
                  int cantidadPersonasDisfrazadas, int cantidadSorpresasRepartir, boolean adicionJuegosInfantiles){
        super(tipo,cliente,lugar,fecha,horaInicio,horaFin,capacidad,planificador,elementos);
        this.cantidadPersonasDisfrazadas = cantidadPersonasDisfrazadas;
        this.cantidadSorpresasRepartir = cantidadSorpresasRepartir;
        this.adicionJuegosInfantiles = adicionJuegosInfantiles;

        
    }
    
    /***
     * constructor que recibe dos parametros, un string y otro de tipo evento, y que ademas llama al constructor copia de la clase padre
     * @param evento Evento del cual se va a copiar los datos
     * @param cantidadPersonasDisfrazadas Cantidad de personas que se disfrazaran en la FiestaInfantil
     * @param cantidadSorpresasRepartir Cantidad de sorpresas a repartir en la FiestaInfantil
     * @param adicionJuegosInfantiles  Valor de verdad que indica si la FiestaInfanil contara con juegos Infantiles
     */
    
    public FiestaInfantil(Evento evento, int cantidadPersonasDisfrazadas, 
            int cantidadSorpresasRepartir, boolean adicionJuegosInfantiles){
        super(evento);
        this.cantidadPersonasDisfrazadas = cantidadPersonasDisfrazadas;
        this.cantidadSorpresasRepartir = cantidadSorpresasRepartir;
        this.adicionJuegosInfantiles = adicionJuegosInfantiles;
    }
    
    /***
     * constructor que solo recibe un objeto tipo evento y que llama al constructor copia de la clase padre
     * @param evento Evento del cual se va a copiar los datos
     */
    public FiestaInfantil(Evento evento){
        super(evento);
    }
    
    /***
     * anade elementos de otra lista a la lista de elementos del objeto que llama al metodo
     * @param lista Lista de elementos previamente cargada en el inicio del programa
     */
    public void setAtributos(ArrayList<Elemento> lista){
        for (Elemento elemento : lista) {
            if (elemento.getEvento().getCodigoEvento().equals(this.codigoEvento)) {
                if (elemento.getElemento() == null) {
                    cantidadPersonasDisfrazadas = elemento.getCantidadPersonasDisfrazadas();
                    cantidadSorpresasRepartir = elemento.getCantidadSorpresasRepartir();
                    adicionJuegosInfantiles = elemento.isAdicionJuegosInfantiles();
                }
            }
        }
        
    }
    
    /***
     * Sobreescritura del metodo confirmar() de la clase Padre
     */
    @Override
    public void confirmar(){
        System.out.println("Si realizan un próximo evento en las mismas instalaciones en un plazo de 6 meses se les otorgará en servicio de música gratuito.");
        super.confirmar();
    }
    
    /***
     * regresa los atributos del objeto mediante un string
     * @return Un String con los atributos propios de esta clase FiestaInfantil
     */
    @Override
    public String toString() {
        String s = super.toString();
        s += "Elementos propios del evento" + tipo + ": " + "\n" + "CANTIDAD DE PERSONAS DISFRAZADAS: " +cantidadPersonasDisfrazadas+ "\n"
             +"CANTIDAD DE SORPRESAS A REPARTIR: " +cantidadSorpresasRepartir+ "\n" + "SERVICIO DE JUEGOS INFANTILES: ";
        if(adicionJuegosInfantiles){
            s += "SI"+"\n";
        } else {
            s += "NO"+"\n";
        }
        s += presentarElementos();
        return s;
    }
    
     
    /***
     * get del atributo cantidadPersonasDisfrazadas
     * @return Retorna la cantidad de personas que estaran disfrazadas
     */
    public int getCantidadPersonasDisfrazadas() {
        return cantidadPersonasDisfrazadas;
    }

    /***
     * set del atributo cantidadPersonasDisfrazadas
     * @param cantidadPersonasDisfrazadas Dato que reemplazara el valor actual de este atributo
     */
    public void setCantidadPersonasDisfrazadas(int cantidadPersonasDisfrazadas) {
        this.cantidadPersonasDisfrazadas = cantidadPersonasDisfrazadas;
    }

    /***
     * get del atributo cantidadSorpresasRepartir
     * @return Retorna la cantidad de sorpresas a repartir
     */
    public int getCantidadSorpresasRepartir() {
        return cantidadSorpresasRepartir;
    }

    /***
     * set del atributo cantidadSorpresasRepartir
     * @param cantidadSorpresasRepartir Dato que reemplazara el valor actual de este atributo
     */
    public void setCantidadSorpresasRepartir(int cantidadSorpresasRepartir) {
        this.cantidadSorpresasRepartir = cantidadSorpresasRepartir;
    }

    /***
     * get del atributo adicionJuegosInfantiles
     * @return Retorna si la fista infantil contara con juegos artificiales o no
     */
    public boolean isAdicionJuegosInfantiles() {
        return adicionJuegosInfantiles;
    }

    /***
     * set del atributo adicionJuegosInfantiles
     * @param adicionJuegosInfantiles Dato que reemplazara el valor actual de este atributo
     */
    public void setAdicionJuegosInfantiles(boolean adicionJuegosInfantiles) {
        this.adicionJuegosInfantiles = adicionJuegosInfantiles;
    }
    
}
