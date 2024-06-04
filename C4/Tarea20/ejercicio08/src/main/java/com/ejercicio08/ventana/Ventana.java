package com.ejercicio08.ventana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class Ventana extends JFrame {
    private JButton limpiar = new JButton("LIMPIAR");
    private JButton cambiarValor = new JButton("CONV. A PESETAS");
    private JButton convertir = new JButton("CONVERTIR");
    private JTextField dineroSinConvertir = new JTextField(20);
    private JTextPane dineroConvertido = new JTextPane();
    private boolean euros;
    private JLabel textoDinCon = new JLabel(); 

    public Ventana() {
        euros = true;
        setTitle("Cenversor euros - pesetas / pesetas - euros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel ingresaDinero = new JLabel("Ingrese la cantidad a convertir : ");
        JPanel panelTF = new JPanel();
        panelTF.add(dineroSinConvertir);
        JPanel panelTP = new JPanel();
        panelTP.add(dineroConvertido);
        JPanel panelBotones = new JPanel(new GridLayout(1, 2));
        panelBotones.add(cambiarValor);
        panelBotones.add(convertir);
        addCaracteristicas(panelTF, panelTP, panelBotones);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 0, 5);
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.gridwidth = 1; gbc.gridy = 0; gbc.gridx = 0;
        panel.add(ingresaDinero, gbc);

        gbc.gridx = 1;
        panel.add(panelTF, gbc);
        
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.gridy = 1; gbc.gridx = 0;
        panel.add(textoDinCon, gbc);

        gbc.gridx = 1;
        panel.add(panelTP, gbc);
        
        gbc.insets = new Insets(0, 5, 2, 5);
        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 2;
        panel.add(panelBotones, gbc);

        gbc.insets = new Insets(1, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.gridy = 3; gbc.gridx = 0;
        panel.add(limpiar, gbc);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void addCaracteristicas(JPanel panelTF, JPanel panelTP, JPanel panelBotones) {
        String resultado = (euros) ? "Dinero en euros : " : "Dinero en pesetas : ";
        textoDinCon.setText(resultado);
        textoDinCon.setBorder(new EmptyBorder(0, 0, 5, 0));
        
        panelTF.setBorder(new LineBorder(Color.BLACK, 1));
        panelTF.setBackground(Color.GRAY);
        dineroSinConvertir.setBorder(new EmptyBorder(5, 5, 5, 5));
        dineroSinConvertir.setBackground(Color.GRAY);
        dineroSinConvertir.setHorizontalAlignment(JTextField.CENTER);
        dineroSinConvertir.setText("1");
        dineroSinConvertir.setForeground(Color.LIGHT_GRAY);
        textoQueDesaparece(dineroSinConvertir, "1");
        
        StyledDocument doc = dineroConvertido.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        
        panelTP.setBorder(new LineBorder(Color.BLACK, 1));
        panelTP.setBackground(Color.LIGHT_GRAY);
        dineroConvertido.setEditable(false);
        dineroConvertido.setPreferredSize(dineroSinConvertir.getPreferredSize());
        dineroConvertido.setBackground(Color.LIGHT_GRAY);
        dineroConvertido.setForeground(Color.GRAY);
        dineroConvertido.setText("166.386");

        panelBotones.setBackground(Color.GRAY);
        
        cambiarValor.setBorderPainted(false);
        cambiarValor.setBackground(Color.DARK_GRAY);
        cambiarValor.setForeground(Color.WHITE);
        cambiarValor.setAlignmentX(CENTER_ALIGNMENT);
        
        convertir.setBorderPainted(false);
        convertir.setBackground(Color.DARK_GRAY);
        convertir.setForeground(Color.WHITE);
        convertir.setAlignmentX(CENTER_ALIGNMENT);
    }
    
    public void textoQueDesaparece(JTextField textField, String texto) {
        final Object[] objetos = {textField, texto};
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (((JTextField) objetos[0]).getText().equals(((String) objetos[1])) || 
                ((JTextField) objetos[0]).getText().equals("0.0")) {
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

    public void textoQueCambia(Ventana vent, String texto) {
        String resultado = (euros) ? "Dinero en euros : " : "Dinero en pesetas : ";
        cambiarValor.setText(texto);
        textoDinCon.setText(resultado);
        repaint();
        revalidate();
    }
    
    public double getDineroAConvertir() {
        double d = 0;
        try {
            d = Double.parseDouble(dineroSinConvertir.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido",
                "Error " + e.getCause(), JOptionPane.ERROR_MESSAGE);
        }
        return d;
    }
    
    public void setDineroConvertido(double dinConvertido) {
        String texto = "";
        if (euros) {
            texto = String.format("%.3f", dinConvertido);
        } else {
            texto = String.format("%.2f", dinConvertido);
        }
        dineroConvertido.setText(texto);
        repaint();
        revalidate();
    }
    
    public boolean getEstadoConvertor () {
        return euros;
    }
    
    public void setEstadoConvertor (boolean estadoConversor) {
        euros = estadoConversor;
    }
    
    public JTextField getTextFieldDinero() {
        return dineroSinConvertir;
    }

    public void setDineroParaConvertir(double d) {
        dineroSinConvertir.setText(String.valueOf(d));
    }

    public void addListeners(ActionListener listenerLimpiar, 
    ActionListener listenerCambiarValor, 
    ActionListener listenerConvertir, KeyListener listenerTeclado) {
        limpiar.addActionListener(listenerLimpiar);
        cambiarValor.addActionListener(listenerCambiarValor);
        convertir.addActionListener(listenerConvertir);
        dineroSinConvertir.addKeyListener(listenerTeclado);
    }
}
