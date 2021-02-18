package proyecto2_201700893;

import static proyecto2_201700893.Inicio.*;

/**
 *
 * @author USER
 */
public class ListaCircularDobleEstampaUsuario {

    NodoEstampaUsuario primero;
    NodoEstampaUsuario ultimo;

    public ListaCircularDobleEstampaUsuario() {
    }

    public void agregar(int cod_usuario, int cod_estampa, int pegada, int cantidad) {
        EstampasUsuarios act = new EstampasUsuarios(cod_usuario, cod_estampa, pegada, cantidad);
        if (primero == null) {
            primero = new NodoEstampaUsuario(act);
            ultimo = primero;
        } else {
            NodoEstampaUsuario nuevo = new NodoEstampaUsuario(act);
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
            primero.anterior = ultimo;
        }
    }

    public void imprimir() {

        NodoEstampaUsuario temp = primero;

        do {
            if (temp.anterior != null) {
                System.out.println("Anterior: " + temp.anterior.getEstampaUsuario().getCodEstampa());
            }
            System.out.println("Actual: " + temp.getEstampaUsuario().getCodEstampa());
            if (temp.siguiente != null) {
                System.out.println("Siguiente: " + temp.siguiente.getEstampaUsuario().getCodEstampa());
            }
            System.out.println("-----------------------------");
            temp = temp.siguiente;
        } while (temp != primero);
    }

    public String[] buscarMasPegada(int codigo) {
        String datos[] = new String[5];
        NodoEstampaUsuario temp = primero;
        int contador = 0;
        int cantidad = 0;
        do {
            if (codigo == temp.getEstampaUsuario().getCodUsuario()) {
                if (temp.getEstampaUsuario().getPegada() == 1) {
                    contador++;
                }
                cantidad += temp.getEstampaUsuario().getCantidad();
            }
            temp = temp.siguiente;
        } while (temp != primero);
        datos[0] = String.valueOf(codigo);
        datos[1] = lu.buscarNomnbre(codigo);
        datos[2] = lu.buscarApellido(codigo);
        datos[3] = String.valueOf(cantidad);
        datos[4] = String.valueOf(contador);
        return datos;
    }

    public String[] buscarMenosPegada(int codigo) {
        String datos[] = new String[5];
        NodoEstampaUsuario temp = primero;
        int contador = 0;
        int cantidad = 0;
        do {
            if (codigo == temp.getEstampaUsuario().getCodUsuario()) {
                if (temp.getEstampaUsuario().getPegada() == 0) {
                    contador++;
                }
                cantidad += temp.getEstampaUsuario().getCantidad();
            }
            temp = temp.siguiente;
        } while (temp != primero);
        datos[0] = String.valueOf(codigo);
        datos[1] = lu.buscarNomnbre(codigo);
        datos[2] = lu.buscarApellido(codigo);
        datos[3] = String.valueOf(cantidad);
        datos[4] = String.valueOf(contador);
        return datos;
    }

    public String[] buscarEstampas(int codigo) {
        String datos[] = new String[5];
        NodoEstampaUsuario temp = primero;
        int contador = 0;
        int cantidad = 0;
        do {
            if (codigo == temp.getEstampaUsuario().getCodUsuario()) {
                datos[0] = String.valueOf(codigo);
                datos[1] = lu.buscarNomnbre(codigo);
                datos[2] = lu.buscarApellido(codigo);
                cantidad += temp.getEstampaUsuario().getCantidad();
                contador++;
            }
            temp = temp.siguiente;
        } while (temp != primero);
        datos[3] = String.valueOf(cantidad);
        datos[4] = String.valueOf(contador);
        return datos;
    }

    public boolean buscarPegada(int codigo) {
        boolean resultado = false;
        NodoEstampaUsuario temp = primero;
        do {
            if (codigo == temp.getEstampaUsuario().getCodEstampa()) {
                if (temp.getEstampaUsuario().getPegada() == 0) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }
            temp = temp.siguiente;
        } while (temp != primero);

        return resultado;
    }
}
