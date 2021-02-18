package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class NodoEquipo {
    public Equipos equipo;
    NodoEquipo siguiente;
    NodoEquipo anterior;
    
    public NodoEquipo(Equipos equipo){
        this.equipo = equipo;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Equipos getEquipo(){
        return equipo;
    }
    public void setEquipo(Equipos equipo){
        this.equipo = equipo;
    }
    
    public NodoEquipo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoEquipo siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoEquipo getAnterior(){
        return anterior;
    }
    public void setAnterior(NodoEquipo anterior){
        this.anterior = anterior;
    }
}
