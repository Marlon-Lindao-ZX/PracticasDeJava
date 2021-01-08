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
public class FirstNameComparator implements Comparator<Person> {
    public int compare(Person _firstPerson, Person _secondPerson) {
return _firstPerson.firstname.compareTo(_secondPerson.firstname);
}
}
