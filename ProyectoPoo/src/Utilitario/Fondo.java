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

// 'extends JPanel' significa que creamos nuestro propio panel personalizado
public class Fondo extends JPanel {
    
    private Image imagen;

    // El constructor recibe la ruta de la foto (ej: "/imagenes/fondo.jpg")
    public Fondo(String rutaImagen) {
        java.net.URL url = getClass().getResource(rutaImagen);
        if (url != null) {
            // Cargamos la imagen en la memoria
            this.imagen = new ImageIcon(url).getImage();
        }
    }

    // Este método dibuja la imagen automáticamente en la pantalla
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Borra lo anterior
        if (imagen != null) {
            // Dibuja la imagen estirándola al ancho y alto actual de la ventana
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}