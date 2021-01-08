/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

/**
 *
 * @author Sandra Loayza
 */
public class Info {
    private String cadena;
    private int frec;
    private int bit;
    public Info(String cadena,int frec){
        this.cadena = cadena;
        this.frec = frec;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getFrec() {
        return frec;
    }

    public void setFrec(int frec) {
        this.frec = frec;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    @Override
    public String toString() {
        return "Info{" + "cadena=" + cadena + ", frec=" + frec + ", bit=" + bit + '}';
    }
    
    
}
