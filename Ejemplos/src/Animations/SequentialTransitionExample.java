/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import javafx.animation.FillTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT;
/**
 *
 * @author Veronica
 */
public class SequentialTransitionExample extends Application{
    public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) 
	{
		// Create the Rectangle
		Rectangle rect = new Rectangle(50, 30, Color.RED);

		// Create the path
		Circle path = new Circle(100);
		path.setFill(null);
		path.setStroke(Color.BLACK);
		
		// Create the VBox
		VBox root = new VBox(rect, path);
		// Set the Size of the VBox
		root.setPrefSize(300, 300);
		// Set the Style-properties of the VBox
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
		stage.setTitle("A Sequential Transition Example");
		// Display the Stage
		stage.show();

		// Set up a Scale Transition
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1));
		scaleTransition.setFromX(1.0);
		scaleTransition.setToX(2.0);
		scaleTransition.setFromY(1.0);
		scaleTransition.setToY(2.0);
		// Let the animation run forever
		scaleTransition.setCycleCount(2);
		// Reverse direction on alternating cycles
		scaleTransition.setAutoReverse(true);
		
		// Set up a Fill Transition
		FillTransition fillTransition = new FillTransition(Duration.seconds(1));
		fillTransition.setFromValue(Color.RED);
		fillTransition.setToValue(Color.BLUE);
		// Let the animation run forever
		fillTransition.setCycleCount(2);
		// Reverse direction on alternating cycles
		fillTransition.setAutoReverse(true);
		
		// Set up a Path Transition
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path);
		pathTransition.setOrientation(ORTHOGONAL_TO_TANGENT);

		// Create a sequential transition
		SequentialTransition sequTransition = new SequentialTransition();
		// Rectangle is the node for all animations
		sequTransition.setNode(rect);
		// Add animations to the list
		sequTransition.getChildren().addAll(scaleTransition, fillTransition,pathTransition);
		// Let the animation run forever
		sequTransition.setCycleCount(PathTransition.INDEFINITE);
		// Play the Animation
		sequTransition.play();		
	}
}
