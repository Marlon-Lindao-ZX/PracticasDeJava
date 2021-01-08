/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller1;

import java.util.Scanner;

public class RevisionCurso {

	static Estudiante[] curso;
	static int estudiantesencurso;

	public static void start(int dimension) {
		curso = new Estudiante[dimension];
		estudiantesencurso = 0;
	}

	public static Estudiante crearestudiante(String Nombre, String Apellido, int Edad, char Sexo, String Matricula) {
		Estudiante e = new Estudiante(Nombre, Apellido, Edad, Sexo, Matricula);
		estudiantesencurso++;
		return e;
	}

	public static void mostrarestudiante(Estudiante[] curso) {
		for (Estudiante x : curso) {
			System.out.print(" Nombre: " + x.getNombre() + "| Apellido: " + x.getApellido() + "| Edad " + x.getEdad());
			System.out.println("| Sexo: " + x.getSexo() + "| Matricula: " + x.getMatricula());

		}
	}

	public static void main(String[] args) {

		short dimension, opcion;
		Scanner read = new Scanner(System.in);

		boolean controlarreglo, controlmensaje, control, controlwhile, arreglocreated;
		controlarreglo = controlmensaje = control = controlwhile = true;
		arreglocreated = false;

		System.out.println("Ingrese la dimension de la lista de estudiantes: ");
		dimension = read.nextShort();
		start(dimension);

		do {

			System.out.println("Seleccione una opcion del programa: ");
			System.out.println("1) Crear lista de estudiantes ");
			System.out.println("2) Modificar datos del Estudiante ");
			System.out.println("3) Mostrar listado del cutso ");
			System.out.println("4) Salir del programa ");

			opcion = read.nextShort();

			switch (opcion) {

				case 1:
					if (arreglocreated) {
						System.out.println("la lista ya ha sido creada");

					} else {
						arreglocreated = true;
						for (int i = 0; i < curso.length; i++) {

							if (control) {
								if (controlmensaje) {
									System.out.println("¿Desea ingresar estudiantes?:");
									controlmensaje = false;
								} else {
									System.out.println("¿Desea seguir ingresando estudiantes?:");
								}

								System.out.println("Digite 1 para seguir y 0 para salir");

								short decision = read.nextShort();
								if (decision == 0) {
									controlarreglo = control = false;
								}
							}

							if (controlarreglo) {

								System.out.println("Ingrese el nombre del estudiante:");
								String Nombre = read.next();

								System.out.println("Ingrese el apellido del estudiante:");
								String Apellido = read.next();

								System.out.println("Ingrese la edad del estudiante:");
								int Edad = read.nextInt();

								System.out.println("Ingrese el sexo del estudiante (m si es masculino o f si es femenino):");
								char Sexo = read.next().charAt(0);

								System.out.println("Ingrese la matricula del estudiante:");
								String Matricula = read.next();

								curso[i] = crearestudiante(Nombre, Apellido, Edad, Sexo, Matricula);
							} else {
								Estudiante defecto;
								defecto = new Estudiante();
								curso[i] = defecto;
							}
						}
					}
					break;

				case 2:
					boolean control2;
					control2=true;
					short choice;
					
					if(arreglocreated){
					do{
						System.out.println("Escriba la opcion que desea realizar:");
						System.out.println("1) Agregar a la lista, datos de un nuevo Estudiante ");
						System.out.println("2) Modificar datos de un estudiante");
						System.out.println("3) Eliminar un estudiante de la lista");
						System.out.println("4) Regresar al programa");
						
						choice = read.nextShort();
						
						switch(choice) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								control2=false;
								break;
							default:
								System.out.println("Opcion incorrecta");
								break;	
						}
					} while(control2);
					} else {
						System.out.println("No hay lista creada");
					}
					break;
				case 3:
					if (arreglocreated) {
						mostrarestudiante(curso);
						System.out.println("Cantidad de estudiantes en curso: " + estudiantesencurso);
					} else {
						System.out.println("No hay lista creada que mostrar");
					}
					break;

				case 4:
					controlwhile = false;
					System.out.println("Sayonara XD");
					break;
				default:
					System.out.println("Opcion incorrecta");
					break;

			}
		} while (controlwhile);

	}
}





