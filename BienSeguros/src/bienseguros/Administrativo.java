/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bienseguros;

/**
 *Clase Administrativo hereda de Empleado
 * @author 
 */
public class Administrativo extends Empleado{
    
    private boolean jornadaCompleta;
    
    /***
     * Constructor vacio
     */
    public Administrativo(){}
    
    
    /***
     * Constructor que llama al constructor del padre y actualiza el valor de sueldo
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param sueldo
     * @param jornadaCompleta 
     */
    public Administrativo (String cedula, String nombres, String apellidos, double sueldo, boolean jornadaCompleta){
        super(cedula, nombres, apellidos, sueldo);
        this.jornadaCompleta = jornadaCompleta;
        this.sueldo = calcularSueldo();
    }
    
    /***
     * sobreescritura del metodo abstracto heredado del padre
     * metodo que resta al sueldo la importacion del iess 
     * @return 
     */
    @Override
    public double calcularSueldo(){
        return sueldo - (sueldo*0.0945);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }

    /***
     * getters y setters de esta clase
     * @return 
     */
    public boolean isJornadaCompleta() {
        return jornadaCompleta;
    }

    public void setJornadaCompleta(boolean jornadaCompleta) {
        this.jornadaCompleta = jornadaCompleta;
    }

    
    
}
