package memoryproyect.ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ventana extends JFrame {
    private int parejasAcertadas = 0;
    private JLabel titulo = new JLabel("M E M O R Y");
    private Color[] posicionColor = new Color[16];
    private JLabel conteoParejas = new JLabel(String.format("Llevas %d / 8", parejasAcertadas));
    private static JPanel panelBotones = new JPanel();

    public Ventana() {
        HashMap<Color, Integer> colorCantidad = new HashMap<>();
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
                Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK));
        for (Color colo : colors) {
            colorCantidad.put(colo, 2);
        }

        setTitle("Construcciones Abdellah - Construye memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = 0;
        pos.gridy = 0;

        titulo.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        add(titulo, pos);

        pos.gridy = 1;
        conteoParejas.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        add(conteoParejas, pos);

        pos.gridy = 2;
        panelBotones.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            JToggleButton boton = new JToggleButton();
            Random alea = new Random();
            int numAlea = alea.nextInt(colors.size());
            Color colorAhora = colors.get(numAlea);

            for (Color col : colorCantidad.keySet()) {
                if (col.equals(colorAhora)) {
                    int cantidad = colorCantidad.get(col);
                    if (cantidad > 0) {
                        posicionColor[i] = colorAhora;
                        boton.setBackground(colorAhora);
                        colorCantidad.put(col, cantidad - 1);
                        break;
                    }
                }
            }

            boton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    int posicionBoton = e.getID();
                    if (boton.isSelected()) {
                        // boton.setBackground(posicionColor[]);
                    } else {
                        boton.setBackground(Color.LIGHT_GRAY);
                    }
                }
            });
        }
    }

    public static void main(String args[]) {
        new Ventana();
    }
}