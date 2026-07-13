/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Clases.Usuario;

/**
 *
 * @author ASUS
 */
public class GestionUsuario {
    private Usuario[] usuarios; 

    public GestionUsuario() {
        this.usuarios = new Usuario[3];
        
        this.usuarios[0] = new Usuario("admin", "admin", "Administrador");
        this.usuarios[1] = new Usuario("asesor", "222222", "Asesor de Viaje");
        this.usuarios[2] = new Usuario("operador", "333333", "Operador");
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
        
    }
    public Usuario validarLogin(String usuario, String clave) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(usuario) && usuarios[i].getClave().equals(clave)) {
                    return usuarios[i];
                }
            }
        }
        return null;
    }
    
}
