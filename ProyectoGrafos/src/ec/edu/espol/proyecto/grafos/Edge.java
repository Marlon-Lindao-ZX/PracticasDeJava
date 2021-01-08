/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.grafos;

import java.util.Objects;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class Edge<E>{
    private int peso;
    private Vertex<E> origin;
    private Vertex<E> destiny;
    private String movie;

    public Edge(Vertex<E> origin,Vertex<E> destiny,int peso) {
        this.peso = peso;
        this.origin = origin;
        this.destiny = destiny;
    }
    
    public Edge(Vertex<E> origin,Vertex<E> destiny,int peso,String movie) {
        this.peso = peso;
        this.origin = origin;
        this.destiny = destiny;
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge<E> other = (Edge<E>) obj;
        if ((!this.getOrigin().getData().equals(other.getOrigin().getData()))||(!this.getDestiny().getData().equals(other.getDestiny().getData()))) {
            return false;
        }
        return true;
    }
    
    

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertex<E> getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex<E> origin) {
        this.origin = origin;
    }

    public Vertex<E> getDestiny() {
        return destiny;
    }

    public void setDestiny(Vertex<E> destiny) {
        this.destiny = destiny;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
    
    
    
    
}
