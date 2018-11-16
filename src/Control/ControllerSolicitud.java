/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Vista.VistaBien;
import Vista.VistaAdministrador;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioBien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import accesoADatos.ServicioSolicitud;
import java.sql.SQLException;
import java.util.ArrayList;
import Vista.VistaBien;
import Logic.Bien;



/**
 *
 * @author Fernando
 */
public class ControllerSolicitud implements MouseListener, ActionListener, KeyListener {

    VistaAdministrador vistaAdministrador;
    //Solicitud solicitudes;
    ServicioSolicitud accesoADatosSolicitudes;
    ServicioBien accesoADatosBienes;
    
    ArrayList<Bien> bienes = new ArrayList<>();
    
    ControllerBien controlBien;
    
   
    VistaBien vistaBien;

  
    
  
    public VistaAdministrador getVistaLogin() {
        return vistaAdministrador;
    }

  
    public void setVistaLogin(VistaAdministrador vistaSolicitud) {
        this.vistaAdministrador = vistaSolicitud;
    }

    
    
    public ControllerBien getControlBien() {
        return controlBien;
    }

    
    public void setControlPrincipal(ControllerBien controlBien) {
        this.controlBien = controlBien;
    }

    
    
    public VistaAdministrador getVistaSolicitud() {
        return vistaAdministrador;
    }
    
 
    
    void cargarTablas() throws GlobalException, NoDataException, SQLException{
         // ArrayList<Bien> bien  = accesoADatosBienes.listarBienes();
          this.vistaAdministrador.dtm.setRowCount(0);
          for (int i = 0; i < bienes.size(); i++){
             // this.vistaSolicitud.dtm.addRow(new Object [] {bienes.get(i).getSerial(), bienes.get(i).getNombre(), bienes.get(i).getMarca()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
          JButton btn =(JButton)e.getSource();
          
          
          if (btn.getText().equalsIgnoreCase("cancelar")){
            this.vistaAdministrador.setVisible(false);
          }
          if (btn.getText().equalsIgnoreCase("Agregar Bien")) {
              VistaBien VistaBien = new VistaBien();
        //      ControllerBien controllerBien = new ControllerBien(vistaBien, accesoADatosBienes,thi);
          //    this.getControlBien().getVistaBien().setVisible(true);
              // o de esta forma controllerBien.getVistaBien().setVisible(true);
          }
          
          if (btn.getText().equalsIgnoreCase("aceptar")){
              System.out.println("Control.ControllerSolicitud.actionPerformed()");
          }
          if (btn.getText().equalsIgnoreCase("agregar bien")){
               this.getControlBien().getVistaBien().setVisible(true);
               this.getVistaSolicitud().setVisible(false);
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
 
    }

