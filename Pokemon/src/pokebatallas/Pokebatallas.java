/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebatallas;

import java.util.ArrayList;

/**
 *
 * @author CORE I7
 */
public class Pokebatallas {
    private ArrayList<Entrenador> Entrenadores = new ArrayList<>();
    private ArrayList<Pokemon> Pokemons = new ArrayList<>();

    public Pokebatallas() {
    }
    
    
    public void addEntrenador(Entrenador e){
        Entrenadores.add(e);
        
    }
    
    public void addPokemon(Pokemon p){
        Pokemons.add(p);
    }
    
    public void readlistEntrenadores(){
        for(Entrenador e: Entrenadores){
            e.toString();
        }
    }
    
    public void readlistPokemon(){
        for (Pokemon p: Pokemons){
            p.toString();
        }
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return Entrenadores;
    }

    public ArrayList<Pokemon> getPokemons() {
        return Pokemons;
    }
}
