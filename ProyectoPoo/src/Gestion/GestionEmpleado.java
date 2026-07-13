/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Clases.Empleado;

/**
 *
 * @author Piero
 */
public class GestionEmpleado {
    private Empleado[] empleados;
    private int cantidad;
    public GestionEmpleado() {
        empleados = new Empleado[100];
        cantidad = 0;
    }
    public void agregarEmpleado(Empleado empleado) {

        if (cantidad < empleados.length) {
            empleados[cantidad] = empleado;
            cantidad++;
        }
    }
    public Empleado buscarEmpleado(int idEmpleado) {
        for (int i = 0; i < cantidad; i++) {

            if (empleados[i].getIdEmpleado() == idEmpleado) {
                return empleados[i];
            }

        }

        return null;
    }
    public boolean eliminarEmpleado(int idEmpleado) {

    for (int i = 0; i < cantidad; i++) {

        if (empleados[i].getIdEmpleado() == idEmpleado) {

            for (int j = i; j < cantidad - 1; j++) {
                empleados[j] = empleados[j + 1];
            }

            cantidad--;
            return true;
        }
    }

    return false;
}

  
    public void mostrarEmpleados() {

        for (int i = 0; i < cantidad; i++) {

            empleados[i].mostrarInformacion();
            imprimir("----------------------");

        }
    }
    public Empleado[] getEmpleados() {
    return empleados;
}
    

    public int obtenerCantidad() {
        return cantidad;
    }

    private void imprimir(String cadena) {
        System.out.println(cadena);
    }
    public boolean actualizar(Empleado empleado) {

    for (int i = 0; i < cantidad; i++) {

        if (empleados[i].getIdEmpleado() == empleado.getIdEmpleado()) {

            empleados[i] = empleado;
            return true;
        }

    }

    return false;
}
}
    

