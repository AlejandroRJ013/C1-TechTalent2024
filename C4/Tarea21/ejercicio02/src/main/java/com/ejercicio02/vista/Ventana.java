package com.ejercicio02.vista;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ventana extends JFrame {
    private JTextPane pantalla = new JTextPane();
    private String[] simbolosCalculadora = { "π", "e", "CE", "C", "<-", "x²", "1/x", "|x|", " exp ", " mod ", "²√x",
            "(", ")", "n!", " / ", "x^y", " x ", "10^x", " - ", "log", " + ", "ln", "+/-", ".", "=" };
    private String[] numerosCalculadora = { "9", "8", "7", "6", "5", "4", "3", "2", "1", "0" };
    JPanel panelBotones;

    public Ventana() {
        setTitle("Calculadora Científica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(Color.decode("#E6E6E6"));

        StyledDocument doc = pantalla.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        pantalla.setBorder(new EmptyBorder(3, 10, 0, 10));
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
            boton.setBackground(Color.decode("#BDBDBD"));
        } else if (tipo.equals("ig")) {
            boton.setBackground(Color.decode("#0097C0"));
        } else {
            boton.setBackground(Color.decode("#E0E0E0"));
        }
        boton.setBorderPainted(false);
    }

    public JPanel generarPanelBotones() {
        JPanel panBot = new JPanel(new GridBagLayout());
        panBot.setBorder(new EmptyBorder(0, 10, 10, 10));
        GridBagConstraints posicionBot = new GridBagConstraints();
        posicionBot.insets = new Insets(2, 2, 2, 2);
        posicionBot.fill = GridBagConstraints.BOTH;
        posicionBot.weightx = 1.0;
        posicionBot.weighty = 1.0;
        int contadorSim = 0;
        int contadorNum = 0;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 5; j++) {
                posicionBot.gridx = (j - 1);
                posicionBot.gridy = (i - 1);
                JButton boton;
                String tipo = "";
                if ((i == 7 && Arrays.asList(2, 4).contains(j)) || Arrays.asList(1, 2, 3).contains(i) || j == 1
                        || j == 5) {
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

    public String obtenerTextoPantalla() {
        return pantalla.getText();
    }

    public void eliminarCaracter() {
        StringBuilder operacion = new StringBuilder(obtenerTextoPantalla());
        operacion.setLength(operacion.length() - 1);
        pantalla.setText(operacion.toString());
    }

    public void limpiarPantalla() {
        StringBuilder operacion = new StringBuilder("0");
        pantalla.setText(operacion.toString());
    }
}