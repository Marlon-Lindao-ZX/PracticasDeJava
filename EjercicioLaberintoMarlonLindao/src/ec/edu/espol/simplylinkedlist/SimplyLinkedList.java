/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.simplylinkedlist;

import ec.edu.espol.generallist.GeneralList;
import ec.edu.espol.list.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author CORE I7
 * @param <E>
 */
public class SimplyLinkedList<E> extends GeneralList<E> implements List<E>,Iterable<E>{
    
    private NodeS<E> first;
    private NodeS<E> last;
    
    public SimplyLinkedList(){
        first = last = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public boolean addFirst(E element) {
        if(element == null) return false;
        NodeS<E> node = new NodeS<>(element);
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
        NodeS<E> node = new NodeS<>(element);
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
            NodeS<E> temp = first;
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
            NodeS<E> p = getPrevious(last);
            if (p == null) return false;
            p.setNext(null);
            last.setData(null);
            last = p;
        }
        efectivo--;
        return true;
    }
    
    private NodeS<E> getPrevious(NodeS<E> temp){
        if(temp == first) return null;
        for(NodeS<E>p=first; p != null ;p = p.getNext()){
            if(p.getNext() == temp)
                return p;
        }
        return null;
    }

    @Override
    public boolean removeElement(E element) {
        if(isEmpty() || element == null) return false;
        for(NodeS<E>p=first;p != null;p=p.getNext()){
            if(p.getData().equals(element)){
                NodeS<E> temp = getPrevious(p);
                if(temp == null) return false;
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
        NodeS<E> temp = obtain(index);
        if(temp != null){
            temp.setData(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(E element, int index) {
        if(isEmpty() || element == null || !(index >= 0 && index < efectivo)) return false;
        NodeS<E> temp = obtain(index);
        NodeS<E> previous = getPrevious(temp);
        if(temp == null ||previous == null) return false;
        NodeS<E> nuevo = new NodeS<>(element);
        previous.setNext(nuevo);
        nuevo.setNext(temp);
        efectivo++;
        return true;
    }

    @Override
    public E get(int index) throws Exception {

        if (isEmpty()) {
            throw new Exception(ERROR1);
        } else if (index >= 0 && index < efectivo) {
            NodeS<E> tmp = obtain(index);
            if(tmp == null) throw new Exception("NullException");
            return tmp.getData();
        } else {
            throw new Exception("IndexOutBoundException");
        }

    }
    
    private NodeS<E> obtain(int index){
         if(!(index >= 0 && index < efectivo)) return null;
        if(index == 0) return first;
        else if(index == efectivo-1) return last;
        int i = 1;
        for(NodeS<E>p=first.getNext(); p != null ;p = p.getNext()){
            if(i == index)
                return p;
            i++;
        }
        return null;
    }

    @Override
    public E getFirst() throws Exception {
        if(isEmpty()) throw new Exception(ERROR1);
        return first.getData();
    }

    @Override
    public E getLast() throws Exception {
        if(isEmpty()) throw new Exception(ERROR1);
        return last.getData();
    }

    @Override
    public boolean contains(E element) {
        if(isEmpty() || element == null) return false;
        for(NodeS<E>p=first; p != null ;p = p.getNext()){
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
        for(NodeS<E>p=first; p != null ;p = p.getNext())
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
        NodeS<E>j=other.first;
        for(NodeS<E>p=first; p != null ;p = p.getNext())
        {
            if(!p.getData().equals(j.getData())){
                return false;
            }
            j=j.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.first);
        hash = 37 * hash + Objects.hashCode(this.last);
        return hash;
    }
    
    

    @Override
    public boolean reverse() {
        if(!isEmpty()){
            reverse(this.first,this.last);
            return true;
        } 
        return false;
    }
    
    private void reverse(NodeS<E> p,NodeS<E> q){
        if(!(p == q || q.getNext()==p)){
            E tmp = p.getData();
            p.setData(q.getData());
            q.setData(tmp);
            reverse(p.getNext(),getPrevious(q));
        }
    }
    
    @Override
    public Iterator<E> iterator(){
        Iterator<E> its = new Iterator<E>() {
            private NodeS<E> r = first;
            
            @Override
            public boolean hasNext() {
                return r != null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                E e = r.getData();
                r = r.getNext();
                return e;
            }
        };
        return its;
    }
    
    public Iterator<E> iteratorStep(int start,int step){
        Iterator<E> it = new Iterator<E>() {
            private NodeS<E> p = obtain(start);
            private int paso = start;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    throw new NoSuchElementException();
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
    
    private class NodeS<E> {

        private E data;
        private NodeS<E> next;

        public NodeS(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public NodeS<E> getNext() {
            return next;
        }

        public void setNext(NodeS<E> next) {
            this.next = next;
        }

    }

    
}
