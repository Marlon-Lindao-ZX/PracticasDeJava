/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import ObjetosDelJuego.Elemento;
import ObjetosDelJuego.Fondo;
import ObjetosDelJuego.Obstaculo;
import ObjetosDelJuego.Parqueo;
import ObjetosDelJuego.Recompensa;
import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class Nivel3 extends Nivel{
    
    private PathTransition transLevel3;
    private PathTransition transHLevel3;
    private TranslateTransition transPoliLevel3;
    private PathTransition transLevel3_1;
    private PathTransition transHLevel3_1;
    private TranslateTransition transPoliLevel3_1;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    /**
     * 
     */
    public Nivel3(){
        super();
        inicializar();
        generarRoot();
    }
    /**
     * 
     */
    @Override
    public void generarRoot() {
        
        ImageView fondo = new ImageView(new Image("/image/nivel3.png"));        
        
        
        container.getChildren().addAll(vida,puntaje,vehicle.getElemento(),time.getLb(),rectangle1,rectangle2,rectangle3);
        
        Fondo font = new Fondo();

        rootNivel.getChildren().addAll(fondo,container,font.getTop(),font.getBottom());
        rootNivel.setOnMouseClicked(e -> {
            System.out.println(e.getSceneX()+","+e.getSceneY());
        });

        
        transLevel3.play();
        transLevel3_1.play();
        transHLevel3.play();
        transHLevel3_1.play();
        transPoliLevel3.play();
        transPoliLevel3_1.play();
        
        iniciarTime(vehicle,elements,this,font.getTop(),font.getBottom(),rectangle1,
                    rectangle2,rectangle3);
       
    }
    /**
     * 
     */
    @Override
     public void inicializar(){
        control = 3;
        life = 3;
        vida.setText("Vidas: "+ life);
        puntaje.setText("Puntuacion: "+score);
        container.getChildren().removeAll(Auxiliar.obtainImageView(parkPrizes));
        posiciones = new double[16][2];
        double [][] rec = {{139.0,169.0},{107.0,479.0},{303.0,548.0},{711.0,472.0},{697.0,302.0},{379.0,145.0},{251.0,556.0},
                      {438.0,555.0},{528.0,440.0},{287.0,418.0},{591.0,264.0},{573.0,201.0},{109.0,180.0},{166.0,249.0},
                      {118.0,413.0},{329.0,407.0}};
        System.arraycopy(rec, 0, posiciones, 0, rec.length);
        elements.clear();
        prizes.clear();
        parkPrizes.clear();
        setearListaNivel3();
        container.getChildren().addAll(Auxiliar.obtainImageView(elements));
        container.getChildren().addAll(Auxiliar.obtainImageView(parkPrizes));
    }

    /**
     * 
     */
    private void setearListaNivel3() {

        Parqueo parkZone = new Parqueo("/image/Pzone.png", 640, 420, 0.0, 100, true);
        Obstaculo ambulancia = new Obstaculo("/image/ambulance.png", 330, 100, 0.0, 60, true);
        Obstaculo policia = new Obstaculo("/image/police.png", 250, 440, 0.0, 50, true);
        Obstaculo hombre = new Obstaculo("/image/man.png", 130, 150, 0.0, 35, true);
        Obstaculo ambulancia1 = new Obstaculo("/image/ambulance.png", 610, 260, -90.0, 60, true);
        Obstaculo policia2 = new Obstaculo("/image/police.png", 60, 439, -135.0, 50, true);
        Obstaculo hombre4 = new Obstaculo("/image/man.png", 655, 90, 90.0, 35, true);
        Obstaculo hombre3 = new Obstaculo("/image/man.png", 700, 100, 130.0, 35, true);
        Obstaculo hombre2 = new Obstaculo("/image/man.png", 710, 150, 180.0, 35, true);
        
        
        Recompensa premio = new Recompensa("/image/premio.png", 650, 130, 0.0, 30, true);
        Recompensa premio1 = new Recompensa("/image/premio.png", 170, 240, 0.0, 30, true);
        Recompensa premio2 = new Recompensa("/image/premio.png", 170, 340, 0.0, 30, true);
        Recompensa premio3 = new Recompensa("/image/premio.png", 410, 290, 0.0, 30, true);
        Recompensa premio4 = new Recompensa("/image/premio.png", 380, 520, 0.0, 30, true);
        Recompensa premio5 = new Recompensa("/image/premio.png", 570, 290, 0.0, 30, true);

        parkPrizes.add(parkZone);
        elements.add(hombre4);
        elements.add(ambulancia1);
        elements.add(policia2);
        elements.add(hombre3);
        elements.add(hombre2);
        prizes.add(premio);
        prizes.add(premio1);
        prizes.add(premio2);
        prizes.add(premio3);
        prizes.add(premio4);
        prizes.add(premio5);

        Circle path = new Circle(100, 100, 100);
        path.setFill(null);
        path.setStroke(Color.TRANSPARENT);

        Rectangle rect = new Rectangle();
        rect.setWidth(95);
        rect.setHeight(335);
        rect.setFill(null);
        rect.setStroke(Color.TRANSPARENT);

        rectangle1 = ambulancia.getBorder();
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.relocate(660, 200);

        rectangle2 = hombre.getBorder();
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.relocate(260, 300);

        rectangle3 = policia.getBorder();
        rectangle3.setFill(Color.TRANSPARENT);
        rectangle3.relocate(500, 880);

        transLevel3 = new PathTransition(Duration.seconds(2), path, ambulancia.getElemento());
        transLevel3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transLevel3.setCycleCount(FadeTransition.INDEFINITE);
        transLevel3.setAutoReverse(false);

        transHLevel3 = new PathTransition(Duration.seconds(15), rect, hombre.getElemento());
        transHLevel3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transHLevel3.setCycleCount(FadeTransition.INDEFINITE);
        transHLevel3.setAutoReverse(true);

        transPoliLevel3 = new TranslateTransition(Duration.seconds(4), policia.getElemento());
        transPoliLevel3.setFromX(-150);
        transPoliLevel3.setToX(250);
        transPoliLevel3.setCycleCount(TranslateTransition.INDEFINITE);
        transPoliLevel3.setAutoReverse(true);

        transLevel3_1 = new PathTransition(Duration.seconds(2), path, rectangle1);
        transLevel3_1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transLevel3_1.setCycleCount(FadeTransition.INDEFINITE);
        transLevel3_1.setAutoReverse(false);

        transHLevel3_1 = new PathTransition(Duration.seconds(15), rect, rectangle2);
        transHLevel3_1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transHLevel3_1.setCycleCount(FadeTransition.INDEFINITE);
        transHLevel3_1.setAutoReverse(true);

        transPoliLevel3_1 = new TranslateTransition(Duration.seconds(4), rectangle3);
        transPoliLevel3_1.setFromX(-150);
        transPoliLevel3_1.setToX(250);
        transPoliLevel3_1.setCycleCount(TranslateTransition.INDEFINITE);
        transPoliLevel3_1.setAutoReverse(true);


       
    }
}
