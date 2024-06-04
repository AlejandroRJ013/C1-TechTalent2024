package com.ejercicio06.vista;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{
    private static JButton calcular = new JButton("Calcular");
    private static JTextField altura = new JTextField(20);
    private static JTextField peso = new JTextField(20);
    private static JTextPane imc = new JTextPane();

    public Ventana() {
        setTitle("Calculador de IMC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 250);

        EmptyBorder borde = new EmptyBorder(5, 5, 5, 5);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        
        JLabel meteAltura = new JLabel("Altura (cm) :");
        meteAltura.setBorder(borde);
        panel.add(meteAltura, gbc);
        
        gbc.gridx = 1;
        altura.setText("Ejemplo: 180");
        altura.setForeground(Color.LIGHT_GRAY);
        textoQueDesaparece(altura, "Ejemplo: 180");
        panel.add(altura, gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel metePeso = new JLabel("Peso /decimales con punto/ (kg) :");
        metePeso.setBorder(borde);
        panel.add(metePeso, gbc);
        
        gbc.gridx = 1;
        peso.setText("Ejemplo: 70.20");
        peso.setForeground(Color.LIGHT_GRAY);
        textoQueDesaparece(peso, "Ejemplo: 70.20");
        panel.add(peso, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        gbc.gridx = 0;
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.GRAY);
        panelBoton.setBorder(new EmptyBorder(10, 0, 10, 0));
        calcular.setBackground(Color.DARK_GRAY);
        calcular.setForeground(Color.WHITE);
        calcular.setBorderPainted(false);
        panelBoton.add(calcular);
        panel.add(panelBoton, gbc);
        
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 3; 
        gbc.gridx = 0; 
        JLabel calcularLabel = new JLabel("Resultado IMC");
        calcularLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        calcularLabel.setBorder(borde);
        panel.add(calcularLabel, gbc);
        
        gbc.gridx = 1;
        StyledDocument doc = imc.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        imc.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        imc.setBackground(Color.LIGHT_GRAY);
        imc.setEditable(false);
        imc.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        imc.setForeground(Color.DARK_GRAY);
        imc.setPreferredSize(new Dimension(220, 40));
        imc.setText("10");
        panel.add(imc, gbc);

        panel.setBorder(borde);
        add(panel);

        setImc(this, 21.67);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void textoQueDesaparece(JTextField textField, String texto) {
        final Object[] objetos = {textField, texto};
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (((JTextField) objetos[0]).getText().equals(((String) objetos[1]))) {
                    ((JTextField) objetos[0]).setText("");
                    ((JTextField) objetos[0]).setForeground(Color.BLACK);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (((JTextField) objetos[0]).getText().equals("")) {
                    ((JTextField) objetos[0]).setText(((String) objetos[1]));
                    ((JTextField) objetos[0]).setForeground(Color.LIGHT_GRAY);
                }
            }
        });
    }

    public static int getAltura() {
        return Integer.parseInt(altura.getText());
    }

    public static double getPeso() {
        return Double.parseDouble(peso.getText());
    }

    public static void setImc(Ventana vent, double imcIntroducido) {
        imc.setText(String.format("%.2f", imcIntroducido));
        vent.repaint();
        vent.revalidate();
    }
    
    public void addCalcularListener(ActionListener listener) {
        calcular.addActionListener(listener);
    }
}


