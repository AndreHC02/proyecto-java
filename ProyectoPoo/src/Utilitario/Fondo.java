/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitario;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author ASUS
 */
/**
 * Un panel personalizado que dibuja una imagen de fondo escalada a su tamaño.
 */

public class Fondo extends JPanel {
    
    private Image imagen;

    public Fondo(String rutaImagen) {
        java.net.URL url = getClass().getResource(rutaImagen);
        if (url != null) {
            this.imagen = new ImageIcon(url).getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}