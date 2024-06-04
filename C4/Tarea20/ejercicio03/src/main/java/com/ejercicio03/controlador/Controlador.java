package com.ejercicio03.controlador;

import com.ejercicio03.vista.*;
import com.ejercicio03.modelo.*;

import java.awt.event.*;

public class Controlador {
    private Ventana vent;
    private Modelo model;

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        Ventana.addBoton1Listener(new Boton1Listener());
        Ventana.addBoton2Listener(new Boton2Listener());
    }

    class Boton1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.bot1Clicado();
            Ventana.actualizarLabel1(vent, model.getClicksBot1());
        }
    }

    class Boton2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.bot2Clicado();
            Ventana.actualizarLabel2(vent, model.getClicksBot2());
        }
    }
}