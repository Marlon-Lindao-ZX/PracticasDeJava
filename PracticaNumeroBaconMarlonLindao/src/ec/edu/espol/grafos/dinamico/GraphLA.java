/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.dinamico;

import ec.edu.espol.grafos.tallergrafos.Actor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author CltControl
 */
public class GraphLA<E> {
    private List<Vertex<E>> vertexes;
    private boolean directed;
    
    public GraphLA(boolean directed){
        vertexes = new LinkedList<>();
        this.directed = directed;
    }
    
    public boolean addVertex(E data){
        Vertex<E> v = new Vertex<>(data);
        if(data == null || this.vertexes.contains(v))
            return false;
        return this.vertexes.add(v);
    }
    
    public boolean addEdge(E origen,E destino,int peso){
        if(origen==null||destino==null)return false;
        Vertex<E> vo = searchVertex(origen);
        Vertex<E> vd = searchVertex(destino);
        if(vo == null || vd == null) return false;
        Edge<E> e = new Edge<>(vo,vd,peso);
        if(vo.getEdges().contains(e)) return false;
        vo.getEdges().add(e);
        if(!directed){
            Edge<E> e1 = new Edge<>(vd,vo,peso);
            vd.getEdges().add(e1);
        }
        return true;
    }
    
    public boolean addEdge(int origen,int destino,int peso,String movie,GraphLA<Actor> arbol){
        
        Vertex<Actor> vo = searchVertex(new Actor(origen),arbol);
        Vertex<Actor> vd = searchVertex(new Actor(destino),arbol);
        if(vo == null || vd == null) return false;
        Edge<Actor> e = new Edge<>(vo,vd,peso,movie);
        if(vo.getEdges().contains(e)) return false;
        vo.getEdges().add(e);
        if(!directed){
            Edge<Actor> e1 = new Edge<>(vd,vo,peso,movie);
            vd.getEdges().add(e1);
        }
        return true;
    }
    
    private Vertex<E> searchVertex(E data){
        for(Vertex<E> v: this.vertexes){
            if(v.getData().equals(data)) return v;
        }
        return null;
    }
    
    private Vertex<Actor> searchVertex(Actor data,GraphLA<Actor> arbol){
        for(Vertex<Actor> v: arbol.vertexes){
            if(v.getData().equals(data)) return v;
        }
        return null;
    }
    
    public boolean removeEdge(E origen,E destino){
        if(origen==null||destino==null)return false;
        Vertex<E> vo = searchVertex(origen);
        Vertex<E> vd = searchVertex(destino);
        if(vo == null || vd == null) return false;
        Edge<E> e = new Edge<>(vo,vd,0);
        vo.getEdges().remove(e);
        if(!directed){
            e = new Edge<>(vd,vo,0);
            vd.getEdges().remove(e);
        }
        return true;
    }
    
    public boolean removeVertex(E data){
        if(data == null) return false;
        Vertex<E> v = searchVertex(data);
        if(v == null) return false;
        ListIterator<Vertex<E>> itv = vertexes.listIterator();
        while(itv.hasNext()){
            Vertex<E> v1 = itv.next();
            ListIterator<Edge<E>> ite = v1.getEdges().listIterator();
            while(ite.hasNext()){
                Edge<E> e1 = ite.next();
                if(e1.getDestiny().equals(v))
                    ite.remove();
            }
        }
        v.getEdges().clear();
        return this.vertexes.remove(v);
    }
    
    public int inDegree(E data){
        if(data == null) return 0;
        Vertex<E> v = searchVertex(data);
        if(v == null) return 0;
        return v.getEdges().size();
    }
    
