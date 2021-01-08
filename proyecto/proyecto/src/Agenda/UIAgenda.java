/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.util.ArrayList;

/**
 *En esta clase esta un atributo ArrayList de tipo Agenda, que alamacena todos los objetos de tipo agenda que se vayan creando y 
 * los que fueron cargados en el inicio del programa
 * @author CORE I7
 */
public class UIAgenda {
    
    
    private static ArrayList<Agenda> agendas = new ArrayList<>();
    
    /***
     * constructor vacio
     */
    public UIAgenda(){}
    
    /***
     * metodo que recibe una lista de Strings que contiene todos los objetos de tipo agenda creados en la sesion anterior del programa
     * y que fueron cargados durante el inicio del programa
     * @param lista lista de Strings que contiene todos los objetos de tipo agenda
     */
    public static void cargarAgenda(ArrayList<String> lista) {
        for (String linea : lista) {
            Agenda agenda = new Agenda(linea);
            agendas.add(agenda);
        }

    }
    
    /***
     * añade un objeto tipo agenda a la lista de esta clase UIAgenda
     * @param agenda agenda
     */
    public static void anadirAgenda(Agenda agenda){
        agendas.add(agenda);
    }
    
    /***
     * get del atributo agendas
     * @return arreglo de agendas
     */
    public static ArrayList<Agenda> getAgendas() {
        return agendas;
    }

    /***
     * set del atributo agendas
     * @param agendas arreglo de agendas
     */
    public static void setAgendas(ArrayList<Agenda> agendas) {
        UIAgenda.agendas = agendas;
    }
    
    
    
}
