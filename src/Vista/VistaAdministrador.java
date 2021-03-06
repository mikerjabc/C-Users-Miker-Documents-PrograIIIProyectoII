/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerAdministrador;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;

import Logic.Solicitud;
import Modelo.ModeloAdministrador;
import java.util.Observer;

/**
 *
 * @author Fernando
 */
public class VistaAdministrador extends javax.swing.JFrame implements Observer {

    /**
     * @return the nombreUsuario
     */
    public javax.swing.JLabel getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(javax.swing.JLabel nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the tituloDeTabla
     */
    public javax.swing.JLabel getTituloDeTabla() {
        return tituloDeTabla;
    }

    /**
     * @param tituloDeTabla the tituloDeTabla to set
     */
    public void setTituloDeTabla(javax.swing.JLabel tituloDeTabla) {
        this.tituloDeTabla = tituloDeTabla;
    }

    /**
     * @return the panelAgregaNuevaSolicitud
     */
    public javax.swing.JPanel getPanelAgregaNuevaSolicitud() {
        return panelAgregaNuevaSolicitud;
    }

    /**
     * @param panelAgregaNuevaSolicitud the panelAgregaNuevaSolicitud to set
     */
    public void setPanelAgregaNuevaSolicitud(javax.swing.JPanel panelAgregaNuevaSolicitud) {
        this.panelAgregaNuevaSolicitud = panelAgregaNuevaSolicitud;
    }

    /**
     * @return the campoMontoTotal
     */
    public javax.swing.JTextField getCampoMontoTotal() {
        return campoMontoTotal;
    }

    /**
     * @param campoMontoTotal the campoMontoTotal to set
     */
    public void setCampoMontoTotal(javax.swing.JTextField campoMontoTotal) {
        this.campoMontoTotal = campoMontoTotal;
    }

    /**
     * @return the campoFecha
     */
    public javax.swing.JTextField getCampoFecha() {
        return campoFecha;
    }

    /**
     * @param campoFecha the campoFecha to set
     */
    public void setCampoFecha(javax.swing.JTextField campoFecha) {
        this.campoFecha = campoFecha;
    }

    /**
     * @return the campoNumeroComprobante
     */
    public javax.swing.JTextField getCampoNumeroComprobante() {
        return campoNumeroComprobante;
    }

    /**
     * @param campoNumeroComprobante the campoNumeroComprobante to set
     */
    public void setCampoNumeroComprobante(javax.swing.JTextField campoNumeroComprobante) {
        this.campoNumeroComprobante = campoNumeroComprobante;
    }

    /**
     * @return the campoTipoAdqui
     */
    public javax.swing.JComboBox<String> getCampoTipoAdqui() {
        return campoTipoAdqui;
    }

    /**
     * @param campoTipoAdqui the campoTipoAdqui to set
     */
    public void setCampoTipoAdqui(javax.swing.JComboBox<String> campoTipoAdqui) {
        this.campoTipoAdqui = campoTipoAdqui;
    }


    

 
    
    public DefaultTableModel dtm = new DefaultTableModel();
     
      
    
    public VistaAdministrador() {
        initComponents();
        tablaBienesSolicitudes.setModel(dtm);
       panelAgregaNuevaSolicitud.setVisible(false);
        this.setLocationRelativeTo(null);  
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        solictud = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoTipoAdquicicion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBienesSolicitudes = new javax.swing.JTable();
        panelAgregaNuevaSolicitud = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoTipoAdqui = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        campoNumeroComprobante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGuardarSolicitud = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarBien = new javax.swing.JButton();
        campoMontoTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        nombreUsuario = new javax.swing.JLabel();
        tituloDeTabla = new javax.swing.JLabel();
        btnNuevaSolicitud = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmOpciones = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarUsuario = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();

        solictud.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        solictud.setText("Solicitud de Bienes Muebles");

        campoTipoAdquicicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-vacio-", "Donacion", "Compra", "Produccion Institucional", " " }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${undecorated}"), campoTipoAdquicicion, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoTipoAdquicicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoAdquicicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tablaBienesSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Modelo", "Serial", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBienesSolicitudes.getTableHeader().setReorderingAllowed(false);
        tablaBienesSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBienesSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBienesSolicitudes);
        if (tablaBienesSolicitudes.getColumnModel().getColumnCount() > 0) {
            tablaBienesSolicitudes.getColumnModel().getColumn(0).setResizable(false);
        }

        panelAgregaNuevaSolicitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Tipo de Adquisicion");

        campoTipoAdqui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Donación", "Produccion Institucional" }));

        jLabel1.setText("NUMERO DE COMPROBANTE");

        campoNumeroComprobante.setEditable(false);

        jLabel5.setText("Monto Total");

        btnGuardarSolicitud.setText("Guardar Solicitud");
        btnGuardarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSolicitudActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarBien.setText("Agregar Bien");
        btnAgregarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBienActionPerformed(evt);
            }
        });

        campoMontoTotal.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setText("Fecha");

        javax.swing.GroupLayout panelAgregaNuevaSolicitudLayout = new javax.swing.GroupLayout(panelAgregaNuevaSolicitud);
        panelAgregaNuevaSolicitud.setLayout(panelAgregaNuevaSolicitudLayout);
        panelAgregaNuevaSolicitudLayout.setHorizontalGroup(
            panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoTipoAdqui, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarSolicitud))
                    .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(btnAgregarBien)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAgregaNuevaSolicitudLayout.setVerticalGroup(
            panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregaNuevaSolicitudLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTipoAdqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarBien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAgregaNuevaSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarSolicitud)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreUsuario.setText("Nombre de Usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreUsuario)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tituloDeTabla.setText("Solicitudes Actuales");

        btnNuevaSolicitud.setText("NUEVA SOLICITUD");
        btnNuevaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSolicitudActionPerformed(evt);
            }
        });

        jmOpciones.setText("Opciones");
        jmOpciones.add(jSeparator2);

        jmiCambiarUsuario.setText("Cambiar de Usuario");
        jmiCambiarUsuario.setName("cambiar"); // NOI18N
        jmOpciones.add(jmiCambiarUsuario);
        jmOpciones.add(jSeparator3);

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmOpciones.add(jmiSalir);

        jMenuBar1.add(jmOpciones);

        jmAyuda.setText("Ayuda");
        jMenuBar1.add(jmAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloDeTabla)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelAgregaNuevaSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevaSolicitud)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaSolicitud))
                .addGap(30, 30, 30)
                .addComponent(tituloDeTabla)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(panelAgregaNuevaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTipoAdquicicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoAdquicicionActionPerformed
        
    }//GEN-LAST:event_campoTipoAdquicicionActionPerformed

    private void btnAgregarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBienActionPerformed
     }//GEN-LAST:event_btnAgregarBienActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarSolicitudActionPerformed

    private void tablaBienesSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBienesSolicitudesMouseClicked
   
    }//GEN-LAST:event_tablaBienesSolicitudesMouseClicked

    private void btnNuevaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaSolicitudActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiSalirActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBien;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarSolicitud;
    private javax.swing.JButton btnNuevaSolicitud;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JTextField campoNumeroComprobante;
    private javax.swing.JComboBox<String> campoTipoAdqui;
    private javax.swing.JComboBox<String> campoTipoAdquicicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public javax.swing.JMenu jmAyuda;
    public javax.swing.JMenu jmOpciones;
    public javax.swing.JMenuItem jmiCambiarUsuario;
    public javax.swing.JMenuItem jmiSalir;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JPanel panelAgregaNuevaSolicitud;
    private javax.swing.JLabel solictud;
    private javax.swing.JTable tablaBienesSolicitudes;
    private javax.swing.JLabel tituloDeTabla;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
    ModeloAdministrador modelo;     
    
    ControllerAdministrador controlador;
    
    
    public void setModelo(ModeloAdministrador model){
        this.modelo=model;
        model.addObserver(this);
    } 
    
       public void setNombreUsuario(String nombre){
        getNombreUsuario().setText(nombre);
    }
    
    public void setControlador(ControllerAdministrador aThis) {
        this.controlador = aThis;
        btnAgregarBien.addActionListener(aThis);
        btnCancelar.addActionListener(aThis);
        btnGuardarSolicitud.addActionListener(aThis);
        btnNuevaSolicitud.addActionListener(aThis);
    }
    
//    public void agregarFila(String descripcion,String serial,String nombre, String marca){
//      dtm.addRow(new Object [] {serial, nombre, marca});
//    }
    
    @Override
    public void update(Observable updatedModel,Object param){
        
    }

    
}
