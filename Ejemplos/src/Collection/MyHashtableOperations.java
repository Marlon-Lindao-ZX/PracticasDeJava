/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;
import java.util.Hashtable;
/**
 *
 * @author Verónica
 */
public class MyHashtableOperations {
 public static void main(String a[]){
        //Create hashtable instance
        Hashtable<String,String> ht = new Hashtable<String,String>();
        //add key-value pair to hashtable
        ht.put("first", "FIRST INSERTED");
        ht.put("second", "SECOND INSERTED");
        ht.put("third","THIRD INSERTED");
        System.out.println(ht);
        //getting value for the given key from hashtable
        System.out.println("Value of key 'second': "+ht.get("second"));
        System.out.println("Is Hashtable empty? "+ht.isEmpty());
        ht.remove("third");
        System.out.println(ht);
        System.out.println("Size of the Hashtable: "+ht.size());
    }   
}
