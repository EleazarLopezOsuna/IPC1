package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class ListaDobleUsuario {

    NodoUsuario primero;
    NodoUsuario ultimo;

    public ListaDobleUsuario() {
    }

    public void agregar(int cod, String name, String lastname, String password) {

        Usuarios act = new Usuarios(cod, name, lastname, password);

        if (primero == null) {
            primero = new NodoUsuario(act);
            ultimo = primero;
        } else {
            NodoUsuario nuevo = new NodoUsuario(act);
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }

    }
    
    public String buscarNomnbre(int cod) {
        String resultado = "";
        NodoUsuario busqueda = primero;
        while (busqueda != null) {
            if (busqueda.getUsuario().getCod() == cod) {
                resultado = busqueda.getUsuario().getName();
                break;
            } else {
                resultado = "";
            }
            busqueda = busqueda.siguiente;
        }
        return resultado;
    }

    public String buscarApellido(int cod) {
        String resultado = "";
        NodoUsuario busqueda = primero;
        while (busqueda != null) {
            if (busqueda.getUsuario().getCod() == cod) {
                resultado = busqueda.getUsuario().getLastname();
                break;
            } else {
                resultado = "";
            }
            busqueda = busqueda.siguiente;
        }
        return resultado;
    }
    
    public boolean buscarCodigo(int cod) {
        boolean resultado = false;
        NodoUsuario busqueda = primero;
        while (busqueda != null) {
            if (busqueda.getUsuario().getCod() == cod) {
                resultado = true;
                break;
            } else {
                resultado = false;
            }
            busqueda = busqueda.siguiente;
        }
        return resultado;
    }

    public String buscar(String name, String password) {
        NodoUsuario busqueda = primero;
        int cod = -1;
        String usuario = "";
        while (busqueda != null) {
            if (busqueda.getUsuario().getName().equals(name) && busqueda.getUsuario().getPassword().equals(password)) {
                cod = busqueda.getUsuario().getCod();
                usuario = busqueda.getUsuario().getName();
                break;
            } else {
                cod = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return cod + "," + usuario;
    }

    public void imprimir() {

        NodoUsuario temp = primero;

        while (temp != null) {
            if (temp.anterior != null) {
                System.out.println("Anterior: " + temp.anterior.getUsuario().getCod());
            }
            System.out.println("Actual: " + temp.getUsuario().getCod());
            if (temp.siguiente != null) {
                System.out.println("Siguiente: " + temp.siguiente.getUsuario().getCod());
            }
            System.out.println("-----------------------------");

            temp = temp.siguiente;
        }

    }
}
