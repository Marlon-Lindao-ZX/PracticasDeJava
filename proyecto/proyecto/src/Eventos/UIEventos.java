/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Archivos.ManejoDeArchivos;
import Constantes.Estado;
import Constantes.TipoEvento;
import Elementos.Animador;
import Elementos.Elemento;
import Elementos.UIElemento;
import SistemaProeventos.Validaciones;
import Transacciones.Pago;
import Usuarios.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Transacciones.UIPago;
import java.util.Collections;
import java.util.Comparator;
        
/**
 * clase que implementa comparator para ordenar la lista de eventos
 * @author CORE I7
 */
public class UIEventos implements Comparator<Evento>{
    
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static UIElemento uie = new UIElemento();
    private static ManejoDeArchivos writer = new ManejoDeArchivos();
    private static Validaciones valido = new Validaciones();
    
    /***
     * constructor vacio
     */
    public UIEventos(){}
    
    /***
     * metodo para crear un evento
     * @param planificador Planificador que inicio sesion en este sistema
     */
    public void crearEvento(Planificador planificador) {
        
        Evento evento,retorno;
        TipoEvento tipo = null;
        String lugar, transition, opcion,nombre;
        Cliente cliente;
        LocalDate fecha;
        LocalTime horaInicio, horaFin;
        fecha = null;
        horaInicio = horaFin = null;
        int cantidad;
        boolean control;
        control = true;

        System.out.println("*******************************************");
        System.out.println("                Nuevo Evento               ");
        System.out.println("*******************************************");
        System.out.println("Elija el tipo de evento:");
        System.out.println("1) Boda");
        System.out.println("2) Fiesta Infantil ");
        System.out.println("3) Integracion");
        while (control) {
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    tipo = TipoEvento.Boda;
                    control = false;
                    break;
                case "2":
                    tipo = TipoEvento.Fiesta_Infantil;
                    control = false;
                    break;
                case "3":
                    tipo = TipoEvento.Integracion;
                    control = false;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }
        System.out.println("*******************************************");
        System.out.println("                Evento: " + tipo);
        System.out.println("*******************************************");
        do {
            do{
            System.out.print("Ingrese el nombre del cliente: ");
            nombre = sc.nextLine();
            } while(valido.esNumerico(nombre) || valido.tieneNumerosOSimbolos(nombre));
            cliente = UIUsuario.buscarCliente(nombre);
            if (cliente == null) {
                System.out.println("Este cliente no se encuentra en los registros del sistema!!");
            }
        } while (cliente == null);
        do{
        System.out.print("Ingrese el lugar a desarrollarse el evento: ");
        lugar = sc.nextLine();
        }while(valido.esNumerico(lugar) || valido.tieneNumerosOSimbolos(lugar));
        System.out.println("Ingrese la fecha predestinada para el evento");
        do {
            System.out.print("Ingrese la fecha con formato dd/mm/yyyy: ");
            transition = sc.next();
            fecha = valido.esFechaValida(transition);
        } while (fecha == null);
        System.out.println("Digite la hora que empieza el evento: ");
        do {
            System.out.print("Ingrese la hora de inicio con este formato HH:mm : ");
            transition = sc.next();
            horaInicio = valido.esHoraValida(transition);
        } while (horaInicio == null);
        System.out.println("Digite la hora de finalizacion del evento");
        do {
            System.out.print("Ingrese la hora de finalizacion con este formato HH:mm : ");
            transition = sc.next();
            horaFin = valido.esHoraValida(transition);
        } while ((horaFin == null)  || (horaFin.equals(horaInicio)) || (horaFin.isBefore(horaInicio)));
        do{
        System.out.print("Ingrese la cantidad de personas que asistiran al evento: ");
        cantidad = valido.esUnNumeroValido();
        }while(cantidad <1);
        sc.skip("\n");
        evento = new Evento(tipo,cliente,lugar,fecha,horaInicio,horaFin,cantidad,planificador);
        evento.setElementos(uie.crearElemento(evento));
        switch(evento.getTipo()){
            case Boda:
                retorno = UIEventoMenu.menuBoda(evento);
                if(retorno != null){
                    uie.agregarElementosOtraLista(retorno.getElementos());
                    eventos.add(retorno);
                    escribirEvento(retorno);
                    System.out.println("Registro exitoso");
                    System.out.println("");
                    System.out.println("");
                } else {
                    System.out.println("Registro fallido");
                    System.out.println("");
                    System.out.println("");
                }
                
                break;
            case Fiesta_Infantil:
                retorno = UIEventoMenu.menuFiestaInfantil(evento);
                if(retorno != null){
                    uie.agregarElementosOtraLista(retorno.getElementos());
                    eventos.add(retorno);
                    escribirEvento(retorno);
                    System.out.println("Registro exitoso");
                    System.out.println("");
                    System.out.println("");
                } else {
                    System.out.println("Registro fallido");
                    System.out.println("");
                    System.out.println("");
                }
                break;
            case Integracion:
                retorno = UIEventoMenu.menuIntegracion(evento);
                if(retorno != null){
                    uie.agregarElementosOtraLista(retorno.getElementos());
                    eventos.add(retorno);
                    escribirEvento(retorno);
                    System.out.println("Registro exitoso");
                    System.out.println("");
                    System.out.println("");
                } else {
                    System.out.println("Registro fallido");
                    System.out.println("");
                    System.out.println("");
                }
                break;
        }
    }
    
