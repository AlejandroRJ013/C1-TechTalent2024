import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Pruebita {
    public static void main(String[] args) {
        HashMap<String, Integer> nombreID = new HashMap<>();
        HashMap<String, Integer> nombreEdad = new HashMap<>();
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));

        // segundo.put("Jose", 26);
        // segundo.put("Isabel", 18);
        // segundo.put("Joel", 19);
        // segundo.put("Sebas", 29);
        // segundo.put("Abdellah", 19);
        // segundo.put("Antonio", 23);
        // segundo.put("Diego", 23);
        // segundo.put("Manel", 26);
        // segundo.put("Jessica", 23);
        // segundo.put("Santos", 23);
        // segundo.put("Alex", 23);
        // segundo.put("Ana María", 23);
        // segundo.put("Aurora", 23);
        // segundo.put("Laia", 23);
        // segundo.put("Alejandro", 19);

        for (int i = 1; i <= cant; i++) {
            JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout para organizar los campos de texto en dos
                                                             // columnas
            panel.add(new JLabel("Nombre del alumno: "));
            JTextField nombre = new JTextField(10);
            panel.add(nombre);

            panel.add(new JLabel("Edad del alummno: "));
            JTextField edad = new JTextField(10);
            panel.add(edad);

            int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca información del producto",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String nombreAlumno = nombre.getText();
                int edadAlumno = Integer.parseInt(edad.getText());
                nombreID.put(nombreAlumno, i);
                nombreEdad.put(nombreAlumno, edadAlumno);
            }
        }



        for (String nombre : nombreID.keySet()) {
            System.out.println("Nombre: " + nombre);
            System.out.println(" - ID: " + nombreID.get(nombre)+"\n - Edad: "+nombreEdad.get(nombre));
            
        }
    }
}