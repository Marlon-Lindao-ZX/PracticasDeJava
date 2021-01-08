/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author Veronica
 */
public class Encadenamiento2 implements Runnable{
    String nombre;
Encadenamiento2(String nom)
{nombre= nom;}
public void run()
{ for (int i=0;i<10;i++)
{System.out.println(nombre);
}
}
public static void main(String args[])
{Encadenamiento2 proceso1=new Encadenamiento2("proceso 1");
Encadenamiento2 proceso2=new Encadenamiento2("proceso 2"); 
Thread p1= new Thread(proceso1);
Thread p2= new Thread(proceso2); 
p1.start(); 
p2.start(); 
}
}
