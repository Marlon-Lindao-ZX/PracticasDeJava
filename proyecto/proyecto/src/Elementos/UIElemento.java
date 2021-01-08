/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Archivos.ManejoDeArchivos;
import Constantes.TipoElementos;
import Constantes.TipoEvento;
import Eventos.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que contiene un atributo de tipo lista de elementos que contiene todos los elementos adicionales y propios de un evento
 * @author CORE I7
 */
public class UIElemento {

    private static Scanner leer = new Scanner(System.in);
    private static ManejoDeArchivos write = new ManejoDeArchivos();
    private UIElementoMenu option = new UIElementoMenu();
    private static ArrayList<Elemento> elementos = new ArrayList<>();
    private static ArrayList<Animador> animadores = new ArrayList<>();

    /***
     * metodo para crear los elementos adicionales de un evento
     * @param evento
     * @return 
     */
    public ArrayList<Elemento> crearElemento(Evento evento) {
        ArrayList<Elemento> resultado = new ArrayList<>();
        ArrayList<Elemento> retorno;
        String opcion;
        boolean control, control2;
        control = true;
        while (control) {
            Elemento elemento;
            System.out.println("¿Desea agregar elementos adicionales? (S/N)");
            System.out.print("Digite S para agregar elementos adicionales o N para salir: ");
            opcion = leer.nextLine();
            switch (opcion) {
                case "S":
                    control2 = true;
                    while (control2) {
                        System.out.println("Las opciones son: ");
                        System.out.println("1. Comida");
                        System.out.println("2. Musica");
                        System.out.println("3. Fotografias");
                        System.out.println("4. Decoracion");
                        System.out.println("5. Bebida");
                        System.out.println("6. Animador");
                        System.out.println("7. Regresar al menu anterior");
                        System.out.println("");
                        System.out.print("Digite su opcion: ");
                        opcion = leer.nextLine();
                        switch (opcion) {
                            case "1":
                                 retorno = option.menuComida(resultado,evento);
                                 if(!retorno.isEmpty()) resultado = agregarElementosOtraLista(retorno,resultado);
                                break;
                            case "2":
                                retorno = option.menuMusica(resultado,evento);
                                if(!retorno.isEmpty()) resultado = agregarElementosOtraLista(retorno,resultado);
                                break;
                            case "3":
                                elemento = option.menuFotografias(resultado,evento);
                                if(elemento != null) resultado.add(elemento);
                                break;
                            case "4":
                                elemento = option.menuDecoracion(resultado,evento);
                                if(elemento != null) resultado.add(elemento);
                                break;
                            case "5":
                                retorno = option.menuBebida(resultado,evento);
                                if(!retorno.isEmpty()) resultado = agregarElementosOtraLista(retorno,resultado);
                                break;
                            case "6":
                                elemento = option.menuAnimador(resultado,evento);
                                if(elemento != null) resultado.add(elemento);
                                break;
                            case "7":
                                control2 = false;
                                break;
                            default:
                                System.out.println("opcion invalida");
                                break;

                        }
                    }
                    break;
                case "N":
                    return resultado;
                default:
                    System.out.println("opcion invalida");
            }

        }
        return resultado;
    }

    
    /***
     * verifica que la lista tenga un elemento con el tipo de elementos igual al enviado como paramatro
     * @param elementos elementos
     * @param tipo tipo de elementos
     * @return true si el elemento coincide
     */
    public boolean verificarElemento(ArrayList<Elemento> elementos, TipoElementos tipo){
        
        for(Elemento elemento: elementos){
            if(elemento.getElemento() == tipo){
                return true;
            }
        }
        return false;
    }
    
    /***
     * verifica que las dos listas que se envian como parametros, tenga un elemento con el tipo de elementos igual 
     * al enviado como paramatro
     * @param elementos1 arreglo de elementos
     * @param elementos2 arreglo de elementos
     * @param tipo tipo de elementos
     * @return true si es el elemento
     */
    public boolean verificarElemento(ArrayList<Elemento> elementos1,ArrayList<Elemento> elementos2, TipoElementos tipo){
        
        if (!elementos1.isEmpty()) {
            for (Elemento elemento : elementos1) {
                if (elemento.getElemento() == tipo) {
                    return true;
                }
            }
        }
        
        for(Elemento elemento: elementos2){
            if(elemento.getElemento() == tipo){
                return true;
            }
        }
        
        return false;
            
    }
    
