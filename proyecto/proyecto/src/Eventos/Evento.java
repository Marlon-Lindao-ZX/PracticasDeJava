/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Constantes.Estado;
import Constantes.*;
import Elementos.*;
import Agenda.*;
import Archivos.ManejoDeArchivos;
import Usuarios.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Clase que es padre de Boda, Integracion y FiestaInfantil, y que ademas implementa la interfaz comparable y confirmable
 * @author CORE I7
 */
public class Evento implements Confirmable,Comparable<Evento> {
    private static int codigo = 0;
    protected String codigoEvento;
    protected TipoEvento tipo;
    protected Agenda agenda;
    protected String lugar;
    protected LocalDate fecha;
    protected LocalTime horaInicio;
    protected LocalTime horaFin;
    protected int capacidad;
    protected Planificador planificador;
    protected Cliente cliente;
    protected Estado estado;
    protected ArrayList<Elemento> elementos = new ArrayList<>();
    private static ManejoDeArchivos ma = new ManejoDeArchivos();
    
    /***
     * constructor vacio
     */
    public Evento(){
        
    }
    
    /***
     * constructor con parametros de esta clase que recibe tambien una lista de tipo elemento
     * @param tipo Tipo de este Evento
     * @param cliente Cliente asociado a este Evento
     * @param lugar Lugar asociado a este Evento
     * @param fecha Fecha de este Evento
     * @param horaInicio Hora de Inicio de este Evento
     * @param horaFin Hora Fin de este Evento
     * @param capacidad Capacidad de este Evento
     * @param planificador Planificador asociado a este Evento
     * @param elementos Elementos de este Evento
     */
    public Evento(TipoEvento tipo, Cliente cliente, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                  int capacidad, Planificador planificador, ArrayList<Elemento> elementos) {
        codigoEvento = obtainCode();
        this.tipo = tipo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidad = capacidad;
        this.planificador = planificador;
        this.cliente = cliente;
        this.estado = Estado.PENDIENTE;
        this.elementos = elementos;
    }
    
    /***
     * constructor con parametros que no recibe como parametro una lista de tipo elemento
    * @param tipo Tipo de este Evento
     * @param cliente Cliente asociado a este Evento
     * @param lugar Lugar asociado a este Evento
     * @param fecha Fecha de este Evento
     * @param horaInicio Hora de Inicio de este Evento
     * @param horaFin Hora Fin de este Evento
     * @param capacidad Capacidad de este Evento
     * @param planificador Planificador asociado a este Evento
     */
    public Evento(TipoEvento tipo, Cliente cliente, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                  int capacidad, Planificador planificador){
        codigoEvento = obtainCode();
        this.tipo = tipo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidad = capacidad;
        this.planificador = planificador;
        this.cliente = cliente;
        this.estado = Estado.PENDIENTE;
    }
    
    /***
     * constructor copia de esta clase
     * @param evento Evento del cual se van a copiar sus valores
     */
    public Evento(Evento evento){
        codigoEvento = evento.codigoEvento;
        tipo = evento.tipo;
        lugar = evento.lugar;
        fecha = evento.fecha;
        horaInicio = evento.horaInicio;
        horaFin = evento.horaFin;
        capacidad = evento.capacidad;
        planificador = evento.planificador;
        cliente = evento.cliente;
        estado = evento.estado;
        elementos = evento.elementos;
    }
    
    /***
     * constructor que recibe como parametros un string que contiene los atributos de este objeto y que han sido extraidos del archivo
     * eventos.txt
     * @param linea String extraido del archivo eventos.txt que contiene los valores de los atributos de este evento
     */
    public Evento(String linea){
        codigo++;
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        codigoEvento = delimitar.next();
        String nombre = delimitar.next();
        cliente = UIUsuario.buscarCliente(nombre);
        lugar = delimitar.next();
        String type = delimitar.next();
        switch(type){
            case "Boda":
                tipo = TipoEvento.Boda;
                break;
            case "Fiesta_Infantil":
                tipo = TipoEvento.Fiesta_Infantil;
                break;
            case "Integracion":
                tipo = TipoEvento.Integracion;
                break;
        }
        String date = delimitar.next();
        try{
        fecha = LocalDate.parse(date);
        } catch (Exception e){
            System.out.println("formato invalido");
            
        }
        String hour = delimitar.next();
        try{
            horaInicio = LocalTime.parse(hour);
        } catch(DateTimeParseException e){
            System.out.println("hora invalida!!");
        }
        hour = delimitar.next();
        try{
            horaFin = LocalTime.parse(hour);
        } catch(DateTimeParseException e){
            System.out.println("hora invalida!!");
        }
        capacidad = Integer.parseInt(delimitar.next());
        nombre = delimitar.next();
        planificador = UIUsuario.buscarPlanificador(nombre);
        String status = delimitar.next();
        if(status.equals(Estado.PENDIENTE.name())) estado = Estado.PENDIENTE;
        if(status.equals(Estado.CONFIRMADO.name())) estado = Estado.CONFIRMADO;
    }
    
