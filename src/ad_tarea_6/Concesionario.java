/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBAuthenticationRuntimeException;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author amjpa
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    
    //Atributos
    private String pathBDOO;
    private String username;
    private String password;
    
    
    public Concesionario() {
        password = "bdproductos.neodatis";
        username = "foc";
        password = "fomento";
    }
    
    public ODB conectarBD(){
     ODB odb = null;
        try {
           ODBFactory.open(pathBDOO, username, password);
            
        } catch (ODBAuthenticationRuntimeException e) {
            if (odb != null && odb.isClosed()) {
                odb.close();
            }
            e.getMessage();
        }
        return odb;
    }
    
    
     public void crearConcesionario(){
        
    }
    
    
    public static void main(String[] args) {
        
    }
    
}
