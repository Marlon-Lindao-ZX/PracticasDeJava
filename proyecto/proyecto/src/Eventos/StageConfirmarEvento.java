/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import SistemaProeventos.AbstractStage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author CORE I7
 */
public class StageConfirmarEvento extends AbstractStage {

    public StageConfirmarEvento() {
        super("Confirmar de Evento");
        stage.setScene(obtenerEscena());
    }

    @Override
    public Scene obtenerEscena() {
        Scene scene;

        Label test = new Label("Coming soon!!! XD");

        VBox vbox = new VBox(test);

        scene = new Scene(vbox, 400, 400);

        return scene;

    }
}
