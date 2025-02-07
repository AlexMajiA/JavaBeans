/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *PropertyChangeListener y tener un método propertyChange() donde reciba el evento y haga lo que debe hacer en ese caso.
 * @author amjpa
 */
public class Coche implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private float precio;
    private boolean vendido;
    private PropertyChangeSupport propertySupport;
    

    public Coche() {
        
        //Inicializamos el objeto que permite lanzar eventos
        propertySupport = new PropertyChangeSupport(this);
    }

    public Coche(String matricula, String marca, String modelo, float precio, boolean vendido) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.vendido = vendido;
        propertySupport = new PropertyChangeSupport(this);
    }
    
    //Añadir un objeto a la lista de escuchadores de los eventos de esta clase
    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertySupport.addPropertyChangeListener(listener);
    }
    
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
