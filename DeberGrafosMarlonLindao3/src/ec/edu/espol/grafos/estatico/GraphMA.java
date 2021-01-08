/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.grafos.estatico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class GraphMA<E> {
    
    private ArrayList<E> vertexes;
    private int [][] matrix;
    private boolean directed;
    private int capacity = 10;
    
    public GraphMA(boolean directed){
        vertexes = new ArrayList<>();
        matrix = new int[capacity][capacity];
        this.directed = directed;
    }
    
    public boolean isEmpty(){
        return vertexes.isEmpty();
    }
    
    public boolean addVertex(E data){
        if(data == null || vertexes.contains(data)) return false;
        //verify capacity
        if(vertexes.size()==capacity){
            capacity = (capacity + (capacity/2));
            int tmp[][] = new int[capacity][capacity];
            System.arraycopy(tmp, 0, matrix, 0, capacity);
        }
        return vertexes.add(data);
    }
    
    public boolean addEdge(E origen,E destino,int peso){
        int origin = vertexes.indexOf(origen);
        int destiny = vertexes.indexOf(destino);
        
        if(origin != -1 && destiny != -1 && peso != 0){
            matrix[origin][destiny] = peso;
            if(!directed) matrix[destiny][origin] = peso;
            return true;
        }
        return false;
    }
    
    public boolean removeVertex(E data){
        int index = vertexes.indexOf(data);
        if(index == -1) return false;
        for (int j = index; j < vertexes.size(); j++) {
            matrix[j] = matrix[j + 1];
            for (int i = 0; i < vertexes.size(); i++) {
                matrix[i][j] = matrix[i][j + 1];
            }
        }
        vertexes.remove(index);
        return true;
    }
    
    public boolean removeEdge(E origen,E destino){
        int origin = vertexes.indexOf(origen);
        int destiny = vertexes.indexOf(destino);
        if(origin != -1 && destiny != -1){
            if(matrix[origin][destiny] == 0) return false;
            matrix[origin][destiny]=0;
            return true;
        }
        return false;
    }
    
    public int inDegree(E data){
        int origin = vertexes.indexOf(data);
        int sum = 0;
        if(origin != -1){
            for(int i= 0;i<vertexes.size();i++){
                if(matrix[i][origin]!=0)
                    sum++;
            }
        }
        return sum;
    }
    
    public int outDegree(E data){
        int origin = vertexes.indexOf(data);
        int sum = 0;
        if(origin != -1){
            for(int i= 0;i<vertexes.size();i++){
                if(matrix[origin][i]!=0)
                    sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "V="+vertexes.toString()+"\n";
        result+="A=";
        ArrayList<String> temp = new ArrayList();
        for(int i=0;i<vertexes.size();i++)
            for(int j = 0;j<vertexes.size();j++)
                if(matrix[i][j]!=0) temp.add("("+vertexes.get(i)+","+vertexes.get(j)+")");
        result+=temp.toString();
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj == null || !(obj instanceof GraphMA)) return false;
        GraphMA<E> other = (GraphMA<E>) obj;
        if(this.vertexes.size() != other.vertexes.size()) return false;
        HashSet<E> temp = new HashSet<>();
        temp.addAll(this.vertexes);
        temp.retainAll(other.vertexes);
        if(temp.size()!=this.vertexes.size()) return false;
        for(int i=0;i<this.vertexes.size();i++)
            for(int j = 0;j<this.vertexes.size();j++)
                if(this.matrix[i][j] != other.matrix[i][j]) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.vertexes);
        hash = 89 * hash + Arrays.deepHashCode(this.matrix);
        hash = 89 * hash + (this.directed ? 1 : 0);
        hash = 89 * hash + this.capacity;
        return hash;
    }
    
    
    
    
    
}
