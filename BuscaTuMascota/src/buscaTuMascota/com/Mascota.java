/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaTuMascota.com;

import java.util.Random;

/**
 *
 * @author suNombreAqui
 */
public class Mascota {
    
    private String nombre;
    private String raza;
    private Dueno nombredueño;
    private int codigo;
    
    public Mascota(String nombre, String raza, Dueno d){
        this.nombre = nombre;
        this.raza = raza;
        nombredueño = d;
        codigo = obtieneCodigo();
        
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getraza(){
        return raza;
    }
    public Dueno getdueno(){
        return nombredueño;
    }
    public int getcodigo(){
       return codigo;
    }
    
   public void setnombre(String nombre){
       this.nombre = nombre;
   }
   public void setraza(String raza){
       this.raza = raza;
   }
   public void setdueno(Dueno d){
       nombredueño = d;
       
   }
   public void setcodigo(int codigo){
       this.codigo = codigo;
   }
    /**
     * Metodo llamado desde el constructor para generar codigos a las mascotas ingresadas
     * @return Codigo entero aleatorio para las mascotas creadas
     */
    private int obtieneCodigo(){
        Random r = new Random();
        return r.nextInt(1500);
    }
   
 
}

