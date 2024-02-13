import javax.swing.JOptionPane;

public class Ejercicio05 {
    public static void main(String[] args) {
        String decima = JOptionPane.showInputDialog("Ingresa un numero para conocerlo en base binaria");
        int decimal = Integer.parseInt(decima);
        JOptionPane.showMessageDialog(null, restos);
    }

    public static int binario(int decimal) {
        int restos[] = new int[decimal];
        for (int i = (decimal - 1); decimal >= 2; i--) {
            restos[i] = decimal % 2;
            decimal /= 2;

        }
    }
}