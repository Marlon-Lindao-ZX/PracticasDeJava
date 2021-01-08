/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import ObjetosDelJuego.Chronometer;
import ObjetosDelJuego.Elemento;
import ObjetosDelJuego.Fondo;
import ObjetosDelJuego.Obstaculo;
import ObjetosDelJuego.Parqueo;
import ObjetosDelJuego.Recompensa;
import ObjetosDelJuego.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;



/**
 *
 * @author Alex
 */
public class Nivel1 extends Nivel{
    
    /**
     * Constructor de Nivel1
     */
    public Nivel1(){
        super();
        inicializar();
        generarRoot();
    }
    /**
     * Metodo que genera roots
     */
    @Override
    public void generarRoot() {

        ImageView fondo = new ImageView(new Image("/image/nivel1.png"));
        fondo.setPickOnBounds(false);
        
        container.getChildren().addAll(vida,puntaje,vehicle.getElemento(),time.getLb(),nivel,crash);

        Fondo font = new Fondo();

        rootNivel.getChildren().addAll(fondo,container,font.getTop(),font.getBottom());
       

        
        
        iniciarTime(vehicle,elements,this,font.getTop(),font.getBottom());
       
        

    }
    /**
     * Metodo para inicializar
     */
    @Override
     public void inicializar(){
         nivel.setText("Nivel 1");
        score = 0;
        life = 3;
        control = 1;
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
        setearListaNivel1();
        container.getChildren().addAll(Auxiliar.obtainImageView(elements));
        container.getChildren().addAll(Auxiliar.obtainImageView(parkPrizes));
    }
    /**
     * Metodo para setear lista de nivel 1
     */
    private void setearListaNivel1(){
        Parqueo parkZone = new Parqueo("/image/Pzone.png",645,90,-135.0,110,true);
        Obstaculo ambulancia = new Obstaculo("/image/ambulance.png",400,260,90.0,60,true);
        Obstaculo policia = new Obstaculo("/image/police.png",335,330,-90.0,50,true);
        Obstaculo mujer = new Obstaculo("/image/woman.png",170,360,-30.0,42,true);
        Obstaculo hombre = new Obstaculo("/image/man.png",275,305,150.0,35,true);
        Obstaculo hombre2 = new Obstaculo("/image/man.png",600,350,0.0,35,true);
        Obstaculo perro = new Obstaculo("/image/perro.png",480,540,-90.0,30,true);
        Obstaculo perro2 = new Obstaculo("/image/perro.png",620,250,-90.0,30,true);
        Obstaculo perro3 = new Obstaculo("/image/perro.png",100,200,0.0,30,true);
        Recompensa premio = new Recompensa("/image/premio.png",470,150,0.0,30,true);
        Recompensa premio1 = new Recompensa("/image/premio.png",220,150,0.0,30,true);
        Recompensa premio2 = new Recompensa("/image/premio.png",235,340,0.0,30,true);
        Recompensa premio3 = new Recompensa("/image/premio.png",550,150,0.0,30,true);
        Recompensa premio4 = new Recompensa("/image/premio.png",270,480,0.0,30,true);
        Recompensa premio5 = new Recompensa("/image/premio.png",550,300,0.0,30,true);
        Recompensa premio6 = new Recompensa("/image/premio.png",300,400,0.0,30,true);
        Recompensa premio7 = new Recompensa("/image/premio.png",170,200,0.0,30,true);
        
       parkPrizes.add(parkZone);
       elements.add(ambulancia);
       elements.add(policia);
       elements.add(mujer);
       elements.add(hombre);
       elements.add(hombre2);
       elements.add(perro);
       elements.add(perro2);
       elements.add(perro3);
       prizes.add(premio);
       prizes.add(premio1);
       prizes.add(premio2);
       prizes.add(premio3);
       prizes.add(premio4);
       prizes.add(premio5);
       prizes.add(premio6);
       prizes.add(premio7);
       
       
      
    }
}
