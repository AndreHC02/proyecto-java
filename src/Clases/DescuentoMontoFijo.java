/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class DescuentoMontoFijo extends Promocion {
    private double monto;

    public DescuentoMontoFijo(double monto, String codigoPromo, String nombre, String fechaInicio, String fechaFin) {
        super(codigoPromo, nombre, fechaInicio, fechaFin);
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public double calcularDescuento(double montoTotal) {
        return Math.min(monto, montoTotal);
    }
    
}
