/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

import java.util.LinkedList;

/**
 *
 * @author CORE I7
 */
public class JavaApplication27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        
        l1.add(2);
        l1.add(3);
        l1.add(8);
        l1.add(4);
        l1.add(1);
        
        l2.add(1);
        l2.add(1);
        l2.add(3);
        l2.add(2);
        l2.add(5);
        l2.add(6);
        
        LinkedList<Integer> result = sum(l1,l2);
        System.out.println(result);
        
        
    }
    
    public static LinkedList<Integer>  sum(LinkedList<Integer> a,LinkedList<Integer>b){
        LinkedList<Integer> temp = new LinkedList<>();
        for(Integer n1: a){
            int temp1 = 0;
            for(Integer n2: b){
                if(n2 < n1)
                    temp1 += n2;
            }
            temp.add(temp1);
        }
        return temp;
    }
    
}
