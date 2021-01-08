/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *Clase que hereda de Usuario
 * @author CORE I7
 */
public class Planificador extends Usuario{
    
    /***
     * constructor vacio de Planificador
     */
    public Planificador() {
    }

    /***
     * constructor con parametros de Planificador y que llama al constructor con parametros de la clase padre
     * @param nombre Nombre del Planificador
     * @param apellido Apellido del Planificador
     * @param usuario User del Planificador
     * @param contraseña Contraseña del Planificador
     * @param perfil Perfil del Planificador
     */
    public Planificador(String nombre, String apellido, String usuario, String contraseña, char perfil) {
        super(nombre, apellido, usuario, contraseña, perfil);
        
    }

    /***
     * constructor de Planificador que llama al constructor copia de la clase Padre
     * @param u Usuario que se envia como parametro para que el objeto tipo Planificador copie sus atributos 
     */
    public Planificador(Usuario u) {
        super(u);
    }
    
    /***
     * constructor que recibe una linea extraida del archivo usuarios.txt y que contiene los atributos del usuario
     * y llama al constructor respectivo de la clase padre
     * @param linea Un string que contiene los valores de los atributos de esta clase Planificador
     */
    public Planificador(String linea){
        super(linea);
    }
}
