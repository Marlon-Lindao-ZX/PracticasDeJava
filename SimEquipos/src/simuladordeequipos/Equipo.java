/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordeequipos;

/**
 *
 * @author CORE I7
 */
public class Equipo {
	private int Partidos_Ganados; 
	private int Puntos_A_Favor;
	private int Puntos_En_Contra;
	private String Nombre;
	
	public Equipo(){
		Partidos_Ganados = 0;
		Puntos_A_Favor = 0;
		Puntos_En_Contra = 0;
		Nombre = "Guanajuato";
	}
	
	public Equipo(int Partidos_Ganados, int Puntos_A_Favor, int Puntos_En_Contra, String Nombre){
		this.Partidos_Ganados = Partidos_Ganados; 
		this.Puntos_A_Favor = Puntos_A_Favor;
		this.Puntos_En_Contra = Puntos_En_Contra;
		this.Nombre = Nombre;
		
	}
	
	public int getPartidos_Ganados() {
		return this.Partidos_Ganados;
	}

	public int getPuntos_A_Favor() {
		return this.Puntos_A_Favor;
	}

	public int getPuntos_En_Contra() {
		return this.Puntos_En_Contra;
	}

	public String getNombre() {
		return this.Nombre;
	}
	
	public void setPartidos_Ganados(int Partidos_Ganados){
		this.Partidos_Ganados = Partidos_Ganados;
		
	}
	
	public void setPuntos_A_Favor(int Puntos_A_Favor){
		this.Puntos_A_Favor = Puntos_A_Favor;
		
	}
	
	public void setPuntos_En_Contra(int Puntos_En_Contra){
		this.Puntos_En_Contra = Puntos_En_Contra;
	}
	
	public void setNombre(String Nombre){
		this.Nombre = Nombre;
	}
	
}



