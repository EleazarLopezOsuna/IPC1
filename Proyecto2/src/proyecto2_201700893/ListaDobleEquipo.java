package proyecto2_201700893;

import java.util.Date;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class ListaDobleEquipo {

    NodoEquipo primero;
    NodoEquipo ultimo;

    public ListaDobleEquipo() {
    }

    public void agregar(int cod, String name, Date date, int mundiales) {

        Equipos act = new Equipos(cod, name, date, mundiales);

        if (primero == null) {
            primero = new NodoEquipo(act);
            ultimo = primero;
        } else {
            NodoEquipo nuevo = new NodoEquipo(act);
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }

    }

    public String buscar(String name) {
        NodoEquipo busqueda = primero;
        int cod = -1;
        String Equipo ="";
        while (busqueda != null) {
            if (busqueda.getEquipo().getName().equals(name)) {
                cod = busqueda.getEquipo().getCod();
                Equipo = busqueda.getEquipo().getName();
                break;
            }else{
                cod = -1;
            }
            busqueda = busqueda.siguiente;
        }
        return cod+","+Equipo;
    }
    
    public boolean buscarEquipo(int codigo) {
        NodoEquipo busqueda = primero;
        boolean encontrado = false;
        while (busqueda != null) {
            if (busqueda.getEquipo().getCod() == codigo) {
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
            busqueda = busqueda.siguiente;
        }
        return encontrado;
    }
    
    public String buscarCodEquipo(int codigo) {
        NodoEquipo busqueda = primero;
        String nombre = "";
        while (busqueda != null) {
            if (busqueda.getEquipo().getCod() == codigo) {
                nombre = busqueda.getEquipo().getName();
                break;
            }else{
                nombre = "";
            }
            busqueda = busqueda.siguiente;
        }
        return nombre;
    }

    public void imprimir() {

        NodoEquipo temp = primero;

        while (temp != null) {
            if (temp.anterior != null) {
                System.out.println("Anterior: " + temp.anterior.getEquipo().getName());
            }
            System.out.println("Actual: " + temp.getEquipo().getName());
            if (temp.siguiente != null) {
                System.out.println("Siguiente: " + temp.siguiente.getEquipo().getName());
            }
            System.out.println("-----------------------------");

            temp = temp.siguiente;
        }

    }
}
