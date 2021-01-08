/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public class test2 extends Application {
    
    public static void main(String[] args)   
    {  
        Application.launch(args);  
    }  
  
    // #########################################################################################################  
    //                                                                                                INSTÂNCIAS  
    // #########################################################################################################  
      
    private StackPane root;  
    private StackPane circles;  
    private Rectangle rect_background;  
    private Scene cenario;  
      
    // UI  
      
    private VBox lay_box_controls;  
      
    private Label lab_test;  
    private TextArea texA_test;  
    private Button but_test;  
      
    // #########################################################################################################  
    //                                                                                                 INÍCIO FX  
    // #########################################################################################################  
      
    @Override 
    public void start(Stage stage) throws Exception   
    {  
        this.confFX();  
          
        cenario = new Scene(this.root , 640 , 480);  
          
        this.rect_background.widthProperty().bind(this.cenario.widthProperty());  
        this.rect_background.heightProperty().bind(this.cenario.heightProperty());  
  
        stage.setScene(cenario);  
        stage.setTitle("Meu programa JavaFX - R.D.S.");  
        stage.show();  
    }  
      
    protected void confFX()  
    {  
        this.root = new StackPane();  
        this.rect_background = new Rectangle();  
        FillTransition fillTransition = new FillTransition(Duration.seconds(5), this.rect_background);
	fillTransition.setFromValue(Color.DARKCYAN);
	fillTransition.setToValue(Color.CADETBLUE);
	fillTransition.setCycleCount(FillTransition.INDEFINITE);
	fillTransition.setAutoReverse(true);
	fillTransition.play();	
        
        Timeline t = new Timeline(new KeyFrame(Duration.seconds(5),e ->{
            generarAnimacion();
        }));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
  
        this.root.getChildren().addAll(this.rect_background);  
        
    } 
    
    public void generarAnimacion(){
        String s = "/hola/";
        Random r = new Random();
        int a = r.nextInt(4);
        switch(a){
            case 0:
                s += "circle";
                break;
            case 1:
                s += "square";
                break;
            case 2:
                s += "x";
                break;
            case 3:
                s += "triangle";
                break;
        }
        s += ".png";
        ImageView img = new ImageView(new Image(s,30,30,true,true));
        double c = (r.nextInt(640) + r.nextDouble()) - 320;

        
        TranslateTransition trans = new TranslateTransition(Duration.seconds(20));
        trans.setFromX(c);
	trans.setFromY(240);
	trans.setToY(-240);
	trans.setCycleCount(1);
        
        RotateTransition rot = new RotateTransition(Duration.seconds(10));
        rot.setFromAngle(0);
        rot.setToAngle(360);
        rot.setCycleCount(2);
        
        ParallelTransition parTransition = new ParallelTransition();
	parTransition.setNode(img);
		// Add the Children to the ParallelTransition
	parTransition.getChildren().addAll(rot, trans);
		// Let the animation run forever
	parTransition.setCycleCount(1);
		// Play the Animation
	parTransition.play();
        
        parTransition.setOnFinished(e -> {
            root.getChildren().remove(img);
        });
        
        root.getChildren().add(img);

    }
}
