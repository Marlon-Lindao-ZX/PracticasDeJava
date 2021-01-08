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
public class Proceso extends Thread{
    
	String mensaje;
	public Proceso(String msg)
	{
		super(msg);
	}
	
	public void run()
	{
		for(int i =0;i<15;i++)
		{
			System.out.println(mensaje);
		}
		System.out.println("Este proceso ha terminado:"+this.getName());
	}
	
	public void setMensaje(String msj)
	{
		this.mensaje = msj;
	}
        
            public static void main(String[] args) {
		// TODO Auto-generated method stub

		Proceso hilo1 = new Proceso("Hilo 1");
		Proceso hilo2 = new Proceso("Hilo 2");
		hilo1.setMensaje("Este es el mensaje del hilo 1");
		hilo2.setMensaje("Mensaje hilo 2");
		
		hilo1.start();
		hilo2.start();
	
	}
}
