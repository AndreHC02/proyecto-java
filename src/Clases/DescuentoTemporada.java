/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class DescuentoTemporada extends Promocion {
    private String temporada;

    public DescuentoTemporada(String temporada, String codigoPromo, String nombre, String fechaInicio, String fechaFin) {
        super(codigoPromo, nombre, fechaInicio, fechaFin);
        this.temporada = temporada;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public double calcularDescuento(double monto) {
        double porcentaje;
        switch (temporada.toLowerCase()) {
            case "baja": porcentaje = 20.0; break;
            case "media": porcentaje = 10.0; break;
            case "alta": porcentaje = 0.0; break;
            default: porcentaje = 5.0;
        }
        return monto* (porcentaje/100);
    }
    
}
