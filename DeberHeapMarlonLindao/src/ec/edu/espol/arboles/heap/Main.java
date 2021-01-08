/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles.heap;

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
        Heap<Integer> heapMa = new Heap<>(Integer::compare,true);
        Heap<Integer> heapMe = new Heap<>(Integer::compare,false);
        
        Random r = new Random();
        
        for(int i = 0;i<15;i++){
            System.out.println(i);
            System.out.print(heapMa.offer(r.nextInt(200)));
            System.out.print(" ");
            System.out.print(heapMe.offer(r.nextInt(200)));
            System.out.println("");
        }
        
        System.out.print(heapMa.poll()+" ");
        System.out.print(heapMa.poll()+" ");
        System.out.print(heapMa.poll()+" ");
        System.out.print(heapMa.poll()+" ");
        System.out.print(heapMa.poll());
        System.out.println("");
        System.out.print(heapMe.poll()+" ");
        System.out.print(heapMe.poll()+" ");
        System.out.print(heapMe.poll()+" ");
        System.out.print(heapMe.poll()+" ");
        System.out.print(heapMe.poll());
        System.out.println("");
    }
    
}
