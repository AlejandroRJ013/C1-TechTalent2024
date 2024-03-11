import java.util.HashMap;

import javax.swing.JOptionPane;

public class PruebaHash {
    public static void main(String[] args) {
        HashMap<String, Integer> edadesAlumnos = new HashMap<>();
        edadesAlumnos.put("Juan", 25);
        edadesAlumnos.put("Pedro", 28);
        edadesAlumnos.put("María", 30);
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno a añadir:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno anterior:"));

        for (String name : edadesAlumnos.keySet()) {
            System.out.print("El alumno "+name);
            for (int age : edadesAlumnos.values()) {
                System.out.print("Tiene "+age+" años\n");
            }    
        }

        ingresarAlumno(edadesAlumnos, nombre, edad);
    }

    public static void ingresarAlumno(HashMap<String, Integer> edadesAlumnos, String nombre, int edad) {
        edadesAlumnos.put(nombre, edad);
    }
}
