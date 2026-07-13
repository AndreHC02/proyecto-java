/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Piero
 */
public class AsesorViaje extends Empleado{


    private int cantidadClientesAtendidos;

    public AsesorViaje(int idEmpleado, String nombre, String apellido,
                       String dni, String telefono, String correo,
                       double sueldo, int cantidadClientesAtendidos) {

        super(idEmpleado, nombre, apellido, dni, telefono, correo, sueldo);
        this.cantidadClientesAtendidos = cantidadClientesAtendidos;
    }

    public void registrarReserva() {
        imprimir("El asesor está registrando una reserva.");
    }

    @Override
    public void mostrarInformacion() {
        imprimir("Asesor de viaje: " + nombre + " " + apellido);
        imprimir("Clientes atendidos: " + cantidadClientesAtendidos);
    }

    public int getCantidadClientesAtendidos() {
        return cantidadClientesAtendidos;
    }

    public void setCantidadClientesAtendidos(int cantidadClientesAtendidos) {
        this.cantidadClientesAtendidos = cantidadClientesAtendidos;
    }
    private void imprimir(String cadena) {
        System.out.println(cadena);
    }
}
    
    

