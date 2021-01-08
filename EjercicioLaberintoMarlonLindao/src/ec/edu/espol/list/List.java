/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.list;

/**
 *
 * @author CltControl
 * @param <E>
 */
public interface List<E> {
    
    
    
    boolean isEmpty();
    int size();
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean removeFirst();
    boolean removeLast();
    boolean removeElement(E element);
    boolean set(E element, int index);
    boolean insert(E element, int index);
    boolean contains(E element);
    E get(int index) throws Exception;
    E getFirst() throws Exception;
    E getLast() throws Exception;
    boolean reverse();
}
