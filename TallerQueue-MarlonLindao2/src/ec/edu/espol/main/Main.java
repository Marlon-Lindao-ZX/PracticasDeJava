/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;



import ec.edu.espol.proceso.Proceso;
import java.util.LinkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author marln
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Proceso> proceso = Proceso.readFromFile("procesos.txt");
//        LinkedList<Proceso> process = (LinkedList<Proceso>) proceso;
        System.out.println(proceso);
        System.out.println("Simulacion 1");
        proceso.sort((Proceso p1, Proceso p2) -> p1.getLlegada() - p2.getLlegada());
        Queue<Proceso> cola = new LinkedList<>();
        cola.addAll(proceso);
        while(!cola.isEmpty()){
            Proceso tmp = cola.poll();
            System.out.println(tmp);
            System.out.println("Ciclos que necesita este proceso " + tmp.getCiclos());
            tmp.setCiclos(tmp.getCiclos()-1);
            System.out.println("Ciclos que le quedan a este proceso " + tmp.getCiclos()+"\n");
            if(tmp.getCiclos()!=0)
                cola.offer(tmp);
        }
        System.out.println("Simulacion 2");
        List<Proceso> proceso2 = Proceso.readFromFile("procesos.txt");
        PriorityQueue<Proceso> cola2 = new PriorityQueue<>((Proceso p1, Proceso p2) -> p1.getPrioridad() - p2.getPrioridad());
        cola2.addAll(proceso2);
        System.out.println(cola2);
        while(!cola2.isEmpty()){
            Proceso tmp = cola2.poll();
            System.out.println(tmp);
            System.out.println("Ciclos que necesita este proceso " + tmp.getCiclos());
            tmp.setCiclos(tmp.getCiclos()-1);
            System.out.println("Ciclos que le quedan a este proceso " + tmp.getCiclos()+"\n");
            if(tmp.getCiclos()!=0)
                cola2.offer(tmp);
        }
       
        
//        
        
                
    }
}


    

