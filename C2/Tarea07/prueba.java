import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class prueba {

    public static void main(String[] args) {
        StringBuilder datos = new StringBuilder();
        HashMap<Integer, String> idNombre = new HashMap<>();

        boolean ordenarID = false;
        boolean ordenarNombre = false;
        boolean ordenarEdad = false;

        idNombre.put(1, "Jose");
        idNombre.put(2, "Isabel");
        idNombre.put(3, "Joel");
        idNombre.put(4, "Sebas");
        idNombre.put(5, "Abdellah");
        idNombre.put(6, "Antonio");
        idNombre.put(7, "Diego");
        idNombre.put(8, "Manel");
        idNombre.put(9, "Jessica");
        idNombre.put(10, "Santos");
        idNombre.put(11, "Alex");
        idNombre.put(12, "Ana María");
        idNombre.put(13, "Aurora");
        idNombre.put(14, "Laia");
        idNombre.put(15, "Alejandro");

        System.out.println("Pausa");

        marcadores(datos, ordenarID, ordenarNombre, ordenarEdad);

        System.out.println("Pausado");
    }

    public static void marcadores(StringBuilder datos, boolean ordenarID, boolean ordenarNombre, boolean ordenarEdad) {
        boolean[] orden = new boolean[3];
        JFrame frame = new JFrame("Como se organizarán los grupos");
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel marcadores = new JPanel();
        marcadores.setSize(300, 50);

        JPanel boton = new JPanel();
        boton.setSize(300, 50);

        JLabel labelId = new JLabel("ID: "); // Etiqueta
        JCheckBox id = new JCheckBox(); // Casilla
        JLabel labelNombre = new JLabel("Nombre: ");
        JCheckBox nombre = new JCheckBox();
        JLabel labelEdad = new JLabel("Edad: ");
        JCheckBox edad = new JCheckBox();

        marcadores.add(labelId);
        marcadores.add(id);
        marcadores.add(labelNombre);
        marcadores.add(nombre);
        marcadores.add(labelEdad);
        marcadores.add(edad);

        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (id.isSelected() && nombre.isSelected() || edad.isSelected()) {
                    if (nombre.isSelected()) {
                        nombre.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }
            }
        });

        nombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (nombre.isSelected() && id.isSelected() || edad.isSelected()) {
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }
            }
        });

        edad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (edad.isSelected() && id.isSelected() || nombre.isSelected()) {
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        nombre.setSelected(false);
                    }
                }
            }
        });

        JButton continuar = new JButton("Continuar");
        continuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana actual
                if (id.isSelected()) {
                    orden[0] = true;
                } else if (nombre.isSelected()) {
                    orden[1] = true;
                } else if (edad.isSelected()) {
                    orden[2] = true;
                }
            }
        });

        if (orden[0]) {
            ordenarID = true;
        } else if (orden[1]) {
            ordenarNombre = true;
        } else if (orden[2]) {
            ordenarEdad = true;
        }

        // Agregamos los paneles al BorderLayout
        frame.add(marcadores, BorderLayout.CENTER);
        frame.add(boton, BorderLayout.SOUTH);

        boton.add(continuar);

        frame.setVisible(true);

        while (frame.isVisible()) {
            try {
                Thread.sleep(100); // Pausar el hilo por un corto período de tiempo
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
