/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import Fuentes.ManejoDeArchivos;
import Fuentes.Registro;
import ObjetosDelJuego.Elemento;
import ObjetosDelJuego.Fondo;
import ObjetosDelJuego.ObjetoFijo;
import ObjetosDelJuego.Premio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class Auxiliar {
    
    private static PaneIngreso organizer2;
    private static PaneHistorial paneH;
    private static PaneSalir paneS;
    private static Nivel1 level1;
    private static Nivel2 level2;
    private static Nivel3 level3;
    private static VentanaExito paneE;
    private static VentanaFallo paneF;
    private static Group defecto;
    private static Fondo fondo;
    private static int acumuladorTiempo;

    
     /**
      * 
      */
    public static void generarRoots(){
        acumuladorTiempo = 0;
        fondo = new Fondo();
        organizer2 = new PaneIngreso();
        paneH = new PaneHistorial();
        paneS = new PaneSalir();
        level1 = new Nivel1();
        level2 = new Nivel2();
        level3 = new Nivel3();
        paneE=new VentanaExito();
        paneF=new VentanaFallo();
        defecto = new Group();
        Nivel.setControl(1);
        
        
    }
    /**
     * 
     * @param objects
     * @return 
     */
    public static ArrayList<Node> obtainImageView(Collection<Elemento> objects){
        
        ArrayList<Node> imgs = new ArrayList<>();
        
        for(Elemento el: objects){
            imgs.add(el.getElemento());
        }
        
        return imgs;
    }
    
    public static void guardar(){
        String nombre = Auxiliar.getOrganizer2().getTfUser().getText();
        if (nombre.equals("")){
            nombre = "default";
        }
        LocalDate fecha = LocalDate.now();
        fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalTime tiempo = LocalTime.ofSecondOfDay(acumuladorTiempo);
        int totalScore = Nivel.getScore();
        
        Registro temp = new Registro(nombre,fecha,tiempo,totalScore);
        
        Auxiliar.getPaneH().getRegistros().add(temp);
        ManejoDeArchivos.escribirArchivo(temp.toString(), ManejoDeArchivos.FILE1);
        
    }
    
    public static void updateTime(int time){
        acumuladorTiempo += (120 - time);
    }

    public static int getAcumuladorTiempo() {
        return acumuladorTiempo;
    }

    public static void setAcumuladorTiempo(int acumuladorTiempo) {
        Auxiliar.acumuladorTiempo = acumuladorTiempo;
    }
    
/**
 * 
 * @return 
 */
    public static Fondo getFondo() {
        return fondo;
    }
/**
 * 
 * @param fondo 
 */
    public static void setFondo(Fondo fondo) {
        Auxiliar.fondo = fondo;
    }
/**
 * 
 * @return 
 */
    public static Group getDefecto() {
        return defecto;
    }
/**
 * 
 * @param defecto 
 */
    public static void setDefecto(Group defecto) {
        Auxiliar.defecto = defecto;
    }
    /**
     * 
     * @return 
     */
    public static StackPane getRootIngreso(){
        return organizer2.getRoot();
    }
    /**
     * 
     * @return 
     */
    public static GridPane getRootHistorial(){
        return paneH.getRootHistorial();
    }
/**
 * 
 * @return 
 */
    public static PaneSalir getPaneS() {
        return paneS;
    }
    /**
     * 
     * @return 
     */
    public static PaneIngreso getOrganizer2() {
        return organizer2;
    }
    /**
     * 
     * @return 
     */
    public static StackPane getRootLevel1(){
        return level1.getRootNivel();
    }
   
/**
 * 
 * @param organizer2 
 */
    public static void setOrganizer2(PaneIngreso organizer2) {
        Auxiliar.organizer2 = organizer2;
    }
/**
 * 
 * @return 
 */
    public static PaneHistorial getPaneH() {
        return paneH;
    }
/**
 * 
 * @param paneH 
 */
    public static void setPaneH(PaneHistorial paneH) {
        Auxiliar.paneH = paneH;
    }
/**
 * 
 * @return 
 */
    public static Nivel1 getLevel1() {
        return level1;
    }
/**
 * 
 * @return 
 */
    public static Nivel2 getLevel2() {
        return level2;
    }
/**
 * 
 * @return 
 */
    public static Nivel3 getLevel3() {
        return level3;
    }

    public static void setPaneS(PaneSalir paneS) {
        Auxiliar.paneS = paneS;
    }

    public static void setLevel1(Nivel1 level1) {
        Auxiliar.level1 = level1;
    }

    public static void setLevel2(Nivel2 level2) {
        Auxiliar.level2 = level2;
    }

    public static void setLevel3(Nivel3 level3) {
        Auxiliar.level3 = level3;
    }
    
    
/**
 * 
 * @return 
 */
    public static VentanaExito getPaneE() {
        return paneE;
    }
/**
 * 
 * @param paneE 
 */
    public static void setPaneE(VentanaExito paneE) {
        Auxiliar.paneE = paneE;
    }
/**
 * 
 * @return 
 */
    public static VentanaFallo getPaneF() {
        return paneF;
    }
/**
 * 
 * @param paneF 
 */
    public static void setPaneF(VentanaFallo paneF) {
        Auxiliar.paneF = paneF;
    }

 
    
    
    
    
    
}
