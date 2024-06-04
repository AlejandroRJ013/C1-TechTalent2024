package com.ejercicio07.controlador;

import com.ejercicio07.ventana.*;
import com.ejercicio07.modelo.*;

import java.awt.event.*;

public class Controlador {
    Ventana vent;
    Modelo model;

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        vent.addCambiarValorListener(new CambiarValorListener());
        vent.addConvertirListener(new ConvertirListener());
    }

    class CambiarValorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean estado = (vent.getEstadoConvertor()) ? false : true;
            model.setBooleanEuros(estado);
            vent.setEstadoConvertor(estado);
            String divisa = (estado) ? "CONV. A PESETAS" : "CONV. A EUROS";
            vent.setTextoBotonCambiante(divisa);
            vent.textoQueCambia(vent);
        }
    }

    class ConvertirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double dinero = vent.getDineroAConvertir();
            model = new Modelo(dinero, vent.getEstadoConvertor());
            Ventana.setDineroConvertido(vent, model.getDineroSalida());
        }
    }
}


