/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.Objects;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author CORE I7
 */
//implements Comparable<Auto>
public class Auto  {

    private StringProperty placa;
    public void setPlaca(String placa) {
        this.placa.set(placa);
    }
    public String getPlaca() {
        return this.placa.get();
    }

    private StringProperty marca;
    public void setMarca(String marca) {
        this.marca.set(marca);
    }
    public String getMarca() {
        return this.marca.get();
    }

    private StringProperty modelo;
    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }
    public String getModelo() {
        return this.modelo.get();
    }

    private DoubleProperty precio;
    public void setPrecio(double precio) {
        this.precio.set(precio);
    }
    public double getPrecio() {
        return this.precio.get();
    }

    private StringProperty anio;
    public void setAnio(String anio) {
        this.anio.set(anio);
    }
    public String getAnio() {
        return this.anio.get();
    }

    private StringProperty color;
    public void setColor(String color) {
        this.color.set(color);
    }
    public String getColor() {
        return this.color.get();
    }

    private DoubleProperty  ubicacionX;
    public void setUbicacionX(double ubicacionX) {
        this.ubicacionX.set(ubicacionX);
    }
    public double getUbicacionX() {
        return this.ubicacionX.get();
    }
    
    private DoubleProperty  ubicacionY;
    public void setUbicacionY(double ubicacionY) {
        this.ubicacionY.set(ubicacionY);
    }
    public double getUbicacionY() {
        return this.ubicacionY.get();
    }

    public Auto(String placa, String marca, String modelo, double precio, String anio, 
                String color, double ubicacionX, double ubicacionY) {
        this.placa = new SimpleStringProperty(placa);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.precio = new SimpleDoubleProperty(precio);
        this.anio = new SimpleStringProperty(anio);
        this.color = new SimpleStringProperty(color);
        this.ubicacionX = new SimpleDoubleProperty(ubicacionX);
        this.ubicacionY = new SimpleDoubleProperty(ubicacionY);
        
    }

    public Auto(String linea) {
        try {
            String[] valores = linea.split(";");
            this.placa = new SimpleStringProperty(valores[0]);
            this.marca = new SimpleStringProperty(valores[1]);
            this.modelo = new SimpleStringProperty(valores[2]);
            this.precio = new SimpleDoubleProperty(Double.parseDouble(valores[3]));
            this.anio = new SimpleStringProperty(valores[4]);
            this.color = new SimpleStringProperty(valores[5]);
            this.ubicacionX = new SimpleDoubleProperty(Double.parseDouble(valores[6]));
            this.ubicacionY = new SimpleDoubleProperty(Double.parseDouble(valores[7]));
            
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!!");
        }
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Auto comp = null;
        if (obj instanceof Auto) {
            comp = (Auto) obj;
            if (this.placa.get().equals(comp.placa.get())) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    @Override
    public String toString() {
        return  marca.get() + " " + modelo.get() ;
    }
    
    

}
