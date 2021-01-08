/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class Operaciones {
    
    private Operaciones(){}
    
    public static long multiplicar(int num){
        if (num <= 1)
            return 1;
        return num*multiplicar(--num);
    }
    
    public static int sumarPar(int num){
        if (num <= 2)
            return 2;
        return num + sumarPar((num-2));
    }
    
    public static void invertir(int [] array){
        if(array.length > 1)
            invertir(array,0,array.length - 1);
    }
    
    private static void invertir(int [] array,int low,int high){
        int temp;
        if(low <= high){
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            invertir(array,++low,--high);
        }
    }
    
    public static int multArray(int [] array){
        if(array.length == 1)
            return array[0];
        return multArray(array,0,array.length - 1);
    }
    
    private static int multArray(int [] array,int low, int high){
        if(low > high)
            return 1;
        else if(low == high)
            return array[low] * multArray(array,++low,--high);
        return array[low] * array[high] * multArray(array,++low,--high);
    }
    
    public static int multDigit(int num){
        if((num/10) == 0)
            return num%10;
        return (num%10) * multDigit(num/10);
    }    
    
    public static int verify(int option){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        int num;
        try {
            num = sc.nextInt();
            if ((num < 0) || ((option == 2) && ((num % 2) != 0)))
                return -1;
            return num;
        } catch (InputMismatchException e){
            return -1;
        }
    }
    
}
