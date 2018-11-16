/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author MikerJABC
 */
public class Transferencia {
    private int numero;
    private Dependencia origen;
    private Dependencia destino;
    private ArrayList<Bien> listaBienes;
    private String ubicacion;
    private Funcionario funcionario;
    private String autorizacion;
    private final String ESTADOINICIAL = "Recibida";

    public Transferencia(int numero, Dependencia origen, Dependencia destino, String ubicacion, Funcionario funcionario) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.listaBienes = new ArrayList();
        this.ubicacion = ubicacion;
        this.funcionario = funcionario;
        this.autorizacion = ESTADOINICIAL;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Dependencia getOrigen() {
        return origen;
    }

    public void setOrigen(Dependencia origen) {
        this.origen = origen;
    }

    public Dependencia getDestino() {
        return destino;
    }

    public void setDestino(Dependencia destino) {
        this.destino = destino;
    }

    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }

    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    
}
