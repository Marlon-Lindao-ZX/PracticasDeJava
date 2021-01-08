/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

import java.util.ArrayList;

/**
 * Clase que hereda de Produccion
 * @author ACarrera
 */
public class Serie extends Produccion {
    private ArrayList<Temporada> temporadas;
    //TODO: Modificar constructores.
    
    public Serie(String nombre,String genero,String productor,ArrayList<Temporada> temporadas) {
        super(nombre,genero,productor);
        this.temporadas = temporadas;
    }
    
    /***
     * metodo que muestra los atributos de la Serie, a excepcion de la lista temporadas
     * @return 
     */
    @Override
    public String toString(){
        return super.toString();
    }
    
    /***
     * metodo para actualizar el estado de una temporada a prestada
     * @param numTemporadas
     * @return 
     */
    public boolean prestar(int numTemporadas) {
        boolean c = true;
        this.temporadas.get(numTemporadas).setEstado(Estados.P);
        for (Temporada temporada : temporadas) {
            if (temporada.getEstado() == Estados.A) {
                c = false;
                break;
            }
        }
        if (c) {
            this.setEstado(Estados.P);
            return true;
        }
        return false;
    }

            
}
