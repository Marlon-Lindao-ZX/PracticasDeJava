/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class TallerU9 extends Application {

    @Override
    public void init(){
        Auxiliar.inicializar();
    }

    @Override
    public void start(Stage primaryStage) {
       
        MainOrganizer root = new MainOrganizer();
        
        Scene scene = new Scene(root.getMainRoot(), 800, 600);
        primaryStage.setTitle("Agencia de Carros RentCar");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e ->{
            e.consume();
            Auxiliar.getOut().generarStage();
        });
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
