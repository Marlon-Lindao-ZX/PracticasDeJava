/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.ArrayList;
import java.util.TreeSet;
import javafx.scene.control.ComboBox;


/**
 *
 * @author CORE I7
 */
public class Auxiliar{
    
    private static TreeSet<Auto> autos;
    private static SecondStage secStage;
    private static SecondScene secScene;
    private static PaneSalir out;
    private static ConfirmationDelete deleter;
    private static int controller;
    
    public static void inicializar(){
        controller = 0;
        autos = new TreeSet<>(new AutoComparator(0));
        iniciarAutos(ManejoDeArchivos.leerArchivo(ManejoDeArchivos.FILE1));
        secStage = new SecondStage();
        secScene = new SecondScene();
        out = new PaneSalir();
        deleter = new ConfirmationDelete();
        
    }
    
    private static void iniciarAutos(ArrayList<String> lineas){
        for(String linea: lineas){
            autos.add(new Auto(linea));
        }
    }
    
    public static void deleteAuto(ComboBox cb) {

        int c = cb.getSelectionModel().getSelectedIndex();
        cb.getItems().remove(cb.getSelectionModel().getSelectedItem());
        if (c != 0) {
            cb.getSelectionModel().select(0);
            cb.setValue(cb.getSelectionModel().getSelectedItem());
        } else {
//            cb.getSelectionModel().select(1);
            cb.getSelectionModel().selectFirst();
            cb.setValue(cb.getSelectionModel().getSelectedItem());
        }

    }

    public static int getController() {
        return controller;
    }

    public static void setController(int controller) {
        Auxiliar.controller = controller;
    }

    public static SecondStage getSecStage() {
        return secStage;
    }

    public static void setSecStage(SecondStage secStage) {
        Auxiliar.secStage = secStage;
    }

    public static SecondScene getSecScene() {
        return secScene;
    }

    public static void setSecScene(SecondScene secScene) {
        Auxiliar.secScene = secScene;
    }
    
    public static TreeSet<Auto> getAutos() {
        return autos;
    }

    public static void setAutos(TreeSet<Auto> autos) {
        Auxiliar.autos = autos;
    }

    public static PaneSalir getOut() {
        return out;
    }

    public static void setOut(PaneSalir out) {
        Auxiliar.out = out;
    }

    public static ConfirmationDelete getDeleter() {
        return deleter;
    }

    public static void setDeleter(ConfirmationDelete deleter) {
        Auxiliar.deleter = deleter;
    }
    
    
    
    
    
    
}
