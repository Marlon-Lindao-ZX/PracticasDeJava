/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.busqueda;

import ec.edu.espol.datos.Datos;
import ec.edu.espol.entidades.Migracion;
import ec.edu.espol.entidades.Migrante;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author CORE I7
 */
public class Busqueda {
    
    private Busqueda(){}
    
    public static LinkedList<Migracion> buscarMigrante(LinkedList<Migracion> mig,String busqueda,String option){
        LinkedList<Migracion> retorno = new LinkedList<>();
        if(mig.isEmpty()) return retorno;
        for (Migracion m : mig) {
            switch (option) {
                case "Fecha":
                    LocalDate tmp = LocalDate.parse(busqueda, DateTimeFormatter.ofPattern("dd/mm/aaaa"));
                    if (m.getFechaMigra().equals(tmp)) retorno.add(m);
                    break;
                case "Provincia":
                    if (m.getMigrante().getProvinciaOrigen().equals(busqueda)) retorno.add(m);
                    break;
                case "Canton":
                    if (m.getMigrante().getCantonOrigen().equals(busqueda)) retorno.add(m);
                    break;
                case "Lugar de Destino":
                    if (m.getLugarDestino().equals(busqueda)) retorno.add(m);
                    break;
                default:
                    return retorno;
            }
        }
        return retorno;
        
    }
    
    public static Migrante searchM(String id){
        Migrante temp;
        temp = AuxBusqueda.findMigrante(Datos.getMigrantes(),id);
        if(temp != null) return temp;
        return null;
    }
    
}
