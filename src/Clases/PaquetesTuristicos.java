/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class PaquetesTuristicos {
    private String idCodigo;
    private String nombre; 
    private int ddias; 
    private int dnoches; 
    private String tipo; 
    private double precioPorPersona;
    private String fechaSalida;
    private String fechaRetorno; 
    private int cantidadMaxPersonas;
    private String estado;
    private int cupoDisponible;
    private DestinosTuristicos[] destinosIncluidos;
    private ServicioIncluido[] serviciosIncluidos;
    private int contadorDestinos;
    private int contadorServicios;
    private String[] itinerarioDias;

    public PaquetesTuristicos(String idCodigo, String nombre, int ddias, int dnoches, String tipo, double precioPorPersona, String fechaSalida, String fechaRetorno, int cantidadMaxPersonas, String estado) {
        this.idCodigo = idCodigo;
        this.nombre = nombre;
        this.ddias = ddias;
        this.dnoches = dnoches;
        this.tipo = tipo;
        this.precioPorPersona = precioPorPersona;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.estado = estado;
        this.cupoDisponible = cantidadMaxPersonas;
        destinosIncluidos = new DestinosTuristicos[20];
        serviciosIncluidos = new ServicioIncluido[20];
        contadorDestinos = 0;
        contadorServicios = 0;
        itinerarioDias = new String[ddias];
    }

    public String getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDdias() {
        return ddias;
    }

    public void setDdias(int ddias) {
        this.ddias = ddias;
    }

    public int getDnoches() {
        return dnoches;
    }

    public void setDnoches(int dnoches) {
        this.dnoches = dnoches;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPorPersona() {
        return precioPorPersona;
    }

    public void setPrecioPorPersona(double precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }

    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public DestinosTuristicos[] getDestinosIncluidos() {
        return destinosIncluidos;
    }

    public void setDestinosIncluidos(DestinosTuristicos[] destinosIncluidos) {
        this.destinosIncluidos = destinosIncluidos;
    }

    public ServicioIncluido[] getServiciosIncluidos() {
        return serviciosIncluidos;
    }

    public void setServiciosIncluidos(ServicioIncluido[] serviciosIncluidos) {
        this.serviciosIncluidos = serviciosIncluidos;
    }

    public int getContadorDestinos() {
        return contadorDestinos;
    }

    public void setContadorDestinos(int contadorDestinos) {
        this.contadorDestinos = contadorDestinos;
    }

    public int getContadorServicios() {
        return contadorServicios;
    }

    public void setContadorServicios(int contadorServicios) {
        this.contadorServicios = contadorServicios;
    }

    public String[] getItinerarioDias() {
        return itinerarioDias;
    }

    public void setItinerarioDias(String[] itinerarioDias) {
        this.itinerarioDias = itinerarioDias;
    }
    
    public void agregarDestino(DestinosTuristicos destino) {
        if (contadorDestinos < destinosIncluidos.length) {
            destinosIncluidos[contadorDestinos] = destino;
            contadorDestinos++;
        } else {
            System.out.println("Límite de destinos alcanzado.");
        }
    }

    public void agregarServicio(ServicioIncluido servicio) {
        if (contadorServicios < serviciosIncluidos.length) {
            serviciosIncluidos[contadorServicios] = servicio;
            contadorServicios++;
        } else {
            System.out.println("Límite de servicios alcanzado.");
        }
    }
    public void registrarActividadDia(int numeroDia, String descripcionActividad) {
        if (numeroDia >= 1 && numeroDia <= this.ddias) {
            this.itinerarioDias[numeroDia - 1] = descripcionActividad;
        } else {
            System.out.println("Error: Ese día no existe en la duración de este paquete turístico.");
        }
    }
    public String obtenerItinerarioCompleto() {
        String completo = "--- ITINERARIO DE VIAJE ---\n";
        for (int i = 0; i < itinerarioDias.length; i++) {
            String actividad = itinerarioDias[i];
            if (actividad == null || actividad.trim().isEmpty()) {
                actividad = "Sin actividad registrada aún.";
            }
            completo = completo + "Día " + (i + 1) + ": " + actividad + "\n";
        }
        return completo;
}
}