/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class DescuentoPorcentaje extends Promocion {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje, String codigoPromo, String nombre, String fechaInicio, String fechaFin) {
        super(codigoPromo, nombre, fechaInicio, fechaFin);
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double monto) {
        return monto *(porcentaje/100);
    }
    
}
