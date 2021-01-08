/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bienseguros;

/**
 *
 * @author 
 */
public class Venta {
    private Vendedor vendedor;
    private PlanSeguro plan;
    private int cantidad;

    /***
     * Constructor con estos parametros
     * @param vendedor
     * @param plan
     * @param cantidad 
     */
    public Venta(Vendedor vendedor, PlanSeguro plan, int cantidad) {
        this.vendedor = vendedor;
        this.plan = plan;
        this.cantidad = cantidad;
    }

    /***
     * getters y setters de esta clase
     * @return 
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public PlanSeguro getPlan() {
        return plan;
    }

    public void setPlan(PlanSeguro plan) {
        this.plan = plan;
    }

    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}



