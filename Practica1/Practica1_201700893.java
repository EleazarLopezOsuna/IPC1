/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201700893;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Practica1_201700893 {

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static int ingreso, turno = 1, ubicacion, contadorConfiguracion = 0, moviendo, avance, encontrado, casillaAlterada;
    static boolean ciclo = true, activo = true, buscando = true, continuado = false;
    static String[] nombres = new String[3];
    static String[] posicion = new String[50];
    static String jugador1 = " @ ", jugador2 = " # ", jugador3 = " % ", buscar = "";

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        for (int i = 0; i <= 49; i++) {
            switch (i) {
                case 0:
                    posicion[i] = " I ";
                    break;
                case 49:
                    posicion[i] = " F ";
                    break;
                default:
                    posicion[i] = " - ";
                    break;
            }
        }
        do {
            System.out.println("--------------------------------");
            System.out.println("Seleccione una Opcion");
            System.out.println("1.- Ingresar Jugadores");
            System.out.println("2.- Configuracion");
            System.out.println("3.- Iniciar Juego");
            System.out.println("4.- Salir");
            System.out.println("--------------------------------");
            String opcion = br.readLine();
            System.out.println("--------------------------------");
            Boolean verificacion = Practica1_201700893.verificarNumero(opcion);
            if (verificacion) {
                int seleccion = Integer.parseInt(opcion);
                switch (seleccion) {
                    case 1:
                        Practica1_201700893.seleccionJugadores();
                        break;
                    case 2:
                        Practica1_201700893.configuracion();
                        break;
                    case 3:
                        String prueba = Practica1_201700893.verificarInicio();
                        System.out.println(prueba);
                        if (prueba.equals("La partida ha Iniciado")) {
                            ciclo = false;
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:

                        break;
                }
            }
        } while (ciclo);
        boolean alguienGano = false;
        do {
            Practica1_201700893.inicioTurno();
            Practica1_201700893.moverJugador();
            boolean continuar = false;
            boolean enter = false;
            do {
                System.out.println("Ingrese Cantidad a Mover");
                String mover = br.readLine();
                if (!mover.equals("")) {
                    boolean comprobar = Practica1_201700893.verificarNumero(mover);
                    if (comprobar) {
                        int casilla = Integer.parseInt(mover);
                        if (ubicacion + casilla > 49 || ubicacion + casilla <= 0) {
                            System.out.println("Ingrese un Numero Valido");
                            System.out.println("--------------------------------");
                        } else {
                            Practica1_201700893.eliminarPosicion();
                            int cantidadMover;
                            cantidadMover = ubicacion + casilla;
                            Practica1_201700893.validarCasilla(cantidadMover);
                            enter = true;
                        }
                    }
                } else {
                    enter = true;
                }
                System.out.println("--------------------------------");
            } while (enter == false);
            System.out.println("Presione Enter para Continuar");
            System.out.println("Presione P para Pausar el Juego");
            System.out.println("--------------------------------");
            do {
                String a = br.readLine();
                switch (a) {
                    case "":
                        continuar = true;
                        break;
                    case "p":
                        Practica1_201700893.pausa();
                        continuar = continuado;
                        break;
                    case "P":
                        Practica1_201700893.pausa();
                        continuar = continuado;
                        break;
                    default:
                        continuar = false;
                        break;
                }
            } while (continuar == false);
            if (posicion[49].equals(" F ")) {
            } else {
                alguienGano = true;
            }
        } while (alguienGano == false);
        Practica1_201700893.llamarTablero();
        switch (posicion[49]) {
            case " @ ":
                System.out.println("El ganador es: " + nombres[0]);
                break;
            case " # ":
                System.out.println("El ganador es: " + nombres[1]);
                break;
            case " % ":
                System.out.println("El ganador es: " + nombres[2]);
                break;
            default:
                break;
        }
    }

    public static String inicioTurno() {
        Practica1_201700893.llamarTablero();
        avance = avance();
        System.out.println("--------------------------------");
        System.out.println("El jugador " + moviendo + " se Movera " + avance + " Casillas");
        System.out.println("--------------------------------");
        return null;
    }

    public static String pausa() throws IOException {
        continuado = false;
        do {
            System.out.println("Presione 1 para salir del Juego");
            System.out.println("Presione Enter para Regresar al Juego");
            System.out.println("--------------------------------");
            String a = br.readLine();
            switch (a) {
                case "":
                    continuado = true;
                    break;
                case "1":
                    System.exit(0);
                default:
                    continuado = false;
                    break;
            }
        } while (continuado == false);

        return null;
    }

    public static String moverJugador() {
        Practica1_201700893.buscarPosicion();
        Practica1_201700893.eliminarPosicion();
        if (encontrado != 0) {
            int nuevaPosicion = ubicacion + avance;
            if (nuevaPosicion >= 50) {
                posicion[49] = buscar;
            } else {
                Practica1_201700893.validarCasilla(nuevaPosicion);
            }
        } else {
            Practica1_201700893.validarCasilla(avance);
        }
        return null;
    }

    public static int validarCasilla(int casilla) {
        int nuevaCasilla = 0;
        if (!posicion[casilla].equals(" - ")) {
            if (posicion[casilla].equals(jugador1) || posicion[casilla].equals(jugador2) || posicion[casilla].equals(jugador3)) {
                nuevaCasilla = casilla - 1;
                Practica1_201700893.validarCasilla(nuevaCasilla);
            } else if (posicion[casilla].equals(" F ") || posicion[casilla].equals(" I ")) {
                posicion[casilla] = buscar;
            } else {
                nuevaCasilla = Integer.parseInt(posicion[casilla]);
                nuevaCasilla = nuevaCasilla + casilla;
                Practica1_201700893.validarCasilla(nuevaCasilla);
            }
        } else {
            posicion[casilla] = buscar;
            casillaAlterada = casilla;
        }
        return 0;
    }

    public static String eliminarPosicion() {
        int contador = 0;
        do {
            for (int i = 0; i <= 49; i++) {
                if (posicion[i].equals(buscar)) {
                    posicion[i] = " - ";
                    break;
                }
            }
            contador = 1;
        } while (contador == 0);

        return null;
    }

    public static int buscarPosicion() {
        int contador = 0;
        switch (moviendo) {
            case 1:
                buscar = " @ ";
                break;
            case 2:
                buscar = " # ";
                break;
            case 3:
                buscar = " % ";
                break;
            default:
                break;
        }
        do {
            for (int i = 0; i <= 49; i++) {
                if (posicion[i].equals(buscar)) {
                    ubicacion = i;
                    contador++;
                }
                buscando = false;
            }
        } while (buscando == true);
        if (contador != 0) {
            encontrado = 1;
        } else {
            encontrado = 0;
        }
        return encontrado;
    }

    public static int avance() {
        Random casillas = new Random();
        int avanceCasillas = 1 + casillas.nextInt(12);
        return avanceCasillas;
    }

    public static String configuracion() throws IOException {
        System.out.println("Seleccione una Configuracion");
        System.out.println("1.- Subida");
        System.out.println("2.- Bajada");
        System.out.println("3.- Regresar");
        String opcion = br.readLine();
        boolean verificacion = Practica1_201700893.verificarNumero(opcion);
        if (verificacion) {
            int seleccion = Integer.parseInt(opcion);
            switch (seleccion) {
                case 1:
                    Practica1_201700893.ingresoSubida();
                    break;
                case 2:
                    Practica1_201700893.ingresoBajada();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Ingrese una Configuracion Valida");
                    break;
            }
        }
        return null;
    }

    public static String ingresoSubida() throws IOException {
        System.out.println("--------------------------------");
        System.out.println("Ingrese Casilla");
        String casilla = br.readLine();
        boolean verificarCasilla = Practica1_201700893.verificarNumero(casilla);
        if (verificarCasilla) {
            int numeroCasilla = Integer.parseInt(casilla);
            if (numeroCasilla < 50) {
                if (posicion[numeroCasilla - 1].equals(" - ")) {
                    System.out.println("--------------------------------");
                    System.out.println("Ingrese Valor de Subida");
                    String subida = br.readLine();
                    boolean verificarSubida = Practica1_201700893.verificarNumero(subida);
                    if (verificarSubida) {
                        int valorSubida = Integer.parseInt(subida);
                        if (valorSubida > 0) {
                            int comprobacionCasillas = numeroCasilla + valorSubida;
                            if (comprobacionCasillas > 50) {
                                System.out.println("Ingrese un Numero Mas Pequeño");
                                Practica1_201700893.ingresoSubida();
                            } else {
                                if (valorSubida < 10) {
                                    posicion[numeroCasilla - 1] = "+0" + valorSubida;
                                    contadorConfiguracion++;
                                } else {
                                    posicion[numeroCasilla - 1] = "+" + valorSubida;
                                    contadorConfiguracion++;
                                }
                            }
                        } else {
                            System.out.println("Ingrese un Valor Valido");
                            Practica1_201700893.ingresoSubida();
                        }
                    } else {
                        System.out.println("Ingrese un Valor Valido");
                        Practica1_201700893.ingresoSubida();
                    }
                } else {
                    System.out.println("Seleccione Otra Casilla");
                    Practica1_201700893.ingresoSubida();
                }
            } else {
                System.out.println("Ingrese una Casilla entre 1 y 50");
                Practica1_201700893.ingresoSubida();
            }
        } else {
            System.out.println("Ingrese Una Casilla Valida");
            Practica1_201700893.ingresoSubida();
        }
        return null;
    }

    public static String ingresoBajada() throws IOException {
        System.out.println("--------------------------------");
        System.out.println("Ingrese Casilla");
        String casilla = br.readLine();
        boolean verificarCasilla = Practica1_201700893.verificarNumero(casilla);
        if (verificarCasilla) {
            int numeroCasilla = Integer.parseInt(casilla);
            if (numeroCasilla < 50) {
                if (posicion[numeroCasilla - 1].equals(" - ")) {
                    System.out.println("--------------------------------");
                    System.out.println("Ingrese Valor de Bajada");
                    String bajada = br.readLine();
                    boolean verificarBajada = Practica1_201700893.verificarNumero(bajada);
                    if (verificarBajada) {
                        int valorBajada = Integer.parseInt(bajada);
                        if (valorBajada > 0) {
                            int comprobacionCasillas = numeroCasilla - valorBajada;
                            if (comprobacionCasillas < 0) {
                                System.out.println("Ingrese un Numero Mas Pequeño");
                                Practica1_201700893.ingresoSubida();
                            } else {
                                if (valorBajada < 10) {
                                    posicion[numeroCasilla - 1] = "-0" + valorBajada;
                                    contadorConfiguracion++;
                                } else {
                                    posicion[numeroCasilla - 1] = "-" + valorBajada;
                                    contadorConfiguracion++;
                                }
                            }
                        } else {
                            System.out.println("Ingrese un Valor Valido");
                            Practica1_201700893.ingresoSubida();
                        }
                    } else {
                        System.out.println("Ingrese un Valor Valido");
                        Practica1_201700893.ingresoSubida();
                    }
                } else {
                    System.out.println("Seleccione Otra Casilla");
                    Practica1_201700893.ingresoSubida();
                }
            } else {
                System.out.println("Ingrese una Casilla entre 1 y 50");
                Practica1_201700893.ingresoSubida();
            }
        } else {
            System.out.println("Ingrese Una Casilla Valida");
            Practica1_201700893.ingresoSubida();
        }
        return null;
    }

    public static String[] llamarTablero() {
        System.out.println("___________________________________________________");
        do {
            for (int i = 9; i >= 0; i--) {
                switch (i) {
                    case 0:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[4] + "   |   " + posicion[3] + "   |   " + posicion[2] + "   |   " + posicion[1] + "   |   " + posicion[0] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 1:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[5] + "   |   " + posicion[6] + "   |   " + posicion[7] + "   |   " + posicion[8] + "   |   " + posicion[9] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 2:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[14] + "   |   " + posicion[13] + "   |   " + posicion[12] + "   |   " + posicion[11] + "   |   " + posicion[10] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 3:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[15] + "   |   " + posicion[16] + "   |   " + posicion[17] + "   |   " + posicion[18] + "   |   " + posicion[19] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 4:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[24] + "   |   " + posicion[23] + "   |   " + posicion[22] + "   |   " + posicion[21] + "   |   " + posicion[20] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 5:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[25] + "   |   " + posicion[26] + "   |   " + posicion[27] + "   |   " + posicion[28] + "   |   " + posicion[29] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 6:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[34] + "   |   " + posicion[33] + "   |   " + posicion[32] + "   |   " + posicion[31] + "   |   " + posicion[30] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 7:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[35] + "   |   " + posicion[36] + "   |   " + posicion[37] + "   |   " + posicion[38] + "   |   " + posicion[39] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 8:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[44] + "   |   " + posicion[43] + "   |   " + posicion[42] + "   |   " + posicion[41] + "   |   " + posicion[40] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    case 9:
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("|   " + posicion[45] + "   |   " + posicion[46] + "   |   " + posicion[47] + "   |   " + posicion[48] + "   |   " + posicion[49] + "   |");
                        System.out.println("|         |         |         |         |         |");
                        System.out.println("___________________________________________________");
                        break;
                    default:
                        break;
                }
            }
            Practica1_201700893.turno();
            activo = false;
        } while (activo == true);
        return null;
    }

    public static String turno() {
        String accion = "";
        if (ingreso == 2) {
            switch (turno) {
                case 1:
                    accion = jugador1;
                    moviendo = 1;
                    turno = 2;
                    break;
                case 2:
                    accion = jugador2;
                    moviendo = 2;
                    turno = 1;
                    break;
                default:
                    break;
            }
        } else if (ingreso == 3) {
            switch (turno) {
                case 1:
                    accion = jugador1;
                    moviendo = 1;
                    turno = 2;
                    break;
                case 2:
                    accion = jugador2;
                    moviendo = 2;
                    turno = 3;
                    break;
                case 3:
                    accion = jugador3;
                    moviendo = 3;
                    turno = 1;
                    break;
                default:
                    break;
            }
        }
        return accion;
    }

    public static String verificarInicio() throws IOException {
        String evento = "";
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            if (nombres[i] == null) {
                contador++;
            }
        }
        if (contador > 1) {
            evento = "Ingrese Jugadores para Iniciar";
        } else if (contadorConfiguracion == 0) {
            evento = "Ingrese Casillas Especiales en Configuracion para Iniciar";
        } else {
            evento = "La partida ha Iniciado";
        }
        return evento;
    }

    public static String seleccionJugadores() throws IOException {
        String[] mostrar = new String[3];
        System.out.println("Seleccione una Opcion");
        System.out.println("1.- 2 Jugadores");
        System.out.println("2.- 3 Jugadores");
        System.out.println("--------------------------------");
        String opcion = br.readLine();
        System.out.println("--------------------------------");
        Boolean verificacion = Practica1_201700893.verificarNumero(opcion);
        if (verificacion) {
            int seleccion = Integer.parseInt(opcion);
            switch (seleccion) {
                case 1:
                    System.out.println("Usted Selecciono");
                    System.out.println("2 Jugadores");
                    System.out.println("--------------------------------");
                    ingreso = 2;
                    mostrar = ingresoJugadores(ingreso);
                    System.out.println("Jugador @: " + mostrar[0]);
                    System.out.println("Jugador #: " + mostrar[1]);
                    System.out.println("--------------------------------");
                    break;
                case 2:
                    System.out.println("Usted Selecciono");
                    System.out.println("3 Jugadores");
                    ingreso = 3;
                    mostrar = ingresoJugadores(ingreso);
                    System.out.println("Jugador @: " + mostrar[0]);
                    System.out.println("Jugador #: " + mostrar[1]);
                    System.out.println("Jugador %: " + mostrar[2]);
                    System.out.println("--------------------------------");
                    break;
                default:
                    System.out.println("Error, Ingrese un Numero Correcto");
                    Practica1_201700893.seleccionJugadores();
            }
        } else {
            System.out.println("Error, Ingrese un Numero Correcto");
            Practica1_201700893.seleccionJugadores();
        }
        return null;
    }

    public static String[] ingresoJugadores(int numeroJugadores) throws IOException {
        int a = numeroJugadores;
        for (int i = 0; i < numeroJugadores; i++) {
            String nombre = null;
            System.out.println("Ingrese el Nombre del Jugador Numero: " + (i + 1));
            System.out.println("--------------------------------");
            nombre = br.readLine();
            System.out.println("--------------------------------");
            if (nombre.length() == 0) {
                System.out.println("Ingrese Un Nombre Valido");
                Practica1_201700893.ingresoJugadores(a);
                break;
            }
            nombres[i] = nombre;
        }
        return (nombres);
    }

    public static boolean verificarNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
