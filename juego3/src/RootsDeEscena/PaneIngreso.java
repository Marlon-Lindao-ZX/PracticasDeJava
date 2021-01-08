/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import ObjetosDelJuego.Chronometer;
import Sistema.Juego;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public class PaneIngreso implements Organizable{
    
    private StackPane Panel;
    private HBox cabezera,cuerpo,flechas,campoTexto,botones;
    private BorderPane PanelInf;
    private StackPane seleccion;
    private VBox seleccion2;
    private TextField tfUser;
    private Button jugar,regresar,flecha2;
    private int contador = 0;
    
/**
 * Constructor de PaneIngreso
 */
    public PaneIngreso() {
        Panel =  new StackPane();  
        generarRoot();
    }
    /**
     * Metodo para generar roots
     */
    @Override
    public void generarRoot(){
        
        
        PanelInf = new BorderPane();
        cabezera = new HBox();
        cuerpo = new HBox();
        flechas = new HBox();
        seleccion = new StackPane();
        seleccion2 = new VBox();
        campoTexto = new HBox(20);
        botones = new HBox(40);
        jugar = new Button("Jugar");
        regresar = new Button("Regresar");
        ImageView[] imagenes = new ImageView[4];
        
        
        ImageView titulo = new ImageView(new Image("/image/CarSelection.png"));
        ImageView flecha1 = new ImageView(new Image("/image/flecha.png"));
        flecha1.setFitHeight(35.5);
        flecha1.setFitWidth(70);
        ImageView flecha2 = new ImageView(new Image("/image/flecha.png"));
        flecha2.setRotate(flecha2.getRotate() + 180);
        flecha2.setFitHeight(35.5);
        flecha2.setFitWidth(70);
        ImageView fondo = new ImageView(new Image("/image/ciudad.jpg"));
        fondo.setFitHeight(600);
        fondo.setFitWidth(800);
        ImageView carro = new ImageView(new Image("/image/car2.gif"));
        carro.setFitHeight(250);
        carro.setFitWidth(250);
        ImageView camioneta = new ImageView(new Image("/image/camioneta.gif"));
        camioneta.setFitHeight(336);
        camioneta.setFitWidth(520);
        ImageView suv = new ImageView(new Image("/image/suv1.gif"));
        suv.setFitHeight(270);
        suv.setFitWidth(380);
        ImageView carretera = new ImageView(new Image("/image/carretera.jpg"));
        ImageView autouser = new ImageView(new Image("/image/CarAereo.png"));
        autouser.setFitHeight(107);
        autouser.setFitWidth(200);
        imagenes[0] = autouser;
        ImageView autouser1 = new ImageView(new Image("/image/CarAereo1.png"));
        autouser1.setFitHeight(107);
        autouser1.setFitWidth(200);
        imagenes[1] = autouser1;
        ImageView autouser2 = new ImageView(new Image("/image/CarAereo2.png"));
        autouser2.setFitHeight(107);
        autouser2.setFitWidth(200);
        imagenes[2] = autouser2;
        ImageView autouser3 = new ImageView(new Image("/image/CarAereo3.png"));
        autouser3.setFitHeight(85);
        autouser3.setFitWidth(200);
        imagenes[3] = autouser3;
        ImageView controller = imagenes[0];
        
        Text tUser = new Text("Usuario");
        tUser.setStyle("-fx-font: 20px Tahoma;"
                + "-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 80%); "
                + "-fx-stroke: linear-gradient(from 0% 0% to 100% 200%, repeat, orange 0%, red 80%);"
                + "-fx-stroke-width: 2");
        
        tfUser = new TextField();
        tfUser.setPromptText("(Escriba su apodo)");
        tfUser.setTooltip(new Tooltip("Ingrese un nombre o apodo"));
        
        campoTexto.getChildren().addAll(tUser,tfUser);
        campoTexto.setAlignment(Pos.CENTER);
        
        
        jugar.setId("jugar");
//        jugar.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
//                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
//                + "-fx-font-weight: bold;-fx-font-size: 19px");
        jugar.setMinSize(100, 40);
        jugar.setTooltip(new Tooltip("Todavia no esta implementado el boton de jugar"));
        
        
        regresar.setId("regresar");
//        regresar.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
//                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
//                + "-fx-font-weight: bold;-fx-font-size: 19px");
        regresar.setMinSize(100, 40);
        
        botones.getChildren().addAll(jugar,regresar);
        botones.setAlignment(Pos.CENTER);
                
        TranslateTransition transCar = new TranslateTransition(Duration.seconds(5), carro);
        transCar.setFromX(Panel.getWidth()- 2*carro.getFitWidth());
	transCar.setToX(1.0 * fondo.getLayoutBounds().getWidth());
	transCar.setCycleCount(TranslateTransition.INDEFINITE);
        transCar.play();
        
        TranslateTransition transSuv = new TranslateTransition(Duration.seconds(7), suv);
        transSuv.setFromX(1.0 * fondo.getLayoutBounds().getWidth());
	transSuv.setToX(Panel.getWidth()-carro.getFitWidth()-2*suv.getFitWidth());
	transSuv.setCycleCount(TranslateTransition.INDEFINITE);
        transSuv.play();
        
        TranslateTransition transCami = new TranslateTransition(Duration.seconds(3), camioneta);
        transCami.setFromX(Panel.getWidth()- 6*camioneta.getFitWidth());
	transCami.setToX(1.0 * fondo.getLayoutBounds().getWidth());
	transCami.setCycleCount(TranslateTransition.INDEFINITE);
        transCami.play();
        
        cabezera.setPadding(new Insets(70,10,10,10));
        cabezera.getChildren().addAll(titulo);
        cabezera.setAlignment(Pos.BASELINE_CENTER);
        
        flechas.getChildren().addAll(flecha1,flecha2);
        flechas.setSpacing(255);
        flechas.setAlignment(Pos.CENTER);
        seleccion.getChildren().addAll(carretera,flechas,controller);
        seleccion.setAlignment(Pos.CENTER);
        
        seleccion2.getChildren().addAll(seleccion,campoTexto,botones);
        seleccion2.setSpacing(15);
        seleccion2.setAlignment(Pos.CENTER);
        cuerpo.getChildren().addAll(seleccion2);
        cuerpo.setSpacing(20);
        cuerpo.setAlignment(Pos.CENTER);
        
        StackPane abajo = new StackPane();
        abajo.getChildren().addAll(carro,suv,camioneta);
        
        PanelInf.setTop(cabezera);
        PanelInf.setCenter(cuerpo);
        PanelInf.setBottom(abajo);
        
        flecha2.setOnMouseClicked((MouseEvent event) -> {
             contador++;
            if (contador > 3) contador = 0;
            controller.setImage(imagenes[contador].getImage());
           
        });
        
        flecha1.setOnMouseClicked((MouseEvent event) -> {
            contador--;
            if (contador < 0) contador = 3;
            controller.setImage(imagenes[contador].getImage());
        });
        
        Panel.getChildren().addAll(fondo,PanelInf);
        
        jugar.setOnAction(e -> {
            Chronometer.setSeconds(120);
            Juego.scene1.setRoot(Auxiliar.getRootLevel1());
            Auxiliar.getLevel1().getVehicle().getElemento().setImage(controller.getImage());
            Auxiliar.getLevel1().play();
        });
        
        regresar.setOnAction(e -> {
             Juego.scene1.setRoot(Juego.organizer1.getRootInicio());
             
             BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
             BackgroundMusic.iniciarThread();
                
        });
        
        Panel.setOnKeyPressed(new EventHandler<KeyEvent>(){
              @Override
              public void handle(KeyEvent event){

                     if (event.getCode() == KeyCode.RIGHT) {
                     jugar.setFocusTraversable(true);
                     } else if (event.getCode() == KeyCode.LEFT) {
                     regresar.setFocusTraversable(true);
                     }else if (event.getCode() == KeyCode.ENTER) {
                          if(jugar.isFocused()){
                              Chronometer.setSeconds(120);
                              Juego.scene1.setRoot(Auxiliar.getRootLevel1());
                              Auxiliar.getLevel1().getVehicle().getElemento().setImage(controller.getImage());
                              Auxiliar.getLevel1().play();
                           }else if (regresar.isFocused()){
                               Juego.scene1.setRoot(Juego.organizer1.getRootInicio());             
                               BackgroundMusic.inicializarTask("src/Fuentes/DJ AG - VOID.mp3");
                               BackgroundMusic.iniciarThread();
                           }
                     }
              }
        });
        
    }
/**
 * Obtiene el panel
 * @return panel
 */
    public StackPane getRoot() {
        return Panel;
    }
/**
 * Setea el panel
 * @param Panel panel
 */
    public void setRoot(StackPane Panel) {
        this.Panel = Panel;
    }
/**
 * Obtiene el TextField user
 * @return TextField
 */
    public TextField getTfUser() {
        return tfUser;
    }
/**
 * Setea el TextField use
 * @param tfUser TextField
 */
    public void setTfUser(TextField tfUser) {
        this.tfUser = tfUser;
    }
    
    
}
