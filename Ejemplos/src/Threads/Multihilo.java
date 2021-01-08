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
public class Multihilo {
     static public void main( String args[] ) {
        // Se instancian dos nuevos objetos Thread
        Thread hiloA = new Thread( new MiHilo(),"hiloA" );
        Thread hiloB = new Thread( new MiHilo(),"hiloB" );

        // Se arrancan los dos hilos, para que comiencen su ejecución
        hiloA.start();
        hiloB.start();
    
        // Aquí se retrasa la ejecución un segundo y se captura la
        // posible excepción que genera el método, aunque no se hace
        // nada en el caso de que se produzca
        try {
            Thread.currentThread().sleep( 1000 );
        }catch( InterruptedException e ){}

        // Presenta información acerca del Thread o hilo principal 
        // del programa
        System.out.println( Thread.currentThread() );        

        // Se detiene la ejecución de los dos hilos
        hiloA.stop();
        hiloB.stop();
        }
}
