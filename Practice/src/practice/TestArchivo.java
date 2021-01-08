/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;
import java.util.ArrayList;
/**
 *
 * @author CORE I7
 */
public class TestArchivo {
    	public static void main(String[] args) {
		// estructura Array List para guardar los objetos estudiantes
		ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
 
		// estudiante 1
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setCedula("234");
		estudiante1.setNombres("Augusto");
		estudiante1.setApellidos("Suárez");
		estudiante1.setTelefono("0987345678");
		estudiante1.setDireccion("Las Palmas");
 
		// añade un estudiante a la lista
		listaEstudiantes.add(estudiante1);
 
		// estudiante 2
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setCedula("756");
		estudiante2.setNombres("Marco");
		estudiante2.setApellidos("Alvarez");
		estudiante2.setTelefono("09345788");
		estudiante2.setDireccion("El Condado");
 
		// añade un estudiante a la lista
		listaEstudiantes.add(estudiante2);
 
		// estudiante 3
		Estudiante estudiante3 = new Estudiante();
		estudiante3.setCedula("5677");
		estudiante3.setNombres("Victor");
		estudiante3.setApellidos("Carrión");
		estudiante3.setTelefono("092356788");
		estudiante3.setDireccion("Sauces");
 
		// añade un estudiante a la lista
		listaEstudiantes.add(estudiante3);
 
		// crea el archivo estudiantes
		OperacionArchivo.crearArchivo(listaEstudiantes);
 
		// estudiante 4
		Estudiante estudiante4 = new Estudiante();
		estudiante4.setCedula("589");
		estudiante4.setNombres("Paúl");
		estudiante4.setApellidos("Valdez");
		estudiante4.setTelefono("0783455509");
		estudiante4.setDireccion("Centro");
		
		//nueva lista para añadir al archivo
		ArrayList nuevaLista= new ArrayList<>();
		nuevaLista.add(estudiante4);
		
		//añade un estudiante más al archivo
		OperacionArchivo.aniadirArchivo(nuevaLista);
 
		// lista para recibir los objetos estudiantes desde el archivo
		ArrayList<Estudiante> listaLeida = new ArrayList<>();
 
		// asignar a la lista los objetos
		listaLeida = OperacionArchivo.leerArchivo();
		for (Estudiante estudiante : listaLeida) {
			System.out.println(estudiante.toString());
		}
	}
}
