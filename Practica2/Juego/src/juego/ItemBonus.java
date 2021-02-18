/**
 * Aca se generara el Reloj con los 120 segundos de tiempo de juego
 */
package juego;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Eleazar Jared López Osuna 201700893
 */
public class ItemBonus extends Thread {

    public ItemBonus(String msg) {
        super(msg);
        this.start();
    }

    @Override
    public void run() {
        while (Integer.parseInt(Juego.jlTiempo.getText()) != 0) {
            int tiempoRandom;
            Random random = new Random();
            tiempoRandom = 1000 * (10 + random.nextInt(6));
            try {
                sleep(tiempoRandom);
            } catch (InterruptedException e) {

            }
            int tiempo = Integer.parseInt(Juego.jlTiempo.getText());
            int contador = 0;
            int posicionX;
            int posicionY;
            tiempo = Integer.parseInt(Juego.jlTiempo.getText());
            if (tiempo != 0) {
                posicionY = random.nextInt(550);
                posicionX = random.nextInt(1000);
                JLabel itemBonus = new JLabel("");
                ImageIcon iconoBonus = new ImageIcon(getClass().getResource("/imagenes/puntosExtra.png"));
                ImageIcon iconoItemBonus = new ImageIcon(iconoBonus.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                itemBonus.setIcon(iconoItemBonus);
                itemBonus.setName("Bonus," + contador);
                Juego.panelAux.add(itemBonus);
                itemBonus.setBounds(posicionX, posicionY, 50, 50);
                Juego.panelAux.validate();
            }
        }
    }
}
