/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;

/**
 *
 * @author jahzeelp
 */
public class Reporte {
    public void reporteReservas(Reserva[] reservas, int cantidadReservas,
                                 String codigoPaquete, String fechaInicio, String fechaFin) {
        imprimir("---- Reporte de Reservas ----");
        for (int i = 0; i < cantidadReservas; i++) {
            Reserva r = reservas[i];
            boolean coincidePaquete = (codigoPaquete == null) || r.getPaquete().getCodigo().equals(codigoPaquete);
            boolean dentroDeRango = r.getFechaReserva().compareTo(fechaInicio) >= 0
                                  && r.getFechaReserva().compareTo(fechaFin) <= 0;

            if (coincidePaquete && dentroDeRango) {
                imprimir(r.getCodigoReserva() + " - " + r.getPaquete().getNombre()
                        + " - " + r.getFechaReserva() + " - " + r.getEstado());
            }
        }
    }

    public void reporteDestinosMasSolicitados(Reserva[] reservas, int cantidadReservas) {
        String[] nombresDestinos = new String[cantidadReservas];
        int[] conteos = new int[cantidadReservas];
        int totalDestinosUnicos = 0;

        for (int i = 0; i < cantidadReservas; i++) {
            String nombre = reservas[i].getPaquete().getNombre();
            boolean encontrado = false;

            for (int j = 0; j < totalDestinosUnicos; j++) {
                if (nombresDestinos[j].equals(nombre)) {
                    conteos[j]++;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                nombresDestinos[totalDestinosUnicos] = nombre;
                conteos[totalDestinosUnicos] = 1;
                totalDestinosUnicos++;
            }
        }

        imprimir("---- Destinos más solicitados ----");
        for (int i = 0; i < totalDestinosUnicos; i++) {
            imprimir(nombresDestinos[i] + ": " + conteos[i] + " reserva(s)");
        }
    }

    public void reporteIngresosAsesor(Reserva[] reservas, int cantidadReservas) {
        double totalIngresos = 0;

        for (int i = 0; i < cantidadReservas; i++) {
            if (reservas[i].getEstado().equals("Confirmada")) {
                totalIngresos += reservas[i].getPrecioTotal();
            }
        }

        imprimir("---- Ingresos Totales Confirmados ----");
        imprimir("S/ " + totalIngresos);
    }

    public void reportePendientesPago(Reserva[] reservas, int cantidadReservas) {
        imprimir("---- Reservas con Saldo Pendiente ----");
        for (int i = 0; i < cantidadReservas; i++) {
            Reserva r = reservas[i];
            if (!r.getEstado().equals("Cancelada") && r.calcularSaldoPendiente() > 0) {
                imprimir(r.getCodigoReserva() + " - Saldo pendiente: S/ "
                        + r.calcularSaldoPendiente());
            }
        }
    }
    public static void imprimir(String cadena){
        System.out.println(cadena);
    }
}
