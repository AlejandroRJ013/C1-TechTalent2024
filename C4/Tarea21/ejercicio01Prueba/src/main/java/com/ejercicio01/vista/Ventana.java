package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ventana extends JFrame{
    private JTextPane pantalla = new JTextPane();
    private String[] simbolosCalculadora = {"%", "CE", "C", "<-", "1/x", "x^2", "²√x", " / ", " x ", " + ", " - ", "+/-", ".", "="};
    private String[] numerosCalculadora = {"9", "8", "7", "6", "5", "4", "3", "2"," 1", "0"};
    JPanel panelBotones;

    public Ventana() {
        setTitle("Calculadora Estándar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(Color.decode("#E6E6E6"));

        StyledDocument doc = pantalla.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        pantalla.setBorder(new EmptyBorder(3, 25, 0, 25));
        pantalla.setText("0");
        pantalla.setBackground(getBackground());
        pantalla.setPreferredSize(new Dimension(450, 150));
        pantalla.setFont(new Font(getName(), Font.BOLD, 90));
        pantalla.setEditable(false);
        panelPrincipal.add(pantalla);

        panelBotones = generarPanelBotones();
        panelPrincipal.add(panelBotones);

        add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void caracteristicasBoton(JButton boton, String tipo) {
        int anchoFrame = (pantalla.getWidth() + 40);
        int anchoBoton = (anchoFrame / 4);
        int altoBoton = (anchoBoton * 2) / 3;
        boton.setMinimumSize(new Dimension(anchoBoton, altoBoton));
        boton.setFont(new Font("Arial", Font.PLAIN, 20));
        if (tipo.equals("op")) {
            boton.setBackground(Color.decode("#E0E0E0"));
        } else if (tipo.equals("ig")) {
            boton.setBackground(Color.decode("#0067C0"));
        } else {
            boton.setBackground(Color.decode("#F9F9F9"));
        }
        boton.setBorderPainted(false);
    }

    public JPanel generarPanelBotones() {
        JPanel panBot = new JPanel(new GridBagLayout());
        panBot.setBorder(new EmptyBorder(0, 25, 10, 25));
        GridBagConstraints posicionBot = new GridBagConstraints();
        posicionBot.insets = new Insets(2, 2, 2, 2); posicionBot.fill = GridBagConstraints.BOTH;
        posicionBot.weightx = 1.0; posicionBot.weighty = 1.0;
        int contadorSim = 0;
        int contadorNum = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 4; j++) {
                posicionBot.gridx = (j-1);
                posicionBot.gridy = (i-1);
                JButton boton;
                String tipo = "";
                if (j != 2 && i == 6 || Arrays.asList(1, 2).contains(i) || j%4 == 0) {
                    if (contadorSim == simbolosCalculadora.length - 1) {
                        tipo = "ig";
                    } else {
                        tipo = "op";
                    }
                    boton = new JButton(simbolosCalculadora[contadorSim]);
                    contadorSim++;
                } else {
                    boton = new JButton(numerosCalculadora[contadorNum]);
                    contadorNum++;
                }
                caracteristicasBoton(boton, tipo);
                panBot.add(boton, posicionBot);
            }
        }
        return panBot;
    }
    public void agregarListenerBotones(ActionListener listener) {
        Component[] componentes = panelBotones.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JButton) {
                ((JButton) componente).addActionListener(listener);
            }
        }
    }

    public void actualizarPantalla(String texto) {
        pantalla.setText(texto);
    }
}