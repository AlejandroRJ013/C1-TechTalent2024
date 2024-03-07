import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cosasSwing {
    public static void main(String[] args) {
        // Crear un frame para ir añadiendo paneles, establezco un tamaño mediano
        JFrame frame = new JFrame("Ventana");
        frame.setSize(300, 150); // Tamaño
        frame.setLocationRelativeTo(null); // Posición inicial al medio de la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana cierra el programa

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear un ComboBox
        String[] opciones = { "Seleccionar", "Elementos", "Elementos", "Elementos", "Elementos" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un botón
        JButton button = new JButton("Accion");
        // JButton anadirComboBox = new JButton("Más articulos?");

        // Crear una casilla
        JLabel label = new JLabel("ID");
        JCheckBox casilla = new JCheckBox();

      

        // Poner texto e imágen con JLabel
        // Icon icono = new
        // ImageIcon("C:\\Users\\aleja\\OneDrive\\Imágenes\\Simba.jpg");
        // JLabel label = new JLabel("Hola neno\n");
        // label.setIcon(icono);

        // Agregar componentes al panel
        panel.add(comboBox);
        panel.add(button);
        panel.add(label);
        panel.add(casilla);

        // Agregar el panel al marco
        frame.add(panel);

        // Hacer que los botones hagan cosas (Mostrar texto y foto; y agregar articulos)
        // [NO FUNCIONA]
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