package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class NodoUsuario {
    public Usuarios usuario;
    NodoUsuario siguiente;
    NodoUsuario anterior;
    
    public NodoUsuario(Usuarios usuario){
        this.usuario = usuario;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Usuarios getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuarios usuario){
        this.usuario = usuario;
    }
    
    public NodoUsuario getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoUsuario siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoUsuario getAnterior(){
        return anterior;
    }
    public void setAnterior(NodoUsuario anterior){
        this.anterior = anterior;
    }
}
