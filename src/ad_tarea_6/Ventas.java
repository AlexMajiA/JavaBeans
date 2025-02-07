/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import java.io.Serializable;

/**
 *
 * @author amjpa
 */
public class Ventas implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    //Atributos
    private int idVenta;
    private String matricula;
    
    //Getter y Setter
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        
        if (!matricula.equals(matricula)) {
            //lanza envento con firepropertychange, y dirá que está vendido.
            //Envia las dos matriculas, antigua y nueva.
            this.matricula = matricula;
        }else {
            //no se envía este evento.
        }
        
        
        
    }
    
    //propertySupport.firePropertyChange().
    
    public static void main(String[] args) {
     
     
  
        //Venta debe tener un atributo PropertyChangeSupport y usar en el método setMatricula() propertySupport.firePropertyChange().

        
        
        
    }
    
}
