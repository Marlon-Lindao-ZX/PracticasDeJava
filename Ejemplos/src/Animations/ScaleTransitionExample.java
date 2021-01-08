/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author Veronica
 */
public class ScaleTransitionExample extends Application{
    public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) 
	{
		// Create the Circle
		Circle circle = new Circle(150, Color.GRAY);
		// Create the HBox
		HBox root = new HBox(circle);
		// Set the Style-properties of the HBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("A Scale Transition Example");
		// Display the Stage
		stage.show();
		
		// Set up a scale transition for the circle
		ScaleTransition trans = new ScaleTransition(Duration.seconds(2), circle);
		trans.setFromX(1.0);
		trans.setToX(0.40);
		trans.setFromY(1.0);
		trans.setToY(0.20);
		// Let the animation run forever		
		trans.setCycleCount(ScaleTransition.INDEFINITE);
		// Reverse direction on alternating cycles
		trans.setAutoReverse(true);
		// Play the Animation
		trans.play();		
	}
}
