package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class Jugadores {
    private String nombre, posicion;
    private int cod, nacimiento, cod_equipo;
    private double altura, peso;
    
    public Jugadores(int cod, String nombre, String posicion, int nacimiento, double altura, double peso, int cod_equipo){
        this.cod = cod;
        this.nombre = nombre;
        this.posicion = posicion;
        this.nacimiento = nacimiento;
        this.altura = altura;
        this.peso = peso;
        this.cod_equipo = cod_equipo;
    }
    
    public int getCod(){
        return cod;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getPosicion(){
        return posicion;
    }
    public void setPosicion(String posicion){
        this.posicion = posicion;
    }
    
    public int getNacimiento(){
        return nacimiento;
    }
    public void setNacimiento(int nacimiento){
        this.nacimiento = nacimiento;
    }
    
    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public int getCodEquipo(){
        return cod_equipo;
    }
    public void setCodEquipo(){
        this.cod_equipo = cod_equipo;
    }
}
