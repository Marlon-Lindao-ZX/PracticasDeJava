/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class TilePaneTest extends Application {
    private TilePane tile;
    @Override
    public void start(Stage stage) {
        tile = new TilePane();//Por defecto la posicion horizontal
        tile.setPrefColumns(6);//Declaramos 6 columnas
        tile.setPrefRows(4);//Y 4 filas
        for(int i = 0; i < 30; i++) {
            tile.getChildren().add(new Button("Boton "+ i));
        }
        Scene s = new Scene(tile);
        stage.setScene(s);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
