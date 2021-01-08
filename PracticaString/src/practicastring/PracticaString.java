/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicastring;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class PracticaString {

    /**
     * @param args the command line arguments
     */

 
    
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese una palabra o una frase");
        String lectura = read.nextLine();
        String opcion = "";
        while (!opcion.equals("4")) {
            System.out.println("╔                Menu                   ╗");
            System.out.println("║ 1. Mostrar Cantidad de Vocales        ║");
            System.out.println("║ 2. Invertir vocales                   ║");
            System.out.println("║ 3. Repeticion caracteres              ║");
            System.out.println("║ 4. Salir de del Programa              ║");
            System.out.println("╚                                       ╝");
            System.out.print("Ingrese opcion: ");            
            opcion = read.nextLine();
            switch (opcion) {
                case "1":
                    int cantvoc;
                    cantvoc = getVocales(lectura);
                    System.out.println("la frase '"+lectura+"' tiene "+cantvoc+" vocales");
                    ;
                    break;
                case "2":                
                    System.out.println("la frase inversa de '"+lectura+"' es "+ inverse(lectura));
                    break;
                case "3":
                    int count;
                    String compare;
                    System.out.println("introduzca sequencia a comparar con la frase digitada");                                  
                    compare = read.next();
                    count = getcoincidences(lectura,compare);
                    System.out.println("La sequencia "+compare+" se repite "+count+" veces");
                    read.skip("\n");
                    break;
                case "4":
                    System.out.println("Bye Bye XD");
                    break;
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        read.close();
    }
    
    public PracticaString(){
        
    }
    
    public static int getVocales(String s){
        int result = 0;
        char comp;
        String copy;
        copy = s.toLowerCase();
        for (int i = 0; i<s.length();i++){
            comp = copy.charAt(i);
            if (comp == 'a' || comp == 'e' || comp == 'i' || comp == 'o' ||comp == 'u'){
                result++; 
            }
        }        
        return result;
    }
    
    public static String inverse(String s){
        String result = new String();
        for (int i = s.length() - 1; i>= 0; i--){
            result = result + s.charAt(i);
        }
        return result;
    }
    
    public static int getcoincidences(String d, String e){
        int count;
        count = 0;
        while (d.indexOf(e) > -1) {
            d = d.substring((d.indexOf(e) + e.length()), d.length());
            count++;
        }
        return count;
    }
    }
    

