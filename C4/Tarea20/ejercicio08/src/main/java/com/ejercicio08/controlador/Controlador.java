package com.ejercicio08.controlador;

import com.ejercicio08.ventana.*;
import com.ejercicio08.modelo.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Controlador {
    Ventana vent;
    Modelo model;

    public Controlador(Ventana ventana, Modelo modelo) {
        vent = ventana;
        model = modelo;

        vent.addListeners(new LimpiarListener(), new CambiarValorListener(),
        new ConvertirListener(), new TecladoListener());
    }

    class CambiarValorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean estado = (vent.getEstadoConvertor()) ? false : true;
            model.setBooleanEuros(estado);
            vent.setEstadoConvertor(estado);
            String divisa = (estado) ? "CONV. A PESETAS" : "CONV. A EUROS";
            vent.textoQueCambia(vent, divisa);
        }
    }

    class ConvertirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double dinero = vent.getDineroAConvertir();
            model = new Modelo(dinero, vent.getEstadoConvertor());
            vent.setDineroConvertido(model.getDineroSalida());
        }
    }

    class LimpiarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vent.setDineroParaConvertir(0.0);
            vent.setDineroConvertido(0.0);
        }
    }

    class TecladoListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char keyChar = e.getKeyChar();
            if (Character.isDigit(keyChar)) {
                JTextField tf = vent.getTextFieldDinero();
                tf.setForeground(Color.BLACK);
                double num = Double.parseDouble(tf.getText());
                String texto = (num > 0) ?  tf.getText() + keyChar : "" + keyChar;
                vent.setDineroParaConvertir(Double.parseDouble(texto.toString()));
            } else if (keyChar == KeyEvent.VK_ENTER) {
                double dinero = vent.getDineroAConvertir();
                model = new Modelo(dinero, vent.getEstadoConvertor());
                vent.setDineroConvertido(model.getDineroSalida());
            } else {
                e.consume();
            }
        }
    }
}



