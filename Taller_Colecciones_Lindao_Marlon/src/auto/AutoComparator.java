/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.Comparator;

/**
 *
 * @author CORE I7
 */
public class AutoComparator implements Comparator<Auto>{
    
    private int control;
    
    public AutoComparator(int control){
        this.control = control;
    }
    
    @Override
    public int compare(Auto auto1, Auto auto2){
        int i = 0;
        switch(control){
            case 0:
                i = auto1.getPlaca().compareTo(auto2.getPlaca());
                break;
            case 1:
                i = auto1.getMarca().compareTo(auto2.getMarca());
                break;
            case 2:
                i = auto1.getModelo().compareTo(auto2.getModelo());
                break;
            case 3:
                i = Double.compare(auto1.getPrecio(), auto2.getPrecio());
                break;
            case 4:
                i = auto1.getAnio().compareTo(auto2.getAnio());
                break;
            case 5:
                i = auto1.getColor().compareTo(auto2.getColor());
                break;
            case 6:
                i = Double.compare(auto1.getUbicacionX(), auto2.getUbicacionX());
                break;
            case 7:
                i = Double.compare(auto1.getUbicacionY(), auto2.getUbicacionY());
                break;
        }
        
        return i;
    }
}
