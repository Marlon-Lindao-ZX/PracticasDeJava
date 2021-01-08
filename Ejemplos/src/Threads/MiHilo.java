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
public class MiHilo implements Runnable{
     public void run() {
        // Presenta en pantalla información sobre este hilo en particular
        System.out.println( Thread.currentThread() );
        }
}
