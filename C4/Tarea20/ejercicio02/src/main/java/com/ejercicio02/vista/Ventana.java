package com.ejercicio02.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    private JLabel botonPulsado = new JLabel();
    private JButton boton1 = new JButton("Judios");
    private JButton boton2 = new JButton("Israelis");

    public Ventana() {
        setTitle("Que botón se esta pulsando");
        setSize( 250, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 0;
        
        JLabel texto1 = new JLabel("El botón pulsado és:");
        texto1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(texto1, gbc);
        
        gbc.gridy = 1;
        botonPulsado.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(botonPulsado, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        panel.add(boton1, gbc);
        gbc.gridx = 1;
        panel.add(boton2, gbc);

        add(panel);
        setLocationRelativeTo(null);
    }

    public void setBotonPulsado(Ventana vent, String text) {
        botonPulsado.setText(text);
        vent.repaint();
        vent.revalidate();
    }

    public void addBotonListener(ActionListener listener) {
        boton1.addActionListener(listener);
        boton2.addActionListener(listener);
    }
}