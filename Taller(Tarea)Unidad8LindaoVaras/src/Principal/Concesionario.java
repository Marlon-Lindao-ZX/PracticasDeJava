/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

/**
 *
 * @author CORE I7
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Auto> autos = new ArrayList<>();
        ArrayList<Auto> nuevoAutos = new ArrayList<>();
        ArrayList<Auto> autosJSON = new ArrayList<>();
        ArrayList<Auto> autosXML = new ArrayList<>();

        try {
            File[] files = new File[3];
            files[0] = new File("src/Fuentes/serial.json");
            files[1] = new File("src/Fuentes/serial.bin");
            files[2] = new File("src/Fuentes/serial.xml");

            for (File file : files) {
                if (file.createNewFile()) {
                    System.out.println("file " + file.getName() + " created");
                } else {
                    System.out.println("file " + file.getName() + " not created");
                }
            }

            Auto auto1 = new Auto("Mercedes Benz", "Gris", "2016", "AMG Berlina", "Berlina");
            Auto auto2 = new Auto("Hyundai", "Rojo", "2017", "Santa Fe", "HatchBack");

            autos.add(auto1);
            autos.add(auto2);

            escribirListaEnArchivo(autos);
            escribirAJSON(autos);
            escribirAXML(autos);

            nuevoAutos = leerLista();
            autosJSON = leerDeJSON();
            autosXML = leerDeXML();

        } catch (FileNotFoundException ex) {

            System.out.println(ex.getMessage());

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        } finally {

            System.out.println("De archivo Binario");
            for (Auto auto : nuevoAutos) {
                System.out.println(auto);
            }

            System.out.println("De archivo json");
            for (Auto auto : autosJSON) {
                System.out.println(auto);
            }

            System.out.println("De archivo xml");
            for (Auto auto : autosXML) {
                System.out.println(auto);
            }
        }

    }

    public static void escribirListaEnArchivo(ArrayList<Auto> autos) throws FileNotFoundException, IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Fuentes/serial.bin", false))) {
            for (Auto auto : autos) {
                oos.writeObject(auto);
            }
            oos.flush();
            System.out.println("lista guardada en archivo binario");
        }
    }

    public static ArrayList<Auto> leerLista() throws FileNotFoundException, IOException {
        ArrayList<Auto> retorno = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Fuentes/serial.bin"))) {
            try {
                while (true) {
                    retorno.add((Auto) ois.readObject());
                }
            } catch (EOFException ex) {
                System.out.println("lista de archivo binario leida");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return retorno;
        }
    }

    public static void escribirAJSON(ArrayList<Auto> autos) throws FileNotFoundException, IOException {
        ObjectMapper mapper = JsonFactory.create();
        mapper.writeValue(new FileOutputStream("src/Fuentes/serial.json"), autos);
        System.out.println("lista guardada en archivo json");
    }

    public static ArrayList<Auto> leerDeJSON() throws FileNotFoundException, IOException {
        try (FileInputStream input = new FileInputStream("src/Fuentes/serial.json")) {

            ObjectMapper mapper = JsonFactory.create();
            ArrayList<Auto> retorno = mapper.readValue(input, ArrayList.class, Auto.class);
            System.out.println("lista de archivo json leida");
            return retorno;

        }

    }

    public static void escribirAXML(ArrayList<Auto> autos) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("src/Fuentes/serial.xml", false)) {

            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("auto", Auto.class);


                xstream.toXML(autos, fos);

            System.out.println("lista guardada en archivo xml");

        }
    }

    public static ArrayList<Auto> leerDeXML() throws IOException {
        ArrayList<Auto> retorno = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("src/Fuentes/serial.xml")) {

            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("auto", Auto.class);

            retorno = (ArrayList<Auto>) xstream.fromXML(fis);

            System.out.println("lista de archivo xml leida");
            
        } catch(XStreamException ex){
            
        }finally{

            return retorno;
        }
    }

}
