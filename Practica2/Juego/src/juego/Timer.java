/**
 * Aca se generara el Reloj con los 120 segundos de tiempo de juego
 */
package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eleazar Jared López Osuna 201700893
 */
public class Timer extends Thread {

    private int contador;

    public Timer(String msg) {
        super(msg);
        this.start();
    }

    @Override
    public void run() {
        for (contador = 120; contador >= 0; contador--) {
            if (Juego.perdio == true) {
                this.stop();
            }
            try {
                Juego.jlTiempo.setText(String.valueOf(contador));
                if (Juego.jlTiempo.getText().equals("0")) {
                    Juego.perdio = true;
                    for (int i = 1; i < Juego.panelAux.getComponentCount(); i++) {
                        Juego.panelAux.getComponent(i).setVisible(false);
                        Juego.panelAux.getComponent(i).setEnabled(false);
                    }
                    String a = JOptionPane.showInputDialog(Juego.panelAux, "Tiempo Finalizado\nPunteo: " + Juego.jlPunteo.getText() + "\nNaves Eliminadas: " + Juego.jlEliminadas.getText()
                            + "\nIngrese Nombre");
                    try {
                        try (FileWriter fichero = new FileWriter("puntajeMaximo.txt")) {
                            String dato = Juego.jlPunteo.getText();
                            if (Integer.parseInt(dato) > Integer.parseInt(Juego.jlPunteoMaximo.getText())) {
                                if (a.equals("")) {
                                    a = "BBB";
                                }
                                fichero.write(dato + "," + a);
                                fichero.close();
                            } else {
                                try (FileReader lector = new FileReader("puntajeMaximo.txt")) {
                                    BufferedReader br = new BufferedReader(lector);
                                    String datox[] = br.readLine().split(",");
                                    int numero = Integer.parseInt(datox[0]);
                                    Juego.jlPunteoMaximo.setText(String.valueOf(numero));
                                    Juego.jlJugador.setText(datox[1]);
                                    fichero.write(datox[0]+","+datox[1]);
                                }
                            }
                        }
                    } catch (IOException e) {

                    }
                    Juego.jlEliminadas.setText("0");
                    Juego.jlPunteo.setText("0");
                    Juego.perdio = false;
                    Thread timer1 = new Timer("Tiempo");
                    Thread naves = new NavesEnemigas("Naves");
                    Thread ItemBonus = new ItemBonus("Bonus");
                    Thread ItemPenalizacion = new ItemPenalizacion("Penalizacion");
                    Thread estrellas = new agregarEstrellas("Asteroides");
                    try {
                        FileReader lector = new FileReader("puntajeMaximo.txt");
                        BufferedReader br = new BufferedReader(lector);
                        String dato[] = br.readLine().split(",");
                        int numero = Integer.parseInt(dato[0]);
                        Juego.jlPunteoMaximo.setText(String.valueOf(numero));
                        Juego.jlJugador.setText(dato[1]);
                    } catch (IOException e) {

                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }
    }
}
