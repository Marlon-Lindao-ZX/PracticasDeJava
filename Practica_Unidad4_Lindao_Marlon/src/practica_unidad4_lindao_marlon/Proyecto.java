/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_unidad4_lindao_marlon;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Proyecto {
    private int lineasdecodigorequeridas;
    private int lineasdecodigoescritas;
    private int lineasdecodigoprobadas;
    private int duracion;
    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public Proyecto(int lineasdecodigorequeridas, int duracion) {
        this.lineasdecodigorequeridas = lineasdecodigorequeridas;
     
        this.duracion = duracion;
    }
    
    public Proyecto(Proyecto p){
        lineasdecodigorequeridas = p.lineasdecodigorequeridas;
        duracion = p.duracion;
    }
    
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
        
    }
    
    public int hacerproyecto(ArrayList<Empleado> empleados){
        int diastomoproyecto = 0;
        while (!(lineasdecodigoescritas >= lineasdecodigorequeridas) || !(lineasdecodigoprobadas >= lineasdecodigorequeridas)) {

            for (Empleado e : empleados) {
                if (e instanceof Programador) {
                    int sumador1;
                    ((Programador) e).setLineascodigopordia(((Programador) e).trabajar());
                    sumador1 = ((Programador) e).getLineascodigopordia();
                    lineasdecodigoescritas += sumador1;
                } else {
                    int sumador2;
                    ((Testers) e).setLineascodigoprobadopordia(((Testers) e).trabajar());
                    sumador2 = ((Testers) e).getLineascodigoprobadopordia();
                    lineasdecodigoprobadas += sumador2;
                }
            }
            diastomoproyecto++;
              
        }
        return diastomoproyecto;
    }

    public int getLineasdecodigorequeridas() {
        return lineasdecodigorequeridas;
    }

    public void setLineasdecodigorequeridas(int lineasdecodigorequeridas) {
        this.lineasdecodigorequeridas = lineasdecodigorequeridas;
    }

    
    public int getLineasdecodigoescritas() {
        return lineasdecodigoescritas;
    }

    public void setLineasdecodigoescritas(int lineasdecodigoescritas) {
        this.lineasdecodigoescritas = lineasdecodigoescritas;
    }

    public int getLineasdecodigoprobadas() {
        return lineasdecodigoprobadas;
    }

    public void setLineasdecodigoprobadas(int lineasdecodigoprobadas) {
        this.lineasdecodigoprobadas = lineasdecodigoprobadas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    
}
