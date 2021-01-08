/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;
import ec.espol.edu.tdas.ArrayList;
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
        ArrayList<Integer>a = new ArrayList<>();
        for(int i=0;i<100;i++)
            a.addLast(i);
        System.out.println(a);
        System.out.println(a.removeLast());
        System.out.println(a.removeFirst());
        System.out.println(a);
        System.out.println(a.contains(6));
        System.out.println(a.contains(300));
        System.out.println(a.set(612, 12));
        System.out.println(a);
        System.out.println(a.insert(135, 24));
        System.out.println(a);
        System.out.println(a.removeElement(56));
        System.out.println(a);
        System.out.println(a.removeElement(400));
        System.out.println(a);
                
    }
    
}
