/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arraylist;

import ec.edu.espol.generallist.GeneralList;
import ec.edu.espol.list.List;
import java.util.Arrays;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class ArrayList<E> extends GeneralList<E> implements List<E> {
    
    private E[] array;
    private int capacity = 10;

    public ArrayList(){
        array = (E []) new Object[capacity];
    }

    @Override
    public boolean addFirst(E element) {
         if(element == null) 
             return false;
         else if(efectivo == capacity)
             addCapacity();
         desplazar();
         array[0]=element;
         efectivo++;
         return true;
    }
    
    private void desplazar(){
        for(int i = efectivo-1; i>=0;i--)
            array[i+1]=array[i];
    }

    @Override
    public boolean addLast(E element) {
         if(element == null) 
             return false;
         else if(efectivo == capacity)
             addCapacity();
         array[efectivo++]=element;
         return true;
    }
    
    private void addCapacity(){
        E[] tmp = (E[]) new Object[(efectivo/2)+efectivo];
        for(int i = 0; i<efectivo;i++)
            tmp[i] = array[i];
        array = tmp;
        capacity = efectivo + (efectivo/2);
    }

    @Override
    public boolean removeFirst() {
         if(isEmpty()) return false;
         move(0,1);
         array[--efectivo]=null;
         return true;
    }
    
    private void move(int index,int option){
        switch(option)
        {
            case 1:
                for (int i = index+1; i < efectivo; i++){
                    array[i - 1] = array[i];
                }
                break;
            case 2:
                for (int i = efectivo-1; i > index-1; i--) 
                    array[i + 1] = array[i];
                break;
            default:
                break;
        }
    }

    @Override
    public boolean removeLast() {
         if(isEmpty()) return false;
         array[--efectivo]=null;
         return true;
    }

    @Override
    public boolean removeElement(E element) {
        if(isEmpty() || element == null) return false;
        for(int i=0;i<efectivo;i++)
        {
            if(array[i].equals(element))
            {
                move(i,1);
                array[--efectivo]=null;
                return true;
            }
        }
        modifyCapacity();
        return false;
    }
    
    private void modifyCapacity(){
        E[] tmp = (E[]) new Object[((capacity-efectivo)/2)+efectivo];
        for(int i = 0; i<efectivo;i++)
            tmp[i] = array[i];
        array = tmp;
        capacity = efectivo + ((capacity-efectivo)/2);
    }

    @Override
    public boolean set(E element, int index) {
         if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
         array[index] = element;
         return true;
    }
    
    @Override
    public boolean insert(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        if(efectivo == capacity) addCapacity();
        move(index,2);
        array[index] = element;
        efectivo++;
        return true;
    }
    
    @Override
    public boolean contains(E element){
        if(isEmpty() || element == null) return false;
        for(int i = 0;i<efectivo;i++){
            if(array[i].equals(element))
                return true;
        }
        return false;
    }
    
    @Override
    public E getFirst() throws Exception{
        if(isEmpty()) throw new Exception(ERROR1);
        return array[0];
    }

    @Override
    public E getLast() throws Exception{
        if(isEmpty()) throw new Exception(ERROR1);
        return array[efectivo-1];
    }
    
    @Override
    public E get(int index) throws Exception{
        if(isEmpty()) throw new Exception(ERROR1);
        else if(index >= 0 && index < efectivo) return this.array[index];
        else
            throw new Exception("IndexOutBoundException");
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<efectivo;i++)
            sb.append(array[i]).append(",");
        return sb.substring(0, (sb.length()-1)) + "]";
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof ArrayList))
            return false;
        ArrayList<E> other = (ArrayList<E>) o;
        if(this == other) return true;
        if(this.size() != other.size()) return false;
        for(int i=0;i<this.efectivo;i++)
        {
            if(!this.array[i].equals(other.array[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Arrays.deepHashCode(this.array);
        hash = 89 * hash + this.efectivo;
        return hash;
    }

    @Override
    public boolean reverse() {
        if(!isEmpty()) {
            reverse(0,efectivo-1);
            return true;
        }
        return false;
    }
    
    private void reverse(int low,int high){
        if(!(low == high || (low+1)==high)){
            E tmp = array[low];
            array[low]=array[high];
            array[high]=tmp;
            reverse(++low,--high);
        }
    }

    
    
}
