/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bienseguros;

/**
 *Clase abstracta ya que tiene el metodo abstracto calcularsueldo, y es padre de Administrativo
 * y Vendedor
 * Implementa Comparable para ordenar una lista de Empleados segun el apellido
 * @author 
 */
public abstract class Empleado implements Comparable<Empleado>{
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected double sueldo;

    /***
     * Constructor vacio
     */
    public Empleado() {}
    
    /***
     * Constructor con parametros
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param sueldo 
     */
    public Empleado(String cedula, String nombres, String apellidos, double sueldo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.sueldo = sueldo;
    }
/***
 * metodo que tendra implementacion en las clases hijas
 * @return 
 */
    public abstract double calcularSueldo();
    
    /***
     * metodo necesario de implementar debido a la implementacion de la interface Comparable
     * recibe una variable tipo empleado y lo compara con el atributo apellidos del objeto que llama
     * al metodo
     * @param empleado
     * @return 
     */
    @Override
    public int compareTo(Empleado empleado){
        int r = apellidos.compareTo(empleado.apellidos);
        return r;
    }
    
    @Override
    public String toString(){
        String s = "Sueldo para "+apellidos+" "+nombres+" : "+sueldo;
        return s;
    }

    /***
     * getters y setters
     * @return 
     */
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
