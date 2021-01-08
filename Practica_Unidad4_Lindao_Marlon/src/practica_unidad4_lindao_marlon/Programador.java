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
public class Programador extends Empleado{
    private int lineascodigopordia;
    
    public Programador(String nombre, String cedula){
        super(nombre, cedula);
        
    }

    public int getLineascodigopordia() {
        return lineascodigopordia;
    }

    public void setLineascodigopordia(int lineascodigopordia) {
        this.lineascodigopordia = lineascodigopordia;
    }
    
    
    @Override
    public int trabajar(){
        int lineascodigoendiadado, x;
        Random r = new Random();
        x = r.nextInt(101) + 50 ;
        lineascodigoendiadado = x;
        return lineascodigoendiadado;
    }
    
    @Override
    public String toString() {
        String s = "Programador tiene: " + super.toString() + "Lineas de codigo escritos por dia: " + lineascodigopordia;
        return s;
    }
    
    
}
