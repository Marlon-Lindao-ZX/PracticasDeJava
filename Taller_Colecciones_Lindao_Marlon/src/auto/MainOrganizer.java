/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 *
 * @author CORE I7
 */
public class MainOrganizer {
    
    private TilePane mainRoot;
    
    public MainOrganizer(){
        mainRoot = new TilePane();
        generarRoot();
    }
    
    public void generarRoot(){
        ImageView caratula = new ImageView(new Image("auto/caratula.png",350,550,true,true));
        
        Button btnInicio = new Button("Ingresar");
        btnInicio.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");
        btnInicio.setOnAction(e -> Auxiliar.getSecStage().showStage());
        
        mainRoot.getChildren().addAll(caratula,btnInicio);
        mainRoot.setAlignment(Pos.CENTER);
        mainRoot.setHgap(50);
        mainRoot.setOrientation(Orientation.VERTICAL);
        mainRoot.setStyle("-fx-background-color: lightblue;");
    }

    public TilePane getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(TilePane mainRoot) {
        this.mainRoot = mainRoot;
    }
    
    
    
}
