/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EVOTEC
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Calculadora c = new Calculadora();
            double sum = c.Suma(5.1, 10.6, 0.3, 5.5);
            double rest = c.Resta(5.1, 10.6, 0.3, 5.5);
            double mult = c.multiplicacion(5.1, 10.6, 0.3, 5.5);
            double div = c.division(5.1, 10.6, 0.3, 5.5);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
