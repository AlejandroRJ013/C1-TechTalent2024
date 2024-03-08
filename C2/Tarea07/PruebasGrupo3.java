import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PruebasGrupo3 {
    public static void main(String[] args) {
        HashMap<Integer, String> idNombre = new HashMap<>();
        HashMap<Integer, Integer> idEdad = new HashMap<>();
        ArrayList<Integer> ordenDeLosID = new ArrayList<>();
        AtomicBoolean ordenarID = new AtomicBoolean(false);
        AtomicBoolean ordenarNombre = new AtomicBoolean(false);
        AtomicBoolean ordenarEdad = new AtomicBoolean(false);

        panel_informacionAlumnos(idNombre, idEdad);

        generarGrupos(idNombre, idEdad, ordenDeLosID, ordenarID, ordenarNombre, ordenarEdad);
    }

    public static void generarGrupos(HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad,
    ArrayList<Integer> ordenDeLosID, AtomicBoolean ordenarID, AtomicBoolean ordenarNombre,
    AtomicBoolean ordenarEdad) {
        marcadores(ordenarID, ordenarNombre, ordenarEdad);

        if (ordenarID.get()) {
            gruposAleatorios(idNombre, ordenDeLosID);
        } else if (ordenarNombre.get()) {
            gruposAlfabetizados(idNombre, ordenDeLosID);
        } else if (ordenarEdad.get()) {
            gruposPorEdad(idEdad, ordenDeLosID);
        }

        ventana(idNombre, idEdad, ordenDeLosID, ordenarID, ordenarNombre, ordenarEdad);
    }

    public static void gruposAleatorios(HashMap<Integer, String> idNombre, ArrayList<Integer> ordenDeLosID) {
        ArrayList<Integer> idsOrdenadosAleatoriamente = new ArrayList<>(idNombre.keySet());

        // Ordenar los IDs de manera aleatoria
        Collections.shuffle(idsOrdenadosAleatoriamente);

        // Agregar los IDs ordenados a ordenDeLosID
        ordenDeLosID.addAll(idsOrdenadosAleatoriamente);

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

    public static void gruposPorEdad(HashMap<Integer, Integer> idEdad, ArrayList<Integer> ordenDeLosID) {
        ArrayList<Integer> idsOrdenadosPorEdad = new ArrayList<>(idEdad.keySet());

        // Ordenar los IDs según sus edades
        idsOrdenadosPorEdad.sort(Comparator.comparingInt(idEdad::get));

        // Agregar los IDs ordenados a ordenDeLosID
        ordenDeLosID.addAll(idsOrdenadosPorEdad);

    }

    public static void panel_informacionAlumnos(HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad) {
        JPanel saltoDeLinea = new JPanel();
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JPanel ejemplo = new JPanel(new GridLayout(1, 2));
        JPanel datosIntroducidos = new JPanel(new GridLayout(1, 2));

        JLabel titulo = new JLabel("- - INGRESE LOS DATOS DE LOS ALUMNOS - -");
        panel.add(titulo);

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        ejemplo.add(new JLabel("UTILICE EL SIGUIENTE FORMATO   ==>   ==>"));
        ejemplo.add(new JLabel("[ Nombre_compuesto Edad, Nombre_com... ]"));

        JLabel datosPedidos = new JLabel("Alumnos del curso TechTalent 2024:");
        datosPedidos.setHorizontalAlignment(SwingConstants.CENTER);
        datosIntroducidos.add(datosPedidos);
        JTextField alumnos = new JTextField(20);
        datosIntroducidos.add(alumnos);

        panel.add(saltoDeLinea);
        panel.add(ejemplo);
        panel.add(datosIntroducidos);

        int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca los datos del alumno",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

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
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel marcadores = new JPanel(new GridLayout(1, 3));
        marcadores.setSize(300, 50);
        marcadores.setBorder(new EmptyBorder(10, 5, 3, 5));

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

        accionesCasillas(id, nombre, edad);

        marcadores.add(texto_casilla_id);
        marcadores.add(texto_casilla_nombre);
        marcadores.add(texto_casilla_edad);

        boton.setBorder(new EmptyBorder(0, 5, 10, 5));
        boton.add(continuar);

        // Agregamos los paneles al BorderLayout
        frame.add(marcadores, BorderLayout.CENTER);
        frame.add(boton, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
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

    public static void accionesCasillas(JCheckBox id, JCheckBox nombre, JCheckBox edad) {
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
    }

    public static void ventana(HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad,
            ArrayList<Integer> ordenDeLosID, AtomicBoolean ordenarID, AtomicBoolean ordenarNombre,
            AtomicBoolean ordenarEdad) {
        JFrame frame = new JFrame("Alumnos ordenados");
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints posicionPanel = new GridBagConstraints();

        JLabel titulo = new JLabel(" - - ALUMNOS DEL CURSO - - ");
        titulo.setVerticalAlignment(SwingConstants.TOP); // Mover el texto al borde superior del JFrame en la posición
                                                         // vertical
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Mover el texto al centro en la posición horizontal
        JPanel titul = new JPanel();
        titul.add(titulo);

        JPanel tituloGrupo = new JPanel();
        tituloGrupo.setLayout(new BoxLayout(tituloGrupo, BoxLayout.X_AXIS));
        tituloGrupo.setBorder(new EmptyBorder(5, 0, 5, 0));

        JPanel contenidoDinamico = new JPanel(); // Creamos un panel donde iremos poniendo varios
                                                 // paneles según que quiero mostrar
        contenidoDinamico.setLayout(new BoxLayout(contenidoDinamico, BoxLayout.X_AXIS));
        contenidoDinamico.setBorder(new EmptyBorder(0, 0, 15, 0));

        crearGrupos(idNombre, idEdad, ordenDeLosID, contenidoDinamico);

        //NO FUNCIONA
        /*
        JButton otroMetodo = new JButton("Otro método");
        otroMetodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    generarGrupos(idNombre, idEdad, ordenDeLosID, ordenarID, ordenarNombre, ordenarEdad);
                  }
            }
        });
 */

        posicionPanel.gridx = 0;
        posicionPanel.gridy = 0;
        frame.add(titul, posicionPanel);

        posicionPanel.gridx = 0;
        posicionPanel.gridy = 1;
        frame.add(tituloGrupo, posicionPanel);

        posicionPanel.gridx = 0;
        posicionPanel.gridy = 2;
        frame.add(contenidoDinamico, posicionPanel);

        // posicionPanel.gridx = 0;
        // posicionPanel.gridy = 3;
        // frame.add(otroMetodo, posicionPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Hacer visible el frame
    }

    public static void panelIntegrantes(StringBuilder integrantesGrupo, JPanel losIntegrantes,
            HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad) {
        losIntegrantes.setLayout(new BoxLayout(losIntegrantes, BoxLayout.Y_AXIS));
        String[] integrantes = integrantesGrupo.toString().split(" ");
        String nombreCompleto = "";
        for (String integrante : integrantes) {
            nombreCompleto = integrante;
            if (integrante.contains("_")) {
                integrante = integrante.replace("_", " ");
            }
            for (int iDe : idNombre.keySet()) {
                if (idNombre.get(iDe).equals(nombreCompleto)) {
                    JLabel labelIntegrante = new JLabel(
                            "ID: " + iDe + " Nombre: " + integrante + ", " + idEdad.get(iDe) + " años");
                    labelIntegrante.setHorizontalAlignment(SwingConstants.CENTER);
                    losIntegrantes.add(labelIntegrante);
                }
            }
        }
    }

    public static void anadirInfo_StrBuilder(HashMap<Integer, String> idNombre, ArrayList<Integer> ordenDeLosID,
            StringBuilder grupo, int inicio, int fin) {

        ArrayList<Integer> indicesAEliminar = new ArrayList<>();

        for (int i = inicio; i < fin; i++) {
            int id = ordenDeLosID.get(i);
            String nombre = idNombre.get(id);
            grupo.append(nombre).append(" ");
            indicesAEliminar.add(i);
        }

        for (int i = indicesAEliminar.size() - 1; i >= 0; i--) {
            ordenDeLosID.remove((int) indicesAEliminar.get(i));
        }
    }

    public static void crearGrupos(HashMap<Integer, String> idNombre, HashMap<Integer, Integer> idEdad,
            ArrayList<Integer> ordenDeLosID, JPanel contenidoDinamico) {
        StringBuilder grupo = new StringBuilder();
        int numGrup = 1;

        while (ordenDeLosID.size() >= 3) {
            JPanel panelGrupo = new JPanel();
            panelGrupo.setLayout(new GridBagLayout());
            panelGrupo.setBorder(new EmptyBorder(0, 7, 0, 7));

            GridBagConstraints titulo_integrantes = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                int id = ordenDeLosID.remove(0); // Asignamos el valor a "id" a la vez que lo eliminamos del ArrayList
                String nombre = idNombre.get(id);
                grupo.append(nombre).append(" ");
            }

            JLabel grupoLabel = new JLabel("/ GRUPO " + numGrup + " /\n");
            grupoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel integrantes = new JPanel();
            panelIntegrantes(grupo, integrantes, idNombre, idEdad);

            titulo_integrantes.gridy = 0;
            panelGrupo.add(grupoLabel, titulo_integrantes);

            titulo_integrantes.gridy = 1;
            panelGrupo.add(integrantes, titulo_integrantes);

            contenidoDinamico.add(panelGrupo);

            grupo.setLength(0);
            numGrup += 1;
        }

        if (!ordenDeLosID.isEmpty()) {
            JPanel panelGrupo = new JPanel();
            panelGrupo.setLayout(new GridBagLayout());
            GridBagConstraints titulo_integrantes = new GridBagConstraints();

            while (!ordenDeLosID.isEmpty()) {
                int id = ordenDeLosID.remove(0);
                String nombre = idNombre.get(id);
                grupo.append(nombre).append(" ");
            }

            JLabel grupoLabel = new JLabel("/ GRUPO " + numGrup + " /\n");
            grupoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel integrantes = new JPanel();
            panelIntegrantes(grupo, integrantes, idNombre, idEdad);

            titulo_integrantes.gridy = 0;
            panelGrupo.add(grupoLabel, titulo_integrantes);

            titulo_integrantes.gridy = 1;
            panelGrupo.add(integrantes, titulo_integrantes);

            contenidoDinamico.add(panelGrupo);
        }
    }
}