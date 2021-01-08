/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Varios;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class ComboBox_ObservableList2 extends Application {
    public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(new Group(), 450, 250);
    ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4");
    ComboBox<String> emailComboBox = new ComboBox<String>(list);
    
    emailComboBox.setValue("A");
    System.out.println(emailComboBox.getValue());
    
    GridPane grid = new GridPane();
    grid.setVgap(4);
    grid.setHgap(10);
    grid.setPadding(new Insets(5, 5, 5, 5));
    grid.add(new Label("To: "), 0, 0);
    grid.add(emailComboBox, 1, 0);
    
    
    Group root = (Group) scene.getRoot();
    root.getChildren().add(grid);
    stage.setScene(scene);
    stage.show();

  }
}
