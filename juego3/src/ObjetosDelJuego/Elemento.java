/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDelJuego;

import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Alex
 */
public abstract class Elemento {
    
    protected ImageView elemento;
    protected String path;
    protected Image img;
    protected double posX;
    protected double posY;
    protected double compX;
    protected double compY;
    protected Rectangle border;
    protected Rectangle2D as;
    /**
     * Constructor de elemento
     */
    public Elemento(){
        
    }
    /**
     * Constructor de Elemento
     * @param path path
     * @param dimX dimension x
     * @param dimY dimension y
     * @param posX posicion x
     * @param posY posicion y
     */
    public Elemento(String path,double dimX,double dimY, double posX, double posY){
        img = new Image(path);
        elemento = new ImageView(img);
        elemento.setPickOnBounds(true);
        elemento.relocate(posX, posY);
        
    }
    /**
     * Constructor de Elemento
     * @param path path
     * @param posX posicion x
     * @param posY posicion y
     * @param angulo angulo
     * @param height height
     * @param value valor
     */
    public Elemento(String path,double posX,double posY, double angulo,double height,boolean value){
        img = new Image(path);
        elemento = new ImageView(img);
        elemento.setPickOnBounds(false);
        elemento.relocate(posX, posY);
        elemento.setStyle("-fx-background: blue");
        this.compX = posX;
        this.compY = posY;
        elemento.setRotate(angulo);
        elemento.setFitHeight(height);
        elemento.setPreserveRatio(value);
        border = new Rectangle();
        
//        Image img1 = new Image(path);
//        border.setFill(new ImagePattern(img1));
        
        border.setX(posX);
        border.setY(posY);
        border.setRotate(angulo);
        border.setHeight(height);
        double a = ((height*elemento.getImage().getWidth())/elemento.getImage().getHeight());
        border.setWidth(a);
        border.setFill(Color.AQUA);
        border.setPickOnBounds(true);
        
        
 
    }
/**
 * Hashcode
 * @return hascode
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.compX) ^ (Double.doubleToLongBits(this.compX) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.compY) ^ (Double.doubleToLongBits(this.compY) >>> 32));
        return hash;
    }
/**
 * equals
 * @param obj objeto
 * @return verdadero o falso
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (Double.doubleToLongBits(this.compX) != Double.doubleToLongBits(other.compX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.compY) != Double.doubleToLongBits(other.compY)) {
            return false;
        }
        return true;
    }
    
    
    /**
     * obtiene el boundary
     * @return boundary
     */
    public Rectangle2D getBoundary() {
        return new Rectangle2D(elemento.getX(), elemento.getY(), elemento.getImage().getWidth(), elemento.getImage().getHeight());
    }
/**
 * obtiene el border
 * @return border
 */
    public Rectangle getBorder() {
        return border;
    }
/**
 * setea el border
 * @param border border
 */
    public void setBorder(Rectangle border) {
        this.border = border;
    }
    /**
     * obtiene el bounds
     * @return 
     */
    public Bounds getBounds(){
        return border.getBoundsInParent();
    }
    /**
     * obtiene el bounds 2
     * @return bounds
     */
    public Bounds getBounds2(){
        return border.getBoundsInLocal();
    }
    /**
     * obtiene el bounds 3
     * @return bounds
     */
    public Bounds getBounds3(){
        return border.getLayoutBounds();
    }
    /**
     * obtiene el bounds 1
     * @return bounds
     */
    public Bounds getBounds1(){
        return elemento.getBoundsInParent();
    }
    
    public Bounds getBounds4(){
        return elemento.getBoundsInParent();
    }
/**
 * obtiene la imageview
 * @return imageview
 */
    public ImageView getElemento() {
        return elemento;
    }
/**
 * setea la imageview
 * @param elemento imageview
 */
    public void setElemento(ImageView elemento) {
        this.elemento = elemento;
    }
/**
 * obtiene el path
 * @return path
 */
    public String getPath() {
        return path;
    }
/**
 * setea el path
 * @param path path
 */
    public void setPath(String path) {
        this.path = path;
    }
/**
 * obtiene la imagen
 * @return imagen
 */
    public Image getImg() {
        return img;
    }
/**
 * setea la imagen
 * @param img imagen
 */
    public void setImg(Image img) {
        this.img = img;
    }
/**
 * obtiene la posicion x
 * @return posicion
 */
    public double getPosX() {
        return posX;
    }
/**
 * setea la posicion x
 * @param posX posicion
 */
    public void setPosX(double posX) {
        this.posX = posX;
    }
/**
 * obtiene la posicion y
 * @return posicion
 */
    public double getPosY() {
        return posY;
    }
/**
 * setea la posicion y
 * @param posY posicion
 */
    public void setPosY(double posY) {
        this.posY = posY;
    }
    
    
    
    
}
