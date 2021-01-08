/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class GridPaneTest2 extends Application{
    private GridPane grid;
    @Override
    public void start(Stage stage)  {
        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Button("Posicion 0, 0"), 0, 0);
        grid.add(new Button("Posicion 1, 0"), 1, 0 );
        grid.add(new Button("Posicion 0, 1"), 0, 1);
        grid.add(new Button("Posicion 1, 1"), 1, 1);
        grid.add(new Button("Posicion 0, 2"), 0, 2);
        grid.add(new Button("Posicion 1, 2"), 1, 2);
        
        Scene s = new Scene(grid);
        stage.setScene(s);
        stage.show();   
    }
    public static void main(String[] args) {
        launch(args);
    }
}
