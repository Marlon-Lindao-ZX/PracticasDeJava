/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class BorderPaneTest extends Application{
     private BorderPane raiz; 
    
    @Override
    public void start(Stage stage)  {
        raiz = new BorderPane();
        
        raiz.setTop(new Button("TOP"));
        raiz.setBottom(new Button("BOTTOM"));
        raiz.setLeft(new Button("LEFT"));
        raiz.setRight(new Button("RIGHT"));
        
        VBox b=new VBox();
        b.getChildren().addAll(new Button("CENTER"),new Button("CENTER 2"));
        raiz.setCenter(b);
        
        
        Scene scene = new Scene(raiz);
        
        stage.setScene(scene);
        stage.show();
    }    
    public static void main(String[] args) {
        launch(args);
    }
}
