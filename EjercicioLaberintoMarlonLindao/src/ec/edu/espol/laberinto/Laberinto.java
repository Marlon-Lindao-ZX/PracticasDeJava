/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.laberinto;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author CORE I7
 */
public class Laberinto {
    
    private Laberinto(){};
    
    public static LinkedList<Casilla> encontrarCamino(int matriz[][], int x, int y){
        Deque<Casilla> test = new LinkedList<>();
        LinkedList<Casilla> camino = new LinkedList<>();
        Casilla tmp;
        
        if(matriz.length == 0 && matriz[0].length == 0){
            System.out.println("Lista vacia\nRetornando lista de camino vacia");
            return camino;
        }
        
        if(!isSafe(matriz,x,y)){
            System.out.println("Coordenadas incorrectas\nRetornando lista de camino vacia");
            return camino;
        }
        
        if(matriz[x][y] == 1) {
            System.out.println("Esta tratando de iniciar en la pared del laberinto\nRetornando lista de camino vacia");
            return camino;
        }
        
        tmp = new Casilla(x,y);
        
        test.push(tmp);
        matriz[tmp.getX()][tmp.getY()] = 1;
        
        do{
            if((tmp = next(matriz,tmp.getX(),tmp.getY()))!= null){
                test.push(tmp);
                if(matriz[tmp.getX()][tmp.getY()] == 2){
                    camino = copy(test);
                    return camino;
                }
                matriz[tmp.getX()][tmp.getY()] = 1;
            }
       
            if(tmp == null){
                Casilla tmp1;
                tmp = test.pop();
                if((tmp1 = next(matriz,tmp.getX(),tmp.getY()))!=null)
                    test.push(tmp);
            }
            
            
        }while(!test.isEmpty());
        
        return camino;
    }
    
    private static boolean isSafe(int matriz[][], int x, int y){
        return isSafeX(matriz,x) && isSafeY(matriz,y);
    }
    
    private static boolean isSafeX(int matriz[][], int x){
        return x >= 0 && x < matriz.length;
    }
    
    private static boolean isSafeY(int matriz[][], int y){
        return y >= 0 && y < matriz[0].length;
    }
    
    private static Casilla next(int matriz[][], int x, int y){
        int up = giveCoordinate(matriz,y-1,2);
        int down = giveCoordinate(matriz,y+1,2);
        int left = giveCoordinate(matriz,x-1,1);
        int right = giveCoordinate(matriz,x+1,1);
        
        if(up >= 0){
            if(matriz[x][up]==0 || matriz[x][up]==2) return new Casilla(x,up);
        }
        
        if(down >= 0){
            if(matriz[x][down]==0 || matriz[x][down]==2) return new Casilla(x,down);
        }
        
        if(left >= 0){
            if(matriz[left][y]==0 || matriz[left][y]==2) return new Casilla(left,y);
        }
        
        if(right >= 0){
            if(matriz[right][y]==0 || matriz[right][y]==2) return new Casilla(right,y);
        }
        
        return null;
            
    }
    
    private static int giveCoordinate(int matriz[][], int value, int option){
        switch(option){
            case 1:
                if(isSafeX(matriz,value)) return value;
                break;
            case 2:
                if(isSafeY(matriz,value)) return value;
                break;
            default:
                break;                
        }
        return -1;
    }
    
    private static LinkedList<Casilla> copy(Deque<Casilla> temp){
        LinkedList<Casilla> retorno = new LinkedList<>();
        while(!temp.isEmpty())
            retorno.addFirst(temp.pop());
        return retorno;
    }
    
    
}
