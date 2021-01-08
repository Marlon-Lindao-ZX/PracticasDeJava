/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles.heap;

import java.util.Comparator;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class Heap <E> {
    E elements[];
    int efectivo = 0;
    boolean prioridad;
    int capacity = 10;
    Comparator<E> f;
    
    public Heap(Comparator<E> f,boolean prioridad){
        this.elements = (E []) new Object[capacity];
        this.f = f;
        this.prioridad = prioridad;
    }
    
    public boolean isEmpty(){
        return efectivo == 0;
    }
    
    public int size(){
        return efectivo;
    }
    
    private int posIzq(int i){
        int a;
        if(i>=0 && i<=efectivo) a = (2*i) +1;
        else a = -1;
        return a;
    }
    
    private int posDer(int i){
        int a;
        if(i>=0 && i<=efectivo) a = (2*i) +2;
        else a = -1;
        return a;
    }
    
    private int posPadre(int i){
        int a;
        if(i>=0 && i<=efectivo) a = (i-1)/2;
        else a = -1;
        return a;
    }
    
    private void addCapacity(){
        E[] tmp = (E[]) new Object[(efectivo/2)+efectivo];
        System.arraycopy(elements, 0, tmp, 0, efectivo);
        elements = tmp;
        capacity = efectivo + (efectivo/2);
    }
    
    private boolean contains(E element){
        if(isEmpty() || element == null) return false;
        for(int i = 0;i<efectivo;i++){
            if(f.compare(elements[i],element)==0) {
                return true;
            } 
        }
        return false;
    }
    
    private void ajustarMayor(int posnodo) {
        int pos_mayor, izq, der;
        pos_mayor = posnodo;
        izq = posIzq(posnodo);
        der = posDer(posnodo);

        if (izq >= 0 && izq <= this.efectivo && f.compare(elements[izq],elements[pos_mayor]) > 0) 
            pos_mayor = izq;
        
        if (der >= 0 && der <= this.efectivo && f.compare(elements[der],elements[pos_mayor]) > 0) 
            pos_mayor = der;
        
        if (pos_mayor != posnodo) {
            intercambiar(posnodo, pos_mayor);
            ajustarMayor(pos_mayor);
        }
    }
    
    private void ajustarMenor(int posnodo) {
        int pos_menor, izq, der;
        pos_menor = posnodo;
        izq = posIzq(posnodo);
        der = posDer(posnodo);

        if (izq >= 0 && izq <= this.efectivo && f.compare(elements[izq],elements[pos_menor]) < 0) 
            pos_menor = izq;
        
        if (der >= 0 && der <= this.efectivo && f.compare(elements[der],elements[pos_menor]) < 0) 
            pos_menor = der;
        
        if (pos_menor != posnodo) {
            intercambiar(posnodo, pos_menor);
            ajustarMenor(pos_menor);
        }
    }
    
    private void intercambiar(int nodo1,int nodo2){
        E temp = elements[nodo1];
        elements[nodo1] = elements[nodo2];
        elements[nodo2] = temp;
    }

    
    public boolean offer(E data){
        if (!contains(data)) {
            if (efectivo == capacity) 
                addCapacity();
            elements[efectivo] = data;
            subir(efectivo);
            efectivo++;
            return true;
        }
        return false;
    }
    
    private void subir(int nodo) {
        int father = posPadre(nodo);
        if (father >= 0) {
            if (prioridad) {
                if (f.compare(elements[nodo], elements[father]) > 0) {
                    intercambiar(nodo, father);
                }
            } else {
                if (f.compare(elements[nodo], elements[father]) < 0) {
                    intercambiar(nodo, father);
                }
            }
            if (father > 0) {
                subir(father);
            }
        }

    }
    
    public E poll(){
        E retorno = null;
        if(!isEmpty()){
            retorno = elements[0];
            intercambiar(0,efectivo-1);
            efectivo--;
            if(prioridad) ajustarMayor(0);
            else ajustarMenor(0);
        }
        return retorno;
    }
}
