/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_presencial;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USER
 */
public class Practica_Presencial extends JFrame {

    public static int numeroAgregados = 0;
    static Datos[] vectorDatos = new Datos[15];
    JLabel jlNombre = new JLabel("Nombre: ");
    JTextField jtNombre = new JTextField();
    JLabel jlApellido = new JLabel("Apellido: ");
    JTextField jtApellido = new JTextField();
    JLabel jlEdad = new JLabel("Edad: ");
    JTextField jtEdad = new JTextField();
    JLabel jlSexo = new JLabel("Sexo: ");
    JComboBox jcSexo = new JComboBox();
    JButton jbAgregar = new JButton("Agregar");
    JButton jbEdad = new JButton("Edad");
    JTable jtTabla;
    JScrollPane jsPane = new JScrollPane();
    String Enombre, Eapellido, Eedad, Esexo;

    public Practica_Presencial() {
        super("Practica Presencial");
        iniciarVentana();
    }

    public void iniciarVentana() {
        setSize(850, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocation(250, 100);
        Object[][] datos = new Object[numeroAgregados][4];
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        int contador = 0;
        for (int i = 0; i < numeroAgregados; i++) {
            datos[i][0] = vectorDatos[i].getNombre();
            datos[i][1] = vectorDatos[i].getApellido();
            datos[i][2] = vectorDatos[i].getEdad();
            datos[i][3] = vectorDatos[i].getSexo();
            contador++;
        }
        Object[][] datosModificados = new Object[contador][4];
        for (int i = 0; i < contador; i++) {
            datosModificados[i][0] = datos[i][0];
            datosModificados[i][1] = datos[i][1];
            datosModificados[i][2] = datos[i][2];
            datosModificados[i][3] = datos[i][3];
        }
        String[] encabezados = {"Nombre", "Apellido", "Edad", "Sexo"};
        jtTabla = new JTable(datosModificados, encabezados);//Se crea la tabla con los datos y encabezados
        for (int i = 0; i < 4; i++) {
            jtTabla.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
        }
        jlNombre.setBounds(20, 20, 70, 25);
        jtNombre.setBounds(90, 20, 90, 25);
        jlApellido.setBounds(190, 20, 70, 25);
        jtApellido.setBounds(260, 20, 90, 25);
        jlEdad.setBounds(360, 20, 70, 25);
        jtEdad.setBounds(400, 20, 90, 25);
        jlSexo.setBounds(500, 20, 70, 25);
        jcSexo.setBounds(540, 20, 90, 25);
        jbAgregar.setBounds(690, 20, 90, 25);
        jtNombre.setToolTipText("Nombre");
        jtApellido.setToolTipText("Apellido");
        jtEdad.setToolTipText("Edad");
        jcSexo.addItem("Sexo");//Index 0
        jcSexo.addItem("Masculino");// Index 1
        jcSexo.addItem("Femenino");// Index 2
        jsPane.setBounds(20, 60, 700, 400);
        jtTabla.enable(false);
        jsPane.setViewportView(jtTabla);
        jbEdad.setBounds(735, 120, 85, 25);
        jbEdad.setEnabled(false);
        if (numeroAgregados != 0) {
            jbEdad.setEnabled(true);
        } else {
            jbEdad.setEnabled(false);
        }
        add(jbEdad);
        add(jsPane);
        add(jlNombre);
        add(jlApellido);
        add(jlEdad);
        add(jlSexo);
        add(jtNombre);
        add(jtApellido);
        add(jtEdad);
        add(jcSexo);
        add(jbAgregar);
        jbAgregar.addActionListener((ActionEvent e) -> {
            agregar();
        });
        jbEdad.addActionListener((ActionEvent e) -> {
            ordenarEdad();
        });
        jtTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = jtTabla.rowAtPoint(e.getPoint());
                    int columna = jtTabla.columnAtPoint(e.getPoint());
                    if (fila > -1 && columna > -1) {
                        Enombre = jtTabla.getValueAt(fila, 0).toString();
                        Eapellido = jtTabla.getValueAt(fila, 1).toString();
                        Eedad = jtTabla.getValueAt(fila, 2).toString();
                        Esexo = jtTabla.getValueAt(fila, 3).toString();
                        eliminar(Enombre, Eapellido, Eedad, Esexo);
                    }
                }
            }
        });
    }

    public void eliminar(String nombre, String apellido, String edad, String sexo) {
        int numeroEdad = Integer.parseInt(edad);
        for (int i = 0; i < numeroAgregados; i++) {
            if (vectorDatos[i].getNombre().equals(nombre) && vectorDatos[i].getApellido().equals(apellido) && vectorDatos[i].getSexo().equals(sexo) && vectorDatos[i].getEdad() == numeroEdad) {
                for (int j = i; j < numeroAgregados - 1; j++) {
                    vectorDatos[j].setNombre(vectorDatos[j + 1].getNombre());
                    vectorDatos[j].setApellido(vectorDatos[j + 1].getApellido());
                    vectorDatos[j].setSexo(vectorDatos[j + 1].getSexo());
                    vectorDatos[j].setEdad(vectorDatos[j + 1].getEdad());
                }
                vectorDatos[numeroAgregados - 1].setNombre(null);
                vectorDatos[numeroAgregados - 1].setApellido(null);
                vectorDatos[numeroAgregados - 1].setSexo(null);
                vectorDatos[numeroAgregados - 1].setEdad(0);
                numeroAgregados--;
                break;
            }
        }
        for (int i = 0; i < numeroAgregados; i++) {
            System.out.println(vectorDatos[i].getNombre());
            System.out.println(vectorDatos[i].getApellido());
            System.out.println(vectorDatos[i].getSexo());
            System.out.println(vectorDatos[i].getEdad());
            System.out.println("---------------------------");
        }
        this.dispose();
        Practica_Presencial p = new Practica_Presencial();
        p.setVisible(true);
    }

    public void agregar() {
        String nombre = jtNombre.getText();
        String apellido = jtApellido.getText();
        String datoEdad = jtEdad.getText();
        int contadorNombre = 0;
        int contadorApellido = 0;
        int edad;
        int ingresar = 0;
        String sexo = (String) jcSexo.getSelectedItem();
        boolean continuar = verificarNumero(datoEdad);
        for (int i = 0; i < 10; i++) {
            if (nombre.contains(String.valueOf(i))) {
                contadorNombre++;
            }
            if (apellido.contains(String.valueOf(i))) {
                contadorApellido++;
            }
        }
        if (nombre.equals("") || apellido.equals("") || datoEdad.equals("") || sexo.equals("Sexo")) {
            JOptionPane.showMessageDialog(this, "Ingrese Todos Los Datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (contadorNombre != 0 || contadorApellido != 0) {
                ingresar++;
                JOptionPane.showMessageDialog(this, "Nombre o Apellido Contiene Numeros", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!continuar && ingresar < 2) {
                JOptionPane.showMessageDialog(this, "Ingrese Un Numero En Edad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                edad = Integer.parseInt(datoEdad);
                if (numeroAgregados < 14) {
                    Datos agregar = new Datos(nombre, apellido, sexo, edad);
                    vectorDatos[numeroAgregados] = agregar;
                    numeroAgregados++;
                    this.dispose();
                    Practica_Presencial p = new Practica_Presencial();
                    p.setVisible(true);
                }
            }
        }
    }

    public void ordenarEdad() {
        String matrizNumeros[][] = new String[numeroAgregados][4];
        int edadAuxiliar;
        for (int i = 0; i < numeroAgregados; i++) {
            matrizNumeros[i][0] = String.valueOf(vectorDatos[i].getEdad());
            matrizNumeros[i][1] = vectorDatos[i].getNombre();
            matrizNumeros[i][2] = vectorDatos[i].getApellido();
            matrizNumeros[i][3] = vectorDatos[i].getSexo();
        }
        for (int i = 0; i < matrizNumeros.length; i++) {
            for (int j = i + 1; j < matrizNumeros.length; j++) {
                if (Integer.parseInt(matrizNumeros[i][0]) < Integer.parseInt(matrizNumeros[j][0])) {
                    edadAuxiliar = Integer.parseInt(matrizNumeros[i][0]);
                    matrizNumeros[i][0] = matrizNumeros[j][0];
                    matrizNumeros[j][0] = String.valueOf(edadAuxiliar);
                }
            }
        }
        for (int i = 0; i < matrizNumeros.length; i++) {
            System.out.println(matrizNumeros[i][0]);
            System.out.println("----------------------------");
        }
    }

    public static void llenarDefault() {
        Datos agregar = new Datos(null, null, null, 0);
        for (int i = 0; i < vectorDatos.length; i++) {
            vectorDatos[i] = agregar;
        }
    }

    public boolean verificarNumero(String cadena) {
        boolean esNumero = false;
        int numero = 0;
        try {
            numero = Integer.parseInt(cadena);
            esNumero = true;
        } catch (NumberFormatException e) {
            esNumero = false;
        }
        return esNumero;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Practica_Presencial p = new Practica_Presencial();
        p.setVisible(true);
        llenarDefault();
    }

}
