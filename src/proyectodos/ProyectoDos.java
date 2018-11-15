/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodos;

import Control.ControllerAdministrador;
import Control.ControllerJefe;
import Control.ControllerSecretaria;
import Logic.Bien;
import Vista.VistaAdministrador;
import Modelo.ModeloAdministrador;
import Modelo.ModeloJefe;
import Modelo.ModeloSecretaria;
import Vista.VistaJefe;
import Vista.VistaSecretaria;
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
     
//        ModeloSecretaria modelo = new ModeloSecretaria();
//        VistaSecretaria vistaSecretaria = new VistaSecretaria();
//        ControllerSecretaria  controlSecretaria = new ControllerSecretaria(modelo, vistaSecretaria );
//        controlSecretaria.getVistaSecretaria().setVisible(true);
        
        ControllerJefe contro = new ControllerJefe(new ModeloJefe(), new VistaJefe());
        contro.mostrarVista();

    }

}
