/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import Archivos.ManejoDeArchivos;
import Eventos.Evento;
import Eventos.UIEventos;
import SistemaProeventos.Validaciones;
import Usuarios.Cliente;
import Usuarios.UIUsuario;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */

/***
 * Clase Pago con sus atributos y modificadores de acceso
 * @author Marinchi
 */

public class Pago {
    private Evento evento;
    private Cliente cliente;
    private String metodoPago;
    private String codigoTransaccion;
    private static ManejoDeArchivos ma = new ManejoDeArchivos();
    private static Validaciones valido = new Validaciones();
    
    /***
     * constructor vacio
     */
    public Pago(){}   
    
    /***
     * constructor con parametros de la clase pago
     * @param evento Evento asociado a este Pago
     * @param cliente Cliente asociado a este Pago
     * @param metodoPago La forma de cancelacion de este Pago
     * @param codigoTransaccion  El codigo generado del Pago
     */
    public Pago(Evento evento, Cliente cliente, String metodoPago, String codigoTransaccion) {
        this.evento = evento;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.codigoTransaccion = codigoTransaccion;
    }
    
    /***
     * constructor que recibe una linea extraida del archivo pagos.txt y que contiene los atributos del objeto tipo agenda
     * a instanciar
     * @param linea Un string que contiene los atributos de este Pago
     */
    public Pago(String linea){
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        String codigo = delimitar.next();
        evento = UIEventos.obtenerEvento(codigo);
        String client = delimitar.next();
        cliente = UIUsuario.buscarCliente(client);
        metodoPago = delimitar.next();
        codigoTransaccion = delimitar.next();
    }
    
    /***
     * crea un pago de un evento asociado a un cliente
     * @param cliente Cliente que inicio en el sistema
     */
    public static void menuTransaccion(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        String codigo, opcion, metodoPago, codigoTransaccion;
        boolean control = true;
        System.out.print("Ingrese el codigo del evento: ");
        codigo = sc.nextLine();
        Evento evento = UIEventos.obtenerEvento(codigo);
        if (evento != null) {
            if (evento.getCliente().getNombre().equals(cliente.getNombre())) {
                if (!UIPago.verificarPago(evento)) {
                    do{
                    System.out.print("Ingrese el metodo de pago utilizado para el pago del evento: ");
                    metodoPago = sc.nextLine();
                    }while(valido.esNumerico(metodoPago));
                    do{
                    System.out.print("Ingrese el codigo de transaccion generado sobre el pago del evento: ");
                    codigoTransaccion = sc.nextLine();
                    } while(!valido.verificarCantidadCaracteres(codigoTransaccion)); 
                    System.out.println("¿Desea confirmar el pago de este evento? (S/N)");
                    do {
                        System.out.print("Digite su opcion: ");
                        opcion = sc.nextLine();
                        switch (opcion) {
                            case "S":
                                Pago pago = new Pago(evento, cliente, metodoPago, codigoTransaccion);
                                UIPago.anadirPago(pago);
                                escribirPago(pago.toString());
                                System.out.println("Transaccion realizada de forma exitosa");
                                control = false;
                                break;
                            case "N":
                                System.out.println("Evento no ha sido cancelado");
                                control = false;
                                break;
                            default:
                                break;
                        }
                    } while (control);

                } else {
                    System.out.println("Este evento ya cuenta como pagado!!");
                }
            } else {
                System.out.println("Este evento no le pertenece!!");
            }
        } else {
            System.out.println("Evento no existe!!");
        }
    }
    
    /***
     * sirve para escribir en el archivo pago.txt un string que contiene los atributos del objeto tipo pago
     * @param linea Un String que contiene los atributos de este objeto
     */
    public static void escribirPago(String linea){
        ma.escribirArchivo(linea, ManejoDeArchivos.getFILE5());
    }
    
    /***
     * retorna un string con los atributos del objeto que llama al metodo
     * @return Un String con los atributos de este objeto
     */
    @Override
    public String toString(){
        return this.evento.getCodigoEvento()+ "," + this.cliente.getNombre() + "," + metodoPago + "," + codigoTransaccion;
    }

    /***
     * get del atributo evento 
     * @return Evento pagado por el cliente que lo solicito
     */
    public Evento getEvento() {
        return evento;
    }

    /***
     * set del atributo evento
     * @param evento Evento cancelado por el cliente en una sesion anterior del sistema
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /***
     * get del atributo codigoTransaccion
     * @return Codigo generado en el pago del Evento
     */
    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /***
     * set del atributo codigoTransaccion
     * @param codigoTransaccion Codigo generado en el pago del Evento
     */
    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    /***
     * get del atributo cliente
     * @return objeto tipo Cliente asociado a este pago
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /***
     * set del atributo cliente
     * @param cliente Cliente que realizo el pago de un evento asociado a el
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /***
     * get del atributo metodoPago
     * @return Un string que contiene el metodo de pago realizado por el cliente 
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /***
     * set del atributo metodoPago
     * @param metodoPago Un string que contiene el metodo de pago realizado por el cliente
     */
    public void setMetodopoago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

}
