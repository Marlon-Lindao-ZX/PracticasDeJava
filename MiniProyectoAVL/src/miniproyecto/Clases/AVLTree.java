/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyecto.Clases;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Administrador
 */
public class AVLTree<E> {
    private Comparator<E> g;
    private NodeBT<E> root;
    public AVLTree(Comparator<E> g){
        this.g = g;
        this.root= null;
    }
    public boolean isEmpty(){     
        return root== null;
    }
    private  int height(NodeBT<E> p){
        if(p==null) return 0;
        return 1 +Math.max(height(p.getLeft()), height(p.getRight()));        
    }
   
    public NodeBT<E> comprobar(NodeBT<E> p){
        if(p == null) return null;
        if(Math.abs(diferencia(p))>1){
            return p;
        }
        comprobar(searchParent(p.getData()));
        return null;
    }
    public NodeBT<E> searchNode(E data){
        return searchNode(data, root);
    }   
    
    private NodeBT<E> searchNode(E data, NodeBT<E> nodo){
        //caso base
        if(nodo==null){
            return null;
        }
        
        else if(nodo.getData().equals(data)){
            return nodo;
        }
        
        NodeBT<E> nodeLeft = searchNode(data,nodo.getLeft());
        if(nodeLeft!= null){
           return nodeLeft;
        }
        return searchNode(data,nodo.getRight());
    
    }
    public NodeBT<E> searchParent(E data){
        return searchParent(data,root);     
    }
    public NodeBT<E> searchParent(E data, NodeBT<E> nodo){
        if(nodo== null) return null;
        else if((nodo.getLeft() != null && nodo.getLeft().getData().equals(data))|| (nodo.getRight() != null && nodo.getRight().getData().equals(data)) ){
            return nodo;
        }
        NodeBT<E> l = searchParent(data,nodo.getLeft());
        if(l!= null) return l;
        return searchParent(data,nodo.getRight());
    }
    public boolean contains(E element){
        if(element == null || isEmpty()){
            return false;
        }
        return contains(element,root);
        
    }
    private boolean contains(E element, NodeBT<E> p){
        if(p== null){
            return false;
        }
        if(p.getData().equals(element)){
            return true;
        }
        if(g.compare(element, p.getData())>0){
            return contains(element,p.getRight());
        }
            return contains(element,p.getLeft());     
    }
    public boolean add(E e){
        if(e==null) return false;
        if(contains(e)) return false;
        this.root = add(e, this.root);             
        return true;     
    }
    private NodeBT<E> add(E element,NodeBT<E> p){
        if(p== null){
            p= new NodeBT<>(element);
        }else if(g.compare(element, p.getData())>0){
            p.setRight(add(element,p.getRight()));
        }else if(g.compare(element, p.getData())<0){
            p.setLeft(add(element, p.getLeft()));
        }
        actualizar(p);
        return balancear(p);
        
    }
    private NodeBT<E> balancear(NodeBT<E> n){
        if(n.getFactor() == -2){
            if(n.getLeft().getFactor() <=0) return LeftLeftCaso(n);
            else return LeftRightCaso(n);
        }else if(n.getFactor() == +2){
            if(n.getRight().getFactor()>=0) return RightRightCaso(n);
            else return RightLeftCaso(n);
        }
        return n;
    }
   
