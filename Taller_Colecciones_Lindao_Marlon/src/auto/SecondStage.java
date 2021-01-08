/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author CORE I7
 */
public class SecondStage {
    
    private Stage secondStage;
    private GridPane rootSecond;
    private Scene scene2;
    private ComboBox<Auto> autoSelection;
    
    
    public SecondStage(){
        rootSecond = new GridPane();
        Group gp = new Group();
        scene2 = new Scene(gp,800,600);
        setearElementos();
    }
    
    public void setearElementos(){
        
        VBox cont = new VBox(20);
        cont.setAlignment(Pos.TOP_LEFT);
        VBox cont2 = new VBox(70);
        cont2.setAlignment(Pos.TOP_LEFT);
        
        GridPane subCont = new GridPane();
        subCont.setHgap(15);
        subCont.setVgap(15);
        
        GridPane subCont2 = new GridPane();
        subCont2.setHgap(15);
        subCont2.setVgap(70);
        
        Label order = new Label("Ordenar por: ");
        Label select = new Label("Seleccionar: ");
        
        Label texto = new Label("Estos son los datos del auto seleccionado: ");
        
        Label year = new Label("Anio: ");
        Label price = new Label("Precio: ");
        Label color = new Label("Color: ");
        Label mark = new Label("Marca ");
        
        TextField t_year = new TextField();
        TextField t_price = new TextField();
        TextField t_color = new TextField();
        TextField t_mark = new TextField();
        
        subCont.addColumn(0, year,price,color,mark);
        subCont.addColumn(1, t_year, t_price, t_color, t_mark);
        
        ImageView img = new ImageView();
        img.setFitWidth(150);
        img.setFitHeight(100);
        
        cont.getChildren().addAll(texto,subCont,img);
        
        
        ObservableList<Auto> Lista = FXCollections.observableArrayList(Auxiliar.getAutos());
        autoSelection = new ComboBox<>(Lista);
        autoSelection.getSelectionModel().selectFirst();
        autoSelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Auto>(){
            @Override
            public void changed(ObservableValue<? extends Auto> arg0, Auto arg1, Auto arg2){ 
                Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                        System.out.println(autoSelection.getItems());
                        t_year.setText(arg2.getAnio());
                        t_price.setText(Double.toString(arg2.getPrecio()));
                        t_color.setText(arg2.getColor());
                        t_mark.setText(arg2.getMarca());
                        img.setImage(new Image(TallerU9.class.getResource(arg2.toString() + ".png").toExternalForm()));
                    }
                });
            }
        });
        
        
        ObservableList<String> list = FXCollections.observableArrayList("Placa", "Marca", "Modelo", "Precio",
                "Anio", "Color", "Ubicacion X", "Ubicacion Y");
        ComboBox<String> options = new ComboBox<>(list);
        options.getSelectionModel().selectFirst();
        options.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        int controller = 0;
                        switch (arg2) {
                            case "Placa":
                                controller = 0;
                                break;
                            case "Marca":
                                controller = 1;
                                break;
                            case "Modelo":
                                controller = 2;
                                break;
                            case "Precio":
                                controller = 3;
                                break;
                            case "Anio":
                                controller = 4;
                                break;
                            case "Color":
                                controller = 5;
                                break;
                            case "Ubicacion X":
                                controller = 6;
                                break;
                            case "Ubicacion Y":
                                controller = 7;
                                break;
                        }
                        autoSelection.getItems().sort(new AutoComparator(controller));
                        autoSelection.getSelectionModel().select(0);
                        autoSelection.setValue(autoSelection.getSelectionModel().getSelectedItem());
                    }
                });
            }
        });
        
        subCont2.addColumn(0, order,select);
        subCont2.addColumn(1,options,autoSelection);
        
        HBox contBtn = new HBox(20);
        
        Button btnDelete = new Button("Eliminar");
        btnDelete.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");
        btnDelete.setOnAction(e -> Auxiliar.getDeleter().generarStage());
        
        Button btnConsult = new Button("Consultar");
        btnConsult.setStyle("-fx-background-color: linear-gradient(#67ff5b, #00e620);"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n"
                + "-fx-font-weight: bold;-fx-font-size: 19px");
        btnConsult.setOnAction(e -> scene2.setRoot(Auxiliar.getSecScene().getRootHistorial()));
        
        contBtn.getChildren().addAll(btnDelete,btnConsult);
        
        cont2.getChildren().addAll(subCont2,contBtn);
        
        rootSecond.addColumn(0, cont2);
        rootSecond.addColumn(1, cont);
        rootSecond.setHgap(20);
        rootSecond.setVgap(20);
        rootSecond.setAlignment(Pos.CENTER);
        rootSecond.setStyle("-fx-background-color: lightblue;");
        
        
    }
    
    public void showStage(){
        
        secondStage = new Stage();
        
        scene2.setRoot(rootSecond);
        secondStage.setScene(scene2);
        secondStage.setTitle("informacion de Autos");
        secondStage.setOnCloseRequest(e -> {
            e.consume();
            Auxiliar.getOut().generarStage();
        });
        secondStage.show();
    }

    public ComboBox<Auto> getAutoSelection() {
        return autoSelection;
    }

    public void setAutoSelection(ComboBox<Auto> autoSelection) {
        this.autoSelection = autoSelection;
    }
    
    
    

    
    
    
}
