/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class ServicioVisitasGuiadas extends ServicioIncluido {
    private String nombreGuia; 
    private double tiempoVisita;
    private String horaInicio;

    public ServicioVisitasGuiadas(String nombreGuia, double tiempoVisita, String horaInicio, String descripcion, double precioBase) {
        super(descripcion, "Visita Guiada", precioBase);
        this.nombreGuia = nombreGuia;
        this.tiempoVisita = tiempoVisita;
        this.horaInicio = horaInicio;
    }

    public String getNombreGuia() {
        return nombreGuia;
    }

    public void setNombreGuia(String nombreGuia) {
        this.nombreGuia = nombreGuia;
    }

    public double getTiempoVisita() {
        return tiempoVisita;
    }

    public void setTiempoVisita(double tiempoVisita) {
        this.tiempoVisita = tiempoVisita;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String obtenerDetalleServicio() {
        return "[VISITA GUIADA] " + 
                "- Nombre del guía: " + nombreGuia + 
                " - Tiempo de visita: " + tiempoVisita + " min" + 
                " - Hora de inicio: " + horaInicio + 
                " - Precio del servicio : S/" + calcularPrecioFinal() +
                " (" + descripcion + ")";
    }

    public double precioGuia(double tiempoVisita){
        if (tiempoVisita <= 60) {
            return 20.5;
        }else if(tiempoVisita <= 90 ){
            return 40;
        }else if(tiempoVisita > 90){
            return 50.5;
        }  
        return 0;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase + precioGuia(tiempoVisita);
    }
}