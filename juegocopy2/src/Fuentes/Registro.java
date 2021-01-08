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
     * 
     * @param nombreUsuario 
     */
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario.set(nombreUsuario);
    }
    /**
     * 
     * @return 
     */
    public String getNombreUsuario(){
        return this.nombreUsuario.get();
    }
    /**
     * 
     */
    private ObjectProperty<LocalDate> fecha;
    public void setFecha(LocalDate fecha){
        this.fecha.set(fecha);
    }
    /**
     * 
     * @return 
     */
    public LocalDate getFecha(){
        return this.fecha.get();
    } 
    
    private ObjectProperty<LocalTime> hora;
    public void setHora(LocalTime hora){
        this.hora.set(hora);
    }
    /**
     * 
     * @return 
     */
    public LocalTime getHora(){
        return this.hora.get();
    }
    
    
    private IntegerProperty puntacion;
    /**
     * 
     * @param puntacion 
     */
    public void setPuntacion(int puntacion){
        this.puntacion.set(puntacion);
    }
    /**
     * 
     * @return 
     */
    public int getPuntacion(){
        return this.puntacion.get();
    }
    /**
     * 
     */
    public Registro(){};
    /**
     * 
     * @param nombreUsuario
     * @param fecha
     * @param hora
     * @param puntacion 
     */
    public Registro(String nombreUsuario, LocalDate fecha, LocalTime hora, int puntacion){
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.fecha = new SimpleObjectProperty<>(fecha);
        this.hora = new SimpleObjectProperty<>(hora);
        this.puntacion = new SimpleIntegerProperty(puntacion);
        
    }
    /**
     * 
     * @param linea 
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
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombreUsuario.get() +","+this.fecha.get()+","+this.hora.get()+","+this.puntacion.get()+"\n";
    }

    
    
    

   
    

    
    
    
}
