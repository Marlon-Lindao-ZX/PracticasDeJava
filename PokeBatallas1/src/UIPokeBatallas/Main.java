/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPokeBatallas;

import java.util.Scanner;


/**
 *
 * @author Actualice grupo
 */
public class Main {
     static Scanner sc = new Scanner(System.in);
     
     static UIPokemon pok = new UIPokemon();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }
    /**
     * Muestra el menu por consola.
     */
    public static void menu(){
        String opcion="";
        while(!opcion.equals("4")){
              System.out.println("╔                Menu                       ╗");
              System.out.println("║ 1. Registro de Pokemons                   ║");
              System.out.println("║ 2. Registro de Entrenador                 ║");
              System.out.println("║ 3. Consulta de Pokemons                   ║");                        
              System.out.println("║ 4. Salir                                  ║");        
              System.out.println("╚                                           ╝");
              System.out.print("Ingrese opcion: ");      
              opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    pok.crearPokemon();
                    break;
                case "2":
                    pok.crearEntrenador();
                    break;
                case "3": 
                    String nombre;
                    System.out.print("Ingrese el nombre del pokemon: ");
                    nombre = sc.nextLine();
                    pok.consultarPokemon(nombre);
                    break;
                case "4":    
                    System.out.println("Gracias por tu visita!");
                    break;
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }
    
   
}
