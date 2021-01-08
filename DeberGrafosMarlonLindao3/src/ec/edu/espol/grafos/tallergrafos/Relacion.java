/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.tallergrafos;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Relacion {
    private int idActor;
    private int idPelicula;
    
    public Relacion(String linea){
        String value[] = linea.split("\\|");
        this.idActor = Integer.parseInt(value[1]);
        this.idPelicula = Integer.parseInt(value[0]);
    }
    
    public static List<Relacion> readFromFile(String archivo){
        List<Relacion> relaciones = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(archivo));){
            while (sc.hasNextLine()) {
                relaciones.add(new Relacion(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return relaciones;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    
    
}
