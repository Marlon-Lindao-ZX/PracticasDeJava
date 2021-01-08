/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readandwrite;

import java.io.Serializable;

/**
 *
 * @author CORE I7
 */
public class Persona implements Serializable{
    public String nombre;
    public String apellido;
    public Mascota mimascota;
    public int edad;
    
    public Persona(){
        nombre = "Marlon";
        apellido = "Lindao";
        mimascota = new Mascota();
        edad =24;
        
    }

    public Persona(String nombre, String apellido, Mascota mimascota, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mimascota = mimascota;
        this.edad = edad;
    }
    
    
    
    @Override
    public String toString(){
        return nombre + " "+ apellido +" "+ mimascota.nombre+ " "+ mimascota.numeropatas+ " "+ edad; 
    }
    

    
}
