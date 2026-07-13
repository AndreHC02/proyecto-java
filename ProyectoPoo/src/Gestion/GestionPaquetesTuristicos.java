/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import Clases.DestinosTuristicos;
import Clases.PaquetesTuristicos;
/**
 *
 * @author ASUS
 */
public class GestionPaquetesTuristicos {

    private PaquetesTuristicos[] listaPaquetes;
    private int contador;

    public GestionPaquetesTuristicos() {
        this.listaPaquetes = new PaquetesTuristicos[100]; 
        this.contador = 0;
    }

    public PaquetesTuristicos[] getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(PaquetesTuristicos[] listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }



    public boolean registrarPaquete(PaquetesTuristicos nuevoPaquete) {
        if (contador < listaPaquetes.length) {
            listaPaquetes[contador] = nuevoPaquete;
            contador++;
            return true;
        }
        return false;
    }

    public PaquetesTuristicos buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaPaquetes[i].getIdCodigo().equalsIgnoreCase(codigo)) {
                return listaPaquetes[i];
            }
        }
        return null;
    }

    public boolean modificarPaquete(String codigo, String nuevoNom, int nuevosDias, int nuevasNoches, String nuevoTipo, double nuevoPrecio, String nuevaSalida, String nuevaRetorno, int nuevoMax, String nuevoEstado) {
        PaquetesTuristicos paq = buscarPorCodigo(codigo);
        if (paq != null) {
            paq.setNombre(nuevoNom);
            paq.setDdias(nuevosDias);
            paq.setDnoches(nuevasNoches);
            paq.setTipo(nuevoTipo);
            paq.setPrecioPorPersona(nuevoPrecio); 
            paq.setFechaSalida(nuevaSalida);
            paq.setFechaRetorno(nuevaRetorno);
            paq.setCantidadMaxPersonas(nuevoMax);
            paq.setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public boolean eliminarPaquete(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaPaquetes[i].getIdCodigo().equalsIgnoreCase(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    listaPaquetes[j] = listaPaquetes[j + 1];
                }
                listaPaquetes[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public boolean vincularDestinoAPaquete(String codigoPaquete, DestinosTuristicos destino) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            paq.agregarDestino(destino);
            return true;
        }
        return false;
    }

    public DestinosTuristicos[] obtenerDestinosDePaquete(String codigoPaquete) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            int cantidad = paq.getContadorDestinos();
            DestinosTuristicos[] destinosDelPaquete = new DestinosTuristicos[cantidad];
            for (int i = 0; i < cantidad; i++) {
                destinosDelPaquete[i] = paq.getDestinosIncluidos()[i];
            }
            return destinosDelPaquete;
        }
        return new DestinosTuristicos[0];
    }



    public double calcularPrecioTotal(String codigoPaquete, int cantidadPasajeros) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            return paq.getPrecioPorPersona() * cantidadPasajeros;
        }
        return 0.0;
    }

    public boolean verificarDisponibilidad(String codigoPaquete, int cuposSolicitados) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null && paq.getEstado().equalsIgnoreCase("Activo")) {
            return paq.getCupoDisponible() >= cuposSolicitados;
        }
        return false;
    }

    public boolean reservarCupos(String codigoPaquete, int cantidadPasajeros) {
        if (verificarDisponibilidad(codigoPaquete, cantidadPasajeros)) {
            PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
            int nuevosCupos = paq.getCupoDisponible() - cantidadPasajeros;
            paq.setCupoDisponible(nuevosCupos); 
            
            if (nuevosCupos == 0) {
                paq.setEstado("Agotado");
            }
            return true;
        }
        return false;
    }

    public boolean cambiarEstadoPaquete(String codigoPaquete, String nuevoEstado) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            paq.setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public PaquetesTuristicos[] obtenerTodos() {
        PaquetesTuristicos[] existentes = new PaquetesTuristicos[contador];
        for (int i = 0; i < contador; i++) {
            existentes[i] = listaPaquetes[i];
        }
        return existentes;
    }
    // Ejemplo de cómo preparar tus datos cargados para la sustentación:
    public static PaquetesTuristicos[] cargarDatosDePrueba() {
    PaquetesTuristicos[] listaPaquetes = new PaquetesTuristicos[50];
    
    // Paquete 1: Cusco (5 días)
    PaquetesTuristicos p1 = new PaquetesTuristicos("CUS01", "Cusco Mágico e Imperial", 5, 4, "Cultural", 1200.0, "15/08/2026", "20/08/2026", 20, "Activo");
    p1.registrarActividadDia(1, "Recepción en aeropuerto, traslado al hotel y mate de coca de bienvenida.");
    p1.registrarActividadDia(2, "City Tour guiado por Sacsayhuamán, Qorikancha y Tambomachay.");
    // Dejamos los días 3, 4 y 5 vacíos para que TÚ los llenes en vivo frente al profesor
    listaPaquetes[0] = p1;

    // Paquete 2: Máncora (3 días)
    PaquetesTuristicos p2 = new PaquetesTuristicos("MAN02", "Relax en Playas de Máncora", 3, 2, "Relax", 850.0, "10/09/2026", "13/09/2026", 15, "Activo");
    p2.registrarActividadDia(1, "Llegada al resort, tarde de playa y cóctel de bienvenida en la piscina.");
    listaPaquetes[1] = p2;

    return listaPaquetes;
}
}