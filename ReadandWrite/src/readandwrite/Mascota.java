/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readandwrite;

import java.io.Serializable;

/**
 *
 * @author CORE I7
 */
public class Mascota implements Serializable{
    public String nombre;
    public int numeropatas;
    
    public Mascota(){
        nombre = "Aslan";
        numeropatas = 4;
    }

    public Mascota(String nombre, int numeropatas) {
        this.nombre = nombre;
        this.numeropatas = numeropatas;
    }
    
    
}
