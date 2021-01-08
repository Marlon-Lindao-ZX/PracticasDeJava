/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CORE I7
 */
@XmlRootElement
public class Auto implements Serializable{
    
    private String marca;
    private String color;
    private String anio;
    private String modelo;
    private String tipo;

    public Auto(String marca, String color, String anio, String modelo, String tipo) {
        this.marca = marca;
        this.color = color;
        this.anio = anio;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Auto{" + "marca=" + marca + ", color=" + color + ", anio=" + anio + ", modelo=" + modelo + ", tipo=" + tipo + '}';
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
