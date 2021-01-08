/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordeequipos;
import java.util.Scanner;
/**
 *
 * @author CORE I7
 */
public class SimuladordeEquipos {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		// TODO code application logic here
		Scanner sc = new Scanner(System.in);
		String Fecha;
		String capture;
		System.out.println("Inserte el numero de la fecha: ");
		Fecha = sc.nextLine();
		
		TablaDePosiciones t,e;
		e = new TablaDePosiciones();
	        t = new TablaDePosiciones(Fecha);
		
		capture = e.evaluacionEquipos(t.getTeams());
		
		System.out.println("El mejor equipo es: " +capture);
		
		System.out.println("este es el contenido de los equipos");
		for(Equipo x: t.getTeams()){
			System.out.print(x.getNombre()+"--");
			System.out.print(x.getPartidos_Ganados()+"--");
			System.out.print(x.getPuntos_A_Favor()+"--");
			System.out.println(x.getPuntos_En_Contra()+"--");
		}
		
	}
	
}




