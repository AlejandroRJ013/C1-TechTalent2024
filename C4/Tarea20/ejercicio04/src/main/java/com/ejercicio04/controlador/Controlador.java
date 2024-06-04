package com.ejercicio04.controlador;

import com.ejercicio04.vista.*;
import com.ejercicio04.modelo.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controlador {
    private Ventana vent;
    private Modelo model;
    private Timer ventanaMoviendo = new Timer(500, ex -> {
        model.appendInfo("Moviendo ventana...");
        vent.setArea(model.getTexto());
    });
    private Timer ventanaReescalando = new Timer(500, ex -> {
        model.appendInfo("Reescalando ventana...");
        vent.setArea(model.getTexto());
    });

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        vent.addVentanaListener(new AccionesListener());
        vent.addComponenteListener(new ComponentesListener());
    }

    class AccionesListener extends WindowAdapter {
        @Override
        public void windowOpened(WindowEvent e) {
            model.appendInfo("Ventana Abierta");
            vent.setArea(model.getTexto());
        }
    
        @Override
        public void windowIconified(WindowEvent e) {
            model.appendInfo("Ventana Minimizada");
            vent.setArea(model.getTexto());
        }
    
        @Override
        public void windowActivated(WindowEvent e) {
            model.appendInfo("Entrada en la ventana");
            vent.setArea(model.getTexto());
        }
    
        @Override
        public void windowDeactivated(WindowEvent e) {
            model.appendInfo("Salida de la ventana");
            vent.setArea(model.getTexto());
        }
    }

    class ComponentesListener extends ComponentAdapter {
        Point initialLocation;
        @Override
        public void componentResized(ComponentEvent e) {
            if (vent.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                model.appendInfo("Ventana Maximizada");
                vent.setArea(model.getTexto());
            } else if (vent.getExtendedState() == JFrame.NORMAL) {
                ventanaReescalando.setRepeats(false);
                ventanaReescalando.start();
            }
        }
        
        @Override
        public void componentMoved(ComponentEvent e) {
            if (initialLocation == null) {
                initialLocation = vent.getLocation();
            } else {
                Point currentLocation = vent.getLocation();
                if (!currentLocation.equals(initialLocation)) {
                    ventanaMoviendo.setRepeats(false);
                    ventanaMoviendo.start();
                }
            }
        }
    }
}


