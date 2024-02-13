import javax.swing.JOptionPane;

public class EjerExtra4 {
    public static void main(String[] args) {

        String numIng = JOptionPane.showInputDialog(null, "Ingresa un numero para saber si es primo:");
        int num = Integer.parseInt(numIng);

        if (num <= 1) {
            numIng = JOptionPane.showInputDialog(null, "¡INGRESA UN NUMERO SUPERIOR A 1!");
            num = Integer.parseInt(numIng);
        } else if (true == numPrimo(num)) {
            JOptionPane.showMessageDialog(null, "¡Exacto! El número " + num + " es mi primo ");
        } else {
            JOptionPane.showMessageDialog(null, "Que lástima, el número " + num + " no es mi primo ");
        }
    }

    public static boolean numPrimo(int num) {
        if (num <= 1) {
            return false;

        }
        for (int produc = (num - 1); produc >= 2; produc--) {
            if (num % produc == 0) {
                return false;
            }
        }
        return true;
    }
}