/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

/**
 * Clase que hereda de Produccion
 * @author ACarrera
 */
public class Pelicula extends Produccion{
    private int duracion;
    
    /***
     * metodo que llama al constructor de produccion y que asigna valor a su atrbuto duracion
     * @param nombre
     * @param genero
     * @param productor
     * @param duracion 
     */
    public Pelicula(String nombre,String genero,String productor,int duracion) {
        super(nombre,genero,productor);
        this.duracion = duracion;
    }
    
    /***
     * metodo para mostrar sus atributos en un String
     * @return 
     */
    @Override
    public String toString(){
        return super.toString()+"|Duracion: "+this.duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    
    
}
