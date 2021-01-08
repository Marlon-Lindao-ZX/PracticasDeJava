/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public abstract class PaneVentana {
    
    protected Scene scene;
    protected Text message;
    protected Button btn1;
    protected Button btn2;
    protected HBox contenedorBotones;
    protected Stage window;
    
    public abstract void generarStage();
    
    public void setearElementos(String mensaje,String nameBtn1,String nameBtn2,
                                EventHandler<ActionEvent> eventBtn1,EventHandler<ActionEvent> eventBtn2){
        message = new Text(mensaje);
        message.setStyle("-fx-font: 20px Tahoma;"
                + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 80%); "
                + "-fx-stroke: linear-gradient(from 0% 0% to 100% 200%, repeat, orange 0%, red 80%);"
                + "-fx-stroke-width: 2");
        btn1 = new Button(nameBtn1);
        btn2 = new Button(nameBtn2);
        btn1.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");
        btn2.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");
        
        btn1.setOnAction(eventBtn1);
        btn2.setOnAction(eventBtn2);

        contenedorBotones = new HBox();
        
        
        contenedorBotones.getChildren().addAll(btn1, btn2);
        contenedorBotones.setSpacing(30);
        contenedorBotones.setAlignment(Pos.CENTER);

    }
}
