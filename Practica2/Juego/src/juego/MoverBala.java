/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class MoverBala extends Thread {

    int numeroLabel;
    String nombre;

    public MoverBala(String msg, int componente, String nombre) {
        super(msg);
        this.numeroLabel = componente;
        this.nombre = nombre;
        this.start();
    }

    @Override
    public void run() {
        boolean llego = true;
        Juego.panelAux.validate();
        int posicionInicialenX;
        int posicionInicialenY = Juego.panelAux.getComponent(numeroLabel).getY();
        int posicionFinalenX = 1500;
        while (llego) {
            Juego.panelAux.validate();
            if (Juego.panelAux.getComponent(numeroLabel).getX() <= 0) {
                for (int i = 0; i < Juego.panelAux.getComponentCount(); i++) {
                    if (Juego.panelAux.getComponent(i).getName().equals(nombre)) {
                        Juego.panelAux.getComponent(i).setName("NO");
                        Juego.panelAux.getComponent(i).setVisible(false);
                        Juego.panelAux.validate();
                        break;
                    }
                }
                Juego.panelAux.validate();
                llego = false;
            } else if (Juego.panelAux.getComponent(numeroLabel).getX() > 0 && !Juego.panelAux.getComponent(numeroLabel).getName().equals("NO")) {
                posicionInicialenX = Juego.panelAux.getComponent(numeroLabel).getX();
                posicionFinalenX = posicionInicialenX - 5;
                Juego.panelAux.getComponent(numeroLabel).setLocation(posicionFinalenX, posicionInicialenY);
                for (int i = 0; i < Juego.panelAux.getComponentCount(); i++) {
                    Juego.panelAux.validate();
                    if (Juego.panelAux.getComponent(i).getName().contains("Enemigo") && Juego.panelAux.getComponent(i).isVisible() && Juego.panelAux.getComponent(i).isEnabled() == true && Juego.panelAux.getComponent(i).getBackground() != Color.black && !Juego.panelAux.getComponent(numeroLabel).getName().equals("NO") && Juego.panelAux.getComponent(numeroLabel).isVisible()) {
                        //Desde aca se hace la comparacion de posiciones para el impacto de la bala
                        int posicion = posicionInicialenY - Juego.panelAux.getComponent(i).getY();
                        if (Juego.panelAux.getComponent(i).getX() + 50 > posicionFinalenX && (posicion < 50 && posicion > -50)) {
                            if (Juego.panelAux.getComponent(i).getBackground() == Color.green) {
                                for (int j = 0; j < Juego.numeroVidas; j++) {
                                    if (Juego.vida[j].getName().contains(Juego.panelAux.getComponent(i).getName())) {
                                        Juego.vida[j].setValue(66);
                                        Juego.vida[j].setForeground(Color.orange);
                                        Juego.hit.play();
                                    }
                                }
                                Juego.panelAux.getComponent(i).setBackground(Color.blue);
                                Juego.panelAux.getComponent(numeroLabel).setName("NO");
                                Juego.panelAux.getComponent(numeroLabel).setVisible(false);
                                break;
                            } else if (Juego.panelAux.getComponent(i).getBackground() == Color.blue) {
                                for (int j = 0; j < Juego.numeroVidas; j++) {
                                    if (Juego.vida[j].getName().contains(Juego.panelAux.getComponent(i).getName())) {
                                        Juego.vida[j].setValue(33);
                                        Juego.vida[j].setForeground(Color.red);
                                        Juego.hit.play();
                                    }
                                }
                                Juego.panelAux.getComponent(i).setBackground(Color.red);
                                Juego.panelAux.getComponent(numeroLabel).setName("NO");
                                Juego.panelAux.getComponent(numeroLabel).setVisible(false);
                                break;
                            } else if (Juego.panelAux.getComponent(i).getBackground() == Color.red) {
                                for (int j = 0; j < Juego.numeroVidas; j++) {
                                    if (Juego.vida[j].getName().contains(Juego.panelAux.getComponent(i).getName())) {
                                        Juego.vida[j].setValue(10);
                                        Juego.destruir.play();
                                    }
                                }
                                Juego.panelAux.getComponent(i).setBackground(Color.black);
                                int punteo = Integer.parseInt(Juego.jlPunteo.getText());
                                punteo = punteo + 35;
                                Juego.jlPunteo.setText(String.valueOf(punteo));
                                int conteo = Integer.parseInt(Juego.jlEliminadas.getText());
                                conteo++;
                                Juego.jlEliminadas.setText(String.valueOf(conteo));
                                Juego.panelAux.getComponent(numeroLabel).setName("NO");
                                Juego.panelAux.getComponent(numeroLabel).setVisible(false);
                                Juego.panelAux.getComponent(i).setEnabled(false);
                                Juego.panelAux.getComponent(i).setVisible(false);
                                break;
                            }
                        }
                    }
                    if (Juego.panelAux.getComponent(i).getName().contains("Bonus") && Juego.panelAux.getComponent(i).isVisible() && Juego.panelAux.getComponent(i).isEnabled() == true && !Juego.panelAux.getComponent(numeroLabel).getName().equals("NO")) {
                        int posicion = posicionInicialenY - Juego.panelAux.getComponent(i).getY();
                        if (Juego.panelAux.getComponent(i).getX() + 50 > posicionFinalenX && (posicion < 50 && posicion > -50)) {
                            Juego.panelAux.getComponent(numeroLabel).setName("NO");
                            Juego.panelAux.getComponent(numeroLabel).setVisible(false);
                            Juego.panelAux.getComponent(i).setEnabled(false);
                            Juego.panelAux.getComponent(i).setVisible(false);
                            Juego.jlPunteo.setText(String.valueOf(Integer.parseInt(Juego.jlPunteo.getText()) + 50));
                            Juego.hit.play();
                        }
                    }
                    if (Juego.panelAux.getComponent(i).getName().contains("Penalizacion") && Juego.panelAux.getComponent(i).isVisible() && Juego.panelAux.getComponent(i).isEnabled() == true && !Juego.panelAux.getComponent(numeroLabel).getName().equals("NO")) {
                        int posicion = posicionInicialenY - Juego.panelAux.getComponent(i).getY();
                        if (Juego.panelAux.getComponent(i).getX() + 50 > posicionFinalenX && (posicion < 50 && posicion > -50)) {
                            Juego.panelAux.getComponent(numeroLabel).setName("NO");
                            Juego.panelAux.getComponent(numeroLabel).setVisible(false);
                            Juego.panelAux.getComponent(i).setEnabled(false);
                            Juego.panelAux.getComponent(i).setVisible(false);
                            Juego.jlPunteo.setText(String.valueOf(Integer.parseInt(Juego.jlPunteo.getText()) - 30));
                            Juego.hit.play();
                        }
                    }
                }
            }
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoverBala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
