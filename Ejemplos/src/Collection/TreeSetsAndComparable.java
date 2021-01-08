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
public class TreeSetsAndComparable {

    public static void main(String[] args) {
        new TreeSetsAndComparable().listPeople();
    }

    private void listPeople() {

        System.out.println("---First Set (ordered by lastname)---");
        Set<Person> firstSetOfPeople = new TreeSet<Person>();
        firstSetOfPeople.add(new Person("Shakespeare", "William"));
        firstSetOfPeople.add(new Person("Dostoevsky", "Fyodor"));
        firstSetOfPeople.add(new Person("Churchill", "Winston"));

        for (Person person : firstSetOfPeople) {
            System.out.println(person.firstname + " " + person.lastname);
        }

        System.out.println();

        // This accomplishes what I want, but only by creating a new TreeSet.
        System.out.println("---Second Set (ordered by firstname)---");
        Set<Person> secondSetOfPeople = new TreeSet<Person>(
                new FirstNameComparator());
        secondSetOfPeople.add(new Person("Shakespeare", "William"));
        secondSetOfPeople.add(new Person("Dostoevsky", "Fyodor"));
        secondSetOfPeople.add(new Person("Churchill", "Winston"));

        for (Person person : secondSetOfPeople) {
            System.out.println(person.firstname + " " + person.lastname);
        }

        System.out.println();

       

    }
}