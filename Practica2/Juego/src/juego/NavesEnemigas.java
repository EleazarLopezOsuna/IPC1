/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class NavesEnemigas extends Thread {

    public NavesEnemigas(String msg) {
        super(msg);
        this.start();
    }

    @Override
    public void run() {
        int tiempo = Integer.parseInt(Juego.jlTiempo.getText());
        while (tiempo != 0) {
            int contador = 0;
            int posicion;
            int tiempoRandom;
            Random random = new Random();
            tiempoRandom = 1000 * (1 + random.nextInt(4));
            try {
                sleep(tiempoRandom);
            } catch (InterruptedException ex) {

            }
            posicion = 50 + random.nextInt(475);
            for (int i = 0; i < Juego.panelAux.getComponentCount(); i++) {
                if (Juego.panelAux.getComponent(i).getName().contains("Enemigo")) {
                    contador++;
                }
            }
            tiempo = Integer.parseInt(Juego.jlTiempo.getText());
            if (tiempo != 0) {
                JLabel naveEnemiga = new JLabel("");
                Juego.vida[Juego.numeroVidas] = new JProgressBar();
                ImageIcon balaUsuario = new ImageIcon(getClass().getResource("/imagenes/naveEnemiga.png"));
                ImageIcon iconoBalaUsuario = new ImageIcon(balaUsuario.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
                naveEnemiga.setIcon(iconoBalaUsuario);
                naveEnemiga.setName("Enemigo," + contador);
                Juego.vida[Juego.numeroVidas].setName("Enemigo," + contador + " Vida");
                Juego.vida[Juego.numeroVidas].setValue(100);
                Juego.vida[Juego.numeroVidas].setBounds(0, 40, 50, 10);
                Juego.vida[Juego.numeroVidas].setForeground(Color.green);
                naveEnemiga.add(Juego.vida[Juego.numeroVidas]);
                Juego.numeroVidas++;
                naveEnemiga.setBackground(Color.green);
                Juego.panelAux.add(naveEnemiga);
                naveEnemiga.setBounds(0, posicion, 70, 50);
                Juego.panelAux.validate();
                MoverNaveEnemiga mover = new MoverNaveEnemiga("Mover Nave", naveEnemiga.getName());
            }else{
                
            }
        }
    }

}
