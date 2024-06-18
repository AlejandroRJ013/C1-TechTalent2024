package com.ejercicio01.vista;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PanelSelect extends JFrame {
    public String query;

    public PanelSelect() {
        setTitle("Seleccionar datos");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER; // Para centrar los componentes horizontalmente
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] labels = { "SELECT: ", "FROM: ", "WHERE: ", "GROUP BY: ", "HAVING: ", "ORDER BY: " };
        ArrayList<JTextField> textFields = new ArrayList<>();

        for (String label : labels) {
            JLabel jLabel = new JLabel(label);
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            textFields.add(new JTextField(20));

            JPanel fila = new JPanel();
            fila.setLayout(new BoxLayout(fila, BoxLayout.X_AXIS));
            fila.setBorder(new EmptyBorder(0, 0, 2, 0));
            fila.add(jLabel);
            fila.add(textFields.get(textFields.size() - 1));

            gbc.gridx = 0;
            gbc.gridy = textFields.size() - 1;
            gbc.weightx = 1.0;
            add(fila, gbc);
        }

        JButton submit = new JButton("Select");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                StringBuilder queryStrBuil = new StringBuilder();
                for (JTextField textField : textFields) {
                    String valor = textField.getText();
                    if (!valor.isEmpty()) {
                        switch (i) {
                            case 0:
                                queryStrBuil.append("SELECT " + valor);
                                break;

                            case 1:
                                queryStrBuil.append(" FROM " + valor);
                                break;

                            case 2:
                                queryStrBuil.append(" WHERE " + valor);
                                break;

                            case 3:
                                queryStrBuil.append(" GROUP BY " + valor);
                                break;

                            case 4:
                                queryStrBuil.append(" HAVING " + valor);
                                break;

                            case 5:
                                queryStrBuil.append(" ORDER BY " + valor);
                                break;

                            default:
                                break;
                        }
                    }
                    i++;
                }

                query = queryStrBuil.toString();

                dispose(); // Cierra la ventana después de la inserción
            }
        });

        gbc.gridx = 0;
        gbc.gridy = textFields.size();
        gbc.anchor = GridBagConstraints.CENTER;
        add(submit, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getQuery() {
        return query;
    }
}