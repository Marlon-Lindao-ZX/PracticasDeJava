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
public class Entrenador {
    private String Nombre;
    private String pueblo;
    private int edad;
    private boolean eslider;
    
    public Entrenador(){
        
    }
    public Entrenador(Entrenador e){
        Nombre = e.Nombre;
        pueblo = e.pueblo;
        edad = e.edad;
        eslider = e.eslider;
        
    }

    public Entrenador(String Nombre, String pueblo, int edad, boolean eslider) {
        this.Nombre = Nombre;
        this.pueblo = pueblo;
        this.edad = edad;
        this.eslider = eslider;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean islider() {
        return eslider;
    }

    public void setEslider(boolean eslider) {
        this.eslider = eslider;
    }

    @Override
    public String toString() {
        return "Nombre= " + Nombre + "|| pueblo=" + pueblo + "|| edad=" + edad + "|| eslider=" + eslider;
    }
    
    
    
    
}
