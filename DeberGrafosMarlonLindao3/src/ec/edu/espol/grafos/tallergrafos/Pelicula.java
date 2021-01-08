/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.tallergrafos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Pelicula {
    private int id;
    private String nombre;
    
    public Pelicula(String linea){
        String values[] = linea.split("\\|");
        this.id = Integer.parseInt(values[0]);
        this.nombre = values[1];
    }
    
    public static ArrayList<Pelicula> readFromFile(String archivo){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo));){
            while (sc.hasNextLine()) {
                peliculas.add(new Pelicula(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return peliculas;
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
}
