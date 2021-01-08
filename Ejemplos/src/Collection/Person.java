/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author usuario
 */
public class Person implements Comparable<Person> {
    String firstname;
String lastname;
 
Person(String _lastname, String _firstname) {
lastname = _lastname;
firstname = _firstname;
}
  
public int compareTo(Person _person) {
return this.lastname.compareTo(_person.lastname);
}
}
