/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerRegistrador;
import Modelo.ModeloRegistrador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VistaRegistrador extends javax.swing.JFrame implements Observer {
    
    private DefaultTableModel model;
    public VistaRegistrador() {
        initComponents();
        initLocal();
    }
    
    private void initLocal(){
        model = (DefaultTableModel)jtFuncionarios.getModel();
        setTitle("Registro de Bienes");
        setLocationRelativeTo(null);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jtFuncionarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtIdBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmOpciones = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarUsuario = new javax.swing.JMenuItem();
        jmiCambiarUsuario1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Solicitud", "Fecha", "Tipo", "Estado", "Cantidad de Bienes", "Monto total"
            }
        ));
        jScrollPane2.setViewportView(jtFuncionarios);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtIdBuscar.setName("idBuscar"); // NOI18N

        jbBuscar.setText("Buscar");
        jbBuscar.setName("buscar"); // NOI18N

        jLabel2.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
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
                    .addComponent(jLabel2))
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
                .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrador de Bienes");

        jmOpciones.setText("Opciones");
        jmOpciones.setName("catalogo"); // NOI18N
        jmOpciones.add(jSeparator2);

        jmiCambiarUsuario.setText("Cambiar de Usuario");
        jmiCambiarUsuario.setName("cambiar"); // NOI18N
        jmOpciones.add(jmiCambiarUsuario);

        jmiCambiarUsuario1.setText("Catálogo");
        jmiCambiarUsuario1.setName("cambiar"); // NOI18N
        jmOpciones.add(jmiCambiarUsuario1);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistrador().setVisible(true);
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
    public javax.swing.JButton jbBuscar;
    public javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JLabel jlNombre;
    public javax.swing.JMenu jmAyuda;
    public javax.swing.JMenu jmOpciones;
    public javax.swing.JMenuItem jmiCambiarUsuario;
    public javax.swing.JMenuItem jmiCambiarUsuario1;
    public javax.swing.JMenuItem jmiSalir;
    public javax.swing.JTable jtFuncionarios;
    public javax.swing.JTextField jtIdBuscar;
    // End of variables declaration//GEN-END:variables
    
   private ModeloRegistrador modelo;
    private ControllerRegistrador controlador;
    
    public void setModelo(ModeloRegistrador modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
        jcbBuscar.addItem(modelo.tiposSolicitud[0]);
        jcbBuscar.addItem(modelo.tiposSolicitud[1]);
        jlNombre.setText(modelo.getFuncionario().getNombre());
        
    }
    
    public void setControlador(ControllerRegistrador controlador){
        this.controlador = controlador;
        jbBuscar.addActionListener(controlador);
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

    public void limpiarTodosEspacios() {
        jtIdBuscar.setText("");
        jcbBuscar.getModel().setSelectedItem(modelo.tiposSolicitud[0]);
    }

    public boolean confirmacionDeAccion(String mensaje) {
        boolean respuesta = false;
        int option = JOptionPane.showConfirmDialog(this, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.OK_OPTION == option) {
            respuesta = true;
        }
        return respuesta;
    }

    public void cambiarValoresTabla(String tipo) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);

        if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
            //Asignar tamaño de ancho de cada columna
            jtFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);//Numero
            jtFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);//Fecha
            jtFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);//Tipo
            jtFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(150);//Estado
            jtFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(150);//CantidadBienes
            jtFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(150);//MontoTotal
            //Cargar nombres de cada columna
            jtFuncionarios.getColumnModel().getColumn(0).setHeaderValue(modelo.VARIABLESTABLA[0]);//Numero
            jtFuncionarios.getColumnModel().getColumn(1).setHeaderValue(modelo.VARIABLESTABLA[1]);//Fecha
            jtFuncionarios.getColumnModel().getColumn(2).setHeaderValue(modelo.VARIABLESTABLA[2]);//Tipo
            jtFuncionarios.getColumnModel().getColumn(3).setHeaderValue(modelo.VARIABLESTABLA[3]);//Estado
            jtFuncionarios.getColumnModel().getColumn(4).setHeaderValue(modelo.VARIABLESTABLA[4]);//CantidadBienes
            jtFuncionarios.getColumnModel().getColumn(5).setHeaderValue(modelo.VARIABLESTABLA[5]);//MontoTotal
            jtFuncionarios.repaint();
        }else {
            //Asignar tamaño de ancho de cada columna
            jtFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);//Codigo
            jtFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(200);//DescripcionBien
            jtFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(200);//DescripcionActivo
            jtFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(150);//funcionario
            jtFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(150);//Ubicacion
            jtFuncionarios.getColumnModel().getColumn(5).setMaxWidth(0);
            jtFuncionarios.getColumnModel().getColumn(5).setMinWidth(0);
            jtFuncionarios.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            jtFuncionarios.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            //Cargar nombre de cada columna
            jtFuncionarios.getColumnModel().getColumn(0).setHeaderValue(modelo.VARIABLESTABLA[6]);//Codigo
            jtFuncionarios.getColumnModel().getColumn(1).setHeaderValue(modelo.VARIABLESTABLA[7]);//DescripcionBien
            jtFuncionarios.getColumnModel().getColumn(2).setHeaderValue(modelo.VARIABLESTABLA[8]);//DescripcionActivo
            jtFuncionarios.getColumnModel().getColumn(3).setHeaderValue(modelo.VARIABLESTABLA[9]);//funcionario
            jtFuncionarios.getColumnModel().getColumn(4).setHeaderValue(modelo.VARIABLESTABLA[10]);//Ubicacion
            jtFuncionarios.getColumnModel().getColumn(5).setHeaderValue("");//Ocultar
            jtFuncionarios.repaint();
        }
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
