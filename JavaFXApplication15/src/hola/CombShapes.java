/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hola;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import javafx.scene.shape.Shape;

import javafx.stage.Stage;

 

public class CombShapes extends Application

{

    public static void main(String[] args)

    {

       Application.launch(args);

    }

     

    @Override

    public void start(final Stage stage)

    {

        // Create the Circles

        Circle circle1 = new Circle (0, 0, 20);

        Circle circle2 = new Circle (15, 0, 20);

         

        // Create the Shapes

        Shape union = Shape.union(circle1, circle2);

        union.setStroke(Color.BLACK);

        union.setFill(Color.LIGHTGRAY);

         

        Shape intersection = Shape.intersect(circle1, circle2);

        intersection.setStroke(Color.BLACK);

        intersection.setFill(Color.LIGHTGRAY);

         

        Shape subtraction = Shape.subtract(circle1, circle2);

        subtraction.setStroke(Color.BLACK);

        subtraction.setFill(Color.LIGHTGRAY);

         

        // Create the HBox

        HBox root = new HBox(union, intersection, subtraction);

        root.setSpacing(20);

         

        // Set the Style of the HBox

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

        stage.setTitle("A Combining Path Example");

        // Display the Stage

        stage.show();

    }
}

