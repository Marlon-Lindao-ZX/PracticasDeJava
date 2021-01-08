/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import SistemaProeventos.AbstractScene;
import Agenda.StageRegistrarAgenda;
import Eventos.StageConfirmarEvento;
import Eventos.StageConsultarEvento;
import Eventos.StageRegistroEvento;
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
public class ScenePlanificador extends AbstractScene{
    

    public ScenePlanificador(Stage stage) {
        
        super(stage,obtenerPanePlanificador());
        
    }
    
    
    private static TilePane obtenerPanePlanificador(){
        
        TilePane tp = new TilePane();
        Text plaTitle = new Text("Bienvenido Planificador");
        plaTitle.setFont(new Font(20));
        
        
        Button btnRegistroEvento = new Button("Registrar Evento");
        StageRegistroEvento sre = new StageRegistroEvento();
        btnRegistroEvento.setOnAction(e -> Auxiliar.btnOpenStage(sre.getStage()));
        
        Button btnRegistroAgenda = new Button("Registrar Agenda");
        StageRegistrarAgenda sra = new StageRegistrarAgenda();
        btnRegistroAgenda.setOnAction(e -> Auxiliar.btnOpenStage(sra.getStage()));
        
        Button btnConfirmarEvento = new Button("Confirmar Evento");
        StageConfirmarEvento sce = new StageConfirmarEvento();
        btnConfirmarEvento.setOnAction(e -> Auxiliar.btnOpenStage(sce.getStage()));
        
        Button btnConsultarEvento = new Button("Consultar Evento");
        StageConsultarEvento scne = new StageConsultarEvento();
        btnConsultarEvento.setOnAction(e -> Auxiliar.btnOpenStage(scne.getStage()));
        
        Button btnCierre = new Button("Cerrar Sesion");
        btnCierre.setOnAction(e -> Auxiliar.btnCerrarSesionClick(generalStage, LoginStage.getScene()));
        
        VBox paneVer = new VBox(20,plaTitle,btnRegistroEvento,btnRegistroAgenda,btnConfirmarEvento,btnConsultarEvento,btnCierre);
        paneVer.setAlignment(Pos.CENTER);
        paneVer.setCenterShape(true);
        
        tp.getChildren().addAll(paneVer);
        tp.setOrientation(Orientation.VERTICAL);
        tp.setAlignment(Pos.CENTER);
        tp.setCenterShape(true);
        
        
        return tp;
    }
}
