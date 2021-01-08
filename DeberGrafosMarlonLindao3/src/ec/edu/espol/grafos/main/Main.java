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
        GraphLA<String> graph = new GraphLA<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 2);
        
        GraphLA<String> graph2 = new GraphLA<>(true);
        graph2.addVertex("C");
        graph2.addVertex("B");
        graph2.addVertex("F");
        graph2.addVertex("H");
        graph2.addVertex("S");
        
        graph2.addEdge("C", "B", 1);
        graph2.addEdge("B", "S", 1);
        graph2.addEdge("S", "C", 1);
        graph2.addEdge("F", "C", 1);
        graph2.addEdge("F", "S", 1);
        graph2.addEdge("H", "F", 1);
        graph2.addEdge("H", "B", 1);
        
        GraphLA<Integer> enteros = new GraphLA<>(false);
        enteros.addVertex(1);
        enteros.addVertex(2);
        enteros.addVertex(3);
        enteros.addVertex(4);
        enteros.addVertex(5);
        enteros.addVertex(6);
        enteros.addVertex(7);
        
        enteros.addEdge(1, 2, 1);
        enteros.addEdge(1, 4, 4);
        enteros.addEdge(2, 3, 2);
        enteros.addEdge(2, 4, 6);
        enteros.addEdge(2, 5, 4);
        enteros.addEdge(3, 5, 5);
        enteros.addEdge(3, 6, 6);
        enteros.addEdge(4, 5, 3);
        enteros.addEdge(4, 7, 4);
        enteros.addEdge(5, 6, 8);
        enteros.addEdge(5, 7, 7);
        enteros.addEdge(7, 6, 3);
        
        System.out.println(graph.isConnected());
        System.out.println(graph.connectedComponents());
        System.out.println(graph.kruskal());
        System.out.println(graph.searchByNumStep("A", "E", 2));
        System.out.println(graph.searchByNumStep("A", "E", 4));
        System.out.println("\n");
        
        System.out.println(graph2.isConnected());
        System.out.println(graph2.connectedComponents());
        System.out.println(graph2.kruskal());
        System.out.println(graph2.searchByNumStep("H", "C", 2));
        System.out.println(graph2.searchByNumStep("H", "C", 1));
        System.out.println("\n");
        
        System.out.println(enteros.isConnected());
        System.out.println(enteros.connectedComponents());
        System.out.println(enteros.kruskal());
        System.out.println(enteros.searchByNumStep(1, 6, 3));
        System.out.println(enteros.searchByNumStep(1, 6, 2));
        
        
        
    }
    
    
}
