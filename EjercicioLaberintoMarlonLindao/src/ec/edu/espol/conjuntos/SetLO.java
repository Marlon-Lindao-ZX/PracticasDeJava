/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.conjuntos;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class SetLO<E> {
    
    private LinkedList<E> list;
    private Comparator<E> f;

    public SetLO(Comparator<E> f) {
        this.list = new LinkedList<>();
        this.f = f;
    }
    
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
    
    public boolean add(E element){
        if(element == null) return false;
        else if(isEmpty()) return this.list.add(element);
        else if(f.compare(element, list.getLast())>0)
            list.addLast(element);
        else{
            ListIterator<E> it = list.listIterator();
            while(it.hasNext()){
                E tmp = it.next();
                if(f.compare(tmp,element)==0) return false;
                else if(f.compare(tmp,element)>0){
                    it.previous();
                    it.add(element);
                    return true;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        return list.toString().replace("[","{").replace("]", "}");
    }
    
    public SetLO<E> intersect(SetLO<E> s1,SetLO<E> s2){
        return null;
    }
    
    
    
    
}
