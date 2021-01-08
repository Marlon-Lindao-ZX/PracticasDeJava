/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.busqueda;

import ec.edu.espol.datos.Datos;
import ec.edu.espol.entidades.Migracion;
import ec.edu.espol.entidades.Migrante;
import ec.edu.espol.funciones.Herramientas;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Domenica Barreiro
 */
public class UIbusquedas {
    
    private Stage father;
    private VBox menu;
    private VBox rootUB1;
    private VBox rootUB2;
    private ObservableList<MigracionProperty> listM;
    private TableView<MigracionProperty> tablaM;
    private LinkedList<MigracionProperty> resultBusqueda;

    
    public UIbusquedas(Stage primaryStage, VBox menu) {
        this.father = primaryStage;
        this.menu = menu;
        resultBusqueda = new LinkedList<>();
        generarRootUB();
        father.getScene().setRoot(rootUB1);
        father.setTitle("Busqueda de Migrantes");
    }
    
    private void generarRootUB(){
        rootUB1 = new VBox(50);
        rootUB1.alignmentProperty().set(Pos.TOP_CENTER);
        rootUB1.setStyle("-fx-background-color: #e0ffff");
        
        rootUB2 = new VBox(30);
        rootUB2.alignmentProperty().set(Pos.CENTER);
        rootUB2.setStyle("-fx-background-color: #e0ffff");

        Button atras = Herramientas.getButton("Atrás","src/ec/edu/espol/recursos/volver.JPG",100,80);
        
        atras.setOnAction((e)->{
            father.setTitle("Sistema de Gestion de Migraciones");
            father.getScene().setRoot(menu);
        });
        
        Text titulo = Herramientas.styleText("Buscar por: ","Palatino Linotype",35,false,Color.BLACK);
        VBox titleB = new VBox(atras,titulo);
        titleB.setAlignment(Pos.CENTER_LEFT);
        titleB.setSpacing(40);
        
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setVgap(40);
        gp.setHgap(35);
        gp.setAlignment(Pos.CENTER);
        
        Text lbB1 = Herramientas.styleText("Seleccione Categoría: ","Palatino Linotype",25,false,Color.BLACK);
        Text lbB2 = Herramientas.styleText("Escriba el valor de la \ncategoría a buscar: ","Palatino Linotype",25,false,Color.BLACK);
        
        ObservableList<String> optionB = FXCollections.observableArrayList("Fecha", "Provincia", "Canton", "Lugar de Destino");
        ComboBox<String> cbB1 = new ComboBox(optionB);
        cbB1.getSelectionModel().selectFirst();
        TextField tfB1 = new TextField();
        gp.addRow(0, lbB1, cbB1);
        gp.addRow(1, lbB2, tfB1);

        Text advert = Herramientas.styleText("No hay migraciones que mostrar","Palatino Linotype",25,false,Color.BLACK);

        Button nextB = Herramientas.getButton("Buscar","src/ec/edu/espol/recursos/buscar.png",100,100);

        Text titleB2 = Herramientas.styleText("Resultado de Búsqueda","Palatino Linotype",40,false,Color.BLACK);
        tablaM = new TableView<>();
        
        TableColumn<MigracionProperty, String> codMCol = new TableColumn<>("Codigo Migracion");
        codMCol.setCellValueFactory(new PropertyValueFactory("cod"));

        TableColumn<MigracionProperty, LocalDate> fechaCol = new TableColumn<>("Fecha Migracion");
        fechaCol.setCellValueFactory(fechaRowData -> fechaRowData.getValue().getDate());
        
        TableColumn<MigracionProperty, String> idCol = new TableColumn<>("Identificacion Migrante");
        idCol.setCellValueFactory(new PropertyValueFactory("idMigrante"));

        TableColumn<MigracionProperty, String> nameCol = new TableColumn<>("Nombre Completo Migrante");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        
        TableColumn<MigracionProperty, String> cityCol = new TableColumn<>("Ciudad de Origen");
        cityCol.setCellValueFactory(new PropertyValueFactory("cityO"));
        
        TableColumn<MigracionProperty, String> provCol = new TableColumn<>("Provincia de Origen");
        provCol.setCellValueFactory(new PropertyValueFactory("provinciaO"));
        
        TableColumn<MigracionProperty, String> countryCol = new TableColumn<>("Pais de Origen");
        countryCol.setCellValueFactory(new PropertyValueFactory("country"));

        TableColumn<MigracionProperty, String> lugDCol = new TableColumn<>("Lugar de Destino");
        lugDCol.setCellValueFactory(new PropertyValueFactory("lugarDestino"));

        idCol.setMinWidth(150);
        codMCol.setMinWidth(200);
        fechaCol.setMinWidth(200);
        nameCol.setMinWidth(50);
        lugDCol.setMinWidth(80);
        countryCol.setMinWidth(200);
        provCol.setMinWidth(200);
        cityCol.setMinWidth(200);
        
        tablaM.getColumns().addAll(codMCol, fechaCol, idCol, nameCol, cityCol, provCol, countryCol, lugDCol);
        tablaM.setMaxSize(1500, 700);

        Button backB = Herramientas.getButton("Regresar","src/ec/edu/espol/recursos/volver.JPG",100,80);

        rootUB1.getChildren().addAll(titleB, gp, nextB);
        
        rootUB2.getChildren().addAll(titleB2, tablaM, advert, backB);
        
        nextB.setOnMouseClicked(e ->goNext(advert,tfB1.getText(),cbB1.getSelectionModel().getSelectedItem()));
        backB.setOnMouseClicked(e -> goBack(advert));
            
        
    }
    
    private void goNext(Text lb, String busqueda, String option) {
        LinkedList<Migracion> tmp;
        tablaM.getItems().clear();
        if (busqueda.equals("")) {
            tmp = new LinkedList<>();
        } else {
            tmp = Busqueda.buscarMigrante(Datos.getMigraciones(), busqueda, option);
        }

        if (!tmp.isEmpty()) {
            tmp.forEach((m) -> {
                resultBusqueda.add(new MigracionProperty(m));
            });
            listM = FXCollections.observableList(resultBusqueda);
            tablaM.setItems(listM);
            tablaM.setRowFactory(tv -> {
                TableRow<MigracionProperty> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                            && event.getClickCount() == 2) {
                        MigracionProperty clickedRow = row.getItem();
                        AuxBusqueda.generateAuxStage(clickedRow);
                    }
                });
                return row;
            });
            lb.setVisible(false);
        } else {
            lb.setVisible(true);
        }
        father.getScene().setRoot(rootUB2);
    }
    
    private void goBack(Text lb){
        lb.setVisible(false);
        father.getScene().setRoot(rootUB1);
    }

    public ObservableList<MigracionProperty> getListM() {
        return listM;
    }

    public void setListM(ObservableList<MigracionProperty> listM) {
        this.listM = listM;
    }

    public TableView<MigracionProperty> getTablaM() {
        return tablaM;
    }

    public void setTablaM(TableView<MigracionProperty> tablaM) {
        this.tablaM = tablaM;
    }

    public LinkedList<MigracionProperty> getResultBusqueda() {
        return resultBusqueda;
    }

    public void setResultBusqueda(LinkedList<MigracionProperty> resultBusqueda) {
        this.resultBusqueda = resultBusqueda;
    }
    
    
    
}
