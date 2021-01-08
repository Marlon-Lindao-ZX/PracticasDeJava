package Elementos;

import Constantes.TipoElementos;
import Eventos.*;
import java.util.Scanner;




/**
 * Atributos de la clase Elemento con los modificadores de acceso
 * aqui se encuentran los atributos de cada elemento adicional
 * @author Alex
 */
public class Elemento {
    private TipoElementos elemento;
    private Evento evento;
    private int cantidad;
    private double precioTotal;
    private boolean transporte;
    private String tipoVehiculo;
    private int cantidadPersonasDisfrazadas;
    private int cantidadSorpresasRepartir;
    private boolean adicionJuegosInfantiles;
    private int cantidadPersonasTransportar;
    
    /***
     * Constructor vacio de Elemento
     */
    
    public Elemento() {}
    
    /***
     * Metodo Constructor de Elemento
     * @param elemento
     * @param cantidad
     * @param evento 
     */
/***
 * Constructor de Elemento
 * @param elemento tipo de elemento
 * @param cantidad cantidad de elemento
 * @param evento evento
 */
    public Elemento(TipoElementos elemento, int cantidad, Evento evento) {
        this.evento = evento;
        this.elemento = elemento;
        this.cantidad = cantidad;
        if (this.elemento == TipoElementos.BOCADITOS) {
            precioTotal = (cantidad/100)*elemento.getPrecio();
        } else {
            precioTotal = cantidad * elemento.getPrecio();
        }
    }
    
    /***
     * Constructor de elemento
     * @param elemento tipos de elementos
     * @param evento evento
     */
    
    public Elemento(TipoElementos elemento, Evento evento){
        this.evento = evento;
        this.elemento = elemento;
        cantidad = 1;
        precioTotal = cantidad*elemento.getPrecio();
        
    }
    
    /***
     * Constructor Copia de esta clase Elemento
     * @param elemento elemento
     */
    public Elemento(Elemento elemento){
        evento = elemento.getEvento();
        this.elemento = elemento.getElemento();
        cantidad = 1;
        precioTotal = cantidad*this.elemento.getPrecio();
    }
    
    /***
     * constructor que recibe un objeto de tipo Boda para su inicializacion
     * usado para guardar en el archivo elementos.txt los atributos de boda
     * @param boda  boda
     */
    
    public Elemento(Boda boda){
        evento = boda;
        tipoVehiculo = boda.getTipoVehiculo();
    }
    
    /***
     * constructor que recibe un objeto de tipo FiestaInfantil para la inicializacion de sus atributos
     * usado para guardar en el archivo elementos.txt los atributos de FiestaInfantil
     * @param fiestaInfantil fiesta infantil
     */
    public Elemento(FiestaInfantil fiestaInfantil){
        evento = fiestaInfantil;
        cantidadPersonasDisfrazadas = fiestaInfantil.getCantidadPersonasDisfrazadas();
        cantidadSorpresasRepartir = fiestaInfantil.getCantidadSorpresasRepartir();
        adicionJuegosInfantiles = fiestaInfantil.isAdicionJuegosInfantiles();
    }
    
    /***
     * constructor que recibe un objeto de tipo Integracion para la inicializacion de sus atributos
     * usado para guardar en el archivo elementos.txt los atributos de Integracion
     * @param integracion integracion
     */
    public Elemento(Integracion integracion){
        evento = integracion;
        transporte = integracion.isTransporte();
        cantidadPersonasTransportar = integracion.getCantidadPersonasTransportar();
    }
    
