/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordeequipos;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author CORE I7
 */
public class TablaDePosiciones {
	private String Fecha;
	private ArrayList<Equipo> Teams;
	
	public String getFecha(){
		return this.Fecha;
	}
	
	public ArrayList<Equipo> getTeams(){
		return this.Teams;
	}
	
	public void setFecha(String Fecha){
		this.Fecha = Fecha;
	}
	
//	public void setTeams(){
//		
//	}
	
	public TablaDePosiciones(String Fecha){
		this.Fecha = Fecha;
		crearEquipos();
	}
	
	public TablaDePosiciones(){
		
	}
	
	private  void crearEquipos(){
            String [] a= {"Atlanta Utd.","FrankFurt","Guanajuato","Gimnasia","Osaka F.C.","Los Angeles Galaxy","Independiente Santa Fe"};
            ArrayList<String> lista;
            lista = new ArrayList<>(Arrays.asList(a));
            boolean control, controlmensaje, controlarreglo, val;
            control = controlmensaje = controlarreglo = val = true;
            Teams = new ArrayList<>();
            int PG, PA, PE;
            String Name;

            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                    if (control) {
                            if (controlmensaje) {
                                    System.out.println("¿Desea ingresar equipos?:");
                                    controlmensaje = false;
                            } else {
                                    System.out.println("¿Desea seguir ingresando equipos?:");
                            }

                            while(val){

                                System.out.println("Digite 1 para seguir y 0 para salir");
                                short decision = sc.nextShort();

                                if (decision == 0 || decision == 1) {
                                    if (decision == 0) {
                                        controlarreglo = control = false;
                                        val = false;
                                    } else {
                                        val = false;
                                    }

                                } else {
                                    System.out.println("Ingrese 1 para ingresar equipos o 0 para salir: ");
                                }
                            } 


                    }

                    if (controlarreglo) {
                        sc.nextLine();
                        System.out.println("Ingrese nombre del equipo: ");
                        Name = sc.nextLine();
                        System.out.println("Ingrese cuantos partidos gano: ");
                        PG = sc.nextInt();
                        System.out.println("Ingrese los puntos a favor que tiene: ");
                        PA = sc.nextInt();
                        System.out.println("Ingrese los puntos en contra que observe: ");
                        PE = sc.nextInt();
                        Teams.add(new Equipo(PG, PA, PE, Name));


                    } else {
                        int b;
                        Random r = new Random();
                        b = r.nextInt(lista.size());
                        Name = lista.get(b);
                        lista.remove(b);
                        b = r.nextInt(11);
                        PG = b;
                        b = r.nextInt(11);
                        PA = b;
                        b = r.nextInt(11);
                        PE = b;
                        Teams.add(new Equipo(PG, PA, PE, Name));
                    }

                    val = true;
            }
		
	}
	
	public String evaluacionEquipos(ArrayList<Equipo> e){
		String result;
		Equipo a, b, c;
		for (int i = 0; i < e.size(); i++) {
			for (int j = 0; j < e.size(); j++) {
				a = e.get(i);
				b = e.get(j);
				if (a.getPartidos_Ganados() == b.getPartidos_Ganados()) {
					if (a.getPuntos_A_Favor() != b.getPuntos_A_Favor()) {
						if (a.getPuntos_A_Favor() > b.getPuntos_A_Favor()) {
							e.set(i, b);
							e.set(j, a);
						}
					} else if (a.getPuntos_En_Contra() > b.getPuntos_En_Contra()) {
						e.set(i, b);
						e.set(j, a);

					}
				} else if (a.getPartidos_Ganados() > b.getPartidos_Ganados()) {
					e.set(i, b);
					e.set(j, a);
				}
			}
		}
		c = e.get(0);
		result = c.getNombre();
		return result;
	}

}

		
	













