package com.ejercicio01.vista;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    private JTextArea pantalla = new JTextArea("0");

    public Ventana() {
        setTitle("Calculadora Estándar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);

        pantalla.setPreferredSize(new Dimension(275, 125));
        pantalla.setBackground(Color.GRAY);
        pantalla.setEditable(false);
        add(pantalla);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}