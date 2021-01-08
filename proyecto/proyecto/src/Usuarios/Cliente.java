/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Eventos.*;
import java.util.ArrayList;

/**
 * Clase que hereda de la clase Usuario
 * @author CORE I7
 */
public class Cliente extends Usuario {
    
    private ArrayList<Planificador> planificadores;
    private ArrayList<Evento> eventos;

    /***
     * constructor vacio de Cliente
     */
    public Cliente(){
        
    }
    
    /***
     * constructor con parametros de Cliente y que llama al constructor con parametros de la clase padre
     * @param nombre Nombre del Cliente
     * @param apellido Apellido del Cliente
     * @param usuario User del Cliente
     * @param contraseña Contraseña del Cliente
     * @param perfil Perfil del Cliente
     */
    public Cliente (String nombre, String apellido, String usuario, String contraseña, char perfil){
        super(nombre, apellido, usuario, contraseña, perfil);
        planificadores = new ArrayList<>();
        eventos = new ArrayList<>();
        
    }
    
    /***
     * constructor que llama al constructor copia de la clase Padre
     * @param u Usuario al cual el Cliente va a copiar los valores de sus atributos
     */
    public Cliente(Usuario u){
        super(u);
        planificadores = new ArrayList<>();
        eventos = new ArrayList<>();
        
        
    }
    
    /***
     * constructor que recibe una linea extraida del archivo usuarios.txt y que contiene los atributos del usuario
     * y llama al constructor respectivo de la clase padre
     * @param linea Un string que contiene los valores de los atributos del Cliente
     */
    public Cliente(String linea){
        super(linea);
        planificadores = new ArrayList<>();
        eventos = new ArrayList<>();
    }
    
    /***
     * Asigna los eventos correspondientes de este Cliente durante la carga de archivos en el inicio 
     * del programa
     * @param events Una lista de eventos cargada en el inicio del programa
     */
    public void asignarEventos(ArrayList<Evento> events) {
        for (Evento evento : events) {
            if (evento.getCliente() == this) {
                eventos.add(evento);
                if (!planificadores.contains(evento.getPlanificador())) {
                    planificadores.add(evento.getPlanificador());
                }
            }
        }
    }
    
    /***
     * Metodo que añade un evento asociado a este objeto tipo Cliente a su lista de eventos
     * @param evento Evento nuevo creado para este cliente
     */
    public void añadirEvento(Evento evento){
        planificadores.add(evento.getPlanificador());
        eventos.add(evento);
    }
    
    /***
     * Presenta los datos de los eventos que contiene este Cliente
     */
    public void presentarEvento() {
        if (!eventos.isEmpty()) {
            for (Evento evento : eventos) {
                System.out.println(evento.presentarAtributos());
            }
        } else {
            System.out.println("Cliente no tiene eventos asociados!!");
        }
    }

    /***
     * Obtiene el atributo planificadores
     * @return Una lista con los planificadores asociados con este cliente
     */
    public ArrayList<Planificador> getPlanificadores() {
        return planificadores;
    }

    /***
     * set del atributo planificadores
     * @param planificadores Una lista tipo Planificador que va a reemplazar el valor actual del atributo planificadores
     */
    public void setPlanificadores(ArrayList<Planificador> planificadores) {
        this.planificadores = planificadores;
    }
   
    
    
    /***
     * Obtiene el atributo eventos que es una lista de eventos asociados con el cliente
     * @return La lista de eventos asociado con este cliente
     */

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
    /***
     * Setea el atributo eventos
     * @param eventos Una lista tipo Evento que va a reemplazar el valor actual del atributo eventos
     */

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
 
    
}
