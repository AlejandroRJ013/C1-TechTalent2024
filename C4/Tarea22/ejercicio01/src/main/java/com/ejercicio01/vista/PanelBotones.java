package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotones extends JPanel {
    private static Boton panelInsert = new Boton("img/botonCreate.png");
    private static Boton panelUpdate = new Boton("img/botonUpdate.png");
    private static Boton panelSelect = new Boton("img/botonSelect.png");
    private static Boton panelDelete = new Boton("img/botonDelete.png");

    public PanelBotones(JPanel panelPrincipal) {
        setLayout(new GridLayout(1, 4));
        setBorder(new EmptyBorder(0, 0, 20, 0));
        setBackground(panelPrincipal.getBackground());

        add(panelInsert);
        add(panelUpdate);
        add(panelSelect);
        add(panelDelete);
    }

    public static void setListeners(ActionListener listenerInsert, ActionListener listenerUpdate,
            ActionListener listenerSelect, ActionListener listenerDelete) {
        Boton.setListener(panelInsert, listenerInsert);
        Boton.setListener(panelUpdate, listenerUpdate);
        Boton.setListener(panelSelect, listenerSelect);
        Boton.setListener(panelDelete, listenerDelete);
    }
}