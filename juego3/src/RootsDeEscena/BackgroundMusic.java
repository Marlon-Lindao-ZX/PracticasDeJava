/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootsDeEscena;


import com.sun.deploy.config.Platform;
import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/**
 *
 * @author CORE I7
 */
public class BackgroundMusic {
    
    private static Task task;
    private static Thread threadMusic;
    private static Media sound;
    private static MediaPlayer mediaPlayer;
            
    /**
     * Metodo para iniciar el sonido
     * @param ruta ruta
     */
    public static void inicializarTask(String ruta){
        task = new Task(){
            @Override
            protected Object call(){
                try{                      
                    sound = new Media(new File(ruta).toURI().toString());
                    mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    return null;
                }catch(Exception e){
                    System.out.println("error");
                    return null;
                }
            }
        };
    }
    /**
     * Metodo para inciarl el thread
     */
    public static void iniciarThread(){
        threadMusic = new Thread(task);
        threadMusic.setDaemon(true);
        threadMusic.start();
    }
    /**
     * Metodo para terminar el thread
     */
    public static void terminarThread(){
        try{
            mediaPlayer.stop();
            mediaPlayer.dispose();
            Thread.sleep(2);
            threadMusic.interrupt();
        }catch(InterruptedException ie){
            
        }
        
        
    }
}
