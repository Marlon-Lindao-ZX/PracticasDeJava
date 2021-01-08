/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CltControl
 */
public class Util {
    
    public String leerTexto(String nombreArchivo){
        String texto = "";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(nombreArchivo));            
            while(sc.hasNextLine()) texto+=sc.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL LEER EL ARCHIVO: "+e);
        }finally{
            if(sc!=null){
           sc.close();}
        }
        return texto;
    }
    
    public HashMap<String,Integer> calcularFrecuencias(String texto){
        HashMap<String,Integer> mapa = new HashMap<>();
        Set letras = new HashSet();
        for(int i=0;i<texto.length();i++){
            letras.add(texto.charAt(i));            
        }        
        Iterator it = letras.iterator();
        while(it.hasNext()) {     
            String letra = it.next().toString();
            int frecuencia = 0;
            for(int j=0;j<texto.length();j++){
                String a = texto.charAt(j)+"";
                if(a.equals(letra)) frecuencia+=1;
            }
            mapa.put(letra,frecuencia);
        }        
        return mapa;
    }
    
    public String binarioHexadecimal(String binario){
        String hexadecimal = "";
        //llenar con 0 al final
        int residuo = binario.length()%4;  
        for(int i=0;i<residuo;i++) binario+="0";
        //binario a hexadecimal
        for(int i=0;i<binario.length()-residuo;i+=4){
            String b = binario.substring(i,i+4);
            int dec=Integer.parseInt(b,2);
            hexadecimal+=Integer.toHexString(dec);
        }
        //llenar con - al final
        for(int i=0;i<residuo;i++) hexadecimal+="-";
        return hexadecimal;
    }
    
    public String hexadecimalBinario(String hexadecimal){
        String binario = "";
        //cuento los ceros del final
        int numerode0 = 0;
        for(int k = 0; k<hexadecimal.length();k++){
            if((hexadecimal.charAt(k)+"").equals("-")) numerode0+=1;
        }
        //recorro el hexadecimal
        for(int i=0;i<hexadecimal.length()-numerode0;i++){
            int dec=Integer.parseInt(hexadecimal.charAt(i)+"",16);
            String hex = Integer.toBinaryString(dec);
            //completo con ceros los caracteres binarios
            if(hex.length()!=4){
                String ceros = "";
                for(int j=0;j<4-hex.length();j++) ceros+=0;
                hex=ceros+hex;
            }
            binario+=hex;
        }
        //elimino los ceros del "-"        
        return binario.substring(0,binario.length()-numerode0);
    }
    
    public void guardarTexto(String nombreArchivo,String texto, HashMap<String,String> mapa){
        System.gc();
        try(BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File(nombreArchivo+"n.txt"),false))){
            bw1.append(texto);
            System.out.println("ALMACENAMIENTO DE ARCHIVO EXITOSO");
            bw1.close();
        }
        catch (IOException e) {
            System.err.print("ERROR AL ALMACENAR EL ARCHIVO: "+e);
        } 
        
        if(mapa.size()==0){          
            File f = new File(nombreArchivo+"n_compress.txt");  
            try {                
                FileOutputStream out = new FileOutputStream(f);
                out.close();                
                out = null;               
                System.out.println("ARCHIVO DE FRECUENCIAS BORRADO EXITOSAMENTE");                
            } catch (Exception e) {
                System.out.println("ERROR AL BORRAR ARCHIVO DE FRECUENCIAS: "+e);
            }
            if(f.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
            
        }
        else{
            try(BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File(nombreArchivo+"n_compress.txt"),false))){
                bw2.append(mapa.toString());
                System.out.println("ALMACENAMIENTO DE ARCHIVO DE FRECUENCIAS EXITOSO");
            }
            catch (IOException e) {
                System.err.print("ERROR AL ALMACENAR EL ARCHIVO DE FRECUENCIAS: "+e);
            } 
        }
        
    }
    
    public HashMap<String,String> leerMapa (String nombreArchivo){
        HashMap<String,String> mapa = new HashMap<>();
        String texto = leerTexto(nombreArchivo+".txt");
        String[] arr = texto.substring(1,texto.length()-1).split(", ");
        for(int i=0;i<arr.length;i++) mapa.put(arr[i].split("=")[0],arr[i].split("=")[1]);
        return mapa;
    }
    
}
