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
    private Dependencia dependencia;
    public final String ALL = "Todas";
    
    public ModeloRecurHumanos(){
        dependencia = null;
    }

    public void setServicioDependencia(ServicioDependencia servicioDependencia) {
        this.servicioDependencia = servicioDependencia;
        dependencia = null;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarFuncionario(String id, String nombre, String puesto, String password, String dependencia) throws Exception {
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
            if (dependencia.equals("") || id.equals("-")) {
                throw (new Exception("Dependencia invalida"));
            }
            servicioFuncionario.modificarFuncionario(new Funcionario(id, nombre, puesto, password));
            this.dependencia = servicioDependencia.consultarDependencia(Integer.valueOf(dependencia));
            this.setChanged();
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
            if (dependencia.equals("") || id.equals("-")) {
                throw (new Exception("Dependencia invalida"));
            }
            servicioFuncionario.insertarFuncionario(new Funcionario(id, nombre, puesto, password), Integer.valueOf(dependencia));
            this.dependencia = servicioDependencia.consultarDependencia(Integer.valueOf(dependencia));
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }

    public void eliminarFuncionario(String id, String dependencia) throws Exception {
        try {
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            if (dependencia.equals("")) {
                throw (new Exception("Dependencia invalida"));
            }
            servicioFuncionario.eliminarFuncionario(id);
            this.dependencia = servicioDependencia.consultarDependencia(Integer.valueOf(dependencia));
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public Funcionario buscarFuncionario(String id, String dependencia) throws Exception {
        Funcionario aux = null;
        try {
            if (id.equals("")) {
                throw (new Exception("Codigo invalido"));
            }
            if (dependencia.equals("")) {
                throw (new Exception("Dependencia invalida"));
            }
            if (servicioFuncionario.consultarFuncionario(id) == null) {
                throw (new Exception("No existe este funcionario en la base de datos"));
            }
            this.dependencia = servicioDependencia.consultarDependencia(Integer.valueOf(dependencia));
            this.dependencia.setListaFuncionarios(new ArrayList());
            aux = servicioFuncionario.consultarFuncionario(id);
            this.dependencia.getListaFuncionarios().add(aux);
            
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
        return aux;
    }
    
    public void cambiarDependencia(String codigo) throws Exception {
        try {
            if (codigo.equals("")) {
                throw (new Exception("Debe ingresar un codigo"));
            }
            if (codigo.equals(ALL)) {
                dependencia = null;
            }else{
                dependencia = servicioDependencia.consultarDependencia(Integer.valueOf(codigo));
            }
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public ArrayList<Object> getListaFuncionarios(){
        ArrayList<Object> list = new ArrayList();
        try {
            if (dependencia == null) {
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
            }else{
                Iterator<Funcionario> ite = dependencia.getListaFuncionarios().iterator();
                    while (ite.hasNext()) {
                        Funcionario e = ite.next();
                        Object[] fila = new Object[5];
                        fila[0] = e.getId();
                        fila[1] = e.getNombre();
                        fila[2] = e.getPuesto();
                        fila[3] = dependencia.getNombre();
                        list.add(fila);
                    }
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
            Iterator<Dependencia> ite = servicioDependencia.listarDependencia().iterator();
                while (ite.hasNext()) {
                    list.add(ite.next().getNombre());
                }
        } catch (GlobalException | NoDataException ex) {} catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getCodigoDependencia(String nombre) {
        int codigo = -1;
        try {
            Iterator<Dependencia> ite = servicioDependencia.listarDependencia().iterator();
                while (ite.hasNext()) {
                    Dependencia d = ite.next();
                    if(d.getNombre().equals(nombre)){
                        codigo = d.getCodigo();
                        break;
                    }
                }
        } catch (GlobalException | NoDataException ex) {} catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaFuncionarios());
    }

    public void limpiar() {
        dependencia = null;
        this.setChanged();
        this.notifyObservers();
    }
}
