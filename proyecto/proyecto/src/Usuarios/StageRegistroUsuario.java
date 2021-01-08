/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import SistemaProeventos.AbstractStage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author CORE I7
 */
public class StageRegistroUsuario extends AbstractStage {

    public StageRegistroUsuario() {

        super("Registro de Usuario");
        stage.setScene(obtenerEscena());
    }

    @Override
    public Scene obtenerEscena() {
        Scene scene;
        
        VBox vbox = new VBox(30);

        Text text = new Text("Registro de Usuario");
        text.setTextAlignment(TextAlignment.CENTER);
        
        GridPane gp = new GridPane();

        Text t1 = new Text("Nombre: ");
        Text t2 = new Text("Apellido: ");
        Text t3 = new Text("Usuario: ");
        Text t4 = new Text("Contraseña: ");
        Text t5 = new Text("Perfil: ");
        
        gp.add(t1, 0, 0);
        gp.add(t2, 0, 1);
        gp.add(t3, 0, 2);
        gp.add(t4, 0, 3);
        gp.add(t5, 0, 4);

        TextField tf1 = new TextField();
        tf1.setPrefColumnCount(20);
        tf1.setPromptText("(Escriba su nombre aqui)");
        tf1.setMaxWidth(Double.MAX_VALUE);

        TextField tf2 = new TextField();
        tf2.setPrefColumnCount(20);
        tf2.setPromptText("(Escriba su apellido aqui)");
        tf2.setMaxWidth(Double.MAX_VALUE);

        TextField tf3 = new TextField();
        tf3.setPrefColumnCount(20);
        tf3.setPromptText("(Escriba su usuario aqui)");
        tf3.setMaxWidth(Double.MAX_VALUE);

        TextField tf4 = new TextField();
        tf4.setPrefColumnCount(20);
        tf4.setPromptText("(Escriba su clave aqui)");
        tf4.setMaxWidth(Double.MAX_VALUE);
        
        gp.add(tf1, 1, 0);
        gp.add(tf2, 1, 1);
        gp.add(tf3, 1, 2);
        gp.add(tf4, 1, 3);
        
        gp.setAlignment(Pos.CENTER);
        gp.setCenterShape(true);
        gp.setHgap(15);
        gp.setVgap(15);
       

        Button btnRegister = new Button("Registrar");

        vbox.getChildren().addAll(text,gp,btnRegister);
        vbox.setAlignment(Pos.CENTER);
        vbox.setCenterShape(true);

        scene = new Scene(vbox, 400, 400);

        return scene;

    }

}
