package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    public Ventana(String table, int row, int col, ArrayList<String> tablas, ArrayList<String> nombres) {
        setTitle("Gestión de bases de datos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1500, 600));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(new EmptyBorder(0, 30, 30, 30));
        panelPrincipal.setBackground(Color.decode("#f5e1ce"));

        PanelElegirTabla panelTitul = new PanelElegirTabla(panelPrincipal, tablas);
        panelPrincipal.add(panelTitul);

        JPanel panelInteraccion = new JPanel();
        panelInteraccion.setLayout(new BoxLayout(panelInteraccion, BoxLayout.X_AXIS));
        panelInteraccion.setBorder(new EmptyBorder(20, 0, 50, 0));
        panelInteraccion.setBackground(panelPrincipal.getBackground());

        JPanel panelBotonesTabla = new JPanel();
        panelBotonesTabla.setLayout(new GridBagLayout());
        panelBotonesTabla.setBackground(panelPrincipal.getBackground());
        GridBagConstraints gridBagTabla = new GridBagConstraints();
        gridBagTabla.fill = GridBagConstraints.BOTH;
        gridBagTabla.weightx = 1;
        gridBagTabla.weighty = 1;
        // panelBotonesTabla.setBorder(new EmptyBorder(0, 0, 0, 40));

        PanelBotones panelBotones = new PanelBotones(panelPrincipal);
        gridBagTabla.gridy = 0;
        panelBotonesTabla.add(panelBotones, gridBagTabla);

        PanelTabla panelTabla = new PanelTabla(row, col, nombres);
        gridBagTabla.gridy = 1;
        gridBagTabla.weighty = 10;
        panelBotonesTabla.add(panelTabla, gridBagTabla);

        panelInteraccion.add(panelBotonesTabla);

        // PanelVistaActualizado panelPanelVistaLinea = new PanelVistaActualizado();

        // panelInteraccion.add(panelPanelVistaLinea);

        panelPrincipal.add(panelInteraccion);

        PanelConsola panelConsola = new PanelConsola();

        panelPrincipal.add(panelConsola);

        add(panelPrincipal);

        // pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}