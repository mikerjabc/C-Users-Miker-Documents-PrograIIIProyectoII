/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModeloAdministrador;
import Modelo.ModeloJefe;
import Modelo.ModeloLogin;
import Modelo.ModeloRecurHumanos;
import Modelo.ModeloRegistrador;
import Modelo.ModeloSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Vista.VistaLogin;
 import Vista.VistaAdministrador;
import Vista.VistaSecretaria;
import Vista.VistaRegistrador;
import Vista.VistaJefe;
import Vista.VistaRecursosHumanos;


public class ControllerLogin implements MouseListener, ActionListener, KeyListener{

    private AbstractController controlador;;
    // Daclaramos las vistas a las cuales vamos acceder
    
    private VistaLogin vista;
    private ModeloLogin modelo;
    
     
    
    public ControllerLogin(ModeloLogin modelo, VistaLogin vista){
        this.vista = vista;
        this.modelo = modelo;
        vista.setModelo(modelo);
        vista.setControlador(this);
    }
    
    public VistaLogin getVistaLogin() {
        return vista;
    }

    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vista = vistaLogin;
    }
    
    // Acá vamos a validar el acceso y de esta misma menaera podremos asiganar una ventana
    // a cada uno para que cumplan sus funciones
    
    public boolean validarIngreso(String id, String pass) {
        if (id.equals("registrador") && pass.equals("regis123")) {
            JOptionPane.showMessageDialog(null, "Eres un perro Registrador sigue adelante");
            if (controlador != null) {
                controlador.ocultarVista();
                controlador = null;
            }
            controlador = new ControllerRegistrador(new ModeloRegistrador(), new VistaRegistrador());
            vista.setVisible(false);
            controlador.mostrarVista();

            return true;
        } else if (id.equals("admin") && pass.equals("admin123")) {
            JOptionPane.showMessageDialog(null, "Eres un perro Administrador sigue adelante");
            if (controlador != null) {
                controlador.ocultarVista();
                controlador = null;
            }
            //controlador = new ControllerAdministrador(new ModeloAdministrador(), new VistaAdministrador());
            vista.setVisible(false);
            controlador.mostrarVista();
            return true;

        } else if (id.equals("secretaria") && pass.equals("secre123")) {
            JOptionPane.showMessageDialog(null, "Eres un perra Secretaria sigue adelante");
            if (controlador != null) {
                controlador.ocultarVista();
                controlador = null;
            }
            controlador = new ControllerSecretaria(new ModeloSecretaria(), new VistaSecretaria());
            vista.setVisible(false);
            controlador.mostrarVista();
            return true;
        } else if (id.equals("jefe") && pass.equals("jefe123")) {
            JOptionPane.showMessageDialog(null, "Eres un puto Jefe sigue adelante");
            if (controlador != null) {
                controlador.ocultarVista();
                controlador = null;
            }
            controlador = new ControllerJefe(new ModeloJefe(), new VistaJefe());
            vista.setVisible(false);
            controlador.mostrarVista();
            return true;
        } else if (id.equals("recursoshumanos") && pass.equals("recurhuma123")) {
            JOptionPane.showMessageDialog(null, "Eres un perro de Recursos Huamanos sigue adelante");
            if (controlador != null) {
                controlador.ocultarVista();
                controlador = null;
            }
            controlador = new ControllerRecurHumanos(new ModeloRecurHumanos(), new VistaRecursosHumanos());
            vista.setVisible(false);
            controlador.mostrarVista();
            return true;
        }

        JOptionPane.showMessageDialog(null, "Usurio Invalido");
        return false;
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

    
    public void encuentraCuales() {
        if (!this.vista.getCampoID().getText().equals("") && !this.vista.getCampoPassword().getText().equals("")){
                
                if ( validarIngreso(this.getVistaLogin().getCampoID().getText(),this.getVistaLogin().getCampoPassword().getText()) ) {
                    
            }//debe imprimirlo la vista    
            else JOptionPane.showMessageDialog(null,"campos vacios");
    }
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       JButton btn =(JButton)e.getSource();

        if (btn.getText().equalsIgnoreCase("ingresar")){
            encuentraCuales();
        }
        
        if (btn.getText().equalsIgnoreCase("salir")){
            System.exit(0);
        }
//        this.getControlPrincipal().getViewPrincipal().setVisible(true);
//        this.getVistaLogin().setVisible(false);
    
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
