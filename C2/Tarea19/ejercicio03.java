import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ejercicio03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Encuesta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JPanel encuestaLabelPanel = new JPanel();
        encuestaLabelPanel.setBackground(Color.DARK_GRAY);
        JLabel encuestaLabel = new JLabel("Encuesta");
        encuestaLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        encuestaLabel.setForeground(Color.LIGHT_GRAY);
        encuestaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        encuestaLabelPanel.add(encuestaLabel);
        panelPrincipal.add(encuestaLabelPanel);

        JPanel panelSO = sistemasOperativos();
        panelPrincipal.add(panelSO);

        frame.add(panelPrincipal);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        boolean parar = true;
        while (parar) {
            for (Component paneles : panelSO.getComponents()) {
                if (paneles instanceof JPanel) {
                    JPanel panelBoton = (JPanel) paneles;
                    for (Component boton : panelBoton.getComponents()) {
                        if (boton instanceof JRadioButton) {
                            JRadioButton radBut = (JRadioButton) boton;
                            if (radBut.isSelected()) {
                                parar = false;
                            }
                        }
                    }
                }
            }
        }
        
        JPanel panelEsp = especialidad();
        panelPrincipal.add(panelEsp);

        frame.revalidate();
        frame.repaint();

        frame.add(panelPrincipal);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setVisible(true);
        
        JPanel panelMostrar = new JPanel();
        panelMostrar.setBackground(Color.LIGHT_GRAY);
        panelMostrar.setBorder(new LineBorder(null, 5, true));
        JButton mostrar = new JButton("Mostrar");
        mostrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        mostrar.setBackground(Color.GRAY);
        mostrar.setForeground(Color.LIGHT_GRAY);
        mostrar.setBorder(new LineBorder(Color.BLACK, 2, true));
        mostrar.setBorderPainted(true);
        mostrar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        panelMostrar.add(mostrar);
        
        boolean dejameSalir = true;
        while (dejameSalir) {
            for (Component paneles : panelEsp.getComponents()) {
                if (paneles instanceof JPanel) {
                    JPanel panelCheck = (JPanel) paneles;
                    for (Component checks : panelCheck.getComponents()) {
                        if (checks instanceof JCheckBox) {
                            JCheckBox check = (JCheckBox) checks;
                            if (check.isSelected()) {
                                // Generar el siguiente panel al seleccionar una opción
                                dejameSalir = false;
                            }
                        }
                    }
                }
            }
        }
        JPanel panelHoras = horasDedicadas(frame, panelPrincipal);
        panelPrincipal.add(panelHoras);

        frame.revalidate();
        frame.repaint();

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sisOp = obtenerSO(panelSO);
                String especialidades = obtenerEspecialidades(panelEsp);
                String horas = obtenerHoras(panelHoras);
                
                panelMensaje(frame, panelPrincipal, sisOp, especialidades, horas);
            }
        });
        panelPrincipal.add(panelMostrar);
        frame.add(panelPrincipal);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static String obtenerSO(JPanel panelSO) {
        String sis = "";
        for (Component paneles : panelSO.getComponents()) {
            if (paneles instanceof JPanel) {
                JPanel panelBoton = (JPanel) paneles;
                for (Component boton : panelBoton.getComponents()) {
                    if (boton instanceof JRadioButton) {
                        JRadioButton radBut = (JRadioButton) boton;
                        if (radBut.isSelected()) {
                            sis = radBut.getText();
                        }
                    }
                }
            }
        }
        return sis;
    }

    public static String obtenerEspecialidades(JPanel panelEsp) {
        StringBuilder especialidades = new StringBuilder();

        for (Component paneles : panelEsp.getComponents()) {
            if (paneles instanceof JPanel) {
                JPanel panelCheck = (JPanel) paneles;
                for (Component checks : panelCheck.getComponents()) {
                    if (checks instanceof JCheckBox) {
                        JCheckBox check = (JCheckBox) checks;
                        if (check.isSelected()) {
                            especialidades.append(check.getText() + ", ");
                        }
                    }
                }
            }
        }

        especialidades.setLength(especialidades.length()-2);

        return especialidades.toString();
    }

    public static String obtenerHoras(JPanel panelHoras) {
        String horas = "";
        for (Component paneles : panelHoras.getComponents()) {
            if (paneles instanceof JPanel) {
                JPanel panelSlider = (JPanel) paneles;
                for (Component slider : panelSlider.getComponents()) {
                    if (slider instanceof JSlider) {
                        horas = String.valueOf(((JSlider)slider).getValue());
                    }
                }
            }
        }
        return horas;
    }

    public static JPanel sistemasOperativos() {
        JPanel panelSO = new JPanel();
        panelSO.setLayout(new BoxLayout(panelSO, BoxLayout.Y_AXIS));
        JPanel labelP = new JPanel();
        labelP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelP.setBackground(Color.LIGHT_GRAY);
        labelP.setBorder(new LineBorder(null, 5, true));
        JLabel labelSO = new JLabel("¿Cuál es tu sistema operativo preferido?");
        labelSO.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        JPanel radioBP = new JPanel();
        radioBP.setAlignmentX(Component.CENTER_ALIGNMENT);
        JRadioButton win = new JRadioButton("Windows", false);
        JRadioButton lin = new JRadioButton("Linux", false);
        JRadioButton mac = new JRadioButton("Mac", false);

        ButtonGroup botones = new ButtonGroup();
        botones.add(win);
        botones.add(lin);
        botones.add(mac);

        labelP.add(labelSO);
        panelSO.add(labelP);
        radioBP.add(win);
        radioBP.add(lin);
        radioBP.add(mac);
        panelSO.add(radioBP);

        return panelSO;
    }

    public static JPanel especialidad() {
        JPanel panelEspecialidad = new JPanel();
        panelEspecialidad.setLayout(new BoxLayout(panelEspecialidad, BoxLayout.Y_AXIS));
        JPanel labelP = new  JPanel();
        labelP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelP.setBackground(Color.LIGHT_GRAY);
        labelP.setBorder(new LineBorder(null, 5, true));
        JLabel labelEspecialidad = new JLabel("¿Cuál es tu especialidad?");
        labelEspecialidad.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        JPanel checkBP = new JPanel();
        checkBP.setAlignmentX(Component.CENTER_ALIGNMENT);
        JCheckBox dev = new JCheckBox("Programación");
        JCheckBox GraDes = new JCheckBox("Diseño Gráfico");
        JCheckBox man = new JCheckBox("Administración");

        labelP.add(labelEspecialidad);
        panelEspecialidad.add(labelP);
        checkBP.add(dev);
        checkBP.add(GraDes);
        checkBP.add(man);
        panelEspecialidad.add(checkBP);

        return panelEspecialidad;
    }

    public static JPanel horasDedicadas(JFrame frame, JPanel panelPrincipal) {
        JPanel panelHoras = new JPanel();
        panelHoras.setLayout(new BoxLayout(panelHoras, BoxLayout.Y_AXIS));
        JPanel labelP = new JPanel();
        labelP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelP.setBackground(Color.LIGHT_GRAY);
        labelP.setBorder(new LineBorder(null, 5, true));

        JLabel labelHoras = new JLabel("¿Cuántas horas dedicas al ordenador?");
        labelHoras.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        JPanel sliderP = new JPanel();
        sliderP.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider horas = new JSlider(0, 10);
        horas.setPreferredSize(new Dimension(panelPrincipal.getWidth()-30, 25));
        JPanel labelCanHorP = new JPanel();
        labelCanHorP.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel labelCantHoras = new JLabel("Horas: " + horas.getValue());
        labelCantHoras.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        labelCanHorP.add(labelCantHoras);
        horas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelCanHorP.removeAll();

                JLabel labelCantHoras = new JLabel("Horas: " + horas.getValue());
                labelCantHoras.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
                labelCanHorP.add(labelCantHoras);
                
                labelCanHorP.repaint();
                labelCanHorP.revalidate();

                frame.pack();
            }
        });
        
        labelP.add(labelHoras);
        panelHoras.add(labelP);
        sliderP.add(horas);
        panelHoras.add(sliderP);
        panelHoras.add(labelCanHorP);

        return panelHoras;
    }

    public static void panelMensaje(JFrame frame, JPanel panelPrincipal, String sisOp, String especialzacion, String horas) {
        JDialog dialogo = new JDialog(frame, "Mensaje", true);
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panelMensaje = new JPanel();
        panelMensaje.setLayout(new GridLayout(6, 0));
        panelMensaje.setSize(300, 300);
        panelMensaje.setBackground(Color.DARK_GRAY);

        JPanel labelSOP = new JPanel();
        labelSOP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSOP.setBackground(Color.LIGHT_GRAY);
        JLabel so = new JLabel("Sistema Operativo");
        so.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        labelSOP.add(so);

        JPanel labelRespuestaSO = new JPanel();
        labelRespuestaSO.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRespuestaSO.setBackground(Color.WHITE);
        JLabel respOS = new JLabel(sisOp);
        respOS.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        labelRespuestaSO.add(respOS);

        JPanel labelEspP = new JPanel();
        labelEspP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEspP.setBackground(Color.LIGHT_GRAY);
        JLabel esp = new JLabel("Especialidades");
        esp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        labelEspP.add(esp);
        
        JPanel labelRespuestaEsp = new JPanel();
        labelRespuestaEsp.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRespuestaEsp.setBackground(Color.WHITE);
        JLabel respEsp = new JLabel(especialzacion);
        respEsp.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        labelRespuestaEsp.add(respEsp);

        JPanel labelHorP = new JPanel();
        labelHorP.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelHorP.setBackground(Color.LIGHT_GRAY);
        JLabel hor = new JLabel("Horas");
        hor.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        labelHorP.add(hor);

        JPanel labelRespuestaHor = new JPanel();
        labelRespuestaHor.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRespuestaHor.setBackground(Color.WHITE);
        JLabel respHor = new JLabel(horas);
        respHor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        labelRespuestaHor.add(respHor);

        panelMensaje.add(labelSOP);
        panelMensaje.add(labelRespuestaSO);
        panelMensaje.add(labelEspP);
        panelMensaje.add(labelRespuestaEsp);
        panelMensaje.add(labelHorP);
        panelMensaje.add(labelRespuestaHor);

        panelMensaje.setBorder(new EmptyBorder(10, 10, 10, 10));

        dialogo.add(panelMensaje);
        dialogo.pack();
        dialogo.setLocationRelativeTo(frame);
        dialogo.setVisible(true);
    }
}