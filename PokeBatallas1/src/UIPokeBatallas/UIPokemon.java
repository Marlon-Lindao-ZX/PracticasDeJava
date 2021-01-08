/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPokeBatallas;

import java.util.Scanner;
import pokebatallas.Entrenador;
import pokebatallas.Pokebatallas;
import pokebatallas.Pokemon;

/**
 *
 * @author CORE I7
 */
public class UIPokemon {
    
    
    Scanner sc = new Scanner(System.in);
    Pokebatallas pb = new Pokebatallas();
    
    public UIPokemon(){
        
    }

    public void crearPokemon() {

        Pokemon p;
        String Nombre, especie, compare;
        int ataque, defensa, nivel;
        boolean vivo, control;
        control = vivo = true;
        System.out.print("Ingrese el nombre del pokemon: ");
        Nombre = sc.nextLine();
        
        System.out.print("Ingrese el ataque del pokemon: ");
        ataque = sc.nextInt();
        System.out.print("Ingrese la defensa del pokemon: ");
        defensa = sc.nextInt();
        System.out.print("Ingrese el nivel del pokemon: ");
        nivel = sc.nextInt();
        sc.skip("\n");
        System.out.print("Ingrese la especie del pokemon: ");
        especie = sc.nextLine();
        System.out.println("Ingrese el estado actual del pokemon");
        System.out.print("Escriba vivo o muerto: ");
//        sc.skip("\n");
        do {
            compare = sc.nextLine();
            compare = compare.toLowerCase();
            switch (compare) {
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
        } while (control);

        p = new Pokemon(Nombre, ataque, defensa, nivel, especie, vivo);
        pb.addPokemon(p);

    }

    public void crearEntrenador() {

        Entrenador e;
        String Nombre, pueblo, compare;
        int edad;
        boolean eslider, control;
        control = eslider = true;
        System.out.print("Ingrese el nombre del entrenador: ");
        Nombre = sc.nextLine();
        System.out.print("Ingrese el pueblo natal: ");
        pueblo = sc.nextLine();
        System.out.print("Ingrese la edad del entrenador: ");
        edad = sc.nextInt();
        System.out.println("Ingrese si el entrenador es lider de ginmanio");
        System.out.print("Escriba si o no: ");
        sc.skip("\n");
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

    public void consultarPokemon(String Name) {
//        ArrayList<Pokemon> result = new ArrayList<>();
        Pokebatallas result = new Pokebatallas();
        for (Pokemon p : pb.getListaPokemons()) {
            if (p.getNombre().equals(Name)) {
                result.addPokemon(p);

            }

        }
        result.readlistPokemon();
    }

}
