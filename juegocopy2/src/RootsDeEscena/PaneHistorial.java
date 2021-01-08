/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import Fuentes.ManejoDeArchivos;
import Fuentes.Registro;
import Sistema.Juego;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Alex
 */
public class PaneHistorial implements Organizable {
    
    private GridPane rootHistorial;
    private ObservableList<Registro> registros;
    private TableView<Registro> tabla;
    /**
     * 
     */
    public PaneHistorial(){
        rootHistorial = new GridPane();
        registros = FXCollections.observableArrayList();
        llenarRegistros(ManejoDeArchivos.leerArchivo(ManejoDeArchivos.FILE1));
        generarRoot();
        
    }
    /**
     * 
     */
    @Override
    public void generarRoot(){
        
        VBox title = new VBox();
        VBox boton = new VBox();
        Text textHistorial = new Text("Registro de Puntuaciones");
        textHistorial.setId("mensaje");

        textHistorial.setFill(Color.ROYALBLUE);
        textHistorial.setTextAlignment(TextAlignment.CENTER);
        title.getChildren().add(textHistorial);
        title.setAlignment(Pos.CENTER);
        
         
        tabla = new TableView<>();
        TableColumn<Registro,String> userCol = new TableColumn<>("Nombre");
        userCol.setCellValueFactory(new PropertyValueFactory("nombreUsuario"));
        
        TableColumn<Registro,String> fechaCol = new TableColumn<>("Fecha");
        fechaCol.setCellValueFactory(new PropertyValueFactory("fecha"));
        
        TableColumn<Registro,String> duracionCol = new TableColumn<>("Duracion");
        duracionCol.setCellValueFactory(new PropertyValueFactory("hora"));
        
        TableColumn<Registro,String> puntacionCol = new TableColumn<>("Puntacion");
        puntacionCol.setCellValueFactory(new PropertyValueFactory("puntacion"));
        
        tabla.getColumns().setAll(userCol,fechaCol,duracionCol,puntacionCol);
        tabla.setItems(registros);
        
        tabla.setMaxSize(400, 200);
        
        rootHistorial.setStyle("-fx-background-color: lightblue;");
        
        
        
        Button btnRegresar = new Button("Regresar");
        btnRegresar.setId("btnRegresar");
        
        btnRegresar.setOnAction(e -> {
            Juego.scene1.setRoot(Juego.organizer1.getRootInicio());
            BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
            BackgroundMusic.iniciarThread();
        });
        boton.getChildren().add(btnRegresar);
        boton.setAlignment(Pos.BASELINE_RIGHT);
        
        rootHistorial.setAlignment(Pos.CENTER);
        rootHistorial.setVgap(60);
        rootHistorial.add(title,0,0);
        rootHistorial.add(tabla,0,1);
        rootHistorial.add(boton,0,2);
        
        
    }
    /**
     * 
     * @param lineas 
     */
    public void llenarRegistros(ArrayList<String> lineas){
        
        for(String linea: lineas) registros.add(new Registro(linea));
    }
/**
 * 
 * @return 
 */
    public GridPane getRootHistorial() {
        return rootHistorial;
    }
/**
 * 
 * @param rootHistorial 
 */
    public void setRootHistorial(GridPane rootHistorial) {
        this.rootHistorial = rootHistorial;
    }
/**
 * 
 * @return 
 */
    public ObservableList<Registro> getRegistros() {
        return registros;
    }
/**
 * 
 * @param registros 
 */
    public void setRegistros(ObservableList<Registro> registros) {
        this.registros = registros;
    }
    
    
}