    private NodeBT<E> LeftLeftCaso(NodeBT<E> n){
        return RightRotation(n);
    }
    private NodeBT<E> RightRightCaso(NodeBT<E> n){
        return LeftRotation(n);
    }
    private NodeBT<E> LeftRightCaso(NodeBT<E> n){
        n.setLeft(LeftRotation(n.getLeft()));
        return LeftLeftCaso(n);
    }
    private NodeBT<E> RightLeftCaso(NodeBT<E> n){
        n.setRight(RightRotation(n.getRight()));
        return RightRightCaso(n);
    }
    private void actualizar(NodeBT<E> n){
        int alturaLeft = (n.getLeft()== null) ? -1 : n.getLeft().getAltura();
        int alturaRight = (n.getRight()== null) ? -1 : n.getRight().getAltura();
        n.setAltura(1+ Math.max(alturaLeft, alturaRight));
        n.setFactor(alturaRight - alturaLeft);         
    }
    private NodeBT<E> RightRotation(NodeBT<E> nodo ){
        NodeBT<E> nuevoPadre = nodo.getLeft();
        nodo.setLeft(nuevoPadre.getRight());
        nuevoPadre.setRight(nodo);
        actualizar(nodo);
        actualizar(nuevoPadre);
        return nuevoPadre; 
    }
    private NodeBT<E> LeftRotation(NodeBT<E> nodo ){
        NodeBT<E> nuevoPadre = nodo.getRight();
        nodo.setRight(nuevoPadre.getLeft());
        nuevoPadre.setLeft(nodo);
        actualizar(nodo);
        actualizar(nuevoPadre);
        return nuevoPadre; 
    }
    public void preorden(){
        System.out.println("");
        preorden(root);
        
    }
    private void preorden(NodeBT<E> nodo){
        
        if(nodo != null){
            System.out.print(nodo.getData()+" ");
            preorden(nodo.getLeft());
            preorden(nodo.getRight());
        }
        
        
    }
    public void postorden(){
        System.out.println("");
        postorden(root);
    }
    private void postorden(NodeBT<E> nodo){
        if(nodo!= null){
            postorden(nodo.getLeft());
            postorden(nodo.getRight());
            System.out.print(nodo.getData()+" ");
        }
    }
    public void inorden(){
        System.out.println("");
        inorden(root);
    }
    private void inorden(NodeBT<E> nodo){
        if(nodo!= null){
            inorden(nodo.getLeft());
            System.out.print(nodo.getData()+" ");
            inorden(nodo.getRight());
            
        }
    }
    public boolean remove(E data){
        if(data== null || !contains(data) )return false;
        this.root = remove(data,this.root);
        return true;
    }
    private NodeBT<E> remove(E data,NodeBT<E> nodo){
        if(nodo == null) return null;
        if(g.compare(data, nodo.getData())>0){
            nodo.setRight(remove(data,nodo.getRight()));          
        }else if(g.compare(data, nodo.getData())<0){
            nodo.setLeft(remove(data,nodo.getLeft()));
        }else{
            if(nodo.getLeft()== null){
                return nodo.getRight();
            }else if(nodo.getRight() == null){
                return nodo.getLeft();
            }else{
                if(nodo.getLeft().getAltura() < nodo.getRight().getAltura()){
                    E valor = max(nodo.getLeft());
                    nodo.setData(valor);
                    nodo.setLeft(remove(valor,nodo.getLeft()));                
                }else{
                    E valor = min(nodo.getRight());
                    nodo.setData(valor);
                    nodo.setRight(remove(valor,nodo.getRight()));
                }
            }
        }
        actualizar(nodo);
        return balancear(nodo);
        
    }
   public E max(){
        if(isEmpty()){
            return null;
        }
        return max(root);
        
    }
    private E max(NodeBT<E> p){
        if(p.getRight()== null){
            return p.getData();
        }
        return max(p.getRight());
    }
    public E min(){
        if(isEmpty()){
            return null;
        }
        return min(root);
        
    }
    private E min(NodeBT<E> p){
        if(p.getLeft()== null){
            return p.getData();
        }
        return min(p.getLeft());
    }

    public NodeBT<E> getRoot() {
        return root;
    }

    public void setRoot(NodeBT<E> root) {
        this.root = root;
    }
    
    public void vaciarArbol(){
        root = null;
    }
    
    public int Nivel(E data){
        if(data == null)
            return -1;
        return Nivel(root,data,0);
    }
    public int Nivel(NodeBT<E> n, E data,int nivel){
        if(n != null){
            if(g.compare(n.getData(),data) == 0)
                return nivel;
            else if(g.compare(n.getData(),data) > 0)
                return Nivel(n.getLeft(),data,nivel+1);
            else if(g.compare(n.getData(),data) < 0)
                return Nivel(n.getRight(),data,nivel+1);
        }else
            return -1;
        return -1;
    }
    
     public int diferencia (NodeBT<E> p){
        return  height(p.getRight()) - height(p.getLeft());
    }
}
