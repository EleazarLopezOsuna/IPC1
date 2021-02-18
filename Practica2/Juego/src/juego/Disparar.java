/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Image;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class Disparar extends Thread {

    public Disparar(String msg) {
        super(msg);
        this.start();
    }

    @Override
    public void run() {
        int index = 0;
        try {
            sleep(50);
        } catch (InterruptedException ex) {

        }
        JLabel label = new JLabel("");
        ImageIcon balaUsuario = new ImageIcon(getClass().getResource("/imagenes/bala.gif"));
        ImageIcon iconoBalaUsuario = new ImageIcon(balaUsuario.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        label.setIcon(iconoBalaUsuario);
        label.setName("Bala" + Juego.numeroDeBalas);
        Juego.numeroDeBalas++;
        Juego.panelAux.add(label);
        Juego.disparo.play();
        index = Juego.panelAux.getComponentCount() - 1;
        Juego.panelAux.validate();
        Juego.panelAux.getComponent(index).setBounds(Juego.navePrincipal.getX() - 40, Juego.navePrincipal.getY(), 50, 50);
        MoverBala mover = new MoverBala("Mover Bala", index, label.getName());

    }
}
