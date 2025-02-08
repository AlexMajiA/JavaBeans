/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBAuthenticationRuntimeException;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

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
        pathBDOO = "bdproductos.neodatis";
        username = "foc";
        password = "fomento";
    }
    
    public ODB conectarBD(){
     ODB odb = null;
        try {
        odb = ODBFactory.open(pathBDOO, username, password);  //Asignamos la conexión a odb
            
        } catch (ODBAuthenticationRuntimeException e) {
            if (odb != null && odb.isClosed()) {
                odb.close();
            }
            System.out.println("Error de autenticación: " + e.getMessage());
        }
        return odb;
    }
    
    
     public void crearConcesionario(){
        ODB odb = conectarBD();
         
         //Verifica si ya hay coches en la base de datos
         Objects<Coche> coches = odb.getObjects(Coche.class);
         if (coches.hasNext()) {
             System.out.println("El concesionario ya está creado. No se añadirán más coches.");
             odb.close();
             return;
         }
         
         //Creo los coches
        Coche car1 = new Coche("123", "Seat", "Leon", 20000, false);
        Coche car2 = new Coche("456", "Ford", "Fiesta", 18000, false);
        Coche car3 = new Coche("789", "Renault", "Clio", 16000, false);
        Coche car4 = new Coche("321", "Fiat", "Multipla", 17000, false);
        
        //Guardo los coches en la BD
        odb.store(car1);
        odb.store(car2);
        odb.store(car3);
        odb.store(car4);
        
        try {
            // Crear y almacenar coches...
            System.out.println("Concesionario creado y coches añadidos.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar la conexión a la base de datos
            if (odb != null) {
                odb.close();
            }
        }
    }
    
    public static void main(String[] args) {
        
       Concesionario cs = new Concesionario();
       
        //Crea la BD del concesionario si no existe.
        cs.crearConcesionario();
        
       //Conectamos con la base de datos concesionario.
       ODB odb = cs.conectarBD();
         if (odb == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }
        
       //Buscamos un coche por su matrícula en la BD.
        String matricula = "456";
        
        Objects<Coche> coches = odb.getObjects(new CriteriaQuery(Coche.class, Where.equal("matricula", matricula)));
        
        if (coches.isEmpty()) {
            System.out.println("No se encontró un coche con la matrícula " + matricula);
            odb.close();
            return;
        }

        Coche coche = coches.getFirst();
        System.out.println("Coche encontrado: " + coche);
       
        // Crear PropertyChangeSupport para gestionar eventos
        PropertyChangeSupport propertySupport = new PropertyChangeSupport(new Object());


       // Crear la venta y asociarla al coche
        Ventas venta = new Ventas(1, coche.getMatricula(), propertySupport);
             
        // Conectar fuente (Ventas) con receptor (Coche)
        venta.addPropertyChangeListener((PropertyChangeListener) coche);
        
        // Marcar el coche como vendido
        coche.setVendido(true);
        // Guardar coche actualizado en la BD
        odb.store(coche);
        
        System.out.println("El coche " + coche.getMatricula() + " ha sido vendido.");

        odb.close();
   
    }
    
}
     