    /***
     * añade los elementos de una lista a la otra lista
     * @param lista1 arreglo de elementos
     * @param lista2 arreglo de elementos
     * @return arreglo de elementos
     */
    public ArrayList<Elemento> agregarElementosOtraLista(ArrayList<Elemento> lista1, ArrayList<Elemento> lista2){
        for (Elemento elemento: lista1){
            lista2.add(elemento);
        }
        return lista2;
        
    }
    
    /***
     * añade los elementos de la lista enviada como parametros a la lista de esta clase UIElemento
     * @param lista arreglo de elementos
     */
    public void agregarElementosOtraLista(ArrayList<Elemento> lista){
        for(Elemento elemento: lista){
            elementos.add(elemento);
        }
        
    }
    
    /***
     * añade el elemento enviado como parametro a la lista de esta clase UIElemento 
     * @param elemento elemento
     */
    public void agregarElementoALista(Elemento elemento){
        elementos.add(elemento);
        
    }
    
    /***
     * escribe en el archivo el string que contiene los atributos de un elemento, al archivo elementos.txt
     * @param linea atributos de un elemento
     */
    public static void escribirElemento(String linea){
        write.escribirArchivo(linea, ManejoDeArchivos.getFILE3());
    }
    
    /***
     * carga los elementos al iniciar el programa con la lista de strings obtenida en la lectura del archivo elementos.txt
     * @param lista lista de strings obtenida en la lectura del archivo elementos.txt
     */
    public static void cargarElementos(ArrayList<String> lista) {
        Elemento elemento;
        for (String linea : lista) {
            char[] array = linea.toCharArray();
            int contador, index;
            contador = index = 0;
            for (int i = 0; i < array.length; i++) {
                char c = array[i];
                if (c == ',') {
                    contador++;
                    if (contador == 4) {
                        index = i;
                    }
                }
            }

            if (contador <= 4) {
                elemento = new Elemento(linea);
                elementos.add(elemento);
            } else {
                String linea1, linea2;
                linea1 = linea.substring(0, index - 1);
                linea2 = linea.substring(index + 1);
                elemento = new Elemento(linea1);
                elemento = new Animador(elemento, linea2);
                elementos.add(elemento);

            }
        }

    }
    
    /***
     * Carga los animadores
     * @param lista lista de animadores
     */
    public static void cargarAnimadores(ArrayList<String> lista){
        for(String linea: lista){
            Animador animador = new Animador(linea);
            animadores.add(animador);
        }
        
    }
    
    /***
     * Muestra los animadores disponibles
     * @param tipo tipo de evento
     */
    public static void mostrarAnimadoresDisponibles(TipoEvento tipo){
        for(Animador animador: animadores){
            if((animador.getTipo()) == tipo || (animador.getTipo() == TipoEvento.Otros))
                System.out.println(animador);
        }
    }
    
    /***
     * Obtiene el animador
     * @param nombre nombre del animador
     * @return el animador
     */
    public static Animador obtenerAnimador(String nombre){
        for(Animador animador: animadores){
            if(animador.getNombre().equals(nombre)){
                return animador;
            }
        }
        return null;
    }

    /***
     * get que devuelve la lista de esta clase UIEvento
     * @return arreglo de elementos
     */
    public static ArrayList<Elemento> getElementos() {
        return elementos;
    }

    /***
     * set que actualiza la lista de esta clase UIEvento con la lista enviada como parametros 
     * @param elementos 
     */
    public static void setElementos(ArrayList<Elemento> elementos) {
        UIElemento.elementos = elementos;
    }

    /***
     * Obtiene los animadores
     * @return arreglo de animadores
     */
    public static ArrayList<Animador> getAnimadores() {
        return animadores;
    }

    /***
     * Setea los animadores
     * @param animadores arreglo de animadores
     */
    public static void setAnimadores(ArrayList<Animador> animadores) {
        UIElemento.animadores = animadores;
    }
    
    
    
    
}
