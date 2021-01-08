/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.doublylinkedlist;

import ec.edu.espol.list.List;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author marln
 * @param <E>
 */
public class DoublyLinkedList<E> implements List<E>,Iterable<E>{
    
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    
    public DoublyLinkedList(){
        first = last= null;
        efectivo = 0;
    }

    @Override
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        if(element == null) return false;
        Node<E> node = new Node<>(element);
        if(isEmpty()) first = last = node;
        else {
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if(element == null) return false;
        Node<E> node = new Node<>(element);
        if(isEmpty())
            first = last = node;
        else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        else if(first == last){ 
            first = last = null;
        } else {
            Node<E> temp = first;
            first = first.getNext();
            first.setPrevious(null);
            temp.setNext(null);
            temp.setData(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        else if(first == last) first = last = null;
        else{
            last = last.getPrevious();
            last.getNext().setPrevious(null);
            last.getNext().setData(null);
            last.setNext(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeElement(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>p=first;p != null;p=p.getNext()){
            if(p.getData().equals(element)){
                Node<E> temp = p.getPrevious();
                temp.setNext(p.getNext());
                p.getNext().setPrevious(temp);
                p.setData(null);
                p.setNext(null);
                p.setPrevious(null);
                efectivo--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        Node<E> temp = obtain(index);
        temp.setData(element);
        return true;
    }

    @Override
    public boolean insert(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        Node<E> temp = obtain(index);
        Node<E> nuevo = new Node<>(element);
        nuevo.setNext(temp);
        nuevo.setPrevious(temp.getPrevious());
        temp.getPrevious().setNext(nuevo);
        temp.setPrevious(nuevo);
        efectivo++;
        return true;
    }

    @Override
    public boolean contains(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>p=first; p != null ;p = p.getNext()){
            if(p.getData().equals(element))
                return true;
        }
        return false;
    }

    @Override
    public E get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty List");
        } else if (index >= 0 && index < efectivo) {
            return obtain(index).getData();
        } else {
            throw new Exception("IndexOutBoundException");
        }
    }
    
    private Node<E> obtain(int index){
        if(!(index >= 0 && index < efectivo)) return null;
        if(index == 0) return first;
        else if(index == efectivo-1) return last;
        int i = 1;
        for(Node<E>p=first.getNext(); p != null ;p = p.getNext()){
            if(i == index)
                return p;
            i++;
        }
        return null;
    }

    @Override
    public E getFirst() throws Exception {
        if(isEmpty()) throw new Exception("Empty List");
        return first.getData();
    }

    @Override
    public E getLast() throws Exception {
        if(isEmpty()) throw new Exception("Empty List");
        return last.getData();
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<E>p=first; p != null ;p = p.getNext())
            sb.append(p.getData()).append(",");
        return sb.substring(0, (sb.length()-1)) + "]";
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof DoublyLinkedList))
            return false;
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
        if(this == other) return true;
        if(this.size() != other.size()) return false;
        Node<E>j=other.first;
        for(Node<E>p=first; p != null ;p = p.getNext())
        {
            if(!p.getData().equals(j.getData())){
                return false;
            }
            j=j.getNext();
        }
        return true;
    }

    @Override
    public void reverse() {
        if(!isEmpty()) reverse(this.first,this.last);
    }
    
    private void reverse(Node<E> p,Node<E> q){
        if(!(p == q || q.getNext()==p)){
            E tmp = p.getData();
            p.setData(q.getData());
            q.setData(tmp);
            reverse(p.getNext(),q.getPrevious());
        }
    }

    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = first;
            
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return lit;
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
