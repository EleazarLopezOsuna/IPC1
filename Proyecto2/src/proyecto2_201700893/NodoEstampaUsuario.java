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
public class NodoEstampaUsuario {

    public EstampasUsuarios estampausuario;
    NodoEstampaUsuario siguiente;
    NodoEstampaUsuario anterior;

    public NodoEstampaUsuario(EstampasUsuarios estampausuario) {
        this.estampausuario = estampausuario;
        this.siguiente = null;
        this.anterior = null;
    }

    public EstampasUsuarios getEstampaUsuario() {
        return estampausuario;
    }

    public void setEstampaUsuario(EstampasUsuarios estampausuario) {
        this.estampausuario = estampausuario;
    }

    public NodoEstampaUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstampaUsuario siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEstampaUsuario getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEstampaUsuario anterior) {
        this.anterior = anterior;
    }
}
