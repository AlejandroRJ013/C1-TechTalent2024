import javax.swing.JOptionPane;

public class Ejercicio03 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog(null, "Ingresa un numero para saber si es primo:");
        int num = Integer.parseInt(numero);

        if (true == esprimo(num)) {
            JOptionPane.showMessageDialog(null, "¡Exacto! El número " + num + " es primo ");
        } else {
            JOptionPane.showMessageDialog(null, "Que lástima, el número " + num + " no es primo ");
        }
    }

    public static boolean esprimo(int num) {
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