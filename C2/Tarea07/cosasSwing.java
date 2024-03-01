import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cosasSwing {
    public static void main(String[] args) {
        // Crear un frame para ir añadiendo paneles, establezco un tamaño mediano
        JFrame frame = new JFrame("Ventana");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear un ComboBox
        String[] opciones = { "Seleccionar", "Elementos", "Elementos" , "Elementos" , "Elementos" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un botón
        JButton button = new JButton("Accion");
        JButton anadirComboBox = new JButton("Más articulos?");

        // Crear una casilla
        JLabel label = new JLabel("ID");
        JCheckBox casilla = new JCheckBox();

        JLabel abel = new JLabel("Nobre");
        JCheckBox casill = new JCheckBox();

        JLabel bel = new JLabel("Edades");
        JCheckBox casil = new JCheckBox();

        // Poner texto e imágen con JLabel
        // Icon icono = new ImageIcon("C:\\Users\\aleja\\OneDrive\\Imágenes\\Simba.jpg");
        // JLabel label = new JLabel("Hola neno\n");
        // label.setIcon(icono);

        // Agregar componentes al panel
        panel.add(comboBox);
        panel.add(button);
        panel.add(label);
        panel.add(casilla);
        panel.add(abel);
        panel.add(casill);
        panel.add(bel);
        panel.add(casil);

        // Agregar el panel al marco
        frame.add(panel);
        

        // Hacer que los botones hagan cosas (Mostrar texto y foto; y agregar articulos) [NO FUNCIONA]
        anadirComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel masCompra = new JPanel();
                masCompra.add(label);
                frame.add(masCompra);
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }
}