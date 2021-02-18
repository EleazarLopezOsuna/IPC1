/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MoverNaveEnemiga extends Thread {

    String nombre;

    public MoverNaveEnemiga(String msg, String nombre) {
        super(msg);
        this.nombre = nombre;
        this.start();
    }

    @Override
    public void run() {
        Juego.panelAux.validate();
        boolean llego = true;
        int index = 0;
        int posicionInicialenX;
        int posicionInicialenY;
        int posicionFinalenX;
        while (llego) {
            for (int i = 0; i < Juego.panelAux.getComponentCount(); i++) {
                if (Juego.panelAux.getComponent(i).getName().contains(nombre)) {
                    index = i;
                    break;
                }
            }
            int posicion = Juego.panelAux.getComponent(0).getY() - Juego.panelAux.getComponent(index).getY();
            if (Juego.panelAux.getComponent(index).isVisible()) {
                if (Juego.panelAux.getComponent(index).getX() + 50 >= Juego.panelAux.getComponent(0).getX() && (posicion < 50 && posicion > -50)) {
                    Juego.perdio = true;
                    for (int i = 1; i < Juego.panelAux.getComponentCount(); i++) {
                        Juego.panelAux.getComponent(i).setVisible(false);
                        Juego.jlTiempo.setText("0");
                        Juego.panelAux.getComponent(i).setEnabled(false);
                    }
                    llego = false;
                    String a = JOptionPane.showInputDialog(Juego.panelAux, "Tiempo Finalizado\nPunteo: " + Juego.jlPunteo.getText() + "\nNaves Eliminadas: " + Juego.jlEliminadas.getText()
                            + "\nIngrese Nombre");
                    if (a.isEmpty()) {
                        a = "AAA";
                    }
                    Juego.jlEliminadas.setText("0");
                    try {
                        try (FileWriter fichero = new FileWriter("puntajeMaximo.txt")) {
                            String dato = Juego.jlPunteo.getText();
                            if (Integer.parseInt(dato) > Integer.parseInt(Juego.jlPunteoMaximo.getText())) {
                                fichero.write(dato + "," + a);
                            } else {
//                                try (FileReader lector = new FileReader("puntajeMaximo.txt")) {
//                                    BufferedReader br = new BufferedReader(lector);
//                                    String datox[] = br.readLine().split(",");
//                                    int numero = Integer.parseInt(datox[0]);
//                                    Juego.jlPunteoMaximo.setText(String.valueOf(numero));
//                                    Juego.jlJugador.setText(datox[1]);
//                                    fichero.write(datox[0] + "," + datox[1]);
//                                }
                            }
                            fichero.close();
                        }
                    } catch (IOException e) {

                    }
                    Juego.jlPunteo.setText("0");
                    Juego.perdio = false;
                    Thread timer1 = new Timer("Tiempo");
                    Thread naves = new NavesEnemigas("Naves");
                    Thread ItemBonus = new ItemBonus("Bonus");
                    Thread ItemPenalizacion = new ItemPenalizacion("Penalizacion");
                    Thread estrellas = new agregarEstrellas("Asteroides");
                    try {
                        try (FileReader lector = new FileReader("puntajeMaximo.txt")) {
                            BufferedReader br = new BufferedReader(lector);
                            String dato[] = br.readLine().split(",");
                            int numero = Integer.parseInt(dato[0]);
                            Juego.jlPunteoMaximo.setText(String.valueOf(numero));
                            Juego.jlJugador.setText(dato[1]);
                        }
                    } catch (IOException e) {

                    }
                }
            }
            if (Juego.panelAux.getComponent(index).getX() >= 1275) {
                if (Juego.panelAux.getComponent(index).isVisible()) {
                    Juego.perdio = true;
                    for (int i = 1; i < Juego.panelAux.getComponentCount(); i++) {
                        Juego.panelAux.getComponent(i).setVisible(false);
                        Juego.jlTiempo.setText("0");
                        Juego.panelAux.getComponent(i).setEnabled(false);
                    }
                    llego = false;
                    String a = JOptionPane.showInputDialog(Juego.panelAux, "Tiempo Finalizado\nPunteo: " + Juego.jlPunteo.getText() + "\nNaves Eliminadas: " + Juego.jlEliminadas.getText()
                            + "\nIngrese Nombre");
                    if (a.isEmpty()) {
                        a = "AAA";
                    }
                    Juego.jlEliminadas.setText("0");
                    try {
                        try (FileWriter fichero = new FileWriter("puntajeMaximo.txt")) {
                            String dato = Juego.jlPunteo.getText();
                            if (Integer.parseInt(dato) > Integer.parseInt(Juego.jlPunteoMaximo.getText())) {
                                fichero.write(dato + "," + a);
                            } else {
//                                FileReader lector = new FileReader("puntajeMaximo.txt");
//                                BufferedReader br = new BufferedReader(lector);
//                                String datox[] = br.readLine().split(",");
//                                int numero = Integer.parseInt(datox[0]);
//                                Juego.jlPunteoMaximo.setText(String.valueOf(numero));
//                                Juego.jlJugador.setText(datox[1]);
//                                fichero.write(datox[0] + "," + datox[1]);
                            }
                            fichero.close();
                        }
                    } catch (IOException e) {

                    }
                    Juego.jlPunteo.setText("0");
                    Juego.perdio = false;
                    Thread timer1 = new Timer("Tiempo");
                    Thread naves = new NavesEnemigas("Naves");
                    Thread ItemBonus = new ItemBonus("Bonus");
                    Thread ItemPenalizacion = new ItemPenalizacion("Penalizacion");
                    Thread estrellas = new agregarEstrellas("Asteroides");
                    try {
                        try (FileReader lector = new FileReader("puntajeMaximo.txt")) {
                            BufferedReader br = new BufferedReader(lector);
                            String dato[] = br.readLine().split(",");
                            int numero = Integer.parseInt(dato[0]);
                            Juego.jlPunteoMaximo.setText(String.valueOf(numero));
                            Juego.jlJugador.setText(dato[1]);
                        }
                    } catch (IOException e) {

                    }
                }
            } else {
                posicionInicialenX = Juego.panelAux.getComponent(index).getX();
                posicionInicialenY = Juego.panelAux.getComponent(index).getY();
                posicionFinalenX = posicionInicialenX + 3;
                Juego.panelAux.getComponent(index).setLocation(posicionFinalenX, posicionInicialenY);
            }
            try {
                sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoverBala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
