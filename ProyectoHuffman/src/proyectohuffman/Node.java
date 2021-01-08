/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

/**
 *
 * @author Sandra Loayza
 */
public class Node {
    Info info;
    Node izq;
    Node der;
    public Node(Info info){
        this.info = info;
        izq = der = null;
	}

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Node getIzq() {
        return izq;
    }

    public void setIzq(Node izq) {
        this.izq = izq;
    }

    public Node getDer() {
        return der;
    }

    public void setDer(Node der) {
        this.der = der;
    }

    @Override
    public String toString() {
        //return "Node{" + "info=" + info + ", izq=" + izq + ", der=" + der + '}';
        return "Node{"+ info + '}';
    }
    
    
    
    
}
