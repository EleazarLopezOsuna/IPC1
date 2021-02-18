package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class ListaDobleJugador {

    NodoJugador primero;
    NodoJugador ultimo;

    public ListaDobleJugador() {}
    
    public void agregar(int cod, String nombre, String posicion, int nacimiento, double altura, double peso, int cod_equipo){
        Jugadores act = new Jugadores(cod,nombre,posicion,nacimiento,altura,peso,cod_equipo);
        
        if(primero == null){
            primero = new NodoJugador(act);
            ultimo = primero;
        }else{
            NodoJugador nuevo = new NodoJugador(act);
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }
    
    public String buscar(String name) {
        NodoJugador busqueda = primero;
        int cod = -1;
        int cod_equipo = -1;
        String Equipo ="";
        while (busqueda != null) {
            if (busqueda.getJugador().getNombre().equals(name)) {
                cod = busqueda.getJugador().getCod();
                Equipo = busqueda.getJugador().getNombre();
                cod_equipo = busqueda.getJugador().getCodEquipo();
                break;
            }else{
                cod = -1;
                cod_equipo = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return cod+","+Equipo+","+cod_equipo;
    }
    
    public void imprimir() {

        NodoJugador temp = primero;

        while (temp != null) {
            if (temp.anterior != null) {
                System.out.println("Anterior: " + temp.anterior.getJugador().getNombre());
            }
            System.out.println("Actual: " + temp.getJugador().getNombre());
            if (temp.siguiente != null) {
                System.out.println("Siguiente: " + temp.siguiente.getJugador().getNombre());
            }
            System.out.println("-----------------------------");

            temp = temp.siguiente;
        }
    }
    
    public String buscarCodJugador(int codigo) {
        NodoJugador busqueda = primero;
        String nombre = "";
        while (busqueda != null) {
            if (busqueda.getJugador().getCod() == codigo) {
                nombre = busqueda.getJugador().getNombre();
                break;
            }else{
                nombre = "";
            }
            busqueda = busqueda.siguiente;
        }
        return nombre;
    }
    
    public int buscarCodEquipo(int codigo){
        NodoJugador busqueda = primero;
        int cod = -1;
        while(busqueda!=null){
            if (busqueda.getJugador().getCod() == codigo) {
                cod = busqueda.getJugador().getCodEquipo();
                break;
            }else{
                cod = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return cod;
    }
    
    public boolean buscarJugador(int codigo) {
        NodoJugador busqueda = primero;
        boolean encontrado = false;
        while (busqueda != null) {
            if (busqueda.getJugador().getCod() == codigo) {
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
            busqueda = busqueda.siguiente;
        }
        return encontrado;
    }
}
