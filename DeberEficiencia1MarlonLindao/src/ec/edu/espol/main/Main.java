/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.arboles.SBT;
import ec.edu.espol.datos.Registro;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        
        File file = new File("arbol.bin");
        SBT<Registro> arbolCarrera;
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ioe){}
            arbolCarrera = Registro.readFile("manhattan_inc.csv");
        } else{
            arbolCarrera = Registro.readTree(file);
        }
        
        
        Scanner sc = new Scanner(System.in);
        int r = -1;
        
        while(r<0){
            try{
                System.out.print("Ingrese un id de carrera: ");
                r = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Id invalido");
                r=-1;
                sc.nextLine();
            }
            
        }
        
        long tiempoInicio = System.currentTimeMillis();
        Registro temp = Registro.get(arbolCarrera, r);
        long tiempoFin = System.currentTimeMillis();
        
        long result = tiempoFin - tiempoInicio;
        System.out.println(result);
        
        if(temp == null)
            System.out.println("ID de carrera ingresado no se encuentra en el DataBase");
        else
            System.out.println(temp);
        
        Registro.saveTree(arbolCarrera, file);
        
        
    }
    
}
