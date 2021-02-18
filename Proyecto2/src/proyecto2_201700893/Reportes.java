/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201700893;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import static proyecto2_201700893.Inicio.*;

/**
 *
 * @author USER
 */
public class Reportes extends javax.swing.JFrame {

    public Object bodyTabla2[][];
    public Object bodyTabla3[][];
    public Object bodyTabla4[][];

    public void LlenarTablaMasPegadas() {
        bodyTabla2 = new Object[5][5];
        String head[] = {"Codigo", "Nombre", "Apellido", "Estampas", "Pegadas"};
        int contador = 0;
        int contador2 = 0;
        NodoUsuario usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarMasPegada(codigo);
            if (datos != null) {
                contador++;
            }
            usuario = usuario.siguiente;
        }
        String pegadas[][] = new String[contador][5];
        usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarMasPegada(codigo);
            if (datos != null) {
                pegadas[contador2][0] = datos[0];
                pegadas[contador2][1] = datos[1];
                pegadas[contador2][2] = datos[2];
                pegadas[contador2][3] = datos[3];
                pegadas[contador2][4] = datos[4];
                contador2++;
            }
            usuario = usuario.siguiente;
        }
        pegadas = ordenar(pegadas, "descendente");
        int parar = 0;
        for (int i = 0; i < pegadas.length; i++) {
            if (parar == 5) {
                break;
            } else {
                System.arraycopy(pegadas[i], 0, bodyTabla2[i], 0, pegadas[i].length);
            }
            parar++;
        }
        DefaultTableModel mod = new DefaultTableModel(bodyTabla2, head);
        Reportes.jTable2.setModel(mod);
    }

    public void LlenarTablaMenosPegadas() {
        bodyTabla3 = new Object[5][5];
        String head[] = {"Codigo", "Nombre", "Apellido", "Estampas", "Pegadas"};
        int contador = 0;
        int contador2 = 0;
        NodoUsuario usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarMenosPegada(codigo);
            if (datos != null) {
                contador++;
            }
            usuario = usuario.siguiente;
        }
        String pegadas[][] = new String[contador][5];
        usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarMenosPegada(codigo);
            if (datos != null) {
                pegadas[contador2][0] = datos[0];
                pegadas[contador2][1] = datos[1];
                pegadas[contador2][2] = datos[2];
                pegadas[contador2][3] = datos[3];
                pegadas[contador2][4] = datos[4];
                contador2++;
            }
            usuario = usuario.siguiente;
        }
        pegadas = ordenar(pegadas, "descendente");

        int parar = 0;
        for (int i = 0; i < pegadas.length; i++) {
            if (parar == 5) {
                break;
            } else {
                System.arraycopy(pegadas[i], 0, bodyTabla3[i], 0, pegadas[i].length);
            }
            parar++;
        }
        DefaultTableModel mod = new DefaultTableModel(bodyTabla3, head);
        Reportes.jTable3.setModel(mod);
    }

    public String[][] ordenar(String[][] matriz, String tipo) {
        switch (tipo) {
            case "descendente":
                for (int i = 0; i < matriz.length - 1; i++) {
                    for (int j = 0; j < matriz.length - 1; j++) {
                        if (Integer.parseInt(matriz[j][4]) < Integer.parseInt(matriz[j + 1][4])) {
                            String[] temp = matriz[j + 1];
                            matriz[j + 1] = matriz[j];
                            matriz[j] = temp;
                        }
                    }
                }
                break;
            case "ascendente":
                for (int i = 0; i < matriz.length - 1; i++) {
                    for (int j = 0; j < matriz.length - 1; j++) {
                        if (Integer.parseInt(matriz[j][4]) > Integer.parseInt(matriz[j + 1][4])) {
                            String[] temp = matriz[j + 1];
                            matriz[j + 1] = matriz[j];
                            matriz[j] = temp;
                        }
                    }
                }
                break;
            case "otro":
                for (int i = 0; i < matriz.length - 1; i++) {
                    for (int j = 0; j < matriz.length - 1; j++) {
                        if (Integer.parseInt(matriz[j][3]) < Integer.parseInt(matriz[j + 1][3])) {
                            String[] temp = matriz[j + 1];
                            matriz[j + 1] = matriz[j];
                            matriz[j] = temp;
                        }
                    }
                }
                break;
            default:
                break;
        }
        return matriz;
    }

    public void LlenarTablaArchivos() {
        String head[] = {"Archivo", "Ingresados", "Error", "Duplicados", "Total"};
        int contador = 0;
        for (String[] datosCargado : datosCargados) {
            if (!datosCargado[0].isEmpty()) {
                contador++;
            }
        }
        Object body[][] = new Object[contador][5];
        for (int i = 0; i < datosCargados.length; i++) {
            if (!datosCargados[i][0].isEmpty()) {
                body[i][0] = datosCargados[i][0];
                body[i][1] = datosCargados[i][1];
                body[i][2] = datosCargados[i][2];
                body[i][3] = datosCargados[i][3];
                body[i][4] = datosCargados[i][4];
            }
        }
        DefaultTableModel mod = new DefaultTableModel(body, head);
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(mod);
        Reportes.jTable1.setModel(mod);
        Reportes.jTable1.setRowSorter(tr);
    }

    public void LlenarMasEstampas() {
        bodyTabla4 = new Object[5][4];
        String head[] = {"Codigo", "Nombre", "Apellido", "Estampas"};
        int contador = 0;
        int contador2 = 0;
        NodoUsuario usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarEstampas(codigo);
            if (datos != null) {
                contador++;
            }
            usuario = usuario.siguiente;
        }
        String pegadas[][] = new String[contador][4];
        usuario = lu.primero.siguiente;
        while (usuario != null) {
            int codigo = usuario.getUsuario().getCod();
            String datos[] = eu.buscarEstampas(codigo);
            if (datos != null) {
                pegadas[contador2][0] = datos[0];
                pegadas[contador2][1] = datos[1];
                pegadas[contador2][2] = datos[2];
                pegadas[contador2][3] = datos[3];
                contador2++;
            }
            usuario = usuario.siguiente;
        }
        pegadas = ordenar(pegadas, "otro");
        int parar = 0;
        for (int i = 0; i < pegadas.length; i++) {
            if (parar == 5) {
                break;
            } else {
                System.arraycopy(pegadas[i], 0, bodyTabla4[i], 0, pegadas[i].length);
            }
            parar++;
        }
        DefaultTableModel mod = new DefaultTableModel(bodyTabla4, head);
        Reportes.jTable4.setModel(mod);
    }

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        LlenarTablaArchivos();
        LlenarTablaMasPegadas();
        LlenarTablaMenosPegadas();
        LlenarMasEstampas();
        Reportes.jTable1.setEnabled(false);
        Reportes.jTable2.setEnabled(false);
        Reportes.jTable3.setEnabled(false);
        Reportes.jTable4.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 80));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Archivos", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Top 5 Usuarios Mas Estampas Pegadas", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Top 5 Usuarios Estampas Menos Pegadas", jPanel3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Top 5 Usuaros Mas Estampas", jPanel4);

        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel1.setText("Ruta:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generar PDF", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser buscador = new JFileChooser();
        int opcion = buscador.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File f = buscador.getSelectedFile();
            this.jTextField1.setText(f.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ruta = this.jTextField1.getText();
        if (!ruta.isEmpty()) {
            try {
                FileOutputStream archivo = new FileOutputStream(ruta + ".pdf");
                Document doc = new Document();
                Font titulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                //Archivo
                Paragraph parrafo1 = new Paragraph();
                parrafo1.add(new Phrase("Reporte de Archivos", titulo));
                parrafo1.setAlignment(Element.ALIGN_CENTER);
                parrafo1.add(new Phrase(Chunk.NEWLINE));
                parrafo1.add(new Phrase(Chunk.NEWLINE));

                //Usuarios estampas mas Pegadas
                Paragraph parrafo2 = new Paragraph();
                parrafo2.add(new Phrase(Chunk.NEWLINE));
                parrafo2.add(new Phrase(Chunk.NEWLINE));
                parrafo2.add(new Phrase("Top 5: Usuarios con mas estampas Pegadas", titulo));
                parrafo2.setAlignment(Element.ALIGN_CENTER);
                parrafo2.add(new Phrase(Chunk.NEWLINE));
                parrafo2.add(new Phrase(Chunk.NEWLINE));

                //Usuarios estampas menos Pegadas
                Paragraph parrafo3 = new Paragraph();
                parrafo3.add(new Phrase(Chunk.NEWLINE));
                parrafo3.add(new Phrase(Chunk.NEWLINE));
                parrafo3.add(new Phrase("Top 5: Usuarios con menos estampas Pegadas", titulo));
                parrafo3.setAlignment(Element.ALIGN_CENTER);
                parrafo3.add(new Phrase(Chunk.NEWLINE));
                parrafo3.add(new Phrase(Chunk.NEWLINE));

                //Usuarios mas estampas Pegadas
                Paragraph parrafo4 = new Paragraph();
                parrafo4.add(new Phrase(Chunk.NEWLINE));
                parrafo4.add(new Phrase(Chunk.NEWLINE));
                parrafo4.add(new Phrase("Top 5: Usuarios con mas estampas", titulo));
                parrafo4.setAlignment(Element.ALIGN_CENTER);
                parrafo4.add(new Phrase(Chunk.NEWLINE));
                parrafo4.add(new Phrase(Chunk.NEWLINE));

                try {
                    PdfWriter.getInstance(doc, archivo);
                    doc.open();
                    //Archivo
                    PdfPTable tabla1 = new PdfPTable(5);
                    float[] columnWidth = {40, 15, 12, 17, 15};
                    float[] columnWidth2 = {40, 20, 17, 22};
                    tabla1.setTotalWidth(columnWidth);
                    PdfPCell celda11 = new PdfPCell(new Paragraph("Archivo"));
                    PdfPCell celda12 = new PdfPCell(new Paragraph("Cargados"));
                    PdfPCell celda13 = new PdfPCell(new Paragraph("Error"));
                    PdfPCell celda14 = new PdfPCell(new Paragraph("Duplicados"));
                    PdfPCell celda15 = new PdfPCell(new Paragraph("Leidos"));
                    celda11.setMinimumHeight(30);
                    celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda12.setMinimumHeight(30);
                    celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda13.setMinimumHeight(30);
                    celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda14.setMinimumHeight(30);
                    celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda15.setMinimumHeight(30);
                    celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda15.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla1.addCell(celda11);
                    tabla1.addCell(celda12);
                    tabla1.addCell(celda13);
                    tabla1.addCell(celda14);
                    tabla1.addCell(celda15);
                    for (String[] datosCargado : datosCargados) {
                        for (String datosCargado1 : datosCargado) {
                            if (!datosCargado[0].isEmpty()) {
                                PdfPCell celda = new PdfPCell(new Paragraph(datosCargado1));
                                celda.setMinimumHeight(15);
                                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla1.addCell(celda);
                            }
                        }
                    }

                    //Usuarios mas estampas Pegadas
                    PdfPTable tabla2 = new PdfPTable(5);
                    tabla2.setTotalWidth(columnWidth);
                    PdfPCell celda21 = new PdfPCell(new Paragraph("Codigo"));
                    PdfPCell celda22 = new PdfPCell(new Paragraph("Nombre"));
                    PdfPCell celda23 = new PdfPCell(new Paragraph("Apellido"));
                    PdfPCell celda24 = new PdfPCell(new Paragraph("Estampas"));
                    PdfPCell celda25 = new PdfPCell(new Paragraph("Pegadas"));
                    celda21.setMinimumHeight(30);
                    celda21.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda21.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda22.setMinimumHeight(30);
                    celda22.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda22.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda23.setMinimumHeight(30);
                    celda23.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda23.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda24.setMinimumHeight(30);
                    celda24.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda24.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda25.setMinimumHeight(30);
                    celda25.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda25.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(celda21);
                    tabla2.addCell(celda22);
                    tabla2.addCell(celda23);
                    tabla2.addCell(celda24);
                    tabla2.addCell(celda25);
                    for (Object[] datosCargado : bodyTabla2) {
                        for (Object datosCargado1 : datosCargado) {
                            if (datosCargado[0] != null) {
                                PdfPCell celda = new PdfPCell(new Paragraph(datosCargado1.toString()));
                                celda.setMinimumHeight(15);
                                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla2.addCell(celda);
                            }
                        }
                    }

                    //Usuarios menos estampas Pegadas
                    PdfPTable tabla3 = new PdfPTable(5);
                    tabla3.setTotalWidth(columnWidth);
                    PdfPCell celda31 = new PdfPCell(new Paragraph("Codigo"));
                    PdfPCell celda32 = new PdfPCell(new Paragraph("Nombre"));
                    PdfPCell celda33 = new PdfPCell(new Paragraph("Apellido"));
                    PdfPCell celda34 = new PdfPCell(new Paragraph("Estampas"));
                    PdfPCell celda35 = new PdfPCell(new Paragraph("Pegadas"));
                    celda31.setMinimumHeight(30);
                    celda31.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda31.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda32.setMinimumHeight(30);
                    celda32.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda32.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda33.setMinimumHeight(30);
                    celda33.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda33.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda34.setMinimumHeight(30);
                    celda34.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda34.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda35.setMinimumHeight(30);
                    celda35.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda35.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(celda31);
                    tabla3.addCell(celda32);
                    tabla3.addCell(celda33);
                    tabla3.addCell(celda34);
                    tabla3.addCell(celda35);
                    for (Object[] datosCargado : bodyTabla3) {
                        for (Object datosCargado1 : datosCargado) {
                            if (datosCargado[0] != null) {
                                PdfPCell celda = new PdfPCell(new Paragraph(datosCargado1.toString()));
                                celda.setMinimumHeight(15);
                                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla3.addCell(celda);
                            }
                        }
                    }

                    //Usuarios mas estampas
                    PdfPTable tabla4 = new PdfPTable(4);
                    tabla4.setTotalWidth(columnWidth2);
                    PdfPCell celda41 = new PdfPCell(new Paragraph("Codigo"));
                    PdfPCell celda42 = new PdfPCell(new Paragraph("Nombre"));
                    PdfPCell celda43 = new PdfPCell(new Paragraph("Apellido"));
                    PdfPCell celda44 = new PdfPCell(new Paragraph("Estampas"));
                    celda41.setMinimumHeight(30);
                    celda41.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda41.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda42.setMinimumHeight(30);
                    celda42.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda42.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda43.setMinimumHeight(30);
                    celda43.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda43.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda44.setMinimumHeight(30);
                    celda44.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda44.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(celda41);
                    tabla4.addCell(celda42);
                    tabla4.addCell(celda43);
                    tabla4.addCell(celda44);
                    for (Object[] datosCargado : bodyTabla4) {
                        for (Object datosCargado1 : datosCargado) {
                            if (datosCargado[0] != null) {
                                PdfPCell celda = new PdfPCell(new Paragraph(datosCargado1.toString()));
                                celda.setMinimumHeight(15);
                                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla4.addCell(celda);
                            }
                        }
                    }

                    doc.add(parrafo1);
                    doc.add(tabla1);
                    doc.add(parrafo2);
                    doc.add(tabla2);
                    doc.add(parrafo3);
                    doc.add(tabla3);
                    doc.add(parrafo4);
                    doc.add(tabla4);
                    doc.close();
                    this.jTextField1.setText("");
                    JOptionPane.showMessageDialog(this, "Reporte Creado Correctamente");
                    String rutax = ruta + ".pdf";
                    Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + rutax);
                } catch (DocumentException | IOException ex) {
                    Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una Ruta Valida","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Reportes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private static javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
