import java.util.Arrays;

import javax.swing.JOptionPane;

public class T6Extra06 {
    public static void main(String[] args) {
        StringBuilder suma = new StringBuilder("");
        int numalumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos a evaluar"));
        double[] notas = new double[numalumnos];
        Arrays.fill(notas, 5);
        ponernotas(notas);
        promedio(suma, numalumnos, notas);
    }

    public static void ponernotas(double notas[]) {
        int cont = 0;
        for (int i = 0; i < notas.length; i++) {
            cont++;
            String notatxt = JOptionPane.showInputDialog("Valore al alumno: ");
            if (notatxt.equals("")) {
                JOptionPane.showMessageDialog(null, "Al alumno en la posición " + cont
                        + " no se le ha asignado una nota, de forma automatica hemos asignado un <5>");
            } else {
                notas[i] = Double.parseDouble(notatxt);
            }
        }
    }

    public static void promedio(StringBuilder suma, int numalumnos, double notas[]) {
        double sumadenotas = 0;
        for (int i = 0; i < notas.length; i++) {
            sumadenotas += notas[i];
            if (i == (notas.length - 1)) {
                suma.append(notas[i] + " = " + sumadenotas);
            } else {
                suma.append(notas[i] + " + ");
            }
        }
        double resultado = (sumadenotas / numalumnos);
        int resulredondeado = (int) Math.round(resultado);
        JOptionPane.showMessageDialog(null,
                "El promedio de notas de los alumnos es:\n" + suma + "/" + numalumnos + " = " + resulredondeado + " ("
                        + resultado + ")");
    }
}
