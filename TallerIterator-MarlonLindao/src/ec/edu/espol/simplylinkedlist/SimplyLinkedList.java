/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.simplylinkedlist;

import ec.edu.espol.list.List;
import java.util.Iterator;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class SimplyLinkedList<E> implements List<E>,Iterable<E>{
    
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    
    public SimplyLinkedList(){
        first = last = null;
        efectivo = 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        if(element == null) return false;
        Node<E> node = new Node<>(element);
        if(isEmpty())
            first = last = node;
        else {
            node.setNext(first);
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
            temp.setNext(null);
            temp.setData(null);
        }
        efectivo--;
        return true;
            
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        else if(first == last){ 
            first = last = null;
        } else {
            Node<E> p = getPrevious(last);
            p.setNext(null);
            last.setData(null);
            last = p;
        }
        efectivo--;
        return true;
    }
    
    private Node<E> getPrevious(Node<E> temp){
        if(temp == first) return null;
        for(Node<E>p=first; p != null ;p = p.getNext()){
            if(p.getNext() == temp)
                return p;
        }
        return null;
    }

    @Override
    public boolean removeElement(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>p=first;p != null;p=p.getNext()){
            if(p.getData().equals(element)){
                Node<E> temp = getPrevious(p);
                temp.setNext(p.getNext());
                p.setData(null);
                p.setNext(null);
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
        Node<E> previous = getPrevious(temp);
        Node<E> nuevo = new Node<>(element);
        previous.setNext(nuevo);
        nuevo.setNext(temp);
        efectivo++;
        return true;
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
    public boolean contains(E element) {
        if(isEmpty() || element == null) return false;
        for(Node<E>p=first; p != null ;p = p.getNext()){
            if(p.getData().equals(element))
                return true;
        }
        return false;
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
        if(o==null || !(o instanceof SimplyLinkedList))
            return false;
        SimplyLinkedList<E> other = (SimplyLinkedList<E>) o;
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
            reverse(p.getNext(),getPrevious(q));
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
    
    public Iterator<E> iteratorStep(int start,int step){
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = obtain(start);
            private int paso = start;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E e = p.getData();
                int count = 0;
                while(count < step){
                    paso++;
                    if(paso > efectivo-1){
                        p = null;
                        break;
                    }
                    p = p.getNext();
                    count++;
                }
                return e;
            }
        };
        return it;
    }
    
    private class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
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

    }

    
}
