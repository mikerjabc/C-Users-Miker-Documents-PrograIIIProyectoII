/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerRecurHumanos;
import Modelo.ModeloRecurHumanos;
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
public class VistaRecursosHumanos extends javax.swing.JFrame implements Observer {
    
    private DefaultTableModel model;
    
    public VistaRecursosHumanos() {
        initComponents();
        initLocal();
    }
    
    private void initLocal(){
        model = (DefaultTableModel)jtFuncionarios.getModel();
        setTitle("Recursos Humanos");
        setLocationRelativeTo(null);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        jtFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);//ID
        jtFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);//Nombre
        jtFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);//Puesto
        jtFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(150);//Dependencia
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        jtFuncionarios.getColumnModel().getColumn(0).setCellRenderer(tcr);//ID
        jtFuncionarios.getColumnModel().getColumn(1).setCellRenderer(tcr);//Nombre
        jtFuncionarios.getColumnModel().getColumn(2).setCellRenderer(tcr);//Puesto
        jtFuncionarios.getColumnModel().getColumn(3).setCellRenderer(tcr);//Dependencia
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFuncionarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtIdBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmOpciones = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recursos Humanos");

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Puesto", "Dependencia"
            }
        ));
        jScrollPane2.setViewportView(jtFuncionarios);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtIdBuscar.setName("idBuscar"); // NOI18N

        jbBuscar.setText("Buscar");
        jbBuscar.setName("buscar"); // NOI18N

        jLabel2.setText("ID:");

        jbAgregar.setText("Insertar");
        jbAgregar.setName("nuevo"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
                .addGap(91, 91, 91)
                .addComponent(jbAgregar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jbAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlNombre.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlNombre.setText("Nombre de Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jmOpciones.setText("Opciones");
        jmOpciones.add(jSeparator2);

        jmiCambiarUsuario.setText("Cambiar de Usuario");
        jmiCambiarUsuario.setName("cambiar"); // NOI18N
        jmOpciones.add(jmiCambiarUsuario);
        jmOpciones.add(jSeparator1);

        jmiSalir.setText("Salir");
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
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRecursosHumanos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public javax.swing.JButton jbAgregar;
    public javax.swing.JButton jbBuscar;
    public javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JLabel jlNombre;
    public javax.swing.JMenu jmAyuda;
    public javax.swing.JMenu jmOpciones;
    public javax.swing.JMenuItem jmiCambiarUsuario;
    public javax.swing.JMenuItem jmiSalir;
    public javax.swing.JTable jtFuncionarios;
    public javax.swing.JTextField jtIdBuscar;
    // End of variables declaration//GEN-END:variables
    
    private ModeloRecurHumanos modelo;
    private ControllerRecurHumanos controlador;
    
    public void setModelo(ModeloRecurHumanos modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
        Iterator<String> ite = modelo.getNombresDependencias().iterator();
        while (ite.hasNext()) {
            jcbBuscar.addItem(ite.next());
        }
    }
    
    public void setControlador(ControllerRecurHumanos controlador){
        this.controlador = controlador;
        jbBuscar.addActionListener(controlador);
        jbAgregar.addActionListener(controlador);
        jcbBuscar.addItemListener(controlador);
        jlNombre.addKeyListener(controlador);
        jmAyuda.addActionListener(controlador);
        jmiCambiarUsuario.addActionListener(controlador);
        jmiSalir.addActionListener(controlador);
        jtIdBuscar.addActionListener(controlador);
        jtFuncionarios.addMouseListener(controlador);
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public void setNombreUsuario(String nombre){
        jlNombre.setText(nombre);
    }
    
    public void limpiarTodosEspacios() {
        jtIdBuscar.setText("");
        jcbBuscar.getModel().setSelectedItem(modelo.ALL);
    }
    
    public boolean confirmacionDeAccion(String mensaje) {
        boolean respuesta = false;
        int option = JOptionPane.showConfirmDialog(this, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.OK_OPTION == option) {
            respuesta = true;
        }
        return respuesta;
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
