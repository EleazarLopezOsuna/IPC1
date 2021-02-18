package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class NodoJugador {
    public Jugadores jugador;
    NodoJugador siguiente;
    NodoJugador anterior;
    
    public NodoJugador(Jugadores jugador){
        this.jugador = jugador;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Jugadores getJugador(){
        return jugador;
    }
    public void setJugador(Jugadores jugador){
        this.jugador = jugador;
    }
    
    public NodoJugador getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoJugador siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoJugador getAnterior(){
        return anterior;
    }
    public void setAnterior(NodoJugador anterior){
        this.anterior = anterior;
    }
}
