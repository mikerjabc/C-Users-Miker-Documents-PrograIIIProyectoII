/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControllerJefe;
import Modelo.ModeloJefe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VistaJefe extends javax.swing.JFrame implements Observer {

    private DefaultTableModel model;

    public VistaJefe() {
        initComponents();
        initLocal();
    }

    private void initLocal() {
        model = (DefaultTableModel) jtSolicitudes.getModel();
        setTitle("Jefe");
        setLocationRelativeTo(null);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        //Ajustar el texto a la izquierta
        jtSolicitudes.getColumnModel().getColumn(0).setCellRenderer(tcr);//Numero
        jtSolicitudes.getColumnModel().getColumn(1).setCellRenderer(tcr);//Fecha
        jtSolicitudes.getColumnModel().getColumn(2).setCellRenderer(tcr);//Tipo
        jtSolicitudes.getColumnModel().getColumn(3).setCellRenderer(tcr);//Estado
        jtSolicitudes.getColumnModel().getColumn(4).setCellRenderer(tcr);//CantidadBienes
        jtSolicitudes.getColumnModel().getColumn(4).setCellRenderer(tcr);//MontoTotal
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtSolicitudes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtIdBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmOpciones = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiCambiarUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jefe");

        jtSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha", "Tipo", "Estado", "Cantidad de Bienes", "Monto Total"
            }
        ));
        jScrollPane2.setViewportView(jtSolicitudes);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtIdBuscar.setName("idBuscar"); // NOI18N

        jbBuscar.setText("Buscar");

        jLabel2.setText("Número de Solicitud:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
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
                .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaJefe().setVisible(true);
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
    public javax.swing.JMenuItem jmiSalir;
    public javax.swing.JTextField jtIdBuscar;
    public javax.swing.JTable jtSolicitudes;
    // End of variables declaration//GEN-END:variables

    private ModeloJefe modelo;
    private ControllerJefe controlador;

    public void setModelo(ModeloJefe modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
        jcbBuscar.addItem(modelo.tiposSolicitud[0]);
        jcbBuscar.addItem(modelo.tiposSolicitud[1]);
    }

    public void setControlador(ControllerJefe controlador) {
        this.controlador = controlador;
        jcbBuscar.addItemListener(controlador);
        jbBuscar.addActionListener(controlador);
        jmiCambiarUsuario.addActionListener(controlador);
        jmiSalir.addActionListener(controlador);
        jmAyuda.addActionListener(controlador);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void setNombreUsuario(String nombre) {
        jlNombre.setText(nombre);
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
            jtSolicitudes.getColumnModel().getColumn(0).setPreferredWidth(100);//Numero
            jtSolicitudes.getColumnModel().getColumn(1).setPreferredWidth(150);//Fecha
            jtSolicitudes.getColumnModel().getColumn(2).setPreferredWidth(100);//Tipo
            jtSolicitudes.getColumnModel().getColumn(3).setPreferredWidth(150);//Estado
            jtSolicitudes.getColumnModel().getColumn(4).setPreferredWidth(150);//CantidadBienes
            jtSolicitudes.getColumnModel().getColumn(5).setPreferredWidth(150);//MontoTotal
            //Cargar nombres de cada columna
            jtSolicitudes.getColumnModel().getColumn(0).setHeaderValue(modelo.VARIABLESTABLA[0]);//Numero
            jtSolicitudes.getColumnModel().getColumn(1).setHeaderValue(modelo.VARIABLESTABLA[1]);//Fecha
            jtSolicitudes.getColumnModel().getColumn(2).setHeaderValue(modelo.VARIABLESTABLA[2]);//Tipo
            jtSolicitudes.getColumnModel().getColumn(3).setHeaderValue(modelo.VARIABLESTABLA[3]);//Estado
            jtSolicitudes.getColumnModel().getColumn(4).setHeaderValue(modelo.VARIABLESTABLA[4]);//CantidadBienes
            jtSolicitudes.getColumnModel().getColumn(5).setHeaderValue(modelo.VARIABLESTABLA[5]);//MontoTotal
            jtSolicitudes.repaint();
        } else {
            //Asignar tamaño de ancho de cada columna
            jtSolicitudes.getColumnModel().getColumn(0).setPreferredWidth(100);//Numero
            jtSolicitudes.getColumnModel().getColumn(1).setPreferredWidth(200);//Origen
            jtSolicitudes.getColumnModel().getColumn(2).setPreferredWidth(200);//Destino
            jtSolicitudes.getColumnModel().getColumn(3).setPreferredWidth(150);//Ubicacion
            jtSolicitudes.getColumnModel().getColumn(4).setPreferredWidth(150);//Funcionario
            jtSolicitudes.getColumnModel().getColumn(5).setPreferredWidth(150);//Estado
            //Cargar nombre de cada columna
            jtSolicitudes.getColumnModel().getColumn(0).setHeaderValue(modelo.VARIABLESTABLA[0]);//Numero
            jtSolicitudes.getColumnModel().getColumn(1).setHeaderValue(modelo.VARIABLESTABLA[6]);//Origen
            jtSolicitudes.getColumnModel().getColumn(2).setHeaderValue(modelo.VARIABLESTABLA[7]);//Destino
            jtSolicitudes.getColumnModel().getColumn(3).setHeaderValue(modelo.VARIABLESTABLA[8]);//ubicacion
            jtSolicitudes.getColumnModel().getColumn(4).setHeaderValue(modelo.VARIABLESTABLA[9]);//Funcionario
            jtSolicitudes.getColumnModel().getColumn(5).setHeaderValue(modelo.VARIABLESTABLA[10]);//Estado
            jtSolicitudes.repaint();
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
