import javax.swing.JOptionPane;

public class T6Extra07 {
    public static void main(String[] args) {
        int array[] = {5, 8, 10, 6, 25, 2, 7};
        StringBuilder mostrar = new StringBuilder("");
        boolean estaelnum = false;
        String buscar = JOptionPane.showInputDialog("Ingrese un número para buscar en el array");

        if (!esta(estaelnum, array, buscar, mostrar)) {
            JOptionPane.showMessageDialog(null, "El número buscado <"+buscar+"> no que aparece en la lista"+mostrar);
        } else {
            JOptionPane.showMessageDialog(null, "El número buscado <"+buscar+"> sí que aparece en la lista"+mostrar);
        }
    }

    public static boolean esta(boolean estaelnum, int array[], String buscar, StringBuilder mostrar) {
        int intbuscar = Integer.parseInt(buscar);
        mostrar.append(" - - Números del array - - \n");
        for (int valor : array) {
            mostrar.append(valor);
            if (valor == intbuscar) {
                mostrar.append("[ "+ valor +"]");
                estaelnum = true;
            }
        }
    }
}