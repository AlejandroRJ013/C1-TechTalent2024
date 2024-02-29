import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio02 {
    public static void main(String[] args) {
        // Crear un frame para ir añadiendo paneles, establezco un tamaño mediano
        JFrame frame = new JFrame("Carrito de la compra");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear un ComboBox
        String[] opciones = { "Seleccionar", "Elementos de la cesta" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un botón
        JButton button = new JButton("Comprar");
        JButton anadirComboBox = new JButton("Más articulos?");

        // Crear una casilla
        JCheckBox casilla = new JCheckBox();

        // Poner texto e imágen con JLabel
        Icon icono = new ImageIcon("C:\\Users\\aleja\\OneDrive\\Imágenes\\Simba.jpg");
        JLabel label = new JLabel("Hola neno\n");
        label.setIcon(icono);

        // Agregar componentes al panel
        panel.add(comboBox);
        panel.add(button);
        panel.add(casilla);

        // Agregar el panel al marco
        frame.add(panel);

        // Hacer que los botones hagan cosas (Mostrar texto y foto; y agregar articulos)
        anadirComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setSize(500, 500);
                panel.add(label);
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
