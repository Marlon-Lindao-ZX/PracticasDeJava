/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *Clase que implementa Comparator para asi ordenar la lista prestables, en esta clase
 * tambien hay metodos para consultar los prestables disponibles y de adicion de prestamos
 * @author ACarrera
 */
public class BiblioDigital implements Comparator<Prestable>{
    public static ArrayList<Prestable> prestables = new ArrayList<>();
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();
    
    /***
     * metodo que ordena la lista prestables y muestra los elementos de la lista
     * @return lista Prestable
     */
    public static ArrayList<Prestable> consultarDisponibles(){
    
        ArrayList<Prestable> retorno = new ArrayList<>();
        for(Prestable p: prestables){
            if(p.estarDisponible()) retorno.add(p);
        }
        Collections.sort(retorno, new BiblioDigital());
        return retorno;
    }
    
    /***
     * metodo que imprime los atributos de los elementos de una lista tipo prestable
     * @param lista 
     */
    public static void imprimirArreglos(ArrayList<Prestable> lista){
        for(Prestable p: lista){
            System.out.println(p.toString());
        }
        
        
    }
    
    /***
     * metodo que busca el prestamo asociado con la cedula enviada como parametro
     * @param cedula
     * @return 
     */
    public static Prestamo consultarPrestamo(String cedula){
       
        for(Prestamo pr: prestamos){
            if(pr.getCedula().equals(cedula)){
                if(pr.getFechaDevolucion()==null){
                    return pr;
                }
            }
            
        }
        return null;
        
    }
    
    /***
     * metodo que busca el un prestable con el nombre igual del enviado con el parametro
     * @param nombre
     * @return 
     */
    public static Prestable consultarObjeto(String nombre) {
        
        for (Prestable prestable : prestables) {
            if(prestable instanceof Produccion){
                Produccion pro = (Produccion) prestable;
                if(pro.getNombre().equals(nombre)){
                    return pro;
                }
//            if (p instanceof Pelicula) {
//                Pelicula pe = (Pelicula) p;
//                if (pe.getNombre().equals(nombre)) {
//                    return p;
//                }
//            } else if (p instanceof Serie) {
//                Serie se = (Serie) p;
//                if (se.getNombre().equals(nombre)) {
//                    return p;
//                }
            } else if (prestable instanceof Libro) {
                Libro l = (Libro) prestable;
                if (l.getTitulo().equals(nombre)) {
                    return l;

                }
            }
        }
        return null;
    }
    
    /***
     * metodo que añade un objeto tipo prestamo a la lista prestamos si la cedula asociada
     * no tiene un prestamo activo
     * @param cedula
     * @param p 
     */
    public static void añadirPrestamo(String cedula, Prestable p){
        if(consultarPrestamo(cedula) == null){
            p.prestar();
            Prestamo pr = new Prestamo(cedula,p);
            prestamos.add(pr);
            System.out.println("Prestamo añadido sin problemas");
        } else {
            System.out.println("Este usuario ya tiene un prestamo activo");
        }
        
        
    }
    
    /***
     * metodo que añade un prestamo de un prestable tipo Serie, siempre y cuando la cedula enviada
     * no presente un prestamo activo
     * @param cedula
     * @param objeto
     * @param numtemporada 
     */
    public static void añadirPrestamo(String cedula, Prestable objeto, int numtemporada) {
        if (consultarPrestamo(cedula) == null) {
            if (objeto instanceof Serie) {
                Serie serie = (Serie) objeto;
                serie.prestar(numtemporada);
                Prestamo pr = new Prestamo(cedula, serie);
                prestamos.add(pr);
            } else {
                System.out.println("Prestable no es una serie");
            }
        } else {
            System.out.println("Este usuario ya tiene un prestamo activo");
        }
    }
    
    /***
     * metodo que compara el nombre de los dos prestables, y que sera usado para ordenar la lista
     * prestables
     * @param p1
     * @param p2
     * @return 
     */
    @Override
    public int compare(Prestable p1, Prestable p2){
        return p1.obtenerString().compareTo(p2.obtenerString());
    }
    

   }

