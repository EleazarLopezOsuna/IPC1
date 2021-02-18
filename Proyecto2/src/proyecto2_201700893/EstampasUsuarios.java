/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201700893;

/**
 *
 * @author USER
 */
public class EstampasUsuarios {
    private int cod_usuario, cod_estampa, pegada, cantidad;
    
    public EstampasUsuarios(int cod_usuario, int cod_estampa, int pegada, int cantidad){
        this.cod_usuario = cod_usuario;
        this.cod_estampa = cod_estampa;
        this.pegada = pegada;
        this.cantidad = cantidad;
    }
    
    public int getCodUsuario(){
        return cod_usuario;
    }
    public void setCodUsuario(int cod_usuario){
        this.cod_usuario = cod_usuario;
    }
    
    public int getCodEstampa(){
        return cod_estampa;
    }
    public void setCodEstampa(int cod_estampa){
        this.cod_estampa = cod_estampa;
    }
    
    public int getPegada(){
        return pegada;
    }
    public void setPegada(int pegada){
        this.pegada = pegada;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
}
