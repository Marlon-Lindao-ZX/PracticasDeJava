/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class BT<E> {
    private NodeBT<E> root;
    
    public BT(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
    public boolean add(E child,E parent){
        if(child == null) return false;
        if(searchNode(child) == null)
            if(isEmpty())
                return true;
        return false;
    }
    
    private NodeBT<E> searchNode(E data){
        if(data == null || isEmpty()) return null;
        return searchNode(data,root);
    }
    
    private NodeBT<E> searchNode(E data,NodeBT<E> p){
        if(p==null) return null;
        else if(p.getData().equals(data))
            return p;
        NodeBT<E> l = searchNode(data,p.getLeft());
        return (l != null) ? l:searchNode(data,p.getRight());
    }
    
    public int size(){
        return size(root);
    }
    
    private int size(NodeBT<E> p){
        if(p == null) return 0;
        return 1 + size(p.getLeft()) + size(p.getRight());
    }
    
    public int height(){
        return height(root);
    }
    
    private int height(NodeBT<E> p){
        if (p == null) return 0;
        return 1 + Math.max(height(p.getLeft()), height(p.getRight()));
    }
     
    
    
    
    
}
