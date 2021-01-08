/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

/**
 *
 * @author Estudiante
 */
public class Auto{
    private String placa;
    private String marca;
    private String modelo;
    private String precio;
    private String anio;
    private String color;

    public Auto(String placa, String marca, String modelo, String precio, String anio, String color) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.anio = anio;
        this.color = color;
    }

    public Auto(String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return marca +" "+ modelo;

    }
}
