/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

/**
 *
 * @author amjpa
 */
public class Main {

    /**
     * deberá usar el método addPropertyChangeListener() del fuente con el receptor, para conectar fuente con receptor.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Coche car1 = new Coche("123", "Seat", "Leon", 20000, false);
        Coche car2 = new Coche("456", "Ford", "Fiesta", 18000, false);
        Coche car3 = new Coche("789", "Renault", "Clio", 16000, false);
        Coche car4 = new Coche("321", "Fiat", "Multipla", 17000, false);
        
        
        Ventas venta = new Ventas();
        
        //Asignación de matricula.
        //venta.setMatricula(car1.getMatricula());
        
        //La venta del vehiculo se apunta a la lista de listener
        venta.addPropertyChangeListener(car1);
        venta.addPropertyChangeListener(car2);
        venta.addPropertyChangeListener(car3);
        venta.addPropertyChangeListener(car4);
        
        //Comprobamos si la venta se ha modificado al cambiar la propiedad ligada.
        System.out.println("Iniciando la venta.");
        venta.setMatricula("123");  
    }
    
}
