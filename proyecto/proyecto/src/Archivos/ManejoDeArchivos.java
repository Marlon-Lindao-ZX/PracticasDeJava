/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CORE I7
 */
/**
 * *
 * Metodo Constructor de ManejoArchivos
 *
 * @author Marinchi
 */
public class ManejoDeArchivos {

    private final static File FILE1 = new File("src/Archivos/usuarios.txt");
    private final static File FILE2 = new File("src/Archivos/eventos.txt");
    private final static File FILE3 = new File("src/Archivos/elementos.txt");
    private final static File FILE4 = new File("src/Archivos/agenda.txt");
    private final static File FILE5 = new File("src/Archivos/pagos.txt");
    private final static File FILE6 = new File("src/Archivos/animadores.txt");

    public ManejoDeArchivos() {
    }

    /***
     * Metodo para leer las lineas de un archivo y que retorna una lista de
     * strings que sera usado para la instanciacion de objetos de la clase
     * correspondiente
     * @param file Objeto tipo File que contiene la ruta del archivo a trabajar
     * @return Una lista de Strings extraidos del archivo leido
     */
    public ArrayList<String> leerArchivo(File file) {
        ArrayList<String> lineas = new ArrayList<>();
        Scanner scanner;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                lineas.add(linea);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lineas;

    }

    /***
     * Metodo que recibe un string que contiene los atributos de un objeto y que
     * lo guarda en su archivo respectivo
     * @param linea String que contiene los datos a guardar en el archivo
     * @param file Objeto tipo File que contiene la ruta del archivo a trabajar
     */
    public void escribirArchivo(String linea, File file) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(file, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(linea + "\n");

            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   

    /***
     * Metodo que actualiza los datos del archivo correspondiente definido por el objeto tipo File, segun las modificaciones 
     * realizadas durante la ejecucion del programa
     * @param lineaAntigua String de la linea del archivo a buscar en el archivo
     * @param lineaNueva String de la linea del archivo a modificar en el archivo
     * @param file Objeto tipo File que contiene la ruta del archivo a trabajar
     */
    public void modificarArchivo(String lineaAntigua, String lineaNueva, File file) {
        try {

            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String result = "";
            String linea;
            while ((linea = bfr.readLine()) != null) {
                if (linea.toUpperCase().trim().equals(lineaAntigua.toUpperCase().trim())) {
                    result += lineaNueva + "\n";
                } else {
                    result += linea + "\n";
                }
            }
            bfr.close();
            RandomAccessFile archivo = new RandomAccessFile(file.getPath(), "rw");
            archivo.seek(0);
            archivo.writeBytes(result);
            archivo.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***
     *  get que retorna la ruta del archivo usuarios.txt
     * @return El objeto tipo File que contiene la ruta del archivo usuarios.txt
     */
    public static File getFILE1() {
        return FILE1;
    }

    /***
     *  get que retorna la ruta del archivo eventos.txt
     * @return El objeto tipo File que contiene la ruta del archivo eventos.txt
     */
    public static File getFILE2() {
        return FILE2;
    }

    /***
     *  get que retorna la ruta del archivo elementos.txt
     * @return El objeto tipo File que contiene la ruta del archivo elementos.txt
     */
    public static File getFILE3() {
        return FILE3;
    }

    /***
     *  get que retorna la ruta del archivo agenda.txt
     * @return El objeto tipo File que contiene la ruta del archivo agenda.txt
     */
    public static File getFILE4() {
        return FILE4;
    }

    /***
     *  get que retorna la ruta del archivo pagos.txt
     * @return El objeto tipo File que contiene la ruta del archivo pagos.txt
     */
    public static File getFILE5() {
        return FILE5;
    }

    /***
     * get que retorna la ruta del archivo animadores.txt
     * @return El objeto tipo File que contiene la ruta del archivo animadores.txt
     */
    public static File getFILE6() {
        return FILE6;
    }

}
