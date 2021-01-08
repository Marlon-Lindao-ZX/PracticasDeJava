/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author CORE I7
 */
public class SecondScene {

    private GridPane rootHistorial;
    private ObservableList<Auto> autos;
    private TableView<Auto> tabla;

    public SecondScene() {
        rootHistorial = new GridPane();
        autos = FXCollections.observableArrayList(Auxiliar.getAutos());
        generarRoot();

    }

    public void generarRoot() {

        VBox title = new VBox();
        VBox boton = new VBox();
        Text textHistorial = new Text("Lista de Carros");
        textHistorial.setStyle("-fx-font: 20px Tahoma;"
                + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 80%); "
                + "-fx-stroke: linear-gradient(from 0% 0% to 100% 200%, repeat, orange 0%, red 80%);"
                + "-fx-stroke-width: 2");
        textHistorial.setFill(Color.ROYALBLUE);
        textHistorial.setTextAlignment(TextAlignment.CENTER);
        title.getChildren().add(textHistorial);
        title.setAlignment(Pos.CENTER);

        tabla = new TableView<>();
        TableColumn<Auto, String> placaCol = new TableColumn<>("Placa");
        placaCol.setCellValueFactory(new PropertyValueFactory("placa"));

        TableColumn<Auto, String> marcaCol = new TableColumn<>("Marca");
        marcaCol.setCellValueFactory(new PropertyValueFactory("marca"));

        TableColumn<Auto, String> modeloCol = new TableColumn<>("Modelo");
        modeloCol.setCellValueFactory(new PropertyValueFactory("modelo"));

        TableColumn<Auto, String> precioCol = new TableColumn<>("Precio");
        precioCol.setCellValueFactory(new PropertyValueFactory("precio"));

        TableColumn<Auto, String> anioCol = new TableColumn<>("Anio");
        anioCol.setCellValueFactory(new PropertyValueFactory("anio"));

        TableColumn<Auto, String> colorCol = new TableColumn<>("Color");
        colorCol.setCellValueFactory(new PropertyValueFactory("color"));

        TableColumn<Auto, String> ubXCol = new TableColumn<>("Ubicacion X");
        ubXCol.setCellValueFactory(new PropertyValueFactory("ubicacionX"));

        TableColumn<Auto, String> ubYCol = new TableColumn<>("Ubicacion Y");
        ubYCol.setCellValueFactory(new PropertyValueFactory("ubicacionY"));

        tabla.getColumns().setAll(placaCol, marcaCol, modeloCol, precioCol, anioCol, colorCol, ubXCol, ubYCol);
        tabla.setItems(autos);

        tabla.setMaxSize(400, 200);
        rootHistorial.setStyle("-fx-background-color: lightblue;");

        Button btnSalir = new Button("Salir");
        btnSalir.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");

        btnSalir.setOnAction(e -> {
            e.consume();
            Auxiliar.getOut().generarStage();
        });
        boton.getChildren().add(btnSalir);
        boton.setAlignment(Pos.BASELINE_RIGHT);

        rootHistorial.setAlignment(Pos.CENTER);
        rootHistorial.setVgap(60);
        rootHistorial.add(title, 0, 0);
        rootHistorial.add(tabla, 0, 1);
        rootHistorial.add(boton, 0, 2);
    }

    public GridPane getRootHistorial() {
        return rootHistorial;
    }

    public void setRootHistorial(GridPane rootHistorial) {
        this.rootHistorial = rootHistorial;
    }

    public TableView<Auto> getTabla() {
        return tabla;
    }

    public void setTabla(TableView<Auto> tabla) {
        this.tabla = tabla;
    }
    
    
    
    
}
