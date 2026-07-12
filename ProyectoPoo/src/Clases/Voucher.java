/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class Voucher {
     private String numeroVoucher;
    private Reserva reserva;

    public Voucher(String numeroVoucher, Reserva reserva) {
        this.numeroVoucher = numeroVoucher;
        this.reserva = reserva;
    }

    public String getNumeroVoucher() { return numeroVoucher; }
    public void setNumeroVoucher(String numeroVoucher) { this.numeroVoucher = numeroVoucher; }

    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    public String generarVoucher() {
        if (!reserva.getEstado().equals("Confirmada")) {
            return "No se puede generar el voucher: la reserva no está confirmada.";
        }

        String texto = "========== VOUCHER DE RESERVA ==========\n";
        texto += "N° Voucher: " + numeroVoucher + "\n";
        texto += "Código de Reserva: " + reserva.getCodigoReserva() + "\n";
        texto += "Paquete: " + reserva.getPaquete().getNombre() + "\n";
        texto += "Fecha de la reserva: " + reserva.getFechaReserva() + "\n";
        texto += "Pasajeros adultos: " + reserva.getCantidadAdultos() + "\n";
        texto += "Pasajeros menores: " + reserva.getCantidadMenores() + "\n";

        texto += "Clientes:\n";
        Cliente[] clientes = reserva.getClientes();
        for (int i = 0; i < reserva.getCantidadClientes(); i++) {
            texto += "  - " + clientes[i].getNombres() + " " + clientes[i].getApellidos() + "\n";
        }

        double totalPagado = 0;
        Pago[] pagos = reserva.getPagos();
        for (int i = 0; i < reserva.getCantidadPagos(); i++) {
            totalPagado += pagos[i].getMonto();
        }

        texto += "Precio total: S/ " + reserva.getPrecioTotal() + "\n";
        texto += "Monto abonado: S/ " + totalPagado + "\n";
        texto += "Saldo pendiente: S/ " + reserva.calcularSaldoPendiente() + "\n";
        texto += "=========================================";

        return texto;
    }

    public void mostrarVoucher() {
        imprimir(generarVoucher());
    }
    public static void imprimir(String cadena){
        System.out.println(cadena);
    }
}
