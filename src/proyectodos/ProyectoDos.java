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
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioBien;
import java.sql.SQLException;
/**
 *
 * @author Fernando
 */
public class ProyectoDos {

    
    public static void main(String[] args) throws GlobalException, NoDataException, SQLException {
        
        ModeloAdministrador modelo = new ModeloAdministrador();
        VistaBien vistaBien = new VistaBien(){};
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        
        ServicioBien accesoADatosBien = null;
        
        ControllerAdministrador controlAdministrador = new ControllerAdministrador(modelo, vistaAdministrador );
        controlAdministrador.getVistaAdmistrador().setVisible(true);
    }
    
}
