/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proceso;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author CltControl
 */
public class Proceso {
    
    private int llegada;
    private String nombre;
    private int ciclos;
    private int prioridad;
    
    public Proceso(int llegada,String nombre,int ciclos,int prioridad){
        this.llegada = llegada;
        this.nombre = nombre;
        this.ciclos = ciclos;
        this.prioridad = prioridad;
    }
    
    public static List<Proceso> readFromFile(String archivo){
        List<Proceso> proceso = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(archivo));){
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String [] arreglo = linea.split("\\|");
                int lleg = Integer.parseInt(arreglo[0]);
                String name = arreglo[1];
                int cycle = Integer.parseInt(arreglo[2]);
                int priority = Integer.parseInt(arreglo[3]);
                proceso.add(new Proceso(lleg,name,cycle,priority));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return proceso;
    }

    @Override
    public String toString() {
        return llegada + "|" + nombre + "|" + ciclos + "|" + prioridad;
    }
    
    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
