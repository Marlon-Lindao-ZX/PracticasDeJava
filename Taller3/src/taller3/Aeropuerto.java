/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;
import java.util.Scanner;
/**
 *
 * @author CORE I7
 */
public class Aeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner read = new Scanner(System.in);
        boolean control;
        control = true;
        String Modelo, Marca, Color;
        int Año;
        System.out.println("Ingrese el modelo del avion");
        Modelo = read.nextLine();
        System.out.println("Ingrese la marca del avion");
        Marca = read.nextLine();
        System.out.println("Ingrese el año del avion");
        Año = read.nextInt();
        System.out.println("Ingrese el color del avion: ");
        Color = read.next();
        Avion plane;
        plane = new Avion(Modelo, Marca, Año, Color);
        
        do{
            String opcion;
            System.out.println("Menu");
            System.out.println("1. Año");
            System.out.println("2. Empresa");
            System.out.println("3. Kilometraje");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion; ");
            opcion = read.nextLine();
            
            switch(opcion){
                case "1":
                    int añoactual;
                    System.out.print("Ingrese el año actual :");
                    añoactual = read.nextInt();
                    plane.mostrarAvion(añoactual);
                    read.skip("\n");
                    break;
                case "2":
                    String nombreempresa, nombrepiloto;
                    System.out.print("Ingrese el nombre de la empresa :");
                    nombreempresa = read.nextLine();
                    System.out.print("Ingrese el nombre del piloto :");
                    nombrepiloto = read.nextLine();
                    plane.mostrarAvion(nombreempresa, nombrepiloto);
                    break;
                case "3":
                    double kilometraje;
                    System.out.print("Ingrese el kilometraje del avion: ");
                    kilometraje = read.nextDouble();
                    plane.mostrarAvion(kilometraje);
                    read.skip("\n");
                    break;
                case "4":
                    System.out.println("Bye Bye XD");
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;   
            }          
        }while(control); 
        
        
        
        
    }
    
}
