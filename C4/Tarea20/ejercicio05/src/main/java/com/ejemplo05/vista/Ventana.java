package com.ejemplo05.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    private JButton limpiar = new JButton("L I M P I A R");
    private JTextArea infoRaton = new JTextArea();

    public Ventana() {
        setTitle("Acciones del ratón");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(200, 200));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JLabel titulo = new JLabel("- Eventos del ratón -");
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        add(titulo, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        limpiar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(limpiar, gbc);
        
        gbc.gridy = 2;
        infoRaton.setEditable(false);
        infoRaton.setPreferredSize(new Dimension(100, 100));
        add(new JScrollPane(infoRaton), gbc);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void setInformacionRaton(StringBuilder nuevoTexto) {
        infoRaton.setText(nuevoTexto.toString());
        repaint();
        revalidate();
        pack();
    }

    public void addLimpiarListener(ActionListener listener) {
        limpiar.addActionListener(listener);
    }
    
    public void addRatonListener(MouseAdapter listener) {
        addMouseListener(listener);
    }
}