/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author Verónica
 */
public class animationfx  extends Application {
    /**
* @param args the command line arguments
*/
public static void main(String[] args) {
Application.launch(animationfx.class, args);
}

@Override
public void start(Stage primaryStage) {
primaryStage.setTitle("Proyecto Unidad I");
Group root = new Group();
Scene scene = new Scene(root, 400, 300, Color.BLACK);

//Coloca una imagen de fondo
Image d = new Image(animationfx.class.getResource("dia.png").toExternalForm());
ImageView image = new ImageView();
image.setFitWidth(400);
image.setFitHeight(300);
image.setImage(d);
root.getChildren().add(image);
// crea otra imagen sobre puesta
Image no = new Image(animationfx.class.getResource("noche.png").toExternalForm());
ImageView im = new ImageView();
im.setFitWidth(400);
im.setFitHeight(300);
im.setImage(no);
root.getChildren().add(im);

Group Eli = new Group();
Circle eli = new Circle(200, 110, 50);
eli.setFill(Color.GREY);
eli.setStroke(Color.DARKBLUE);

//se crean circulos
Circle sol = new Circle(50);
sol.setFill(Color.WHITE);
sol.setStroke(Color.WHITESMOKE);
sol.setEffect(new BoxBlur(10, 10, 3));

Circle lun = new Circle(31, 400, 50);
lun.setFill(Color.YELLOW);
lun.setStroke(Color.YELLOWGREEN);
lun.setEffect(new BoxBlur(10, 10, 3));

Group star = new Group();
Circle star1 = new Circle(200, 20, 2);
star1.setFill(Color.AQUA);
star1.setStroke(Color.DARKBLUE);
star1.setEffect(new BoxBlur(2, 2, 3));

Circle star2 = new Circle(240, 25, 2);
star2.setFill(Color.AQUA);
star2.setStroke(Color.DARKBLUE);
star2.setEffect(new BoxBlur(2, 2, 3));

Circle star3 = new Circle(280, 20, 2);
star3.setFill(Color.AQUA);
star3.setStroke(Color.DARKBLUE);
star3.setEffect(new BoxBlur(2, 2, 3));

Circle star4 = new Circle(230, 10, 2);
star4.setFill(Color.AQUA);
star4.setStroke(Color.DARKBLUE);
star4.setEffect(new BoxBlur(2, 2, 3));

Circle star5 = new Circle(260, 10, 2);
star5.setFill(Color.AQUA);
star5.setStroke(Color.DARKBLUE);
star5.setEffect(new BoxBlur(2, 2, 3));

Ellipse el = new Ellipse(200, 220, 50, 70);
el.setFill(Color.GRAY);
el.setStroke(Color.DARKBLUE);

Ellipse maniz = new Ellipse(134, 190, 20, 20);
maniz.setFill(Color.GRAY);
maniz.setStroke(Color.DARKBLUE);

Ellipse mande = new Ellipse(266, 190, 20, 20);
mande.setFill(Color.GRAY);
mande.setStroke(Color.DARKBLUE);

Ellipse pieiz = new Ellipse(170, 290, 20, 20);
pieiz.setFill(Color.GRAY);
pieiz.setStroke(Color.DARKBLUE);

Ellipse piede = new Ellipse(230, 290, 20, 20);
piede.setFill(Color.GRAY);
piede.setStroke(Color.DARKBLUE);

Ellipse oreiz = new Ellipse(165, 60, 20, 20);
oreiz.setFill(Color.GRAY);
oreiz.setStroke(Color.DARKBLUE);

Ellipse oreder = new Ellipse(230, 60, 20, 20);
oreder.setFill(Color.GRAY);
oreder.setStroke(Color.DARKBLUE);

Circle ojitoizq = new Circle(185, 110, 5, Color.DARKBLUE);
Circle ojitoder = new Circle(210, 110, 5, Color.DARKBLUE);

Line boca = new Line(190, 135, 205, 135);
boca.setStroke(Color.DARKBLUE);
boca.setStrokeWidth(3);

Line nari = new Line(197, 125, 197, 125);
nari.setStroke(Color.DARKBLUE);
nari.setStrokeWidth(3);


star.getChildren().add(star5);
star.getChildren().add(star4);
star.getChildren().add(star3);
star.getChildren().add(star1);
star.getChildren().add(star2);
Eli.getChildren().add(oreder);
Eli.getChildren().add(oreiz);
Eli.getChildren().add(piede);
Eli.getChildren().add(pieiz);
Eli.getChildren().add(mande);
Eli.getChildren().add(maniz);
Eli.getChildren().add(el);
Eli.getChildren().add(eli);
Eli.getChildren().add(ojitoizq);
Eli.getChildren().add(ojitoder);
Eli.getChildren().add(boca);
Eli.getChildren().add(nari);



// root.getChildren().add(dia);
root.getChildren().add(sol);
root.getChildren().add(lun);
root.getChildren().add(star);
root.getChildren().add(Eli);
primaryStage.setScene(scene);

//Se da la animacion de los objetos

Timeline timeline = new Timeline();///de aki

timeline.getKeyFrames().addAll(
new KeyFrame(new Duration(10000), // set end position at 40s
new KeyValue(sol.translateXProperty(), 460),
new KeyValue(sol.rotateProperty(), 180)));

timeline.getKeyFrames().addAll(
new KeyFrame(new Duration(12000), // set end position at 40s
new KeyValue(star.translateXProperty(), 400),
new KeyValue(star.rotateProperty(), 180)));

timeline.getKeyFrames().addAll(
new KeyFrame(new Duration(15000), // set end position at 40s
new KeyValue(lun.translateYProperty(), -380),
new KeyValue(lun.rotateProperty(), 90)));


timeline.getKeyFrames().addAll(
// new KeyFrame(Duration.ZERO, // set start position at 0
// new KeyValue(image.translateXProperty(), 800),
// new KeyValue(dia.translateYProperty(), 600)
// ),
new KeyFrame(new Duration(10000), // set end position at 40s
new KeyValue(im.translateXProperty(), 460))
);
// play 40s of animation
timeline.play();//asta aki es para animar
primaryStage.show();
}
}
