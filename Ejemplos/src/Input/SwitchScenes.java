/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Verónica
 */
public class SwitchScenes extends Application{
    Stage window;
    Scene scene1;
    Scene scene2;
    
    public static void main(String[] args) {
    Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window=stage;
        Label label1=new Label("Welcome to the first scene!");
        Button b1=new Button("Go to Scene 2");
        b1.setOnAction(e->window.setScene(scene2));
        
        //Layout 1 - children are laid out in vertcial column
        VBox layout1=new VBox(20);     
        layout1.getChildren().addAll(label1,b1);
        scene1=new Scene(layout1,200,200);
        
        
        //Button 2
        Button b2=new Button("Go back to Scene 1");
        b2.setOnAction(e->window.setScene(scene1));
        
        //Layout 2
        StackPane layout2=new StackPane();
        layout2.getChildren().add(b2);
        scene2=new Scene(layout2,600,300);  
        
        window.setScene(scene1);
        window.setTitle("Switch Scenes");
        window.show();
    }
}
