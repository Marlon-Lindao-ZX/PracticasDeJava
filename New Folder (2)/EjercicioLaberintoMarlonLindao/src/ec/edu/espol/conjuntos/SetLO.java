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
    
    public SetLO<E> intersect(SetLO<E> s1){
        SetLO<E> intersection = new SetLO<>(this.f);
        if((this.isEmpty())||(s1.isEmpty())) return intersection;
        ListIterator<E> l1 = this.list.listIterator();
        ListIterator<E> l2 = s1.list.listIterator();
        E tmp1 = l1.next();
        E tmp2 = l2.next();
        int cmp;
        do{
            cmp = f.compare(tmp1, tmp2);
            if(cmp == 0) intersection.add(tmp1);
            if(cmp == 0 || cmp <0)
                tmp1 = l1.next();
            tmp2 = l2.next();
        }while(l1.hasNext()&& l2.hasNext());
        return intersection;
    }

    public LinkedList<E> getList() {
        return list;
    }

    public void setList(LinkedList<E> list) {
        this.list = list;
    }

    public Comparator<E> getF() {
        return f;
    }

    public void setF(Comparator<E> f) {
        this.f = f;
    }
    
    
    
    
    
    
    
}
