/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

import java.util.Date;

/**
 * Clase que contiene los datos del prestamo,
 * @author ACarrera
 */
public class Prestamo {
    private String cedula;
    private Prestable objeto;
    private Temporada temporada;
    private Date fecha;
    private Date fechaDevolucion;

    public Prestamo(String cedula, Prestable objeto) {
        this.cedula = cedula;
        this.objeto = objeto;
        this.fecha= new Date();
    }
    
    /***
     * metodo que asigna la fecha de devolucion del prestamo y cambia el estado del prestable
     * a disponible
     * @param fechaDevolucion 
     */
    public void devolverPrestamo(Date fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
        if(this.objeto.devolver()) System.out.println("prestamo ya ha sido devuelto");
        
    }
    
    //getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Prestable getObjeto() {
        return objeto;
    }

    public void setObjeto(Prestable objeto) {
        this.objeto = objeto;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
