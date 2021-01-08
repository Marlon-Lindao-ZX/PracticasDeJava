/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;

import Fuentes.ManejoDeArchivos;
import Fuentes.Registro;
import ObjetosDelJuego.Chronometer;
import ObjetosDelJuego.Elemento;
import ObjetosDelJuego.ObjetoFijo;
import ObjetosDelJuego.Obstaculo;
import ObjetosDelJuego.Parqueo;
import ObjetosDelJuego.PoderEspecial;
import ObjetosDelJuego.Premio;
import ObjetosDelJuego.Recompensa;
import ObjetosDelJuego.Vehiculo;
import Sistema.Juego;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author CORE I7
 */
public abstract class Nivel implements Organizable {

    protected StackPane rootNivel;
    protected static ImageView crash;
    protected Pane container;
    protected int counter;
    protected Random temp;
    protected int indice;
    protected int power;
    protected int position;
    protected Vehiculo vehicle;
    protected Chronometer time;
    protected ArrayList<Elemento> prizes;
    protected ArrayList<Elemento> elements;
    protected HashSet<Elemento> parkPrizes;
    protected Timeline tLine;
    protected Timeline tLine2;
    protected Timeline tLine3;
    protected double[][] posiciones;
    protected Label vida;
    protected Label puntaje;
    protected static int score = 0;
    protected static int life = 3;
    protected static int control = 1;
    protected Label nivel;
   
/**
 * Constructor de Nivel
 */
    public Nivel() {
        rootNivel = new StackPane();
        container = new Pane();
        prizes = new ArrayList<>();
        elements = new ArrayList<>();
        parkPrizes = new HashSet<>();
        vehicle = new Vehiculo("/image/CarAereo.png", 0, 280, 50);
        time = new Chronometer();
        vida = new Label("Vidas   " + life);
        vida.setStyle("-fx-text-fill: linear-gradient(#ff6666, #ff0000);-fx-font-weight: bold;"
                + "-fx-font-size: 35px");
        vida.setLayoutX(25);
        vida.setLayoutY(45);
        puntaje = new Label("Puntuacion: " + score);
        puntaje.setStyle("-fx-text-fill: linear-gradient(#f3fc09, #f0f487);-fx-font-weight: bold;"
                + "-fx-font-size: 21px");
        puntaje.setLayoutX(215);
        puntaje.setLayoutY(55);
        temp = new Random();
        nivel = new Label("Nivel 1");
        nivel.setLayoutX(120);
        nivel.setLayoutY(20);
        nivel.setStyle("-fx-text-fill: linear-gradient(#000099, #9966ff);-fx-font-weight: bold;"
                + "-fx-font-size: 15px");
        crash = new ImageView(new Image("/image/explotion.png",30,30,true,true));
        crash.setLayoutX(20);
        crash.setLayoutY(20);
        
        
    }
/**
 * Metodo para inciar time
 * @param car auto
 * @param list1 arrelgo de elementos
 * @param level nivel
 * @param nodes nodos
 */
    public void iniciarTime(Vehiculo car, ArrayList<Elemento> list1, Nivel level,Node ... nodes) {
        counter = 0;
        indice = 0;
        power = 0;
        position = 0;

        tLine = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            checkBounds(car, list1, nodes);
        }));
        tLine.setCycleCount(Animation.INDEFINITE);

        tLine2 = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            counter++;
            if ((counter % 5000) == 0) {
                indice = temp.nextInt(prizes.size());
                if (parkPrizes.add(prizes.get(indice))) {
                    container.getChildren().add(prizes.get(indice).getElemento());
                    ((Premio) prizes.get(indice)).play(this);
                }

            }

            checkBounds2(car);
        }));
        tLine2.setCycleCount(Animation.INDEFINITE);

        tLine3 = new Timeline(new KeyFrame(Duration.seconds(12), e -> {
            power = temp.nextInt(3);
            position = temp.nextInt(posiciones.length);
            String s = "/image/";
            switch (power) {
                case 0:
                    s += "liveup.png";
                    break;
                case 1:
                    s += "special.png";
                    break;
                case 2:
                    s += "freeze.png";
                    break;
            }

            PoderEspecial poder = new PoderEspecial(s, posiciones[position][0], posiciones[position][1], 0.0, 30, true, power);
            container.getChildren().add(poder.getElemento());
            poder.play(level);
        }));
        tLine3.setCycleCount(Animation.INDEFINITE);

    }
