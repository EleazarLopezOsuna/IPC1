/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201700893;

/**
 *
 * @author USER
 */
public class NodoEstampa {
    public Estampas estampa;
    NodoEstampa siguiente;
    
    public NodoEstampa(Estampas estampa){
        this.estampa = estampa;
        this.siguiente = null;
    }
    
    public Estampas getEstampa(){
        return estampa;
    }
    public void setEstampa(Estampas estampa){
        this.estampa = estampa;
    }
    
    public NodoEstampa getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoEstampa siguiente){
        this.siguiente = siguiente;
    }
}
