/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIBuscaTuMascota.com;

import buscaTuMascota.com.*;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author su nombre aqui
 */
public class Main {

	static Scanner sc = new Scanner(System.in);
	BuscaTuMascotaCom aplicacion = new BuscaTuMascotaCom();

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Llamada menu
		Main main = new Main();
		main.menu();
	}

	public void menu() {
		String opcion = "";
		while (!opcion.equals("6")) {
			System.out.println("╔                Menu                   ╗");
			System.out.println("║ 1. Registro de Duenos                 ║");
			System.out.println("║ 2. Registro de Mascotas               ║");
			System.out.println("║ 3. Consulta de Mascotas por Dueno     ║");
			System.out.println("║ 4. Consulta de Mascotas por Raza      ║");
			System.out.println("║ 5. Consulta de Mascotas por Codigo    ║");
			System.out.println("║ 6. Salir de Mascotas                  ║");
			System.out.println("╚                                       ╝");
			System.out.print("Ingrese opcion: ");
			opcion = sc.nextLine();
			switch (opcion) {
				case "1":
					registroDuenos();
					break;
				case "2":
					registroMascotas();
					break;
				case "3":
					consultaMascotasPorDueno();
					break;
				case "4":
					consultaMascotasPorRaza();
					break;
				case "5":
					consultaMascotasPorCodigo();
					break;
				default:
					System.out.println("Opcion No valida!!");
			}
		}
		sc.close();
	}

	public void registroDuenos() {
		System.out.print("Ingresar cedula: ");
		String cedula = sc.nextLine();
		System.out.print("Ingresar nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Ingresar ciudad: ");
		String ciudad = sc.nextLine();
		System.out.print("Ingresar direccion: ");
		String direccion = sc.nextLine();
		System.out.print("Desea registrar Tarjeta de Credito ahora S/N: ");
		String opcion = sc.nextLine();
		if (opcion.equals("S")) {
			System.out.print("Ingresar tarjeta credito: ");
			long tarjeta = sc.nextLong();
			/**
			 * TODO: Crear objeto dueno usando el constructor
			 * correspondiente
			 */
			Dueno o;
			o = new Dueno(nombre, ciudad, direccion, cedula, tarjeta);
			aplicacion.anadirDueno(o);

		} else {

			/*
               TODO: Crear objeto dueno usando el constructor correspondiente             
			 */
			Dueno o;
			o = new Dueno(nombre, ciudad, direccion, cedula);
			aplicacion.anadirDueno(o);

		}

		System.out.println("Se registro exitosamente!");

	}

	public void registroMascotas() {
		boolean b = true;
		String cedula;
		do{
			System.out.print("Ingresar cedula dueno: ");
			cedula = sc.nextLine();
			Dueno d = aplicacion.consultarDueno(cedula);
			if (d != null) {
				System.out.println("Nombre del Dueno: " + d.getnombre());
				System.out.print("Ingresar nombre de la mascota: ");
				String nombre = sc.nextLine();
				System.out.print("Ingresar raza de la mascota: ");
				String raza = sc.nextLine();

				Mascota m;
				m = new Mascota(nombre, raza, aplicacion.consultarDueno(cedula));

				aplicacion.anadirMascota(m);

				System.out.println("Se registro exitosamente!");
				b = false;
		} else {
			System.out.println("Dueno no se encuentra registrado");
			System.out.println("Desea ingresar otra cedula: Y/N");
			char choice = sc.next().charAt(0);
			if(choice == 'y' || choice == 'Y'){
				
			} else {
				b = false;
			}
			
		}
		/**
		 * TODO: Buscar Cedula Dueno, finalizar interfaz
		 */
		}while(b);
		
		

	}

	public void consultaMascotasPorDueno() {
		List<Mascota> listamascota;
		System.out.print("Ingresar cedula dueno: ");
		String cedula = sc.nextLine();
		listamascota = aplicacion.consultarMascota(aplicacion.consultarDueno(cedula));
		
		for(Mascota f: listamascota){
			System.out.print(f.getcodigo() + "--");
			System.out.print(f.getnombre().toUpperCase() + "--" + f.getraza().toUpperCase() + "--");
			System.out.println("Dueno:" + f.getdueno().getnombre());
		}

	}

	public void consultaMascotasPorRaza() {
		List<Mascota> listamascota;
		System.out.print("Ingresar raza: ");
		String raza = sc.nextLine();
		listamascota = aplicacion.consultarMascota(raza);
		
		for(Mascota f: listamascota){
			System.out.print(f.getcodigo() + "--");
			System.out.print(f.getnombre().toUpperCase() + "--" + f.getraza().toUpperCase() + "--");
			System.out.println("Dueno:" + f.getdueno().getnombre());

	}
		
	}

	public void consultaMascotasPorCodigo() {
		System.out.print("Ingresar codigo: ");
		int codigo = sc.nextInt();
		Mascota s;
		s = aplicacion.consultarMascota(codigo);
		System.out.print(s.getcodigo()+"--");
		System.out.print(s.getnombre().toUpperCase()+"--"+s.getraza().toUpperCase()+"--");
		System.out.println("Dueno:" +s.getdueno().getnombre());
	}

}