    /***
     * retorna un string con el codigo del evento, cambia el formato del atributo codigo a este formato 0000
     * @return String que contiene el codigo del evento
     */
    private String obtainCode(){
        codigo++;
        String s = "";
        int digitos = String.valueOf(codigo).length();
        switch(digitos){
            case 1:
                s = "000"+codigo;
                break;
            case 2:
                s = "00"+codigo;
                break;
            case 3:
                s = "0"+codigo;
                break;
            case 4:
                s += codigo;
                break;
        }
        return s;
    }
    
    /***
     * Sobreescritura del metodo confirmar() de la interfaz confirmable y que modifica la linea del archivo eventos.txt
     */
    @Override
    public void confirmar() {
        String lineaAntigua,lineaNueva;
        lineaAntigua = this.pasarLinea();
        this.estado = Estado.CONFIRMADO;
        lineaNueva = this.pasarLinea();
        ma.modificarArchivo(lineaAntigua, lineaNueva, ManejoDeArchivos.getFILE2());
    }
    
    /***
     * Sobreescritura del metodo compareTo de la interfaz Comparable que ayuda a ordenar una lista de Eventos
     * @param e Evento a comparar de la lista
     * @return Un valor numerico que sera usado en la comparacion de la lista
     */
    @Override
    public int compareTo(Evento e){
        int r = fecha.compareTo(e.fecha);
        if (r == 0){
            r = horaInicio.compareTo(e.getHoraInicio());
            return r;
        } else {
            return r;
        }
    }
    
    /***
     * retorna un string con los atributos del objeto tipo Evento que lo invoca
     * @return Un string con los atributos del objeto
     */
    @Override
    public String toString(){
        String s = "CODIGO: "+codigoEvento+"\n"+"TIPO: "+tipo+"\n"+"LUGAR: "+lugar+"\n"+"FECHA: "+fecha+"\n"+"HORA INICIO: "+horaInicio
                +"\n"+"HORA FIN: "+horaFin+"\n"+"CAPACIDAD: "+capacidad+"\n"+"PLANIFICADOR ASIGNADO: "+planificador.getNombre()+"\n";
        return s;
    }
    
    
    public String toAgenda(){
        String s = "CODIGO: "+codigoEvento+","+"TIPO: "+tipo+","+"LUGAR: "+lugar+","+"FECHA: "+fecha+","+"HORA INICIO: "+horaInicio
                +","+"HORA FIN: "+horaFin+","+"CAPACIDAD: "+capacidad+","+"PLANIFICADOR ASIGNADO: "+planificador.getNombre();
        return s;
    }
    
    /***
     * presenta los atributos necesarios en la presentacion de los objetos tipo evento de una lista ordenada
     * @return un string con los atributos necesarios a presentar del objeto
     */
    public String presentarAtributosComparacion(){
        int minutes = (int) ChronoUnit.MINUTES.between(horaInicio,horaFin);
        int hour = (minutes/60);
        minutes = minutes % 60;
        String s = "TIPO: "+tipo+"\n"+"FECHA: "+fecha+"\n"+"LUGAR: "+lugar+"\n"+"HORA INICIO: "+horaInicio
                +"\n"+"Duracion: "+hour+" horas"+minutes+" minutos"+"\n";
        return s;
    }
    
    /***
     * retorna un string que contiene solo atributos de esta clase
     * @return Un string con los atributos del objeto
     */
    public String presentarAtributos(){
        String s = "CODIGO: "+codigoEvento+"\n"+"TIPO: "+tipo+"\n"+"LUGAR: "+lugar+"\n"+"FECHA: "+fecha+"\n"+"HORA INICIO: "+horaInicio
                +"\n"+"HORA FIN: "+horaFin+"\n"+"CAPACIDAD: "+capacidad+"\n"+"PLANIFICADOR ASIGNADO: "+planificador.getNombre()+"\n";
        return s;
    }
    
    /***
     * retorna la duracion del evento
     * @return Un valor numerico entero que indica la duracion del evento
     */
    public int obtenerDuracion(){
        return (int) ChronoUnit.MINUTES.between(horaInicio,horaFin);
    }
    
