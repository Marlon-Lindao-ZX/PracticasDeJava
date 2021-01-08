/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proceso;

/**
 *
 * @author CORE I7
 */
public class Instruccion {
    private String tipo;
    private String variable;
    
    public Instruccion(String tipo,String variable){
        this.tipo = tipo;
        this.variable = variable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
    
    
}
