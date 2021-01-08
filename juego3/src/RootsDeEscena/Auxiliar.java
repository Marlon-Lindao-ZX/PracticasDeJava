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
      * Metodo para generar roots
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
     * Metodo para obtener los imageview
     * @param objects objetos
     * @return arreglo
     */
    public static ArrayList<Node> obtainImageView(Collection<Elemento> objects){
        
        ArrayList<Node> imgs = new ArrayList<>();
        
        for(Elemento el: objects){
            imgs.add(el.getElemento());
//            imgs.add(el.getBorder());
        }
        
        return imgs;
    }
    /**
     * Metod guardar registros
     */
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
    /**
     * Metodo que actualiza el tiempo
     * @param time tiempo
     */
    public static void updateTime(int time){
        acumuladorTiempo += (120 - time);
        int temp = Nivel.getScore();
        temp += Nivel.getLife() * 100;
        temp += (120 - time) * 5;
        Nivel.setScore(temp);
    }
/**
 * Metodo que acumula el tiempo
 * @return tiempo
 */
    public static int getAcumuladorTiempo() {
        return acumuladorTiempo;
    }
/**
 * Metodo que setea el tiempo acumulado
 * @param acumuladorTiempo 
 */
    public static void setAcumuladorTiempo(int acumuladorTiempo) {
        Auxiliar.acumuladorTiempo = acumuladorTiempo;
    }
    
/**
 * Metodo que obtiene el fondo
 * @return fondo
 */
    public static Fondo getFondo() {
        return fondo;
    }
/**
 * Setea el fondo
 * @param fondo fondo
 */
    public static void setFondo(Fondo fondo) {
        Auxiliar.fondo = fondo;
    }
/**
 * Obtiene el group por defecto
 * @return group
 */
    public static Group getDefecto() {
        return defecto;
    }
/**
 * Setea el group por defecto
 * @param defecto group
 */
    public static void setDefecto(Group defecto) {
        Auxiliar.defecto = defecto;
    }
    /**
     * Obtiene el root de ingreso
     * @return root
     */
    public static StackPane getRootIngreso(){
        return organizer2.getRoot();
    }
    /**
     * Obtiene el root de historial
     * @return root
     */
    public static GridPane getRootHistorial(){
        return paneH.getRootHistorial();
    }
/**
 * Obtiene el pane salir
 * @return pane
 */
    public static PaneSalir getPaneS() {
        return paneS;
    }
    /**
     * Obtiene el organizer2
     * @return organizer2
     */
    public static PaneIngreso getOrganizer2() {
        return organizer2;
    }
    /**
     * Obtiene el root de nivel 1
     * @return root
     */
    public static StackPane getRootLevel1(){
        return level1.getRootNivel();
    }
   
/**
 * Setea el paneIngreso
 * @param organizer2 pane
 */
    public static void setOrganizer2(PaneIngreso organizer2) {
        Auxiliar.organizer2 = organizer2;
    }
/**
 * Obtiene el pane de historial
 * @return pane
 */
    public static PaneHistorial getPaneH() {
        return paneH;
    }
/**
 * Setea el panel de historial
 * @param paneH pane
 */
    public static void setPaneH(PaneHistorial paneH) {
        Auxiliar.paneH = paneH;
    }
/**
 * Obtiene el nivel 1
 * @return nivel
 */
    public static Nivel1 getLevel1() {
        return level1;
    }
/**
 * Obtiene el nivel 2
 * @return nivel
 */
    public static Nivel2 getLevel2() {
        return level2;
    }
/**
 * Obtiene el nivel 3
 * @return nivel
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
 * Obtiene la ventana exito
 * @return ventana
 */
    public static VentanaExito getPaneE() {
        return paneE;
    }
/**
 * Setea el pane exito
 * @param paneE pane
 */
    public static void setPaneE(VentanaExito paneE) {
        Auxiliar.paneE = paneE;
    }
/**
 * Obtiene el pane fallo
 * @return pane
 */
    public static VentanaFallo getPaneF() {
        return paneF;
    }
/**
 * Setea el pane fallo
 * @param paneF pane
 */
    public static void setPaneF(VentanaFallo paneF) {
        Auxiliar.paneF = paneF;
    }

 
    
    
    
    
    
}
