/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import SistemaProeventos.AbstractScene;
import SistemaProeventos.Auxiliar;
import SistemaProeventos.LoginStage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class SceneAdministrador extends AbstractScene{
    
    

    public SceneAdministrador(Stage stage) {
        
        super(stage,obtenerPaneAdministrador());
        
        
        
    }

    
    
    private static TilePane obtenerPaneAdministrador(){
        
        
        
        TilePane tp = new TilePane();
        Text admTitle = new Text("Bienvenido Administrador");
        admTitle.setFont(new Font(20));
        
        Button btnRegistro = new Button("Registrar Usuario");
        StageRegistroUsuario sru = new StageRegistroUsuario();
        btnRegistro.setOnAction(e -> Auxiliar.btnOpenStage(sru.getStage()));
        
        Button btnCierre = new Button("Cerrar Sesion");
        btnCierre.setOnAction(e -> Auxiliar.btnCerrarSesionClick(generalStage, LoginStage.getScene()));
        
        VBox paneVer = new VBox(20,admTitle,btnRegistro,btnCierre);
        paneVer.setAlignment(Pos.CENTER);
        paneVer.setCenterShape(true);
        
        tp.getChildren().addAll(paneVer);
        tp.setOrientation(Orientation.VERTICAL);
        tp.setAlignment(Pos.CENTER);
        tp.setCenterShape(true);
        
        
        
        
        return tp;
    }
    
    
    
}
