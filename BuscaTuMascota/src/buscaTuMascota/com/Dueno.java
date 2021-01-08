/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaTuMascota.com;

/**
 *
 * @author suNombreAqui
 */
public class Dueno {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String cedula;
    private long tarjetacredito;
    
    public Dueno(String nombre, String ciudad, String direccion, String cedula, long tarjetacredito) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cedula = cedula;
        this.tarjetacredito = tarjetacredito;
    }
    

    public Dueno(String nombre, String ciudad, String direccion, String cedula) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cedula = cedula;
        
   
   
}
    
    public String getnombre(){
        return nombre;
    }
    public String getciudad(){
        return ciudad;
    }
    public String getdireccion(){
        return direccion;
    }
    public String getcedula(){
        return cedula;
    }
    public long gettarjetacredito(){
        return tarjetacredito;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public void setciudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setdireccion(String direccion){
        this.direccion = direccion;
    }
    public void setcedula(String cedula){
        this.cedula = cedula;
    }
    public void settarjetacredito(long tarjetacredito){
        this.tarjetacredito = tarjetacredito;
    }
}



