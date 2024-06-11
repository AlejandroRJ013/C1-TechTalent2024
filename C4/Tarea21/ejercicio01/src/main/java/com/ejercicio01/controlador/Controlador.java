package com.ejercicio01.controlador;

import com.ejercicio01.modelo.*;
import com.ejercicio01.vista.*;

import java.awt.event.*;
import javax.swing.*;

public class Controlador {
    private Modelo modelo;
    private Ventana vista;

    public Controlador(Modelo model, Ventana vist) {
        modelo = model;
        vista = vist;
        vista.agregarListenerBotones(new AccionBoton());
    }

    class AccionBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String textoBoton = boton.getText();
            if (textoBoton.equals("=")) {
                modelo.leerOperacion();
                vista.actualizarPantalla(modelo.getOperacion());
                modelo.limpiarOperacion();
            } else if (textoBoton.equals("CE")) {
                modelo.limpiarOperacion();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("C")) {
                modelo.limpiarOperacionYHistorial();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("<-")) {
                modelo.borrarUno();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("1/x")) {
                modelo.fraccion();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("x^2")) {
                modelo.elevar();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("²√x")) {
                modelo.raiz();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("%")) {
                modelo.porcentaje();
                vista.actualizarPantalla(modelo.getOperacion());
            } else if (textoBoton.equals("+/-")) {
                modelo.cambiarSentido();
                vista.actualizarPantalla(modelo.getOperacion());
            } else {
                modelo.setEntrada(textoBoton);
                vista.actualizarPantalla(modelo.getOperacion());
            }
        }
    }
}