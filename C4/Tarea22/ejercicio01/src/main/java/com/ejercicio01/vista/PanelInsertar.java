package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PanelInsertar extends JFrame {
    public String colAfectadas;
    public String valoresIntroducidos;
    public StringBuilder columnasAfectadas;
    public StringBuilder values;

    public PanelInsertar(int col, ArrayList<String> nombres, ArrayList<String> valores) {
        setTitle("Insertar datos");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER; // Para centrar los componentes horizontalmente
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ArrayList<JTextField> textFields = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            JPanel fila = new JPanel();
            fila.setLayout(new BoxLayout(fila, BoxLayout.X_AXIS));
            fila.setBorder(new EmptyBorder(0, 0, 2, 0));

            JLabel label = new JLabel();
            if (nombres.get(i).equalsIgnoreCase("fecha")) {
                label = new JLabel(nombres.get(i).toUpperCase() + " (YYYY-MM-DD) : ");
            } else {
                label = new JLabel(nombres.get(i).toUpperCase() + ":    ");
            }
            label.setHorizontalAlignment(SwingConstants.CENTER);
            JTextField campo = new JTextField(20);
            textFields.add(campo);

            fila.add(label);
            fila.add(campo);

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 1.0;
            add(fila, gbc);
        }

        columnasAfectadas = new StringBuilder("(");
        values = new StringBuilder("(");

        JButton submit = new JButton("Insertar");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                for (JTextField textField : textFields) {
                    String valor = textField.getText();
                    if (valor.isEmpty()) {
                        valores.add("");
                    } else {
                        columnasAfectadas.append(nombres.get(i) + ",");
                        values.append("'" + valor + "',");
                        valores.add(valor);
                    }
                    i++;
                }

                columnasAfectadas.deleteCharAt(columnasAfectadas.length() - 1);
                columnasAfectadas.append(")");
                values.deleteCharAt(values.length() - 1);
                values.append(")");

                colAfectadas = columnasAfectadas.toString();
                valoresIntroducidos = values.toString();

                dispose(); // Cierra la ventana después de la inserción
            }
        });

        gbc.gridx = 0;
        gbc.gridy = col;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submit, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getColumnasAfectadas() {
        return colAfectadas;
    }

    public String getValoresIntroducidos() {
        return valoresIntroducidos;
    }
}
