/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class PaqueteTuristico {
    private String codigo;
    private String nombre;
    private double precioPersonas;
    private int cupoDisponible;

    public PaqueteTuristico(String codigo, String nombre, double precioPersonas, int cupoDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioPersonas = precioPersonas;
        this.cupoDisponible = cupoDisponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCoidgo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPersonas() {
        return precioPersonas;
    }

    public void setPrecioPersonas(double precioPersonas) {
        this.precioPersonas = precioPersonas;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }
    public void actualizarCupo(int cantidad){
        cupoDisponible -=cantidad;
    }

    
}
