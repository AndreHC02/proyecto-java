/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import Clases.DestinosTuristicos;
import Clases.PaquetesTuristicos;
/**
 *
 * @author ASUS
 */
public class GestionPaquetesTuristicos {

    private PaquetesTuristicos[] listaPaquetes;
    private int contador;

    public GestionPaquetesTuristicos() {
        this.listaPaquetes = new PaquetesTuristicos[100]; 
        this.contador = 0;
    }

    public PaquetesTuristicos[] getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(PaquetesTuristicos[] listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }



    public boolean registrarPaquete(PaquetesTuristicos nuevoPaquete) {
        if (contador < listaPaquetes.length) {
            listaPaquetes[contador] = nuevoPaquete;
            contador++;
            return true;
        }
        return false;
    }

    public PaquetesTuristicos buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaPaquetes[i].getIdCodigo().equalsIgnoreCase(codigo)) {
                return listaPaquetes[i];
            }
        }
        return null;
    }

    public boolean modificarPaquete(String codigo, String nuevoNom, int nuevosDias, int nuevasNoches, String nuevoTipo, double nuevoPrecio, String nuevaSalida, String nuevaRetorno, int nuevoMax, String nuevoEstado) {
        PaquetesTuristicos paq = buscarPorCodigo(codigo);
        if (paq != null) {
            paq.setNombre(nuevoNom);
            paq.setDdias(nuevosDias);
            paq.setDnoches(nuevasNoches);
            paq.setTipo(nuevoTipo);
            paq.setPrecioPorPersona(nuevoPrecio); 
            paq.setFechaSalida(nuevaSalida);
            paq.setFechaRetorno(nuevaRetorno);
            paq.setCantidadMaxPersonas(nuevoMax);
            paq.setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public boolean eliminarPaquete(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaPaquetes[i].getIdCodigo().equalsIgnoreCase(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    listaPaquetes[j] = listaPaquetes[j + 1];
                }
                listaPaquetes[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public boolean vincularDestinoAPaquete(String codigoPaquete, DestinosTuristicos destino) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            paq.agregarDestino(destino);
            return true;
        }
        return false;
    }

    public DestinosTuristicos[] obtenerDestinosDePaquete(String codigoPaquete) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            int cantidad = paq.getContadorDestinos();
            DestinosTuristicos[] destinosDelPaquete = new DestinosTuristicos[cantidad];
            for (int i = 0; i < cantidad; i++) {
                destinosDelPaquete[i] = paq.getDestinosIncluidos()[i];
            }
            return destinosDelPaquete;
        }
        return new DestinosTuristicos[0];
    }



    public double calcularPrecioTotal(String codigoPaquete, int cantidadPasajeros) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            return paq.getPrecioPorPersona() * cantidadPasajeros;
        }
        return 0.0;
    }

    public boolean verificarDisponibilidad(String codigoPaquete, int cuposSolicitados) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null && paq.getEstado().equalsIgnoreCase("Activo")) {
            return paq.getCupoDisponible() >= cuposSolicitados;
        }
        return false;
    }

    public boolean reservarCupos(String codigoPaquete, int cantidadPasajeros) {
        if (verificarDisponibilidad(codigoPaquete, cantidadPasajeros)) {
            PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
            int nuevosCupos = paq.getCupoDisponible() - cantidadPasajeros;
            paq.setCupoDisponible(nuevosCupos); 
            
            if (nuevosCupos == 0) {
                paq.setEstado("Agotado");
            }
            return true;
        }
        return false;
    }

    public boolean cambiarEstadoPaquete(String codigoPaquete, String nuevoEstado) {
        PaquetesTuristicos paq = buscarPorCodigo(codigoPaquete);
        if (paq != null) {
            paq.setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public static PaquetesTuristicos[] cargarDatosDePrueba() {
    PaquetesTuristicos[] listaPaquetes = new PaquetesTuristicos[50];
    
    // Paquete 1: Cusco (5 días) - Dejamos días libres para la demo en vivo
    PaquetesTuristicos p1 = new PaquetesTuristicos("CUS01", "Cusco Mágico e Imperial", 5, 4, "Cultural", 1200.0, "15/08/2026", "20/08/2026", 20, "Activo");
    p1.registrarActividadDia(1, "Recepción en aeropuerto, traslado al hotel y mate de coca de bienvenida.");
    p1.registrarActividadDia(2, "City Tour guiado por Sacsayhuamán, Qorikancha y Tambomachay.");
    // Dejamos los días 3, 4 y 5 vacíos para llenarlos en vivo frente al profesor
    listaPaquetes[0] = p1;

    // Paquete 2: Máncora (3 días)
    PaquetesTuristicos p2 = new PaquetesTuristicos("MAN02", "Relax en Playas de Máncora", 3, 2, "Relax", 850.0, "10/09/2026", "13/09/2026", 15, "Activo");
    p2.registrarActividadDia(1, "Llegada al resort, tarde de playa y cóctel de bienvenida en la piscina.");
    p2.registrarActividadDia(2, "Día libre para deportes acuáticos y clases de surf.");
    p2.registrarActividadDia(3, "Mañana de spa, check-out y traslado al aeropuerto de Piura.");
    listaPaquetes[1] = p2;

    // Paquete 3: Arequipa y Cañón del Colca (4 días)
    PaquetesTuristicos p3 = new PaquetesTuristicos("ARE03", "Arequipa y Maravillas del Colca", 4, 3, "Aventura", 950.0, "01/10/2026", "04/10/2026", 18, "Activo");
    p3.registrarActividadDia(1, "Llegada a Arequipa y City Tour peatonal por el Monasterio de Santa Catalina.");
    p3.registrarActividadDia(2, "Viaje hacia Chivay, pasando por la Reserva Nacional de Salinas y Aguada Blanca.");
    p3.registrarActividadDia(3, "Visita al Mirador de la Cruz del Cóndor y baños termales en Chivay.");
    p3.registrarActividadDia(4, "Retorno a la ciudad blanca y traslado al aeropuerto.");
    listaPaquetes[2] = p3;

    // Paquete 4: Iquitos y Selva Amazónica (4 días)
    PaquetesTuristicos p4 = new PaquetesTuristicos("IQU04", "Aventura en la Selva de Iquitos", 4, 3, "Ecoturismo", 1350.0, "15/07/2026", "18/07/2026", 10, "Activo");
    p4.registrarActividadDia(1, "Navegación por el Río Amazonas hasta el Lodge y caminata nocturna.");
    p4.registrarActividadDia(2, "Búsqueda de delfines rosados y visita a la comunidad nativa Yagua.");
    p4.registrarActividadDia(3, "Excursión para observar monos y tour de pesca de pirañas.");
    p4.registrarActividadDia(4, "Visita al centro de rescate de manatíes y retorno a la ciudad.");
    listaPaquetes[3] = p4;

    // Paquete 5: Puno y Lago Titicaca (3 días)
    PaquetesTuristicos p5 = new PaquetesTuristicos("PUN05", "Misterios del Lago Titicaca", 3, 2, "Cultural", 780.0, "05/11/2026", "07/11/2026", 25, "Activo");
    p5.registrarActividadDia(1, "Recepción en Puno y tarde libre para aclimatación.");
    p5.registrarActividadDia(2, "Excursión en lancha a las Islas Flotantes de los Uros y la Isla Taquile.");
    p5.registrarActividadDia(3, "Visita a las Chullpas de Sillustani camino al aeropuerto de Juliaca.");
    listaPaquetes[4] = p5;

    // Paquete 6: Ica y Paracas (2 días)
    PaquetesTuristicos p6 = new PaquetesTuristicos("ICA06", "Dunas y Ballestas en Ica", 2, 1, "Aventura", 450.0, "20/08/2026", "21/08/2026", 30, "Activo");
    p6.registrarActividadDia(1, "Tour en deslizador por las Islas Ballestas y avistamiento de fauna marina.");
    p6.registrarActividadDia(2, "Paseo en tubulares (buggies) y sandboarding en el Oasis de Huacachina.");
    listaPaquetes[5] = p6;

    // Paquete 7: Huaraz y Cordillera Blanca (4 días) - Ejemplo de paquete "Agotado"
    PaquetesTuristicos p7 = new PaquetesTuristicos("HUA07", "Trekking en la Cordillera Blanca", 4, 3, "Aventura", 890.0, "12/09/2026", "15/09/2026", 0, "Agotado");
    p7.registrarActividadDia(1, "Llegada a Huaraz y caminata suave al Mirador de Rataquenua para aclimatación.");
    p7.registrarActividadDia(2, "Trekking de día completo hacia la espectacular Laguna 69.");
    p7.registrarActividadDia(3, "Visita al Nevado Pastoruri y al bosque de Puyas de Raimondi.");
    p7.registrarActividadDia(4, "Compra de artesanías en el centro de Huaraz y regreso al terminal.");
    listaPaquetes[6] = p7;

    // Paquete 8: Tarapoto (3 días)
    PaquetesTuristicos p8 = new PaquetesTuristicos("TAR08", "Cascadas y Verde de Tarapoto", 3, 2, "Ecoturismo", 690.0, "22/10/2026", "24/10/2026", 12, "Activo");
    p8.registrarActividadDia(1, "Llegada, instalación en el hotel y tarde de relax en la Laguna Azul (Sauce).");
    p8.registrarActividadDia(2, "Caminata por la selva hasta las Cataratas de Ahuashiyacu y baño refrescante.");
    p8.registrarActividadDia(3, "Visita al Castillo de Lamas, degustación de café/cacao y check-out.");
    listaPaquetes[7] = p8;

    // Paquete 9: Trujillo y Chiclayo (4 días) - Ejemplo de paquete "Inactivo"
    PaquetesTuristicos p9 = new PaquetesTuristicos("TRU09", "Ruta Moche: Tesoros del Norte", 4, 3, "Cultural", 1100.0, "10/12/2026", "13/12/2026", 15, "Inactivo");
    p9.registrarActividadDia(1, "Llegada a Trujillo y visita a la ciudadela de barro de Chan Chan.");
    p9.registrarActividadDia(2, "Tour por las Huacas del Sol y la Luna, y tarde en el balneario de Huanchaco.");
    p9.registrarActividadDia(3, "Traslado a Chiclayo y visita al Museo Tumbas Reales del Señor de Sipán.");
    p9.registrarActividadDia(4, "Recorrido por el Mercado de Brujos de Chiclayo y fin del servicio.");
    listaPaquetes[8] = p9;

    // Paquete 10: Ayacucho (3 días)
    PaquetesTuristicos p10 = new PaquetesTuristicos("AYA10", "Ruta de las Iglesias e Historia", 3, 2, "Cultural", 620.0, "18/11/2026", "20/11/2026", 20, "Activo");
    p10.registrarActividadDia(1, "Recorrido por las principales iglesias coloniales y la Plaza Mayor.");
    p10.registrarActividadDia(2, "Excursión histórica al Santuario Histórico de la Pampa de Ayacucho y Quinua.");
    p10.registrarActividadDia(3, "Visita a los talleres de retablos ayacuchanos y traslado al aeropuerto.");
    listaPaquetes[9] = p10;

    return listaPaquetes;
}
}