/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import Archivos.ManejoDeArchivos;
import Eventos.Evento;
import Eventos.UIEventos;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */

/***
 * Atributos que presenta la clase Agenda
 * en esta clase se guardan los eventos que ya han sido confirmados por el planificador y
 * pagados por el cliente
 * @author Marinchi
 */
public class Agenda {
    
    private Evento evento;
    private String descripcion;
    private static ManejoDeArchivos ma = new ManejoDeArchivos();
   
    /***
     * constructor vacio de esta clase
     */
    public Agenda(){}

    /***
     * constructor que solo necesita de un objeto tipo Evento para inicializar sus valores
     * @param evento 
     */
    public Agenda(Evento evento) {
        this.evento = evento;
        descripcion = evento.toAgenda();
    }
    
    /***
     * constructor que recibe una linea del archivo correspondiente y que la usa para inicializar sus atributos
     * @param linea linea del archivo correspondiente y que la usa para inicializar sus atributos
     */
    public Agenda(String linea){
        String s = "";
        String[] arreglo = linea.split(",");
        evento = UIEventos.obtenerEvento(arreglo[0]);
        for(int i = 1; i<arreglo.length;i++){
            s += arreglo[i]+"\n";
        }
        descripcion = s;
    }
    
    /***
     * metodo que muestra el menu para ingresar un evento confirmado a la agenda
     */
    public static void menuAgenda(){
        Scanner sc = new Scanner(System.in);
        String codigo,opcion;
        boolean control = true;
        System.out.print("Ingrese el codigo del evento: ");
        codigo = sc.nextLine();
        Evento evento = UIEventos.verificarEstado(codigo);
        if(evento != null){
            System.out.println("¿Desea ingresar este evento a la agenda? (S/N)");
            do{
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "S":
                    Agenda agenda = new Agenda(evento);
                    UIAgenda.anadirAgenda(agenda);
                    escribirAgenda(agenda.toString());
                    System.out.println("Evento ha sido agregado a la agenda exitosamente ");
                    control = false;
                    break;
                case "N":
                    System.out.println("Evento no ha sido anadido a la Agenda");
                    control = false;
                    break;
                default:
                    break;
            }
            
            }while(control);
        } else {
            if(UIEventos.obtenerEvento(codigo) != null){
            System.out.println("Evento no puede ser ingresado aun");
            } else {
                System.out.println("Evento no existe!!");
            }
        }
    }
    
    /***
     * metodo que pasa los atributos de esta clase en un String
     * @return atributos de agenda en un String
     */
    @Override
    public String toString(){
        return evento.getCodigoEvento() + "," + descripcion;
        
    }
    
    /***
     * metodo que sirve para escribir la agenda en su archivo correspondiente
     * @param linea linea para escribir la agenda en su archivo correspondiente
     */
    public static void escribirAgenda(String linea){
        ma.escribirArchivo(linea, ManejoDeArchivos.getFILE4());
    }
    
    
    /***
     * Metodo getter muestra el valor Descripcion
     * @return descripcion de agenda
     */
   

    public String getDescripcion() {
        return descripcion;
    }
    
    /***
     * Metodo setter establecemos el parametro de Descripcion
     * @param descripcion descripcion de agenda
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
