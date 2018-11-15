/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodos;

import Control.ControllerAdministrador;
import Logic.Bien;
import Vista.VistaAdministrador;
import Modelo.ModeloAdministrador;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioBien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Fernando
 */
public class ProyectoDos {

    
    public static void main(String[] args) throws SQLException  {
        ModeloAdministrador modelo = new ModeloAdministrador();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        ControllerAdministrador controlAdministrador = new ControllerAdministrador(modelo, vistaAdministrador );
        controlAdministrador.getVistaAdmistrador().setVisible(true);
//bla

        
    }

}
