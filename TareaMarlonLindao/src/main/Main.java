package main;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CORE I7
 */
public class Main {
    
    public static int contador = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] data = new int[1000];
        for(int i=0; i<data.length;i++)
            data[i]=i;
        Random r = new Random();
        int target = r.nextInt(1001);
        if(!binarySearch(data,target,0,data.length-1))
            System.out.println("el numero "+ target +" no fue encontrado");
    }
    
    public static boolean binarySearch(int [] data, int target, int low, int high){
        contador++;
        if(low > high)
            return false;
        else {
            int mid = (low + high)/2;
            if(target == data[mid]){
                System.out.println("el numero "+ target +" fue encontrado en la "+ contador +" iteracion");
                return true;
            } else if(target < data[mid])
                return  binarySearch(data,target,low,mid - 1);
            else
                return  binarySearch(data,target,mid + 1,high);
        }
    }
    
}
