/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author CORE I7
 */
public class PaneOrganizer {
    
    private VBox root;
    private VBox botones;
    private VBox caja;
    private VBox barra;
    
    private GridPane contenedor;
    
    private Text title;
    
    private Label time;
    private Label repeticion;
    private Label frase;
    private Label texto;
    private Label status;
    
    private TextField tTime;
    private TextField tRep;
    private TextField tFrase;
    private TextArea tArea;
    
    private ProgressBar pb;
    private ProgressIndicator pi;
    
    private Button btnStart;
    private Button btnExit;
    
    
    public PaneOrganizer(){
        root = new VBox(20);
        generarRoot();
    }
    
    private void generarRoot(){
        
        title = new Text("Aplicacion de un Thread");
        
        time = new Label("Segundos: ");
        repeticion = new Label("Repeticiones: ");
        frase = new Label("Frase: ");
        texto = new Label("Texto: ");
        status = new Label();
        
        tTime = new TextField();
        tRep  = new TextField();
        tFrase = new TextField();
        tArea = new TextArea();
        
        btnStart = new Button("Start");
        btnExit = new Button("Exit");
        
        pb = new ProgressBar(0);
        pi = new ProgressIndicator(0);
        
        botones = new VBox(20);
        botones.getChildren().addAll(btnStart,btnExit);
        caja = new VBox(20);
        caja.getChildren().addAll(texto,tArea);
        barra = new VBox();
        barra.getChildren().addAll(pb,status);
        
        contenedor = new GridPane();
        contenedor.setHgap(20);
        contenedor.setVgap(20);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.addColumn(0, time,repeticion,frase,botones,pb);
        contenedor.addColumn(1, tTime,tRep,tFrase,caja,pi);
        
        root.getChildren().addAll(title,contenedor);
        root.setAlignment(Pos.CENTER);
        
        btnStart.setOnAction(e -> {
            Runnable task = () -> runTask();
            Thread background = new Thread(task);
            background.setDaemon(true);
            background.start();
        });
        
    }
    
    private void runTask(){
        try{
        double sec = Double.parseDouble(tTime.getText());
        double rep = Double.parseDouble(tRep.getText());

        long time = (long) ((sec / rep) * 1000);

        for (int i = 1; i <= rep; i++) {

            double a = i * ((100 / rep)/100);
            String s = "Cargando " + a + "%";

            Platform.runLater(() -> {
                pb.setProgress(a);
                pi.setProgress(a);
                tArea.appendText(tFrase.getText() + "\n");
                status.setText(s);
            });
            
            Thread.sleep(time);

        }
        } catch (InterruptedException ie) {

        } catch (NumberFormatException nfe) {

        }
    

    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }
    
    
}
