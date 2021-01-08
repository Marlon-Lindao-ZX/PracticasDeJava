/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import SistemaProeventos.Validaciones;
import java.util.Scanner;

/**
 *Contiene los submenus del metodo CrearEvento
 * @author CORE I7
 */
public class UIEventoMenu {
    
    private static Scanner sc = new Scanner(System.in);
    private static Validaciones valido = new Validaciones();
    
    public UIEventoMenu (){}
    
    /***
     * submenu de Boda del metodo crearEvento
     * @param evento Evento que esta siendo creado por el Planificador
     * @return Un Objeto tipo Boda que fue instaciado con los atributos del evento enviado y con los ingresados
     */
    public static Evento menuBoda(Evento evento) {
        String opcion, tipoVehiculo;
        tipoVehiculo = "";
        boolean control = true;
        System.out.println("¿Desea ingresar el tipo de vehiculo que se transportara la pareja? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    do{
                    System.out.print("Escriba el tipo de vehiculo: ");
                    tipoVehiculo = sc.nextLine();
                    } while(valido.esNumerico(tipoVehiculo));
                    System.out.println("");
                    System.out.println("");
                    control = false;
                    break;
                case "N":
                    tipoVehiculo = "No aplica";
                    System.out.println("");
                    System.out.println("");
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");

            }
        }
        Boda boda = new Boda(evento, tipoVehiculo);
        System.out.println(boda);
        control = true;
        System.out.println("¿Desea guardar este evento y finalizar el registro? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    return boda;
                case "N":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    break;
            }
        }
        return null;
    }
    
    /***
     * submenu de la Fiesta Infantil del metodo crearEvento
     * @param evento Evento que esta siendo creado por el Planificador
     * @return Un Objeto tipo FiestaInfantil que fue instaciado con los atributos del evento enviado y con los ingresados
     */
    public static Evento menuFiestaInfantil(Evento evento){
        String opcion;
        int cantidadPersonasDisfrazadas,cantidadSorpresasRepartir;
        boolean control,juegosInfantiles;
        control = juegosInfantiles = true;
        do{
        System.out.print("Ingrese la cantidad de personas disfrazadas que habran en la fiesta: ");
        cantidadPersonasDisfrazadas = valido.esUnNumeroValido();
        } while(cantidadPersonasDisfrazadas < 0);
        do{
        System.out.print("Ingrese la cantidad de sorpresas que se van a repartir en la fiesta: ");
        cantidadSorpresasRepartir = valido.esUnNumeroValido();
        } while(cantidadSorpresasRepartir < 0);
        System.out.println("¿Desea tener servicio de juegos infantiles? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    control = false;
                    break;
                case "N":
                    juegosInfantiles = false;
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");

            }
        }
        FiestaInfantil fiestaInfantil = new FiestaInfantil(evento,cantidadPersonasDisfrazadas,cantidadSorpresasRepartir,juegosInfantiles);
        System.out.println(fiestaInfantil);
        control = true;
        System.out.println("¿Desea guardar este evento y finalizar el registro? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    return fiestaInfantil;
                case "N":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    break;
            }
        }
        return null;
  
    }
    
    /***
     * submenu de la Integracion del metodo crearEvento 
     * @param evento Evento que esta siendo creado por el Planificador
     * @return Un Objeto tipo Integracion que fue instaciado con los atributos del evento enviado y con los ingresados
     */
    public static Evento menuIntegracion(Evento evento){
        String opcion;
        int cantidadPersonasTransportar = 0;
        boolean control,transporte;
        control = transporte = true;
        System.out.println("¿Desea tener servicio de transporte? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    do{
                    System.out.print("Ingrese la cantidad de personas a transportar hacia la integracion: ");
                    cantidadPersonasTransportar = valido.esUnNumeroValido();
                    }while (cantidadPersonasTransportar < 0);
                    control = false;
                    break;
                case "N":
                    transporte = false;
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");

            }
        }
        Integracion integracion = new Integracion(evento,transporte,cantidadPersonasTransportar);
        System.out.println(integracion);
        control = true;
        System.out.println("¿Desea guardar este evento y finalizar el registro? (S/N)");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "S":
                    return integracion;
                case "N":
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    break;
            }
        }
        return null;
    }
}
