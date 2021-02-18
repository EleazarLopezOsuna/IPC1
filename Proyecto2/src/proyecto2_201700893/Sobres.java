package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class Sobres {

    private int codUsuario, capacidad, colocada;
    private int codEstampas[][];

    public Sobres(int codUsuario, int capacidad, int[][] codEstampas) {
        this.codUsuario = codUsuario;
        this.capacidad = capacidad;
        this.codEstampas = codEstampas;
    }

    public int getCapacidad(){
        return capacidad;
    }
    public void setCapacidad(){
        this.capacidad = capacidad;
    }
    
    public int[][] getEstampas(){
        return codEstampas;
    }
    public void setEstampas(int[][] codEstampas){
        this.codEstampas = codEstampas;
    }
    
    public int getCodUsuario(){
        return codUsuario;
    }
    public void setCodUsuario(int codUsuario){
        this.codUsuario = codUsuario;
    }
}
