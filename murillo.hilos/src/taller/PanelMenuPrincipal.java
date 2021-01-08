/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import com.sun.java.swing.plaf.motif.MotifTextUI;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Administrador
 */
class PanelMenuPrincipal {
    private VBox root_principal;
    private Label label_seconds;
    private static TextField text_seconds;
    private Label label_rep;
    private static TextField text_rep;
    private Label label_fra;
    private static TextField text_fra;
    private Label label_txt;
    private static TextArea txt_area;
    
  
  
    private static ProgressBar pb;
    private static ProgressIndicator pri;
    
    
    public PanelMenuPrincipal(){
        root_principal = new VBox();
        generarRoot();
        
        
}
    Parent getRoot() {
        return root_principal;
    }
    
    public void generarRoot(){
        HBox nameShape = new HBox();
        label_seconds = new Label("Segundos: ");
        text_seconds = new TextField("");
        nameShape.getChildren().addAll(label_seconds,text_seconds);
        nameShape.setAlignment(Pos.CENTER_LEFT);
        nameShape.setMargin(label_seconds,new Insets(10,10,10,10));
        nameShape.setMargin(text_seconds,new Insets(10,10,10,10));
        nameShape.setSpacing(60);
        root_principal.getChildren().add(nameShape);
        
        HBox nameShape2 = new HBox();
        label_rep = new Label("Repeticiones: ");
        text_rep = new TextField("");
        nameShape2.getChildren().addAll(label_rep,text_rep);
        nameShape2.setAlignment(Pos.CENTER_LEFT);
        nameShape2.setMargin(label_rep,new Insets(10,10,10,10));
        nameShape2.setMargin(text_rep,new Insets(10,10,10,10));
        nameShape2.setSpacing(40);
        root_principal.getChildren().add(nameShape2);
        
        HBox nameShape3 = new HBox();
        label_fra = new Label("Frase: ");
        text_fra = new TextField("");
        nameShape3.getChildren().addAll(label_fra,text_fra);
        nameShape3.setAlignment(Pos.CENTER_LEFT);
        nameShape3.setMargin(label_fra,new Insets(10,10,10,10));
        nameShape3.setMargin(text_fra,new Insets(10,10,10,10));
        nameShape3.setSpacing(80);
        root_principal.getChildren().add(nameShape3);
        
        HBox btnShape = new HBox();
        Button rbtn = new Button("Start");
        Button sbtn = new Button("Exit");
        btnShape.getChildren().addAll(rbtn,sbtn);
        btnShape.setAlignment(Pos.CENTER_LEFT);
        root_principal.getChildren().add(btnShape);
        
        HBox nameShape4 = new HBox();
        label_txt = new Label("Texto: ");
        txt_area = new TextArea("");
        nameShape4.getChildren().addAll(label_txt,txt_area);
        nameShape4.setAlignment(Pos.TOP_RIGHT);
        nameShape4.setMargin(label_txt,new Insets(10,10,10,10));
        nameShape4.setMargin(txt_area,new Insets(10,10,10,10));
        nameShape4.setSpacing(60);
        root_principal.getChildren().add(nameShape4);
        
        pb = new ProgressBar(0);
        pb.setFocusTraversable(true);
        pri = new ProgressIndicator(0);
        pri.setFocusTraversable(true);
        root_principal.getChildren().add(pb);
        root_principal.getChildren().add(pri);
        
        
        
        rbtn.setOnAction(e -> { 
            
            Runnable task = () -> runTask();
            Thread background = new Thread(task);
            background.setDaemon(true);
            background.start();
            
        
        });
        sbtn.setOnAction(e -> { Platform.exit();});
        
    }
    
    public void runTask() {

        try{
        double sec = Double.parseDouble(text_seconds.getText());
        double rep = Double.parseDouble(text_rep.getText());

        long time = (long) ((sec / rep) * 1000);

        for (int i = 1; i <= rep; i++) {

            double a = i * ((100 / rep)/100);

            Platform.runLater(() -> {
                pb.setProgress(a);
                pri.setProgress(a);
                txt_area.appendText(PanelMenuPrincipal.getText_fra().getText() + "\n");
            });
            
            Thread.sleep(time);

        }
        } catch (InterruptedException ie) {

        } catch (NumberFormatException nfe) {

        }
    }

    public static TextField getText_seconds() {
        return text_seconds;
    }

    public static TextField getText_rep() {
        return text_rep;
    }

    public static TextField getText_fra() {
        return text_fra;
    }

    public static TextArea getTxt_area() {
        return txt_area;
    }

    public static ProgressBar getPb() {
        return pb;
    }

    public static ProgressIndicator getPri() {
        return pri;
    }

    
}
