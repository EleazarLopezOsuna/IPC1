package proyecto1_201700893;

/**
 * Clase Prestamo contiene los datos del Prestamo
 * 
 * @author Eleazar Jared López Osuna
 */
public class Prestamo {
    private String Tipo, Autor, Titulo, Dpi, Entregado, Eliminado, Modificado;
    private String Fecha_Prestamo, Fecha_Devolucion;
    private String Edicion;
    /**
     * Constructor de la clase Prestamo
     * 
     * @param Tipo
     * @param Autor
     * @param Titulo
     * @param Edicion
     * @param Fecha_Prestamo
     * @param Fecha_Devolucion
     * @param Dpi
     * @param Entregado
     * @param Eliminado
     * @param Modificado
     */
    public Prestamo(String Tipo, String Autor, String Titulo, String Edicion, String Fecha_Prestamo, String Fecha_Devolucion,String Dpi,String Entregado, String Eliminado, String Modificado){
        this.Tipo = Tipo;
        this.Autor = Autor;
        this.Titulo = Titulo;
        this.Edicion = Edicion;
        this.Fecha_Prestamo = Fecha_Prestamo;
        this.Fecha_Devolucion = Fecha_Devolucion;
        this.Dpi = Dpi;
        this.Entregado = Entregado;
        this.Eliminado = Eliminado;
        this.Modificado = Modificado;
    }
    
    public String getTipo(){
        return Tipo;
    }
    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }
    
    public String getAutor(){
        return Autor;
    }
    public void setAutor(String Autor){
        this.Autor = Autor;
    }
    
    public String getTitulo(){
        return Titulo;
    }
    public void setTitulo(String Titulo){
        this.Titulo = Titulo;
    }
    
    public String getEdicion(){
        return Edicion;
    }
    public void setEdicion(String Edicion){
        this.Edicion = Edicion;
    }
    
    public String getDpi(){
        return Dpi;
    }
    public void setDpi(String Dpi){
        this.Dpi = Dpi;
    }
    
    public String getEntregado(){
        return Entregado;
    }
    public void setEntregado(String Entregado){
        this.Entregado = Entregado;
    }
    
    public String getEliminado(){
        return Eliminado;
    }
    public void setEliminado(String Eliminado){
        this.Eliminado = Eliminado;
    }
    
    public String getModificado(){
        return Modificado;
    }
    public void setModificado(String Modificado){
        this.Modificado = Modificado;
    }
    
    public String getFecha_Prestamo(){
        return Fecha_Prestamo;
    }
    public void setFecha_Prestamo(String Fecha_Prestamo){
        this.Fecha_Prestamo = Fecha_Prestamo;
    }
    
    public String getFecha_Devolucion(){
        return Fecha_Devolucion;
    }
    public void setFecha_Devolucion(String Fecha_Devolucion){
        this.Fecha_Devolucion = Fecha_Devolucion;
    }
}
