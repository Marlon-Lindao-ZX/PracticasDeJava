/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_unidad4_lindao_marlon;

import java.util.Random;

/**
 *
 * @author Estudiante
 */
public class Testers extends Empleado {
    
    private int lineascodigoprobadopordia;
    
     public Testers(String nombre, String cedula){
        super(nombre, cedula);
        
    }

    public int getLineascodigoprobadopordia() {
        return lineascodigoprobadopordia;
    }

    public void setLineascodigoprobadopordia(int lineascodigoprobadopordia) {
        this.lineascodigoprobadopordia = lineascodigoprobadopordia;
    }
    
    @Override
    public int trabajar(){
        int lineascodigoprobadoenundia,x;
        Random r = new Random();
        x = r.nextInt(51) + 75;
        lineascodigoprobadoenundia = x;
        return lineascodigoprobadoenundia;
    }

    @Override
    public String toString() {
        String s = "Tester tiene: "+super.toString()+"Lineas de codigo probado por dia: "+lineascodigoprobadopordia;
        return s;
    }
    
    
}
