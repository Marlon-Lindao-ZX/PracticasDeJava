/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebatallas;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
public class UIPokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void crearPokemon(){
        Scanner sc = new Scanner(System.in);
        Pokemon p;
        String Nombre,compare;
        int ataque, defensa, nivel, especie;
        boolean vivo, control;
        control = vivo = true;
        System.out.print("Ingrese el nombre del pokemon :");
        Nombre = sc.nextLine();
        System.out.print("Ingrese el ataque del pokemon :");
        ataque = sc.nextInt();
        System.out.print("Ingrese la defensa del pokemon: ");
        defensa = sc.nextInt();
        System.out.print("Ingrese el nivel del pokemon: ");
        nivel = sc.nextInt();
        System.out.print("Ingrese la especie del pokemon: ");
        especie = sc.nextInt();
        System.out.println("Ingrese el estado actual del pokemon");
        System.out.print("Escriba vivo o muerto: ");
        do {
        compare = sc.nextLine();
        compare = compare.toLowerCase();
        switch(compare){
            case "vivo":
                control = false;
                break;
            case "muerto":
                vivo = false;
                control = false;
                break;
            default:
                System.out.print("Escriba vivo o muerto: ");
                break;
                    
        }
    }while(control);
        
    p = new Pokemon(Nombre, ataque, defensa, nivel, especie, vivo);    
    
    }
    
    public void crearEntrenador(){
        Scanner sc = new Scanner(System.in);
        Entrenador e;
        String Nombre, pueblo, compare;
        int edad;
        boolean eslider, control;
        control = eslider = true;
        System.out.print("Ingrese el nombre del entrenador : ");
        Nombre = sc.nextLine();
        System.out.println("Ingrese el pueblo natal: ");
        pueblo = sc.nextLine();
        System.out.println("Ingrese la edad del entrenador");
        edad = sc.nextInt();
        System.out.println("Ingrese si el entrenador es lider de ginmanio");
        System.out.print("Escriba si o no: ");
        do {
            compare = sc.nextLine();
            compare = compare.toLowerCase();
            switch (compare) {
                case "si":
                    control = false;
                    break;
                case "no":
                    eslider = false;
                    control = false;
                    break;
                default:
                    System.out.print("Escriba sí o no: ");
                    break;

            }
        } while (control);
        
        e = new Entrenador(Nombre, pueblo, edad, eslider); 
    }
    
    public List<Pokemon> consultarPokemon(String Nombre) {
        Pokebatallas pb = new Pokebatallas() ;
	List<Pokemon> result = new ArrayList<>();
	for(Pokemon p: pb.getPokemons() ){
		if(p.getNombre().equals(Nombre)){
			result.add(p);
			
		}
		
	}
	return result;
}
}
