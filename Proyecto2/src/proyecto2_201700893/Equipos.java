package proyecto2_201700893;

import java.util.Date;

/**
 *
 * @author Eleazar  Jared López Osuna
 */
public class Equipos {
    private String name;
    private Date date;
    private int cod,mundiales;
    
    public Equipos(int cod,String name,Date date,int mundiales){
        this.cod = cod;
        this.name = name;
        this.date = date;
        this.mundiales = mundiales;
    }
    
    public int getCod(){
        return cod;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    
    public int getMundiales(){
        return mundiales;
    }
    public void setMundiales(int mundiales){
        this.mundiales = mundiales;
    }
}
