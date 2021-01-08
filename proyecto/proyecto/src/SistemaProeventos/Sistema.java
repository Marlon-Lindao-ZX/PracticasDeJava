/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import Agenda.Agenda;
import Transacciones.Pago;
import java.util.Scanner;
import Usuarios.*;
import Eventos.UIEventos;
import java.lang.System;

/**
 * Clase Main del Proyecto
 * @author Alex
 */
public class Sistema {
    static UISistema ui = new UISistema();
    static boolean controlLogin, controlPrograma = true;
    static Scanner sc = new Scanner(System.in);
    static UIEventos aplication = new UIEventos();
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        ui.cargaArchivos();
        
        do{
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("                 Bienvenido al Sistema             ");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
            controlLogin = ui.login();
            System.out.println("");
            System.out.println("");
        } while(controlLogin);
        
        while(controlPrograma){
            switch (ui.obtenerPerfil()) {
                case 'A':
                    menuAdminnistrador();
                    controlPrograma = false;
                    break;
                case 'P':
                    menuPlanificador(ui.obtainUser());
                    controlPrograma = false;
                    break;
                case 'C':
                    menuCliente(ui.obtainUser());
                    controlPrograma = false;
                    break;
            }
            System.out.println("Bye Bye XD");
        }
        

    }
    
    /***
     * el programa muestra este menu cuando el perfil del usuario que ingreso por el login es A de Administrador
     */
    public static void menuAdminnistrador(){
        boolean control = true;
        String opcion;
        while (control) {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("        Bienvenido Administrador       ");
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    ui.registrarUsuario();
                    break;
                case "2":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
                
            }
        }
    }
    
    /***
     * el programa muestra este menu cuando el perfil del usuario que ingreso por el login es P de Planificador
     * @param usuario Usuario que inicio sesion en el sistema y el programa lo reconocio como Planificador
     */
    public static void menuPlanificador(Usuario usuario){
        Planificador planificador = null;
        if (usuario instanceof Planificador) {
            planificador = (Planificador) usuario;
        }
        boolean control = true;
        String opcion;
        while (control) {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("        Bienvenido Planificador       ");
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Registrar Evento");
            System.out.println("2. Registrar Agenda");
            System.out.println("3. Confirmar evento");
            System.out.println("4. Consultar evento");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    aplication.crearEvento(planificador);
                    break;
                case "2":
                    Agenda.menuAgenda();
                    break;
                case "3":
                    UIEventos.confirmarEvento();
                    break;
                case "4":
                    UIEventos.menuOrdenacion();
                    break;
                case "5":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
                
            }
        }
    }
    
    /***
     * el programa muestra este menu cuando el perfil del usuario que ingreso por el login es C de Cliente
     * @param usuario Usuario que inicio sesion en el sistema y el programa lo reconocio como Cliente
     */
     public static void menuCliente(Usuario usuario){
        Cliente cliente = null;
        if (usuario instanceof Cliente) {
            cliente = (Cliente) usuario;
        }
        boolean control = true;
        String opcion;
        while (control) {
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("          Bienvenido Cliente          ");
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Registrar pago Evento");
            System.out.println("2. Consultar evento");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    Pago.menuTransaccion(cliente);
                    break;
                case "2":
                    cliente.presentarEvento();
                    break;
                case "3":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
                
            }
        }
    }

}
