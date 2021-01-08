/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.busqueda;

import ec.edu.espol.entidades.Migrante;
import ec.edu.espol.funciones.Herramientas;
import java.util.LinkedList;
import java.util.ListIterator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class AuxBusqueda {
    
    private static Stage auxStage;
    
    private AuxBusqueda(){}
    
    public static Migrante findMigrante(LinkedList<Migrante> lista,String id){
        if(lista.isEmpty()) return null;
        Migrante tmp;
        ListIterator<Migrante> low = lista.listIterator();
        ListIterator<Migrante> high = lista.listIterator(lista.size());
        tmp = searchMigrante(low,high,id);
        return tmp;
    }
    
    private static Migrante searchMigrante(ListIterator<Migrante> low,ListIterator<Migrante> high,String id){
        int indmenor = low.nextIndex() -1;
        int indmayor = high.previousIndex()+1;
        Migrante tmp;
        Migrante tmp1;
        Migrante tmp2;
        if(indmenor == indmayor) {
            tmp = low.next();
            if(tmp.getIdentificacion().equals(id)) return tmp;
            return null;
        }
        if(!((low.nextIndex() == indmayor  ))){
            tmp1 = low.next();
            tmp2 = low.next();
            if(tmp1.getIdentificacion().equals(id)) return tmp1;
            if(tmp2.getIdentificacion().equals(id)) return tmp2;
            searchMigrante(low,high,id);
        }
        return null;
        
    }
    
    public static void generateAuxStage(MigracionProperty mp){
        VBox rootAux = new VBox(15);
        rootAux.setPadding(new Insets(10, 10, 10, 10));
        rootAux.alignmentProperty().set(Pos.TOP_CENTER);
        rootAux.setStyle("-fx-background-color: #e0ffff");
        
        Text titleAux = Herramientas.styleText("Datos de Migracion ","Palatino Linotype",25,false,Color.BLACK);
        
        GridPane gpAux = new GridPane();
        gpAux.setPadding(new Insets(10, 10, 10, 10));
        gpAux.setVgap(40);
        gpAux.setHgap(35);
        gpAux.setAlignment(Pos.CENTER);
        
        Text codM = Herramientas.styleText("Codigo de Migracion: ","Palatino Linotype",15,false,Color.BLACK);
        Text fechaM = Herramientas.styleText("Fecha de Migracion: ","Palatino Linotype",15,false,Color.BLACK);
        Text idM = Herramientas.styleText("ID de Migrante: ","Palatino Linotype",15,false,Color.BLACK);
        Text nameM = Herramientas.styleText("Nombre de Migrante: ","Palatino Linotype",15,false,Color.BLACK);
        Text cityO = Herramientas.styleText("Ciudad Origen de Migrante: ","Palatino Linotype",15,false,Color.BLACK);
        Text provO = Herramientas.styleText("Provincia Origen de Migrante: ","Palatino Linotype",15,false,Color.BLACK);
        Text couO = Herramientas.styleText("Pais Origen de Migrante: ","Palatino Linotype",15,false,Color.BLACK);
        Text lugD = Herramientas.styleText("Lugar de Destino: ","Palatino Linotype",15,false,Color.BLACK);
        
        Text valCodM = Herramientas.styleText(String.valueOf(mp.getCod()),"Palatino Linotype",15,false,Color.BLACK);
        Text valFechaM = Herramientas.styleText(mp.getDate().getValue().toString(),"Palatino Linotype",15,false,Color.BLACK);
        Text valIdM = Herramientas.styleText(mp.getIdMigrante(),"Palatino Linotype",15,false,Color.BLACK);
        Text valNameM = Herramientas.styleText(mp.getName(),"Palatino Linotype",15,false,Color.BLACK);
        Text valCityO = Herramientas.styleText(mp.getCityO(),"Palatino Linotype",15,false,Color.BLACK);
        Text valProvO = Herramientas.styleText(mp.getProvinciaO(),"Palatino Linotype",15,false,Color.BLACK);
        Text valCouO = Herramientas.styleText(mp.getCountry(),"Palatino Linotype",15,false,Color.BLACK);
        Text valLugD = Herramientas.styleText(mp.getLugarDestino(),"Palatino Linotype",15,false,Color.BLACK);
        
        gpAux.addRow(0, codM, valCodM);
        gpAux.addRow(1, fechaM,valFechaM);
        gpAux.addRow(2, idM,valIdM);
        gpAux.addRow(3, nameM,valNameM);
        gpAux.addRow(4, cityO,valCityO);
        gpAux.addRow(5, provO,valProvO);
        gpAux.addRow(6, couO,valCouO);
        gpAux.addRow(7, lugD,valLugD);
        
        HBox auxBox = new HBox(15);
        auxBox.setAlignment(Pos.CENTER);
        
        Button modify = new Button("Modificar");
        Button delete = new Button("Eliminar");
        
        auxBox.getChildren().addAll(modify,delete);
        rootAux.getChildren().addAll(titleAux,gpAux,auxBox);
        
        Scene sceneAux = new Scene(rootAux);
        
        auxStage = new Stage();
        auxStage.setScene(sceneAux);
        auxStage.setTitle("Migracion");
        auxStage.showAndWait();
    }
}
