/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.util.Random;

/**
 *
 * @author CORE I7
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SBT<Integer> arbolB = new SBT<>(Integer::compare);
        Random r = new Random();
        arbolB.add(300);
        
        for(int i = 0; i<10;i++)
            arbolB.add(r.nextInt(1000)+1);
        
        arbolB.preOrden();
        System.out.println("");
        arbolB.posOrden();
        System.out.println("");
        arbolB.enOrden();
        System.out.println("");
        System.out.println(arbolB.height());
        System.out.println(arbolB.countLeaf());
        System.out.println(arbolB.isFull());
        System.out.println(arbolB.contains(300));
        System.out.println(arbolB.contains(550));
        
        
    }
    
}
