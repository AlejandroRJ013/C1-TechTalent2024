import javax.swing.JOptionPane;

public class Ejercicio04 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Ingrese un numero para saber su factorial");
        int num = Integer.parseInt(numero);
        int resultado = factorial(num);

        JOptionPane.showMessageDialog(null, "El factorial de " + num + " es : " + resultado);
    }

    public static int factorial(int fac) {
        int resultado = 1;
        for (int operador = fac; operador >= 1; operador--) {
            resultado *= operador;
        }
        return resultado;
    }
}
