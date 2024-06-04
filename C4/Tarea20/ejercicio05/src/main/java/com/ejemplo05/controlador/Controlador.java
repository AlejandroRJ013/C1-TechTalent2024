package com.ejemplo05.controlador;

import com.ejemplo05.vista.*;
import com.ejemplo05.modelo.*;

import java.awt.*;
import java.awt.event.*;

public class Controlador {
    Ventana ventan;
    Modelo model;
    Cursor cursor;

    public Controlador(Ventana ventana, Modelo modelo) {
        ventan = ventana;
        model = modelo;
        
        ventan.setInformacionRaton(model.getTexto());
        ventan.addMouseListener(new miMouseListener());
        ventan.addLimpiarListener(new LimpiarListener());
    }

    class LimpiarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setTexto("");
            ventan.setInformacionRaton(model.getTexto());
        }
    }

    class miMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                model.appendInfo("Click izquierdo");
            } else if (e.getButton() == MouseEvent.BUTTON2) {
                model.appendInfo("Click medio");
            } else {
                model.appendInfo("Click derecho");
            }
            ventan.setInformacionRaton(model.getTexto());
        }
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            model.appendInfo("Ratón ha entrado");
            ventan.setInformacionRaton(model.getTexto());
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            model.appendInfo("Ratón ha salido");
            ventan.setInformacionRaton(model.getTexto());
        }
    };
    
    class addMouseWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() < 0) {
                model.appendInfo("Rueda hacia arriba");
            } else {
                model.appendInfo("Rueda hacia abajo");
            }
            ventan.setInformacionRaton(model.getTexto());
        }
    };
}