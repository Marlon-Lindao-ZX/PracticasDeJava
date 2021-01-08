/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;
import java.util.*;
/**
 *
 * @author usuario
 */
public class TreeSetExample {

    public static void main(String[] args) {
        Set<BookComparable> set = new TreeSet<BookComparable>();
        //Creating Books  
        BookComparable b1 = new BookComparable(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        BookComparable b2 = new BookComparable(233, "Operating System", "Galvin", "Wiley", 6);
        BookComparable b3 = new BookComparable(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        //Adding Books to TreeSet  
        set.add(b1);
        set.add(b2);
        set.add(b3);
        //Traversing TreeSet  
        for (BookComparable b : set) {
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }
    }
}
