/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModeloJefe;
import Modelo.ModeloRegistrador;
import Vista.VistaJefe;
import Vista.VistaRegistrador;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Fernando
 */
public class ControllerJefe extends AbstractController{

    ModeloJefe modelo ;
    VistaJefe vista;

    public ControllerJefe(ModeloJefe modelo, VistaJefe vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setModelo(modelo);
        vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
//                    modelo.agregarProducto(vista.jtfCodigoProducto.getText(), vista.jtfCantidad.getText());
//                    vista.limpiarEspacios();
//                    mensaje = "Se ingresó el producto";
                }
                break;
                case "buscar": {
//                    modelo.buscarFactura(vista.jtfNumero.getText());
//                    vista.jbAgregar.setEnabled(false);
//                    vista.jbGuardar.setEnabled(false);
                }
                break;
                case "guardar": {
//                    modelo.crearFactura(vista.jtfNombre.getText(),vista.jtfFecha.getText());
//                    vista.limpiarTodosEspacios();
//                    mensaje = "Se ingresó la factura";
                }
                break;
                case "limpiar": {
//                    modelo.limpiar();
//                    vista.jbAgregar.setEnabled(true);
//                    vista.jbGuardar.setEnabled(true);
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
}
