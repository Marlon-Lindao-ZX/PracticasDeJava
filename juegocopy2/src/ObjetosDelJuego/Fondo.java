/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ysrael
 */
public class Fondo {
    
    private Shape top;
    private Shape bottom;
/**
 * 
 */
    public Fondo() {
        getBordes();
    }
    /**
     * 
     */
    public void getBordes(){
        
        Rectangle top1 = new Rectangle();
        top1.setWidth(415);
        top1.setHeight(120);
        top1.setFill(null);
        top1.setStroke(Color.RED);
        Rectangle top4 = new Rectangle();
        top4.setWidth(110);
        top4.setHeight(20);
        top4.setFill(null);
        top4.setStroke(Color.RED);
        Rectangle top2 = new Rectangle();
        top2.setWidth(95);
        top2.setHeight(120);
        top2.setFill(null);
        top2.setStroke(Color.RED);
        Rectangle top3 = new Rectangle();
        top3.setWidth(200);
        top3.setHeight(70);
        top3.setFill(null);
        top3.setStroke(Color.RED);
        Rectangle left1 = new Rectangle();
        left1.setWidth(50);
        left1.setHeight(265);
        left1.setFill(null);
        left1.setStroke(Color.RED);
        Rectangle left2 = new Rectangle();
        left2.setWidth(50);
        left2.setHeight(265);
        left2.setFill(null);
        left2.setStroke(Color.RED);
        Rectangle rigth1 = new Rectangle();
        rigth1.setWidth(50);
        rigth1.setHeight(265);
        rigth1.setFill(null);
        rigth1.setStroke(Color.RED);
        Rectangle rigth2 = new Rectangle();
        rigth2.setWidth(50);
        rigth2.setHeight(265);
        rigth2.setFill(null);
        rigth2.setStroke(Color.RED);
        Rectangle botton1 = new Rectangle();
        botton1.setWidth(225);
        botton1.setHeight(70);
        botton1.setFill(null);
        botton1.setStroke(Color.RED);
        Rectangle botton3 = new Rectangle();
        botton3.setWidth(375);
        botton3.setHeight(20);
        botton3.setFill(null);
        botton3.setStroke(Color.RED);
        Rectangle botton2 = new Rectangle();
        botton2.setWidth(200);
        botton2.setHeight(70);
        botton2.setFill(null);
        botton2.setStroke(Color.RED);
        
        
        
        Circle C1 = new Circle(40,40,40);
        C1.setFill(null);
        C1.setStroke(Color.RED);
        Circle C2 = new Circle(40,40,40);
        C2.setFill(null);
        C2.setStroke(Color.RED);
        Circle C3 = new Circle(40,40,40);
        C3.setFill(null);
        C3.setStroke(Color.RED);
        Circle C4 = new Circle(40,40,40);
        C4.setFill(null);
        C4.setStroke(Color.RED);
        
        Pane root = new Pane();
        root.getChildren().addAll(top1,top2,top3,left1,left2,botton1,
                botton2,rigth1,rigth2,C1,C2,C3,C4);
//        top1.relocate(0, 0);
//        top4.relocate(415, 0);
//        top2.relocate(525, 0);
//        top3.relocate(600, 0);
        top4.setLayoutX(415);
        top4.setLayoutY(0);
        top2.setLayoutX(525);
        top2.setLayoutY(0);
        top3.setLayoutX(600);
        top3.setLayoutY(0);      
//        left1.relocate(0, 0);
//        left2.relocate(0, 330);
//        botton1.relocate(0,530);
//        botton2.relocate(530, 530);
//        botton3.relocate(225, 580);
        left2.setLayoutX(0);
        left2.setLayoutY(330);
        botton1.setLayoutX(0);
        botton1.setLayoutY(530);
        botton2.setLayoutX(600);
        botton2.setLayoutY(530);
        botton3.setLayoutX(225);
        botton3.setLayoutY(580);

//        rigth1.relocate(750, 0);
//        rigth2.relocate(750, 325);
//        C1.relocate(25, 185);
//        C2.relocate(25, 329);
//        C3.relocate(710, 200);
//        C4.relocate(710, 317);
        rigth1.setLayoutX(750);
        rigth1.setLayoutY(0);
        rigth2.setLayoutX(750);
        rigth2.setLayoutY(325);
        C1.setLayoutX(25);
        C1.setLayoutY(185);
        C2.setLayoutX(25);
        C2.setLayoutY(329);
        C3.setLayoutX(710);
        C3.setLayoutY(200);
        C4.setLayoutX(710);
        C4.setLayoutY(317);
        
        top = Shape.union(Shape.union(Shape.union(top1, top4), Shape.union(left1, C1)),Shape.union(Shape.union(top2, top3),Shape.union(rigth1, C3)) );
        bottom = Shape.union(Shape.union(Shape.union(left2, C2), Shape.union(botton1, botton3)),Shape.union(botton2,Shape.union(rigth2, C4)) );
    
        top.setTranslateY(-165);
        top.setPickOnBounds(false);
        top.setFill(Color.TRANSPARENT);
        
        
        bottom.setTranslateY(165);
        bottom.setPickOnBounds(false);
        bottom.setFill(Color.TRANSPARENT);
        
    
    }
/**
 * 
 * @return 
 */
    public Shape getTop() {
        return top;
    }
/**
 * 
 * @param top 
 */
    public void setTop(Shape top) {
        this.top = top;
    }
/**
 * 
 * @return 
 */
    public Shape getBottom() {
        return bottom;
    }
/**
 * 
 * @param bottom 
 */
    public void setBottom(Shape bottom) {
        this.bottom = bottom;
    }
    
    
    
}
