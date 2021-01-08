/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;



import ec.edu.espol.conjuntos.SetLO;
import ec.edu.espol.doublylinkedlist.DoublyLinkedList;
import ec.edu.espol.laberinto.Casilla;
import ec.edu.espol.laberinto.Laberinto;
import ec.edu.espol.proceso.Instruccion;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
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
        /*int matriz[][] = {{1,1,1,1,1,1,1,1,2,1},{1,1,0,0,0,0,1,1,0,1},{1,1,1,1,1,0,0,0,0,1},{0,0,0,0,0,0,1,1,1,1},{1,1,1,1,1,1,1,1,1,1}};
//        int matriz[][] = new int[10][4];
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                System.out.print(matriz1[j] + ",");
            }
            System.out.println("");
        }
        LinkedList<Casilla> result = Laberinto.encontrarCamino(matriz, 3, 0);

        if(result.isEmpty()){
            System.out.println("Solucion no encontrada");
        } else {
            System.out.println(result);
        }
        
        SetLO<Integer> lista = new SetLO<>(Integer::compareTo);
        lista.add(10);
        lista.add(5);
        lista.add(6);
        lista.add(4);
        lista.add(20);
        lista.add(6);
        
        System.out.println(lista);*/
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(5);
        list.addLast(10);
        list.addLast(25);
        list.addLast(8);
        list.addLast(10);
        System.out.println(list);
        
        DoublyLinkedList<Integer> list3 = list.split(1, 4);
        System.out.println(list3);
        
        list.removeNNodes(10,3);
        System.out.println(list);
        
        Queue<Instruccion> cola = new LinkedList<>();
        cola.offer(new Instruccion("PUSH","A"));
        cola.offer(new Instruccion("PUSH","C"));
        cola.offer(new Instruccion("PUSH","X"));
        cola.offer(new Instruccion("POP","D"));
        cola.offer(new Instruccion("PUSH","A"));
        cola.offer(new Instruccion("ADD",null));
        
        Map<String,Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 4);
        map.put("X", 2);
        map.put("D", 10);
        map.put("C", 1);
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(10);
        list2.add(20);
        list2.add(1);
        list2.add(8);
        list2.add(2);
        list2.add(11);
        list2.add(25);
        list2.add(12);
        list2.add(8);
        list2.add(20);
        
       
        
           
        
        
    }
    
    public static boolean reverse(LinkedList<Integer> lista){
        if(lista.isEmpty()) return false;
        ListIterator<Integer> low = lista.listIterator();
        ListIterator<Integer> high = lista.listIterator(lista.size());
        reverse(low,high);
        return true;
    }
    
    private static void reverse(ListIterator<Integer> low,ListIterator<Integer> high){
        int indmenor = low.nextIndex() -1;
        int indmayor = high.previousIndex()+1;
        int tmp3;
        if(!((indmenor == indmayor )||( low.nextIndex() == indmayor  ))){
            tmp3 = low.next();
            low.set(high.previous());
            high.set(tmp3);
            reverse(low,high);
        }
    }
}


    

