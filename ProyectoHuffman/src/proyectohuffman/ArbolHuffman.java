/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Sandra Loayza
 */
public class ArbolHuffman {
    private Node raiz;
    
    public Node calcularArbol(HashMap<String,Integer> map){
        List<Node> lista = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String cadena = entry.getKey();
            int frec = entry.getValue();
            lista.add(new Node(new Info(cadena,frec)));            
        }
        
        PriorityQueue <Node> colaPr= new PriorityQueue<>((Node n1,Node n2)->n1.getInfo().getFrec()-n2.getInfo().getFrec());
        colaPr.addAll(lista);
        while(colaPr.size()> 1) {
            //saca 2 primeros nodos de la cola
            Node izq = colaPr.poll();
            Node der = colaPr.poll();
            //izq son 0 y der son 1
            izq.getInfo().setBit(0);
            der.getInfo().setBit(1);
            // cadena y frec del nodo padre de esos 2 nodos que saqué  
            String cadenacomb = izq.getInfo().getCadena()+der.getInfo().getCadena();
            int freqcomb = izq.getInfo().getFrec()+der.getInfo().getFrec();
            // nodo padre de esos 2 nodos que saqué              
            Node padre = new Node(new Info(cadenacomb, freqcomb));
            padre.setIzq(izq);
            padre.setDer(der);
            //System.out.println(padre+" // der:"+padre.getDer()+" // izp:"+padre.getIzq());
            colaPr.offer(padre);
        }
        
        raiz=colaPr.peek();
        return raiz;
    }
    
    public HashMap<String,String> calcularCodigos (){
        HashMap<String,String> mapa = new HashMap<>();
        //obtener cadena-frecuencia-bit de las hojas
        String cb = getCadenaBit(raiz).toString();
        String cadenaBit = cb.substring(1,cb.length()-1);
        String[] arr = cadenaBit.split(", ");
        ArrayList<String> lista = new ArrayList<>();
        for(int i=0;i<arr.length;i++) lista.add(arr[i]);
        lista.sort(String::compareTo);
        for(int i=0;i<arr.length;i++) mapa.put(arr[i].split("-")[0],arr[i].split("-")[1]);
        return mapa;
    }
    private ArrayList<String> getCadenaBit(Node nodo){
        ArrayList<String> arr = new ArrayList<>();
        if(nodo==null) return arr;
        else if(nodo.getDer()==null && nodo.getIzq()==null){
            String cadenaBit = nodo.getInfo().getCadena()+"-";
            arr.add(cadenaBit);
            return arr;
        }
        else{            
            //NODOS HOJA DERECHA
            String der = getCadenaBit(nodo.getDer(),nodo.getDer().getInfo().getBit()+"").toString();
            arr.add(der.substring(1,der.length()-1));
            //NODOS HOJA IZQUIERDA
            String izq = getCadenaBit(nodo.getIzq(),nodo.getIzq().getInfo().getBit()+"").toString();
            arr.add(izq.substring(1,izq.length()-1));
            return arr;
        }        
    }
    private ArrayList<String> getCadenaBit(Node nodo,String bit){
        ArrayList<String> arr = new ArrayList<>();
        if(nodo==null) return arr;
        else if(nodo.getDer()==null && nodo.getIzq()==null){
            String cadenaBit = nodo.getInfo().getCadena()+"-"+bit;
            arr.add(cadenaBit);
            return arr;
        }
        else{            
            //NODOS HOJA DERECHA
            String der = getCadenaBit(nodo.getDer(),bit+nodo.getDer().getInfo().getBit()).toString();
            arr.add(der.substring(1,der.length()-1));
            //NODOS HOJA IZQUIERDA
            String izq = getCadenaBit(nodo.getIzq(),bit+nodo.getIzq().getInfo().getBit()).toString();
            arr.add(izq.substring(1,izq.length()-1));            
            return arr;
        }        
    }
    
    public static String codificar(String texto, HashMap<String,String> mapa){
        String codigo = "";
        for(int i=0;i<texto.length();i++){            
            if(mapa.containsKey(texto.charAt(i)+"")){
                codigo+=mapa.get(texto.charAt(i)+"");
            }
        }
        return codigo;
    }
        
    public static String decodificar(String texto, HashMap<String,String> mapa){
        return decodificar(0,texto,mapa);
    }
    private static String decodificar(int inicio,String texto, HashMap<String,String> mapa){
        String original = "";
        if(inicio==0 && texto.length()==0) return original;
        else if(texto.length()==0) return original;
        else{
            for (HashMap.Entry<String,String> entry : mapa.entrySet()){
                int tamano = entry.getValue().length();
                if(tamano<=texto.length()){
                    if(entry.getValue().equals(texto.subSequence(inicio,tamano))){
                        original+=entry.getKey();
                        String texto2 = texto.substring(tamano,texto.length());
                        original+=decodificar(0,texto2,mapa);
                    }
                }
            }
            return original;
        }        
    }
    
    
}
