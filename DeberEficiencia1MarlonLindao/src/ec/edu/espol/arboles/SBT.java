/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class SBT<E> implements Serializable{
    
    private NodeBT<E> rootSBT;
    private Comparator<E> f;
    private int contador;
    
    public SBT(Comparator<E> f){
        rootSBT = null;
        this.f = f;
        contador = 0;
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
        System.out.println("holi "+contador);
        contador++;
        return true;
    }
    
    private NodeBT<E> add(E data,NodeBT<E> r){
        if(r == null) r = new NodeBT<>(data);
        
        if(f.compare(data, r.getData())<0) r.setLeft(add(data,r.getLeft()));
        else if(f.compare(data, r.getData())>0) r.setRight(add(data,r.getRight()));
        else return r;
        
        r.setHeight(1 + max(heightNode(r.getLeft()),heightNode(r.getRight())));
        
        int balance = getBalance(r);
        
        if(balance > 1 && f.compare(data, r.getLeft().getData())<0)
            return rightRotate(r);
        
        if(balance < -1 && f.compare(data, r.getRight().getData())>0)
            return leftRotate(r);
        
        if(balance > 1 && f.compare(data, r.getLeft().getData())>0){
            r.setLeft(leftRotate(r.getLeft()));
            return rightRotate(r);
        }
        
        if(balance < -1 && f.compare(data, r.getRight().getData())>0){
            r.setRight(rightRotate(r.getRight()));
            return leftRotate(r);
        }
        
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
    
    public E get(E data){
        if(data==null || isEmpty()) return null;
        NodeBT<E> temp = searchNode(data,this.rootSBT);
        if(temp == null) return null;
        return temp.getData();
    }
    
    public boolean contains(E data){
        if(data==null || isEmpty()) return false;
        return (searchNode(data,rootSBT)) != null;
    }
    
    private NodeBT<E> searchNode(E data,NodeBT<E> r){
        if(r == null) return null;
        else if(f.compare(data, r.getData())==0) return r;
        if(f.compare(data, r.getData())>0) return searchNode(data,r.getRight());
        else return searchNode(data,r.getLeft());
    }
    
    private int heightNode(NodeBT<E> N) { 
        if (N == null) 
            return 0; 
  
        return N.getHeight(); 
    }
    
    private int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
    
    private NodeBT<E> rightRotate(NodeBT<E> y) { 
        NodeBT<E> x = y.getLeft(); 
        NodeBT<E> T2 = x.getRight(); 
  
        x.setRight(y); 
        y.setLeft(T2);
  
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1); 
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1); 

        return x; 
    } 
    
    private NodeBT<E> leftRotate(NodeBT<E> x) { 
        NodeBT<E> y = x.getRight(); 
        NodeBT<E> T2 = y.getLeft(); 
  
        y.setLeft(x); 
        x.setRight(T2); 
   
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1); 
  
        return y; 
    } 
    
    private int getBalance(NodeBT<E> N) { 
        if (N == null) 
            return 0; 
  
        return height(N.getLeft()) - height(N.getRight()); 
    }
    
    public HashMap<E,Integer> getLevels(List<E> claves){
        HashMap<E,Integer> map = new HashMap<>();
        getLevels(claves,map,0,this.rootSBT);
        return map;
    }
    
    private void getLevels(List<E> claves,HashMap<E,Integer> map,int level,NodeBT<E> p){
        if(p != null){
            if(claves.contains(p.getData())){
                map.put(p.getData(), level);
            }
            getLevels(claves,map,level+1,p.getLeft());
            getLevels(claves,map,level+1,p.getRight());
        }
    }
    
    public boolean isMirror(SBT<E> tree){
        if(tree.isEmpty() || this.isEmpty())
            return false;
        return isMirror(this.rootSBT,tree.rootSBT);
    }
    
    private boolean isMirror(NodeBT<E> p, NodeBT<E> q){
        if(p==null&&q==null)
            return true;
        
        if(p==null || q == null)
            return false;
        
        if (!p.getData().equals(q.getData()))
             return false;
        
        return isMirror(p.getLeft(),q.getRight()) && isMirror(p.getRight(),q.getLeft());
        
    }
    
    
}
