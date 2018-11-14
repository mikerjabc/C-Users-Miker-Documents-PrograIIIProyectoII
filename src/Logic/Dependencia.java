
package Logic;

import java.util.ArrayList;


public class Dependencia  {
    
    private int codigo;
    private String nombre;
    private ArrayList<Funcionario> listaFuncionarios;

    public Dependencia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        listaFuncionarios = new ArrayList();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
    
    
}


