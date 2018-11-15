/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Solicitud;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioSolicitud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloJefe extends Observable {
    private ServicioSolicitud servicioSolicitud;
    public String[] tiposSolicitud = {"Incorporación","Traslado"};
    private String tipo;

    public void setServicioSolicitud(ServicioSolicitud servicioDependencia) {
        this.servicioSolicitud = servicioDependencia;
        tipo = tiposSolicitud[0];
        this.setChanged();
        this.notifyObservers();
    }
    
    public Solicitud buscarSolicitud(String numero, String tipo) throws Exception {
        Solicitud aux = null;
        try {
            if (numero.equals("")) {
                throw (new Exception("Codigo invalido"));
            }
            if (tipo.equals("")) {
                throw (new Exception("Dependencia invalida"));
            }
            //aux = servicioSolicitud.consultarBienesMuebles(Integer.valueOf(numero));
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
        return aux;
    }
    
    public void cambiarTipo(String tipo) throws Exception {
        try {
            if (tipo.equals("")) {
                throw (new Exception("Debe ingresar un codigo"));
            }
            this.tipo = tipo;
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public ArrayList<Object> getListaSolicitudes() {
        ArrayList<Object> list = new ArrayList();
        try {
            Iterator<Solicitud> ite = servicioSolicitud.listarSolicitudes().iterator();
            if (tipo.equals(tiposSolicitud[0])) {
                while (ite.hasNext()) {
                    Solicitud d = ite.next();
                    if (d.getEstado().equalsIgnoreCase("por verificar") && d.getTipo().equalsIgnoreCase(tipo)) {
                        Object[] fila = new Object[5];
                        fila[0] = d.getNumeroSolicitud();
                        fila[1] = d.getFecha();
                        fila[2] = d.getEstado();
                        fila[3] = d.getCantiadadBienes();
                        list.add(fila);
                    }
                }
            } else {
                while (ite.hasNext()) {
                    Solicitud d = ite.next();
                    if (d.getTipo().equalsIgnoreCase(tipo)) {
                        Object[] fila = new Object[5];
                        fila[0] = d.getNumeroSolicitud();
                        fila[1] = d.getFecha();
                        fila[2] = d.getEstado();
                        fila[3] = d.getCantiadadBienes();
                        list.add(fila);
                    }
                }
            }
        } catch (GlobalException | NoDataException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaSolicitudes());
    }

    public void limpiar() {
        this.setChanged();
        this.notifyObservers();
    }
}
