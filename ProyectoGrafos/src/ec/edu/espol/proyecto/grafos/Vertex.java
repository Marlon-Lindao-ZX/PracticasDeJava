/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class Vertex<E> {
    private E data;
    private List<Edge<E>> edges;
    private boolean visited;
    private int distance;
    private Vertex<E> antecesor;
    private String bestMovie;
    private int connection;
    
    
    public Vertex(E data){
        this.data = data;
        edges = new LinkedList<>();
        visited = false;
        distance = Integer.MAX_VALUE;
        antecesor = null;
        connection = 0;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.data);
        hash = 47 * hash + Objects.hashCode(this.edges);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Vertex<E> other = (Vertex<E>) obj;
        if (!this.data.equals(other.data)) {
            return false;
        }
        return true;
    }
    

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public List<Edge<E>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<E>> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<E> getAntecesor() {
        return antecesor;
    }

    public void setAntecesor(Vertex<E> antecesor) {
        this.antecesor = antecesor;
    }

    public String getBestMovie() {
        return bestMovie;
    }

    public void setBestMovie(String bestMovie) {
        this.bestMovie = bestMovie;
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + '}';
    }

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }


    

    
    
    
}
