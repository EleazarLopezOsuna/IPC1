package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class ListaDobleSobres {
    NodoSobre primero;
    NodoSobre ultimo;
    
    public ListaDobleSobres(){}
    
    public void agregar(int codUsuario, int capacidad, int[][] codEstampas){
        Sobres act = new Sobres(codUsuario,capacidad,codEstampas);
        if (primero == null) {
            primero = new NodoSobre(act);
            ultimo = primero;
        } else {
            NodoSobre nuevo = new NodoSobre(act);
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }
    
    public boolean buscarEstampas(int codUsuario){
        boolean resultado = false;
        NodoSobre busqueda = primero;
        while(busqueda != null){
            if (busqueda.getSobre().getCodUsuario() == codUsuario) {
                resultado = true;
                break;
            } else {
                resultado = false;
            }
            busqueda = busqueda.siguiente;
        }
        return resultado;
    }
}
