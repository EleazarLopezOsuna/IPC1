package proyecto2_201700893;

/**
 *
 * @author Eleazar Jared López Osuna
 */
public class Usuarios {
     private String name,lastname,password;
     private int cod;
    
    public Usuarios(int cod,String name,String lastname,String password){
        this.cod = cod;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
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
    
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
