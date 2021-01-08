/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializar.modelo;

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
  
/** 
 * Clase que procesa un XML de un libro mediante el handler SAX ManejadorLibro 
 *  
 * @author Xela 
 * 
 */  
  
  
   public class Libro {  
     
   private String isbn = null;  
   private String titulo = null;  
   private String autor = null;  
   private String anyo = null;  
   private String editorial = null;  
     
   // Constructor por defecto  
   public Libro() {  
        
   }  
     
   public String getIsbn() {  
      return isbn;  
   }  
     
   public void setIsbn(String isbn) {  
      this.isbn = isbn;  
   }  
     
   public String getTitulo() {  
      return titulo;  
   }  
     
   public void setTitulo(String titulo) {  
      this.titulo = titulo;  
   }  
     
   public String getAutor() {  
      return autor;  
   }  
     
   public void setAutor(String autor) {  
      this.autor = autor;  
   }  
     
   public String getAnyo() {  
      return anyo;  
   }  
     
   public void setAnyo(String anyo) {  
      this.anyo = anyo;  
   }  
     
   public String getEditorial() {  
      return editorial;  
   }  
     
   public void setEditorial(String editorial) {  
      this.editorial = editorial;  
   }  
  
   @Override  
   public String toString() {  
      StringBuilder sb = new StringBuilder();  
      sb.append("\nISBN: "+isbn);  
      sb.append("\nTítulo: "+titulo);  
      sb.append("\nAutor: "+autor);  
      sb.append("\nAño: "+anyo);  
      sb.append("\nEditorial: "+editorial);  
        
      return sb.toString();  
   }  

}  
