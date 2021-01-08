/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos;

/**
 *
 * @author CltControl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereG
        GraphMA<Integer> gp = new GraphMA<>(true);
        gp.addVertex(10);
        gp.addVertex(12);
        gp.addVertex(3);
        gp.addVertex(4);
        gp.addVertex(5);
        
        gp.addEdge(10, 3, 1);
        gp.addEdge(12, 3, 1);
        gp.addEdge(4, 3, 1);
        gp.addEdge(5, 3, 1);
        gp.addEdge(3, 5, 1);
        gp.addEdge(3, 12, 1);
        
        System.out.println(gp.inDegree(3));
        System.out.println(gp.outDegree(3));
        System.out.println(gp);
    }
    
}
