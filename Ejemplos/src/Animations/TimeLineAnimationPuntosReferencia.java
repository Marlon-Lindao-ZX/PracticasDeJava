/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;
/**
 *
 * @author Veronica
 */
public class TimeLineAnimationPuntosReferencia extends Application{
    // Create the Text
	Text text = new Text("A Scrolling Text!");
	// Create the Pane
	Pane pane = new Pane();
	// Create the Cue Points List View
	ListView<String> cuePointsListView = new ListView<String>();
	// Create the Timeline
	Timeline timeline = new Timeline();
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) 
	{
		// Create the Text
		text.setTextOrigin(VPos.TOP);
		text.setFont(Font.font(24));

		// Set the Size of the ListView
		cuePointsListView.setPrefSize(100, 150);
		// Create the Pane
		pane = new Pane(text);
		
		// Create the BorderPane
		BorderPane root = new BorderPane();
		// Set the Size of the BorderPane
		root.setPrefSize(600, 250);

		// Set the Style-properties of the BorderPane
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Add the Pane and ListView to the BorderPane
		root.setBottom(pane);
		root.setLeft(cuePointsListView);
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title of the Stage
		stage.setTitle("Cue Points");
		// Display the Stage
		stage.show();
		
		// Setup the Animation
		this.setupAnimation();
		// Add the Cue Points to the List
		this.addCuePoints();
	}
	
	private void setupAnimation() 
	{
		// Get width of Pane and Text
		double paneWidth = pane.getWidth();
		double textWidth = text.getLayoutBounds().getWidth();
		
		// Define the Durations
		Duration startDuration = Duration.ZERO;
		Duration endDuration = Duration.seconds(10);
				
		// Create the initial and final key frames
		KeyValue startKeyValue = new KeyValue(text.translateXProperty(), paneWidth);
		KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
		KeyValue endKeyValue = new KeyValue(text.translateXProperty(), -1.0 * textWidth);
		KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
		
		// Create the Timeline
		timeline = new Timeline(startKeyFrame,endKeyFrame);
		// Let the animation run forever
		timeline.setCycleCount(Timeline.INDEFINITE);
		// Play the Animation
		timeline.play();
	}	
	
	private void addCuePoints() 
	{
		// Add two cue points directly to the map
		timeline.getCuePoints().put("4", Duration.seconds(4));
		timeline.getCuePoints().put("7", Duration.seconds(7));
				
		// Add all cue points from the map to the ListView in the order
		// of their durations
		cuePointsListView.getItems().add(0, "Start");
		cuePointsListView.getItems().addAll(1, timeline.getCuePoints().keySet());
		cuePointsListView.getItems().add("End");

		// Add Event Handler to the List
		cuePointsListView.setOnMousePressed(new EventHandler<MouseEvent>() 
		{
	        @Override
	        public void handle(MouseEvent event) 
	        {
	            timeline.jumpTo(cuePointsListView.getSelectionModel().getSelectedItem());
	        }
	    });
	}
}
