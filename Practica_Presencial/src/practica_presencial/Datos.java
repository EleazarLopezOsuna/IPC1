/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_presencial;

/**
 *
 * @author USER
 */
public class Datos {
    private String nombre, apellido, sexo;
    private int edad;
    
    /**
     * Constructor de Datos.
     *
     * @param nombre
     * @param apellido
     * @param edad
     * @param sexo
     */
    public Datos(String nombre, String apellido, String sexo, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getApellido(){
        return this.apellido;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public String getSexo(){
        return this.sexo;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    public int getEdad(){
        return this.edad;
    }
}
