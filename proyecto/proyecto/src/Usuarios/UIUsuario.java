/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;


import Eventos.Evento;
import SistemaProeventos.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase que contiene los metodos usados por la Clase Usuario y sus respectivas clases hijas, y que ademas guarda los usuarios
 * creados durante la ejecucion del programa
 * @author CORE I7
 */
public class UIUsuario {
 
    private static Scanner sc = new Scanner(System.in);
    private static Validaciones valido = new Validaciones();
    private static ArrayList <Usuario> usuarios = new ArrayList<>();
    
    /***
     * constructor vacio de UIUsuario
     */
    public UIUsuario(){}

    /***
     * retorna un pbjeto tipo usuario instanciado con los parametros ingresados por el usuario, y que le muestra al usuario
     * como debe ingresar estos parametros
     * @return Un objeto tipo Usuario instanciado con los parametros ingresados de este metodo
     */
    public static Usuario crearUsuario() {
        boolean controlPrincipal = true;
        Usuario u = null;
        String nombre, apellido, usuario, contraseña, opcion, confirmacion;
        char perfil, val;
        nombre = "";
        apellido = usuario = contraseña = nombre;
        perfil = ' ';

        while (controlPrincipal) {

            boolean control, control2, control3;
            control = control2 = control3 = true;

            System.out.println("¿Que perfil tendra el usuario?");
            System.out.println("1) Planificador (P) ");
            System.out.println("2) Cliente (C)");

            do {
                System.out.print("Digite su opcion: ");
                opcion = sc.nextLine();
                switch (opcion) {
                    case "1":
                        perfil = 'P';
                        control2 = false;
                        break;
                    case "2":
                        perfil = 'C';
                        control2 = false;
                        break;
                    default:
                        System.out.println("opcion no valida");
                        break;
                }

            } while (control2);

            do{
            System.out.print("Ingrese el nombre del usuario: ");
            nombre = sc.nextLine();
            } while(valido.esNumerico(nombre) || valido.tieneNumerosOSimbolos(nombre));
            do{
            System.out.print("Ingrese el apellido del usuario: ");
            apellido = sc.nextLine();
            } while(valido.esNumerico(apellido) || valido.tieneNumerosOSimbolos(apellido));
            do{
            System.out.print("Ingrese el sobrenombre del usuario: ");
            usuario = sc.nextLine();
            } while (buscarUsuario(usuario));
            System.out.println("Ingrese una contraseña ");
            System.out.println("La contraseña debe tener estas condiciones");
            System.out.println("1) El primer caracter debe ser una letra Mayuscula");
            System.out.println("2) La contraseña debe tener de 8 a 12 caracteres");
            while (control) {
                System.out.print("Inserte la contraseña: ");
                contraseña = sc.nextLine();
                val = contraseña.charAt(0);
                if (Character.isUpperCase(val) && ((contraseña.length() >= 8) && (contraseña.length() <= 12))) {
                    System.out.println("Contraseña valida");
                    control = false;
                } else {
                    System.out.println("Ingrese una contraseña valida");
                }
            }

            while (control3) {
                System.out.print("¿Desea guardar los cambios realizados? (S/N): ");
                confirmacion = sc.nextLine();
                confirmacion = confirmacion.toUpperCase();
                switch (confirmacion) {
                    case "S":
                        controlPrincipal = false;
                        control3 = false;
                        break;
                    case "N":
                        control3 = false;
                        break;
                    default:
                        System.out.println("Ingrese la opcion correcta");
                        break;

                }
            }

        }
        
        switch(perfil){
            case 'A':
                u = new Usuario(nombre, apellido, usuario, contraseña, perfil);
                break;
            case 'P':
                u = new Planificador(nombre, apellido, usuario, contraseña, perfil);
                break;
            case 'C':
                u = new Cliente(nombre, apellido, usuario, contraseña, perfil);
                break;
        }
        System.out.println("USUARIO CREADO CORRECTAMENTE");

        return u;
    }
    
