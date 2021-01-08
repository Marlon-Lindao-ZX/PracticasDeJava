/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.doublylinkedlist;

import ec.edu.espol.generallist.GeneralList;
import ec.edu.espol.list.List;
import ec.edu.espol.queue.Queue;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author marln
 * @param <E>
 */
public class DoublyLinkedList<E> extends GeneralList<E> implements List<E>,Iterable<E>,Queue<E>{
    
    private Node<E> firstD;
    private Node<E> lastD;
    
    
    public DoublyLinkedList(){
        firstD = lastD= null;
        efectivo = 0;
    }

    @Override
    public boolean addFirst(E element) {
        //if element equals null return false
        if(element == null) return false;
        Node<E> node = new Node<>(element);
        if(isEmpty()) firstD = lastD = node;
        else {
            node.setNext(firstD);
            firstD.setPrevious(node);
            firstD = node;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if(element == null) return false;
        Node<E> node = new Node<>(element);
        if(isEmpty())
            firstD = lastD = node;
        else {
            lastD.setNext(node);
            node.setPrevious(lastD);
            lastD = node;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        else if(firstD == lastD){ 
            firstD = lastD = null;
        } else {
            Node<E> temp = firstD;
            firstD = firstD.getNext();
            firstD.setPrevious(null);
            temp.setNext(null);
            temp.setData(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        else if(firstD == lastD) firstD = lastD = null;
        else{
            lastD = lastD.getPrevious();
            lastD.getNext().setPrevious(null);
            lastD.getNext().setData(null);
            lastD.setNext(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeElement(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>v=firstD;v != null;v=v.getNext()){
            if(v.getData().equals(element)){
                Node<E> tmp = v.getPrevious();
                tmp.setNext(v.getNext());
                v.getNext().setPrevious(tmp);
                v.setData(null);
                v.setNext(null);
                v.setPrevious(null);
                efectivo--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        Node<E> tep = obtain(index);
        if(tep != null){
            tep.setData(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        Node<E> tmp = obtain(index);
        if (tmp != null) {
            Node<E> nuevo = new Node<>(element);
            nuevo.setNext(tmp);
            nuevo.setPrevious(tmp.getPrevious());
            tmp.getPrevious().setNext(nuevo);
            tmp.setPrevious(nuevo);
            efectivo++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>p=firstD; p != null ;p = p.getNext()){
            if(p.getData().equals(element))
                return true;
        }
        return false;
    }

    @Override
    public E get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception(ERROR1);
        } else if (index >= 0 && index < efectivo) {
            Node<E> tmp = obtain(index);
            if(tmp != null){
                return tmp.getData();
            }
            throw new Exception("Null element");
        } else {
            throw new Exception("IndexOutBoundException");
        }
    }
    
    private Node<E> obtain(int index){
        if(!(index >= 0 && index < efectivo)) return null;
        if(index == 0) return firstD;
        else if(index == efectivo-1) return lastD;
        int i = 1;
        for(Node<E>p=firstD.getNext(); p != null ;p = p.getNext()){
            if(i == index)
                return p;
            i++;
        }
        return null;
    }

    @Override
    public E getFirst() throws Exception {
        if(isEmpty()) throw new Exception(ERROR1);
        return firstD.getData();
    }

    @Override
    public E getLast() throws Exception {
        if(isEmpty()) throw new Exception(ERROR1);
        return lastD.getData();
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<E>v=firstD; v != null ;v = v.getNext())
            sb.append(v.getData()).append(",");
        return sb.substring(0, (sb.length()-1)) + "]";
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof DoublyLinkedList))
            return false;
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
        if(this == other) return true;
        if(this.size() != other.size()) return false;
        Node<E>j=other.firstD;
        for(Node<E>v=firstD; v != null ;v = v.getNext())
        {
            if(!v.getData().equals(j.getData())){
                return false;
            }
            j=j.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.firstD);
        hash = 67 * hash + Objects.hashCode(this.lastD);
        return hash;
    }
    
    

    @Override
    public boolean reverse() {
        if(!isEmpty()) {
            reverse(this.firstD,this.lastD);
            return true;
        } 
        return false;

    }
    
    private void reverse(Node<E> p,Node<E> q){
        if(!(p == q || q.getNext()==p)){
            E tmp = p.getData();
            p.setData(q.getData());
            q.setData(tmp);
            reverse(p.getNext(),q.getPrevious());
        }
    }

    @Override
    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = firstD;
            
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                E e = p.getData();
                p = p.getNext();
                return e;
            }
        };
        return it;
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> lit = new ListIterator<E>(){
            
            Node<E> p = obtain(index);
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                E e = p.getData();
                p = p.getNext();
                return e;
            }

            @Override
            public boolean hasPrevious() {
                return p != null;
            }

            @Override
            public E previous() {
                if(!hasPrevious())
                    throw new NoSuchElementException();
                E e = p.getData();
                p = p.getPrevious();
                return e;
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                Node<E> temp = p.getPrevious();
                temp.setNext(p.getNext());
                p.getNext().setPrevious(temp);
                p.setData(null);
                p.setNext(null);
                p.setPrevious(null);
                p = temp.getNext();
                efectivo--;
            }

            @Override
            public void set(E e) {
                if(p!=null) p.setData(e);
            }

            @Override
            public void add(E e) {
                if(e != null){
                    Node<E> nuevo = new Node<>(e);
                    nuevo.setNext(p);
                    nuevo.setPrevious(p.getPrevious());
                    p.getPrevious().setNext(nuevo);
                    p.setPrevious(nuevo);
                    p = nuevo;
                    efectivo++;
                }
                
            }
        };
        return lit;
    }

    @Override
    public boolean offer(E element) {
        return addLast(element);
    }

    @Override
    public E poll() {
        E data;
        try{
            data = getFirst();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } 
        
        removeFirst();
        return data;
        
        
    }

    @Override
    public E peek() {
        try{
            return getFirst();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
    private class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data) {
            this.data = data;
            next = previous= null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

    }
}
