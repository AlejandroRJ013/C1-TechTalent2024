import java.util.Arrays;

import javax.swing.JOptionPane;

public class T6Extra08 {
    public static void main(String[] args) {
        StringBuilder arrayInicial = new StringBuilder();
        StringBuilder arrayOrdenado = new StringBuilder();

        int array[] = { 5, 8, 10, 6, 25, 2, 7 };
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                arrayInicial.append(array[i]);
            } else {
                arrayInicial.append(array[i] + ", ");
            }
        }
        Arrays.sort(array);
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                arrayOrdenado.append(array[i]);
            } else {
                arrayOrdenado.append(array[i] + ", ");
            }
        }
        JOptionPane.showMessageDialog(null, "Array inicial: " + arrayInicial + "\nArray ordenado: " + arrayOrdenado);
    }
}