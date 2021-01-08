/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.util.Comparator;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class SBT<E> {
    
    private NodeBT<E> rootSBT;
    private Comparator<E> f;
    
    public SBT(Comparator<E> f){
        rootSBT = null;
        this.f = f;
    }
    
    public boolean isEmpty(){
        return rootSBT==null;
    }
    
    public int size(){
        return size(rootSBT);
    }
    
    private int size(NodeBT<E> r){
        if(r == null) return 0;
        return 1 + size(r.getLeft()) + size(r.getRight());
    }
    
    public boolean add(E data){
        if(data == null) return false;
        this.rootSBT = add(data,rootSBT);
        return true;
    }
    
    private NodeBT<E> add(E data,NodeBT<E> r){
        if(r == null) r = new NodeBT<>(data);
        else if(f.compare(data, r.getData())<0) r.setLeft(add(data,r.getLeft()));
        else if(f.compare(data, r.getData())>0) r.setRight(add(data,r.getRight()));
        return r;
    }
    
    public boolean remove(E data){
        if(data == null || isEmpty()) return false;
        rootSBT = remove(data,rootSBT);
        return true;
    }
    
    private NodeBT<E> remove(E data,NodeBT<E> r){
        if(r == null) return r;
        else if(f.compare(data,r.getData())<0)
            r.setLeft(remove(data,r.getLeft()));
        else if(f.compare(data,r.getData())>0)
            r.setRight(remove(data,r.getRight()));
        else if(r.getLeft() != null && r.getRight() != null){
            r.setData(min(r.getRight()));
            r.setRight(remove(r.getData(),r.getRight()));
        }
        else
            r = (r.getLeft() != null) ? r.getLeft():r.getRight();
        return r;
        
    }
    
    public E min(){
        if(isEmpty()) return null;
        return min(rootSBT);
    }
    
    private E min(NodeBT<E> r){
        if(r.getLeft()==null) return r.getData();
        return min(r.getLeft());
        
    }
    
    public E max(){
        if(isEmpty()) return null;
        return max(rootSBT);
    }
    
    private E max(NodeBT<E> r){
        if(r.getRight()==null) return r.getData();
        return max(r.getRight());
    }

    public void preOrden(){
        preOrden(rootSBT);
    }
    
    private void preOrden(NodeBT<E> r){
        if(r != null){
            System.out.print(r.getData()+" ");
            preOrden(r.getLeft());
            preOrden(r.getRight());
        }
    }
    
    public void posOrden(){
        posOrden(rootSBT);
    }
    
    private void posOrden(NodeBT<E> r){
        if(r != null){
            posOrden(r.getLeft());
            posOrden(r.getRight());
            System.out.print(r.getData()+" ");
        }
    }
    
    public void enOrden(){
        enOrden(rootSBT);
    }
    
    private void enOrden(NodeBT<E> r){
        if(r != null){
            enOrden(r.getLeft());
            System.out.print(r.getData()+" ");
            enOrden(r.getRight());
        }
    }
    
    public int height(){
        return height(rootSBT);
    }
    
    private int height(NodeBT<E> r){
        if (r == null) return 0;
        return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }
    
    public int countLeaf(){
        return countLeaf(rootSBT);
    }
    
    private int countLeaf(NodeBT<E> r){
        if(r == null) return 0;
        else if(r.getLeft() == null && r.getRight() == null)
            return 1;
        return countLeaf(r.getLeft())+countLeaf(r.getRight());
    }
    
    public boolean isFull(){
        if(isEmpty()) return true;
        else if(height(rootSBT.getLeft()) == height(rootSBT.getRight()))
            return isFull(rootSBT);
        return false;
    }
    
    private boolean isFull(NodeBT<E> r){
        if(r == null) return true;
        else if((r.getLeft() == null ^ r.getRight() == null)) 
            return false;
        return isFull(r.getLeft()) && isFull(r.getRight());

    }
    
    public boolean contains(E data){
        if(data==null || isEmpty()) return false;
        return (searchNode(data,rootSBT)) != null;
    }
    
    private NodeBT<E> searchNode(E data,NodeBT<E> r){
        if(r == null) return null;
        else if(r.getData().equals(data)) return r;
        if(f.compare(data, r.getData())>0) return searchNode(data,r.getRight());
        else return searchNode(data,r.getLeft());
    }
    
    
}
