/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Venta debe tener un atributo PropertyChangeSupport y usar en el método
 * setMatricula() propertySupport.firePropertyChange().
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
    private PropertyChangeSupport propertySupport;

    public Ventas() {
        //Inicializamos el objeto que permite lanzar eventos
        propertySupport = new PropertyChangeSupport(this);
    }

    public Ventas(int idVenta, String matricula, PropertyChangeSupport propertySupport) {
        this.idVenta = idVenta;
        this.matricula = matricula;
        this.propertySupport = propertySupport;
        propertySupport = new PropertyChangeSupport(this);
    }

    //Añadir un objeto a la lista de escuchadores de los eventos de esta clase
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    //Elimina un objeto a la lista de escuchadores de los eventos de esta clase
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

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
        Coche car = new Coche();

        //Almaceno la matricula antigua
        String oldLicensePlate = this.matricula;

        //Actualizo la matricula nueva
        this.matricula = matricula;

        //Quermos que se envíe el evento solo cuando el coche está vendido y tiene la misma matrícula.
        if (oldLicensePlate == null || !oldLicensePlate.equals(matricula)){
            System.out.println("Vehículo vendido");
            //Enviamos el evento a quien lo escuche
            propertySupport.firePropertyChange("Coche vendido", oldLicensePlate, matricula);
        }
    }

   
    
    public static void main(String[] args) {
        
    }
    
}
