package Control;

import Logic.Funcionario;
import Modelo.ModeloJefe;
import Modelo.ModeloRegistrador;
import Vista.VistaActivo;
import Vista.VistaFuncionario;
import Vista.VistaJefe;
import Vista.VistaRegistrador;
import Vista.VistaSolicitud;
import Vista.VistaTransferencia;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioDependencia;
import accesoADatos.ServicioFuncionario;
import accesoADatos.ServicioSolicitud;
import accesoADatos.ServicioTransferencia;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTable;

/**
 *
 * @author Fernando
 */
public final class ControllerRegistrador extends AbstractController implements ItemListener{

    private ModeloRegistrador modelo ;
    private VistaRegistrador vista;
    private VistaSolicitud vistaSolicitud;
    private VistaTransferencia vistaTrasferencia;
    private VistaActivo vistaActivo;

    public ControllerRegistrador(ModeloRegistrador modelo, VistaRegistrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setModelo(modelo);
        vista.setControlador(this);
        this.ajustarVista();
        vistaActivo = new VistaActivo();
        modelo.setServicioSolicitud(ServicioSolicitud.getServicioSolicitud());
        modelo.setServicioTransferencia(ServicioTransferencia.getServicioTransferencia());
        modelo.setServicioFuncionario(ServicioFuncionario.getServicioFuncionario());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().getClass() == JButton.class) {
                JButton button = (JButton) ae.getSource();
                instrucciones(button.getName());
            }
            if (ae.getSource().getClass() == JMenuItem.class) {
                JMenuItem button = (JMenuItem) ae.getSource();
                instrucciones(button.getName());
            }
        } catch (Exception ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void ajustarVista() {
        vistaSolicitud = new VistaSolicitud();
        vistaSolicitud.ajustatVistaParaFuncionario("Registrador");
    }

    @Override
    public void mouseClicked(MouseEvent ae) {
        String numero;
        try {
            if (ae.getSource().getClass() == JTable.class) {
                JTable tabla = (JTable) ae.getSource();
                numero = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                tabla.changeSelection(tabla.getSelectedRow(), 0, false, true);
                modelo.buscarSolicitud(vista.jtIdBuscar.getText());
                if (ae.getClickCount() == 2) {
                    switch (ae.getButton()) {
                        case MouseEvent.BUTTON2: {//Click derecho
                            //instrucciones("eliminar");
                        }
                        break;
                        case MouseEvent.BUTTON1: {//Click izquierdo
                            if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                                vistaSolicitud.cargarDatos(modelo.getSolicitud(), modelo.tiposSolicitud, modelo.tiposBienes);
                                vistaSolicitud.setVisible(true);
                            } else {
                                vistaTrasferencia.cargarDatos(modelo.getTransferencia(), modelo.tiposSolicitud);
                                vistaTrasferencia.setVisible(true);
                            }
                        }
                        break;
                    }
                }
            }
        } catch (GlobalException | NoDataException ex) {
            vista.mostrarMensaje(ex.getMessage());
        } catch (Exception ex1) {
            vista.mostrarMensaje(ex1.getMessage());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mostrarVista() {
        vista.setVisible(true);
    }

    @Override
    public void ocultarVista() {
        vista.setVisible(false);
    }

    public void instrucciones(String x) throws Exception {
        String mensaje = "";
        try {
            switch (x.toLowerCase()) {
                case "Agregar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        
                        vistaSolicitud.setVisible(false);
                        modelo.RegistrarListaBien(vistaActivo.jtfCodigo.getText(),
                                                    vistaActivo.jtfDescripcion.getText(),
                                                    vistaActivo.jtfCodigo.getText(),
                                                    vistaActivo.jtfBien.getText(),
                                                    vistaActivo.jtfDescripcion1.getText());
                        mensaje = "Se asigno como activo el bien";
                    } else {
                        modelo.AutorizarTransferencia(vistaTrasferencia.jtfNumero.getText(),vistaTrasferencia.jcbEstado.getModel().getSelectedItem().toString());
                        vistaTrasferencia.setVisible(false);
                        mensaje = "Se guardo el cambio en el estado de la trasferencia";
                    }
                }
                break;
                case "buscar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        
                        vistaSolicitud.setVisible(false);
                        //modelo.buscarBien(vistaSolicitud.jtfNumero.getText(), vistaSolicitud.jtfIdBuscar.getText());
                        mensaje = "Se encontro el bien";
                    } else {
                        modelo.AutorizarTransferencia(vistaTrasferencia.jtfNumero.getText(), vistaTrasferencia.jtfIdBuscar.getText());
                        vistaTrasferencia.setVisible(false);
                        mensaje = "Se encontro el bien";
                    }
                }
                break;
                case "limpiar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        
                        vistaSolicitud.setVisible(false);
                        //modelo.buscarBien(vistaSolicitud.jtfNumero.getText(), vistaSolicitud.jtfIdBuscar.getText());
                        mensaje = "Se encontro el bien";
                    } else {
                        modelo.AutorizarTransferencia(vistaTrasferencia.jtfNumero.getText(), vistaTrasferencia.jtfIdBuscar.getText());
                        vistaTrasferencia.setVisible(false);
                        mensaje = "Se encontro el bien";
                    }
                }
                break;
                case "cancelar": {
                    mensaje = "No se realizo ningun cambio";
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        
                        vistaSolicitud.setVisible(false);
                        vistaSolicitud.limpiarTodosEspacios();
                    } else {
                        vistaTrasferencia.setVisible(false);
                        vistaSolicitud.limpiarTodosEspacios();
                    }
                }
                break;
                case "cambiar": {
                    mensaje = "Cambiar de usuario";
                    //vistaFuncionario.setVisible(false);

                }
                break;
                case "catalogo": {
                    mensaje = "Cambiar de usuario";
                    //vistaFuncionario.setVisible(false);
                }
                break;
                case "salir": {
                    System.exit(0);
                }
                break;
                default: {
                }
                break;
            }
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
        if (!mensaje.equals("")) {
            vista.mostrarMensaje(mensaje);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        try {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                modelo.cambiarTipo(ie.getItem().toString());
                vista.cambiarValoresTabla(modelo.getTipo());
            }
        } catch (Exception exception) {
            vista.mostrarMensaje(exception.getMessage());
        }
    }
    
    @Override
    public void cerrarVista() {
        vista.dispose();
    }
}

