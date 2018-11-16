/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Bien;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Observable;

/**
 *
 * @author MikerJABC
 */
public class ModeloSolicitud extends Observable{
    private ArrayList<Bien> listaBienes;
    private Bien bien;
    public final String[] tiposBien = {"Compra","Donación","Producción institucional"};
    public final String[] tiposEstadoSolicitud = {"Recibida","Por verificar","Rechazada","Espera de rotulación", "Procesada"};
    
    public ModeloSolicitud() {
        listaBienes = new ArrayList();
    }
    
    public void agregarBien(String serial, String descripcion, String modelo, String marca, String precio, String cantidad) throws Exception {
        if (serial.equals("")) {
            throw (new Exception("Serial invalido"));
        }
        if (descripcion.equals("")) {
            throw (new Exception("Descripción invalida"));
        }
        if (modelo.equals("")) {
            throw (new Exception("Modelo invalido"));
        }
        if (marca.equals("")) {
            throw (new Exception("Marca invalida"));
        }
        if (precio.equals("")) {
            throw (new Exception("Precio invalido"));
        }
        if (cantidad.equals("")) {
            throw (new Exception("Cantidad invalida"));
        }
        listaBienes.add(new Bien(serial,descripcion,modelo,marca,Integer.valueOf(precio),Integer.valueOf(cantidad)));
    }
    
    public void eliminarBien(Bien bien) throws Exception {
        try{
            listaBienes.remove(bien);
        }
        catch(Exception ex){
            throw(new Exception(ex.getMessage()));
        }
    }
    
    public void modificarBien(String serial, String descripcion, String modelo, String marca, String precio, String cantidad) throws Exception {
        try {
            if (serial.equals("")) {
                throw (new Exception("Serial invalido"));
            }
            if (descripcion.equals("")) {
                throw (new Exception("Descripción invalida"));
            }
            if (modelo.equals("")) {
                throw (new Exception("Modelo invalido"));
            }
            if (marca.equals("")) {
                throw (new Exception("Marca invalida"));
            }
            if (precio.equals("")) {
                throw (new Exception("Precio invalido"));
            }
            if (cantidad.equals("")) {
                throw (new Exception("Cantidad invalida"));
            }
            ListIterator<Bien> ite = listaBienes.listIterator();
            while (ite.hasNext()) {
                Bien d = ite.next();
                if (bien.getSerial().equals(d.getSerial())) {
                    listaBienes.set(ite.previousIndex(), new Bien(serial, descripcion, modelo, marca, Integer.valueOf(precio), Integer.valueOf(cantidad)));
                    break;
                }
            }
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }

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
