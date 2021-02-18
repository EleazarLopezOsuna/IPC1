package proyecto2_201700893;

/**
 *
 * @author Eleazar Jarez López Osuna
 */
public class Estampas {
    private String ruta;
    private int cod, cod_jugador, cod_equipo, rareza;
    
    public Estampas(int cod, int cod_jugador, int cod_equipo, int rareza, String ruta){
        this.cod = cod;
        this.cod_jugador = cod_jugador;
        this.cod_equipo = cod_equipo;
        this.rareza = rareza;
        this.ruta = ruta;
    }
    
    public int getCod(){
        return cod;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public int getCodJugador(){
        return cod_jugador;
    }
    public void setCodJugador(int cod_jugador){
        this.cod_jugador = cod_jugador;
    }
    
    public int getCodEquipo(){
        return cod_equipo;
    }
    public void setCodEquipo(int cod_equipo){
        this.cod_equipo = cod_equipo;
    }
    
    public int getRareza(){
        return rareza;
    }
    public void setRareza(int rareza){
        this.rareza = rareza;
    }
    
    public String getRuta(){
        return ruta;
    }
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
}
