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
import accesoADatos.ServicioBien;
import accesoADatos.ServicioSolicitud;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

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
    
    
    
    public ControllerAdministrador(ModeloAdministrador modelo, VistaAdministrador vistaAdmistrador ) {
        this.vistaAdmistrador = vistaAdmistrador;
        this.modelo = modelo;
        this.modelo.setVista(this.vistaAdmistrador);
         this.vistaAdmistrador = vistaAdmistrador;
         vistaAdmistrador.setControlador(this);
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
               this.vistaAdmistrador.setVisible(false);
           }
           
            if(btn.getText().equalsIgnoreCase("guardar solicitud")){
                guardarSolicitud();
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
        String  tipo = vistaAdmistrador.getCampoTipoAdqui().getSelectedItem().toString();
        accesoADatosSolicitud.insertarSolicitud(tipo,vistaAdmistrador.getCampoMontoTotal().getText(),modelo.getBienes());
    }
    
    
    
    
}
