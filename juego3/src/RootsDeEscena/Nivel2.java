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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class Nivel2 extends Nivel{
    
    private PathTransition transHLevel2;
    private PathTransition transHLevel2_1;
    private Rectangle rectangle;
    
    /**
     * Constructor de Nivel2
     */
    public Nivel2(){
        super();
        inicializar();
        generarRoot();
    }
    /**
     * Metodo para generar roots
     */
    @Override
    public void generarRoot() {
        ImageView fondo = new ImageView(new Image("/image/nivel2.png"));        
        
        
        container.getChildren().addAll(vida,puntaje,vehicle.getElemento(),time.getLb(),rectangle,nivel,crash);
        
        Fondo font = new Fondo();

        rootNivel.getChildren().addAll(fondo,container,font.getTop(),font.getBottom());
        


        
        transHLevel2.play();
        transHLevel2_1.play();
        
        
        
        iniciarTime(vehicle,elements,this,font.getTop(),font.getBottom(),rectangle);
        
       
    }
    /**
     * Metodo para inicializar
     */
    @Override
     public void inicializar(){
        nivel.setText("Nivel 2");
        control = 2;
        life = 3;
        vida.setText("Vidas   "+ life);
        
        puntaje.setText("Puntuacion: "+score);
        
        posiciones = new double[16][2];
        double [][] rec = {{139.0,169.0},{107.0,479.0},{303.0,548.0},{711.0,472.0},{697.0,302.0},{379.0,145.0},{251.0,556.0},
                      {438.0,555.0},{528.0,440.0},{287.0,418.0},{591.0,264.0},{573.0,201.0},{109.0,180.0},{166.0,249.0},
                      {118.0,413.0},{329.0,407.0}};
        System.arraycopy(rec, 0, posiciones, 0, rec.length);
        container.getChildren().removeAll(Auxiliar.obtainImageView(parkPrizes));
        elements.clear();
        prizes.clear();
        parkPrizes.clear();
        setearListaNivel2();
        container.getChildren().addAll(Auxiliar.obtainImageView(elements));
        container.getChildren().addAll(Auxiliar.obtainImageView(parkPrizes));
    }

    /**
     * Metodo para setar lista de nivel2
     */
    private void setearListaNivel2() {
        ArrayList<Elemento> temp = new ArrayList<>();
        Parqueo parkZone = new Parqueo("/image/Pzone.png", 500, 480, 0.0, 110, true);
        Obstaculo ambulancia = new Obstaculo("/image/ambulance.png", 500, 350, -125.0, 64, true);
        Obstaculo policia = new Obstaculo("/image/police.png", 345, 440, -125.0, 50, true);
        Obstaculo hombre = new Obstaculo("/image/man.png", 280, 320, 180.0, 35, true);
        Obstaculo hombre2 = new Obstaculo("/image/man.png", 645, 210, 180.0, 35, true);
        Obstaculo mujer = new Obstaculo("/image/woman.png", 175, 320, 0.0, 42, true);        
        Obstaculo mujer2 = new Obstaculo("/image/woman.png", 645, 250, 180.0, 42, true);
        Obstaculo perro = new Obstaculo("/image/perro.png", 210, 140, 0.0, 30, true);
        Recompensa premio = new Recompensa("/image/premio.png", 450, 150, 0.0, 30, true);
        Recompensa premio1 = new Recompensa("/image/premio.png", 170, 240, 0.0, 30, true);
        Recompensa premio2 = new Recompensa("/image/premio.png", 235, 340, 0.0, 30, true);
        Recompensa premio3 = new Recompensa("/image/premio.png", 410, 290, 0.0, 30, true);
        Recompensa premio4 = new Recompensa("/image/premio.png", 330, 480, 0.0, 30, true);
        Recompensa premio5 = new Recompensa("/image/premio.png", 615, 215, 0.0, 30, true);
        Recompensa premio6 = new Recompensa("/image/premio.png", 365, 235, 0.0, 30, true);
        Recompensa premio7 = new Recompensa("/image/premio.png", 615, 300, 0.0, 30, true);

       parkPrizes.add(parkZone);
       elements.add(mujer2);
       elements.add(ambulancia);
       elements.add(policia);
       elements.add(mujer);
       elements.add(hombre);
       elements.add(hombre2);
       elements.add(perro);
       prizes.add(premio);
       prizes.add(premio1);
       prizes.add(premio2);
       prizes.add(premio3);
       prizes.add(premio4);
       prizes.add(premio5);

        Rectangle rect = new Rectangle();
        rect.setWidth(400);
        rect.setHeight(55);
        rect.setFill(null);
        rect.setStroke(Color.TRANSPARENT);
        
        rectangle = perro.getBorder();
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.relocate(210+210, 140+140);

        transHLevel2 = new PathTransition(Duration.seconds(20), rect, perro.getElemento());
        transHLevel2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transHLevel2.setCycleCount(FadeTransition.INDEFINITE);
        
        transHLevel2_1 = new PathTransition(Duration.seconds(20), rect, rectangle);
        transHLevel2_1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transHLevel2_1.setCycleCount(FadeTransition.INDEFINITE);

        

    }
}
    
