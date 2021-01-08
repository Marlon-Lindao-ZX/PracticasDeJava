/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.datos;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author CORE I7
 * 
 */
public class RegistroComparator implements Serializable,Comparator<Registro>{
    
    @Override
    public int compare(Registro rg1, Registro rg2){
        int r = rg1.getId() - rg2.getId();
//                (int)((int) rg1.getDistance() - rg2.getDistance());
//        if(r == 0){
//            r = rg1.getPasajeros() - rg2.getPasajeros();
//            if(r == 0){
//                r = (int) ((int) rg1.getValue() - rg2.getValue());
//                if(r == 0){
//                    r = rg1.getFecha_inicio().compareTo(rg2.getFecha_inicio());
//                    if(r == 0)
//                        r = rg1.getFecha_fin().compareTo(rg2.getFecha_fin());
//                }
//            }
//        }
        return r;
    }
}