    /***
     * metodo para obtener un objeto tipo Evento
     * @param codigoEvento Codigo del evento que se desea buscar en el sistema
     * @return Evento que contenga el codigo del evento enviado como parametro
     */
    public static Evento obtenerEvento(String codigoEvento){
        for(Evento evento: eventos){
            if(evento.getCodigoEvento().equals(codigoEvento)){
                return evento;
            }
            
        }
        return null;
        
    }
    
    /***
     * metodo para confirmar un evento
     */
    public static void confirmarEvento(){
        System.out.print("Ingrese el codigo del evento: ");
        Scanner es = new Scanner(System.in);
        boolean b = true;
        String codigo=es.nextLine();
        Evento evento = obtenerEvento(codigo);
        if (evento != null) {
            for (Pago p : UIPago.getTransacciones()) {
                if (p.getEvento().getCodigoEvento().equals(codigo)) {
                    p.getEvento().confirmar();
                    System.out.println("El evento se ha confirmado para la fecha establecida");
                    b = false;
                    break;
                } 
            }
            if(b){
                System.out.println("El evento no puede ser confirmado porque todavia no ha sido cancelado "
                            + "por el cliente");
            }
        } else {
            System.out.println("Evento no existe!!");
        }
        
        
    }
     
    /***
     * metodo que sirve para anadir un evento
     * @param evento Evento nuevo que se añadira a la lista de esta clase UIEventos
     */
    public static void anadirEvento(Evento evento){
        eventos.add(evento);
        
    }
    
    /***
     * metodo que presenta los eventos de forma ordenadada
     */
    public static void  presentarEventoOrdenado(){
        Collections.sort(eventos);
        for(Evento evento: eventos){
            System.out.println(evento.presentarAtributosComparacion());
        }
    }
    
    /***
     * metodo que presenta los eventos ordenados segun su tipo
     *
     */
    public static void presentarEventoOrdenadoPorTipo(){
        ArrayList<Evento> retorno = new ArrayList<>();
        for (Evento evento: eventos){
            if(evento.getTipo() == TipoEvento.Boda){
                retorno.add(evento);
            }
            
        }
        if (!retorno.isEmpty()) {
            System.out.println("BODA: ");
            Collections.sort(eventos, new UIEventos());
            for (Evento evento : retorno) {
                System.out.println(evento.presentarAtributosComparacion());
            }
        } 
        retorno.clear();
        for (Evento evento: eventos){
            if(evento.getTipo() == TipoEvento.Fiesta_Infantil){
                retorno.add(evento);
            }
            
        }
        if (!retorno.isEmpty()) {
            System.out.println("FIESTA INFANTIL: ");
            Collections.sort(eventos, new UIEventos());
            for (Evento evento : retorno) {
                System.out.println(evento.presentarAtributosComparacion());
            }
        }
        retorno.clear();
        for (Evento evento: eventos){
            if(evento.getTipo() == TipoEvento.Integracion){
                retorno.add(evento);
            }
            
        }
        if (!retorno.isEmpty()) {
            System.out.println("INTEGRACION: ");
            Collections.sort(eventos, new UIEventos());
            for (Evento evento : retorno) {
                System.out.println(evento.presentarAtributosComparacion());
            }
        }
        retorno.clear();
    }
    
    /***
     * metodo que muestra al planificador las opciones de consulta
     */
    public static void menuOrdenacion(){
        boolean control;
        String opcion;
        control = true;
        do {
            System.out.println("Opciones de consulta de Eventos: ");
            System.out.println("1) Por fecha");
            System.out.println("2) Por Tipo de Evento: ");
            System.out.println("3) Salir del menu");
            System.out.print("Digite su opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    presentarEventoOrdenado();
                    break;
                case "2":
                    presentarEventoOrdenadoPorTipo();
                    break;
                case "3":
                    control = false;
                    break;
                default:
                    System.out.println("opcion no valida!!");
                    break;

            }
        } while (control);
    } 
    
