import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class PruebasGrupo2 {
    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, Integer>> primero = new HashMap<>();
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
        // segundo.put("Jose", 26);
        // segundo.put("Isabel", 18);
        // segundo.put("Joel", 19);
        // segundo.put("Sebas", 29);
        // segundo.put("Abdellah", 19);
        // segundo.put("Antonio", 23);
        // segundo.put("Diego", 23);
        // segundo.put("Manel", 26);
        // segundo.put("Jessica", 23);
        // segundo.put("Santos", 23);
        // segundo.put("Alex", 23);
        // segundo.put("Ana María", 23);
        // segundo.put("Aurora", 23);
        // segundo.put("Laia", 23);
        // segundo.put("Alejandro", 19);

        HashMap<String, Integer> segundo = new HashMap<>();
        for (int i = 1; i <= cant; i++) {
            JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout para organizar los campos de texto en dos
                                                             // columnas
            panel.add(new JLabel("Nombre del alumno: "));
            JTextField nombre = new JTextField(10);
            panel.add(nombre);

            panel.add(new JLabel("Edad del alummno: "));
            JTextField edad = new JTextField(10);
            panel.add(edad);

            int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca información del producto",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String nombreAlumno = nombre.getText();
                int edadAlumno = Integer.parseInt(edad.getText());
                segundo.put(nombreAlumno, edadAlumno);
                primero.put(i, segundo);
            }
        }

        ventana(primero, segundo);

        for (Integer key : primero.keySet()) {
            System.out.println("ID: " + key);
            HashMap<String, Integer> alumno = primero.get(key);
            for (String nombre : alumno.keySet()) {
                int edad = alumno.get(nombre);
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }
        }
    }

    public static void ventana(HashMap<Integer, HashMap<String, Integer>> primero, HashMap<String, Integer> segundo) {
        JFrame frame = new JFrame("Alumnos curso TechTalent2024");
        frame.setSize(450, 300); // Tamaño
        frame.setLocationRelativeTo(null); // Posición inicial al medio de la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana cierra el programa

        JPanel titul = new JPanel();
        JLabel titulo = new JLabel(" - - CON QUE VALOR SE ORDENARÁN LOS ALUMNOS - - "); // JLabel titulo
        titulo.setVerticalAlignment(SwingConstants.TOP); // Mover el texto al borde superior del JFrame en la posición
                                                         // vertical
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Mover el texto al centro en la posición horizontal
        titul.add(titulo);

        JPanel marcadores = new JPanel();
        marcadores.setBounds(0, 25, 100, 280); // Establecer el tamaño y posición del panel a uno que nos convenga

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

        JPanel contenidoDinamico = new JPanel(); // Creamos un panel donde iremos poniendo varios paneles según que
                                                 // quiero mostrar
        contenidoDinamico.setBounds(100, 25, 350, 280); // Establezco un tamaño y posición fijo
        JPanel ordenID = new JPanel();
        // Método para ordenar los alumnos por el ID, concatenandolo a un StringBuilder
        // para mostrarlo en la linea de abajo [ordenID.add(new JLabel("¿Funciona ID?"))
        // --> ordenID.add(new JLabel(StringBuilder.toString))]
        ordenID.add(new JLabel(primero.toString()));

        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (id.isSelected() && nombre.isSelected() || edad.isSelected()) { // Cuando selecciones una casilla
                                                                                      // con otra seleccionada, la
                                                                                      // anterior se deseleccionará
                    if (nombre.isSelected()) {
                        nombre.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }

                if (id.isSelected()) { // Cuando la casilla esté seleccionada
                    contenidoDinamico.removeAll(); // Limpiar contenido previo del panelDinámico
                    contenidoDinamico.add(ordenID); // Añade el contenido del panel ordenID al dinámico
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Revalidar el panelDinámico
                contenidoDinamico.repaint(); // Repintar el panelDinámico
            }
        });

        JPanel ordenNombre = new JPanel();
        // Método para ordenar los alumnos por el Nombre, concatenandolo a un
        // StringBuilder para mostrarlo en la linea de abajo [ordenID.add(new
        // JLabel("¿Funciona Nombre?")) --> ordenID.add(new
        // JLabel(StringBuilder.toString))
        ordenNombre.add(new JLabel("¿Funciona Nombre?"));

        nombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (nombre.isSelected() && id.isSelected() || edad.isSelected()) { // Cuando selecciones una casilla
                                                                                      // con otra seleccionada, la
                                                                                      // anterior se deseleccionará
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }

                if (nombre.isSelected()) { // Cuando la casilla esté seleccionada
                    contenidoDinamico.removeAll(); // Limpiar contenido previo del panelDinámico
                    contenidoDinamico.add(ordenNombre); // Añade el contenido del panel ordenNombre al dinámico
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Revalidar el panelDinámico
                contenidoDinamico.repaint(); // Repintar el panelDinámico
            }
        });

        JPanel ordenEdad = new JPanel();
        // Método para ordenar los alumnos por el Edad, concatenandolo a un
        // StringBuilder para mostrarlo en la linea de abajo [ordenID.add(new
        // JLabel("¿Funciona Edad?")) --> ordenID.add(new
        // JLabel(StringBuilder.toString))
        ordenEdad.add(new JLabel("¿Funciona Edad?"));

        edad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (edad.isSelected() && id.isSelected() || nombre.isSelected()) { // Cuando selecciones una casilla
                                                                                      // con otra seleccionada, la
                                                                                      // anterior se deseleccionará
                    if (id.isSelected()) {
                        id.setSelected(false);
                    } else {
                        nombre.setSelected(false);
                    }
                }

                if (edad.isSelected()) { // Cuando la casilla esté seleccionada
                    contenidoDinamico.removeAll(); // Limpiar contenido previo del panelDinámico
                    contenidoDinamico.add(ordenEdad); // Añade el contenido del panel ordenEdad al dinámico
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Revalidar el panelDinámico
                contenidoDinamico.repaint(); // Repintar el panelDinámico
            }
        });

        frame.add(contenidoDinamico);
        frame.add(marcadores);
        frame.add(titul);
        frame.setVisible(true); // Hacer visible el frame
    }
}