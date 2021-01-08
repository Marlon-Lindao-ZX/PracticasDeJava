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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Veronica
 */
public class TimeLineAnimationControl extends Application {

    // Create the Timeline
    Timeline timeline = new Timeline();
    // Create the Label
    Label status = new Label("Current State: " + timeline.getStatus());

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws InterruptedException {
        // Create the Text
        Text text = new Text("A Scrolling Text!");
        // Set the Font of the Text
        text.setFont(Font.font(36));

        // Create the Buttons
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        Button replay = new Button("RePlay");
        Button stop = new Button("Stop");

        // Create the Event-Handlers for the Buttons
        play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                timeline.play();
                status.setText("Current State: " + timeline.getStatus());
            }
        });

        replay.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                timeline.playFromStart();
                status.setText("Current State: " + timeline.getStatus());
            }
        });

        pause.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                timeline.pause();
                status.setText("Current State: " + timeline.getStatus());
            }
        });

        stop.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                timeline.stop();
                status.setText("Current State: " + timeline.getStatus());
            }
        });

        // Create the Button Box
        HBox buttonBox = new HBox();
        // Set Spacing to 10 pixels
        buttonBox.setSpacing(10);
        // Add the Children to the HBox
        buttonBox.getChildren().addAll(play, pause, replay, stop);

        // Create the VBox
        VBox root = new VBox(buttonBox, status, text);
        // Set Spacing to 10 pixels
        root.setSpacing(10);
        // Set the Size of the VBox
        root.setPrefSize(500, 200);
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("A JavaFX Animation Control Example");
        // Display the Stage
        stage.show();

        // Get the Scene width and the Text width
        double sceneWidth = scene.getWidth();
        double textWidth = text.getLayoutBounds().getWidth();

        // Define the Durations
        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(10);

        // Create the start and end Key Frames
        KeyValue startKeyValue = new KeyValue(text.translateXProperty(), sceneWidth);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(text.translateXProperty(), -1.0 * textWidth);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        // Create a Timeline
        timeline = new Timeline(startKeyFrame, endKeyFrame);
        // Let the animation run forever
        timeline.setCycleCount(Timeline.INDEFINITE);
    }
}
