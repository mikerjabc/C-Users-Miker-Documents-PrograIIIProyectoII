/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModeloAdministrador;
import Vista.VistaBien;
 import Vista.VistaLogin;
import Vista.VistaAdministrador;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioBien;
import accesoADatos.ServicioSolicitud;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ControllerAdministrador extends AbstractController{

    /**
     * @return the modelo
     */
    public ModeloAdministrador getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloAdministrador modelo) {
        this.modelo = modelo;
    }
    
    public VistaAdministrador getVistaAdmistrador() {
        return vistaAdmistrador;
    }

    public void setVistaAdmistrador(VistaAdministrador vistaAdmistrador) {
        this.vistaAdmistrador = vistaAdmistrador;
    }

    public VistaLogin getVistaLogin() {
        return vistaLogin;
    }

    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }

    public VistaAdministrador getVistaSolicitud() {
        return vistaSolicitud;
    }

    public void setVistaSolicitud(VistaAdministrador vistaSolicitud) {
        this.vistaSolicitud = vistaSolicitud;
    }

    public VistaBien getVistaBien() {
        return vistaBien;
    }

    public void setVistaBien(VistaBien vistaBien) {
        this.vistaBien = vistaBien;
    }

    public ControllerBien getControlbien() {
        return controlbien;
    }

    public void setControlbien(ControllerBien controlbien) {
        this.controlbien = controlbien;
    }

    public ControllerLogin getControlLogin() {
        return controlLogin;
    }

    public void setControlLogin(ControllerLogin controlLogin) {
        this.controlLogin = controlLogin;
    }

    
    public ControllerSolicitud getControlSolicitud() {
        return controlSolicitud;
    }

    
    public void setControlSolicitud(ControllerSolicitud controlSolicitud) {
        this.controlSolicitud = controlSolicitud;
    }
    
    
    public VistaAdministrador vistaAdmistrador;
    public VistaLogin vistaLogin;
    public VistaAdministrador vistaSolicitud;
    public VistaBien vistaBien;
    
    private ModeloAdministrador modelo;
    
    public ControllerBien controlbien;
    public ControllerLogin controlLogin;
    public ControllerSolicitud controlSolicitud;
    public ServicioBien accesoADatosBien;
    public ServicioSolicitud accesoADatosSolicitud;
    
    
    
    public ControllerAdministrador(ModeloAdministrador modelo, VistaAdministrador vistaAdmistrador )   {
        this.vistaAdmistrador = vistaAdmistrador;
        this.modelo = modelo;
        this.modelo.setVista(this.vistaAdmistrador);
         this.vistaAdmistrador = vistaAdmistrador;
         vistaAdmistrador.setControlador(this);
         
        try {
            cargar();
        } catch (GlobalException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton btn = (JButton)e.getSource();
        
        if(btn.getText().equalsIgnoreCase("Agregar Bien")) {
            vistaBien = new VistaBien();
            accesoADatosBien = new ServicioBien();
            controlbien = new ControllerBien(vistaBien, accesoADatosBien, this);
            controlbien.getVistaBien().setVisible(true); 
        }
           if(btn.getText().equalsIgnoreCase("Cancelar")) {
                 this.vistaAdmistrador.getPanelAgregaNuevaSolicitud().setVisible(false);
                 this.vistaAdmistrador.dtm.setRowCount(0);
                 String [] titulo1 = new String []{"#Solicitud", "fecha ","tipo adquisicion", "estado"};
                 this.vistaAdmistrador.dtm.setColumnIdentifiers(titulo1);
                 this.vistaAdmistrador.getTituloDeTabla().setText("Mis Solicitudes");   
           }
            if(btn.getText().equalsIgnoreCase("guardar solicitud")){                 
                this.vistaAdmistrador.getPanelAgregaNuevaSolicitud().setVisible(false);
                guardarSolicitud();
            }
             if(btn.getText().equalsIgnoreCase("Nueva Solicitud")){
                     String [] titulo = new String []{"Descripcion", "Modelo", "Serial", "Precio", "Cantidad"};
                     this.vistaAdmistrador.dtm.setRowCount(0);
                     this.vistaAdmistrador.dtm.setColumnIdentifiers(titulo);
                     this.vistaAdmistrador.getPanelAgregaNuevaSolicitud().setVisible(true);
                     this.vistaAdmistrador.getTituloDeTabla().setText("Bienes de la Solicitud");     
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
        vistaAdmistrador.setVisible(true);
    }

    @Override
    public void ocultarVista() {
        vistaAdmistrador.setVisible(false);
    }

    private void guardarSolicitud() {
        accesoADatosSolicitud = new ServicioSolicitud();
         try {
            accesoADatosSolicitud.insertarSolicitud(modelo.getSolicitud());
        } catch (GlobalException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         accesoADatosBien = new ServicioBien();
         
         for (int i = 0; i < modelo.getBienes().size(); i++) {
            try {
                accesoADatosBien.insertarBien(modelo.getBienes().get(i), modelo.getSolicitud().getNumeroSolicitud() );
            } catch (GlobalException ex) {
                Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoDataException ex) {
                Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
        JOptionPane.showMessageDialog(null," Solicitud Agregada Satisfactoriamente" );
        modelo.limpiar();
         try {
            cargar();
        } catch (GlobalException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargar() throws GlobalException, NoDataException, SQLException {
        accesoADatosSolicitud =  new ServicioSolicitud();
        System.out.println(accesoADatosSolicitud.listarSolicitudes().toString());
        modelo.setNumeroNuevoSolicitud( accesoADatosSolicitud.listarSolicitudes());
        
        String [] titulo1 = new String []{"#Solicitud", "fecha ","tipo adquisicion", "estado"};
        this.vistaAdmistrador.dtm.setColumnIdentifiers(titulo1);
    }
    
    @Override
    public void cerrarVista() {
        //vista.dispose();
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
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
