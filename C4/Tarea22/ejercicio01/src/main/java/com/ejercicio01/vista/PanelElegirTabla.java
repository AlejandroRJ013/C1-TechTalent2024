package com.ejercicio01.vista;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelElegirTabla extends JPanel {
    private static String tablaSeleccionada;
    private static ArrayList<JPanel> panelesTabla = new ArrayList<>();

    public PanelElegirTabla(JPanel panelPrincipal, ArrayList<String> tablas) {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#A3785A"));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.gridy = 0;

        for (int i = 0; i < tablas.size(); i++) {
            JPanel nombreTabla = new JPanel(new GridLayout());
            nombreTabla.setBackground(getBackground());
            JLabel tablaLabel = new JLabel(" - - " + tablas.get(i).toUpperCase() + " - - ", SwingConstants.CENTER);
            tablaLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
            tablaLabel.setForeground(Color.WHITE);
            addListenerPanel(nombreTabla, tablas.get(i));

            gbc.gridx = i;
            nombreTabla.add(tablaLabel);
            add(nombreTabla, gbc);

            // Añadir el panel a la lista de paneles
            panelesTabla.add(nombreTabla);
        }
    }

    public static void addListenerMostrarTabla(MouseListener listener) {
        // Añadir el listener a cada panel en la lista
        for (JPanel panel : panelesTabla) {
            panel.addMouseListener(listener);
        }
    }

    public void addListenerPanel(JPanel panel, String tabla) {
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.decode("#7a5c3c"));
            }

            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.decode("#A3785A"));
            }

            public void mouseClicked(MouseEvent e) {
                tablaSeleccionada = tabla;
            }
        });
    }

    public static String getTablaSeleccionada() {
        return tablaSeleccionada;
    }
}
