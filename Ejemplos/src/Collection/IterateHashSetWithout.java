/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author usuario
 */
public class IterateHashSetWithout {
     public static void main(String[] args) {
     // Create a HashSet
     Set<String> hset = new HashSet<String>();
 
     //add elements to HashSet
     hset.add("Chaitanya");
     hset.add("Rahul");
     hset.add("Tim");
     hset.add("Rick");
     hset.add("Harry");
 
     for (String temp : hset) {
        System.out.println(temp);
     }
  }
}
