/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller7s2;

/**
 *
 * @author CORE I7
 */
public class Estudiante {
    private String nombre;
    private int [] score = {0,0,0,0,0};
    public static final int [] MAX_SCORE = {25,25,50,75,100};
    
    public Estudiante(){}
    
    public Estudiante(String nombre){
        this.nombre = nombre; 
    }
    
    public void setCalificaciones(int[] calificaciones) throws CalificacionFueraDeRangoException{
        for(int i=0;i<calificaciones.length;i++){
            if(calificaciones[i]>MAX_SCORE[i] || calificaciones[i]<0 ){
                if (calificaciones[i]>MAX_SCORE[i]) {
                    String s = "Error en la calificacion " + (i+1) + " del arreglo enviado, ya que el valor maximo aceptado en esa "
                            + "posicion es "+MAX_SCORE[i];
                    throw new CalificacionFueraDeRangoException(s);
                
                }
            }
        }
        
        this.score = calificaciones;
       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
    
    
}
