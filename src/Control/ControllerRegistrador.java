/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModeloRegistrador;
import Vista.VistaRegistrador;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Fernando
 */
public class ControllerRegistrador extends AbstractController{

    ModeloRegistrador modelo ;
    VistaRegistrador vista;

    public ControllerRegistrador(ModeloRegistrador modelo, VistaRegistrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setModelo(modelo);
        vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mostrarVista() {
        vista.setVisible(true);
    }

    @Override
    public void ocultarVista() {
        vista.setVisible(false);
    }
}
