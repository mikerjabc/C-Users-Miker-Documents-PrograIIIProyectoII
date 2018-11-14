/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Bien;
import Vista.VistaAdministrador;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author MikerJABC
 */
public class ModeloAdministrador extends Observable {
    
    ArrayList<Bien> bienes  = new ArrayList<>();
    VistaAdministrador view;
    int total;
    public void updateTable(Bien bien  ){
        bienes.add(bien);
        this.view.dtm.addRow(new Object [] {bien.getDescripcion(),bien.getModelo(),bien.getSerial(),bien.getPrecio(),bien.getCantidad()  });
        
        if (this.view.getCampoMontoTotal().getText().equalsIgnoreCase(""))
            total = 0;
        else 
        total = Integer.parseInt(this.view.getCampoMontoTotal().getText());
        
        total = (int) (total + bien.getCantidad()*bien.getPrecio());
        this.view.getCampoMontoTotal().setText(""+total);
    }
 
    public void setVista(VistaAdministrador view){
        this.view = view;
    }

    
    public ArrayList<Bien> getBienes() {
        return bienes;    
    }
}
