/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpoo;


/**
 *
 * @author jahzeelp
 */
public class Fidelizacion {
    private static final double SOLES_POR_PUNTO = 100.0; 
    private static final int PUNTOS_PARA_DESCUENTO = 5;   
    private static final double PORCENTAJE_DESCUENTO_PREMIO = 10.0; 

    private String[] identificadorCliente; 
    private int[] puntos;
    private int cantidadClientesRegistrados;

    public Fidelizacion() {
        identificadorCliente = new String[100];
        puntos = new int[100];
        cantidadClientesRegistrados = 0;
    }

    private int buscarPosicion(String identificador) {
        for (int i = 0; i < cantidadClientesRegistrados; i++) {
            if (identificadorCliente[i].equals(identificador)) {
                return i;
            }
        }
        return -1;
    }

    public void agregarPuntos(String identificador, double montoGastado) {
        int puntosGanados = (int) (montoGastado / SOLES_POR_PUNTO);

        int posicion = buscarPosicion(identificador);

        if (posicion == -1) {
            if (cantidadClientesRegistrados < identificadorCliente.length) {
                identificadorCliente[cantidadClientesRegistrados] = identificador;
                puntos[cantidadClientesRegistrados] = puntosGanados;
                cantidadClientesRegistrados++;
            }
        } else {
            puntos[posicion] += puntosGanados;
        }
    }

    public int consultarPuntos(String identificador) {
        int posicion = buscarPosicion(identificador);
        if (posicion == -1) {
            return 0;
        }
        return puntos[posicion];
    }

    public Promocion generarDescuentoSiAplica(String identificador) {
    int puntosActuales = consultarPuntos(identificador);

    if (puntosActuales >= PUNTOS_PARA_DESCUENTO) {
        return new DescuentoPorcentaje(
                PORCENTAJE_DESCUENTO_PREMIO,
                "PROMO-FIDELIDAD-" + identificador,
                "Descuento por fidelidad",
                "2026-07-15",
                "2026-12-31"
        );
    }
    return null; 
}
}   
