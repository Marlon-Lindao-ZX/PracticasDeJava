/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.io.Serializable;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class NodeBT<E> implements Serializable{
    
    private E data;
    private NodeBT<E> left;
    private NodeBT<E> right;
    private int height;
    
    public NodeBT(E data){
        this.data = data;
        left = right = null;
        height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeBT<E> getLeft() {
        return left;
    }

    public void setLeft(NodeBT<E> left) {
        this.left = left;
    }

    public NodeBT<E> getRight() {
        return right;
    }

    public void setRight(NodeBT<E> right) {
        this.right = right;
    }
    
    
}
