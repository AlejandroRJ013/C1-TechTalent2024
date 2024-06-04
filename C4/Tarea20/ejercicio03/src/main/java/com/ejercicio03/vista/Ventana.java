package com.ejercicio03.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ventana extends JFrame {
    private static JLabel cantClicksBot1;
    private static JLabel cantClicksBot2;
    private static JButton boton1 = new JButton("Click?");
    private static JButton boton2 = new JButton("Click?");

    public Ventana() {
        setTitle("Conteo de clicks");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(0, 150));
        EmptyBorder borde = new EmptyBorder(4, 4, 4, 4);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        
        JLabel labelBot1 = new JLabel("Clicks boton 1:");
        Font nuevaFuente1 = labelBot1.getFont().deriveFont(16f);
        labelBot1.setFont(nuevaFuente1);
        labelBot1.setBorder(borde);
        panel.add(labelBot1, gbc);

        gbc.gridx = 1;
        JLabel labelBot2 = new JLabel("Clicks boton 2:");
        Font nuevaFuente2 = labelBot2.getFont().deriveFont(16f);
        labelBot2.setFont(nuevaFuente2);
        labelBot2.setBorder(borde);
        panel.add(labelBot2, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        cantClicksBot1 = new JLabel("0");
        cantClicksBot1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        cantClicksBot1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(cantClicksBot1, gbc);

        gbc.gridx = 1;
        cantClicksBot2 = new JLabel("0");
        cantClicksBot2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        cantClicksBot2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(cantClicksBot2, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(boton1, gbc);
        
        gbc.gridx = 1;
        panel.add(boton2, gbc);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void actualizarLabel1(Ventana vent, int nuevaCant) {
        try {
            cantClicksBot1.setText(String.valueOf(nuevaCant));
            vent.repaint();
            vent.revalidate();
        } catch (Exception e) {
            System.out.println("Error indevido");
        }
    }

    public static void actualizarLabel2(Ventana vent, int nuevaCant) {
        try {
            cantClicksBot2.setText(String.valueOf(nuevaCant));
            vent.repaint();
            vent.revalidate();
        } catch (Exception e) {
            System.out.println("Error indevido");
        }
    }

    public static void addBoton1Listener(ActionListener listener) {
        boton1.addActionListener(listener);
    }

    public static void addBoton2Listener(ActionListener listener) {
        boton2.addActionListener(listener);
    }
}