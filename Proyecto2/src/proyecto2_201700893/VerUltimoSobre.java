package proyecto2_201700893;

import java.awt.Image;
import javax.swing.ImageIcon;
import static proyecto2_201700893.Inicio.*;

/**
 *
 * @author USER
 */
public class VerUltimoSobre extends javax.swing.JFrame {

    int numeroEstampa = 0;
    NodoSobre sobre = so.ultimo;

    public VerUltimoSobre() {
        initComponents();
        cargaInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel23.setText("Jugador");

        jLabel18.setText("Equipo");

        jLabel17.setText("Rareza");

        jTextField7.setEditable(false);

        jTextField8.setEditable(false);

        jTextField9.setEditable(false);

        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jButton1.setText("Pegar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel23)
                                .addComponent(jLabel17))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField9)
                                .addComponent(jTextField8)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if (numeroEstampa != sobre.getSobre().getCapacidad() - 1) {
            numeroEstampa++;
            int estampas[][] = sobre.getSobre().getEstampas();
            String ruta = est.buscarRuta(estampas[numeroEstampa][0]);
            int rareza = est.buscarRareza(estampas[numeroEstampa][0]);
            int codEquipo = est.buscarEquipo(estampas[numeroEstampa][0]);
            int codJugador = est.buscarJugador(estampas[numeroEstampa][0]);
            String nombreJugador = ju.buscarCodJugador(codJugador);
            String nombreEquipo = eq.buscarCodEquipo(codEquipo);
            ImageIcon ImagenJugador = new ImageIcon(getClass().getResource("/" + ruta));
            ImageIcon IconoJugador = new ImageIcon(ImagenJugador.getImage().getScaledInstance(jLabel24.getWidth(), jLabel24.getHeight(), Image.SCALE_DEFAULT));
            jLabel24.setIcon(IconoJugador);
            jTextField7.setText(String.valueOf(rareza));
            jTextField8.setText(nombreEquipo);
            jTextField9.setText(nombreJugador);
            if (eu.buscarPegada(estampas[numeroEstampa][0])) {
                jButton1.setEnabled(true);
            } else {
                jButton1.setEnabled(false);
            }
        } else {
            jLabel16.setEnabled(false);
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int estampas[][] = sobre.getSobre().getEstampas();
        int codEstampa = estampas[numeroEstampa][0];
        NodoEstampaUsuario nodo = eu.primero;
        do {
            if (nodo.getEstampaUsuario().getCodUsuario() == Integer.parseInt(usuarioActual[0])) {
                if (nodo.getEstampaUsuario().getCodEstampa() == codEstampa) {
                    nodo.getEstampaUsuario().setPegada(1);
                }
            }
            nodo = nodo.siguiente;
        } while (nodo != eu.primero);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargaInicial() {
        ImageIcon ImagenSiguiente = new ImageIcon(getClass().getResource("next.png"));
        ImageIcon IconoSiguiente = new ImageIcon(ImagenSiguiente.getImage().getScaledInstance(jLabel16.getWidth(), jLabel16.getHeight(), Image.SCALE_DEFAULT));
        jLabel16.setIcon(IconoSiguiente);
        int estampas[][] = sobre.getSobre().getEstampas();
        String ruta = est.buscarRuta(estampas[numeroEstampa][0]);
        ImageIcon ImagenJugador = new ImageIcon(getClass().getResource("/" + ruta));
        ImageIcon IconoJugador = new ImageIcon(ImagenJugador.getImage().getScaledInstance(jLabel24.getWidth(), jLabel24.getHeight(), Image.SCALE_DEFAULT));
        jLabel24.setIcon(IconoJugador);
        //Pone Primer Jugador
        int rareza = est.buscarRareza(estampas[numeroEstampa][0]);
        int codEquipo = est.buscarEquipo(estampas[numeroEstampa][0]);
        int codJugador = est.buscarJugador(estampas[numeroEstampa][0]);
        String nombreJugador = ju.buscarCodJugador(codJugador);
        String nombreEquipo = eq.buscarCodEquipo(codEquipo);
        jLabel24.setIcon(IconoJugador);
        jTextField7.setText(String.valueOf(rareza));
        jTextField8.setText(nombreEquipo);
        jTextField9.setText(nombreJugador);
        if (eu.buscarPegada(estampas[numeroEstampa][0])) {
            jButton1.setEnabled(true);
        } else {
            jButton1.setEnabled(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerUltimoSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerUltimoSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerUltimoSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerUltimoSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerUltimoSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
