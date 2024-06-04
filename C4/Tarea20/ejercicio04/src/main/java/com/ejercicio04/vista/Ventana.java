package com.ejercicio04.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private JTextArea area = new JTextArea();

    public Ventana() {
        setTitle("Eventos de la página");
        setPreferredSize(new Dimension(250, 200));
        setMinimumSize(new Dimension(200, 150));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JLabel titulo = new JLabel("- Eventos de la página -");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        add(titulo, gbc);
        
        gbc.gridy = 1;
        area.setSize(getSize());
        add(new JScrollPane(area), gbc);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setArea(StringBuilder textArea) {
        area.setText(textArea.toString());
        repaint();
        revalidate();
    }

    public void addVentanaListener(WindowAdapter listener) {
        addWindowListener(listener);
    }

    public void addComponenteListener(ComponentAdapter listener) {
        addComponentListener(listener);
    }
}
