/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Bien;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author MikerJABC
 */
public class ModeloTransferencia extends Observable{
    private ArrayList<Bien> listaBienes;
    private Bien bien;
    public final String[] tiposEstadoTransferencia = {"Recibida","Aceptada","Rechazada"};
    
    public ModeloTransferencia() {
        listaBienes = new ArrayList();
    }
    
    public void buscarBien(String serial) throws Exception {
        if (serial.equals("")) {
            throw (new Exception("Serial invalido"));
        }
        Iterator<Bien> ite = listaBienes.iterator();
        while (ite.hasNext()) {
            Bien d = ite.next();
            bien = d;
            break;
        }
    }
    
    private ArrayList<Object> getListaBien() {
        ArrayList<Object> list = new ArrayList();
        if (bien != null) {
            Object[] fila = {bien.getSerial(), bien.getDescripcion(), bien.getMarca(), bien.getModelo(), bien.getPrecio(), bien.getCantidad()};
            list.add(fila);
        } else {
            Iterator<Bien> ite = listaBienes.iterator();
            while (ite.hasNext()) {
                Bien bien = ite.next();
                Object[] fila = {bien.getSerial(), bien.getDescripcion(), bien.getMarca(), bien.getModelo(), bien.getPrecio(), bien.getCantidad()};
                list.add(fila);
            }
        }
        return list;
    }

    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }

    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
        this.setChanged();
        this.notifyObservers();
    }

    public Bien getBien() {
        return bien;
    }
    
    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaBien());
    }

    public void limpiar() {
        bien = null;
        listaBienes.removeAll(listaBienes);
        this.setChanged();
        this.notifyObservers();
    }
}
