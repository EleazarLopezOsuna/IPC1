package proyecto1_201700893;

/**
 * Clase Tesis contiene los datos de la tesis
 *
 * @author Eleazar Jared López Osuna
 */
public class Tesis {

    private String Autor, Titulo, Palabras_Clave, Area, Temas, Descripcion;
    private String Edicion, Copias, Disponibles;

    /**
     * Constructor de la clase Tesis
     *
     * @param Autor
     * @param Titulo
     * @param Palabras_Clave
     * @param Area
     * @param Temas
     * @param Descripcion
     * @param Edicion
     * @param Copias
     * @param Disponibles
     */
    
    public Tesis(String Autor, String Titulo, String Palabras_Clave, String Area, String Temas, String Descripcion, String Edicion, String Copias, String Disponibles) {
        this.Autor = Autor;
        this.Titulo = Titulo;
        this.Palabras_Clave = Palabras_Clave;
        this.Area = Area;
        this.Temas = Temas;
        this.Descripcion = Descripcion;
        this.Edicion = Edicion;
        this.Copias = Copias;
        this.Disponibles = Disponibles;
    }

    //Obtener Autor
    public String getAutor() {
        return Autor;
    }

    //Agregar Autor
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    //Obtener Titulo
    public String getTitulo() {
        return Titulo;
    }

    //Agregar Titulo
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    //Obtener Palabras_Clave
    public String getPalabras_Clave() {
        return Palabras_Clave;
    }

    //Agregar Palabras_Clave
    public void setPalabras_Clave(String Palabras_Clave) {
        this.Palabras_Clave = Palabras_Clave;
    }

    //Obtener Area
    public String getArea() {
        return Area;
    }

    //Agregar Area
    public void setArea(String Area) {
        this.Area = Area;
    }

    //Obtener Temas
    public String getTemas() {
        return Temas;
    }

    //Agregar Temas
    public void setTemas(String Temas) {
        this.Temas = Temas;
    }

    //Obtener Descripcion
    public String getDescripcion() {
        return Descripcion;
    }

    //Agregar Descripcion
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    //Obtener Edicion
    public String getEdicion() {
        return Edicion;
    }

    //Agregar Edicion
    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    //Obtener Copias
    public String getCopias() {
        return Copias;
    }

    //Agregar Copias
    public void setCopias(String Copias) {
        this.Copias = Copias;
    }

    //Obtener Disponibles
    public String getDisponibles() {
        return Disponibles;
    }

    //Agregar Disponibles
    public void setDisponibles(String Disponibles) {
        this.Disponibles = Disponibles;
    }
}
