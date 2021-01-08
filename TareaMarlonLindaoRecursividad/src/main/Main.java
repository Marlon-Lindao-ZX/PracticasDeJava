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
        int test;
        Random r = new Random();
        int [] data = new int[1 + r.nextInt(20)];
        for(int i = 0; i<data.length; i++){
            data[i] = 2 + r.nextInt(5);
            System.out.print(data[i] +"|");
        }
        System.out.println("\n"+"el arreglo tiene "+data.length+" elementos");
        
        
        System.out.print("Ingrese un numero entero positivo: ");
        while((test = Operaciones.verify(1))<0)
            System.out.print("Ingrese un numero entero positivo: ");
        System.out.println(Operaciones.multiplicar(test));
        
        System.out.print("Ingrese un numero entero positivo par: ");
        while((test = Operaciones.verify(2))<0)
            System.out.print("Ingrese un numero entero positivo par: ");
        System.out.println(Operaciones.sumarPar(test));  
        
        Operaciones.invertir(data);
        for(int x: data){
            System.out.print(x +"|");
        }
        
        System.out.println("\n"+"El resultado de la multiplicacion de los elementos del arreglo es: "+Operaciones.multArray(data));
        
        System.out.print("Ingrese un numero entero positivo: ");
        while((test = Operaciones.verify(1))<0)
            System.out.print("Ingrese un numero entero positivo: ");
        System.out.println(Operaciones.multDigit(test));

        
    }
    
}
