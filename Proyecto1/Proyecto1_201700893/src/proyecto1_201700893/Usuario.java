package proyecto1_201700893;

/**
 * Clase Usuario contiene los datos de los usuarios.
 *
 * @author Eleazar Jared López Osuna
 */
public class Usuario {

    private String DPI, Nombre, Apellido, Usuario, Password, Rol;

    /**
     * Constructor de la clase Usuario.
     *
     * @param DPI
     * @param Nombre
     * @param Apellido
     * @param Usuario
     * @param Password
     * @param Rol
     */
    public Usuario(String DPI, String Nombre, String Apellido, String Usuario, String Password, String Rol) {
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Rol = Rol;
    }

    //Obtiene el DPI
    public String getDPI() {
        return DPI;
    }

    //Agrega el DPI
    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    //Obtiene el Nombre
    public String getNombre() {
        return Nombre;
    }

    //Agrega el Nombre
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    //Obtiene el Apellido
    public String getApellido() {
        return Apellido;
    }

    //Agrega el Apellido
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    //Obtiene el Usuario
    public String getUsuario() {
        return Usuario;
    }

    //Agrega el Usuario
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    //Obtiene el Password
    public String getPassword() {
        return Password;
    }

    //Agrega el Password
    public void setPassword(String Password) {
        this.Password = Password;
    }

    //Obtiene el Rol
    public String getRol() {
        return Rol;
    }

    //Agrega el Rol
    public void setRol(String Rol) {
        this.Rol = Rol;
    }
}
