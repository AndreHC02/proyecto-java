/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import Clases.DestinosTuristicos;
/**
 *
 * @author ASUS
 */
public class GestionDestinoTuristico {

    private DestinosTuristicos[] listaDestinos;
    private int contador;

    public GestionDestinoTuristico() {
        this.listaDestinos = new DestinosTuristicos[100];
        this.contador = 0;
    }

    public DestinosTuristicos[] getListaDestinos() {
        return listaDestinos;
    }

    public void setListaDestinos(DestinosTuristicos[] listaDestinos) {
        this.listaDestinos = listaDestinos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


    public boolean registrarDestino(DestinosTuristicos nuevoDestino) {
        if (contador < listaDestinos.length) {
            listaDestinos[contador] = nuevoDestino;
            contador++;
            return true;
        }
        return false;
    }

    public DestinosTuristicos buscarPorId(String idDestino) {
        for (int i = 0; i < contador; i++) {
            if (listaDestinos[i].getIdDestino().equalsIgnoreCase(idDestino)) {
                return listaDestinos[i]; 
            }
        }
        return null; 
    }

    public boolean modificarDestino(String id, String nuevoNom, String nuevoPais, String nuevaCiu, String nuevaDesc, String nuevoClim, String nuevoIdio, String nuevaImg) {
        DestinosTuristicos encontrado = buscarPorId(id);
        if (encontrado != null) {
            encontrado.setNombre(nuevoNom);
            encontrado.setPais(nuevoPais);
            encontrado.setCiudad(nuevaCiu);
            encontrado.setDescripción(nuevaDesc);
            encontrado.setClima(nuevoClim);
            encontrado.setIdioma(nuevoIdio);
            encontrado.setImagen(nuevaImg);
            return true;
        }
        return false;
    }

    public boolean eliminarDestino(String idDestino) {
        for (int i = 0; i < contador; i++) {
            if (listaDestinos[i].getIdDestino().equalsIgnoreCase(idDestino)) {
                for (int j = i; j < contador - 1; j++) {
                    listaDestinos[j] = listaDestinos[j + 1];
                }
                listaDestinos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public DestinosTuristicos[] obtenerTodos() {
        DestinosTuristicos[] existentes = new DestinosTuristicos[contador];
        for (int i = 0; i < contador; i++) {
            existentes[i] = listaDestinos[i];
        }
        return existentes;
    }
}

