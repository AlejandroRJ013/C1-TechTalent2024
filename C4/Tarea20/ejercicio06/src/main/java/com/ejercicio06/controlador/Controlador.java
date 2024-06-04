package com.ejercicio06.controlador;

import com.ejercicio06.vista.*;
import com.ejercicio06.modelo.*;

import javax.swing.*;
import java.awt.event.*;

public class Controlador {
    private Ventana vent;
    private Modelo model;

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        vent.addCalcularListener(new CalcularListener());
    }

    class CalcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int altura = Ventana.getAltura();
                double peso = Ventana.getPeso();
                model = new Modelo(altura, peso);
                double imc = model.getIMC();
                Ventana.setImc(vent, imc);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vent, 
                "Por favor, ingrese valores "
                + "válidos para altura y peso.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


