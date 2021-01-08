/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyecto.Clases;

import java.util.Objects;

/**
 *
 * @author chard
 */
public class NodeBT<E>{
        private E data ;
    private NodeBT left;
    private NodeBT right; 
    private int factor;
    private int altura;
    public NodeBT(E data){
        this.data = data;
        left = null;
        right = null;
        factor = 0;
        altura = 0;
        
        
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeBT<?> other = (NodeBT<?>) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
        
    
 }
