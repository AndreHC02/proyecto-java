/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public abstract class Promocion implements IDescuento{
    private String codigoPromo;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;

    public Promocion(String codigoPromo, String nombre, String fechaInicio, String fechaFin) {
        this.codigoPromo = codigoPromo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getCodigoPromo() {
        return codigoPromo;
    }

    public void setCodigoPromo(String codigoPromo) {
        this.codigoPromo = codigoPromo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public abstract double calcularDescuento(double monto);
}
