/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

/**
 * interface que tiene 3 metodos booleanos y un metodo String que seran implementados por 
 * la clase Produccion y Libro
 * @author Administrador
 */
public interface Prestable {
    
    float MULTA = 2.50f;
    
    public boolean prestar();
    public boolean devolver();
    public boolean estarDisponible();
    public String obtenerString();
    
}
