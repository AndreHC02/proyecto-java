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
}