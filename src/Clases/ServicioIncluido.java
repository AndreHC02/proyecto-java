/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public abstract class ServicioIncluido {
    protected String descripcion; 
    protected String tipoServicio; 
    protected double precioBase; 

    public ServicioIncluido(String descripcion, String tipoServicio, double precioBase) {
        this.descripcion = descripcion;
        this.tipoServicio = tipoServicio;
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract String obtenerDetalleServicio();
    public abstract double calcularPrecioFinal();
}