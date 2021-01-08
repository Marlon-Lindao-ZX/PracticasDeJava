/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliodigital;

/**
 *
 * @author ACarrera
 */
public class Temporada {
    private int numero;
    private Estados estado;

    public Temporada(int numero) {
        this.numero = numero;
        this.estado = Estados.A;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

   
    
}
