/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyecto.Clases;

import java.util.HashMap;

/**
 *
 * @author chard
 */
public class MapaArbol {
    private final AVLTree tree;
    private final HashMap<NodeBT,Coordenada> mapa;
    private final int separacionV = 100;
    private final int separacionH = 100;
    
    public MapaArbol(AVLTree tree){
        this.tree = tree;
        this.mapa = new HashMap<>();
        posicionesDeNodos(tree);
    }
    
    public void posicionesDeNodos(AVLTree arbol){
        if(arbol.getRoot() != null){
            posicionesDeNodos(arbol.getRoot(),570,10);
        }
    }
    private void posicionesDeNodos(NodeBT n, int x, int y){
        if(n != null){
            if(mapa.containsValue(new Coordenada(x,y))){
                mapa.put(n, new Coordenada(x-separacionH-50,y));
            }
            else{
                mapa.put(n, new Coordenada(x,y));
            }
            if(n.getLeft() != null && n.getRight() != null){
                if(size(n.getLeft()) > size(n.getRight())){
                    posicionesDeNodos(n.getLeft(),x-40-separacionH,y+separacionV);
                    posicionesDeNodos(n.getRight(),x+20+separacionH,y+separacionV);
                }else if(size(n.getLeft()) < size(n.getRight())){
                    posicionesDeNodos(n.getLeft(),x-20-separacionH,y+separacionV);
                    posicionesDeNodos(n.getRight(),x+40+separacionH,y+separacionV);
                }else{
                    posicionesDeNodos(n.getLeft(),x-20-separacionH,y+separacionV);
                    posicionesDeNodos(n.getRight(),x+20+separacionH,y+separacionV);
                }
                
                
            }           
            if(n.getLeft()!= null && n.getRight() == null){     
                posicionesDeNodos(n.getLeft(),x-separacionH,y+separacionV);
            }            
            if(n.getLeft()== null && n.getRight() != null){               
                posicionesDeNodos(n.getRight(),x+separacionH,y+separacionV);
            }
    
        }
    }
    public HashMap<NodeBT,Coordenada> getMapa(){
        return mapa;
    }
    private int size(NodeBT p){
        if(p==null){
            return 0;
        }
        return 1 + size(p.getLeft())+size(p.getRight()); 
                
    }
}
