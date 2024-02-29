import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ejercicio01 {
    public static void main(String[] args) {
        int cantalumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos a evaluar:"));
        int numnotas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas notas tienen los alumnos?"));
        StringBuilder concatenado = new StringBuilder("");
        HashMap<String, Integer> cursoprogramacion = new HashMap<>();
        for (int i = 0; i<cantalumnos; i++) {
            String alumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
            cursoprogramacion.put(alumno, notamedia(numnotas, alumno));
            concatenado.append("La nota media de "+ alumno + " es: " + notamedia(numnotas, alumno)+ "\n");
        }
        JOptionPane.showMessageDialog(null, concatenado.toString());
    }

    public static int notamedia(int numnotas, String alumno) {
        ArrayList<Integer> nota = new ArrayList<>();
        for (int i = 0; i<2; i++) {
            int cualificacio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una nota del alumno "+alumno+":"));
            nota.add(cualificacio);
        }

        Iterator<Integer> it = nota.iterator();
        int num = 0;
		while (it.hasNext()) {
			num += it.next();
		}
        
        return num/numnotas;
    }
}
