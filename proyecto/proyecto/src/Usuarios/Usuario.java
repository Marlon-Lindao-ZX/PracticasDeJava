/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.Scanner;


/**
 *Clase padre de Cliente y planificador, y que ademas tiene todos los atributos requeridos para la identificacion del usuario
 * @author CORE I7
 */
public class Usuario {
    
    
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String clave;
    protected char perfil;
    
    
    
    /***
     * Constructor vacio de la clase Usuario
     */
    public Usuario(){
        nombre = "Adm";
        apellido = "Str";
        usuario = "Default";
        clave = "A00000000";
        perfil = 'A';
        
    }
    
    /***
     * Constructor copia de la clase Usuario
     * @param u Usuario al cual sus atributos seran copiados a otro objeto tipo Usuario
     */
    public Usuario(Usuario u){
        nombre = u.nombre;
        apellido = u.apellido;
        usuario = u.usuario;
        clave = u.clave;
        perfil = u.perfil;
        
        
    }
    
    /***
     * constructor que recibe una linea extraida del archivo y usuarios.txt y que contiene los atributos del objeto tipo Usuario
     * a instanciar
     * @param linea Este string contiene los atributos de un objeto tipo Usuario
     */
    public Usuario(String linea){
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        nombre = delimitar.next();
        apellido = delimitar.next();
        usuario = delimitar.next();
        clave = delimitar.next();
        perfil = delimitar.next().charAt(0);

    }

    /***
     * Constructor con parametros de la clase Usuario
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param usuario usuario
     * @param clave clave  del usuario
     * @param perfil perfil del usuario
     */
    public Usuario(String nombre, String apellido, String usuario, String clave, char perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.perfil = perfil;
       
    }
    
    /***
     * regresa en un string los atributos del objeto tipo Usuario que es usado para guardarlo en el archivo usuarios.txt
     * @return Un string que contiene los atributos de un objeto tipo Usuario
     */
    public String pasarLinea(){
        return this.nombre + "," + this.apellido + "," + this.usuario + "," + this.clave +"," + this.perfil; 
        
    }
    
    
    /***
     * Metodo que retorna el atributo nombre
     * @return Un string que contiene el nombre del Usuario 
     */

    public String getNombre() {
        return nombre;
    }
    
    /***
     * Setea el atributo nombre
     * @param nombre String que va a reemplazar el valor actual del atributo nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /***
     * Obtiene el atributo apellido
     * @return Un string que contiene el apellido del Usuario 
     */

    public String getApellido() {
        return apellido;
    }
    
    /***
     * Setea del atributo apellido
     * @param apellido String que va a reemplazar el valor actual del atributo apellido
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /***
     * Obtiene el atributo usuario
     * @return Un string que contiene el user del Usuario 
     */

    public String getUsuario() {
        return usuario;
    }
    
    /***
     * Setea el atributo usuario
     * @param usuario String que va a reemplazar el valor actual del atributo usuario
     */

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /***
     * get del atributo clave
     * @return Un string que contiene la contraseña del Usuario 
     */

    public String getClave() {
        return clave;
    }
    
    /***
     * set del atributo clave
     * @param clave String que va a reemplazar el valor actual del atributo clave
     */

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /***
     * Obtiene el atributo perfil 
     * @return Un caracter que contiene el perfil del Usuario 
     */

    public char getPerfil() {
        return perfil;
    }
    
    /***
     * Setea el atributo perfil
     * @param perfil Caracter que sea A,P o C que va a reemplazar el valor actual del atributo perfil
     */

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }
    
    
    
}
