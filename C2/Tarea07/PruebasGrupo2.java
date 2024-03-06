import javax.swing.*;

import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PruebasGrupo2 {
    public static void main(String[] args) {
        StringBuilder grupo1 = new StringBuilder();
        StringBuilder grupo2 = new StringBuilder();
        StringBuilder grupo3 = new StringBuilder();
        StringBuilder grupo4 = new StringBuilder();
        StringBuilder grupo5 = new StringBuilder();
        HashMap<Integer, String> idNombre = new HashMap<>();
        HashMap<Integer, Integer> idEdad = new HashMap<>();
        ArrayList<Integer> ordenDeLosID = new ArrayList<>();
        AtomicBoolean ordenarID = new AtomicBoolean(false);
        AtomicBoolean ordenarNombre = new AtomicBoolean(false);
        AtomicBoolean ordenarEdad = new AtomicBoolean(false);

        panel_informacionAlumnos(idNombre, idEdad);

        marcadores(ordenarID, ordenarNombre, ordenarEdad);

        if (ordenarID.get()) {
            System.out.println("Ordenar por ID");
        } else if (ordenarNombre.get()) {
            gruposAlfabetizados(idNombre, ordenDeLosID);
            anadirInfo_StrBuilder(idNombre, ordenDeLosID, grupo1, grupo2, grupo3, grupo4, grupo5);
        } else if (ordenarEdad.get()) {
            System.out.println("Ordenar por Edad");
        } else {
            System.out.println("3");
        }

        ventana(grupo1, grupo2, grupo3, grupo4, grupo5);
    }

    public static void panel_informacionAlumnos(HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel ejemplo = new JPanel(new GridLayout(1, 2));
        JPanel datosIntroducidos = new JPanel(new GridLayout(1, 2));

        ejemplo.add(new JLabel("UTILICE EL SIGUIENTE FORMATO   ==>   ==>"));
        ejemplo.add(new JLabel("[ Nombre_compuesto Edad, Nombre_com... ]"));
        datosIntroducidos.add(new JLabel("   Alumnos del curso TechTalent 2024: "));
        JTextField alumnos = new JTextField(20);
        datosIntroducidos.add(alumnos);

        panel.add(ejemplo);
        panel.add(datosIntroducidos);

        int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca los datos del alumno",
                JOptionPane.OK_CANCEL_OPTION);

        asignarInfo_Hash(result, alumnos, idNombre, idEdad);
    }

    public static void asignarInfo_Hash(int result, JTextField alumnos, HashMap<Integer, String> idNombre,
            HashMap<Integer, Integer> idEdad) {
        if (result == JOptionPane.OK_OPTION) {
            String nombreAlumno = alumnos.getText();
            String[] nombreEdad = nombreAlumno.split(", ");

            for (int i = 0; i < nombreEdad.length; i++) {
                String[] info = nombreEdad[i].split(" ");
                idNombre.put((i + 1), info[0]);
                idEdad.put((i + 1), Integer.parseInt(info[1]));
                System.out.println("ID: " + (i + 1) + " Nombre: " + info[0] + " Edad: " + info[1] + "\n HashNom: "
                        + idNombre.toString() + "\n HashEdad: " + idEdad.toString());
            }
        } else if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
    }

    public static void marcadores(AtomicBoolean ordenarID, AtomicBoolean ordenarNombre, AtomicBoolean ordenarEdad) {
        JFrame frame = new JFrame("Como se organizarán los grupos");
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel marcadores = new JPanel(new GridLayout(1, 3));
        marcadores.setSize(300, 50);

        JPanel boton = new JPanel();
        boton.setSize(300, 50);

        JPanel texto_casilla_id = new JPanel();
        JPanel texto_casilla_nombre = new JPanel();
        JPanel texto_casilla_edad = new JPanel();

        JCheckBox id = new JCheckBox();
        JCheckBox nombre = new JCheckBox();
        JCheckBox edad = new JCheckBox();

        // Opción predeterminada
        id.setSelected(true);

        texto_casilla_id.add(new JLabel("ID: "));
        texto_casilla_id.add(id);
        texto_casilla_nombre.add(new JLabel("Nombre: "));
        texto_casilla_nombre.add(nombre);
        texto_casilla_edad.add(new JLabel("Edad: "));
        texto_casilla_edad.add(edad);

        marcadores.add(texto_casilla_id);
        marcadores.add(texto_casilla_nombre);
        marcadores.add(texto_casilla_edad);

        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (id.isSelected() && nombre.isSelected() || edad.isSelected()) {
                    if (nombre.isSelected()) {
                        nombre.setSelected(false);
                    } else {
                        edad.setSelected(false);
                    }
                }

                if (!id.isSelected() && !nombre.isSelected() && !edad.isSelected()) {
                    id.setSelected(true);
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

                if (!nombre.isSelected() && !id.isSelected() && !edad.isSelected()) {
                    nombre.setSelected(true);
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

                if (!edad.isSelected() && !id.isSelected() && !nombre.isSelected()) {
                    edad.setSelected(true);
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

        boton.add(continuar);

        // Agregamos los paneles al BorderLayout
        frame.add(marcadores, BorderLayout.CENTER);
        frame.add(boton, BorderLayout.SOUTH);

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

    public static void ventana(StringBuilder grupo1,
            StringBuilder grupo2, StringBuilder grupo3, StringBuilder grupo4, StringBuilder grupo5) {
        JFrame frame = new JFrame("Alumnos ordenados");
        frame.setSize(600, 155);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titul = new JPanel();
        JLabel titulo = new JLabel(" - - ALUMNOS DEL CURSO - - ");
        titulo.setVerticalAlignment(SwingConstants.TOP); // Mover el texto al borde superior del JFrame en la posición
                                                         // vertical
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Mover el texto al centro en la posición horizontal
        titul.add(titulo);

        JPanel tituloGrupo = new JPanel(new GridLayout(1, 5));
        tituloGrupo.setBounds(10, 20, 590, 30);
        JPanel contenidoDinamico = new JPanel(new GridLayout(1, 5)); // Creamos un panel donde iremos poniendo varios
                                                                     // paneles según que quiero mostrar
        contenidoDinamico.setBounds(10, 40, 590, 150);
        JPanel panelGrupo1 = new JPanel();
        JPanel panelGrupo2 = new JPanel();
        JPanel panelGrupo3 = new JPanel();
        JPanel panelGrupo4 = new JPanel();
        JPanel panelGrupo5 = new JPanel();

        JLabel grupo1Label = new JLabel();
        grupo1Label.setText("/ GRUPO 1 /\n");
        tituloGrupo.add(grupo1Label);
        JPanel integrantesG1 = new JPanel();

        panelIntegrantes(grupo1, integrantesG1);

        JLabel grupo2Label = new JLabel();
        grupo2Label.setText("/ GRUPO 2 /\n");
        tituloGrupo.add(grupo2Label);
        JPanel integrantesG2 = new JPanel();

        panelIntegrantes(grupo2, integrantesG2);

        JLabel grupo3Label = new JLabel();
        grupo3Label.setText("/ GRUPO 3 /\n");
        tituloGrupo.add(grupo3Label);
        JPanel integrantesG3 = new JPanel();

        panelIntegrantes(grupo3, integrantesG3);

        JLabel grupo4Label = new JLabel();
        grupo4Label.setText("/ GRUPO 4 /\n");
        tituloGrupo.add(grupo4Label);
        JPanel integrantesG4 = new JPanel();

        panelIntegrantes(grupo4, integrantesG4);

        JLabel grupo5Label = new JLabel();
        grupo5Label.setText("/ GRUPO 5 /\n");
        tituloGrupo.add(grupo5Label);
        JPanel integrantesG5 = new JPanel();

        panelIntegrantes(grupo5, integrantesG5);

        panelGrupo1.add(integrantesG1);
        panelGrupo2.add(integrantesG2);
        panelGrupo3.add(integrantesG3);
        panelGrupo4.add(integrantesG4);
        panelGrupo5.add(integrantesG5);

        contenidoDinamico.add(panelGrupo1);
        contenidoDinamico.add(panelGrupo2);
        contenidoDinamico.add(panelGrupo3);
        contenidoDinamico.add(panelGrupo4);
        contenidoDinamico.add(panelGrupo5);

        frame.add(contenidoDinamico);
        frame.add(tituloGrupo);
        frame.add(titul);
        frame.setVisible(true); // Hacer visible el frame
    }

    public static void panelIntegrantes(StringBuilder integrantesGrupo, JPanel losIntegrantes) {
        losIntegrantes.setLayout(new BoxLayout(losIntegrantes, BoxLayout.Y_AXIS));
        String[] integrantes = integrantesGrupo.toString().split(" ");
        for (String integrante : integrantes) {
            if (integrante.contains("_")) {
                String[] nombre_compuesto = integrante.split("_");
                StringBuilder nombre = new StringBuilder();
                for (int i = 0; i < nombre_compuesto.length; i++) {
                    nombre.append(nombre_compuesto[i] + " ");
                }
                integrante = nombre.toString();
            }
            JLabel labelIntegrante = new JLabel(" -> " + integrante);
            losIntegrantes.add(labelIntegrante);
        }
    }

    public static void gruposAlfabetizados(HashMap<Integer, String> idNombre, ArrayList<Integer> ordenDeLosID) {
        ArrayList<String> ordenAlfa = new ArrayList<>();
        for (String nombre : idNombre.values()) {
            ordenAlfa.add(nombre);
        }

        Collections.sort(ordenAlfa);

        for (String nombreBuscado : ordenAlfa) {
            for (int iDe : idNombre.keySet()) {
                if (idNombre.get(iDe).equals(nombreBuscado)) {
                    ordenDeLosID.add(iDe);
                }
            }
        }
    }

    public static void anadirInfo_StrBuilder(HashMap<Integer, String> idNombre, ArrayList<Integer> ordenDeLosID,
            StringBuilder grupo1, StringBuilder grupo2, StringBuilder grupo3,
            StringBuilder grupo4, StringBuilder grupo5) {
        int cantidadGrupos = (int) Math.ceil((double) ordenDeLosID.size() / 3);

        for (int i = 0; i < cantidadGrupos; i++) {
            StringBuilder grupo = new StringBuilder();
            int inicio = i * 3;
            int fin = Math.min(inicio + 3, ordenDeLosID.size());

            for (int j = inicio; j < fin; j++) {
                int id = ordenDeLosID.get(j);
                String nombre = idNombre.get(id);
                grupo.append(nombre).append(" ");
            }

            switch (i) {
                case 0:
                    grupo1.append(grupo.toString());
                    break;
                case 1:
                    grupo2.append(grupo.toString());
                    break;
                case 2:
                    grupo3.append(grupo.toString());
                    break;
                case 3:
                    grupo4.append(grupo.toString());
                    break;
                case 4:
                    grupo5.append(grupo.toString());
                    break;
                default:
                    break;
            }
        }
    }
}