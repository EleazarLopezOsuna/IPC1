package proyecto1_201700893;

import java.awt.Font;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author USER
 */
public class Inicio extends JFrame {

    //Se definen los JButton
    JButton jbLogin;
    JButton jbAbout;

    //Array donde se Guardaran los Usuarios
    public static Usuario[] arregloUsuario = new Usuario[50];
    public static Tesis[] arregloTesis = new Tesis[50];
    public static Revista[] arregloRevista = new Revista[50];
    public static Libro[] arregloLibro = new Libro[50];
    public static Prestamo[] arregloPrestamo = new Prestamo[50];
    public static String[][] ingresados = new String[50][15];

    //Guarda el tamaño del Array
    public static int numeroUsuarios = 0;
    public static int numeroTesis = 0;
    public static int numeroRevistas = 0;
    public static int numeroLibros = 0;
    public static int numeroPrestamos = 0;
    public static int ingresos = 0;
    public String autor = "";
    public String titulo = "";
    public String palabras = "";
    public String edicion = "";
    public String tipo = "";

    //Guarda el usuario que actualmente esta accediendo al sistema
    public String usuarioActual = "";

    //Constructor de Inicio
    public Inicio() {
        super("Inicio");
        inicializacionInicio();//Se llama al Void que genera la Ventana Grafica
    }

    private void inicializacionInicio() {
        setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
        setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
        setSize(400, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
        setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica

        //Creacion de los Objetos
        jbLogin = new JButton("Login");
        jbAbout = new JButton("About");

        //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
        jbLogin.setBounds(105, 35, 160, 80);
        jbAbout.setBounds(105, 135, 160, 80);

        //Al dar Clic
        jbLogin.addActionListener((ActionEvent e) -> {
            jbLogin();
        });
        jbAbout.addActionListener((ActionEvent e) -> {
            jbAbout();
        });

        //Se Agregan los Objetos
        add(jbLogin);
        add(jbAbout);
    }

    //Accion Boton Login
    private void jbLogin() {
        this.setVisible(false);
        Login L = new Login();
        L.setVisible(true);
    }

    //Accion Boton About
    private void jbAbout() {
        String mensaje = "Desarrollador: Eleazar Jared López Osuna\nCarrera: Ingenieria en Ciencias y Sistemas\nCurso: IPC 1\nCarnet: 201700893\nCUI: 2997-76506-0101";
        JOptionPane.showMessageDialog(this, mensaje, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cargarUsuariosDefault() {
        Usuario usuario1 = new Usuario("admin", "admin", "admin", "admin", "admin", "Administrador");
        Usuario usuario2 = new Usuario("2997765060101", "Eleazar", "Osuna", "eleazar", "123", "Estudiante");
        Usuario usuario3 = new Usuario("5897842012463", "Juan", "Aguirre", "juan", "123", "Catedrático");
        Usuario usuario4 = new Usuario("1245789621015", "Maria", "Lopez", "maria", "123", "Estudiante");
        arregloUsuario[0] = usuario1;
        arregloUsuario[1] = usuario2;
        arregloUsuario[2] = usuario3;
        arregloUsuario[3] = usuario4;
        numeroUsuarios = 4;
    }

    public static void cargarPrestamosDefault() {
        //Vencidas
        String fecha = "27-03-2018";
        String fecha1 = "21-03-2018";
        String fecha2 = "22-03-2018";
        String fecha3 = "23-03-2018";
        String fecha4 = "24-03-2018";
        String fecha5 = "25-03-2018";
        String fecha6 = "26-03-2018";

        //Vigentes
        String fecha7 = "27-03-2018";
        String fecha8 = "28-03-2018";
        String fecha9 = "29-03-2018";
        String fecha10 = "30-03-2018";
        String fecha11 = "31-03-2018";
        String fecha12 = "01-04-2018";
        String fecha13 = "02-04-2018";
        String fecha14 = "03-04-2018";
        String fecha15 = "04-04-2018";
        String fecha16 = "12-12-2018";

        //Usuario 1
        //Vencidos
        Prestamo prestamo1 = new Prestamo("Tesis", "Floriza Felipa Avila Pesquera", "Protocolos para transmisiones a altas velocidades", "1", fecha1, fecha, "2997765060101", "NO", "NO", "NO");
        Prestamo prestamo2 = new Prestamo("Tesis", "Braulio Bladimir Bran Girón", "Actualización del sistema de gestión de calidad basado en la Norma ISO 22,000 en las líneas de procesamiento de palmito y piña de grupo Layta", "1", fecha2, fecha, "2997765060101", "NO", "NO", "NO");
        // Vigentes
        Prestamo prestamo7 = new Prestamo("Tesis", "Marco Tulio Salguero Hernández", "Actualización del reglamento de pesos y dimensiones de vehículos automotores y sus combinaciones", "1", fecha7, fecha16, "2997765060101", "NO", "NO", "NO");
        Prestamo prestamo8 = new Prestamo("Tesis", "Luis Waldemar Sierra Herrera", "Acceso inalámbrico del abonado en una red de telecomunicaciones", "1", fecha8, fecha16, "2997765060101", "NO", "NO", "NO");
        Prestamo prestamo9 = new Prestamo("Tesis", "Juan Carlos Telon Miranda", "Protocolos de Red", "1", fecha9, fecha16, "2997765060101", "NO", "NO", "NO");

        //Usuario 2
        //Vencidos
        Prestamo prestamo3 = new Prestamo("Libro", "Baldor", "Algebra", "9", fecha3, fecha, "5897842012463", "NO", "NO", "NO");
        Prestamo prestamo4 = new Prestamo("Libro", "Timberlake", "Fisica Conceptos y Aplicaciones", "6", fecha4, fecha, "5897842012463", "NO", "NO", "NO");
        // Vigentes
        Prestamo prestamo10 = new Prestamo("Libro", "Timberlake", "Actualización Quimica", "2", fecha10, fecha16, "5897842012463", "NO", "NO", "NO");
        Prestamo prestamo11 = new Prestamo("Libro", "James Stewart", "Cálculo Trascendentes Tempranas", "4", fecha11, fecha16, "5897842012463", "NO", "NO", "NO");
        Prestamo prestamo12 = new Prestamo("Libro", "James Stewart", "Precálculo", "4", fecha12, fecha16, "5897842012463", "NO", "NO", "NO");

        //Usuario 2
        //Vencidos
        Prestamo prestamo5 = new Prestamo("Revista", "Juan Carlos Estrada Quiñonez", "Un Ingeniero en un mundo de Abogados", "5", fecha5, fecha, "1245789621015", "NO", "NO", "NO");
        Prestamo prestamo6 = new Prestamo("Revista", "Marco Eudilio Perez Soto", "Ingenieria Moderna", "2", fecha6, fecha, "1245789621015", "NO", "NO", "NO");
        // Vigentes
        Prestamo prestamo13 = new Prestamo("Revista", "Maria Inez Roca Marroquin", "Soy Ingeniera", "4", fecha13, fecha16, "1245789621015", "NO", "NO", "NO");
        Prestamo prestamo14 = new Prestamo("Revista", "Marta Lucia Giron Paz", "Fisica Moderna", "8", fecha14, fecha16, "1245789621015", "NO", "NO", "NO");
        Prestamo prestamo15 = new Prestamo("Revista", "Juan Carlos Peña Olivo", "Fisica Clasica", "8", fecha15, fecha16, "1245789621015", "NO", "NO", "NO");

        //Guardar los Datos
        arregloPrestamo[0] = prestamo1;
        arregloPrestamo[1] = prestamo2;
        arregloPrestamo[2] = prestamo3;
        arregloPrestamo[3] = prestamo4;
        arregloPrestamo[4] = prestamo5;
        arregloPrestamo[5] = prestamo6;
        arregloPrestamo[6] = prestamo7;
        arregloPrestamo[7] = prestamo8;
        arregloPrestamo[8] = prestamo9;
        arregloPrestamo[9] = prestamo10;
        arregloPrestamo[10] = prestamo11;
        arregloPrestamo[11] = prestamo12;
        arregloPrestamo[12] = prestamo13;
        arregloPrestamo[13] = prestamo14;
        arregloPrestamo[14] = prestamo15;
        numeroPrestamos = 15;
    }

    public static void cargarTesisDefault() {
        Tesis tesis1 = new Tesis("Braulio Bladimir Bran Girón", "Actualización del sistema de gestión de calidad basado en la Norma ISO 22,000 en las líneas de procesamiento de palmito y piña de grupo Layta", "Ingenieria,Tratamiento,ISO", "Ingenieria", "Administracion,Control,Confiabilidad", "Añadir Descripcion", "1", "5", "4");
        Tesis tesis2 = new Tesis("Marco Tulio Salguero Hernández", "Actualización del reglamento de pesos y dimensiones de vehículos automotores y sus combinaciones", "Ingenieria,Actualizacion,Vehiculos", "Ingenieria", "Transporte,Reglamentos", "Añadir Descipcion", "1", "8", "7");
        Tesis tesis3 = new Tesis("Luis Waldemar Sierra Herrera", "Acceso inalámbrico del abonado en una red de telecomunicaciones", "Ingenieria,Red,Comunicaciones", "Ingenieria", "Telecomunicaciones,Sistemas,Ingenieria", "Añadir Descripcion", "1", "4", "3");
        Tesis tesis4 = new Tesis("Floriza Felipa Avila Pesquera", "Protocolos para transmisiones a altas velocidades", "Red,Protocolos", "Ingenieria", "Ingenieria,Redes,Internet", "Añadir Descripcion", "1", "4", "3");
        Tesis tesis5 = new Tesis("Juan Carlos Telon Miranda", "Protocolos de Red", "Red,Protocolos", "Ingenieria", "Ingenieria,Redes,Internet", "Añadir Descripcion", "1", "4", "3");
        arregloTesis[0] = tesis1;
        arregloTesis[1] = tesis2;
        arregloTesis[2] = tesis3;
        arregloTesis[3] = tesis4;
        arregloTesis[4] = tesis5;
        numeroTesis = 5;
    }

    public static void cargarRevistasDefault() {
        Revista revista1 = new Revista("Juan Carlos Estrada Quiñonez", "Un Ingeniero en un mundo de Abogados", "Ingeniero,Abogado,Mundo", "Mensual", "8", "Ingenieria,Problematica,Solucion", "Añadir Descripcion", "5", "4", "3");
        Revista revista2 = new Revista("Marco Eudilio Perez Soto", "Ingenieria Moderna", "Ingenieria,Procesos,Internet", "Semanal", "5", "Ingenieria,Actualidad,Pasado", "Añadir Descripcion", "2", "2", "1");
        Revista revista3 = new Revista("Maria Inez Roca Marroquin", "Soy Ingeniera", "Ingenieria,Administracion", "Mensual", "7", "Ingenieria,Cero Diferencias,Capacidades", "Añadir Descripcion", "4", "2", "1");
        Revista revista4 = new Revista("Marta Lucia Giron Paz", "Fisica Moderna", "Fisica,Particulas,Atomos", "Semanal", "4", "Fisica,Teoria de Cuerdas,Fundadores,Fisica Cuantica", "Añadir Descripcion", "8", "9", "8");
        Revista revista5 = new Revista("Juan Carlos Peña Olivo", "Fisica Clasica", "Fisica,Particulas,Atomos", "Semanal", "1", "Fisica,Teoria de Cuerdas,Fundadores,Fisica Cuantica", "Añadir Descripcion", "8", "9", "8");
        arregloRevista[0] = revista1;
        arregloRevista[1] = revista2;
        arregloRevista[2] = revista3;
        arregloRevista[3] = revista4;
        arregloRevista[4] = revista5;
        numeroRevistas = 5;
    }

    public static void cargarLibrosDefault() {
        Libro libro1 = new Libro("Baldor", "Algebra", "Matematica,Algebra", "Suma,Resta,Agrupacion,Factorizacion", "Libro acerca de Algebra", "9", "5", "4");
        Libro libro2 = new Libro("Timberlake", "Fisica Conceptos y Aplicaciones", "Fisica,Matematica,Fisica Aplicada", "Suma,Momentos,Mecanica,Fluidos,Termodinamica", "Libro acerca de Fisica", "6", "5", "4");
        Libro libro3 = new Libro("Timberlake", "Actualización Quimica", "Quimica,Matematica,Quimica Aplicada,", "Mediciones,Materia y Energia,Cantidades Quimicas, Gases", "Libro acerca de Quimica", "2", "2", "1");
        Libro libro4 = new Libro("James Stewart", "Cálculo Trascendentes Tempranas", "Matematica,Cálculo,Derivar,Integrar", "Funciones,Derivadas,Integrales,Técnicas de Integracion", "Libro acerca de Calculo", "4", "3", "2");
        Libro libro5 = new Libro("James Stewart", "Precálculo", "Matematica,Fúnciones", "Funciones", "Libro acerca de Precalculo", "4", "3", "2");
        arregloLibro[0] = libro1;
        arregloLibro[1] = libro2;
        arregloLibro[2] = libro3;
        arregloLibro[3] = libro4;
        arregloLibro[4] = libro5;
        numeroLibros = 5;
    }

    public static void main(String[] args) throws ParseException {
        cargarUsuariosDefault();
        cargarTesisDefault();
        cargarLibrosDefault();
        cargarRevistasDefault();
        cargarPrestamosDefault();
        Inicio I = new Inicio();//crea un nuevo objeto del tipo de esta clase
        I.setVisible(true);//hace el objeto visible
    }

    private class Login extends JFrame {

        //Declaracion de los JLabels
        JLabel jlUsuario;
        JLabel jlPassword;

        //Declaracion de los JTextFields
        JTextField jtUsuario;

        //Declaracion de los JPasswordFields
        JPasswordField jpPassword;

        //Declaracion de Botones
        JButton jbAceptar;
        JButton jbCancelar;
        //Constructor de Login

        public Login() {
            super("Login");
            inicializacionLogin();//Se llama al Void que genera la Ventana Grafica
        }
        //Crea la Ventana Grafica

        private void inicializacionLogin() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(400, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            //Creacion de los Objetos
            jlUsuario = new JLabel("Usuario: ");
            jlPassword = new JLabel("Password: ");
            jbAceptar = new JButton("Aceptar");
            jbCancelar = new JButton("Cancelar");
            jtUsuario = new JTextField();
            jpPassword = new JPasswordField();

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            jlUsuario.setBounds(80, 30, 75, 20);
            jlPassword.setBounds(80, 65, 75, 20);
            jtUsuario.setBounds(160, 30, 150, 25);
            jpPassword.setBounds(160, 65, 150, 25);
            jbAceptar.setBounds(76, 160, 100, 25);
            jbCancelar.setBounds(206, 160, 100, 25);

            //Al dar Clic
            jbAceptar.addActionListener((ActionEvent e) -> {
                jbAceptarAccion();
            });
            jbCancelar.addActionListener((ActionEvent e) -> {
                jbCancelarAccion();
            });

            //Se agregan los Objetos
            add(jlUsuario);
            add(jlPassword);
            add(jtUsuario);
            add(jpPassword);
            add(jbAceptar);
            add(jbCancelar);
        }
        //Accion para el Boton Aceptar

        private void jbAceptarAccion() {
            String usuario = jtUsuario.getText();//Obtiene el Usuario
            String password = jpPassword.getText();//Obtiene el Password
            int contador = 0;//Se usa para almacenar
            int administrador = 0;//Se usa para almacenar
            String rol = "";
            for (int i = 0; i < numeroUsuarios; i++) {
                if (arregloUsuario[i].getUsuario().equals(usuario) && arregloUsuario[i].getPassword().equals(password)) {//Comprueba el usuario Existe y si la Contraseña coincide
                    if (arregloUsuario[i].getRol().equals("Administrador")) {
                        administrador = 1;
                        rol = arregloUsuario[i].getRol();
                    } else if (!arregloUsuario[i].getRol().equals("Administrador")) {
                        rol = arregloUsuario[i].getRol();
                        administrador = administrador;
                    }
                    usuarioActual = arregloUsuario[i].getDPI();
                    contador = 1;
                } else {
                    contador = contador;
                }
            }
            if (contador == 1) {//Verifica si el For anterior encontro los datos correctos o no

                //Verifica si el Usuario es Administrador o es un Usuario Normal
                if (administrador == 1) {
                    this.setVisible(false);
                    Administrador A = new Administrador();
                    A.setVisible(true);
                } else {
                    this.setVisible(false);
                    MenuUsuario MU = new MenuUsuario();
                    MU.setVisible(true);
                }
            } else if (contador == 0) {
                JOptionPane.showMessageDialog(this, "Los Datos no Coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Accion para el Boton Cancelar

        private void jbCancelarAccion() {
            jtUsuario.setText("");//Limpia el Usuario
            jpPassword.setText("");//Limpia el Password
        }
    }

    private class MenuUsuario extends JFrame {

        //Se definen los JButton
        JButton jbSalir;
        JButton jbCrearPrestamo;
        JButton jbDevolverPrestamo;
        JButton jbVerMiBiblioteca;
        JButton jbVerHistorial;
        JButton jbVerBiblioteca;
        JLabel jlUsuario;

        //Creacion del Constructor
        public MenuUsuario() {
            super("MenuUsuario");
            inicializacionMenuUsuario();
        }

        //Creacion de la Ventana Grafica
        public void inicializacionMenuUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1050, 450); //Fijacion del tamaño de la ventana 1050px en X, 450px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica

            //Creacion de los Objetos
            jbSalir = new JButton("Salir");
            jbCrearPrestamo = new JButton("Crear Prestamo");
            jbDevolverPrestamo = new JButton("Devolver Prestamo");
            jbVerMiBiblioteca = new JButton("Ver Mi Biblioteca");
            jbVerHistorial = new JButton("Ver Historial");
            jbVerBiblioteca = new JButton("Ver Biblioteca");
            jlUsuario = new JLabel("");

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            jbSalir.setBounds(425, 350, 200, 50);
            jlUsuario.setBounds(400, 40, 250, 50);
            jbCrearPrestamo.setBounds(80, 170, 200, 50);
            jbDevolverPrestamo.setBounds(300, 170, 200, 50);
            jbVerMiBiblioteca.setBounds(520, 170, 200, 50);
            jbVerHistorial.setBounds(740, 170, 200, 50);
            jbVerBiblioteca.setBounds(80, 240, 200, 50);

            //Al dar Clic
            jbSalir.addActionListener((ActionEvent e) -> {
                jbAccionSalir();
            });
            jbCrearPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionCrearPrestamo();
            });
            jbVerHistorial.addActionListener((ActionEvent e) -> {
                jbAccionVerHistorial();
            });
            jbVerMiBiblioteca.addActionListener((ActionEvent e) -> {
                jbAccionVerMiBiblioteca();
            });
            jbVerBiblioteca.addActionListener((ActionEvent e) -> {
                jbAccionVerBiblioteca();
            });
            jbDevolverPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionDevolverPrestamo();
            });
            //Agregar los Objetos al Layout
            add(jbSalir);
            add(jbCrearPrestamo);
            add(jbDevolverPrestamo);
            add(jbVerMiBiblioteca);
            add(jbVerHistorial);
            add(jbVerBiblioteca);
            add(jlUsuario);

            for (int i = 0; i < numeroUsuarios; i++) {
                if (arregloUsuario[i].getDPI().equals(usuarioActual)) {
                    jlUsuario.setText(arregloUsuario[i].getNombre() + " " + arregloUsuario[i].getApellido());
                }
            }
            Font fuente = jlUsuario.getFont();
            jlUsuario.setFont(new Font(fuente.getFontName(), fuente.getStyle(), 30));
        }

        private void jbAccionSalir() {
            this.setVisible(false);
            Inicio I = new Inicio();
            I.setVisible(true);
        }

        private void jbAccionDevolverPrestamo() {
            this.setVisible(false);
            DevolverPrestamo DP = new DevolverPrestamo();
            DP.setVisible(true);
        }

        private void jbAccionCrearPrestamo() {
            this.setVisible(false);
            CrearPrestamoUsuario CPu = new CrearPrestamoUsuario();
            CPu.setVisible(true);
        }

        private void jbAccionVerHistorial() {
            this.setVisible(false);
            VerHistorial VH = new VerHistorial();
            VH.setVisible(true);
        }

        private void jbAccionVerMiBiblioteca() {
            this.setVisible(false);
            VerMiBiblioteca VMB = new VerMiBiblioteca();
            VMB.setVisible(true);
        }

        private void jbAccionVerBiblioteca() {
            this.setVisible(false);
            VerBiblioteca VB = new VerBiblioteca();
            VB.setVisible(true);
        }
    }

    private class CrearPrestamoUsuario extends JFrame {

        JLabel jlBuscar;
        JTextField jtBuscar;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane

        JButton jbBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public CrearPrestamoUsuario() {
            super("CrearPrestamoUsuario");
            inicializacionCrearPrestamoUsuario();
        }

        public void inicializacionCrearPrestamoUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jlBuscar = new JLabel("Buscar: ");
            jbBuscar = new JButton("Buscar");
            jbRegresarUsuario = new JButton("Regresar");
            jtBuscar = new JTextField("");
            jbBuscar.setBounds(460, 25, 80, 30);
            jbRegresarUsuario.setBounds(220, 410, 90, 30);
            jlBuscar.setBounds(220, 25, 70, 25);
            jtBuscar.setBounds(290, 25, 150, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarUsuario();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });
            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                            edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                            PantallaPrestamo PP = new PantallaPrestamo();
                            PP.setVisible(true);
                        }
                    }
                }
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);

        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            JTable jtModificarBibliografia;
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                jtModificarBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarUsuario = new JButton("Regresar");
                jbRegresarUsuario.setBounds(130, 375, 130, 25);

                jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                    jbRegresarUsuario();
                });

                jtModificarBibliografia.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            int fila = jtModificarBibliografia.rowAtPoint(e.getPoint());
                            int columna = jtModificarBibliografia.columnAtPoint(e.getPoint());
                            if (fila > -1 && columna > -1) {
                                tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                                autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                                titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                                palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                                edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                                PantallaPrestamo PP = new PantallaPrestamo();
                                PP.setVisible(true);
                            }
                        }
                    }
                });
                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarUsuario);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarUsuario() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            MenuUsuario MU = new MenuUsuario();//Crea el Objeto de la Clase Administrador
            MU.setVisible(true);//Muestra el JFrame de Administrador
        }

        private class PantallaPrestamo extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JLabel jlEdicion;
            JLabel jlFecha_Prestamo;
            JLabel jlFecha_Devolucion;
            JTextField jtAutor;
            JTextField jtTitulo;
            JTextField jtEdicion;
            JTextField jtFecha_Prestamo;
            JTextField jtFecha_Devolucion;
            JComboBox jcTipo;
            JButton jbPrestamo;
            JButton jbRegresar;

            public PantallaPrestamo() {
                super("PantallaPrestamo");
                inicializacionPantallaPrestamo();
            }

            private void inicializacionPantallaPrestamo() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jlEdicion = new JLabel("Edicion: ");
                jlFecha_Prestamo = new JLabel("Fecha Prestamo: ");
                jlFecha_Devolucion = new JLabel("Fecha Devolucion: ");
                jtAutor = new JTextField("");
                jtTitulo = new JTextField("");
                jtEdicion = new JTextField("");
                jtFecha_Prestamo = new JTextField("");
                jtFecha_Devolucion = new JTextField("");
                jcTipo = new JComboBox();
                jbPrestamo = new JButton("Aceptar");
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jlEdicion.setBounds(30, 130, 150, 25);
                jlFecha_Prestamo.setBounds(30, 165, 150, 25);
                jlFecha_Devolucion.setBounds(30, 200, 150, 25);
                jcTipo.setBounds(140, 25, 150, 25);
                jtAutor.setBounds(140, 60, 150, 25);
                jtTitulo.setBounds(140, 95, 150, 25);
                jtEdicion.setBounds(140, 130, 150, 25);
                jtFecha_Prestamo.setBounds(140, 165, 150, 25);
                jtFecha_Devolucion.setBounds(140, 200, 150, 25);
                jbPrestamo.setBounds(300, 100, 90, 30);
                jbRegresar.setBounds(300, 130, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlEdicion);
                add(jlFecha_Prestamo);
                add(jlFecha_Devolucion);
                add(jtAutor);
                add(jtTitulo);
                add(jtEdicion);
                add(jtFecha_Prestamo);
                add(jtFecha_Devolucion);
                add(jcTipo);
                add(jbPrestamo);
                add(jbRegresar);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });

                jbPrestamo.addActionListener((ActionEvent e) -> {
                    try {
                        jbPrestamo();
                        inicializacionCrearPrestamoUsuario();
                    } catch (ParseException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }

            private void jbRegresar() {
                this.dispose();
            }

            private void llenarCampos() {
                Date fecha = new Date();
                int contador = 0;
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jtEdicion.setEditable(false);
                jcTipo.setEnabled(false);
                jtFecha_Prestamo.setEditable(false);
                jtFecha_Devolucion.setToolTipText("dd-MM-yyyy");
                jtFecha_Prestamo.setText(new SimpleDateFormat("dd-MM-yyyy").format(fecha));
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloTesis[i].getAutor()));
                                jtTitulo.setText(arregloTesis[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloTesis[i].getEdicion()));
                                jcTipo.setSelectedIndex(1);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Libros":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloLibro[i].getAutor()));
                                jtTitulo.setText(arregloLibro[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloLibro[i].getEdicion()));
                                jcTipo.setSelectedIndex(2);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloRevista[i].getAutor()));
                                jtTitulo.setText(arregloRevista[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloRevista[i].getEdicion()));
                                jcTipo.setSelectedIndex(3);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        break;
                }
            }

            private void jbPrestamo() throws ParseException {
                if (!jtFecha_Prestamo.getText().isEmpty() && !jtFecha_Devolucion.getText().isEmpty()) {
                    if (verificarFecha(jtFecha_Prestamo.getText()) && verificarFecha(jtFecha_Devolucion.getText())) {
                        String[] split1 = jtFecha_Prestamo.getText().split("-");
                        String[] split2 = jtFecha_Devolucion.getText().split("-");
                        int[] numeros1 = new int[3];
                        int[] numeros2 = new int[3];
                        for (int i = 0; i < split1.length; i++) {
                            numeros1[i] = Integer.parseInt(split1[i]);
                            numeros2[i] = Integer.parseInt(split2[i]);
                        }
                        boolean continuar = false;
                        if (numeros2[2] > numeros1[2]) {
                            continuar = false;
                        } else {
                            if (numeros2[1] > numeros1[1]) {
                                continuar = false;
                            } else {
                                if (numeros2[0] > numeros1[0]) {
                                    continuar = false;
                                } else {
                                    continuar = true;
                                }
                            }
                        }
                        if (!continuar) {
                            String indexTipo = "";
                            DateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                            switch (jcTipo.getSelectedIndex()) {
                                case 0:
                                    break;
                                case 1:
                                    indexTipo = "Tesis";
                                    break;
                                case 2:
                                    indexTipo = "Libro";
                                    break;
                                case 3:
                                    indexTipo = "Revista";
                                    break;
                            }
                            int contador = 0;
                            for (int i = 0; i < numeroPrestamos; i++) {
                                if (arregloPrestamo[i].getTipo().equals(indexTipo) && arregloPrestamo[i].getAutor().equals(jtAutor.getText()) && arregloPrestamo[i].getTitulo().equals(jtTitulo.getText()) && arregloPrestamo[i].getDpi().equals(usuarioActual) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                                    contador++;
                                } else {
                                    contador = contador;
                                }
                            }
                            if (contador >= 1) {
                                JOptionPane.showMessageDialog(this, "Ya cuenta con una Copia de este Documento", "Error", JOptionPane.ERROR_MESSAGE);
                                this.dispose();
                            } else {
                                //Se Verifica que hayan disponibles
                                switch (indexTipo) {
                                    case "Tesis":
                                        for (int i = 0; i < numeroTesis; i++) {
                                            if (arregloTesis[i].getAutor().equals(jtAutor.getText()) && arregloTesis[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloTesis[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), jtFecha_Devolucion.getText(), usuarioActual, "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloTesis[i].setDisponibles(String.valueOf(Integer.parseInt(arregloTesis[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case "Libro":
                                        for (int i = 0; i < numeroLibros; i++) {
                                            if (arregloLibro[i].getAutor().equals(jtAutor.getText()) && arregloLibro[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloLibro[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), jtFecha_Devolucion.getText(), usuarioActual, "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloLibro[i].setDisponibles(String.valueOf(Integer.parseInt(arregloLibro[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case "Revista":
                                        for (int i = 0; i < numeroRevistas; i++) {
                                            if (arregloRevista[i].getAutor().equals(jtAutor.getText()) && arregloRevista[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloRevista[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), jtFecha_Devolucion.getText(), usuarioActual, "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloRevista[i].setDisponibles(String.valueOf(Integer.parseInt(arregloRevista[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese Fecha Correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese Formato De Fecha Correcto dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese Fecha", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean verificarFecha(String cadena) {
                DateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                Date dates = new Date();
                try {
                    dates = formato.parse(cadena);
                    return true;
                } catch (ParseException e) {
                    return false;
                }
            }
        }
    }

    private class DevolverPrestamo extends JFrame {

        //Se define la JTable
        JTable jtVerBibliografia;
        JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public DevolverPrestamo() {
            super("DevolverPrestamo");
            inicializacionDevolverPrestamo();
        }

        public void inicializacionDevolverPrestamo() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][10];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                if (arregloPrestamo[i].getDpi().equals(usuarioActual) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                    Date fecha = new Date();
                    String date = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
                    String[] split1 = date.split("-");
                    String[] split2 = arregloPrestamo[i].getFecha_Devolucion().split("-");
                    int[] numeros1 = new int[3];
                    int[] numeros2 = new int[3];
                    for (int j = 0; j < split1.length; j++) {
                        numeros1[j] = Integer.parseInt(split1[j]);
                        numeros2[j] = Integer.parseInt(split2[j]);
                    }
                    boolean continuar = false;
                    if (numeros2[2] > numeros1[2]) {
                        continuar = false;
                    } else {
                        if (numeros2[1] > numeros1[1]) {
                            continuar = false;
                        } else {
                            if (numeros2[0] > numeros1[0]) {
                                continuar = false;
                            } else {
                                continuar = true;
                            }
                        }
                    }
                    if (!continuar) {
                        datos[contador][0] = contador;
                        datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                        datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                        datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                        datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                        datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                        datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                        datos[contador][7] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                        datos[contador][8] = arregloPrestamo[i].getEliminado();//Se obtiene el Rol
                        datos[contador][9] = arregloPrestamo[i].getModificado();//Se obtiene el Rol
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "Entregado", "Eliminado", "Modificado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 10; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(9).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarUsuario();
            });
            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            PantallaDevolver PD = new PantallaDevolver();
                            PD.setVisible(true);
                        }
                    }
                }
            });

            jsVerUsuario.setBounds(20, 40, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);
        }

        private class PantallaDevolver extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JTextField jtAutor;
            JTextField jtTitulo;
            JComboBox jcTipo;
            JButton jbDevolver;
            JButton jbRegresar;

            public PantallaDevolver() {
                super("PantallaDevolver");
                inicializacionPantallaBibliografia();
            }

            private void inicializacionPantallaBibliografia() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jtAutor = new JTextField("");
                jtTitulo = new JTextField("");
                jcTipo = new JComboBox();
                jbDevolver = new JButton("Devolver");
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jcTipo.setBounds(140, 25, 150, 25);
                jtAutor.setBounds(140, 60, 150, 25);
                jtTitulo.setBounds(140, 95, 150, 25);

                jbRegresar.setBounds(300, 130, 90, 30);
                jbDevolver.setBounds(200, 130, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 450); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jtAutor);
                add(jtTitulo);
                add(jcTipo);
                add(jbRegresar);
                add(jbDevolver);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });
                jbDevolver.addActionListener((ActionEvent e) -> {
                    jbDevolver();
                    inicializacionDevolverPrestamo();
                });
            }

            private void llenarCampos() {
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jcTipo.setEnabled(false);
                jtAutor.setText(autor);
                jtTitulo.setText(titulo);
                switch (tipo) {
                    case "Tesis":
                        jcTipo.setSelectedIndex(1);
                        break;
                    case "Libro":
                        jcTipo.setSelectedIndex(2);
                        break;
                    case "Revista":
                        jcTipo.setSelectedIndex(2);
                        break;
                    default:
                        break;
                }
            }

            private void jbDevolver() {
                for (int i = 0; i < numeroPrestamos; i++) {
                    if (arregloPrestamo[i].getAutor().equals(autor) && arregloPrestamo[i].getTipo().equals(tipo) && arregloPrestamo[i].getTitulo().equals(titulo) && arregloPrestamo[i].getDpi().equals(usuarioActual) && arregloPrestamo[i].getEntregado().equals("NO")) {
                        String aEntregado = "SI";
                        arregloPrestamo[i].setEntregado(aEntregado);
                        switch (tipo) {
                            case "Tesis":
                                for (int j = 0; j < numeroTesis; j++) {
                                    if (arregloTesis[j].getAutor().equals(autor) && arregloTesis[j].getTitulo().equals(titulo)) {
                                        arregloTesis[j].setDisponibles(String.valueOf(Integer.parseInt(arregloTesis[j].getDisponibles()) + 1));
                                    }
                                }
                                break;
                            case "Libro":
                                for (int j = 0; j < numeroLibros; j++) {
                                    if (arregloLibro[j].getAutor().equals(autor) && arregloLibro[j].getTitulo().equals(titulo)) {
                                        arregloLibro[j].setDisponibles(String.valueOf(Integer.parseInt(arregloLibro[j].getDisponibles()) + 1));
                                    }
                                }
                                break;
                            case "Revista":
                                for (int j = 0; j < numeroRevistas; j++) {
                                    if (arregloRevista[j].getAutor().equals(autor) && arregloRevista[j].getTitulo().equals(titulo)) {
                                        arregloRevista[j].setDisponibles(String.valueOf(Integer.parseInt(arregloRevista[j].getDisponibles()) + 1));
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        JOptionPane.showMessageDialog(this, "Prestamo Entregado", "Entregado", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                }
            }

            private void jbRegresar() {
                this.dispose();
            }
        }

        //Accion Boton Regresar
        private void jbRegresarUsuario() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            MenuUsuario MU = new MenuUsuario();//Crea el Objeto de la Clase Administrador
            MU.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class VerMiBiblioteca extends JFrame {

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public VerMiBiblioteca() {
            super("VerMiBiblioteca");
            inicializacionVerUsuario();
        }

        public void inicializacionVerUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][10];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                if (arregloPrestamo[i].getDpi().equals(usuarioActual) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                    datos[contador][0] = contador;
                    datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                    datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                    datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                    datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                    datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                    datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                    datos[contador][7] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                    datos[contador][8] = arregloPrestamo[i].getEliminado();//Se obtiene el Rol
                    datos[contador][9] = arregloPrestamo[i].getModificado();//Se obtiene el Rol
                    contador++;
                }
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "Entregado", "Eliminado", "Modificado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 10; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.getColumnModel().getColumn(9).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarUsuario();
            });
            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            PantallaBibliografia PB = new PantallaBibliografia();
                            PB.setVisible(true);
                        }
                    }
                }
            });
            JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane

            jsVerUsuario.setBounds(20, 40, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);
        }

        private class PantallaBibliografia extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JLabel jlPalabras;
            JLabel jlTemas;
            JLabel jlDescripcion;
            JLabel jlEdicion;
            JLabel jlCopias;
            JLabel jlDisponibles;
            JTextField jtAutor;
            JTextField jtTitulo;
            JTextField jtPalabras;
            JTextField jtTemas;
            JTextField jtDescripcion;
            JTextField jtEdicion;
            JTextField jtCopias;
            JTextField jtDisponibles;
            JComboBox jcTipo;
            JButton jbRegresar;

            public PantallaBibliografia() {
                super("PantallaBibliografia");
                inicializacionPantallaBibliografia();
            }

            private void inicializacionPantallaBibliografia() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jlPalabras = new JLabel("Palabras Clave: ");
                jlTemas = new JLabel("Temas: ");
                jlDescripcion = new JLabel("Descripcion: ");
                jlEdicion = new JLabel("Edicion: ");
                jlCopias = new JLabel("Copias: ");
                jlDisponibles = new JLabel("Disponibles: ");
                jtAutor = new JTextField("");
                jtTitulo = new JTextField("");
                jtPalabras = new JTextField("");
                jtTemas = new JTextField("");
                jtDescripcion = new JTextField("");
                jtEdicion = new JTextField("");
                jtCopias = new JTextField("");
                jtDisponibles = new JTextField("");
                jcTipo = new JComboBox();
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jlPalabras.setBounds(30, 130, 150, 25);
                jlTemas.setBounds(30, 165, 150, 25);
                jlDescripcion.setBounds(30, 200, 150, 25);
                jlEdicion.setBounds(30, 235, 150, 25);
                jlCopias.setBounds(30, 270, 150, 25);
                jlDisponibles.setBounds(30, 305, 150, 25);
                jcTipo.setBounds(140, 25, 150, 25);
                jtAutor.setBounds(140, 60, 150, 25);
                jtTitulo.setBounds(140, 95, 150, 25);
                jtPalabras.setBounds(140, 130, 150, 25);
                jtTemas.setBounds(140, 165, 150, 25);
                jtDescripcion.setBounds(140, 200, 150, 25);
                jtEdicion.setBounds(140, 235, 150, 25);
                jtCopias.setBounds(140, 270, 150, 25);
                jtDisponibles.setBounds(140, 305, 150, 25);

                jbRegresar.setBounds(300, 130, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 450); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlPalabras);
                add(jlTemas);
                add(jlDescripcion);
                add(jlEdicion);
                add(jlCopias);
                add(jlDisponibles);
                add(jtAutor);
                add(jtTitulo);
                add(jtPalabras);
                add(jtTemas);
                add(jtDescripcion);
                add(jtEdicion);
                add(jtCopias);
                add(jtDisponibles);
                add(jcTipo);
                add(jbRegresar);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });
            }

            private void llenarCampos() {
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jtPalabras.setEditable(false);
                jtTemas.setEditable(false);
                jtDescripcion.setEditable(false);
                jtEdicion.setEditable(false);
                jtCopias.setEditable(false);
                jtDisponibles.setEditable(false);
                jcTipo.setEnabled(false);
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo)) {
                                jtAutor.setText(arregloTesis[i].getAutor());
                                jtTitulo.setText(arregloTesis[i].getTitulo());
                                jtPalabras.setText(arregloTesis[i].getPalabras_Clave());
                                jtTemas.setText(arregloTesis[i].getTemas());
                                jtDescripcion.setText(arregloTesis[i].getDescripcion());
                                jtEdicion.setText(String.valueOf(arregloTesis[i].getEdicion()));
                                jtCopias.setText(String.valueOf(arregloTesis[i].getCopias()));
                                jtDisponibles.setText(String.valueOf(arregloTesis[i].getDisponibles()));
                                jcTipo.setSelectedIndex(1);
                            }
                        }
                        break;
                    case "Libro":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras)) {
                                jtAutor.setText(arregloLibro[i].getAutor());
                                jtTitulo.setText(arregloLibro[i].getTitulo());
                                jtPalabras.setText(arregloLibro[i].getPalabras_Clave());
                                jtTemas.setText(arregloLibro[i].getTemas());
                                jtDescripcion.setText(arregloLibro[i].getDescripcion());
                                jtEdicion.setText(String.valueOf(arregloLibro[i].getEdicion()));
                                jtCopias.setText(String.valueOf(arregloLibro[i].getCopias()));
                                jtDisponibles.setText(String.valueOf(arregloLibro[i].getDisponibles()));
                                jcTipo.setSelectedIndex(2);
                            }
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras)) {
                                jtAutor.setText(arregloRevista[i].getAutor());
                                jtTitulo.setText(arregloRevista[i].getTitulo());
                                jtPalabras.setText(arregloRevista[i].getPalabras_Clave());
                                jtTemas.setText(arregloRevista[i].getTemas());
                                jtDescripcion.setText(arregloRevista[i].getDescripcion());
                                jtEdicion.setText(String.valueOf(arregloRevista[i].getEdicion()));
                                jtCopias.setText(String.valueOf(arregloRevista[i].getCopias()));
                                jtDisponibles.setText(String.valueOf(arregloRevista[i].getDisponibles()));
                                jcTipo.setSelectedIndex(3);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

            private void jbRegresar() {
                this.dispose();
            }
        }

        //Accion Boton Regresar
        private void jbRegresarUsuario() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            MenuUsuario MU = new MenuUsuario();//Crea el Objeto de la Clase Administrador
            MU.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class VerBiblioteca extends JFrame {

        JTable jtModificarBibliografia;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane
        JButton jbBuscar;
        JLabel jlBuscar;
        JTextField jtBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public VerBiblioteca() {
            super("VerBiblioteca");
            inicializacionVerBibliografia();
        }

        public void inicializacionVerBibliografia() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(220, 410, 90, 30);
            jbBuscar = new JButton("Buscar");
            jlBuscar = new JLabel("Buscar: ");
            jtBuscar = new JTextField("");
            jlBuscar.setBounds(20, 10, 125, 25);
            jtBuscar.setBounds(80, 10, 125, 25);
            jbBuscar.setBounds(220, 10, 75, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            DefaultTableModel modelo = new DefaultTableModel(datos, nombres);
            jtVerBibliografia = new JTable(modelo);//Se crea la tabla con los datos y encabezados
            DefaultTableModel ordenar = (DefaultTableModel) jtVerBibliografia.getModel();
            jtVerBibliografia.setRowSorter(new TableRowSorter(ordenar));
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarUsuarioAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);
        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[i][0] = i;
                        datos[i][1] = "Tesis";
                        datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[i][6] = "-";
                        datos[i][7] = "-";
                        datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;

                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                DefaultTableModel modelo = new DefaultTableModel(datos, nombres);
                jtModificarBibliografia = new JTable(modelo);//Se crea la tabla con los datos y encabezados
                DefaultTableModel ordenar = (DefaultTableModel) jtModificarBibliografia.getModel();
                jtModificarBibliografia.setRowSorter(new TableRowSorter(ordenar));
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarUsuario = new JButton("Regresar");
                jbRegresarUsuario.setBounds(130, 375, 130, 25);

                jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                    jbRegresarUsuarioAccion();
                });

                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarUsuario);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarUsuarioAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            MenuUsuario MU = new MenuUsuario();//Crea el Objeto de la Clase Administrador
            MU.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class VerHistorial extends JFrame {

        //Se define la JTable
        JTable jtVerHistorial;

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public VerHistorial() {
            super("VerHistorial");
            inicializacionVerUsuario();
        }

        public void inicializacionVerUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][10];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                if (arregloPrestamo[i].getDpi().equals(usuarioActual)) {
                    datos[contador][0] = contador;
                    datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                    datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                    datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                    datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                    datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                    datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                    datos[contador][7] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                    datos[contador][8] = arregloPrestamo[i].getEliminado();//Se obtiene el Rol
                    datos[contador][9] = arregloPrestamo[i].getModificado();//Se obtiene el Rol
                    contador++;
                }
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "Entregado", "Eliminado", "Modificado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerHistorial = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 10; i++) {
                jtVerHistorial.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerHistorial.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(9).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarUsuario();
            });

            JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane
            jsVerUsuario.setBounds(20, 20, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerHistorial);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);

        }

        //Accion Boton Regresar
        private void jbRegresarUsuario() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            MenuUsuario MU = new MenuUsuario();//Crea el Objeto de la Clase Administrador
            MU.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class CrearUsuario extends JFrame {

        //Declaracion de los JLabels
        JLabel jlDPI;
        JLabel jlNombre;
        JLabel jlApellido;
        JLabel jlUsuario;
        JLabel jlRol;
        JLabel jlPassword;
        JLabel jlRpassword;

        //Declaracion de los JTextFields
        JTextField jtDPI;
        JTextField jtNombre;
        JTextField jtApellido;
        JTextField jtUsuario;

        //Declaracion de los JPasswordFields
        JPasswordField jpPassword;
        JPasswordField jpRpassword;

        //Declaracion de los JComboBox
        JComboBox jcRol;

        //Declaracion de Botones
        JButton jbAceptar;
        JButton jbCancelar;
        JButton jbRegresarAdministrador;

        //Constructor de CrearUsuario
        public CrearUsuario() {
            super("CrearUsuario");
            inicializacionCrearUsuario();//Se llama al Void que genera la Ventana Grafica
        }

        //Crea la Ventana Grafica
        private void inicializacionCrearUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(800, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo 
            setLayout(null);//Elimina el Layout para poder Agregar las posiciones de manera Estatica

            //Crear los Objetos
            jlDPI = new JLabel("DPI: ");
            jlNombre = new JLabel("Nombre: ");
            jlApellido = new JLabel("Apellido: ");
            jlUsuario = new JLabel("Usuario: ");
            jlRol = new JLabel("Rol: ");
            jlPassword = new JLabel("Password: ");
            jlRpassword = new JLabel("Repetir Password: ");
            jtDPI = new JTextField("");
            jtNombre = new JTextField("");
            jtApellido = new JTextField("");
            jtUsuario = new JTextField("");
            jcRol = new JComboBox();
            jpPassword = new JPasswordField("");
            jpRpassword = new JPasswordField("");
            jbAceptar = new JButton("Aceptar");
            jbCancelar = new JButton("Cancelar");
            jbRegresarAdministrador = new JButton("Regresar");

            //Agregar Items al ComboBox
            jcRol.addItem("Seleccionar");//Index 0
            jcRol.addItem("Catedrático");//Index 1
            jcRol.addItem("Estudiante");//Index 2

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            jlDPI.setBounds(80, 30, 75, 20);
            jlNombre.setBounds(80, 65, 75, 20);
            jlApellido.setBounds(80, 100, 75, 20);
            jlUsuario.setBounds(80, 135, 75, 20);
            jlRol.setBounds(80, 170, 75, 20);
            jlPassword.setBounds(80, 205, 75, 20);
            jlRpassword.setBounds(35, 240, 110, 20);
            jtDPI.setBounds(160, 30, 150, 25);
            jtNombre.setBounds(160, 65, 150, 25);
            jtApellido.setBounds(160, 100, 150, 25);
            jtUsuario.setBounds(160, 135, 150, 25);
            jcRol.setBounds(160, 170, 150, 25);
            jpPassword.setBounds(160, 205, 150, 25);
            jpRpassword.setBounds(160, 240, 150, 25);
            jbAceptar.setBounds(76, 335, 90, 25);
            jbCancelar.setBounds(206, 335, 90, 25);
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            //Al dar Clic
            jbAceptar.addActionListener((ActionEvent e) -> {
                jbAceptarAccion();
            });
            jbCancelar.addActionListener((ActionEvent e) -> {
                jbCancelarAccion();
            });
            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });

            //Agregar los Objetos al Layout
            add(jlDPI);
            add(jlNombre);
            add(jlApellido);
            add(jlUsuario);
            add(jlRol);
            add(jlPassword);
            add(jlRpassword);
            add(jtDPI);
            add(jtNombre);
            add(jtApellido);
            add(jtUsuario);
            add(jcRol);
            add(jpPassword);
            add(jpRpassword);
            add(jbAceptar);
            add(jbCancelar);
            add(jbRegresarAdministrador);
        }

        //Accion para el Boton Aceptar
        public void jbAceptarAccion() {

            //Creacion de Variables donde se Almacenan los Textos Ingresados
            double dpi = 0;
            String transformar = jtDPI.getText();
            String nombre = jtNombre.getText();
            String apellido = jtApellido.getText();
            String usuario = jtUsuario.getText();
            String password = jpPassword.getText();
            String rpassword = jpRpassword.getText();

            //Comprobar si el DPI ingresado es Numerico
            if (verificarNumero(transformar)) {
                dpi = Double.parseDouble(transformar);
            } else {
                dpi = 0;
            }

            //Comprueba el Index que se Selecciono en el JComboBox
            int rol = jcRol.getSelectedIndex();
            String tipo = "";
            switch (rol) {
                case 0:
                    tipo = "";
                    break;
                case 1:
                    tipo = "Catedrático";
                    break;
                case 2:
                    tipo = "Estudiante";
                    break;
                default:
                    tipo = "";
                    break;
            }

            //Comprueba si se Ingresaron todos los Datos
            if (dpi != 0 && !nombre.equals("") && !apellido.equals("") && !usuario.equals("") && !password.equals("") && !rpassword.equals("") && !tipo.equals("")) {

                //Comprueba si la Contraseña coincide con la Repeticion de la Contraseña
                if (password.equals(rpassword)) {
                    int contador = 0;//Se usa para Almacenar
                    int contadorNumeros = 0;
                    for (int i = 0; i < 10; i++) {
                        if (password.contains(String.valueOf(i))) {
                            contadorNumeros++;
                        }
                    }
                    if (password.length() >= 6 && capitalizarLetra(password).equals(password) && contadorNumeros > 0 && transformar.length() == 13) {
                        for (int i = 0; i < numeroUsuarios; i++) {
                            //Verifica si ya Existe una Entrada con los datos DPI y Usuario ingresados
                            if (arregloUsuario[i].getDPI().equals(transformar) || arregloUsuario[i].getUsuario().equals(usuario)) {
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        //Verifica si el For anterior Encontro o NO un Usuario
                        if (contador == 0) {
                            //Ingresa el Usuario
                            Usuario agregar = new Usuario(transformar, nombre, apellido, usuario, password, tipo);
                            arregloUsuario[numeroUsuarios] = agregar;
                            numeroUsuarios++;
                            JOptionPane.showMessageDialog(this, "Usuario Agregado");
                            jbCancelarAccion();
                        } else {
                            JOptionPane.showMessageDialog(this, "El usuario o DPI ya fue Ingresado\nSeleccione Otro", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese Formato de Contraseña o Dpi Correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La Contraseña no Coincide", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion para el Boton Cancelar
        private void jbCancelarAccion() {
            //Limpia los JTextField y Coloca el Index 0 en el JComboBox
            jtDPI.setText("");
            jtNombre.setText("");
            jtApellido.setText("");
            jtUsuario.setText("");
            jpPassword.setText("");
            jpRpassword.setText("");
            jcRol.setSelectedIndex(0);
        }

        //Verificacion de Cadena es Numerica o No
        private boolean verificarNumero(String cadena) {
            try {
                Double.parseDouble(cadena);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class Administrador extends JFrame {

        //Se definen los JLabel
        JLabel jlUsuarios;
        JLabel jlBibliografias;
        JLabel jlPrestamos;
        JButton jbSalir;

        //Se definen los JButton
        //Usuario
        JButton jbCrearUsuario;
        JButton jbModificarUsuario;
        JButton jbEliminarUsuario;
        JButton jbVerUsuario;

        //Bibliografia
        JButton jbCrearBibliografia;
        JButton jbModificarBibliografia;
        JButton jbEliminarBibliografia;
        JButton jbVerBibliografia;

        //Prestamo
        JButton jbCrearPrestamo;
        JButton jbModificarPrestamo;
        JButton jbEliminarPrestamo;
        JButton jbVerPrestamo;

        //Creacion del Constructor
        public Administrador() {
            super("Administrador");
            inicializacionAdministrador();
        }

        //Creacion de la Ventana Grafica
        public void inicializacionAdministrador() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1050, 450); //Fijacion del tamaño de la ventana 1050px en X, 450px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica

            //Creacion de los Objetos
            //Usuario
            jlUsuarios = new JLabel("Usuarios");
            jbCrearUsuario = new JButton("Crear Usuario");
            jbModificarUsuario = new JButton("Modificar Usuario");
            jbEliminarUsuario = new JButton("Eliminar Usuario");
            jbVerUsuario = new JButton("Ver Usuario");

            //Bibliografia
            jlBibliografias = new JLabel("Bibliografias");
            jbCrearBibliografia = new JButton("Crear Bibliografia");
            jbModificarBibliografia = new JButton("Modificar Bibliografia");
            jbEliminarBibliografia = new JButton("Eliminar Bibliografia");
            jbVerBibliografia = new JButton("Ver Bibliografia");

            //Prestamo
            jlPrestamos = new JLabel("Prestamos");
            jbCrearPrestamo = new JButton("Crear Prestamo");
            jbModificarPrestamo = new JButton("Modificar Prestamo");
            jbEliminarPrestamo = new JButton("Eliminar Prestamo");
            jbVerPrestamo = new JButton("Ver Prestamo");

            jbSalir = new JButton("Salir");

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            //Usuario
            jlUsuarios.setBounds(80, 30, 75, 20);
            jbCrearUsuario.setBounds(80, 60, 200, 50);
            jbModificarUsuario.setBounds(300, 60, 200, 50);
            jbEliminarUsuario.setBounds(520, 60, 200, 50);
            jbVerUsuario.setBounds(740, 60, 200, 50);

            //Bibliografia
            jlBibliografias.setBounds(80, 140, 75, 20);
            jbCrearBibliografia.setBounds(80, 170, 200, 50);
            jbModificarBibliografia.setBounds(300, 170, 200, 50);
            jbEliminarBibliografia.setBounds(520, 170, 200, 50);
            jbVerBibliografia.setBounds(740, 170, 200, 50);

            //Prestamo
            jlPrestamos.setBounds(80, 250, 75, 20);
            jbCrearPrestamo.setBounds(80, 280, 200, 50);
            jbModificarPrestamo.setBounds(300, 280, 200, 50);
            jbEliminarPrestamo.setBounds(520, 280, 200, 50);
            jbVerPrestamo.setBounds(740, 280, 200, 50);

            jbSalir.setBounds(425, 350, 200, 50);

            //Al dar Clic
            jbEliminarPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionEliminarPrestamo();
            });
            jbModificarPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionModificarPrestamo();
            });
            jbCrearPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionCrearPrestamo();
            });
            jbVerPrestamo.addActionListener((ActionEvent e) -> {
                jbAccionVerPrestamo();
            });
            jbVerUsuario.addActionListener((ActionEvent e) -> {
                jbAccionVerUsuario();
            });
            jbCrearUsuario.addActionListener((ActionEvent e) -> {
                jbAccionCrearUsuario();
            });
            jbModificarUsuario.addActionListener((ActionEvent e) -> {
                jbAccionModificarUsuario();
            });
            jbEliminarUsuario.addActionListener((ActionEvent e) -> {
                jbAccionEliminarUsuario();
            });

            jbCrearBibliografia.addActionListener((ActionEvent e) -> {
                jbAccionCrearBibliografia();
            });
            jbVerBibliografia.addActionListener((ActionEvent e) -> {
                jbAccionVerBibliografia();
            });
            jbModificarBibliografia.addActionListener((ActionEvent e) -> {
                jbAccionModificarBibliografia();
            });
            jbEliminarBibliografia.addActionListener((ActionEvent e) -> {
                jbAccionEliminarBibliografia();
            });
            jbSalir.addActionListener((ActionEvent e) -> {
                jbAccionSalir();
            });

            //Agregar los Objetos al Layout
            //Usuario
            add(jlUsuarios);
            add(jbCrearUsuario);
            add(jbModificarUsuario);
            add(jbEliminarUsuario);
            add(jbVerUsuario);

            //Bibliografia
            add(jlBibliografias);
            add(jbCrearBibliografia);
            add(jbModificarBibliografia);
            add(jbEliminarBibliografia);
            add(jbVerBibliografia);

            //Prestamo
            add(jlPrestamos);
            add(jbCrearPrestamo);
            add(jbModificarPrestamo);
            add(jbEliminarPrestamo);
            add(jbVerPrestamo);

            add(jbSalir);
        }

        private void jbAccionEliminarPrestamo() {
            this.setVisible(false);
            EliminarPrestamoAdministrador EPA = new EliminarPrestamoAdministrador();
            EPA.setVisible(true);
        }

        private void jbAccionModificarPrestamo() {
            this.setVisible(false);
            ModificarPrestamoAdministrador MPA = new ModificarPrestamoAdministrador();
            MPA.setVisible(true);
        }

        private void jbAccionCrearPrestamo() {
            this.setVisible(false);
            CrearPrestamoAdministrador CPA = new CrearPrestamoAdministrador();
            CPA.setVisible(true);
        }

        private void jbAccionVerPrestamo() {
            this.setVisible(false);
            VerPrestamoAdministrador VPA = new VerPrestamoAdministrador();
            VPA.setVisible(true);
        }

        //Accion para el Boton Ver Usuario
        private void jbAccionVerUsuario() {
            this.setVisible(false);
            VerUsuario vU = new VerUsuario();
            vU.setVisible(true);
        }

        private void jbAccionSalir() {
            this.setVisible(false);
            Inicio I = new Inicio();
            I.setVisible(true);
        }

        //Accion para el Boton Crear Bibliografia
        private void jbAccionCrearBibliografia() {
            this.setVisible(false);
            CrearBibliografia Cb = new CrearBibliografia();
            Cb.setVisible(true);
        }

        //Accion para el Boton Ver Bibliografia
        private void jbAccionVerBibliografia() {
            this.setVisible(false);
            VerBibliografia Vb = new VerBibliografia();
            Vb.setVisible(true);
        }

        //Accion para el Boton Modificar Bibliografia
        private void jbAccionModificarBibliografia() {
            this.setVisible(false);
            ModificarBibliografia Mb = new ModificarBibliografia();
            Mb.setVisible(true);
        }

        //Accion para el Boton Eliminar Bibliografia
        private void jbAccionEliminarBibliografia() {
            this.setVisible(false);
            EliminarBibliografia Eb = new EliminarBibliografia();
            Eb.setVisible(true);
        }

        //Accion para el Boton Crear Usuario
        private void jbAccionCrearUsuario() {
            this.setVisible(false);//Oculta el JFrame de Inicio de Sesion (Login) 
            CrearUsuario C = new CrearUsuario();//Crea un nuevo Objeto de la clase CrearUsuario
            C.setVisible(true);//Muestra el JFrame obtenido de la clase CrearUsuario
        }

        //Accion para el Boton Crear Usuario
        private void jbAccionModificarUsuario() {
            this.setVisible(false);//Oculta el JFrame de Inicio de Sesion (Login) 
            ModificarUsuario M = new ModificarUsuario();//Crea un nuevo Objeto de la clase CrearUsuario
            M.setVisible(true);//Muestra el JFrame obtenido de la clase CrearUsuario
        }

        //Accion para el Boton Crear Usuario
        private void jbAccionEliminarUsuario() {
            this.setVisible(false);//Oculta el JFrame de Inicio de Sesion (Login) 
            EliminarUsuario E = new EliminarUsuario();//Crea un nuevo Objeto de la clase CrearUsuario
            E.setVisible(true);//Muestra el JFrame obtenido de la clase CrearUsuario
        }
    }

    private class EliminarPrestamoAdministrador extends JFrame {

        JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane;
        //Se define la JTable
        JTable jtVerHistorial;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public EliminarPrestamoAdministrador() {
            super("EliminarPrestamoAdministrador");
            inicializacionEliminarPrestamoAdministrador();
        }

        public void inicializacionEliminarPrestamoAdministrador() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][9];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                if (arregloPrestamo[i].getEliminado().equals("NO")) {
                    datos[contador][0] = contador;
                    datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                    datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                    datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                    datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                    datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                    datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                    datos[contador][7] = arregloPrestamo[i].getDpi();//Se obtiene el Rol
                    datos[contador][8] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                    contador++;
                }
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "DPI", "Entregado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerHistorial = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 9; i++) {
                jtVerHistorial.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerHistorial.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministrador();
            });
            jtVerHistorial.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerHistorial.rowAtPoint(e.getPoint());
                        int columna = jtVerHistorial.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerHistorial.getValueAt(fila, 1).toString();
                            autor = jtVerHistorial.getValueAt(fila, 2).toString();
                            titulo = jtVerHistorial.getValueAt(fila, 3).toString();
                            edicion = jtVerHistorial.getValueAt(fila, 7).toString();
                            PantallaEliminar PE = new PantallaEliminar();
                            PE.setVisible(true);
                        }
                    }
                }
            });
            jsVerUsuario.setBounds(20, 20, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerHistorial);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);

        }

        private class PantallaEliminar extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JLabel jlDpi;
            JTextField jtAutor;
            JTextField jtTitulo;
            JTextField jtDpi;
            JTextField jtTipo;
            JButton jbDevolver;
            JButton jbRegresar;

            public PantallaEliminar() {
                super("PantallaEliminar");
                inicializacionPantallaEliminar();
            }

            private void inicializacionPantallaEliminar() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jlDpi = new JLabel("Dpi: ");
                jtAutor = new JTextField("");
                jtTitulo = new JTextField("");
                jtDpi = new JTextField("");
                jtTipo = new JTextField("");
                jbDevolver = new JButton("Eliminar");
                jbRegresar = new JButton("Regresar");

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jlDpi.setBounds(30, 130, 150, 25);
                jtTipo.setBounds(140, 25, 150, 25);
                jtAutor.setBounds(140, 60, 150, 25);
                jtTitulo.setBounds(140, 95, 150, 25);
                jtDpi.setBounds(140, 130, 150, 25);

                jtTipo.setEditable(false);
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jtDpi.setEditable(false);

                jbRegresar.setBounds(300, 170, 90, 30);
                jbDevolver.setBounds(200, 170, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 450); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlDpi);
                add(jtDpi);
                add(jtAutor);
                add(jtTitulo);
                add(jtTipo);
                add(jbRegresar);
                add(jbDevolver);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });
                jbDevolver.addActionListener((ActionEvent e) -> {
                    jbDevolver();
                    inicializacionEliminarPrestamoAdministrador();
                });
            }

            private void llenarCampos() {
                jtTipo.setText(tipo);
                jtAutor.setText(autor);
                jtTitulo.setText(titulo);
                jtDpi.setText(edicion);
            }

            private void jbDevolver() {
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo)) {
                                arregloTesis[i].setDisponibles(String.valueOf(Integer.parseInt(arregloTesis[i].getDisponibles()) + 1));
                                break;
                            }
                        }
                        break;
                    case "Libro":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo)) {
                                arregloLibro[i].setDisponibles(String.valueOf(Integer.parseInt(arregloLibro[i].getDisponibles()) + 1));
                                break;
                            }
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo)) {
                                arregloRevista[i].setDisponibles(String.valueOf(Integer.parseInt(arregloRevista[i].getDisponibles()) + 1));
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
                for (int i = 0; i < numeroPrestamos; i++) {
                    if (arregloPrestamo[i].getTipo().equals(tipo) && arregloPrestamo[i].getAutor().equals(autor) && arregloPrestamo[i].getTitulo().equals(titulo) && arregloPrestamo[i].getDpi().equals(edicion) && arregloPrestamo[i].getEliminado().equals("NO")) {
                        arregloPrestamo[i].setEliminado("SI");
                        JOptionPane.showMessageDialog(this, "El Prestamo Fue Eliminado", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        break;
                    }
                }
            }

            private void jbRegresar() {
                this.dispose();
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministrador() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class CrearPrestamoAdministrador extends JFrame {

        JLabel jlBuscar;
        JTextField jtBuscar;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane

        JButton jbBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarUsuario;

        //Constructor de la Clase VerUsuario
        public CrearPrestamoAdministrador() {
            super("CrearPrestamoAdministrador");
            inicializacionCrearPrestamoUsuario();
        }

        public void inicializacionCrearPrestamoUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jlBuscar = new JLabel("Buscar: ");
            jbBuscar = new JButton("Buscar");
            jbRegresarUsuario = new JButton("Regresar");
            jtBuscar = new JTextField("");
            jbBuscar.setBounds(460, 25, 80, 30);
            jbRegresarUsuario.setBounds(220, 410, 90, 30);
            jlBuscar.setBounds(220, 25, 70, 25);
            jtBuscar.setBounds(290, 25, 150, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarUsuario = new JButton("Regresar");
            jbRegresarUsuario.setBounds(130, 375, 130, 25);

            jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                jbRegresarAdministrador();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });
            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                            edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                            PantallaPrestamo PP = new PantallaPrestamo();
                            PP.setVisible(true);
                        }
                    }
                }
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarUsuario);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);

        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            JTable jtModificarBibliografia;
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                jtModificarBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarUsuario = new JButton("Regresar");
                jbRegresarUsuario.setBounds(130, 375, 130, 25);

                jbRegresarUsuario.addActionListener((ActionEvent e) -> {
                    jbRegresarAdministrador();
                });

                jtModificarBibliografia.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            int fila = jtModificarBibliografia.rowAtPoint(e.getPoint());
                            int columna = jtModificarBibliografia.columnAtPoint(e.getPoint());
                            if (fila > -1 && columna > -1) {
                                tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                                autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                                titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                                palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                                edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                                PantallaPrestamo PP = new PantallaPrestamo();
                                PP.setVisible(true);
                            }
                        }
                    }
                });
                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarUsuario);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministrador() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        private class PantallaPrestamo extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JLabel jlEdicion;
            JLabel jlFecha_Prestamo;
            JLabel jlFecha_Devolucion;
            JLabel jlUsuarios;
            JTextField jtAutor;
            JTextField jtTitulo;
            JTextField jtEdicion;
            JTextField jtFecha_Prestamo;
            JTextField jtFecha_Devolucion;
            JComboBox jcTipo;
            JComboBox jcUsuarios;
            JButton jbPrestamo;
            JButton jbRegresar;

            public PantallaPrestamo() {
                super("PantallaPrestamo");
                inicializacionPantallaPrestamo();
            }

            private void inicializacionPantallaPrestamo() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jlEdicion = new JLabel("Edicion: ");
                jlFecha_Prestamo = new JLabel("Fecha Prestamo: ");
                jlFecha_Devolucion = new JLabel("Fecha Devolucion: ");
                jlUsuarios = new JLabel("Usuario: ");
                jtAutor = new JTextField("");
                jtTitulo = new JTextField("");
                jtEdicion = new JTextField("");
                jtFecha_Prestamo = new JTextField("");
                jtFecha_Devolucion = new JTextField("");
                jcTipo = new JComboBox();
                jcUsuarios = new JComboBox();
                jbPrestamo = new JButton("Aceptar");
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jcUsuarios.addItem("Usuarios");
                for (int i = 1; i < numeroUsuarios; i++) {
                    jcUsuarios.addItem(arregloUsuario[i].getDPI());
                }

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jlEdicion.setBounds(30, 130, 150, 25);
                jlFecha_Prestamo.setBounds(30, 165, 150, 25);
                jlFecha_Devolucion.setBounds(30, 200, 150, 25);
                jlUsuarios.setBounds(30, 235, 150, 25);
                jcTipo.setBounds(140, 25, 150, 25);
                jtAutor.setBounds(140, 60, 150, 25);
                jtTitulo.setBounds(140, 95, 150, 25);
                jtEdicion.setBounds(140, 130, 150, 25);
                jtFecha_Prestamo.setBounds(140, 165, 150, 25);
                jtFecha_Devolucion.setBounds(140, 200, 150, 25);
                jcUsuarios.setBounds(140, 235, 150, 25);
                jbPrestamo.setBounds(300, 100, 90, 30);
                jbRegresar.setBounds(300, 130, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlEdicion);
                add(jlFecha_Prestamo);
                add(jlFecha_Devolucion);
                add(jlUsuarios);
                add(jtAutor);
                add(jtTitulo);
                add(jtEdicion);
                add(jtFecha_Prestamo);
                add(jtFecha_Devolucion);
                add(jcTipo);
                add(jcUsuarios);
                add(jbPrestamo);
                add(jbRegresar);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });

                jbPrestamo.addActionListener((ActionEvent e) -> {
                    try {
                        jbPrestamo();
                        inicializacionCrearPrestamoUsuario();
                    } catch (ParseException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }

            private void jbRegresar() {
                this.dispose();
            }

            private void llenarCampos() {
                Date fecha = new Date();
                int contador = 0;
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jtEdicion.setEditable(false);
                jcTipo.setEnabled(false);
                jtFecha_Prestamo.setEditable(false);
                jtFecha_Devolucion.setToolTipText("dd-MM-yyyy");
                jtFecha_Prestamo.setText(new SimpleDateFormat("dd-MM-yyyy").format(fecha));
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloTesis[i].getAutor()));
                                jtTitulo.setText(arregloTesis[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloTesis[i].getEdicion()));
                                jcTipo.setSelectedIndex(1);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Libros":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloLibro[i].getAutor()));
                                jtTitulo.setText(arregloLibro[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloLibro[i].getEdicion()));
                                jcTipo.setSelectedIndex(2);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                jtAutor.setText(String.valueOf(arregloRevista[i].getAutor()));
                                jtTitulo.setText(arregloRevista[i].getTitulo());
                                jtEdicion.setText(String.valueOf(arregloRevista[i].getEdicion()));
                                jcTipo.setSelectedIndex(3);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        break;
                }
            }

            private void jbPrestamo() throws ParseException {
                if (!jtFecha_Prestamo.getText().isEmpty() && !jtFecha_Devolucion.getText().isEmpty() && jcUsuarios.getSelectedIndex() != 0) {
                    if (verificarFecha(jtFecha_Prestamo.getText()) && verificarFecha(jtFecha_Devolucion.getText())) {
                        String[] split1 = jtFecha_Prestamo.getText().split("-");
                        String[] split2 = jtFecha_Devolucion.getText().split("-");
                        int[] numeros1 = new int[3];
                        int[] numeros2 = new int[3];
                        for (int i = 0; i < split1.length; i++) {
                            numeros1[i] = Integer.parseInt(split1[i]);
                            numeros2[i] = Integer.parseInt(split2[i]);
                        }
                        boolean continuar = false;
                        if (numeros2[2] > numeros1[2]) {
                            continuar = false;
                        } else {
                            if (numeros2[1] > numeros1[1]) {
                                continuar = false;
                            } else {
                                if (numeros2[0] > numeros1[0]) {
                                    continuar = false;
                                } else {
                                    continuar = true;
                                }
                            }
                        }
                        if (!continuar) {
                            String indexTipo = "";
                            DateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                            switch (jcTipo.getSelectedIndex()) {
                                case 0:
                                    break;
                                case 1:
                                    indexTipo = "Tesis";
                                    break;
                                case 2:
                                    indexTipo = "Libro";
                                    break;
                                case 3:
                                    indexTipo = "Revista";
                                    break;
                            }
                            int contador = 0;
                            for (int i = 0; i < numeroPrestamos; i++) {
                                if (arregloPrestamo[i].getTipo().equals(indexTipo) && arregloPrestamo[i].getAutor().equals(jtAutor.getText()) && arregloPrestamo[i].getTitulo().equals(jtTitulo.getText()) && arregloPrestamo[i].getDpi().equals((String) jcUsuarios.getSelectedItem()) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                                    contador++;
                                } else {
                                    contador = contador;
                                }
                            }
                            if (contador >= 1) {
                                JOptionPane.showMessageDialog(this, "Ya cuenta con una Copia de este Documento", "Error", JOptionPane.ERROR_MESSAGE);
                                this.dispose();
                            } else {
                                //Se Verifica que hayan disponibles
                                switch (indexTipo) {
                                    case "Tesis":
                                        for (int i = 0; i < numeroTesis; i++) {
                                            if (arregloTesis[i].getAutor().equals(jtAutor.getText()) && arregloTesis[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloTesis[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), (String) jcUsuarios.getSelectedItem(), usuarioActual, "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloTesis[i].setDisponibles(String.valueOf(Integer.parseInt(arregloTesis[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case "Libro":
                                        for (int i = 0; i < numeroLibros; i++) {
                                            if (arregloLibro[i].getAutor().equals(jtAutor.getText()) && arregloLibro[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloLibro[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), jtFecha_Devolucion.getText(), (String) jcUsuarios.getSelectedItem(), "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloLibro[i].setDisponibles(String.valueOf(Integer.parseInt(arregloLibro[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    case "Revista":
                                        for (int i = 0; i < numeroRevistas; i++) {
                                            if (arregloRevista[i].getAutor().equals(jtAutor.getText()) && arregloRevista[i].getTitulo().equals(jtTitulo.getText())) {
                                                if (Integer.parseInt(arregloRevista[i].getDisponibles()) != 0) {
                                                    //Se Guarda el Prestamo
                                                    Prestamo agregar = new Prestamo(indexTipo, jtAutor.getText(), jtTitulo.getText(), jtEdicion.getText(), jtFecha_Prestamo.getText(), jtFecha_Devolucion.getText(), (String) jcUsuarios.getSelectedItem(), "NO", "NO", "NO");
                                                    arregloPrestamo[numeroPrestamos] = agregar;
                                                    numeroPrestamos++;
                                                    //Se Modifica los Disponbles
                                                    JOptionPane.showMessageDialog(this, "Prestamo Agregado", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                                                    this.dispose();
                                                    arregloRevista[i].setDisponibles(String.valueOf(Integer.parseInt(arregloRevista[i].getDisponibles()) - 1));
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "No se tienen Copias Disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                                                    this.dispose();
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese Fecha Correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese Formato De Fecha Correcto dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean verificarFecha(String cadena) {
                DateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                Date dates = new Date();
                try {
                    dates = formato.parse(cadena);
                    return true;
                } catch (ParseException e) {
                    return false;
                }
            }
        }
    }

    private class ModificarPrestamoAdministrador extends JFrame {

        JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane;
        //Se define la JTable
        JTable jtVerHistorial;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public ModificarPrestamoAdministrador() {
            super("ModificarPrestamoAdministrador");
            inicializacionVerPrestamoAdministrador();
        }

        public void inicializacionVerPrestamoAdministrador() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][9];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                Date fecha = new Date();
                String date = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
                String[] split1 = date.split("-");
                String[] split2 = arregloPrestamo[i].getFecha_Devolucion().split("-");
                int[] numeros1 = new int[3];
                int[] numeros2 = new int[3];
                for (int j = 0; j < split1.length; j++) {
                    numeros1[j] = Integer.parseInt(split1[j]);
                    numeros2[j] = Integer.parseInt(split2[j]);
                }
                boolean continuar = false;
                if (numeros2[2] > numeros1[2]) {
                    continuar = false;
                } else {
                    if (numeros2[1] > numeros1[1]) {
                        continuar = false;
                    } else {
                        if (numeros2[0] > numeros1[0]) {
                            continuar = false;
                        } else {
                            continuar = true;
                        }
                    }
                }
                if (!continuar) {
                    if (arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                        datos[contador][0] = contador;
                        datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                        datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                        datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                        datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                        datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                        datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                        datos[contador][7] = arregloPrestamo[i].getDpi();//Se obtiene el Rol
                        datos[contador][8] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "DPI", "Entregado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerHistorial = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 9; i++) {
                jtVerHistorial.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerHistorial.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministrador();
            });
            jtVerHistorial.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerHistorial.rowAtPoint(e.getPoint());
                        int columna = jtVerHistorial.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerHistorial.getValueAt(fila, 1).toString();
                            autor = jtVerHistorial.getValueAt(fila, 2).toString();
                            titulo = jtVerHistorial.getValueAt(fila, 3).toString();
                            edicion = jtVerHistorial.getValueAt(fila, 7).toString();
                            PantallaEliminar PE = new PantallaEliminar();
                            PE.setVisible(true);
                        }
                    }
                }
            });
            jsVerUsuario.setBounds(20, 20, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerHistorial);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);

        }

        private class PantallaEliminar extends JFrame {

            JLabel jlTipo;
            JLabel jlAutor;
            JLabel jlTitulo;
            JLabel jlDpi;
            JComboBox jcAutor;
            JComboBox jcTitulo;
            JComboBox jcDpi;
            JComboBox jcTipo;
            JButton jbDevolver;
            JButton jbRegresar;

            public PantallaEliminar() {
                super("PantallaEliminar");
                inicializacionPantallaEliminar();
            }

            private void inicializacionPantallaEliminar() {
                jlTipo = new JLabel("Tipo: ");
                jlAutor = new JLabel("Autor: ");
                jlTitulo = new JLabel("Titulo: ");
                jlDpi = new JLabel("Dpi: ");
                jcAutor = new JComboBox();
                jcTitulo = new JComboBox();
                jcDpi = new JComboBox();
                jcTipo = new JComboBox();
                jbDevolver = new JButton("Modificar");
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jlTipo.setBounds(30, 25, 150, 25);
                jlAutor.setBounds(30, 60, 150, 25);
                jlTitulo.setBounds(30, 95, 150, 25);
                jlDpi.setBounds(30, 130, 150, 25);
                jcTipo.setBounds(140, 25, 150, 25);
                jcAutor.setBounds(140, 60, 150, 25);
                jcTitulo.setBounds(140, 95, 150, 25);
                jcDpi.setBounds(140, 130, 150, 25);

                jbRegresar.setBounds(300, 170, 90, 30);
                jbDevolver.setBounds(200, 170, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 450); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlDpi);
                add(jcDpi);
                add(jcAutor);
                add(jcTitulo);
                add(jcTipo);
                add(jbRegresar);
                add(jbDevolver);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });
                jbDevolver.addActionListener((ActionEvent e) -> {
                    jbDevolver();
                    inicializacionVerPrestamoAdministrador();
                });
            }

            private void llenarCampos() {
                jcTipo.setEnabled(false);
                for (int i = 0; i < numeroTesis; i++) {
                    jcAutor.addItem(arregloTesis[i].getAutor());
                }
                for (int i = 0; i < numeroLibros; i++) {
                    jcAutor.addItem(arregloLibro[i].getAutor());
                }
                for (int i = 0; i < numeroRevistas; i++) {
                    jcAutor.addItem(arregloRevista[i].getAutor());
                }
                for (int i = 1; i < numeroUsuarios; i++) {
                    jcDpi.addItem(arregloUsuario[i].getDPI());
                }
                jcDpi.setSelectedItem(edicion);
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo)) {
                                jcAutor.setSelectedItem(autor);
                                jcTitulo.addItem(titulo);
                            }
                        }
                        jcTipo.setSelectedIndex(1);
                        break;
                    case "Libro":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo)) {
                                jcAutor.setSelectedItem(autor);
                                jcTitulo.addItem(titulo);
                            }
                        }
                        jcTipo.setSelectedIndex(2);
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo)) {
                                jcAutor.setSelectedItem(autor);
                                jcTitulo.addItem(titulo);
                            }
                        }
                        jcTipo.setSelectedIndex(2);
                        break;
                    default:
                        break;
                }
                jcAutor.addActionListener((ActionEvent e) -> {
                    jcTitulo.removeAllItems();
                    buscarTitulo();
                });
            }

            private void buscarTitulo() {
                for (int i = 0; i < numeroTesis; i++) {
                    if (arregloTesis[i].getAutor().equals((String) jcAutor.getSelectedItem())) {
                        jcTitulo.addItem(arregloTesis[i].getTitulo());
                        jcTipo.setSelectedIndex(1);
                    }
                }
                for (int i = 0; i < numeroLibros; i++) {
                    if (arregloLibro[i].getAutor().equals((String) jcAutor.getSelectedItem())) {
                        jcTitulo.addItem(arregloLibro[i].getTitulo());
                        jcTipo.setSelectedIndex(2);
                    }
                }
                for (int i = 0; i < numeroRevistas; i++) {
                    if (arregloRevista[i].getAutor().equals((String) jcAutor.getSelectedItem())) {
                        jcTitulo.addItem(arregloRevista[i].getTitulo());
                        jcTipo.setSelectedIndex(3);
                    }
                }
            }

            private void jbDevolver() {
                int identificador = 0;
                int contador = 0;
                for (int i = 0; i < numeroPrestamos; i++) {
                    contador = 0;
                    if (!edicion.equals((String) jcDpi.getSelectedItem())) {
                        if (arregloPrestamo[i].getTipo().equals((String) jcTipo.getSelectedItem()) && arregloPrestamo[i].getDpi().equals((String) jcDpi.getSelectedItem()) && arregloPrestamo[i].getAutor().equals((String) jcAutor.getSelectedItem()) && arregloPrestamo[i].getTitulo().equals((String) jcTitulo.getSelectedItem()) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                            contador = 2;
                            break;
                        } else {
                            String aTipo = (String) jcTipo.getSelectedItem();
                            String aAutor = (String) jcAutor.getSelectedItem();
                            String aTitulo = (String) jcTitulo.getSelectedItem();
                            String aEdicion = arregloPrestamo[identificador].getEdicion();
                            String aFechaP = arregloPrestamo[identificador].getFecha_Prestamo();
                            String aFechaE = arregloPrestamo[identificador].getFecha_Devolucion();
                            String aDpi = (String) jcDpi.getSelectedItem();
                            String aEntregado = "NO";
                            String aEliminado = "NO";
                            String aModificado = "SI";
                            if (arregloPrestamo[i].getAutor().equals(autor) && arregloPrestamo[i].getTitulo().equals(titulo)) {
                                identificador = i;
                            }
                            switch (aTipo) {
                                case "Tesis":
                                    for (int j = 0; j < numeroTesis; j++) {
                                        if (arregloTesis[j].getAutor().equals(aAutor) && arregloTesis[j].getTitulo().equals(aTitulo) && Integer.parseInt(arregloTesis[j].getDisponibles()) != 0) {
                                            Prestamo agregar = new Prestamo(aTipo, aAutor, aTitulo, aEdicion, aFechaP, aFechaE, aDpi, aEntregado, aEliminado, aModificado);
                                            arregloPrestamo[numeroPrestamos] = agregar;
                                            numeroPrestamos++;
                                            contador = 1;
                                            arregloPrestamo[identificador].setModificado(aModificado);
                                            break;
                                        } else {
                                            contador = 3;
                                        }
                                    }
                                    break;
                                case "Libro":
                                    for (int j = 0; j < numeroLibros; j++) {
                                        if (arregloLibro[j].getAutor().equals(aAutor) && arregloLibro[j].getTitulo().equals(aTitulo) && Integer.parseInt(arregloLibro[j].getDisponibles()) != 0) {
                                            Prestamo agregar = new Prestamo(aTipo, aAutor, aTitulo, aEdicion, aFechaP, aFechaE, aDpi, aEntregado, aEliminado, aModificado);
                                            arregloPrestamo[numeroPrestamos] = agregar;
                                            numeroPrestamos++;
                                            contador = 1;
                                            arregloPrestamo[identificador].setModificado(aModificado);
                                            break;
                                        } else {
                                            contador = 3;
                                        }
                                    }
                                    break;
                                case "Revista":
                                    for (int j = 0; j < numeroRevistas; j++) {
                                        if (arregloRevista[j].getAutor().equals(aAutor) && arregloRevista[j].getTitulo().equals(aTitulo) && Integer.parseInt(arregloRevista[j].getDisponibles()) != 0) {
                                            Prestamo agregar = new Prestamo(aTipo, aAutor, aTitulo, aEdicion, aFechaP, aFechaE, aDpi, aEntregado, aEliminado, aModificado);
                                            arregloPrestamo[numeroPrestamos] = agregar;
                                            numeroPrestamos++;
                                            contador = 1;
                                            arregloPrestamo[identificador].setModificado(aModificado);
                                            break;
                                        } else {
                                            contador = 3;
                                        }
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        }
                        //Funciona
                    } else {
                        if (!arregloPrestamo[i].getTipo().equals((String) jcTipo.getSelectedItem()) && !arregloPrestamo[i].getDpi().equals((String) jcDpi.getSelectedItem()) && arregloPrestamo[i].getAutor().equals((String) jcAutor.getSelectedItem()) && arregloPrestamo[i].getTitulo().equals((String) jcTitulo.getSelectedItem()) && arregloPrestamo[i].getEntregado().equals("NO") && arregloPrestamo[i].getEliminado().equals("NO")) {
                            contador = 0;
                            break;
                        } else {
                            if (arregloPrestamo[i].getAutor().equals(autor) && arregloPrestamo[i].getTitulo().equals(titulo)) {
                                identificador = i;
                                String aTipo = (String) jcTipo.getSelectedItem();
                                String aAutor = (String) jcAutor.getSelectedItem();
                                String aTitulo = (String) jcTitulo.getSelectedItem();
                                String aModificado = "SI";
                                arregloPrestamo[identificador].setTipo(aTipo);
                                arregloPrestamo[identificador].setAutor(aAutor);
                                arregloPrestamo[identificador].setTitulo(aTitulo);
                                arregloPrestamo[identificador].setModificado(aModificado);
                                contador = 1;
                                break;
                            }
                        }
                    }
                }
                switch (contador) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Se Modifico el Prestamo", "Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(this, "Ya Cuenta con Esta Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(this, "La Bibliografia No Tiene Copias Diponibles", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "La Bibliografia No Fue Modificada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void jbRegresar() {
                this.dispose();
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministrador() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class VerPrestamoAdministrador extends JFrame {

        //Se define la JTable
        JTable jtVerHistorial;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public VerPrestamoAdministrador() {
            super("VerPrestamoAdministrador");
            inicializacionVerPrestamoAdministrador();
        }

        public void inicializacionVerPrestamoAdministrador() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroPrestamos][9];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            for (int i = 0; i < numeroPrestamos; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                datos[contador][0] = contador;
                datos[contador][1] = arregloPrestamo[i].getTipo();//Se obtiene el DPI
                datos[contador][2] = arregloPrestamo[i].getAutor();//Se obtiene el Nombre
                datos[contador][3] = arregloPrestamo[i].getTitulo();//Se obtiene el Apellido
                datos[contador][4] = arregloPrestamo[i].getEdicion();//Se obtiene el Usuario
                datos[contador][5] = arregloPrestamo[i].getFecha_Prestamo();//Se obtiene el Password
                datos[contador][6] = arregloPrestamo[i].getFecha_Devolucion();//Se obtiene el Rol
                datos[contador][7] = arregloPrestamo[i].getDpi();//Se obtiene el Rol
                datos[contador][8] = arregloPrestamo[i].getEntregado();//Se obtiene el Rol
                contador++;
            }
            Object[][] datosModificados = new Object[contador][10];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Edicion", "Fecha Prestamo", "Fecha Entrega", "DPI", "Entregado"};//Se crea el vector donde van los encabezados de las columnas
            jtVerHistorial = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 9; i++) {
                jtVerHistorial.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerHistorial.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(2).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(3).setPreferredWidth(80);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(4).setPreferredWidth(10);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(5).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(6).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(7).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.getColumnModel().getColumn(8).setPreferredWidth(60);//Se da un ancho a la columna que muestra el DPI
            jtVerHistorial.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministrador();
            });

            JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane
            jsVerUsuario.setBounds(20, 20, 950, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerHistorial);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);

        }

        //Accion Boton Regresar
        private void jbRegresarAdministrador() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class VerUsuario extends JFrame {

        //Se define la JTable
        JTable jtVerUsuario;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public VerUsuario() {
            super("VerUsuario");
            inicializacionVerUsuario();
        }

        public void inicializacionVerUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            Object[][] datos = new Object[numeroUsuarios][7];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroUsuarios; i++) {//Llenado de la tabla con los usuarios existentes y sus datos
                datos[i][0] = i;
                datos[i][1] = arregloUsuario[i].getDPI();//Se obtiene el DPI
                datos[i][2] = arregloUsuario[i].getNombre();//Se obtiene el Nombre
                datos[i][3] = arregloUsuario[i].getApellido();//Se obtiene el Apellido
                datos[i][4] = arregloUsuario[i].getUsuario();//Se obtiene el Usuario
                datos[i][5] = arregloUsuario[i].getPassword();//Se obtiene el Password
                datos[i][6] = arregloUsuario[i].getRol();//Se obtiene el Rol
            }
            String[] nombres = {"#", "DPI", "Nombre", "Apellido", "Usuario", "Passowrd", "Rol"};//Se crea el vector donde van los encabezados de las columnas
            jtVerUsuario = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 7; i++) {
                jtVerUsuario.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerUsuario.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerUsuario.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerUsuario.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });

            JScrollPane jsVerUsuario = new JScrollPane();//Se creaa un JScrollPane
            jsVerUsuario.setBounds(20, 20, 800, 150);//Se da el tamaño al JScrollPane
            jsVerUsuario.setViewportView(jtVerUsuario);//Se inserta la tabla en el JScrollPane
            add(jsVerUsuario);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);

        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class ModificarUsuario extends JFrame {

        public int indexMatriz = 0;//Almacena el index de la Matriz Usuario
        //Declaracion de los JLabels
        JLabel jlDPI;
        JLabel jlNombre;
        JLabel jlApellido;
        JLabel jlUsuario;
        JLabel jlRol;
        JLabel jlPassword;
        JLabel jlRpassword;
        JLabel jlBuscar;

        //Declaracion de los JTextFields
        JTextField jtDPI;
        JTextField jtNombre;
        JTextField jtApellido;
        JTextField jtUsuario;
        JTextField jtBuscar;
        JTextField jtPassword;
        JTextField jtRpassword;

        //Declaracion de los JComboBox
        JComboBox jcRol;

        //Declaracion de Botones
        JButton jbAceptar;
        JButton jbCancelar;
        JButton jbRegresarAdministrador;
        JButton jbBuscar;

        //Constructor de CrearUsuario
        public ModificarUsuario() {
            super("ModificarUsuario");
            inicializacionCrearUsuario();//Se llama al Void que genera la Ventana Grafica
        }

        //Crea la Ventana Grafica
        private void inicializacionCrearUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(800, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo 
            setLayout(null);//Elimina el Layout para poder Agregar las posiciones de manera Estatica

            //Crear los Objetos
            jlDPI = new JLabel("DPI: ");
            jlNombre = new JLabel("Nombre: ");
            jlApellido = new JLabel("Apellido: ");
            jlUsuario = new JLabel("Usuario: ");
            jlRol = new JLabel("Rol: ");
            jlPassword = new JLabel("Password: ");
            jlRpassword = new JLabel("Repetir Password: ");
            jlBuscar = new JLabel("Buscar: ");
            jtDPI = new JTextField("");
            jtNombre = new JTextField("");
            jtApellido = new JTextField("");
            jtUsuario = new JTextField("");
            jtBuscar = new JTextField("");
            jcRol = new JComboBox();
            jtPassword = new JTextField("");
            jtRpassword = new JTextField("");
            jbAceptar = new JButton("Aceptar");
            jbCancelar = new JButton("Cancelar");
            jbRegresarAdministrador = new JButton("Regresar");
            jbBuscar = new JButton("Buscar");

            //Agregar Items al ComboBox
            jcRol.addItem("Seleccionar");//Index 0
            jcRol.addItem("Catedrático");//Index 1
            jcRol.addItem("Estudiante");//Index 2

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            jlDPI.setBounds(80, 30, 75, 20);
            jlNombre.setBounds(80, 65, 75, 20);
            jlApellido.setBounds(80, 100, 75, 20);
            jlUsuario.setBounds(80, 135, 75, 20);
            jlRol.setBounds(80, 170, 75, 20);
            jlPassword.setBounds(80, 205, 75, 20);
            jlRpassword.setBounds(35, 240, 110, 20);
            jlBuscar.setBounds(540, 65, 75, 20);
            jtDPI.setBounds(160, 30, 150, 25);
            jtNombre.setBounds(160, 65, 150, 25);
            jtApellido.setBounds(160, 100, 150, 25);
            jtUsuario.setBounds(160, 135, 150, 25);
            jtBuscar.setBounds(540, 85, 150, 25);
            jcRol.setBounds(160, 170, 150, 25);
            jtPassword.setBounds(160, 205, 150, 25);
            jtRpassword.setBounds(160, 240, 150, 25);
            jbAceptar.setBounds(76, 335, 90, 25);
            jbCancelar.setBounds(206, 335, 90, 25);
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);
            jbBuscar.setBounds(540, 115, 90, 25);

            //Bloquea la edicion previa de los campos
            enableFalse();

            //Al dar Clic
            jbAceptar.addActionListener((ActionEvent e) -> {
                jbAceptarAccion();
            });
            jbCancelar.addActionListener((ActionEvent e) -> {
                jbCancelarAccion();
            });
            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });

            //Agregar los Objetos al Layout
            add(jlDPI);
            add(jlNombre);
            add(jlApellido);
            add(jlUsuario);
            add(jlRol);
            add(jlPassword);
            add(jlRpassword);
            add(jlBuscar);
            add(jtDPI);
            add(jtNombre);
            add(jtApellido);
            add(jtUsuario);
            add(jtBuscar);
            add(jcRol);
            add(jtPassword);
            add(jtRpassword);
            add(jbAceptar);
            add(jbCancelar);
            add(jbRegresarAdministrador);
            add(jbBuscar);
        }

        //Accion para el Boton Buscar
        public void jbBuscarAccion() {
            String buscar = jtBuscar.getText();//Guarda el texto ingresado
            int contador = 0;//Contador
            if (!buscar.equals("")) {//Compueba si el texto no esta vacio
                if (verificarNumero(buscar)) {//Comprueba si el texto ingresado es un numero
                    for (int i = 0; i < numeroUsuarios; i++) {//Recorre la Matriz
                        if (arregloUsuario[i].getDPI().equals(buscar)) {//Si encuentra un DPI igual al ingresado
                            contador++;
                            indexMatriz = i;
                        } else {
                            contador = contador;
                        }
                    }
                    if (contador == 1) {// Compueba si se encontro una entrada igual

                        //Se colocan los datos del usuario con el DPI ingresado en los campos de texto
                        jtDPI.setText(arregloUsuario[indexMatriz].getDPI());
                        jtNombre.setText(arregloUsuario[indexMatriz].getNombre());
                        jtApellido.setText(arregloUsuario[indexMatriz].getApellido());
                        jtUsuario.setText(arregloUsuario[indexMatriz].getUsuario());
                        jtPassword.setText(arregloUsuario[indexMatriz].getPassword());
                        jtRpassword.setText(arregloUsuario[indexMatriz].getPassword());

                        //Comprobacion del Rol
                        int rol = 0;//Almacena el Rol
                        switch (arregloUsuario[indexMatriz].getRol()) {
                            case "Estudiante":
                                rol = 2;
                                break;
                            case "Catedrático":
                                rol = 1;
                                break;
                            default:
                                rol = 0;
                                break;
                        }

                        //Colocar el Rol del Usuario con el DPI ingresado
                        jcRol.setSelectedIndex(rol);
                        enableTrue();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        jtBuscar.setText("");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                    jtBuscar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

        //Accion para el Boton Aceptar
        public void jbAceptarAccion() {

            //Creacion de Variables donde se Almacenan los Textos Ingresados
            double dpi = 0;
            String transformar = jtDPI.getText();
            String nombre = jtNombre.getText();
            String apellido = jtApellido.getText();
            String usuario = jtUsuario.getText();
            String password = jtPassword.getText();
            String rpassword = jtRpassword.getText();

            //Comprobar si el DPI ingresado es Numerico
            if (verificarNumero(transformar)) {
                dpi = Double.parseDouble(transformar);
            } else {
                dpi = 0;
            }

            //Comprueba el Index que se Selecciono en el JComboBox
            int rol = jcRol.getSelectedIndex();
            String tipo = "";
            switch (rol) {
                case 0:
                    tipo = "";
                    break;
                case 1:
                    tipo = "Catedrático";
                    break;
                case 2:
                    tipo = "Estudiante";
                    break;
                default:
                    tipo = "";
                    break;
            }

            //Comprueba si se Ingresaron todos los Datos
            if (dpi != 0 && !nombre.equals("") && !apellido.equals("") && !usuario.equals("") && !password.equals("") && !rpassword.equals("") && !tipo.equals("")) {

                //Comprueba si la Contraseña coincide con la Repeticion de la Contraseña
                if (password.equals(rpassword)) {
                    int contador = 0;//Se usa para Almacenar 
                    for (int i = 0; i < numeroUsuarios; i++) {

                        //Verifica si ya Existe una Entrada con los datos DPI y Usuario ingresados
                        if (arregloUsuario[i].getDPI().equals(transformar) || arregloUsuario[i].getUsuario().equals(usuario)) {
                            if (i == indexMatriz) {
                                contador = contador;
                            } else {
                                contador++;
                            }
                        } else {
                            contador = contador;
                        }
                    }

                    //Verifica si el For anterior Encontro o NO un Usuario
                    if (contador == 0) {
                        //Ingresa el Usuario
                        arregloUsuario[indexMatriz].setDPI(jtDPI.getText());
                        arregloUsuario[indexMatriz].setNombre(jtNombre.getText());
                        arregloUsuario[indexMatriz].setApellido(jtApellido.getText());
                        arregloUsuario[indexMatriz].setUsuario(jtUsuario.getText());
                        arregloUsuario[indexMatriz].setPassword(jtPassword.getText());
                        int ingresoRol = jcRol.getSelectedIndex();
                        String tipoRol = "";
                        switch (ingresoRol) {
                            case 0:
                                tipoRol = "";
                                break;
                            case 1:
                                tipoRol = "Catedrático";
                                break;
                            case 2:
                                tipoRol = "Estudiante";
                                break;
                            default:
                                tipoRol = "";
                                break;
                        }
                        arregloUsuario[indexMatriz].setRol(tipoRol);
                        JOptionPane.showMessageDialog(this, "Usuario Modificado");
                        jbCancelarAccion();
                    } else {
                        JOptionPane.showMessageDialog(this, "El usuario o DPI ya fue Ingresado\nSeleccione Otro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La Contraseña no Coincide", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion para el Boton Cancelar
        private void jbCancelarAccion() {
            //Limpia los JTextField y Coloca el Index 0 en el JComboBox
            jtDPI.setText("");
            jtNombre.setText("");
            jtApellido.setText("");
            jtUsuario.setText("");
            jtPassword.setText("");
            jtRpassword.setText("");
            jtBuscar.setText("");
            jcRol.setSelectedIndex(0);
        }

        //Verificacion de Cadena es Numerica o No
        private boolean verificarNumero(String cadena) {
            try {
                Double.parseDouble(cadena);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        //Bloquea la edicion de los campos
        private void enableFalse() {
            this.jtApellido.setEditable(false);
            this.jtDPI.setEditable(false);
            this.jtNombre.setEditable(false);
            this.jtUsuario.setEditable(false);
            this.jtPassword.setEditable(false);
            this.jtRpassword.setEditable(false);
            this.jcRol.setEnabled(false);
        }

        //Libera la edicion de los campos
        private void enableTrue() {
            this.jtApellido.setEditable(true);
            this.jtDPI.setEditable(true);
            this.jtNombre.setEditable(true);
            this.jtUsuario.setEditable(true);
            this.jtPassword.setEditable(true);
            this.jtRpassword.setEditable(true);
            this.jcRol.setEnabled(true);
        }
    }

    private class EliminarUsuario extends JFrame 
{
        public int indexMatriz = 0;//Almacena el index de la Matriz Usuario
        //Declaracion de los JLabels
        JLabel jlDPI;
        JLabel jlNombre;
        JLabel jlApellido;
        JLabel jlUsuario;
        JLabel jlRol;
        JLabel jlPassword;
        JLabel jlRpassword;
        JLabel jlBuscar;

        //Declaracion de los JTextFields
        JTextField jtDPI;
        JTextField jtNombre;
        JTextField jtApellido;
        JTextField jtUsuario;
        JTextField jtBuscar;
        JTextField jtPassword;
        JTextField jtRpassword;

        //Declaracion de los JComboBox
        JComboBox jcRol;

        //Declaracion de Botones
        JButton jbAceptar;
        JButton jbCancelar;
        JButton jbRegresarAdministrador;
        JButton jbBuscar;

        //Constructor de CrearUsuario
        public EliminarUsuario() {
            super("EliminarUsuario");
            inicializacionEliminarUsuario();//Se llama al Void que genera la Ventana Grafica
        }

        //Crea la Ventana Grafica
        private void inicializacionEliminarUsuario() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(800, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo 
            setLayout(null);//Elimina el Layout para poder Agregar las posiciones de manera Estatica

            //Crear los Objetos
            jlDPI = new JLabel("DPI: ");
            jlNombre = new JLabel("Nombre: ");
            jlApellido = new JLabel("Apellido: ");
            jlUsuario = new JLabel("Usuario: ");
            jlRol = new JLabel("Rol: ");
            jlPassword = new JLabel("Password: ");
            jlRpassword = new JLabel("Repetir Password: ");
            jlBuscar = new JLabel("Buscar: ");
            jtDPI = new JTextField("");
            jtNombre = new JTextField("");
            jtApellido = new JTextField("");
            jtUsuario = new JTextField("");
            jtBuscar = new JTextField("");
            jcRol = new JComboBox();
            jtPassword = new JTextField("");
            jtRpassword = new JTextField("");
            jbAceptar = new JButton("Aceptar");
            jbCancelar = new JButton("Cancelar");
            jbRegresarAdministrador = new JButton("Regresar");
            jbBuscar = new JButton("Buscar");

            //Agregar Items al ComboBox
            jcRol.addItem("Seleccionar");//Index 0
            jcRol.addItem("Catedrático");//Index 1
            jcRol.addItem("Estudiante");//Index 2

            //Fijacion de Tamaños (Posicion X, Posicion Y, Largo, Ancho)
            jlDPI.setBounds(80, 30, 75, 20);
            jlNombre.setBounds(80, 65, 75, 20);
            jlApellido.setBounds(80, 100, 75, 20);
            jlUsuario.setBounds(80, 135, 75, 20);
            jlRol.setBounds(80, 170, 75, 20);
            jlPassword.setBounds(80, 205, 75, 20);
            jlRpassword.setBounds(35, 240, 110, 20);
            jlBuscar.setBounds(540, 65, 75, 20);
            jtDPI.setBounds(160, 30, 150, 25);
            jtNombre.setBounds(160, 65, 150, 25);
            jtApellido.setBounds(160, 100, 150, 25);
            jtUsuario.setBounds(160, 135, 150, 25);
            jtBuscar.setBounds(540, 85, 150, 25);
            jcRol.setBounds(160, 170, 150, 25);
            jtPassword.setBounds(160, 205, 150, 25);
            jtRpassword.setBounds(160, 240, 150, 25);
            jbAceptar.setBounds(76, 335, 90, 25);
            jbCancelar.setBounds(206, 335, 90, 25);
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);
            jbBuscar.setBounds(540, 115, 90, 25);

            //Bloquea la edicion previa de los campos
            enableFalse();

            //Al dar Clic
            jbAceptar.addActionListener((ActionEvent e) -> {
                jbAceptarAccion();
            });
            jbCancelar.addActionListener((ActionEvent e) -> {
                jbCancelarAccion();
            });
            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });

            //Agregar los Objetos al Layout
            add(jlDPI);
            add(jlNombre);
            add(jlApellido);
            add(jlUsuario);
            add(jlRol);
            add(jlPassword);
            add(jlRpassword);
            add(jlBuscar);
            add(jtDPI);
            add(jtNombre);
            add(jtApellido);
            add(jtUsuario);
            add(jtBuscar);
            add(jcRol);
            add(jtPassword);
            add(jtRpassword);
            add(jbAceptar);
            add(jbCancelar);
            add(jbRegresarAdministrador);
            add(jbBuscar);
        }

        //Accion para el Boton Aceptar
        public void jbAceptarAccion() {
            int contador = 0;
            for (int i = 0; i < numeroUsuarios; i++) {
                if (arregloUsuario[i].getDPI().equals(jtBuscar.getText())) {
                    for (int j = i; j < numeroUsuarios - 1; j++) {
                        arregloUsuario[j].setDPI(arregloUsuario[j + 1].getDPI());
                        arregloUsuario[j].setNombre(arregloUsuario[j + 1].getNombre());
                        arregloUsuario[j].setApellido(arregloUsuario[j + 1].getApellido());
                        arregloUsuario[j].setUsuario(arregloUsuario[j + 1].getUsuario());
                        arregloUsuario[j].setPassword(arregloUsuario[j + 1].getPassword());
                        arregloUsuario[j].setRol(arregloUsuario[j + 1].getRol());
                    }
                    arregloUsuario[numeroUsuarios - 1].setDPI(null);
                    arregloUsuario[numeroUsuarios - 1].setNombre(null);
                    arregloUsuario[numeroUsuarios - 1].setApellido(null);
                    arregloUsuario[numeroUsuarios - 1].setUsuario(null);
                    arregloUsuario[numeroUsuarios - 1].setPassword(null);
                    arregloUsuario[numeroUsuarios - 1].setRol(null);
                    contador++;
                    numeroUsuarios = numeroUsuarios - 1;
                    break;
                }
            }
            if (contador == 1) {
                JOptionPane.showMessageDialog(this, "El usuario fue eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                jbCancelarAccion();
            } else {
                JOptionPane.showMessageDialog(this, "El usuario no fue eliminado", "Eliminado", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion para el Boton Buscar
        public void jbBuscarAccion() {
            String buscar = jtBuscar.getText();//Guarda el texto ingresado
            int contador = 0;//Contador
            if (!buscar.equals("")) {//Compueba si el texto no esta vacio
                if (verificarNumero(buscar)) {//Comprueba si el texto ingresado es un numero
                    for (int i = 0; i < numeroUsuarios; i++) {//Recorre la Matriz
                        if (arregloUsuario[i].getDPI().equals(buscar)) {//Si encuentra un DPI igual al ingresado
                            contador++;
                            indexMatriz = i;
                        } else {
                            contador = contador;
                        }
                    }
                    if (contador == 1) {// Compueba si se encontro una entrada igual

                        //Se colocan los datos del usuario con el DPI ingresado en los campos de texto
                        jtDPI.setText(arregloUsuario[indexMatriz].getDPI());
                        jtNombre.setText(arregloUsuario[indexMatriz].getNombre());
                        jtApellido.setText(arregloUsuario[indexMatriz].getApellido());
                        jtUsuario.setText(arregloUsuario[indexMatriz].getUsuario());
                        jtPassword.setText(arregloUsuario[indexMatriz].getPassword());
                        jtRpassword.setText(arregloUsuario[indexMatriz].getPassword());

                        //Comprobacion del Rol
                        int rol = 0;//Almacena el Rol
                        switch (arregloUsuario[indexMatriz].getRol()) {
                            case "Estudiante":
                                rol = 2;
                                break;
                            case "Catedrático":
                                rol = 1;
                                break;
                            default:
                                rol = 0;
                                break;
                        }

                        //Colocar el Rol del Usuario con el DPI ingresado
                        jcRol.setSelectedIndex(rol);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        jtBuscar.setText("");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                    jtBuscar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un DPI valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

        //Accion para el Boton Cancelar
        private void jbCancelarAccion() {
            //Limpia los JTextField y Coloca el Index 0 en el JComboBox
            jtDPI.setText("");
            jtNombre.setText("");
            jtApellido.setText("");
            jtUsuario.setText("");
            jtPassword.setText("");
            jtRpassword.setText("");
            jtBuscar.setText("");
            jcRol.setSelectedIndex(0);
        }

        //Verificacion de Cadena es Numerica o No
        private boolean verificarNumero(String cadena) {
            try {
                Double.parseDouble(cadena);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        //Bloquea la edicion de los campos
        private void enableFalse() {
            this.jtApellido.setEditable(false);
            this.jtDPI.setEditable(false);
            this.jtNombre.setEditable(false);
            this.jtUsuario.setEditable(false);
            this.jtPassword.setEditable(false);
            this.jtRpassword.setEditable(false);
            this.jcRol.setEnabled(false);
        }
    }

    private class CrearBibliografia extends JFrame {

        JLabel jlCategoria;
        JLabel jlTipo;

        JComboBox jcCategoria;
        JComboBox jcTipo;

        JButton jbAceptar1;
        JButton jbRegresarAdministrador;
        JButton jbAceptar2;
        JButton jbRegresar;
        JButton jbCancelar;

        JLabel jlAutor = new JLabel("Autor: ");
        JLabel jlTitulo = new JLabel("Titulo: ");
        JLabel jlPalabras_Clave = new JLabel("Palabras Clave: ");
        JLabel jlArea = new JLabel("Area: ");
        JLabel jlTemas = new JLabel("Temas: ");
        JLabel jlDescripcion = new JLabel("Descripcion: ");
        JLabel jlEdicion = new JLabel("Edicion: ");
        JLabel jlCopias = new JLabel("Copias: ");
        JLabel jlDisponibles = new JLabel("Disponibles: ");
        JLabel jlDatos = new JLabel("Datos: ");
        JLabel jlEjemplares = new JLabel("Ejemplares: ");
        JTextField jtAutor = new JTextField();
        JTextField jtTitulo = new JTextField();
        JTextField jtPalabras_Clave = new JTextField();
        JTextField jtArea = new JTextField();
        JTextField jtTemas = new JTextField();
        JTextField jtDescripcion = new JTextField();
        JTextField jtEdicion = new JTextField();
        JTextField jtCopias = new JTextField();
        JTextField jtDisponibles = new JTextField();
        JTextField jtEjemplares = new JTextField();
        JTextArea jtTodo = new JTextArea();
        JScrollPane jsTodo = new JScrollPane();

        public CrearBibliografia() {
            super("CrearBibliografia");
            inicializacionCrearBibliografia();
        }

        private void inicializacionCrearBibliografia() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(800, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica

            jlCategoria = new JLabel("Categoria");
            jlTipo = new JLabel("Tipo de Carga");
            jcCategoria = new JComboBox();
            jcTipo = new JComboBox();
            jbAceptar1 = new JButton("Aceptar");
            jbAceptar2 = new JButton("Aceptar");
            jbRegresar = new JButton("Regresar");
            jbRegresarAdministrador = new JButton("Regresar");
            jbCancelar = new JButton("Cancelar");

            //Agregar Items al ComboBox
            jcTipo.addItem("Tipo");//Index 0
            jcTipo.addItem("Individual");//Index 1
            jcTipo.addItem("Masiva");//Index 2

            //Agregar Items al ComboBox
            jcCategoria.addItem("Categoria");//Index 0
            jcCategoria.addItem("Tesis");//Index 1
            jcCategoria.addItem("Libro");//Index 2
            jcCategoria.addItem("Revista");//Index 3

            jlCategoria.setBounds(80, 10, 95, 20);
            jlDatos.setBounds(80, 10, 95, 20);
            jlTipo.setBounds(220, 10, 95, 20);
            jcCategoria.setBounds(80, 30, 95, 20);
            jcTipo.setBounds(220, 30, 95, 20);
            jbAceptar1.setBounds(330, 25, 80, 30);
            jbRegresarAdministrador.setBounds(220, 410, 90, 30);
            jbRegresar.setBounds(220, 410, 90, 30);
            jbAceptar2.setBounds(130, 410, 90, 30);
            jbCancelar.setBounds(310, 410, 90, 30);

            jlAutor.setBounds(80, 30, 60, 25);
            jlTitulo.setBounds(80, 60, 60, 25);
            jlPalabras_Clave.setBounds(80, 90, 95, 25);
            jlArea.setBounds(80, 120, 60, 25);
            jlTemas.setBounds(80, 150, 60, 25);
            jlDescripcion.setBounds(80, 180, 90, 25);
            jlEdicion.setBounds(80, 210, 60, 25);
            jlCopias.setBounds(80, 240, 60, 25);
            jlDisponibles.setBounds(80, 270, 90, 25);
            jlEjemplares.setBounds(80, 300, 90, 25);
            jtAutor.setBounds(180, 30, 150, 25);
            jtTodo.setBounds(180, 30, 600, 350);
            jtTitulo.setBounds(180, 60, 150, 25);
            jtPalabras_Clave.setBounds(180, 90, 150, 25);
            jtArea.setBounds(180, 120, 150, 25);
            jtTemas.setBounds(180, 150, 150, 25);
            jtDescripcion.setBounds(180, 180, 150, 25);
            jtEdicion.setBounds(180, 210, 150, 25);
            jtCopias.setBounds(180, 240, 150, 25);
            jtDisponibles.setBounds(180, 270, 150, 25);
            jtEjemplares.setBounds(180, 300, 150, 25);
            jsTodo.setBounds(180, 30, 600, 350);
            jcCategoria.setEnabled(false);

            jsTodo.setViewportView(jtTodo);
            add(jsTodo);
            add(jlAutor);
            add(jlDatos);
            add(jlTitulo);
            add(jlPalabras_Clave);
            add(jlArea);
            add(jlTemas);
            add(jlDescripcion);
            add(jlEdicion);
            add(jlCopias);
            add(jlDisponibles);
            add(jlEjemplares);
            add(jtAutor);
            add(jtTitulo);
            add(jtPalabras_Clave);
            add(jtArea);
            add(jtTemas);
            add(jtDescripcion);
            add(jtEdicion);
            add(jtCopias);
            add(jtDisponibles);
            add(jtEjemplares);

            add(jlCategoria);
            add(jlTipo);
            add(jcCategoria);
            add(jcTipo);
            add(jbAceptar1);
            add(jbAceptar2);
            add(jbRegresarAdministrador);
            add(jbRegresar);
            add(jbCancelar);

            jbAceptar1.addActionListener((ActionEvent e) -> {
                jbAceptar1Accion();
            });

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            ocultarProceso();
            jbRegresar.addActionListener((ActionEvent e) -> {
                ocultarProceso();
                mostrarInicio();
                limpiar();
            });
            jbCancelar.addActionListener((ActionEvent e) -> {
                limpiar();
            });
            jbAceptar2.addActionListener((ActionEvent e) -> {
                jbAceptar2Accion();
            });
        }

        //Accion Boton Aceptar1
        private void jbAceptar1Accion() {
            switch (jcTipo.getSelectedIndex()) {
                case 0:
                    JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    jcCategoria.setEnabled(true);
                    if (jcCategoria.getSelectedIndex() != 0) {
                        switch (jcCategoria.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case 1:
                                switch (jcTipo.getSelectedIndex()) {
                                    case 0:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    case 1:
                                        ocultarInicio();
                                        mostrarProcesoTesis();
                                        break;
                                    case 2:
                                        ocultarInicio();
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                }
                                break;
                            case 2:
                                switch (jcTipo.getSelectedIndex()) {
                                    case 0:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    case 1:
                                        ocultarInicio();
                                        mostrarProcesoLibro();
                                        break;
                                    case 2:
                                        ocultarInicio();
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                }
                                break;
                            case 3:
                                switch (jcTipo.getSelectedIndex()) {
                                    case 0:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    case 1:
                                        ocultarInicio();
                                        mostrarProcesoRevista();
                                        break;
                                    case 2:
                                        ocultarInicio();
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    ocultarInicio();
                    mostrarMasiva();
                    jcCategoria.setSelectedIndex(0);
                    jcCategoria.setEnabled(false);
                    break;
                default:
                    break;
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        //Ocultar los elementos iniciales
        private void ocultarInicio() {
            jlCategoria.setVisible(false);
            jlTipo.setVisible(false);
            jcCategoria.setVisible(false);
            jcTipo.setVisible(false);
            jbAceptar1.setVisible(false);
            jbRegresarAdministrador.setVisible(false);
        }

        //Ocultar los elementos del proceso de creacion de bibliografia
        private void ocultarProceso() {
            jlAutor.setVisible(false);
            jlTitulo.setVisible(false);
            jlPalabras_Clave.setVisible(false);
            jlArea.setVisible(false);
            jlTemas.setVisible(false);
            jlDescripcion.setVisible(false);
            jlEdicion.setVisible(false);
            jlCopias.setVisible(false);
            jlDisponibles.setVisible(false);
            jtAutor.setVisible(false);
            jtTitulo.setVisible(false);
            jtPalabras_Clave.setVisible(false);
            jtArea.setVisible(false);
            jtTemas.setVisible(false);
            jtDescripcion.setVisible(false);
            jtEdicion.setVisible(false);
            jtCopias.setVisible(false);
            jtDisponibles.setVisible(false);
            jbAceptar2.setVisible(false);
            jbRegresar.setVisible(false);
            jsTodo.setVisible(false);
            jlDatos.setVisible(false);
            jlEjemplares.setVisible(false);
            jtEjemplares.setVisible(false);
        }

        //Mostrar los elementos iniciales
        private void mostrarInicio() {
            jlCategoria.setVisible(true);
            jlTipo.setVisible(true);
            jcCategoria.setVisible(true);
            jcTipo.setVisible(true);
            jbAceptar1.setVisible(true);
            jbRegresarAdministrador.setVisible(true);
        }

        //Mostrar los elementos del proceso de creacion de bibliografia
        private void mostrarProcesoTesis() {
            jlAutor.setVisible(true);
            jlTitulo.setVisible(true);
            jlPalabras_Clave.setVisible(true);
            jlArea.setVisible(true);
            jlTemas.setVisible(true);
            jlDescripcion.setVisible(true);
            jlEdicion.setVisible(true);
            jlCopias.setVisible(true);
            jlDisponibles.setVisible(true);
            jtAutor.setVisible(true);
            jtTitulo.setVisible(true);
            jtPalabras_Clave.setVisible(true);
            jtArea.setVisible(true);
            jtTemas.setVisible(true);
            jtDescripcion.setVisible(true);
            jtEdicion.setVisible(true);
            jtCopias.setVisible(true);
            jtDisponibles.setVisible(true);
            jbAceptar2.setVisible(true);
            jbRegresar.setVisible(true);
        }

        private void mostrarProcesoLibro() {
            jlAutor.setVisible(true);
            jlTitulo.setVisible(true);
            jlPalabras_Clave.setVisible(true);
            jlArea.setVisible(true);
            jlArea.setEnabled(false);
            jlTemas.setVisible(true);
            jlDescripcion.setVisible(true);
            jlEdicion.setVisible(true);
            jlCopias.setVisible(true);
            jlDisponibles.setVisible(true);
            jtAutor.setVisible(true);
            jtTitulo.setVisible(true);
            jtPalabras_Clave.setVisible(true);
            jtArea.setVisible(true);
            jtArea.setEnabled(false);
            jtTemas.setVisible(true);
            jtDescripcion.setVisible(true);
            jtEdicion.setVisible(true);
            jtCopias.setVisible(true);
            jtDisponibles.setVisible(true);
            jbAceptar2.setVisible(true);
            jbRegresar.setVisible(true);
        }

        private void mostrarProcesoRevista() {
            jlAutor.setVisible(true);
            jlTitulo.setVisible(true);
            jlPalabras_Clave.setVisible(true);
            jlArea.setVisible(true);
            jlArea.setText("Frecuencia: ");
            jlArea.setBounds(80, 120, 90, 25);
            jlTemas.setVisible(true);
            jlDescripcion.setVisible(true);
            jlEdicion.setVisible(true);
            jlCopias.setVisible(true);
            jlDisponibles.setVisible(true);
            jtAutor.setVisible(true);
            jtTitulo.setVisible(true);
            jtPalabras_Clave.setVisible(true);
            jtArea.setVisible(true);
            jtTemas.setVisible(true);
            jtDescripcion.setVisible(true);
            jtEdicion.setVisible(true);
            jtCopias.setVisible(true);
            jtDisponibles.setVisible(true);
            jbAceptar2.setVisible(true);
            jbRegresar.setVisible(true);
            jlEjemplares.setVisible(true);
            jtEjemplares.setVisible(true);
        }

        private void mostrarMasiva() {
            jsTodo.setVisible(true);
            jlDatos.setVisible(true);
            jbAceptar2.setVisible(true);
            jbRegresar.setVisible(true);
        }

        private void limpiar() {
            jcCategoria.setSelectedIndex(0);
            jcTipo.setSelectedIndex(0);
            jtAutor.setText("");
            jtTitulo.setText("");
            jtPalabras_Clave.setText("");
            jtArea.setText("");
            jtTemas.setText("");
            jtDescripcion.setText("");
            jtEdicion.setText("");
            jtCopias.setText("");
            jtDisponibles.setText("");
            jtTodo.setText("");
            jtEjemplares.setText("");
        }

        private void jbAceptar2Accion() {
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 12; j++) {
                    ingresados[i][j] = "";
                }
            }
            int index = jcCategoria.getSelectedIndex();
            int index2 = jcTipo.getSelectedIndex();
            switch (index2) {
                case 0:
                    JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    switch (index) {
                        case 0:
                            JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 1:
                            if (!jtAutor.getText().equals("") && !jtTitulo.getText().equals("") && !jtPalabras_Clave.getText().equals("") && !jtArea.getText().equals("") && !jtTemas.getText().equals("") && !jtDescripcion.getText().equals("") && !jtEdicion.getText().equals("") && !jtCopias.getText().equals("") && !jtDisponibles.getText().equals("")) {
                                if (verificarNumero(jtEdicion.getText()) && verificarNumero(jtCopias.getText()) && verificarNumero(jtDisponibles.getText())) {
                                    if (Integer.parseInt(jtCopias.getText()) > 0 && Integer.parseInt(jtEdicion.getText()) > 0 && Integer.parseInt(jtDisponibles.getText()) > 0) {
                                        if (jtCopias.getText().equals(jtDisponibles.getText())) {
                                            Tesis agregar = new Tesis(jtAutor.getText(), jtTitulo.getText(), jtPalabras_Clave.getText(), jtArea.getText(), jtTemas.getText(), jtDescripcion.getText(), jtEdicion.getText(), jtCopias.getText(), jtDisponibles.getText());
                                            arregloTesis[numeroTesis] = agregar;
                                            numeroTesis++;
                                            JOptionPane.showMessageDialog(this, "Tesis Agregada");
                                            ocultarProceso();
                                            mostrarInicio();
                                            limpiar();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Disponibles y Copias Tienen que ser Iguales", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese Numeros Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 2:
                            if (!jtAutor.getText().equals("") && !jtTitulo.getText().equals("") && !jtPalabras_Clave.getText().equals("") && !jtTemas.getText().equals("") && !jtDescripcion.getText().equals("") && !jtEdicion.getText().equals("") && !jtCopias.getText().equals("") && !jtDisponibles.getText().equals("")) {
                                if (verificarNumero(jtEdicion.getText()) && verificarNumero(jtCopias.getText()) && verificarNumero(jtDisponibles.getText())) {
                                    if (Integer.parseInt(jtCopias.getText()) > 0 && Integer.parseInt(jtEdicion.getText()) > 0 && Integer.parseInt(jtDisponibles.getText()) > 0) {
                                        if (jtCopias.getText().equals(jtDisponibles.getText())) {
                                            Libro agregar = new Libro(jtAutor.getText(), jtTitulo.getText(), jtPalabras_Clave.getText(), jtTemas.getText(), jtDescripcion.getText(), jtEdicion.getText(), jtCopias.getText(), jtDisponibles.getText());
                                            arregloLibro[numeroLibros] = agregar;
                                            numeroLibros++;
                                            JOptionPane.showMessageDialog(this, "Libro Agregado");
                                            ocultarProceso();
                                            mostrarInicio();
                                            limpiar();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Disponibles y Copias Tienen que ser Iguales", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese Numeros Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 3:
                            if (!jtAutor.getText().equals("") && !jtTitulo.getText().equals("") && !jtPalabras_Clave.getText().equals("") && !jtArea.getText().equals("") && !jtEjemplares.getText().equals("") && !jtTemas.getText().equals("") && !jtDescripcion.getText().equals("") && !jtEdicion.getText().equals("") && !jtCopias.getText().equals("") && !jtDisponibles.getText().equals("")) {
                                if (verificarNumero(jtEdicion.getText()) && verificarNumero(jtCopias.getText()) && verificarNumero(jtDisponibles.getText()) && verificarNumero(jtEjemplares.getText())) {
                                    if (Integer.parseInt(jtCopias.getText()) > 0 && Integer.parseInt(jtEdicion.getText()) > 0 && Integer.parseInt(jtDisponibles.getText()) > 0 && Integer.parseInt(jtEjemplares.getText()) > 0) {
                                        if (jtCopias.getText().equals(jtDisponibles.getText())) {
                                            Revista agregar = new Revista(jtAutor.getText(), jtTitulo.getText(), jtPalabras_Clave.getText(), jtArea.getText(), jtEjemplares.getText(), jtTemas.getText(), jtDescripcion.getText(), jtEdicion.getText(), jtCopias.getText(), jtDisponibles.getText());
                                            arregloRevista[numeroRevistas] = agregar;
                                            numeroRevistas++;
                                            JOptionPane.showMessageDialog(this, "Tesis Agregada");
                                            ocultarProceso();
                                            mostrarInicio();
                                            limpiar();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Disponibles y Copias Tienen que ser Iguales", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese Numeros Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;
                case 2:
                    int contador = 0;
                    if (!jtTodo.getText().equals("")) {
                        String[] vectorLineas = jtTodo.getText().split("\n");
                        for (String vectorLinea : vectorLineas) {
                            String[] vectorCampos = vectorLinea.split(";");
                            String aAutor = "";
                            String aTitulo = "";
                            String aDescripcion = "";
                            String aPalabra = "";
                            String aEdicion = "";
                            String aTema = "";
                            String aFrecuencia = "";
                            String aEjemplar = "";
                            String aArea = "";
                            String aCopias = "";
                            String aDisponibles = "";
                            switch (vectorCampos.length) {
                                case 9://Libro
                                    if (vectorCampos[0].equals("0")) {
                                        aAutor = vectorCampos[1];
                                        aTitulo = vectorCampos[2];
                                        aDescripcion = vectorCampos[3];
                                        aPalabra = vectorCampos[4];
                                        aTema = vectorCampos[6];
                                        if (verificarNumero(vectorCampos[5]) && verificarNumero(vectorCampos[7]) && verificarNumero(vectorCampos[8])) {
                                            aEdicion = vectorCampos[5];
                                            aCopias = vectorCampos[7];
                                            aDisponibles = vectorCampos[8];
                                            Libro agregar = new Libro(aAutor, aTitulo, aPalabra, aTema, aDescripcion, String.valueOf(aEdicion), String.valueOf(aCopias), String.valueOf(aDisponibles));
                                            arregloLibro[numeroLibros] = agregar;
                                            numeroLibros++;
                                            contador++;
                                            ingresados[ingresos][0] = String.valueOf(ingresos);
                                            ingresados[ingresos][1] = "Libro";
                                            ingresados[ingresos][2] = aAutor;
                                            ingresados[ingresos][3] = aTitulo;
                                            ingresados[ingresos][4] = aDescripcion;
                                            ingresados[ingresos][5] = aPalabra;
                                            ingresados[ingresos][6] = aEdicion;
                                            ingresados[ingresos][7] = aTema;
                                            ingresados[ingresos][8] = aCopias;
                                            ingresados[ingresos][9] = aDisponibles;
                                            ingresados[ingresos][10] = "-";
                                            ingresados[ingresos][11] = "-";
                                            ingresados[ingresos][12] = "-";
                                            ingresos++;
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                            break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese el Tipo Correcto", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                    break;
                                case 11://Revista
                                    if (vectorCampos[0].equals("1")) {
                                        aAutor = vectorCampos[1];
                                        aTitulo = vectorCampos[2];
                                        aDescripcion = vectorCampos[3];
                                        aPalabra = vectorCampos[4];
                                        aTema = vectorCampos[6];
                                        aFrecuencia = vectorCampos[7];
                                        if (verificarNumero(vectorCampos[5]) && verificarNumero(vectorCampos[8]) && verificarNumero(vectorCampos[9]) && verificarNumero(vectorCampos[10])) {
                                            aEdicion = vectorCampos[5];
                                            aEjemplar = vectorCampos[8];
                                            aCopias = vectorCampos[9];
                                            aDisponibles = vectorCampos[10];
                                            Revista agregar = new Revista(aAutor, aTitulo, aPalabra, aFrecuencia, String.valueOf(aEjemplar), aTema, aDescripcion, String.valueOf(aEdicion), String.valueOf(aCopias), String.valueOf(aDisponibles));
                                            arregloRevista[numeroRevistas] = agregar;
                                            numeroRevistas++;
                                            contador++;
                                            ingresados[ingresos][0] = String.valueOf(ingresos);
                                            ingresados[ingresos][1] = "Revista";
                                            ingresados[ingresos][2] = aAutor;
                                            ingresados[ingresos][3] = aTitulo;
                                            ingresados[ingresos][4] = aDescripcion;
                                            ingresados[ingresos][5] = aPalabra;
                                            ingresados[ingresos][6] = aEdicion;
                                            ingresados[ingresos][7] = aTema;
                                            ingresados[ingresos][8] = aCopias;
                                            ingresados[ingresos][9] = aDisponibles;
                                            ingresados[ingresos][10] = aFrecuencia;
                                            ingresados[ingresos][11] = aEjemplar;
                                            ingresados[ingresos][12] = "-";
                                            ingresos++;
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                            break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese el Tipo Correcto", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                    break;
                                case 10://Tesis
                                    if (vectorCampos[0].equals("2")) {

                                        aAutor = vectorCampos[1];
                                        aTitulo = vectorCampos[2];
                                        aDescripcion = vectorCampos[3];
                                        aPalabra = vectorCampos[4];
                                        aTema = vectorCampos[6];
                                        aArea = vectorCampos[7];
                                        if (verificarNumero(vectorCampos[5]) && verificarNumero(vectorCampos[8]) && verificarNumero(vectorCampos[9])) {
                                            aEdicion = vectorCampos[5];
                                            aCopias = vectorCampos[8];
                                            aDisponibles = vectorCampos[9];
                                            Tesis agregar = new Tesis(aAutor, aTitulo, aPalabra, aArea, aTema, aDescripcion, String.valueOf(aEdicion), String.valueOf(aCopias), String.valueOf(aDisponibles));
                                            arregloTesis[numeroTesis] = agregar;
                                            numeroTesis++;
                                            contador++;
                                            ingresados[ingresos][0] = String.valueOf(ingresos);
                                            ingresados[ingresos][1] = "Tesis";
                                            ingresados[ingresos][2] = aAutor;
                                            ingresados[ingresos][3] = aTitulo;
                                            ingresados[ingresos][4] = aDescripcion;
                                            ingresados[ingresos][5] = aPalabra;
                                            ingresados[ingresos][6] = aEdicion;
                                            ingresados[ingresos][7] = aTema;
                                            ingresados[ingresos][8] = aCopias;
                                            ingresados[ingresos][9] = aDisponibles;
                                            ingresados[ingresos][10] = "-";
                                            ingresados[ingresos][11] = "-";
                                            ingresados[ingresos][12] = aArea;
                                            ingresos++;
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Ingrese Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                                            break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Ingrese el Tipo Correcto", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(this, "Ingrese Campos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                            }
                        }
                        if (vectorLineas.length != 0) {
                            if (contador != 0) {
                                JOptionPane.showMessageDialog(this, "Bibliografias Ingresadas", "Error", JOptionPane.INFORMATION_MESSAGE);
                                VerIngresados VI = new VerIngresados();
                                VI.setVisible(true);
                                jtTodo.setText("");
                            } else {
                                JOptionPane.showMessageDialog(this, "Error al Ingresar las Bibliografias", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Seleccione Datos Validos", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

        //Verificacion de Cadena es Numerica o No
        private boolean verificarNumero(String cadena) {
            try {
                Integer.parseInt(cadena);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
    }

    private class VerIngresados extends JFrame {

        JScrollPane jsVerIngresados = new JScrollPane();
        JTable jtVerIngresados = new JTable();

        public VerIngresados() {
            super("Ingresados");
            inicializacionVerIngresados();
        }

        public void inicializacionVerIngresados() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            Object[][] datos = new Object[ingresos][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            for (int i = 0; i < ingresos; i++) {
                for (int j = 0; j < 13; j++) {
                    datos[i][j] = ingresados[i][j];
                }
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Descripcion", "Palabras Clave", "Edicion", "Temas", "Copias", "Disponibles", "Frecuencia", "Ejemplar", "Area"};//Se crea el vector donde van los encabezados de las columnas
            jtVerIngresados = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerIngresados.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerIngresados.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerIngresados.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerIngresados.enable(false);//Se bloquea la edicion de la tabla
            jsVerIngresados.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerIngresados.setViewportView(jtVerIngresados);//Se inserta la tabla en el JScrollPane
            add(jsVerIngresados);//Se Agrega el JScrollPane
        }
    }

    private class VerBibliografia extends JFrame {

        JLabel jlBuscar;
        JTextField jtBuscar;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane

        JButton jbBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public VerBibliografia() {
            super("VerBibliografia");
            inicializacionVerBibliografia();
        }

        public void inicializacionVerBibliografia() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jlBuscar = new JLabel("Buscar: ");
            jbBuscar = new JButton("Buscar");
            jbRegresarAdministrador = new JButton("Regresar");
            jtBuscar = new JTextField("");
            jbBuscar.setBounds(460, 25, 80, 30);
            jbRegresarAdministrador.setBounds(220, 410, 90, 30);
            jlBuscar.setBounds(220, 25, 70, 25);
            jtBuscar.setBounds(290, 25, 150, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);

        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            JTable jtModificarBibliografia;
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[i][0] = i;
                        datos[i][1] = "Tesis";
                        datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[i][6] = "-";
                        datos[i][7] = "-";
                        datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;

                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen las Palabras Clave
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                jtModificarBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarAdministrador = new JButton("Regresar");
                jbRegresarAdministrador.setBounds(130, 375, 130, 25);

                jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                    jbRegresarAdministradorAccion();
                });

                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarAdministrador);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }
    }

    private class EliminarBibliografia extends JFrame {

        JLabel jlBuscar;
        JTextField jtBuscar;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane

        JButton jbBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public EliminarBibliografia() {
            super("EliminarBibliografia");
            inicializacionEliminarBibliografia();
        }

        public void inicializacionEliminarBibliografia() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jlBuscar = new JLabel("Buscar: ");
            jbBuscar = new JButton("Buscar");
            jbRegresarAdministrador = new JButton("Regresar");
            jtBuscar = new JTextField("");
            jbBuscar.setBounds(460, 25, 80, 30);
            jbRegresarAdministrador.setBounds(220, 410, 90, 30);
            jlBuscar.setBounds(220, 25, 70, 25);
            jtBuscar.setBounds(290, 25, 150, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });

            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                            edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                            PantallaEliminar Pe = new PantallaEliminar();
                            Pe.setVisible(true);
                        }
                    }
                }
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);

        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            JTable jtModificarBibliografia;
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;

                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;

                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;

                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                jtModificarBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarAdministrador = new JButton("Regresar");
                jbRegresarAdministrador.setBounds(130, 375, 130, 25);

                jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                    jbRegresarAdministradorAccion();
                });
                jtModificarBibliografia.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            int fila = jtModificarBibliografia.rowAtPoint(e.getPoint());
                            int columna = jtModificarBibliografia.columnAtPoint(e.getPoint());
                            if (fila > -1 && columna > -1) {
                                tipo = jtModificarBibliografia.getValueAt(fila, 1).toString();
                                autor = jtModificarBibliografia.getValueAt(fila, 2).toString();
                                titulo = jtModificarBibliografia.getValueAt(fila, 3).toString();
                                palabras = jtModificarBibliografia.getValueAt(fila, 4).toString();
                                edicion = jtModificarBibliografia.getValueAt(fila, 10).toString();
                                PantallaEliminar Pe = new PantallaEliminar();
                                Pe.setVisible(true);
                            }
                        }
                    }
                });

                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarAdministrador);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        private class PantallaEliminar extends JFrame {

            JLabel jlAutor = new JLabel("Autor: ");
            JLabel jlTitulo = new JLabel("TItulo: ");
            JLabel jlTipo = new JLabel("Tipo: ");
            JLabel jlEdicion = new JLabel("Edicion: ");
            JTextField jtAutor = new JTextField("");
            JTextField jtTitulo = new JTextField("");
            JTextField jtEdicion = new JTextField("");
            JTextField jtTipo = new JTextField("");
            JButton jbBorrar = new JButton("Borrar");

            public PantallaEliminar() {
                super("PantallaEliminar");
                inicializarPantallaEliminar();
            }

            private void inicializarPantallaEliminar() {
                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(400, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica

                jbBorrar.setBounds(30, 220, 90, 30);
                jlTipo.setBounds(30, 130, 70, 25);
                jlAutor.setBounds(30, 25, 70, 25);
                jlTitulo.setBounds(30, 60, 70, 25);
                jlEdicion.setBounds(30, 95, 70, 25);
                jlTipo.setBounds(30, 130, 150, 25);
                jtAutor.setBounds(130, 25, 150, 25);
                jtTitulo.setBounds(130, 60, 150, 25);
                jtEdicion.setBounds(130, 95, 150, 25);
                jtTipo.setBounds(130, 130, 150, 25);
                jtAutor.setEditable(false);
                jtTitulo.setEditable(false);
                jtEdicion.setEditable(false);
                jtTipo.setEditable(false);
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getEdicion().equals(edicion)) {
                                jtTipo.setText("Tesis");
                                jtAutor.setText(arregloTesis[i].getAutor());
                                jtEdicion.setText(String.valueOf(arregloTesis[i].getEdicion()));
                                jtTitulo.setText(arregloTesis[i].getTitulo());
                            }
                        }
                        break;
                    case "Libros":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getEdicion().equals(edicion)) {
                                jtTipo.setText("Libro");
                                jtAutor.setText(arregloLibro[i].getAutor());
                                jtEdicion.setText(String.valueOf(arregloLibro[i].getEdicion()));
                                jtTitulo.setText(arregloLibro[i].getTitulo());
                            }
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getEdicion().equals(edicion)) {
                                jtTipo.setText("Revista");
                                jtAutor.setText(arregloRevista[i].getAutor());
                                jtEdicion.setText(String.valueOf(arregloRevista[i].getEdicion()));
                                jtTitulo.setText(arregloRevista[i].getTitulo());
                            }
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Ingrese una Categoria Correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                add(jlTipo);
                add(jlAutor);
                add(jlTitulo);
                add(jlEdicion);
                add(jtTipo);
                add(jtAutor);
                add(jtEdicion);
                add(jtTitulo);
                add(jbBorrar);
                jbBorrar.addActionListener((ActionEvent e) -> {
                    jbBorrarAccion();
                });
            }

            private void jbBorrarAccion() {
                String Autor = jtAutor.getText();
                String Titulo = jtTitulo.getText();
                String Tipo = jtTipo.getText();
                String Edicion = jtEdicion.getText();
                switch (Tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(Autor) && arregloTesis[i].getTitulo().equals(Titulo) && arregloTesis[i].getEdicion().equals(Edicion)) {
                                for (int j = i; j < numeroTesis - 1; j++) {
                                    arregloTesis[j].setAutor(arregloTesis[j + 1].getAutor());
                                    arregloTesis[j].setTitulo(arregloTesis[j + 1].getTitulo());
                                    arregloTesis[j].setPalabras_Clave(arregloTesis[j + 1].getPalabras_Clave());
                                    arregloTesis[j].setArea(arregloTesis[j + 1].getArea());
                                    arregloTesis[j].setTemas(arregloTesis[j + 1].getTemas());
                                    arregloTesis[j].setDescripcion(arregloTesis[j + 1].getDescripcion());
                                    arregloTesis[j].setEdicion(arregloTesis[j + 1].getEdicion());
                                    arregloTesis[j].setCopias(arregloTesis[j + 1].getCopias());
                                    arregloTesis[j].setDisponibles(arregloTesis[j + 1].getDisponibles());
                                }
                                arregloTesis[numeroTesis - 1].setAutor(null);
                                arregloTesis[numeroTesis - 1].setTitulo(null);
                                arregloTesis[numeroTesis - 1].setPalabras_Clave(null);
                                arregloTesis[numeroTesis - 1].setArea(null);
                                arregloTesis[numeroTesis - 1].setTemas(null);
                                arregloTesis[numeroTesis - 1].setDescripcion(null);
                                arregloTesis[numeroTesis - 1].setEdicion(null);
                                arregloTesis[numeroTesis - 1].setCopias(null);
                                arregloTesis[numeroTesis - 1].setDisponibles(null);
                                numeroTesis--;
                            }
                        }
                        JOptionPane.showMessageDialog(this, "La tesis fue eliminada", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        inicializacionEliminarBibliografia();
                        break;
                    case "Libro":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(Autor) && arregloLibro[i].getTitulo().equals(Titulo) && arregloLibro[i].getEdicion().equals(Edicion)) {
                                for (int j = i; j < numeroLibros - 1; j++) {
                                    arregloLibro[j].setAutor(arregloLibro[j + 1].getAutor());
                                    arregloLibro[j].setTitulo(arregloLibro[j + 1].getTitulo());
                                    arregloLibro[j].setPalabras_Clave(arregloLibro[j + 1].getPalabras_Clave());
                                    arregloLibro[j].setTemas(arregloLibro[j + 1].getTemas());
                                    arregloLibro[j].setDescripcion(arregloLibro[j + 1].getDescripcion());
                                    arregloLibro[j].setEdicion(arregloLibro[j + 1].getEdicion());
                                    arregloLibro[j].setCopias(arregloLibro[j + 1].getCopias());
                                    arregloLibro[j].setDisponibles(arregloLibro[j + 1].getDisponibles());
                                }
                                arregloLibro[numeroLibros - 1].setAutor(null);
                                arregloLibro[numeroLibros - 1].setTitulo(null);
                                arregloLibro[numeroLibros - 1].setPalabras_Clave(null);
                                arregloLibro[numeroLibros - 1].setTemas(null);
                                arregloLibro[numeroLibros - 1].setDescripcion(null);
                                arregloLibro[numeroLibros - 1].setEdicion(null);
                                arregloLibro[numeroLibros - 1].setCopias(null);
                                arregloLibro[numeroLibros - 1].setDisponibles(null);
                                numeroLibros--;
                            }
                        }
                        JOptionPane.showMessageDialog(this, "El libro fue eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        inicializacionEliminarBibliografia();
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(Autor) && arregloRevista[i].getTitulo().equals(Titulo) && arregloRevista[i].getEdicion().equals(Edicion)) {
                                for (int j = i; j < numeroRevistas - 1; j++) {
                                    arregloRevista[j].setAutor(arregloRevista[j + 1].getAutor());
                                    arregloRevista[j].setTitulo(arregloRevista[j + 1].getTitulo());
                                    arregloRevista[j].setPalabras_Clave(arregloRevista[j + 1].getPalabras_Clave());
                                    arregloRevista[j].setFrecuencia_Actual(arregloRevista[j + 1].getFrecuencia_Actual());
                                    arregloRevista[j].setEjemplar(arregloRevista[j + 1].getEjemplar());
                                    arregloRevista[j].setTemas(arregloRevista[j + 1].getTemas());
                                    arregloRevista[j].setDescripcion(arregloRevista[j + 1].getDescripcion());
                                    arregloRevista[j].setEdicion(arregloRevista[j + 1].getEdicion());
                                    arregloRevista[j].setCopias(arregloRevista[j + 1].getCopias());
                                    arregloRevista[j].setDisponibles(arregloRevista[j + 1].getDisponibles());
                                }
                                arregloRevista[numeroRevistas - 1].setAutor(null);
                                arregloRevista[numeroRevistas - 1].setTitulo(null);
                                arregloRevista[numeroRevistas - 1].setPalabras_Clave(null);
                                arregloRevista[numeroRevistas - 1].setFrecuencia_Actual(null);
                                arregloRevista[numeroRevistas - 1].setEjemplar(null);
                                arregloRevista[numeroRevistas - 1].setTemas(null);
                                arregloRevista[numeroRevistas - 1].setDescripcion(null);
                                arregloRevista[numeroRevistas - 1].setEdicion(null);
                                arregloRevista[numeroRevistas - 1].setCopias(null);
                                arregloRevista[numeroRevistas - 1].setDisponibles(null);
                                numeroRevistas--;
                            }
                        }
                        JOptionPane.showMessageDialog(this, "La revista fue eliminada", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        inicializacionEliminarBibliografia();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private class ModificarBibliografia extends JFrame {

        JLabel jlBuscar;
        JTextField jtBuscar;
        JScrollPane jsVerBibliografia = new JScrollPane();//Se creaa un JScrollPane
        JScrollPane jsVerBibliografia2 = new JScrollPane();//Se creaa un JScrollPane

        JButton jbBuscar;

        //Se define la JTable
        JTable jtVerBibliografia;

        //Se define el JButton
        JButton jbRegresarAdministrador;

        //Constructor de la Clase VerUsuario
        public ModificarBibliografia() {
            super("ModificarBibliografia");
            inicializacionModificarBibliografia();
        }

        public void inicializacionModificarBibliografia() {
            setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
            setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
            setSize(1000, 500); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
            setDefaultCloseOperation(EXIT_ON_CLOSE); //Finaliza el Programa al Cerrarlo
            setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
            jlBuscar = new JLabel("Buscar: ");
            jbBuscar = new JButton("Buscar");
            jbRegresarAdministrador = new JButton("Regresar");
            jtBuscar = new JTextField("");
            jbBuscar.setBounds(460, 25, 80, 30);
            jbRegresarAdministrador.setBounds(220, 410, 90, 30);
            jlBuscar.setBounds(220, 25, 70, 25);
            jtBuscar.setBounds(290, 25, 150, 25);
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                datos[i][0] = i;
                datos[i][1] = "Tesis";
                datos[i][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                datos[i][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                datos[i][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[i][5] = arregloTesis[i].getArea();//Se obtiene el Area
                datos[i][6] = "-";
                datos[i][7] = "-";
                datos[i][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                datos[i][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                datos[i][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                datos[i][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                datos[i][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                datos[numeroTesis + i][0] = numeroTesis + i;
                datos[numeroTesis + i][1] = "Libros";
                datos[numeroTesis + i][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + i][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + i][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + i][5] = "-";
                datos[numeroTesis + i][6] = "-";
                datos[numeroTesis + i][7] = "-";
                datos[numeroTesis + i][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + i][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + i][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + i][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + i][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con las Revista existentes
                datos[numeroTesis + numeroLibros + i][0] = numeroTesis + numeroLibros + i;
                datos[numeroTesis + numeroLibros + i][1] = "Revista";
                datos[numeroTesis + numeroLibros + i][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                datos[numeroTesis + numeroLibros + i][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                datos[numeroTesis + numeroLibros + i][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                datos[numeroTesis + numeroLibros + i][5] = "-";
                datos[numeroTesis + numeroLibros + i][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                datos[numeroTesis + numeroLibros + i][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                datos[numeroTesis + numeroLibros + i][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                datos[numeroTesis + numeroLibros + i][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                datos[numeroTesis + numeroLibros + i][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                datos[numeroTesis + numeroLibros + i][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
            }

            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            jtVerBibliografia = new JTable(datos, nombres);//Se crea la tabla con los datos y encabezados
            for (int i = 0; i < 13; i++) {
                jtVerBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
            }
            jtVerBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
            jtVerBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
            jtVerBibliografia.enable(false);//Se bloquea la edicion de la tabla
            jbRegresarAdministrador = new JButton("Regresar");
            jbRegresarAdministrador.setBounds(130, 375, 130, 25);

            jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                jbRegresarAdministradorAccion();
            });
            jbBuscar.addActionListener((ActionEvent e) -> {
                jbBuscarAccion();
            });
            jtVerBibliografia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int fila = jtVerBibliografia.rowAtPoint(e.getPoint());
                        int columna = jtVerBibliografia.columnAtPoint(e.getPoint());
                        if (fila > -1 && columna > -1) {
                            tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                            autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                            titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                            palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                            edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                            PantallaModificar Pe = new PantallaModificar();
                            Pe.setVisible(true);
                        }
                    }
                }
            });
            jsVerBibliografia.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
            jsVerBibliografia.setViewportView(jtVerBibliografia);//Se inserta la tabla en el JScrollPane
            add(jsVerBibliografia);//Se Agrega el JScrollPane
            add(jbRegresarAdministrador);
            add(jlBuscar);
            add(jtBuscar);
            add(jbBuscar);

        }

        private void jbBuscarAccion() {
            if (!jtBuscar.getText().equals("")) {
                MostrarTabla();
            } else {
                jsVerBibliografia.setVisible(true);
                jsVerBibliografia2.setVisible(false);
            }
        }

        public String capitalizarLetra(String str) {
            if (str.isEmpty()) {
                return str;
            } else {
                return Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }

        private void MostrarTabla() {
            jsVerBibliografia.setVisible(false);
            String dato1 = jtBuscar.getText();
            String dato = capitalizarLetra(dato1);
            JTable jtModificarBibliografia;
            int numeroTotal = numeroTesis + numeroLibros + numeroRevistas;
            Object[][] datos = new Object[numeroTotal][13];//Se crea la Matriz donde se Guardaran los datos a mostrar
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();//Se crea un objeto nuevo 
            centrado.setHorizontalAlignment(SwingConstants.CENTER);//Se alinea el texto a el centro
            int contador = 0;
            switch (dato) {
                case "Tesis":
                    for (int i = 0; i < numeroTesis; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Libros":
                    for (int i = 0; i < numeroLibros; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                case "Revistas":
                    for (int i = 0; i < numeroRevistas; i++) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numeroTesis; i++) {//Llenado de la tabla con las tesis existentes
                String palabras = arregloTesis[i].getPalabras_Clave();
                String listaAutor = arregloTesis[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloTesis[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Tesis";
                        datos[contador][2] = arregloTesis[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloTesis[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloTesis[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = arregloTesis[i].getArea();//Se obtiene el Area
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloTesis[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloTesis[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloTesis[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloTesis[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloTesis[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroLibros; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloLibro[i].getPalabras_Clave();
                String listaAutor = arregloLibro[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloLibro[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Libros";
                        datos[contador][2] = arregloLibro[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloLibro[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloLibro[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = "-";
                        datos[contador][7] = "-";
                        datos[contador][8] = arregloLibro[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloLibro[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloLibro[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloLibro[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloLibro[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            for (int i = 0; i < numeroRevistas; i++) {//Llenado de la tabla con los libros existentes
                String palabras = arregloRevista[i].getPalabras_Clave();
                String listaAutor = arregloRevista[i].getAutor();
                String[] matrizAutor = listaAutor.split(" ");
                String listaTemas = arregloRevista[i].getTemas();
                String[] matrizTemas = listaTemas.split(" ");
                String[] lista = palabras.split(",");
                for (String matrizAutor1 : matrizAutor) {
                    if (matrizAutor1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String matrizTemas1 : matrizTemas) {
                    if (matrizTemas1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
                for (String lista1 : lista) {
                    if (lista1.equals(dato)) {
                        datos[contador][0] = contador;
                        datos[contador][1] = "Revista";
                        datos[contador][2] = arregloRevista[i].getAutor();//Se obtiene el Autor
                        datos[contador][3] = arregloRevista[i].getTitulo();//Se obtiene el Titulo
                        datos[contador][4] = arregloRevista[i].getPalabras_Clave();//Se obtienen las Palabras Clave
                        datos[contador][5] = "-";
                        datos[contador][6] = arregloRevista[i].getFrecuencia_Actual();//Se obtiene la Frecuencia de Publicacion
                        datos[contador][7] = arregloRevista[i].getEjemplar();//Se obtienen los Temas
                        datos[contador][8] = arregloRevista[i].getTemas();//Se obtienen los Temas
                        datos[contador][9] = arregloRevista[i].getDescripcion();//Se obtiene la Descripcion
                        datos[contador][10] = arregloRevista[i].getEdicion();//Se obtiene la Edicion
                        datos[contador][11] = arregloRevista[i].getCopias();//Se obtiene las Copias
                        datos[contador][12] = arregloRevista[i].getDisponibles();//Se obtienen las Copias Disponibles
                        contador++;
                    }
                }
            }
            Object[][] datosModificados = new Object[contador][13];
            for (int i = 0; i < contador; i++) {
                datosModificados[i][0] = datos[i][0];
                datosModificados[i][1] = datos[i][1];
                datosModificados[i][2] = datos[i][2];
                datosModificados[i][3] = datos[i][3];
                datosModificados[i][4] = datos[i][4];
                datosModificados[i][5] = datos[i][5];
                datosModificados[i][6] = datos[i][6];
                datosModificados[i][7] = datos[i][7];
                datosModificados[i][8] = datos[i][8];
                datosModificados[i][9] = datos[i][9];
                datosModificados[i][10] = datos[i][10];
                datosModificados[i][11] = datos[i][11];
                datosModificados[i][12] = datos[i][12];
            }
            String[] nombres = {"#", "Tipo", "Autor", "Titulo", "Palabras Clave", "Area", "Frecuencia", "Ejemplares", "Temas", "Descripcion", "Edicion", "Copias", "Disponibles"};//Se crea el vector donde van los encabezados de las columnas
            if (contador > 0) {
                jtModificarBibliografia = new JTable(datosModificados, nombres);//Se crea la tabla con los datos y encabezados
                for (int i = 0; i < 13; i++) {
                    jtModificarBibliografia.getColumnModel().getColumn(i).setCellRenderer(centrado);//Se centra el texto de todas las columnas
                }
                jtModificarBibliografia.getColumnModel().getColumn(0).setPreferredWidth(10);//Se da un ancho a la columna que muesta el numero de usuario
                jtModificarBibliografia.getColumnModel().getColumn(1).setPreferredWidth(50);//Se da un ancho a la columna que muestra el DPI
                jtModificarBibliografia.enable(false);//Se bloquea la edicion de la tabla
                jbRegresarAdministrador = new JButton("Regresar");
                jbRegresarAdministrador.setBounds(130, 375, 130, 25);

                jbRegresarAdministrador.addActionListener((ActionEvent e) -> {
                    jbRegresarAdministradorAccion();
                });

                jtModificarBibliografia.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            int fila = jtModificarBibliografia.rowAtPoint(e.getPoint());
                            int columna = jtModificarBibliografia.columnAtPoint(e.getPoint());
                            if (fila > -1 && columna > -1) {
                                tipo = jtVerBibliografia.getValueAt(fila, 1).toString();
                                autor = jtVerBibliografia.getValueAt(fila, 2).toString();
                                titulo = jtVerBibliografia.getValueAt(fila, 3).toString();
                                palabras = jtVerBibliografia.getValueAt(fila, 4).toString();
                                edicion = jtVerBibliografia.getValueAt(fila, 10).toString();
                                PantallaModificar Pe = new PantallaModificar();
                                Pe.setVisible(true);
                            }
                        }
                    }
                });
                jsVerBibliografia2.setBounds(20, 80, 955, 150);//Se da el tamaño al JScrollPane
                jsVerBibliografia2.setViewportView(jtModificarBibliografia);//Se inserta la tabla en el JScrollPane
                jsVerBibliografia2.setVisible(true);
                add(jsVerBibliografia2);//Se Agrega el JScrollPane
                add(jbRegresarAdministrador);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ninguna Bibliografia con dicho Autor/Titulo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Accion Boton Regresar
        private void jbRegresarAdministradorAccion() {
            this.setVisible(false);//Oculta el JFrame de CrearUsuario
            Administrador A = new Administrador();//Crea el Objeto de la Clase Administrador
            A.setVisible(true);//Muestra el JFrame de Administrador
        }

        private class PantallaModificar extends JFrame {

            JLabel jlTipo;
            JLabel jlCopias;
            JLabel jlPalabras;
            JLabel jlDescripcion;
            JLabel jlFrecuencia;
            JLabel jlArea;
            JLabel jlEjemplar;
            JTextField jtCopias;
            JTextField jtPalabras;
            JTextField jtDescripcion;
            JTextField jtFrecuencia;
            JTextField jtArea;
            JTextField jtEjemplar;
            JComboBox jcTipo;
            JButton jbModificar;
            JButton jbRegresar;

            public PantallaModificar() {
                super("PantallaModificar");
                inicializacionPantallaModificar();
            }

            private void inicializacionPantallaModificar() {
                jlTipo = new JLabel("Tipo: ");
                jlCopias = new JLabel("Copias: ");
                jlPalabras = new JLabel("Palabras Clave: ");
                jlDescripcion = new JLabel("Descripcion: ");
                jlFrecuencia = new JLabel("Frecuencia: ");
                jlArea = new JLabel("Area: ");
                jlEjemplar = new JLabel("Ejemplar: ");
                jtCopias = new JTextField("");
                jtPalabras = new JTextField("");
                jtDescripcion = new JTextField("");
                jtFrecuencia = new JTextField("");
                jtEjemplar = new JTextField("");
                jtArea = new JTextField("");
                jcTipo = new JComboBox();
                jbModificar = new JButton("Modificar");
                jbRegresar = new JButton("Regresar");

                jcTipo.addItem("Categoria");//Index 0
                jcTipo.addItem("Tesis");//Index 1
                jcTipo.addItem("Libro");//Index 2
                jcTipo.addItem("Revista");//Index 3

                jlTipo.setBounds(30, 25, 150, 25);
                jlCopias.setBounds(30, 60, 150, 25);
                jlPalabras.setBounds(30, 95, 150, 25);
                jlDescripcion.setBounds(30, 130, 150, 25);
                jlFrecuencia.setBounds(30, 165, 150, 25);
                jlArea.setBounds(30, 200, 150, 25);
                jlEjemplar.setBounds(30, 235, 150, 25);
                jcTipo.setBounds(130, 25, 150, 25);
                jtCopias.setBounds(130, 60, 150, 25);
                jtPalabras.setBounds(130, 95, 150, 25);
                jtDescripcion.setBounds(130, 130, 150, 25);
                jtFrecuencia.setBounds(130, 165, 150, 25);
                jtArea.setBounds(130, 200, 150, 25);
                jtEjemplar.setBounds(130, 235, 150, 25);
                jbModificar.setBounds(300, 100, 90, 30);
                jbRegresar.setBounds(300, 130, 90, 30);

                setResizable(false);//Indica que no se puede modificar el tamaño de la ventana
                setLocation(new java.awt.Point(100, 100));//Indica donde se inicia la ventana
                setSize(450, 300); //Fijacion del tamaño de la ventana 400px en X, 300px en Y 
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finaliza el Programa al Cerrarlo
                setLayout(null); //Elimina el Layout para Agregar las posiciones de manera Estatica
                add(jlTipo);
                add(jlCopias);
                add(jlPalabras);
                add(jlDescripcion);
                add(jlFrecuencia);
                add(jlArea);
                add(jlEjemplar);
                add(jtCopias);
                add(jtPalabras);
                add(jtDescripcion);
                add(jtFrecuencia);
                add(jtArea);
                add(jtEjemplar);
                add(jcTipo);
                add(jbModificar);
                add(jbRegresar);

                jlArea.setVisible(false);
                jlFrecuencia.setVisible(false);
                jlEjemplar.setVisible(false);
                jtArea.setVisible(false);
                jtFrecuencia.setVisible(false);
                jtEjemplar.setVisible(false);

                llenarCampos();

                jbRegresar.addActionListener((ActionEvent e) -> {
                    jbRegresar();
                });

                jbModificar.addActionListener((ActionEvent e) -> {
                    jbModificar();
                });
            }

            private void jbRegresar() {
                this.dispose();
            }

            private void llenarCampos() {
                int contador = 0;
                switch (tipo) {
                    case "Tesis":
                        for (int i = 0; i < numeroTesis; i++) {
                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                jtCopias.setText(String.valueOf(arregloTesis[i].getCopias()));
                                jtPalabras.setText(arregloTesis[i].getPalabras_Clave());
                                jtDescripcion.setText(arregloTesis[i].getDescripcion());
                                jtArea.setText(arregloTesis[i].getArea());
                                jcTipo.setSelectedIndex(1);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Libros":
                        for (int i = 0; i < numeroLibros; i++) {
                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                jtCopias.setText(String.valueOf(arregloLibro[i].getCopias()));
                                jtPalabras.setText(arregloLibro[i].getPalabras_Clave());
                                jtDescripcion.setText(arregloLibro[i].getDescripcion());
                                jcTipo.setSelectedIndex(2);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "Revista":
                        for (int i = 0; i < numeroRevistas; i++) {
                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                jtCopias.setText(String.valueOf(arregloRevista[i].getCopias()));
                                jtPalabras.setText(arregloRevista[i].getPalabras_Clave());
                                jtDescripcion.setText(arregloRevista[i].getDescripcion());
                                jtFrecuencia.setText(arregloRevista[i].getFrecuencia_Actual());
                                jcTipo.setSelectedIndex(3);
                                contador++;
                            } else {
                                contador = contador;
                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(this, "No se encontro la Bibliografia", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        break;
                }
            }

            private boolean verificarNumero(String cadena) {
                try {
                    Double.parseDouble(cadena);
                    return true;
                } catch (NumberFormatException nfe) {
                    return false;
                }
            }

            private void jbModificar() {
                switch (jcTipo.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(this, "Ingrese un Tipo Correcto", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        if (!jtArea.getText().isEmpty()) {
                            jtFrecuencia.setText("");
                            if (!jtCopias.getText().equals("") && !jtDescripcion.getText().equals("") && !jtPalabras.getText().equals("")) {
                                if (verificarNumero(jtCopias.getText())) {
                                    switch (tipo) {
                                        case "Tesis":
                                            for (int i = 0; i < numeroTesis; i++) {
                                                if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloTesis[i].getDisponibles())) {
                                                        Tesis agregar = new Tesis(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), jtArea.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                        arregloTesis[numeroTesis] = agregar;
                                                        numeroTesis++;
                                                        for (int j = i; j < numeroTesis - 1; j++) {
                                                            arregloTesis[j].setAutor(arregloTesis[j + 1].getAutor());
                                                            arregloTesis[j].setTitulo(arregloTesis[j + 1].getTitulo());
                                                            arregloTesis[j].setPalabras_Clave(arregloTesis[j + 1].getPalabras_Clave());
                                                            arregloTesis[j].setArea(arregloTesis[j + 1].getArea());
                                                            arregloTesis[j].setTemas(arregloTesis[j + 1].getTemas());
                                                            arregloTesis[j].setDescripcion(arregloTesis[j + 1].getDescripcion());
                                                            arregloTesis[j].setEdicion(arregloTesis[j + 1].getEdicion());
                                                            arregloTesis[j].setCopias(arregloTesis[j + 1].getCopias());
                                                            arregloTesis[j].setDisponibles(arregloTesis[j + 1].getDisponibles());
                                                        }
                                                        arregloTesis[numeroTesis - 1].setAutor(null);
                                                        arregloTesis[numeroTesis - 1].setTitulo(null);
                                                        arregloTesis[numeroTesis - 1].setPalabras_Clave(null);
                                                        arregloTesis[numeroTesis - 1].setArea(null);
                                                        arregloTesis[numeroTesis - 1].setTemas(null);
                                                        arregloTesis[numeroTesis - 1].setDescripcion(null);
                                                        arregloTesis[numeroTesis - 1].setEdicion(null);
                                                        arregloTesis[numeroTesis - 1].setCopias(null);
                                                        arregloTesis[numeroTesis - 1].setDisponibles(null);
                                                        numeroTesis--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        case "Libros":
                                            for (int i = 0; i < numeroLibros; i++) {
                                                if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                        Tesis agregar = new Tesis(arregloLibro[i].getAutor(), arregloLibro[i].getTitulo(), jtPalabras.getText(), jtArea.getText(), arregloLibro[i].getTemas(), jtDescripcion.getText(), arregloLibro[i].getEdicion(), jtCopias.getText(), arregloLibro[i].getDisponibles());
                                                        arregloTesis[numeroTesis] = agregar;
                                                        numeroTesis++;
                                                        for (int j = i; j < numeroLibros - 1; j++) {
                                                            arregloLibro[j].setAutor(arregloLibro[j + 1].getAutor());
                                                            arregloLibro[j].setTitulo(arregloLibro[j + 1].getTitulo());
                                                            arregloLibro[j].setPalabras_Clave(arregloLibro[j + 1].getPalabras_Clave());
                                                            arregloLibro[j].setTemas(arregloLibro[j + 1].getTemas());
                                                            arregloLibro[j].setDescripcion(arregloLibro[j + 1].getDescripcion());
                                                            arregloLibro[j].setEdicion(arregloLibro[j + 1].getEdicion());
                                                            arregloLibro[j].setCopias(arregloLibro[j + 1].getCopias());
                                                            arregloLibro[j].setDisponibles(arregloLibro[j + 1].getDisponibles());
                                                        }
                                                        arregloLibro[numeroLibros - 1].setAutor(null);
                                                        arregloLibro[numeroLibros - 1].setTitulo(null);
                                                        arregloLibro[numeroLibros - 1].setPalabras_Clave(null);
                                                        arregloLibro[numeroLibros - 1].setTemas(null);
                                                        arregloLibro[numeroLibros - 1].setDescripcion(null);
                                                        arregloLibro[numeroLibros - 1].setEdicion(null);
                                                        arregloLibro[numeroLibros - 1].setCopias(null);
                                                        arregloLibro[numeroLibros - 1].setDisponibles(null);
                                                        numeroLibros--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        case "Revista":
                                            for (int i = 0; i < numeroRevistas; i++) {
                                                if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                        Tesis agregar = new Tesis(arregloRevista[i].getAutor(), arregloRevista[i].getTitulo(), jtPalabras.getText(), jtArea.getText(), arregloRevista[i].getTemas(), jtDescripcion.getText(), arregloRevista[i].getEdicion(), jtCopias.getText(), arregloRevista[i].getDisponibles());
                                                        arregloTesis[numeroTesis] = agregar;
                                                        numeroTesis++;
                                                        for (int j = i; j < numeroRevistas - 1; j++) {
                                                            arregloRevista[j].setAutor(arregloRevista[j + 1].getAutor());
                                                            arregloRevista[j].setTitulo(arregloRevista[j + 1].getTitulo());
                                                            arregloRevista[j].setPalabras_Clave(arregloRevista[j + 1].getPalabras_Clave());
                                                            arregloRevista[j].setFrecuencia_Actual(arregloRevista[j + 1].getFrecuencia_Actual());
                                                            arregloRevista[j].setEjemplar(arregloRevista[j + 1].getEjemplar());
                                                            arregloRevista[j].setTemas(arregloRevista[j + 1].getTemas());
                                                            arregloRevista[j].setDescripcion(arregloRevista[j + 1].getDescripcion());
                                                            arregloRevista[j].setEdicion(arregloRevista[j + 1].getEdicion());
                                                            arregloRevista[j].setCopias(arregloRevista[j + 1].getCopias());
                                                            arregloRevista[j].setDisponibles(arregloRevista[j + 1].getDisponibles());
                                                        }
                                                        arregloRevista[numeroRevistas - 1].setAutor(null);
                                                        arregloRevista[numeroRevistas - 1].setTitulo(null);
                                                        arregloRevista[numeroRevistas - 1].setPalabras_Clave(null);
                                                        arregloRevista[numeroRevistas - 1].setFrecuencia_Actual(null);
                                                        arregloRevista[numeroRevistas - 1].setEjemplar(null);
                                                        arregloRevista[numeroRevistas - 1].setTemas(null);
                                                        arregloRevista[numeroRevistas - 1].setDescripcion(null);
                                                        arregloRevista[numeroRevistas - 1].setEdicion(null);
                                                        arregloRevista[numeroRevistas - 1].setCopias(null);
                                                        arregloRevista[numeroRevistas - 1].setDisponibles(null);
                                                        numeroRevistas--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        default:
                                            break;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Llene campo adicional", "Error", JOptionPane.ERROR_MESSAGE);
                            jtArea.setText("");
                            jtFrecuencia.setText("");
                            jtFrecuencia.setVisible(false);
                            jlFrecuencia.setVisible(false);
                            jtEjemplar.setVisible(false);
                            jlEjemplar.setVisible(false);
                            jtEjemplar.setText("");
                            jtArea.setVisible(true);
                            jlArea.setVisible(true);
                        }
                        break;
                    case 2:
                        if (!jtCopias.getText().equals("") && !jtDescripcion.getText().equals("") && !jtPalabras.getText().equals("")) {
                            if (verificarNumero(jtCopias.getText())) {
                                switch (tipo) {
                                    case "Tesis":
                                        for (int i = 0; i < numeroTesis; i++) {
                                            if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                                if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                    Libro agregar = new Libro(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                    arregloLibro[numeroLibros] = agregar;
                                                    numeroLibros++;
                                                    for (int j = i; j < numeroTesis - 1; j++) {
                                                        arregloTesis[j].setAutor(arregloTesis[j + 1].getAutor());
                                                        arregloTesis[j].setTitulo(arregloTesis[j + 1].getTitulo());
                                                        arregloTesis[j].setPalabras_Clave(arregloTesis[j + 1].getPalabras_Clave());
                                                        arregloTesis[j].setArea(arregloTesis[j + 1].getArea());
                                                        arregloTesis[j].setTemas(arregloTesis[j + 1].getTemas());
                                                        arregloTesis[j].setDescripcion(arregloTesis[j + 1].getDescripcion());
                                                        arregloTesis[j].setEdicion(arregloTesis[j + 1].getEdicion());
                                                        arregloTesis[j].setCopias(arregloTesis[j + 1].getCopias());
                                                        arregloTesis[j].setDisponibles(arregloTesis[j + 1].getDisponibles());
                                                    }
                                                    arregloTesis[numeroTesis - 1].setAutor(null);
                                                    arregloTesis[numeroTesis - 1].setTitulo(null);
                                                    arregloTesis[numeroTesis - 1].setPalabras_Clave(null);
                                                    arregloTesis[numeroTesis - 1].setArea(null);
                                                    arregloTesis[numeroTesis - 1].setTemas(null);
                                                    arregloTesis[numeroTesis - 1].setDescripcion(null);
                                                    arregloTesis[numeroTesis - 1].setEdicion(null);
                                                    arregloTesis[numeroTesis - 1].setCopias(null);
                                                    arregloTesis[numeroTesis - 1].setDisponibles(null);
                                                    numeroTesis--;
                                                    //Se buscan los prestamos asociados
                                                    for (int j = 0; j < numeroPrestamos; j++) {
                                                        if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                            arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                        }
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                        this.dispose();
                                        inicializacionModificarBibliografia();
                                        break;
                                    case "Libros":
                                        for (int i = 0; i < numeroLibros; i++) {
                                            if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                                if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                    Libro agregar = new Libro(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                    arregloLibro[numeroLibros] = agregar;
                                                    numeroLibros++;
                                                    for (int j = i; j < numeroLibros - 1; j++) {
                                                        arregloLibro[j].setAutor(arregloLibro[j + 1].getAutor());
                                                        arregloLibro[j].setTitulo(arregloLibro[j + 1].getTitulo());
                                                        arregloLibro[j].setPalabras_Clave(arregloLibro[j + 1].getPalabras_Clave());
                                                        arregloLibro[j].setTemas(arregloLibro[j + 1].getTemas());
                                                        arregloLibro[j].setDescripcion(arregloLibro[j + 1].getDescripcion());
                                                        arregloLibro[j].setEdicion(arregloLibro[j + 1].getEdicion());
                                                        arregloLibro[j].setCopias(arregloLibro[j + 1].getCopias());
                                                        arregloLibro[j].setDisponibles(arregloLibro[j + 1].getDisponibles());
                                                    }
                                                    arregloLibro[numeroLibros - 1].setAutor(null);
                                                    arregloLibro[numeroLibros - 1].setTitulo(null);
                                                    arregloLibro[numeroLibros - 1].setPalabras_Clave(null);
                                                    arregloLibro[numeroLibros - 1].setTemas(null);
                                                    arregloLibro[numeroLibros - 1].setDescripcion(null);
                                                    arregloLibro[numeroLibros - 1].setEdicion(null);
                                                    arregloLibro[numeroLibros - 1].setCopias(null);
                                                    arregloLibro[numeroLibros - 1].setDisponibles(null);
                                                    numeroLibros--;
                                                    //Se buscan los prestamos asociados
                                                    for (int j = 0; j < numeroPrestamos; j++) {
                                                        if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                            arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                        }
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                        this.dispose();
                                        inicializacionModificarBibliografia();
                                        break;
                                    case "Revista":
                                        for (int i = 0; i < numeroRevistas; i++) {
                                            if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                                if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                    Libro agregar = new Libro(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                    arregloLibro[numeroLibros] = agregar;
                                                    numeroLibros++;
                                                    for (int j = i; j < numeroRevistas - 1; j++) {
                                                        arregloRevista[j].setAutor(arregloRevista[j + 1].getAutor());
                                                        arregloRevista[j].setTitulo(arregloRevista[j + 1].getTitulo());
                                                        arregloRevista[j].setPalabras_Clave(arregloRevista[j + 1].getPalabras_Clave());
                                                        arregloRevista[j].setFrecuencia_Actual(arregloRevista[j + 1].getFrecuencia_Actual());
                                                        arregloRevista[j].setEjemplar(arregloRevista[j + 1].getEjemplar());
                                                        arregloRevista[j].setTemas(arregloRevista[j + 1].getTemas());
                                                        arregloRevista[j].setDescripcion(arregloRevista[j + 1].getDescripcion());
                                                        arregloRevista[j].setEdicion(arregloRevista[j + 1].getEdicion());
                                                        arregloRevista[j].setCopias(arregloRevista[j + 1].getCopias());
                                                        arregloRevista[j].setDisponibles(arregloRevista[j + 1].getDisponibles());
                                                    }
                                                    arregloRevista[numeroRevistas - 1].setAutor(null);
                                                    arregloRevista[numeroRevistas - 1].setTitulo(null);
                                                    arregloRevista[numeroRevistas - 1].setPalabras_Clave(null);
                                                    arregloRevista[numeroRevistas - 1].setFrecuencia_Actual(null);
                                                    arregloRevista[numeroRevistas - 1].setEjemplar(null);
                                                    arregloRevista[numeroRevistas - 1].setTemas(null);
                                                    arregloRevista[numeroRevistas - 1].setDescripcion(null);
                                                    arregloRevista[numeroRevistas - 1].setEdicion(null);
                                                    arregloRevista[numeroRevistas - 1].setCopias(null);
                                                    arregloRevista[numeroRevistas - 1].setDisponibles(null);
                                                    numeroRevistas--;
                                                    //Se buscan los prestamos asociados
                                                    for (int j = 0; j < numeroPrestamos; j++) {
                                                        if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                            arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                        }
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                    break;
                                                }
                                            }
                                        }
                                        this.dispose();
                                        inicializacionModificarBibliografia();
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        jtArea.setText("");
                        jtFrecuencia.setText("");
                        jtFrecuencia.setVisible(false);
                        jlFrecuencia.setVisible(false);
                        jtEjemplar.setVisible(false);
                        jlEjemplar.setVisible(false);
                        jtEjemplar.setText("");
                        jtArea.setVisible(false);
                        jlArea.setVisible(false);
                        break;
                    case 3:
                        if (!jtFrecuencia.getText().isEmpty()) {
                            jtArea.setText("");
                            if (!jtCopias.getText().equals("") && !jtDescripcion.getText().equals("") && !jtPalabras.getText().equals("")) {
                                if (verificarNumero(jtCopias.getText())) {
                                    switch (tipo) {
                                        case "Tesis":
                                            for (int i = 0; i < numeroTesis; i++) {
                                                if (arregloTesis[i].getAutor().equals(autor) && arregloTesis[i].getTitulo().equals(titulo) && arregloTesis[i].getPalabras_Clave().equals(palabras) && arregloTesis[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                        Revista agregar = new Revista(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), jtFrecuencia.getText(), jtEjemplar.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                        arregloRevista[numeroRevistas] = agregar;
                                                        numeroRevistas++;
                                                        for (int j = i; j < numeroTesis - 1; j++) {
                                                            arregloTesis[j].setAutor(arregloTesis[j + 1].getAutor());
                                                            arregloTesis[j].setTitulo(arregloTesis[j + 1].getTitulo());
                                                            arregloTesis[j].setPalabras_Clave(arregloTesis[j + 1].getPalabras_Clave());
                                                            arregloTesis[j].setArea(arregloTesis[j + 1].getArea());
                                                            arregloTesis[j].setTemas(arregloTesis[j + 1].getTemas());
                                                            arregloTesis[j].setDescripcion(arregloTesis[j + 1].getDescripcion());
                                                            arregloTesis[j].setEdicion(arregloTesis[j + 1].getEdicion());
                                                            arregloTesis[j].setCopias(arregloTesis[j + 1].getCopias());
                                                            arregloTesis[j].setDisponibles(arregloTesis[j + 1].getDisponibles());
                                                        }
                                                        arregloTesis[numeroTesis - 1].setAutor(null);
                                                        arregloTesis[numeroTesis - 1].setTitulo(null);
                                                        arregloTesis[numeroTesis - 1].setPalabras_Clave(null);
                                                        arregloTesis[numeroTesis - 1].setArea(null);
                                                        arregloTesis[numeroTesis - 1].setTemas(null);
                                                        arregloTesis[numeroTesis - 1].setDescripcion(null);
                                                        arregloTesis[numeroTesis - 1].setEdicion(null);
                                                        arregloTesis[numeroTesis - 1].setCopias(null);
                                                        arregloTesis[numeroTesis - 1].setDisponibles(null);
                                                        numeroTesis--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        case "Libros":
                                            for (int i = 0; i < numeroLibros; i++) {
                                                if (arregloLibro[i].getAutor().equals(autor) && arregloLibro[i].getTitulo().equals(titulo) && arregloLibro[i].getPalabras_Clave().equals(palabras) && arregloLibro[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                        Revista agregar = new Revista(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), jtFrecuencia.getText(), jtEjemplar.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                        arregloRevista[numeroRevistas] = agregar;
                                                        numeroRevistas++;
                                                        for (int j = i; j < numeroLibros - 1; j++) {
                                                            arregloLibro[j].setAutor(arregloLibro[j + 1].getAutor());
                                                            arregloLibro[j].setTitulo(arregloLibro[j + 1].getTitulo());
                                                            arregloLibro[j].setPalabras_Clave(arregloLibro[j + 1].getPalabras_Clave());
                                                            arregloLibro[j].setTemas(arregloLibro[j + 1].getTemas());
                                                            arregloLibro[j].setDescripcion(arregloLibro[j + 1].getDescripcion());
                                                            arregloLibro[j].setEdicion(arregloLibro[j + 1].getEdicion());
                                                            arregloLibro[j].setCopias(arregloLibro[j + 1].getCopias());
                                                            arregloLibro[j].setDisponibles(arregloLibro[j + 1].getDisponibles());
                                                        }
                                                        arregloLibro[numeroLibros - 1].setAutor(null);
                                                        arregloLibro[numeroLibros - 1].setTitulo(null);
                                                        arregloLibro[numeroLibros - 1].setPalabras_Clave(null);
                                                        arregloLibro[numeroLibros - 1].setTemas(null);
                                                        arregloLibro[numeroLibros - 1].setDescripcion(null);
                                                        arregloLibro[numeroLibros - 1].setEdicion(null);
                                                        arregloLibro[numeroLibros - 1].setCopias(null);
                                                        arregloLibro[numeroLibros - 1].setDisponibles(null);
                                                        numeroLibros--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        case "Revista":
                                            for (int i = 0; i < numeroRevistas; i++) {
                                                if (arregloRevista[i].getAutor().equals(autor) && arregloRevista[i].getTitulo().equals(titulo) && arregloRevista[i].getPalabras_Clave().equals(palabras) && arregloRevista[i].getEdicion().equals(edicion)) {
                                                    if (Integer.parseInt(jtCopias.getText()) >= Integer.parseInt(arregloLibro[i].getDisponibles())) {
                                                        Revista agregar = new Revista(arregloTesis[i].getAutor(), arregloTesis[i].getTitulo(), jtPalabras.getText(), jtFrecuencia.getText(), jtEjemplar.getText(), arregloTesis[i].getTemas(), jtDescripcion.getText(), arregloTesis[i].getEdicion(), jtCopias.getText(), arregloTesis[i].getDisponibles());
                                                        arregloRevista[numeroRevistas] = agregar;
                                                        numeroRevistas++;
                                                        for (int j = i; j < numeroRevistas - 1; j++) {
                                                            arregloRevista[j].setAutor(arregloRevista[j + 1].getAutor());
                                                            arregloRevista[j].setTitulo(arregloRevista[j + 1].getTitulo());
                                                            arregloRevista[j].setPalabras_Clave(arregloRevista[j + 1].getPalabras_Clave());
                                                            arregloRevista[j].setFrecuencia_Actual(arregloRevista[j + 1].getFrecuencia_Actual());
                                                            arregloRevista[j].setEjemplar(arregloRevista[j + 1].getEjemplar());
                                                            arregloRevista[j].setTemas(arregloRevista[j + 1].getTemas());
                                                            arregloRevista[j].setDescripcion(arregloRevista[j + 1].getDescripcion());
                                                            arregloRevista[j].setEdicion(arregloRevista[j + 1].getEdicion());
                                                            arregloRevista[j].setCopias(arregloRevista[j + 1].getCopias());
                                                            arregloRevista[j].setDisponibles(arregloRevista[j + 1].getDisponibles());
                                                        }
                                                        arregloRevista[numeroRevistas - 1].setAutor(null);
                                                        arregloRevista[numeroRevistas - 1].setTitulo(null);
                                                        arregloRevista[numeroRevistas - 1].setPalabras_Clave(null);
                                                        arregloRevista[numeroRevistas - 1].setFrecuencia_Actual(null);
                                                        arregloRevista[numeroRevistas - 1].setEjemplar(null);
                                                        arregloRevista[numeroRevistas - 1].setTemas(null);
                                                        arregloRevista[numeroRevistas - 1].setDescripcion(null);
                                                        arregloRevista[numeroRevistas - 1].setEdicion(null);
                                                        arregloRevista[numeroRevistas - 1].setCopias(null);
                                                        arregloRevista[numeroRevistas - 1].setDisponibles(null);
                                                        numeroRevistas--;
                                                        //Se buscan los prestamos asociados
                                                        for (int j = 0; j < numeroPrestamos; j++) {
                                                            if (arregloPrestamo[j].getAutor().equals(autor) && arregloPrestamo[j].getTitulo().equals(titulo) && arregloPrestamo[j].getTipo().equals(tipo)) {
                                                                arregloPrestamo[j].setTipo((String) jcTipo.getSelectedItem());
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Bibliografia Modificada", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
                                                        break;
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Ingrese Copias Validas", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                    }
                                                }
                                            }
                                            this.dispose();
                                            inicializacionModificarBibliografia();
                                            break;
                                        default:
                                            break;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese Datos Correctos", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Llene campo adicional", "Error", JOptionPane.ERROR_MESSAGE);
                            jtArea.setText("");
                            jtFrecuencia.setText("");
                            jtFrecuencia.setVisible(true);
                            jlFrecuencia.setVisible(true);
                            jtEjemplar.setVisible(true);
                            jlEjemplar.setVisible(true);
                            jtEjemplar.setText("");
                            jtArea.setVisible(false);
                            jlArea.setVisible(false);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
