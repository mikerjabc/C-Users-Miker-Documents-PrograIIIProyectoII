/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Vista.VistaBien;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioBien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import Control.ControllerSolicitud;
import Logic.Bien;
import javax.swing.JTextField;

/**
 *
 * @author Fernando
 */
public class ControllerBien implements MouseListener, ActionListener, KeyListener {

    
    ControllerSolicitud controlSolicitud;
    ControllerAdministrador elControlAdministrador;

    
    
    public VistaBien getVistaBien() {
        return vistaBien;
    }

  
    public void setVistaBien(VistaBien vistaBien) {
        this.vistaBien = vistaBien;
    }
    
    private VistaBien vistaBien;
    private ServicioBien accesoADatosBien;
    
    
    
    public ControllerBien(VistaBien vistaBien , ServicioBien accesoADatosBien,ControllerAdministrador elControlAdministrador){
        this.vistaBien = vistaBien ;
        this.accesoADatosBien = accesoADatosBien;
        this.vistaBien.setController(this);
        this.elControlAdministrador = elControlAdministrador;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
          JButton btn =(JButton)e.getSource();
 
          if (btn.getText().equalsIgnoreCase("Cancelar")){
              this.vistaBien.setVisible(false);
           }
 
          if (btn.getText().equalsIgnoreCase("guardar")){
              if (verificarCampos()){
                          String marca  = this.vistaBien.getCampoMarca().getText();
                          String descripcion = this.vistaBien.getCampoDescripcion().getText();
                          String modelo = this.vistaBien.getCampoModelo().getText();
                          String serial = this.vistaBien.getCampoSerial().getText();
                          String precioUnitario = this.vistaBien.getCampoPrecioUnitario().getText();
                          int cantidad  = (int)this.vistaBien.getCampoCantidadUnidades().getValue();
                          Bien  bien = new Bien(serial,descripcion,marca,modelo,Integer.parseInt(precioUnitario),cantidad);
                          
                          elControlAdministrador.getModelo().updateTable(bien);
                          this.vistaBien.setVisible(false);
                          
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

    private boolean verificarCampos() {
        
        
              if (this.vistaBien.getCampoMarca().getText().equals("")){ this.vistaBien.campoVacio("Marca"); return false;}        
              if (this.vistaBien.getCampoModelo().getText().equals("")){this.vistaBien.campoVacio("Modelo"); return false;}    
              if (this.vistaBien.getCampoCantidadUnidades().getValue().equals(0)){this.vistaBien.campoVacio("Cantidad de Unidades");return false;} 
              if (this.vistaBien.getCampoDescripcion().getText().equals("")){this.vistaBien.campoVacio("Nombre");return false;} 
              if (this.vistaBien.getCampoSerial().getText().equals("")){this.vistaBien.campoVacio("Serial");return false;}
              return true;
    }
}
