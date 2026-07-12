/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class ServicioHotel extends ServicioIncluido {
    private String nombreHotel;
    private int estrellas;
    private String tipoHabitacion;

    public ServicioHotel(double precioBase, String descripcion, String nombreHotel, int estrellas, String tipoHabitacion) {
        super(descripcion, "Hotel", precioBase);
        this.nombreHotel = nombreHotel;
        this.estrellas = estrellas;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String obtenerDetalleServicio() {
        return "[HOTEL " + estrellas + "★] " + nombreHotel + 
                " - Habitación: " + tipoHabitacion + 
                " - Precio del Servicio: S/" + calcularPrecioFinal()  +
                " (" + descripcion + ")";
    }

    public double precioHabitacion(String tipoHabitacion){
        String habLimpia = tipoHabitacion.trim();
        if (habLimpia.equals("Standard")) {
            return 50; 
        }if (habLimpia.equals("Deluxe")) {
            return 70; 
        }if (habLimpia.equals("Suite")) {
           return 100; 
        }
        return 0;
     }

    @Override
    public double calcularPrecioFinal() {
        return precioBase + precioHabitacion(tipoHabitacion);
    }
}