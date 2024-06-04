package com.ejercicio02.controlador;

import com.ejercicio02.vista.*;
import com.ejercicio02.modelo.*;

import javax.swing.*;
import java.awt.event.*;

public class Controlador {
    private Ventana vent;
    private Modelo model;

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        vent.setBotonPulsado(vent, model.getBotonPulsado());
        vent.addBotonListener(new BotonListener());
    }

    class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            model.setBotonPulsado(boton.getText());
            vent.setBotonPulsado(vent, model.getBotonPulsado());
        }
    }
}


