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
 public class LoginFondo extends JPanel {

    private Image imagenFondo;
    public LoginFondo(String rutaImagen) {
        // Intenta cargar la imagen
        java.net.URL urlImagen = getClass().getResource(rutaImagen);
        
        if (urlImagen != null) {
            this.imagenFondo = new ImageIcon(urlImagen).getImage();
        } else {
            System.err.println("¡ERROR: No se encontró la imagen en la ruta: " + rutaImagen + "!");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
