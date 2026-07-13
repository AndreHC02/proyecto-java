/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class ServicioVuelo extends ServicioIncluido {
    private String aerolinea;
    private String numeroVuelo;
    private String clase; 

    public ServicioVuelo(String aerolinea, String numeroVuelo, String clase, String descripcion, double precioBase) {
        super(descripcion, "Vuelo", precioBase);
        this.aerolinea = aerolinea;
        this.numeroVuelo = numeroVuelo;
        this.clase = clase;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String obtenerDetalleServicio() {
        return "[VUELO] " + descripcion + 
                " - Aerolínea: " + aerolinea + 
                " (Vuelo #" + numeroVuelo + ")";
    }

    public double precioClase(String clase){
        String claseLimpia = clase.trim();
        if (claseLimpia.equals("primera")) {
            return 120;
        }else if (claseLimpia.equals("ejecutiva")) {
            return 80; 
        }else if (claseLimpia.equals("economica")) {
            return 0; 
        }
        return 0;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase + precioClase(clase); 
    }
}