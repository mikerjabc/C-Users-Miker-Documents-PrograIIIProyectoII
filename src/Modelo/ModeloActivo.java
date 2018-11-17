/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Bien;
import Logic.Funcionario;
import accesoADatos.ServicioFuncionario;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author MikerJABC
 */
public class ModeloActivo extends Observable {

    private Bien bien;
    private Funcionario funcionario;
    private int numeroActivo;
    private ServicioFuncionario servicioFuncionario;
    
    public ModeloActivo(Bien bien,int numeroActivo) {
        this.bien = bien;
        this.funcionario = null;
        this.numeroActivo = numeroActivo;
    }

    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
    }

    public void buscarFuncionario(String id) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            funcionario = servicioFuncionario.consultarFuncionario_Nombre_ID(id);
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    private ArrayList<Object> getListaBien() {
        ArrayList<Object> list = new ArrayList();
        Object[] fila = new Object[3];
        fila[0] = numeroActivo;
        fila[1] = bien.getDescripcion();
        if (funcionario != null) {
            fila[2] = funcionario.getNombre();
        }
        list.add(fila);
        return list;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
        notifyObservers();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public int getNumeroActivo(){
        return numeroActivo;
    }
    
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers(getListaBien());
    }
    
    public void limpiar() {
        bien = null;
        funcionario = null;
        numeroActivo = 0; 
    }
}