    /***
     * constructor que recibe una linea del archivo .txt correspondiente a este objeto, y que lo usa
     * para inicializar sus valores
     * @param linea linea
     */
    public Elemento(String linea){
        Scanner delimitar = new Scanner(linea);
        delimitar.useDelimiter("\\s*,\\s*");
        char[] array = linea.toCharArray();
        int contador = 0;
        for(char c: array){
            if(c == ',') contador++;    
        }
        switch(contador){
            case 1:
                String codigo = delimitar.next();
                evento = UIEventos.obtenerEvento(codigo);
                tipoVehiculo = delimitar.next();
                break;
            case 2:
                codigo = delimitar.next();
                evento = UIEventos.obtenerEvento(codigo);
                transporte = delimitar.nextBoolean();
                cantidadPersonasTransportar = delimitar.nextInt();
                break;
            case 3:
                codigo = delimitar.next();
                evento = UIEventos.obtenerEvento(codigo);
                String tipo = delimitar.next();
                switch (tipo) {
                    case "MENU":
                        elemento = TipoElementos.MENU;
                        break;
                    case "BOCADITOS":
                        elemento = TipoElementos.BOCADITOS;
                        break;
                    case "DJ":
                        elemento = TipoElementos.DJ;
                        break;
                    case "BANDA":
                        elemento = TipoElementos.BANDA;
                        break;
                    case "WHISKY":
                        elemento = TipoElementos.WHISKY;
                        break;
                    case "VODKA":
                        elemento = TipoElementos.VODKA;
                        break;
                    case "CERVEZA":
                        elemento = TipoElementos.CERVEZA;
                        break;
                    case "REFRESCOS":
                        elemento = TipoElementos.REFRESCOS;
                        break;
                    case "FOTOGRAFIA":
                        elemento = TipoElementos.FOTOGRAFIA;
                        break;
                    case "DECORACION":
                        elemento = TipoElementos.DECORACION;
                        break;
                    case "ANIMADOR":
                        elemento = TipoElementos.ANIMADOR;
                        break;
                }
                cantidad = delimitar.nextInt(); 
                precioTotal = Double.parseDouble(delimitar.next());
                break;
            case 4:
                codigo = delimitar.next();
                evento = UIEventos.obtenerEvento(codigo);
                cantidadPersonasDisfrazadas = delimitar.nextInt();
                cantidadSorpresasRepartir = delimitar.nextInt();
                adicionJuegosInfantiles = delimitar.nextBoolean();
                break; 
        }
    }


    /***
     * retorna los atributos de esta clase en un String
     * @return String con los atributos de elemento
     */
    @Override
    public String toString(){
        String s = "                ";
        switch(elemento){
            case MENU:
                s += elemento+" "+cantidad+" PERSONAS"+"\n";
                return s;
            case BOCADITOS:
                s += elemento+" "+cantidad+"\n";
                return s;
            case DJ:
                s += elemento+"\n";
                return s;
            case BANDA:
                s += elemento+"\n";
                return s;
            case WHISKY:
                s += elemento+" "+cantidad+" BOTELLAS"+"\n";
                return s;
            case VODKA:
                s += elemento+" "+cantidad+" BOTELLAS"+"\n";
                return s;
            case CERVEZA:
                s += elemento+" "+cantidad+" BOTELLAS"+"\n";
                return s;
            case REFRESCOS:
                s += elemento+" "+cantidad+" BOTELLAS"+"\n";
                return s;
            case ANIMADOR:
                break;
        }
        return s;
    }
    
    /***
     * retorna en un string los atributos del elemento adicional
     * @return 
     */
    public String pasarLineaElementoAdicional() {
        return this.evento.getCodigoEvento() + "," + elemento + "," + cantidad + "," + precioTotal;
    }
    
    /***
     * retorna en un string los atributos de la boda
     * @return atributos de la boda
     */
    public String pasarLineaElementoBoda(){
        return this.evento.getCodigoEvento() + "," + tipoVehiculo;
    }
    
    /***
     * retorna en un string los atributos de la FiestaInfantil
     * @return atributos de la FiestaInfantil
     */
    public String pasarLineaElementoFiestaInfantil(){
        return this.evento.getCodigoEvento() + ","+ cantidadPersonasDisfrazadas + "," + cantidadSorpresasRepartir + ","
                + adicionJuegosInfantiles + "," + "fiestainfantil";
    }
    
