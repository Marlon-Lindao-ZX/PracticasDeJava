/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import Agenda.UIAgenda;
import Archivos.ManejoDeArchivos;
import Elementos.UIElemento;
import Eventos.UIEventos;
import Transacciones.UIPago;
import java.util.Scanner;
import Usuarios.*;
import java.lang.System;
/**
 *En esta clase se encuentran algunos metodos que son usados en el main
 * @author CORE I7
 */
public class UISistema {

    private UIUsuario lu = new UIUsuario();
    private ManejoDeArchivos ma = new ManejoDeArchivos();
    private String user;
    private static Scanner sc = new Scanner(System.in);

    /***
     * constructor vacio
     */
    public UISistema() {

    }
    
    /***
     * metodo que sirve para inicializar todas las listas al momento de la ejecucion del programa
     */
    public void cargaArchivos(){
        UIElemento.cargarAnimadores(ma.leerArchivo(ManejoDeArchivos.getFILE6()));
        UIUsuario.cargarListaUsuario(ma.leerArchivo(ManejoDeArchivos.getFILE1()));
        UIEventos.cargaEventos(ma.leerArchivo(ManejoDeArchivos.getFILE2()));
        UIElemento.cargarElementos(ma.leerArchivo(ManejoDeArchivos.getFILE3()));
        UIEventos.asignacionElementosAEventos(UIElemento.getElementos());
        UIUsuario.asignarEventosCliente(UIEventos.getEventos());
        UIAgenda.cargarAgenda(ma.leerArchivo(ManejoDeArchivos.getFILE4()));
        UIPago.cargarTransacciones(ma.leerArchivo(ManejoDeArchivos.getFILE5()));
    }

    /***
     * metodo que verifica el usuario y contrasenia ingresadas por el Usuario, y que lo hace comparando usuario y contraseña
     * de la lista usuarios de la clase UIUsuario
     * @return true si el usuario y contrasenia coinciden con los atributos de un Usuario perteneciente a la lista 
     * de usuarios cargada en el inicio del programa; false caso contrario
     */
    public boolean login() {
        boolean b;
        b = true;
        String clave;
        System.out.print("Ingrese su usuario: ");
        user = sc.nextLine();
        System.out.print("Ingrese su contrasena: ");
        clave = sc.nextLine();
        for (Usuario u : UIUsuario.getUsuarios()) {
            if(user.equals(u.getUsuario()) && clave.equals(u.getClave())){
                b = false;
                break;
            }
        }
        if(b) System.out.println("Usuario o clave incorrectas ");
        return b;
    }
    
    /***
     * retorna el perfil del usuario que llama al metodo
     * @return char - Especifica el perfil del Usuario
     */
    public char obtenerPerfil(){
        char result = ' ';
        for(Usuario usuario: UIUsuario.getUsuarios()){
            if (user.equals(usuario.getUsuario())){
                return usuario.getPerfil();
                
            } 
        }
        return result;
    }
    
    /***
     * metodo para obtener el Usuario del usuario ingresado anteriormente
     * @return Usuario - Se encuentre en la lista de usuarios cargadas por el sistema
     */
    public Usuario obtainUser(){
        for (Usuario usuario: UIUsuario.getUsuarios()){
            if (user.equals(usuario.getUsuario())) {
                return usuario;
                
            }
        }
        return null;
    }
    
    /***
     * sirve para escribir un usuario en lel archivo usuarios.txt
     */
    public void registrarUsuario(){
        Usuario usuario;
        usuario = UIUsuario.crearUsuario();
        UIUsuario.añadirUsuario(usuario);
        ma.escribirArchivo(usuario.pasarLinea(),ManejoDeArchivos.getFILE1());
    }
    

    /***
     * get del atributo user
     * @return Un string que contiene el nombre del usuario 
     */
    public String getUser() {
        return user;
    }

    /***
     * set del atributo user
     * @param user Nombre del usuario
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    

}
