import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PruebasGrupo2 {
    public static void main(String[] args) {
        StringBuilder datos = new StringBuilder();
        StringBuilder grupo1 = new StringBuilder("\nGrupo 1: \n");
        StringBuilder grupo2 = new StringBuilder("\nGrupo 2: \n");
        StringBuilder grupo3 = new StringBuilder("\nGrupo 3: \n");
        StringBuilder grupo4 = new StringBuilder("\nGrupo 4: \n");
        StringBuilder grupo5 = new StringBuilder("\nGrupo 5: \n");
        HashMap<Integer, String> idNombre = new HashMap<>();
        HashMap<Integer, Integer> idEdad = new HashMap<>();
        AtomicBoolean ordenarID = new AtomicBoolean(false);
        AtomicBoolean ordenarNombre = new AtomicBoolean(false);
        AtomicBoolean ordenarEdad = new AtomicBoolean(false);

        // int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));

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

        // int ultimoID = 0;
        // for (int i = 1; i <= cant; i++) {
        // JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout para organizar
        // los campos de texto en dos
        // // columnas
        // panel.add(new JLabel("Nombre: "));
        // JTextField nombre = new JTextField(10);
        // panel.add(nombre);

        // panel.add(new JLabel("Edad: "));
        // JTextField edad = new JTextField(10);
        // panel.add(edad);

        // int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca los datos
        // del alumno",
        // JOptionPane.OK_CANCEL_OPTION);

        // if (result == JOptionPane.OK_OPTION) {
        // String nombreAlumno = nombre.getText();
        // int edadAlumno = Integer.parseInt(edad.getText());
        // idNombre.put(i, nombreAlumno);
        // idEdad.put(i, edadAlumno);
        // }
        // ultimoID = i;
        // }

        for (Integer id : idNombre.keySet()) {
            datos.append("Nombre: " + idNombre.get(id) + "\n - ID: " + id + "\n - Edad: " + idEdad.get(id));

            System.out.println("ID: " + id /* + " ULTIMO id: " + ultimoID */);
            System.out.println(" - Nombre: " + idNombre.get(id) + "\n - Edad: " + idEdad.get(id));

        }
        System.out.println("1");
        marcadores(datos, ordenarID, ordenarNombre, ordenarEdad);
        System.out.println("2");

        if (ordenarID.get()) {
            System.out.println("Ordenar por ID");
        } else if (ordenarNombre.get()) {
            gruposAlfabetizados(idNombre, grupo1, grupo2, grupo3, grupo4, grupo5);
        } else if (ordenarEdad.get()) {
            System.out.println("Ordenar por Edad");
        } else {
            System.out.println("3");
        }

        ventana(idNombre, grupo1, grupo2, grupo3, grupo4, grupo5, ordenarID, ordenarNombre, ordenarEdad);
    }

    public static void marcadores(StringBuilder datos, AtomicBoolean ordenarID, AtomicBoolean ordenarNombre,
            AtomicBoolean ordenarEdad) {
        JFrame frame = new JFrame("Como se organizarán los grupos");
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel marcadores = new JPanel();
        marcadores.setSize(300, 50);

        JPanel boton = new JPanel();
        boton.setSize(300, 50);

        JCheckBox id = new JCheckBox();
        JCheckBox nombre = new JCheckBox();
        JCheckBox edad = new JCheckBox();

        marcadores.add(new JLabel("ID: "));
        marcadores.add(id);
        marcadores.add(new JLabel("Nombre: "));
        marcadores.add(nombre);
        marcadores.add(new JLabel("Edad: "));
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
                if (id.isSelected()) {
                    ordenarID.set(true);
                } else if (nombre.isSelected()) {
                    ordenarNombre.set(true);
                } else if (edad.isSelected()) {
                    ordenarEdad.set(true);
                }
                frame.dispose(); // Cerrar la ventana actual
            }
        });

        // Agregamos los paneles al BorderLayout
        frame.add(marcadores, BorderLayout.CENTER);
        frame.add(boton, BorderLayout.SOUTH);

        boton.add(continuar);

        frame.setVisible(true);
        // Pausar el hilo mientras se esta ejecutando la ventana
        while (frame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void ventana(HashMap<Integer, String> idNombre, StringBuilder grupo1,
            StringBuilder grupo2, StringBuilder grupo3, StringBuilder grupo4, StringBuilder grupo5,
            AtomicBoolean ordenarID, AtomicBoolean ordenarNombre,
            AtomicBoolean ordenarEdad) {
        JFrame frame = new JFrame("Alumnos curso TechTalent2024");
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titul = new JPanel();
        JLabel titulo = new JLabel(" - - ALUMNOS DEL CURSO - - ");
        titulo.setVerticalAlignment(SwingConstants.TOP); // Mover el texto al borde superior del JFrame en la posición
                                                         // vertical
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Mover el texto al centro en la posición horizontal
        titul.add(titulo);

        JPanel contenidoDinamico = new JPanel(); // Creamos un panel donde iremos poniendo varios paneles según que
                                                 // quiero mostrar
        contenidoDinamico.setBounds(0, 50, 600, 285); // Establezco un tamaño y posición fijo
        JPanel panelGrupo1 = new JPanel();
        panelGrupo1.setBounds(0, 50, 120, 285);
        JPanel panelGrupo2 = new JPanel();
        panelGrupo2.setBounds(120, 50, 120, 285);
        JPanel panelGrupo3 = new JPanel();
        panelGrupo3.setBounds(240, 50, 120, 285);
        JPanel panelGrupo4 = new JPanel();
        panelGrupo4.setBounds(360, 50, 120, 285);
        JPanel panelGrupo5 = new JPanel();
        panelGrupo5.setBounds(480, 50, 120, 285);

        if (ordenarID.get()) {
            panelGrupo1.add(new JLabel(grupo1.toString()));
            panelGrupo2.add(new JLabel(grupo2.toString()));
            panelGrupo3.add(new JLabel(grupo3.toString()));
            panelGrupo4.add(new JLabel(grupo4.toString()));
            panelGrupo5.add(new JLabel(grupo5.toString()));
        } else if (ordenarNombre.get()) {
            gruposAlfabetizados(idNombre, grupo1, grupo2, grupo3, grupo4, grupo5);
            panelGrupo1.add(new JLabel(grupo1.toString()));
            panelGrupo2.add(new JLabel(grupo2.toString()));
            panelGrupo3.add(new JLabel(grupo3.toString()));
            panelGrupo4.add(new JLabel(grupo4.toString()));
            panelGrupo5.add(new JLabel(grupo5.toString()));
        } else if (ordenarEdad.get()) {
            panelGrupo1.add(new JLabel(grupo1.toString()));
            panelGrupo2.add(new JLabel(grupo2.toString()));
            panelGrupo3.add(new JLabel(grupo3.toString()));
            panelGrupo4.add(new JLabel(grupo4.toString()));
            panelGrupo5.add(new JLabel(grupo5.toString()));
        } else {
            System.out.println("3");
        }

        contenidoDinamico.add(panelGrupo1);
        contenidoDinamico.add(panelGrupo2);
        contenidoDinamico.add(panelGrupo3);
        contenidoDinamico.add(panelGrupo4);
        contenidoDinamico.add(panelGrupo5);
        frame.add(contenidoDinamico);
        frame.add(titul);
        frame.setVisible(true); // Hacer visible el frame
    }

    public static void gruposAlfabetizados(HashMap<Integer, String> idNombre, StringBuilder grupo1,
            StringBuilder grupo2, StringBuilder grupo3, StringBuilder grupo4, StringBuilder grupo5) {
        StringBuilder grup = new StringBuilder();
        ArrayList<String> ordenAlfa = new ArrayList<>();
        for (String nombre : idNombre.values()) {
            ordenAlfa.add(nombre);
        }

        System.out.println(ordenAlfa.toString());
        Collections.sort(ordenAlfa);
        System.out.println(ordenAlfa.toString());

        int numeroGrupo = 1;
        int integrantesGrupo = 1;
        for (int indice = 0; indice < ordenAlfa.size(); indice++) {
            if (integrantesGrupo <= 2) {
                String nombre = ordenAlfa.get(indice);
                System.out.println(ordenAlfa.get(indice));
                grup.append(nombre + ", ");
            } else if (integrantesGrupo == 3) {
                String nombre = ordenAlfa.get(indice);
                grup.append(nombre);
            }

            if (numeroGrupo == 1 && integrantesGrupo == 3) {
                grupo1.append(grup.toString());
            } else if (numeroGrupo == 2 && integrantesGrupo == 3) {
                grupo2.append(grup.toString());
            } else if (numeroGrupo == 3 && integrantesGrupo == 3) {
                grupo3.append(grup.toString());
            } else if (numeroGrupo == 4 && integrantesGrupo == 3) {
                grupo4.append(grup.toString());
            } else if (numeroGrupo == 5 && integrantesGrupo == 3) {
                grupo5.append(grup.toString());
            }

            if (integrantesGrupo == 3) {
                integrantesGrupo = 0;
                numeroGrupo++;
                grup.setLength(0);
            }

            integrantesGrupo++;
        }
    }
}