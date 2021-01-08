/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.auxiliar;

import ec.edu.espol.proyecto.grafos.GraphLA;
import ec.edu.espol.proyecto.grafos.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Auxiliar {
    
    
    private Auxiliar(){}
    
    public static HashMap<String,String> cargarCiudades(String nombreArchivo){
        HashMap<String,String> ciudades = new HashMap<>();
        try(Scanner sc = new Scanner(new File(nombreArchivo));){
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String values[] = linea.split(",");
                ciudades.put(values[0], values[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return ciudades;
    }
    
    public static GraphLA<String> cargarGrafo(String nombreArchivo, HashMap<String,String> ciudades){
        GraphLA<String> graphCity = new GraphLA<>(false);
        for(String key: ciudades.keySet())
            graphCity.addVertex(key);
        try(Scanner sc = new Scanner(new File(nombreArchivo));){
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String values[] = linea.split("\\|");
                String idOrigen = values[0];
                for(int i=1;i<values.length;i++){
                    String temp[] = values[i].split(",");
                    String idDestino = temp[0];
                    int peso = Integer.parseInt(temp[1]);
                    if(peso>0){
                        graphCity.addEdge(idOrigen, idDestino, peso);
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return graphCity;
    }
    
    public static String buscarCodigoCiudad(HashMap<String,String> codigos, String ciudad){
        for(String id: codigos.keySet()){
            String value = codigos.get(id);
            if(value.equals(ciudad)){
                return id;
            }
        }
        return null;
    }
    
    public static List<String> calcularRutaCorta(GraphLA<String> grafo,HashMap<String,String> codigos, String origen, String destino){
        String idOrigen = buscarCodigoCiudad(codigos,origen);
        String idDestino = buscarCodigoCiudad(codigos,destino);
        List<String> ruta = new LinkedList<>();
        if(!(idOrigen == null || idDestino == null)){
            ruta = grafo.disktra(idOrigen, idDestino);
        }
        return ruta;
        
    }

    
    
}
