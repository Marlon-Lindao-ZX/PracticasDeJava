/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;


import java.util.ArrayList;
import java.util.Date;


/**
 * 
 * @author ACarrera
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creacion de Libros
         
        Date fecha = new Date();
        System.out.println(fecha);
        
        BiblioDigital.prestables.add(new Libro("Me Before you","Jojo Moyes",5));
        BiblioDigital.prestables.add(new Libro("The hunger games","Suzan Collins",6));
        
        //Creacion de Peliculas
        BiblioDigital.prestables.add(new Pelicula("Bridget Jones","Comedia","Sony Pictures",125));
        BiblioDigital.prestables.add(new Pelicula("The duff","Comedia","Warner Bros",118));
        
        //Creacion de Series
        ArrayList<Temporada> ts1= new ArrayList<>();
        for (int i=0;i<7;i++)
            ts1.add(new Temporada(i));
        ArrayList<Temporada> ts2= new ArrayList<>();
        for (int i=0;i<11;i++)
            ts2.add(new Temporada(i));
        BiblioDigital.prestables.add(new Serie("Gossip Girl","Drama","Warner Bros",ts1));
        BiblioDigital.prestables.add(new Serie("Friends","Comedia","Warner Bros",ts2));
        
        /**
         * TODO: Consultar todos los objetos disponibles.
         */
        BiblioDigital.imprimirArreglos(BiblioDigital.consultarDisponibles());
        
         /**
          * TODO: anadir prestamo para la pelicula Bridget Jones con cedula 0919662047.
          * 
          */
        BiblioDigital.añadirPrestamo("0919662047",BiblioDigital.consultarObjeto("Bridget Jones"));
         /**
          * TODO: anadir prestamo para el libro Me Before you con cedula 0919662047.
          * 
          */
        BiblioDigital.añadirPrestamo("0919662047",BiblioDigital.consultarObjeto("Me Before you"));
        
           /**
           * TODO: Consultar todos los objetos disponibles.
           */
        BiblioDigital.imprimirArreglos(BiblioDigital.consultarDisponibles());
           /**
            * TODO: Devolver el prestamo realizado por 0919662047.
            */
        BiblioDigital.consultarPrestamo("0919662047").devolverPrestamo(fecha);
             /**
           * TODO: Consultar todos los objetos disponibles.
           */
        BiblioDigital.imprimirArreglos(BiblioDigital.consultarDisponibles());
        
    }
}
