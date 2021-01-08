/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import static Eventos.UIEventos.stringToLocalDate;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.System;

/**
 *
 * @author CORE I7
 */
public class Validaciones {

    /***
     * Metodo que verifica si un string contiene solo caracteres numericos
     * @param cadena String a verificar
     * @return true si solo esta compuesto por caracteres numericos, false caso contrario
     */
    public boolean esNumerico(String cadena) {
        if (verificarCantidadCaracteres(cadena)) {
            try {
                Integer.parseInt(cadena);
                System.out.println("El dato ingresado es solo numero");
                System.out.println("El sistema no acepta oraciones que solo tenga numeros");
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        } else {
            System.out.println("Ingrese una palabra o frase que contenga mas de dos caracteres");
            return true;
        }
    }


    /***
     * Verifica si el string enviado como parametro es un formato de fecha valida 
     * @param cadena El string a convertir a un objeto tipo LocalDate
     * @return Un objeto tipo LocalDate si el formato del string es valido por el metodo, caso contrario retorna
     * un null
     */
    public LocalDate esFechaValida(String cadena) {
        LocalDate fecha = stringToLocalDate(cadena);
        if (fecha == null) {
            System.out.println("fecha invalida!!");
            return null;
        } else {
            return fecha;
        }
    }

    /***
     * Verifica si el string enviado como parametro es un formato de hora valida 
     * @param cadena El string a convertir a un objeto tipo LocalTime
     * @return Un objeto tipo LocalTime si el formato del string es valido por el metodo, caso contrario retorna null
     */
    public LocalTime esHoraValida(String cadena) {
        try {
            LocalTime hora = LocalTime.parse(cadena);
            if (hora == null) {
                System.out.println("Hora invalida!!");
                return null;
            } else {
                return hora;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Hora inválida");
            return null;
        }
    }

    /***
     * Metodo que pide ingresar un numero y verifica que no reciba datos erroneos
     * @return El numero ingresado si no habido problemas de excepcion por el mal ingreso de datos, caso contrario 
     * retorna un -1
     */
    public int esUnNumeroValido() {
        Scanner sc = new Scanner(System.in);
        try {
            int num = sc.nextInt();
            return num;
        } catch (InputMismatchException ime) {
            System.out.println("Cuidado!!, dato ingresado no es un numero");
            System.out.println("Solo puede ingresar numero");
            return -1;
        }
    }

    /***
     * Verifica que el String contenga solo caracteres de letra o espacio
     * @param cadena String a revisar si contiene caracteres numericos o simbolicos
     * @return true Si el string comparado contiene numeros o simbolos o contenga menos de dos caracteres
     * , false caso contrario
     */
    public boolean tieneNumerosOSimbolos(String cadena) {
        if (verificarCantidadCaracteres(cadena)) {
            Pattern patron = Pattern.compile("[^A-Za-z ]");
            Matcher encaja = patron.matcher(cadena);

            if (encaja.find()) {
                System.out.println("Esta secuencia tiene numeros o simbolos!!");
                System.out.println("Vuelva a escribir una secuencia de texto sin numeros o simbolos!!");
                return true;
            }

            return false;
        } else {
            System.out.println("Ingrese una palabra o frase que contenga mas de dos caracteres");
            return true;
        }
    }

    /***
     * Verifica si el string esta compuesto por solo 2 caracteres o menos
     * @param cadena El string que se va a contar los caracteres que tiene
     * @return true si esta compuesto por 3 caracteres o mas, false caso contrario
     */
    public boolean verificarCantidadCaracteres(String cadena) {
        if (cadena.length() > 2) {
            return true;
        } else {
            return false;
        }
    }

}
