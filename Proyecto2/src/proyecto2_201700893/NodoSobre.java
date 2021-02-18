package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class NodoSobre {
    public Sobres sobre;
    NodoSobre siguiente;
    NodoSobre anterior;
    
    public NodoSobre(Sobres sobre){
        this.sobre = sobre;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Sobres getSobre(){
        return sobre;
    }
    public void setSobre(Sobres sobre){
        this.sobre = sobre;
    }
    
    public NodoSobre getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoSobre siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoSobre getAnterior(){
        return anterior;
    }
    public void setAnterior(NodoSobre anterior){
        this.anterior = anterior;
    }
}
