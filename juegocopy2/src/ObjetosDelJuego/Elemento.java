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
     * 
     */
    public Elemento(){
        
    }
    /**
     * 
     * @param path
     * @param dimX
     * @param dimY
     * @param posX
     * @param posY 
     */
    public Elemento(String path,double dimX,double dimY, double posX, double posY){
        img = new Image(path);
        elemento = new ImageView(img);
        elemento.setPickOnBounds(true);
        elemento.relocate(posX, posY);
        
    }
    /**
     * 
     * @param path
     * @param posX
     * @param posY
     * @param angulo
     * @param height
     * @param value 
     */
    public Elemento(String path,double posX,double posY, double angulo,double height,boolean value){
        img = new Image(path);
        elemento = new ImageView(img);
        elemento.setPickOnBounds(false);
        elemento.relocate(posX, posY);
        this.compX = posX;
        this.compY = posY;
        elemento.setRotate(angulo);
        elemento.setFitHeight(height);
        elemento.setPreserveRatio(value);
        border = new Rectangle();
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
 * 
 * @return 
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.compX) ^ (Double.doubleToLongBits(this.compX) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.compY) ^ (Double.doubleToLongBits(this.compY) >>> 32));
        return hash;
    }
/**
 * 
 * @param obj
 * @return 
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
     * 
     * @return 
     */
    public Rectangle2D getBoundary() {
        return new Rectangle2D(elemento.getX(), elemento.getY(), elemento.getImage().getWidth(), elemento.getImage().getHeight());
    }
/**
 * 
 * @return 
 */
    public Rectangle getBorder() {
        return border;
    }
/**
 * 
 * @param border 
 */
    public void setBorder(Rectangle border) {
        this.border = border;
    }
    /**
     * 
     * @return 
     */
    public Bounds getBounds(){
        return border.getBoundsInParent();
    }
    /**
     * 
     * @return 
     */
    public Bounds getBounds2(){
        return border.getBoundsInLocal();
    }
    /**
     * 
     * @return 
     */
    public Bounds getBounds3(){
        return border.getLayoutBounds();
    }
    /**
     * 
     * @return 
     */
    public Bounds getBounds1(){
        return elemento.getBoundsInParent();
    }
/**
 * 
 * @return 
 */
    public ImageView getElemento() {
        return elemento;
    }
/**
 * 
 * @param elemento 
 */
    public void setElemento(ImageView elemento) {
        this.elemento = elemento;
    }
/**
 * 
 * @return 
 */
    public String getPath() {
        return path;
    }
/**
 * 
 * @param path 
 */
    public void setPath(String path) {
        this.path = path;
    }
/**
 * 
 * @return 
 */
    public Image getImg() {
        return img;
    }
/**
 * 
 * @param img 
 */
    public void setImg(Image img) {
        this.img = img;
    }
/**
 * 
 * @return 
 */
    public double getPosX() {
        return posX;
    }
/**
 * 
 * @param posX 
 */
    public void setPosX(double posX) {
        this.posX = posX;
    }
/**
 * 
 * @return 
 */
    public double getPosY() {
        return posY;
    }
/**
 * 
 * @param posY 
 */
    public void setPosY(double posY) {
        this.posY = posY;
    }
    
    
    
    
}
