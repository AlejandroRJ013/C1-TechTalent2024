package com.ejercicio01.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ventana extends JFrame {
    private static JLabel titulo = new JLabel("Titulo prueba");
    JSlider slider;

    public Ventana() {
        setTitle("Titulo interactivo");
        setSize(300, 200);
        //CUANDO SE CIERRA LA VENTANA SE APAGA EL PROGRAMA
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        slider = new JSlider(8, 64, 24);

        panel.add(titulo);
        panel.add(slider);

        add(panel);
        setLocationRelativeTo(null);
    }

    public static void nuevoTam(Ventana ventana, int tam) {
        titulo.setFont(new Font(Font.SERIF, Font.PLAIN, tam));
        ventana.repaint();
        ventana.revalidate();
    }

    public void addSliderListener(ChangeListener listener) {
        slider.addChangeListener(listener);
    }
}