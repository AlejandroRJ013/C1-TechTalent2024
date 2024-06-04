import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ejercicio9Grupal extends JFrame {
    private JButton[] buttons = new JButton[16];
    private Color[] color = new Color[16];
    private ArrayList<Color> colors = new ArrayList<>();
    private JButton firstButton = null;
    private JButton secondButton = null;
    private Color firstColor;
    private Color secondColor;

    public ejercicio9Grupal() {
        // Configuración de la ventana
        setTitle("Memorama de Colores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 4)); // 4x4 GridLayout

        // Inicializar colores de los botones
        colors.addAll(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.CYAN,
                Color.MAGENTA, Color.PINK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.CYAN,
                Color.MAGENTA, Color.PINK));
        Collections.shuffle(colors);

        // Crear y añadir botones
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY);
            color[i] = colors.get(i);
            buttons[i].addActionListener(new ButtonClickListener());
            add(buttons[i]);
        }
    }

    public static int indiceBoton(JButton[] buttons, JButton boton) {
        int i = 0;
        for (i = 0; i <= buttons.length; i++) {
            JButton bot = buttons[i];
            if (boton == bot) {
                break;
            }
        }
        return i;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int indice = ejercicio9Grupal.indiceBoton(buttons, clickedButton);
            if (clickedButton.getBackground().equals(Color.GRAY) && firstButton != clickedButton) {
                clickedButton.setBackground(color[indice]);
                if (firstButton == null) {
                    firstButton = clickedButton;
                    firstColor = color[indice];
                } else {
                    secondButton = clickedButton;
                    secondColor = color[indice];

                    if (firstColor.equals(secondColor)) {
                        firstButton.setEnabled(false);
                        secondButton.setEnabled(false);
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            System.out.println("El hilo fue interrumpido.");
                        }
                        firstButton.setBackground(Color.GRAY);
                        secondButton.setBackground(Color.GRAY);
                    }
                    firstButton = null;
                    secondButton = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ejercicio9Grupal().setVisible(true);
            }
        });
    }
}