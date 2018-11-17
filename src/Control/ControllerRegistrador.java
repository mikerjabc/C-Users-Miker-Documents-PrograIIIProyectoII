package Control;

import Modelo.ModeloActivo;
import Modelo.ModeloRegistrador;
import Modelo.ModeloSolicitud;
import Vista.VistaActivo;
import Vista.VistaRegistrador;
import Vista.VistaSolicitud;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioActivo;
import accesoADatos.ServicioFuncionario;
import accesoADatos.ServicioSolicitud;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
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
    private VistaActivo vistaActivo;
    private ModeloSolicitud modeloSolicitud;
    private ModeloActivo modeloActivo;

    public ControllerRegistrador(ModeloRegistrador modelo, VistaRegistrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setModelo(modelo);
        vista.setControlador(this);
        this.ajustarVista();
        modelo.setServicioSolicitud(ServicioSolicitud.getServicioSolicitud());
        modelo.setServicioFuncionario(ServicioFuncionario.getServicioFuncionario());
        modelo.setServicioActivo(ServicioActivo.getServicioActivo());
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
        modeloSolicitud = new ModeloSolicitud(modelo.getFuncionario());
        vistaSolicitud.setModelo(modeloSolicitud);
        vistaSolicitud.setControlador(this);
        //
        vistaActivo = new VistaActivo();
        vistaActivo.setControlador(this);
        modeloActivo = null;
    }

    @Override
    public void mouseClicked(MouseEvent ae) {
        String numero;
        try {
            if (ae.getSource().getClass() == JTable.class) {
                JTable tabla = (JTable) ae.getSource();
                numero = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                tabla.changeSelection(tabla.getSelectedRow(), 0, false, true);
                if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0]) && modelo.getSolicitud() != null) {
                    modeloSolicitud.buscarBien(numero);
                } else if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0]) && modelo.getSolicitud() == null) {
                    modelo.buscarIncorporacion_Activo(numero);
                } else if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[1])) {
                    modelo.buscarIncorporacion_Activo(numero);
                }
                
                if (ae.getClickCount() == 1) {
                    switch (ae.getButton()) {
                        case MouseEvent.BUTTON2: {//Click derecho
                            instrucciones("eliminar");
                        }
                        break;
                        case MouseEvent.BUTTON1: {//Click izquierdo
                            if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0]) && modeloSolicitud.getBien() == null) {
                                vistaSolicitud.cargarDatos(modelo.getSolicitud());
                                vistaSolicitud.setVisible(true);
                            } else if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0]) && modeloSolicitud.getBien() != null) {
                                modeloActivo = new ModeloActivo(modeloSolicitud.getBien(),modelo.numeroConsecutivoParaActivo());
                                modeloActivo.setServicioFuncionario(ServicioFuncionario.getServicioFuncionario());
                                vistaActivo.setModelo(modeloActivo);
                                vistaActivo.setVisible(true);
                            } else if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[1])) {
                                vistaActivo.cargarDatos(modelo.getActivo());
                                vistaActivo.setVisible(true);
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
                        if (modelo.getSolicitud() != null) {
                            modelo.agregarActivo(vistaActivo.jtfCodigo.getText(),
                                    vistaActivo.jtfBien.getText(),
                                    vistaActivo.jtfDescripcion.getText(),
                                    vistaActivo.jtfFuncionario.getText(),
                                    vistaActivo.jtfUbicacion.getText()
                            );
                            vistaActivo.limpiarTodosEspacios();
                        }else{
                            vistaSolicitud.setVisible(false);
                            vistaSolicitud.limpiarTodosEspacios();
                            modelo.limpiar();
                        }
                        mensaje = "Se asigno como activo el bien";
                    }
                }
                break;
                case "buscar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0]) && modelo.getSolicitud() != null) {
                        modeloSolicitud.buscarBien(vistaSolicitud.jtfIdBuscar.getText());
                    }else{
                       modelo.buscarIncorporacion_Activo(vista.jtIdBuscar.getText()); 
                    }
                }
                break;
                case "buscarfuncionario": {
                    modeloActivo.buscarFuncionario(vistaActivo.jtfFuncionario.getText());
                    mensaje = "¡Funcionario encontrado!";
                }
                break;
                case "limpiar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        vistaActivo.limpiarTodosEspacios();
                    }
                }
                break;
                case "eliminar": {
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        //
                    }
                }
                break;
                case "cancelar": {
                    mensaje = "No se realizó ningún cambio";
                    if (modelo.getTipo().equalsIgnoreCase(modelo.tiposSolicitud[0])) {
                        if (modelo.getActivo() != null) {
                            vistaActivo.setVisible(false);
                            vistaActivo.limpiarTodosEspacios();
                        }else if (modeloActivo.getBien() == null) {
                            vistaSolicitud.setVisible(false);
                            vistaSolicitud.limpiarTodosEspacios();
                        }else if (modeloActivo.getBien() != null) {
                            vistaActivo.setVisible(false);
                            vistaActivo.limpiarTodosEspacios();
                        }
                    }else{
                        vistaActivo.setVisible(false);
                        vistaActivo.limpiarTodosEspacios();
                    }
                }
                break;
                case "cambiar": {
                    vista.dispose();
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

