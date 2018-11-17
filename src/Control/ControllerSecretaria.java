/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModeloSecretaria;
import Vista.VistaSecretaria;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioSolicitud;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Fernando
 */
public class ControllerSecretaria extends AbstractController{

    /**
     * @return the vista
     */
    public VistaSecretaria getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaSecretaria vista) {
        this.vista = vista;
    }

    ModeloSecretaria modelo ;
    private VistaSecretaria vista;

    public ControllerSecretaria(ModeloSecretaria modelo, VistaSecretaria vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setModelo(modelo);
        vista.setControlador(this);
        modelo.setVista(vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
              
        JButton btn = (JButton)e.getSource();  
        if(btn.getText().equalsIgnoreCase("buscar")) {
            ServicioSolicitud accesoADatosSolicitud = new ServicioSolicitud();
            try {
                modelo.setTabla( accesoADatosSolicitud.buscarSolicitud(Integer.parseInt(this.vista.getCampoBuscar().getText())));
            } catch (GlobalException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoDataException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if(btn.getText().equalsIgnoreCase("ver solicitudes")) {
            ServicioSolicitud accesoADatosSolicitud = new ServicioSolicitud();
            try {
                modelo.setTabla(accesoADatosSolicitud.listarSolicitudes());
            } catch (GlobalException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoDataException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerSecretaria.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
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
        getVista().setVisible(true);
    }

    @Override
    public void ocultarVista() {
        getVista().setVisible(false);
    }

    public VistaSecretaria getVistaSecretaria() {
        return vista;
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
