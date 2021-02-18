/**
 * Aca se genera la impresion de la nave principal
 */
package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class DibujarNavePrincipal extends Canvas{
    private final JLabel label;
    private final Dimension dimCanvas;
    public DibujarNavePrincipal(JLabel label, int width, int height){
        super();
        this.setSize(new Dimension(width, height));
        this.label = label;
        dimCanvas = this.getSize();
    }
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
        label.paint(g);
    }
}
