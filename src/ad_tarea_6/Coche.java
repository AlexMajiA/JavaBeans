/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_tarea_6;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 *PropertyChangeListener y tener un método propertyChange() donde reciba el evento y haga lo que debe hacer en ese caso.
 * @author amjpa
 */
public class Coche implements Serializable, PropertyChangeListener {

    /**
     * @param args the command line arguments
     */
    
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private float precio;
    private boolean vendido;
    
    

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, float precio, boolean vendido) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.vendido = vendido;
    }
    
    //Este método saltará automáticamente, cuando un evento sea escuchado por el listener de este objeto.
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        //Solo se activa si el evento es el cambio de matrícula.
        if ("Coche vendido".equals(evt.getPropertyName())) {

            String matriculaVendida = (String) evt.getNewValue();

            if (this.matricula.equals(evt.getNewValue())) {
                System.out.println("Matricula coche vendido: " + evt.getNewValue());
                System.out.println("Marca: " + this.marca);
                System.out.println("Modelo: " + this.modelo);
                System.out.println("Precio: " + this.precio);

                //Pongo vendido a true para confirmar que está vendido.
                this.setVendido(true);
            }

        }
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
