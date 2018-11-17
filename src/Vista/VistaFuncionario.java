/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerRecurHumanos;
import Logic.Funcionario;
import Modelo.ModeloRecurHumanos;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class VistaFuncionario extends javax.swing.JFrame {

    public VistaFuncionario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfContrasenna = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbPuesto = new javax.swing.JComboBox<>();
        jcbDependencia = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jlfFuncionario = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Puesto:");

        jtfId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfId.setName("id"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Contraseña:");

        jtfContrasenna.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfContrasenna.setName("contrasenna"); // NOI18N

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("ID:");

        jtfNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfNombre.setName("nombre"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nombre:");

        jcbPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbPuesto.setName("puesto"); // NOI18N

        jcbDependencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbDependencia.setName("dependencia"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Dependencia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombre)
                            .addComponent(jcbPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbDependencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jcbDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlfFuncionario.setFont(new java.awt.Font("Comic Sans MS", 2, 26)); // NOI18N
        jlfFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlfFuncionario.setText("Insertar Funcionario");
        jlfFuncionario.setName("Funcionario"); // NOI18N

        jbtnGuardar.setText("Agregar");
        jbtnGuardar.setName("agregar"); // NOI18N

        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.setName("limpiar"); // NOI18N

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setName("cancelar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnGuardar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlfFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlfFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLimpiar)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JButton jbtnCancelar;
    public javax.swing.JButton jbtnGuardar;
    public javax.swing.JButton jbtnLimpiar;
    public javax.swing.JComboBox<String> jcbDependencia;
    public javax.swing.JComboBox<String> jcbPuesto;
    private javax.swing.JLabel jlfFuncionario;
    public javax.swing.JTextField jtfContrasenna;
    public javax.swing.JTextField jtfId;
    public javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
    private ModeloRecurHumanos modelo;
    private ControllerRecurHumanos controlador;
    
    public void setModelo(ModeloRecurHumanos modelo) {
        this.modelo = modelo;
        Iterator<String> ite = modelo.getNombresDependencias().iterator();
        ite.next();
        jcbDependencia.addItem("-");
        while (ite.hasNext()) {
            jcbDependencia.addItem(ite.next());
        }
        jcbPuesto.addItem(modelo.tiposSolicitud[0]);
        jcbPuesto.addItem(modelo.tiposSolicitud[1]);
        jcbPuesto.addItem(modelo.tiposSolicitud[2]);
        jcbPuesto.addItem(modelo.tiposSolicitud[3]);
        jcbPuesto.addItem(modelo.tiposSolicitud[4]);
        jcbPuesto.addItem(modelo.tiposSolicitud[5]);
        modelo.notifyObservers();
    }
    
    public void setControlador(ControllerRecurHumanos controlador){
        this.controlador = controlador;
       jbtnGuardar.addActionListener(controlador);
       jbtnLimpiar.addActionListener(controlador);
       jbtnCancelar.addActionListener(controlador);
       jtfNombre.addActionListener(controlador);
       jtfId.addActionListener(controlador);
       jtfContrasenna.addActionListener(controlador);
    }
    
    public void limpiarTodos(){
        jtfContrasenna.setText("");
        jtfNombre.setText("");
        jtfId.setText("");
        jcbDependencia.setSelectedItem("-");
        jcbPuesto.setSelectedItem("-");
        jbtnGuardar.setName("agregar");
        jbtnGuardar.setText("Agregar");
        jbtnLimpiar.setEnabled(true);
        jtfId.setEditable(true);
    }
    
    public void cargarDatos(Funcionario funcionario, String dependencia){
        jtfContrasenna.setText(funcionario.getPassword());
        jtfNombre.setText(funcionario.getNombre());
        jtfId.setText(funcionario.getId());
        jtfId.setEditable(false);
        jcbDependencia.setSelectedItem(dependencia);
        jcbPuesto.setSelectedItem(funcionario.getPuesto());
        jbtnLimpiar.setEnabled(false);
        jbtnGuardar.setName("modificar");
        jbtnGuardar.setText("Modificar");
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public void setNombreUsuario(String nombre){
        jlfFuncionario.setText(nombre);
    }
}
