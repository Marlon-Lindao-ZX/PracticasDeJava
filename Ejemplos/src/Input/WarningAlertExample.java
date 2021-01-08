/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class WarningAlertExample extends Application  {
     // Show a Warning Alert with header Text
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning alert");
        alert.setHeaderText("Battery Status:");
        alert.setContentText("The battery charge is low!");
 
        alert.showAndWait();
    }
 
    // Show a Warning Alert with default header Text
    private void showAlertWithDefaultHeaderText() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning alert");
 
        // alert.setHeaderText("Battery Status:");
        alert.setContentText("The battery charge is low!");
 
        alert.showAndWait();
    }
 
    // Show a Warning Alert without Header Text
    private void showAlertWithoutHeaderText() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("The battery charge is low!");
 
        alert.showAndWait();
    }
 
    @Override
    public void start(Stage stage) {
 
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
 
        Button button1 = new Button("Warning Alert");
        Button button2 = new Button("Warning Alert with default Header Text");
        Button button3 = new Button("Warning Alert without Header Text");
 
        button1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithHeaderText();
            }
        });
 
        button2.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithDefaultHeaderText();
            }
        });
 
        button3.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithoutHeaderText();
            }
        });
 
        root.getChildren().addAll(button1, button2, button3);
 
        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("JavaFX Warning Alert (o7planning.org)");
        stage.setScene(scene);
 
        stage.show();
 
    }
 
    public static void main(String args[]) {
        launch(args);
    }
}
