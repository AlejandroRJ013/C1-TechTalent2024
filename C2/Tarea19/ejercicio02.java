import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ejercicio02 {
    public static void main(String[] args) {
        ArrayList<String> peliculas = new ArrayList<>(Arrays.asList("Barbie", "El robo: Juan Carlos", "Artistas con techo de hormigón"));
        JPanel panelPelis = new JPanel();

        JFrame frame = new JFrame();
        frame.setTitle("Añade peliculas");
        frame.setMinimumSize(new Dimension(325, 0));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titulAnadir = new JPanel();
        titulAnadir.setBackground(Color.GRAY);
        JLabel labelAnadir = new JLabel("Añade una película:");
        labelAnadir.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAnadir.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        titulAnadir.add(labelAnadir);
        panel.add(titulAnadir);

        Image imagen = new ImageIcon("imagenes/agregar-pelicula-resplandor.png").getImage();
        imagen = imagen.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon agregar = new ImageIcon(imagen);

        JPanel panelEntrada = new JPanel();
        panelEntrada.setBackground(Color.LIGHT_GRAY);
        JTextField peliculaEntrada = new JTextField("Avatar 2", 20);
        peliculaEntrada.setForeground(Color.GRAY);
        peliculaEntrada.setAlignmentX(Component.CENTER_ALIGNMENT);
        peliculaEntrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (peliculaEntrada.getText().equals("Avatar 2")) {
                    peliculaEntrada.setText("");
                    peliculaEntrada.setForeground(Color.BLACK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (peliculaEntrada.getText().isEmpty()) {
                    peliculaEntrada.setText("Avatar 2");
                    peliculaEntrada.setForeground(Color.GRAY);
                }
            }
    
        });
        panelEntrada.add(peliculaEntrada);
        panel.add(panelEntrada);

        JPanel separador = new JPanel();
        separador.setBackground(Color.DARK_GRAY);
        JButton boton = new JButton(agregar);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peli = peliculaEntrada.getText();
                if (!peliculas.contains(peli)) {
                    peliculas.add(peli);
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            generarInferior(panelPelis, peliculas);
                        }
                    });
                }
            }
        });
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        separador.add(boton);

        panel.add(separador);

        panelPelis.setBackground(Color.LIGHT_GRAY);
        panelPelis.removeAll();
        panelPelis.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] peliculasArray = peliculas.toArray(new String[peliculas.size()]);
        JComboBox<String> peliculasCombo = new JComboBox<String>(peliculasArray);
        panelPelis.add(peliculasCombo);

        panel.add(panelPelis);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    public static void generarInferior(JPanel panelPelis, ArrayList<String> peliculas) {
        for (Component component : panelPelis.getComponents()) {
            if (component instanceof JComboBox) {
                panelPelis.remove(component);
                break;
            }
        }    

        panelPelis.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] peliculasArray = peliculas.toArray(new String[peliculas.size()]);
        JComboBox<String> peliculasCombo = new JComboBox<String>(peliculasArray);
        panelPelis.add(peliculasCombo);
        panelPelis.repaint();
        panelPelis.revalidate();
    }
}