/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

/**
 *Clase que sera padre de las clases Serie y Pelicula
 * @author ACarrera
 */
public abstract class Produccion implements Prestable,Comparable<Produccion>{
    // hacerlos protected o usar los getters
    private String nombre;
    private String genero;
    private String productor;
    private Estados estado;

    /***
     * constructor que le sirve a las clases hijas para asignar valores a los atributos
     * que heredan del padre
     * @param nombre
     * @param genero
     * @param productor 
     */
    public Produccion(String nombre, String genero, String productor) {
        this.nombre = nombre;
        this.genero = genero;
        this.productor = productor;
        this.estado= Estados.A;
        
        
    }
    
    /***
     * metodo que verifica si una produccion esta disponible
     * @return 
     */
    @Override
    public boolean estarDisponible(){
        boolean b = false;
        if(this.estado == Estados.A){
            b = true;
        }
        return b;
    }

    /***
     * metodo que muestra en un String los atributos de produccion
     * @return 
     */
    @Override
    public String toString(){
        String s = "Nombre: "+this.nombre+"|Genero: "+this.genero+"|Productor: "+this.productor+"|Estado: "+this.estado;
        return s;
    }
    
    /***
     * metodo que le ayuda al metodo sort de Collections para ordenar una lista de tipo Produccion
     * @param p
     * @return 
     */
    @Override
    public int compareTo(Produccion p){
        int r = nombre.compareTo(p.nombre);
        return r;
    }
    
    /***
     * metodo que actualiza el estado de la produccion a Prestado
     * @return 
     */
    @Override
    public boolean prestar(){
        boolean b = false;
        if (estarDisponible()){
            this.estado = Estados.P;
            b = true; 
        }
        return b;
    }
    
    /***
     * metodo que actualiza el estado de la produccion a Disponible
     * @return 
     */
    @Override
    public boolean devolver(){
        boolean b = true;
        this.estado = Estados.A;
        return b;
    }
    
    /***
     * metodo que devuelve el nombre de la produccion
     * @return 
     */
    @Override
    public String obtenerString(){
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    
    
    
    
    
    
}
