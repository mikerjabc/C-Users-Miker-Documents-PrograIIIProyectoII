/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Solicitud;
import Logic.Transferencia;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioSolicitud;
import accesoADatos.ServicioTransferencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloJefe extends Observable {
    private ServicioSolicitud servicioSolicitud;
    private ServicioTransferencia servicioTransferencia;
    public String[] tiposSolicitud = {"Incorporación","Traslado"};
    private String tipo;
    private Solicitud solicitud;
    private Transferencia transferencia;
    

    public void setServicioSolicitud(ServicioSolicitud servicioDependencia) {
        this.servicioSolicitud = servicioDependencia;
        tipo = tiposSolicitud[0];
        this.setChanged();
        this.notifyObservers();
    }
    
    public Solicitud buscarSolicitud(String numero) throws Exception {
        Solicitud aux = null;
        try {
            if (numero.equals("")) {
                throw (new Exception("Codigo invalido"));
            }
            if (tipo.equals("")) {
                throw (new Exception("Dependencia invalida"));
            }
            if(tipo.equalsIgnoreCase(tiposSolicitud[0])){
                solicitud = servicioSolicitud.buscarSolicitud(Integer.valueOf(numero));
                transferencia = null;
            }else{
                transferencia = servicioTransferencia.buscarTransferencia(Integer.valueOf(numero));
                solicitud = null;
            }
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
            if (tipo.equals(tiposSolicitud[0])) {
                Iterator<Solicitud> ite = servicioSolicitud.listarSolicitudes().iterator();
                while (ite.hasNext()) {
                    Solicitud d = ite.next();
                    if (d.getEstado().equalsIgnoreCase("por verificar")) {
                        Object[] fila = new Object[6];
                        fila[0] = d.getNumeroSolicitud();
                        fila[1] = d.getFecha();
                        fila[2] = d.getTipo();
                        fila[3] = d.getEstado();
                        fila[4] = d.getCantiadadBienes();
                        fila[5] = d.getMontoTotal();
                        
                        list.add(fila);
                    }
                }
            } else {
                Iterator<Transferencia> ite = servicioTransferencia.listarTransferencia().iterator();
                while (ite.hasNext()) {
                    Transferencia t = ite.next();
                    if (t.getAutorizacion().equalsIgnoreCase("Recibida")) {
                        Object[] fila = new Object[6];
                        fila[0] = t.getNumero();
                        fila[1] = t.getOrigen().getNombre();
                        fila[2] = t.getDestino().getNombre();
                        fila[3] = t.getUbicacion();
                        fila[4] = t.getFuncionario();
                        fila[5] = t.getAutorizacion();
                        
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
