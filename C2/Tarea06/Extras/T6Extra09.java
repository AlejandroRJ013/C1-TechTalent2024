import java.util.ArrayList;

import javax.swing.JOptionPane;

public class T6Extra09 {
    public static void main(String[] args) {
        StringBuilder repetidos = new StringBuilder();
        ArrayList<Integer> numeros = new ArrayList<>();
        int array[] = { 5, 8, 7, 10, 5, 10, 6, 25, 2, 25, 6, 7 };
        rellenarArrayList(repetidos, numeros, array);
        eliminaRepes(numeros);
        JOptionPane.showMessageDialog(null, "Pirmer array con numeros repetidos:\n" + repetidos
                + "\n\nNueva array sin números repetidos:\n" + numeros);
    }

    public static void rellenarArrayList(StringBuilder repetidos, ArrayList<Integer> numeros, int array[]) {
        for (int i = 0; i < array.length; i++) {
            numeros.add(array[i]);
            if (i == 0) {
                repetidos.append("[" + array[i] + ", ");
            } else if (i < (array.length - 1)) {
                repetidos.append(array[i] + ", ");
            } else {
                repetidos.append(array[i] + "]");
            }
        }
    }

    public static void eliminaRepes(ArrayList<Integer> numeros) {
        for (int i = 0; i < numeros.size(); i++) {
            for (int indice = (i + 1); indice < numeros.size(); indice++) {
                if (numeros.get(i) == numeros.get(indice)) {
                    numeros.remove(indice);
                }
            }
        }
    }
}
