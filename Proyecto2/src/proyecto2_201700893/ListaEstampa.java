package proyecto2_201700893;

/**
 *
 * @author USER
 */
public class ListaEstampa {
    NodoEstampa primero;
    NodoEstampa ultimo;
    
    public ListaEstampa(){}
    
    public void agregar(int cod, int cod_jugador, int cod_equipo, int rareza, String ruta){
        Estampas act = new Estampas(cod,cod_jugador,cod_equipo,rareza,ruta);
        if (primero == null) {
            primero = new NodoEstampa(act);
            ultimo = primero;
        }else{
            NodoEstampa nuevo = new NodoEstampa(act);
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    
    public void imprimir() {

        NodoEstampa temp = primero;

        while (temp != null) {
            System.out.println("Actual: " + temp.getEstampa().getCod());
            if (temp.siguiente != null) {
                System.out.println("Siguiente: " + temp.siguiente.getEstampa().getCod());
            }
            System.out.println("-----------------------------");

            temp = temp.siguiente;
        }
    }
    
    public boolean buscarCodigo(int cod) {
        boolean resultado = false;
        NodoEstampa busqueda = primero;
        while (busqueda != null) {
            if (busqueda.getEstampa().getCod() == cod) {
                resultado = true;
                break;
            } else {
                resultado = false;
            }
            busqueda = busqueda.siguiente;
        }
        return resultado;
    }
    
    public int buscarEquipo(int cod){
        int codigo = 0;
        NodoEstampa busqueda = primero;
        while(busqueda != null){
            if (busqueda.getEstampa().getCod() == cod) {
                codigo = busqueda.getEstampa().getCodEquipo();
                break;
            } else {
                codigo = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return codigo;
    }
    
    public int buscarJugador(int cod){
        int codigo = 0;
        NodoEstampa busqueda = primero;
        while(busqueda != null){
            if (busqueda.getEstampa().getCod() == cod) {
                codigo = busqueda.getEstampa().getCodJugador();
                break;
            } else {
                codigo = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return codigo;
    }
    
    public int buscarRareza(int cod){
        int codigo = 0;
        NodoEstampa busqueda = primero;
        while(busqueda != null){
            if (busqueda.getEstampa().getCod() == cod) {
                codigo = busqueda.getEstampa().getRareza();
                break;
            } else {
                codigo = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return codigo;
    }
    
    public String buscarRuta(int cod){
        String ruta = "";
        NodoEstampa busqueda = primero;
        while(busqueda != null){
            if (busqueda.getEstampa().getCod() == cod) {
                ruta = busqueda.getEstampa().getRuta();
                break;
            } else {
                ruta = "";
            }
            busqueda = busqueda.siguiente;
        }
        return ruta;
    }
}
