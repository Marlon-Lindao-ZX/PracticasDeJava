/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author Verónica
 */
public class ComparableComparatorTest {
    
 public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Carlos", "Ana", "Dionisio", "Bernardo");
        System.out.println("lista original:" + nombres);

        Collections.sort(nombres);
        System.out.println("lista ordenada:" + nombres);

        Set<String> otrosNombres = new TreeSet<>();
        otrosNombres.add("Mario");
        otrosNombres.add("Fernando");
        otrosNombres.add("Omar");
        otrosNombres.add("Juana");

        System.out.println("conjunto ordenado:" + otrosNombres);

        Set<Persona> personas = new TreeSet<>();
        personas.add(new Persona(1, "Mario"));
        personas.add(new Persona(2, "Fernando"));
        personas.add(new Persona(3, "Omar"));
        personas.add(new Persona(4, "Juana"));

        System.out.println("conjunto ordenado de personas: " + personas);

        List<Persona> otrasPersonas = Arrays.asList(new Persona(4, "Juana"),
                new Persona(2, "Fernando"),
                new Persona(1, "Mario"),
                new Persona(3, "Omar"));
        Collections.sort(otrasPersonas, new OrdenarPersonaPorId());
        System.out.println("lista de personas ordenadas por ID:" + otrasPersonas);


        Set<Persona> conjuntoPersonas = new TreeSet<>(new OrdenarPersonaPorId());
        conjuntoPersonas.add(new Persona(3, "Omar"));
        conjuntoPersonas.add(new Persona(4, "Juana"));
        conjuntoPersonas.add(new Persona(2, "Fernando"));
        conjuntoPersonas.add(new Persona(1, "Mario"));

        System.out.println("conjunto de personas ordenadas por ID:" + conjuntoPersonas);
    }
}

class Persona implements Comparable<Persona> {

    private int idPersona;
    private String nombre;
    private java.util.Date fechaNacimiento;

    public Persona() {
    }

    public Persona(int idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.util.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return String.format("persona{idPersona:%1s,nombre:%2s}", idPersona, nombre);
    }
}

class OrdenarPersonaPorId implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getIdPersona() - o2.getIdPersona();
    }
}
