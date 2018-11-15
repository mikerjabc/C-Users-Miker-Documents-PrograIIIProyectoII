/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.sql.Date;
import java.util.ArrayList;

import java.util.Observable;
/**
 *
 * @author Fernando
 */
public class Solicitud extends Observable {

    private int numeroSolicitud;
    private String fecha;
    private String tipo;
    private String estado;
    private int cantiadadBienes;
    public float montoTotal;
    private ArrayList<Bien> listaBienes;

    public Solicitud(int numeroSolicitud, String fecha, String tipo, String estado ) {
        this.numeroSolicitud = numeroSolicitud;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantiadadBienes() {
        return cantiadadBienes;
    }

    public void setCantiadadBienes(int cantiadadBienes) {
        this.cantiadadBienes = cantiadadBienes;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }

    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }
}
