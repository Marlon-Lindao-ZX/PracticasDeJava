/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyecto;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import miniproyecto.Clases.AVLTree;
import miniproyecto.Clases.MapaArbol;
import miniproyecto.Clases.NodeBT;

/**
 *
 * @author chard
 */
public class FXMLAvlController implements Initializable {
    private AVLTree<Integer> holi = new AVLTree<>(Integer::compareTo);
    @FXML
    private Button searchButton;

    @FXML
    private TextField addTF;

    @FXML
    private Button allButton;

    @FXML
    private Button removeButton;

    @FXML
    private TextField removeTF;

    @FXML
    private Pane lienzo;

    @FXML
    private Button addButton;

    @FXML
    private TextField searchTF;
    
    @FXML
    private VBox toSearch;

    @FXML
    void addAction(ActionEvent event) {
        if(!addTF.getText().equals("")){
            if(holi.add(Integer.parseInt(addTF.getText()))){
                lienzo.getChildren().clear();
                MapaArbol mapis = new MapaArbol(holi);
                graficarArbol(mapis);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PROBLEMA!");
                alert.setHeaderText("VALOR REPETIDO");
                alert.showAndWait();
            }
            borrarTextfields();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR!");
                alert.setHeaderText("INSERTE VALOR EN ADD");
                alert.showAndWait();
        }
        
    }

    @FXML
    void removeAction(ActionEvent event) {
        if(!removeTF.getText().equals("")){
            if(holi.remove(Integer.parseInt(removeTF.getText()))){
                lienzo.getChildren().clear();
                MapaArbol mapis = new MapaArbol(holi);
                graficarArbol(mapis);
               
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PROBLEMA!");
                alert.setHeaderText("VALOR NO ENCONTRADO O YA ELIMINADO ");
                alert.showAndWait();
            }
            borrarTextfields();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR!");
                alert.setHeaderText("INSERTE VALOR EN REMOVE");
                alert.showAndWait();
        }
        
    }
     @FXML
    void removeAllAction(ActionEvent event) {
        toSearch.getChildren().clear();
        lienzo.getChildren().clear();
        holi.vaciarArbol();
    }
    @FXML
    void searchAction(ActionEvent event) {
        if(!searchTF.getText().equals("")){ 
            NodeBT<Integer> num = holi.searchNode(Integer.parseInt(searchTF.getText()));
            if(num != null){
                Label l = new Label("El numero "+searchTF.getText()+" esta en el nivel " + holi.Nivel(num.getData()));
                toSearch.getChildren().add(l);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PROBLEMA!");
                alert.setHeaderText("EL NUMERO NO SE ENCUENTRA EN EL ARBOL");
                alert.showAndWait();
            }
            borrarTextfields();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR!");
                alert.setHeaderText("INSERTE UN VALOR EN SEARCH");
                alert.showAndWait();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        onlyNumbers();
        
    }    
    
    public void graficarArbol(MapaArbol mapita){
        for(NodeBT<Integer> n:mapita.getMapa().keySet() ){
            Text numero = new Text();numero.setFill(Color.WHITE);
            Circle c1 = new Circle(25); 
            c1.setFill(Color.DARKTURQUOISE);
            StackPane contenedor = new StackPane();
            numero.setText(n.getData().toString());
            contenedor.setLayoutX(mapita.getMapa().get(n).getX());
            contenedor.setLayoutY(mapita.getMapa().get(n).getY());
            contenedor.getChildren().addAll(c1,numero);
            lienzo.getChildren().add(contenedor);
            
            if(n.getRight()!= null){
                Line linea = new Line();
                linea.setStartX(mapita.getMapa().get(n).getX()+20);
                linea.setStartY(mapita.getMapa().get(n).getY()+20);
                linea.setEndX(mapita.getMapa().get(n.getRight()).getX()+20);
                linea.setEndY(mapita.getMapa().get(n.getRight()).getY()+20);
                linea.setFill(Color.GREEN);              
                lienzo.getChildren().add(linea);
                linea.toBack();
                            }
            if(n.getLeft()!= null){
                Line linea = new Line();
                linea.setStartX(mapita.getMapa().get(n).getX()+20);
                linea.setStartY(mapita.getMapa().get(n).getY()+20);
                linea.setEndX(mapita.getMapa().get(n.getLeft()).getX()+20);
                linea.setEndY(mapita.getMapa().get(n.getLeft()).getY()+20);
                linea.setFill(Color.RED);  
                lienzo.getChildren().add(linea);
                linea.toBack();
            }
        }
    }
    
    public void onlyNumbers(){
        addTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,10}?")) {
                    addTF.setText(oldValue);
                }
            }
        });
        removeTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,10}?")) {
                    removeTF.setText(oldValue);
                }
            }
        });
        searchTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,10}?")) {
                    searchTF.setText(oldValue);
                }
            }
        });
    }
    
    public void borrarTextfields(){
        removeTF.setText("");
        searchTF.setText("");
        addTF.setText("");
    }
}
