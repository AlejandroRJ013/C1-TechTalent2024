package proyecto.memory.ventana;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ventana extends JFrame {
    private int[] botonesActivos = new int[1];
    private JToggleButton[] botones = new JToggleButton[16];
    private Color[] coloresBoton = new Color[16];
    private ArrayList<Color> colores = new ArrayList<>(Arrays.asList(Color.decode("#FF0000"), Color.decode("#FF0000"),
            Color.decode("#00FF00"), Color.decode("#00FF00"), Color.decode("#0000FF"), Color.decode("#0000FF"),
            Color.decode("#FFFF00"), Color.decode("#FFFF00"), Color.decode("#00FFFF"), Color.decode("#00FFFF"),
            Color.decode("#FF00FF"), Color.decode("#FF00FF"), Color.decode("#FFA500"), Color.decode("#FFA500"),
            Color.decode("#800080"), Color.decode("#800080")));

    private static JPanel panelBotones = new JPanel();
    private JLabel titulo = new JLabel("M E M O R Y");
    private JToggleButton switchActivo1 = null;
    private JToggleButton switchActivo2 = null;

    public Ventana() {
        botonesActivos[0] = 0;
        setTitle("Construcciones Abdellah - Construye memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();

        titulo.setFont(new Font(Font.SERIF, Font.BOLD, 30));

        pos.insets = new Insets(10, 15, 5, 15);
        pos.gridx = 0;
        pos.gridy = 0;
        add(titulo, pos);

        panelBotones.setLayout(new GridLayout(4, 4));

        Collections.shuffle(colores);

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JToggleButton();
            parametrosBoton(botones[i]);
            coloresBoton[i] = botones[i].getBackground();
            botones[i].setSelected(true);
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    botonesActivos[0]++;
                    actualizarBotones((JToggleButton) e.getSource(), botonesActivos[0]);
                }
            });
            panelBotones.add(botones[i]);
        }

        pos.insets = new Insets(2, 15, 10, 15);
        pos.gridy = 1;
        add(panelBotones, pos);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void parametrosBoton(JToggleButton interruptor) {
        Random randi = new Random();
        int indice = randi.nextInt(colores.size());
        interruptor.setPreferredSize(new Dimension(100, 100));
        interruptor.setBackground(colores.get(indice));
        colores.remove(indice);
    }

    public void actualizarBotones(JToggleButton boton, int botonesActivos) {
        if (switchActivo1 == null) {
            switchActivo1 = boton;
            return;
        } else if (switchActivo2 == null && boton != switchActivo1) {
            switchActivo2 = boton;
            if (switchActivo1.getBackground().equals(switchActivo2.getBackground())) {
                JOptionPane.showMessageDialog(null, "Enhorabuena");
                switchActivo1.setEnabled(false);
                switchActivo2.setEnabled(false);
                resetActiveButtons();
            } else {
                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switchActivo1.setSelected(true);
                        switchActivo2.setSelected(true);
                        resetActiveButtons();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void resetActiveButtons() {
        switchActivo1 = null;
        switchActivo2 = null;
    }
}