    /***
     * presenta los elementos adicionales del evento
     * @return Un String con los elementos adicionales del evento
     */
    public String presentarElementos(){
        
        String s = ""; 
        if(verificarElementos(TipoElementos.MENU,TipoElementos.BOCADITOS)){
            s += "COMIDA: "+"\n"+obtenerStringElementos(TipoElementos.MENU,TipoElementos.BOCADITOS)+"\n";
        }
        if(verificarElementos(TipoElementos.DJ,TipoElementos.BANDA)){
            s += "MUSICA: "+"\n"+obtenerStringElementos(TipoElementos.DJ,TipoElementos.BANDA)+"\n";
        }
        if(verificarElementos(TipoElementos.FOTOGRAFIA)){
            s += "FOTOGRAFIA"+"\n";
        }
        if(verificarElementos(TipoElementos.DECORACION)){
            s += "DECORACION"+"\n";
        }
        if(verificarElementos(TipoElementos.WHISKY,TipoElementos.VODKA,TipoElementos.CERVEZA,TipoElementos.REFRESCOS)){
            s += "BEBIDA: "+"\n"+obtenerStringElementos(TipoElementos.WHISKY,TipoElementos.VODKA,
                    TipoElementos.CERVEZA,TipoElementos.REFRESCOS)+"\n";
        }
        if(verificarElementos(TipoElementos.ANIMADOR)){
            s += "ANIMADOR ASIGNADO: "+obtenerStringElementos(TipoElementos.ANIMADOR)+"\n";
        }
        
        return s;
    } 
    
    /***
     * verifica los tipos de elementos que tiene la lista del evento
     * @param tipos Cantidad de tipos variables a comparar
     * @return true si los elementos se encuetran en la lista elementos del objeto que lo invoca
     */
    public boolean verificarElementos(TipoElementos...tipos){
        for(int i=0; i<tipos.length;i++){
            for(Elemento elemento: elementos){
                if(elemento.getElemento().equals(tipos[i])){
                    return true;
                }
            }
        }
        return false;
    }
    
    /***
     * Obtiene el string con los atributos del elementos que coincidan con los parametros enviados en este metodo
     * @param tipos
     * @return 
     */
    public String obtenerStringElementos(TipoElementos... tipos) {
        String s = "";
        for (int i = 0; i < tipos.length; i++) {
            for (Elemento elemento : elementos) {
                if (elemento.getElemento().equals(tipos[i])) {
                    if (tipos[i].equals(TipoElementos.ANIMADOR)) {
                        Animador animador = (Animador) elemento;
                        s += animador.getNombre();
                    } else {
                        s += elemento.toString();
                        break;
                    }
                }
            }
        }
        return s;
        
    }
    
    /***
     * muestra en un string los atributos de esta lista
     * @return string con los atributos de esta lista de eventos
     */
    public String pasarLinea(){
        return this.codigoEvento + "," + this.cliente.getNombre() + "," +lugar+ "," + this.tipo + "," + this.fecha + "," + this.horaInicio + "," 
                + this.horaFin + "," + this.capacidad + "," + this.planificador.getNombre() + "," + this.estado;
    }
    
    /***
     * get del atributo codigoEvento
     * @return codigoEvento
     */
    public String getCodigoEvento() {
        return codigoEvento;
    }

    /***
     * set del atributo codigoEvento
     * @param codigoEvento codigoEvento
     */
    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }
 
    /***
     * get del atributo tipo
     * @return tipo 
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /***
     * set del atributo tipo
     * @param tipo tipo
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    /***
     * get del atributo agenda
     * @return agenda
     */
    public Agenda getAgenda() {
        return agenda;
    }

    /***
     * set del atributo agenda
     * @param agenda agenda
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    /***
     * get del atributo elementos
     * @return arreglo de elementos
     */
    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    /***
     * set del atributo elementos
     * @param elementos arreglo de elementos
     */
    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    /***
     * get del atributo lugar
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /***
     * set del atributo lugar
     * @param lugar lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /***
     * get del atributo fecha
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /***
     * set del atributo fecha
     * @param fecha fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /***
     * get del atributo horaInicio
     * @return horaInicio
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /***
     * set del atributo horaInicio
     * @param horaInicio horaInicio
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /***
     * get del atributo horaFin
     * @return horaFin
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /***
     * set del atributo horaFin
     * @param horaFin horaFin
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    /***
     * get del atributo capacidad
     * @return capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /***
     * set del atributo capacidad
     * @param capacidad capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /***
     * get del atributo getPlanificador
     * @return planificador
     */
    public Planificador getPlanificador() {
        return planificador;
    }
    
    /***
     * set del atributo getPlanificador
     * @param planificador planificador
     */
    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }

    /***
     * get del atributo getCliente
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /***
     * set del atributo getCliente
     * @param cliente cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /***
     * get del atributo getEstado
     * @return estado
     */
    public Estado getEstado() {
        return estado;
    }

    /***
     * set del atributo getEstado
     * @param estado estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }


   
    
    
    
    
}
