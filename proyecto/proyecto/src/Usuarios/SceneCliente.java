/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Eventos.StageConsultarEventoCliente;
import SistemaProeventos.AbstractScene;
import SistemaProeventos.Auxiliar;
import SistemaProeventos.LoginStage;
import Transacciones.StageRegistroPago;
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
public class SceneCliente extends AbstractScene {
    
    

    public SceneCliente(Stage stage) {
        
        super(stage,obtenerPaneCliente());
        
        
    }

    
    
    private static TilePane obtenerPaneCliente(){
        
        TilePane tp = new TilePane();
        Text cliTitle = new Text("Bienvenido Cliente");
        cliTitle.setFont(new Font(20));
        
        
        Button btnRegistroPago = new Button("Registrar Pago Evento");
        StageRegistroPago srp = new StageRegistroPago();
        btnRegistroPago.setOnAction(e -> Auxiliar.btnOpenStage(srp.getStage()));
        
        Button btnConsultarEvento = new Button("Consultar Eventos");
        StageConsultarEventoCliente scec = new StageConsultarEventoCliente();
        btnConsultarEvento.setOnAction(e -> Auxiliar.btnOpenStage(scec.getStage()));
        
        Button btnCierre = new Button("Cerrar Sesion");
        btnCierre.setOnAction(e -> Auxiliar.btnCerrarSesionClick(generalStage, LoginStage.getScene()));
        
        VBox paneVer = new VBox(20,cliTitle,btnRegistroPago,btnConsultarEvento,btnCierre);
        paneVer.setAlignment(Pos.CENTER);
        paneVer.setCenterShape(true);
        
        tp.getChildren().addAll(paneVer);
        tp.setOrientation(Orientation.VERTICAL);
        tp.setAlignment(Pos.CENTER);
        tp.setCenterShape(true);
        
        
        
        return tp;
    }
}
