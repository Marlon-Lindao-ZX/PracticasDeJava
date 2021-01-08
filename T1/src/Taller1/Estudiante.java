/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller1;

/**
 *
 * @author CORE I7
 */
public class Estudiante {

	private String Nombre;
	private String Apellido;
	private int Edad;
	private char Sexo;
	private String Matricula;

	public Estudiante() {
		Nombre = "nombre estudiante";
		Apellido = "apellido estudiante";
		Edad = 0;
		Sexo = 'u';
		Matricula = "000000000";
	}

	public Estudiante(Estudiante e) {
		Nombre = e.Nombre;
		Apellido = e.Apellido;
		Edad = e.Edad;
		Sexo = e.Sexo;
		Matricula = e.Matricula;
	}

	public Estudiante(String Nombre, String Apellido, int Edad, char Sexo, String Matricula) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Edad = Edad;
		this.Sexo = Sexo;
		this.Matricula = Matricula;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public int getEdad() {
		return Edad;
	}

	public char getSexo() {
		return Sexo;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}

	public void setEdad(int Edad) {
		this.Edad = Edad;
	}

	public void setSexo(char Sexo) {
		this.Sexo = Sexo;
	}

	public void setMatricula(String Matricula) {
		this.Matricula = Matricula;
	}

}



