/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Activo;
import accesoADatos.ServicioActivo;
import accesoADatos.ServicioBien;
import accesoADatos.ServicioFuncionario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class ModeloTransferencia extends Observable {

    private ArrayList<Activo> listaActivos;
    private Activo activo;
    public final String[] tiposEstadoTransferencia = {"Recibida", "Aceptada", "Rechazada"};
    public ServicioActivo servicioActivo;
    private ServicioFuncionario servicioFuncionario;
    private ServicioBien servicioBien;
    
    public void setServicioActivo(ServicioActivo servicioActivo){
        this.servicioActivo = servicioActivo;
    }
    
    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
    }
    
    public void setServicioBien(ServicioBien servicioBien) {
        this.servicioBien = servicioBien;
    }
    
    public ModeloTransferencia() {
        listaActivos = new ArrayList();
    }

    public void eliminarActivo(Activo activo) throws Exception {
        try {
            listaActivos.remove(activo);
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    public void buscarActivo(String codigo) throws Exception {
        try {
            if (codigo.equals("")) {
                throw (new Exception("Serial invalido"));
            }
            Iterator<Activo> ite = listaActivos.iterator();
            while (ite.hasNext()) {
                Activo d = ite.next();
                if(d.getCodigoActivo() == Integer.valueOf(codigo)){
                  activo = d;
                  break;
                }
            }
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    private ArrayList<Object> getListaActivo() {
        ArrayList<Object> list = new ArrayList();
        if (activo != null) {
            Object[] fila = {activo.getCodigoActivo(), activo.getBien().getDescripcion(), activo.getFuncionario(), activo.getUbicacion()};
            list.add(fila);
        } else {
            Iterator<Activo> ite = listaActivos.iterator();
            while (ite.hasNext()) {
                Activo activo = ite.next();
                Object[] fila = {activo.getCodigoActivo(), activo.getBien().getDescripcion(), activo.getFuncionario(), activo.getUbicacion()};
                list.add(fila);
            }
        }
        return list;
    }

    public ArrayList<Activo> getListaActivos() {
        return listaActivos;
    }

    public void setListaActivos(ArrayList<Activo> listaActivos) {
        this.listaActivos = listaActivos;
        this.setChanged();
        this.notifyObservers();
    }

    public Activo getActivo() {
        return activo;
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaActivo());
    }

    public void limpiar() {
        activo = null;
        listaActivos.removeAll(listaActivos);
        this.setChanged();
        this.notifyObservers();
    }
}
