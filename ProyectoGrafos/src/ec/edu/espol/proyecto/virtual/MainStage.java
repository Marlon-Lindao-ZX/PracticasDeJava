/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto.virtual;

import ec.edu.espol.proyecto.auxiliar.Auxiliar;
import ec.edu.espol.proyecto.grafos.GraphLA;
import java.util.HashMap;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class MainStage {
    
    private Stage stage;
    private Scene scene;
    private VBox root;
    private int counter = 1;
    private GraphLA<String> graph;
    private HashMap<String,String> ciudades;
    
    
    public MainStage(Stage stage){
        ciudades = Auxiliar.cargarCiudades("ciudades.txt");
        graph = Auxiliar.cargarGrafo("distancias.txt", ciudades);
        generarRoot();
        scene = new Scene(root);
        this.stage = stage;
        
    }
    
    private void generarRoot(){
        root = new VBox(50);
        root.setPadding(new Insets(20,20,20,20));
        HBox hbox = new HBox(25);
        
        Text t1 = new Text("Ciudad Origen: ");
        Text t2 = new Text("Ciudad Destino: ");
        
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        
        Button btn1 = new Button("Generar Ruta");
        
        
        hbox.getChildren().addAll(t1,tf1,t2,tf2,btn1);
        
        TextArea ta1 = new TextArea();
        btn1.setOnMouseClicked(e -> generateRout(tf1,tf2,ta1));
        
        Button btnForward = new Button("Mapa");
        btnForward.setOnMouseClicked(e -> goForward());
        
        
        root.getChildren().addAll(hbox,ta1,btnForward);
        
    }
    
    private void generateRout(TextField tf1, TextField tf2, TextArea ta) {
        String origin = tf1.getText();
        String destiny = tf2.getText();
        StringBuilder result = new StringBuilder();
        
        int contador = 1;
        int temporal = 0;

        ta.clear();

        if (!(origin.isEmpty() || destiny.isEmpty())) {
            
            List<String> ruta = Auxiliar.calcularRutaCorta(graph, ciudades, origin, destiny);
            if (!ruta.isEmpty()) {
                for(String value : ruta) {
                    if(contador++%2 != 0){
                        value = ciudades.get(value);
                        result.append(value).append("-");
                    }else{
                        temporal += Integer.parseInt(value.substring(2, value.length()-5));
                    }
                        
                    
                }
                ta.appendText(result.substring(0, result.length()-1));
                ta.appendText("\nDistancia de Ruta: "+temporal+" km");
            }

        }
    }
    
    private void goForward(){
        SecondStage st = new SecondStage(this);
        this.scene.setRoot(st.getRootS());
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public GraphLA<String> getGraph() {
        return graph;
    }

    public void setGraph(GraphLA<String> graph) {
        this.graph = graph;
    }

    public HashMap<String, String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(HashMap<String, String> ciudades) {
        this.ciudades = ciudades;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    
    
    
    
    
    
    
    
}
