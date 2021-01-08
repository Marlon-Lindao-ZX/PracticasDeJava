/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

/**
 *Clase implementa de prestable, y de comparable para ordenar una lista de libros por el nombre
 * @author ACarrera
 */
public class Libro implements Prestable,Comparable<Libro>{
    private String titulo;
    private String autor;
    private int stock;

    /***
     * constructor que recibe como parametros el titulo del libro, el autor, y el numero
     * de copias que cuenta la biblioteca digital
     * @param titulo
     * @param autor
     * @param stock 
     */
    public Libro(String titulo, String autor, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
    }
    
    /***
     * metodo que verifica si el libro se encuentra disponible para
     * ser prestado
     * @return 
     */
    @Override
    public boolean estarDisponible(){
        boolean b = false;
        if(this.stock > 0){
            b = true;
        }
        return b;
    }
    
    /***
     * metodo que presenta los atributos de libro
     * @return 
     */
    @Override
    public String toString(){
        String s = "Titulo: "+this.titulo+"|Autor: "+this.autor+"|stock: "+this.stock;
        return s;
    }
    
    /***
     * metodo que ayuda en la ordenacion de la lista libros
     * @param l
     * @return 
     */
    @Override
    public int compareTo(Libro l){
        int r = titulo.compareTo(l.autor);
        return r;
    }
    
    /***
     * metodo que actualiza la cantidad de copias, cuando el libro se presta
     * la cantidad de copias se reduce en 1
     * @return 
     */
    @Override
    public boolean prestar(){
        boolean b = false;
        if (estarDisponible()){
            this.stock--;
            b = true; 
        }
        return b;
    }
    
    /***
     *metodo que actualiza la cantidad de copias, cuando el libro ha sido devuelto
     * @return 
     */
    @Override
    public boolean devolver(){
        boolean b = true;
        this.stock++;
        return b;
    }
    
    /***
     * metodo que devuelve el titulo del libro
     * @return String titulo
     */
    @Override
    public String obtenerString(){
        return titulo;
    }

    /***
     * getters y setters
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
