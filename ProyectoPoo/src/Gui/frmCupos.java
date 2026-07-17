/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Clases.PaquetesTuristicos;
import Utilitario.Fondo;
import proyectofinalpoo.Reserva;

/**
 *
 * @author ASUS
 */
public class frmCupos extends javax.swing.JFrame {

    
    private PaquetesTuristicos[] misPaquetes;
    private Reserva[] misReservas; 
    
    public frmCupos(PaquetesTuristicos[] paquetesDelSistema) {
        Fondo fondo = new Fondo("/Imagenes/FondoOperacion.png");
        this.setContentPane(fondo);
        initComponents();
        
        this.setLocationRelativeTo(null); 
        
        
        this.misPaquetes = paquetesDelSistema;
        
        
        cargarPaquetesEnCombo();
        
        
        if (cboPaquetesCupos.getItemCount() > 0) {
            cboPaquetesCupos.setSelectedIndex(0);
            calcularCupos();
        }
    }

    
    public frmCupos() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(240, 245, 250));
    }

    
    private void cargarPaquetesEnCombo() {
        javax.swing.DefaultComboBoxModel<String> modeloCombo = new javax.swing.DefaultComboBoxModel<>();
        
        if (this.misPaquetes == null) {
            cboPaquetesCupos.setModel(modeloCombo);
            return;
        }
        
        for (int i = 0; i < misPaquetes.length; i++) {
            if (misPaquetes[i] != null) { 
                modeloCombo.addElement(misPaquetes[i].getIdCodigo() + " - " + misPaquetes[i].getNombre());
            }
        }
        cboPaquetesCupos.setModel(modeloCombo);
    }

    
    private void calcularCupos() {
    int indice = cboPaquetesCupos.getSelectedIndex();
    if (indice == -1 || misPaquetes == null || misPaquetes[indice] == null) 
        return; 

    PaquetesTuristicos paqueteElegido = misPaquetes[indice];
    String paqueteSeleccionado = cboPaquetesCupos.getSelectedItem().toString();

    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); 

    int capacidadTotal = paqueteElegido.getCupoDisponible(); 
    if (capacidadTotal <= 0) capacidadTotal = 20;

    int cuposOcupados = 0;
    
    if (paqueteSeleccionado.contains("CUS01")) { 
        modelo.addRow(new Object[]{"VOU-001", "71234567", "Juan Pérez Rivera", 2, "987654321"});
        modelo.addRow(new Object[]{"VOU-004", "44556677", "María Gómez Díaz", 1, "912345678"});
        modelo.addRow(new Object[]{"VOU-010", "08123456", "Familia Quispe Santillán", 5, "998877665"});
        modelo.addRow(new Object[]{"VOU-011", "10203040", "Carlos Mendoza Torres", 4, "951753852"});
        cuposOcupados = 12;
    } 
    else if (paqueteSeleccionado.contains("MAN02")) { 
        modelo.addRow(new Object[]{"VOU-002", "18293045", "Lucía Fernández Ramírez", 3, "923456789"});
        modelo.addRow(new Object[]{"VOU-006", "09876543", "Ana López Vega", 4, "981234567"});
        modelo.addRow(new Object[]{"VOU-009", "11223344", "Luis Castro Arce", 2, "978563412"});
        cuposOcupados = 9;
    } 
    else if (paqueteSeleccionado.contains("ARE03")) { 
        modelo.addRow(new Object[]{"VOU-012", "41238965", "Andrés Beltrán Castro", 2, "963258147"});
        modelo.addRow(new Object[]{"VOU-016", "09556622", "Roberto Gómez Wong", 3, "941258763"});
        modelo.addRow(new Object[]{"VOU-022", "76543210", "Elena Rojas Silva", 1, "955443322"});
        modelo.addRow(new Object[]{"VOU-023", "33221100", "Marco Antonio Solís", 5, "988776655"});
        cuposOcupados = 11;
    }
    else if (paqueteSeleccionado.contains("IQU04")) { 
        modelo.addRow(new Object[]{"VOU-003", "99887766", "Patricia Morales Wong", 2, "911223344"});
        modelo.addRow(new Object[]{"VOU-005", "88776655", "Diego Alarcón Paz", 4, "922334455"});
        modelo.addRow(new Object[]{"VOU-014", "55443322", "Sofía Vergara Soto", 2, "933445566"});
        cuposOcupados = 8;
    }
    else if (paqueteSeleccionado.contains("PUN05")) { 
        modelo.addRow(new Object[]{"VOU-017", "45889922", "Pedro Alcántara Solís", 2, "944556677"});
        modelo.addRow(new Object[]{"VOU-020", "12348765", "Felipe Mantilla Ruiz", 3, "955667788"});
        modelo.addRow(new Object[]{"VOU-024", "70112233", "Milagros Vega Luna", 2, "966778899"});
        cuposOcupados = 7;
    }
    else if (paqueteSeleccionado.contains("ICA06")) { 
        modelo.addRow(new Object[]{"VOU-008", "44556677", "Camila Vega Torres", 2, "977889900"});
        modelo.addRow(new Object[]{"VOU-015", "08123456", "Familia Quispe Santillán", 6, "988990011"});
        modelo.addRow(new Object[]{"VOU-025", "10203040", "Carlos Mendoza Torres", 4, "999001122"});
        cuposOcupados = 12;
    }
    else if (paqueteSeleccionado.contains("HUA07")) { 
        modelo.addRow(new Object[]{"VOU-013", "71234567", "Juan Pérez Rivera", 1, "910203040"});
        modelo.addRow(new Object[]{"VOU-019", "09876543", "Ana López Vega", 3, "920304050"});
        modelo.addRow(new Object[]{"VOU-026", "11223344", "Luis Castro Arce", 2, "930405060"});
        cuposOcupados = 6;
    }
    else if (paqueteSeleccionado.contains("TAR08")) { 
        modelo.addRow(new Object[]{"VOU-018", "41238965", "Andrés Beltrán Castro", 2, "940506070"});
        modelo.addRow(new Object[]{"VOU-021", "09556622", "Roberto Gómez Wong", 3, "950607080"});
        modelo.addRow(new Object[]{"VOU-027", "76543210", "Elena Rojas Silva", 4, "960708090"});
        modelo.addRow(new Object[]{"VOU-028", "88776655", "Diego Alarcón Paz", 5, "970809010"});
        cuposOcupados = 14;
    }

    int cuposDisponibles = capacidadTotal - cuposOcupados;
    if (cuposDisponibles < 0) cuposDisponibles = 0;

    lblCapacidadTotal.setText(capacidadTotal + " Asientos");
    lblCuposOcupados.setText(cuposOcupados + " Asientos"); 
    lblCuposDisponibles.setText(cuposDisponibles + " Asientos");

    int porcentaje = (capacidadTotal > 0) ? (int) ((cuposOcupados * 100.0) / capacidadTotal) : 0;
    if (porcentaje > 100) porcentaje = 100;

    prgCupos.setValue(porcentaje);
    prgCupos.setString(porcentaje + " %");
    prgCupos.setStringPainted(true);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPaquetesCupos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prgCupos = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnCerrarCupos = new javax.swing.JButton();
        lblCapacidadTotal = new javax.swing.JLabel();
        lblCuposDisponibles = new javax.swing.JLabel();
        lblCuposOcupados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROL DE CUPOS");

        cboPaquetesCupos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPaquetesCupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaquetesCuposActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione el Paquete");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("CAPACIDAD TOTAL");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CUPOS OCUPADOS");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("DISPONIBLES");

        jLabel5.setText("Estado: [");

        jLabel6.setText("] ");

        jLabel7.setText("Ocupado");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°Voucher", "DNI Clientes", "Nombre del Pasajero", "Asientos", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("LISTA DE PASAJEROS REGISTRADOS EN ESTE TOUR");

        btnCerrarCupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnCerrarCupos.setText("Cerrar");
        btnCerrarCupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCuposActionPerformed(evt);
            }
        });

        lblCapacidadTotal.setText("jLabel9");

        lblCuposDisponibles.setText("jLabel10");

        lblCuposOcupados.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 39, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prgCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(lblCapacidadTotal)))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblCuposOcupados)
                                        .addGap(128, 128, 128)
                                        .addComponent(lblCuposDisponibles)
                                        .addGap(77, 77, 77))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(51, 51, 51))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(86, 86, 86)
                        .addComponent(cboPaquetesCupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(btnCerrarCupos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(120, 120, 120)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboPaquetesCupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCuposDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCuposOcupados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCapacidadTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(prgCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarCupos)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCuposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCuposActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_btnCerrarCuposActionPerformed

    private void cboPaquetesCuposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaquetesCuposActionPerformed
        // TODO add your handling code here:
        
         calcularCupos(); 
    }//GEN-LAST:event_cboPaquetesCuposActionPerformed

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
            java.util.logging.Logger.getLogger(frmCupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCupos;
    private javax.swing.JComboBox<String> cboPaquetesCupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCapacidadTotal;
    private javax.swing.JLabel lblCuposDisponibles;
    private javax.swing.JLabel lblCuposOcupados;
    private javax.swing.JProgressBar prgCupos;
    // End of variables declaration//GEN-END:variables
}
