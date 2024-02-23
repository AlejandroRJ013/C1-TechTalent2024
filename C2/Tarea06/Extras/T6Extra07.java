import javax.swing.JOptionPane;

public class T6Extra07 {
    public static void main(String[] args) {
        int array[] = { 5, 8, 10, 6, 25, 2, 7 };
        StringBuilder mostrar = new StringBuilder("\n\n");
        boolean estaelnum = false;
        String buscar = JOptionPane.showInputDialog("Ingrese un número para buscar en el array");
        int intbuscar = Integer.parseInt(buscar);

        encadenar(estaelnum, array, intbuscar, mostrar);

        if (esta(array, intbuscar)) {
            JOptionPane.showMessageDialog(null,
                    "El número buscado <" + buscar + "> sí que aparece en la lista" + mostrar);
        } else {
            JOptionPane.showMessageDialog(null, "El número buscado <" + buscar + "> no aparece en la lista" + mostrar);
        }
    }

    public static void encadenar(boolean estaelnum, int array[], int intbuscar, StringBuilder mostrar) {
        mostrar.append(" - - Números del array - - \n");
        for (int i = 0; i < 7; i++) {/*
                                      * (i < 7) es lo mismo que (i < array.length) pero como se la longitud la pongo
                                      */
            if (array[i] == intbuscar) {
                mostrar.append(" [ " + array[i] + " ],");
            } else if (i == 6) {
                mostrar.append(" " + array[i]);
            } else {
                mostrar.append(" " + array[i] + ",");
            }
        }
    }

    public static boolean esta(int array[], int intbuscar) {
        for (int i = 0; i < 7; i++) {
            if (array[i] == intbuscar) {
                return true;
            }
        }
        return false;
    }
}