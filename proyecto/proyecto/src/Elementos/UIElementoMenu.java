/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Constantes.TipoElementos;
import Constantes.TipoEvento;
import Eventos.*;
import SistemaProeventos.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que contiene los submenu del metodo crearElementos
 * @author CORE I7
 */
public class UIElementoMenu {
    
    private Scanner read = new Scanner(System.in);
    private static UIElemento test = new UIElemento();
    private static Validaciones valido = new Validaciones();
    
    /***
     * submenu de crearElementos que registra las opciones de comida
     * @param elementos arreglo de elementos
     * @param evento evento
     * @return arreglo de elementos
     */
    public ArrayList<Elemento> menuComida(ArrayList<Elemento> elementos, Evento evento) {
        boolean control,control2;
        control = true;
        ArrayList<Elemento> retorno = new ArrayList<>();
        String opcion;
        int cantidad = 0;
        do {
            System.out.println("Opciones de comida: ");
            System.out.println("1) Menu");
            System.out.println("2) Bocaditos");
            System.out.println("3) Regresar al menu anterior");
            System.out.print("Elija opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "1":
                    if(!test.verificarElemento(retorno,elementos,TipoElementos.MENU)){
                        while(cantidad<1){
                        System.out.print("Ingrese la cantidad de platos a servir: ");
                        cantidad = valido.esUnNumeroValido();
                        }
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.MENU,cantidad,evento);
                        System.out.println("Elemento: "+TipoElementos.MENU+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                System.out.println("Elemento ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                System.out.println("opcion invalida!!");
                                System.out.println("");
                                break;
                        }
                        } while(control2);
                        cantidad = 0;
                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                        System.out.println("");
                        System.out.println("");
                    }
                    break;
                case "2":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.BOCADITOS)){
                         System.out.println("Ingrese la cantidad de bocaditos que haya en el evento");
                         do {
                             System.out.print("Ingrese una cantidad muliplo de 100: ");
                             cantidad = valido.esUnNumeroValido();
                         }while((cantidad % 100) != 0);
                         control2 = true;
                         Elemento elemento = new Elemento(TipoElementos.BOCADITOS, cantidad, evento);
                         System.out.println("Elemento: " + TipoElementos.BOCADITOS + "\n" + "Cantidad: " + elemento.getCantidad() + "\n"
                                 + "Total: " + elemento.getPrecioTotal() + "\n");
                         System.out.println("¿Desea ingresar este elemento?(S/N)");
                         do {
                             System.out.print("Digite su opcion: ");
                             opcion = read.nextLine();
                             switch (opcion) {
                                 case "S":
                                     retorno.add(elemento);
                                     System.out.println("Elemento ha sido agregado");
                                     control2 = false;
                                     break;
                                 case "N":
                                     System.out.println("elemento no ha sido agregado");
                                     control2 = false;
                                     break;
                                 default:
                                     break;
                             }
                         } while (control2);
                         
                        
                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                    }
                    break;
                case "3":
                    return retorno;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (control);
        return retorno;

    }

    /***
     * submenu del metodo crearElemento que registra las opciones de musica disponibles
     * @param elementos arreglo de elementos
     * @param evento evento
     * @return arreglo de elementos
     */
    public ArrayList<Elemento> menuMusica(ArrayList<Elemento> elementos, Evento evento) {
        boolean control,control2;
        control = true;
        ArrayList<Elemento> retorno = new ArrayList<>();
        String opcion;
        do {
            System.out.println("Servicios de Musica: ");
            System.out.println("1) DJ");
            System.out.println("2) Banda");
            System.out.println("3) Regresar al menu anterior");
            System.out.print("Elija opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "1":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.DJ)){
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.DJ,evento);
                        System.out.println("Elemento: "+TipoElementos.DJ+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                 System.out.print("Usted ha agregado un DJ");
                                 System.out.println("");
                                 System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                break;
                        }
                        } while(control2);
                        
                    } else {
                        System.out.println("Usted ya agrego un DJ!!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "2":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.BANDA)){
                         control2 = true;
                         Elemento elemento = new Elemento(TipoElementos.BANDA, evento);
                         System.out.println("Elemento: " + TipoElementos.BANDA + "\n" + "Cantidad: " + elemento.getCantidad() + "\n"
                                 + "Total: " + elemento.getPrecioTotal() + "\n");
                         System.out.println("¿Desea ingresar este elemento?(S/N)");
                         do {
                             System.out.print("Digite su opcion: ");
                             opcion = read.nextLine();
                             switch (opcion) {
                                 case "S":
                                     retorno.add(elemento);
                                     System.out.print("Usted ha agregado una banda");
                                     System.out.println("");
                                     System.out.println("");
                                     control2 = false;
                                     break;
                                 case "N":
                                     System.out.println("elemento no ha sido agregado");
                                     System.out.println("");
                                     System.out.println("");
                                     control2 = false;
                                     break;
                                 default:
                                     System.out.println("opcion invalida!!");
                                     break;
                             }
                         } while (control2);
                         
                    } else {
                        System.out.println("Usted ya agrego una banda!!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "3":
                    System.out.println("");
                    System.out.println("");
                    return retorno;
                default:
                    System.out.println("opcion invalida");
                    System.out.println("");
                    System.out.println("");
                    break;
            }

        } while (control);
        return retorno;

    }

    /***
     * submenu del metodo crearElemento que registra la opcion de Fotografia
     * @param elementos arreglo de elementos
     * @param evento eveto
     * @return elemento
     */
    public Elemento menuFotografias(ArrayList<Elemento> elementos, Evento evento) {
        boolean control;
        control = true;
        String opcion;
        do {
            System.out.println("¿Desea tener servicio de fotografias? (S/N)");
            System.out.print("Digite su opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "S":
                    if(!test.verificarElemento(elementos,TipoElementos.FOTOGRAFIA)){
                        Elemento elemento = new Elemento(TipoElementos.FOTOGRAFIA,evento);
                        System.out.println("Servicio de Fotografias agregado");
                        System.out.println("");
                        System.out.println("");
                        return elemento;
                    } else {
                        System.out.print("El evento ya tiene servicio de fotografias!");
                        System.out.println("");
                        System.out.println("");
                    }

                    control = false;
                    break;
                case "N":
                    System.out.println("Servicio de Fotografias no ha sido agregado");
                    System.out.println("");
                    System.out.println("");
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    System.out.println("");
                    System.out.println("");
                    break;
            }

        } while (control);
        return null;
        

    }
    
    /***
     * submenu del metodo crearElemento que registra la opcion de Decoracion
     * @param elementos arreglo de elementos
     * @param evento evento
     * @return elemento
     */
    public Elemento menuDecoracion(ArrayList<Elemento> elementos, Evento evento) {
        boolean control;
        control = true;
        String opcion;
        do {
            System.out.println("¿Desea tener el servicio de decoracion? (S/N)");
            System.out.print("Digite su opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "S":
                      if(!test.verificarElemento(elementos,TipoElementos.DECORACION)){
                        Elemento elemento = new Elemento(TipoElementos.DECORACION,evento);
                          System.out.println("Servicio de Decoracion ha sido agregado");
                          System.out.println("");
                          System.out.println("");
                        return elemento;
                    } else {
                        System.out.println("El servicio de decoracion ya ha sido agregado!!");
                          System.out.println("");
                          System.out.println("");
                    }
                    control = false;
                    break;
                case "N":
                    System.out.println("Servicio de decoracion no ha sido agregado");
                    System.out.println("");
                    System.out.println("");
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    System.out.println("");
                    System.out.println("");
                    break;
            }

        } while (control);
        return null;

    }
