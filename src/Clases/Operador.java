/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Piero
 */
public class Operador extends Empleado{
    private String turno;

    public Operador(int idEmpleado, String nombre, String apellido,
                    String dni, String telefono, String correo,
                    double sueldo, String turno) {

        super(idEmpleado, nombre, apellido, dni, telefono, correo, sueldo);
        this.turno = turno;
    }

    public void gestionarReservas() {
        imprimir("El operador está gestionando reservas.");
    }

    @Override
    public void mostrarInformacion() {
        imprimir("Operador: " + nombre + " " + apellido);
        imprimir("Turno: " + turno);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    private void imprimir(String cadena) {
        System.out.println(cadena);
    }
}
    
    

