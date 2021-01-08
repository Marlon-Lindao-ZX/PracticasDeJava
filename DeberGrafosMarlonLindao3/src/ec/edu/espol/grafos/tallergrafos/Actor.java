/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.tallergrafos;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Actor {
    private int id;
    private String nombre;
    private ArrayList<Integer> peliculas;
    
    public Actor(int id){
        this.id = id;
    }
    
    public Actor(String linea){
        String values[] = linea.split("\\|");
        this.id = Integer.parseInt(values[0]);
        this.nombre = values[1];
        peliculas = new ArrayList<>();
        
    }
    
    public static List<Actor> readFromFile(String archivo){
        List<Actor> actores = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(archivo));){
            while (sc.hasNextLine()) {
                actores.add(new Actor(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return actores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Integer> peliculas) {
        this.peliculas = peliculas;
    }
    
    
    
    
}
