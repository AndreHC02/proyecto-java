/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Piero
 */
public class Administrador extends Empleado{


    private String areaGestion;

    public Administrador(int idEmpleado, String nombre, String apellido,
                         String dni, String telefono, String correo,
                         double sueldo, String areaGestion) {

        super(idEmpleado, nombre, apellido, dni, telefono, correo, sueldo);
        this.areaGestion = areaGestion;
    }

    @Override
    public void mostrarInformacion() {
        imprimir("Administrador: " + nombre + " " + apellido);
        imprimir("Área: " + areaGestion);
        imprimir("Sueldo: " + sueldo);
    }

    public String getAreaGestion() {
        return areaGestion;
    }

    public void setAreaGestion(String areaGestion) {
        this.areaGestion = areaGestion;
    }
    private void imprimir(String cadena) {
        System.out.println(cadena);
    }
}
    

