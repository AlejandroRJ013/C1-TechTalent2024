package com.ejercicio01.controlador;

import com.ejercicio01.vista.*;
import com.ejercicio01.modelo.*;

import javax.swing.*;
import javax.swing.event.*;

public class Controlador {
    private Ventana ventan;
    private Modelo model;

    public Controlador (Ventana ventana, Modelo modelo) {
        ventan = ventana;
        model = modelo;
        Ventana.nuevoTam(ventan, model.getTaman());

        this.ventan.addSliderListener(new SliderListener());
    }

    class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            model.setTaman(slider.getValue());
            Ventana.nuevoTam(ventan, model.getTaman());
        }
    }
}