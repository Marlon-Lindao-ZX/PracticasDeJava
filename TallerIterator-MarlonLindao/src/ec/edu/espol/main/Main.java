/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.doublylinkedlist.DoublyLinkedList;
import ec.edu.espol.simplylinkedlist.SimplyLinkedList;
import java.util.Iterator;
import java.util.ListIterator;

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
        SimplyLinkedList<Integer> l = new SimplyLinkedList<>();
        l.addLast(7);
        l.addLast(10);
        l.addLast(9);
        System.out.println(l);
        Iterator<Integer> it = l.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        it = l.iterator();
        while(it.hasNext()){
            Integer n = it.next();
            System.out.println(n);
        }
        for(Integer n: l){
            System.out.println(n);
        }
        
        DoublyLinkedList<Integer> db = new DoublyLinkedList<>();
        db.addFirst(11);
        db.addFirst(6);
        db.addFirst(4);
        ListIterator<Integer> lit = db.listIterator(0);
        while(lit.hasNext()){
            Integer n = lit.next();
            System.out.println(n);
        }
        
        ListIterator<Integer> lit2 = db.listIterator(db.size()-1);
        while(lit2.hasPrevious()){
            Integer n = lit2.previous();
            System.out.println(n);
        }
        
       for(Integer e: db){
           System.out.println(e);
       }
       
       SimplyLinkedList<Integer> ltest = new SimplyLinkedList<>();
       ltest.addLast(46);
       ltest.addLast(51);
       ltest.addLast(26);
       ltest.addLast(22);
       ltest.addLast(92);
       ltest.addLast(14);
       ltest.addLast(15);
       ltest.addLast(16);
       ltest.addLast(17);
       ltest.addLast(18);
       it = ltest.iteratorStep(0,4);
       while(it.hasNext()){
            Integer n = it.next();
            System.out.println(n);
        }
        
//        
        
                
    }
}


    