/***
 * submenu del metodo crearElemento que registra las opciones de bebidas disponibles
 * @param elementos arreglo de elementos
 * @param evento evento
 * @return elemento
 */
    public ArrayList<Elemento> menuBebida(ArrayList<Elemento> elementos, Evento evento) {
        boolean control,control2;
        control = true;
        int cantidad=0;
        ArrayList<Elemento> retorno = new ArrayList<>();
        String opcion;
        do {
            System.out.println("Opciones de bebida: ");
            System.out.println("1) Whisky");
            System.out.println("2) Vodka");
            System.out.println("3) Cerveza");
            System.out.println("4) Refrescos");
            System.out.println("5) Regresar al menu anterior");
            System.out.print("Elija opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "1":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.WHISKY)){
                        while(cantidad<1){
                            System.out.print("Ingrese la cantidad de botellas que desea para el evento: ");
                            cantidad = valido.esUnNumeroValido();
                        }
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.WHISKY,cantidad,evento);
                        System.out.println("Elemento: "+TipoElementos.WHISKY+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                System.out.println("Elemento ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("Elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                break;
                        }
                        } while(control2);
                        cantidad = 0;

                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "2":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.VODKA)){
                         while(cantidad<1){
                            System.out.print("Ingrese la cantidad de botellas que desea para el evento: ");
                            cantidad = valido.esUnNumeroValido();
                         }
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.VODKA,cantidad,evento);
                        System.out.println("Elemento: "+TipoElementos.VODKA+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                System.out.println("Elemento ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("Elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                break;
                        }
                        } while(control2);
                        cantidad = 0;
                        
                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "3":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.CERVEZA)){
                         while(cantidad<1){
                            System.out.print("Ingrese la cantidad de cervezas que desea para el evento: ");
                            cantidad = valido.esUnNumeroValido();
                         }
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.CERVEZA,cantidad,evento);
                        System.out.println("Elemento: "+TipoElementos.CERVEZA+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                System.out.println("Elemento ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("Elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                break;
                        }
                        } while(control2);
                        cantidad = 0;
                        
                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "4":
                     if(!test.verificarElemento(retorno,elementos,TipoElementos.REFRESCOS)){
                         while(cantidad<1){
                            System.out.print("Ingrese la cantidad de refrescos que desea para el evento: ");
                            cantidad = valido.esUnNumeroValido();
                         } 
                        control2 = true;
                        Elemento elemento = new Elemento(TipoElementos.REFRESCOS,cantidad,evento);
                        System.out.println("Elemento: "+TipoElementos.REFRESCOS+"\n"+"Cantidad: "+elemento.getCantidad()+"\n"+
                                "Total: "+elemento.getPrecioTotal()+"\n");
                        System.out.println("¿Desea ingresar este elemento?(S/N)");
                        do{
                        System.out.print("Digite su opcion: ");
                        opcion = read.nextLine();
                        switch(opcion){
                            case "S":
                                retorno.add(elemento);
                                System.out.println("Elemento ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            case "N":
                                System.out.println("Elemento no ha sido agregado");
                                System.out.println("");
                                System.out.println("");
                                control2 = false;
                                break;
                            default:
                                break;
                        }
                        } while(control2);
                        cantidad = 0;
                        
                    } else {
                        System.out.println("Elemento ya ha sido agregado!");
                         System.out.println("");
                         System.out.println("");
                    }
                    break;
                case "5":
                    System.out.println("");
                    System.out.println("");
                    return retorno;
                default:
                    System.out.println("opcion invalida");
                    System.out.println("");
                    System.out.println("");
                    break;
            }

        } while (control);
        return retorno;

    }

    /***
     * submenu del metodo crearElemento que registra la opcion de Animador
     * @param elementos arreglo de elementos
     * @param evento evento
     * @return elemento
     */
    public Elemento menuAnimador(ArrayList<Elemento> elementos, Evento evento) {
        boolean control;
        control = true;
        String opcion;
        do {
            System.out.println("¿Desea que su evento tenga un animador? (S/N)");
            System.out.print("Digite su opcion: ");
            opcion = read.nextLine();
            switch (opcion) {
                case "S":
                    if (!test.verificarElemento(elementos, TipoElementos.ANIMADOR)) {
                        String name;
                        Animador animador;
                        Elemento elemento = new Elemento(TipoElementos.ANIMADOR, evento);
                        System.out.println("Estos son los animadores disponibles para su evento: "+"\n");
                        UIElemento.mostrarAnimadoresDisponibles(evento.getTipo());
                        System.out.println("Ingrese el nombre del animador que desee que anime su evento que coincida con la "
                                + "lista antes mostrada");
                        do {
                            do {
                                System.out.print("Escriba el nombre del animador: ");
                                name = read.nextLine();
                            } while (valido.esNumerico(name) || valido.tieneNumerosOSimbolos(name));
                            animador = UIElemento.obtenerAnimador(name);
                            if (animador == null) {
                                System.out.println("Animador no se encuentra en la lista mostrada");
                                System.out.println("Ingrese otro");
                            }
                        } while (animador == null);
                        elemento = new Animador(elemento, animador);
                        System.out.println("Animador ha sido agregado");
                        System.out.println("");
                        System.out.println("");
                        return elemento;
                    } else {
                        System.out.println("El evento ya tiene un animador!!");
                        System.out.println("");
                        System.out.println("");
                    }
                    control = false;
                    break;
                case "N":
                    System.out.println("Servicio de Animador no agregado");
                    System.out.println("");
                    System.out.println("");
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida!!");
                    System.out.println("");
                    System.out.println("");
                    break;
            }
            
        } while (control);
        return null;
        
    }
}
