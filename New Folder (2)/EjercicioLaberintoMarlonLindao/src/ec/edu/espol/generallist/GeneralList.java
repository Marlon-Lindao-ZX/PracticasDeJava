/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.generallist;

import ec.edu.espol.list.List;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public abstract class GeneralList<E> implements List<E> {
        
    protected int efectivo;
    protected final static String ERROR1 = "Empty List";
    
    public GeneralList(){
        efectivo = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public int size() {
        return efectivo;
    }
    
    
        
        
        
}
