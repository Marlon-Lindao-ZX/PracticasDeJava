/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuentes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alex
 */
public class Registro {
    
    private StringProperty nombreUsuario;
    /**
     * Metodo para setear el nombre de usuario
     * @param nombreUsuario 
     */
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario.set(nombreUsuario);
    }
    /**
     * Metodo para obtener el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombreUsuario(){
        return this.nombreUsuario.get();
    }
    
    private ObjectProperty<LocalDate> fecha;
    /**
     * Metodo para setear la fecha
     * @param fecha fecha
     */
    public void setFecha(LocalDate fecha){
        this.fecha.set(fecha);
    }
    /**
     * Metodo para obtener la fecha
     * @return fecha
     */
    public LocalDate getFecha(){
        return this.fecha.get();
    } 
    
    private ObjectProperty<LocalTime> hora;
    /**
     * Metodo para setear la hora
     * @param hora hora
     */
    public void setHora(LocalTime hora){
        this.hora.set(hora);
    }
    /**
     * Metodo para obtener la hora
     * @return hora
     */
    public LocalTime getHora(){
        return this.hora.get();
    }
    
    
    private IntegerProperty puntacion;
    /**
     * Metodo para setear la puntuacion
     * @param puntacion puntuacion
     */
    public void setPuntacion(int puntacion){
        this.puntacion.set(puntacion);
    }
    /**
     * Metodo para obtener la puntuacion
     * @return puntuacion
     */
    public int getPuntacion(){
        return this.puntacion.get();
    }
    /**
     * Constructor de Registro
     */
    public Registro(){};
    /**
     * Constructor  de Registro
     * @param nombreUsuario nombre de usuario
     * @param fecha fecha
     * @param hora hora
     * @param puntacion puntuacion 
     */
    public Registro(String nombreUsuario, LocalDate fecha, LocalTime hora, int puntacion){
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.fecha = new SimpleObjectProperty<>(fecha);
        this.hora = new SimpleObjectProperty<>(hora);
        this.puntacion = new SimpleIntegerProperty(puntacion);
        
    }
    /**
     * Constructor de Registro
     * @param linea linea
     */
    public Registro(String linea){
        try{
        String [] valores = linea.split(",");
        this.nombreUsuario = new SimpleStringProperty(valores[0]);
        this.fecha = new SimpleObjectProperty<>(LocalDate.parse(valores[1]));
        this.hora = new SimpleObjectProperty<>(LocalTime.parse(valores[2]));
        this.puntacion = new SimpleIntegerProperty(Integer.parseInt(valores[3]));
        }  catch (NumberFormatException nfe){
            System.out.println("Surgio un problema, lo estamos resolviendo");    
        } 
    }
    /**
     * Metodo toString de Registro
     * @return cadena con los atributos de registro
     */
    @Override
    public String toString(){
        return this.nombreUsuario.get() +","+this.fecha.get()+","+this.hora.get()+","+this.puntacion.get()+"\n";
    }

    
    
    

   
    

    
    
    
}
