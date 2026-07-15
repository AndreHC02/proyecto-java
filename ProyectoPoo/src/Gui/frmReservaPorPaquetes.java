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
public class frmReservaPorPaquetes extends javax.swing.JFrame {

    
    private PaquetesTuristicos[] misPaquetes;
    private Voucher[] misVouchers; 

    
    public frmReservaPorPaquetes(PaquetesTuristicos[] paquetesDelSistema, Voucher[] vouchersDelSistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        this.misPaquetes = paquetesDelSistema;
        this.misVouchers = vouchersDelSistema; 
        
            cargarPaquetesEnCombo();
        
        if (cboPaquetesReserva.getItemCount() > 0) {
            cboPaquetesReserva.setSelectedIndex(0);
            mostrarReportePasajeros();
        }
     }
        public frmReservaPorPaquetes() {
            Fondo fondo = new Fondo("/Imagenes/FondoReportes.png");
            this.setContentPane(fondo);
            initComponents();
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(new java.awt.Color(240, 245, 250));
            
        }
    
    private void cargarPaquetesEnCombo() {
        javax.swing.DefaultComboBoxModel<String> modeloCombo = new javax.swing.DefaultComboBoxModel<>();
        
        if (this.misPaquetes == null) {
            cboPaquetesReserva.setModel(modeloCombo);
            return;
        }
        
        for (int i = 0; i < misPaquetes.length; i++) {
            if (misPaquetes[i] != null) { 
                modeloCombo.addElement(misPaquetes[i].getIdCodigo() + " - " + misPaquetes[i].getNombre());
            }
        }
        cboPaquetesReserva.setModel(modeloCombo);
    }

    
    private void mostrarReportePasajeros() {
    int indice = cboPaquetesReserva.getSelectedIndex();
    if (indice == -1 || misPaquetes == null || misPaquetes[indice] == null) return;

    PaquetesTuristicos paqueteElegido = misPaquetes[indice];
    String codigo = paqueteElegido.getIdCodigo();

    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); 

    int totalAsientosVendidos = 0;
    
    if (codigo.equalsIgnoreCase("CUS01")) { 
        modelo.addRow(new Object[]{"VOU-001", "71234567", "Juan Pérez Rivera", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-004", "44556677", "María Gómez Díaz", 1, "S/. " + (1 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-010", "08123456", "Familia Quispe Santillán", 5, "S/. " + (5 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 8;
    } 
    else if (codigo.equalsIgnoreCase("MAN02")) { 
        modelo.addRow(new Object[]{"VOU-002", "10203040", "Carlos Mendoza Torres", 4, "S/. " + (4 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-006", "18293045", "Lucía Fernández Ramírez", 1, "S/. " + (1 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 5;
    } 
    else if (codigo.equalsIgnoreCase("IQU03") || codigo.equalsIgnoreCase("IQU04")) { 
        modelo.addRow(new Object[]{"VOU-003", "09876543", "Ana López Vega", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-005", "11223344", "Luis Castro Arce", 3, "S/. " + (3 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-014", "99887766", "Patricia Morales Wong", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 7;
    }
    else if (codigo.equalsIgnoreCase("ARE03")) { 
        modelo.addRow(new Object[]{"VOU-012", "41238965", "Andrés Beltrán Castro", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-016", "09556622", "Roberto Gómez Wong", 3, "S/. " + (3 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-022", "76543210", "Elena Rojas Silva", 1, "S/. " + (1 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 6;
    }
    else if (codigo.equalsIgnoreCase("PUN05")) { 
        modelo.addRow(new Object[]{"VOU-017", "88776655", "Diego Alarcón Paz", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-020", "55443322", "Sofía Vergara Soto", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 4;
    }
    else if (codigo.equalsIgnoreCase("ICA06")) { 
        modelo.addRow(new Object[]{"VOU-008", "45889922", "Pedro Alcántara Solís", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-015", "33221100", "Marco Antonio Solís", 4, "S/. " + (4 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 6;
    }
    else if (codigo.equalsIgnoreCase("TAR08")) { 
        modelo.addRow(new Object[]{"VOU-018", "44556677", "Camila Vega Torres", 2, "S/. " + (2 * paqueteElegido.getPrecioPorPersona())});
        modelo.addRow(new Object[]{"VOU-021", "12348765", "Felipe Mantilla Ruiz", 3, "S/. " + (3 * paqueteElegido.getPrecioPorPersona())});
        totalAsientosVendidos = 5;
    }

    lblTotalAsientos.setText(totalAsientosVendidos + " Asientos");
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
        cboPaquetesReserva = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalAsientos = new javax.swing.JLabel();
        btnCerrarReportesReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTE DE RESERVAS POR PAQUETE");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione el Paquete: ");

        cboPaquetesReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPaquetesReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaquetesReservaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Voucher", "DNI / Pasaporte", "Nombre del Pasajero", "Asientos", "Pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Total de Asientos Vendidos  en este Paquete: ");

        lblTotalAsientos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalAsientos.setText("Asientos");

        btnCerrarReportesReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnCerrarReportesReserva.setText("Cerrar");
        btnCerrarReportesReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarReportesReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cboPaquetesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalAsientos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(btnCerrarReportesReserva))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboPaquetesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarReportesReserva, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTotalAsientos))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboPaquetesReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaquetesReservaActionPerformed
        // TODO add your handling code here:
        mostrarReportePasajeros(); 
    }//GEN-LAST:event_cboPaquetesReservaActionPerformed

    private void btnCerrarReportesReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarReportesReservaActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarReportesReservaActionPerformed

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
            java.util.logging.Logger.getLogger(frmReservaPorPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReservaPorPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReservaPorPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReservaPorPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReservaPorPaquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarReportesReserva;
    private javax.swing.JComboBox<String> cboPaquetesReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTotalAsientos;
    // End of variables declaration//GEN-END:variables
}
