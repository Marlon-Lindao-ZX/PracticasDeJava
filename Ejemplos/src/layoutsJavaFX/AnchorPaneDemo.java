/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsJavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author Verónica
 */
public class AnchorPaneDemo extends Application{
     @Override
   public void start(Stage primaryStage) throws Exception {
       AnchorPane root = new AnchorPane();
       Button button1 = new Button("(B1) Top + Left + Right");
 
       Button button2 = new Button("(B2) Top + Left + Right");
       Button button3 = new Button("(B3) Top + Left + Right");
 
       Button button4 = new Button("(B4) Top + Left + Right + Bottom");
 
       // (B1) Anchor to the Top + Left + Right
       AnchorPane.setTopAnchor(button1, 40.0);
       AnchorPane.setLeftAnchor(button1, 50.0);
       AnchorPane.setRightAnchor(button1, 70.0);
 
       // (B2) Anchor to the Top + Left + Right
       AnchorPane.setTopAnchor(button2, 90.0);
       AnchorPane.setLeftAnchor(button2, 10.0);
       AnchorPane.setRightAnchor(button2, 320.0);
 
       // (B3) Anchor to the Top + Left + Right
       AnchorPane.setTopAnchor(button3, 100.0);
       AnchorPane.setLeftAnchor(button3, 250.0);
       AnchorPane.setRightAnchor(button3, 20.0);
 
       // (B4) Anchor to the four sides of AnchorPane
       AnchorPane.setTopAnchor(button4, 150.0);
       AnchorPane.setLeftAnchor(button4, 40.0);
       AnchorPane.setRightAnchor(button4, 50.0);
       AnchorPane.setBottomAnchor(button4, 45.0);
 
       // Add buttons to AnchorPane
       root.getChildren().addAll(button1, button3, button2, button4);
 
       Scene scene = new Scene(root, 550, 250);
 
       primaryStage.setTitle("AnchorPane Layout Demo (o7planning.org)");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}
