/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.arboles;

import java.util.HashMap;

/**
 *
 * @author CORE I7
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BT<String> arbolB = new BT<>();
        arbolB.add("FRA0", null);
        arbolB.add("FRA1", "FRA0");
        arbolB.add("CRO1", "FRA0");
        arbolB.add("FRA2", "FRA1");
        arbolB.add("BEL2", "FRA1");
        arbolB.add("CRO2", "CRO1");
        arbolB.add("ING2", "CRO1");
        arbolB.add("FRA3", "FRA2");
        arbolB.add("URU3", "FRA2");
        arbolB.add("BEL3", "BEL2");
        arbolB.add("BRA3", "BEL2");
        arbolB.add("CRO3", "CRO2");
        arbolB.add("RUS3", "CRO2");
        arbolB.add("ING3", "ING2");
        arbolB.add("SUE3", "ING2");
        arbolB.add("FRA4", "FRA3");
        arbolB.add("ARG4", "FRA3");
        arbolB.add("URU4", "URU3");
        arbolB.add("POR4", "URU3");
        arbolB.add("BEL4", "BEL3");
        arbolB.add("JAP4", "BEL3");
        arbolB.add("BRA4", "BRA3");
        arbolB.add("MEX4", "BRA3");
        arbolB.add("CRO4", "CRO3");
        arbolB.add("DIN4", "CRO3");
        arbolB.add("RUS4", "RUS3");
        arbolB.add("ESP4", "RUS3");
        arbolB.add("ING4", "ING3");
        arbolB.add("COL4", "ING3");
        arbolB.add("SUE4", "SUE3");
        arbolB.add("SUI4", "SUE3");
        
        HashMap<String,Integer> fases = new HashMap<>();
        fases.put("campeon", 0);
        fases.put("semifinal", 1);
        fases.put("cuartos", 2);
        fases.put("octavos", 3);
        
        System.out.println(arbolB.equiposEliminados("CRO"));
        
        BT<Integer> arbolB2 = new BT<>();
        arbolB2.add(1, null);
        arbolB2.add(2, 1);
        arbolB2.add(3, 1);
        arbolB2.add(4, 2);
        arbolB2.add(5, 2);
        arbolB2.add(6, 3);
        arbolB2.add(7, 3);
        arbolB2.enOrden();
        System.out.println("");
        
        
        BT<Integer> mirror = arbolB2.mirror();
        mirror.enOrden();
        System.out.println("");
        arbolB2.enOrden();
        System.out.println("");
        System.out.println(arbolB2.equals(mirror));
        
        SBT<Integer> sArbol = new SBT<>(Integer::compare);
        sArbol.add(45);
        sArbol.add(30);
        sArbol.add(55);
        sArbol.add(65);
        sArbol.add(40);
        sArbol.enOrden();
        System.out.println("");
        System.out.println(sArbol.contains(40));
        System.out.println(sArbol.contains(65));
        System.out.println(sArbol.contains(62));
        System.out.println(sArbol.contains(39));
        System.out.println(sArbol.contains(29));
        System.out.println(sArbol.contains(55));
        
    }
    
}
