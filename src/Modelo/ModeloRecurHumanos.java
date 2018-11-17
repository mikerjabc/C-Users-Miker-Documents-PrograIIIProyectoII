/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Dependencia;
import Logic.Funcionario;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioDependencia;
import accesoADatos.ServicioFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MikerJABC
 */
public class ModeloRecurHumanos extends Observable {
    private ServicioDependencia servicioDependencia;
    private ServicioFuncionario servicioFuncionario;
    public final String ALL = "Todas";
    public final String[] tiposSolicitud = {"-","Administrador","Registrador","Jefe","Secretaria","Recursos Humanos"};
    private Funcionario funcionario;
    private int codigoDependencia;
    
    
    public ModeloRecurHumanos(){
        funcionario = null;
        codigoDependencia = -1;
    }

    public void setServicioDependencia(ServicioDependencia servicioDependencia) {
        this.servicioDependencia = servicioDependencia;
    }
    
    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
    }
    
    public void modificarFuncionario(String id, String nombre, String puesto, String password) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            if (nombre.equals("")) {
                throw (new Exception("Nombre invalido"));
            }
            if (puesto.equals("") || puesto.equals("-")) {
                throw (new Exception("Puesto invalido"));
            }
            if (password.equals("")) {
                throw (new Exception("Contraseña invalida"));
            }
            servicioFuncionario.modificarFuncionario(new Funcionario(id, nombre, puesto, password));
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    public void crearFuncionario(String id, String nombre, String puesto, String password, String dependencia) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            if (nombre.equals("")) {
                throw (new Exception("Nombre invalido"));
            }
            if (puesto.equals("") || puesto.equals("-")) {
                throw (new Exception("Puesto invalido"));
            }
            if (password.equals("")) {
                throw (new Exception("Contraseña invalida"));
            }
            if (dependencia.equals("") || id.equals(ALL)) {
                throw (new Exception("Dependencia invalida"));
            }
            servicioFuncionario.insertarFuncionario(new Funcionario(id, nombre, puesto, password), servicioDependencia.buscarDependenciaPorNombre(dependencia).getCodigo());
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    public void eliminarFuncionario(String id) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            servicioFuncionario.eliminarFuncionario(id);
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void buscarFuncionario(String id) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("Codigo invalido"));
            }
            funcionario = servicioFuncionario.consultarFuncionario(id);
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void cambiarDependencia(String nombre) throws Exception {
        try {
            if (nombre.equals("")) {
                throw (new Exception("Debe ingresar un codigo"));
            }
            if (nombre.equals(ALL)) {
                codigoDependencia = -1;
            }else{
                codigoDependencia = servicioDependencia.buscarDependenciaPorNombre(nombre).getCodigo();
            }
            funcionario = null;
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public ArrayList<Object> getListaFuncionarios(){
        ArrayList<Object> list = new ArrayList();
        try {
            if (funcionario == null && codigoDependencia == -1) {
                Iterator<Dependencia> ite = servicioDependencia.listarDependencia().iterator();
                while (ite.hasNext()) {
                    Dependencia d = ite.next();
                    Iterator<Funcionario> ite2 = d.getListaFuncionarios().iterator();
                    while (ite2.hasNext()) {
                        Funcionario e = ite2.next();
                        Object[] fila = new Object[5];
                        fila[0] = e.getId();
                        fila[1] = e.getNombre();
                        fila[2] = e.getPuesto();
                        fila[3] = d.getNombre();
                        list.add(fila);
                    }
                }
            } else if (funcionario == null) {
                Dependencia dep = servicioDependencia.buscarDependencia(codigoDependencia);
                Iterator<Funcionario> ite = dep.getListaFuncionarios().iterator();
                while (ite.hasNext()) {
                    Funcionario e = ite.next();
                    Object[] fila = new Object[5];
                    fila[0] = e.getId();
                    fila[1] = e.getNombre();
                    fila[2] = e.getPuesto();
                    fila[3] = dep.getNombre();
                    list.add(fila);
                }
            } else {
                Object[] fila = new Object[5];
                fila[0] = funcionario.getId();
                fila[1] = funcionario.getNombre();
                fila[2] = funcionario.getPuesto();
                fila[3] = servicioFuncionario.consultarDependenciaPorFuncionario(funcionario.getId()).getNombre();
                list.add(fila);
            }
        } catch (GlobalException | NoDataException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<String> getNombresDependencias() {
        ArrayList<String> list = new ArrayList();
        list.add(ALL);
        try {
            if(servicioDependencia.listarDependencia() != null){
            Iterator<Dependencia> ite = servicioDependencia.listarDependencia().iterator();
                while (ite.hasNext()) {
                    list.add(ite.next().getNombre());
                }
            }
            this.notifyObservers();
        } catch (GlobalException | NoDataException ex) {} catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getCodigoDependencia(String nombre) {
        int codigo = -1;
        try {
            if(servicioDependencia.listarDependencia() == null){
            Iterator<Dependencia> ite = servicioDependencia.listarDependencia().iterator();
                while (ite.hasNext()) {
                    Dependencia d = ite.next();
                    if(d.getNombre().equals(nombre)){
                        codigo = d.getCodigo();
                        break;
                    }
                }
            }
            this.notifyObservers();
        } catch (GlobalException | NoDataException ex) {} catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
    
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers(getListaFuncionarios());
    }

    public void limpiar() {
        funcionario = null;
        this.setChanged();
        this.notifyObservers();
    }
}
