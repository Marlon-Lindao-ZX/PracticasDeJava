/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author Veronica
 */
public class FillTransitionExample extends Application{
    public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) 
	{
		// Create the Rectangle
		Rectangle rect = new Rectangle(400, 200, Color.CYAN);
		// Create the HBox
		HBox root = new HBox(rect);
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
		stage.setTitle("A Fill Transition Example");
		// Display the Stage
		stage.show();

		// Set up a fill transition for the rectangle
		FillTransition fillTransition = new FillTransition(Duration.seconds(2), rect);
		fillTransition.setFromValue(Color.BLUEVIOLET);
		fillTransition.setToValue(Color.AZURE);
		fillTransition.setCycleCount(FillTransition.INDEFINITE);
		fillTransition.setAutoReverse(true);
		fillTransition.play();		
	}
    
}
