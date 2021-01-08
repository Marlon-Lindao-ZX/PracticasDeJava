/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializar;

/**
 *
 * @author sandra
 */
import java.io.FileInputStream;  
import java.io.IOException;  
  
import org.xml.sax.InputSource;  
import org.xml.sax.SAXException;  
import org.xml.sax.XMLReader;  
import org.xml.sax.helpers.XMLReaderFactory;  
import serializar.controlador.ManejadorLibro;
import serializar.modelo.Libro;
  




public class DeserializarSAX{  
  
   public static void main(String[] args) {  
        
      try {  
         // Creamos nuestro objeto libro vacío  
         Libro libro = new Libro();  
         // Creamos la factoria de parseadores por defecto  
         XMLReader reader = XMLReaderFactory.createXMLReader();  
         // Añadimos nuestro manejador al reader pasandole el objeto libro  
         reader.setContentHandler(new ManejadorLibro(libro));           
         // Procesamos el xml de ejemplo  
         reader.parse(new InputSource(new FileInputStream("libros.xml")));  
         // Ya tenemos nuestro objeto libro con los valores obtenidos del xml  
         // Lo imprimimos  
         System.out.println(libro.toString());           
      } catch (SAXException e) {  
         e.printStackTrace();  
      } catch (IOException e) {  
         e.printStackTrace();  
      }  
  
   }  
  
}  