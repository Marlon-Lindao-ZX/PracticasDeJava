/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User-pc
 */
public class PantallaBusquedaController implements Initializable {

    @FXML
    private Button btnsearch;
    @FXML
    private MenuItem comprimir;
    @FXML
    private MenuItem descomprimir;
    @FXML
    private TextField textSeleccionado;
    String[] s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
@FXML
    private void searchFile(ActionEvent event) {
        FileChooser fc=new FileChooser();
        File seleccionar=fc.showOpenDialog(null);
        if(seleccionar!=null){
            textSeleccionado.setText(seleccionar.getAbsolutePath());
        }else{
           JOptionPane.showMessageDialog(null, "Archivo no seleccionado", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
           textSeleccionado.setText("");
            }
    }
    
    @FXML
    private void comprimirFile(ActionEvent event) {
       Util u = new Util();
       try{
        ArbolHuffman a = new ArbolHuffman();        
                    String texto = u.leerTexto(textSeleccionado.getText());
                    System.out.println("Texto por comprimir: "+texto);
                    //frecuencias del archivo. creo arbol Huffman. peso del archivo en bytes
                    HashMap<String,Integer> frecuencias = u.calcularFrecuencias(u.leerTexto(textSeleccionado.getText()));
                    Node nodoraiz = a.calcularArbol(frecuencias);
                    System.out.println("Peso en bytes de archivo por comprimir: "+nodoraiz.getInfo().getFrec());

                                        //CODIFICO Y GUARDO ARCHIVO
                    //codigo del arbol huffman. codificar. transforma codigo binario huffman a hexadecimal. crea archivo comprimido con el texto hexadecimal
                    HashMap<String,String> codigoHuffman = a.calcularCodigos();
                    String binario = ArbolHuffman.codificar(texto,codigoHuffman);                       //CODIFICAR
                    String hexadecimal = u.binarioHexadecimal(binario);
                    String str=textSeleccionado.getText();
                    str = str.substring(0, str.length() - 4);
                    //System.out.println(str);
                    u.guardarTexto(str, hexadecimal, codigoHuffman);

                                        //PESO EN BYTES DEL ARCHIVO COMPRIMIDO
                    //peso en bytes del archivo comprimido
                    texto = u.leerTexto(str+"n.txt");
                    System.out.println("Texto comprimido: "+texto);
                    //frecuencias del archivo. creo arbol Huffman. peso del archivo en bytes
                    frecuencias = u.calcularFrecuencias(u.leerTexto(str+"n.txt"));
                    nodoraiz = a.calcularArbol(frecuencias);
                    System.out.println("Peso en bytes de archivo comprimido: "+nodoraiz.getInfo().getFrec());
                    textSeleccionado.setText("");
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("INFORMACION");
                    alert.setContentText("Archivo Comprimido Exitosamente...!");
 
                    alert.showAndWait();}
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Archivo no permitido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
           textSeleccionado.setText("");
       }
        
        
    }
        
    @FXML
    private void descomprimirFile(ActionEvent event) {
        Util u = new Util();
        try{
        ArbolHuffman a = new ArbolHuffman();       
                    //PESO EN BYTES DEL ARCHIVO POR DESCOMPRIMIR                    
                    //leo el archivo
                   String  texto = u.leerTexto(textSeleccionado.getText());
                    System.out.println("Texto por descomprimir: "+texto);
                    HashMap<String,Integer> frecuencias = u.calcularFrecuencias(u.leerTexto(textSeleccionado.getText()));
                    Node nodoraiz = a.calcularArbol(frecuencias);
                    //frecuencias del archivo. creo arbol Huffman. peso del archivo en bytes
                    frecuencias = u.calcularFrecuencias(u.leerTexto(textSeleccionado.getText()));
                    nodoraiz = a.calcularArbol(frecuencias);
                    System.out.println("Peso en bytes de archivo por descomprimir: "+nodoraiz.getInfo().getFrec());
                    
                    //DECODIFICO Y GUARDO ARCHIVO
                    //transforma codigo hexadecimal a binario huffman. leo el _compress y lo hago HashMap. decodifico. crea archivo comprimido con el texto hexadecimal
                    String binario = u.hexadecimalBinario(texto);
                    HashMap<String,String> codigoHuffman = a.calcularCodigos();
                    String strr=textSeleccionado.getText();
                    String str = strr.substring(0, strr.length() - 4);
                    String ss=strr.substring(0, strr.length() - 5);
                    codigoHuffman = u.leerMapa(str+"_compress");
                    String textoAGuardar = ArbolHuffman.decodificar(binario,codigoHuffman);             //DECODIFICAR
                    u.guardarTexto(ss,textoAGuardar,new HashMap<>());

                    //PESO EN BYTES DEL ARCHIVO DESCOMPRIMIDO                    
                    //leo el archivo
                    texto = u.leerTexto(ss+".txt");
                    System.out.println("Texto descomprimido: "+ texto );                    
                    //frecuencias del archivo. creo arbol Huffman. peso del archivo en bytes
                    frecuencias = u.calcularFrecuencias(u.leerTexto(ss+".txt"));
                    nodoraiz = a.calcularArbol(frecuencias);
                    System.out.println("Peso en bytes de archivo descomprimido: "+nodoraiz.getInfo().getFrec());
                    textSeleccionado.setText("");
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("INFORMACION");
                    alert.setContentText("Archivo Descomprimido Exitosamente...!");
 
                    alert.showAndWait();
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, "Archivo no permitido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
           textSeleccionado.setText("");
       }
        
        
        
        
        
    }
    
}
