/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodos;

import Control.ControllerAdministrador;
 import Vista.VistaBien;
import Vista.VistaAdministrador;

import Modelo.ModeloAdministrador;
import accesoADatos.ServicioBien;
/**
 *
 * @author Fernando
 */
public class ProyectoDos {

    
    public static void main(String[] args) {
        
        ModeloAdministrador modelo = new ModeloAdministrador();
        VistaBien vistaBien = new VistaBien(){};
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        
        ServicioBien accesoADatosBien = null;
        
        
      //  ControllerBien controlBien = new ControllerBien(vistaBien, accesoADatosBien);
    
        ControllerAdministrador controlAdministrador = new ControllerAdministrador(modelo, vistaAdministrador );
       
        //ControllerLogin controllerLogin = new ControllerLogin(new ModeloLogin(), new VistaLogin());
        
        //controllerLogin.getVistaLogin().setVisible(true);
//0000
        controlAdministrador.getVistaAdmistrador().setVisible(true);
    }
    
}
