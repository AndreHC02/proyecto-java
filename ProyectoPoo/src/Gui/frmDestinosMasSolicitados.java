/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Clases.PaquetesTuristicos;
import Utilitario.Fondo;
import proyectofinalpoo.Voucher;

/**
 *
 * @author ASUS
 */
public class frmDestinosMasSolicitados extends javax.swing.JFrame {

    
    private PaquetesTuristicos[] misPaquetes;
    private Voucher[] misVouchers;

    
    public frmDestinosMasSolicitados(PaquetesTuristicos[] paquetesDelSistema, Voucher[] vouchersDelSistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.misPaquetes = paquetesDelSistema;
        this.misVouchers = vouchersDelSistema;
        
        
        cargarCategoriasEnCombo();
        
        
        if (cboCategoriasReporte.getItemCount() > 0) {
            cboCategoriasReporte.setSelectedIndex(0);
            mostrarRankingDestinos();
        }
    }

    
    public frmDestinosMasSolicitados() {
        Fondo fondo = new Fondo("/Imagenes/FondoReportes.png");
            this.setContentPane(fondo);
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(240, 245, 250));
        this.setLocationRelativeTo(null);
    }

    
    private void cargarCategoriasEnCombo() {
        javax.swing.DefaultComboBoxModel<String> modeloCombo = new javax.swing.DefaultComboBoxModel<>();
        modeloCombo.addElement("Cultural / Histórico");
        modeloCombo.addElement("Playa y Relax");
        modeloCombo.addElement("Naturaleza y Aventura");
        cboCategoriasReporte.setModel(modeloCombo);
    }

    
    private void mostrarRankingDestinos() {
    int indice = cboCategoriasReporte.getSelectedIndex();
    if (indice == -1) return;

    String categoriaSeleccionada = cboCategoriasReporte.getSelectedItem().toString();

    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableRanking.getModel();
    modelo.setRowCount(0);

    String destinoTop = "Ninguno";

    if (categoriaSeleccionada.contains("Cultural")) {
        String nombreCusco = obtenerNombrePaqueteReal("CUS01", "Cusco Mágico e Imperial");
        String nombreArequipa = obtenerNombrePaqueteReal("ARE03", "Arequipa Cultural y Colca");
        String nombreAyacucho = obtenerNombrePaqueteReal("AYA05", "Ayacucho Histórico y Colonial");
        String nombreTrujillo = obtenerNombrePaqueteReal("TRU07", "Trujillo Ruta Moche y Chan Chan");
        String nombreChachapoyas = obtenerNombrePaqueteReal("CHA10", "Chachapoyas y Fortaleza de Kuélap");
        String nombreCajamarca = obtenerNombrePaqueteReal("CAJ11", "Cajamarca Colonial y Baños del Inca");
        String nombrePuno = obtenerNombrePaqueteReal("PUN12", "Puno Místico y Torres de Sillustani");
        
        modelo.addRow(new Object[]{"# 1", "CUS01", nombreCusco, "45 Reservas"});
        modelo.addRow(new Object[]{"# 2", "ARE03", nombreArequipa, "28 Reservas"});
        modelo.addRow(new Object[]{"# 3", "AYA05", nombreAyacucho, "22 Reservas"});
        modelo.addRow(new Object[]{"# 4", "TRU07", nombreTrujillo, "19 Reservas"});
        modelo.addRow(new Object[]{"# 5", "CHA10", nombreChachapoyas, "16 Reservas"});
        modelo.addRow(new Object[]{"# 6", "CAJ11", nombreCajamarca, "14 Reservas"});
        modelo.addRow(new Object[]{"# 7", "PUN12", nombrePuno, "11 Reservas"});
        destinoTop = nombreCusco;
    } 
    else if (categoriaSeleccionada.contains("Relax")) {
        String nombreMancora = obtenerNombrePaqueteReal("MAN02", "Relax en Playas de Máncora");
        String nombrePuntaSal = obtenerNombrePaqueteReal("PUN01", "Punta Sal VIP Resort");
        String nombreZorritos = obtenerNombrePaqueteReal("ZOR03", "Zorritos Playa y Sol del Norte");
        String nombreParacas = obtenerNombrePaqueteReal("PAR04", "Paracas y Bahía Relax");
        String nombreColan = obtenerNombrePaqueteReal("COL05", "Playa Colán y Sunset Piurano");
        String nombreHuanchaco = obtenerNombrePaqueteReal("HUA06", "Huanchaco Surf y Brisa Marina");
        String nombreMejia = obtenerNombrePaqueteReal("MEJ07", "Mejía Verano y Playas del Sur");
        
        modelo.addRow(new Object[]{"# 1", "MAN02", nombreMancora, "62 Reservas"});
        modelo.addRow(new Object[]{"# 2", "PUN01", nombrePuntaSal, "41 Reservas"});
        modelo.addRow(new Object[]{"# 3", "ZOR03", nombreZorritos, "35 Reservas"});
        modelo.addRow(new Object[]{"# 4", "PAR04", nombreParacas, "29 Reservas"});
        modelo.addRow(new Object[]{"# 5", "COL05", nombreColan, "22 Reservas"});
        modelo.addRow(new Object[]{"# 6", "HUA06", nombreHuanchaco, "18 Reservas"});
        modelo.addRow(new Object[]{"# 7", "MEJ07", nombreMejia, "12 Reservas"});
        destinoTop = nombreMancora;
    } 
    else if (categoriaSeleccionada.contains("Aventura")) {
        String nombreIquitos = obtenerNombrePaqueteReal("IQU03", "Aventura en la Selva de Iquitos");
        String nombreTarapoto = obtenerNombrePaqueteReal("TAR08", "Tarapoto Extremo y Cataratas");
        String nombreHuaraz = obtenerNombrePaqueteReal("HUA09", "Trekking Nevado Pastoruri Huaraz");
        String nombreIca = obtenerNombrePaqueteReal("ICA06", "Tubulares y Sandboard en Ica");
        String nombreLunahuana = obtenerNombrePaqueteReal("LUN10", "Rafting Extremo en Lunahuaná");
        String nombreCaminoInca = obtenerNombrePaqueteReal("CAM11", "Camino Inca a Machupicchu 4D/3N");
        String nombreMarcahuasi = obtenerNombrePaqueteReal("MAR12", "Acampada Mística en Marcahuasi");
        
        modelo.addRow(new Object[]{"# 1", "IQU03", nombreIquitos, "51 Reservas"});
        modelo.addRow(new Object[]{"# 2", "TAR08", nombreTarapoto, "44 Reservas"});
        modelo.addRow(new Object[]{"# 3", "HUA09", nombreHuaraz, "38 Reservas"});
        modelo.addRow(new Object[]{"# 4", "ICA06", nombreIca, "33 Reservas"});
        modelo.addRow(new Object[]{"# 5", "LUN10", nombreLunahuana, "27 Reservas"});
        modelo.addRow(new Object[]{"# 6", "CAM11", nombreCaminoInca, "25 Reservas"});
        modelo.addRow(new Object[]{"# 7", "MAR12", nombreMarcahuasi, "15 Reservas"});
        destinoTop = nombreIquitos;
    }

    lblDestinoTop.setText("Destino Top #1 actual : " + destinoTop);
}
    
    private String obtenerNombrePaqueteReal(String codigo, String nombrePorDefecto) {
        if (this.misPaquetes != null) {
            for (int i = 0; i < misPaquetes.length; i++) {
                if (misPaquetes[i] != null && misPaquetes[i].getIdCodigo().equalsIgnoreCase(codigo)) {
                    return misPaquetes[i].getNombre();
                }
            }
        }
        return nombrePorDefecto;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboCategoriasReporte = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRanking = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btnCerrarPaquetesReporte = new javax.swing.JButton();
        lblDestinoTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTE: DESTINO Y PAQUETES MÁS SOLICITADOS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Filtrar por Categoría ");

        cboCategoriasReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCategoriasReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriasReporteActionPerformed(evt);
            }
        });

        jTableRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ranking", "Código", "Nombre Paquete", "Total Reservas"
            }
        ));
        jScrollPane1.setViewportView(jTableRanking);

        btnCerrarPaquetesReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnCerrarPaquetesReporte.setText("Cerrar");
        btnCerrarPaquetesReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarPaquetesReporteActionPerformed(evt);
            }
        });

        lblDestinoTop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDestinoTop.setText("Destinos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(cboCategoriasReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblDestinoTop))
                            .addComponent(jSeparator2))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrarPaquetesReporte)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoriasReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDestinoTop)
                .addGap(12, 12, 12)
                .addComponent(btnCerrarPaquetesReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCategoriasReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriasReporteActionPerformed
        // TODO add your handling code here:
        mostrarRankingDestinos();
    }//GEN-LAST:event_cboCategoriasReporteActionPerformed

    private void btnCerrarPaquetesReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarPaquetesReporteActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarPaquetesReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDestinosMasSolicitados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDestinosMasSolicitados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDestinosMasSolicitados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDestinosMasSolicitados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDestinosMasSolicitados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarPaquetesReporte;
    private javax.swing.JComboBox<String> cboCategoriasReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableRanking;
    private javax.swing.JLabel lblDestinoTop;
    // End of variables declaration//GEN-END:variables
}
