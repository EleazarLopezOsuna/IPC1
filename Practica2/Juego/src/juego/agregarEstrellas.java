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
public class agregarEstrellas extends Thread {

    public agregarEstrellas(String msg) {
        super(msg);
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {
            int posicionX;
            int posicionY;
            Random random = new Random();
            posicionY = random.nextInt(550);
            posicionX = random.nextInt(1300);
            JLabel itemBonus = new JLabel("");
            ImageIcon iconoBonus = new ImageIcon(getClass().getResource("/imagenes/paraFondo.png"));
            ImageIcon iconoItemBonus = new ImageIcon(iconoBonus.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
            itemBonus.setIcon(iconoItemBonus);
            itemBonus.setName("Estrella");
            Juego.panelAux.add(itemBonus);
            itemBonus.setBounds(posicionX, posicionY, 50, 50);
            Juego.panelAux.validate();
        }
    }
}
