import java.util.HashMap;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, Integer>> primero = new HashMap<>();
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

        for (int i = 1 ; i <= cant ; i++) {
            HashMap<String, Integer> segundo = new HashMap<>();
            
            JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout para organizar los campos de texto en dos columnas
            
                panel.add(new JLabel("Nombre del alumno: "));
                JTextField nombre = new JTextField(10);
                panel.add(nombre);

                panel.add(new JLabel("Edad del alummno: "));
                JTextField edad = new JTextField(10);
                panel.add(edad);

                int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca información del producto", JOptionPane.OK_CANCEL_OPTION);
                
                if (result == JOptionPane.OK_OPTION) {
                String nombreAlumno = nombre.getText();
                int edadAlumno = Integer.parseInt(edad.getText());
                segundo.put(nombreAlumno, edadAlumno);
                primero.put(i, segundo);
            }
        }

        for (Integer key : primero.keySet()) {
            System.out.println("ID: " + key);
            HashMap<String, Integer> alumno = primero.get(key);
            for (String nombre : alumno.keySet()) {
                int edad = alumno.get(nombre);
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }
        }
    }
}