/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;


import Constantes.TipoEvento;
import java.util.Scanner;
/**
 *
 * @author CORE I7
 */

/***
 * Atributos de la clase Animador con los modificadores de acceso
 * @author Marinchi
 */

public class Animador extends Elemento{
    private String nombre;
    private String apellido;
    private int edad;
    private String cedula;
    private TipoEvento tipo;
    
    /***
     * Constructor vacio de esta clase Animador
     */
    public Animador(){}
    
    /***
     * Constructor de Animador
     * @param elemento elemento 
     * @param animador objeto tipo animador
     */
    public Animador(Elemento elemento, Animador animador){
        super(elemento);
        nombre = animador.nombre;
        apellido = animador.apellido;
        edad = animador.edad;
        cedula = animador.cedula;
        tipo = animador.tipo;
    }
    
    /***
     * Constructor de Animador
     * @param linea delimitador
     */
    public Animador(String linea){
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        nombre = delimitar.next();
        apellido = delimitar.next();
        edad = delimitar.nextInt();
        cedula = delimitar.next();
        String type = delimitar.next();
        switch(type){
            case "Boda":
                tipo = TipoEvento.Boda;
                break;
            case "Fiesta_Infantil":
                tipo = TipoEvento.Fiesta_Infantil;
                break;
            case "Integracion":
                tipo = TipoEvento.Integracion;
                break;
            case "Otros":
                tipo = TipoEvento.Otros;
                break;
        }
    }
    
    /***
     * Constructor de Animador
     * @param elemento elemento 
     * @param linea delimitador
     */
    public Animador(Elemento elemento,String linea) {
        super(elemento);
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        nombre = delimitar.next();
        apellido = delimitar.next();
        edad = delimitar.nextInt();
        cedula = delimitar.next();
        String type = delimitar.next();
        switch(type){
            case "Boda":
                tipo = TipoEvento.Boda;
                break;
            case "Fiesta_Infantil":
                tipo = TipoEvento.Fiesta_Infantil;
                break;
            case "Integracion":
                tipo = TipoEvento.Integracion;
                break;
            case "Otros":
                tipo = TipoEvento.Otros;
                break;
        }
    }
  
    /***
     * Regresa un String que contiene los atributos de un Animador que sera guardado en el archivo elementos.txt
     * @return atributos de un animador
     */
    public String pasarLineaAnimador(){
        String s = "";
        s += super.pasarLineaElementoAdicional();
        s += "," + nombre + "," + apellido + "," + edad + "," + cedula + "," + tipo;
        return s;
    }
    
    /***
     * Metodo para mostrar los atributos de animador
     * @return atributos del animador
     */
    @Override
    public String toString(){
        return "Nombres: " + nombre + "\n" + "Apellidos: " + apellido + "\n" + "Edad: " + edad + "\n" +"Cedula: " + cedula + "\n" + 
                "Tipo de Evento: " + tipo + "\n";
    }
    /***
     * Metodo getter muestra el valor de nombre
     * @return 
     */

    /***
     * Obtiene el nombre
     * @return nombre del animador
     */
    public String getNombre() {
        return nombre;
    }
    
    /***
     * Metodo setter asigna el parametro de nombre
     * @param nombre nombre del animador
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /***
     * Metodo getter obtiene el valor de apellido
     * @return apellido del animador
     */

    public String getApellido() {
        return apellido;
    }
    
    /***
     * Metodo setter asigna el parametro de apellido
     * @param apellido 
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /***
     * Metodo getter obtiene el valor de edad
     * @return edad
     */

    public int getEdad() {
        return edad;
    }
    
    /***
     * Metodo setter asigna el parametro de edad
     * @param edad 
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /***
     * Metodo getter obtiene el valor de cedula
     * @return cedula
     */

    public String getCedula() {
        return cedula;
    }
    
    /***
     * Metodo setter asigna el parametro de cedula
     * @param cedula cedula
     */

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /***
     * Retorna el tipo de evento
     * @return tipo de evento
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /***
     * Setea el tipo de evento
     * @param tipo tipo de evento
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }
    
    
}
