/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Varios;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
/**
 *
 * @author Verónica
 */
public class EjemploObservableList {
    public static void main(String[] args) {

        // Se insta una lista.
        List<String> list = new ArrayList<String>();

        // se agrega la observación usando FXCollections:
    ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.add("uno");
    observableList.addListener(new ListChangeListener() {
            
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Ocurrio un cambio! ");
            }
        });

        // Se reportan cambios a observableList.
        // Aquí se va imprimir la alerta 
        observableList.add("uno");

        // cambios directas a la lista escapan la observación
        // no se imprime ninguna alerta 
        list.add("dos");
        //list.add("tres");
        observableList.add("wqkqw");
        System.out.println(observableList);
        System.out.println("Tamano: "+observableList.size());
    }
}
