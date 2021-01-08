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
    protected static Vehiculo vehicle;
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
   
/**
 * 
 */
    public Nivel() {
        rootNivel = new StackPane();
        container = new Pane();
        prizes = new ArrayList<>();
        elements = new ArrayList<>();
        parkPrizes = new HashSet<>();
        vehicle = new Vehiculo("/image/CarAereo.png", 0, 280, 50);
        time = new Chronometer();
        vida = new Label("Vidas: " + life);
        vida.setLayoutX(10);
        vida.setLayoutY(20);
        temp = new Random();
        puntaje = new Label("Puntuacion: " + score);
        puntaje.setLayoutX(70);
        puntaje.setLayoutY(20);
        
    }
/**
 * 
 * @param car
 * @param list1
 * @param level
 * @param nodes 
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
 * 
 * @param auto
 * @param elementos
 * @param nodes 
 */
    public void checkBounds(Vehiculo auto, ArrayList<Elemento> elementos, Node... nodes) {

        for (Elemento element : elementos) {
            if (element instanceof Obstaculo) {
                if (auto.getBounds().intersects(element.getBounds3())) {
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
 * 
 * @param auto
 * @param nodes 
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
 * 
 */
    public abstract void inicializar();
/**
 * 
 * @param car 
 */
    private void runTask1(Vehiculo car) {
        try {
            Thread.sleep(10);
            Platform.runLater(() -> {
                life--;
                vida.setText("Vidas: " + life);
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
 * 
 * @param car 
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
 * 
 */
    public void play() {
        tLine.playFromStart();
        tLine2.playFromStart();
        time.doTime();
        tLine3.playFromStart();
    }
    
    
/**
 * 
 * @return 
 */
    public static ImageView getCrash() {
        return crash;
    }
/**
 * 
 * @param crash 
 */
    public void setCrash(ImageView crash) {
        Nivel.crash = crash;
    }
/**
 * 
 * @return 
 */
    public StackPane getRootNivel() {
        return rootNivel;
    }
/**
 * 
 * @param rootNivel 
 */
    public void setRootNivel(StackPane rootNivel) {
        this.rootNivel = rootNivel;
    }
/**
 * 
 * @return 
 */
    public static Vehiculo getVehicle() {
        return vehicle;
    }
/**
 * 
 * @param vehicle 
 */
    public void setVehicle(Vehiculo vehicle) {
        Nivel.vehicle = vehicle;
    }
/**
 * 
 * @return 
 */
    public Chronometer getTime() {
        return time;
    }
/**
 * 
 * @param time 
 */
    public void setTime(Chronometer time) {
        this.time = time;
    }

    public static int getControl() {
        return control;
    }

    public static void setControl(int control) {
        Nivel.control = control;
    }

/**
 * 
 * @return 
 */
    public Pane getContainer() {
        return container;
    }
/**
 * 
 * @param container 
 */
    public void setContainer(Pane container) {
        this.container = container;
    }
/**
 * 
 * @return 
 */
    public ArrayList<Elemento> getPrizes() {
        return prizes;
    }
/**
 * 
 * @param prizes 
 */
    public void setPrizes(ArrayList<Elemento> prizes) {
        this.prizes = prizes;
    }
/**
 * 
 * @return 
 */
    public HashSet<Elemento> getParkPrizes() {
        return parkPrizes;
    }
/**
 * 
 * @param parkPrizes 
 */
    public void setParkPrizes(HashSet<Elemento> parkPrizes) {
        this.parkPrizes = parkPrizes;
    }
/**
 * 
 * @return 
 */
    public Timeline gettLine() {
        return tLine;
    }
/**
 * 
 * @param tLine 
 */
    public void settLine(Timeline tLine) {
        this.tLine = tLine;
    }
/**
 * 
 * @return 
 */
    public Timeline gettLine2() {
        return tLine2;
    }
/**
 * 
 * @param tLine2 
 */
    public void settLine2(Timeline tLine2) {
        this.tLine2 = tLine2;
    }
/**
 * 
 * @return 
 */
    public Label getVida() {
        return vida;
    }
/**
 * 
 * @param vida 
 */
    public void setVida(Label vida) {
        this.vida = vida;
    }
/**
 * 
 * @return 
 */
    public Label getPuntaje() {
        return puntaje;
    }
/**
 * 
 * @param puntaje 
 */
    public void setPuntaje(Label puntaje) {
        this.puntaje = puntaje;
    }
/**
 * 
 * @return 
 */
    public static int getScore() {
        return score;
    }
/**
 * 
 * @param score 
 */
    public void setScore(int score) {
        Nivel.score = score;
    }
/**
 * 
 * @return 
 */
    public static int getLife() {
        return life;
    }
/**
 * 
 * @param life 
 */
    public void setLife(int life) {
        Nivel.life = life;
    }
/**
 * 
 * @return 
 */
    public ArrayList<Elemento> getElements() {
        return elements;
    }
/**
 * 
 * @param elements 
 */
    public void setElements(ArrayList<Elemento> elements) {
        this.elements = elements;
    }
    
    /**
     * 
     * @return 
     */
    

}
