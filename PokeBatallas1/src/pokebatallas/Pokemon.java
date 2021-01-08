/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebatallas;

/**
 *
 * @author CORE I7
 */
public class Pokemon {
    private String Nombre;
    private int ataque;
    private int defensa;
    private int nivel;
    private String especie;
    private boolean vivo;
    
    public Pokemon(){
        
    }
    
    public Pokemon(Pokemon p){
        Nombre = p.Nombre;
        ataque = p.ataque;
        defensa = p.defensa;
        nivel = p.nivel;
        especie = p.especie;
        vivo = p.vivo;
        
    }

    public Pokemon(String Nombre, int ataque, int defensa, int nivel, String especie, boolean vivo) {
        this.Nombre = Nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.especie = especie;
        this.vivo = vivo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "Nombre= " + Nombre + "|| ataque= " + ataque + "|| defensa= " + defensa + "|| nivel= " + nivel + "|| especie= " + especie + "|| vivo= " + vivo;
    }
    
    
    
    
    
    
}
