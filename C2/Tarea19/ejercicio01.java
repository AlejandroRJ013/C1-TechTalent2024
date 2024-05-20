import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class ejercicio01 {
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JPanel panelTexto = new JPanel();
    panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));

    JLabel PP = new JLabel("Bienvenido a Políticos Pudorosos");
    JLabel cualNombre = new JLabel("¿Comó te llamas?");

    PP.setAlignmentX(Component.CENTER_ALIGNMENT);
    PP.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));

    cualNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
    cualNombre.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

    panelTexto.add(PP);
    panelTexto.add(cualNombre);
    panel.add(panelTexto);

    JPanel panelTextField = new JPanel();

    JTextField nombreUsuario = new JTextField("Perro Sánchez Kahbron", 20);
    nombreUsuario.setForeground(Color.GRAY);
    nombreUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
    nombreUsuario.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            if (nombreUsuario.getText().equals("Perro Sánchez Kahbron")) {
                nombreUsuario.setText("");
                nombreUsuario.setForeground(Color.BLACK);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (nombreUsuario.getText().isEmpty()) {
                nombreUsuario.setText("Perro Sánchez Kahbron");
                nombreUsuario.setForeground(Color.GRAY);
            }
        }
    });

    JButton saludar = new JButton("¡Saludame!");
    saludar.setAlignmentX(Component.CENTER_ALIGNMENT);
    saludar.setSize(30, 120);
    saludar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Image perro = new ImageIcon("imagenes/perroSanche.png").getImage();
            perro = perro.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon perroSanche = new ImageIcon(perro);

            JPanel panelSaludo = new JPanel();
            panelSaludo.setLayout(new BoxLayout(panelSaludo, BoxLayout.Y_AXIS));
            JLabel bienvenido = new JLabel("Bienvenido");
            JLabel nombre = new JLabel(nombreUsuario.getText());
            JLabel imagen = new JLabel(perroSanche);
            bienvenido.setAlignmentX(Component.CENTER_ALIGNMENT);
            nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagen.setAlignmentX(Component.CENTER_ALIGNMENT);
            bienvenido.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
            nombre.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));

            panelSaludo.add(bienvenido);
            panelSaludo.add(nombre);
            panelSaludo.add(imagen);

            JOptionPane.showOptionDialog(null, new JScrollPane(panelSaludo), "Saludo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        }
    });

    panelTextField.add(nombreUsuario);
    panel.add(panelTextField);
    panel.add(saludar);

    panel.setBorder(new EmptyBorder(5, 5, 5, 5));

    frame.add(panel);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    frame.setFocusable(true);
    frame.requestFocusInWindow();
    }
}