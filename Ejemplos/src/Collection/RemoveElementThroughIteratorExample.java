/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.*;

/**
 *
 * @author Verónica
 */
public class RemoveElementThroughIteratorExample {

    public static void main(String[] args) {
        TreeSet<String> aList = new TreeSet<String>();
        aList.add("1");
        aList.add("2");
        aList.add("3");
        aList.add("4");
        aList.add("5");

        System.out.println("ArrayList before removal : ");
        System.out.println(aList);
        Iterator itr = aList.iterator();
        String strElement = "";
        while (itr.hasNext()) {
            strElement = (String) itr.next();
            if (strElement.equals("2")) {
                itr.remove();
                break;
            }
        }
        System.out.println("ArrayList after removal : ");
        System.out.println(aList);
    }
}