    /***
     * retorna en un string los atributos de la Integracion
     * @return atributos de la Integracion
     */
    public String pasarLineaElementoIntegracion(){
        return this.evento.getCodigoEvento() + ","+transporte + "," + cantidadPersonasTransportar;
    }
    
    /***
     * Metodo getter muestra el valor de Elemento
     * @return valor de Elemento
     */

    public TipoElementos getElemento() {
        return elemento;
    }
    
    /***
     * Metodo setter asigna el parametro de Elemento
     * @param elemento parametro de Elemento
     */

    public void setElemento(TipoElementos elemento) {
        this.elemento = elemento;
    }
    
    /***
     * Metodo getter muestra el valor de cantidad
     * @return  valor de cantidad
     */


    public int getCantidad() {
        return cantidad;
    }
    
    /***
     * Metodo setter asigna el parametro de Cantidad
     * @param cantidad cantidad 
     */

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /***
     * Obtiene el atributo evento
     * @return evento
     */
    public Evento getEvento() {
        return evento;
    }

    /***
     * Setea el atributo evento
     * @param evento evento
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    /***
     * Metodo getter muestra el valor de PrecioTotal
     * @return precio total
     */

    public double getPrecioTotal() {
        return precioTotal;
    }
    
    /***
     * Metodo setter asigna el parametro de PrecioTotal
     * @param precioTotal precio total
     */

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /***
     * Obtiene el atributo transporte
     * @return si tiene transporte
     */
    public boolean isTransporte() {
        return transporte;
    }

    /***
     * Setea el atributo transporte
     * @param transporte transporte
     */
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }
    
    /***
     * Metodo getter muestra el valor de TipoVehiculo
     * @return vehiculo
     */

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    
    /***
     * Metodo setter asigna el parametro de TipoVehiculo
     * @param tipoVehiculo tipo de vehiculo
     */

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /***
     * Obtiene del atributo CantidadPersonasDisfrazadas
     * @return cantidad de personas disfrazadas
     */
    public int getCantidadPersonasDisfrazadas() {
        return cantidadPersonasDisfrazadas;
    }

    /***
     * Setea el atributo CantidadPersonasDisfrazadas
     * @param cantidadPersonasDisfrazadas cantidad de personas disfrazadas
     */
    public void setCantidadPersonasDisfrazadas(int cantidadPersonasDisfrazadas) {
        this.cantidadPersonasDisfrazadas = cantidadPersonasDisfrazadas;
    }

    /***
     * get del atributo cantidadSorpresasRepartir
     * @return cantidad de sorpresas a repartir
     */
    public int getCantidadSorpresasRepartir() {
        return cantidadSorpresasRepartir;
    }

    /***
     * set del atributo cantidadSorpresasRepartir
     * @param cantidadSorpresasRepartir cantidad de sorpresas a repartir
     */
    public void setCantidadSorpresasRepartir(int cantidadSorpresasRepartir) {
        this.cantidadSorpresasRepartir = cantidadSorpresasRepartir;
    }

    /***
     * get del atributo adicionJuegosInfantiles
     * @return true si adiciona juegos infantiles
     */
    public boolean isAdicionJuegosInfantiles() {
        return adicionJuegosInfantiles;
    }

    /***
     * set del atributo adicionJuegosInfantiles
     * @param adicionJuegosInfantiles adiciona juegos infantiles
     */
    public void setAdicionJuegosInfantiles(boolean adicionJuegosInfantiles) {
        this.adicionJuegosInfantiles = adicionJuegosInfantiles;
    }

    /***
     * get del atributo cantidadPersonasTransportar
     * @return cantidad de personas a transportar
     */
    public int getCantidadPersonasTransportar() {
        return cantidadPersonasTransportar;
    }

    /***
     * set del atributo cantidadPersonasTransportar
     * @param cantidadPersonasTransportar cantidad de personas a transportar
     */
    public void setCantidadPersonasTransportar(int cantidadPersonasTransportar) {
        this.cantidadPersonasTransportar = cantidadPersonasTransportar;
    }

      
    
}
