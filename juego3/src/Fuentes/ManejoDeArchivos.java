/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuentes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */

public class ManejoDeArchivos {
    
    public static final ArrayList<String> RUTAS = new ArrayList<>();
    public static final File FILE1 = new File("src/Fuentes/historial.txt");
    
    
/**
 * Metodo para iniciar la lista
 */
    public static void iniciarLista(){
        RUTAS.add("src/Fuentes/car.png");
    }
    /**
     * Metodo para verificar archivo
     */
    public static void verificarArchivo(){
        try{
            if(!FILE1.exists()) FILE1.createNewFile();
        } catch (IOException ioe) {
            System.out.println("problema");
        }
    }
    /**
     * Metodo para escribir archivo
     * @param linea linea a escribir
     * @param file file con la ruta del txt
     */
    public static void escribirArchivo(String linea, File file){
        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(file,true))){
            
            bfw.write(linea);
            
        } catch(IOException ioe){
            System.out.println("Problema");
        }
        
    }
    /**
     * Metodo para leer el archivo
     * @param file file con la ruta del txt
     * @return arreglo con los datos que estaban guardados en el txt
     */
    public static ArrayList<String> leerArchivo(File file){
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        try(BufferedReader bfr = new BufferedReader(new FileReader(file))){
            
            while((linea = bfr.readLine()) != null){
                lineas.add(linea);
            }
            
            return lineas;
            
        } catch (IOException ioe) {
            System.out.println("problema");
            return null;
        } 
        
    }
    
}
