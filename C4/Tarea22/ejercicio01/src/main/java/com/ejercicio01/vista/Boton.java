package com.ejercicio01.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Boton extends JPanel {
    private JLabel imagen;
    private ImageIcon icono;
    private int anchuraIcono = 0;
    private int alturaIcono = 0;

    public Boton(String ruta) {
        setPreferredSize(new Dimension(125, 60));
        setBackground(Color.decode("#7a5c3c"));
        setLayout(new GridLayout());
        icono = cargarImagen(ruta);
        ImageIcon iconoGuardado = icono;
        anchuraIcono = icono.getIconWidth();
        alturaIcono = icono.getIconHeight();
        imagen = new JLabel(icono);
        imagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#A3785A"));
                icono = escalarImagen(icono, anchuraIcono + 10, alturaIcono + 10);
                imagen.setIcon(icono);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#7a5c3c"));
                icono = iconoGuardado;
                imagen.setIcon(icono);
            }
        });
        add(imagen);
    }

    public static void setListener(Boton panel, ActionListener listener) {
        panel.imagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }

    private ImageIcon cargarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource(ruta));
        if (imagen.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error al cargar la imagen: " + ruta);
        }
        return imagen;
    }

    private ImageIcon escalarImagen(ImageIcon icono, int anchura, int altura) {
        return new ImageIcon(icono.getImage().getScaledInstance(anchura, altura, Image.SCALE_SMOOTH));
    }
}