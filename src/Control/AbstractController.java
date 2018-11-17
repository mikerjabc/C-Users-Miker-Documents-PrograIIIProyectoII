/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author MikerJABC
 */
public abstract class AbstractController implements MouseListener, ActionListener, KeyListener, WindowListener{
    
    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public abstract void mouseClicked(MouseEvent e);

    @Override
    public abstract void mousePressed(MouseEvent e);

    @Override
    public abstract void mouseReleased(MouseEvent e);

    @Override
    public abstract void mouseEntered(MouseEvent e);

    @Override
    public abstract void mouseExited(MouseEvent e);

    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);
    
    @Override
    public abstract void windowOpened(WindowEvent we);

    @Override
    public abstract void windowDeactivated(WindowEvent we);

    @Override
    public abstract void windowActivated(WindowEvent we);

    @Override
    public abstract void windowDeiconified(WindowEvent we);

    @Override
    public abstract void windowIconified(WindowEvent we);

    @Override
    public abstract void windowClosed(WindowEvent we);

    @Override
    public abstract void windowClosing(WindowEvent we);
    
    public abstract void mostrarVista();
    
    public abstract void ocultarVista();
    
    public abstract void cerrarVista();
}
