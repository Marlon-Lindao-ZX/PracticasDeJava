/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import Sistema.Juego;
import static Sistema.Juego.scene2;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public class PaneInicio implements Organizable{
    
    private StackPane rootInicio;
    private BorderPane cuerpo;
    private HBox botones;
    private VBox centro;
    private Button Inicio,Historial,Salir;
/**
 * Constructor de PaneInicio
 */
    public PaneInicio() {
        
        rootInicio = new StackPane();
        generarRoot();
    }

   /**
    * Metodo para generar root
    */
    @Override
    public void generarRoot() {
        
        BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
        BackgroundMusic.iniciarThread();
        
        cuerpo = new BorderPane();
        botones = new HBox();
        centro = new VBox();
        
        ImageView fondo = new ImageView(new Image("/image/ciudad.jpg"));
        fondo.setFitHeight(600);
        fondo.setFitWidth(800);
        ImageView titulo = new ImageView(new Image("/image/Titulo.png"));
        ImageView carro = new ImageView(new Image("/image/car1.gif"));
        carro.setFitHeight(250);
        carro.setFitWidth(250);
        ImageView hombre = new ImageView(new Image("/image/hombre.gif"));
        hombre.setFitHeight(200);
        hombre.setFitWidth(115);
        ImageView perro = new ImageView(new Image("/image/perro1.gif"));
        perro.setFitHeight(177);
        perro.setFitWidth(130);
        
        
        Inicio = new Button("Nuevo Juego");
        Inicio.setId("inicio");
        
        
//        Inicio.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
//                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
//                + "-fx-font-weight: bold;");
        Inicio.setMinSize(100, 50);
        
        Inicio.setOnAction(e -> {
            Juego.scene1.setRoot(Auxiliar.getRootIngreso());
            BackgroundMusic.terminarThread();
                    
        }); 
        
        Historial = new Button("Historial de Juego");
        Historial.setId("historial");
        
//        Historial.setStyle("-fx-background-color: linear-gradient(#f5ff5b, #e6e300);"
//                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" 
//                + "-fx-font-weight: bold;");
        Historial.setMinSize(100, 50);
        
        Historial.setOnAction(e -> {
            
                Juego.scene1.setRoot(Auxiliar.getRootHistorial());
                BackgroundMusic.terminarThread();
                
                
                });
        
     
        
        Salir = new Button("Salir");
        Salir.setId("salir");
        
//        Salir.setStyle("-fx-background-color: linear-gradient(#ff5b5b, #e60000);"
//                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" 
//                + "-fx-font-weight: bold;");
        Salir.setMinSize(100, 50);
        
        Salir.setOnAction(e -> {
            
            Auxiliar.getPaneS().generarStage();
            
            
        });
        
        botones.getChildren().addAll(Inicio,Historial,Salir);
        botones.setAlignment(Pos.BOTTOM_CENTER);
        botones.setSpacing(10);
        
        centro.getChildren().addAll(titulo,botones);
        centro.setAlignment(Pos.CENTER);
        centro.setSpacing(10);
        StackPane abajo = new StackPane();
        abajo.getChildren().addAll(carro,perro,hombre);
        cuerpo.setCenter(centro);
        cuerpo.setBottom(abajo);
        
        TranslateTransition transCar = new TranslateTransition(Duration.seconds(4), carro);
        transCar.setFromX(rootInicio.getWidth()- 2*carro.getFitWidth());
	transCar.setToX(1.0 * fondo.getLayoutBounds().getWidth());
	transCar.setCycleCount(TranslateTransition.INDEFINITE);
        transCar.play();
                        
        TranslateTransition transPerro = new TranslateTransition(Duration.seconds(5), perro);
        transPerro.setFromX(1.0 * fondo.getLayoutBounds().getWidth());
	transPerro.setToX(rootInicio.getWidth()-carro.getFitWidth()-2*perro.getFitWidth());
	transPerro.setCycleCount(TranslateTransition.INDEFINITE);
        transPerro.play();
        
        TranslateTransition transHom = new TranslateTransition(Duration.seconds(10), hombre);
        transHom.setFromX(rootInicio.getWidth()- 6*hombre.getFitWidth());
	transHom.setToX(1.0 * fondo.getLayoutBounds().getWidth());
	transHom.setCycleCount(TranslateTransition.INDEFINITE);
        transHom.play();
        
        
       

        rootInicio.getChildren().addAll(fondo,cuerpo);
        
        rootInicio.setOnKeyPressed(new EventHandler<KeyEvent>(){
              @Override
              public void handle(KeyEvent event){

                     if (event.getCode() == KeyCode.RIGHT) {
                     Inicio.setFocusTraversable(true);
                     } else if (event.getCode() == KeyCode.LEFT) {
                     Salir.setFocusTraversable(true);
                     }else if (event.getCode() == KeyCode.ENTER) {
                          if(Inicio.isFocused()){
                              Juego.scene1.setRoot(Auxiliar.getRootIngreso());
                              BackgroundMusic.terminarThread();
                           }else if (Historial.isFocused()){
                               Juego.scene1.setRoot(Auxiliar.getRootHistorial());
                                BackgroundMusic.terminarThread();
                           }else if (Salir.isFocused()){
                               Auxiliar.getPaneS().generarStage();
                           }
                     }
              }
        });
        
        
        
    }
/**
 * Obtener el root incio
 * @return root
 */
    public StackPane getRootInicio() {
        return rootInicio;
    }
/**
 * Setea el root inicio
 * @param rootInicio root
 */
    public void setRootInicio(StackPane rootInicio) {
        this.rootInicio = rootInicio;
    }
    /**
     * Metodo para salir
     */
    public  void salir(){
        Stage window =new Stage();
        Label mensaje=new Label("Desea salir del juego?");
        Button si=new Button("Si");
        Button no=new Button("No");
        si.setOnAction(e->{
            Platform.exit();
        });
        no.setOnAction(e->{
        window.close();
        });
        
        HBox hbox=new HBox();
        hbox.getChildren().addAll(si,no);
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);
        
        VBox vbox=new VBox();
        vbox.getChildren().addAll(mensaje,hbox);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        
        Scene scene= new Scene(vbox,330,150);
        scene.getStylesheets().add("CSS/estilo1.css");
        window.setScene(scene);
        window.setTitle("Confirmacion");
        window.show();
    }
    
    
    
}
