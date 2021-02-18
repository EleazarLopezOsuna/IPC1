/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumaprimos;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class SumaPrimos { 
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static int numero2, numero4;
    static long numero3;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String a;
        int b;
        do {
            System.out.println("Seleccione una Opcion");
            System.out.println("1.- Ejercicio 1");
            System.out.println("2.- Ejercicio 2");
            System.out.println("3.- Ejercicio 3");
            System.out.println("4.- Ejercicio 4");
            System.out.println("5.- Salir");
            a = br.readLine();
            b = Integer.parseInt(a);
            switch(b){
                case 1:
                    System.out.println("Usted Selecciono Ejercicio 1");
                    String resultado1 = ordenar();
                    System.out.println("El orden es "+resultado1);
                    break;
                case 2:
                    System.out.println("Usted Selecciono Ejercicio 2");
                    int resultado2 = par();
                    System.out.println("El resultado de operar el numero "+numero2+" es "+resultado2);
                    break;
                case 3:
                    System.out.println("Usted Selecciono Ejercicio 3");
                    String resultado3 = capicua();
                    System.out.println("El numero "+numero3+" "+resultado3);
                    break;
                case 4:
                    System.out.println("Usted Selecciono Ejercicio 4");
                    int resultado4 = ingreso();
                    System.out.println("El resultado de sumar los primeros "+numero4+" numeros primos es "+resultado4);
                    break;
                case 5:
                    System.out.println("Usted Slecciono Salir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error");
                    SumaPrimos.main(null);
                    break;
            }
        } while (true);
    }
    public static String ordenar() throws IOException{//Usado para el Ejercicio 1
        System.out.println("Ingrese el Primer Numero");
        String a = br.readLine();
        System.out.println("Ingrese el Segundo Numero");
        String b = br.readLine();
        System.out.println("Ingrese el Tercer Numero");
        String c = br.readLine();
        String resultado = "";
        if (decimal(a)&&decimal(b)&&decimal(c)) {
            double uno = Double.parseDouble(a);
            double dos = Double.parseDouble(b);
            double tres = Double.parseDouble(c);
            if (uno >= dos && dos >= tres) {
                resultado = "El orden es "+uno+" "+dos+" "+tres+" ";
            }else if (uno >= tres && tres >= dos) {
                resultado = "El orden es "+uno+" "+tres+" "+dos+" ";
            }else if (dos >= uno && uno >= tres) {
                resultado = "El orden es "+dos+" "+uno+" "+tres+" ";
            }else if (dos >= dos && dos >= tres) {
                resultado = "El orden es "+dos+" "+tres+" "+uno+" ";
            }else if (tres >= uno && uno >= dos) {
                resultado = "El orden es "+tres+" "+uno+" "+dos+" ";
            }else{
                resultado = "El orden es "+tres+" "+dos+" "+uno+" ";
            }
        }else{
            System.out.println("Ingrese Numeros Validos");
            System.out.println("-----------------------");
            SumaPrimos.ordenar();
        }
        return resultado;
    }
    public static int par() throws IOException{//Usado para el Ejercicio 2
        System.out.println("Ingrese un Numero Entero");
        String a = br.readLine();
        int resultado = 0;
        if (numero(a)) {
            numero2 = Integer.parseInt(a);
            if (numero2%1==0) {
                if (numero2%2==0) {
                    resultado = numero2*2;
                }else{
                    resultado = numero2*3;
                }
            }else{
                System.out.println("Ingrese Un Numero Valido");
                System.out.println("------------------------");
                SumaPrimos.par();
            }
        }else{
            System.out.println("Ingrese Un Numero Valido");
            System.out.println("------------------------");
            SumaPrimos.par();
        }
        return resultado;
    }
    private static boolean numero(String cadena){//Usado para el Ejercicio 2 y 3
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    private static boolean decimal(String cadena){//Usado para el Ejercicio 1
        try {
            Double.parseDouble(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    public static String capicua() throws IOException{//Usado para el Ejercicio 3
        System.out.println("Ingrese Un Numero");
        String a = br.readLine();
        String resultado="";
        if (numero(a)) {
            numero3 = Long.parseLong(a);
            long b = numero3 , c = 0, d = 0;
            do {
                d = b%10;
                b = b/10;
                c = (c*10)+d;
            } while (b!=0);
            if (numero3==c) {
                resultado = "Es Capicua";
            }else{
                resultado = "No es Capicua";
            }
        }else{
            System.out.println("Ingrese un Numero Valido");
            System.out.println("------------------------");
            SumaPrimos.capicua();
        }
        return resultado;
    }
    public static int ingreso() throws IOException{ //Usado para el Ejercicio 4
        System.out.println("Ingrese Un Numero Entero Positivo");
        String a = br.readLine();
        int mostrar=0;
        if (SumaPrimos.isNumeric(a)) {
            numero4 = Integer.parseInt(a);
            mostrar = primo(numero4);
        }else{
            SumaPrimos.ingreso();
        }
        return mostrar;
    }
    public static int primo(int m) throws IOException{ //Usado para el Ejercicio 4
        int n = 1, k = 0, suma = 0;
        boolean verificar = true;
        do {
            while(k!=m){
                n++;
                int contador = 0;
                for (int i = 1; i <= n; i++) {
                    if (n%i==0) {
                        contador++;
                    }
                }
                if (contador <= 2) {
                    k++;
                    suma = suma + n;
                }
            }
            verificar = false;
            return suma;
        } while (true);
    }
    private static boolean isNumeric(String cadena){//Usado para el Ejercicio 4
	try {
            int a;
            a = Integer.parseInt(cadena);
            if (a%1 == 0) {
                if (a>=0) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
