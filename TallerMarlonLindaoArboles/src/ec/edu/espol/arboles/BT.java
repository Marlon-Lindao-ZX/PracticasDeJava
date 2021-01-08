/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
        NodeBT<E> nodeC = new NodeBT<>(child);
        if(child==null) return false;
        if(isEmpty() && parent == null)
            root = nodeC;
        else if (searchNode(child) == null){
            NodeBT<E> father = searchNode(parent);
            if(father == null) return false;
            else if(father.getLeft()==null) father.setLeft(nodeC);
            else if(father.getRight()==null) father.setRight(nodeC);
            else return false;
        }
        return true;
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
    
    public boolean remove(E child){
        if(child == null || isEmpty()) return false;
        if(root.getData().equals(child)) {
            root = null;
            return true;
        }
        NodeBT<E> father = searchParent(child);
        if(father==null) return false;
        if(father.getLeft()!=null && father.getLeft().getData().equals(child)) father.setLeft(null);
        else father.setRight(null);
        return true;
    }
    
    private NodeBT<E> searchParent(E child){
        return searchParent(child,root);
    }
    
    private NodeBT<E> searchParent(E child, NodeBT<E> node){
        if(node == null) return null;
        else if(node.getLeft()!= null && node.getLeft().getData().equals(child))
            return node;
        else if(node.getRight()!= null && node.getRight().getData().equals(child))
            return node;
        NodeBT<E> l = searchParent(child,node.getLeft());
        return (l != null) ? l:searchParent(child,node.getRight());
    }

    public void preOrden(){
        preOrden(root);
    }
    
    private void preOrden(NodeBT<E> p){
        if(p != null){
            System.out.print(p.getData()+" ");
            preOrden(p.getLeft());
            preOrden(p.getRight());
        }
    }
    
    public void posOrden(){
        posOrden(root);
    }
    
    private void posOrden(NodeBT<E> p){
        if(p != null){
            posOrden(p.getLeft());
            posOrden(p.getRight());
            System.out.print(p.getData()+" ");
        }
    }
    
    public void enOrden(){
        enOrden(root);
    }
    
    private void enOrden(NodeBT<E> p){
        if(p != null){
            enOrden(p.getLeft());
            System.out.print(p.getData()+" ");
            enOrden(p.getRight());
        }
    }
    
    public int height(){
        return height(root);
    }
    
    private int height(NodeBT<E> p){
        if (p == null) return 0;
        return 1 + Math.max(height(p.getLeft()), height(p.getRight()));
    }
    
    public int countLeaf(){
        return countLeaf(root);
    }
    
    private int countLeaf(NodeBT<E> p){
        if(p == null) return 0;
        else if(p.getLeft() == null && p.getRight() == null)
            return 1;
        return countLeaf(p.getLeft())+countLeaf(p.getRight());
    }
    
    public boolean isFull(){
        if(isEmpty()) return true;
        else if(height(root.getLeft()) == height(root.getRight()))
            return isFull(root);
        return false;
    }
    
    private boolean isFull(NodeBT<E> p){
        if(p == null) return true;
        else if((p.getLeft() == null ^ p.getRight() == null)) 
            return false;
        return isFull(p.getLeft()) && isFull(p.getRight());

    }
    
    public boolean contains(E data){
        if(data == null || isEmpty()) return false;
        return (searchNode(data,root)) != null;
    }
    
    public List<E> equiposDerrotadosFases(String fase, HashMap<String, Integer> fases){
        List<E> result = new LinkedList<>();
        int fase2 = fases.get(fase);
        result.addAll(equiposDerrotadosFases(root,fase2,0));
        return result;
    }
    
    private List<E> equiposDerrotadosFases(NodeBT<E> p, int fase,int count){
        List<E> result = new LinkedList<>();
        if(p == null)
            return new LinkedList<>();
        else if(count >= fase){
            if(p.getRight() != null)
                result.add(p.getRight().getData());

        }
        result.addAll(equiposDerrotadosFases(p.getLeft(),fase,count+1));
        result.addAll(equiposDerrotadosFases(p.getRight(),fase,count+1));
        return result;
    }
    
    public List<E> equiposEliminados(String seleccion){
        List<E> result = new LinkedList<>();
        result.addAll(equiposEliminados(root,seleccion,0));
        return result;
    }
    
    public List<E> equiposEliminados(NodeBT<E> p, String seleccion,int count){
        List<E> result = new LinkedList<>();
        if(p == null)
            return new LinkedList<>();
        else if(p.getData().equals(seleccion+count)){
            if(p.getRight() != null)
                result.add(p.getRight().getData());
        } 
        result.addAll(equiposEliminados(p.getLeft(),seleccion,count+1));
        result.addAll(equiposEliminados(p.getRight(),seleccion,count+1));
        return result;
    }
    
    public BT<E> mirror() {

        BT<E> tree = new BT<>();
        tree.root = mirror(this.root);
        return tree;

    }
    
    private NodeBT<E> mirror(NodeBT<E> p){
        if(p == null)
            return p;
        NodeBT<E> temp = new NodeBT<>(p.getData());
        temp.setLeft(mirror(p.getRight()));
        temp.setRight(mirror(p.getLeft()));
        return temp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.root);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;     
        BT<E> comp = (BT<E>) obj;
        if(this.isEmpty()&&comp.isEmpty())
            return true;
        if((this.isEmpty() || comp.isEmpty()) || this.height() != comp.height()) 
            return false;
        return iguales(this.root,comp.root);
    }
    
    private boolean iguales(NodeBT<E> p,NodeBT<E> q){
        if(p == null && q == null)
            return true;
        else if ((p == null || q == null))
            return false;
        else if(!p.getData().equals(q.getData()))
            return false;
        return iguales(p.getLeft(),q.getLeft()) && iguales(p.getRight(),q.getRight());
    }
    
    
    
}
