/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.AbstractController;
import Logic.Transferencia;
import Modelo.ModeloTransferencia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando
 */
public class VistaTransferencia extends javax.swing.JFrame implements Observer {

    private DefaultTableModel model;

    public VistaTransferencia() {
        initComponents();
        initLocal();
    }

    private void initLocal() {
        model = (DefaultTableModel) jtActivos.getModel();
        setTitle("Jefe");
        setLocationRelativeTo(null);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        //Ajustar el texto a la izquierta
        jtActivos.getColumnModel().getColumn(0).setCellRenderer(tcr);//Codigo
        jtActivos.getColumnModel().getColumn(1).setCellRenderer(tcr);//Bien
        jtActivos.getColumnModel().getColumn(2).setCellRenderer(tcr);//Descripcion
        jtActivos.getColumnModel().getColumn(3).setCellRenderer(tcr);//Funcionario
        jtActivos.getColumnModel().getColumn(4).setCellRenderer(tcr);//Ubicacion
        //Ajustar tamaño
        jtActivos.getColumnModel().getColumn(0).setPreferredWidth(100);//Codigo
        jtActivos.getColumnModel().getColumn(1).setPreferredWidth(200);//Bien
        jtActivos.getColumnModel().getColumn(2).setPreferredWidth(100);//Descripcion
        jtActivos.getColumnModel().getColumn(3).setPreferredWidth(200);//Funcionario
        jtActivos.getColumnModel().getColumn(4).setPreferredWidth(150);//Ubicacion
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfUbicacion = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JComboBox<>();
        jtfOrigen = new javax.swing.JTextField();
        jtfDestino = new javax.swing.JTextField();
        jtfFuncionario = new javax.swing.JTextField();
        jbLimpiar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jtfCodigoBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtActivos = new javax.swing.JTable();
        jbAgregarBien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 2, 26)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Transferencia");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Número:");

        jtfNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfNumero.setName("jtfNumero"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Dependencia Destino:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ubicación:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Dependencia Origen:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Funcionario Responsable:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Estado de Autorización:");
        jLabel5.setToolTipText("");

        jtfUbicacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfUbicacion.setName("ubicacion"); // NOI18N

        jcbEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtfOrigen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfOrigen.setName("jtfNumero"); // NOI18N

        jtfDestino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfDestino.setName("jtfNumero"); // NOI18N

        jtfFuncionario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfFuncionario.setName("jtfNumero"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfOrigen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addComponent(jtfDestino)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfUbicacion)
                            .addComponent(jtfFuncionario)
                            .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jtfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbLimpiar.setText("Limpiar");
        jbLimpiar.setName("limpiar"); // NOI18N

        jbCancelar.setText("Cancelar");
        jbCancelar.setName("cancelar"); // NOI18N

        jbAgregar.setText("Agregar");
        jbAgregar.setName("agregar"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Bienes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jtfCodigoBuscar.setName("idBuscar"); // NOI18N

        jbBuscar.setText("Buscar");
        jbBuscar.setName("buscar"); // NOI18N

        jLabel7.setText("Código:");

        jtActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Bien", "Descripción", "Funcionario", "Ubicación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtActivos);

        jbAgregarBien.setText("Agregar");
        jbAgregarBien.setName("agregarBien"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAgregarBien)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel7)
                    .addComponent(jbAgregarBien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAgregar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiar)
                    .addComponent(jbAgregar)
                    .addComponent(jbCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaTransferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton jbAgregar;
    public javax.swing.JButton jbAgregarBien;
    public javax.swing.JButton jbBuscar;
    public javax.swing.JButton jbCancelar;
    public javax.swing.JButton jbLimpiar;
    public javax.swing.JComboBox<String> jcbEstado;
    public javax.swing.JTable jtActivos;
    public javax.swing.JTextField jtfCodigoBuscar;
    public javax.swing.JTextField jtfDestino;
    public javax.swing.JTextField jtfFuncionario;
    public javax.swing.JTextField jtfNumero;
    public javax.swing.JTextField jtfOrigen;
    private javax.swing.JTextField jtfUbicacion;
    // End of variables declaration//GEN-END:variables

    private ModeloTransferencia modelo;
    private AbstractController controlador;

    public void setModelo(ModeloTransferencia modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public void setControlador(AbstractController controlador) {
        this.controlador = controlador;
        jbAgregar.addActionListener(controlador);
        jbAgregarBien.addActionListener(controlador);
        jbCancelar.addActionListener(controlador);
        jbBuscar.addActionListener(controlador);
        jbLimpiar.addActionListener(controlador);
        jtfNumero.addKeyListener(controlador);
        jtfCodigoBuscar.addKeyListener(controlador);
    }

    public void ajustatVistaParaFuncionario(String tipo) {
        switch (tipo.toLowerCase()) {
            case "administrador": {
                jcbEstado.addItem(modelo.tiposEstadoTransferencia[0]);
            }
            break;
            case "jefe": {
                jcbEstado.addItem(modelo.tiposEstadoTransferencia[1]);
                jcbEstado.addItem(modelo.tiposEstadoTransferencia[2]);

                jbAgregarBien.setEnabled(false);

                jbLimpiar.setEnabled(false);

                jtfOrigen.setEditable(false);
                jtfDestino.setEditable(false);
                jtfNumero.setEditable(false);
                jtfUbicacion.setEditable(false);
                jtfFuncionario.setEditable(false);
            }
            break;
        }
    }

    public void limpiarTodosEspacios() {
        jtfOrigen.setText("");
        jtfDestino.setText("");
        jtfNumero.setText("");
        jcbEstado.getModel().setSelectedItem(modelo.tiposEstadoTransferencia[0]);
        jtfCodigoBuscar.setText("");
        jtfFuncionario.setText("");
        jtfUbicacion.setText("");
        modelo.limpiar();
    }

    public void cargarDatos(Transferencia transferencia) {
        jtfOrigen.setText(transferencia.getOrigen().getNombre());
        jtfDestino.setText(transferencia.getDestino().getNombre());
        jtfFuncionario.setText(transferencia.getFuncionario().getNombre());
        jtfUbicacion.setText(transferencia.getUbicacion());
        jtfNumero.setText(String.valueOf(transferencia.getNumero()));
        jcbEstado.getModel().setSelectedItem(transferencia.getAutorizacion());
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o1 != null) {
            if (o1.getClass() == ArrayList.class) {
                ArrayList aux = (ArrayList) o1;
                int filas = model.getRowCount();
                for (int i = 0; i < filas; i++) {
                    model.removeRow(0);
                }
                Iterator<Object[]> ite = aux.iterator();
                while (ite.hasNext()) {
                    model.addRow(ite.next());
                }
            }
        }
    }
}
