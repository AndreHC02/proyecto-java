/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class Reserva {
    private String codigoReserva;
    private String fechaReserva;
    private Cliente[] clientes;
    private int cantidadClientes;
    private PaqueteTuristico paquete;
    private int cantidadAdultos;
    private int cantidadMenores;
    private double precioTotal;
    private String estado;
    
    private Pago[] pagos;
    private int cantidadPagos;
    private Promocion promocionAplicada;

    public Reserva(String codigoReserva, String fechaReserva, PaqueteTuristico paquete, int cantidadAdultos, int cantidadMenores) {
        this.codigoReserva = codigoReserva;
        this.fechaReserva = fechaReserva;
        this.paquete = paquete;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadMenores = cantidadMenores;
        this.estado = "Pendiente";
        
        this.clientes = new Cliente[10];
        this.cantidadClientes = 0;
        
        this.pagos = new Pago[10];
        this.cantidadPagos = 0;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public void setCantidadClientes(int cantidadClientes) {
        this.cantidadClientes = cantidadClientes;
    }

    public int getCantidadPagos() {
        return cantidadPagos;
    }

    public void setCantidadPagos(int cantidadPagos) {
        this.cantidadPagos = cantidadPagos;
    }
    

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public int getCantidadMenores() {
        return cantidadMenores;
    }

    public void setCantidadMenores(int cantidadMenores) {
        this.cantidadMenores = cantidadMenores;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pago[] getPagos() {
        return pagos;
    }

    public void setPagos(Pago[] pagos) {
        this.pagos = pagos;
    }

    public Promocion getPromocionAplicada() {
        return promocionAplicada;
    }

    public void setPromocionAplicada(Promocion promocionAplicada) {
        this.promocionAplicada = promocionAplicada;
    }
    public boolean agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
            return true;
        }
        return false;
    }
    public boolean registrarPago(Pago pago) {
        if (cantidadPagos < pagos.length) {
            pagos[cantidadPagos] = pago;
            cantidadPagos++;
            return true;
        }
        return false;
    }
    public double calcularTotal() {
        double precioAdultos = paquete.getPrecioPersonas() * cantidadAdultos;
        double precioMenores = paquete.getPrecioPersonas() * cantidadMenores * 0.5;
        double total = precioAdultos + precioMenores;

        if (promocionAplicada != null) {
            total -= promocionAplicada.calcularDescuento(total);
        }

        this.precioTotal = total;
        return precioTotal;
    }
    public boolean confirmarReserva() {
        double totalPagado = 0;
        for (int i = 0; i < cantidadPagos; i++) {
            totalPagado += pagos[i].getMonto();
        }

        double pagoMinimo = precioTotal * 0.30; // 30% mínimo requerido

        if (totalPagado >= pagoMinimo && precioTotal > 0) {
            this.estado = "Confirmada";
            paquete.actualizarCupo(cantidadAdultos + cantidadMenores);
            return true;
        }
        return false;
    }
     public void cancelarReserva() {
        this.estado = "Cancelada";
    }
      public double calcularSaldoPendiente() {
        double totalPagado = 0;
        for (int i = 0; i < cantidadPagos; i++) {
            totalPagado += pagos[i].getMonto();
        }
        return precioTotal - totalPagado;
    }
}
