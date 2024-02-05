import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio01pruebas {
    


    public static void main(String[] args) {
        int val1=8 , val2=5;
		int suma=val1+val2;
		int resta=val1-val2;
		int multi=val1*val2;
		int divi=val1/val2;
		int modulo=val1%val2;
        
		System.out.println("El valor asignado al primer numero es: "+val1);
		System.out.println("El valor asignado al segundo numero es: "+val2);
		
        // Crear un marco (frame) y configurar sus propiedades
        JFrame frame = new JFrame("Operaciones Matemáticas");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear un ComboBox
        String[] opciones = {"Seleccionar", "Sumar", "Restar", "Multiplicar", "Dividir"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un botón
        JButton button = new JButton("Soliucionar");

        // Agregar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la opción seleccionada
                String seleccion = (String) comboBox.getSelectedItem();

                // Realizar una acción basada en la opción seleccionada
                if (seleccion.equals("Sumar")) {
                    JOptionPane.showMessageDialog(frame, val1+" + "+val2+" = "+suma);
                } else {}
                if (seleccion.equals("Restar")) {
                    JOptionPane.showMessageDialog(frame, val1+" - "+val2+" = "+resta);
                } else {}
                if (seleccion.equals("Multiplicar")) {
                    JOptionPane.showMessageDialog(frame, val1+" * "+val2+" = "+multi);
                } else {}
                if (seleccion.equals("Dividir")) {
                    JOptionPane.showMessageDialog(frame, val1+" / "+val2+" = "+divi+" con resto: "+modulo);
                } else {}
            }
        });

        // Agregar componentes al panel
        panel.add(comboBox);
        panel.add(button);

        // Agregar el panel al marco
        frame.add(panel);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}