/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_unidad4_lindao_marlon;

/**
 *
 * @author Estudiante
 */
public abstract class Empleado {
    protected String nombre;
    protected String cedula;

    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        String s = "Nombre: "+nombre+" Cedula: "+cedula;
        return s;
    }
    
    
    
    public abstract int trabajar();
}
