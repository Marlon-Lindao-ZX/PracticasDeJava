/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author CORE I7
 */
public class Avion {
    private String Modelo;
    private String Marca;
    private int Año;
    private String Color;
    
    public Avion(){
        Modelo = "Por defecto";
        Marca = "Por defecto";
        Año = 0;
        Color = "Por defecto";
    }

    public Avion(String Modelo, String Marca, int Año, String Color) {
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.Año = Año;
        this.Color = Color;
    }
    
    public void mostrarAvion(int añoactual){
        System.out.println("Es el año "+añoactual+" y este avion es del año "+this.Año);  
    }
   
    public void mostrarAvion(String nombreempresa, String nombrepiloto){
        System.out.print("Este avion es del modelo "+this.Modelo+", pertenece a "+nombreempresa); 
        System.out.println(" y su piloto es "+nombrepiloto);
    } 
    
    public void mostrarAvion(double kilometraje){
        System.out.print("Este avion es de color "+this.Color);
        System.out.println(" y tiene un kilometraje de "+kilometraje+" km");     
    }
            
    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    
    
    
}