/**
 * Metodo para revisar los bounds
 * @param auto auto
 * @param elementos arreglo de elementos
 * @param nodes nodos
 */
    public void checkBounds(Vehiculo auto, ArrayList<Elemento> elementos, Node... nodes) {

        for (Elemento element : elementos) {
            if (element instanceof Obstaculo) {
                if (auto.getBounds1().intersects(element.getBounds1())) {
                    Shape intersect = Shape.intersect(auto.getBorder(), element.getBorder());
                    if (intersect.getBoundsInLocal().getWidth()  != -1) {
                        auto.setVivo(false);
                        auto.getElemento().setRotate(Math.toDegrees(Math.atan2(0,0)));
                        auto.getBorder().setRotate(Math.toDegrees(Math.atan2(0,0)));
                        auto.getTimer().stop();
                        System.out.println("collision detected");
                        auto.getElemento().relocate(-auto.getPosX(), (280 - auto.getPosY()));
                        auto.getBorder().relocate(-auto.getPosX(), (280 - auto.getPosY()));
                        auto.setGiro(0);
                        auto.setAngulo(0);
                        auto.setVelocity(0);
                        
                        Runnable task1 = () -> runTask1(auto);
                        Thread thread1 = new Thread(task1);
                        thread1.setDaemon(true);
                        thread1.start();
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < nodes.length; i++) {
            if ((nodes[i].getBoundsInParent().intersects(auto.getBounds()))) {
                if (nodes[i] instanceof Shape) {
                    Shape intersect = Shape.intersect((Shape) (nodes[i]), auto.getBorder());
                    if (intersect.getBoundsInLocal().getWidth() != -1) {
                        auto.setVivo(false);
                        auto.setAngulo(0);
                        auto.setGiro(0);
                        auto.setVelocity(0);
                        auto.getElemento().setRotate(0);
                        auto.getElemento().setRotate(0);
                        auto.getBorder().setRotate(0);
                        auto.getBorder().setRotate(0);
                        auto.getTimer().stop();

                        System.out.println("collision detected");
//                    auto.getElemento().setRotate(Math.toDegrees(Math.atan2(-280-auto.getPosY(),auto.getPosX())));
//                    auto.getBorder().setRotate(Math.toDegrees(Math.atan2(-280-auto.getPosY(),auto.getPosX())));
                        auto.getBorder().relocate(-auto.getPosX(), (280 - auto.getPosY()));
                        auto.getElemento().relocate(-auto.getPosX(), (280 - auto.getPosY()));

                        auto.setVivo(false);
                        Runnable task1 = () -> runTask1(auto);
                        Thread thread1 = new Thread(task1);
                        thread1.setDaemon(true);
                        thread1.start();

                        break;
                    }
                } 
            }
        }
    }
/**
 * Metodo para revisar los bounds 2
 * @param auto auto
 * @param nodes nodos
 */
    public void checkBounds2(Vehiculo auto, ImageView... nodes) {

        Iterator<Elemento> itr = parkPrizes.iterator();

        while (itr.hasNext()) {
            Elemento temp = itr.next();

            if (temp instanceof Recompensa) {
                if (auto.getBounds().intersects(temp.getBounds())) {
                    container.getChildren().remove(temp.getElemento());
                    itr.remove();
                    score += 100;
                    puntaje.setText("Puntacion: " + score);

                }
            }

            if (temp instanceof Parqueo) {
////                if (temp.getBounds().intersects(auto.getBounds())) {
////                    Shape intersect = Shape.intersect(auto.getBorder(), temp.getBorder());
//                    if(){
//                        
//                    }
//
//                }
                if (temp.getBounds().contains(auto.getBounds())) {
                    System.out.println("is inside!!!");
                    auto.getTimer().stop();
                    auto.setAngulo(0);
                    auto.setVelocity(0);
                    time.getTime().stop();
                    tLine.stop();
                    tLine2.stop();
                    tLine3.stop();
                    Runnable task2 = () -> runTask2(auto);
                    Thread thread2 = new Thread(task2);
                    thread2.setDaemon(true);
                    thread2.start();

                }
            
            }

        }
    }
/**
 * Metodo para inicializar
 */
    public abstract void inicializar();
/**
 * Metodo runTask
 * @param car auto
 */
    private void runTask1(Vehiculo car) {
        try {
            Thread.sleep(10);
            Platform.runLater(() -> {
                life--;
                vida.setText("Vidas   " + life);
//                car.getElemento().setRotate(Math.toDegrees(Math.atan2((280 - car.getPosY()),-car.getPosX())));
//                car.getBorder().setRotate(Math.toDegrees(Math.atan2((280 - car.getPosY()),-car.getPosX())));
                car.setAngulo(0);
                car.setVivo(true);
                car.getTimer().start();

                if (life <= 0) {
                    time.getTime().stop();
                    tLine.stop();
                    tLine2.stop();
                    tLine3.stop();
                    Auxiliar.getPaneF().generarStage();
                    
                }
            });
        } catch (InterruptedException ie) {

        }
    }
/**
 * Metodo runTask2
 * @param car auto
 */
    private void runTask2(Vehiculo car) {
        try {
            Thread.sleep(10);
            Platform.runLater(() -> { 
                time.getTime().stop();
                tLine.stop();
                tLine2.stop();
                tLine3.stop();
                Auxiliar.getPaneE().setTime(Chronometer.getSeconds());
                Auxiliar.getPaneE().setScore(score);
                Auxiliar.getPaneE().setearVentana(control);
                Auxiliar.getPaneE().generarStage();
                car.setVivo(true);
                car.getElemento().relocate(-car.getPosX(), (280 - car.getPosY()));
                car.getBorder().relocate(-car.getPosX(), (280 - car.getPosY()));
                car.getTimer().start();
                

            });
        } catch (InterruptedException ie) {

        }
    }
/**
 * Metodo para empezar
 */
    public void play() {
        tLine.playFromStart();
        tLine2.playFromStart();
        time.doTime();
        tLine3.playFromStart();
    }
    
    
/**
 * Metodo para obtner el imageview
 * @return imageview
 */
    public static ImageView getCrash() {
        return crash;
    }
/**
 * Metodo para setear el imageview
 * @param crash imageview
 */
    public static void setCrash(ImageView crash) {
        Nivel.crash = crash;
    }
/**
 * Metodo para obtener el root del nivel
 * @return root
 */
    public StackPane getRootNivel() {
        return rootNivel;
    }
/**
 * Metodo para setear el root de nivel
 * @param rootNivel root
 */
    public void setRootNivel(StackPane rootNivel) {
        this.rootNivel = rootNivel;
    }
/**
 * Metodo para obtener el vehiculo
 * @return vehiculo
 */
    public Vehiculo getVehicle() {
        return vehicle;
    }
/**
 * Setea el vehiculo
 * @param vehicle 
 */
    public void setVehicle(Vehiculo vehicle) {
        this.vehicle = vehicle;
    }
/**
 * Obtiene el tiempo
 * @return 
 */
    public Chronometer getTime() {
        return time;
    }
/**
 * Setea el tiempo
 * @param time 
 */
    public void setTime(Chronometer time) {
        this.time = time;
    }
/**
 * Obtiene el control
 * @return control
 */
    public static int getControl() {
        return control;
    }
/**
 * Setea el control
 * @param control control
 */
    public static void setControl(int control) {
        Nivel.control = control;
    }

/**
 * Obtiene el container
 * @return container
 */
    public Pane getContainer() {
        return container;
    }
/**
 * Setea el container
 * @param container container
 */
    public void setContainer(Pane container) {
        this.container = container;
    }
/**
 * Obtiene el pizes
 * @return prizes
 */
    public ArrayList<Elemento> getPrizes() {
        return prizes;
    }
/**
 * Setea el prizes
 * @param prizes prizes
 */
    public void setPrizes(ArrayList<Elemento> prizes) {
        this.prizes = prizes;
    }
/**
 * Obtiene el parkprizes
 * @return parkprices
 */
    public HashSet<Elemento> getParkPrizes() {
        return parkPrizes;
    }
/**
 * Setea el parkprizes
 * @param parkPrizes parkprizes
 */
    public void setParkPrizes(HashSet<Elemento> parkPrizes) {
        this.parkPrizes = parkPrizes;
    }
/**
 * Obtiene el line
 * @return line
 */
    public Timeline gettLine() {
        return tLine;
    }
/**
 * Setea el line
 * @param tLine 
 */
    public void settLine(Timeline tLine) {
        this.tLine = tLine;
    }
/**
 * Obtiene el line2
 * @return line2
 */
    public Timeline gettLine2() {
        return tLine2;
    }
/**
 * Setea el line2
 * @param tLine2 line2
 */
    public void settLine2(Timeline tLine2) {
        this.tLine2 = tLine2;
    }
/**
 * Obtiene la vida
 * @return vida
 */
    public Label getVida() {
        return vida;
    }
/**
 * Setea la vida
 * @param vida vida
 */
    public void setVida(Label vida) {
        this.vida = vida;
    }
/**
 * Obtiene el puntaje
 * @return puntaje
 */
    public Label getPuntaje() {
        return puntaje;
    }
/**
 * Setea el puntaje
 * @param puntaje puntaje
 */
    public void setPuntaje(Label puntaje) {
        this.puntaje = puntaje;
    }
/**
 * Obtiene el score
 * @return score
 */
    public static int getScore() {
        return score;
    }
/**
 * Setea el score
 * @param score score
 */
    public static void setScore(int score) {
        Nivel.score = score;
    }
/**
 * Obtiene la vida
 * @return vida
 */
    public static int getLife() {
        return life;
    }
/**
 * Setea la vida
 * @param life 
 */
    public void setLife(int life) {
        Nivel.life = life;
    }
/**
 * Obtiene los elementos
 * @return elementos
 */
    public ArrayList<Elemento> getElements() {
        return elements;
    }
/**
 * Setea los elementos
 * @param elements elementos
 */
    public void setElements(ArrayList<Elemento> elements) {
        this.elements = elements;
    }
    
    
    

}