    /***
     * metodo para escribir un evento en el archivo correspondiente y que tambien sus elementos son 
     * añadidos a sus respectivos archivos
     * @param evento Evento que se añadira al archivo correspondiente
     */
    public static void escribirEvento(Evento evento){
        Elemento elemento;
        writer.escribirArchivo(evento.pasarLinea(), ManejoDeArchivos.getFILE2());
        for(Elemento e: evento.getElementos()){
            if(e instanceof Animador){
                Animador animador = (Animador) e;
                UIElemento.escribirElemento(animador.pasarLineaAnimador());
            } else {
                UIElemento.escribirElemento(e.pasarLineaElementoAdicional());
            }
        }
        if(evento instanceof Boda){
            Boda boda = (Boda) evento;
            elemento = new Elemento(boda);
            uie.agregarElementoALista(elemento);
            UIElemento.escribirElemento(elemento.pasarLineaElementoBoda());         
        }
        
        if(evento instanceof FiestaInfantil){
            FiestaInfantil fiestaInfantil = (FiestaInfantil) evento;
            elemento = new Elemento(fiestaInfantil);
            uie.agregarElementoALista(elemento);
            UIElemento.escribirElemento(elemento.pasarLineaElementoFiestaInfantil());

        }
        if(evento instanceof Integracion){
            Integracion integracion = (Integracion) evento;
            elemento = new Elemento(integracion);
            uie.agregarElementoALista(elemento);
            UIElemento.escribirElemento(elemento.pasarLineaElementoIntegracion());            
        }
    }
    
    /***
     * metodo que carga los eventos durante la ejecucion del programa
     * @param lista Lista de Strings generada en la lectura del archivo eventos.txt
     */
    public static void cargaEventos(ArrayList<String> lista) {
        for (String linea : lista) {
            Evento evento = new Evento(linea);
            switch (evento.getTipo()) {
                case Boda:
                    Boda boda = new Boda(evento);
                    eventos.add(boda);
                    break;
                case Fiesta_Infantil:
                    FiestaInfantil fiestaInfantil = new FiestaInfantil(evento);
                    eventos.add(fiestaInfantil);
                    break;
                case Integracion:
                    Integracion integracion = new Integracion(evento);
                    eventos.add(integracion);
                    break;

            }
        }
    }
    
    /***
     * metodo que asigna elementos adicionales a sus respectivos eventos
     * @param elements Lista de elementos cargada en el principio del programa
     */
    public static void asignacionElementosAEventos(ArrayList<Elemento> elements) {
        for (Evento evento : eventos) {
            for (Elemento elemento : elements) {
                if ((elemento.getElemento() != null)) {
                    if ((elemento.getEvento().getCodigoEvento().equals(evento.getCodigoEvento()))) {
                        evento.getElementos().add(elemento);
                    }
                }
            }

            switch (evento.getTipo()) {
                case Boda:
                    Boda boda = new Boda(evento);
                    boda.setAtributos(elements);
                    break;
                case Fiesta_Infantil:
                    FiestaInfantil fiestaInfantil = new FiestaInfantil(evento);
                    fiestaInfantil.setAtributos(elements);
                    break;
                case Integracion:
                    Integracion integracion = new Integracion(evento);
                    integracion.setAtributos(elements);
                    break;
            }
        }

    }
    
    /***
     * metodo para cambiar el formato de una fecha
     * @param date String con la fecha que debe tener el formato solicitado
     * @return Un objeto tipo LocalDate con e tipo de formato solicitado
     */
    public static LocalDate stringToLocalDate(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }
        return localDate;
    }
    
    /***
     * metodo que retorna un evento con el estado CONFIRMADO
     * @param codigoEvento El codigo del evento a buscar
     * @return Evento con estado Confirmado
     */
    public static Evento verificarEstado(String codigoEvento){
        Evento evento = obtenerEvento(codigoEvento);
        if(evento != null){
            if(evento.getEstado().equals(Estado.CONFIRMADO)){
                return evento;
            }
        }
        return null;
    }
    
    /***
     * Sobreescritura del metodo compare de la interfaz Comparator que sirve para comparar la lista de eventos segun su duracion
     * @param evento1 Evento 1 de la lista a comparar
     * @param evento2 Evento 2 de la lista a comparar
     * @return Un resultado numerico que sera utilizado por el metodo sort() de la clase Collections
     */
    @Override
    public int compare(Evento evento1,Evento evento2){
        return evento1.obtenerDuracion() - evento2.obtenerDuracion();
    }
    

    /***
     * get del atributo Evento
     * @return Lista de eventos de esta clase UIEventos
     */
    public static ArrayList<Evento> getEventos() {
        return eventos;
    }

    /***
     * set del atributo Evento
     * @param eventos Lista de Eventos que reemplazara la lista tipo Evento de esta clase UIEventos
     */
    public static void setEventos(ArrayList<Evento> eventos) {
        UIEventos.eventos = eventos;
    }
    
    
    
}
