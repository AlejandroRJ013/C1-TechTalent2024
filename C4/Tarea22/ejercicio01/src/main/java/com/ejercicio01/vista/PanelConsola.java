package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelConsola extends JPanel {
    private static JPanel panelSalida;
    private static final int MAX_ETIQUETAS = 8;

    public PanelConsola() {
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.BLACK, 1));
        setPreferredSize(new Dimension(getWidth(), 164));

        JPanel panelContorno = new JPanel();
        panelContorno.setBackground(Color.decode("#A3785A"));
        panelContorno.setBorder(new EmptyBorder(5, 5, 5, 5));

        panelSalida = new JPanel();
        panelSalida.setLayout(new BoxLayout(panelSalida, BoxLayout.Y_AXIS));
        panelSalida.setBorder(new EmptyBorder(1, 2, 1, 2));
        panelSalida.setBackground(Color.WHITE);

        panelContorno.add(panelSalida, BorderLayout.CENTER);
        add(panelSalida, BorderLayout.CENTER);
    }

    public static void setEntradaConsola(ArrayList<String> lineasConsola) {
        for (String linea : lineasConsola) {
            JLabel label = new JLabel(linea);
            label.setBorder(new EmptyBorder(2, 5, 2, 5));
            panelSalida.add(label);

            if (panelSalida.getComponentCount() > MAX_ETIQUETAS) {
                panelSalida.remove(0);
            }
        }
        panelSalida.revalidate();
        panelSalida.repaint();
    }
}
