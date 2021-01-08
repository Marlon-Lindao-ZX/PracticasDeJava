/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.queue;

/**
 *
 * @author marln
 */
public interface Queue <E> {
    
    boolean isEmpty();
    boolean offer(E element);
    E poll();
    E peek();
    
}
