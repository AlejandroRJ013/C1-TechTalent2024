package com.ejercicio02.controlador;

import java.awt.event.*;
import javax.swing.*;

import com.ejercicio02.modelo.*;
import com.ejercicio02.vista.*;

public class Controlador {
    private Modelo modelo;
    private Ventana vista;
    private boolean limpiarDes = false;
    private boolean potencia = false;

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
            switch (textoBoton) {
                case "π":
                    modelo.setEntrada(String.valueOf(modelo.getPI()));
                    break;

                case "e":
                    modelo.setEntrada(String.valueOf(modelo.getE()));
                    break;

                case "CE":
                    modelo.limpiarOperacion();
                    break;

                case "C":
                    modelo.limpiarOperacionYHistorial();
                    break;

                case "<-":
                    modelo.borrarUno();
                    break;

                case "x²":
                    modelo.elevar(modelo.getOperacion());
                    break;

                case "1/x":
                    modelo.fraccion(modelo.getOperacion());
                    break;

                case "|x|":
                    modelo.valorAbsoluto(modelo.getOperacion());
                    break;

                case "²√x":
                    modelo.raiz(modelo.getOperacion());
                    break;

                case "n!":
                    modelo.factorial(modelo.getOperacion());
                    break;

                case "x^y":
                    potencia = true;
                    modelo.setEntrada(" ^ ");
                    break;

                case "10^x":
                    modelo.potenciaDeDiez(modelo.getOperacion());
                    break;

                case "log":
                    modelo.log(modelo.getOperacion());
                    break;

                case "ln":
                    modelo.logaritmoNeperiano(modelo.getOperacion());
                    break;

                case "+/-":
                    modelo.cambiarSentido(modelo.getOperacion());
                    break;

                case "=":
                    modelo.leerYOperar(modelo.getOperacion());
                    limpiarDes = true;
                    break;

                default:
                    modelo.setEntrada(textoBoton);
                    if (potencia) {
                        modelo.elevarY(modelo.getOperacion());
                        potencia = false;
                    }
                    break;
            }
            vista.actualizarPantalla(modelo.getOperacion());
            if (limpiarDes) {
                modelo.limpiarOperacion();
                limpiarDes = false;
            }
        }
    }

}