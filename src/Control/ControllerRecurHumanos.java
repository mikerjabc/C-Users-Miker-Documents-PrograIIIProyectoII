/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Logic.Funcionario;
import Modelo.ModeloRecurHumanos;
import Vista.VistaFuncionario;
import Vista.VistaRecursosHumanos;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioDependencia;
import accesoADatos.ServicioFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTable;

/**
 *
 * @author Fernando
 */
public class ControllerRecurHumanos extends AbstractController implements ItemListener{

    private ModeloRecurHumanos modelo ;
    private VistaRecursosHumanos vista;
    private VistaFuncionario vistaFuncionario;

    public ControllerRecurHumanos(ModeloRecurHumanos modelo, VistaRecursosHumanos vista) {
        this.modelo = modelo;
        this.vista = vista;
        modelo.setServicioDependencia(ServicioDependencia.getServicioDependencia());
        modelo.setServicioFuncionario(ServicioFuncionario.getServicioFuncionario());
        vista.setModelo(modelo);
        vista.setControlador(this);
        vistaFuncionario = new VistaFuncionario();
        vistaFuncionario.setModelo(modelo);
        vistaFuncionario.setControlador(this);
        vistaFuncionario.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().getClass() == JButton.class) {
                JButton button = (JButton) ae.getSource();
                crud(button.getName());
            }
            if (ae.getSource().getClass() == JMenuItem.class) {
                JMenuItem button = (JMenuItem) ae.getSource();
                crud(button.getName());
            }
        } catch (Exception ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent ae) {
        String id, numero;
        try {
            if (ae.getSource().getClass() == JTable.class) {
                JTable tabla = (JTable) ae.getSource();
                id = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                numero = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
                tabla.changeSelection(tabla.getSelectedRow(), 0, false, true);
                modelo.buscarFuncionario(id);
                if (ae.getClickCount() == 1) {
                    switch (ae.getButton()) {
                        case MouseEvent.BUTTON2: {//Click derecho
                            crud("eliminar");
                        } break;
                        case MouseEvent.BUTTON1: {//Click izquierdo
                            vistaFuncionario.cargarDatos(modelo.getFuncionario(), numero);
                            vistaFuncionario.setVisible(true);
                        }break;
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
    
    public void crud(String x) throws Exception {
        String mensaje = "";
        try {
            switch (x.toLowerCase()) {
                case "agregar": {
                    modelo.crearFuncionario(vistaFuncionario.jtfId.getText(),
                                            vistaFuncionario.jtfNombre.getText(),
                                            vistaFuncionario.jcbPuesto.getModel().getSelectedItem().toString(),
                                            vistaFuncionario.jtfContrasenna.getText(),
                                            vistaFuncionario.jcbDependencia.getModel().getSelectedItem().toString());
                    mensaje = "Se ingresó el funcionario";
                    modelo.limpiar();
                    vistaFuncionario.setVisible(false);
                    vistaFuncionario.limpiarTodos();
                    vistaFuncionario.dispose();
                }
                break;
                case "nuevo": {
                    vistaFuncionario.setVisible(true);
                }
                break;
                case "eliminar": {
                    if (vista.confirmacionDeAccion("¿Eliminar Funcionario?")) {
                        modelo.eliminarFuncionario(modelo.getFuncionario().getId());
                        mensaje = "El funcionario fue eliminado";
                    } else {
                        mensaje = "No se ha realizado ningun cambio";
                    }
                }
                break;
                case "modificar": {
                    modelo.modificarFuncionario(vistaFuncionario.jtfId.getText(),
                                                vistaFuncionario.jtfNombre.getText(),
                                                vistaFuncionario.jcbPuesto.getModel().getSelectedItem().toString(),
                                                vistaFuncionario.jtfContrasenna.getText());
                    mensaje = "El cambio fue guardado con éxito";
                    modelo.limpiar();
                    vistaFuncionario.setVisible(false);
                    vistaFuncionario.limpiarTodos();
                    vistaFuncionario.dispose();
                }
                break;
                case "buscar": {
                    modelo.buscarFuncionario(vista.jtIdBuscar.getText());
                }
                break;
                case "limpiar": {
                    vistaFuncionario.limpiarTodos();
                }
                break;
                case "cancelar": {
                    mensaje = "No se realizo ningun cambio";
                    modelo.limpiar();
                    vistaFuncionario.setVisible(false);
                    vistaFuncionario.dispose();
                    vistaFuncionario.limpiarTodos();
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
            if (ie.getSource().getClass() == JComboBox.class) {
                modelo.cambiarDependencia(ie.getItem().toString());
            }
        } catch (Exception ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    @Override
    public void cerrarVista() {
        vista.dispose();
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        vista.setEnabled(false);
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
        vista.setEnabled(true);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
