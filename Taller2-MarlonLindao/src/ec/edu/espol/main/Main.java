/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;
import ec.espol.edu.tdas.SimplyLinkedList;
import java.util.Random;

/**
 *MarlonLindao
 * @author CltControl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random r = new Random();
        SimplyLinkedList<Integer> a = new SimplyLinkedList<>();
        SimplyLinkedList<Integer> b = new SimplyLinkedList<>();
        System.out.println(a.addFirst(8));
        System.out.println(a.addFirst(7));
        System.out.println(a.addFirst(6));
        System.out.println(a.addFirst(5));
        System.out.println(a.addFirst(4));
        System.out.println(a.addLast(9));
        System.out.println(a.addLast(10));
        System.out.println(a.addLast(11));
        System.out.println(a.addLast(12));
        System.out.println(a.addLast(13));
        System.out.println(b.addFirst(8));
        System.out.println(b.addFirst(7));
        System.out.println(b.addFirst(6));
        System.out.println(b.addFirst(5));
        System.out.println(b.addFirst(4));
        System.out.println(b.addLast(9));
        System.out.println(b.addLast(10));
        System.out.println(b.addLast(11));
        System.out.println(b.addLast(12));
        System.out.println(b.addLast(13));
        System.out.println(a.equals(b));
        System.out.println(a);
        try{
            System.out.println(a.get(4));
            System.out.println(a.get(16));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println(a.contains(8));
            System.out.println(a.contains(20));
            System.out.println(a.removeFirst());
            System.out.println(a.removeFirst());
            System.out.println(a.removeLast());
            System.out.println(a.removeLast());
            System.out.println(a);
        }
        
                
    }
    
}
