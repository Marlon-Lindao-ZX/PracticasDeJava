/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

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
        Random r = new Random();
        int [] data = new int[r.nextInt(1000)];
        for(int i=0; i<data.length;i++)
            data[i]=r.nextInt(10000);
        System.out.println("la dimension del arreglo es: " +data.length
        +" y la suma de sus elementos es: "+sumArray(data));
    }
    
    public static int sumArray(int [] array){
        if(array.length == 1)
            return array[0];
        return sumArray(array,0,array.length - 1);
    }
    
    private static int sumArray(int [] array,int low, int high){
        if(low > high)
            return 0;
        else if(low == high)
            return array[low] + sumArray(array,++low,--high);
        return array[low] + array[high] + sumArray(array,++low,--high);
    }
    
}
