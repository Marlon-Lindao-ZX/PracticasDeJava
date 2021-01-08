/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.datos;

import ec.edu.espol.arboles.SBT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Registro implements Serializable{
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int pasajeros;
    private float distance;
    private float value;
    
    public Registro(String linea){
        String array[] = linea.split(",");
        
        this.id = Integer.parseInt(array[0]);
        String temp[] = array[1].split(" ");
        String temp2[] = temp[0].split("-");
        String temp3[] = temp[1].split(":");
        int arreglo[] = new int[6];
        arreglo[0] = Integer.parseInt(temp2[0]);
        arreglo[1] = Integer.parseInt(temp2[1]);
        arreglo[2] = Integer.parseInt(temp2[2]);
        arreglo[3] = Integer.parseInt(temp3[0]);
        arreglo[4] = Integer.parseInt(temp3[1]);
        arreglo[5] = Integer.parseInt(temp3[2]);
        this.fecha_inicio = LocalDate.of(arreglo[0],arreglo[1],arreglo[2]);
        this.fecha_inicio.atTime(arreglo[3], arreglo[4], arreglo[5]);
        temp = array[2].split(" ");
        temp2 = temp[0].split("-");
        temp3 = temp[1].split(":");
        arreglo = new int[6];
        arreglo[0] = Integer.parseInt(temp2[0]);
        arreglo[1] = Integer.parseInt(temp2[1]);
        arreglo[2] = Integer.parseInt(temp2[2]);
        arreglo[3] = Integer.parseInt(temp3[0]);
        arreglo[4] = Integer.parseInt(temp3[1]);
        arreglo[5] = Integer.parseInt(temp3[2]);
        this.fecha_fin = LocalDate.of(arreglo[0],arreglo[1],arreglo[2]);
        this.fecha_fin.atTime(arreglo[3], arreglo[4], arreglo[5]);
        this.pasajeros = Integer.parseInt(array[3]);
        this.distance = Float.parseFloat(array[4]);
        this.value = Float.parseFloat(array[5]);
    }
    
    public Registro(int id){
        this.id = id;
    }
    
    public static List<Registro> readFromFile(String archivo){
        List<Registro> registros = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(archivo));){
            sc.nextLine();
            while (sc.hasNextLine()) {
                registros.add(new Registro(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return registros;
    }
    
    public static SBT<Registro> readFile(String archivo){
        RegistroComparator rc = new RegistroComparator();
        SBT<Registro> result = new SBT<>(rc);
        try(Scanner sc = new Scanner(new File(archivo));){
            sc.nextLine();
            while (sc.hasNextLine()) {
                result.add(new Registro(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return result;
    }
    
    public static SBT<Registro> readTree(File file){
        SBT<Registro> temp = new SBT<>(new RegistroComparator());
        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file))){
            temp = (SBT<Registro>) ios.readObject();
        }catch(IOException | ClassNotFoundException cnfe){
            
        } finally{
            return temp;
        }
    }
    
    public static void saveTree(SBT<Registro> arbol,File file){
        try(ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream(file))){
            ios.writeObject(arbol);
        }catch(IOException cnfe){
            
        } 
    }
    
    public static Registro get(SBT<Registro> arbol,int id){
        Registro temp = new Registro(id);
        Registro result = arbol.get(temp);
        return result;
    }
    
    @Override
    public String toString(){
        String result = "=======================================================\n";
        result += "         Informacion de la Carrera "+this.id+"\n";
        result += "=======================================================\n\n\n";
        result += "Hora Inicio: "+this.fecha_inicio+"\n";
        result += "Hora Fin: "+this.fecha_fin+"\n";
        result += "Cantidad de Pasajeros: "+this.pasajeros+"\n";
        result += "Valor: "+this.value+"\n";
        result += "Distancia Recorrida: "+this.distance+"\n";
        return result;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    
}
