/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.main;

import ec.edu.espol.grafos.dinamico.GraphLA;
import ec.edu.espol.grafos.tallergrafos.Actor;
import ec.edu.espol.grafos.tallergrafos.Pelicula;
import ec.edu.espol.grafos.tallergrafos.Relacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CltControl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GraphLA<Actor> gp = new GraphLA<>(false);
        List<Actor> actores = Actor.readFromFile("actores.txt");
        ArrayList<Pelicula> peliculas = Pelicula.readFromFile("peliculas.txt");
        
        HashMap<Integer,String> movies = new HashMap<>();
        for(Pelicula pelicula: peliculas)
            movies.put(pelicula.getId(), pelicula.getNombre());
        
        List<Relacion> relaciones = Relacion.readFromFile("pelicula-actores.txt");
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int id;
        
        for(Relacion r: relaciones){
            id = r.getIdPelicula();
            List<Integer> temp = map.get(id);
            if(temp == null){
                map.put(id, new LinkedList());
                temp = map.get(id);
                temp.add(r.getIdActor());
            } else{
                temp.add(r.getIdActor());
            }
            
        }
        
        for(Actor actor: actores)
            gp.addVertex(actor);
        
        for(Integer i: map.keySet()){
            List<Integer> temp = map.get(i);
            String movie = movies.get(i);
            int value = temp.get(0);
            for(Integer idl: temp){
                if(value != idl)
                    gp.addEdge(value, idl, 1, movie, gp);
            }
            
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del actor a buscar: ");
        String temp = sc.nextLine();
        
        int ido = getIdActor(actores,"Kevin Bacon");
        int idd = getIdActor(actores,temp);
        
        if(!(ido == -1 || idd == -1)){
            List<String> resultado = gp.disktra(ido, idd, gp);
            System.out.println(resultado);
        } else {
            System.out.println("Nombre de actor ingresado no se encuentra");
        }
        
       
    }
    
    public static int getIdActor(List<Actor> actores,String name){
        int r = -1;
        for(Actor actor: actores)
            if(actor.getNombre().equals(name))
                return actor.getId();
        return r;
        
    }
    
    
}
