/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.Event.*;
import javafx.event.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Veronica
 */
public class PaneOrganizer {

    private VBox _root;
    private Label _label;

    public static Color generarColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color customColor = Color.rgb(red, green, blue);
        return customColor;
    }

    public PaneOrganizer() {
        

    }

    public VBox getRoot() {
        _root = new VBox();
        _label = new Label("CS15 Rocks!");
        Button btn = new Button("Random Color");

        _root.getChildren().addAll(_label, btn);
        _root.setSpacing(8);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            
                _label.setTextFill(generarColor());
            }

        }
        );
        return _root;
    }

}
