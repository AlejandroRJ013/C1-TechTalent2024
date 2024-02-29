import java.util.HashMap;

import javax.swing.JOptionPane;

public class Ejercicio01 {
    public static void main(String[] args) {
        HashMap<String, Integer> alum_notas = new HashMap<>();
        StringBuilder nombres_media = new StringBuilder(" - - NOTAS MEDIAS DE LOS ALUMNOS - - \n\n");
        int cantAlumnos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos alumnos hay que evaluar?"));
        int cantNotas = Integer.parseInt(JOptionPane.showInputDialog("Y cuantas notas tienen cada uno?"));

        nombrarAlumnoyCadena(alum_notas, nombres_media, cantAlumnos, cantNotas);
        
        JOptionPane.showMessageDialog(null, nombres_media.toString()); //Con un método para varios StringBuilder para mostrar.
    }

    // Calcular nota media de un alumno
    public static int notaMedia(int cantNotas) {
        int notasSumadas = 0;
        for (int i = 0; i < cantNotas; i++) {
            int nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una nota para el alumno"));
            while (!numValido(nota)) {
                nota = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, ingrese una nota entre 0 y 10"));
            }
            notasSumadas += nota;
        }
        return notasSumadas / cantNotas;
    }

    // Poner nombre al alumno y asignar al HashMap
    public static void nombrarAlumnoyCadena(HashMap<String, Integer> alum_notas, StringBuilder nombres_media,
            int cantAlumnos, int cantNotas) {
        int media = 0;
        for (int i = 0; i < cantAlumnos; i++) {
            String nombre = JOptionPane.showInputDialog("¿Como se llama el alumno a evaluar?");
            media = notaMedia(cantNotas);
            alum_notas.put(nombre, media);
            nombres_media.append(" - " + nombre + " ==> " + alum_notas.get(nombre) + "\n");
        }
    }

    // Controlar la nota, números positivos y máximo 10
    public static boolean numValido(int nota) {
        if (nota < 0) {
            return false;
        } else if (nota > 10) {
            return false;
        } else {
            return true;
        }
    }
}