/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Juego extends JFrame implements KeyListener {

    public static DibujarNavePrincipal navePrincipal;
    public static JLabel jlTiempo = new JLabel("");
    JLabel texto1 = new JLabel("Tiempo");
    JLabel texto2 = new JLabel("Destruidas");
    JLabel texto3 = new JLabel("Punteo");
    JPanel textos = new JPanel();
    JLabel texto4 = new JLabel("Puntaje Maximo");
    JLabel texto5 = new JLabel("Jugador");
    public static JLabel jlPunteoMaximo = new JLabel("0");
    public static JLabel jlPunteo = new JLabel("0");
    public static JLabel jlEliminadas = new JLabel("0");
    public static JLabel jlNaveUsuario = new JLabel("");
    public static JLabel jlJugador = new JLabel("");
    public static JPanel panelAux = new JPanel();
    public static Thread enemigos;
    public static AudioClip disparo;
    public static AudioClip hit;
    public static AudioClip destruir;
    public static JProgressBar vida[] = new JProgressBar[1000];
    public static boolean perdio = false;
    public static int numeroVidas = 0;
    public static int numeroDeBalas = 0;
    boolean continuarArriba = false;
    boolean continuarAbajo = false;
    public static boolean disparando = false;

    public Juego() throws FontFormatException, IOException {
        super("Mini-Galagan");
        inicializarJuego();
    }

    public void inicializarJuego() throws FontFormatException, IOException {
        hit = java.applet.Applet.newAudioClip(getClass().getResource("/sound/Explosion2.wav"));
        destruir = java.applet.Applet.newAudioClip(getClass().getResource("/sound/Shut_Down2.wav"));
        disparo = java.applet.Applet.newAudioClip(getClass().getResource("/sound/Beep4.wav"));
        try{
            FileReader lector = new FileReader("puntajeMaximo.txt");
            BufferedReader br = new BufferedReader(lector);
            String dato[] = br.readLine().split(",");
            int numero = Integer.parseInt(dato[0]);
            jlPunteoMaximo.setText(String.valueOf(numero));
            jlJugador.setText(dato[1]);
        }catch(IOException e){
            
        }
        panelAux.setLayout(null);
        textos.setLayout(null);
        navePrincipal = new DibujarNavePrincipal(jlNaveUsuario, 50, 50);
        jlNaveUsuario.setBounds(1255, 325, 50, 50);
        navePrincipal.setLocation(1255, 325);
        panelAux.add(navePrincipal);
        setSize(1325, 700);
        setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
        setLocation(new java.awt.Point(20, 20));//Indica donde se inicia la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        jlTiempo.setBounds(20, 40, 75, 25);
        texto1.setBounds(20, 20, 300, 25);
        jlPunteo.setBounds(220, 40, 75, 25);
        texto3.setBounds(220, 20, 300, 25);
        jlEliminadas.setBounds(420, 40, 75, 25);
        texto2.setBounds(420, 20, 300, 25);
        jlPunteoMaximo.setBounds(620,40,300,25);
        texto4.setBounds(620,20,300,25);
        jlJugador.setBounds(920,40,300,25);
        texto5.setBounds(920,20,300,25);
        panelAux.setSize(1325, 600);
        panelAux.setLocation(0, 70);
        textos.setSize(1325, 70);
        textos.add(texto1);
        textos.add(texto2);
        textos.add(texto3);
        textos.add(jlTiempo);
        textos.add(jlEliminadas);
        textos.add(jlPunteo);
        textos.add(jlPunteoMaximo);
        textos.add(texto4);
        textos.add(jlJugador);
        textos.add(texto5);
        textos.setBackground(Color.black);
        add(textos);
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/ARCADECLASSIC.TTF"));
        jlTiempo.setFont(font.deriveFont(Font.BOLD, 25f));
        jlEliminadas.setFont(font.deriveFont(Font.BOLD, 25f));
        jlPunteo.setFont(font.deriveFont(Font.BOLD, 25f));
        jlPunteoMaximo.setFont(font.deriveFont(Font.BOLD, 25f));
        jlJugador.setFont(font.deriveFont(Font.BOLD, 25f));
        texto1.setFont(font.deriveFont(Font.BOLD, 25f));
        texto2.setFont(font.deriveFont(Font.BOLD, 25f));
        texto3.setFont(font.deriveFont(Font.BOLD, 25f));
        texto4.setFont(font.deriveFont(Font.BOLD, 25f));
        texto5.setFont(font.deriveFont(Font.BOLD, 25f));
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        texto3.setForeground(Color.white);
        texto4.setForeground(Color.white);
        texto5.setForeground(Color.white);
        jlTiempo.setForeground(Color.white);
        jlEliminadas.setForeground(Color.white);
        jlPunteo.setForeground(Color.white);
        jlPunteoMaximo.setForeground(Color.white);
        jlJugador.setForeground(Color.white);
        ImageIcon naveUsuario = new ImageIcon(getClass().getResource("/imagenes/naveUsuario.png"));
        ImageIcon iconoNaveUsuario = new ImageIcon(naveUsuario.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        jlNaveUsuario.setIcon(iconoNaveUsuario);
        panelAux.setBackground(Color.black);
        Thread tiempo = new Timer("Control de Tiempo");
        Thread bonus = new ItemBonus("Item Bonus");
        Thread penalizacion = new ItemPenalizacion("Item Penalizacion");
        Thread agregarEstrellas = new agregarEstrellas("Agregar Estrellas");
        enemigos = new NavesEnemigas("Añadir Naves Enemigas");
        add(panelAux);
        addKeyListener(this);
    }

    /**
     * Método principal
     *
     * @param args
     * @throws java.awt.FontFormatException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FontFormatException, IOException {
        // TODO code application logic here
        Juego j = new Juego();
        j.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                continuarArriba = false;
                break;
            case KeyEvent.VK_DOWN:
                continuarAbajo = false;
                break;
            case KeyEvent.VK_SPACE:
                Thread disparar = new Disparar("Disparando");
                disparando = true;
                break;
        }
    }

    class MoverArriba extends Thread {

        public MoverArriba(String msg) {
            super(msg);
            this.start();
        }

        @Override
        public void run() {
            while (continuarArriba) {
                int posicionInicialenX = Juego.navePrincipal.getX();
                int posicionInicialenY = Juego.navePrincipal.getY();
                int posicionFinalenY;
                posicionFinalenY = posicionInicialenY - 1;
                if (posicionFinalenY > 0) {
                    Juego.navePrincipal.setLocation(posicionInicialenX, posicionFinalenY);
                } else {
                    continuarAbajo = false;
                }
                try {
                    sleep(10);
                } catch (InterruptedException ex) {

                }
            }
        }
    }

    class MoverAbajo extends Thread {

        public MoverAbajo(String msg) {
            super(msg);
            this.start();
        }

        @Override
        public void run() {
            while (continuarAbajo) {
                int posicionInicialenX = Juego.navePrincipal.getX();
                int posicionInicialenY = Juego.navePrincipal.getY();
                int posicionFinalenY;
                posicionFinalenY = posicionInicialenY + 1;
                if (posicionFinalenY <= 550) {
                    Juego.navePrincipal.setLocation(posicionInicialenX, posicionFinalenY);

                } else {
                    continuarAbajo = false;
                }
                try {
                    sleep(10);
                } catch (InterruptedException ex) {

                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                Thread threadArriba = new MoverArriba("Mover Arriba");
                continuarArriba = true;
                break;
            case KeyEvent.VK_DOWN:
                Thread threadAbajo = new MoverAbajo("Mover Abajo");
                continuarAbajo = true;
                break;
        }
    }
}
