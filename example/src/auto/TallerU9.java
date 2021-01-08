/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import auto.Auto;
import com.sun.javafx.font.PrismFontFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class TallerU9 extends Application {

    HashSet<Auto> autos = new HashSet<Auto>();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader("autos.txt"));
            String s;
            while ((s = in.readLine()) != null) {
                String[] var = s.split(";");
                autos.add(new Auto(var[0], var[1], var[2], var[3], var[4], var[5], var[6]));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        ObservableList<Auto> Lista = FXCollections.observableArrayList(autos);
        ComboBox<Auto> combobox = new ComboBox<Auto>(Lista);
        combobox.getSelectionModel().selectFirst();
        Label l1 = new Label();
        ImageView im = new ImageView();
        im.setFitWidth(150);
        im.setFitHeight(100);
        combobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Auto>() {
            @Override
            public void changed(ObservableValue<? extends Auto> arg0, Auto arg1, Auto arg2) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Selected auto; " + arg2.toString());
                        Image no = new Image(TallerU9.class.getResource(combobox.getValue() + ".png").toExternalForm());
                        im.setImage(no);
                        l1.setText(arg2.toString());
                    }
                });
            }

        });

        VBox root = new VBox();
        root.getChildren().add(combobox);
        root.getChildren().add(im);
        root.getChildren().add(l1);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Combox Ejemplo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
