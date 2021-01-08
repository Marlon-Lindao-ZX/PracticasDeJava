/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaProeventos;

import Usuarios.SceneAdministrador;
import Usuarios.SceneCliente;
import Usuarios.ScenePlanificador;
import Usuarios.UIUsuario;
import Usuarios.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class LoginStage {
    
    private TilePane root;
    private static Scene scene;
    private Stage stage;
    
    public LoginStage(Stage stage) {
        
        root = new TilePane();
        this.stage = stage;
        showLogin();
        scene = new Scene(root,400,400);
    }
    
    public TilePane getRoot() {
        return root;
    }

    public static Scene getScene() {
        return scene;
    }
    
    
    
    private void showLogin() {
        
        VBox paneAll = new VBox(10);
        
        
        HBox paneUsuario = new HBox();
        HBox paneContrasena = new HBox();
        
        Text loginTitle = new Text("Bienvenido al Sistema ProEventos");
        loginTitle.setFont(new Font(20));
        HBox paneTope = new HBox(loginTitle);
        paneTope.setPadding(new Insets(20, 10, 20, 10));
        
        
        Label lbl1 = new Label("Usuario: ");
        lbl1.setAlignment(Pos.CENTER);
        lbl1.setPrefWidth(100);
        
        TextField tfuser = new TextField();
        tfuser.setPrefColumnCount(20);
        tfuser.setPromptText("(Escriba su usuario aqui)");
        tfuser.setMaxWidth(Double.MAX_VALUE);
        
        paneUsuario.getChildren().addAll(lbl1,tfuser);
        
        Label lbl2 = new Label("Contraseña: ");
        lbl2.setAlignment(Pos.CENTER);
        lbl2.setPrefWidth(100);
        
        
        TextField tfcontrasena = new TextField();
        tfcontrasena.setPrefColumnCount(20);
        tfcontrasena.setPromptText("(Escriba su clave aqui)");
        tfcontrasena.setMaxWidth(Double.MAX_VALUE);
        
        paneContrasena.getChildren().addAll(lbl2,tfcontrasena);
        
        Button btnLogin = new Button();
        btnLogin.setText("Login");
        btnLogin.setOnAction(e -> buttonLogin(tfuser,tfcontrasena));
        
        paneAll.getChildren().addAll(paneUsuario,paneContrasena);
        
        
        
        root.getChildren().addAll(paneTope,paneAll,btnLogin);
        root.setAlignment(Pos.CENTER);
        root.setOrientation(Orientation.VERTICAL);
        root.setCenterShape(true);
        
    }
    
    public void buttonLogin(TextField user, TextField contrasena){
        Boolean b = true;
        
        char c = ' ';
        
        String usuario = user.getText();
        String clave = contrasena.getText();
        
        for (Usuario u : UIUsuario.getUsuarios()) {
            if(usuario.equals(u.getUsuario()) && clave.equals(u.getClave())){
                b = false;
                c = u.getPerfil();
                break;
            }
        }
        if(b) {
            MessageBox.show("Usuario o contraseña incorrecta!!!", "Warning");
        } else {
            user.clear();
            contrasena.clear();
            switch(c){
                case 'A':
                    SceneAdministrador sca = new SceneAdministrador(stage);
                    stage.setScene(sca.getGeneralScene());
                    break;
                case 'P':
                    ScenePlanificador scp= new ScenePlanificador(stage);
                    stage.setScene(scp.getGeneralScene());
                    break;
                case 'C':
                    SceneCliente scc = new SceneCliente(stage);
                    stage.setScene(scc.getGeneralScene());
                    break;
            }
        }
        
    }
}
