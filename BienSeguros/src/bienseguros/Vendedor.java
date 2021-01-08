/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bienseguros;

import java.util.ArrayList;

/**
 *
 * @author 
 */
/***
 * clase Vendedor hereda de Empleado
 * 
 * @author CORE I7
 */
public class Vendedor extends Empleado {
    private double valorComision;

    /***
     * constructor vacio de la clase
     */
    public Vendedor() {}
    
    
    /***
     * constructor vendedor llama al constructor del padre y actualiza el sueldo sin
     * el valor de la importacion al seguro
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param sueldo 
     */
    public Vendedor(String cedula, String nombres, String apellidos, double sueldo){
        super(cedula, nombres, apellidos, sueldo);
        this.sueldo = calcularSueldo();
        this.valorComision = 0;
    }
    /***
     * sobreescritura del metodo abstracto heredado del padre
     * metodo que resta al sueldo la importacion del iess 
     * @return double
     */
    @Override
    public double calcularSueldo(){
        return sueldo - (sueldo*0.0945);
    }
    /***
     * para representar en un String los atributos de esta clase
     * @return String 
     */
    @Override
    public String toString(){
        return super.toString();
    }
    
    /***
     * metodo que recibe una lista tipo Venta, y que busca las ventas asociadas 
     * al vendedor para calcular las comisiones correspondientes
     * @param ventas 
     */
    public void calcularComision(ArrayList<Venta> ventas){
        for (Venta venta: ventas){
            if(this.cedula.equals(venta.getVendedor().getCedula())){
                if(venta.getCantidad() >= 10 ){
                    this.valorComision += (venta.getCantidad()/10)*venta.getPlan().getComisionVendedor();   
                }
            }
        }
        this.sueldo += this.valorComision; 
    }
 
    /***
     * getters y setters
     * @return 
     */
    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }
    
    
}