    public int outDegree(E data){
        if(data == null) return 0;
        Vertex<E> v = searchVertex(data);
        if(v == null) return 0;
        int sum = 0;
        ListIterator<Vertex<E>> itv = vertexes.listIterator();
        while(itv.hasNext()){
            Vertex<E> v1 = itv.next();
            ListIterator<Edge<E>> ite = v1.getEdges().listIterator();
            while(ite.hasNext()){
                Edge<E> e1 = ite.next();
                if(e1.getDestiny().equals(v))
                    sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "V=";
        ArrayList<String> temp = new ArrayList();
        ArrayList<String> temp1 = new ArrayList();
        for(Vertex<E> v:this.vertexes){
            temp.add(v.getData().toString());
            for(Edge<E> e: v.getEdges()){
                temp1.add("("+e.getOrigin().getData()+","+e.getDestiny().getData()+","+e.getPeso()+")");
            }
        }
        result+=temp.toString()+"\n";
        result+="E=";
        result+=temp1.toString();
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null || !(obj instanceof GraphLA)) return false;
        GraphLA<E> other = (GraphLA<E>) obj;
        if(this.vertexes.size()!=other.vertexes.size()) return false;
        HashSet<Vertex<E>> temp = new HashSet<>();
        temp.addAll(this.vertexes);
        temp.retainAll(other.vertexes);
        if(temp.size()!=this.vertexes.size()) return false;
        for(Vertex<E> v1: this.vertexes){
            for(Vertex<E> v2 : other.vertexes){
                if(v1.equals(v2)){
                    HashSet<Edge<E>> temp1 = new HashSet<>();
                    temp1.addAll(v1.getEdges());
                    temp1.retainAll(v2.getEdges());
                    if(temp1.size()!=v1.getEdges().size()) return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.vertexes);
        hash = 37 * hash + (this.directed ? 1 : 0);
        return hash;
    }
    
    public List<E> bfs(E origen){
        List<E> resultado = new LinkedList<>();
        Queue<Vertex<E>> cola = new LinkedList<>();
        Vertex<E> v = searchVertex(origen);
        if(v != null){
            v.setVisited(true);
            cola.offer(v);
            while(!cola.isEmpty()){
                v = cola.poll();
                resultado.add(v.getData());
                for(Edge<E> e: v.getEdges()){
                    if(!e.getDestiny().isVisited()){
                        e.getDestiny().setVisited(true);
                        cola.offer(e.getDestiny());
                    }
                }
            }
        }
        cleanVertex();
        return resultado;
    }
    
    public List<E> dfs(E origen){
        List<E> resultado = new LinkedList<>();
        Stack<Vertex<E>> pila = new Stack<>();
        Vertex<E> v = searchVertex(origen);
        if(v != null){
            v.setVisited(true);
            pila.push(v);
            while(!pila.isEmpty()){
                v = pila.pop();
                resultado.add(v.getData());
                for(Edge<E> e: v.getEdges()){
                    if(!e.getDestiny().isVisited()){
                        e.getDestiny().setVisited(true);
                        pila.push(e.getDestiny());
                    }
                }
            }
        }
        cleanVertex();
        return resultado;
    }
    
    private void cleanVertex(){
        for(Vertex<E> v: this.vertexes){
            v.setVisited(false);
            v.setBestMovie(null);
        }
    }
    
    
    public GraphLA<E> reverse(){
        GraphLA<E> result = new GraphLA<>(this.directed);
        if(!this.vertexes.isEmpty()){
            result.vertexes.addAll(this.vertexes);
            ListIterator<Vertex<E>> itv = this.vertexes.listIterator();
                        
            while(itv.hasNext()){
                Vertex<E> temp1 = itv.next();
                for(Edge e: temp1.getEdges())
                    result.addEdge((E) e.getDestiny().getData(), (E) e.getOrigin().getData(), e.getPeso());
            }
            
        }
        return result;
    }
    
    public List<HashSet<E>> isConnected(){
        return new LinkedList<>();
    }
    
    public List<Vertex<E>> disktra(E origen,E destino){
        Vertex<E> vo = searchVertex(origen);
        Vertex<E> vd = searchVertex(destino);
        List<Vertex<E>> result = new LinkedList<>();
        if(!(vo == null || vd == null)){
            disktra(vo);
            for(Vertex<E> tmp = vd; tmp != null; tmp=vd.getAntecesor()){
                result.add(tmp);
            }
        }
        return result;
        
    }
    
    private void disktra(Vertex<E> vo) {
        cleanVertex();
        vo.setDistance(0);
        PriorityQueue<Vertex<E>> pq = new PriorityQueue<>((Vertex<E> v1, Vertex<E> v2) -> v1.getDistance() - v2.getDistance());
        pq.offer(vo);
        while (!pq.isEmpty()) {
            Vertex<E> temp = pq.poll();
            temp.setVisited(true);
            for (Edge e : temp.getEdges()) {
                Vertex<E> temp2 = e.getDestiny();
                if ((temp.getDistance() + e.getPeso()) < temp2.getDistance() && !temp2.isVisited()) {
                    temp2.setAntecesor(temp);
                    temp2.setDistance(temp.getDistance() + e.getPeso());
                    pq.offer(temp2);
                }
            }
        }
    }
    
    public List<String> disktra(int origen,int destino,GraphLA<Actor> arbol){
        Vertex<Actor> vo = searchVertex(new Actor(origen),arbol);
        Vertex<Actor> vd = searchVertex(new Actor(destino),arbol);
        List<String> result = new LinkedList<>();
        if(!(vo == null || vd == null)){
            disktra1(vo);
            for(Vertex<Actor> tmp = vd; tmp != null; tmp=tmp.getAntecesor()){
                result.add(tmp.getData().getNombre());
                if(tmp.getAntecesor()!=null)
                    result.add(tmp.getBestMovie());
            }
        }
        return result;
        
    }
    
    private void disktra1(Vertex<Actor> vo) {
        cleanVertex();
        vo.setDistance(0);
        PriorityQueue<Vertex<Actor>> pq = new PriorityQueue<>((Vertex<Actor> v1, Vertex<Actor> v2) -> v2.getDistance() - v1.getDistance());
        pq.offer(vo);
        while (!pq.isEmpty()) {
            Vertex<Actor> temp = pq.poll();
            temp.setVisited(true);
            for (Edge e : temp.getEdges()) {
                Vertex<Actor> temp2 = e.getDestiny();
                if ((temp.getDistance() + e.getPeso()) < temp2.getDistance() && !temp2.isVisited()) {
                    temp2.setAntecesor(temp);
                    temp2.setDistance(temp.getDistance() + e.getPeso());
                    temp2.setBestMovie(e.getMovie());
                    pq.offer(temp2);
                }
            }
        }
    }
    
    public boolean escalera(E inicio, E data, int pasos){
        Vertex<E> temp = searchVertex(inicio);
        if(temp == null) return false;
        return escalera(temp,data,pasos);
    }
    
    private boolean escalera(Vertex<E> v, E data, int pasos){
        if(v.getData().equals(data)) return true;
        for(Edge<E> e: v.getEdges())
            if(!escalera(e.getDestiny(),data,pasos,1)) return false;
        return true;
    }
    
    private boolean escalera(Vertex<E> v, E data, int pasos,int contador){
        if(contador>pasos) return false;
        if(v.getData().equals(data)) return true;
        for(Edge<E> e: v.getEdges())
            if(!escalera(e.getDestiny(),data,pasos,contador+1)) return false;
        return false;
    }
    
    
    
    
    
    
    
    
}