    /***
     * metodo que carga los usuarios que han sido guardados previamente en el archivo usuarios.txt, y que lo hace recibiendo
     * una lista de strings extraidos de ese archivo
     * @param lineas Una lista que contiene strings que representan los atributos de cada objeto tipo Usuario creado antes en 
     * el programa
     */
    public static void cargarListaUsuario(ArrayList<String> lineas) {
        for (String linea : lineas) {
            Usuario usuario = new Usuario(linea);
            switch (usuario.getPerfil()) {
                case 'A':
                    usuarios.add(usuario);
                    break;
                case 'P':
                    usuarios.add(new Planificador(usuario));
                    break;
                case 'C':
                    usuarios.add(new Cliente(usuario));
                    break;

            }

        }
    }
    
    /***
     * retorna un dato tipo booleano que sera true o false segun el resultado de la coincidencia del user enviado como parametro
     * con el atributo usuario de cada objeto tipo Usuario durante la busqueda en la lista usuarios de esta clase UIUsuario
     * @param user El user del Usuario a buscar en la lista de esta clase UIUsuario
     * @return true si el user coincide con el usuario de cualquier elemento de esta lista o si el string enviado tiene menos 
     * de dos caracteres
     */
    public static boolean buscarUsuario(String user){
        if(valido.verificarCantidadCaracteres(user)){
        for(Usuario usuario: usuarios){
            if(usuario.getUsuario().equals(user)){
                System.out.println("El Usuario ya ha sido utilizado utilizado");
                return true;
            }
        }
        return false;
        } else {
            System.out.println("Ingrese un usuario con mas de dos caracteres");
            return true;
        }
    }
    
    /***
     * retorna un objeto tipo Planificador que coincida con el nombre enviados como parametro 
     * durante la busqueda en la lista usuarios de esta clase UIUsuario
     * @param nombre El nombre del planificador a buscar en la lista de esta clase UIUsuario
     * @return Un objeto tipo Planificador que su nombre coincide con el enviado como parametro, caso contrario
     * regresa nulo
     */
    public static Planificador buscarPlanificador(String nombre){
        for(Usuario usuario: usuarios){
            if(usuario instanceof Planificador){
                Planificador planificador = (Planificador) usuario;
                if(planificador.getNombre().equals(nombre)) return planificador;
            }
        }
        return null;
    }
    
    /***
     * retorna un objeto tipo Cliente que coincida con el nombre enviados como parametro 
     * durante la busqueda en la lista usuarios de esta clase UIUsuario
     * @param nombre El nombre del cliente a buscar en la lista de esta clase UIUsuario
     * @return Un objeto tipo Cliente que su nombre coincide con el enviado como parametro, caso contrario
     * regresa nulo
     */
    public static Cliente buscarCliente(String nombre){
        for(Usuario usuario: usuarios){
            if(usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                if(cliente.getNombre().equals(nombre)) return cliente;
            }
        }
        return null;
    }
    
    /***
     * Metodo que recibe una lista de eventos y que asigna sus elementos a los respectivos clientes que 
     * el planificador asigno anteriormente
     * @param eventos La lista de eventos que fue cargada al comienzo del programa
     */
    public static void asignarEventosCliente(ArrayList<Evento> eventos){
        for(Usuario usuario: usuarios){
            if(usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                cliente.asignarEventos(eventos);
            }
        }
    }
    
    /***
     * añade un objeto tipo usuario que es enviado como parametro y que lo añade a la lista de 
     * esta clase UIUsuario
     * @param usuario Un objeto tipo Usuarip que sera añadido a la lista de esta clase
     */
     public static void añadirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

     /***
      * Obtiene el atributo usuarios
      * @return Una lista de tipo Usuario de esta clase UIUsuario
      */
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /***
     * Setea el atributo usuarios
     * @param usuarios Una lista de tipo Usuario que reemplazara la lista de esta clase UIUsuario
     */
    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        UIUsuario.usuarios = usuarios;
    }

}
