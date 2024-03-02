import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebasGrupo2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Alumnos curso TechTalent2024");
        frame.setSize(450, 300); // Tamaño
        frame.setLocationRelativeTo(null); // Posición inicial al medio de la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana cierra el programa

        JPanel titul = new JPanel();
        JLabel titulo = new JLabel(" - - CON QUE VALOR SE ORDENARÁN LOS ALUMNOS - - ");
        titulo.setVerticalAlignment(SwingConstants.TOP);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titul.add(titulo);

        JPanel marcadores = new JPanel();
        marcadores.setBounds(0, 25, 100, 280);

        JLabel labelId = new JLabel("ID: ");
        JCheckBox id = new JCheckBox();
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

        JPanel contenidoDinamico = new JPanel();
        contenidoDinamico.setBounds(100, 25, 350, 280);
        JPanel ordenID = new JPanel();
        ordenID.add(new JLabel("¿Funciona ID?"));

        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (id.isSelected() && nombre.isSelected() || edad.isSelected()) {
                    if (nombre.isSelected()) {
                        nombre.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }

                if (id.isSelected()) {
                    contenidoDinamico.removeAll(); // Limpiar contenido previo
                    contenidoDinamico.add(ordenID);
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Actualizar el layout del frame
                contenidoDinamico.repaint(); // Actualizar el layout del frame
            }
        });

        JPanel ordenNombre = new JPanel();
        ordenNombre.add(new JLabel("¿Funciona Nombre?"));

        nombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (nombre.isSelected() && id.isSelected() || edad.isSelected()) {
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }

                if (nombre.isSelected()) {
                    contenidoDinamico.removeAll(); // Limpiar contenido previo
                    contenidoDinamico.add(ordenNombre);
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Actualizar el layout del frame
                contenidoDinamico.repaint(); // Actualizar el layout del frame
            }
        });

        JPanel ordenEdad = new JPanel();
        ordenEdad.add(new JLabel("¿Funciona Edad?"));

        edad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (edad.isSelected() && id.isSelected() || nombre.isSelected()) {
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        nombre.setSelected(false);
                    }
                }

                if (edad.isSelected()) {
                    contenidoDinamico.removeAll(); // Limpiar contenido previo
                    contenidoDinamico.add(ordenEdad);
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Actualizar el layout del frame
                contenidoDinamico.repaint(); // Actualizar el layout del frame
            }
        });

        frame.add(contenidoDinamico);
        frame.add(marcadores);
        frame.add(titul);
        frame.setVisible(true);
    }
}